/*
 * Copyright 2021 Alexengrig Dev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.alexengrig.socoment.youtube.controller;

import dev.alexengrig.socoment.youtube.model.Comment;
import dev.alexengrig.socoment.youtube.service.YouTubeCommentService;
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
public class YouTubeCommentController {

    private final YouTubeCommentService commentService;

    @GetMapping("/videos/{videoId}")
    public ResponseEntity<List<Comment>> all(@PathVariable String videoId) {
        return ResponseEntity.ok(commentService.getAllByVideoId(videoId));
    }

}
