package org.simplenet.simplenet.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

import org.simplenet.simplenet.diagram.edit.parts.ModuleEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModuleNameEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModulePortsCompartmentEditPart;
import org.simplenet.simplenet.diagram.edit.parts.NetEditPart;

import org.simplenet.simplenet.diagram.part.SimplenetVisualIDRegistry;

/**
 * @generated
 */
public class ModuleViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated 
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		styles.add(NotationFactory.eINSTANCE.createDescriptionStyle());
		styles.add(NotationFactory.eINSTANCE.createFillStyle());
		styles.add(NotationFactory.eINSTANCE.createLineStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = SimplenetVisualIDRegistry
					.getType(ModuleEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		if (!NetEditPart.MODEL_ID.equals(SimplenetVisualIDRegistry
				.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE
					.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails()
					.put("modelID", NetEditPart.MODEL_ID); //$NON-NLS-1$
			view.getEAnnotations().add(shortcutAnnotation);
		}
		getViewService()
				.createNode(
						semanticAdapter,
						view,
						SimplenetVisualIDRegistry
								.getType(ModuleNameEditPart.VISUAL_ID),
						ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(
				semanticAdapter,
				view,
				SimplenetVisualIDRegistry
						.getType(ModulePortsCompartmentEditPart.VISUAL_ID),
				ViewUtil.APPEND, true, getPreferencesHint());
	}

}
