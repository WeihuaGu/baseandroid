package base;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class ViewHolderAdapter extends Adapter<ViewHolderAdapter.ViewHolder> {
	 private View mitemview;
	 public ViewHolderAdapter(){
	 }
	 
	 public View getItemView(){
		 return mitemview;
	 }
	 public abstract void setItemView();
	 
	 public static class ViewHolder extends RecyclerView.ViewHolder {
	       protected  View mView;
	        public ViewHolder(View v) {
	            super(v);
	            mView = v;
	        }
	 }
	 
	 @Override
	 public ViewHolderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // create a new view
		 	View v=getItemView();
     // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(v);
            return vh;
     }
	 @Override
	 public abstract void onBindViewHolder(ViewHolder holder, int position) ;
	 @Override
	    public abstract  int getItemCount();
	 

}
