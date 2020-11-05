package com.org.user.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_USERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long userId;

    @Column(name = "f_name")
    protected String userName;

    @ManyToMany
    @JoinTable(
            name = "t_users_roles",
            joinColumns = @JoinColumn(name = "f_user_id"),
            inverseJoinColumns = @JoinColumn(name = "f_role_id"))
    protected List<UserRole> userRoles;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
