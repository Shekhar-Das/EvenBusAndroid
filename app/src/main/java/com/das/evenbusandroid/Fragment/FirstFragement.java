package com.das.evenbusandroid.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import org.w3c.dom.Text;


public class FirstFragement extends Fragment {
   // private TextView textView;
    public FirstFragement() {
        // required empty public constructor
    }

    public static FirstFragement newInstance() {
        return new FirstFragement();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_frist_fragment, container, false);
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
                EventBus.getDefault().post(s.toString());


            }

        });
      //  textView = view.findViewById(R.id.textView2);
    }

    //Event bus event
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResultReceived(String result) {
       // textView.setText(result);
        Log.d("Data","got result");
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().register(this);
    }
}
