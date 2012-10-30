package fr.vinsnet.compteurtarot.adapters;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.activities.strategies.fillround.FillRoundStrategy;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.JeuBlancAtout;
import fr.vinsnet.compteurtarot.model.JeuBlancTete;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.utils.adapters.SimpleListAdapter;

public class JeuBlancMenuAdapter extends SimpleListAdapter<JeuBlancMenuItem> implements DialogInterface.OnClickListener{

	private static final String TAG = "JeuBlancMenuAdapter";
	private Player player;
	private FillRoundStrategy strategy;

	public JeuBlancMenuAdapter(Activity context,FillRoundStrategy strategy,Player selectedPlayer) {
		super(context, getInitList());
		this.strategy = strategy;
		this.player = selectedPlayer;
		
		// TODO Auto-generated constructor stub
	}

	private static List<JeuBlancMenuItem> getInitList() {
		ArrayList<JeuBlancMenuItem> listItem = new ArrayList<JeuBlancMenuItem>(2);
		listItem.add(new JeuBlancMenuItem("Jeu blanc d'atout", JeuBlancMenuItem.ATOUT));
		listItem.add(new JeuBlancMenuItem("Jeu blanc de tete", JeuBlancMenuItem.TETE));
		return listItem;
	}

	@Override
	protected void onSelectedItem(JeuBlancMenuItem item, View v) {
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
	protected void updateView(View currentView, JeuBlancMenuItem item) {
		((TextView)currentView).setText(item.getLabel());
		
	}
	
	@Override
	protected View instanciateNewView() {
		TextView v = new TextView(getContext());
		v.setHeight(48);
		return v;
	}
	
	public void onClick(DialogInterface dialog, int which) {
		AlertDialog d = (AlertDialog) dialog;
		d.hide();
		Bonus b=null;
		switch(getItem(which).getCode()){
		case JeuBlancMenuItem.ATOUT : 
			b= new JeuBlancAtout( player);
			break;
		case JeuBlancMenuItem.TETE : 
			b= new JeuBlancTete( player);
			break;
		
		}
		if(b!=null){
			strategy.addBonus(b);
		}
	}

}
