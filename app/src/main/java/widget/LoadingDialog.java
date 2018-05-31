package widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidproject_plant.R;


/**
 * 加载对话框
 */

public class LoadingDialog extends ProgressDialog {

    private String mMessage;

    private TextView mTitleTv;


    public LoadingDialog(Context context, String message, boolean canceledOnTouchOutside) {
        super(context, R.style.Theme_AppCompat_Light);
        this.mMessage = message;
        // 如果触摸屏幕其它区域,可以选择让这个progressDialog消失或者无变化
        setCanceledOnTouchOutside(canceledOnTouchOutside);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support_simple_spinner_dropdown_item);
//        mTitleTv = (TextView) findViewById(R.id.btn_login);
//        mTitleTv.setText(mMessage);
//        setCancelable(false);//不可取消
    }

    public void setTitle(String message) {
        this.mMessage = message;
        mTitleTv.setText(mMessage);
    }



    /**
     * 显示在底部
     */
    public void showButtom() {
        // WindowManager windowManager = ((Activity)
        // mContext).getWindowManager();
        // Display display = windowManager.getDefaultDisplay();
        //
        // WindowManager.LayoutParams lp = getWindow().getAttributes();
        // lp.width = (int) (display.getWidth() * 0.8);
        // getWindow().setAttributes(lp);
        // super.show();
    }

}
