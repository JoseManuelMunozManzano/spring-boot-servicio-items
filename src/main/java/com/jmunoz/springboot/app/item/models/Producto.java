package com.jmunoz.springboot.app.item.models;

import java.util.Date;

// Mediante API REST obtenemos esta estructura JSON y la convertimos a este objeto Producto.
// Producto tiene la misma estructura que tenemos en el microservicio de productos.
// PERO NO ES UN ENTITY PORQUE NO ESTÁ MAPEADO A NINGUNA TABLA.
// Es un objeto en el que vamos a poblar datos del JSON.
//
// Para evitar replicar clases, se podría crear otro microservicio que tuviera todas las clases en común para así
// poder reutilizarlas. Por ejemplo: springboot-servicio-commons
public class Producto {
    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;
    private Integer port;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
