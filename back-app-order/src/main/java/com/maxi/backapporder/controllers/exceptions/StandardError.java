package com.maxi.backapporder.controllers.exceptions;

public class StandardError {
    private Long moment;
    private String error;
    private Integer status;

    public StandardError() {
    }

    public StandardError(Long moment, String error, Integer status) {
        this.moment = moment;
        this.error = error;
        this.status = status;
    }

    public Long getMoment() {
        return moment;
    }

    public void setMoment(Long moment) {
        this.moment = moment;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
