package com.samsung.rest.DataTransferObject;

import com.samsung.domain.Chapter;
import com.samsung.domain.Words;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChapterDTO {

    private int id;
    private String nameChapter;
    private List<WordsDTO> list;

    public static ChapterDTO toDTO(Chapter chapter) {
        List<WordsDTO> wordsDTOList;
        if (chapter.getWordsList() != null) {
            wordsDTOList = chapter.getWordsList()
                    .stream().map(WordsDTO::toDTO)
                    .collect(Collectors.toList());
        } else {
            wordsDTOList = new ArrayList<>();
        }
        return new ChapterDTO(chapter.getId(), chapter.getChapter(), wordsDTOList);
    }

    private static Chapter toDomainObject(ChapterDTO chapterDTO, List<Words> wordsList) {
        return new Chapter(chapterDTO.getId(), chapterDTO.getNameChapter(), wordsList);
    }

}
