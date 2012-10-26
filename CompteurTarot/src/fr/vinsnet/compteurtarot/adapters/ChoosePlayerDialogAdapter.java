package fr.vinsnet.compteurtarot.adapters;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.views.ChoosePlayerDialog.OnPlayerChosenListener;
import fr.vinsnet.compteurtarot.views.ContactView;
import fr.vinsnet.utils.adapters.SimpleListAdapter;

public class ChoosePlayerDialogAdapter extends SimpleListAdapter<Player>
		implements ListAdapter {

	private OnPlayerChosenListener listener;

	public ChoosePlayerDialogAdapter(Activity context, List<Player> list,OnPlayerChosenListener listener) {
		super(context, list);
		this.listener = listener;
	}

	private static final String TAG = "ChoosePlayerDialogAdapter";

	@Override
	protected int getItemLayoutId() {
		return Utils.CONTACT_VIEW_ID;
	}

	@Override
	protected void updateView(View currentView, Player item) {
		Log.v(TAG, "updateView");
		ContactView v = (ContactView) currentView;
		v.setPlayer(item);

	}

	@Override
	protected void onSelectedItem(Player item, View v) {
		listener.onPlayerChosen(item);
		
	}
	
	@Override
	protected void changeOnClickListener(View currentView, Player item) {

		currentView.setOnClickListener(getNewSimpleOnClickListener( item));
	}

}
