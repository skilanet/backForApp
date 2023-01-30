package com.samsung.repository;

import com.samsung.domain.Chapter;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

    @Override
    @EntityGraph(attributePaths = {"wordsList"})
    List<Chapter> findAll();

    Chapter findByChapter(String chapter);
}
