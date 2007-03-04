package org.simplenet.simplenet.diagram.edit.policies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.simplenet.simplenet.Device;

import org.simplenet.simplenet.diagram.edit.parts.ModuleEditPart;

import org.simplenet.simplenet.diagram.part.SimplenetVisualIDRegistry;

/**
 * @generated
 */
public class DeviceModulesCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		for (Iterator values = ((Device) modelObject).getModules().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = SimplenetVisualIDRegistry.getNodeVisualID(viewObject,
					nextValue);
			if (ModuleEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return view.isSetElement() && view.getElement() != null
				&& view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

}
