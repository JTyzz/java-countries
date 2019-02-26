package com.jasontyzzer.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class CountryController {

    // /names/all
    @RequestMapping("/names/all")
    public ArrayList<Country> getAllCountries(){
        JavaCountriesApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return JavaCountriesApplication.countryList.countryList;
    }

    // /names/begin?letter=
    @RequestMapping("/names/begin")
    public ArrayList<Country> getCountriesThatBeginWith(@RequestParam(value = "letter") String letter){
        ArrayList<Country> countryBegin = new ArrayList<>();

        for (Country c: JavaCountriesApplication.countryList.countryList){
            if (c.getName().toLowerCase().startsWith(letter.toLowerCase())){
                countryBegin.add(c);
            }
        }
        return countryBegin;
    }

    // /names/size?letters=
    @RequestMapping("/names/size")
    public ArrayList<Country> getCountriesByNameLength(@RequestParam(value = "letters") int size){
        ArrayList<Country> countrySize = new ArrayList<Country>();
        for (Country c: JavaCountriesApplication.countryList.countryList){
            if (c.getName().length() >= size){
                countrySize.add(c);
            }
        }
        return countrySize;
    }
}
