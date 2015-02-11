package org.londero.retrollerdroid.wifi;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.londero.retrollerdroid.command.Command;

/**
 * Http implementation of a {@link RetrollerServerClient}
 * 
 * @author Adam Londero
 */
public class RetrollerServerHttpClient implements RetrollerServerClient {

	private URL uri;

	public RetrollerServerHttpClient(String ipAddress, String port) {
		try {
			uri = new URL("http://" + ipAddress + ":" + port);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void post(final Command dataToSend) {
		Runnable postRunner = new Runnable() {

			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					String json = "{\"key\":"+dataToSend.getKey()+", \"modifier\":"+dataToSend.getModifier()+"}";
					connection = (HttpURLConnection) uri.openConnection();
					int length = json.getBytes().length;
					connection.setRequestProperty("Content-Type", "application/json");
					connection.setRequestProperty("Content-Length", "" + length);
					connection.setFixedLengthStreamingMode(length);
					connection.setDoOutput(true);

					BufferedOutputStream wr = new BufferedOutputStream(connection.getOutputStream());
					wr.write(json.getBytes());
					wr.flush();
					wr.close();
				} catch (IOException ioe) {
					Logger.getAnonymousLogger().log(Level.SEVERE, "Unable to POST to Retroller server", ioe);
				} finally {
					connection.disconnect();
				}
			}
		};
		
		new Thread(postRunner).start();
	}
	
}
