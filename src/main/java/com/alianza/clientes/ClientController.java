package com.alianza.clientes;


import com.alianza.clientes.data.entity.Client;
import com.alianza.clientes.service.IClientService;
import com.alianza.clientes.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4201")
public class ClientController {

    private static Logger logger = LoggerFactory.getLogger(ClientController.class.getName());

    @Autowired
    private IClientService clientService;

    @PostMapping()
    public ResponseEntity<?> crearCliente(@RequestBody Client client) {

        try {
            //Se crea el cliente
            Client nuevoClient = clientService.crearCliente(client);
            // Se construye el map y se devuelve la respuesta exitosa
            Map<String, Object> response = DataUtil.extractValues(nuevoClient);
            logger.info("Cliente con sharedKey: " + nuevoClient.getSharedKey());

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            logger.error("Error creando el cliente con nombre: " + client.getName());
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping()
    public ResponseEntity<?> clientes() {
        try {
            //listar clientes
            List<Client> clientes = clientService.listarClientes();

            logger.info("Se han encontrado " + clientes.size() + " clientes");

            return ResponseEntity.ok(clientes);
        } catch (NoSuchElementException e) {
            logger.error("Error obteniendo clientes");
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }


}

