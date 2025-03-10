package com.dynamo.api.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@DynamoDBTable(tableName = "User")
public class User {

    private String id;         // 🔑 **Clave Primaria Simple (PK)**
    private String tipoCuenta; // 🔑 **Parte de Clave Primaria Compuesta (SK)**
    private String nombre;     // 🏷️ **Atributo normal**
    private String email;      // 🔍 **Índice Secundario Global (GSI)**
    private int edad;         // 🔍 **Índice Secundario Local (LSI)**
    private String direccion;  // 🏷️ **Atributo normal**
    private String telefono;   // 🏷️ **Atributo normal**
}
