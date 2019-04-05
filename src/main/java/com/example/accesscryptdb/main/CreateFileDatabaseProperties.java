package com.example.accesscryptdb.main;

import com.example.accesscryptdb.Encryptor.Encryptor;
import com.example.accesscryptdb.model.DatabaseProperties;
import com.example.accesscryptdb.tools.Constants;
import com.example.accesscryptdb.tools.Tools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class CreateFileDatabaseProperties {

    private final Encryptor encriptor;
    private final DatabaseProperties dbProp;
    private final Properties prop;
    private final Scanner scanner;


    public CreateFileDatabaseProperties() {
         encriptor = new Encryptor();
         dbProp = new DatabaseProperties();
         prop = new Properties();
         scanner = new Scanner(System.in);
    }

    private void generateFilePropertiesConnection() throws Exception {
        String prefix, databaseSelection;

        File file = new File(Constants.PATH_DEFAULT.concat("/").concat(Constants.FILE_NAME));
        FileOutputStream out;

        System.out.printf("Informe para qual DB deseja criar o arquivo:\n"
                + "0 - Oracle\n"
                + "1 - MySQL\n"
                + "2 - PostgreSQL\n");
        databaseSelection = scanner.nextLine();

        System.out.printf("Informe o nome do Schema:\n");
        String schema = scanner.nextLine();

        System.out.printf("Informe o IP da conexão:\n");
        String ip = scanner.nextLine();

        System.out.printf("Informe o Usuário da conexão:\n");
        String user = scanner.nextLine();

        System.out.printf("Informe a Senha da conexão:\n");
        String pass = encriptor.encrypt(scanner.nextLine());

        prefix = Tools.getPrefix(databaseSelection);

        prop.setProperty("configuration.jdbc.dbselection", databaseSelection);
        prop.setProperty(prefix.concat(".").concat("database"), schema);
        prop.setProperty(prefix.concat(".").concat("driver"), Tools.getDriver(databaseSelection));
        prop.setProperty(prefix.concat(".").concat("ip"), ip);
        prop.setProperty(prefix.concat(".").concat("port"), Tools.getPort(databaseSelection));
        prop.setProperty(prefix.concat(".").concat("user"), user);
        prop.setProperty(prefix.concat(".").concat("pass"), pass);

        try {
            out = new FileOutputStream(file);
            prop.store(out, "Arquivo de configuração de propriedades para conexão JDBC.");
            System.out.printf("Arquivo criado com sucesso em: ".concat(file.getAbsolutePath()));
        } catch(IOException ex) {
            throw new Exception(ex);
        }
    }

    public static void main(String ... args) {
        CreateFileDatabaseProperties createFileDatabaseProperties = new CreateFileDatabaseProperties();

        try {
            createFileDatabaseProperties.generateFilePropertiesConnection();
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }
    }

}
