package com.lody.virtual.client.hook.patchs.notification;

import java.lang.reflect.Method;

import com.lody.virtual.client.core.VirtualCore;
import com.lody.virtual.client.hook.base.Hook;

/**
 * @author Lody
 *
 */
/* package */ class Hook_CancelAllNotifications extends Hook {

	@Override
	public String getName() {
		return "cancelAllNotifications";
	}

	@Override
	public Object onHook(Object who, Method method, Object... args) throws Throwable {
		String pkgName = (String) args[0];
		if (!VirtualCore.getCore().isHostPackageName(pkgName)) {
			args[0] = VirtualCore.getCore().getContext().getPackageName();
			// return 0;
		}
		return method.invoke(who, args);
	}
}
