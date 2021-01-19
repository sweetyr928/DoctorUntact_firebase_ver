package Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import Adapter.BoardAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import model.Board;
import com.dotter.doctoruntact.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class BoardFragment extends Fragment{

    private RecyclerView recyclerView;
    private BoardAdapter adapter;
    private ArrayList<Board> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_board, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        list = Board.createBoardList();
        recyclerView.setHasFixedSize(true);
        adapter = new BoardAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
