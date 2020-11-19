package com.woniuxy.service.impl;

import com.woniuxy.domain.LimoCamp;
import com.woniuxy.domain.LimoCollect;
import com.woniuxy.domain.LimoCollectExample;
import com.woniuxy.exception.ErrorException;
import com.woniuxy.mapper.LimoCampMapper;
import com.woniuxy.mapper.LimoCollectMapper;
import com.woniuxy.service.CollectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CollectServiceImpl
 * @Author shadow
 * @Date 2020/11/9 14:56
 * @Description TODO
 **/
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private LimoCollectMapper limoCollectMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void insertCollect(Integer cId,Integer uId) throws Exception {
        LimoCollect collect=new LimoCollect();
        collect.setCId(cId);
        collect.setCoType(1);
        collect.setUId(uId);
        limoCollectMapper.insertSelective(collect);
    }

    @Override
    public LimoCollect selectCollect(Integer cId,Integer uId) throws Exception {
        LimoCollectExample example = new LimoCollectExample();
        example.createCriteria().andUIdEqualTo(uId);
        List<LimoCollect> limoCollects = limoCollectMapper.selectByExample(example);
        for (LimoCollect limoCollect :limoCollects) {
            if(limoCollect.getCId()==cId){
                return limoCollect;
            }
        }
        return null;
    }

    @Override
    public void deleteCollect(Integer coId) throws Exception {
        limoCollectMapper.deleteByPrimaryKey(coId);
    }
}
