package dev.alexengrig.socment.youtube.converter;

import com.google.api.services.youtube.model.CommentSnippet;
import com.google.api.services.youtube.model.CommentThread;
import dev.alexengrig.socment.youtube.model.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter implements Converter<CommentThread, Comment> {

    @Override
    public Comment convert(CommentThread source) {
        CommentSnippet snippet = source.getSnippet().getTopLevelComment().getSnippet();
        String text = snippet.getTextDisplay();
        return new Comment(text);
    }
}
