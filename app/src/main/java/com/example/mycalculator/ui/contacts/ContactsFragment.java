package com.example.mycalculator.ui.contacts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.example.mycalculator.R;
import com.example.mycalculator.databinding.FragmentContactsBinding;

public class ContactsFragment extends Fragment {

    private FragmentContactsBinding binding;

    private CardView Btn_instagram;
    private CardView Btn_telegram;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentContactsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Btn_instagram = (CardView) root.findViewById(R.id.Btn_instagram);
        Btn_telegram  = (CardView) root.findViewById(R.id.Btn_telegram);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = null;
                Intent likeIng = new Intent();
                switch(view.getId()){
                    case R.id.Btn_instagram:
                        uri = Uri.parse(getString(R.string.instagram_url));
                        likeIng.setPackage("com.instagram.android");
                        break;
                    case R.id.Btn_telegram:
                        uri = Uri.parse(getString(R.string.telegram_url));
                        likeIng.setPackage("org.telegram.messenger");
                        break;
                }
                try {
                    likeIng.setAction(Intent.ACTION_VIEW);
                    likeIng.setData(uri);
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,uri));
                }
            }
        };
        Btn_instagram.setOnClickListener(onClickListener);
        Btn_telegram.setOnClickListener(onClickListener);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}