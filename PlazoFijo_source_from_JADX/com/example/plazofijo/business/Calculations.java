package com.example.plazofijo.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calculations {
    public static ArrayList<ResultsBean> calcultate(Double initialAmount, Double monthlySavings, Double porcentageOfInterest, Double numberOfMonths, Double dollarValue) {
        ArrayList<ResultsBean> resultsList = new ArrayList();
        Calendar c1 = GregorianCalendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
        for (int i = 0; ((double) i) < numberOfMonths.doubleValue(); i++) {
            double interests = (initialAmount.doubleValue() * porcentageOfInterest.doubleValue()) / 100.0d;
            double interestInDollars = interests / dollarValue.doubleValue();
            initialAmount = Double.valueOf((initialAmount.doubleValue() + interests) + monthlySavings.doubleValue());
            double balanceindolars = initialAmount.doubleValue() / dollarValue.doubleValue();
            ResultsBean resultsBean = new ResultsBean();
            if (i == 0) {
                resultsBean.setMonth(sdf.format(c1.getTime()));
            } else {
                c1.add(2, 1);
                resultsBean.setMonth(sdf.format(c1.getTime()));
            }
            resultsBean.setIncrement(Double.valueOf(interests));
            resultsBean.setIngrementInDollars(Double.valueOf(interestInDollars));
            resultsBean.setBalanceInPesos(initialAmount);
            resultsBean.setBalanceInDollars(Double.valueOf(balanceindolars));
            resultsList.add(resultsBean);
        }
        return resultsList;
    }
}
