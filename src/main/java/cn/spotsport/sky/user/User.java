package cn.spotsport.sky.user;

import org.apache.tomcat.util.security.MD5Encoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String phone;
    String password;

    public User(){}

    public User(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = passwordMd5(password);
    }
    //MD5加密
    private String passwordMd5(String pwd){
        return MD5Encoder.encode(pwd.getBytes());
    }

    public Long getId() {
        return id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean checkPassword(String pwd) {
        if(null==pwd){
            return false;
        }
        return this.password.equals(passwordMd5(pwd));
    }

    public void setPassword(String password) {
        this.password = passwordMd5(password);
    }
}
