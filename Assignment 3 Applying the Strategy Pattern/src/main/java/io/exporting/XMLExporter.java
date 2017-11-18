package io.exporting;

import io.IExporter;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

/*
 * Hanchen (Zero) Liu
 * 11/17/2017
 * XMLExporter.java
 *
 * This class write car parts to xml file
 */

/**
 * This class write car parts to xml file
 *
 * @author Hanchen (Zero) Liu
 * @version 1.0
 * @see io.IExporter
 */
public class XMLExporter implements IExporter
{
    private PartsDatabase database;

    private static final String FILE_NAME = "/data/parts.xml";

    /**
     * instantiate a xml file exporter
     * @param database a collection of car parts
     */
    public XMLExporter(PartsDatabase database)
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
     * this method writes car parts to a xml file
     */
    public void xmlFileWriter()
    {
        try
        {
            //initiate file
            File file = new File(System.getProperty("user.dir") + FILE_NAME);

            //if the directory or file does not exit, create them
            if (file.getParentFile().mkdir() || file.createNewFile()) ;

            try
            {
                //use jaxb context and marshaller to write all car parts to xml file
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