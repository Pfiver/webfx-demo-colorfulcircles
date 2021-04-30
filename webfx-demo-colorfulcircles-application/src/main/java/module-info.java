// File managed by WebFX (DO NOT EDIT MANUALLY)

import dev.webfx.demo.charts.ChartDemo;

module webfx.demo.colorfulcircles.application {

    // Direct dependencies modules
    requires java.base;
    requires java.logging;

    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;

    // Exported packages
    exports dev.webfx.demo.charts;

    // Provided services
    provides javafx.application.Application with ChartDemo;

}
