package dev.prateek.productservice.inheritanceDemo.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    <S extends Mentor> S save(S entity);

}
