//package com.woniuxy.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.woniuxy.doman.LimoAppoint;
//import com.woniuxy.exception.BackExecption;
//import com.woniuxy.mapper.LimoAppointMapper;
//import com.woniuxy.service.LimoAppointService;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
///**
// * <p>
// *  服务实现类
// * </p>
// *
// * @author zhuyuli
// * @since 2020-11-24
// */
//@Service
//public class LimoAppointServiceImpl extends ServiceImpl<LimoAppointMapper, LimoAppoint> implements LimoAppointService {
//    @Resource
//    private LimoAppointMapper limoAppointMapper;
//    @Override
//    public List qurty(String startTime, String endtime) throws  Exception {
//        QueryWrapper<LimoAppoint> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("h_id",8);
//        queryWrapper.eq("ap_status",1);
//        List<LimoAppoint> list = limoAppointMapper.selectList(queryWrapper);
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime stattparse = LocalDateTime.parse(startTime,df);
//        LocalDateTime endTime = LocalDateTime.parse(endtime,df);
//        for(LimoAppoint i:list){
//
//            if(!(stattparse.isBefore(i.getOrStartTime()) && endTime.isBefore(i.getOrStartTime()))){
//                throw new BackExecption("时间冲突");
//            }
//            if(stattparse.isAfter(i.getOrStartTime()) &&stattparse.isBefore(i.getOrEndTime()) ){
//                throw new BackExecption("时间冲突");
//            }
//        }
//        return null;
//    }
//}
