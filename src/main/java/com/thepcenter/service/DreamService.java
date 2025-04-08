package com.thepcenter.service;
import com.thepcenter.model.Dream;
import com.thepcenter.model.*;
import org.springframework.stereotype.Service;

@Service
public class DreamService {

    private Patient patient = new Patient("Ana");

    public Dream registerDream(int duration, String intensity, String clarity) {
        Dream dream = new Dream(duration, intensity, clarity, null);
        patient.addDream(dream);
        return dream;
    }

    public Dream cloneDream(int index) {
        if (index < 0 || index >= patient.getDreams().size()) {
            throw new IndexOutOfBoundsException("No se encontró el sueño");
        }
        Dream clone = patient.getDreams().get(index).cloneDream();
        patient.addDream(clone);
        return clone;
    }

    public Patient getPatient() {
        return patient;
    }
}