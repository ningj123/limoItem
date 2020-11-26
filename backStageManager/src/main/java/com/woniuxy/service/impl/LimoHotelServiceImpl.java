package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.woniuxy.doman.*;
import com.woniuxy.exception.BackExecption;
import com.woniuxy.mapper.*;
import com.woniuxy.param.AppParam;
import com.woniuxy.param.DetailParam;
import com.woniuxy.param.Per;
import com.woniuxy.param.SleepParam;
import com.woniuxy.service.LimoHotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@Service
public class LimoHotelServiceImpl extends ServiceImpl<LimoHotelMapper, LimoHotel> implements LimoHotelService {
    @Resource
    private LimoHotelMapper limoHotelMapper ;
    @Resource
    private LimoAppointMapper limoAppointMapper;
    @Resource
    private LimoAppointDetailMapper limoAppointDetailMapper;
    @Resource
    private LimoOrderMapper limoOrderMapper;
    @Resource
    private LimoOrderDetailMapper limoOrderDetailMapper;

    /**
     * @Author zhuyuli
     * @Description //查询预约信息
     * @Date 2020/11/25 14:51
     * @Param [detail]
     * @return java.util.List<?>
     **/
    @Override
    public List<?> queryHotel(DetailParam detail) throws Exception{
        QueryWrapper<LimoHotel> queryWrapper = new QueryWrapper<>();
        if(detail.getCid()!=null){
            queryWrapper.eq("c_id",detail.getCid());
        }
        if(!StringUtils.isBlank(detail.getName())){
            queryWrapper.like("re_name",detail.getName());
        }
        return limoHotelMapper.selectList(queryWrapper);
    }
    /**
     * @Author zhuyuli
     * @Description //办理入住
     * @Date 2020/11/25 15:03
     * @Param [sleepParam]
     * @return void
     **/
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void insertHotel(SleepParam sleepParam)throws Exception {
        //更新房车状态
        UpdateWrapper<LimoHotel> updateWrapper = new UpdateWrapper<LimoHotel>();
        updateWrapper.set("h_status",sleepParam.getApid());
        limoHotelMapper.update(null,updateWrapper);
        //更新住宿信息
        UpdateWrapper<LimoAppoint> update = new UpdateWrapper<LimoAppoint>();
        update.eq("ap_id",sleepParam.getApid());
        update.eq("ap_status",1);
        limoAppointMapper.update(null,update);
        //新增住宿信息
        LimoAppointDetail li=new LimoAppointDetail();
        List<Per> list = sleepParam.getList();
        for(Per p:list){
            LimoAppointDetail dto=new LimoAppointDetail();
            dto.setApId(sleepParam.getApid());
            dto.setCard(p.getCard());
            dto.setName(p.getName());
            dto.setSex(p.getSex());
            limoAppointDetailMapper.insert(dto);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void insertHoteldetail(AppParam param) throws Exception{
        System.out.println(param);
        //判断入住的时间是否在存在
        QueryWrapper<LimoAppoint> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(!org.apache.commons.lang3.StringUtils.isEmpty(param.getStarttime()),"or_start_time",param.getStarttime())
                .le(!org.apache.commons.lang3.StringUtils.isEmpty(param.getEndtime()),"or_end_time",param.getEndtime())
                .lt("ap_status",3);
        LimoAppoint limoAppoint = limoAppointMapper.selectOne(queryWrapper);
        if(limoAppoint!=null){
            throw new BackExecption("时间冲突");
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime stattparse = LocalDateTime.parse(param.getStarttime(),df);
        LocalDateTime endtime = LocalDateTime.parse(param.getEndtime(),df);
        //不存在，新增住宿信息
        LimoAppoint limo=new LimoAppoint();
        limo.setCId(param.getCid());
        limo.setApStatus(1);
        limo.setHId(param.getHid());
        limo.setReName(param.getName());
        limo.setReNum(param.getNum());
        limo.setUId(0);
        limo.setRePhone(param.getPhone());
        limo.setOrStartTime(stattparse);
        limo.setOrEndTime(endtime);
        limoAppointMapper.insert(limo);
        //更新房车状态
        UpdateWrapper<LimoHotel> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("h_status",limo.getApId());
        updateWrapper.eq("h_id",param.getHid());
        limoHotelMapper.update(null,updateWrapper);
        //生成订单
        LimoOrder order=new LimoOrder();
        order.setOStatus(3);
        order.setCId(param.getCid());
        order.setUId(0);
        //计算时间天数
        Date a1 = new SimpleDateFormat("yyyy-MM-dd").parse(param.getStarttime());
        Date b1 = new SimpleDateFormat("yyyy-MM-dd").parse(param.getEndtime());
        long day = (a1.getTime()-b1.getTime())/(24*60*60*1000);
        order.setOTotal((-day)*param.getPrice());
        limoOrderMapper.insert(order);
        LimoOrderDetail orderDetail=new LimoOrderDetail();
        orderDetail.setHId(param.getHid());

        orderDetail.setOrStartTime(param.getStarttime());
        orderDetail.setOrEndTime(param.getEndtime());
        orderDetail.setOId(order.getOId());
        orderDetail.setOrType(2);
        limoOrderDetailMapper.insert(orderDetail);
    }
    //查询使用情况
    @Override
    public List queryWork(Integer hid, Integer status) {
        QueryWrapper<LimoAppoint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ap_id",status);

        return limoAppointMapper.selectList(queryWrapper);
    }
    /**
     * @Author zhuyuli
     * @Description //申请退房
     * @Date 2020/11/26 10:35
     * @Param [apid, hid]
     * @return void
     **/
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void outHotel(Integer apid, Integer hid) throws Exception{
        //更新住宿表的状态
        UpdateWrapper<LimoAppoint> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("ap_status",2);
        updateWrapper.eq("ap_id",apid);
        limoAppointMapper.update(null,updateWrapper);
        //更新房车的状态
        UpdateWrapper<LimoHotel> update = new UpdateWrapper<>();
        update.set("h_status",0);
        update.eq("h_id",hid);
        limoHotelMapper.update(null,update);
    }
}
