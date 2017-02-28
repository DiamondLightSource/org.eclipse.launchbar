/*******************************************************************************
 * Copyright (c) 2016 QNX Software Systems and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.launchbar.core.target;

/**
 * Working copy to set attributes on a target and then save them.
 */
public interface ILaunchTargetWorkingCopy extends ILaunchTarget {

	/**
	 * Get the original launch target.
	 * 
	 * @return the original launch target
	 */
	ILaunchTarget getOriginal();

	/**
	 * Gives the target a new ID. The save method will return a new target with the given name.e
	 * 
	 * @param id
	 *            new target ID
	 */
	void setId(String id);

	/**
	 * Set an attribute.
	 * 
	 * @param key
	 *            key
	 * @param value
	 *            value
	 */
	void setAttribute(String key, String value);

	/**
	 * Save the changes to the original working copy.
	 * 
	 * @return original launch target unless the id was changed in which case returns a new target
	 */
	ILaunchTarget save();

}
