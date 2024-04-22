package com.cirodeleon.apps.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.cirodeleon.apps.app.entity.Producto;
import com.cirodeleon.apps.app.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Producto addProducto(@RequestBody @Valid Producto producto) {
        return service.saveProducto(producto);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Producto> getAllProductos() {
        return service.getAllProductos();
    }
    @Operation(summary = "Obtener productos caros", description = "Devuelve todos los productos con un precio mayor a 100")
    @GetMapping(path = "/caros", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Producto> getProductosCaros() {
        return service.getProductosCaros();
    }
    @Operation(summary = "Obtener productos baratos", description = "Devuelve todos los productos con un precio menor o igual a 100")    
    @GetMapping(path = "/baratos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Producto> getProductosBaratos() {
        return service.getProductosBaratos();
    }


    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Producto getProductoById(@PathVariable Long id) {
        return service.getProductoById(id);
    }

    @PutMapping(path = "/{id}",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Producto updateProducto(@RequestBody @Valid  Producto producto, @PathVariable Long id) {
        Producto existingProducto = service.getProductoById(id);
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setDescripcion(producto.getDescripcion());
        existingProducto.setPrecio(producto.getPrecio());
        return service.saveProducto(existingProducto);
    }

    @DeleteMapping(path = "/{id}",
                   produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String deleteProducto(@PathVariable Long id) {
        service.deleteProducto(id);
        return "Producto eliminado con éxito!";
    }
}

