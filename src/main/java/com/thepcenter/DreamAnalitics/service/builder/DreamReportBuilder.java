package com.thepcenter.DreamAnalitics.service.builder;

import com.thepcenter.DreamAnalitics.dto.DreamReport;
import com.thepcenter.DreamAnalitics.model.Dream;
import org.springframework.stereotype.Service;

@Service
public class DreamReportBuilder implements ReportBuilder {
    private final DreamReport report = new DreamReport();

    public DreamReportBuilder withSummary(Dream dream) {
        report.setSummary("Resumen: " + dream.getDescription());
        return this;
    }

    public DreamReportBuilder withSymbolicSection(String symbolic) {
        report.setSymbolicSection(symbolic);
        return this;
    }

    public DreamReportBuilder withEmotionalSection(String emotional) {
        report.setEmotionalSection(emotional);
        return this;
    }

    public DreamReportBuilder StatisticSection(String statistic) {
        report.setStatisticSection(statistic);
        return this;
    }

    public DreamReportBuilder withCognitiveSection(String cognitive) {
        report.setCognitiveSection(cognitive);
        return this;
    }

    public DreamReport build() {
        return report;
    }
}