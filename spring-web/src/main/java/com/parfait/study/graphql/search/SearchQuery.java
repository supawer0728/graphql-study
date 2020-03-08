package com.parfait.study.graphql.search;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.parfait.study.graphql.album.Album;
import com.parfait.study.graphql.album.AlbumRepository;
import com.parfait.study.graphql.post.Post;
import com.parfait.study.graphql.post.PostRepository;
import com.parfait.study.graphql.todo.Todo;
import com.parfait.study.graphql.todo.TodoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SearchQuery implements GraphQLQueryResolver {
    private final AlbumRepository albumRepository;
    private final PostRepository postRepository;
    private final TodoRepository todoRepository;

    public List<Object> search(String title) {
        Stream<Album> albums = albumRepository.findByTitleContaining(title).stream();
        Stream<Post> posts = postRepository.findByTitleContaining(title).stream();
        Stream<Todo> todos = todoRepository.findByTitleContaining(title).stream();

        return concat(concat(albums, posts), todos).collect(toList());
    }
}
