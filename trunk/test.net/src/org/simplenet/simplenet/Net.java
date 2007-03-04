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
 * A representation of the model object '<em><b>Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.simplenet.simplenet.Net#getName <em>Name</em>}</li>
 *   <li>{@link org.simplenet.simplenet.Net#getDevices <em>Devices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.simplenet.simplenet.SimplenetPackage#getNet()
 * @model
 * @generated
 */
public interface Net extends EObject {
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
	 * @see org.simplenet.simplenet.SimplenetPackage#getNet_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.simplenet.simplenet.Net#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Devices</b></em>' containment reference list.
	 * The list contents are of type {@link org.simplenet.simplenet.Device}.
	 * It is bidirectional and its opposite is '{@link org.simplenet.simplenet.Device#getNet <em>Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Devices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Devices</em>' containment reference list.
	 * @see org.simplenet.simplenet.SimplenetPackage#getNet_Devices()
	 * @see org.simplenet.simplenet.Device#getNet
	 * @model type="org.simplenet.simplenet.Device" opposite="net" containment="true"
	 * @generated
	 */
	EList<Device> getDevices();

} // Net
