package org.eclipselabs.spray.shapes.ui.linking;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipselabs.spray.runtime.xtext.ui.linking.DSLEditorOpener;
import org.eclipselabs.spray.runtime.xtext.ui.linking.DSLLinkingHelper;
import org.eclipselabs.spray.runtime.xtext.ui.linking.DSLResourceVisitor;
import org.eclipselabs.spray.styles.styles.Style;

import com.google.inject.Inject;

public class ShapeLinkingHelper extends DSLLinkingHelper<Style> {
		
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IJvmModelAssociations modelAssocs;

	@Override
	protected DSLResourceVisitor<Style> getDSLResourceVisitor(
			final XtextResource xtextResource) {
		return new StyleResourceVisitor(xtextResource.getResourceSet());
	}

	@Override
	protected boolean isExpectedType(final EObject to) {
		return to instanceof Style;
	}
	
	@Override
	protected DSLEditorOpener<Style> getDSLEditorOpener(Style to) {
		return new StyleEditorOpener(to);
	}


	@Override
	protected String getName(Style style) {
		return style.getName();
	}

	@Override
	protected Set<EObject> getSourceElements(JvmType jvmType) {
		return modelAssocs.getSourceElements(jvmType);
	}

	@Override
	protected EObjectAtOffsetHelper getEObjectAtOffsetHelper() {
		return eObjectAtOffsetHelper;
	}
}
