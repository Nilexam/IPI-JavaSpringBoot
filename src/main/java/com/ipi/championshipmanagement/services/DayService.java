package com.ipi.championshipmanagement.services;

import com.ipi.championshipmanagement.pojos.Day;

import java.util.List;

public interface DayService {
    List<Day> getAllDays();

    Day getDayById(long dayId);

    Day saveDay(Day day);

    void deleteDay(long dayId);

    void save(Day day);
}
