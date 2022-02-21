package com.example.models;

import javax.persistence.*;
import java.util.Set;

@Entity// создание табл
@Table(name="users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;//обязательное поле при создании регистрации с помощью spring
    private boolean enabled;//обязательное поле при создании регистрации с помощью spring

    private String username, password;//обязательное поле при создании регистрации с помощью spring
private String  email;
    @ElementCollection(targetClass = Role.class, fetch=FetchType.LAZY)//создаем коллекцию на основе всех элементов из таблицы Role
    @CollectionTable(name= "user_role", joinColumns = @JoinColumn(name="user_id"))//соединение с таблицей role по столбу user_id и id
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;//обязательное поле при создании регистрации с помощью spring



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
