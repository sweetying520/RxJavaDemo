package com.dream.rxjavademo.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/7.
 */

public class UserInfoEntity implements Serializable{

    /**
     * code : 0
     * msg : null
     * model : {"entity_id":"10","name":"eee ddd","email":"1770385837@qq.com","avatar":null,"tel":null,"session":"032f994fc2b36e5eaeeb4f4e70d17997"}
     */

    private int code;
    private String msg;
    private ModelBean model;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public static class ModelBean implements Serializable{
        /**
         * entity_id : 10
         * name : eee ddd
         * email : 1770385837@qq.com
         * avatar : null
         * tel : null
         * session : 032f994fc2b36e5eaeeb4f4e70d17997
         */

        private String entity_id;
        private String name;
        private String email;
        private String avatar;
        private String tel;
        private String session;
        public int count = 2;

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

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }
    }
}
