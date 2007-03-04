package org.simplenet.simplenet.diagram.part;

import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import org.simplenet.simplenet.Device;
import org.simplenet.simplenet.Module;
import org.simplenet.simplenet.Net;
import org.simplenet.simplenet.Port;
import org.simplenet.simplenet.SimplenetPackage;

import org.simplenet.simplenet.diagram.edit.parts.DeviceEditPart;
import org.simplenet.simplenet.diagram.edit.parts.DeviceModulesCompartmentEditPart;
import org.simplenet.simplenet.diagram.edit.parts.DeviceNameEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModuleEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModuleNameEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModulePortsCompartmentEditPart;
import org.simplenet.simplenet.diagram.edit.parts.NetEditPart;
import org.simplenet.simplenet.diagram.edit.parts.PortEditPart;
import org.simplenet.simplenet.diagram.edit.parts.PortNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented 
 * by a domain model object.
 *
 * @generated
 */
public class SimplenetVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = SimplenetDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (NetEditPart.MODEL_ID.equals(view.getType())) {
				return NetEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				SimplenetDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getDiagramVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	private static int getDiagramVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		if (SimplenetPackage.eINSTANCE.getNet().isSuperTypeOf(
				domainElementMetaclass)
				&& isDiagramNet_1000((Net) domainElement)) {
			return NetEditPart.VISUAL_ID;
		}
		return getUnrecognizedDiagramID(domainElement);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getNodeVisualID(containerView, domainElement,
				domainElementMetaclass, null);
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView,
			EObject domainElement, EClass domainElementMetaclass,
			String semanticHint) {
		String containerModelID = getModelID(containerView);
		if (!NetEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (NetEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = NetEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		int nodeVisualID = semanticHint != null ? getVisualID(semanticHint)
				: -1;
		switch (containerVisualID) {
		case DeviceEditPart.VISUAL_ID:
			if (DeviceNameEditPart.VISUAL_ID == nodeVisualID) {
				return DeviceNameEditPart.VISUAL_ID;
			}
			if (DeviceModulesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return DeviceModulesCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedDevice_2001ChildNodeID(domainElement,
					semanticHint);
		case ModuleEditPart.VISUAL_ID:
			if (ModuleNameEditPart.VISUAL_ID == nodeVisualID) {
				return ModuleNameEditPart.VISUAL_ID;
			}
			if (ModulePortsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return ModulePortsCompartmentEditPart.VISUAL_ID;
			}
			return getUnrecognizedModule_3001ChildNodeID(domainElement,
					semanticHint);
		case PortEditPart.VISUAL_ID:
			if (PortNameEditPart.VISUAL_ID == nodeVisualID) {
				return PortNameEditPart.VISUAL_ID;
			}
			return getUnrecognizedPort_3002ChildNodeID(domainElement,
					semanticHint);
		case DeviceModulesCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || ModuleEditPart.VISUAL_ID == nodeVisualID)
					&& SimplenetPackage.eINSTANCE.getModule().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeModule_3001((Module) domainElement))) {
				return ModuleEditPart.VISUAL_ID;
			}
			return getUnrecognizedDeviceModulesCompartment_7001ChildNodeID(
					domainElement, semanticHint);
		case ModulePortsCompartmentEditPart.VISUAL_ID:
			if ((semanticHint == null || PortEditPart.VISUAL_ID == nodeVisualID)
					&& SimplenetPackage.eINSTANCE.getPort().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodePort_3002((Port) domainElement))) {
				return PortEditPart.VISUAL_ID;
			}
			return getUnrecognizedModulePortsCompartment_7002ChildNodeID(
					domainElement, semanticHint);
		case NetEditPart.VISUAL_ID:
			if ((semanticHint == null || DeviceEditPart.VISUAL_ID == nodeVisualID)
					&& SimplenetPackage.eINSTANCE.getDevice().isSuperTypeOf(
							domainElementMetaclass)
					&& (domainElement == null || isNodeDevice_2001((Device) domainElement))) {
				return DeviceEditPart.VISUAL_ID;
			}
			return getUnrecognizedNet_1000ChildNodeID(domainElement,
					semanticHint);
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		EClass domainElementMetaclass = domainElement.eClass();
		return getLinkWithClassVisualID(domainElement, domainElementMetaclass);
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement,
			EClass domainElementMetaclass) {
		{
			return getUnrecognizedLinkWithClassID(domainElement);
		}
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isDiagramNet_1000(Net element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDiagramID(EObject domainElement) {
		return -1;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeDevice_2001(Device element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodeModule_3001(Module element) {
		return true;
	}

	/**
	 * User can change implementation of this method to check some additional 
	 * conditions here.
	 *
	 * @generated
	 */
	private static boolean isNodePort_3002(Port element) {
		return true;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDevice_2001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedModule_3001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedPort_3002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedDeviceModulesCompartment_7001ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedModulePortsCompartment_7002ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedNet_1000ChildNodeID(
			EObject domainElement, String semanticHint) {
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 *
	 * @generated
	 */
	private static int getUnrecognizedLinkWithClassID(EObject domainElement) {
		return -1;
	}
}
