package sadowskim.pl.mywunderlist;

/**
 * Created by mateuszsadowski on 27/03/2018.
 */

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.CheckBox;
        import android.widget.TextView;

        import java.util.ArrayList;

        import static android.content.ContentValues.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mDataset;
    private ArrayList<CheckBox> mCheckboxes;
    private IOnLongClickListener mListener;

    public RecyclerViewAdapter(ArrayList<String> myDataset, IOnLongClickListener listener, Context context) {
        mDataset = myDataset;
        mListener = listener;
        mCheckboxes = new ArrayList<CheckBox>();
        mContext = context;
    }
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mListItemText;
        public CheckBox mCheckBox;

        public ViewHolder(View v) {
            super(v);
            mListItemText = v.findViewById(R.id.list_item_text);
            mCheckBox = v.findViewById(R.id.list_item_checkbox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mCheckBox.isChecked())
                    {
                        mCheckboxes.get(getAdapterPosition()).setChecked(false);
                        mCheckBox.setChecked(false);
                    }
                    else
                    {
                        mCheckboxes.get(getAdapterPosition()).setChecked(true);
                        mCheckBox.setChecked(true);
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mListener.onLongClickItem(getAdapterPosition());
                    return true;
                }
            });
        }

        public void bind(TextView textView, CheckBox checkBox){
            mListItemText = textView;
            mCheckBox = checkBox;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        CheckBox tmpCheckbox = new CheckBox(mContext);
        tmpCheckbox.setChecked(false);
        mCheckboxes.add(tmpCheckbox);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");
        holder.mListItemText.setText(mDataset.get(position));
        holder.mCheckBox.setChecked(mCheckboxes.get(position).isChecked());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void removeItem(int position)
    {
        mDataset.remove(position);
        mCheckboxes.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(String item)
    {
        mDataset.add(item);
        CheckBox tmpCheckbox = new CheckBox(mContext);
        tmpCheckbox.setChecked(false);
        mCheckboxes.add(tmpCheckbox);
        notifyDataSetChanged();
    }

    public interface IOnLongClickListener
    {
        void onLongClickItem(int position);
    }
}