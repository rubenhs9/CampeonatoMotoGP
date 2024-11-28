package data;

public enum Pais {
    ESPAÑA(".\\res\\imgPais\\España.png"),
    ITALIA(".\\res\\imgPais\\Italia.png"),
    FRANCIA(".\\res\\imgPais\\Francia.png"),
    JAPÓN(".\\res\\imgPais\\Japón.png"),
    SUDAFRICA(".\\res\\imgPais\\Sudáfrica.png"),
    AUSTRALIA(".\\res\\imgPais\\Australia.png"),
    PORTUGAL(".\\res\\imgPais\\Portugal.png"),
    MONACO(".\\res\\imgPais\\Monaco.png"),
    AUSTRIA(".\\res\\imgPais\\Austria.png"),
    USA(".\\res\\imgPais\\USA.png");

    private final String rutaImagen;

    Pais(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}
