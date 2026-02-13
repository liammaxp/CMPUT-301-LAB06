package com.example.listcity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that maintains a list of City objects.
 * This class provides functionality to add, remove, retrieve, and query cities.
 * The list is kept sorted alphabetically by city name when retrieved.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if the city does not already exist.
     * Equality is determined by the City class's equals() method,
     * which checks both city name and province.
     *
     * @param city the city to add to the list
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Returns a sorted list of all cities in alphabetical order by city name.
     * The list is sorted using the City class's compareTo() method.
     *
     * @return a sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether the given city exists in the list.
     * Equality is determined by the City class's equals() method,
     * which checks both city name and province.
     *
     * @param city the city to check for in the list
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list.
     * If the city is found, it is removed from the list.
     * If the city is not found, an exception is thrown.
     * Equality is determined by the City class's equals() method,
     * which checks both city name and province.
     *
     * @param city the city to delete from the list
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Returns the total number of cities in the list.
     *
     * @return the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
