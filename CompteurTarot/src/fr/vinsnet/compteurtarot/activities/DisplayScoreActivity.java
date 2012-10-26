package fr.vinsnet.compteurtarot.activities;

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

public class DisplayScoreActivity extends Activity {

	
	
    private static final String TAG = "DisplayScoreActivity";
	private Game currentGame;
	private Round currentRound;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentGame = Utils.getCurrentGame(this);
        setContentView(R.layout.activity_display_score);
        Log.v(TAG,"childcount :"+getHeader().getChildCount());
        
    }
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
        Log.v(TAG,"childcount :"+getHeader().getChildCount());
	}

    protected void createHeader() {
		Log.v(TAG, "players.size()="+currentGame.getPlayers().size());
		ViewGroup header = getHeader();
		header.removeAllViews();
		for(Player p : currentGame.getPlayers()){
			header.addView(Utils.getNewPlayerView(this,p));
		}
		header.requestLayout();
	}


@Override
public void onContentChanged() {
		createHeader();
		updateAddRoundButton();
	}

	private void updateAddRoundButton() {
		if(currentRound==null){
			//TODO
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
		if (resultCode == AddRoundActivity.RESULT_NOT_FINISHED){
			currentRound = Utils.getCurrentRound(data);
			onContentChanged();
		}
	}
}
}
