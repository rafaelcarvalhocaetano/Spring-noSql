package com.apisw.repository;

import java.util.Date;
import java.util.List;

import com.apisw.model.Post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{

  @Query("{ 'title': { $regex: ?0, $options: 'i' }}")
  List<Post> searchTitle(String text);

  @Query("{ $and: [ {date: {$gte: ?1} }, { date: { $lte: value }}, { $or: [ { 'title': { $regex: ?0, $options: 'i' }}, { 'body': { $regex: ?0, $options: 'i' }}, { 'comment.text': { $regex: ?0, $options: 'i' }} ] }] }")
  List<Post> fullSearch(String text, Date minDate, Date maxDate);

  List<Post> findByTitleContainingIgnoreCase(String text);
  
}