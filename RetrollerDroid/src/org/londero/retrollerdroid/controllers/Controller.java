package org.londero.retrollerdroid.controllers;

import android.app.Activity;

/**
 * Encapsulates information about a controller
 * @author Adam Londero
 */
public class Controller {

	private String name;
	private Class<? extends Activity> activity;

	private Controller(Builder builder) {
		this.name = builder.name;
		this.activity = builder.activity;
	}
	
	public Class<?> getActivity() {
		return activity;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public static class Builder {

		private String name;
		private Class<? extends Activity> activity;

		public static Builder controller() {
			return new Builder();
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withClass(Class<? extends Activity> activity) {
			this.activity = activity;
			return this;
		}

		public Controller build() {
			return new Controller(this);
		}
		
	}
}
