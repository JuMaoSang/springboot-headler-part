package com.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.pojo.Headline;
import com.study.service.HeadlineService;
import com.study.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author Mr DaMing
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-12-04 23:00:17
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




