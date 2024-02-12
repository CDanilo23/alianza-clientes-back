package com.alianza.clientes.util;

import com.alianza.clientes.data.entity.Client;

import java.util.HashMap;
import java.util.Map;


public class DataUtil {
    public static Map<String, Object> extractValues(Client client) {
        Map<String, Object> response = new HashMap<>();
        response.put("name", client.getName());
        response.put("lastName", client.getLastName());
        response.put("sharedKey", client.getSharedKey());
        response.put("email", client.getEmail());
        response.put("phone", client.getPhone());
        response.put("startDate", client.getStartDate());
        response.put("endDate", client.getEndDate());
        response.put("dataAdded", client.getDataAdded());

        return response;
    }

}
