package rk.samples.gofpatterns.chain.handler;

import rk.samples.gofpatterns.chain.model.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Secretary extends AbstractSighter {
    private static final String SPAM = "SPAM";

    public Secretary() {
        addCheck(this::checkIfAccountantDocument, new Accountant());
        addCheck(this::checkIfLawyerDocument, new Lawyer());
        addCheck(this::checkIfDocumentApproved, new Boss());
    }

    @Override
    public String getName() {
        return "Secretary";
    }

    @Override
    public boolean verify(Document document) {
        return isSpam(document);
    }

    private boolean isSpam(Document document) {
        Pattern pattern = Pattern.compile(SPAM, Pattern.CASE_INSENSITIVE + Pattern.MULTILINE);
        List<String> documentPartsToCheck = new ArrayList<>();
        documentPartsToCheck.add(document.getBody());
        documentPartsToCheck.addAll(document.getTags());
        for (String part : documentPartsToCheck) {
            if (pattern.matcher(part).find()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfAccountantDocument(Document document) {
        return Accountant.Keywords.TITLE.matchToDocumentPart(document.getTitle())
                || Accountant.Keywords.BODY.matchToDocumentPart(document.getBody());
    }

    private boolean checkIfLawyerDocument(Document document) {
        return Lawyer.Keywords.TITLE.matchToDocumentPart(document.getTitle())
                || Lawyer.Keywords.BODY.matchToDocumentPart(document.getBody())
                || document.getTags().stream().map(Lawyer.Keywords.TAGS::matchToDocumentPart).anyMatch(b -> b.equals(Boolean.TRUE));
    }

    private boolean checkIfDocumentApproved(Document document) {
        return document.isApproved();
    }
}
