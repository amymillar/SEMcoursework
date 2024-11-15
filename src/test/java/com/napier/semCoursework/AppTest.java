package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class AppTest
{
    static App app;


    // Create initial construction work to manage tests
    @BeforeAll
    static void init()
    {
        // create instance of App to work with
        app = new App();
    }

    // Test to check what happens when null is passed to displayCountries
    @Test
    void printCountriesByPopulationTestNull()
    {
        app.printCountriesByPopulation(null);
    }

    // Test what happens when employee is empty
    @Test
    void printCountriesByPopulationTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountriesByPopulation(countries);
    }

    // Test what happens when a list with a null value is printed
    @Test
    void printCountriesByPopulationTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountriesByPopulation(countries);
    }

    // Test to validate ordering of countries by population
    @Test
    void printCountriesByPopulationTestOrdering()
    {
        ArrayList<Country> countries = new ArrayList<>();

        Country country1 = new Country();
        country1.name = "Australia";
        country1.population = 25000000;

        Country country2 = new Country();
        country2.name = "New Zealand";
        country2.population = 3862000;

        countries.add(country2);
        countries.add(country1);

        app.printCountriesByPopulation(countries);
    }

    // Test with normal conditions
    @Test
    void printCountriesByPopulation()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.code = "NZL";
        country.name = "New Zealand";
        country.continent = "Oceania";
        country.region = "Australia and New Zealand";
        country.population = 3862000;
        app.printCountriesByPopulation(countries);
    }
}
