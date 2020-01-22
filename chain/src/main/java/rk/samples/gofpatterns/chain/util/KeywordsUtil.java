package rk.samples.gofpatterns.chain.util;

import lombok.extern.log4j.Log4j2;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Log4j2
public class KeywordsUtil {

    private KeywordsUtil() {}

    public static Set<Pattern> compilePatternsFromKeywords(String... keywords) {
        Set<Pattern> patterns = new HashSet<>();

        for (String regex : keywords) {
            try {
                Pattern newPattern = Pattern.compile("\\b" + regex + "\\b", Pattern.CASE_INSENSITIVE + Pattern.MULTILINE);
                patterns.add(newPattern);
            } catch (PatternSyntaxException e) {
                log.error("Cannot compile regex: {}", regex);
            }
        }

        return patterns;
    }
}
