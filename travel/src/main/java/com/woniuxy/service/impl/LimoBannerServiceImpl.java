package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.woniuxy.doman.LimoBanner;

import com.woniuxy.dto.LimoBannerDto;
import com.woniuxy.mapper.LimoBannerMapper;
import com.woniuxy.param.BanParam;
import com.woniuxy.service.LimoBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
 */
@Service
public class LimoBannerServiceImpl extends ServiceImpl<LimoBannerMapper, LimoBanner> implements LimoBannerService {
    @Resource
    private  LimoBannerMapper limoBannerMapper;


    /**
     * @Author zhuyuli
     * @Description 分页查询广告列表
     * @Date 2020/11/9 9:44
     * @Param 广告集合
     * @return Page
     **/
    @Transactional(readOnly = true)
    @Override
    public Object queryBannerList(Integer pageSize, Integer pageNum,Integer type) throws Exception{
        Page<LimoBanner> Page = new Page<LimoBanner>(pageNum,pageSize);
        if (type ==null ){

            limoBannerMapper.selectPage(Page,null);
        }else {
            QueryWrapper<LimoBanner> wrapper = new QueryWrapper<>();
            wrapper.eq("type",type);
            limoBannerMapper.selectPage(Page,wrapper);
        }
        Page<LimoBannerDto> page = new Page<LimoBannerDto>();

        System.out.println(1);
        BeanUtils.copyProperties(Page,page);
        Page=null;
        return page;
    }
    /**
     * @Author zhuyuli
     * @Description 根据类型查询广告
     * @Date 2020/11/9 9:44
     * @Param 广告集合
     * @return Page
     **/
    @Transactional(readOnly = true)
    @Override
    public List queryBannerByType(Integer type) throws Exception{
        QueryWrapper<LimoBanner> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        List<LimoBanner> list = limoBannerMapper.selectList(wrapper);

        return list;
    }

    /**
     * @Author zhuyuli
     * @Description //更新广告
     * @Date 2020/11/9 14:21
     * @Param 广告的参数
     **/
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void updateBannerById(BanParam param) throws  Exception{
        UpdateWrapper<LimoBanner> wrapper = new UpdateWrapper<>();
        LimoBanner banner = new LimoBanner();
        BeanUtils.copyProperties(param,banner);
        limoBannerMapper.updateById(banner);
    }
}
