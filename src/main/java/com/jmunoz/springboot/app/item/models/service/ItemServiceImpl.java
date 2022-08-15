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
        // En la url se informa el nombre del microservicio productos y no se informa el puerto
        // Es decir, desacoplamos el nombre de la máquina y el puerto
        List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        // Para pasar parámetros se usa un map de Java
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }
}
