package fr.vinsnet.compteurtarot.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.model.Player;

public class ContactView extends RelativeLayout   {
	

	
	private Player player;

	/*public ContactView(Context context,Player p, AttributeSet attrs, int defStyle) {
		super(context, attrs,defStyle);
		setPlayer(p);
	}

	public ContactView(Context context,Player p, AttributeSet attrs) {
		super(context, attrs);
		setPlayer(p);
	}

	public ContactView(Context context,Player p) {
		super(context);
		setPlayer(p);
	}
	*/

	public ContactView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs,defStyle);
	}
	
	public ContactView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ContactView(Context context) {
		super(context);
	}
	
/*
	private static Player getMockPlayer() {
		Player mockPlayer = new Player();
		mockPlayer.setName("nom");
		return mockPlayer;
	}
*/


	@Override
	protected void onDraw(Canvas canvas) {
		update();
		super.onDraw(canvas);
	}
	
	private void update() {
		((TextView)this.findViewById(R.id.cv_name)).setText(player.getName()); 
	}

	public void setPlayer(Player player) {	
		//if(player==null)return;
		this.player=player;
		update();
		
	}

	


	


	

}
