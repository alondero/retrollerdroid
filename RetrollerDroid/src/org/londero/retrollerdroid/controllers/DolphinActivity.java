package org.londero.retrollerdroid.controllers;

import static org.londero.retrollerdroid.command.AwtKey.F1;
import static org.londero.retrollerdroid.command.AwtKey.F4;
import static org.londero.retrollerdroid.command.AwtModifier.ALT;
import static org.londero.retrollerdroid.command.AwtModifier.SHIFT;
import static org.londero.retrollerdroid.command.Command.Builder.command;

import org.londero.retrollerdroid.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DolphinActivity extends ControllerActivity {

	public static final String CONTROLLER_NAME = "Dolphin";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new DolphinFragment()).commit();
		}
	}
	
	public void loadState(View view) {
		postToServer(command().withKey(F1).build());
	}
	
	public void saveState(View view) {
		postToServer(command().withKey(F1).withModifier(SHIFT).build());
	}
	
	public void quit(View view) {
		postToServer(command().withKey(F4).withModifier(ALT).build());
	}
	
	public static class DolphinFragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";

		public static DolphinFragment newInstance(int sectionNumber) {
			DolphinFragment fragment = new DolphinFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public DolphinFragment() {}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_dolphin, container, false);
		}
	}
}
