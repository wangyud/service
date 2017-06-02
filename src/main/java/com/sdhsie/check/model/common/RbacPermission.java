package com.sdhsie.check.model.common;

import javax.persistence.Table;

/**
 * Created by winterwa on 2017/5/22.
 */
@Table(name = "rbac_permission")
public class RbacPermission {

    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "RbacPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", available='" + available + '\'' +
                '}';
    }

    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    private String description;

    private String available;
}
