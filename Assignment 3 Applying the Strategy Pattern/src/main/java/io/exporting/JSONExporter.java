package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.IExporter;
import model.PartsDatabase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * JSONExporter.java
 *
 * This class write car parts to json file
 */

/**
 * This class write car parts to json file
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 * @see io.IExporter
 */
public class JSONExporter implements IExporter
{
    private PartsDatabase database;

    private static final String FILE_NAME = "/data/parts.json";

    /**
     * instantiate a json file exporter
     * @param database a collection of car parts
     */
    public JSONExporter(PartsDatabase database)
    {
        this.database = database;
    }

    /**
     * this method checks if the collection is empty
     * @return if the collection is empty or not
     */
    @Override
    public boolean exportParts()
    {
        return database.getParts().isEmpty();
    }

    /**
     * this method writes car parts to a json file
     */
    public void jsonFileWriter()
    {
        //prints using new line characters
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try
        {
            //initiate file
            File file = new File(System.getProperty("user.dir") + FILE_NAME);

            //if the directory or file does not exit, create them
            if (file.getParentFile().mkdir() || file.createNewFile());

            //use file writer to write car parts to json file
            FileWriter fileWriter = new FileWriter(file);

            //declare the top level of the json file
            fileWriter.append("[");

            //write car parts one by one to the json file
            for (int i = 0; i < database.getParts().size(); i++)
            {
                gson.toJson(database.getParts().toArray()[i], fileWriter);
                if (i != database.getParts().size() - 1)
                {
                    //separate each car part with a comma
                    fileWriter.append(",");
                }
            }

            //end the json file
            fileWriter.append("]");

            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}