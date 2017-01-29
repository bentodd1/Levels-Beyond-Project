package com.bentodd.assignment;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Produces({"application/json" })
public interface NoteService {

	@GET
	@Path("/{id}")
	public abstract Note getNote(@PathParam("id") String id);
	
	@GET
	@Path("/")
	public abstract List<Note> getNotes(@QueryParam("query") String query);

	@POST
	@Path("/")
	public abstract Response addNote(Note note);

}