package com.github.weibao.service;

import com.github.weibao.mapper.UserMapper;
import com.github.weibao.model.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class UserService  {

    @Autowired
    UserMapper userMapper;



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){
        userMapper.deleteByPrimaryKey(id);
    }


    public User getUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }



    public Integer isExist(User user){
        return  userMapper.selectCount(user);
    }


    public void addUser(User user){
        userMapper.insert(user);
    }


    public List<User> getUsers(User user){
        if (user == null) {
            return userMapper.selectAll();
        }

        return userMapper.select(user);
    }


    public void deleteById(int id){
        userMapper.deleteByPrimaryKey(id);

    }

    public void update(User user){
        userMapper.updateByPrimaryKey(user);
    }

    public boolean login(User user){
        // TODO: 16/1/18  
        return true;
    }
}
