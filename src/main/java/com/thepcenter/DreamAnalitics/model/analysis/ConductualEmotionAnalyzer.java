package com.uptc.model.analysis;

import com.uptc.model.Dream;

public class ConductualEmotionAnalyzer implements EmotionAnalyzer {
    @Override
    public String analyze(Dream dream) {
        return "Análisis emocional conductual: identificación de emociones observables en el relato.";
    }
}
