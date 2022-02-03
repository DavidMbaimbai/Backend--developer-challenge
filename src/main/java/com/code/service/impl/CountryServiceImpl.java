package com.code.service.impl;

import com.code.model.AddResponse;
import com.code.model.Country;
import com.code.repository.CountryRepository;
import com.code.service.CountryService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository= countryRepository;
    }
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country createNewCountry(Country country) {
        country.setId(getMaxId());
        countryRepository.save(country);
        return country;
    }

    @Override
    public AddResponse deleteCountry(int id) {
      countryRepository.deleteById(id);
      AddResponse response = new AddResponse();
      response.setMsg("Country deleted");
      response.setId(id);
      return response;
    }

    @Override
    public Country updateCountry( Country country) {
        countryRepository.save(country);
        return country;
    }

    public int getMaxId(){
        return countryRepository.findAll().size()+1;
    }

    @Override
    public Country findById(int id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public Country findByName(String name) {
        List<Country> countries = countryRepository.findAll();
        Country country = null;
        for (Country con: countries) {
            if (con.getName().equalsIgnoreCase(name))
                country=con;

        }
        return country;
    }

    @Override
    public Country findByCapital(String capital) {

        List<Country> countries = countryRepository.findAll();
        Country country = null;
        for (Country con: countries){
            if (con.getCapital().equalsIgnoreCase(capital))
                country=con;
        }
        return country;
    }

    @Override
    public Country findByRegion(String region) {
        List<Country> countries = countryRepository.findAll();
        Country country = null;
        for (Country con: countries) {
            if (con.getRegion().equalsIgnoreCase(region))
                country =con;
        }
        return country;
    }

    @Override
    public Country findBySubRegion(String subRegion) {
        List<Country> countries = countryRepository.findAll();
        Country country = null;
        for (Country con: countries) {
            if (con.getSubRegion().equalsIgnoreCase(subRegion))
                country = con;
        }
        return country;
    }

    @Override
    public Country findByArea(String area) {
        List<Country> countries = countryRepository.findAll();
        Country country = null;
        for(Country con: countries){
            if (con.getArea().equalsIgnoreCase(area))
                country = con;
        }
        return country;
    }
}
