package com.deliveroo.cron.parsers;

import com.deliveroo.cron.exception.InvalidCronExpression;
import com.deliveroo.cron.model.TimeUnit;

import java.util.ArrayList;
import java.util.List;

public class BoundIntervalsParser extends Parser {

    @Override
    public List<Integer> getTimings(TimeUnit timeUnit, String cronExpression) throws InvalidCronExpression {
        String[] boundIntervals = cronExpression.split(",");
        List<Integer> result = new ArrayList<>();

        for(String boundInterval : boundIntervals) {
            String[] intervals = boundInterval.split("-");
            Integer startInterval = Integer.valueOf(intervals[0]);
            Integer endInterval = Integer.valueOf(intervals[1]);

            if(isValid(startInterval, endInterval, timeUnit)) {
                result.addAll(getCronTimings(startInterval, endInterval, 1));
            } else {
                throw new InvalidCronExpression(timeUnit, cronExpression, "Values passed are not in give range");
            }
        }
        return result;
    }

    @Override
    public String getRegex() {
        return "^\\d+-\\d+(,\\d+-\\d+)*$";
    }

    private boolean isValid(Integer startInterval, Integer endInterval, TimeUnit timeUnit) {
        return startInterval >= timeUnit.getStartRange()
                && startInterval <= timeUnit.getEndRange()
                && endInterval >= timeUnit.getStartRange()
                && endInterval <= timeUnit.getEndRange()
                && startInterval <= endInterval;
    }
}
