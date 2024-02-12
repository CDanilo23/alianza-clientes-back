package com.alianza.clientes.service;

import com.alianza.clientes.data.repository.ClientRepository;
import com.alianza.clientes.data.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ClientService implements IClientService {

    private static Logger logger = LoggerFactory.getLogger(ClientService.class.getName());

    @Autowired
    private ClientRepository clientRepository;

    public Client crearCliente(Client client) {
        client.setSharedKey(createSharedKey(client));
        client.setDataAdded(LocalDate.now());
        Client newClient = clientRepository.save(client);
        logger.info("Se ha creado el cliente con el sharedKey: '" + newClient.getSharedKey()
                + "' de manera exitosa");
        return newClient;
    }

    private String createSharedKey(Client client) {
       return client.getName().substring(0,1).toLowerCase() + client.getLastName().toLowerCase();
    }

    @Override
    public List<Client> listarClientes() {
        //DataUtil.mapClientToDto(clientRepository.findAll());
       return clientRepository.findAll();
    }

}
