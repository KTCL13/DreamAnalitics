package com.thepcenter.DreamAnalitics.model;

public abstract class DreamRepositoryFactory {
    public abstract DreamRepository createRepository();

    public static DreamRepository create(String type) {
        switch (type.toLowerCase()) {
            case "historial":
                return new HistoricalDreamRepository();
            case "temporal":
                return new TemporaryDreamRepository();
            default:
                throw new IllegalArgumentException("Tipo de repositorio no válido: " + type);
        }
    }
}
