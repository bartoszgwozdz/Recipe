package dev.gwozdz.DemoRecipe.converters;

import dev.gwozdz.DemoRecipe.commands.NoteCommand;
import dev.gwozdz.DemoRecipe.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class NoteToNoteCommandTest {
    private NoteToNoteCommand converter;

    @BeforeEach
    void setUp() {
        converter = new NoteToNoteCommand();
    }

    @Test
    void convertShouldHandleNull(){
        //given
        //when
        NoteCommand noteConverted = converter.convert(null);
        //then
        assertNull(noteConverted);
    }

    @Test
    void convertShouldHandleEmptyUom(){
        //given
        Note noteGiven = new Note();
        //when
        NoteCommand noteConverted = converter.convert(noteGiven);
        //then
        assertThat(noteConverted, notNullValue());
    }

    @Test
    void convertShouldReturnProperValues(){
        //given
        Note noteGiven = new Note();
        Long idGiven = Long.valueOf(1l);
        String recipeNotesGiven = "recipeNotes";
        noteGiven.setId(idGiven);
        noteGiven.setRecipeNotes(recipeNotesGiven);
        //when
        NoteCommand noteConverted = converter.convert(noteGiven);
        //then
        assertThat(noteConverted.getId(), equalTo(idGiven));
        assertThat(noteConverted.getRecipeNotes(), equalTo(recipeNotesGiven));
    }
}