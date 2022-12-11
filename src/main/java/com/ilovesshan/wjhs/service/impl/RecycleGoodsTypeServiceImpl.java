package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsType;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.RecycleGoodsTypeMapper;
import com.ilovesshan.wjhs.service.RecycleGoodsTypeService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/11
 * @description:
 */

@Service
public class RecycleGoodsTypeServiceImpl implements RecycleGoodsTypeService {

    @Autowired
    private RecycleGoodsTypeMapper recycleGoodsTypeMapper;


    @Override
    public List<RecycleGoodsType> selectList() {
        return recycleGoodsTypeMapper.selectList();
    }

    @Override
    public RecycleGoodsType selectById(String id) {
        RecycleGoodsType findRecycleGoodsType = recycleGoodsTypeMapper.selectById(id);
        if(Objects.isNull(findRecycleGoodsType)){
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return findRecycleGoodsType;
    }

    @Override
    public boolean deleteById(String id) {
        selectById(id);
        return recycleGoodsTypeMapper.deleteById(id) > 0;
    }

    @Override
    public boolean insert(RecycleGoodsType recycleGoodsType) {
        recycleGoodsType.setId(UuidUtil.generator());
        RecycleGoodsType findRecycleGoodsType = recycleGoodsTypeMapper.selectByName(recycleGoodsType.getName());
        if(!Objects.isNull(findRecycleGoodsType)){
            throw new CustomException(R.ERROR_RESOURCES_EXISTS);
        }
        return recycleGoodsTypeMapper.insert(recycleGoodsType) > 0;
    }

    @Override
    public boolean update(RecycleGoodsType recycleGoodsType) {
        selectById(recycleGoodsType.getId());
        return recycleGoodsTypeMapper.update(recycleGoodsType) > 0;
    }
}
