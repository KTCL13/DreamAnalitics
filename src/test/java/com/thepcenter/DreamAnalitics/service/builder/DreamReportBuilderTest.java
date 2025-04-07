package com.thepcenter.DreamAnalitics.service.builder;

import com.thepcenter.DreamAnalitics.dto.DreamReport;
import com.thepcenter.DreamAnalitics.model.Dream;
import com.thepcenter.DreamAnalitics.model.analysis.EmotionalAnalyzer;
import com.thepcenter.DreamAnalitics.model.analysis.SymbolicAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DreamReportBuilderTest {

    @Test
    void shouldBuildDynamicReportFromDream() {
        // Arrange
        Dream dream = new Dream("Estaba volando sobre un mar oscuro");
        SymbolicAnalyzer symbolic = new SymbolicAnalyzer();
        EmotionalAnalyzer emotional = new EmotionalAnalyzer();


        DreamReport report = new DreamReportBuilder()
                .withSummary(dream)
                .withSymbolicSection(symbolic.analyze(dream))
                .withEmotionalSection(emotional.analyze(dream))
                .build();


        assertEquals("Resumen: Estaba volando sobre un mar oscuro", report.getSummary());
        assertEquals("Análisis simbólico de: Estaba volando sobre un mar oscuro", report.getSymbolicSection());
        assertEquals("Emociones encontradas en: Estaba volando sobre un mar oscuro", report.getEmotionalSection());
    }
}
