package org.simplenet.simplenet.diagram.part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.internal.l10n.EditorMessages;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.EditorStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @generated
 */
public class SimplenetDocumentProvider extends AbstractDocumentProvider
		implements IDiagramDocumentProvider {

	/**
	 * @generated
	 */
	protected ElementInfo createElementInfo(Object element)
			throws CoreException {
		if (false == element instanceof FileEditorInput) {
			throw new CoreException(
					new Status(
							IStatus.ERROR,
							SimplenetDiagramEditorPlugin.ID,
							0,
							"Incorrect element used: " + element + " instead of org.eclipse.ui.part.FileEditorInput", null)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		IEditorInput editorInput = (IEditorInput) element;
		IDiagramDocument document = (IDiagramDocument) createDocument(editorInput);

		ResourceSetInfo info = new ResourceSetInfo(document, editorInput);
		info.setModificationStamp(computeModificationStamp(info));
		info.fStatus = null;
		ResourceSetModificationListener modificationListener = new ResourceSetModificationListener(
				info);
		info.getResourceSet().eAdapters().add(modificationListener);
		return info;
	}

	/**
	 * @generated
	 */
	protected IDocument createDocument(Object element) throws CoreException {
		if (false == element instanceof FileEditorInput) {
			throw new CoreException(
					new Status(
							IStatus.ERROR,
							SimplenetDiagramEditorPlugin.ID,
							0,
							"Incorrect element used: " + element + " instead of org.eclipse.ui.part.FileEditorInput", null)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		IDocument document = createEmptyDocument();
		setDocumentContent(document, (FileEditorInput) element);
		setupDocument(element, document);
		return document;
	}

	/**
	 * Sets up the given document as it would be provided for the given element. The
	 * content of the document is not changed. This default implementation is empty.
	 * Subclasses may reimplement.
	 * 
	 * @param element the blue-print element
	 * @param document the document to set up
	 * @generated
	 */
	protected void setupDocument(Object element, IDocument document) {
		// for subclasses
	}

	/**
	 * @generated
	 */
	private long computeModificationStamp(ResourceSetInfo info) {
		int result = 0;
		for (Iterator it = info.getResourceSet().getResources().iterator(); it
				.hasNext();) {
			Resource nextResource = (Resource) it.next();
			IFile file = WorkspaceSynchronizer.getFile(nextResource);
			if (file != null) {
				if (file.getLocation() != null) {
					result += file.getLocation().toFile().lastModified();
				} else {
					result += file.getModificationStamp();
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected IDocument createEmptyDocument() {
		DiagramDocument document = new DiagramDocument();
		document.setEditingDomain(createEditingDomain());
		return document;
	}

	/**
	 * @generated
	 */
	private TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain editingDomain = DiagramEditingDomainFactory
				.getInstance().createEditingDomain();
		editingDomain.setID("test.net.diagram.EditingDomain"); //$NON-NLS-1$
		final NotificationFilter diagramResourceModifiedFilter = NotificationFilter
				.createNotifierFilter(editingDomain.getResourceSet()).and(
						NotificationFilter
								.createEventTypeFilter(Notification.ADD)).and(
						NotificationFilter.createFeatureFilter(
								ResourceSet.class,
								ResourceSet.RESOURCE_SET__RESOURCES));
		editingDomain.getResourceSet().eAdapters().add(new Adapter() {

			private Notifier myTarger;

			public Notifier getTarget() {
				return myTarger;
			}

			public boolean isAdapterForType(Object type) {
				return false;
			}

			public void notifyChanged(Notification notification) {
				if (diagramResourceModifiedFilter.matches(notification)) {
					Object value = notification.getNewValue();
					if (value instanceof Resource) {
						((Resource) value).setTrackingModification(true);
					}
				}
			}

			public void setTarget(Notifier newTarget) {
				myTarger = newTarget;
			}

		});

		return editingDomain;
	}

	/**
	 * @generated
	 */
	protected void setDocumentContent(IDocument document, IEditorInput element)
			throws CoreException {
		if (false == element instanceof FileEditorInput) {
			throw new CoreException(
					new Status(
							IStatus.ERROR,
							SimplenetDiagramEditorPlugin.ID,
							0,
							"Incorrect element used: " + element + " instead of org.eclipse.ui.part.FileEditorInput", null)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		IStorage storage = ((FileEditorInput) element).getStorage();
		IDiagramDocument diagramDocument = (IDiagramDocument) document;
		//	org.eclipse.gmf.runtime.notation.Diagram diagram = diagramDocument.getDiagram();

		//	org.eclipse.emf.transaction.TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
		//	diagram = org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil.load(domain, storage, true, getProgressMonitor());
		//	if (myContentObjectURI != null && diagram != null && diagram.eResource() != null && !diagram.eResource().getURIFragment(diagram).equals(myContentObjectURI)) {
		//		org.eclipse.emf.ecore.EObject anotherContentObject = diagram.eResource().getEObject(myContentObjectURI);
		//		document.setContent(anotherContentObject);
		//	} else {
		//		document.setContent(diagram);
		//	}

		TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
		Diagram diagram = DiagramIOUtil.load(domain, storage, true,
				getProgressMonitor());
		document.setContent(diagram);
	}

	/**
	 * @generated
	 */
	public long getModificationStamp(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			return computeModificationStamp(info);
		}
		return super.getModificationStamp(element);
	}

	/**
	 * @generated
	 */
	public long getSynchronizationStamp(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			return info.getModificationStamp();
		}
		return super.getSynchronizationStamp(element);
	}

	/**
	 * @generated
	 */
	public boolean isDeleted(Object element) {
		if (element instanceof IFileEditorInput) {
			IFileEditorInput input = (IFileEditorInput) element;
			IPath path = input.getFile().getLocation();
			if (path == null) {
				return true;
			}
			return !path.toFile().exists();
		}
		return super.isDeleted(element);
	}

	/**
	 * @generated
	 */
	public ResourceSetInfo getResourceSetInfo(Object editorInput) {
		return (ResourceSetInfo) super.getElementInfo(editorInput);
	}

	/**
	 * @generated
	 */
	protected void disposeElementInfo(Object element, ElementInfo info) {
		if (info instanceof ResourceSetInfo) {
			ResourceSetInfo resourceSetInfo = (ResourceSetInfo) info;
			resourceSetInfo.dispose();
		}
		super.disposeElementInfo(element, info);
	}

	/**
	 * @generated
	 */
	protected void doValidateState(Object element, Object computationContext)
			throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection files2Validate = new ArrayList();
			for (Iterator it = info.getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null && file.isReadOnly()) {
					files2Validate.add(file);
				}
			}
			ResourcesPlugin.getWorkspace().validateEdit(
					(IFile[]) files2Validate.toArray(new IFile[files2Validate
							.size()]), computationContext);
		}

		super.doValidateState(element, computationContext);
	}

	/**
	 * @generated
	 */
	public boolean isReadOnly(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (info.isUpdateCache()) {
				try {
					updateCache((IStorageEditorInput) element);
				} catch (CoreException ex) {
					SimplenetDiagramEditorPlugin
							.getInstance()
							.logError(
									EditorMessages.StorageDocumentProvider_isModifiable,
									ex);
				}
			}
			return info.isReadOnly();
		}
		return super.isReadOnly(element);
	}

	/**
	 * @generated
	 */
	public boolean isModifiable(Object element) {
		if (!isStateValidated(element)) {
			if (element instanceof FileEditorInput) {
				return true;
			}
		}
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (info.isUpdateCache()) {
				try {
					updateCache((IStorageEditorInput) element);
				} catch (CoreException ex) {
					SimplenetDiagramEditorPlugin
							.getInstance()
							.logError(
									EditorMessages.StorageDocumentProvider_isModifiable,
									ex);
				}
			}
			return info.isModifiable();
		}
		return super.isModifiable(element);
	}

	/**
	 * @generated
	 */
	protected void updateCache(IStorageEditorInput input) throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(input);
		if (info != null) {
			for (Iterator it = info.getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null && file.isReadOnly()) {
					info.setReadOnly(true);
					info.setModifiable(false);
					return;
				}
			}
			info.setReadOnly(false);
			info.setModifiable(true);
			return;
		}
	}

	/**
	 * @generated
	 */
	protected void doUpdateStateCache(Object element) throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			info.setUpdateCache(true);
		}
		super.doUpdateStateCache(element);
	}

	/**
	 * @generated
	 */
	public boolean isSynchronized(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			return info.isSynchronized();
		}
		return super.isSynchronized(element);
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getResetRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection rules = new ArrayList();
			for (Iterator it = info.getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory()
							.modifyRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[]) rules
					.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getSaveRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection rules = new ArrayList();
			for (Iterator it = info.getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(computeSchedulingRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[]) rules
					.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getSynchronizeRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection rules = new ArrayList();
			for (Iterator it = info.getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					rules.add(ResourcesPlugin.getWorkspace().getRuleFactory()
							.refreshRule(file));
				}
			}
			return new MultiRule((ISchedulingRule[]) rules
					.toArray(new ISchedulingRule[rules.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getValidateStateRule(Object element) {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			Collection files = new ArrayList();
			for (Iterator it = info.getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource nextResource = (Resource) it.next();
				IFile file = WorkspaceSynchronizer.getFile(nextResource);
				if (file != null) {
					files.add(file);
				}
			}
			return ResourcesPlugin.getWorkspace().getRuleFactory()
					.validateEditRule(
							(IFile[]) files.toArray(new IFile[files.size()]));
		}
		return null;
	}

	/**
	 * @generated
	 */
	private ISchedulingRule computeSchedulingRule(IResource toCreateOrModify) {
		if (toCreateOrModify.exists())
			return ResourcesPlugin.getWorkspace().getRuleFactory().modifyRule(
					toCreateOrModify);

		IResource parent = toCreateOrModify;
		do {
			/*
			 * XXX This is a workaround for
			 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=67601
			 * IResourceRuleFactory.createRule should iterate the hierarchy
			 * itself.
			 */
			toCreateOrModify = parent;
			parent = toCreateOrModify.getParent();
		} while (parent != null && !parent.exists());

		return ResourcesPlugin.getWorkspace().getRuleFactory().createRule(
				toCreateOrModify);
	}

	/**
	 * @generated
	 */
	protected void doSynchronize(Object element, IProgressMonitor monitor)
			throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null && element instanceof FileEditorInput) {
			for (Iterator it = info.getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource nextResource = (Resource) it.next();
				handleElementChanged(info, nextResource, monitor);
			}
			return;
		}
		super.doSynchronize(element, monitor);
	}

	/**
	 * @generated
	 */
	protected void markWholeResourceSetAsDirty(ResourceSet resourceSet) {
		for (Iterator it = resourceSet.getResources().iterator(); it.hasNext();) {
			Resource nextResource = (Resource) it.next();
			nextResource.setModified(true);
		}
	}

	/**
	 * @generated
	 */
	protected void doSaveDocument(IProgressMonitor monitor, Object element,
			IDocument document, boolean overwrite) throws CoreException {
		ResourceSetInfo info = getResourceSetInfo(element);
		if (info != null) {
			if (!overwrite && !info.isSynchronized()) {
				throw new CoreException(new Status(IStatus.ERROR,
						SimplenetDiagramEditorPlugin.ID, IStatus.OK,
						"The file has been changed on the file system", null)); //$NON-NLS-1$
			}
			info.stopResourceListening();
			fireElementStateChanging(element);
			List resources = info.getResourceSet().getResources();
			try {
				monitor.beginTask("Saving diagram", resources.size() + 1);
				Map options = new HashMap();
				options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE,
						Boolean.TRUE);
				for (Iterator it = resources.iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					monitor.setTaskName("Saving " + nextResource.getURI());
					if (nextResource.isLoaded()
							&& (!nextResource.isTrackingModification() || nextResource
									.isModified())) {
						try {
							nextResource.save(options);
						} catch (IOException e) {
							fireElementStateChangeFailed(element);
							throw new CoreException(new Status(IStatus.ERROR,
									SimplenetDiagramEditorPlugin.ID,
									EditorStatusCodes.RESOURCE_FAILURE, e
											.getLocalizedMessage(), null));
						}
					}
					monitor.worked(1);
				}
				monitor.done();
			} catch (RuntimeException x) {
				fireElementStateChangeFailed(element);
				throw x;
			} finally {
				info.startResourceListening();
			}
		}
	}

	/**
	 * @generated
	 */
	protected void handleElementChanged(ResourceSetInfo info,
			Resource changedResource, IProgressMonitor monitor) {
		IFile file = WorkspaceSynchronizer.getFile(changedResource);
		if (file != null) {
			try {
				file.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			} catch (CoreException ex) {
				SimplenetDiagramEditorPlugin
						.getInstance()
						.logError(
								EditorMessages.FileDocumentProvider_handleElementContentChanged,
								ex);
			}
		}
		changedResource.unload();

		fireElementContentAboutToBeReplaced(info.getEditorInput());
		removeUnchangedElementListeners(info.getEditorInput(), info);
		info.fStatus = null;
		try {
			setDocumentContent(info.fDocument, info.getEditorInput());
		} catch (CoreException e) {
			info.fStatus = e.getStatus();
		}
		if (!info.fCanBeSaved) {
			info.setModificationStamp(computeModificationStamp(info));
		}
		addUnchangedElementListeners(info.getEditorInput(), info);
		fireElementContentReplaced(info.getEditorInput());
	}

	/**
	 * @generated
	 */
	protected void handleElementMoved(IEditorInput input,
			org.eclipse.emf.common.util.URI uri) {
		IFile newFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(org.eclipse.emf.common.util.URI.decode(uri.path()))
						.removeFirstSegments(1));
		fireElementMoved(input, newFile == null ? null : new FileEditorInput(
				newFile));
	}

	/**
	 * @generated
	 */
	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput,
			TransactionalEditingDomain domain) {
		return editorInput;
	}

	/**
	 * @generated
	 */
	public IDiagramDocument getDiagramDocument(Object element) {
		IDocument doc = getDocument(element);
		if (doc instanceof IDiagramDocument) {
			return (IDiagramDocument) doc;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}

	/**
	 * @generated
	 */
	protected class ResourceSetInfo extends ElementInfo {

		/**
		 * @generated
		 */
		private long myModificationStamp = IResource.NULL_STAMP;

		/**
		 * @generated
		 */
		private WorkspaceSynchronizer mySynchronizer;

		/**
		 * @generated
		 */
		private Collection myUnSynchronizedResources = new ArrayList();

		/**
		 * @generated
		 */
		private IDiagramDocument myDocument;

		/**
		 * @generated
		 */
		private IEditorInput myEditorInput;

		/**
		 * @generated
		 */
		private boolean myUpdateCache = true;

		/**
		 * @generated
		 */
		private boolean myModifiable = false;

		/**
		 * @generated
		 */
		private boolean myReadOnly = true;

		/**
		 * @generated
		 */
		public ResourceSetInfo(IDiagramDocument document,
				IEditorInput editorInput) {
			super(document);
			myDocument = document;
			myEditorInput = editorInput;
			startResourceListening();
		}

		/**
		 * @generated
		 */
		public long getModificationStamp() {
			return myModificationStamp;
		}

		/**
		 * @generated
		 */
		public void setModificationStamp(long modificationStamp) {
			myModificationStamp = modificationStamp;
		}

		/**
		 * @generated
		 */
		public ResourceSet getResourceSet() {
			return myDocument.getEditingDomain().getResourceSet();
		}

		/**
		 * @generated
		 */
		public IEditorInput getEditorInput() {
			return myEditorInput;
		}

		/**
		 * @generated
		 */
		public void dispose() {
			stopResourceListening();
			for (Iterator it = getResourceSet().getResources().iterator(); it
					.hasNext();) {
				Resource resource = (Resource) it.next();
				resource.unload();
			}
		}

		/**
		 * @generated
		 */
		public boolean isSynchronized() {
			return myUnSynchronizedResources.size() == 0;
		}

		/**
		 * @generated
		 */
		public void setUnSynchronized(Resource resource) {
			myUnSynchronizedResources.add(resource);
		}

		/**
		 * @generated
		 */
		public void setSynchronized(Resource resource) {
			myUnSynchronizedResources.remove(resource);
		}

		/**
		 * @generated
		 */
		public final void stopResourceListening() {
			mySynchronizer.dispose();
			mySynchronizer = null;
		}

		/**
		 * @generated
		 */
		public final void startResourceListening() {
			mySynchronizer = new WorkspaceSynchronizer(myDocument
					.getEditingDomain(), new SynchronizerDelegate());
		}

		public boolean isUpdateCache() {
			return myUpdateCache;
		}

		public void setUpdateCache(boolean update) {
			myUpdateCache = update;
		}

		public boolean isModifiable() {
			return myModifiable;
		}

		public void setModifiable(boolean modifiable) {
			myModifiable = modifiable;
		}

		public boolean isReadOnly() {
			return myReadOnly;
		}

		public void setReadOnly(boolean readOnly) {
			myReadOnly = readOnly;
		}

		/**
		 * @generated
		 */
		private class SynchronizerDelegate implements
				WorkspaceSynchronizer.Delegate {

			/**
			 * @generated
			 */
			public void dispose() {
			}

			/**
			 * @generated
			 */
			public boolean handleResourceChanged(final Resource resource) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						ResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						handleElementChanged(ResourceSetInfo.this, resource,
								null);
					}
				});
				return true;
			}

			/**
			 * @generated
			 */
			public boolean handleResourceDeleted(Resource resource) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						ResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						fireElementDeleted(ResourceSetInfo.this
								.getEditorInput());
					}
				});
				return true;
			}

			/**
			 * @generated
			 */
			public boolean handleResourceMoved(Resource resource,
					final org.eclipse.emf.common.util.URI newURI) {
				synchronized (ResourceSetInfo.this) {
					if (ResourceSetInfo.this.fCanBeSaved) {
						ResourceSetInfo.this.setUnSynchronized(resource);
						return true;
					}
				}
				if (myDocument.getDiagram().eResource() == resource) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							handleElementMoved(ResourceSetInfo.this
									.getEditorInput(), newURI);
						}
					});
				} else {
					handleResourceDeleted(resource);
				}
				return true;
			}

		}

	}

	/**
	 * @generated
	 */
	private class ResourceSetModificationListener extends EContentAdapter {

		/**
		 * @generated
		 */
		private NotificationFilter myModifiedFilter;

		/**
		 * @generated
		 */
		private ResourceSetInfo myInfo;

		/**
		 * @generated
		 */
		public ResourceSetModificationListener(ResourceSetInfo info) {
			myInfo = info;
			myModifiedFilter = NotificationFilter.createEventTypeFilter(
					Notification.SET).or(
					NotificationFilter
							.createEventTypeFilter(Notification.UNSET)).and(
					NotificationFilter.createFeatureFilter(Resource.class,
							Resource.RESOURCE__IS_MODIFIED));
		}

		/**
		 * @generated
		 */
		public void notifyChanged(Notification notification) {
			if (notification.getNotifier() instanceof ResourceSet) {
				super.notifyChanged(notification);
			}
			if (myModifiedFilter.matches(notification)) {
				if (notification.getNotifier() instanceof Resource) {
					Resource resource = (Resource) notification.getNotifier();
					if (resource.isLoaded()) {
						boolean modified = false;
						for (Iterator it = myInfo.getResourceSet()
								.getResources().iterator(); it.hasNext()
								&& !modified;) {
							Resource nextResource = (Resource) it.next();
							if (nextResource.isLoaded()) {
								modified = nextResource.isModified();
							}
						}
						boolean dirtyStateChanged = false;
						synchronized (myInfo) {
							if (modified != myInfo.fCanBeSaved) {
								myInfo.fCanBeSaved = modified;
								dirtyStateChanged = true;
							}
							if (!resource.isModified()) {
								myInfo.setSynchronized(resource);
							}
						}
						if (dirtyStateChanged) {
							fireElementDirtyStateChanged(myInfo
									.getEditorInput(), modified);

							if (!modified) {
								myInfo
										.setModificationStamp(computeModificationStamp(myInfo));
							}
						}
					}
				}
			}
		}

	}

}
