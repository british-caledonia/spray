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
class Mod4jAddBusinessClassNameOnlyFeatureBaseTest extends AbstractSprayGeneratorTest {

    @Test
    def void test() {
       val fsa = triggerGenerator("mod4j/mod4j-busmod.spray")
       val keyClass = "DEFAULT_OUTPUTorg/eclipselabs/spray/examples/mod4j/features/Mod4jAddBusinessClassNameOnlyFeatureBase.java"
       assertTrue(keyClass + " should have been generated", fsa.files.containsKey(keyClass))
       assertEquals(keyClass + " should have the expected content", fsa.files.get(keyClass).toString, expectedContent.toString)
    }

    def private expectedContent() '''
        /*************************************************************************************
         *
         * Generated by Spray AddShapeFromDslFeature.xtend
         *
         * This file contains generated and should not be changed.
         * Use the extension point class (the direct subclass of this class) to add manual code
         *
         *************************************************************************************/
        package org.eclipselabs.spray.examples.mod4j.features;
        
        import org.eclipse.emf.ecore.EObject;
        import org.eclipse.graphiti.features.IFeatureProvider;
        import org.eclipse.graphiti.features.context.IAddContext;
        import org.eclipse.graphiti.mm.pictograms.ContainerShape;
        import org.eclipse.graphiti.mm.pictograms.Shape;
        import org.eclipse.graphiti.mm.pictograms.Diagram;
        import org.eclipse.graphiti.mm.pictograms.PictogramElement;
        import org.eclipse.graphiti.services.Graphiti;
        import org.eclipse.graphiti.services.IGaService;
        import org.eclipselabs.spray.runtime.graphiti.features.AbstractAddFeature;
        import org.eclipselabs.spray.runtime.graphiti.shape.ISprayShape;
        import org.eclipselabs.spray.runtime.graphiti.layout.SprayLayoutService;
        import org.eclipselabs.spray.runtime.graphiti.GraphitiProperties;
        import org.eclipselabs.spray.examples.mod4j.shapes.null;
        import org.eclipselabs.spray.runtime.graphiti.styles.DefaultSprayStyle;
        import org.eclipselabs.spray.runtime.graphiti.styles.ISprayStyle;
        
        import samplepackage.BusinessClass;
        import samplepackage.BusinessClass;
        
        
        @SuppressWarnings("unused")
        public abstract class Mod4jAddBusinessClassNameOnlyFeatureBase extends AbstractAddFeature {
            protected final static String typeOrAliasName = "BusinessClassNameOnly";
            protected Diagram targetDiagram = null;
        
            public Mod4jAddBusinessClassNameOnlyFeatureBase(final IFeatureProvider fp) {
                super(fp);
        
            }
        
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean canAdd(final IAddContext context) {
                final EObject newObject = (EObject) context.getNewObject();
                if (newObject instanceof BusinessClass) {
                    // check if user wants to add to a diagram
                    if (context.getTargetContainer() instanceof Diagram) {
                        return true;
                    } else if (context.getTargetContainer() instanceof ContainerShape) {
                        // OLD STUFF
                        final Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
                        // NEW stuff
                        // cls samplepackage.Package refers to this metaClass»
                        if( target instanceof samplepackage.Package ){
                            if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                                String id = GraphitiProperties.get(context.getTargetContainer(), TEXT_ID);
                                if ( (id != null) && (id.equals("classes")) ) {
                                    return true;    
                                }
                            }
                        }
                        // cls samplepackage.Package refers to this metaClass»
                        if( target instanceof samplepackage.Package ){
                            if (SprayLayoutService.isCompartment(context.getTargetContainer())) {
                                String id = GraphitiProperties.get(context.getTargetContainer(), TEXT_ID);
                                if ( (id != null) && (id.equals("classes")) ) {
                                    return true;    
                                }
                            }
                        }
                   }
                }
                return false;
            }
        
            /**
             * {@inheritDoc}
             */
            @Override
            public PictogramElement add(final IAddContext context) {
                final BusinessClass addedModelElement = (BusinessClass) context.getNewObject();
                        // NEW stuff
                Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
                final ContainerShape targetContainer = context.getTargetContainer();
                final ISprayStyle style = new DefaultSprayStyle();
                final ISprayShape shape = new (getFeatureProvider());
                final ContainerShape conShape = shape.getShape(targetContainer, style);
                final IGaService gaService = Graphiti.getGaService();
                gaService.setLocation(conShape.getGraphicsAlgorithm(), context.getX(), context.getY());
                link(conShape, addedModelElement);
                linkShapes(conShape, addedModelElement);
                peService.setPropertyValue(conShape , PROPERTY_ALIAS, "BusinessClassNameOnly");
        
                setDoneChanges(true);
                updatePictogramElement(conShape);
                layout(conShape);
                
                return conShape;
            }
        
        
            protected void linkShapes(ContainerShape conShape, BusinessClass addedModelElement) {
                link(conShape, addedModelElement);
                for (Shape childShape : conShape.getChildren()) {
                   if( childShape instanceof ContainerShape ) {
                      linkShapes((ContainerShape)childShape, addedModelElement);
                   } else {
                      link(childShape, addedModelElement);
                   }
                }
            }
        }
    '''
}
