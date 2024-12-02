package com.example.demo.service.Impl;

import com.example.demo.domain.WordEntity;
import com.example.demo.repository.WordChooserRepository;
import com.example.demo.service.WordService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

    private final WordChooserRepository wordChooserRepository;

    @SneakyThrows
    public void wordValidation(String word) {
        wordChooserRepository.findByWord(word)
                .map(wordEntity -> true)
                .orElseThrow(() -> new RuntimeException("Такого слова нет в нашей базе"));
    }


    @SneakyThrows
    public WordEntity wordChooser(Integer length) {
        Random random = new Random();
        List<WordEntity> matchesByLengthWords = wordChooserRepository.findWordsByLength(length);
        if (matchesByLengthWords.isEmpty()) {
            throw new RuntimeException("Слов указанной длины нет");  // Если слов указанной длины нет
        }

        int randomIndex = random.nextInt(matchesByLengthWords.size());  // Генерация случайного индекса
        return matchesByLengthWords.get(randomIndex);

    }

}
