package com.rep.abstractclass;

/**
 * 定义一个抽象类，该类具有可以在其他类中使用的字段和功能。 抽象类可以包含未实现的方法，称为抽象方法。 抽象方法需要由抽象类的子类实现。
 */
abstract class Schedule {
    /* from w ww . j ava 2s . com */
    public String scheduleYear;

    public String teamName;

    public Schedule() {
    }

    public Schedule(String teamName) {
        this.teamName = teamName;
    }

    abstract void calculateDaysPlayed(int month);

}

class TeamSchedule extends Schedule {

    public TeamSchedule(String teamName) {
        super(teamName);
    }

    @Override
    void calculateDaysPlayed(int month) {
        int totalGamesPlayedInMonth = 0;

        System.out.println("Games played in specified month: " + totalGamesPlayedInMonth);
    }

}
