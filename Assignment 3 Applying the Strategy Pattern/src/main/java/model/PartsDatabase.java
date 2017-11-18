package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * PartsDatabase.java
 *
 * This class creates a database for storing car parts
 */

/**
 * This class creates a database for storing car parts
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 */
@XmlRootElement
public class PartsDatabase
{
    private Collection<CarPart> parts;

    /**
     * instantiate a database
     */
    public PartsDatabase()
    {
        parts = new ArrayList<CarPart>();
    }

    /**
     * this method add one car part to the database
     * @param part car part waiting to be added to the database
     */
    public void addPart(CarPart part)
    {
        parts.add(part);
    }

    /**
     * this method retrieves all the car parts from the database
     *
     * @return a collection of car parts
     */
    @XmlElement
    public Collection<CarPart> getParts()
    {
        return Collections.unmodifiableCollection(parts);
    }

    /**
     * this method clears out the entire database
     */
    public void clear()
    {
        parts.clear();
    }
}