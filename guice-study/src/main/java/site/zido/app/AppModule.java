package site.zido.app;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;

public class AppModule extends AbstractModule{

    @Override
    protected void configure() {
        final Binder bind = binder();
    }
}
