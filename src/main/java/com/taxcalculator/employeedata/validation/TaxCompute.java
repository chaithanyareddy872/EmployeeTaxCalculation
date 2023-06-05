package com.taxcalculator.employeedata.validation;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class TaxCompute {
    public double taxCal(double yearlysal){
        return yearlysal<250000?
                0:yearlysal>250000 && yearlysal<=500000?
                0.05*yearlysal:yearlysal>500000 && yearlysal<=1000000?
                12500+0.1*(yearlysal-500000):(yearlysal>1000000 && yearlysal<2500000)?
                62500+0.2*(yearlysal-10000000):62500+0.2*(yearlysal-10000000)+0.02*(yearlysal-2500000);

    }
    public double cesAmount(double monthlySal){
        return monthlySal*12>2500000?0.02*(monthlySal*12):0;
    }
    public double totalsal(LocalDateTime date,double monthSal){
        LocalDateTime todate=date.getMonthValue()>4?
                LocalDateTime.of(date.getYear() + 1, 5, 1, 0, 0, 0):
                LocalDateTime.of(date.getYear(), 5, 1, 0, 0, 0);
        long daysbt= ChronoUnit.DAYS.between(date,todate);
        System.out.println(daysbt);
        return daysbt*(monthSal/30);
    }
}
