package com.woniuxy.service.impl;

import com.woniuxy.domain.LimoCamp;
import com.woniuxy.domain.LimoCollect;
import com.woniuxy.exception.ErrorException;
import com.woniuxy.mapper.LimoCampMapper;
import com.woniuxy.mapper.LimoCollectMapper;
import com.woniuxy.service.CollectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName CollectServiceImpl
 * @Author shadow
 * @Date 2020/11/9 14:56
 * @Description TODO
 **/
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private LimoCampMapper limoCampMapper;
    @Resource
    private LimoCollectMapper limoCollectMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void insertCollect(Integer cId,Integer uId) throws Exception {
        LimoCamp limoCamp = limoCampMapper.selectByPrimaryKey(cId);
        LimoCollect limoCollect = new LimoCollect();
        limoCollect.setCId(limoCamp.getcId());
        limoCollect.setCoType(1);
        limoCollect.setUId(uId);
        if(limoCamp!=null){
            limoCollectMapper.insertSelective(limoCollect);
        }else {
            throw new ErrorException("没有该营地");
        }
    }
}
