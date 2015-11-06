package service;

import java.util.ArrayList;
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

import facade.ActorFacade;
import facade.FilmActorFacade;
import model.Actor;
import model.Film;
import model.FilmActor;
import model.FilmActorPK;

@Path("/filmActor")
public class FilmActorService {

	@EJB 
	FilmActorFacade filmActorFacadeEJB;
	@EJB
	ActorFacade actorFacadeEJB;
	
    Logger logger = Logger.getLogger(FilmActorService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<FilmActor> findAll(){
		return filmActorFacadeEJB.findAll();
	}
	
    @GET
    @Path("{id}")//buscar todos los actores de cierto film
    @Produces({"application/xml", "application/json"})
    //public FilmActor find(@PathParam("id") Integer id) {
    public List<FilmActor> find(@PathParam("id") Integer id) {
    	//estaran todos los film, pero debemos restringir los q son de id_film igual al id de entrada
        List<FilmActor> listaFilmActor = filmActorFacadeEJB.findAll();
        List<FilmActor> listaAux = new ArrayList<FilmActor>();
        for(int i=0; i<listaFilmActor.size(); i++){
        	//si es el film, se agrega a la lista auxiliar
        	if(listaFilmActor.get(i).getFilmId() == id ){
        		listaAux.add(listaFilmActor.get(i));	
        	}
        }     
        return listaAux;
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
