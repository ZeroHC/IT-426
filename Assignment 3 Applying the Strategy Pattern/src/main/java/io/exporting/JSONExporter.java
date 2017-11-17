package io.exporting;

import io.IExporter;
import model.PartsDatabase;

public class JSONExporter implements IExporter
{
    @Override
    public boolean exportParts(PartsDatabase database)
    {
        return database.getParts().isEmpty();
    }
}