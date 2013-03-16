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
package fr.vinsnet.compteurtarot.adapters;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import fr.vinsnet.compteurtarot.R;
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
		return R.layout.view_contact;
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
