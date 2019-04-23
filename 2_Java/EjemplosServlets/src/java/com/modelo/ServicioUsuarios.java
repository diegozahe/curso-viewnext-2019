/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.ArrayList;

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
    private final ArrayList<Usuario> listaUsuarios;

    public boolean addUsuario(String nom, int edad, String email, String password) {
        // Creamos el usuairo
        Usuario nuevoUsu = new Usuario(nom, edad, email, password);

        // Primero creamos el usuario (SI YA EXISTE SE MODIFICA)
        if (this.bdUsu.isAlive(nuevoUsu)) {
            this.bdUsu.update(nuevoUsu);
            for (Usuario usu : listaUsuarios) {
                if (usu.getEmail().equals(email)) {
                    listaUsuarios.remove(usu);
                    break;
                }
            }

            this.listaUsuarios.add(nuevoUsu);

        } else {
            this.bdUsu.crear(nuevoUsu);
            this.listaUsuarios.add(nuevoUsu);
        }
        return true;
    }

    public boolean deleteUsuario(Usuario user) {
        this.listaUsuarios.remove(user);
        this.bdUsu.delete(user);
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

    public boolean setUserLogged(String email){
        for (Usuario usu : listaUsuarios) {
            if (usu.getEmail().equals(email)) {
                this.userLogged = usu;
                return true;
            }
        }
        return false;
    }
    
    public Usuario getUserLogged(){
        return this.userLogged;
    }
    
    public ArrayList<Usuario> listar(){
        
        
        return this.listaUsuarios;
    }
    
    
    
}
