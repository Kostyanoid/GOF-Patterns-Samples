package rk.samples.gofpatterns.chain.handler;

import rk.samples.gofpatterns.chain.model.Document;

public interface Sighter {
    String getName();

    void sight(Document document);
}
