package net.proselyte.subscription.services;

import net.proselyte.subscription.dao.SubscriptionDao;
import net.proselyte.subscription.model.Subscription;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SubscriptionServicesImpl implements SubscriptionServices {
    private SubscriptionDao subscriptionDao;

    public void setSubscriptionDao(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    @Override
    @Transactional
    public void addSubscription(Subscription subscription) {
        this.subscriptionDao.addSubscription(subscription);
    }

    @Override
    @Transactional
    public void removeSubscription(int id) {
        this.subscriptionDao.removeSubscription(id);

    }

    @Override
    @Transactional
    public Subscription getSubscriptionById(int id) {
        return this.subscriptionDao.getSubscriptionById(id);
    }

    @Override
    @Transactional
    public List<Subscription> listSubscription() {
        return this.subscriptionDao.listSubscription();
    }
}
