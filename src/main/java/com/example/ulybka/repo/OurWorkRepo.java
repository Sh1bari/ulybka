package com.example.ulybka.repo;

import com.example.ulybka.entities.OurWork;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OurWorkRepo extends CrudRepository<OurWork, Integer> {
    @Modifying
    @Transactional
    @Query(value = "delete from OurWork b where b.id=:id")
    void deleteWork(@Param("id") Integer id);

    @Query(value = "select o.id from OurWork o")
    List<Integer> findAllIds();
}
