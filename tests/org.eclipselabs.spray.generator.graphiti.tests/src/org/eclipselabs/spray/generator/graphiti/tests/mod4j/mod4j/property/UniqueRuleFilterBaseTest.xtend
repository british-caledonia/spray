package org.eclipselabs.spray.generator.graphiti.tests.mod4j.mod4j.property

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.spray.generator.graphiti.tests.AbstractSprayGeneratorTest
import org.eclipselabs.spray.generator.graphiti.tests.SprayTestsInjectorProvider
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(SprayTestsInjectorProvider))
class UniqueRuleFilterBaseTest extends AbstractSprayGeneratorTest {

    @Test
    def void test() {
       val fsa = triggerGenerator("mod4j/mod4j-busmod.spray")
       val keyClass = "DEFAULT_OUTPUTorg/eclipselabs/spray/examples/mod4j/property/UniqueRuleFilterBase.java"
       assertTrue(keyClass + " should have been generated", fsa.files.containsKey(keyClass))
       assertEquals(keyClass + " should have the expected content", fsa.files.get(keyClass).toString, expectedContent.toString)
    }

    def private expectedContent() '''
        /*************************************************************************************
         *
         * Generated by Spray Filter.xtend
         *
         * This file contains generated and should not be changed.
         * Use the extension point class (the direct subclass of this class) to add manual code
         *
         *************************************************************************************/
        package org.eclipselabs.spray.examples.mod4j.property;
        
        import org.eclipse.emf.ecore.EObject;
        import org.eclipse.graphiti.mm.pictograms.PictogramElement;
        import org.eclipse.graphiti.services.Graphiti;
        import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;
        
        import samplepackage.UniqueRule;
        
        public class UniqueRuleFilterBase extends AbstractPropertySectionFilter {
        
            /**
             * {@inheritDoc}
             */
            @Override
            protected boolean accept(final PictogramElement pe) {
                final EObject eObject = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
                if (eObject instanceof UniqueRule) {
                    return true;
                }
                return false;
            }
        }
    '''
}
