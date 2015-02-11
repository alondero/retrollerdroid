package org.londero.retrollerdroid;

import static org.londero.retrollerdroid.controllers.Controller.Builder.controller;

import java.util.ArrayList;
import java.util.List;

import org.londero.retrollerdroid.controllers.Controller;
import org.londero.retrollerdroid.controllers.DolphinActivity;
import org.londero.retrollerdroid.controllers.HyperSpinActivity;
import org.londero.retrollerdroid.controllers.Pcsx2Activity;
import org.londero.retrollerdroid.controllers.VisualBoyAdvanceActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

	private ArrayAdapter<Controller> controllerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<Controller> controllers = new ArrayList<>();
		controllers.add(controller().withName("Hyperspin").withClass(HyperSpinActivity.class).build());
		controllers.add(controller().withName("VisualBoy Advance").withClass(VisualBoyAdvanceActivity.class).build());
		controllers.add(controller().withName("PCSX2").withClass(Pcsx2Activity.class).build());
		controllers.add(controller().withName("Dolphin").withClass(DolphinActivity.class).build());
		
		controllerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, controllers);
		setListAdapter(controllerAdapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Controller selectedController = (Controller) getListView().getItemAtPosition(position);
		startActivity(new Intent(this, selectedController.getActivity()));
	}
}
