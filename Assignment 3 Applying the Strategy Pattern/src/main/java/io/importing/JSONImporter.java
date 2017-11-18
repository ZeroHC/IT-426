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

public class JSONImporter implements IImporter
{
    private static final String FILE_NAME = "/data/parts.json";
    private static final File MY_FILE = new File(System.getProperty("user.dir") + FILE_NAME);

    @Override
    public boolean importParts()
    {
        return MY_FILE.exists();
    }

    public PartsDatabase jsonFileReader()
    {
        PartsDatabase database = new PartsDatabase();

        Gson gson = new Gson();

        try
        {
            FileReader fileReader = new FileReader(MY_FILE);

            JsonStreamParser parser = new JsonStreamParser(fileReader);

            Type collectionType = new TypeToken<Collection<CarPart>>(){}.getType();
            Collection<CarPart> parts = new ArrayList<>();

            while (parser.hasNext())
            {
                parts = gson.fromJson(parser.next(), collectionType);
            }

            fileReader.close();

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