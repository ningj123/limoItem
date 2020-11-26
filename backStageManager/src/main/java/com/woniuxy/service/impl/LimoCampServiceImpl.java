package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.woniuxy.doman.*;
import com.woniuxy.dto.CampDatilDto;
import com.woniuxy.dto.LimoAppointDto;
import com.woniuxy.dto.LimoCampDto;
import com.woniuxy.mapper.*;
import com.woniuxy.param.PageParam;
import com.woniuxy.param.Per;
import com.woniuxy.param.PersonParam;
import com.woniuxy.service.LimoCampService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-24
 */
@Service
public class LimoCampServiceImpl extends ServiceImpl<LimoCampMapper, LimoCamp> implements LimoCampService { @Resource
    @Autowired
    private LimoCampMapper limoCampMapper;
    @Resource
    private LimoManageMapper limoManageMapper;
    @Resource
    private LimoHotelMapper limoHotelMapper;
    @Resource
    private LimoAppointMapper limoAppointMapper;
    @Resource
    private LimoAppointDetailMapper limoAppointDetailMapper;


    /**
     * @Author zhuyuli
     * @Description //根据营地管理员下的营地
     * @Date 2020/11/24 18:50
     * @Param [id]
     * @return java.util.List
     **/
    @Override
    public List<LimoCampDto> selectByCamp(LimoManage limoManage) {
        QueryWrapper<LimoCamp> queryWrapper = new QueryWrapper<>();
        if(limoManage.getRId()!=1){
            queryWrapper.eq("m_id",limoManage.getMId());
        }
        queryWrapper.eq("c_status",0);
        List<LimoCamp> camps = limoCampMapper.selectList(queryWrapper);
        ArrayList<LimoCampDto> list = new ArrayList<>();
        for(LimoCamp c:camps){
            LimoCampDto dto=new LimoCampDto();
            BeanUtils.copyProperties(c,dto);
            list.add(dto);
        }
        camps=null;
        return list;
    }
    /**
     * @Author zhuyuli
     * @Description //根据营地管理员查询营地的房车
     * @Date 2020/11/24 19:42
     * @Param [limoManage]
     * @return java.lang.Object
     **/
    @Override
    public List selectByCampCar(LimoManage limoManage, Integer cid) {


        ArrayList<CampDatilDto>  list1=new ArrayList<CampDatilDto>();
        //先判断是不是系统管理员,不是管理员就查询营地管理员下的房车
        if(cid!=null){
            QueryWrapper<LimoHotel> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("c_id",cid);
            queryWrapper.lt("h_type",3);
            List<LimoHotel> hotels = limoHotelMapper.selectList(queryWrapper);
            LimoCamp limoCamp = limoCampMapper.selectById(cid);
            for(LimoHotel l:hotels){
                CampDatilDto dyo=new CampDatilDto();
                BeanUtils.copyProperties(l,dyo);
                dyo.setCname(limoCamp.getCName());
                list1.add(dyo);
            }
        }else if(limoManage.getRId()!=1){
            List<LimoCampDto> list = selectByCamp(limoManage);
            for(int i=0;i<list.size();i++) {
                QueryWrapper<LimoHotel> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("c_id", list.get(i).getCId());
                queryWrapper.lt("h_type", 3);
                List<LimoHotel> hotels = limoHotelMapper.selectList(queryWrapper);

                for (LimoHotel l : hotels) {
                    CampDatilDto dyo = new CampDatilDto();
                    BeanUtils.copyProperties(l, dyo);
                    dyo.setCname(list.get(i).getCName());
                    list1.add(dyo);
                }
            }
        }else{
            List<LimoHotel> hotels = limoHotelMapper.selectList(null);
        }
        return list1;
 }
    /**
     * @Author zhuyuli
     * @Description //查询房车使用情况
     * @Date 2020/11/24 20:16
     * @Param [cid]
     * @return java.lang.Object
     **/
    @Override
    public List selectByStatus(Integer cid){
            QueryWrapper<LimoAppoint> queryWrapper = new QueryWrapper<>();
            if (cid != null) {
                queryWrapper.eq("c_id", cid);
            }
            queryWrapper.lt("ap_status", 3);
            List<LimoAppoint> limoAppoints = limoAppointMapper.selectList(queryWrapper);
            ArrayList<LimoAppointDto> limoAppointDtos = new ArrayList<>();
            for (LimoAppoint c : limoAppoints) {
                LimoAppointDto dto = new LimoAppointDto();
                BeanUtils.copyProperties(c, dto);
                limoAppointDtos.add(dto);
            }
            limoAppoints = null;
            return limoAppointDtos;

    }
    /**
     * @Author zhuyuli
     * @Description //新增住房人员信息
     * @Date 2020/11/24 20:40
     * @Param [per]
     * @return void
     **/
        @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
        @Override
        public void insertAppDetail(PersonParam per) {
            LimoAppointDetail li=new LimoAppointDetail();
            List<Per> list = per.getList();
            for(Per p:list){
                LimoAppointDetail dto=new LimoAppointDetail();
                dto.setApId(per.getId());
                dto.setCard(p.getCard());
                dto.setName(p.getName());
                dto.setSex(p.getSex());
                limoAppointDetailMapper.insert(dto);
            }
        }

        @Override
        public List<?> selectByHtol(Integer id) {
            QueryWrapper<LimoAppointDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ap_id",id);
            return limoAppointDetailMapper.selectList(queryWrapper);
        }
    /**
     * @Author zhuyuli
     * @Description //根据房车查询住宿情况
     * @Date 2020/11/25 12:05
     * @Param [id]
     * @return java.util.List<?>
     **/
    @Override
    public List<?> selectByHtolList(Integer id) {
        QueryWrapper<LimoAppoint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("h_id",id);
        queryWrapper.lt("ap_status",3);
         return limoAppointMapper.selectList(queryWrapper);
    }
}
