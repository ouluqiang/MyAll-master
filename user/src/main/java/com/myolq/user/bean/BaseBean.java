package com.myolq.user.bean;

/**
 * Created by root on 2017-09-01.
 */

public class BaseBean<T> {

    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
