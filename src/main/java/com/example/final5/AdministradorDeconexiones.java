package com.example.final5;

import java.sql.DriverManager;
import java.sql.Connection;

public class AdministradorDeconexiones {

    AdministradorDeconexiones conexion = DriverManager.getConnection ("jdbc:mysql://127.0.0.1/estudiantes","root", "");
}
