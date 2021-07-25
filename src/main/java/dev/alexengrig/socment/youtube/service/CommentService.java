package dev.alexengrig.socment.youtube.service;

import dev.alexengrig.socment.youtube.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByVideoId(String videoId);
}
