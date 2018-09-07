package hut.cwp.freetouchevent.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import hut.cwp.freetouchevent.R;

public class ThreeFragment extends Fragment implements IOnClick{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_three, container, false);
    }

    @Override
    public void singleClick() {
        Toast.makeText(getContext(),"three fragment click",Toast.LENGTH_SHORT).show();
    }
}


