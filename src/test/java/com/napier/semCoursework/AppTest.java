package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class AppTest

{
    static App app;

    /**
     * Create initial construction work to manage tests
     */
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * Test what happens when null is passed into the printCountriesByPopulation method
     */
    @Test
    void printCountriesByPopulationTestNull()
    {
        app.printCountriesByPopulation(null);
    }

    /**
     * Test what happens when an empty list is passed into the printCountriesByPopulation method
     */
    @Test
    void printCountriesByPopulationTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountriesByPopulation(countries);
    }

    /**
     * Test what happens when a list containing a null value is passed into the printCountriesByPopulation method
     */
    @Test
    void printCountriesByPopulationTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountriesByPopulation(countries);
    }

    /**
     * Test what happens when a valid list of countries is passed into the printCountriesByPopulation method
     */
    @Test
    void printCountriesByPopulationTest()
    {
        ArrayList<Country> countries = new ArrayList<>();

        // Add countries to the list
        Country country1 = new Country();
        country1.code = "NZL";
        country1.name = "New Zealand";
        country1.continent = "Oceania";
        country1.region = "Australia and New Zealand";
        country1.population = 3862000;

        Country country2 = new Country();
        country2.code = "AUS";
        country2.name = "Australia";
        country2.continent = "Oceania";
        country2.region = "Australia and New Zealand";
        country2.population = 25687041;

        countries.add(country1);
        countries.add(country2);

        // Call the method with a valid list
        app.printCountriesByPopulation(countries);
    }
}