package com.code.controller;

import com.code.model.AddResponse;
import com.code.model.Country;
import com.code.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService= countryService;
    }

    @GetMapping("/getcountries")
    public ResponseEntity<List<Country>> getCountries(){
        try {
            List<Country>countries = countryService.getAllCountries();
            return new ResponseEntity<>(countries, HttpStatus.FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/getcountries{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable (value = "id") int id){
        try {
            Country country = countryService.findById(id);
            return new ResponseEntity<>(country,HttpStatus.OK);
        }catch (Exception ex){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getcountries/countryregion")
    public ResponseEntity<Country> getCountryByRegion(@PathVariable (value="region") String region){
        try{
            Country country = countryService.findByRegion(region);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getcountries/countrysubregion")
    public ResponseEntity<Country> getCountryBySubRegion(@PathVariable (value="subRegion") String subRegion){
        try{
            Country country = countryService.findBySubRegion(subRegion);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getcountries/countryarea")
    public ResponseEntity<Country> getCountryByArea(@PathVariable (value="area") String area){
        try{
            Country country = countryService.findByArea(area);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getcountries/countryname")
    public ResponseEntity<Country> getCountryByName(@PathVariable (value="name") String name){
        try{
            Country country = countryService.findByName(name);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getcountries/countrycapital")
    public ResponseEntity<Country> getCountryByCapital(@PathVariable(value="capital")
                                                                   String capital){
        try {
            Country country = countryService.findByCapital(capital);
            return new ResponseEntity<>(country, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
        return countryService.createNewCountry(country);

    }

    @PutMapping("/updatecountry")
    public ResponseEntity<Country> updateCountry(@PathVariable (value = "id") int id,
                                 @RequestBody Country country){
        try {
            Country existCountry= countryService.findById(id);
            existCountry.setName(country.getName());
            existCountry.setRegion(country.getRegion());
            existCountry.setCapital(country.getCapital());
            existCountry.setSubRegion(country.getSubRegion());
            existCountry.setArea(country.getArea());
            Country updatedCountry=countryService.updateCountry(existCountry);
            return new ResponseEntity<>(updatedCountry,HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable (value="id") int id){
        return countryService.deleteCountry(id);
    }



}
