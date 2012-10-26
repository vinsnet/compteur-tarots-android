package fr.vinsnet.compteurtarot.adapters;


import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.activities.AddRoundActivity;
import fr.vinsnet.compteurtarot.model.DoublePoignee;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Poignee;
import fr.vinsnet.compteurtarot.model.SimplePoignee;
import fr.vinsnet.compteurtarot.model.TriplePoignee;
import fr.vinsnet.utils.adapters.SimpleListAdapter;

public class PoigneeMenuAdapter extends SimpleListAdapter<PoigneeMenuItem> implements DialogInterface.OnClickListener  {

	

	public PoigneeMenuAdapter(AddRoundActivity context) {
		super(context, getInitList());
	}

	private static List<PoigneeMenuItem> getInitList() {
		List<PoigneeMenuItem> list = new ArrayList<PoigneeMenuItem>(3);
		list.add(new PoigneeMenuItem("Poignee Simple", SimplePoignee.TYPE));
		list.add(new PoigneeMenuItem("Poignee Double", DoublePoignee.TYPE));
		list.add(new PoigneeMenuItem("Poignee Triple", TriplePoignee.TYPE));
		return list;
	}

	private static final String TAG = "PoigneeMenuAdapter";

	@Override
	protected void onSelectedItem(PoigneeMenuItem item, View v) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onSelectedItem");
		
	}

	@Override
	protected int getItemLayoutId() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getItemLayoutId");
		return 0;
	}

	@Override
	protected void updateView(View currentView, PoigneeMenuItem item) {
		((TextView)currentView).setText(item.getLabel());
		
	}
	
	@Override
	protected View instanciateNewView() {
		TextView view = new TextView(getContext());
		return view;
	}

	public void onClick(DialogInterface dialog, int which) {
		((AlertDialog)dialog).hide();
		Poignee p =null;
		switch(getItem(which).getCode()){
		case SimplePoignee.TYPE:p=new SimplePoignee(null);break;
		case DoublePoignee.TYPE:p=new DoublePoignee(null);break;
		case TriplePoignee.TYPE:p=new TriplePoignee(null);break;
		}
		AddRoundActivity c=((AddRoundActivity)getContext());
		List<Player> players = c.getGame().getPlayers();
		c.prepareChoosePlayerPoigneeView(players, p);
		c.getAskPlayerPoigneeAlertDialog().show();
	}

}
