package com.jmunoz.springboot.app.item.models.service;

import com.jmunoz.springboot.app.item.models.Item;
import com.jmunoz.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        // En la url se informa el puerto y en endpoint del microservicio que queremos consurmir.
        // No se puede informar un tipo List en getForObject, pero si un arreglo que luego se transforma a List.
        //
        // PROBLEMA: MUY ACOPLADO AL NOMBRE DE LA MÁQUINA Y AL PUERTO
        // Para que sea escalable esto debe ser TRANSPARENTE
        // Esto lo veremos luego con EUREKA y SPRING CLOUD
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        // Para pasar parámetros se usa un map de Java
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }
}
