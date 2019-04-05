package com.example.accesscryptdb.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DatabaseProperties {

    private String user;
    private String pass;
    private String driver;
    private String schema;
    private String port;
    private String ip;

}
