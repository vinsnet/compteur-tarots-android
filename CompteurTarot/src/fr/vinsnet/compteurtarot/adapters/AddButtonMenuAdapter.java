package fr.vinsnet.compteurtarot.adapters;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.activities.fillroundstrategy.FillRoundStrategy;
import fr.vinsnet.compteurtarot.activities.fillroundstrategy.FillRoundStrategy.Actionable;
import fr.vinsnet.utils.adapters.SimpleListAdapter;

public class AddButtonMenuAdapter extends  SimpleListAdapter<AddButtonMenuItem>  implements DialogInterface.OnClickListener{

	private Actionable actionable;

	public AddButtonMenuAdapter(Activity context, List<AddButtonMenuItem> list,FillRoundStrategy.Actionable actionable) {
		super(context, list);
		this.actionable=actionable;
	}

	private static final String TAG = "AddButtonMenuAdapter";

	@Override
	protected void onSelectedItem(AddButtonMenuItem item, View v) {
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
		TextView v = new TextView(getContext());
		v.setHeight(48);
		return v;
	}

	@Override
	protected void updateView(View currentView, AddButtonMenuItem item) {
		((TextView)currentView).setText(item.getLabel());
		
	}

	public void onClick(DialogInterface dialog, int which) {
		AlertDialog d = (AlertDialog) dialog;
		d.hide();
		switch(getItem(which).getCode()){
		case AddButtonMenuItem.PETIT_AU_BOUT : 
			this.actionable.onAskPetitAuBon();
			break;
		case AddButtonMenuItem.POIGNEE : 
			this.actionable.onAskPoignee();
			break;
		case AddButtonMenuItem.JEU_BLANC : 
			this.actionable.onAskJeuBlanc();
			break;
		case AddButtonMenuItem.PENALITE : 
			this.actionable.onAskPenalty();
			break;
		case AddButtonMenuItem.CHELEM : 
			this.actionable.onAskChelem();
			break;
		}
		
	}




}
