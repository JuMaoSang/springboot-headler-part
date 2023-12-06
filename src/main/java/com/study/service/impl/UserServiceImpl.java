package com.study.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.pojo.User;
import com.study.service.UserService;
import com.study.mapper.UserMapper;
import com.study.utils.JwtHelper;
import com.study.utils.MD5Util;
import com.study.utils.Result;
import com.study.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr DaMing
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2023-12-04 23:00:17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 登入业务
     * 1. 根据账号查询用户对象
     * 2. 账号为空，查询失败，账号错误，返回501
     * 3. 对比密码
     * 4. 失败，返回503，成功，根据用户id生成token。装配到result
     *
     * @param user
     * @return
     */
    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
        User loginUser = userMapper.selectOne(lambdaQueryWrapper);

        if (loginUser == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        //对比密码

        if (!StringUtils.isEmpty(user.getUserPwd()) && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())) {
        //登入成功
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));

            Map data = new HashMap();
            data.put("token", token);
            return Result.ok(data);
        }

        //密码错误
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    /**
     * 根据token获取用户数据
     * @param token
     * @return
     */
    @Override
    public Result getUserInfo(String token) {
        //判断token是否失效 true，过期
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration){
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }

        int intValue = jwtHelper.getUserId(token).intValue();
        User user = userMapper.selectById(intValue);
        user.setUserPwd("");
        HashMap map = new HashMap();
        map.put("loginUser",user);
        return Result.ok(map);
    }
    /**
     * 检查账号是否可用
     * @param usernmae
     * @return
     */
    @Override
    public Result checkUserName(String usernmae) {

        return null;
    }


}




