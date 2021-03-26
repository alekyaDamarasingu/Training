package com.kc.training.restfulwebservices.service;

import com.kc.training.restfulwebservices.model.Post;
import com.kc.training.restfulwebservices.model.User;
import com.kc.training.restfulwebservices.repo.PostRepository;
import com.kc.training.restfulwebservices.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PostRepository postRepo;
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User saveUser(User user) {
        User savedUser = userRepo.save(user);
        return savedUser;
    }

    public Post savePost(Post post) {
        Post savedPost = postRepo.save(post);
        return savedPost;
    }

    public Optional<User> findOne(int id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }



    public User deleteByUserId(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
