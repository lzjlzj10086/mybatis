package com.dao;

import com.entity.Order;
import com.entity.User;

import java.util.List;

public interface UserDao02 {
    List<User> findAll(User user);
    List<User> findAllByList(List<Integer> list);
    List<User> findPageAll();

    /**
     * 一对一
     * @return
     */
    List<Order> findOrder();

    /**
     * 一对多
     * @return
     */
    List<User> findOrderMore();
    /**
     * 多对多
     * @return
     */
    List<User> findOrderMoreAndMore();
}
