package com.test;

import com.dao.UserDao;
import com.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SqlTest {

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setId(4);
        user.setUserName("华仔hua");
        user.setPassWord("chsfj434ksk");
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        //dao.save(user);
        //dao.update(user);
        List<User> users = dao.findAll();
        System.out.println(users);
        session.commit();
        session.close();
        resourceAsStream.close();
    }
    @Test
    public void test2() throws Exception {
        User user = new User();
        user.setId(4);
        user.setUserName("华仔");
        user.setPassWord("chsodmjfjksk");
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        dao.save(user);
        session.commit();
        session.close();
        resourceAsStream.close();
    }
    @Test
    public void test3() throws Exception {
        User user = new User();
        user.setId(4);
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession();
        UserDao dao = session.getMapper(UserDao.class);
        dao.delete(user);
        session.commit();
        session.close();
        resourceAsStream.close();
    }
}
