package com.reggie.user.dao;

import com.reggie.user.domain.entity.User;
import com.reggie.user.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author paddy
 * @since 2024-08-03
 */
@Service
public class UserDao extends ServiceImpl<UserMapper, User> {

}
