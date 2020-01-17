package rk.samples.gofpatterns.chain.handler;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface DocumentMatcher {

    boolean matchToDocumentPart(String documentPart);

    default boolean matchToDocumentPart(String documentPart, Set<Pattern> patterns) {
        String adjustedSource = documentPart.toLowerCase().trim();
        boolean isMatch = false;
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(adjustedSource);
            if (matcher.find()) {
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }
}
