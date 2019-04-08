package net.proselyte.subscription.services;

import net.proselyte.subscription.model.Subscription;

import java.util.List;

public interface SubscriptionServices {
    public void addSubscription(Subscription subscription);
    public void removeSubscription(int id);
    public Subscription getSubscriptionById(int id);
    public List<Subscription> listSubscription();
}
