package com.samsung.rest.DataTransferObject;

import com.samsung.domain.Chapter;
import com.samsung.domain.Words;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordsDTO {

    private int id;
    private String word;
    private String translate;

    public static WordsDTO toDTO(Words words) {
        return new WordsDTO(words.getId(), words.getWord(), words.getTranslate());
    }

    public static Words toDomainObject(WordsDTO wordsDTO, Chapter chapter) {
        return new Words(wordsDTO.getId(), wordsDTO.getWord(), wordsDTO.getTranslate(), chapter);
    }

}
