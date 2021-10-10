package com.deliveroo.cron.parsers.manager;

import com.deliveroo.cron.exception.InvalidCronExpression;
import com.deliveroo.cron.model.TimeUnit;
import com.deliveroo.cron.parsers.Parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParserStrategyManager implements IParserStrategyManager {

    private Set<Parser> parserList = new HashSet<>();

    @Override
    public void registerStrategy(Parser parser) {
        parserList.add(parser);
    }

    @Override
    public List<Integer> getExecutableTimings(TimeUnit timeUnit, String cronExpression) throws InvalidCronExpression {
        Parser parser;
        try {
            parser = getParser(cronExpression);
        } catch (InvalidCronExpression invalidCronExpression) {
            throw new InvalidCronExpression(timeUnit, cronExpression, invalidCronExpression.getMessage());
        }
        return parser.getTimings(timeUnit, cronExpression);
    }

    private Parser getParser(String cronExpression) {
        for(Parser parser : parserList) {
            if(cronExpression.matches(parser.getRegex())) {
                return parser;
            }
        }

        throw new InvalidCronExpression("Invalid expression passed. Not able to parse the given input.");
    }
}
