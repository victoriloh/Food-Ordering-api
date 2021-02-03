package com.restapi.foodapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_price")
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private Order orders;


    public Menu() {
    }

    public Menu(String foodName, Long price) {
        this.foodName = foodName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodMenu{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                '}';
    }
}
