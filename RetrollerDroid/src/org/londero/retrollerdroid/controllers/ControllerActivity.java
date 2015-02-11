package org.londero.retrollerdroid.controllers;

import org.londero.retrollerdroid.command.Command;
import org.londero.retrollerdroid.wifi.RetrollerServerClient;
import org.londero.retrollerdroid.wifi.RetrollerServerHttpClient;

import android.app.Activity;

/**
 * Defines basic behaviour of all Controllers
 * @author Adam Londero
 */
public abstract class ControllerActivity extends Activity {

	private RetrollerServerClient retrollerClient = new RetrollerServerHttpClient("192.168.0.8", "7778");
	
	protected void postToServer(Command command) {
		retrollerClient.post(command);
	}
}
