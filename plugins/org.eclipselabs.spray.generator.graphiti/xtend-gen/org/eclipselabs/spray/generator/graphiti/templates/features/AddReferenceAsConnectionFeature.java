package org.eclipselabs.spray.generator.graphiti.templates.features;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.generator.graphiti.util.LayoutExtensions;
import org.eclipselabs.spray.generator.graphiti.util.NamingExtensions;
import org.eclipselabs.spray.generator.graphiti.util.mm.MetaReferenceExtensions;
import org.eclipselabs.spray.mm.spray.Connection;
import org.eclipselabs.spray.mm.spray.Diagram;
import org.eclipselabs.spray.mm.spray.Layout;
import org.eclipselabs.spray.mm.spray.MetaClass;
import org.eclipselabs.spray.mm.spray.MetaReference;

@SuppressWarnings("all")
public class AddReferenceAsConnectionFeature extends FileGenerator {
  @Inject
  private NamingExtensions _namingExtensions;
  
  @Inject
  private LayoutExtensions _layoutExtensions;
  
  @Inject
  private MetaReferenceExtensions _metaReferenceExtensions;
  
  public StringConcatenation generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    StringConcatenation _mainFile = this.mainFile(((MetaReference) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public StringConcatenation generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    StringConcatenation _mainExtensionPointFile = this.mainExtensionPointFile(((MetaReference) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public StringConcatenation mainExtensionPointFile(final MetaReference metaReference, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _extensionHeader = this.extensionHeader(this);
    _builder.append(_extensionHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends ");
    _builder.append(className, "");
    _builder.append("Base {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("public ");
    _builder.append(className, "    ");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("super(fp);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("//  /**");
    _builder.newLine();
    _builder.append("//   * {@inheritDoc}");
    _builder.newLine();
    _builder.append("//   */");
    _builder.newLine();
    _builder.append("//  @Override");
    _builder.newLine();
    _builder.append("//  protected GraphicsAlgorithm createConnectionStartDecorator (IAddConnectionContext context,");
    _builder.newLine();
    _builder.append("//          Connection connection) {");
    _builder.newLine();
    _builder.append("//      ConnectionDecorator cd = peCreateService.createConnectionDecorator(");
    _builder.newLine();
    _builder.append("//              connection, /* active */false, /* location */0.0, /* isRelative */");
    _builder.newLine();
    _builder.append("//              true);");
    _builder.newLine();
    _builder.append("//      Polyline polyline = gaService.createPolyline(cd, new int[] {");
    _builder.newLine();
    _builder.append("//              -15, 10, 0, 0, -15, -10 });");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("//      polyline.setForeground(manageColor(IColorConstant.BLACK));");
    _builder.newLine();
    _builder.append("//      polyline.setLineWidth(1);");
    _builder.newLine();
    _builder.append("//      ");
    _builder.newLine();
    _builder.append("//      return polyline;");
    _builder.newLine();
    _builder.append("//      return null;");
    _builder.newLine();
    _builder.append("//  }");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//  /**");
    _builder.newLine();
    _builder.append("//   * {@inheritDoc}");
    _builder.newLine();
    _builder.append("//   */");
    _builder.newLine();
    _builder.append("//  @Override");
    _builder.newLine();
    _builder.append("//  protected GraphicsAlgorithm createConnectionEndDecorator (IAddConnectionContext context,");
    _builder.newLine();
    _builder.append("//          Connection connection) {");
    _builder.newLine();
    _builder.append("//      ConnectionDecorator cd = peCreateService.createConnectionDecorator(");
    _builder.newLine();
    _builder.append("//              connection, /* active */false, /* location */1.0, /* isRelative */");
    _builder.newLine();
    _builder.append("//              true);");
    _builder.newLine();
    _builder.append("//      Polygon polygon = gaService.createPolygon(cd, new int[] {");
    _builder.newLine();
    _builder.append("//              -12, 8, 0, 0, -12, -8, -12, 8 });");
    _builder.newLine();
    _builder.append("//");
    _builder.newLine();
    _builder.append("//      polygon.setForeground(manageColor(IColorConstant.BLACK));");
    _builder.newLine();
    _builder.append("//      polygon.setBackground(manageColor(IColorConstant.WHITE));");
    _builder.newLine();
    _builder.append("//      polygon.setFilled(Boolean.TRUE);");
    _builder.newLine();
    _builder.append("//      polygon.setLineWidth(1);");
    _builder.newLine();
    _builder.append("//      ");
    _builder.newLine();
    _builder.append("//      return polygon;");
    _builder.newLine();
    _builder.append("//  }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation mainFile(final MetaReference reference, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    StringConcatenation _header = this.header(this);
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.emf.ecore.EObject;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IAddConnectionContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IAddContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.AnchorContainer;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Connection;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.PictogramElement;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.Polyline;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.IGaService;");
    _builder.newLine();
    _builder.append("import org.eclipselabs.spray.runtime.graphiti.features.AbstractAddConnectionFeature;");
    _builder.newLine();
    _builder.append("// MARKER_IMPORT");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractAddConnectionFeature {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_additionalFields = this.generate_additionalFields(reference);
    _builder.append(_generate_additionalFields, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    _builder.append(className, "    ");
    _builder.append("(IFeatureProvider fp) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("super(fp);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("gaService = ");
    Diagram _diagram = this._metaReferenceExtensions.getDiagram(reference);
    String _activatorClassName = this._namingExtensions.getActivatorClassName(_diagram);
    String _shortName = this.shortName(_activatorClassName);
    _builder.append(_shortName, "        ");
    _builder.append(".get(IGaService.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    StringConcatenation _generate_canAdd = this.generate_canAdd(reference);
    _builder.append(_generate_canAdd, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_add = this.generate_add(reference);
    _builder.append(_generate_add, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_removeExisting = this.generate_removeExisting(reference);
    _builder.append(_generate_removeExisting, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_additionalFields_1 = this.generate_additionalFields(reference);
    _builder.append(_generate_additionalFields_1, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_add(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("    ");
    EReference _target = reference.getTarget();
    final EReference target = _target;
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("public PictogramElement add(IAddContext context) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("IAddConnectionContext addConContext = (IAddConnectionContext) context;");
    _builder.newLine();
    _builder.append("        ");
    MetaClass _metaClass = reference.getMetaClass();
    EClass _type = _metaClass.getType();
    String _javaInterfaceName = this._namingExtensions.getJavaInterfaceName(_type);
    String _shortName = this.shortName(_javaInterfaceName);
    _builder.append(_shortName, "        ");
    _builder.append(" addedDomainObject = (");
    MetaClass _metaClass_1 = reference.getMetaClass();
    String _name = this._namingExtensions.getName(_metaClass_1);
    _builder.append(_name, "        ");
    _builder.append(") context.getNewObject();");
    _builder.newLineIfNotEmpty();
    {
      int _upperBound = target.getUpperBound();
      boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_upperBound), ((Integer)1));
      if (_operator_equals) {
        _builder.append("    ");
        _builder.append("removeExisting(context);");
        _builder.newLine();
      }
    }
    _builder.append("      ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// CONNECTION WITH POLYLINE");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Connection connection = peCreateService.createFreeFormConnection(getDiagram());");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("connection.setStart(addConContext.getSourceAnchor());");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("connection.setEnd(addConContext.getTargetAnchor());");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// TRY");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("AnchorContainer parent = connection.getStart().getParent();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object start = getBusinessObjectForPictogramElement(parent);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("AnchorContainer child = connection.getEnd().getParent();");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Object end = getBusinessObjectForPictogramElement(child);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//END TRY");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Polyline polyline = gaService.createPolyline(connection);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("polyline.setLineWidth(");
    Connection _representedBy = reference.getRepresentedBy();
    Layout _layout = _representedBy.getLayout();
    int _lineWidth = _layout.getLineWidth();
    _builder.append(_lineWidth, "        ");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("polyline.setForeground(manageColor(");
    String _lineColor = this._layoutExtensions.lineColor(reference);
    _builder.append(_lineColor, "        ");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("         ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// create link and wire it");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("peService.setPropertyValue(connection, \"MODEL_TYPE\", \"");
    MetaClass _metaClass_2 = reference.getMetaClass();
    String _name_1 = this._namingExtensions.getName(_metaClass_2);
    _builder.append(_name_1, "        ");
    _builder.append(".");
    String _name_2 = target.getName();
    _builder.append(_name_2, "        ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("peService.setPropertyValue(connection, \"REFERENCE\", (String)context.getProperty(\"REFERENCE\"));");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("peService.setPropertyValue(connection, \"TARGETOBJECT\", (String)context.getProperty(\"TARGETOBJECT\"));");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("//       link(connection, addedDomainObject);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// add static graphical decorator");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("// ConnectionDecorator cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//      No arrows");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//        createArrow(cd);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("decorateConnection (addConContext, connection);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("setDoneChanges(true);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return connection;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_canAdd(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    StringConcatenation _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public boolean canAdd(IAddContext context) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// return true if given business object is an ");
    MetaClass _metaClass = reference.getMetaClass();
    String _name = this._namingExtensions.getName(_metaClass);
    _builder.append(_name, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("// note, that the context must be an instance of IAddConnectionContext");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (context instanceof IAddConnectionContext");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("&& context.getNewObject() instanceof ");
    MetaClass _metaClass_1 = reference.getMetaClass();
    String _name_1 = this._namingExtensions.getName(_metaClass_1);
    _builder.append(_name_1, "        ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_removeExisting(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void removeExisting(IAddContext context) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("IAddConnectionContext addConContext = (IAddConnectionContext) context;");
    _builder.newLine();
    _builder.append("    ");
    MetaClass _metaClass = reference.getMetaClass();
    String _name = this._namingExtensions.getName(_metaClass);
    _builder.append(_name, "    ");
    _builder.append(" addedDomainObject = (");
    MetaClass _metaClass_1 = reference.getMetaClass();
    String _name_1 = this._namingExtensions.getName(_metaClass_1);
    _builder.append(_name_1, "    ");
    _builder.append(") context.getNewObject();");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("Object[] pictogramElements = peService.getLinkedPictogramElements(new EObject[] { addedDomainObject }, getDiagram());");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (Object pict : pictogramElements) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if( pict instanceof PictogramElement){");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("PictogramElement p = (PictogramElement)pict;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("String reference = peService.getPropertyValue(p, \"REFERENCE\");");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("if( \"");
    String _name_2 = this._namingExtensions.getName(reference);
    _builder.append(_name_2, "            ");
    _builder.append("\".equals(reference)){");
    _builder.newLineIfNotEmpty();
    _builder.append("                ");
    _builder.append("peService.deletePictogramElement(p) ;");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("setDoneChanges(true);");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_createArrow(final MetaReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("    ");
    _builder.append("private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("Polyline polyline = gaCreateService.createPolyline(gaContainer, new int[] { -15, 10, 0, 0, -15, -10 });");
    _builder.newLine();
    _builder.append("//        polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("polyline.setLineWidth(");
    Connection _representedBy = reference.getRepresentedBy();
    Layout _layout = _representedBy.getLayout();
    int _lineWidth = _layout.getLineWidth();
    _builder.append(_lineWidth, "        ");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("polyline.setForeground(manageColor(");
    String _lineColor = this._layoutExtensions.lineColor(reference);
    _builder.append(_lineColor, "        ");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("return polyline;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
