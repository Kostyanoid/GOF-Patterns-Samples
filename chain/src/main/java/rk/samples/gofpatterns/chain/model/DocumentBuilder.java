package rk.samples.gofpatterns.chain.model;

import java.util.HashSet;
import java.util.Set;

public class DocumentBuilder {
    private String title;
    private String body;
    private Set<String> tags = new HashSet<>();

    public DocumentBuilder reset() {
        title = "";
        body = "";
        tags.clear();
        return this;
    }

    public DocumentBuilder title(String title) {
        this.title = title;
        return this;
    }

    public DocumentBuilder body(String body) {
        this.body = body;
        return this;
    }

    public DocumentBuilder tag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public DocumentBuilder tags(Set<String> tags) {
        this.tags.addAll(tags);
        return this;
    }

    public Document build() {
        return new Document(this.title, this.body, this.tags);
    }
}
