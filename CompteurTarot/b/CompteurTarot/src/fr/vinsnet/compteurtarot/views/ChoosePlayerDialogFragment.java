/*******************************************************************************
 * Copyright (c) 2012 vinsnet<vinsnet@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     vinsnet<vinsnet@gmail.com> - initial API and implementation
 ******************************************************************************/
package fr.vinsnet.compteurtarot.views;

import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.model.Player;

public class ChoosePlayerDialogFragment extends DialogFragment{

	private OnPlayerChosenListener listener;
	private List<Player> players;

//TODO metre les player dans le dialog
	public ChoosePlayerDialogFragment(){
		
	}


	public ChoosePlayerDialogFragment(List<Player> players) {
		this.players = players;
	}

	public void setListener(OnPlayerChosenListener listener) {
		this.listener = listener;
		
	}

	public void setTitle(String title){
		getTitleView().setText(title);
	}
	
	
	// getPlayerGrid().setAdapter(new ChoosePlayerDialogAdapter(  getActivity(),players,listener));
	public void setPlayerList(List<Player> players){
		this.players = players;
		this.getView().requestLayout();
	}
	
	public GridView getPlayerGrid(){
		return (GridView) getActivity().findViewById(R.id.cpd_player_grid);
	}
	
	public TextView getTitleView(){
		return (TextView) getActivity().findViewById(R.id.cpd_title);
	}
	
	public interface OnPlayerChosenListener{
		public void onPlayerChosen(Player selected);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		builder.setView((ContactView)inflater.inflate(R.layout.view_contact,null));
		return builder.create();
	}
	
}