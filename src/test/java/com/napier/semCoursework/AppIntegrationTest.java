package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        // Call the method to retrieve all the countries from the world database
        ArrayList<Country> countries = app.getAllCountries();
        // Check the list of countries is not null
        assertNotNull(countries);
        // Check the list of countries is not empty
        assertFalse(countries.isEmpty());
    }

    /**
     * Test that getAllCountries returns a list of countries sorted by population in descending order
     */
    @Test
    void testAllCountriesOrderingByPopulation()
    {
        ArrayList<Country> countries = app.getAllCountries();
        assertNotNull(countries);

        // Validate ordering
        for (int i = 0; i < countries.size() - 1; i++)
        {
            assertTrue(countries.get(i).population >= countries.get(i + 1).population);
        }
    }

    /**
     * Test that the getCountriesByContinent method returns a valid list of countries from a chosen continent
     */
    @Test
    void testGetCountriesByContinent()
    {
        // Call the method to retrieve all the countries in the continent of "Asia"
        ArrayList<Country> countries = app.getCountriesByContinent("Asia");
        // Check the list of countries is not null
        assertNotNull(countries);
        // Check the list of countries is not empty
        assertFalse(countries.isEmpty());
    }

    /**
     * Test that getCountriesByContinent returns a list of countries sorted by population in descending order
     */
    @Test
    void testCountriesByContinentOrderingByPopulation()
    {
        ArrayList<Country> countries = app.getAllCountries();
        assertNotNull(countries);

        // Validate ordering
        for (int i = 0; i < countries.size() - 1; i++)
        {
            assertTrue(countries.get(i).population >= countries.get(i + 1).population);
        }
    }

    /**
     * Test that the getCountriesByRegion method returns a valid list of countries from a chosen region
     */
    @Test
    void testGetCountriesByRegion()
    {
        // Call the method to retrieve all the countries in the "Europe" region
        ArrayList<Country> countries = app.getCountriesByRegion("Europe");
        // Check the list of countries is not null
        assertNotNull(countries);
        // Check the list of countries is not empty
        assertFalse(countries.isEmpty());
    }

    /**
     * Test that getCountriesByRegion returns a list of countries sorted by population in descending order
     */
    @Test
    void testCountriesByRegionOrderingByPopulation()
    {
        ArrayList<Country> countries = app.getAllCountries();
        assertNotNull(countries);

        // Validate ordering
        for (int i = 0; i < countries.size() - 1; i++)
        {
            assertTrue(countries.get(i).population >= countries.get(i + 1).population);
        }
    }
}