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

package dev.alexengrig.socoment.youtube.service;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThread;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import dev.alexengrig.socoment.youtube.converter.YouTubeCommentConverter;
import dev.alexengrig.socoment.youtube.model.Comment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YouTubeCommentServiceImpl implements YouTubeCommentService {

    private final YouTube youTube;
    private final YouTubeCommentConverter commentConverter;

    @Value("${youtube.api.key}")
    private final String apiKey;

    @Override
    @SneakyThrows(IOException.class)
    public List<Comment> getAllByVideoId(String videoId) {
        CommentThreadListResponse response = youTube
                .commentThreads()
                .list("snippet")
                .setKey(apiKey)
                .setVideoId(videoId)
                .execute();
        List<CommentThread> items = response.getItems();
        return items.stream()
                .map(commentConverter::convert)
                .collect(Collectors.toList());
    }

}
