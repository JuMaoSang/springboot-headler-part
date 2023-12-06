package com.study.service;

import com.study.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.utils.Result;

/**
* @author Mr DaMing
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-12-04 23:00:17
*/
public interface UserService extends IService<User> {
    /**
     * 登入方法
     * @param user
     * @return
     */
    Result login(User user);

    Result getUserInfo(String token);

    Result checkUserName(String usernmae);
}
