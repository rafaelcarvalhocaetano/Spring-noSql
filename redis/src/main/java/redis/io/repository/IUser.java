package redis.io.repository;

import java.util.Map;

import redis.io.model.User;

public interface IUser {
  void save(User user);
  Map<String, User> findAll();
  User findById(String id);
  void update(User user);
  void delete(String id);  
}