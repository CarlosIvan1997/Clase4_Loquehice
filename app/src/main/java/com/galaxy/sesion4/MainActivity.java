package com.galaxy.sesion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.galaxy.sesion4.models.Cliente;
import com.galaxy.sesion4.sqlite.ClienteDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cliente> clientes = null;

        ClienteDao clienteDao = new ClienteDao(this);

        //REGISTRANDO UN CLIENTE
        Cliente cliente1 = new Cliente();
        cliente1.setName("Marco");
        cliente1.setLastName("Estrella");
        cliente1.setAddress("AV. AVV");
        cliente1.setAge(26);

        long success = clienteDao.insert(cliente1);
        if(success>0)
            Log.i(TAG, "el cliente se registro correctamente");
        else
            Log.i(TAG, "error al registrar el cliente");

        //VERIFICAR SI REGISTRÓ

        clientes = clienteDao.getClientes();
        for(Cliente c : clientes){
            Log.i(TAG, c.toString());
        }

        //ACTUALIZANDO EL REGISTRO
        cliente1.setId(1);
        cliente1.setName("Julio");
        cliente1.setLastName("GONZALES ");
        cliente1.setAddress("AV. AVV");
        cliente1.setAge(25);

        long successUpdate = clienteDao.update(cliente1);
        if(successUpdate>0)
            Log.i(TAG, "el cliente se actualizó correctamente");
        else
            Log.i(TAG, "error al actualizar el cliente");

        //VERIFICAR SI ACTUALIZÓ

        clientes = clienteDao.getClientes();
        for(Cliente c : clientes){
            Log.i(TAG, c.toString());
        }

        long successDelete = clienteDao.delete(1);
        if(successDelete>0)
            Log.i(TAG, "el cliente se eliminó correctamente");
        else
            Log.i(TAG, "error al eliminar el cliente");

        //VERIFICAR SI ELIMINÓ
        clientes = clienteDao.getClientes();
        if(clientes.size()>0){
            for(Cliente c : clientes){
                Log.i(TAG, c.toString());
            }
        }else{
            Log.e(TAG, "no hay clientes");
        }
    }
}
