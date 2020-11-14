package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoCity;
import com.woniuxy.domain.LimoSortDetail;
import com.woniuxy.dto.LimoCityDto;
import com.woniuxy.mapper.LimoCityMapper;
import com.woniuxy.mapper.LimoSortDetailMapper;
import com.woniuxy.param.LimoCityParam;
import com.woniuxy.param.PageParam;
import com.woniuxy.service.LimoCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
@Service
public class LimoCityServiceImpl extends ServiceImpl<LimoCityMapper, LimoCity> implements LimoCityService {
    @Resource
    private LimoSortDetailMapper limoSortDetailMapper;
    @Resource
    private LimoCityMapper limoCityMapper;

    /**
     * @Author zhuyuli
     * @Description //查询城市列表
     * @Date 2020/11/10 11:15
     * @Param [param]
     * @return java.lang.Object
     **/
    @Override
    public Page selectCItyListByPage(PageParam param) throws Exception{
        Page<LimoCity> page = new Page<LimoCity>(param.getPageNum(),param.getPageSize());
        limoCityMapper.selectPage(page,null);
        //根据城市查询有多少文章
        for(int i=0;i<page.getRecords().size();i++){
            QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("so_d_city",page.getRecords().get(i).getCity());
            Integer count = limoSortDetailMapper.selectCount(queryWrapper);
            page.getRecords().get(i).setTatol(count);
        }
        //封装Dto
        Page<LimoCityDto> page2 = new Page<LimoCityDto>();
        BeanUtils.copyProperties(page,page2);
        page=null;
        return page2;
    }
    /**
     * @Author zhuyuli
     * @Description //根据城市查询列表
     * @Date 2020/11/10 11:58
     * @Param [param, city]
     * @return java.lang.Object
     **/
    @Override
    public Object selectByCityList(PageParam param, String city) throws Exception{
        Page<LimoSortDetail> page = new Page<LimoSortDetail>(param.getPageNum(),param.getPageSize());
        QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("so_d_city",city);
        limoSortDetailMapper.selectPage(page, queryWrapper);
        //封装Dto
        Page<LimoCityDto> page2 = new Page<LimoCityDto>();
        BeanUtils.copyProperties(page,page2);
        page=null;
        return page2;
    }
    /**
     * @Author zhuyuli
     * @Description //新增城市
     * @Date 2020/11/13 15:23
     * @Param [param]
     * @return void
     **/
    @Override
    public void insertCity(LimoCityParam param) {
        LimoCity city=new LimoCity();
        BeanUtils.copyProperties(param,city);
        limoCityMapper.insert(city);
    }
}
