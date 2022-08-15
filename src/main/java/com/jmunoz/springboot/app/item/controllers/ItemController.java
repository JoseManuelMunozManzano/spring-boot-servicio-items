package com.jmunoz.springboot.app.item.controllers;

import com.jmunoz.springboot.app.item.models.Item;
import com.jmunoz.springboot.app.item.models.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Para probar esta app primero tenemos que arrancar la de productos, ya que items depende de productos.
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemService.findAll();
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id, cantidad);
    }
}
