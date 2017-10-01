package poclin.carlos.sesion4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import poclin.carlos.sesion4.MySQLiteOpenHelper;
import poclin.carlos.sesion4.models.Cliente;

/**
 * Created by Alumno on 1/10/2017.
 */

public class ClienteDao {

    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public ClienteDao(Context context){
        this.mySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        this.sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
    }

    public long insertarCliente (Cliente cliente){
        ContentValues valores = new ContentValues();
        valores.put(Cliente.NAME_FIELD,cliente.getName());
        valores.put(Cliente.LASTNAME_FIELD,cliente.getLastname());
        valores.put(Cliente.ADDRESS_FIELD,cliente.getAddress());
        valores.put(Cliente.AGE_FIELD,cliente.getAge());

        long result;

        try {
            openDB();
            result = sqLiteDatabase.insert(Cliente.TABLE_NAME,null,valores);
        } catch (SQLException e){
            result = 0;
        }

        return result;
    }

    public int actualizarCliente (Cliente cliente){
        ContentValues valores = new ContentValues();
        valores.put(Cliente.NAME_FIELD,cliente.getName());
        valores.put(Cliente.LASTNAME_FIELD,cliente.getLastname());
        valores.put(Cliente.ADDRESS_FIELD,cliente.getAddress());
        valores.put(Cliente.AGE_FIELD,cliente.getAge());

        String whereClause = Cliente.ID_FIELD + "=?";
        String [] whereArgs = { cliente.getId().toString() };

        int result = sqLiteDatabase.update(Cliente.TABLE_NAME,valores,whereClause,whereArgs);

        return result;

    }

    public int eliminarUsuario(int id){

        String whereClause = Cliente.ID_FIELD + "=?";
        String [] whereArgs = { String.valueOf(id) };

        int result;

        try {
            openDB();
            result = sqLiteDatabase.delete(Cliente.TABLE_NAME,whereClause,whereArgs);
        }catch (SQLException e){
            result=0;
        }
        return result;
    }

    public List<Cliente> obtenerUsuarios(){

        String [] fields = {Cliente.ID_FIELD,
                Cliente.NAME_FIELD,
                Cliente.LASTNAME_FIELD,
                Cliente.ADDRESS_FIELD,
                Cliente.AGE_FIELD};

        Cursor cursor = sqLiteDatabase.query(Cliente.TABLE_NAME, fields, null, null, null, null, null);

        return convertCursorToList(cursor);
    }

    private List<Cliente> convertCursorToList (Cursor mCursor){

        List<Cliente> arrList = new ArrayList<>();

        if(mCursor.moveToFirst()){
            do{
                Cliente model = new Cliente();

                model.setId(mCursor.getInt((mCursor.getColumnIndex(Cliente.ID_FIELD))));
                model.setName(mCursor.getString((mCursor.getColumnIndex(Cliente.NAME_FIELD))));
                model.setLastname(mCursor.getString((mCursor.getColumnIndex(Cliente.LASTNAME_FIELD))));
                model.setAddress(mCursor.getString((mCursor.getColumnIndex(Cliente.ADDRESS_FIELD))));
                model.setAge(mCursor.getInt((mCursor.getColumnIndex(Cliente.AGE_FIELD))));

                arrList.add(model);
            }while (mCursor.moveToNext());
        }
        return arrList;
    }

    private void openDB(){
        if(!sqLiteDatabase.isOpen()){
            this.sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();
        }
    }

    private void closeDB(){
        sqLiteDatabase.close();
    }

}
