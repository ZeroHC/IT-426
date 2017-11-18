package io.importing;

import io.IImporter;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLImporter implements IImporter
{
    private static final String FILE_NAME = "/data/parts.xml";
    private static final File MY_FILE = new File(System.getProperty("user.dir") + FILE_NAME);

    @Override
    public boolean importParts()
    {
        return MY_FILE.exists();
    }

    public PartsDatabase xmlFileReader()
    {
        PartsDatabase database = new PartsDatabase();
        try
        {
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            database = (PartsDatabase) unmarshaller.unmarshal(MY_FILE);
        }
        catch (JAXBException e)
        {
            System.out.println(e.getMessage());
        }

        return database;
    }
}