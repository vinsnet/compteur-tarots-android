package fr.vinsnet.compteurtarot.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.adapters.SelectedContactAdapter;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Player;
public class ChooseContactActivity extends Activity {

	private Game currentGame;
	private static final int CONTACT_PICKER_RESULT = 1;
	private SelectedContactAdapter selectedContactAdapter;

	private GridView selectedContactGrid;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		currentGame=(Game) getLastNonConfigurationInstance();
		if(currentGame==null){
			currentGame = Utils.getCurrentGame(this);
		}
		setContentView(R.layout.activity_choose_contact);
		
		SelectedContactAdapter adapter = getSelectedContactAdapter();
		getSelectedContactGrid().setNumColumns(6);
		this.setListSelectedContactAdapter(adapter);
		
		
		// currentGame = ((MainActivity)getParent()).getCurrentGame();
		/* ((TextView) ) */
		// ((TextView)findViewById(R.id.TestText)).setText(currentGame.getStartTime().toLocaleString());
		updateAddContactButton();
		updateStartGameButton();
	}

	private GridView getSelectedContactGrid() {
		if(this.selectedContactGrid==null){
			selectedContactGrid=(GridView)findViewById(R.id.cca_selected_contact_view);
		}
		return selectedContactGrid;
	}

	private void setListSelectedContactAdapter(SelectedContactAdapter adapter) {
		this.selectedContactAdapter=adapter;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_choose_player, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*
		 * switch (item.getItemId()) { case android.R.id.home:
		 * NavUtils.navigateUpFromSameTask(this); return true; }
		 */
		return super.onOptionsItemSelected(item);
	}

	public void addContact(View view) {
		Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
				Contacts.CONTENT_URI);
		startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT);
	}
	
	
	public void startGame(View view) {
		Utils.getGameDao(this).save(currentGame);
		Utils.displayGame(this, currentGame);
	}
	


	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // Check which request we're responding to
	    if (requestCode == CONTACT_PICKER_RESULT) {
	        // Make sure the request was successful
	        if (resultCode == RESULT_OK) {
	          onContactSelected(data);
	          }
	    }
	}

	private void onContactSelected(Intent data) {
		Uri contactUri = data.getData();
		Player player = newPlayerFromContactUri(contactUri);
		currentGame.addPlayer(player);
		this.selectedContactAdapter.notifyDataSetChanged();
		Log.v("ChoosePlayerActivity", "selected Contact added" );
	}

	private SelectedContactAdapter getSelectedContactAdapter() {
		return new SelectedContactAdapter(this,currentGame.getPlayers());
	}

	protected Player newPlayerFromContactUri(Uri contactUri) {
		
		Player p =new Player();
		p.setContactUri(contactUri);
		
		
		String[] projection = new String[] { Contacts._ID,Contacts.DISPLAY_NAME};
		
		Cursor nameCur = getApplicationContext().getContentResolver().query(p.getContactUri(),projection, null, null, null);
		String name =null;
		int id = 0;
		//TODO en lire seulement 1
		while (nameCur.moveToNext()) {
	        name = nameCur.getString(1);
	        id = nameCur.getInt(0);
	    }
	    nameCur.close();
	    
	    p.setContactId(id);
	    p.setName(name);
	    
	    return p;
	    
	}
	
	   @Override
	    public void onContentChanged() {
	        
	       // View emptyView = findViewById(com.android.internal.R.id.empty);
	       GridView grid = getSelectedContactGrid();
	      //  GridView grid = (GridView) getSelectedContactAdapter().getContext().findViewById(R.id.selected_contact_view);
	        
	        
	       //if (emptyView != null) {
	      // grid.setEmptyView(new View(this));
	       // }
	       
	        //TODO mList.setOnItemClickListener(mOnClickListener);
	       // if (mFinishedStart) {
	       grid.invalidateViews();
	       grid.setAdapter(getSelectedContactAdapter());
	     //  grid.forceLayout();
	       
	        //}
	       updateAddContactButton();
	       updateStartGameButton();
	       super.onContentChanged();
	       
	       
	      //  mFinishedStart = true;
	    }

	private void updateStartGameButton() {
		Button startGameButton=getStartGameButton();
		if(currentGame.getPlayers().size()>=3){
			startGameButton.setEnabled(true);
			startGameButton.setClickable(true);
		}else{
			startGameButton.setEnabled(false);
			startGameButton.setClickable(false);
		}
	}

	private void updateAddContactButton() {
		Button addContactButton=getAddContactButton();
		if(currentGame.getPlayers().size()<6){
			addContactButton.setEnabled(true);
			addContactButton.setClickable(true);
		}else{
			addContactButton.setEnabled(false);
			addContactButton.setClickable(false);
		}
	}
	
	@Override
	public Object onRetainNonConfigurationInstance() {
		// TODO Auto-generated method stub
		return currentGame;
	}
	private Button getAddContactButton() {
		return (Button) findViewById(R.id.cca_add_player_button);
	}

	private Button getStartGameButton() {
		return (Button) findViewById(R.id.cca_startGame_button);
	}
	

}
