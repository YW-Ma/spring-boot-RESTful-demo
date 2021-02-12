package com.study.demo.handler.dao;

import com.study.demo.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
  @Autowired
  private SessionFactory sessionFactory;

  public void addUser(User user) {
    Session session = null;

    try {
      session = sessionFactory.openSession();
      session.beginTransaction();
      session.save(user); // may have more operations in this transaction in future
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      if (session != null) {
        session.close();
      }
    }
  }


  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    try (Session session = sessionFactory.openSession()) {
      // we don't need to rollback if fail, so we don't need to access session
      // outside of this {} pair. --> so we can use try () {} statement
      Criteria crit = session.createCriteria(User.class); // criteria是在搜索，返回Criteria变量，返回值做.list()获得一个List。
      users = crit.list();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return users;
  }

}
