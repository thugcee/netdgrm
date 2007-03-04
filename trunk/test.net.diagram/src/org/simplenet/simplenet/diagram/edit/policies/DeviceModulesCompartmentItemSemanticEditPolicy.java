package org.simplenet.simplenet.diagram.edit.policies;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.simplenet.simplenet.SimplenetPackage;

import org.simplenet.simplenet.diagram.edit.commands.ModuleCreateCommand;

import org.simplenet.simplenet.diagram.providers.SimplenetElementTypes;

/**
 * @generated
 */
public class DeviceModulesCompartmentItemSemanticEditPolicy extends
		SimplenetBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SimplenetElementTypes.Module_3001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SimplenetPackage.eINSTANCE
						.getDevice_Modules());
			}
			return getMSLWrapper(new ModuleCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
