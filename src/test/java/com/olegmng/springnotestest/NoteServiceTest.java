package com.olegmng.springnotestest;

import com.olegmng.springnotestest.repository.NoteRepository;
import com.olegmng.springnotestest.service.NoteService;
import jakarta.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoFramework;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteServiceTest {

    @InjectMocks
    private NoteService noteService;

    @Mock
    private NoteRepository noteRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllNoteTest(){
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        List<Note> expectedNotes = Collections.singletonList(note);
        when(noteRepository.findAll()).thenReturn(expectedNotes);

        List<Note> actualNotes = noteService.getAllNotes();
        assertEquals(expectedNotes, actualNotes);
    }


}
