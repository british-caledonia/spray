/*
 * generated by Xtext
 */
package org.eclipselabs.spray.xtext.formatting;

import java.util.List;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.eclipselabs.spray.xtext.services.SprayGrammarAccess;

/**
 * This class contains custom formatting description.
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class SprayFormatter extends AbstractDeclarativeFormatter {

    @Override
    protected void configureFormatting(FormattingConfig c) {
        SprayGrammarAccess f = (SprayGrammarAccess) getGrammarAccess();

        c.setAutoLinewrap(120);

        handleImport(c, f);
        handleDiagram(c, f);
        handleBehavior(c, f);
        handleMetaclass(c, f);

        handleSeparators(c, f.findKeywords(";", ","));
        handleBrackets(c, f.findKeywordPairs("{", "}"));

        handleOperations(c, f.findKeywords("=", "=="));
        handleReferences(c, f.findKeywords(".", "::"));

        handleComments(c, f);

    }

    private void handleDiagram(FormattingConfig c, SprayGrammarAccess f) {
        c.setLinewrap(2).between(f.getImportRule(), f.getDiagramRule());
        c.setLinewrap(2).around(f.getDiagramRule());
    }

    private void handleImport(FormattingConfig c, SprayGrammarAccess f) {
        c.setLinewrap(1).after(f.getImportRule());
    }

    private void handleBehavior(FormattingConfig c, SprayGrammarAccess f) {
        c.setLinewrap(2).before(f.getBehaviorGroupAccess().getBehaviorKeyword_0());
        c.setLinewrap().before(f.getBehaviorRule());
    }

    private void handleMetaclass(FormattingConfig c, SprayGrammarAccess f) {
        c.setLinewrap(2).before(f.getMetaClassAccess().getClassKeyword_0());
        c.setLinewrap().around(f.getShapePropertyAssignmentRule());
        c.setLinewrap().around(f.getShapeCompartmentAssignmentRule());
        c.setLinewrap(2).after(f.getMetaClassRule());
    }

    private void handleSeparators(FormattingConfig c, List<Keyword> keywords) {
        for (Keyword keyword : keywords) {
            c.setNoLinewrap().before(keyword);
            c.setNoSpace().before(keyword);
            c.setLinewrap().after(keyword);
        }
    }

    private void handleBrackets(FormattingConfig c, List<Pair<Keyword, Keyword>> keywordPairs) {
        for (Pair<Keyword, Keyword> pair : keywordPairs) {
            c.setIndentation(pair.getFirst(), pair.getSecond());
            c.setLinewrap(1).after(pair.getFirst());
            c.setLinewrap(1).before(pair.getSecond());
            c.setLinewrap(1).after(pair.getSecond());
        }
    }

    private void handleReferences(FormattingConfig c, List<Keyword> operationKeywords) {
        for (Keyword keyword : operationKeywords) {
            c.setNoLinewrap().before(keyword);
            c.setNoSpace().before(keyword);
            c.setNoSpace().after(keyword);
        }
    }

    private void handleOperations(FormattingConfig c, List<Keyword> operationKeywords) {
        for (Keyword keyword : operationKeywords) {
            c.setNoLinewrap().before(keyword);
            c.setSpace(" ").before(keyword);
            c.setSpace(" ").after(keyword);
            c.setNoLinewrap().after(keyword);
        }
    }

    private void handleComments(FormattingConfig c, SprayGrammarAccess f) {
        c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
        c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
        c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());
    }
}
