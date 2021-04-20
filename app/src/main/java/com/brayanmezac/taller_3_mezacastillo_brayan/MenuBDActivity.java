package com.brayanmezac.taller_3_mezacastillo_brayan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import com.brayanmezac.taller_3_mezacastillo_brayan.bd.BaseDatos;
import com.brayanmezac.taller_3_mezacastillo_brayan.bd.ClienteDAO;
import com.brayanmezac.taller_3_mezacastillo_brayan.model.Cliente;

public class MenuBDActivity extends AppCompatActivity {

    private ClienteDAO clienteDAO;
    private boolean editar=false;
    private boolean eliminar=false;
    private Cliente c=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_b_d);
        BaseDatos baseDatos=new BaseDatos(getApplicationContext());
        clienteDAO = new ClienteDAO(baseDatos);
        actualizarLista(0);
    }

    public void ejecutar(View view) {
        if (view.getId()==R.id.button8) {
            EditText documento = findViewById(R.id.txtDocumento);
            EditText nombre = findViewById(R.id.txtNom);
            EditText direccion = findViewById(R.id.txtDireccion);
            EditText email = findViewById(R.id.txtEmail);
            EditText celular = findViewById(R.id.txtCelular);

            documento.setText("");
            nombre.setText("");
            direccion.setText("");
            email.setText("");
            celular.setText("");

            LinearLayout linear = findViewById(R.id.linear_form);
            linear.setVisibility(View.VISIBLE);
            Button guardar = findViewById(R.id.button9);
            guardar.setVisibility(Button.VISIBLE);
            view.setVisibility(View.GONE);

        } else if (view.getId()==R.id.button9) {

            EditText documento = findViewById(R.id.txtDocumento);
            EditText nombre = findViewById(R.id.txtNom);
            EditText direccion = findViewById(R.id.txtDireccion);
            EditText email = findViewById(R.id.txtEmail);
            EditText celular = findViewById(R.id.txtCelular);

            String txtDocumento = documento.getText().toString();
            String txtNom = nombre.getText().toString();
            String txtDireccion = direccion.getText().toString();
            String txtEmail = email.getText().toString();
            String txtCelular = celular.getText().toString();

            Cliente c = new Cliente(0,txtDocumento, txtNom, txtDireccion, txtEmail, txtCelular);

            if (clienteDAO.addCliente(c)) {

                documento.setText("");
                nombre.setText("");
                direccion.setText("");
                email.setText("");
                celular.setText("");

                Toast.makeText(this, "Cliente Almacenado", Toast.LENGTH_SHORT).show();
                view.setVisibility(View.GONE);
                Button nuevo = findViewById(R.id.button8);
                nuevo.setVisibility(Button.VISIBLE);
                LinearLayout linear = findViewById(R.id.linear_form);
                linear.setVisibility(View.GONE);
                actualizarLista(0);

            } else {
                Toast.makeText(this, "Error al almacenar el Cliente", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId()==R.id.button10) {
            LinearLayout linear = findViewById(R.id.linear_form);
            if (!editar) {

                linear.setVisibility(View.VISIBLE);

                EditText documento = findViewById(R.id.txtDocumento);
                EditText nombre = findViewById(R.id.txtNom);
                EditText direccion = findViewById(R.id.txtDireccion);
                EditText email = findViewById(R.id.txtEmail);
                EditText celular = findViewById(R.id.txtCelular);

                ListView lista = findViewById(R.id.lista_clientes_bd);

                c=null;
                //Toast.makeText(this, ""+lista.getCheckedItemPosition(), Toast.LENGTH_SHORT).show();
                if (lista.getCheckedItemPosition()>=0) {
                    c = (Cliente) lista.getItemAtPosition(lista.getCheckedItemPosition());

                    documento.setText(c.getDocumento());
                    nombre.setText(c.getNombre());
                    direccion.setText(c.getDireccion());
                    email.setText(c.getEmail());
                    celular.setText(c.getCelular());
                    editar=true;
                    Button btn = findViewById(R.id.button10);
                    btn.setText("Actualizar");
                } else {
                    documento.setText("");
                    nombre.setText("");
                    direccion.setText("");
                    email.setText("");
                    celular.setText("");
                    linear.setVisibility(View.GONE);
                }
            } else {
                EditText documento = findViewById(R.id.txtDocumento);
                EditText nombre = findViewById(R.id.txtNom);
                EditText direccion = findViewById(R.id.txtDireccion);
                EditText email = findViewById(R.id.txtEmail);
                EditText celular = findViewById(R.id.txtCelular);

                String txtDocumento = documento.getText().toString();
                String txtNom = nombre.getText().toString();
                String txtDireccion = direccion.getText().toString();
                String txtEmail = email.getText().toString();
                String txtCelular = celular.getText().toString();

                c.setDocumento(txtDocumento);
                c.setNombre(txtNom);
                c.setDireccion(txtDireccion);
                c.setEmail(txtEmail);
                c.setCelular(txtCelular);

                //Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
                clienteDAO.updateCliente(c);
                c=null;
                editar=false;
                Button btn = findViewById(R.id.button10);
                btn.setText("EDITAR");
                linear.setVisibility(View.GONE);
            }
        } else if (view.getId()==R.id.button11) {
            //Toast.makeText(this, "Opcion no implementada", Toast.LENGTH_SHORT).show();
            if (!eliminar) {
                actualizarLista(1);
                Button btn = findViewById(R.id.button11);
                btn.setText("BORRAR");
                eliminar=true;
            } else {
                ListView lista = findViewById(R.id.lista_clientes_bd);
                SparseBooleanArray valores = lista.getCheckedItemPositions();
                for (int i=0; i<valores.size(); i++) {
                    int pos = valores.keyAt(i);
                    if (valores.get(pos)) {
                        c = (Cliente) lista.getAdapter().getItem(pos);
                        clienteDAO.deleteCliente(c);
                        c=null;
                    }
                }
                actualizarLista(0);
                Button btn = findViewById(R.id.button11);
                btn.setText("ELIMINAR");
                eliminar=false;
            }
        }
    }

    private void actualizarLista(int vista) {
        ArrayList<Cliente> clientes = clienteDAO.getClientes();
        if (vista==0) {
            ArrayAdapter<Cliente> adapter = new ArrayAdapter<>(getApplicationContext(),
                    android.R.layout.simple_list_item_single_choice,
                    clientes);
            ListView lista = findViewById(R.id.lista_clientes_bd);
            lista.setAdapter(adapter);
            lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        } else {
            ArrayAdapter<Cliente> adapter = new ArrayAdapter<>(getApplicationContext(),
                    android.R.layout.simple_list_item_multiple_choice,
                    clientes);
            ListView lista = findViewById(R.id.lista_clientes_bd);
            lista.setAdapter(adapter);
            lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        }

    }
}