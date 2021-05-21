package com.adrian.test;

/**
 * @author xialei
 * @version Id: User, v 0.1 2021/4/21 7:36 下午 xialei Exp $
 */
public class User {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
