package com.woniuxy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.domain.LimoActivity;
import com.woniuxy.domain.LimoCamp;
import com.woniuxy.domain.LimoJoin;
import com.woniuxy.domain.LimoProduct;
import com.woniuxy.dto.*;
import com.woniuxy.mapper.LimoActivityMapper;
import com.woniuxy.mapper.LimoCampMapper;
import com.woniuxy.mapper.LimoJoinMapper;
import com.woniuxy.mapper.LimoProductMapper;
import com.woniuxy.param.CampParam;
import com.woniuxy.param.LimoActivityParam;
import com.woniuxy.param.LimoJoinParam;
import com.woniuxy.param.LimoParam;
import com.woniuxy.service.LimoCampService;
import com.woniuxy.param.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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
 * @author shadow
 * @since 2020-11-12
 */
@Service
public class LimoCampServiceImpl extends ServiceImpl<LimoCampMapper, LimoCamp> implements LimoCampService {
    @Resource
    private LimoCampMapper limoCampMapper;

    /**
     * 分页条件查询营地
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public Page<CampDto> selectCamp(Integer pageNum,Integer pageSize) throws Exception {
        Page<LimoCamp> page = new Page<>(pageNum,pageSize);
//        QueryWrapper<LimoCamp> queryWrapper = new QueryWrapper<>();
//        if (campParam.getcStatus()!=null){
//            queryWrapper.eq("c_status",campParam.getcStatus());
//        }
//        if (!StringUtils.isEmpty(campParam.getcName())){
//            queryWrapper.eq("c_name",campParam.getcName());
//        }
        limoCampMapper.selectPage(page,null);
        Page<CampDto> dtoPage = new Page<>();
        BeanUtils.copyProperties(page,dtoPage);
        return dtoPage;
    }

    /**
     * 下架营地
     * @param cId
     * @param cStatus
     * @throws Exception
     */
    @Override
    public void stopCamp(Integer cId, Integer cStatus) throws Exception {
        LimoCamp limoCamp = new LimoCamp();
        limoCamp.setcId(cId);
        limoCamp.setcStatus(cStatus);
        //修改营地状态
        limoCampMapper.updateById(limoCamp);
    }
    /**
     * 新增营地信息
     * @param campParam
     * @throws Exception
     */
    @Override
    public void insertCamp(CampParam campParam) throws Exception {
        LimoCamp limoCamp = new LimoCamp();
        BeanUtils.copyProperties(campParam, limoCamp);
        limoCampMapper.insert(limoCamp);
    }
    @Resource
    private LimoProductMapper limoProductMapper;
    @Resource
    private LimoJoinMapper limoJoinMapper;
    @Resource
    private LimoActivityMapper limoActivityMapper;
    @Override
    public PageInfo<CampDto> selectCamps(Integer mId,PageVO pageVO) throws Exception {
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        QueryWrapper<LimoCamp> wrapper = new QueryWrapper<>();
        wrapper.eq("m_id",mId);
        List<LimoCamp> limoCamps = limoCampMapper.selectList(wrapper);
        PageInfo<LimoCamp> pageInfo = new PageInfo<>(limoCamps);
        PageInfo<CampDto> page = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo,page);
        return page;
    }

    @Override
    public CampDto selectCampByCid(Integer cId) throws Exception {
        LimoCamp limoCamp = limoCampMapper.selectById(cId);
        CampDto campDto = new CampDto();
        BeanUtils.copyProperties(limoCamp,campDto);
        return campDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateCamp(CampParam campParam) throws Exception {
        LimoCamp limoCamp = new LimoCamp();
        BeanUtils.copyProperties(campParam,limoCamp);
        limoCampMapper.updateById(limoCamp);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteCampByCid(Integer cId) throws Exception {
        UpdateWrapper<LimoCamp> wrapper = new UpdateWrapper<>();
        wrapper.eq("c_id",cId).set("c_status",1);
        LimoCamp limoCamp = new LimoCamp();
        limoCamp.setcId(cId);
        limoCampMapper.update(limoCamp,wrapper);
        UpdateWrapper<LimoProduct> wrapper1 = new UpdateWrapper<>();
        wrapper1.eq("c_id",cId).set("p_status",1);
        limoProductMapper.update(null,wrapper1);
        UpdateWrapper<LimoActivity> wrapper2 = new UpdateWrapper<>();
        wrapper2.eq("c_id",cId).set("a_status",1);
        limoActivityMapper.update(null,wrapper2);
    }

    @Override
    public PageInfo<LimosDto> selectLimos(Integer pType, Integer mId, PageVO pageVO) throws Exception {
        QueryWrapper<LimoCamp> wrapper = new QueryWrapper<>();
        wrapper.eq("m_id",mId).eq("c_status",0);
        List<LimoCamp> limoCamps = limoCampMapper.selectList(wrapper);
        List<LimosDto> limos = new ArrayList<>();
        LimosDto limosDto = null;
        LimoDto limoDto=null;
        for (LimoCamp limoCamp:limoCamps) {
            limosDto = new LimosDto();
            BeanUtils.copyProperties(limoCamp,limosDto);
            QueryWrapper<LimoProduct> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("c_id",limoCamp.getcId());
            if(pType!=null){
                wrapper1.eq("p_type",pType);
            }else{
                wrapper1.and(wrapper2 ->wrapper2.eq("p_type",2).or().eq("p_type",3));
            }
            List<LimoProduct> limoProducts = limoProductMapper.selectList(wrapper1);
            List<LimoDto> limoDtos = new ArrayList<>();
            for (LimoProduct limoProduct:limoProducts) {
                limoDto=new LimoDto();
                BeanUtils.copyProperties(limoProduct,limoDto);
                limoDtos.add(limoDto);
            }
            limosDto.setList(limoDtos);
            limos.add(limosDto);
        }
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        PageInfo<LimosDto> limosDtoPageInfo = new PageInfo<>(limos);
        return limosDtoPageInfo;
    }

    @Override
    public LimoDto selectLimoById(Integer pId) throws Exception {
        LimoProduct limoProduct = limoProductMapper.selectById(pId);
        LimoDto limoDto = new LimoDto();
        BeanUtils.copyProperties(limoProduct,limoDto);
        return limoDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteLimoById(Integer pId) throws Exception {
        UpdateWrapper<LimoProduct> wrapper = new UpdateWrapper<>();
        wrapper.eq("p_id",pId).set("p_status",1);
        limoProductMapper.update(null,wrapper);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateLimo(LimoParam limoParam) throws Exception {
        LimoProduct limoProduct = new LimoProduct();
        BeanUtils.copyProperties(limoParam,limoProduct);
        limoProductMapper.updateById(limoProduct);
    }

    @Override
    public PageInfo<LimosDto> selectProducts(Integer pType,Integer mId, PageVO pageVO) throws Exception {
        QueryWrapper<LimoCamp> wrapper = new QueryWrapper<>();
        wrapper.eq("m_id",mId).eq("c_status",0);
        List<LimoCamp> limoCamps = limoCampMapper.selectList(wrapper);
        List<LimosDto> limos = new ArrayList<>();
        LimosDto limosDto = null;
        LimoDto limoDto=null;
        for (LimoCamp limoCamp:limoCamps) {
            limosDto = new LimosDto();
            BeanUtils.copyProperties(limoCamp,limosDto);
            QueryWrapper<LimoProduct> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("c_id",limoCamp.getcId());
            if(pType!=null){
                wrapper1.eq("p_type",pType);
            }else{
                wrapper1.and(wrapper2 ->wrapper2.eq("p_type",0).or().eq("p_type",1));
            }
            List<LimoProduct> limoProducts = limoProductMapper.selectList(wrapper1);
            List<LimoDto> limoDtos = new ArrayList<>();
            for (LimoProduct limoProduct:limoProducts) {
                limoDto=new LimoDto();
                BeanUtils.copyProperties(limoProduct,limoDto);
                limoDtos.add(limoDto);
            }
            limosDto.setList(limoDtos);
            limos.add(limosDto);
        }
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        PageInfo<LimosDto> limosDtoPageInfo = new PageInfo<>(limos);
        return limosDtoPageInfo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void insertProduct(LimoParam limoParam) throws Exception {
        LimoProduct limoProduct = new LimoProduct();
        BeanUtils.copyProperties(limoParam,limoProduct);
        limoProductMapper.insert(limoProduct);
    }

    @Override
    public PageInfo<LimoJoinsDto> selectLimoJoin(Integer mId,PageVO pageVO) throws Exception {
        QueryWrapper<LimoCamp> wrapper = new QueryWrapper<>();
        wrapper.eq("m_id",mId).eq("c_status",0);
        List<LimoCamp> limoCamps = limoCampMapper.selectList(wrapper);
        List<LimoJoinsDto> limos = new ArrayList<LimoJoinsDto>();
        LimoJoinsDto limoJoinsDto = null;
        LimoJoinDto limoJoinDto=null;
        for (LimoCamp limoCamp:limoCamps) {
            limoJoinsDto = new LimoJoinsDto();
            BeanUtils.copyProperties(limoCamp,limoJoinsDto);
            QueryWrapper<LimoJoin> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("c_id",limoCamp.getcId()).eq("j_type",1).eq("j_status",0);
            List<LimoJoin> limoProducts = limoJoinMapper.selectList(wrapper1);
            List<LimoJoinDto> limoDtos = new ArrayList<>();
            for (LimoJoin limoJoin:limoProducts) {
                limoJoinDto=new LimoJoinDto();
                BeanUtils.copyProperties(limoJoin,limoJoinDto);
                limoDtos.add(limoJoinDto);
            }
            limoJoinsDto.setList(limoDtos);
            limos.add(limoJoinsDto);
        }
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        PageInfo<LimoJoinsDto> limosDtoPageInfo = new PageInfo<>(limos);
        return limosDtoPageInfo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateJoin(LimoJoinParam limoJoinParam) throws Exception {
        UpdateWrapper<LimoJoin> wrapper = new UpdateWrapper<>();
        wrapper.eq("j_id",limoJoinParam.getjId()).set("j_status",limoJoinParam.getjStatus());
        limoJoinMapper.update(null,wrapper);
        if(limoJoinParam.getjStatus()==1){
            LimoProduct limoProduct = new LimoProduct();
            limoProduct.setcCity(limoJoinParam.getCity());
            limoProduct.setcId(limoJoinParam.getcId());
            limoProduct.setpName(limoJoinParam.getjSerail());
            limoProduct.setpImages(limoJoinParam.getjLimoImages());
            limoProduct.setpType(2);
            limoProductMapper.insert(limoProduct);
        }
    }

    @Override
    public PageInfo<LimoActivitiesDto> selectActivity(Integer aType,Integer mId, PageVO pageVO) throws Exception {
        QueryWrapper<LimoCamp> wrapper = new QueryWrapper<>();
        wrapper.eq("m_id",mId).eq("c_status",0);
        List<LimoCamp> limoCamps = limoCampMapper.selectList(wrapper);
        List<LimoActivitiesDto> limos = new ArrayList<LimoActivitiesDto>();
        LimoActivitiesDto limoActivitiesDto = null;
        LimoActivityDto limoActivityDto=null;
        for (LimoCamp limoCamp:limoCamps) {
            limoActivitiesDto = new LimoActivitiesDto();
            BeanUtils.copyProperties(limoCamp,limoActivitiesDto);
            QueryWrapper<LimoActivity> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("c_id",limoCamp.getcId());
            List<LimoActivity> limoProducts = limoActivityMapper.selectList(wrapper1);
            List<LimoActivityDto> limoDtos = new ArrayList<>();
            for (LimoActivity limoActivity:limoProducts) {
                limoActivityDto=new LimoActivityDto();
                BeanUtils.copyProperties(limoActivity,limoActivityDto);
                limoDtos.add(limoActivityDto);
            }
            limoActivitiesDto.setList(limoDtos);
            limos.add(limoActivitiesDto);
        }
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        PageInfo<LimoActivitiesDto> limosDtoPageInfo = new PageInfo<>(limos);
        return limosDtoPageInfo;
    }

    @Override
    public LimoActivityDto selectActivityById(Integer aId) throws Exception {
        LimoActivity limoActivity = limoActivityMapper.selectById(aId);
        LimoActivityDto limoActivityDto = new LimoActivityDto();
        BeanUtils.copyProperties(limoActivity,limoActivityDto);
        return limoActivityDto;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void insertActivity(LimoActivityParam limoActivityParam) throws Exception {
        LimoActivity limoActivity = new LimoActivity();
        BeanUtils.copyProperties(limoActivityParam,limoActivity);
        limoActivityMapper.insert(limoActivity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void deleteActivity(Integer aId) throws Exception {
        UpdateWrapper<LimoActivity> wrapper = new UpdateWrapper<>();
        wrapper.eq("a_id",aId).set("a_status",1);
        limoActivityMapper.update(null,wrapper);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateActivity(LimoActivityParam limoActivityParam) throws Exception {
        LimoActivity limoActivity = new LimoActivity();
        BeanUtils.copyProperties(limoActivityParam,limoActivity);
        limoActivityMapper.updateById(limoActivity);
    }
}
