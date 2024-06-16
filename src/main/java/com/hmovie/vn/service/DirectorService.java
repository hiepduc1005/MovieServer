package com.hmovie.vn.service;

import com.hmovie.vn.entity.Director;

public interface DirectorService {

	Director createDirector(Director director);

	Director updateDirector(Director directorUpdate);

	void deleteDirector(Integer directorId);

}
