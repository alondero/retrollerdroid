package org.londero.retrollerdroid.command;

public enum AwtModifier {
	SHIFT(0x10),
	ALT(0x12);
	
	private int code;

	private AwtModifier(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

}
