package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for integration tests on App
 */
public class AppIntegrationTest
{
    static App app;

    /**
     * Create a random entry into the database to use for testing
     */
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    /**
     * Test that the getAllCountries method returns a valid list of all the countries in the world
     */
    @Test
    void testGetAllCountries()
    {
        ArrayList<Country> countries = app.getAllCountries();
        // Check the list of countries is not null
        assertNotNull(countries);
    }

    /**
     * Test that the getCountriesByContinent method returns a valid list of countries from a chosen continent
     */
    @Test
    void testGetCountriesByContinent()
    {
        ArrayList<Country> countries = app.getCountriesByContinent("Asia");
        // Check the list of countries is not null
        assertNotNull(countries);
    }

    /**
     * Test that the getCountriesByRegion method returns a valid list of countries from a chosen region
     */
    @Test
    void testGetCountriesByRegion()
    {
        ArrayList<Country> countries = app.getCountriesByRegion("Europe");
        // Check the list of countries is not null
        assertNotNull(countries);
    }

    /**
     * Test that the getAllCities method returns a valid list of all the cities in the world
     */
    @Test
    void testGetAllCities()
    {
        ArrayList<City> cities = app.getAllCities();
        // Check the list cities is not null
        assertNotNull(cities);
    }

    /**
     * Test that the getCitiesByContinent method returns a valid list of cities from a chosen continent
     */
    @Test
    void getCitiesByContinent()
    {
        ArrayList<City> cities = app.getCitiesByContinent("Asia");
        // Check the list cities is not null
        assertNotNull(cities);
    }

    /**
     * Test that the getCitiesByRegion method returns a valid list of cities from a chosen region
     */
    @Test
    void getCitiesByRegion()
    {
        ArrayList<City> cities = app.getCitiesByRegion("Middle East");
        // Check the list cities is not null
        assertNotNull(cities);
    }

    /**
     * Test that the getCitiesByCountry method returns a valid list of cities from a chosen country
     */
    @Test
    void getCitiesByCountry()
    {
        ArrayList<City> cities = app.getCitiesByCountry("GEO");
        // Check the list cities is not null
        assertNotNull(cities);
    }

    /**
     * Test that the getCitiesByDistrict method returns a valid list of cities from a chosen district
     */
    @Test
    void getCitiesByDistrict()
    {
        ArrayList<City> cities = app.getCitiesByDistrict("São Paulo");
        // Check the list cities is not null
        assertNotNull(cities);
    }
}