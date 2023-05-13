package com.example.ulybka.repo;

import com.example.ulybka.entities.CallBack;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CallBackRepo extends CrudRepository<CallBack, Integer> {
    List<CallBack> findAllByNumberContainingOrderByDateDesc(String str);

    @Modifying
    @Transactional
    @Query(value = "delete from CallBack b where b.id=:id")
    void deleteCallBack(@Param("id") Integer id);
}
