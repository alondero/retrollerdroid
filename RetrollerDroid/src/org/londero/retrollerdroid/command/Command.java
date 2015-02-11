package org.londero.retrollerdroid.command;

/**
 * Encapsulates the command to invoke on the server
 * @author Adam Londero
 */
public class Command {

	private AwtKey key;
	private AwtModifier modifier;

	private Command(Builder builder) {
		this.key = builder.key;
		this.modifier = builder.modifier;
	}

	public static class Builder {

		private AwtKey key;
		private AwtModifier modifier;

		public static Builder command() {
			return new Builder();
		}

		public Builder withKey(AwtKey key) {
			this.key = key;
			return this;
		}
		
		public Builder withModifier(AwtModifier modifier) {
			this.modifier = modifier;
			return this;
		}

		public Command build() {
			return new Command(this);
		}
		
	}

	public int getKey() {
		return key.getKey();
	}

	public int getModifier() {
		return modifier == null ? -1 : modifier.getCode();
	}
}
