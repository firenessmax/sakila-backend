package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.FilmActorFacade;
import model.FilmActor;
import model.FilmActorPK;

@Path("/filmActor")
public class FilmActorService {

	@EJB 
	FilmActorFacade filmActorFacadeEJB;
	
    Logger logger = Logger.getLogger(FilmActorService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<FilmActor> findAll(){
		return filmActorFacadeEJB.findAll();
	}
	
    @GET
    @Path("{idFilm}/{idActor}")
    @Produces({"application/xml", "application/json"})
    public FilmActor find(@PathParam("idFilm") Integer idFilm, @PathParam("idActor") Integer idActor) {
    	FilmActorPK filmActorPK = new FilmActorPK(idFilm,idActor);
        return filmActorFacadeEJB.find(filmActorPK);
    }
	
	@POST
    @Consumes({"application/xml", "application/json"})
    public void create(FilmActor entity) {
        filmActorFacadeEJB.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, FilmActor entity) {
    	entity.setActorId(id.intValue());
        filmActorFacadeEJB.edit(entity);
    }
}
