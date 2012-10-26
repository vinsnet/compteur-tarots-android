package fr.vinsnet.compteurtarot.adapters;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.views.ContactView;
import fr.vinsnet.utils.adapters.SimpleListAdapter;

public class SelectedContactAdapter extends SimpleListAdapter<Player> {



	
	
	private static final String TAG = "SelectedContactAdapter";
	public SelectedContactAdapter(Activity context,List<Player> list) {
		super(context,list);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getItemLayoutId() {
		return Utils.CONTACT_VIEW_ID;
	}

	@Override
	protected void updateView(View view, Player item) {
		ContactView v = (ContactView) view;
		v.setPlayer(item);
		
	}
/*
	protected static List<ContactView> convertPlayersToContactView(
			Context context, List<Player> players) {
		List<ContactView> objects = new ArrayList<ContactView>(players.size());
		for (Player p : players) {
			objects.add(new ContactView(context, p));
		}
		return objects;
	}
*/

	@Override
	protected void onSelectedItem(Player item, View v) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onSelectedItem");
		
	}
	
	

}
