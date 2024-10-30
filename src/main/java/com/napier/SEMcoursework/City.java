package com.napier.SEMcoursework;

public class City
{
    public int id;
    public String Name;
    public String countryCode;
    public String district;
    public int population;
}
public City getCity()
{
    try
    {
        // Create an SQL statement
        Statement stmt = con.createStatement();
        // Create string for SQL statement
        String strSelect =
                "SELECT * "
                        + "FROM City "
                        + "WHERE district = ?"
                        + "ORDER BY population DESC ";
        // Execute SQL statement
        ResultSet rset = stmt.executeQuery(strSelect);
        // Return new employee if valid.
        // Check one is returned
        if (rset.next())
        {
            City city = new City();
            city.id = rset.getInt("id");
            city.Name = rset.getString("name");
            city.countryCode = rset.getString("country code");
            city.district = rset.getString("district");
            city.population = rset.getInt("population");
            return city;
        }
        else
            return null;
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
        System.out.println("Failed to get cities");
        return null;
    }
}
