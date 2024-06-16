package com.hmovie.vn.service;

import com.hmovie.vn.entity.Trailer;

public interface TrailerService {

	Trailer createTrailer(Trailer trailer);

	Trailer updateTrailer(Trailer trailer);

	void deleteTrailer(Integer trailerId);

}
