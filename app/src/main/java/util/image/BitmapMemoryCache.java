package util.image;

import android.graphics.Bitmap;
import android.util.LruCache;


/**
 * 将图片缓存，提升浏览加载的速度
 */
public class BitmapMemoryCache {

    private final String TAG="BitmapMemoryCache";
    int maxMemory=(int)(Runtime.getRuntime().maxMemory()/1024);
    int catchSize=maxMemory/16;
    LruCache<String,Bitmap> lruCache=new LruCache<String,Bitmap>(catchSize){
        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getRowBytes()*value.getHeight()/1024;
        }
    };

    public void addBitmapToMemory(String key,Bitmap bitmap){
        if (getBitmapFromMemoey(key)==null){
            lruCache.put(key,bitmap);
            System.out.println("最大内存为"+maxMemory);
        }
    }

    public Bitmap getBitmapFromMemoey(String key){
        return lruCache.get(key);
    }
}
