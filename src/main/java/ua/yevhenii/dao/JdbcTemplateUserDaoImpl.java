package ua.yevhenii.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ua.yevhenii.model.User;
import ua.yevhenii.model.util.UserMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

public class JdbcTemplateUserDaoImpl implements IUserDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createUser(String name, String password) {
        String SQL = "INSERT INTO user (name, password) VALUES (?,?)";

        jdbcTemplate.update(SQL, name, password);
        System.out.println("Developer successfully created.\nName: " + name + ";\nSpecilaty: " +
                password + ";\n");
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public List listUsers() {
        String SQL = "SELECT * FROM user";
        List users = jdbcTemplate.query(SQL, new UserMapper());
        return users;    }

    @Override
    public void removeUser(Integer id) {

    }

    @Override
    public void updateUser(Integer id, String login, String password) {

    }
}
