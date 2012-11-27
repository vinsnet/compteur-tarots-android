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
package fr.vinsnet.utils.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class SimpleListAdapter<T> extends BaseAdapter {

	private static final String TAG = "SimpleListAdapter";
	private List<T> list;
	private Activity context;

	public SimpleListAdapter(Activity context,List<T> list) {
		super();
		this.context=context;
		this.list=list;
			
		Log.d("LIST ADAPTER-SimpleListAdapter",""+list.hashCode());
	}



	public int getCount() {
		Log.v(TAG,"getCount "+list.size());
		return list.size();
	}

	public T getItem(int arg0) {

		Log.v(TAG,"getItem "+arg0+" " +list.get(arg0));
		return list.get(arg0); 
	}

	public long getItemId(int arg0) {
		Log.v(TAG,"getItemId "+arg0+" ");
		return 0;
	}

	public View getView(int position, View currentView, ViewGroup parentGroup) {
		Log.v(TAG,"getView "+position+" " );
		if(currentView==null){
			currentView = instanciateNewView();
		}
		T item = (T) getItem(position);
		changeOnClickListener(currentView,item);
		updateView(currentView,item);
		return currentView;
	}

	protected void changeOnClickListener(View currentView, T item){
	}




	protected OnClickListener getNewSimpleOnClickListener(T item) {
		return new SimpleOnClickListener(item);
	}

	protected abstract void onSelectedItem(T item,View v);

	protected View instanciateNewView() {
		Log.v(TAG,"instanciateNewView ");
		LayoutInflater inflater = getLayoutInflater();
		View view = inflater.inflate(getItemLayoutId(), null);
		return view;
	}
	
	
	
	protected LayoutInflater getLayoutInflater() {
		return (LayoutInflater)context.getSystemService
	      (Context.LAYOUT_INFLATER_SERVICE);
	}



	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
		context.onContentChanged();
	}
	
	public Activity getContext() {
		return context;		
	}

	protected abstract int getItemLayoutId() ;
	protected abstract void updateView(View currentView, T item) ;


	protected class SimpleOnClickListener implements View.OnClickListener{
		
		private T item;
		public SimpleOnClickListener (T item){
			this.item = item;
		}
		public void onClick(View v) {
			onSelectedItem(item, v);
			
		}
	}
}
