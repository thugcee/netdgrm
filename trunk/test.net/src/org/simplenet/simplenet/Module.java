/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.simplenet.simplenet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.simplenet.simplenet.Module#getName <em>Name</em>}</li>
 *   <li>{@link org.simplenet.simplenet.Module#getDevice <em>Device</em>}</li>
 *   <li>{@link org.simplenet.simplenet.Module#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.simplenet.simplenet.SimplenetPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.simplenet.simplenet.SimplenetPackage#getModule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.simplenet.simplenet.Module#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Device</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.simplenet.simplenet.Device#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' container reference.
	 * @see #setDevice(Device)
	 * @see org.simplenet.simplenet.SimplenetPackage#getModule_Device()
	 * @see org.simplenet.simplenet.Device#getModules
	 * @model opposite="modules"
	 * @generated
	 */
	Device getDevice();

	/**
	 * Sets the value of the '{@link org.simplenet.simplenet.Module#getDevice <em>Device</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' container reference.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(Device value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.simplenet.simplenet.Port}.
	 * It is bidirectional and its opposite is '{@link org.simplenet.simplenet.Port#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see org.simplenet.simplenet.SimplenetPackage#getModule_Ports()
	 * @see org.simplenet.simplenet.Port#getModule
	 * @model type="org.simplenet.simplenet.Port" opposite="module" containment="true"
	 * @generated
	 */
	EList<Port> getPorts();

} // Module
