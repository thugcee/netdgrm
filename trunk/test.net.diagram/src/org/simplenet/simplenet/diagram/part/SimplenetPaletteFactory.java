package org.simplenet.simplenet.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.simplenet.simplenet.diagram.providers.SimplenetElementTypes;

/**
 * @generated
 */
public class SimplenetPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createSimplenet1Group());
	}

	/**
	 * Creates "simplenet" palette tool group
	 * @generated
	 */
	private PaletteContainer createSimplenet1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Simplenet1Group_title);
		paletteContainer.add(createDevice1CreationTool());
		paletteContainer.add(createModule2CreationTool());
		paletteContainer.add(createPort3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDevice1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SimplenetElementTypes.Device_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Device1CreationTool_title,
				Messages.Device1CreationTool_desc, types);
		entry.setSmallIcon(SimplenetElementTypes
				.getImageDescriptor(SimplenetElementTypes.Device_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createModule2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SimplenetElementTypes.Module_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Module2CreationTool_title,
				Messages.Module2CreationTool_desc, types);
		entry.setSmallIcon(SimplenetElementTypes
				.getImageDescriptor(SimplenetElementTypes.Module_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPort3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(SimplenetElementTypes.Port_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Port3CreationTool_title,
				Messages.Port3CreationTool_desc, types);
		entry.setSmallIcon(SimplenetElementTypes
				.getImageDescriptor(SimplenetElementTypes.Port_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
