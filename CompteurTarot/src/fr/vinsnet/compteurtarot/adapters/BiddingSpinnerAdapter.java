package fr.vinsnet.compteurtarot.adapters;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import fr.vinsnet.compteurtarot.R;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.utils.adapters.SimpleListAdapter;

public class BiddingSpinnerAdapter extends SimpleListAdapter<Bid> {

	public BiddingSpinnerAdapter(Activity context, List<Bid> list) {
		super(context, list);
	}

	private static final String TAG = "BiddingSpinnerAdapter";

	@Override
	protected int getItemLayoutId() {
		return Utils.BIDDING_SPINNER_VIEW_ID;
	}

	@Override
	protected void updateView(View currentView, Bid item) {

		TextView label = (TextView) currentView
				.findViewById(R.id.bsv_item_label);
		TextView point = (TextView) currentView
				.findViewById(R.id.bsv_item_value);
		if (label != null && point != null) {
			label.setText(item.getName());
			point.setText(""+item.getValue());
			label.setHeight(48);
		} else {
			Log.e(TAG, "imposible d'initialiser " + item.getName());
		}

	}
	/*
	 * @Override protected View instanciateNewView() { LinearLayout layout = new
	 * LinearLayout(getContext());
	 * 
	 * vw = new ViewWrapper<Bid, LinearLayout>(getContext(),layout){
	 * 
	 * private TextView label;
	 * 
	 * @Override protected void onObjectUpdate() {
	 * label.setText(getObject().getName());
	 * 
	 * 
	 * }
	 * 
	 * @Override protected void inflate() { LinearLayout pv = getView();
	 * pv.setOrientation(LinearLayout.VERTICAL); this.label = new
	 * TextView(getContext()); pv.addView(label);
	 * 
	 * }
	 * 
	 * }; return vw; }
	 */

	@Override
	protected void onSelectedItem(Bid item, View v) {
		
		
	}
}
