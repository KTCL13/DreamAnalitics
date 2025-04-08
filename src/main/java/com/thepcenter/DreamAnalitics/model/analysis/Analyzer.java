package com.thepcenter.DreamAnalitics.model.analysis;

import com.thepcenter.DreamAnalitics.model.Dream;

public interface Analyzer {
    String analyze(Dream dream);
    String getNombre();
}
