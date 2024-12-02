package com.example.demo.repository;

import com.example.demo.domain.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WordChooserRepository extends JpaRepository<WordEntity, Long> {

    Optional<WordEntity> findByWord(String word);

    @Query("SELECT w FROM WordEntity w WHERE LENGTH(w.word) = :length")
    List<WordEntity> findWordsByLength(@Param("length") int length);

}
