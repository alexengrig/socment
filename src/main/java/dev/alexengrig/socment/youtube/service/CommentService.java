package dev.alexengrig.socment.youtube.service;

import dev.alexengrig.socment.youtube.model.Comment;
import reactor.core.publisher.Flux;

public interface CommentService {
    Flux<Comment> getAllByVideoId(String videoId);
}
