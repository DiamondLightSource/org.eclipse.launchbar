/*******************************************************************************
 * Copyright (c) 2014, 2015 QNX Software Systems and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Doug Schaefer
<<<<<<< HEAD
 *     Torkild U. Resheim
=======
 *     Torkild U. Resheim - add preference to control target selector
 *     Vincent Guignot - Ingenico - add preference to control Build button     
>>>>>>> master
 *******************************************************************************/
package org.eclipse.launchbar.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.launchbar.ui.ILaunchBarUIManager;
import org.eclipse.launchbar.ui.internal.target.LaunchTargetUIManager;
import org.eclipse.launchbar.ui.target.ILaunchTargetUIManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.launchbar.ui"; //$NON-NLS-1$

	// Images
<<<<<<< HEAD
	public static final String IMG_BUTTON_BUILD = "build"; //$NON-NLS-1$
	public static final String IMG_BUTTON_LAUNCH = "launch"; //$NON-NLS-1$
	public static final String IMG_BUTTON_STOP = "stop"; //$NON-NLS-1$
	public static final String IMG_BUTTON_DEPLOY = "deploy"; //$NON-NLS-1$

	// Command ids
	public static final String CMD_BUILD = PLUGIN_ID + ".command.buildActive"; //$NON-NLS-1$
	public static final String CMD_LAUNCH = PLUGIN_ID + ".command.launchActive"; //$NON-NLS-1$
	public static final String CMD_STOP = PLUGIN_ID + ".command.stop"; //$NON-NLS-1$
	public static final String CMD_DEPLOY = PLUGIN_ID + ".command.deploy"; //$NON-NLS-1$
	public static final String CMD_CONFIG = PLUGIN_ID + ".command.configureActiveLaunch"; //$NON-NLS-1$

	// Preference ids
	public static final String PREF_ENABLE_LAUNCHBAR = "enableLaunchBar"; //$NON-NLS-1$
	public static final String PREF_ENABLE_TARGETSELECTOR = "enableTargetSelector"; //$NON-NLS-1$
	public static final String PREF_LAUNCH_HISTORY_SIZE = "launchHistorySize"; //$NON-NLS-1$
=======
	public static final String IMG_LOCAL_TARGET = "localTarget"; //$NON-NLS-1$
>>>>>>> master

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		ImageRegistry imageRegistry = getImageRegistry();
<<<<<<< HEAD
		imageRegistry.put(IMG_BUTTON_BUILD, imageDescriptorFromPlugin(PLUGIN_ID, "icons/build.png")); //$NON-NLS-1$
		imageRegistry.put(IMG_BUTTON_LAUNCH, imageDescriptorFromPlugin(PLUGIN_ID, "icons/launch.png")); //$NON-NLS-1$
		imageRegistry.put(IMG_BUTTON_STOP, imageDescriptorFromPlugin(PLUGIN_ID, "icons/stop.png")); //$NON-NLS-1$
		imageRegistry.put(IMG_BUTTON_DEPLOY, imageDescriptorFromPlugin(PLUGIN_ID, "icons/deploy.png")); //$NON-NLS-1$
=======
		imageRegistry.put(IMG_LOCAL_TARGET, imageDescriptorFromPlugin(PLUGIN_ID, "icons/localTarget.png")); //$NON-NLS-1$

		context.registerService(ILaunchTargetUIManager.class, new LaunchTargetUIManager(), null);
		context.registerService(ILaunchBarUIManager.class, new LaunchBarUIManager(), null);
>>>>>>> master
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public Image getImage(String id) {
		Image im = getImageRegistry().get(id);
		if (im == null) {
			ImageDescriptor des = getImageDescriptor(id);
			if (des != null) {
				im = des.createImage();
				getImageRegistry().put(id, im);
			}
		}
		return im;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public static void log(IStatus status) {
		plugin.getLog().log(status);
	}

	public static void log(Exception e) {
		if (e instanceof CoreException)
			log(((CoreException) e).getStatus());
		plugin.getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getLocalizedMessage(), e));
	}

	public static <T> T getService(Class<T> cls) {
		BundleContext context = getDefault().getBundle().getBundleContext();
		ServiceReference<T> ref = context.getServiceReference(cls);
		return ref != null ? context.getService(ref) : null;
	}
}
