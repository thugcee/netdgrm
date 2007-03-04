package org.simplenet.simplenet.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.simplenet.simplenet.diagram.part.SimplenetDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		DiagramPrintingPreferencePage.initDefaults(store);
		DiagramGeneralPreferencePage.initDefaults(store);
		DiagramAppearancePreferencePage.initDefaults(store);
		DiagramConnectionsPreferencePage.initDefaults(store);
		DiagramRulersAndGridPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return SimplenetDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
