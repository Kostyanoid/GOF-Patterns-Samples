package rk.samples.gofpatterns.chain.handler;

import lombok.extern.log4j.Log4j2;
import rk.samples.gofpatterns.chain.model.Document;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

@Log4j2
public abstract class AbstractSighter implements Sighter, Verifier {
    protected LinkedHashMap<Predicate<Document>, Sighter> checks = new LinkedHashMap<>();
    protected LinkedList<Sighter> nextSighters = new LinkedList<>();

    @Override
    public void sight(Document document) {
        log.info("{} has received document {}", getName(), document);
        addSigthersByChecks(document);
        if (!verify(document)) document.setNotApproved();
        log.info("{} has verified document {}. Approved is {}", getName(), document, document.isApproved());
        sendDocumentToNextSigthers(document);
        if (document.isNotApproved()) {
            log.info("{} has sent back document since it is not approved.", getName());
        }
    }

    private void addSigthersByChecks(Document document) {
        checks.forEach((p, s) -> {
            if (p.test(document)) {
                addSighter(s);
                log.info("{} has added sigther {} to the document {}", getName(), s.getName(), document);
            }
        });
    }

    private void sendDocumentToNextSigthers(Document document) {
        while (document.isApproved() && isThereMoreSigthers()) {
            getNextSighter().ifPresent(sighter -> {
                log.info("{} has sent the document {} to {}", getName(), document, sighter.getName());
                sighter.sight(document);
            });
        }
    }

    protected void addCheck(Predicate<Document> check, Sighter sighter) {
        checks.putIfAbsent(check, sighter);
    }

    protected void addSighter(Sighter newSigther) {
        nextSighters.offer(newSigther);
    }

    protected Optional<Sighter> getNextSighter() {
        return Optional.ofNullable(nextSighters.poll());
    }

    protected boolean isThereMoreSigthers() {
        return !nextSighters.isEmpty();
    }
}
