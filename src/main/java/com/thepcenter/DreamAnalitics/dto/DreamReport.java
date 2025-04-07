package com.thepcenter.DreamAnalitics.dto;

public class DreamReport {
    private String summary;
    private String symbolicSection;
    private String emotionalSection;
    private String cognitiveSection;
    private String statisticSection;
    private String graphicalInsights;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSymbolicSection() {
        return symbolicSection;
    }

    public void setSymbolicSection(String symbolicSection) {
        this.symbolicSection = symbolicSection;
    }

    public String getEmotionalSection() {
        return emotionalSection;
    }

    public void setEmotionalSection(String emotionalSection) {
        this.emotionalSection = emotionalSection;
    }

    public String getCognitiveSection() {
        return cognitiveSection;
    }

    public void setCognitiveSection(String cognitiveSection) {
        this.cognitiveSection = cognitiveSection;
    }

    public String getStatisticSection() {
        return statisticSection;
    }

    public void setStatisticSection(String statisticSection) {
        this.statisticSection = statisticSection;
    }

    public String getGraphicalInsights() {
        return graphicalInsights;
    }

    public void setGraphicalInsights(String graphicalInsights) {
        this.graphicalInsights = graphicalInsights;
    }
}