package com.alina.web.productproject.repositories;

import com.alina.web.productproject.models.Whine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WhinesRepository extends JpaRepository<Whine, Long> {
    List<Whine> findAllByUser_IdOrderByDateDesc(Long id);

    List<Whine> findAllByOrderByDateDesc();

    //    void deleteByIdAndUser_Id(Long id, Long userId);
    Optional<Whine> findByIdAndUserId(Long id, Long userId);
}
