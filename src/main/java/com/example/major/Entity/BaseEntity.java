package com.example.springbootproject1.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 */

public class BaseEntity implements Serializable {

    private String createUser;
    private Date createTime;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        if (getCreateUser() != null ? !getCreateUser().equals(that.getCreateUser()) : that.getCreateUser() != null)
            return false;
        return getCreateTime() != null ? getCreateTime().equals(that.getCreateTime()) : that.getCreateTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getCreateUser() != null ? getCreateUser().hashCode() : 0;
        result = 31 * result + (getCreateTime() != null ? getCreateTime().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
