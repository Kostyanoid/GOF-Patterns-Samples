package rk.samples.gofpatterns.chain.handler;

import rk.samples.gofpatterns.chain.model.Document;

public class Boss extends AbstractSighter {
    private static final double BAD_MOOD = 0.3;

    @Override
    public String getName() {
        return "Big Boss";
    }

    @Override
    public boolean verify(Document document) {
        return Math.random() > BAD_MOOD;
    }
}
