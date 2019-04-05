package com.example.accesscryptdb.main;

import com.example.accesscryptdb.model.DatabaseProperties;
import com.example.accesscryptdb.tools.ReadPropertiesConnectionDatabase;

public class Main {

    private ReadPropertiesConnectionDatabase readableProperties;
    private DatabaseProperties databaseProperties;

    public Main() {
        readableProperties = new ReadPropertiesConnectionDatabase();
        databaseProperties = new DatabaseProperties();
    }

    private void readFileProperties() {
        try {
            databaseProperties = readableProperties.getPropertiesConnectionDatabase();
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
    }

    private void printFileProperties() {
        System.out.println(databaseProperties);
    }

    public static void main(String ... args) {
        Main main = new Main();

        main.readFileProperties();
        main.printFileProperties();
    }

}
