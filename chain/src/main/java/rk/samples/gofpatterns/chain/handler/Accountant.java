package rk.samples.gofpatterns.chain.handler;

import lombok.extern.log4j.Log4j2;
import rk.samples.gofpatterns.chain.model.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Log4j2
public class Accountant extends AbstractSighter {
    private static final String NUMBER_PATTERN = "\\b([+-]\\d+\\.\\d+|[+-]?\\d+)";

    public Accountant() {
        addCheck(this::isDocumentRegardsToHR, new HumanResource());
    }

    @Override
    public String getName() {
        return "Chef accountant Baba Masha";
    }

    @Override
    public boolean verify(Document document) {
        return isThereAnyNumber(document);
    }

    private boolean isThereAnyNumber(Document document) {
        String body = document.getBody();
        Matcher matcher = Pattern.compile(NUMBER_PATTERN, Pattern.CASE_INSENSITIVE + Pattern.MULTILINE).matcher(body);
        return matcher.find();
    }

    private boolean isDocumentRegardsToHR(Document document) {
        return HumanResource.Keywords.BODY.matchToDocumentPart(document.getBody());
    }

    public enum Keywords implements DocumentMatcher {
        TITLE("Bill", "Contract"),
        BODY("Salary"),
        TAGS("accountant", "balance");

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
