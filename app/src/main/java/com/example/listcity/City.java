package com.example.listcity;

/**
 * Represents a City with a name and province.
 * This class implements Comparable to allow sorting cities by their name.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * Constructs a City with the given name and province.
     *
     * @param city the name of the city
     * @param province the province where the city is located
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the name of the city.
     *
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the province where the city is located.
     *
     * @return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city with another city by their names.
     *
     * @param o the city to compare to
     * @return a negative integer, zero, or a positive integer as this city's name
     *         is less than, equal to, or greater than the other city's name
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Checks if this city is equal to another object.
     * Two cities are equal if they have the same name and province.
     *
     * @param o the object to compare to
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return this.city.equals(city.city) && this.province.equals(city.province);
    }

    /**
     * Returns the hash code for this city based on its name and province.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return (city != null ? city.hashCode() : 0) * 31 + (province != null ? province.hashCode() : 0);
    }
}
