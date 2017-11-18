package io.importing;

import com.google.gson.Gson;
import com.google.gson.JsonStreamParser;
import com.google.gson.reflect.TypeToken;
import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * JSONImporter.java
 *
 * This class reads car parts form json file
 */

/**
 * This class reads car parts form json file
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 * @see io.IImporter
 */
public class JSONImporter implements IImporter
{
    //initiate file
    private static final String FILE_NAME = "/data/parts.json";
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
     * this method read the car parts from the json file
     * @return a collection of car parts
     */
    public PartsDatabase jsonFileReader()
    {
        //instantiate a database
        PartsDatabase database = new PartsDatabase();

        //use gson library to read from json file
        Gson gson = new Gson();

        try
        {
            //use a file reader to read through the json file
            FileReader fileReader = new FileReader(MY_FILE);

            //use json stream parser to read the json object one by one
            JsonStreamParser parser = new JsonStreamParser(fileReader);

            Type collectionType = new TypeToken<Collection<CarPart>>(){}.getType();
            Collection<CarPart> parts = new ArrayList<>();

            //store all json objects to an array list
            while (parser.hasNext())
            {
                parts = gson.fromJson(parser.next(), collectionType);
            }

            fileReader.close();

            //add all the json object as car parts, and add to the database
            for (CarPart part : parts)
            {
                database.addPart(part);
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return database;
    }
}