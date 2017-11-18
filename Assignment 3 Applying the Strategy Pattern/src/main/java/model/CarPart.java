package model;

import java.io.Serializable;

/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * CarPart.java
 *
 * This class creates a car part object
 */

/**
 * This class creates a car part object
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 */

//implement the Serializable interface for file io
public class CarPart implements Serializable
{
    private String id;
    private String manufacturer;
    private double listPrice;
    private String[] categories;

    //declare a class version id
    private static final long serialVersionUID = 42L;

    /**
     * empty constructor for easy access
     */
    public CarPart()
    {
        //do nothing - leave this method here...
    }

    /**
     * instantiate a car part object
     * @param id car part id
     * @param manufacturer car part manufacturer
     * @param listPrice car part listed price
     * @param categories car part categories
     */
    public CarPart(String id, String manufacturer, double listPrice, String[] categories)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    /**
     * this method gets the car part id
     * @return car part id
     */
    public String getId()
    {
        return id;
    }

    /**
     * this method gets the car part manufacturer
     * @return car part manufacturer
     */
    public String getManufacturer()
    {
        return manufacturer;
    }

    /**
     * this method gets the car part listed price
     * @return car part listed price
     */
    public double getListPrice()
    {
        return listPrice;
    }

    /**
     * this method gets the car part categories
     * @return car part categories
     */
    public String[] getCategories()
    {
        return categories;
    }

    /**
     * this method sets an id for the car part
     * @param id given id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * this method sets a manufacturer for the car part
     * @param manufacturer given manufacturer
     */
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    /**
     * this method sets a listed price for the car part
     * @param listPrice given listed price
     */
    public void setListPrice(double listPrice)
    {
        this.listPrice = listPrice;
    }

    /**
     * this method sets the categories for the car part
     * @param categories given categories
     */
    public void setCategories(String[] categories)
    {
        this.categories = categories;
    }
}
