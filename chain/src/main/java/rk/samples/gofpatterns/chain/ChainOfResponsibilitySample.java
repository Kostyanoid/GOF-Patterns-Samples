package rk.samples.gofpatterns.chain;

import lombok.extern.log4j.Log4j2;
import rk.samples.gofpatterns.chain.handler.Secretary;
import rk.samples.gofpatterns.chain.handler.Sighter;
import rk.samples.gofpatterns.chain.model.Document;
import rk.samples.gofpatterns.chain.model.DocumentBuilder;

import static rk.samples.gofpatterns.chain.handler.Lawyer.LAWYER_AGREEMENT_COMMENT;

@Log4j2
public class ChainOfResponsibilitySample {
    public static void main(String[] args) {
        runDocumentForAccountantOnly();
        runDocumentForHumanResource();
        runDocumentWithSpam();
        runSecretDocument();
    }

    private static void runDocumentForAccountantOnly() {
        Document documentForAccountant = new DocumentBuilder().title("Bill for Boss")
                .body("ttttt, ggggg, -123.44")
                .build();

        log.trace("Document for accountant: {}", documentForAccountant);

        Sighter secretary = new Secretary();
        secretary.sight(documentForAccountant);
    }

    private static void runDocumentForHumanResource() {
        Document documentForHR = new DocumentBuilder().title("Statement of remuneration")
                .body("Salary, Big Boss, 1000")
                .build();

        log.trace("Document for HR: {}", documentForHR);

        Sighter secretary = new Secretary();
        secretary.sight(documentForHR);
    }

    private static void runDocumentWithSpam() {
        Document documentSpam = new DocumentBuilder().title("Very important document")
                .body("tra-la-lala")
                .tag("spam")
                .build();

        log.trace("Document with spam: {}", documentSpam);

        Sighter secretary = new Secretary();
        secretary.sight(documentSpam);
    }

    private static void runSecretDocument() {
        Document secretDocument = new DocumentBuilder().title("Just a letter")
                .body("top bla-bla-bla secret")
                .tag("court")
                .build();
        secretDocument.addComment(LAWYER_AGREEMENT_COMMENT);

        log.trace("Document with spam: {}", secretDocument);

        Sighter secretary = new Secretary();
        secretary.sight(secretDocument);
    }
}
