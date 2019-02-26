package com.jasontyzzer.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/")
public class CountryController {

    // /names/all
    @RequestMapping("names/all")
    public ArrayList<Country> getAllCountries(){
        JavaCountriesApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return JavaCountriesApplication.countryList.countryList;
    }

    // /names/begin?letter=
    @RequestMapping("names/begin")
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
    @RequestMapping("names/size")
    public ArrayList<Country> getCountriesByNameLength(@RequestParam(value = "letters") int size){
        ArrayList<Country> countrySize = new ArrayList<>();
        for (Country c: JavaCountriesApplication.countryList.countryList){
            if (c.getName().length() >= size){
                countrySize.add(c);
            }
        }
        return countrySize;
    }

    // /population/size?people=
    @RequestMapping ("population/size")
    public ArrayList<Country> getCountriesByPopulation(@RequestParam(value = "people") int population){
        ArrayList<Country> populationSize = new ArrayList<>();
        for (Country c: JavaCountriesApplication.countryList.countryList){
            if (c.getPopulation() >= population){
                populationSize.add(c);
            }
        }
        return populationSize;
    }

    // /population/min
    @RequestMapping ("population/min")
    public Country getCountryByMinPop(){
        JavaCountriesApplication.countryList.countryList.sort(Comparator.comparing(Country::getPopulation));
        return JavaCountriesApplication.countryList.countryList.get(0);
    }


    // /population/max
    @RequestMapping ("population/max")
    public Country getCountryByMaxPop(){
        JavaCountriesApplication.countryList.countryList.sort(Comparator.comparing(Country::getPopulation));
        return JavaCountriesApplication.countryList.countryList.get(JavaCountriesApplication.countryList.countryList.size() - 1);
    }

    // /age/age?age=
    @RequestMapping ("age/age")
    public ArrayList<Country> getCountryByAgeInput(@RequestParam(value = "age")int age){
        ArrayList<Country> countryAge = new ArrayList<>();
        for( Country c: JavaCountriesApplication.countryList.countryList){
            if(c.getMedianAge() >= age){
                countryAge.add(c);
            }
        }
        return countryAge;
    }


    // /age/min
    @RequestMapping ("age/min")
    public Country getCountryByMinAge(){
        JavaCountriesApplication.countryList.countryList.sort(Comparator.comparing(Country::getMedianAge));
        return JavaCountriesApplication.countryList.countryList.get(0);
    }


    // /age/max
    @RequestMapping ("age/max")
    public Country getCountryByMaxAge(){
        JavaCountriesApplication.countryList.countryList.sort(Comparator.comparing(Country::getMedianAge));
        return JavaCountriesApplication.countryList.countryList.get(JavaCountriesApplication.countryList.countryList.size() - 1);
    }
}
