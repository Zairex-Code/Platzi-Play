package platzi.play.content;

public enum Quality {
    SD_480P("480p (SD)", 854, 480),
    HD_720P("720p (HD)", 1280, 720),
    FHD_1080P("1080p (FHD)", 1920, 1080),
    QHD_1440P("1440p (2K)", 2560, 1440),
    UHD_4K("4K (UHD)", 3840, 2160),
    UHD_8K("8K (UHD)", 7680, 4320);

    private final String displayName;
    private final int width;
    private final int height;

    // Constructor
    Quality(String displayName, int width, int height) {
        this.displayName = displayName;
        this.width = width;
        this.height = height;
    }

    // Métodos para obtener los datos
    public String getDisplayName() {
        return displayName;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Método extra: Devuelve algo como "1920x1080"
    public String getResolution() {
        return width + "x" + height;
    }
}