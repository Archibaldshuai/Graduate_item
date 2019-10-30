package com.zpark.graduate.dao;

import com.zpark.graduate.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selByName(String name);
}
