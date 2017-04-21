package ru.bzhumataev.service;


import ru.bzhumataev.model.Note;

import java.util.List;

public interface SearchService {
    public List<Note> searchByTitle(String subTitle);

    public List<Note> searchByText(String subText);
}
