package com.thepcenter.DreamAnalitics.service.builder;

import com.thepcenter.DreamAnalitics.dto.DreamReport;
import com.thepcenter.DreamAnalitics.model.Dream;
import com.thepcenter.DreamAnalitics.model.analysis.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DreamReportBuilder implements ReportBuilder {
    private final DreamReport report = new DreamReport();
    private final Analyzer conductualCognitiveAnalyzer = new ConductualCognitiveAnalyzer();
    private final Analyzer conductualEmotionAnalyzer = new ConductualEmotionAnalyzer();
    private final Analyzer conductualStatisticalAnalyzer = new ConductualStatisticalAnalyzer();
    private final Analyzer conductualSymbolicAnalyzer = new ConductualSymbolicAnalyzer();
    private final Analyzer jungianCognitiveAnalyzer = new JungianCognitiveAnalyzer();
    private final Analyzer jungianEmotionAnalyzer = new JungianEmotionAnalyzer();
    private final Analyzer jungianStatisticalAnalyzer = new JungianStatisticalAnalyzer();
    private final Analyzer jungianSymbolicAnalyzer = new JungianSymbolicAnalyzer();

    public DreamReportBuilder withSummary(Dream dream) {
        report.setSummary("Resumen: " + dream.getDescripcion());
        return this;
    }

    public DreamReportBuilder withSections(String[] selectedSections, Dream dream) {
        for (String section : selectedSections) {
            switch (section) {
                case "1":
                    report.getAnalysisSections().add(conductualCognitiveAnalyzer.analyze(dream));
                    break;
                case "2":
                    report.getAnalysisSections().add(conductualEmotionAnalyzer.analyze(dream));
                    break;
                case "3":
                    report.getAnalysisSections().add(conductualStatisticalAnalyzer.analyze(dream));
                    break;
                case "4":
                    report.getAnalysisSections().add(conductualSymbolicAnalyzer.analyze(dream));
                    break;
                case "5":
                    report.getAnalysisSections().add(jungianCognitiveAnalyzer.analyze(dream));
                    break;
                case "6":
                    report.getAnalysisSections().add(jungianEmotionAnalyzer.analyze(dream));
                    break;
                case "7":
                    report.getAnalysisSections().add(jungianStatisticalAnalyzer.analyze(dream));
                    break;
                case "8":
                    report.getAnalysisSections().add(jungianSymbolicAnalyzer.analyze(dream));
                    break;
            }
        }
        return this;
    }

    public DreamReportBuilder withGraphicInterpretation() {
        report.setGraphicInterpretation("Interpretación gráfica...");
        return this;
    }

    public DreamReport build() {
        return report;
    }
}