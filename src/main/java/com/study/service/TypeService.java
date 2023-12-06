package com.study.service;

import com.study.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.utils.Result;

/**
* @author Mr DaMing
* @description 针对表【news_type】的数据库操作Service
* @createDate 2023-12-04 23:00:17
*/
public interface TypeService extends IService<Type> {
    /**
     * 查询所有类别数据
     * @return
     */
    Result findAllTypes();
}
