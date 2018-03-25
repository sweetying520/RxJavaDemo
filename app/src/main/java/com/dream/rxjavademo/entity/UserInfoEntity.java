package com.dream.rxjavademo.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/7.
 */

public class UserInfoEntity implements Serializable{


    /**
     * entity_id : 10
     * name : eee ddd
     * email : 1770385837@qq.com
     * avatar : null
     * tel : null
     * session : 8ba95c66531653c6032965eb3c69f389
     */

    private String entity_id;
    private String name;
    private String email;
    private Object avatar;
    private Object tel;
    private String session;

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public Object getTel() {
        return tel;
    }

    public void setTel(Object tel) {
        this.tel = tel;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
