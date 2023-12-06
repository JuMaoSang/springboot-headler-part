package com.study.mapper;

import com.study.pojo.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Mr DaMing
* @description 针对表【news_type】的数据库操作Mapper
* @createDate 2023-12-04 23:00:17
* @Entity com.study.pojo.Type
*/
@Mapper
public interface TypeMapper extends BaseMapper<Type> {

}




