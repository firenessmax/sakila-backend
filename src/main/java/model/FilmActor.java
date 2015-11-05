package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="film_actor")
@IdClass(FilmActorPK.class)
@NamedQuery(name="FilmActor.findAll", query="SELECT fa FROM FilmActor fa")
public class FilmActor implements Serializable {
	private static final long serialVersionUID = 3L;

	@Id
	@Column(name="actor_id", unique=true, nullable=false)
	private int actorId;

	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	public FilmActor() {
	}

	public FilmActor(int actorId, int filmId) {
		this.actorId = actorId;
		this.filmId = filmId;
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

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
