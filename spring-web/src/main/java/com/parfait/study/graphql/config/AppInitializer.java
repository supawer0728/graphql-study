package com.parfait.study.graphql.config;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parfait.study.graphql.album.Album;
import com.parfait.study.graphql.album.AlbumRepository;
import com.parfait.study.graphql.album.Photo;
import com.parfait.study.graphql.post.Comment;
import com.parfait.study.graphql.post.Post;
import com.parfait.study.graphql.post.PostRepository;
import com.parfait.study.graphql.todo.Todo;
import com.parfait.study.graphql.todo.TodoRepository;
import com.parfait.study.graphql.user.User;
import com.parfait.study.graphql.user.UserRepository;
import com.parfait.study.graphql.vehicle.Airplane;
import com.parfait.study.graphql.vehicle.Car;
import com.parfait.study.graphql.vehicle.Vehicle;
import com.parfait.study.graphql.vehicle.VehicleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class AppInitializer {
    private static final TypeReference<List<User>> USERS_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<Post>> POSTS_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<Comment>> COMMENT_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<Album>> ALBUM_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<Photo>> PHOTO_TYPE = new TypeReference<>() {};
    private static final TypeReference<List<Todo>> TODO_TYPE = new TypeReference<>() {};

    private final ResourcePatternResolver resourcePatternResolver;
    private final ObjectMapper objectMapper;

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final AlbumRepository albumRepository;
    private final TodoRepository todoRepository;
    private final VehicleRepository vehicleRepository;

    @PostConstruct
    public void initialize() throws IOException {
        Map<Long, User> users = initializeUsers();
        initializePosts(users);
        initializeAlbums(users);
        initializeTodo(users);
        initializeVehicle();
    }

    private Map<Long, User> initializeUsers() throws IOException {
        Map<Long, User> users = objectMapper.readValue(resourcePatternResolver.getResource("classpath:/json/users.json").getInputStream(), USERS_TYPE)
                                            .stream()
                                            .collect(toMap(User::getId, identity()));

        userRepository.saveAll(users.values());
        return users;
    }

    private void initializePosts(Map<Long, User> users) throws IOException {
        Map<Long, Set<Comment>> comments =
                objectMapper.readValue(resourcePatternResolver.getResource("classpath:/json/comments.json").getInputStream(), COMMENT_TYPE)
                            .stream()
                            .collect(groupingBy(Comment::getPostId, toSet()));

        List<Post> posts =
                objectMapper.readValue(resourcePatternResolver.getResource("classpath:/json/posts.json").getInputStream(), POSTS_TYPE)
                            .stream()
                            .map(post -> post.initializeUser(users.get(post.getUserId())))
                            .map(post -> post.initializeComments(comments.get(post.getId())))
                            .collect(toList());

        postRepository.saveAll(posts);
    }

    private void initializeAlbums(Map<Long, User> users) throws IOException {
        Map<Long, Set<Photo>> photos =
                objectMapper.readValue(resourcePatternResolver.getResource("classpath:/json/photos.json").getInputStream(), PHOTO_TYPE)
                            .stream()
                            .collect(groupingBy(Photo::getAlbumId, toSet()));

        List<Album> albums =
                objectMapper.readValue(resourcePatternResolver.getResource("classpath:/json/albums.json").getInputStream(), ALBUM_TYPE)
                            .stream()
                            .map(album -> album.initializeUser(users.get(album.getUserId())))
                            .map(album -> album.initializePhotos(photos.get(album.getId())))
                            .collect(toList());

        albumRepository.saveAll(albums);
    }

    private void initializeTodo(Map<Long, User> users) throws IOException {
        List<Todo> todos =
                objectMapper.readValue(resourcePatternResolver.getResource("classpath:/json/todos.json").getInputStream(), TODO_TYPE)
                            .stream()
                            .map(todo -> todo.initializeUser(users.get(todo.getUserId())))
                            .collect(toList());

        todoRepository.saveAll(todos);
    }

    private void initializeVehicle() {
        List<Vehicle> vehicles =
                Arrays.asList(
                        new Car(1L, "Mercedes-Benz", "E-class", "Mercedes Original"),
                        new Airplane(2L, "Lockheed Martin", "F-22A Raptor", "100km"));

        vehicleRepository.saveAll(vehicles);

    }
}
