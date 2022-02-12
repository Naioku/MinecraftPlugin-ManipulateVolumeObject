package pl.adrian_komuda.manipulate_volume_object.change_option;

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
