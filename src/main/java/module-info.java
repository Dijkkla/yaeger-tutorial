module waterworld {
    requires hanyaeger;
	requires javafx.graphics;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
}
