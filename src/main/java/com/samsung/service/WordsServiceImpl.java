package com.samsung.service;

import com.samsung.domain.Chapter;
import com.samsung.domain.Words;
import com.samsung.repository.ChapterRepository;
import com.samsung.repository.WordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordsServiceImpl implements WordsService {

    public final ChapterRepository chapterRepository;
    public final WordsRepository wordsRepository;

    @Override
    public Words insert(String word, String translate, int chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId).orElse(null);
        Words words = Words.builder().word(word).translate(translate).chapter(chapter).build();
        return wordsRepository.save(words);
    }

    @Override
    public Words update(int id, String word, String translate) {
        Words words = Words.builder()
                .word(word)
                .translate(translate)
                .build();
        return wordsRepository.save(words);
    }

    @Override
    public List<Words> getAll() {
        return wordsRepository.findAll();
    }

    @Override
    public List<Words> findByChapterId(int id) {
        return wordsRepository.findByChapterId(id);
    }

    @Override
    public void deleteById(int id) {
        wordsRepository.deleteById(id);
    }

}
