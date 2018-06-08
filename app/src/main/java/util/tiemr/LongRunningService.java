package util.tiemr;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

public class LongRunningService extends Service {


    private long time;//延迟时间
    private String remidContent;//提醒内容


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {


        time= Long.parseLong(intent.getStringExtra("time"));
        remidContent=intent.getStringExtra("remindContent");

        new Thread(new Runnable() {
            @Override
            public void run() {
                time=time-24*60*60*1000;
                if (time>0){

                }
            }
        }).start();


        AlarmManager manager=(AlarmManager)getSystemService(ALARM_SERVICE);
        long triggerAtTime= SystemClock.elapsedRealtime()+time;

        Intent i=new Intent(this,AlarmReceiver.class);

//        i.putExtra("time",time+"");
//        i.putExtra("remindContent",remidContent);

        PendingIntent pi=PendingIntent.getBroadcast(this,0,i,0);

        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);

        return super.onStartCommand(intent, flags, startId);
    }
}
