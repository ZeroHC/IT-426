package io.exporting;

import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JavaExporter implements IExporter
{
    private PartsDatabase database;

    private static final String FILE_NAME = "/data/parts.dat";

    public JavaExporter(PartsDatabase database)
    {
        this.database = database;
    }

    @Override
    public boolean exportParts()
    {
        return database.getParts().isEmpty();
    }

    public void javaFileWriter()
    {
        try
        {
            File file = new File(System.getProperty("user.dir") + FILE_NAME);

            if (file.getParentFile().mkdir() || file.createNewFile());

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

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