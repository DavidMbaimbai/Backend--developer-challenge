package com.code.service;

import com.code.model.AddResponse;
import com.code.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CountryService {
      List<Country> getAllCountries();
      Country createNewCountry(Country country);
      AddResponse deleteCountry(int id);
      Country updateCountry( Country country);
      Country findById(int id);
      Country findByName(String name);
      Country findByCapital(String capital);
      Country findByRegion(String region);
      Country findBySubRegion(String subRegion);
      Country findByArea(String area);

}
