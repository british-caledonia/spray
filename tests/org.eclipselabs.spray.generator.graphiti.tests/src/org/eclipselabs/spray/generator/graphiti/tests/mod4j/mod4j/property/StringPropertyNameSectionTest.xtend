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
class StringPropertyNameSectionTest extends AbstractSprayGeneratorTest {

    @Test
    def void test() {
       val fsa = triggerGenerator("mod4j/mod4j-busmod.spray")
       val keyClass = "DEFAULT_OUTPUTorg/eclipselabs/spray/examples/mod4j/property/StringPropertyNameSection.java"
       assertTrue(keyClass + " should have been generated", fsa.files.containsKey(keyClass))
       assertEquals(keyClass + " should have the expected content", fsa.files.get(keyClass).toString, expectedContent.toString)
    }

    def private expectedContent() '''
        /*************************************************************************************
         *
         * Generated by Spray PropertySection.xtend
         * 
         * This file is an extension point: copy to "src" folder to manually add code to this
         * extension point.
         *
         *************************************************************************************/
        package org.eclipselabs.spray.examples.mod4j.property;
        
        public class StringPropertyNameSection extends StringPropertyNameSectionBase {
        
        }
    '''
}
