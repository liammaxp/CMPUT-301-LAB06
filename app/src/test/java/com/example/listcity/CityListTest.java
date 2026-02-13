package com.example.listcity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City edmonton = mockCity();
        City regina = new City("Regina", "Saskatchewan");
        assertTrue(cityList.hasCity(edmonton));
        assertFalse(cityList.hasCity(regina));
        cityList.add(regina);
        assertTrue(cityList.hasCity(regina));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        City edmonton = mockCity();
        assertTrue(cityList.hasCity(edmonton));
        cityList.delete(edmonton);
        assertFalse(cityList.hasCity(edmonton));
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City regina = new City("Regina", "Saskatchewan");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(regina);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
        cityList.add(new City("Charlottetown", "Prince Edward Island"));
        assertEquals(3, cityList.countCities());
    }
}
