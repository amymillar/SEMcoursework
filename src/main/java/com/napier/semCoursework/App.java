package com.napier.semCoursework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create new Application and connect to database
        App a = new App();

        if (args.length < 1) {
            a.connect("localhost:33060", 10000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Get all countries in the world and display them ordered by population
        ArrayList<Country> countries = a.getAllCountries();
        System.out.println("ALL THE COUNTRIES IN THE WORLD:");
        a.printCountries(countries);

        // Get all the countries in europe and display them ordered by population
        ArrayList<Country> europeCountries = a.getCountriesByContinent("Europe");
        System.out.println("COUNTRIES IN EUROPE:");
        a.printCountries(europeCountries);

        // Get all countries in Western Europe and display them ordered by population
        ArrayList<Country> westEuropeCountries = a.getCountriesByRegion("Western Europe");
        System.out.println("COUNTRIES IN WESTERN EUROPE:");
        a.printCountries(westEuropeCountries);

        // Get all cities in the world and display them ordered by population
        ArrayList<City> cities = a.getAllCities();
        System.out.println("ALL THE CITIES IN THE WORLD:");
        a.printCities(cities);

        // Get all cities in Asia and display them ordered by population
        ArrayList<City> asianCities = a.getCitiesByContinent("Asia");
        System.out.println("CITIES IN ASIA:");
        a.printCities(asianCities);

        // Get all cities in the Middle East and display them ordered by population
        ArrayList<City> middleEastCities = a.getCitiesByRegion("Middle East");
        System.out.println("CITIES IN MIDDLE EAST:");
        a.printCities(middleEastCities);

        // Get all cities in Georgia and display them ordered by population
        ArrayList<City> georgiaCities = a.getCitiesByCountry("GEO");
        System.out.println("CITIES IN GEORGIA:");
        a.printCities(georgiaCities);

        // Get all cities in São Paulo and display them ordered by population
        ArrayList<City> pauloCities = a.getCitiesByDistrict("São Paulo");
        System.out.println("CITIES IN THE SAU PAULO DISTRICT:");
        a.printCities(pauloCities);

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
    public void connect(String location, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        boolean shouldWait = false;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                if (shouldWait) {
                    // Wait a bit for db to start
                    Thread.sleep(delay);
                }

                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());

                // Let's wait before attempting to reconnect
                shouldWait = true;
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets all the countries from the world database
     * Orders them from largest population to smallest
     * Returns A list of countries sorted by population
     */
    public ArrayList<Country> getAllCountries() {
        // list to hold countries data
        ArrayList<Country> countries = new ArrayList<>();
        try {
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
            while (rset.next()) {
                // Create new country object and set its name and population
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");

                // Add country to the list
                countries.add(country);
            }
            System.out.println("\n");
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to country details");
        }
        return countries;
    }

    /**
     * Gets all the countries in a specific continent from the database
     * Orders them from largest population to smallest
     * Returns A list of countries sorted by population
     */
    public ArrayList<Country> getCountriesByContinent(String continent) {
        // List to hold countries data
        ArrayList<Country> countries = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each country in the specified continent
            // ordered by population descending
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "WHERE continent = '" + continent + "' "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next()) {
                // Create new country object and set its name and population
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");

                // Add country to the list
                countries.add(country);
            }
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries in the continent");
        }
        return countries;
    }

    /**
     * Gets all the countries in a specific region from the database
     * Orders them from largest population to smallest
     * Returns A list of countries sorted by population
     */
    public ArrayList<Country> getCountriesByRegion(String region) {
        // List to hold countries data
        ArrayList<Country> countries = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each country in the specified continent
            // ordered by population descending
            String strSelect =
                    "SELECT name, population "
                            + "FROM country "
                            + "WHERE continent = '" + region  + "' "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next()) {
                // Create new country object and set its name and population
                Country country = new Country();
                country.name = rset.getString("name");
                country.population = rset.getInt("population");

                // Add country to the list
                countries.add(country);
            }
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries in the region");
        }
        return countries;
    }

    public ArrayList<City> getAllCities() {
        // list to hold cities data
        ArrayList<City> cities = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each city and order them by biggest population to smallest
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next()) {
                // Create new city object and set its name and population
                City city = new City();
                city.name = rset.getString("name");
                city.population = rset.getInt("population");

                // Add city to the list
                cities.add(city);
            }
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to city details");
        }
        return cities;
    }

    /**
     * Gets all the cities in a specific continent from the database
     * Orders them from largest population to smallest
     * Returns A list of cities sorted by population
     */
    public ArrayList<City> getCitiesByContinent(String continent) {
        // List to hold countries data
        ArrayList<City> cities = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each city in the specified continent
            // ordered by population descending
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city "
                            + "JOIN country ON city.countryCode = country.code "
                            + "WHERE continent = '" + continent + "' "
                            + "ORDER BY city.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next()) {
                // Create new country object and set its name and population
                City city = new City();
                city.name = rset.getString("name");
                city.population = rset.getInt("population");

                // Add country to the list
                cities.add(city);
            }
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in the continent");
        }
        return cities;
    }

    /**
     * Gets all the cities in a specific region from the database
     * Orders them from largest population to smallest
     * Returns A list of cities sorted by population
     */
    public ArrayList<City> getCitiesByRegion(String region) {
        // List to hold countries data
        ArrayList<City> cities = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each city in the specified continent
            // ordered by population descending
            String strSelect =
                    "SELECT city.name, city.population "
                            + "FROM city "
                            + "JOIN country ON city.countryCode = country.code "
                            + "WHERE region = '" + region + "' "
                            + "ORDER BY city.population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next()) {
                // Create new city object and set its name and population
                City city = new City();
                city.name = rset.getString("name");
                city.population = rset.getInt("population");

                // Add city to the list
                cities.add(city);
            }
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in the region");
        }
        return cities;
    }

    /**
     * Gets all the cities in a specific country from the database
     * Orders them from largest population to smallest
     * Returns A list of cities sorted by population
     */
    public ArrayList<City> getCitiesByCountry(String countryCode) {
        // List to hold countries data
        ArrayList<City> cities = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each city in the specified country
            // ordered by population descending
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "WHERE countryCode = '" + countryCode + "' "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next()) {
                // Create new city object and set its name and population
                City city = new City();
                city.name = rset.getString("name");
                city.population = rset.getInt("population");

                // Add city to the list
                cities.add(city);
            }
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in the region");
        }
        return cities;
    }

    /**
     * Gets all the cities in a specific district from the database
     * Orders them from largest population to smallest
     * Returns A list of cities sorted by population
     */
    public ArrayList<City> getCitiesByDistrict(String district) {
        // List to hold cities data
        ArrayList<City> cities = new ArrayList<>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            // Get the name and population of each city in the specified district
            // ordered by population descending
            String strSelect =
                    "SELECT name, population "
                            + "FROM city "
                            + "WHERE district = '" + district + "' "
                            + "ORDER BY population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Check each row in result set
            while (rset.next()) {
                // Create new city object and set its name and population
                City city = new City();
                city.name = rset.getString("name");
                city.population = rset.getInt("population");

                // Add city to the list
                cities.add(city);
            }
            rset.close();
            stmt.close();
        } catch (Exception e) {
            // Print error message if query fails
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in the district");
        }
        return cities;
    }


    /**
     * Prints the list of countries and their populations.
     */
    public void printCountries(List<Country> countries) {
        // Check countries is not null
        if (countries == null) {
            System.out.println("No countries found");
            return;
        }

        // Loop over all the countries in the list
        for (Country country : countries) {
            // Check if a country is null and skip if it is
            if (country == null)
                continue;
            // Print out country name and its population
            System.out.println(
                    "Name:" + country.name + "\n"
                            + "Population:" + country.population);
        }
    }

    /**
     * Prints the list of cities and their populations.
     */
    public void printCities(List<City> cities) {
        // Check cities is not null
        if (cities == null) {
            System.out.println("No countries found");
            return;
        }

        // Loop over all the city in the list
        for (City city : cities) {
            // Check if a city is null and skip if it is
            if (city == null)
                continue;
            // Print out city name and its population
            System.out.println(
                    "Name:" + city.name + "\n"
                            + "Population:" + city.population);
        }
    }
}