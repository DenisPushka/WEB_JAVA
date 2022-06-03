package dao;

import dataAccess.DataAccess;
import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao {

    private DataAccess db;

    public UserDao(DataAccess db){
        this.db = db;
    }

    public User findById(int id) {
        try {
            return db.getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
        return new User();
    }

    public void save(User user) {
        findById(6);
        /*Session session = null;
        try {
             session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        }
        catch (Exception e){
            System.out.println(e);
        }
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(User user) {
       /* Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();*/
    }

    public void update(User user) {

    }

    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>) HibernateSessionFactoryUtil.
                getSessionFactory().
                openSession().
                createQuery("From User").
                list();
        return users;
    }
}
