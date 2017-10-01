package com.galaxy.sesion4.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.galaxy.sesion4.models.Cliente;

/**
 * Created by Alumno on 1/10/2017.
 */

public class MySqlHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "my_db.db";
    private static final int DB_VERSION = 1;

    private StringBuilder sbCreateTableCliente = new StringBuilder()
            .append("CREATE TABLE "+ Cliente.TABLE_NAME+" ( ")
            .append(Cliente.ID_FIELD+" INTEGER primary key autoincrement, ")
            .append(Cliente.NAME_FIELD+" name TEXT, ")
            .append(Cliente.LASTNAME_FIELD+" name TEXT, ")
            .append(Cliente.ADDRESS_FIELD+" name TEXT, ")
            .append(Cliente.AGE_FIELD+" name TEXT)");

    public MySqlHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sbCreateTableCliente.toString());
    }

    @Override public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
