package com.sandun.web.model;

public abstract class HandleComponent {

    protected HandleComponent nextHandler;

    public void setNextHandler(HandleComponent nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handle(com.sandun.web.model.OrderManagement orderManagement);
}
