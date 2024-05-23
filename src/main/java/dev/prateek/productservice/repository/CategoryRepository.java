package dev.prateek.productservice.repository;

import dev.prateek.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
