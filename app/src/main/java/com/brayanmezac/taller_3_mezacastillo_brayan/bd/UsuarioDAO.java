package com.brayanmezac.taller_3_mezacastillo_brayan.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.brayanmezac.taller_3_mezacastillo_brayan.model.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {
    /*
    private final static String usuario="usuario";

    private  final  static  String id="id";
    private  final  static  String password="password";
    private  final  static  String user="user;";

    Context c;
    Usuario u;
    ArrayList<Usuario>lista;
    SQLiteDatabase sql;
    String bd = "BDUsuario";

    public final static String CREATE_TABLE="CREATE TABLE "+usuario+"("+
            id+"INTEGER NOT NULL," +
            password+"TEXT," +
            user+"TEXT," +
            "PRIMARY KEY AUTOINCREMENT("+id+")" +
            ");";

    private BaseDatos baseDatos;

    public UsuarioDAO(Context c){
        this.c = c;
        sql =c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(CREATE_TABLE);
        u=new Usuario();
    }

    public UsuarioDAO(BaseDatos baseDatos) {
        this.baseDatos=baseDatos;
    }*/
/*
    public boolean insertarUsuario(Usuario u){
        if (0 == buscar(u.getUser())){
            ContentValues cv = new ContentValues();
            cv.put(user,u.getUser());
            cv.put(password,u.getPassword());
            return (sql.insert("usuario",null,cv)>0);
        }else {
            return  false;
        }
    }

    public boolean buscar(String u){
        int x = 0;
        lista=selecUsuarios();
        for(Usuario us:lista){
            if(us.getUser().equals(u)){
                x++;
            }
        }
        return x;
    }
    public ArrayList<Usuario> getUser() {
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFrist()){
            do{
                Usuario u=new Usuario();
                u.setId(cr.getInt(0));
                u.getUser(cr.getString(1));
                u.getPassword(cr.getString(1));
                lista.add(u);
            }while(cr.moveToNext());
        }
    }

 */
}

