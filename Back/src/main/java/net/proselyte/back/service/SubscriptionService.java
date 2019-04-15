package net.proselyte.back.service;

import net.proselyte.back.model.Subscription;

import java.util.List;



public interface SubscriptionService {

    Subscription getSubscriptionById(Long id);

    void addSubscription(Subscription subscription);

    void removeSubscription(Long id);

    List<Subscription> listSubscription();
}
