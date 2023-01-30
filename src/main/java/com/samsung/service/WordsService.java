package com.samsung.service;

import com.samsung.domain.Words;

import java.util.List;

public interface WordsService {

    Words insert(String word,
                 String translate,
                 int chapterId);

    Words update(int id,
                 String word,
                 String translate);

    List<Words> getAll();

    List<Words> findByChapterId(int id);

    void deleteById(int id);

}
