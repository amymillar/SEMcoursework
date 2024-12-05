package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class for unit tests on App
 */
public class AppTest {
    static App app;

    /**
     * Create initial construction work to manage tests
     */
    @BeforeAll
    static void init() {
        app = new App();
    }

    /**
     * Test what happens when null is passed into the printCountries method
     */
    @Test
    void printCountriesTestNull() {
        app.printCountries(null);
    }

    /**
     * Test what happens when an empty list is passed into the printCountries method
     */
    @Test
    void printCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountries(countries);
    }

    /**
     * Test what happens when a list containing a null value is passed into the printCountries method
     */
    @Test
    void printCountriesTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountries(countries);
    }

    /**
     * Test what happens when a valid list of countries is passed into the printCountries method
     */
    @Test
    void printCountriesTest() {
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
        app.printCountries(countries);
    }

    /**
     * Test what happens when null is passed into the printCities method
     */
    @Test
    void printCitiesTestNull() {
        app.printCities(null);
    }

    /**
     * Test what happens when an empty list is passed into the printCities method
     */
    @Test
    void printCitiesTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.printCities(cities);
    }

    /**
     * Test what happens when a list containing a null value is passed into the printCities method
     */
    @Test
    void printCitiesTestContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCities(cities);
    }

    /**
     * Test what happens when a valid list of countries is passed into the printCities method
     */
    @Test
    void printCitiesTest() {
        ArrayList<City> cities = new ArrayList<>();

        // Add countries to the list
        City city1 = new City();
        city1.id = 5;
        city1.name = "Amsterdam";
        city1.countryCode = "NLD";
        city1.district = "Noord-Holland";
        city1.population = 731200;

        City city2 = new City();
        city2.id = 1;
        city2.name = "Kabul";
        city2.countryCode = "AFG";
        city2.district = "Kabol";
        city2.population = 1780000;

        cities.add(city1);
        cities.add(city2);

        // Call the method with a valid list
        app.printCities(cities);
    }
}