package net.proselyte.subscription.dao;

import net.proselyte.subscription.model.Subscription;

import java.util.List;

public interface SubscriptionDao{
    public void addSubscription(Subscription subscription);
    public void removeSubscription(int id);
    public Subscription getSubscriptionById(int id);
    public List<Subscription> listSubscription();
}
