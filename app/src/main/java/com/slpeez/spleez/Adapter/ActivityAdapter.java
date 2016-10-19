package com.slpeez.spleez.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.slpeez.spleez.Activity.R;
import com.slpeez.spleez.Object.Event;


import java.util.ArrayList;


/**
 * ImageCategoriesAdapter.java
 * 
 * Custom adapter to display the different categories in a grid view 
 * 
 * @author Thibaut Chamoux
 * @version 1.0 7/7/14
 *
 */
public class ActivityAdapter extends BaseAdapter {
	
	private Context _context;
	private ArrayList<Event> _list_activities;
	
	/**
	 * Constructor 
	 * @param context of execution
	 */
	public ActivityAdapter(Context context, ArrayList<Event> list_activities) {
		_context = context;
		_list_activities = list_activities;
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
    public View getView(int position, View convertView, ViewGroup parent) {
    	LayoutInflater inflater = (LayoutInflater) _context
    			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     
    		View gridView;
    			
    		/* if the view is null, it means that this view has not been used for the moment, we have to create a new view */
    		if (convertView == null) {
				gridView = new View(_context);
				gridView = inflater.inflate(R.layout.activity_item, null);
	    	/* else, we have to recycle this view to avoid memory loss */
    		} else {   			
    				gridView = (View) convertView;
    		}

        TextView name = (TextView)gridView.findViewById(R.id.t_name);
        TextView desc = (TextView)gridView.findViewById(R.id.t_desc);

        Event i = _list_activities.get(position);
        name.setText(i.getName());
        desc.setText(i.getDesc());

        return gridView;
    }

 
    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	/*
	 * (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public int getCount() {
		return _list_activities.size();
	}

	public void swapEvent(ArrayList<Event> a) {
		_list_activities.clear();
		_list_activities.addAll(a);
		
		/* this method informs the gridview that his content has changed */
		notifyDataSetChanged();
	}
}
