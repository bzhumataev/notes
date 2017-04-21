package ru.bzhumataev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.bzhumataev.model.Note;

import java.util.List;


public interface NoteRepository extends JpaRepository<Note, Long> {
}
