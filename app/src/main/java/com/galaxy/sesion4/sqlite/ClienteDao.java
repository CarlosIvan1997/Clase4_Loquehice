package com.galaxy.sesion4.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.galaxy.sesion4.models.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 1/10/2017.
 */

public class ClienteDao {

    private SQLiteDatabase db;
    private MySqlHelper helper;

    public ClienteDao(Context context) {
        this.helper = new MySqlHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public long insert(Cliente cliente){

        ContentValues cv = new ContentValues();
        cv.put(Cliente.NAME_FIELD, cliente.getName());
        cv.put(Cliente.LASTNAME_FIELD, cliente.getLastName());
        cv.put(Cliente.ADDRESS_FIELD, cliente.getAddress());
        cv.put(Cliente.AGE_FIELD, cliente.getAge());

        long success;
        try{
            openDb();
            success = db.insert(Cliente.TABLE_NAME, null, cv);
        }catch (SQLException ex){
            ex.printStackTrace();
            success = 0;
        }
        return success;

    }

    public long update(Cliente cliente){
        ContentValues cv = new ContentValues();
        cv.put(Cliente.NAME_FIELD, cliente.getName());
        cv.put(Cliente.LASTNAME_FIELD, cliente.getLastName());
        cv.put(Cliente.ADDRESS_FIELD, cliente.getAddress());
        cv.put(Cliente.AGE_FIELD, cliente.getAge());

        String whereClause = Cliente.ID_FIELD+"=? ";
        String whereArgs [] = {cliente.getId().toString()};

        long success;
        try{
            openDb();
            success = db.update(Cliente.TABLE_NAME, cv, whereClause,whereArgs );
        }catch (SQLException ex){
            ex.printStackTrace();
            success = 0;
        }
        return success;
    }

    public long delete(int idCliente){
        String whereClause = Cliente.ID_FIELD+"=? ";
        String whereArgs [] = {String.valueOf(idCliente)};

        long success;
        try{
            openDb();
            success = db.delete(Cliente.TABLE_NAME, whereClause, whereArgs);
        }catch (SQLException ex){
            ex.printStackTrace();
            success = 0;
        }
        return success;
    }

    public List<Cliente> getClientes(){

        List<Cliente> clientes = new ArrayList<>();

        String columns [] = {
                Cliente.ID_FIELD,
                Cliente.NAME_FIELD,
                Cliente.LASTNAME_FIELD,
                Cliente.ADDRESS_FIELD,
                Cliente.AGE_FIELD };
        openDb();
        Cursor cursor = db.query(Cliente.TABLE_NAME, columns, null, null, null, null, null);
        while (cursor.moveToNext()){
            clientes.add(convertCursorToCliente(cursor));
        }
        cursor.close();

        return clientes;
    }

    private Cliente convertCursorToCliente(Cursor cursor){
        Cliente cliente = new Cliente();
        cliente.setId(cursor.getInt(cursor.getColumnIndex(Cliente.ID_FIELD)));
        cliente.setName(cursor.getString(cursor.getColumnIndex(Cliente.NAME_FIELD)));
        cliente.setLastName(cursor.getString(cursor.getColumnIndex(Cliente.LASTNAME_FIELD)));
        cliente.setAddress(cursor.getString(cursor.getColumnIndex(Cliente.ADDRESS_FIELD)));
        cliente.setAge(cursor.getInt(cursor.getColumnIndex(Cliente.AGE_FIELD)));
        return cliente;
    }

    public void closeDb(){
        db.close();
    }

    public void openDb(){
        if(!db.isOpen()){
            this.db = helper.getWritableDatabase();
        }
    }
}
