package model;

import java.io.Serializable;

public class FilmActorPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int actorId;
	private int filmId;
	
	public FilmActorPK(int actorId, int filmId) {
		this.filmId = filmId;
		this.actorId = actorId;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

}
