package org.londero.retrollerdroid.controllers;

import static org.londero.retrollerdroid.command.AwtKey.F1;
import static org.londero.retrollerdroid.command.AwtKey.F3;
import static org.londero.retrollerdroid.command.AwtKey.F4;
import static org.londero.retrollerdroid.command.AwtModifier.ALT;
import static org.londero.retrollerdroid.command.Command.Builder.command;

import org.londero.retrollerdroid.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Pcsx2Activity extends ControllerActivity {

	public static final String CONTROLLER_NAME = "PCSX2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new Pcsx2Fragment()).commit();
		}
	}
	
	public void loadState(View view) {
		postToServer(command().withKey(F3).build());
	}
	
	public void saveState(View view) {
		postToServer(command().withKey(F1).build());
	}
	
	public void quit(View view) {
		postToServer(command().withKey(F4).withModifier(ALT).build());
	}
	
	public static class Pcsx2Fragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";

		public static Pcsx2Fragment newInstance(int sectionNumber) {
			Pcsx2Fragment fragment = new Pcsx2Fragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public Pcsx2Fragment() {}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_pcsx2, container, false);
		}
	}
}
