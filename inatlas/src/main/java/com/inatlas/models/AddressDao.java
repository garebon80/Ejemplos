package com.inatlas.models;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AddressDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(Address address) {
    getSession().save(address);
    return;
  }
  
  public void delete(Address address) {
    getSession().delete(address);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Address> getAll() {
    return getSession().createQuery("from Address").list();
  }
  
  public Address getByName(String name) {
    return (Address) getSession().createQuery(
        "from Address where name = :name")
        .setParameter("name", name)
        .uniqueResult();
  }

  public Address getById(long id) {
    return (Address) getSession().load(Address.class, id);
  }

  public void update(Address address) {
    getSession().update(address);
    return;
  }

} 
