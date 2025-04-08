package com.thepcenter.DreamAnalitics.dto;

import java.util.ArrayList;
import java.util.List;

public class DreamReport {
    private String summary;
    private List<String> analysisSections = new ArrayList<>();
    private String graphicInterpretation;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getAnalysisSections() {
        return analysisSections;
    }

    public void setAnalysisSections(List<String> analysisSections) {
        this.analysisSections = analysisSections;
    }

    public String getGraphicInterpretation() {
        return graphicInterpretation;
    }

    public void setGraphicInterpretation(String graphicInterpretation) {
        this.graphicInterpretation = graphicInterpretation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== INFORME DE SUEÑO ==========\n\n");

        if (summary != null && !summary.isBlank()) {
            sb.append("📝 Resumen:\n").append(summary).append("\n\n");
        }

        if (analysisSections != null && !analysisSections.isEmpty()) {
            sb.append("📊 Secciones de Análisis:\n");
            for (String section : analysisSections) {
                sb.append("- ").append(section).append("\n");
            }
            sb.append("\n");
        }

        if (graphicInterpretation != null && !graphicInterpretation.isBlank()) {
            sb.append("🖼️ Interpretación Gráfica:\n").append(graphicInterpretation).append("\n");
        }

        sb.append("======================================\n");

        return sb.toString();
    }
}