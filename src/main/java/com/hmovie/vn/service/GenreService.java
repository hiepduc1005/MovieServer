package com.hmovie.vn.service;

import com.hmovie.vn.entity.Genre;

public interface GenreService {
	
	Genre createGenre(Genre genre);
	
	Genre updateGenre(Genre genreUpdate);
	
	void deleteGenre(Integer genreId);
}
