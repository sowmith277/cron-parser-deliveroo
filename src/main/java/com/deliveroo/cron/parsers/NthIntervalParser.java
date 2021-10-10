package com.deliveroo.cron.parsers;

import com.deliveroo.cron.exception.InvalidCronExpression;
import com.deliveroo.cron.model.TimeUnit;

import java.util.List;

public class NthIntervalParser extends Parser{

    private static final String NTH_INTERVAL_FORMAT = "*/";
    @Override
    public List<Integer> getTimings(TimeUnit timeUnit, String cronExpression) throws InvalidCronExpression {
        String intervalString = cronExpression.substring(NTH_INTERVAL_FORMAT.length());
        Integer interval = Integer.valueOf(intervalString);

        if(interval < timeUnit.getStartRange() || interval > timeUnit.getEndRange()) {
            throw new InvalidCronExpression(timeUnit, cronExpression, "Values passed are not in give range");
        }

        return getCronTimings(timeUnit, interval);
    }

    @Override
    public String getRegex() {
        return "^\\*/\\d+$";
    }
}
