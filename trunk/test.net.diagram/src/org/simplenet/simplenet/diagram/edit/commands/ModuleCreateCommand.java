package org.simplenet.simplenet.diagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

import org.simplenet.simplenet.SimplenetPackage;

/**
 * @generated
 */
public class ModuleCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public ModuleCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return SimplenetPackage.eINSTANCE.getDevice();
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

}
