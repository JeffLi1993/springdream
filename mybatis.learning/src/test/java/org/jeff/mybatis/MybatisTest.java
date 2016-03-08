package org.jeff.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jeff.domain.User;
import org.jeff.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * 描述:
 * SQL 与 springdream -> examples -> websample中的SQL,一致不再重复加入
 * Created by bysocket on 16/3/8.
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        // 获取SqlSessionFactory
        String resource = "MyBatis-Configuration.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUser(1);
            System.out.println("\nprint user info --> " + user.toString());
        } finally {
            sqlSession.close();
        }
    }
}
