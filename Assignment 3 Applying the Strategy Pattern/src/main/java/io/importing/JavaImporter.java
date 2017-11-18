package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.*;

/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * JavaImporter.java
 *
 * This class reads car parts form dat file
 */

/**
 * This class reads car parts form dat file
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 * @see io.IImporter
 */
public class JavaImporter implements IImporter
{
    //initiate file
    private static final String FILE_NAME = "/data/parts.dat";
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
     * this method read the car parts from the dat file
     * @return a collection of car parts
     */
    public PartsDatabase javaFileReader()
    {
        //instantiate a database
        PartsDatabase database = new PartsDatabase();

        try
        {
            //use object input stream to read all the car parts from the dat file
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(MY_FILE));

            //add the car parts one by one to the database
            while (true)
            {
                try
                {
                    database.addPart((CarPart) objectInputStream.readObject());
                }
                catch (EOFException | ClassNotFoundException e)
                {
                    break;
                }
            }

            objectInputStream.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return database;
    }
}