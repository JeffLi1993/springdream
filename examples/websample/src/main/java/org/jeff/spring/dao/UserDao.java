package org.jeff.spring.dao;

import org.jeff.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by BYSocket on 2015/11/24.
 */
@Repository // DAO bean defined by spring
public class UserDao {

    @Autowired // JdbcTemplate bean autowired by spring's injection factory
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName,String password) {
        String sqlStr = "SELECT count(*) FROM user "
                + " WHERE user_name=? AND password=? ";
        return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,password});
    }

    public User findUserByUserName(String userName){
        String sqlStr = "SELECT id,user_name,email,phone "
                + " FROM user WHERE user_name=? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr,
                new Object[]{userName},
                new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
            }
        });
        return user;
    }
}
