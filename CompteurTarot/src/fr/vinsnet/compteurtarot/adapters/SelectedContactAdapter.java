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
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.views.ContactView;
import fr.vinsnet.utils.adapters.SimpleListAdapter;



 /**
 * @author vinsnet
 *
 *	adapter fonctionnant avec le layout ViewContact
 *
 */
public class SelectedContactAdapter extends SimpleListAdapter<Player> { 
	
	private static final String TAG = "SelectedContactAdapter";
	public SelectedContactAdapter(Activity context,List<Player> list) {
		super(context,list);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getItemLayoutId() {
		return R.layout.view_contact;
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
