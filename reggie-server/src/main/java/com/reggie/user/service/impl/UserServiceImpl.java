package com.reggie.user.service.impl;

import com.reggie.user.dao.UserDao;
import com.reggie.user.domain.entity.User;
import com.reggie.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.lambdaQuery().eq(User::getId, id).one();
    }
}
