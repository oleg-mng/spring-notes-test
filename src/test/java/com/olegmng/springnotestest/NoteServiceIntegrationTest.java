package com.olegmng.springnotestest;

import com.olegmng.springnotestest.repository.NoteRepository;
import com.olegmng.springnotestest.service.NoteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceIntegrationTest {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @Before
    public void setUp() {
        noteRepository.deleteAll();
    }

    @Test
    public void getAllNotesIntegrationTests() {
        Note note = new Note();
        note.setTitle("Integration Test Title");
        note.setContent("Integration Test Content");

        noteRepository.save(note);

        List<Note> notes = noteService.getAllNotes();
        assertTrue(notes.size() > 0);
        assertEquals(note.getTitle(), notes.get(0).getTitle());
    }


}
