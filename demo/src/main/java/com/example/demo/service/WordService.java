package com.example.demo.service;

import com.example.demo.domain.WordEntity;

public interface WordService {

    void wordValidation(String word);

    WordEntity wordChooser(Integer length);

}
