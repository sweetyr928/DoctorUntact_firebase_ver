package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dotter.doctoruntact.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Boardlist> mBList;

    public MyListAdapter(Context mContext, List<Boardlist> mBoardLists) {
        this.mContext = mContext;
        this.mBoardLists = mBoardLists;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.board_item, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

    }

@Override
public int getItemCount() {
        return mUsers.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView nickname;
    public ImageView profile_image;
    private TextView title;
    private TextView Date;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        nickname = itemView.findViewById(R.id.nickname_textview);
        profile_image = itemView.findViewById(R.id.profile_imageView);
        title=itemView.findViewById(R.id.title_textView);
        Date=itemView.findViewById(R.id.date_textView);
    }
}
}
