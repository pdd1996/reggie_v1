package com.reggie.user.service;

import com.reggie.user.domain.entity.User;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author paddy
 * @since 2024-08-03
 */
public interface IUserService {

    User getUserById(Integer id);
}
