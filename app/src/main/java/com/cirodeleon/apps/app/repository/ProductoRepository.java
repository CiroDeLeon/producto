package com.cirodeleon.apps.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cirodeleon.apps.app.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
	@Query(value = "SELECT * FROM productos WHERE precio > 100", nativeQuery = true)
    List<Producto> productosCaros();
	@Query(value = "SELECT * FROM productos WHERE precio <= 100", nativeQuery = true)
    List<Producto> productosBaratos();
}
