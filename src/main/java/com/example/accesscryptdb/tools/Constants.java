package com.example.accesscryptdb.tools;

public class Constants {

    public static final String FILE_NAME = "connection.properties";
    public static final String PATH_DEFAULT = System.getProperty("user.dir");

    public static final String ORACLEXE = "0";
    public static final String MYSQL = "1";
    public static final String POSTGRES = "2";

    public static final String ORACLEXE_PORT = "1521";
    public static final String MYSQL_PORT = "3306";
    public static final String POSTGRES_PORT = "5432";

    public static final String ORACLE_PREFIX = "oracle.jdbc";
    public static final String MYSQL_PREFIX = "mysql.jdbc";
    public static final String POSTGRES_PREFIX = "postgres.jdbc";

    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String POSTGRES_DRIVER = "org.postgresql.Driver";

}
