package com.thepcenter.DreamAnalitics.model.analysis;

import com.thepcenter.DreamAnalitics.model.Dream;

public class EmotionalAnalyzer {
    public String analyze(Dream dream) {
        return "Emociones encontradas en: " + dream.getDescription();
    }
}