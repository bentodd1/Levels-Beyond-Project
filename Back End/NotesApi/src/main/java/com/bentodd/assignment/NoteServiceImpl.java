package com.bentodd.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;

public class NoteServiceImpl implements NoteService {
	long currentId = 0;
	Map<Long, Note> notes = new HashMap<Long, Note>();

	public NoteServiceImpl() {
		init();
	}

	final void init() {
		System.out.println("InitializingService");
	}

	//Adds the note to the map and increases the currentId so 2 notes
	//do not have the same id
	@Override
	public Response addNote(Note note) {
		System.out.println("---Invoking addNote---");
		note.setId(++currentId);
		notes.put(note.getId(), note);
		return Response.ok(note).build();
	}

	@Override
	public Note getNote(String noteId) {
		System.out.println("---Invoking getNote, Note id is: " + noteId);
		long idNumber = Long.parseLong(noteId);
		Note note = notes.get(idNumber);
		System.out.println(note.getBody());
		return note;
	}
	
	// Converts the map of notes into a list.  If the query string is empty this method 
	// returns all the notes.  If the query string is not empty the method calls getMatchingNotes
	// in order to get only the notes that contain the matching string in the body.
	@Override
	public List<Note> getNotes(String query) {
		if (query != null && !query.isEmpty()) {
			System.out.println("Inside getNotes query is " + query);
			List<Note> listNotes = new ArrayList<Note>(notes.values());
			return getMatchingNotes(listNotes, query);
		}
		return new ArrayList<Note>(notes.values());
	}

	// Returns all notes that contain the String query in their body
	// from the original note.
	public List<Note> getMatchingNotes(List<Note> listNotes, String query) {
		List<Note> listClone = new ArrayList<Note>();
		for (Note note : listNotes) {
			System.out.println(note.getBody());
			if (note.getBody().contains(query)) {
				listClone.add(note);
			}
		}
		return listClone;
	}
}
