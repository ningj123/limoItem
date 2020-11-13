package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.doman.LimoSecSpot;
import com.woniuxy.mapper.LimoSecSpotMapper;
import com.woniuxy.param.SortParam;
import com.woniuxy.param.SortTypeParam;
import com.woniuxy.service.LimoSecSpotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-10
 */
@Service
public class LimoSecSpotServiceImpl extends ServiceImpl<LimoSecSpotMapper, LimoSecSpot> implements LimoSecSpotService {

    @Resource
    private LimoSecSpotMapper limoSecSpotMapper;
    /**
     * @Author zhuyuli
     * @Description 条件查询周边景点
     * @Date 2020/11/11 10:53
     * @Param [param]
     * @return java.lang.Object
     **/
    @Override
    public Object queryByParam(SortTypeParam param) {
        Page<LimoSecSpot> page = new Page<LimoSecSpot>(param.getPageNum(), param.getPageSize());
        QueryWrapper<LimoSecSpot> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(param.getCity())){
            queryWrapper.eq("sec_sport_city",param.getCity());
        }
        if(param.getCId()!=-1 && param.getCId()!=null){
            queryWrapper.eq("c_id",param.getCId());
        }
        if(StringUtils.isNotBlank(param.getSecname())){
            queryWrapper.and(Wrapper->Wrapper.like("c_name",param.getSecname()).or().like("sec_sport_name",param.getSecname()));
        }

        limoSecSpotMapper.selectPage(page,queryWrapper);
        return page;
    }
}
