package com.test;

import com.dao.UserDao;
import com.dao.UserDao02;
import com.entity.Order;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class SqlTest02 {
    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        UserDao02 userDao = session.getMapper(UserDao02.class);
        User user = new User();
        user.setId(1);
        user.setUserName("zhangsan");
        List<User> all = userDao.findAll(user);
        System.out.println(all);
    }
    @Test
    public void test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        UserDao02 userDao = session.getMapper(UserDao02.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        List<User> all = userDao.findAllByList(list);
        System.out.println(all);
    }

    /**
     * 分页查询
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        UserDao02 userDao = session.getMapper(UserDao02.class);

        PageHelper.startPage(3,2);
        List<User> userList = userDao.findPageAll();
        PageInfo<User> userPageInfo = new PageInfo<User>(userList);

        for (User user : userList){
            System.out.println(user);
        }
    }
    /**
     * 一对一
     * @throws IOException
     */
    @Test
    public void testone() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        UserDao02 userDao = session.getMapper(UserDao02.class);
        List<Order> orders = userDao.findOrder();
        for (Order order : orders){
            System.out.println(order);
        }
    }
    /**
     * 一对多
     * @throws IOException
     */
    @Test
    public void testmore() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        UserDao02 userDao = session.getMapper(UserDao02.class);
        List<User> userList = userDao.findOrderMore();
        for (User user : userList){
            System.out.println(user);
        }
        session.close();
        resourceAsStream.close();
    }
    /**
     * 多对多
     * @throws IOException
     */
    @Test
    public void testmoreAndmore() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        UserDao02 userDao = session.getMapper(UserDao02.class);
        List<User> userList = userDao.findOrderMoreAndMore();
        for (User user : userList){
            System.out.println(user);
        }
        session.close();
        resourceAsStream.close();
    }
}
