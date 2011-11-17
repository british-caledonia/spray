package org.eclipselabs.spray.generator.graphiti.templates.diagram

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xtend2.lib.StringConcatenation
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator
import org.eclipselabs.spray.generator.graphiti.util.NamingExtensions
import org.eclipselabs.spray.mm.spray.Behavior
import org.eclipselabs.spray.mm.spray.Connection
import org.eclipselabs.spray.mm.spray.Container
import org.eclipselabs.spray.mm.spray.CreateBehavior
import org.eclipselabs.spray.mm.spray.Diagram
import org.eclipselabs.spray.mm.spray.MetaClass
import org.eclipselabs.spray.mm.spray.MetaReference

import static org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil.*

import static extension org.eclipselabs.spray.generator.graphiti.util.MetaModel.*

class ToolBehaviorProvider extends FileGenerator {
    @Inject extension NamingExtensions
    
    override StringConcatenation generateBaseFile(EObject modelElement) {
        mainFile( modelElement as Diagram, javaGenFile.baseClassName)
    }

    override StringConcatenation generateExtensionFile(EObject modelElement) {
        mainExtensionPointFile( modelElement as Diagram, javaGenFile.className)
    }
    
    def mainExtensionPointFile(Diagram diagram, String className) '''
        «extensionHeader(this)»
        package «diagram_package()»;
        
        import org.eclipse.graphiti.dt.IDiagramTypeProvider;
         
        public class «className» extends «className»Base {
            public «className»(IDiagramTypeProvider dtp) {
                super(dtp);
            }
        }
    '''

    def mainFile(Diagram diagram, String className) '''
        «header(this)»
        package «diagram_package()»;

        import java.util.HashMap;
        import java.util.Map;
        
        import org.eclipse.graphiti.dt.IDiagramTypeProvider;
        import org.eclipse.graphiti.features.ICreateConnectionFeature;
        import org.eclipse.graphiti.features.ICreateFeature;
        import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
        import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
        import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
        import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
        import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
        // MARKER_IMPORT
        public class «className» extends DefaultToolBehaviorProvider {
            «generate_additionalFields(diagram)»
            public «className»(IDiagramTypeProvider dtp) {
                super(dtp);
            }
        
        
            @Override
            public IPaletteCompartmentEntry[] getPalette() {
                Map<String, PaletteCompartmentEntry> compartments = new HashMap<String, PaletteCompartmentEntry>();
        
        «FOR metaClass : diagram.metaClasses.filter(m|m.representedBy instanceof Container)»
                «FOR behavior : metaClass.behaviors.filter(typeof(CreateBehavior)) »
                {
                    ICreateFeature createFeature = new «metaClass.createFeatureClassName.shortName»(this.getFeatureProvider());
                    ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(createFeature.getCreateName(), createFeature.getCreateDescription(), createFeature.getCreateImageId(), createFeature.getCreateLargeImageId(), createFeature);
                    PaletteCompartmentEntry compartment = compartments.get("«behavior.paletteCompartment»");
                    if( compartment == null ){
                        compartment = new PaletteCompartmentEntry("«behavior.paletteCompartment»", null);
                    }
                    compartments.put("«behavior.paletteCompartment»", compartment);
                    compartment.addToolEntry(objectCreationToolEntry);
                }
                
                «var container = metaClass.representedBy as Container»
                «FOR reference : container.parts.filter(typeof(MetaReference))»
                    «val target = reference.target »  
                    «IF ! target.EReferenceType.abstract»
                    «objectCreationEntry(reference.createFeatureClassName.shortName, "Other")»
//                    , new «reference.createFeatureClassName»(this)
                    «ENDIF»
                    «FOR subclass : target.EReferenceType.getSubclasses() »
                        «IF ! subclass.abstract »
                            «objectCreationEntry(reference.getCreateReferenceAsListFeatureClassName(subclass).shortName, "Other")»
//                    , new «reference.getCreateReferenceAsListFeatureClassName(subclass)»«subclass.name»Feature(this)
                        «ENDIF»
                    «ENDFOR»
                «ENDFOR»    
                «ENDFOR»
            «ENDFOR»

            «FOR container : diagram.metaClasses.filter( m | m.representedBy instanceof Container).map(m | m.representedBy as Container) »
                «FOR metaRef : container.parts.filter(typeof(MetaReference)) »
                «val metaRefName = metaRef.name»
                «val target = metaRef.target » 
                «val createFeatureName = diagram.name + "Create" + container.represents.name + metaRef.name + target.EReferenceType.name + "Feature" »
                // 00000 Embedded list of references «createFeatureName»
//                {
//                    ICreateFeature createFeature = new !!!addToImports(feature_package(), createFeatureName)!!!(this.getFeatureProvider());
//                    ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(createFeature.getCreateName(), createFeature.getCreateDescription(), createFeature.getCreateImageId(), createFeature.getCreateLargeImageId(), createFeature);
//                    PaletteCompartmentEntry compartment = compartments.get("Other");
//                    if( compartment == null ){
//                        compartment = new PaletteCompartmentEntry("Other", null);
//                    }
//                    compartments.put("Other", compartment);
//                    compartment.addToolEntry(objectCreationToolEntry);
//                }
                «ENDFOR»
            «ENDFOR»
        
            // do the same for connection creators
            «FOR MetaClass mc : diagram.metaClasses.filter(m|m.representedBy instanceof Connection)»
            «FOR Behavior behavior: mc.behaviors.filter(typeof(CreateBehavior))»
                {
                    ICreateConnectionFeature createFeature = new «mc.createFeatureClassName.shortName»(this.getFeatureProvider());
                    ConnectionCreationToolEntry objectCreationToolEntry = new ConnectionCreationToolEntry(createFeature.getCreateName(), createFeature.getCreateDescription(), createFeature.getCreateImageId(), createFeature.getCreateLargeImageId());
                    objectCreationToolEntry.addCreateConnectionFeature(createFeature);
                    PaletteCompartmentEntry compartment = compartments.get("«behavior.paletteCompartment»");
                    if( compartment == null ){
                        compartment = new PaletteCompartmentEntry("«behavior.paletteCompartment»", null);
                    }
                    compartments.put("«behavior.paletteCompartment»", compartment);
                    compartment.addToolEntry(objectCreationToolEntry);
                }
            «ENDFOR»
            «ENDFOR»
            
            «FOR metaClass: diagram.metaClasses»
                «FOR reference : metaClass.references »
                {
                    // «reference.name»
                    ICreateConnectionFeature createFeature = new «reference.createReferenceAsConnectionFeatureClassName.shortName»(this.getFeatureProvider());
                    ConnectionCreationToolEntry objectCreationToolEntry = new ConnectionCreationToolEntry(createFeature.getCreateName(), createFeature.getCreateDescription(), createFeature.getCreateImageId(), createFeature.getCreateLargeImageId());
                    objectCreationToolEntry.addCreateConnectionFeature(createFeature);
                    PaletteCompartmentEntry compartment = compartments.get("Other");
                    if( compartment == null ){
                        compartment = new PaletteCompartmentEntry("Other", null);
                    }
                    compartments.put("Other", compartment);
                    compartment.addToolEntry(objectCreationToolEntry);
                }
                «ENDFOR»
            «ENDFOR»
                IPaletteCompartmentEntry[] res = compartments.values().toArray(new IPaletteCompartmentEntry[compartments.size()]);
                return res;
            }
            «generate_additionalFields(diagram)»
        }
    '''
    
    def objectCreationEntry(String className, String paletteCompartment) '''
        {
            ICreateFeature createFeature = new «className»(this.getFeatureProvider());
            ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(createFeature.getCreateName(), createFeature.getCreateDescription(), createFeature.getCreateImageId(), createFeature.getCreateLargeImageId(), createFeature);
            PaletteCompartmentEntry compartment = compartments.get("«paletteCompartment»");
            if( compartment == null ){
                compartment = new PaletteCompartmentEntry("«paletteCompartment»", null);
            }
            compartments.put("«paletteCompartment»", compartment);
            compartment.addToolEntry(objectCreationToolEntry);
        }
    '''
    
}