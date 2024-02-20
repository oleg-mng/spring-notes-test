package com.olegmng.springnotestest.service;

import com.olegmng.springnotestest.Note;
import com.olegmng.springnotestest.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
        init();
    }

    public void init(){
        for (int i = 0; i < 5; i++) {
            Note note = new Note();
            note.setId((long) i);
            note.setTitle("Note #"+ i);
            note.setContent("To do #"+ i);
            noteRepository.save(note);

        }

    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note saveOrUpdate(Note note){
        return noteRepository.save(note);
    }

    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }
}
