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
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.activities.strategies.fillround.FillRoundStrategy;
import fr.vinsnet.compteurtarot.adapters.AddButtonMenuAdapter;
import fr.vinsnet.compteurtarot.adapters.AddButtonMenuItem;
import fr.vinsnet.compteurtarot.adapters.BiddingSpinnerAdapter;
import fr.vinsnet.compteurtarot.adapters.JeuBlancMenuAdapter;
import fr.vinsnet.compteurtarot.adapters.PoigneeMenuAdapter;
import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Penalty;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Poignee;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.compteurtarot.model.strategies.RoundResult;
import fr.vinsnet.compteurtarot.views.ChoosePlayerDialog;
import fr.vinsnet.compteurtarot.views.ChoosePlayerDialog.OnPlayerChosenListener;
import fr.vinsnet.compteurtarot.views.ContactView;

public class AddRoundActivity extends Activity implements FillRoundStrategy.Actionable{

    private static final String TAG = "AddRoundActivity";
	public static final int RESULT_NOT_FINISHED = 10;
	private  FillRoundStrategy scoreStrategy;
	
	private LayoutInflater inflater;
	private AlertDialog askTakerAlertDialog;
	private AlertDialog askJeuBlancAlertDialog;
	private AlertDialog askPenaltyAlertDialog;
	private AlertDialog askPoigneePlayerAlertDialog;
	private AlertDialog askPoigneeTypeAlertDialog;
	private AlertDialog askPetitAuBoutAlertDialog;
	
	


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        scoreStrategy=(FillRoundStrategy) getLastNonConfigurationInstance();
        if(scoreStrategy==null){
        	scoreStrategy = Utils.getCurrentScoreStrategy(this,this);
        }else{
        	scoreStrategy.setActionable(this);
        }
        Game game = scoreStrategy.getGame();
        
        
        setContentView(R.layout.activity_add_round);
        
        Spinner biddingList = getBiddingSpinner();
        biddingList.setAdapter(new BiddingSpinnerAdapter(this, game.getNewResultStrategy(scoreStrategy.getCurrentRound()).getBidList(this)));
        
        //currentGame = Utils.getCurrentGame(this);
        
        getbiddingOkButton().setOnClickListener(
        		new Button.OnClickListener(){
        			public void onClick(View arg0) {
        				Bid selectedBidding = (Bid) getBiddingSpinner().getSelectedItem();
        				getCurrentScoreStrategy().setBidding(selectedBidding);	
        			}
        		}
        );
        
        getNbBoutsSeekBar().setOnSeekBarChangeListener(
        		new SeekBar.OnSeekBarChangeListener() {
					
					public void onStopTrackingTouch(SeekBar seekBar) {
						onContentChanged();
						
					}
					
					public void onStartTrackingTouch(SeekBar seekBar) {
						//TODO ?
					}
					
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						Log.v(TAG, "onProgressChanged "+progress + " " +fromUser);
						if(fromUser){
							scoreStrategy.setNbBoutsTakers(progress);
						}
						
					}
				}
        );
        
        getScoreSeekBar().setOnSeekBarChangeListener(
        		new SeekBar.OnSeekBarChangeListener() {
					
					public void onStopTrackingTouch(SeekBar seekBar) {
						onContentChanged();
					}
					
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO ?
						
					}
					
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						Log.v(TAG, "onProgressChanged");
						if(fromUser){
							float score = ((float)progress) / scoreStrategy.getScoreIntervalDivider();
							scoreStrategy.setScoreTakers(score);
						}
						
					}
				}
        	);

        
        getAddButton().setOnClickListener(
        		new Button.OnClickListener(){

					public void onClick(View v) {
						Builder builder = getNewAlertBuilder();
						List<AddButtonMenuItem> menuItem = getAddButtonItems();
						AddButtonMenuAdapter adapter = new AddButtonMenuAdapter(getActivity(),menuItem,getActivity());
						builder.setAdapter(adapter , adapter);
						AlertDialog alertDialog = builder.create();
						alertDialog.show();
					}




        			
        		}
        		);
        
        
         
    }
	
	private AddRoundActivity getActivity() {
		return this;
	}
	public Builder getNewAlertBuilder(){
		return new AlertDialog.Builder(this);
	}
	
	private List<AddButtonMenuItem> getAddButtonItems() {
		
		return Utils.getAddButtonItems(this);
	}
	
	protected SeekBar getNbBoutsSeekBar(){
		return (SeekBar) findViewById(R.id.ara_nb_bouts_seekBar);
	}	
	protected TextView getNbBoutsTakersTextView(){
		return (TextView) findViewById(R.id.ara_nb_bouts_takers_textview);
	}	
	protected TextView getNbBoutsDefendersTextView(){
		return (TextView) findViewById(R.id.ara_nb_bouts_defenders_textview);
	}
	
	public FillRoundStrategy getCurrentScoreStrategy() {
		return scoreStrategy;
		
	}
	
	public Button getAddButton(){
		return (Button) findViewById(R.id.ara_add_button);
	}
	
	@Override
	public void onContentChanged() {
		
		updateBiddingPanel();
		updateNbBoutsPanel();
		updateScorePanel();
		updatePetitAuBoutPanel();
		updatePoigneePanel();
		updateBonusPanel();
		updateResultPanel();
		super.onContentChanged();
	}
	
	private void updateBonusPanel() {
		LinearLayout layout = getBonusLayout();
		layout.removeAllViews();
		for(Bonus b: getCurrentRound().getBonus()){
			LinearLayout bonusView = new LinearLayout(this);
			TextView label = new TextView(this);
			label.setText(b.getLabel());
			ContactView playerView =Utils.getNewPlayerView(this,b.getPlayer());
			bonusView.addView(label);
			bonusView.addView(playerView);
			layout.addView(bonusView);
		}
	}

	private LinearLayout getBonusLayout() {
		return (LinearLayout) findViewById(R.id.ara_bonus_layout);
	}

	private void updatePetitAuBoutPanel() {
		LinearLayout layout = getPetitAuBoutLayout();
		layout.removeAllViews();
		PetitAuBout pab =getCurrentRound().getPetitAuBout();
		if(pab==null){
			layout.setVisibility(View.GONE);
		}else{
			layout.setVisibility(View.VISIBLE);
			TextView label = new TextView(this);
			label.setText("Petit au Bout");
			layout.addView(label);
			if(pab.isForTakers()){
				for(Player p : getCurrentRound().getTakers()){
					ContactView c = Utils.getNewPlayerView(this,p);
					layout.addView(c);
				}
			}else{
				for(Player p : getCurrentRound().getDefenders()){
					ContactView c = Utils.getNewPlayerView(this,p);
					layout.addView(c);
				}
			}
			
		}
		
		
	}
	
	private LinearLayout getPetitAuBoutLayout() {
		return (LinearLayout) findViewById(R.id.ara_petit_au_bout_layout);
		
	}

	private void updatePoigneePanel() {
		LinearLayout layout = getPoigneesLayout();
		layout.removeAllViews();
		for(Poignee p: getCurrentRound().getPoignees()){
			LinearLayout bonusView = new LinearLayout(this);
			TextView label = new TextView(this);
			label.setText(p.getLabel());
			ContactView playerView =Utils.getNewPlayerView(this,p.getPlayer());
			bonusView.addView(label);
			bonusView.addView(playerView);
			layout.addView(bonusView);
		}
	}

	private LinearLayout getPoigneesLayout() {
		return (LinearLayout) findViewById(R.id.ara_poignees_layout);
	}

	private void updateResultDetachScore(RoundResult r) {
		LinearLayout l = getDetachScoreLayout();
		l.removeAllViews();
		ArrayList<Player> players = new ArrayList<Player>(getCurrentRound().getTakers());
		players.addAll(getCurrentRound().getDefenders());
		
		Map<Long, Float> scores = r.getDetailedScores();
		
		for(Player p: players){
			LinearLayout layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.VERTICAL);
			ContactView c = Utils.getNewPlayerView(this,p);
			TextView t = new TextView(this);
			t.setText(""+scores.get(p.getId()));
			layout.addView(c);
			layout.addView(t);
			l.addView(layout);
		}
		
		
	}

	private LinearLayout getDetachScoreLayout() {
		return (LinearLayout) findViewById(R.id.ara_result_detail_layout);
		
	}

	protected void updateResultLabel(RoundResult r){
		if(r.isSuccess()){
			getResultLabelTextView().setText("Gagnée");
		}else{
			getResultLabelTextView().setText("Perdue");
			
		}
	}

	private void updateResultPanel() {
		if(scoreStrategy.isResultAvaible()){
			getResultLayout().setVisibility(View.VISIBLE);
			RoundResult r = scoreStrategy.getResult();
			updateResultLabel(r);
			updateResultScore(r);
			updateResultTotal(r);
			updateResultDetachScore(r);
			
		}else{
			getResultLayout().setVisibility(View.GONE);
		}
		
	}

	private void updateResultTotal(RoundResult r) {
		getResultTotalCommentTextView().setText(r.getTotalComment());
		getResultTotalTextView().setText(""+r.getTotal());
		
	}

	private void updateResultScore(RoundResult r) {
		getResultScoreTextView().setText(""+r.getScore());
		
	}

	private TextView getResultScoreTextView() {
		return (TextView) findViewById(R.id.ara_result_score_textView);
	}

	private TextView getResultLabelTextView() {
		return (TextView) findViewById(R.id.ara_result_label_textView);
		
	}
	private TextView getResultTotalTextView() {
		return (TextView) findViewById(R.id.ara_result_total_textView);
	}

	private TextView getResultTotalCommentTextView() {
		return (TextView) findViewById(R.id.ara_result_total_explain_textView);
		
	}

	private LinearLayout getResultLayout() {
		return (LinearLayout) findViewById(R.id.ara_final_layout);
	}

	private void updateBiddingPanel() {
		if(getCurrentRound().isUnsetBidding()){
			displayChooseBiddingLayout();
		}else{
			displayBiddingRoundHeaderLayout();
		}
		
	}

	protected void displayBiddingRoundHeaderLayout() {

		updateBiddingRoundHeaderLayout();
		View cbl = getChooseBiddingLayout();
		View brhl = getBiddingRoundHeaderLayout();
		cbl.setVisibility(View.GONE);
		brhl.setVisibility(View.VISIBLE);
	}
	
	private void updateBiddingRoundHeaderLayout() {
		updateRoundDefenders();
		updateRoundTakers();
		updateRoundBidding();
		
	}



	protected void displayChooseBiddingLayout() {
		View cbl =getChooseBiddingLayout();
		View brhl =getBiddingRoundHeaderLayout();
		cbl.setVisibility(View.VISIBLE);
		brhl.setVisibility(View.GONE);
	}
	
    private Button getbiddingOkButton() {
	return (Button) findViewById(R.id.ara_validate_bidding_button);
	}

	private Spinner getBiddingSpinner() {
		return (Spinner) findViewById(R.id.ara_bidding_spinner);
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_round, menu);
        return true;
    }
	


	
	
	
	private LinearLayout getBiddingRoundHeaderLayout() {
		return (LinearLayout) findViewById(R.id.ara_bidding_round_header);
	}

	private LinearLayout getChooseBiddingLayout() {
		return (LinearLayout) findViewById(R.id.ara_choose_bidding_layout);
	}

	private void dismissAskTakerlertDialog(){
	if(askTakerAlertDialog!=null){
		askTakerAlertDialog.dismiss();
	}
	}
	public void onAskTaker(List<Player> players) {
		ChoosePlayerDialog layout = getChooseTakerView(players);
		dismissAskTakerlertDialog();
		 askTakerAlertDialog =layout.getAlertDialog();
		 askTakerAlertDialog.show();
	}
	
	public void onBiddingSelected() {

		//updateRoundBidding();
		//onContentChanged();
		scoreStrategy.chooseTakers();
	}

	private ChoosePlayerDialog getChooseTakerView(List<Player> players) {
		ChoosePlayerDialog layout = (ChoosePlayerDialog) getInflater().inflate(Utils.DIALOG_CHOOSE_PLAYER,null);
		layout.setListener(new TakerChosenCallback(getCurrentScoreStrategy(),layout.getAlertDialog()));
		layout.setPlayerList(players);
		return layout;
	}


	
	
	private LayoutInflater getInflater() {
		if(inflater==null){
			inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		}
		return inflater;
	}


public class PlayerPenaltyChosenCallback implements OnPlayerChosenListener{
		
		private AlertDialog alertDialog;

		PlayerPenaltyChosenCallback(AlertDialog alertDialog){
			this.alertDialog = alertDialog;
		}
		
		public void onPlayerChosen(Player p) {
			alertDialog.hide();
			getActivity().scoreStrategy.addBonus(new Penalty( p));
			
		}
		
	}
	
public class PlayerPoigneeChosenCallback implements OnPlayerChosenListener{
		
		private AlertDialog alertDialog;
		private Poignee poignee;

		PlayerPoigneeChosenCallback(AlertDialog alertDialog,Poignee p){
			this.alertDialog = alertDialog;
			this.poignee=p;
		}
		
		public void onPlayerChosen(Player p) {
			//alertDialog.get
			poignee.setPlayer(p);
			alertDialog.hide();
			getActivity().scoreStrategy.addPoignee(poignee);
			
		}
		
	}
	
public class PlayerJeuBlancChosenCallback implements OnPlayerChosenListener{
		
		private AlertDialog alertDialog;

		PlayerJeuBlancChosenCallback(AlertDialog alertDialog){
			this.alertDialog = alertDialog;
		}
		
		public void onPlayerChosen(Player p) {
			alertDialog.hide();
			Builder builder = new AlertDialog.Builder(getActivity());
			
			JeuBlancMenuAdapter adapter = new JeuBlancMenuAdapter(getActivity(),getCurrentScoreStrategy(),p);
			builder.setAdapter(adapter, adapter);
			AlertDialog alertDialog2 = builder.create();
			alertDialog2.show();
			
		}
		
	}
	public class TakerChosenCallback implements OnPlayerChosenListener{
		
		private FillRoundStrategy strategy;
		private AlertDialog alertDialog;

		TakerChosenCallback(FillRoundStrategy strategy, AlertDialog alertDialog){
			this.strategy = strategy;
			this.alertDialog = alertDialog;
		}
		
		public void onPlayerChosen(Player p) {
			alertDialog.hide();
			strategy.addTaker(p);
			
			
		}
		
	}


	public void onTeamsCompleted() {
//		updateRoundTakers();
//		updateRoundDefenders();
//		displayBiddingRoundHeaderLayout();
		onContentChanged();
		getBiddingRoundHeaderLayout().requestLayout();
		
	}

	private void updateRoundTakers() {
		getbiddingTakers().removeAllViews();
		for(Player p :getCurrentRound().getTakers()){
			ContactView v = Utils.getNewPlayerView(this,p);
			getbiddingTakers().addView(v);
		}
		getbiddingTakers().requestLayout();
		
	}



	private LinearLayout getbiddingTakers() {
		return (LinearLayout) findViewById(R.id.ara_bidding_round_takers);
	}

	private void updateRoundDefenders() {
		getbiddingDefenders().removeAllViews();
		for(Player p :getCurrentRound().getDefenders()){
			ContactView v = Utils.getNewPlayerView(this,p);
			getbiddingDefenders().addView(v);
		}
		getbiddingDefenders().requestLayout();
		
	}

	private ViewGroup getbiddingDefenders() {
		return (LinearLayout) findViewById(R.id.ara_bidding_round_defenders);
	}
	private TextView getbiddingTextView() {
		return (TextView) findViewById(R.id.ara_bidding_round_label);
	}
	private void updateRoundBidding() {
		String label = "";
		if(getBidding()!=null){
			label= getBidding().getName();
		}
		getbiddingTextView().setText(label);
		
	}
	protected Bid getBidding(){
		return getCurrentRound().getBidding();
	}
	public Game getGame(){
		return this.scoreStrategy.getGame();
	}
	
	protected Round getCurrentRound(){
		return this.scoreStrategy.getCurrentRound();
	}
	public Object onRetainNonConfigurationInstance() {
		return scoreStrategy;
	}

	public void onNbBoutsSet() {
		updateNbBoutsPanel();
		
	}

	private void updateNbBoutsPanel() {
		Round round = getCurrentRound();
		if(round.isUnsetNbBouts()){
			getNbBoutsTakersTextView().setText("?");
			getNbBoutsDefendersTextView().setText("?");
			
		}else{
			getNbBoutsTakersTextView().setText(""+round.getNbBoutsTakers());
			getNbBoutsDefendersTextView().setText(""+round.getNbBoutsDefenders());
			if(!getNbBoutsSeekBar().isPressed()){
				getNbBoutsSeekBar().setProgress(round.getNbBoutsTakers());
			}
		}
	}
	
	public void onScoreUpdated() {
		updateScorePanel();
		
	}
	
	public void onBonusUpdated() {
		onContentChanged();
		
	}

	private void updateScorePanel() {
		Round round = getCurrentRound();
		if(!getScoreSeekBar().isPressed()){
			getScoreSeekBar().setMax(Round.MAX_SCORE*scoreStrategy.getScoreIntervalDivider());
		}
		if(round.isUnsetScore()){
			getScoreTakersTextView().setText("?");
			getScoreDefendersTextView().setText("?");
			
		}else{
			getScoreTakersTextView().setText(""+round.getScoreTakers());
			getScoreDefendersTextView().setText(""+round.getScoreDefenders());
			if(!getScoreSeekBar().isPressed()){
				int progress = (int) (round.getScoreTakers() * scoreStrategy.getScoreIntervalDivider());
				getScoreSeekBar().setProgress(progress);
			}
		}
	}

	private SeekBar getScoreSeekBar() {
		return (SeekBar) findViewById(R.id.ara_score_seekBar);
	}

	private TextView getScoreDefendersTextView() {
		return (TextView) findViewById(R.id.ara_score_defenders_textview);
	}

	private TextView getScoreTakersTextView() {
		return (TextView) findViewById(R.id.ara_score_takers_textview);
	}

	public void onAskPetitAuBon() {
		Builder builder = new AlertDialog.Builder(getActivity());

		PetitAuBoutMenuAdapter adapter = new PetitAuBoutMenuAdapter(this,getCurrentRound(),scoreStrategy);
		builder.setAdapter(adapter, adapter);
		dismissAskPetitAuBoutAlertDialog();
		askPetitAuBoutAlertDialog = builder.create();
		askPetitAuBoutAlertDialog.show();
		
	}



	private void dismissAskPetitAuBoutAlertDialog() {
		Log.v(TAG,"dismissaskPetitAuBoutAlertDialog");
		if (askPetitAuBoutAlertDialog!=null) {
			askPetitAuBoutAlertDialog.dismiss();
		}
	}

	private void dismissAskPoigneeTypeAlertDialog(){
	if(askPoigneeTypeAlertDialog!=null){
		askPoigneeTypeAlertDialog.dismiss();
	}
	}
	
	public void onAskPoignee() {
		Builder builder = new AlertDialog.Builder(getActivity());

		PoigneeMenuAdapter adapter = new PoigneeMenuAdapter(getActivity());
		builder.setAdapter(adapter, adapter);
		dismissAskPoigneeTypeAlertDialog();
		askPoigneeTypeAlertDialog = builder.create();
		askPoigneeTypeAlertDialog.show();
//		ChoosePlayerDialog layout = getChoosePlayerPoigneeView(getGame().getPlayers());
//		AlertDialog alertDialog =layout.getAlertDialog();
//		alertDialog.show();
		
	}

	public void onAskJeuBlanc() {
			prepareChooseJeuBlancPlayerView(getGame().getPlayers());

			askJeuBlancAlertDialog.show();
	}
	private void dismissAskJeuBlancAlertDialog(){
		if(askJeuBlancAlertDialog!=null){
			askJeuBlancAlertDialog.dismiss();
		}
	}
	
	private ChoosePlayerDialog prepareChooseJeuBlancPlayerView(List<Player> players) {
		ChoosePlayerDialog layout = (ChoosePlayerDialog) getInflater().inflate(Utils.DIALOG_CHOOSE_PLAYER,null);
		dismissAskJeuBlancAlertDialog();
		askJeuBlancAlertDialog =layout.getAlertDialog();
		layout.setListener(new PlayerJeuBlancChosenCallback(askJeuBlancAlertDialog));
		layout.setPlayerList(players);
		return layout;
	}
	
	private void dismissAskPenaltyAlertDialog(){
	if(askPenaltyAlertDialog!=null){
		askPenaltyAlertDialog.dismiss();
	}
	}
	
	private ChoosePlayerDialog prepareChoosePlayerPenaltyView(List<Player> players) {
		ChoosePlayerDialog layout = (ChoosePlayerDialog) getInflater().inflate(Utils.DIALOG_CHOOSE_PLAYER,null);
		dismissAskPenaltyAlertDialog();
		askPenaltyAlertDialog =layout.getAlertDialog();
		layout.setListener(new PlayerPenaltyChosenCallback(askPenaltyAlertDialog));
		layout.setPlayerList(players);
		return layout;
	}
	private void dismissAskPoigneePlayerAlertDialog(){
	if(askPoigneePlayerAlertDialog!=null){
		askPoigneePlayerAlertDialog.dismiss();
	}
	}
	
	public ChoosePlayerDialog prepareChoosePlayerPoigneeView(List<Player> players,Poignee p) {
		ChoosePlayerDialog layout = (ChoosePlayerDialog) getInflater().inflate(Utils.DIALOG_CHOOSE_PLAYER,null);
		dismissAskPoigneePlayerAlertDialog();
		askPoigneePlayerAlertDialog =layout.getAlertDialog();
		layout.setListener(new PlayerPoigneeChosenCallback(askPoigneePlayerAlertDialog,p));
		layout.setPlayerList(players);
		return layout;
	}

	public void onAskPenalty() {
		prepareChoosePlayerPenaltyView(getGame().getPlayers());
		askPenaltyAlertDialog.show();
		
	}

	public void onAskChelem() {
		// TODO 
		Log.v(TAG,"onAskChelem");
		
	}

	public void onPoigneesUpdated() {
		onContentChanged();
		
	}

	public void onPetitAuBoutUpdated() {
		onContentChanged();
		
	}

	@Override
	public void onBackPressed() {
		dismissAlertDialog();
		
		Utils.updateRoundInIntent(this,getCurrentRound());
		setResult(RESULT_NOT_FINISHED, getIntent());
		this.finish();
	}

	private void dismissAlertDialog() {
		dismissAskJeuBlancAlertDialog();
		dismissAskPenaltyAlertDialog();
		dismissAskPetitAuBoutAlertDialog();
		dismissAskPoigneePlayerAlertDialog();
		dismissAskPoigneeTypeAlertDialog();
		dismissAskTakerlertDialog();
		
	}

	public Dialog getAskPlayerPoigneeAlertDialog() {
		Log.v(TAG,"getChoosePlayerPoigneeAlertDialog");
		return askPoigneePlayerAlertDialog;
	}
	
	public void saveRound(View view){
		dismissAlertDialog();
		
		Game g = getGame();
		g.addRound(getCurrentRound());
		Utils.updateRoundInIntent(this,null);
		Utils.getGameDao(this).updateOrCreate(g);
		setResult(RESULT_OK, getIntent());
		this.finish();
	}
	
}
