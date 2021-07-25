package dev.alexengrig.socment.youtube.controller;

import dev.alexengrig.socment.youtube.model.Comment;
import dev.alexengrig.socment.youtube.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/youtube/v1/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/videos/{videoId}")
    public ResponseEntity<List<Comment>> all(@PathVariable String videoId) {
        return ResponseEntity.ok(commentService.getAllByVideoId(videoId));
    }
}
