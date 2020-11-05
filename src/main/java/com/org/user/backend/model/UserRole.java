package com.org.user.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_ROLES")
public class UserRole {

    @Id
    @Column(name = "f_id")
    private long roleId;

    @Column(name = "f_name")
    private String roleName;

    /*@ManyToMany
    List<User> users;*/

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /*public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }*/
}
