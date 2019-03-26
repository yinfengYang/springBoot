package com.yyf.firstSpringBootdemo.repository;

import com.yyf.firstSpringBootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */

@Repository
public class UserRepository {

    /**
     * 高并发内存存储方式
     */

    private final ConcurrentHashMap<Integer, User> userConcurrentHashMap
            = new ConcurrentHashMap<>();

    /**
     * 自动增长ID发生器
     */

    private final AtomicInteger idGenerator =
            new AtomicInteger();

    public boolean save(User user) {
        /**
         * id从1开始自增
         */
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return userConcurrentHashMap.put(id, user) == null;
    }

    /**
     * 返回所有用户列表
     * @return
     */
    public Collection<User> findAll(){

        return userConcurrentHashMap.values();
    }


}
