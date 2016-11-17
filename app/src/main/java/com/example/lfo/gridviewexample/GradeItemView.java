package com.example.lfo.gridviewexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by lfo on 16/11/2016.
 */

public class GradeItemView extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;

    public GradeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GridItemView,0,0);
        String cropName = a.getString(R.styleable.GridItemView_cropName);
        String cropImage = a.getString(R.styleable.GridItemView_cropImage);

        a.recycle();

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.grade_item_view, this, true);

        CardView card = (CardView) getChildAt(0);
        LinearLayout linear = (LinearLayout) card.getChildAt(0);

        mImageView = (ImageView) linear.getChildAt(0);
        mTextView = (TextView) linear.getChildAt(1);

        //Set imageView and Textview propreties.
        mTextView.setText(cropName);

        //Must check if has resource name.
        //Get image.
        Bitmap bmp = loadBMP(cropImage);
        if (bmp != null) {
            mImageView.setImageBitmap(bmp);
        }
    }

    public GradeItemView(Context context) {
        this(context, null);
    }

    public void setCropText(String cropName) {
        this.mTextView.setText(cropName);
    }
    public void setCropImage(String source) {
        Bitmap bmp = loadBMP(source);
        if (bmp != null) {
            mImageView.setImageBitmap(bmp);
        }
    }

    private Bitmap loadBMP(String src) {
        File imgFile = new File(src);
        if (imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            Bitmap cropped = Bitmap.createBitmap(bitmap, 0, 0, 100, 100);
            return cropped;
        }
        return null;
    }
}
