package net.proselyte.subscription.dao;

import net.proselyte.subscription.model.Subscription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public class SubscrriptionDaoImpl implements SubscriptionDao {

    private static final Logger logger = LoggerFactory.getLogger(SubscrriptionDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSubscription(Subscription subscription) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(subscription);
        logger.info(("Subscription "+subscription+"successfully "));
    }

    @Override
    public void removeSubscription(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Subscription subscription = (Subscription) session.load(Book.class, id);

        if(subscription!=null){
            session.delete(subscription);
        }
        logger.info(("Subscription "+subscription+"removed "));
    }

    @Override
    public Subscription getSubscriptionById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Subscription subscription = (Subscription) session.load(Subscription.class, id);

        logger.info(("Subscription "+subscription+"added "));
        return subscription;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Subscription> listSubscription() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Subscription> subscriptionList=session.createQuery("from Subscription").list();

        for(Subscription subscription: subscriptionList){
            logger.info("Subscrition list"+subscription);
        }

        return subscriptionList;
    }
}
