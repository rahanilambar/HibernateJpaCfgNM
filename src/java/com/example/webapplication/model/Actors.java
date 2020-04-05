package com.example.webapplication.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author nilambar
 */
@Entity
@Table(name = "actors")
public class Actors implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private Integer id;
    
    @Column(name="actor_name")
    private String actorName;
    
    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.ALL})
//    @JoinTable(name="movies_actors",
//            joinColumns = {@JoinColumn(name="actor_id", referencedColumnName = "actor_id")},
//            inverseJoinColumns = {@JoinColumn(name = "movie_id")})
    List<Movies> movies = new ArrayList<>();

    public Actors(){}
    
    public Actors(String actorName) {
        this.actorName = actorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}
