package rk.samples.gofpatterns.chain.handler;

import lombok.extern.log4j.Log4j2;
import rk.samples.gofpatterns.chain.model.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Log4j2
public class Lawyer extends AbstractSighter {
    public static final String LAWYER_AGREEMENT_COMMENT = "Lawyer has already seen this document 3 times";

    public Lawyer() {
        addCheck(this::checkIfSecurityDocument, new Security());
    }

    @Override
    public String getName() {
        return "Devil's advocate";
    }

    @Override
    public boolean verify(Document document) {
        return document.getComments().stream().anyMatch(LAWYER_AGREEMENT_COMMENT::equals);
    }

    private boolean checkIfSecurityDocument(Document document) {
        return Security.Keywords.BODY.matchToDocumentPart(document.getBody())
                || document.getTags().stream().map(Security.Keywords.TAGS::matchToDocumentPart).anyMatch(b -> b.equals(Boolean.TRUE));
    }

    public enum Keywords implements DocumentMatcher {
        TITLE("Contract", "Lawsuit"),
        BODY("rights"),
        TAGS("court", "trick");

        private Set<Pattern> patterns = new HashSet<>();

        Keywords(String... regexes) {
            for (String regex : regexes) {
                try {
                    Pattern newPattern = Pattern.compile("\\b" + regex + "\\b", Pattern.CASE_INSENSITIVE + Pattern.MULTILINE);
                    patterns.add(newPattern);
                } catch (PatternSyntaxException e) {
                    log.error("Cannot compile regex: {}", regex);
                }
            }
        }


        @Override
        public boolean matchToDocumentPart(String documentPart) {
            return DocumentMatcher.super.matchToDocumentPart(documentPart, patterns);
        }
    }
}
