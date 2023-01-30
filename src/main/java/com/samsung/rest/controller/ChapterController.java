package com.samsung.rest.controller;


import com.samsung.domain.Chapter;
import com.samsung.rest.DataTransferObject.ChapterDTO;
import com.samsung.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;

    @GetMapping("/chapter")
    public List<ChapterDTO> getAllChapter() {
        return chapterService.getAll().stream().map(ChapterDTO::toDTO).collect(Collectors.toList());
    }

    @PostMapping("/chapter")
    public ChapterDTO insertChapter(@RequestParam String nameChapter) {
        Chapter insert = chapterService.insert(nameChapter);
        return ChapterDTO.toDTO(insert);
    }

    @PutMapping("/chapter/{id}")
    public ChapterDTO updateChapter(@PathVariable int id,
                                    @RequestParam String nameChapter) {
        Chapter update = chapterService.update(id, nameChapter);
        return ChapterDTO.toDTO(update);
    }

    @GetMapping("/chapter/{id}")
    public ChapterDTO getChapterById(@PathVariable int id) {
        return ChapterDTO.toDTO(chapterService.getById(id));
    }

    @DeleteMapping("/chapter/{id}")
    public void deleteById(@PathVariable int id) {
        chapterService.deleteById(id);
    }

}
