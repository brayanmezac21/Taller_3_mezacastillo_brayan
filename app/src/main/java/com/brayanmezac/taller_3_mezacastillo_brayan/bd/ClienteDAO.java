package com.brayanmezac.taller_3_mezacastillo_brayan.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.brayanmezac.taller_3_mezacastillo_brayan.model.Cliente;

import java.util.ArrayList;

public class ClienteDAO {
    private final static String _id="_id";
    private final static String documento="documento";
    private final static String nombre="nombre";
    private final static String direccion="direccion";
    private final static String email="email";
    private final static String celular="celular";

    public  final  static String TABLE_NAME = "cliente";

    public  final  static  String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+
            _id+"	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
            documento+"	TEXT NOT NULL,"+
            nombre+"	TEXT NOT NULL,"+
            direccion+"	TEXT NOT NULL,"+
            email+"	TEXT NOT NULL,"+
            celular+"	TEXT NOT NULL)";

    private BaseDatos baseDatos;

    public ClienteDAO(BaseDatos baseDatos) {
        this.baseDatos=baseDatos;
    }

    public ArrayList<Cliente> getClientes() {
        SQLiteDatabase db = this.baseDatos.getReadableDatabase();
        Cursor cursor =
                db.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Cliente> clientes = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                String documento = cursor.getString(cursor.getColumnIndex("documento"));
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String direccion = cursor.getString(cursor.getColumnIndex("direccion"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String celular = cursor.getString(cursor.getColumnIndex("celular"));

                Cliente c = new Cliente(_id, documento, nombre, direccion, email, celular);

                clientes.add(c);
            } while(cursor.moveToNext());

        }
        return clientes;
    }

    /*
    *  public Cliente getCliente(int id) {

        SQLiteDatabase db = this.baseDatos.getReadableDatabase();
        String sql = "select * from "+TABLE_NAME+" where _id=?";
        Cursor cursor = db.rawQuery(sql, new String[]{""+id});
        Cliente cliente = null;

        if (cursor.moveToFirst()) {

            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String documento = cursor.getString(cursor.getColumnIndex("documento"));
            String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
            String direccion = cursor.getString(cursor.getColumnIndex("direccion"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String celular = cursor.getString(cursor.getColumnIndex("celular"));

            cliente = new Cliente(_id, documento, nombre, direccion, email, celular);

        }
        return cliente;
    }

    * */

    public boolean updateCliente(Cliente c) {

        boolean flag=false;
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("documento", c.getDocumento());
        valores.put("direccion", c.getDireccion());
        valores.put("nombre", c.getNombre());
        valores.put("email", c.getEmail());
        valores.put("celular", c.getCelular());

        if (db.update(TABLE_NAME, valores, "_id=?", new String[]{""+c.get_id()})>0) {
            flag=true;
        }

        return flag;
    }

    public boolean deleteCliente(Cliente c) {
        boolean flag=false;
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        if (db.delete(TABLE_NAME, "_id=?", new String[]{""+c.get_id()})>0) {
            flag=true;
        }
        return flag;
    }

    public boolean addCliente(Cliente c) {
        boolean flag=false;
        SQLiteDatabase db = this.baseDatos.getWritableDatabase();
        //"insert into producto (_id, codigo, nombre, precio, imagen) values (NULL, '123', '123', 123, 'link.me')";
        ContentValues valores = new ContentValues();
        valores.put("documento", c.getDocumento());
        valores.put("direccion", c.getDireccion());
        valores.put("nombre", c.getNombre());
        valores.put("email", c.getEmail());
        valores.put("celular", c.getCelular());

        if (db.insert(TABLE_NAME, null, valores)>0) {
            flag=true;
        }

        return flag;
    }


}
