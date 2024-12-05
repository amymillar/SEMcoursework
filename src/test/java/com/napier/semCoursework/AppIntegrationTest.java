package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
        // Check the list of countries is not null or empty
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }

    /**
     * Test that the getCountriesByContinent method returns a valid list of countries from a chosen continent
     */
    @Test
    void testGetCountriesByContinent()
    {
        ArrayList<Country> countries = app.getCountriesByContinent("Asia");
        // Check the list of countries is not null or empty
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }

    /**
     * Test that the getCountriesByRegion method returns a valid list of countries from a chosen region
     */
    @Test
    void testGetCountriesByRegion()
    {
        ArrayList<Country> countries = app.getCountriesByRegion("Europe");
        // Check the list of countries is not null or empty
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }
}}