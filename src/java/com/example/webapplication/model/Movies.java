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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author nilambar
 */
@Entity
@Table(name = "movies")
public class Movies implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Integer id;
    
    @Column(name = "movie_name")
    private String movie_name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="movies_actors",
            joinColumns = {@JoinColumn(name="movie_id", referencedColumnName = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    List<Actors> actors = new ArrayList<>();
    
    public Movies(){}
    
    public Movies(String movie_name) {
        this.movie_name = movie_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }
    
}
