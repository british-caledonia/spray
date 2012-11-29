package org.eclipselabs.spray.generator.graphiti.tests.mod4j.mod4j

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.spray.generator.graphiti.tests.AbstractSprayGeneratorTest
import org.eclipselabs.spray.generator.graphiti.tests.SprayTestsInjectorProvider
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(SprayTestsInjectorProvider))
class ActivatorTest extends AbstractSprayGeneratorTest {

    @Test
    def void test() {
       val fsa = triggerGenerator("mod4j/mod4j-busmod.spray")
       val keyClass = "DEFAULT_OUTPUTorg/eclipselabs/spray/examples/mod4j/Activator.java"
       assertTrue(keyClass + " should have been generated", fsa.files.containsKey(keyClass))
       assertEquals(keyClass + " should have the expected content", fsa.files.get(keyClass).toString, expectedContent.toString)
    }

    def private expectedContent() '''
        /*************************************************************************************
         *
         * Generated by Spray PluginActivator.xtend
         *
         * This file contains generated and should not be changed.
         * Use the extension point class (the direct subclass of this class) to add manual code
         *
         *************************************************************************************/
        package org.eclipselabs.spray.examples.mod4j;
        
        import org.eclipse.ui.plugin.AbstractUIPlugin;
        import org.eclipse.xtext.util.Modules2;
        import org.eclipselabs.spray.runtime.graphiti.GraphitiRuntimeModule;
        import org.osgi.framework.BundleContext;
        
        import com.google.inject.Guice;
        import com.google.inject.Injector;
        
        /**
         * The activator class controls the plug-in life cycle
         */
        public class Activator extends AbstractUIPlugin {
            private Injector           injector;
        
            // The plug-in ID
            public static final String PLUGIN_ID = "spray"; //$NON-NLS-1$
        
            // The shared instance
            private static Activator   plugin;
        
            /*
             * (non-Javadoc)
             * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
             */
            public void start(BundleContext context) throws Exception {
                super.start(context);
                plugin = this;
                injector = createInjector();
            }
        
            /*
             * (non-Javadoc)
             * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
             */
            public void stop(BundleContext context) throws Exception {
                plugin = null;
                super.stop(context);
            }
        
            /**
             * Returns the shared instance
             * 
             * @return the shared instance
             */
            public static Activator getDefault() {
                return plugin;
            }
        
            protected Injector createInjector() {
                return Guice.createInjector(Modules2.mixin(new GraphitiRuntimeModule(), new Mod4jModule()));
            }
        
            public final Injector getInjector() {
                return injector;
            }
        
            public static final <T> T get(Class<T> type) {
                return getDefault().getInjector().getInstance(type);
            }
        }
    '''
}
