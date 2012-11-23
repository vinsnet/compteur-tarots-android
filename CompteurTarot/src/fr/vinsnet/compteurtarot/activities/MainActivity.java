package fr.vinsnet.compteurtarot.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.dao.raw.BaseRawDao;
import fr.vinsnet.compteurtarot.model.Game;

public class MainActivity extends Activity {

    //private Game currentGame; 
   
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
	
	@Override
	protected void onResume() {
		onContentChanged();
		super.onResume();
	}

    private void updateResumeButton() {
    	Button restoreButton = (Button) findViewById(R.id.ma_buttonRestoreGame);
    	
    	if(Utils.getGameDao(getApplicationContext()).hasSavedGame()){
        	restoreButton.setClickable(true);
        	restoreButton.setEnabled(true);
        }else{
        	restoreButton.setClickable(false);
        	restoreButton.setEnabled(false);	
        }
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	 public void startNewGame(View view){
	    	Utils.startNewGame(this);
	    }
	 
	 
	 public void resumeGame(View view){
		 	Game currentGame = Utils.getGameDao(getApplicationContext()).loadLastGame();
	        Utils.displayGame(this, currentGame);
	    }
	 public void eraseData(View view){
		 	 this.deleteDatabase(BaseRawDao.DATABASE_NAME);
		 	 onContentChanged();
	    }
	 @Override
	public void onContentChanged() {
		updateResumeButton();
		super.onContentChanged();
	}
    
	/*public Game getCurrentGame() {
		// TODO Auto-generated method stub
		return currentGame;
	}*/
    
}
