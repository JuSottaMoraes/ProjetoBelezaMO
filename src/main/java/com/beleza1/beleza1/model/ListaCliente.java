package com.beleza1.beleza1.model;

import com.beleza1.beleza1.model.Entity.ClienteEntity;
import java.util.ArrayList;

public class ListaCliente {

    private static ArrayList<ClienteEntity> lista = new ArrayList<ClienteEntity>();

    public static void adicionar(ClienteEntity cliente) {
        lista.add(cliente);

    }

    public static ArrayList<ClienteEntity> getLista() {
        return lista;
    }


}
