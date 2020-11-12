package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.doman.LimoCity;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.mapper.LimoCityMapper;
import com.woniuxy.mapper.LimoSortDetailMapper;
import com.woniuxy.param.PageParam;
import com.woniuxy.service.LimoCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-09
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
    public Page<LimoCity> selectCItyListByPage(PageParam param) {
        Page<LimoCity> page = new Page<LimoCity>(param.getPageNum(),param.getPageSize());
        limoCityMapper.selectPage(page,null);
        //根据城市查询有多少文章
        for(int i=0;i<page.getRecords().size();i++){
            QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("so_d_city",page.getRecords().get(i).getCity());
            Integer count = limoSortDetailMapper.selectCount(queryWrapper);
            page.getRecords().get(i).setTatol(count);
        }
        return page;
    }
    /**
     * @Author zhuyuli
     * @Description //根据城市查询列表
     * @Date 2020/11/10 11:58
     * @Param [param, city]
     * @return java.lang.Object
     **/
    @Override
    public Object selectByCityList(PageParam param, String city) {
        Page<LimoSortDetail> page = new Page<LimoSortDetail>(param.getPageNum(),param.getPageSize());
        QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("so_d_city",city);
        limoSortDetailMapper.selectPage(page, queryWrapper);
        return page;
    }
    /**
     * @Author zhuyuli
     * @Description //根据城市名字查询城市
     * @Date 2020/11/10 14:17
     * @Param [city]
     * @return java.lang.Object
     **/
    @Override
    public Object queryByCity(String city) {
        QueryWrapper<LimoCity> queryWrapper = new QueryWrapper<LimoCity>();
        queryWrapper.eq("city",city);
        QueryWrapper<LimoSortDetail> wrapper = new QueryWrapper<LimoSortDetail>();
        wrapper.eq("so_d_city",city);
        Integer count = limoSortDetailMapper.selectCount(wrapper);
        LimoCity limoCity = limoCityMapper.selectOne(queryWrapper);
        limoCity.setTatol(count);
        return limoCity;
    }
}
