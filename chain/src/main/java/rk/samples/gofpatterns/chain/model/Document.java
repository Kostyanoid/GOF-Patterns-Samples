package rk.samples.gofpatterns.chain.model;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@ToString
public class Document {
    private String title;
    private String body;
    private Set<String> tags;
    private List<String> comments;
    private boolean approved;

    public Document(String title, String body) {
        this.title = title;
        this.body = body;
        this.approved = true;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    public Document(String title, String body, Set<String> tags) {
        this(title, body);
        this.tags.addAll(tags);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public boolean isNotApproved() {
        return !approved;
    }

    public void setNotApproved() {
        approved = false;
    }
}
