package com.example.demo.service.impl;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Movie;
import com.example.demo.entity.MovieImage;
import com.example.demo.repository.MovieImageRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository; //final

    private final MovieImageRepository imageRepository; // final

    @Transactional
    @Override
    public Long register(MovieDTO movieDTO) {

        Map<String, Object> entityMap = dtoEntity(movieDTO);
        Movie movie = (Movie) entityMap.get("movie");
        List<MovieImage> movieImageList = (List<MovieImage>)entityMap.get("imgList");

        movieRepository.save(movie);

        movieImageList.forEach(movieImage -> {
            imageRepository.save(movieImage);
        });
        return movie.getMno();
    }
}
