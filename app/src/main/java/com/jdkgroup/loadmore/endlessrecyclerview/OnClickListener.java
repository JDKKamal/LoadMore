package com.jdkgroup.loadmore.endlessrecyclerview;

import android.view.View;

public class OnClickListener {
	/** Interface for Item Click over Recycler View Items **/
	public interface OnItemClickListener {
		public void OnItemClick(View view, int position);
	}
}
