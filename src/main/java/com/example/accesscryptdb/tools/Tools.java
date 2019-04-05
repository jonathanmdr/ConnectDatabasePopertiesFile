package com.example.accesscryptdb.tools;

public class Tools {

    public static String getPrefix(String databaseSelection) {
        switch (databaseSelection) {
            case Constants.ORACLEXE:
                return Constants.ORACLE_PREFIX;
            case Constants.MYSQL:
                return Constants.MYSQL_PREFIX;
            case Constants.POSTGRES:
                return Constants.POSTGRES_PREFIX;
            default:
                return "";
        }
    }

    public static String getDriver(String databaseSelection) {
        switch (databaseSelection) {
            case Constants.ORACLEXE:
                return Constants.ORACLE_DRIVER;
            case Constants.MYSQL:
                return Constants.MYSQL_DRIVER;
            case Constants.POSTGRES:
                return Constants.POSTGRES_DRIVER;
            default:
                return "";
        }
    }

    public static String getPort(String databaseSelection) {
        switch (databaseSelection) {
            case Constants.ORACLEXE:
                return Constants.ORACLEXE_PORT;
            case Constants.MYSQL:
                return Constants.MYSQL_PORT;
            case Constants.POSTGRES:
                return Constants.POSTGRES_PORT;
            default:
                return "";
        }
    }

}
