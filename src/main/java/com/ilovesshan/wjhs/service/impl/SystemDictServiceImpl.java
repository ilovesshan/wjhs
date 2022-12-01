package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.SystemDict;
import com.ilovesshan.wjhs.mapper.SystemDictMapper;
import com.ilovesshan.wjhs.service.SystemDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Service
public class SystemDictServiceImpl implements SystemDictService {

    @Autowired
    private SystemDictMapper systemDictMapper;

    @Override
    public List<SystemDict> selectAll() {
        return systemDictMapper.selectAll();
    }
}
