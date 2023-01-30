package com.samsung.service;

import com.samsung.domain.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {

    Chapter insert(String nameChapter);

    Chapter update(int id, String nameChapter);

    List<Chapter> getAll();

    Chapter getById(int id);

    Chapter getByChapter(String nameChapter);

    void deleteById(int id);

}
