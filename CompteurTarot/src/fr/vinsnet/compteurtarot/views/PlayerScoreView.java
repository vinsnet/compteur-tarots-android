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

import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.strategies.RoundScore;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

public class PlayerScoreView extends TextView {

	private static final String TAG = "PlayerScoreView";
	private Player player;
	private RoundScore score;
	public PlayerScoreView(Context context) {
		super(context);
	}
	public PlayerScoreView(Context context,RoundScore score,Player p) {
		super(context);
		this.score= score;
		this.player = p;
		this.setWidth(74);
		update();
		}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onMeasure");
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	private void update() {	
		this.setText(formatScore(this.score.getScoreFor(player)));
	}
	protected String formatScore(float score){
		return ""+score;
	}
	


}
