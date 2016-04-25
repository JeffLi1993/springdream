package org.spring.jeff.mapper;

import org.spring.jeff.domain.User;

/**
 * 描述:User Mapper映射类
 * Created by bysocket on 16/3/8.
 */
public interface UserMapper {
    User selectUser(int id);
}
