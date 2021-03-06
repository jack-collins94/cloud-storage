package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper

public interface NotesMapper {

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Note> getAllNotes(int userId);

    @Insert("INSERT INTO NOTES (noteTitle, noteDescription, userId) VALUES(#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNote(Note note);

    @Update("UPDATE NOTES SET noteTitle = #{noteTitle}, noteDescription = #{noteDescription}, userId = #{userId} WHERE noteId = #{noteId}")
    int updateNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteId = #{noteId}")
    int deleteNote(Integer noteId);

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteId}")
    Note getNoteById(int userId);
}
