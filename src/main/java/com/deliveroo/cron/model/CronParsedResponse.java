package com.deliveroo.cron.model;


import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CronParsedResponse {

    private List<Integer> minutes;
    private List<Integer> hours;
    private List<Integer> daysOfMonth;
    private List<Integer> month;
    private List<Integer> daysOfWeek;
    private String command;

    public void setMinutes(List<Integer> minutes) {
        this.minutes = minutes;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }

    public void setDaysOfMonth(List<Integer> daysOfMonth) {
        this.daysOfMonth = daysOfMonth;
    }

    public void setMonth(List<Integer> month) {
        this.month = month;
    }

    public void setDaysOfWeek(List<Integer> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String toString() {
        StringBuffer b = new StringBuffer();
        b.append(format("%-14s%s\n", TimeUnit.MINUTE.getName(), printList(minutes)));
        b.append(format("%-14s%s\n", TimeUnit.HOUR.getName(), printList(hours)));
        b.append(format("%-14s%s\n", TimeUnit.DAY_OF_MONTH.getName(), printList(daysOfMonth)));
        b.append(format("%-14s%s\n", TimeUnit.MONTH.getName(), printList(month)));
        b.append(format("%-14s%s\n", TimeUnit.DAY_OF_WEEK.getName(), printList(daysOfWeek)));
        b.append(format("%-14s%s\n", "command", command));
        return b.toString();
    }

    private String printList(List<Integer> integers) {
        return integers.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
