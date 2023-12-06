package com.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.pojo.Type;
import com.study.service.TypeService;
import com.study.mapper.TypeMapper;
import com.study.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Mr DaMing
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2023-12-04 23:00:17
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

    @Autowired
    private TypeMapper typeMapper;
    
    @Override
    public Result findAllTypes() {

        List<Type> result = typeMapper.selectList(null);

        return Result.ok(result);
    }
}




