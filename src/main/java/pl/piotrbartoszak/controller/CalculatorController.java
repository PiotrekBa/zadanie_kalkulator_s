package pl.piotrbartoszak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piotrbartoszak.model.Country;
import pl.piotrbartoszak.repository.CountryRepository;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("")
    public List<Country> getValue() {
        return countryRepository.getCountries();
    }
    
}
