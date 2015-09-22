package com.obannonapps.helloworld;

/**
 * Created by SeanOBannon on 9/21/2015.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) { // if it's not recycled, initialize some
            // attributes
            imageView = new ImageView(mContext);
            DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
            float dpWidth = metrics.widthPixels / metrics.density;
            int tileWidth = ((int)dpWidth - 30) / 3;
            Log.i("OBANNON", "" + dpWidth + " " + tileWidth);
            imageView.setLayoutParams(new GridView.LayoutParams(tileWidth, tileWidth));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bm = BitmapFactory.decodeResource(mContext.getResources(), mThumbIds[position], options);

        imageView.setImageBitmap(bm);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = { R.drawable.staff, R.drawable.schedule, R.drawable.grades, R.drawable.map, R.drawable.haiku, R.drawable.website, R.drawable.calendar, R.drawable.contact};
}