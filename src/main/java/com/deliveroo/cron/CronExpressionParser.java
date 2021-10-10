package com.deliveroo.cron;

import com.deliveroo.cron.model.CronParsedResponse;
import com.deliveroo.cron.model.TimeUnit;
import com.deliveroo.cron.parsers.manager.IParserStrategyManager;

public class CronExpressionParser {

    private IParserStrategyManager manager;

    public CronExpressionParser(IParserStrategyManager manager) {
        this.manager = manager;
    }

    public CronParsedResponse parseString(String cronExpression) {
        CronParsedResponse response = new CronParsedResponse();
        String[] cronSplitted = cronExpression.split(" ");

        response.setMinutes(manager.getExecutableTimings(TimeUnit.MINUTE, cronSplitted[0]));
        response.setHours(manager.getExecutableTimings(TimeUnit.HOUR, cronSplitted[1]));
        response.setDaysOfMonth(manager.getExecutableTimings(TimeUnit.DAY_OF_MONTH, cronSplitted[2]));
        response.setMonth(manager.getExecutableTimings(TimeUnit.MONTH, cronSplitted[3]));
        response.setDaysOfWeek(manager.getExecutableTimings(TimeUnit.DAY_OF_WEEK, cronSplitted[4]));
        response.setCommand(cronSplitted[5]);

        return response;
    }
}
