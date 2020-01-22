package rk.samples.gofpatterns.chain.handler;

import lombok.extern.log4j.Log4j2;
import rk.samples.gofpatterns.chain.model.Document;
import rk.samples.gofpatterns.chain.util.KeywordsUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
public class HumanResource extends AbstractSighter {
    private static final String BIGBOSS_SALARY_MENTION = "Salary.+Big Boss";

    @Override
    public String getName() {
        return "HR";
    }

    @Override
    public boolean verify(Document document) {
        return isThereBigBossSalary(document);
    }

    private boolean isThereBigBossSalary(Document document) {
        String body = document.getBody();
        Matcher matcher = Pattern.compile(BIGBOSS_SALARY_MENTION, Pattern.CASE_INSENSITIVE + Pattern.MULTILINE).matcher(body);
        return matcher.find();
    }

    public enum Keywords implements DocumentMatcher {
        TITLE(),
        BODY("Salary"),
        TAGS();

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
