package com.woniuxy.service.impl;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniuxy.doman.LimoBanner;
import com.woniuxy.doman.LimoCity;
import com.woniuxy.doman.LimoSortDetail;
import com.woniuxy.mapper.LimoCityMapper;
import com.woniuxy.mapper.LimoSortDetailMapper;
import com.woniuxy.param.TypeParam;
import com.woniuxy.service.LimoSortDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.jdbc.SQL;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyuli
 * @since 2020-11-07
 */
@Service
public class LimoSortDetailServiceImpl extends ServiceImpl<LimoSortDetailMapper, LimoSortDetail> implements LimoSortDetailService {
    @Resource
    private LimoSortDetailMapper  limoSortDetailMapper;
    @Resource
    private LimoCityMapper limoCityMapper;
    /**
     * @Author zhuyuli
     * @Description //查询旅游攻略（4个指南）
     * @Date 2020/11/9 17:32
     * @Param []
     * @return java.lang.Object
     **/
    @Override
    public Object selectAll()throws Exception {
        //根据循环查询4和类别的文章
        String[] src={"hort","camp","food","scenic"};
        HashMap<String,Object> map=new HashMap();
        for(int i=0;i<3;i++){
            QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
            Page<LimoSortDetail> Page = new Page<LimoSortDetail>(1,2);
            queryWrapper.eq("so_d_type",i);
            limoSortDetailMapper.selectPage(Page,queryWrapper);
            map.put(src[i],Page.getRecords());
        }
        //查询城市的类别
        Page<LimoCity> Page = new Page<LimoCity>(1,2);
        limoCityMapper.selectPage(Page,null);
        //根据城市查询有多少文章
        for(int i=0;i<Page.getRecords().size();i++){
            QueryWrapper<LimoSortDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("so_d_city",Page.getRecords().get(i).getCity());
            Integer count = limoSortDetailMapper.selectCount(queryWrapper);
            Page.getRecords().get(i).setTatol(count);
        }
        map.put("city",Page.getRecords());
        return map;
    }
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
        if(param.getKeyWord()!=null && !param.getKeyWord().equals("")){

            queryWrapper.like("so_d_keyword",param.getKeyWord());
        }
        limoSortDetailMapper.selectPage(Page,queryWrapper);
        return Page;
    }
}
