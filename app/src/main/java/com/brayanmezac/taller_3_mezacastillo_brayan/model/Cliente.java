package com.brayanmezac.taller_3_mezacastillo_brayan.model;

import com.brayanmezac.taller_3_mezacastillo_brayan.bd.BaseDatos;

public class Cliente {
    private int _id;
    private  String documento;
    private  String nombre;
    private  String direccion;
    private  String email;
    private  String celular;

    public Cliente( String documento, String nombre, String direccion, String email, String celular) {
        this.documento = documento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
    }

    public Cliente(int _id, String documento, String nombre, String direccion, String email, String celular) {
        this._id = _id;
        this.documento = documento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
    }




    public int get_id() {
        return this._id;
    }

    public void set_id(final int _id) {
        this._id = _id;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(final String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(final String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                "\n- id= " + _id +
                "\n- documento= " + documento +
                "\n- nombre= " + nombre +
                "\n- direccion= " + direccion +
                "\n- email= " + email +
                "\n- celular= " + celular;
    }
}
