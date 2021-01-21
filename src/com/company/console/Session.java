package com.company.console;

import com.company.entity.User;

public class Session {
    private User user;
    private Basket basket = new Basket();

    public Session(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Basket getBasket() {
        return basket;
    }
}
