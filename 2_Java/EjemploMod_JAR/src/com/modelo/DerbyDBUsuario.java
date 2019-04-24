/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Default
 */
public class DerbyDBUsuario {

    public DerbyDBUsuario() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception e) {
            Logger.getLogger(DerbyDBUsuario.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Usuario obtenerUno(String email) {
        try (Connection con = DriverManager.getConnection(
                Constantes.CONEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {
            String consultaSQL = "SELECT id, nombre, edad, email, password "
                    + " FROM Usuario WHERE email='"+ email + "'";
            Statement sentencia = con.createStatement();
            //sentencia.setString(1, email);
            ResultSet res = sentencia.executeQuery(consultaSQL);
            Usuario usu = null;
            if (res.next()) {
                Integer id = res.getInt("id");
                String nom = res.getString("nombre");
                Integer edad = res.getInt("edad");
                String password = res.getString("password");
                usu = new Usuario(id, nom, edad, email, password);
            }
            return usu;
        } catch (SQLException ex) {
            System.err.println(" >>>>  " + ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Usuario> listar() {
        try (Connection con = DriverManager.getConnection(Constantes.CONEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {
            ArrayList<Usuario> listaUsu = new ArrayList<>();
            String consultaSQL = "SELECT id, nombre, edad, email, password FROM Usuario"; //consulta que hacemos a la bd
            Statement sentencia = con.createStatement(); // creamos primero la sentencia
            ResultSet res = sentencia.executeQuery(consultaSQL); // ahora hacemos la consulta
            while (res.next()) {
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                String email = res.getString("email");
                String password = res.getString("password");
                int edad = res.getInt("edad");
                Usuario usu = new Usuario(id, nombre, edad, email, password);
                listaUsu.add(usu);
            }

            // Si todo funciona:
            return listaUsu;

        } catch (SQLException ex) {
            System.err.println(" >>>>>> " + ex.getMessage());
            return null;
        }
    }

    public boolean crear(Usuario user) {
        try (Connection con = DriverManager.getConnection(Constantes.CONEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {
            // Primero comprobamos si existe el usuario
            if (!isAlive(user)) {
                // Codigo nuevo adaptado a la clase "CONSTANTES"
                Statement sentencia = con.createStatement();
                String querySQL = "INSERT INTO USUARIO (NOMBRE, EDAD, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
                PreparedStatement st = con.prepareStatement(querySQL);
                st.setString(1, user.getNombre());
                st.setInt(2, user.getEdad());
                st.setString(3, user.getEmail());
                st.setString(4, user.getPassword());
                st.executeUpdate();

                // Codigo viejo PRE-CONSTANTES
                /*String sqlID = "SELECT COUNT(id) as ultId FROM Usuario";
                Statement sentencia = con.createStatement(); // creamos primero la sentencia
                ResultSet res = sentencia.executeQuery(sqlID); // ahora hacemos la consulta
                String sqlInsert = "INSERT INTO usuario (nombre, email, password, edad) VALUES('"
                        + user.getNombre() + "' , '"
                        + user.getEmail() + "', '"
                        + user.getPassword() + "',"
                        + user.getEdad() + " )";*/
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(" >>>>>> " + ex.getMessage());
        }
        return false;
    }

    public boolean delete(int id) {
        try (Connection con = DriverManager.getConnection(Constantes.CONEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {
            String sqlID = "DELETE FROM Usuario WHERE id=?";
            PreparedStatement st = con.prepareStatement(sqlID);
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println(" >>>>  " + ex.getMessage());
            return false;
        }
    }
    
    public boolean update(Usuario user) {
        try (Connection con = DriverManager.getConnection(Constantes.CONEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {
            // Actualizamos los datos
            String querySQL = "UPDATE USUARIO SET NOMBRE=?, EDAD=?, EMAIL=?, PASSWORD=? WHERE id=?";
            PreparedStatement st = con.prepareStatement(querySQL);
            st.setString(1, user.getNombre());
            st.setInt(2, user.getEdad());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, user.getId());
            st.executeUpdate();

            /*Codigo viejo*/
 /*
            String sqlID = "UPDATE Usuario SET nombre = '" + user.getNombre()
                    + "', email = '" + user.getEmail()
                    + "', edad = " + user.getEdad()
                    + ", password = '" + user.getPassword()
                    + "' WHERE email='" + user.getEmail() + "' ";
            Statement sentencia = con.createStatement(); // creamos primero la sentencia
            sentencia.executeUpdate(sqlID); // ahora hacemos la consulta
             */
            return true;
        } catch (SQLException ex) {
            System.err.println(" >>>>>> " + ex.getMessage());
        }

        return false;
    }

    public boolean isAlive(Usuario user) {
        try (Connection con = DriverManager.getConnection(Constantes.CONEX_DB, Constantes.USUARIO_DB, Constantes.PASSWORD_DB)) {
            // Buscamos si existe
            String consultaSQL = "SELECT id, nombre, edad, email, password FROM Usuario WHERE email='"+user.getEmail()+"'";
            Statement sentencia = con.createStatement(); // creamos primero la sentencia
            ResultSet res = sentencia.executeQuery(consultaSQL); // ahora hacemos la consulta
            int id = -1;
            String nombre = "";
            String email = "";
            String password = "";
            while (res.next()) {
                id = res.getInt("id");
                nombre = res.getString("nombre");
                email = res.getString("email");
                password = res.getString("password");
            }
            
            if (id > 0 && email.equals(user.getEmail())) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(" >>>>>> " + ex.getMessage());
        }
        return false;
    }

}
