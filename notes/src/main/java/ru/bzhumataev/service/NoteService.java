package ru.bzhumataev.service;

import ru.bzhumataev.model.Note;

import java.util.List;


public interface NoteService {
    Note add(final Note note);

    List<Note> findNotes();

    void remove(final long id);
}
