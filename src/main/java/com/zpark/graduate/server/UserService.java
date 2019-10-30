package com.zpark.graduate.server;


import com.zpark.graduate.dao.UserMapper;
import com.zpark.graduate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selByName(String name) {
        return userMapper.selByName(name);
    }
}
