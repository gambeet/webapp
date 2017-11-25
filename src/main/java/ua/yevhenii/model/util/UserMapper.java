package ua.yevhenii.model.util;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import ua.yevhenii.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yevhenii on 23.11.2017.
 */
public class UserMapper implements RowMapper {

    @Nullable
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
