package com.example.activity.conservation;

import android.content.Context;

import net.HttpMethod;
import net.NetConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import constatnt.constant;
import util.ToastUtil;

public class SendConservationFinish {

    private String plantId;
    private String request_type;
    private String nickName;
    private Context context;

    private JSONObject jsonObject;

    public SendConservationFinish(final Context context, String plantId,
                                  String nickName, String request_type) {
        this.context=context;
        this.plantId = plantId;
        this.nickName = nickName;
        this.request_type=request_type;


        jsonObject=new JSONObject();

        try {
            jsonObject.put(constant.REQUEST_TYPE,request_type);
            jsonObject.put(constant.PLANT_ID,plantId);
            jsonObject.put(constant.NICKNAME,nickName);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        new NetConnection(constant.URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject json=new JSONObject(result);
                    JSONArray jsonArray=json.getJSONArray(constant.RESPONSE);
                    String response=jsonArray.getJSONObject(0).getString(constant.STATUS_CODE);

                    if (response.equals("200")){
                        ToastUtil.show(context,"成功！");
                    }else{
                        ToastUtil.show(context,"失败，请稍候重试");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail(String result) {
                ToastUtil.show(context,"失败，请稍候重试");
            }
        },jsonObject);
    }


}
