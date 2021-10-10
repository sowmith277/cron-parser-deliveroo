package com.deliveroo.cron;

import com.deliveroo.cron.model.CronParsedResponse;
import com.deliveroo.cron.parsers.*;
import com.deliveroo.cron.parsers.manager.ParserStrategyManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CronExpressionParserTest {
    private static CronExpressionParser parser;

    public static void init() {
        ParserStrategyManager manager = new ParserStrategyManager();
        manager.registerStrategy(new StarParser());
        manager.registerStrategy(new NthIntervalParser());
        manager.registerStrategy(new NumberParser());
        manager.registerStrategy(new BoundIntervalsParser());
        manager.registerStrategy(new FixedTimingsParser());
        parser = new CronExpressionParser(manager);
    }

    @Test
    public void testIfCronExpressionIsWorkingAsExpected() {
        init();
        String expected =
                "minute        0 15 30 45\n" +
                "hour          0\n" +
                "day of month  1 15\n" +
                "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "day of week   1 2 3 4 5\n" +
                "command       /usr/bin/find\n";

        String cronExpression = "*/15 0 1,15 * 1-5 /usr/bin/find";

        CronParsedResponse response = parser.parseString(cronExpression);
        Assertions.assertTrue(expected.equals(response.toString()));
    }
}
