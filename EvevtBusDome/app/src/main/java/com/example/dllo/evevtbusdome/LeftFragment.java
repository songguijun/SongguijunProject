package com.example.dllo.evevtbusdome;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {
     private Button btn;
    private EditText et;
    private EventBus eventBus;
    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn = (Button) view.findViewById(R.id.btn_left);
        et = (EditText) view.findViewById(R.id.et_left);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        eventBus =EventBus.getDefault();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bean bean = new Bean();
                bean.setData(et.getText().toString());
                eventBus.post(bean);
                            }
        });
    }
}
