package org.simplenet.simplenet.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.simplenet.simplenet.SimplenetPackage;

import org.simplenet.simplenet.diagram.edit.parts.DeviceNameEditPart;
import org.simplenet.simplenet.diagram.edit.parts.ModuleNameEditPart;
import org.simplenet.simplenet.diagram.edit.parts.PortNameEditPart;

import org.simplenet.simplenet.diagram.part.SimplenetVisualIDRegistry;

/**
 * @generated
 */
public class SimplenetParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser moduleModuleName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getModuleModuleName_5002Parser() {
		if (moduleModuleName_5002Parser == null) {
			moduleModuleName_5002Parser = createModuleModuleName_5002Parser();
		}
		return moduleModuleName_5002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createModuleModuleName_5002Parser() {
		SimplenetStructuralFeatureParser parser = new SimplenetStructuralFeatureParser(
				SimplenetPackage.eINSTANCE.getModule_Name());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser portPortName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getPortPortName_5001Parser() {
		if (portPortName_5001Parser == null) {
			portPortName_5001Parser = createPortPortName_5001Parser();
		}
		return portPortName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPortPortName_5001Parser() {
		SimplenetStructuralFeatureParser parser = new SimplenetStructuralFeatureParser(
				SimplenetPackage.eINSTANCE.getPort_Name());
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser deviceDeviceName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getDeviceDeviceName_5003Parser() {
		if (deviceDeviceName_5003Parser == null) {
			deviceDeviceName_5003Parser = createDeviceDeviceName_5003Parser();
		}
		return deviceDeviceName_5003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDeviceDeviceName_5003Parser() {
		SimplenetStructuralFeatureParser parser = new SimplenetStructuralFeatureParser(
				SimplenetPackage.eINSTANCE.getDevice_Name());
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ModuleNameEditPart.VISUAL_ID:
			return getModuleModuleName_5002Parser();
		case PortNameEditPart.VISUAL_ID:
			return getPortPortName_5001Parser();
		case DeviceNameEditPart.VISUAL_ID:
			return getDeviceDeviceName_5003Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(SimplenetVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(SimplenetVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (SimplenetElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}
}
