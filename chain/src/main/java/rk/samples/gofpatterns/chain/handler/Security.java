package rk.samples.gofpatterns.chain.handler;

import lombok.extern.log4j.Log4j2;
import rk.samples.gofpatterns.chain.model.Document;
import rk.samples.gofpatterns.chain.util.KeywordsUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class Security extends AbstractSighter {
    private static final String SECURITY_TOP_SECRET_GUARD = "\\btop\\b.+\\bsecret\\b";

    @Override
    public String getName() {
        return "Agent Smith";
    }

    @Override
    public boolean verify(Document document) {
        Pattern pattern = Pattern.compile(SECURITY_TOP_SECRET_GUARD);
        Matcher matcher = pattern.matcher(document.getBody());
        return !matcher.find();
    }

    public enum Keywords implements DocumentMatcher {
        TITLE(),
        BODY("secret", "security"),
        TAGS("secret");

        private Set<Pattern> patterns = new HashSet<>();

        Keywords(String... keywords) {
            patterns.addAll(KeywordsUtil.compilePatternsFromKeywords(keywords));
        }

        @Override
        public boolean matchToDocumentPart(String documentPart) {
            return DocumentMatcher.super.matchToDocumentPart(documentPart, patterns);
        }
    }
}
