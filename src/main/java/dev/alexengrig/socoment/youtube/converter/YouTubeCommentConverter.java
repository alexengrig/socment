/*
 * Copyright 2020-2021 Alexengrig Dev.
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

package dev.alexengrig.socoment.youtube.converter;

import com.google.api.services.youtube.model.CommentSnippet;
import com.google.api.services.youtube.model.CommentThread;
import dev.alexengrig.socoment.youtube.model.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class YouTubeCommentConverter implements Converter<CommentThread, Comment> {

    @NonNull
    @Override
    public Comment convert(CommentThread source) {
        CommentSnippet snippet = source.getSnippet().getTopLevelComment().getSnippet();
        String text = snippet.getTextDisplay();
        return new Comment(text);
    }

}
