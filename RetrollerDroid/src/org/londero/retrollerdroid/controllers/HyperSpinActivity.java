package org.londero.retrollerdroid.controllers;

import static org.londero.retrollerdroid.command.AwtKey.ENTER;
import static org.londero.retrollerdroid.command.AwtKey.ESCAPE;
import static org.londero.retrollerdroid.command.Command.Builder.command;

import org.londero.retrollerdroid.R;
import org.londero.retrollerdroid.command.AwtKey;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HyperSpinActivity extends ControllerActivity {
	
	public static final String CONTROLLER_NAME = "HyperSpin";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new HyperSpinFragment()).commit();
		}
	}
	
	public void back(View view) {
		postToServer(command().withKey(ESCAPE).build());
	}

	public void select(View view) {
		postToServer(command().withKey(ENTER).build());
	}

	public void up(View view) {
		postToServer(command().withKey(AwtKey.UP).build());
	}

	public void down(View view) {
		postToServer(command().withKey(AwtKey.DOWN).build());
	}

	public static class HyperSpinFragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";

		public static HyperSpinFragment newInstance(int sectionNumber) {
			HyperSpinFragment fragment = new HyperSpinFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public HyperSpinFragment() {}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragment_hyper_spin, container, false);
		}
	}

}
