package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.RecycleGoods;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsAndType;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.RecycleGoodsMapper;
import com.ilovesshan.wjhs.service.RecycleGoodsService;
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
public class RecycleGoodsServiceImpl implements RecycleGoodsService {

    @Autowired
    private RecycleGoodsMapper recycleGoodsMapper;


    @Override
    public List<RecycleGoods> selectList() {
        return recycleGoodsMapper.selectList();
    }

    @Override
    public RecycleGoods selectById(String id) {
        RecycleGoods findRecycleGoods = recycleGoodsMapper.selectById(id);
        if(Objects.isNull(findRecycleGoods)){
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return findRecycleGoods;
    }

    @Override
    public boolean deleteById(String id) {
        selectById(id);
        return recycleGoodsMapper.deleteById(id) > 0;
    }

    @Override
    public boolean insert(RecycleGoods recycleGoods) {
        recycleGoods.setId(UuidUtil.generator());
        RecycleGoods findRecycleGoods = recycleGoodsMapper.selectByName(recycleGoods.getName());
        if(!Objects.isNull(findRecycleGoods)){
            throw new CustomException(R.ERROR_RESOURCES_EXISTS);
        }
        return recycleGoodsMapper.insert(recycleGoods) > 0;
    }

    @Override
    public boolean update(RecycleGoods recycleGoods) {
        selectById(recycleGoods.getId());
        return recycleGoodsMapper.update(recycleGoods) > 0;
    }

    @Override
    public List<RecycleGoods> selectListByType(String type) {
        return recycleGoodsMapper.selectListByType(type);
    }

    @Override
    public List<RecycleGoodsAndType> selectAllListWithType() {
        return recycleGoodsMapper.selectAllListWithType();
    }
}
