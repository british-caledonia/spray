package org.eclipselabs.spray.generator.graphiti.templates.features;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipselabs.spray.generator.graphiti.templates.FileGenerator;
import org.eclipselabs.spray.generator.graphiti.templates.JavaGenFile;
import org.eclipselabs.spray.generator.graphiti.util.GeneratorUtil;
import org.eclipselabs.spray.generator.graphiti.util.LayoutExtensions;
import org.eclipselabs.spray.generator.graphiti.util.MetaModel;
import org.eclipselabs.spray.generator.graphiti.util.NamingExtensions;
import org.eclipselabs.spray.mm.spray.Connection;
import org.eclipselabs.spray.mm.spray.Diagram;
import org.eclipselabs.spray.mm.spray.Layout;
import org.eclipselabs.spray.mm.spray.MetaClass;
import org.eclipselabs.spray.mm.spray.Shape;
import org.eclipselabs.spray.mm.spray.Text;

@SuppressWarnings("all")
public class AddConnectionFeature extends FileGenerator {
  @Inject
  private LayoutExtensions _layoutExtensions;
  
  @Inject
  private NamingExtensions _namingExtensions;
  
  public StringConcatenation generateBaseFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _baseClassName = _javaGenFile.getBaseClassName();
    StringConcatenation _mainFile = this.mainFile(((MetaClass) modelElement), _baseClassName);
    return _mainFile;
  }
  
  public StringConcatenation generateExtensionFile(final EObject modelElement) {
    JavaGenFile _javaGenFile = this.getJavaGenFile();
    String _className = _javaGenFile.getClassName();
    StringConcatenation _mainExtensionPointFile = this.mainExtensionPointFile(((MetaClass) modelElement), _className);
    return _mainExtensionPointFile;
  }
  
  public StringConcatenation mainExtensionPointFile(final MetaClass metaClass, final String className) {
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
  
  public StringConcatenation mainFile(final MetaClass metaClass, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    Diagram _diagram = metaClass.getDiagram();
    String _name = _diagram.getName();
    final String diagramName = _name;
    _builder.newLineIfNotEmpty();
    EClass _type = metaClass.getType();
    EPackage _ePackage = _type.getEPackage();
    String _name_1 = _ePackage.getName();
    final String packge = _name_1;
    _builder.newLineIfNotEmpty();
    EClass _type_1 = metaClass.getType();
    String _fullPackageName = MetaModel.fullPackageName(_type_1);
    final String fullPackage = _fullPackageName;
    _builder.newLineIfNotEmpty();
    Shape _representedBy = metaClass.getRepresentedBy();
    final Connection connection = ((Connection) _representedBy);
    _builder.newLineIfNotEmpty();
    StringConcatenation _header = this.header(this);
    _builder.append(_header, "");
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    String _feature_package = GeneratorUtil.feature_package();
    _builder.append(_feature_package, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import ");
    String _javaInterfaceName = this._namingExtensions.getJavaInterfaceName(metaClass);
    _builder.append(_javaInterfaceName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.eclipse.graphiti.features.IFeatureProvider;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IAddConnectionContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.features.context.IAddContext;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.Text;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.Connection;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.PictogramElement;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.mm.algorithms.Polyline;");
    _builder.newLine();
    _builder.append("import org.eclipse.graphiti.services.IGaService;");
    _builder.newLine();
    _builder.append("import org.eclipselabs.spray.runtime.graphiti.features.AbstractAddConnectionFeature;");
    _builder.newLine();
    _builder.append("import static org.eclipselabs.spray.runtime.graphiti.ISprayConstants.PROPERTY_MODEL_TYPE;");
    _builder.newLine();
    _builder.append("// MARKER_IMPORT");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(className, "");
    _builder.append(" extends AbstractAddConnectionFeature {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_additionalFields = this.generate_additionalFields(metaClass);
    _builder.append(_generate_additionalFields, "    ");
    _builder.newLineIfNotEmpty();
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
    Diagram _diagram_1 = metaClass.getDiagram();
    String _activatorClassName = this._namingExtensions.getActivatorClassName(_diagram_1);
    String _shortName = this.shortName(_activatorClassName);
    _builder.append(_shortName, "        ");
    _builder.append(".get(IGaService.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    StringConcatenation _generate_canAdd = this.generate_canAdd(metaClass);
    _builder.append(_generate_canAdd, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_add = this.generate_add(metaClass);
    _builder.append(_generate_add, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_connectionLine = this.generate_connectionLine(metaClass);
    _builder.append(_generate_connectionLine, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    StringConcatenation _generate_connectionToLabel = this.generate_connectionToLabel(metaClass);
    _builder.append(_generate_connectionToLabel, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_connectionLabel = this.generate_connectionLabel(metaClass);
    _builder.append(_generate_connectionLabel, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_connectionFromLabel = this.generate_connectionFromLabel(metaClass);
    _builder.append(_generate_connectionFromLabel, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    StringConcatenation _generate_additionalFields_1 = this.generate_additionalFields(metaClass);
    _builder.append(_generate_additionalFields_1, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_canAdd(final MetaClass metaClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* {@inheritDoc}");
    _builder.newLine();
    _builder.append("* ");
    _builder.newLine();
    _builder.append("* @return <code>true</code> if given business object is an {@link ");
    String _name = this._namingExtensions.getName(metaClass);
    _builder.append(_name, "");
    _builder.append("} and context is of type {@link IAddConnectionContext}");
    _builder.newLineIfNotEmpty();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("public boolean canAdd(IAddContext context) {");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("if (context instanceof IAddConnectionContext");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("&& context.getNewObject() instanceof ");
    String _name_1 = this._namingExtensions.getName(metaClass);
    _builder.append(_name_1, "       ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("       ");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_add(final MetaClass metaClass) {
    StringConcatenation _builder = new StringConcatenation();
    Shape _representedBy = metaClass.getRepresentedBy();
    final Connection connection = ((Connection) _representedBy);
    _builder.newLineIfNotEmpty();
    StringConcatenation _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public PictogramElement add(IAddContext context) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("IAddConnectionContext addConContext = (IAddConnectionContext) context;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// TODO: Domain object");
    _builder.newLine();
    _builder.append("    ");
    String _name = this._namingExtensions.getName(metaClass);
    _builder.append(_name, "    ");
    _builder.append(" addedDomainObject = (");
    String _name_1 = this._namingExtensions.getName(metaClass);
    _builder.append(_name_1, "    ");
    _builder.append(") context.getNewObject();");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Connection connection = createConnectionLine (addConContext);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// create link and wire it");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("peService.setPropertyValue(connection, PROPERTY_MODEL_TYPE, \"");
    String _name_2 = this._namingExtensions.getName(metaClass);
    _builder.append(_name_2, "    ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("decorateConnection (addConContext, connection);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("link(connection, addedDomainObject);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("setDoneChanges(true);");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return connection;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_connectionLine(final MetaClass metaClass) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    StringConcatenation _overrideHeader = this.overrideHeader();
    _builder.append(_overrideHeader, "   ");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("protected Connection createConnectionLine (IAddConnectionContext context) {");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("// CONNECTION WITH POLYLINE");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("Connection connection = peCreateService.createFreeFormConnection(getDiagram());");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("connection.setStart(context.getSourceAnchor());");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("connection.setEnd(context.getTargetAnchor());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("       ");
    _builder.append("Polyline polyline = gaService.createPolyline(connection);");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("polyline.setLineWidth(");
    Shape _representedBy = metaClass.getRepresentedBy();
    Layout _layout = _representedBy.getLayout();
    int _lineWidth = _layout.getLineWidth();
    _builder.append(_lineWidth, "       ");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("       ");
    _builder.append("polyline.setForeground(manageColor(");
    String _lineColor = this._layoutExtensions.lineColor(metaClass);
    _builder.append(_lineColor, "       ");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("       ");
    _builder.append("return connection;");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generate_connectionFromLabel(final MetaClass metaClass) {
    StringConcatenation _builder = new StringConcatenation();
    Shape _representedBy = metaClass.getRepresentedBy();
    final Connection connection = ((Connection) _representedBy);
    _builder.newLineIfNotEmpty();
    {
      Text _fromLabel = connection.getFromLabel();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_fromLabel, null);
      if (_operator_notEquals) {
        StringConcatenation _overrideHeader = this.overrideHeader();
        _builder.append(_overrideHeader, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected GraphicsAlgorithm createConnectionFromLabel (IAddConnectionContext context, Connection connection) {");
        _builder.newLine();
        _builder.append("    ");
        String _name = this._namingExtensions.getName(metaClass);
        _builder.append(_name, "    ");
        _builder.append(" addedDomainObject = (");
        String _name_1 = this._namingExtensions.getName(metaClass);
        _builder.append(_name_1, "    ");
        _builder.append(") context.getNewObject();");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("ConnectionDecorator fromDecorator = peCreateService.createConnectionDecorator(connection, true, 0.0, true);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("Text fromText = gaService.createDefaultText(getDiagram(), fromDecorator);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("gaLayoutService.setLocation(fromText, 10, 20);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("fromText.setValue(getFromLabel(addedDomainObject));");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("peService.setPropertyValue(fromDecorator, PROPERTY_MODEL_TYPE, \"FROM_LABEL\");");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("link(fromDecorator, addedDomainObject);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("return fromText;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.append("protected String getFromLabel (");
        String _name_2 = this._namingExtensions.getName(metaClass);
        _builder.append(_name_2, "");
        _builder.append(" addedDomainObject) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        Text _fromLabel_1 = connection.getFromLabel();
        StringConcatenation _valueGenerator = this.valueGenerator(_fromLabel_1, "addedDomainObject");
        _builder.append(_valueGenerator, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generate_connectionToLabel(final MetaClass metaClass) {
    StringConcatenation _builder = new StringConcatenation();
    Shape _representedBy = metaClass.getRepresentedBy();
    final Connection connection = ((Connection) _representedBy);
    _builder.newLineIfNotEmpty();
    {
      Text _label = connection.getToLabel();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_label, null);
      if (_operator_notEquals) {
        StringConcatenation _overrideHeader = this.overrideHeader();
        _builder.append(_overrideHeader, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected GraphicsAlgorithm createConnectionToLabel (IAddConnectionContext context, Connection connection) {");
        _builder.newLine();
        _builder.append("    ");
        String _name = this._namingExtensions.getName(metaClass);
        _builder.append(_name, "    ");
        _builder.append(" addedDomainObject = (");
        String _name_1 = this._namingExtensions.getName(metaClass);
        _builder.append(_name_1, "    ");
        _builder.append(") context.getNewObject();");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("ConnectionDecorator toDecorator = peCreateService.createConnectionDecorator(connection, true, 1.0, true);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("Text text = gaService.createDefaultText(getDiagram(), toDecorator);");
        _builder.newLine();
        _builder.append("    ");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("GraphicsAlgorithm ga = context.getTargetAnchor().getParent().getGraphicsAlgorithm();");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("int targetHeight = ga.getHeight();");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("gaLayoutService.setLocation(text, 10, -(targetHeight / 2) - 20);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("text.setValue(getToLabel(addedDomainObject));");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("peService.setPropertyValue(toDecorator, PROPERTY_MODEL_TYPE, \"TO_LABEL\");");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("link(toDecorator, addedDomainObject);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("return text;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("protected String getToLabel (");
        String _name_2 = this._namingExtensions.getName(metaClass);
        _builder.append(_name_2, "");
        _builder.append(" addedDomainObject) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        Text _label_1 = connection.getToLabel();
        StringConcatenation _valueGenerator = this.valueGenerator(_label_1, "addedDomainObject");
        _builder.append(_valueGenerator, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public StringConcatenation generate_connectionLabel(final MetaClass metaClass) {
    StringConcatenation _builder = new StringConcatenation();
    Shape _representedBy = metaClass.getRepresentedBy();
    final Connection connection = ((Connection) _representedBy);
    _builder.newLineIfNotEmpty();
    {
      Text _connectionLabel = connection.getConnectionLabel();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_connectionLabel, null);
      if (_operator_notEquals) {
        StringConcatenation _overrideHeader = this.overrideHeader();
        _builder.append(_overrideHeader, "");
        _builder.newLineIfNotEmpty();
        _builder.append("protected GraphicsAlgorithm createConnectionLabel (IAddConnectionContext context, Connection connection) {");
        _builder.newLine();
        _builder.append("    ");
        String _name = this._namingExtensions.getName(metaClass);
        _builder.append(_name, "    ");
        _builder.append(" addedDomainObject = (");
        String _name_1 = this._namingExtensions.getName(metaClass);
        _builder.append(_name_1, "    ");
        _builder.append(") context.getNewObject();");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("ConnectionDecorator connectionDecorator = peCreateService.createConnectionDecorator(connection, true, 0.5, true);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("Text sourceText = gaService.createDefaultText(getDiagram(), connectionDecorator);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("gaLayoutService.setLocation(sourceText, 10, 0);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("sourceText.setValue(getConnectionLabel(addedDomainObject));");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("peService.setPropertyValue(connectionDecorator, PROPERTY_MODEL_TYPE, \"CONNECTION_LABEL\");");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("link(connectionDecorator, addedDomainObject);");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("return sourceText;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("protected String getConnectionLabel (");
        String _name_2 = this._namingExtensions.getName(metaClass);
        _builder.append(_name_2, "");
        _builder.append(" addedDomainObject) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        Text _connectionLabel_1 = connection.getConnectionLabel();
        StringConcatenation _valueGenerator = this.valueGenerator(_connectionLabel_1, "addedDomainObject");
        _builder.append(_valueGenerator, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
