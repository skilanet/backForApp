package com.samsung.rest.controller;

import com.samsung.domain.Words;
import com.samsung.rest.DataTransferObject.WordsDTO;
import com.samsung.service.WordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WordsController {


    public final WordsService wordsService;

    @GetMapping("/words")
    public List<WordsDTO> getAllWords() {
        return wordsService.getAll().stream().map(WordsDTO::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/chapter/{id}/words")
    public List<WordsDTO> getWordBySpareId(@PathVariable int id) {
        return wordsService.findByChapterId(id).stream().map(WordsDTO::toDTO).collect(Collectors.toList());
    }

    @PostMapping("/words")
    public WordsDTO addNewWord(@RequestParam String word,
                               @RequestParam String translate,
                               @RequestParam int chapterId) {
        Words insertWord = wordsService.insert(word, translate, chapterId);
        return WordsDTO.toDTO(insertWord);
    }

    @PutMapping("/words/{id}/word")
    public void updateById(@PathVariable int id,
                           @RequestParam String word,
                           @RequestParam String translate) {
        wordsService.update(id, word, translate);
    }

    @DeleteMapping("/words/{id}")
    public void deleteById(@PathVariable int id) {
        wordsService.deleteById(id);
    }
}
