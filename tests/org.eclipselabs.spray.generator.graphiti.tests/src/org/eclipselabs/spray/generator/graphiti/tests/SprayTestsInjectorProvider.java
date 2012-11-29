package org.eclipselabs.spray.generator.graphiti.tests;

import com.google.inject.Injector;

/**
 * Sets up also bindings for Graphiti Generator and Runtime.
 * 
 * @author Karsten Thoms
 */
public class SprayTestsInjectorProvider extends SprayInjectorProvider {
    private Injector injector;

    @Override
    public Injector internalCreateInjector() {
        if (injector == null) {
            this.injector = new SprayTestsStandaloneSetup().createInjectorAndDoEMFRegistration();
        }
        return injector;
    }
}
