package dev.alexengrig.socment.youtube.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import dev.alexengrig.socment.youtube.converter.CommentConverter;
import dev.alexengrig.socment.youtube.model.Comment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final YouTube youTube;
    private final CommentConverter commentConverter;

    @Value("${youtube.api.key}")
    private final String youTubeApiKey;

    @Override
    @SneakyThrows(IOException.class)
    public List<Comment> getAllByVideoId(String videoId) {
        CommentThreadListResponse response = youTube
                .commentThreads()
                .list("snippet")
                .setKey(youTubeApiKey)
                .setVideoId(videoId)
                .execute();
        List<CommentThread> items = response.getItems();
        return items.stream()
                .map(commentConverter::convert)
                .collect(Collectors.toList());
    }
}
