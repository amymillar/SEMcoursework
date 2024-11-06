package com.napier.semCoursework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Get all countries
        List<Country> countries = a.getAllCountries();
        // Display all countries
        a.displayCountries(countries);

        // Disconnect from database
        a.disconnect();
    }
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public List<Country> getAllCountries()
    {
        // list to hold countries data
        List<Country> countries = new ArrayList<>();
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each country and order them by biggest population to smallest
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next())
            {
                // Create new country object and set its name and population
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");

                // Add country to the list
                countries.add(country);
            }
            rset.close();
            stmt.close();
        }
        catch (Exception e)
        {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to country details");
        }
        return countries;
    }

    public void displayCountries(List<Country> countries)
    {
        // Check countries is not null
        if (countries == null)
        {
            System.out.println("No countries found");
            return;
        }

        // Loop over all the countries in the list
        for (Country country : countries)
        {
            // Check if a country is null
            if (country == null)
                continue;
            // Print out country name and its population
            System.out.println(
                    "Name:" + country.name + "\n"
                            + "Population:" + country.population + "\n");
        }
    }
}