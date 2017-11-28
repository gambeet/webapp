package ua.yevhenii.dao;

import ua.yevhenii.model.User;

import javax.sql.DataSource;
import java.util.List;

public interface IUserDao {
    public void setDataSource(DataSource dataSource);

    public void createUser(String name, String password);

    public User getUserById(Integer id);

    public List listUsers();

    public void removeUser(Integer id);

    public void updateUser(Integer id, String login, String password);

}
