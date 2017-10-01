package poclin.carlos.sesion4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import poclin.carlos.sesion4.models.Cliente;

/**
 * Created by Alumno on 1/10/2017.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String NAME_DB = "mydb.db";
    public static final int VERSION_DB = 2;

    private static StringBuilder sbCreateTableClienteSQL = new StringBuilder()
            .append("CREATE TABLE " + Cliente.TABLE_NAME + " ( ")
            .append(Cliente.ID_FIELD + " INTEGER PRIMARY KEY AUTOINCREMENT, ")
            .append(Cliente.NAME_FIELD + " TEXT, ")
            .append(Cliente.LASTNAME_FIELD + " TEXT, ")
            .append(Cliente.ADDRESS_FIELD + " TEXT, ")
            .append(Cliente.AGE_FIELD + " INTEGER )");

    public MySQLiteOpenHelper(Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sbCreateTableClienteSQL.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
