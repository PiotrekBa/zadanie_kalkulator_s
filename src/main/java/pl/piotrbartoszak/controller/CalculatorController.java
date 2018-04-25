package pl.piotrbartoszak.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.model.Earning;
import pl.piotrbartoszak.repository.CountryRepository;
import pl.piotrbartoszak.repository.EarningRepository;
import pl.piotrbartoszak.service.CalculateEarningService;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CalculateEarningService cea;

    @Autowired
    EarningRepository earningRepository;

    @GetMapping("")
    public List<Country> getCountries() {
        countryRepository.getCountriesFromFile();
        return countryRepository.getCountries();
    }

    @PostMapping("/calculate")
    public void calculateEarnings(@RequestBody String dailyRate) {
        earningRepository.setEarningsList(dailyRate, countryRepository.getCountries());
    }

    @GetMapping("/send")
    public List<Earning> sendEarnings() {
        return earningRepository.getEarnings();
    }

}
