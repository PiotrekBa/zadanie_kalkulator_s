package pl.piotrbartoszak.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.model.Earning;
import pl.piotrbartoszak.repository.CountryRepository;
import pl.piotrbartoszak.service.CalculateEarningService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CalculateEarningService cea;

    @GetMapping("")
    public List<Country> getCountries() {
        countryRepository.getCountriesFromFile();
        return countryRepository.getCountries();
    }

    @PostMapping("/calculate")
    public List<Earning> calculateEarnings(@RequestBody String dailyRate) {
        List<Earning> earnings = new ArrayList<>();

        List<Country> countries = countryRepository.getCountries();

        for(Country c : countries) {
            Earning earning = cea.calculateEarning(dailyRate, c);
            earnings.add(earning);
        }

        return earnings;
    }

}
