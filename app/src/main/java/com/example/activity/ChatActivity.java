package com.example.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidproject_plant.R;

import java.util.ArrayList;

import adapter.ChatAdapter;
import fragment.TestData;
import model.ChatModel;
import model.ItemModel;

public class ChatActivity extends Activity {

    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private EditText et;
    private TextView tvSend;
    private String content;


//    private LinearLayout layout_edit;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    recyclerView.scrollToPosition(TestData.getTestAdData().size()-1);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        et = (EditText) findViewById(R.id.et_message);
        tvSend = (TextView) findViewById(R.id.tvSend);

//        layout_edit=(LinearLayout)findViewById(R.id.layout_edit);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter = new ChatAdapter());
        adapter.replaceAll(TestData.getTestAdData());
        initData();
    }


    private void initData() {
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

//                ToastUtil.show(ChatActivity.this,"曹尼玛");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                content = s.toString().trim();
            }
        });

        tvSend.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ArrayList<ItemModel> data = new ArrayList<>();
                ChatModel model = new ChatModel();
                model.setIcon("http://img.my.csdn.net/uploads/201508/05/1438760758_6667.jpg");
                model.setContent(content);
                data.add(new ItemModel(ItemModel.CHAT_B, model));
                adapter.addAll(data);
                et.setText("");
                hideKeyBorad(et);
            }
        });

//        et.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                handler.sendEmptyMessageDelayed(0,250);
//                ToastUtil.show(ChatActivity.this,"曹尼玛");
//
//            }
//        });


//        layout_edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                et.requestFocus();
//                showSoftInput(ChatActivity.this,et);
//                handler.sendEmptyMessageDelayed(0,250);
//            }
//        });
//
//        recyclerView.setOnTouchListener(new View.OnTouchListener(){
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                hideSoftInput(ChatActivity.this,et);
//                return false;
//            }
//        });

    }

//    public static void showSoftInput(Context context,View view){
//         @SuppressLint("ServiceCast") InputMethodManager imm=(InputMethodManager)context.getSystemService(Activity.INPUT_SERVICE);
//         imm.showSoftInput(view,InputMethodManager.SHOW_FORCED);
//    }
//
//    public static void hideSoftInput(Context context, View view) {
//        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//
//    }


    private void hideKeyBorad(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
        }
    }
}
