package fr.vinsnet.compteurtarot.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.activities.strategies.fillround.FillRoundStrategy;
import fr.vinsnet.compteurtarot.adapters.MenuItem;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.utils.adapters.SimpleListAdapter;

public class PetitAuBoutMenuAdapter extends SimpleListAdapter<MenuItem> implements DialogInterface.OnClickListener {

	private static final String TAG = "PetitAuBoutMenuAdapter";
	private static final int DEFENDERS = 1;
	private static final int TAKERS = 2;
	private Round round;
	private FillRoundStrategy strategy;

	public PetitAuBoutMenuAdapter(Activity context, Round  r,FillRoundStrategy strategy) {
		super(context, getInitList());
		this.round=r;
		this.strategy = strategy;
	}

	private static List<MenuItem> getInitList() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		list.add(new MenuItem("Preuneurs", TAKERS));
		list.add(new MenuItem("Preuneurs", DEFENDERS));
		return list;
	}

	@Override
	protected void onSelectedItem(MenuItem item, View v) {
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
	protected View instanciateNewView() {
		return new LinearLayout(getContext());
	}

	@Override
	protected void updateView(View currentView, MenuItem item) {
		LinearLayout view = (LinearLayout)currentView;
		view.removeAllViews();
		if(item.getCode()==TAKERS){
			for(Player p : round.getTakers()){
				view.addView(Utils.getNewPlayerView(getContext(), p));
			}
		}else{
			for(Player p : round.getDefenders()){
				view.addView(Utils.getNewPlayerView(getContext(), p));
			}
		}
	}


	
	public void onClick(DialogInterface di, int which) {
		AlertDialog alert = (AlertDialog) di;
		alert.hide();
		PetitAuBout pab=null;
		switch (getItem(which).getCode()) {
		case TAKERS:
			pab=new PetitAuBout(true);
			break;
		case DEFENDERS:

			pab=new PetitAuBout(false);
			break;

		}
		if(pab!=null){
			strategy.setPetitAuBout(pab);
		}
	}

}
