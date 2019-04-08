package net.proselyte.subscription.model;


import javax.persistence.*;



@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "subscription")
    private String subscription;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }


    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", price=" + price +
                ", subscription='" + subscription + '\'' +
                '}';
    }
}
