package io.importing;

import io.IImporter;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * XMLImporter.java
 *
 * This class reads car parts form xml file
 */

/**
 * This class reads car parts form xml file
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 * @see io.IImporter
 */
public class XMLImporter implements IImporter
{
    private static final String FILE_NAME = "/data/parts.xml";
    private static final File MY_FILE = new File(System.getProperty("user.dir") + FILE_NAME);

    /**
     * this method checks if the target file exits
     * @return if the target file exits or not
     */
    @Override
    public boolean importParts()
    {
        return MY_FILE.exists();
    }

    /**
     * this method read the car parts from the xml file
     * @return a collection of car parts
     */
    public PartsDatabase xmlFileReader()
    {
        //instantiate a database
        PartsDatabase database = new PartsDatabase();
        try
        {
            //use jaxb context and unmarshaller to read all car parts from the xml file
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            //store all the car parts to the database
            database = (PartsDatabase) unmarshaller.unmarshal(MY_FILE);
        }
        catch (JAXBException e)
        {
            System.out.println(e.getMessage());
        }

        return database;
    }
}