package com.mozz.recordcollection.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.mozz.recordcollection.entities.Album;

public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> { 

    List<Album> findByTitle(@Param("title") String title);
    List<Album> findByTitleLike(@Param("title") String title);
    List<Album> findByYearOfRelease(@Param("yearOfRelease") int year);
    

}
