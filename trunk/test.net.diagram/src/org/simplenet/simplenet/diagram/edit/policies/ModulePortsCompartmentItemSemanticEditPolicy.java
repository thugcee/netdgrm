package org.simplenet.simplenet.diagram.edit.policies;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.simplenet.simplenet.SimplenetPackage;

import org.simplenet.simplenet.diagram.edit.commands.PortCreateCommand;

import org.simplenet.simplenet.diagram.providers.SimplenetElementTypes;

/**
 * @generated
 */
public class ModulePortsCompartmentItemSemanticEditPolicy extends
		SimplenetBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SimplenetElementTypes.Port_3002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SimplenetPackage.eINSTANCE
						.getModule_Ports());
			}
			return getMSLWrapper(new PortCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
