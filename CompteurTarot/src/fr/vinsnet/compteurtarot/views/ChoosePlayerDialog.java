package fr.vinsnet.compteurtarot.views;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.adapters.ChoosePlayerDialogAdapter;
import fr.vinsnet.compteurtarot.model.Player;

public class ChoosePlayerDialog extends LinearLayout{

	private OnPlayerChosenListener listener;
	private AlertDialog alertDialog;

	public ChoosePlayerDialog(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ChoosePlayerDialog(Context context) {
		super(context);
	}



	public void setListener(OnPlayerChosenListener listener) {
		this.listener = listener;
		
	}

	public void setTitle(String title){
		getTitleView().setText(title);
	}
	
	public void setPlayerList(List<Player> players){
		getPlayergrid().setAdapter(new ChoosePlayerDialogAdapter( (Activity) getContext(),players,listener));
	}
	
	public GridView getPlayergrid(){
		return (GridView) findViewById(R.id.cpd_player_grid);
	}
	
	public TextView getTitleView(){
		return (TextView) findViewById(R.id.cpd_title);
	}
	
	public interface OnPlayerChosenListener{
		public void onPlayerChosen(Player selected);
	}

	public AlertDialog getAlertDialog() {
		if(alertDialog==null){
		Builder builder = new AlertDialog.Builder(getContext());
		builder.setView(this);
		this.alertDialog= builder.create();
		}
		return alertDialog;
	}
	
}
