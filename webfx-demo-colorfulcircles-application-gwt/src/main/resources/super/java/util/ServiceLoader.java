// File managed by WebFX (DO NOT EDIT MANUALLY)
package java.util;

import java.util.Iterator;
import java.util.logging.Logger;
import dev.webfx.platform.shared.util.function.Factory;

public class ServiceLoader<S> implements Iterable<S> {

    public static <S> ServiceLoader<S> load(Class<S> serviceClass) {
        switch (serviceClass.getName()) {
            case "dev.webfx.kit.launcher.spi.WebFxKitLauncherProvider": return new ServiceLoader<S>(dev.webfx.kit.launcher.spi.gwt.GwtWebFxKitLauncherProvider::new);
            case "dev.webfx.kit.mapper.spi.WebFxKitMapperProvider": return new ServiceLoader<S>(dev.webfx.kit.mapper.spi.gwt.GwtWebFxKitHtmlMapperProvider::new);
            case "dev.webfx.platform.client.services.uischeduler.spi.UiSchedulerProvider": return new ServiceLoader<S>(dev.webfx.platform.gwt.services.uischeduler.spi.impl.GwtUiSchedulerProvider::new);
            case "dev.webfx.platform.gwt.services.resource.spi.impl.GwtResourceBundle": return new ServiceLoader<S>();
            case "dev.webfx.platform.shared.services.appcontainer.spi.ApplicationContainerProvider": return new ServiceLoader<S>(dev.webfx.platform.gwt.services.appcontainer.spi.impl.GwtApplicationContainerProvider::new);
            case "dev.webfx.platform.shared.services.appcontainer.spi.ApplicationJob": return new ServiceLoader<S>();
            case "dev.webfx.platform.shared.services.appcontainer.spi.ApplicationModuleInitializer": return new ServiceLoader<S>(dev.webfx.kit.launcher.WebFxKitLauncherModuleInitializer::new, dev.webfx.platform.shared.services.appcontainer.spi.impl.ApplicationJobsStarter::new, dev.webfx.platform.gwt.services.resource.spi.impl.GwtResourceModuleInitializer::new);
            case "dev.webfx.platform.shared.services.log.spi.LoggerProvider": return new ServiceLoader<S>(dev.webfx.platform.gwt.services.log.spi.impl.GwtLoggerProvider::new);
            case "dev.webfx.platform.shared.services.resource.spi.ResourceServiceProvider": return new ServiceLoader<S>(dev.webfx.platform.gwt.services.resource.spi.impl.GwtResourceServiceProvider::new);
            case "dev.webfx.platform.shared.services.scheduler.spi.SchedulerProvider": return new ServiceLoader<S>(dev.webfx.platform.gwt.services.uischeduler.spi.impl.GwtUiSchedulerProvider::new);
            case "dev.webfx.platform.shared.services.shutdown.spi.ShutdownProvider": return new ServiceLoader<S>(dev.webfx.platform.gwt.services.shutdown.spi.impl.GwtShutdownProvider::new);
            case "javafx.application.Application": return new ServiceLoader<S>(dev.webfx.demo.colorfulcircles.ColorfulCircles::new);

            // UNKNOWN SPI
            default:
                Logger.getLogger(ServiceLoader.class.getName()).warning("Unknown " + serviceClass + " SPI - returning no provider");
                return new ServiceLoader<S>();
        }
    }

    private final Factory[] factories;

    public ServiceLoader(Factory... factories) {
        this.factories = factories;
    }

    public Iterator<S> iterator() {
        return new Iterator<S>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < factories.length;
            }

            @Override
            public S next() {
                return (S) factories[index++].create();
            }
        };
    }
}