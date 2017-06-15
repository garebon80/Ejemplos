package com.example.plazofijo.business;

public class ResultsBean {
    public Double balanceInDollars;
    public Double balanceInPesos;
    public Double increment;
    public Double ingrementInDollars;
    public String month;

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getIncrement() {
        return this.increment;
    }

    public void setIncrement(Double increment) {
        this.increment = increment;
    }

    public Double getIngrementInDollars() {
        return this.ingrementInDollars;
    }

    public void setIngrementInDollars(Double ingrementInDollars) {
        this.ingrementInDollars = ingrementInDollars;
    }

    public Double getBalanceInPesos() {
        return this.balanceInPesos;
    }

    public void setBalanceInPesos(Double balanceInPesos) {
        this.balanceInPesos = balanceInPesos;
    }

    public Double getBalanceInDollars() {
        return this.balanceInDollars;
    }

    public void setBalanceInDollars(Double balanceInDollars) {
        this.balanceInDollars = balanceInDollars;
    }
}
