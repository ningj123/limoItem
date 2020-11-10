package com.woniuxy.service.impl;

import com.woniuxy.domain.LimoJoin;
import com.woniuxy.exception.ErrorException;
import com.woniuxy.mapper.LimoJoinMapper;
import com.woniuxy.param.JoinParam;
import com.woniuxy.service.JoinService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName JoinServiceImpl
 * @Author shadow
 * @Date 2020/11/10 10:01
 * @Description TODO
 **/
@Service
public class JoinServiceImpl implements JoinService {
    @Resource
    private LimoJoinMapper limoJoinMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void insertLimoJoin(JoinParam joinParam) throws Exception {
        LimoJoin limoJoin = null;
        if(joinParam!=null){
            limoJoin = new LimoJoin();
            BeanUtils.copyProperties(joinParam,limoJoin);
            limoJoinMapper.insertSelective(limoJoin);
        }else{
            throw new ErrorException("数据不完整");
        }
    }
}
