package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.domain.LimoCity;
import com.woniuxy.domain.LimoSortDetail;
import com.woniuxy.dto.LimoSortDetailDto;
import com.woniuxy.mapper.LimoCityMapper;
import com.woniuxy.mapper.LimoSortDetailMapper;
import com.woniuxy.param.LSDParam;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shadow
 * @since 2020-11-12
 */
@Service
public class LimoSortDetailServiceImpl extends ServiceImpl<LimoSortDetailMapper, LimoSortDetail> implements LimoSortDetailService {
    @Resource
    private LimoSortDetailMapper  limoSortDetailMapper;
    @Resource
    private LimoCityMapper limoCityMapper;

    /**
     * @Author zhuyuli
     * @Description 根据类型或关键字分页查询列表
     * @Date 2020/11/10 9:50
     * @Param [param]
     * @return java.lang.Object
     **/
    @Override
    public Object selectByType(TypeParam param) throws Exception{
        Page<LimoSortDetail> Page = new Page<LimoSortDetail>(param.getPageNum(),param.getPageSize());
        QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
        //如果type=-1,为空，参数为空
        if(param.getType()!=-1 && param.getType()!=null ){

            queryWrapper.eq("so_d_type",param.getType());
        }
        //判断关键字不为空
        if(param.getKeyWord()!=null && !param.getKeyWord().equals("")){

            queryWrapper.like("so_d_keyword",param.getKeyWord());
        }
        limoSortDetailMapper.selectPage(Page,queryWrapper);
        Page<LimoSortDetailDto> page2 = new Page<LimoSortDetailDto>();
        BeanUtils.copyProperties(Page,page2);
        Page=null;
        return page2;
    }
    /**
     * @Author zhuyuli
     * @Description //查询所有列表
     * @Date 2020/11/13 14:54
     * @Param []
     * @return java.util.List
     **/
    @Override
    public List queryAll() throws Exception{
        List<LimoSortDetail> limoSortDetails = limoSortDetailMapper.selectList(null);
        //封装dto
        List<LimoSortDetailDto> limoSortDetailDtos = new ArrayList<LimoSortDetailDto>();
        for(LimoSortDetail i:limoSortDetails){
            LimoSortDetailDto dto=new LimoSortDetailDto();
            BeanUtils.copyProperties(i,dto);
            limoSortDetailDtos.add(dto);
        }
        limoSortDetails=null;
        return limoSortDetailDtos;
    }
    /**
     * @Author zhuyuli
     * @Description 根据ID更新旅游文章
     * @Date 2020/11/13 15:03
     * @Param [param]
     * @return void
     **/
    @Override
    public void updateTravelSort(LSDParam param) throws Exception {
        LimoSortDetail limo = new LimoSortDetail();
        BeanUtils.copyProperties(param, limo);
        limoSortDetailMapper.updateById(limo);
    }
}
