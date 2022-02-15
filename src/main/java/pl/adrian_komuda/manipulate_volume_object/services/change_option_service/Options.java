package pl.adrian_komuda.manipulate_volume_object.services.change_option_service;

public enum Options {
    COPY("copy"),
    PASTE("paste"),
    DELETE("delete");

    private final String name;

    Options(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
