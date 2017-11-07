package singleton;

import java.util.HashMap;
import java.util.Map;

public class DBConnection3
{
    private static final int PORT = 2020;
    private String user;
    private String pass;
    private String host;
    private int port;
    private String dbName;
    private DBType dbType;

    //static singleton
    private static Map<DBType, DBConnection3> instances = new HashMap<>();

    //stop instantiation outside of this class..
    private DBConnection3(String user, String pass, String host, int port, String dbName, DBType dbType)
    {
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbType = dbType;
    }

    public static DBConnection3 getInstance(DBType dbType)
    {
        if (!instances.containsKey(dbType))
        {
            instances.put(dbType, new DBConnection3("hliu", "password!?", "hliu.greenrivertech.net",
                    PORT, "movie", dbType));
        }

        return instances.get(dbType);
    }

    public boolean connect()
    {
        //do something
        return false;
    }

    @Override
    public String toString()
    {
        return "DBConnection{"
                + "user='" + user + '\''
                + ", pass='" + pass + '\''
                + ", host='" + host + '\''
                + ", port=" + port
                + ", dbName='" + dbName + '\''
                + ", dbType='" + dbType + '\''
                + '}';
    }
}
