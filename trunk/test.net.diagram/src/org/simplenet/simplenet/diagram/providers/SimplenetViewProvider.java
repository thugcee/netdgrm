package org.simplenet.simplenet.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.simplenet.simplenet.diagram.edit.parts.DeviceEditPart;
import org.simplenet.simplenet.diagram.edit.parts.DeviceModulesCompartmentEditPart;
import org.simplenet.simplenet.diagram.edit.parts.DeviceNameEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModuleEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModuleNameEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModulePortsCompartmentEditPart;
import org.simplenet.simplenet.diagram.edit.parts.NetEditPart;
import org.simplenet.simplenet.diagram.edit.parts.PortEditPart;
import org.simplenet.simplenet.diagram.edit.parts.PortNameEditPart;

import org.simplenet.simplenet.diagram.part.SimplenetVisualIDRegistry;

import org.simplenet.simplenet.diagram.view.factories.DeviceModulesCompartmentViewFactory;
import org.simplenet.simplenet.diagram.view.factories.DeviceNameViewFactory;
import org.simplenet.simplenet.diagram.view.factories.DeviceViewFactory;
import org.simplenet.simplenet.diagram.view.factories.ModuleNameViewFactory;
import org.simplenet.simplenet.diagram.view.factories.ModulePortsCompartmentViewFactory;
import org.simplenet.simplenet.diagram.view.factories.ModuleViewFactory;
import org.simplenet.simplenet.diagram.view.factories.NetViewFactory;
import org.simplenet.simplenet.diagram.view.factories.PortNameViewFactory;
import org.simplenet.simplenet.diagram.view.factories.PortViewFactory;

/**
 * @generated
 */
public class SimplenetViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (NetEditPart.MODEL_ID.equals(diagramKind)
				&& SimplenetVisualIDRegistry
						.getDiagramVisualID(semanticElement) != -1) {
			return NetViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !SimplenetElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int nodeVID = SimplenetVisualIDRegistry.getNodeVisualID(containerView,
				semanticElement, semanticType, semanticHint);
		switch (nodeVID) {
		case DeviceEditPart.VISUAL_ID:
			return DeviceViewFactory.class;
		case DeviceNameEditPart.VISUAL_ID:
			return DeviceNameViewFactory.class;
		case ModuleEditPart.VISUAL_ID:
			return ModuleViewFactory.class;
		case ModuleNameEditPart.VISUAL_ID:
			return ModuleNameViewFactory.class;
		case PortEditPart.VISUAL_ID:
			return PortViewFactory.class;
		case PortNameEditPart.VISUAL_ID:
			return PortNameViewFactory.class;
		case DeviceModulesCompartmentEditPart.VISUAL_ID:
			return DeviceModulesCompartmentViewFactory.class;
		case ModulePortsCompartmentEditPart.VISUAL_ID:
			return ModulePortsCompartmentViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (elementType != null
				&& !SimplenetElementTypes.isKnownElementType(elementType)) {
			return null;
		}
		EClass semanticType = getSemanticEClass(semanticAdapter);
		if (semanticType == null) {
			return null;
		}
		EObject semanticElement = getSemanticElement(semanticAdapter);
		int linkVID = SimplenetVisualIDRegistry.getLinkWithClassVisualID(
				semanticElement, semanticType);
		switch (linkVID) {
		}
		return getUnrecognizedConnectorViewClass(semanticAdapter,
				containerView, semanticHint);
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private Class getUnrecognizedConnectorViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		// Handle unrecognized child node classes here
		return null;
	}

}
