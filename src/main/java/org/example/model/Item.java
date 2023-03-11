package org.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "total")
    private int total;
    @Column(name = "items")
    private Set<Cart> carts;

    public Item() {
    }

    public Item(int total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", total=" + total +
                ", carts=" + carts +
                '}';
    }
}
