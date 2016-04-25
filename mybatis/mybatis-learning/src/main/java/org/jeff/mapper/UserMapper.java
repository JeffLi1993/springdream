package org.jeff.mapper;

import org.jeff.domain.User;

/**
 * 描述:User Mapper映射类
 * Created by bysocket on 16/3/8.
 */
public interface UserMapper {
    User selectUser(int id);
}
