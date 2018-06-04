package util.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * 将图片进行压缩，否则直接加载原图可能会出现OOM
 */
public class ImageResizer {

    public Bitmap decodeSampledBitmapFromResource(Resources res,int resId){
        BitmapFactory.Options options=new BitmapFactory.Options();
        //解析图片而不会真正的加载
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize=4;
        options.inJustDecodeBounds=false;

        return BitmapFactory.decodeResource(res,resId,options);
    }
}
