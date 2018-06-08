package util;

import android.app.Activity;
import android.content.Intent;

import util.tiemr.LongRunningService;

public class RemindUtil {
    private long time;//提醒间隔
    private String remindContent;//提醒内容

//    private TextView tv;

    private Activity activity;
//    private

    public RemindUtil(long time,String remindContent,Activity activity){
        this.time=time;
        this.remindContent=remindContent;
        this.activity=activity;


        Intent intent=new Intent(activity, LongRunningService.class);

//        intent.putExtra("time",time+"");
//        intent.putExtra("remindContent",remindContent);
        activity.startService(intent);
    }



}
