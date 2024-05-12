package ali.abdou.arauth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ali.abdou.arauth.DimFragment;
import ali.abdou.arauth.R;
import ali.abdou.arauth.UploadImageFragment;

public class InfoBFragment extends Fragment {

    public InfoBFragment() {
        // Constructeur public vide requis
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info, container, false);

        Button btnDims = rootView.findViewById(R.id.dim);
        Button btnImg = rootView.findViewById(R.id.dim);

        btnDims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers DimFragment pour entrer les dimensions
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DimFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers UploadImageFragment pour envoyer une image
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new UploadImageFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }
}
