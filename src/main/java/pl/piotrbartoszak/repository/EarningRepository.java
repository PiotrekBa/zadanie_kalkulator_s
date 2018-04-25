package pl.piotrbartoszak.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.model.Earning;
import pl.piotrbartoszak.service.CalculateEarningService;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EarningRepository {

    @Autowired
    CalculateEarningService cea;

    private List<Earning> earnings;

    public List<Earning> getEarnings() {
        return earnings;
    }

    public void setEarnings(List<Earning> earnings) {
        this.earnings = earnings;
    }

    public void setEarningsList(String dailyRate, List<Country> countries) {

        this.earnings = new ArrayList<>();

        for (Country c : countries) {
            Earning earning = cea.calculateEarning(dailyRate, c);
            earnings.add(earning);
        }
    }

}
