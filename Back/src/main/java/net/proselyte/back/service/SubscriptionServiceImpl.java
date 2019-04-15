package net.proselyte.back.service;

import net.proselyte.back.model.Subscription;
import net.proselyte.back.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findOne(id);
    }

    @Override
    public void addSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public void removeSubscription(Long id) {
        subscriptionRepository.delete(id);
    }

    @Override
    public List<Subscription> listSubscription() {
        return subscriptionRepository.findAll();
    }
}
