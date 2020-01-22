package rk.samples.gofpatterns.chain.handler;

import rk.samples.gofpatterns.chain.model.Document;

public interface Verifier {
    boolean verify(Document document);
}
