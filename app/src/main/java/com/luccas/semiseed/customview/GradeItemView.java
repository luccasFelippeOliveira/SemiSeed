package com.luccas.semiseed.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luccas.semiseed.R;

import java.io.File;

/**
 * Created by lfo on 16/11/2016.
 */

public class GradeItemView extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;
    private CardView mCardView;
    private OnClickListener onClickListener;

    public GradeItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.grade_item_view, this, true);

        mCardView = (CardView) findViewById(R.id.item_container);
        mImageView = (ImageView) findViewById(R.id.crop_imageview);
        mTextView = (TextView) findViewById(R.id.crop_textview);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GridItemView,0,0);
        String cropName = a.getString(R.styleable.GridItemView_cropName);
        String cropImageString = null;
        Drawable cropImageDrawable = null;

        /*TypedValue val = a.peekValue(R.styleable.GridItemView_cropImage);
        if (val.type == TypedValue.TYPE_REFERENCE) {
            cropImageDrawable = a.getDrawable(R.styleable.GridItemView_cropImage);
        } else {
            cropImageString = a.getString(R.styleable.GridItemView_cropImage);
        }*/
        cropImageString = a.getString(R.styleable.GridItemView_cropImage);
        a.recycle();

        //Set imageView and Textview propreties.

        if (cropName != null && !("".equals(cropName))) {
            mTextView.setText(cropName);
        }


        //Get image.
        /*
        if (cropImageDrawable != null)
            mImageView.setImageDrawable(cropImageDrawable);
        else
        */    setCropImage(cropImageString);
    }

    public GradeItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
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
        src="nothing";
        File imgFile = new File(src);
        if (imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            Bitmap cropped = Bitmap.createBitmap(bitmap, 0, 0, 100, 100);
            return cropped;
        }
        return null;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (this.onClickListener != null){
                this.onClickListener.onClick(this);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}
