package com.deliveroo.cron.model;

public enum TimeUnit {
    MINUTE("minute", 0, 59),
    HOUR("hour", 0, 23),
    DAY_OF_MONTH("day of month", 1, 31),
    MONTH("month", 1, 12),
    DAY_OF_WEEK("day of week", 1, 7);

    private String name;
    private int startRange;
    private int endRange;

    TimeUnit(String name, int startRange, int endRange) {
        this.name = name;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public String getName() {
        return name;
    }

    public int getStartRange() {
        return startRange;
    }

    public int getEndRange() {
        return endRange;
    }
}
