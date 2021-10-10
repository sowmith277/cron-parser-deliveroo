package com.deliveroo.cron.parsers;

import com.deliveroo.cron.exception.InvalidCronExpression;
import com.deliveroo.cron.model.TimeUnit;

import java.util.Arrays;
import java.util.List;

public class NumberParser extends Parser {

    @Override
    public List<Integer> getTimings(TimeUnit timeUnit, String cronExpression) throws InvalidCronExpression {
        Integer value = Integer.valueOf(cronExpression);
        if(value < timeUnit.getStartRange() || value > timeUnit.getEndRange()) {
            new InvalidCronExpression(timeUnit, cronExpression, "Values passed are not in give range");
        }

        return Arrays.asList(Integer.valueOf(cronExpression));
    }

    @Override
    public String getRegex() {
        return "^\\d+$";
    }
}
