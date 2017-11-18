package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.*;

public class JavaImporter implements IImporter
{
    private static final String FILE_NAME = "/data/parts.dat";
    private static final File MY_FILE = new File(System.getProperty("user.dir") + FILE_NAME);

    @Override
    public boolean importParts()
    {
        return MY_FILE.exists();
    }

    public PartsDatabase javaFileReader()
    {
        PartsDatabase database = new PartsDatabase();

        try
        {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(MY_FILE));

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