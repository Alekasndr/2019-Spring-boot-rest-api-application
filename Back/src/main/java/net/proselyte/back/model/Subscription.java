package net.proselyte.back.model;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "subscription")
@ToString
public class Subscription extends ModelEntity {

    @Column(name = "subscription")
    private String subscription;


    @Column(name = "price")
    private String price;

    public Subscription() {
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
