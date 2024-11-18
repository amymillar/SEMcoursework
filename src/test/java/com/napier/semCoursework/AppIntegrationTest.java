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
    void testGetCountry()
    {
        Country country = app.getCountry("ITA");
        assertEquals(country.code, "ITA");
        assertEquals(country.name, "Italy");
        assertEquals(country.continent, "Europe");
        assertEquals(country.region, "Southern Europe");
        assertEquals(country.population,57680000);
    }
}
