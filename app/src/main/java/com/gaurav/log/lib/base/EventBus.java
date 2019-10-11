package com.gaurav.log.lib.base;

public interface EventBus {
    void regiater(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
