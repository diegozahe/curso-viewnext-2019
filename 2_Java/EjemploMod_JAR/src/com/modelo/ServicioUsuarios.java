/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.ArrayList;
import javax.sound.midi.SysexMessage;

/**
 * Esto es una simulacion de un Modelo en la estructura MVC (modelo, vista,
 * controlador)
 *
 * @author Default
 */
public class ServicioUsuarios {

    // Implementando "Singleton"
    private static ServicioUsuarios instancia = null;

    private ServicioUsuarios() {
        //listaUsuarios = new ArrayList();
        this.bdUsu = new DerbyDBUsuario();
        this.listaUsuarios = bdUsu.listar();
        this.userLogged = null;
    }

    public static ServicioUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ServicioUsuarios();
        }
        return instancia;
    }

    // Codigo de la clase
    DerbyDBUsuario bdUsu;
    Usuario userLogged;
    private ArrayList<Usuario> listaUsuarios;

    public boolean addUsuario(String nom, String edad, String email, String password) {
        try {
            if (nom.equals("") || edad.equals("") || email.equals("") || password.equals("")) {
                return false;
            } else {
                // Creamos el usuario
                int iEdad = Integer.parseInt(edad);
                Usuario nuevoUsu = new Usuario(null, nom, Integer.parseInt(edad), email, password);
                // Primero creamos el usuario (SI YA EXISTE SE MODIFICA)
                //if (!this.bdUsu.isAlive(nuevoUsu)) {
                    boolean creado = this.bdUsu.crear(nuevoUsu);
                    this.listaUsuarios = bdUsu.listar();
                    return this.listaUsuarios != null && creado;
                //}
            }
        } catch (Exception ex) {
            System.err.println(" << ERROR: No se ha podido crear el Usuario " + ex.getMessage());
        }
        return false;
    }

    public Usuario obtenerUno(String email){
        return this.bdUsu.obtenerUno(email);
    }
    
    public boolean modificarUsuario(String id, String nom, String edad, String email, String password) {
        try {
            if (id.equals("") || nom.equals("") || edad.equals("") || email.equals("") || password.equals("")) {
                return false;
            } else {
                int iEdad = Integer.parseInt(edad);
                int iId = Integer.parseInt(id);
                // Creamos el usuario
                Usuario nuevoUsu = new Usuario(iId, nom, iEdad, email, password);
                // Primero creamos el usuario (SI YA EXISTE SE MODIFICA)
                if (!this.bdUsu.isAlive(nuevoUsu)) {
                    boolean modificado = this.bdUsu.update(nuevoUsu);
                    this.listaUsuarios = bdUsu.listar();
                    return this.listaUsuarios != null && modificado;
                }
            }
        } catch (Exception ex) {
            System.err.println(" << ERROR: No se ha podido modificar el Usuario " + ex.getMessage());
        }
        return false;
    }

    public boolean updateUsuario(Usuario nuevoUsu) {
        if (this.bdUsu.isAlive(nuevoUsu)) {
            this.bdUsu.update(nuevoUsu);
            for (Usuario usu : listaUsuarios) {
                if (usu.getEmail().equals(nuevoUsu.getEmail())) {
                    listaUsuarios.remove(usu);
                    break;
                }
            }
            this.listaUsuarios.add(nuevoUsu);
        }
        return false;
    }

    public boolean validacionPasswd(String email, String passwd) {
        for (Usuario usu : listaUsuarios) {
            if (usu.getEmail().equals(email) && usu.getPassword().equals(passwd)) {
                return true;
            }
        }
        return false;
    }

    public int cantidadUsuarios() {
        return listaUsuarios.size();
    }

    public boolean deleteUsuario(String id) {
        try {
            if (id.equals("")) {
                return false;
            } else {
                Integer iId;
                for (Usuario user : listaUsuarios) {
                    iId = Integer.parseInt(id);
                    if (user.getId().equals(id)) {
                        boolean eliminado = this.listaUsuarios.remove(user);
                        this.bdUsu.delete(iId);
                        return this.listaUsuarios != null && eliminado;
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println(" << ERROR: No se ha podido eliminar el Usuario " + ex.getMessage());
            return false;
        }

        return false;
    }

    public boolean setUserLogged(String email, String passwd) {
        for (Usuario usu : listaUsuarios) {
            if (usu.getEmail().equals(email) && usu.getPassword().equals(passwd)) {
                this.userLogged = usu;
                return true;
            }
        }
        return false;
    }

    public Usuario getUserLogged() {
        return this.userLogged;
    }

    public ArrayList<Usuario> listar() {
        return this.listaUsuarios;
    }

}
