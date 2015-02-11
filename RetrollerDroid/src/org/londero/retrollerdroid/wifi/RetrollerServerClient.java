package org.londero.retrollerdroid.wifi;

import org.londero.retrollerdroid.command.Command;

/**
 * Client for talking to the Retroller server
 * @author Adam Londero
 */
public interface RetrollerServerClient {

	/**
	 * Posts the data to the server
	 * @param data
	 */
	void post(Command command);

}
