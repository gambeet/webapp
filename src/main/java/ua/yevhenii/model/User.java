package ua.yevhenii.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "traineeDB", catalog = "")
public class User implements Serializable, Comparable<User>{

    private Integer id;
    private String login;
    private String password;


    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }


    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
            if(login.compareTo(o.getLogin()) > 0){
                return 1;
            }else if(login.compareTo(o.getLogin())< 0 ){
                return -1;
            }else {
                return 0;
            }
    }
}

