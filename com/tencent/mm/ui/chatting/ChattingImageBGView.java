package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.w;

public class ChattingImageBGView extends ImageView {
    private Bitmap mhk;
    private int vBU = 0;

    public ChattingImageBGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ScaleType.MATRIX);
    }

    public ChattingImageBGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ScaleType.MATRIX);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.vBU != i3 - i) {
            this.vBU = i3 - i;
            w.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            bUn();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.mhk = bitmap;
        super.setImageBitmap(bitmap);
        bUn();
    }

    private void bUn() {
        post(new Runnable(this) {
            final /* synthetic */ ChattingImageBGView vBV;

            {
                this.vBV = r1;
            }

            public final void run() {
                if (this.vBV.mhk == null) {
                    w.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
                    return;
                }
                if (this.vBV.mhk.getWidth() == 0) {
                    w.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
                }
                Matrix matrix = new Matrix();
                float measuredWidth = ((float) this.vBV.getMeasuredWidth()) / ((float) this.vBV.mhk.getWidth());
                float measuredHeight = ((float) this.vBV.getMeasuredHeight()) / ((float) this.vBV.mhk.getHeight());
                w.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", new Object[]{Float.valueOf(measuredWidth), Float.valueOf(measuredHeight), Integer.valueOf(this.vBV.getMeasuredWidth()), Integer.valueOf(this.vBV.getMeasuredHeight())});
                if (measuredWidth > measuredHeight) {
                    matrix.setScale(measuredWidth, measuredWidth);
                } else {
                    matrix.setScale(measuredHeight, measuredHeight);
                    matrix.postTranslate((((float) this.vBV.getMeasuredWidth()) - (((float) this.vBV.mhk.getWidth()) * measuredHeight)) / 2.0f, 0.0f);
                }
                this.vBV.setImageMatrix(matrix);
            }
        });
    }
}
