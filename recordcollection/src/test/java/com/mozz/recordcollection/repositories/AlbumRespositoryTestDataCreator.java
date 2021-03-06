package com.mozz.recordcollection.repositories;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.mozz.recordcollection.App;
import com.mozz.recordcollection.entities.Album;

@Configuration
@EnableAutoConfiguration
public class AlbumRespositoryTestDataCreator {

	
	// TODO: how to do this via JUNIT given all the autowiring gubbins?
  public static void main(String[] args) {

      ConfigurableApplicationContext context = SpringApplication.run(App.class);
      AlbumRepository repository = context.getBean(AlbumRepository.class);

      // delete all data
      repository.deleteAll();
      
      // save a couple of albums
      repository.save(new Album("Thriller", 1983));
      repository.save(new Album("Rubber Soul", 1964));
      repository.save(new Album("Rubber Bullets", 1973));
      repository.save(new Album("Random Access Memories", 2014));


      // fetch all albums
      Iterable<Album> albums = repository.findAll();
      System.out.println("Albums found with findAll():");
      System.out.println("-------------------------------");
      for (Album album : albums) {
          System.out.println(album);
      }
      System.out.println();

      // fetch an individual album by ID
      Album album = repository.findOne(1L);
      System.out.println("Album found with findOne(1L):");
      System.out.println("--------------------------------");
      System.out.println(album);
      System.out.println();

      // fetch album by title
      List<Album> thrillers = repository.findByTitle("Thriller");
      System.out.println("Albums found with findByTitle('Thriller'):");
      System.out.println("--------------------------------------------");
      for (Album thriller : thrillers) {
          System.out.println(thriller);
      }
  
      // fetch album by title wildcard match
      thrillers = repository.findByTitleLike("Rubber%");
      System.out.println("Albums found with findByTitleLike('Rubber%'):");
      System.out.println("--------------------------------------------");
      for (Album thriller : thrillers) {
          System.out.println(thriller);
      }
      
      // fetch by year of relese
      albums = repository.findByYearOfRelease(2014);
      System.out.println("Albums found with findByYearOfRelease(2014):");
      System.out.println("--------------------------------------------");
      for (Album a : albums) {
          System.out.println(a);
      }
      

      context.close();
  }

}
