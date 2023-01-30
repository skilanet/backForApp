package com.samsung.service;

import com.samsung.domain.Chapter;
import com.samsung.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;

    @Override
    public Chapter insert(String nameChapter) {
        Chapter chapter = Chapter.builder()
                .chapter(nameChapter)
                .build();
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter update(int id, String chapter) {
        Chapter newChapter = Chapter.builder()
                .id(id)
                .chapter(chapter)
                .build();
        return chapterRepository.save(newChapter);
    }

    @Override
    public List<Chapter> getAll() {
        return chapterRepository.findAll();
    }

    @Override
    public Chapter getById(int id) {
        return chapterRepository.findById(id).orElse(null);
    }

    @Override
    public Chapter getByChapter(String nameChapter) {
        return chapterRepository.findByChapter(nameChapter);
    }

    @Override
    public void deleteById(int id) {
        chapterRepository.deleteById(id);
    }
}
