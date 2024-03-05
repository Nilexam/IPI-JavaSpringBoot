package com.ipi.championshipmanagement.services.impl;

import com.ipi.championshipmanagement.dao.DayDao;
import com.ipi.championshipmanagement.pojos.Day;
import com.ipi.championshipmanagement.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayDao dayDao;

    @Override
    public List<Day> getAllDays() {
        return (List<Day>) dayDao.findAll();
    }

    @Override
    public Day getDayById(long dayId) {
        Optional<Day> optionalDay = dayDao.findById(dayId);
        return optionalDay.orElse(null);
    }

    @Override
    public Day saveDay(Day day) {
        return dayDao.save(day);
    }

    @Override
    public void deleteDay(long dayId) {
        dayDao.deleteById(dayId);
    }

}
