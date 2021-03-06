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
package fr.vinsnet.compteurtarot.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.compteurtarot.model.strategies.RoundScore;
import fr.vinsnet.compteurtarot.views.PlayerScoreView;

public class DisplayScoreActivity extends Activity {

	
	
    private static final String TAG = "DisplayScoreActivity";
	private Game currentGame;
	private Round currentRound;
	private List<Player> currentPlayerOrder;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentGame = Utils.getCurrentGame(this);
        currentPlayerOrder = currentGame.getPlayers();
        setContentView(R.layout.activity_display_score);
        
        Log.v(TAG,"childcount :"+getHeader().getChildCount());
        
    }
	
	@Override
	protected void onStart() {
		super.onStart();
        Log.v(TAG,"childcount :"+getHeader().getChildCount());
	}

    protected void createHeader() {
		Log.v(TAG, "players.size()="+getCurrentPlayerOrder().size());
		ViewGroup header = getHeader();
		header.removeAllViews();
		for(Player p : getCurrentPlayerOrder()){
			header.addView(Utils.getNewPlayerView(this,p));
		}
		header.requestLayout();
	}


@Override
public void onContentChanged() {
		createHeader();
		updateAddRoundButton();
		updateScore();
		super.onContentChanged();
	}

	private void updateScore() {
		ViewGroup roundScorePanel = getRoundScorePanelView();
		roundScorePanel.removeAllViews();
		List<RoundScore> roundScores = getRoundScoreList();
		for(RoundScore r : roundScores){
			roundScorePanel.addView(instanciateNewScorePanel(r,getCurrentPlayerOrder()));
		}
	
}

	private List<RoundScore> getRoundScoreList() {
		RoundScore score = null;
		List<RoundScore> scoreList = new ArrayList<RoundScore>();
		for(Round r : currentGame.getRounds()){
			score= new RoundScore(score, currentGame.getNewResultStrategy(r).getResult());
			scoreList.add(score);
		}
		if(currentRound!=null){
			scoreList.add(new RoundScore(score, currentGame.getNewResultStrategy(currentRound).getResult()));
		}
		return scoreList;
	}

	private View instanciateNewScorePanel(RoundScore r,
			List<Player> currentPlayerOrder) {
		LinearLayout layout = instancianteRoundScoreLayout();
		
		for(Player p : currentPlayerOrder){
			layout.addView(new PlayerScoreView(this,r,p));
		}
		return layout;
	}

	private LinearLayout instancianteRoundScoreLayout() {
		LinearLayout layout= new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		return layout ;
	}

	private List<Player> getCurrentPlayerOrder() {
		return this.currentPlayerOrder;
	}

	private ViewGroup getRoundScorePanelView() {
		return (ViewGroup) findViewById(R.id.dsa_round_score_panel);
	}

	private void updateAddRoundButton() {
		if(currentRound==null){
			getAddRoundButton().setText(R.string.dsa_addRound);
		}else{
			getAddRoundButton().setText(R.string.dsa_returnToRound);
		}
	}

	private Button getAddRoundButton(){
		return (Button) findViewById(R.id.dsa_add_round_button);
		
	}

	private ViewGroup getHeader() {
		return (LinearLayout)this.findViewById(R.id.dsa_score_header);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.display_score, menu);
        return true;
    }

    
 
	public void addRound(View view){
		if(currentRound==null){
			currentRound=new Round();
		}
		Utils.displayNewRound(this, currentGame,currentRound);
	}
    
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	
	if(requestCode==Utils.NEW_ROUND_REQUEST_CODE){
		Log.v(TAG,"onActivityResult NEW_ROUND_REQUEST_CODE");
		switch(resultCode){
		case AddRoundActivity.RESULT_NOT_FINISHED:
			currentRound = Utils.getCurrentRound(data,this.currentGame.getPlayers());
			break;
		case AddRoundActivity.RESULT_OK : 
			currentRound = null;
			reloadCurrentGame();
		}
		onContentChanged();
	}
}

protected void reloadCurrentGame() {
	Log.v(TAG,"reloadCurrentGame");
	currentGame = Utils.getGameDao(this).loadGame(currentGame.getId(),this);
	
}
}
