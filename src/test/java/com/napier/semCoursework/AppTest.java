package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displayCountriesTestNull()
    {
        app.displayCountries(null);
    }

    @Test
    void displayCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountries(countries);
    }

    @Test
    void displayCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountries(countries);
    }

    @Test
    void displayCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.code = "NZL";
        country.name = "New Zealand";
        country.continent = "Oceania";
        country.region = "Australia and New Zealand";
        country.population = 3862000;
        app.displayCountries(countries);
    }


}
