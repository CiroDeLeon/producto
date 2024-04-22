package com.cirodeleon.apps.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cirodeleon.apps.app.entity.Producto;
import com.cirodeleon.apps.app.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public Producto saveProducto(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> getAllProductos() {
        return repository.findAll();
    }

    public Producto getProductoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteProducto(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> getProductosCaros() {
        return repository.productosCaros();
    }
    
    public List<Producto> getProductosBaratos() {
        return repository.productosBaratos();
    }
}
