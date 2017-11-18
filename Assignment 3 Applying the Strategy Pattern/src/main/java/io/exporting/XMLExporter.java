package io.exporting;

import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class XMLExporter implements IExporter
{
    private PartsDatabase database;

    private static final String FILE_NAME = "/data/parts.xml";

    public XMLExporter(PartsDatabase database)
    {
        this.database = database;
    }

    @Override
    public boolean exportParts()
    {
        return database.getParts().isEmpty();
    }

    public void xmlFileWriter()
    {
        try
        {
            File file = new File(System.getProperty("user.dir") + FILE_NAME);

            if (file.getParentFile().mkdir() || file.createNewFile()) ;

            try
            {
                JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);

                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                marshaller.marshal(database, file);
            }
            catch (JAXBException e)
            {
                System.out.println(e.getMessage());
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}