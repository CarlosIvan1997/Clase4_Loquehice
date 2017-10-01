package poclin.carlos.sesion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import poclin.carlos.sesion4.dao.ClienteDao;
import poclin.carlos.sesion4.models.Cliente;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClienteDao clienteDao = new ClienteDao(this);

        long result_insertar = clienteDao.insertarCliente(new Cliente("Carlos", "Poclin", "carlos@gmail.com", 20));

        if(result_insertar>0){
            Log.v(TAG,"SE INSERTO CORRECTAMENTE");
        }

        clienteDao.obtenerUsuarios();
    }
}
