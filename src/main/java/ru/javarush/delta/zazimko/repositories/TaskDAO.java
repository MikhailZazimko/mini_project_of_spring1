package ru.javarush.delta.zazimko.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.delta.zazimko.domain.Task;

import java.util.List;

@Repository
public class TaskDAO{
    private final SessionFactory sessionFactory;

    public TaskDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return sessionFactory.openSession();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Task t) {
        try (Session session = getCurrentSession()) {
            session.persist(t);
        }

    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Task getById(int id){
        Query<Task> query = getCurrentSession().createQuery("select t from Task t where t.id=:ID", Task.class);
        query.setParameter("ID",id);
            return query.uniqueResult();

    }
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public List<Task> getAll(int offset,int limit){
        Query<Task> query = getCurrentSession().createQuery("select t from Task t", Task.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public int getAllCount(){
        Query<Long> query = getCurrentSession().createQuery("select count(t) from Task t", Long.class);
        return Math.toIntExact(query.uniqueResult());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Task update(Task t){
        try(Session session = getCurrentSession()){
            session.merge(t);
        }
        return t;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(Task t){
        getCurrentSession().remove(t);
    }
}
