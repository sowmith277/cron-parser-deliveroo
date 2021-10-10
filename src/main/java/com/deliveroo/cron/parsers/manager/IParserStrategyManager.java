package com.deliveroo.cron.parsers.manager;

import com.deliveroo.cron.exception.InvalidCronExpression;
import com.deliveroo.cron.model.TimeUnit;
import com.deliveroo.cron.parsers.Parser;

import java.util.List;

public interface IParserStrategyManager {

    void registerStrategy(Parser parser);

    List<Integer> getExecutableTimings(TimeUnit timeUnit, String cronExpression) throws InvalidCronExpression;
}
