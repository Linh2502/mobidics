package org.mobidics.model;

public class MinMaxSummary
{
    private int groupSizeMin;
    private int groupSizeMax;
    private int timeMin;
    private int timeMax;

    public MinMaxSummary(int groupSizeMin, int groupTypeMax, int timeMin, int timeMax)
    {
        this.groupSizeMin = groupSizeMin;
        this.groupSizeMax = groupTypeMax;
        this.timeMin = timeMin;
        this.timeMax = timeMax;
    }

    public int getGroupSizeMin()
    {
        return groupSizeMin;
    }

    public int getGroupSizeMax()
    {
        return groupSizeMax;
    }

    public int getTimeMin()
    {
        return timeMin;
    }

    public int getTimeMax()
    {
        return timeMax;
    }
}
