package org.londero.retrollerdroid.command;

public enum AwtKey {
	ESCAPE(27),
	ENTER(10),
	F1(0x70),
	F3(0x72),
	F4(0x73),
	UP(0x26),
	DOWN(0x28);

	private int keyCode;
	
	AwtKey(int keyCode) {
		this.keyCode = keyCode;
	}

	public int getKey() {
		return keyCode;
	}
}
