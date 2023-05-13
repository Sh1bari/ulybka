package com.example.ulybka.repo;

import com.example.ulybka.entities.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepo extends CrudRepository<Comments, Integer> {
    List<Comments> findAllByNameContainingOrderByDateDesc(String str);

    @Modifying
    @Transactional
    @Query(value = "delete from Comments b where b.id=:id")
    void deleteComments(@Param("id") Integer id);
}
