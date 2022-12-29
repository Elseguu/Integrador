package com.example.final5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstudiantesDAO {
    //metodos del crud
    public EstudiantesDAO obtenerPorID_Persona(int ID_Persona) {
        String sql = "SELECT * FROM Estudiantes1 WHERE ID_Persona="+id;

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        EstudiantesDAO estudianteFromDb = null;

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            if(rs.next()) {//si existe, hay uno solo
                // rs > sacando los datos
                int ID_Personas = rs.getInt(1);//tomar la primer columna
                String Nombre = rs.getString(2);
                String Apellido=rs.getString(3);
                int Edad=rs.getInt(4);



                //campos crear un objeto????
                estudianteFromDb = new EstudiantesDAO(ID_Personas,Nombre,Apellido,Edad);
            }
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return estudianteFromDb;
    }


    //metodos del crud
    public List<Estudiante> listarEstudiante() {
        String sql = "SELECT * FROM Estudiante ";

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        List<Estudiante> list = new ArrayList<>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            while(rs.next()) {//
                // rs > sacando los datos
                int ID_Persona = rs.getInt(1);    //tomar la primer columna
                String Nombre = rs.getString(2);
                String Apellido= rs.getString(3);
                int Edad=rs.getInt(4);

                //campos crear un objeto
                EstudiantesDAO estudianteFromDb = new estudiantes2(ID_Persona,Nombre,Apellido,Edad);

                //agrego a la lista
                list.add(estudiantes2DAOfronDb);
            }

            //cierro la conexion
            con.close();
        } catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
        }
        return list;
    }

    // crear un producto en la db
    public void crearProducto(String Nombre, Float precio, String imagen, String codigo) {

        Connection con = AdministradorDeConexiones.getConnection();

        if(con != null) {
            // insert en la db > SQL: INSERT INTO....
            String sql = "INSERT INTO Estudiante (id_persona, nombre,apellido,edad) ";
            sql += "VALUES(+precio+",	CURRENT_DATE,'"+imagen+"','"+codigo+"')";

            //control de errores
            try {
                Statement st = con.createStatement();
                st.execute(sql);

                //cierre de conexion
                con.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
