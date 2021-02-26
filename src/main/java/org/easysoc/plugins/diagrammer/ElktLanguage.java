package org.easysoc.plugins.diagrammer;

import com.intellij.lang.Language;

public class ElktLanguage extends Language {
    public static final ElktLanguage INSTANCE = new ElktLanguage();

    private ElktLanguage() {
        super("Elkt");
    }
}
