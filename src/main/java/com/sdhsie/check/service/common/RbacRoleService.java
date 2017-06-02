package com.sdhsie.check.service.common;

import com.sdhsie.check.mapper.UserMapper;
import com.sdhsie.check.mapper.common.RbacRoleMapper;
import com.sdhsie.check.model.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by winterwa on 17-5-20.
 */
@Service
public class RbacRoleService {

    @Autowired
    RbacRoleMapper rbacRoleMapper;



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){
        rbacRoleMapper.deleteByPrimaryKey(id);
    }


    public User getUserById(int id){
        return rbacRoleMapper.selectByPrimaryKey(id);
    }



    public boolean isExist(User user){
        System.out.println(user.toString());
        return  rbacRoleMapper.selectCount(user)>0;
    }


    public void addUser(User user){
        rbacRoleMapper.insert(user);
    }


    public List<User> getUsers(User user){
        if (user == null) {
            return rbacRoleMapper.selectAll();
        }

        return rbacRoleMapper.select(user);
    }


    public void deleteById(int id){
        rbacRoleMapper.deleteByPrimaryKey(id);

    }

    public void update(User user){
        rbacRoleMapper.updateByPrimaryKey(user);
    }


}
