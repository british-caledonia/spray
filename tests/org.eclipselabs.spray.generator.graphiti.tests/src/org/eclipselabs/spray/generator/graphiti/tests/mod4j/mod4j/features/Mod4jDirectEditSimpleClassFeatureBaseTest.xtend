package org.eclipselabs.spray.generator.graphiti.tests.mod4j.mod4j.features

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.spray.generator.graphiti.tests.AbstractSprayGeneratorTest
import org.eclipselabs.spray.generator.graphiti.tests.SprayTestsInjectorProvider
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner2))
@InjectWith(typeof(SprayTestsInjectorProvider))
class Mod4jDirectEditSimpleClassFeatureBaseTest extends AbstractSprayGeneratorTest {

    @Test
    def void test() {
       val fsa = triggerGenerator("mod4j/mod4j-busmod.spray")
       val keyClass = "DEFAULT_OUTPUTorg/eclipselabs/spray/examples/mod4j/features/Mod4jDirectEditSimpleClassFeatureBase.java"
       assertTrue(keyClass + " should have been generated", fsa.files.containsKey(keyClass))
       assertEquals(keyClass + " should have the expected content", fsa.files.get(keyClass).toString, expectedContent.toString)
    }

    def private expectedContent() '''
        /*************************************************************************************
         *
         * Generated by Spray DirectEditFeature.xtend
         *
         * This file contains generated and should not be changed.
         * Use the extension point class (the direct subclass of this class) to add manual code
         *
         *************************************************************************************/
        package org.eclipselabs.spray.examples.mod4j.features;
        
        import org.eclipse.graphiti.features.IFeatureProvider;
        import org.eclipse.graphiti.features.context.IDirectEditingContext;
        import org.eclipse.graphiti.mm.pictograms.PictogramElement;
        import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
        import org.eclipse.graphiti.mm.algorithms.Text;
        import org.eclipse.graphiti.services.Graphiti;
        import org.eclipse.graphiti.services.IPeService;
        import org.eclipselabs.spray.runtime.graphiti.features.AbstractDirectEditingFeature;
        import samplepackage.BusinessClass;
        
        public abstract class Mod4jDirectEditSimpleClassFeatureBase extends AbstractDirectEditingFeature {
        
            protected IPeService peService = Graphiti.getPeService();
        
            public Mod4jDirectEditSimpleClassFeatureBase(IFeatureProvider fp) {
                super(fp);
            }
        
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean canDirectEdit(IDirectEditingContext context) {
                PictogramElement pe = context.getPictogramElement();
                Object bo = getBusinessObjectForPictogramElement(pe);
                GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
                // support direct editing, if it is a BusinessClass, and the user clicked
                // directly on the text and not somewhere else in the rectangle
                if (bo instanceof BusinessClass && ga instanceof Text) {
                    return true;
                }
                // direct editing not supported in all other cases
                return false;
            }
        
            /**
             * {@inheritDoc}
             */
            @Override
            public String getInitialValue(IDirectEditingContext context) {
                // return the initial value of the clicked text on the BusinessClass
                PictogramElement pe = context.getPictogramElement();
                BusinessClass eClass = (BusinessClass) getBusinessObjectForPictogramElement(pe);
                Text gAlg = (Text) context.getGraphicsAlgorithm();
                String id = peService.getPropertyValue(gAlg, TEXT_ID);
                if (id.equals("classname")) {
                    return eClass.getName();
                }
                return "";
            }
        
            /**
             * {@inheritDoc}
             */
            @Override
            public int getEditingType() {
                return TYPE_TEXT;
            }
        
            /**
             * {@inheritDoc}
             */
            @Override
            public void setValue(final String value, final IDirectEditingContext context) {
                // set the new value on the BusinessClass
                final PictogramElement pe = context.getPictogramElement();
                BusinessClass eClass = (BusinessClass) getBusinessObjectForPictogramElement(pe);
                Text gAlg = (Text) context.getGraphicsAlgorithm();
                String id = peService.getPropertyValue(gAlg, TEXT_ID);
                if (id.equals("classname")) {
                    eClass.setName(value);
                }
                updatePictogramElement(pe);
            }
        }
    '''
}
