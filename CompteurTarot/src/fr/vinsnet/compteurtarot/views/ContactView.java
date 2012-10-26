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

	public ContactView(Context context,Player p, AttributeSet attrs, int defStyle) {
		super(context, attrs,defStyle);
		this.player=p;
	}

	public ContactView(Context context,Player p, AttributeSet attrs) {
		super(context, attrs);
		this.player=p;
	}

	public ContactView(Context context,Player p) {
		super(context);
		this.player=p;
	}
	

	public ContactView(Context context, AttributeSet attrs, int defStyle) {
		this(context,getMockPlayer(),attrs,defStyle);
	}
	
	public ContactView(Context context, AttributeSet attrs) {
		this(context,getMockPlayer(),attrs);
	}
	
	public ContactView(Context context) {
		this(context,getMockPlayer());
	}
	

	private static Player getMockPlayer() {
		Player mockPlayer = new Player();
		mockPlayer.setName("nom");
		return mockPlayer;
	}



	@Override
	protected void onDraw(Canvas canvas) {
		update();
		super.onDraw(canvas);
	}
	
	private void update() {
		((TextView)this.findViewById(R.id.cv_name)).setText(player.getName()); 
	}

	public void setPlayer(Player player) {	
		this.player=player;
		update();
		
	}

	


	


	

}
