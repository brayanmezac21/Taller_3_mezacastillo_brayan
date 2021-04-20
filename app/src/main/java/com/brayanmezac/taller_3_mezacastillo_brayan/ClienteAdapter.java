package com.brayanmezac.taller_3_mezacastillo_brayan;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import com.brayanmezac.taller_3_mezacastillo_brayan.model.Cliente;

public class ClienteAdapter extends BaseAdapter{
    private ArrayList<Cliente> clientes;
    private Context context;

    public ClienteAdapter(Context context, ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return clientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null) {
            view = LayoutInflater.from(context).inflate(R.layout.vista_cliente, null);
        }
        TextView lb_id = view.findViewById(R.id.lb_id);
        TextView lb_documento = view.findViewById(R.id.lb_documento);
        TextView lb_nombre = view.findViewById(R.id.lb_nombre);
        TextView lb_direccion = view.findViewById(R.id.lb_direccion);
        TextView lb_email = view.findViewById(R.id.lb_email);
        TextView lb_celular = view.findViewById(R.id.lb_celular);

        Cliente cliente = (Cliente) getItem(i);
        lb_id.setText("$"+cliente.get_id());
        lb_documento.setText(cliente.getDocumento());
        lb_nombre.setText(cliente.getNombre());
        lb_direccion.setText(cliente.getDireccion());
        lb_email.setText(cliente.getEmail());
        lb_celular.setText(cliente.getCelular());


        //Picasso.get().load(producto.getImagen()).resize(150,150).into(imagen);

        return view;
    }

}
