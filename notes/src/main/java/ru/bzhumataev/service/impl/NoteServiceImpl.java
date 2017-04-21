package ru.bzhumataev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bzhumataev.model.Note;
import ru.bzhumataev.repository.NoteRepository;
import ru.bzhumataev.service.NoteService;

import java.util.ArrayList;
import java.util.List;


@Service
@Repository
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note add(final Note note) {
        return noteRepository.saveAndFlush(note);
    }

    @Override
    public List<Note> findNotes() {
        return new ArrayList<>(noteRepository.findAll());
    }

    @Override
    public void remove(final long id) {
        noteRepository.delete(id);
    }
}
