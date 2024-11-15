package com.napier.semCoursework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void testGetAllCountries()
    {
        // Get all countries
        ArrayList<Country> countries = app.getAllCountries();

        // Assert that the countries list is not null or empty
        assertNotNull(countries, "Countries list should not be null");
        assertFalse(countries.isEmpty(), "Countries list should not be empty");

        // Check the first country in the list (depends on the database content)
        Country firstCountry = countries.get(0);
        assertNotNull(firstCountry, "First country should not be null");
        assertNotNull(firstCountry.name, "Country name should not be null");
        assertTrue(firstCountry.population > 0, "Country population should be greater than 0");
    }

    @Test
    void testPrintCountriesByPopulation()
    {
        // Get all countries
        ArrayList<Country> countries = app.getAllCountries();

        // Assert that the countries list is not null or empty
        assertNotNull(countries, "Countries list should not be null");
        assertFalse(countries.isEmpty(), "Countries list should not be empty");

        // Capture output from the print method
        try {
            app.printCountriesByPopulation(countries);
            System.out.println("Successfully printed countries by population");
        } catch (Exception e) {
            fail("Printing countries by population threw an exception: " + e.getMessage());
        }
    }
}
