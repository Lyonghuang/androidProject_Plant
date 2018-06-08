package util.tiemr;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.activity.MainActivity;
import com.example.androidproject_plant.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {

    private NotificationManager notificationManager;

    private long time;//提醒的间隔

    private Context context;

    private String remindContent;//提醒内容


    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;

        remindContent=intent.getStringExtra("remindContent");
        time= Long.parseLong(intent.getStringExtra("time"));


        Intent i = new Intent(context, LongRunningService.class);

        i.putExtra("time",time+"");
        i.putExtra("remindContent",remindContent);

        context.startService(i);


//        System.out.println("每隔十秒定时执行");
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void makeNotification() {
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder1 = new Notification.Builder(context);
        builder1.setSmallIcon(R.drawable.ic_launcher_background); //设置图标
        builder1.setTicker("妈哦，好困啊");
        builder1.setContentTitle("草泥马"); //设置标题
        builder1.setContentText("中一百万！！！"); //消息内容
        builder1.setWhen(System.currentTimeMillis()); //发送时间
        builder1.setDefaults(Notification.DEFAULT_ALL); //设置默认的提示音，振动方式，灯光
        builder1.setAutoCancel(true);//打开程序后图标消失
        Intent intent = new Intent(context, MainActivity.class);//点击通知跳转
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        builder1.setContentIntent(pendingIntent);
        Notification notification1 = builder1.build();
        notificationManager.notify(124, notification1); // 通过通知管理器发送通知
    }
}
