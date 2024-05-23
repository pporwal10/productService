package dev.prateek.productservice.repository;

import dev.prateek.productservice.model.Product;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   List<Product> findAllByCategory_Name(String name);
}
