package com.das.evenbusandroid.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.das.evenbusandroid.R;
import com.google.android.material.textfield.TextInputEditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SecondFragement extends Fragment {
    private static final String TAG = "SecondFragment";
    private TextView mTextView;

    public SecondFragement() {
        //Defult constructor
    }

    public static SecondFragement newInstance() {
        return new SecondFragement();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_second_freagment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText inputEditText = view.findViewById(R.id.textInputText);
        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EventBus.getDefault().post(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mTextView = view.findViewById(R.id.txtResult);
    }

    //Event bus event
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResultReceived(String result) {
        mTextView.setText(result);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().register(this);
    }
}
