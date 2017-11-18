package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONExporter implements IExporter
{
    private PartsDatabase database;

    private static final String FILE_NAME = "/data/parts.json";

    public JSONExporter(PartsDatabase database)
    {
        this.database = database;
    }

    @Override
    public boolean exportParts()
    {
        return database.getParts().isEmpty();
    }

    public void jsonFileWriter()
    {
        //prints using new line characters
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try
        {
            File file = new File(System.getProperty("user.dir") + FILE_NAME);

            if (file.getParentFile().mkdir() || file.createNewFile());

            FileWriter fileWriter = new FileWriter(file);

            fileWriter.append("[");

            for (int i = 0; i < database.getParts().size(); i++)
            {
                gson.toJson(database.getParts().toArray()[i], fileWriter);
                if (i != database.getParts().size() - 1)
                {
                    fileWriter.append(",");
                }
            }

            fileWriter.append("]");

            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}