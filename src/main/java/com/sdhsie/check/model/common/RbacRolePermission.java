package com.sdhsie.check.model.common;

/**
 * Created by winterwa on 2017/5/22.
 */
public class RbacRolePermission {

    private Integer id;

    private Integer role_id;

    private Integer permission_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RbacRolePermission{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", permission_id=" + permission_id +
                '}';
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }
}
