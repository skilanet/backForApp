package com.samsung.repository;

import com.samsung.domain.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WordsRepository extends JpaRepository<Words, Integer> {

    @Modifying
    @Query("update Words w set w.word = :word, w.translate = :translate where w.id = :id")
    void updateWordById(@Param("id") int id,
                        @Param("word") String word,
                        @Param("translate") String translate);

    List<Words> findByChapterId(int id);
}
