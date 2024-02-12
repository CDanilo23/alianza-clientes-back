package com.alianza.clientes.service;

import com.alianza.clientes.data.entity.Client;


import java.util.List;

public interface IClientService {
    Client crearCliente(Client prestamo);

    List<Client> listarClientes();
}
