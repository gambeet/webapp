package ua.yevhenii.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.yevhenii.model.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yevhenii on 25.11.2017.
 */

@Service("usersService")
@Transactional
public class UsersService {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("FROM  User").list();
        return  list;
    }

}
