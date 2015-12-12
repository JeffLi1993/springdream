package org.jeff.spring.service;

import org.jeff.spring.dao.UserDao;
import org.jeff.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BYSocket on 2015/11/25.
 */
@Service // 标注该类为一个服务层的Bean
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean hasMatchCount(String userName,String password){
        int matchCount = userDao.getMatchCount(userName,password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

}
