package io.exporting;

import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * JavaExporter.java
 *
 * This class write car parts to dat file
 */

/**
 * This class write car parts to dat file
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 * @see io.IExporter
 */
public class JavaExporter implements IExporter
{
    private PartsDatabase database;

    private static final String FILE_NAME = "/data/parts.dat";

    /**
     * instantiate a dat file exporter
     * @param database a collection of car parts
     */
    public JavaExporter(PartsDatabase database)
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
     * this method writes car parts to a dat file
     */
    public void javaFileWriter()
    {
        try
        {
            //initiate file
            File file = new File(System.getProperty("user.dir") + FILE_NAME);

            //if the directory or file does not exit, create them
            if (file.getParentFile().mkdir() || file.createNewFile());

            //use object output stream to write car parts to dat file
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

            //use for each loop to write car parts one by one to the dat file
            for (CarPart part : database.getParts())
            {
                objectOutputStream.writeObject(part);
            }

            objectOutputStream.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}