package com.example.accesscryptdb.tools;

import com.example.accesscryptdb.Encryptor.Encryptor;
import com.example.accesscryptdb.model.DatabaseProperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesConnectionDatabase {

    private final Encryptor encryptor = new Encryptor();


    public DatabaseProperties getPropertiesConnectionDatabase() throws Exception {
        String prefix, dbSelection;

        DatabaseProperties propJdbc = new DatabaseProperties();
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream(Constants.FILE_NAME);
            properties.load(fis);
        } catch (IOException ioe) {
            throw new Exception(ioe);
        }

        try {
            dbSelection = properties.getProperty("configuration.jdbc.dbselection");
            prefix = Tools.getPrefix(dbSelection);

            propJdbc.setSchema(properties.getProperty(prefix.concat(".").concat("database")));
            propJdbc.setIp(properties.getProperty(prefix.concat(".").concat("ip")));
            propJdbc.setPort(properties.getProperty(prefix.concat(".").concat("port")));
            propJdbc.setDriver(properties.getProperty(prefix.concat(".").concat("driver")));
            propJdbc.setUser(properties.getProperty(prefix.concat(".").concat("user")));
            propJdbc.setPass(encryptor.decrypt(properties.getProperty(prefix.concat(".").concat("pass"))));

        } catch (Exception ex) {
            throw new Exception(ex);
        }

        return propJdbc;
    }

}
