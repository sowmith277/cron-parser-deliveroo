package com.deliveroo.cron.parsers;

import com.deliveroo.cron.model.TimeUnit;

import java.util.List;

public class StarParser extends Parser {

    @Override
    public List<Integer> getTimings(TimeUnit timeUnit,  String cronExpression) {
        return getCronTimings(timeUnit, 1);
    }

    @Override
    public String getRegex() {
        return "^\\*$";
    }
}
