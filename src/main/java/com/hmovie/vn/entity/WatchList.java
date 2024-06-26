package com.hmovie.vn.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;


@Entity

public class WatchList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(mappedBy = "watchList", cascade = CascadeType.ALL)
	private User user;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinTable(name = "watchlists_movies", joinColumns = @JoinColumn(name = "watchlist_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> movies;

	@Column(name = "added_at")
	private String addAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getAddAt() {
		return addAt;
	}

	public void setAddAt(String addAt) {
		this.addAt = addAt;
	}
	
	
}
