package com.tencent.mm.plugin.game.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Array;

@TargetApi(11)
public class BlurringView extends View {
    private int mGO = 11;
    private int mGP = 8;
    private int mGQ = 0;
    private View mGR;
    private int mGS;
    private int mGT;
    private boolean mGU;
    private Bitmap mGV;
    private Bitmap mGW;
    private Canvas mGX;
    private RenderScript mGY;
    private ScriptIntrinsicBlur mGZ;
    private Allocation mHa;
    private Allocation mHb;

    public BlurringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (VERSION.SDK_INT > 16) {
            this.mGY = RenderScript.create(context);
            this.mGZ = ScriptIntrinsicBlur.create(this.mGY, Element.U8_4(this.mGY));
        }
    }

    protected void onDraw(Canvas canvas) {
        int i = 1;
        super.onDraw(canvas);
        if (this.mGR != null) {
            int width = this.mGR.getWidth();
            int height = this.mGR.getHeight();
            if (this.mGX == null || this.mGU || this.mGS != width || this.mGT != height) {
                this.mGU = false;
                this.mGS = width;
                this.mGT = height;
                width /= this.mGP;
                height /= this.mGP;
                width = (width - (width % 4)) + 4;
                height = (height - (height % 4)) + 4;
                if (!(this.mGW != null && this.mGW.getWidth() == width && this.mGW.getHeight() == height)) {
                    this.mGV = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                    if (this.mGV == null) {
                        i = 0;
                    } else {
                        this.mGW = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                        if (this.mGW == null) {
                            i = 0;
                        }
                    }
                }
                this.mGX = new Canvas(this.mGV);
                this.mGX.scale(1.0f / ((float) this.mGP), 1.0f / ((float) this.mGP));
                if (VERSION.SDK_INT > 16) {
                    this.mHa = Allocation.createFromBitmap(this.mGY, this.mGV, MipmapControl.MIPMAP_NONE, 1);
                    this.mHb = Allocation.createTyped(this.mGY, this.mHa.getType());
                }
            }
            if (i != 0) {
                if (this.mGR.getBackground() == null || !(this.mGR.getBackground() instanceof ColorDrawable)) {
                    this.mGV.eraseColor(0);
                } else {
                    this.mGV.eraseColor(((ColorDrawable) this.mGR.getBackground()).getColor());
                }
                this.mGR.draw(this.mGX);
                nP(this.mGO);
                canvas.save();
                canvas.translate(this.mGR.getX() - getX(), this.mGR.getY() - getY());
                canvas.scale((float) this.mGP, (float) this.mGP);
                canvas.drawBitmap(this.mGW, 0.0f, 0.0f, null);
                canvas.restore();
            }
            canvas.drawColor(this.mGQ);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mGY != null) {
            this.mGY.destroy();
        }
    }

    private void nP(int i) {
        if (VERSION.SDK_INT > 16) {
            this.mGZ.setRadius((float) i);
            this.mHa.copyFrom(this.mGV);
            this.mGZ.setInput(this.mHa);
            this.mGZ.forEach(this.mHb);
            this.mHb.copyTo(this.mGW);
        } else if (i > 0) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int width = this.mGV.getWidth();
            int height = this.mGV.getHeight();
            int[] iArr = new int[(width * height)];
            w.i("MicroMsg.BlurringView", width + " " + height + " " + iArr.length);
            this.mGV.getPixels(iArr, 0, width, 0, 0, width, height);
            int i13 = width - 1;
            int i14 = height - 1;
            int i15 = width * height;
            int i16 = (i + i) + 1;
            int[] iArr2 = new int[i15];
            int[] iArr3 = new int[i15];
            int[] iArr4 = new int[i15];
            int[] iArr5 = new int[Math.max(width, height)];
            int i17 = (i16 + 1) >> 1;
            int i18 = i17 * i17;
            int[] iArr6 = new int[(i18 * 256)];
            for (i17 = 0; i17 < i18 * 256; i17++) {
                iArr6[i17] = i17 / i18;
            }
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i16, 3});
            int i19 = i + 1;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            while (i20 < height) {
                int[] iArr8;
                i18 = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                for (i10 = -i; i10 <= i; i10++) {
                    i11 = iArr[Math.min(i13, Math.max(i10, 0)) + i22];
                    iArr8 = iArr7[i10 + i];
                    iArr8[0] = (16711680 & i11) >> 16;
                    iArr8[1] = (65280 & i11) >> 8;
                    iArr8[2] = i11 & 255;
                    i11 = i19 - Math.abs(i10);
                    i6 += iArr8[0] * i11;
                    i7 += iArr8[1] * i11;
                    i8 += i11 * iArr8[2];
                    if (i10 > 0) {
                        i18 += iArr8[0];
                        i9 += iArr8[1];
                        i2 += iArr8[2];
                    } else {
                        i3 += iArr8[0];
                        i4 += iArr8[1];
                        i5 += iArr8[2];
                    }
                }
                i11 = i22;
                i22 = i;
                i12 = i9;
                i9 = i18;
                i10 = i5;
                i5 = i4;
                i4 = i3;
                i3 = i2;
                i2 = i12;
                for (i18 = 0; i18 < width; i18++) {
                    iArr2[i11] = iArr6[i6];
                    iArr3[i11] = iArr6[i7];
                    iArr4[i11] = iArr6[i8];
                    i6 -= i4;
                    i7 -= i5;
                    i8 -= i10;
                    iArr8 = iArr7[((i22 - i) + i16) % i16];
                    i4 -= iArr8[0];
                    i5 -= iArr8[1];
                    i10 -= iArr8[2];
                    if (i20 == 0) {
                        iArr5[i18] = Math.min((i18 + i) + 1, i13);
                    }
                    int i23 = iArr[iArr5[i18] + i21];
                    iArr8[0] = (16711680 & i23) >> 16;
                    iArr8[1] = (65280 & i23) >> 8;
                    iArr8[2] = i23 & 255;
                    i9 += iArr8[0];
                    i2 += iArr8[1];
                    i3 += iArr8[2];
                    i6 += i9;
                    i7 += i2;
                    i8 += i3;
                    i22 = (i22 + 1) % i16;
                    iArr8 = iArr7[i22 % i16];
                    i4 += iArr8[0];
                    i5 += iArr8[1];
                    i10 += iArr8[2];
                    i9 -= iArr8[0];
                    i2 -= iArr8[1];
                    i3 -= iArr8[2];
                    i11++;
                }
                i20++;
                i21 += width;
                i22 = i11;
            }
            for (i20 = 0; i20 < width; i20++) {
                int[] iArr9;
                i9 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i10 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i18 = (-i) * width;
                i2 = 0;
                for (i22 = -i; i22 <= i; i22++) {
                    i11 = Math.max(0, i18) + i20;
                    iArr9 = iArr7[i22 + i];
                    iArr9[0] = iArr2[i11];
                    iArr9[1] = iArr3[i11];
                    iArr9[2] = iArr4[i11];
                    i13 = i19 - Math.abs(i22);
                    i6 += iArr2[i11] * i13;
                    i7 += iArr3[i11] * i13;
                    i8 += iArr4[i11] * i13;
                    if (i22 > 0) {
                        i9 += iArr9[0];
                        i2 += iArr9[1];
                        i3 += iArr9[2];
                    } else {
                        i4 += iArr9[0];
                        i5 += iArr9[1];
                        i10 += iArr9[2];
                    }
                    if (i22 < i14) {
                        i18 += width;
                    }
                }
                i22 = i;
                i11 = i20;
                i12 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i10;
                i10 = i6;
                i6 = i7;
                i7 = i8;
                i18 = i9;
                i9 = i2;
                i2 = i12;
                for (i8 = 0; i8 < height; i8++) {
                    iArr[i11] = (((WebView.NIGHT_MODE_COLOR & iArr[i11]) | (iArr6[i10] << 16)) | (iArr6[i6] << 8)) | iArr6[i7];
                    i10 -= i3;
                    i6 -= i4;
                    i7 -= i5;
                    iArr9 = iArr7[((i22 - i) + i16) % i16];
                    i3 -= iArr9[0];
                    i4 -= iArr9[1];
                    i5 -= iArr9[2];
                    if (i20 == 0) {
                        iArr5[i8] = Math.min(i8 + i19, i14) * width;
                    }
                    i13 = iArr5[i8] + i20;
                    iArr9[0] = iArr2[i13];
                    iArr9[1] = iArr3[i13];
                    iArr9[2] = iArr4[i13];
                    i18 += iArr9[0];
                    i9 += iArr9[1];
                    i2 += iArr9[2];
                    i10 += i18;
                    i6 += i9;
                    i7 += i2;
                    i22 = (i22 + 1) % i16;
                    iArr9 = iArr7[i22];
                    i3 += iArr9[0];
                    i4 += iArr9[1];
                    i5 += iArr9[2];
                    i18 -= iArr9[0];
                    i9 -= iArr9[1];
                    i2 -= iArr9[2];
                    i11 += width;
                }
            }
            w.e("MicroMsg.BlurringView", width + " " + height + " " + i15);
            this.mGW.setPixels(iArr, 0, width, 0, 0, width, height);
        }
    }
}
