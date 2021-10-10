package com.deliveroo.cron.parsers;

import com.deliveroo.cron.exception.InvalidCronExpression;
import com.deliveroo.cron.model.TimeUnit;

import java.util.ArrayList;
import java.util.List;

public class FixedTimingsParser extends Parser {

    @Override
    public List<Integer> getTimings(TimeUnit timeUnit, String cronExpression) throws InvalidCronExpression {
        String[] fixedTimings = cronExpression.split(",");
        List<Integer> result = new ArrayList<>();

        for(String fixedTime : fixedTimings) {
            Integer time = Integer.valueOf(fixedTime);
            if(isValid(time, timeUnit)) {
                result.add(time);
            } else {
                new InvalidCronExpression(timeUnit, cronExpression, "Values passed are not in give range");
            }
        }

        return result;
    }

    @Override
    public String getRegex() {
        return "^\\d+(,\\d+)*$";
    }

    private boolean isValid(Integer value, TimeUnit timeUnit) {
        return value < timeUnit.getStartRange() || value > timeUnit.getEndRange() ? false : true;
    }
}
