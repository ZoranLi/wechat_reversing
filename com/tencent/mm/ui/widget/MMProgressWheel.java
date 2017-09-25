package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.mm.bm.a.j;

public class MMProgressWheel extends View {
    private static final String TAG = MMProgressWheel.class.getSimpleName();
    private float viX = 0.0f;
    private final int wvJ = 16;
    private final int wvK = 270;
    private final long wvL = 200;
    private int wvM = 28;
    private int wvN = 4;
    private int wvO = 4;
    private boolean wvP = false;
    private double wvQ = 0.0d;
    private double wvR = 460.0d;
    private float wvS = 0.0f;
    private boolean wvT = true;
    private long wvU = 0;
    private int wvV = -1442840576;
    private int wvW = 16777215;
    private Paint wvX = new Paint();
    private Paint wvY = new Paint();
    private RectF wvZ = new RectF();
    private float wwa = 230.0f;
    private long wwb = 0;
    private boolean wwc;
    private float wwd = 0.0f;
    private boolean wwe = false;
    private a wwf;
    private boolean wwg;

    static class WheelSavedState extends BaseSavedState {
        public static final Creator<WheelSavedState> CREATOR = new Creator<WheelSavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };
        float viX;
        int wvM;
        int wvN;
        int wvO;
        boolean wvP;
        int wvV;
        int wvW;
        float wwa;
        boolean wwc;
        float wwd;
        boolean wwe;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            super(parcel);
            this.viX = parcel.readFloat();
            this.wwd = parcel.readFloat();
            this.wwe = parcel.readByte() != (byte) 0;
            this.wwa = parcel.readFloat();
            this.wvN = parcel.readInt();
            this.wvV = parcel.readInt();
            this.wvO = parcel.readInt();
            this.wvW = parcel.readInt();
            this.wvM = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.wwc = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.wvP = z2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.viX);
            parcel.writeFloat(this.wwd);
            parcel.writeByte((byte) (this.wwe ? 1 : 0));
            parcel.writeFloat(this.wwa);
            parcel.writeInt(this.wvN);
            parcel.writeInt(this.wvV);
            parcel.writeInt(this.wvO);
            parcel.writeInt(this.wvW);
            parcel.writeInt(this.wvM);
            if (this.wwc) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            if (!this.wvP) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
        }
    }

    public interface a {
    }

    public MMProgressWheel(Context context, AttributeSet attributeSet) {
        boolean z = true;
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.fqH);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.wvN = (int) TypedValue.applyDimension(1, (float) this.wvN, displayMetrics);
        this.wvO = (int) TypedValue.applyDimension(1, (float) this.wvO, displayMetrics);
        this.wvM = (int) TypedValue.applyDimension(1, (float) this.wvM, displayMetrics);
        this.wvM = (int) obtainStyledAttributes.getDimension(j.wBq, (float) this.wvM);
        this.wvP = obtainStyledAttributes.getBoolean(j.wBr, false);
        this.wvN = (int) obtainStyledAttributes.getDimension(j.wBp, (float) this.wvN);
        this.wvO = (int) obtainStyledAttributes.getDimension(j.wBv, (float) this.wvO);
        this.wwa = obtainStyledAttributes.getFloat(j.wBw, this.wwa / 360.0f) * 360.0f;
        this.wvR = (double) obtainStyledAttributes.getInt(j.wBo, (int) this.wvR);
        this.wvV = obtainStyledAttributes.getColor(j.wBn, this.wvV);
        this.wvW = obtainStyledAttributes.getColor(j.wBu, this.wvW);
        this.wwc = obtainStyledAttributes.getBoolean(j.wBs, false);
        if (obtainStyledAttributes.getBoolean(j.wBt, false)) {
            this.wwb = SystemClock.uptimeMillis();
            this.wwe = true;
            invalidate();
        }
        obtainStyledAttributes.recycle();
        if ((VERSION.SDK_INT >= 17 ? Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) : System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f)) == 0.0f) {
            z = false;
        }
        this.wwg = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = (this.wvM + getPaddingLeft()) + getPaddingRight();
        int paddingTop = (this.wvM + getPaddingTop()) + getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(size, paddingTop);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.wvP) {
            this.wvZ = new RectF((float) (paddingLeft + this.wvN), (float) (paddingTop + this.wvN), (float) ((i - paddingRight) - this.wvN), (float) ((i2 - paddingBottom) - this.wvN));
        } else {
            int min = Math.min(Math.min((i - paddingLeft) - paddingRight, (i2 - paddingBottom) - paddingTop), (this.wvM * 2) - (this.wvN * 2));
            paddingLeft += (((i - paddingLeft) - paddingRight) - min) / 2;
            paddingTop += (((i2 - paddingTop) - paddingBottom) - min) / 2;
            this.wvZ = new RectF((float) (this.wvN + paddingLeft), (float) (this.wvN + paddingTop), (float) ((paddingLeft + min) - this.wvN), (float) ((paddingTop + min) - this.wvN));
        }
        this.wvX.setColor(this.wvV);
        this.wvX.setAntiAlias(true);
        this.wvX.setStyle(Style.STROKE);
        this.wvX.setStrokeWidth((float) this.wvN);
        this.wvY.setColor(this.wvW);
        this.wvY.setAntiAlias(true);
        this.wvY.setStyle(Style.STROKE);
        this.wvY.setStrokeWidth((float) this.wvO);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        boolean z = true;
        super.onDraw(canvas);
        canvas.drawArc(this.wvZ, 360.0f, 360.0f, false, this.wvY);
        if (this.wwg) {
            float f;
            float cos;
            if (this.wwe) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.wwb;
                f = (((float) uptimeMillis) * this.wwa) / 1000.0f;
                if (this.wvU >= 200) {
                    this.wvQ = ((double) uptimeMillis) + this.wvQ;
                    if (this.wvQ > this.wvR) {
                        this.wvQ -= this.wvR;
                        this.wvU = 0;
                        this.wvT = !this.wvT;
                    }
                    cos = (((float) Math.cos(((this.wvQ / this.wvR) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                    if (this.wvT) {
                        this.wvS = cos * 254.0f;
                    } else {
                        cos = (1.0f - cos) * 254.0f;
                        this.viX += this.wvS - cos;
                        this.wvS = cos;
                    }
                } else {
                    this.wvU = uptimeMillis + this.wvU;
                }
                this.viX += f;
                if (this.viX > 360.0f) {
                    this.viX -= 360.0f;
                }
                this.wwb = SystemClock.uptimeMillis();
                float f2 = this.viX - 90.0f;
                f = 16.0f + this.wvS;
                if (isInEditMode()) {
                    f2 = 0.0f;
                    f = 135.0f;
                }
                canvas.drawArc(this.wvZ, f2, f, false, this.wvX);
            } else {
                float f3;
                cos = this.viX;
                if (this.viX != this.wwd) {
                    this.viX = Math.min(((((float) (SystemClock.uptimeMillis() - this.wwb)) / 1000.0f) * this.wwa) + this.viX, this.wwd);
                    this.wwb = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (!(cos == this.viX || this.wwf == null)) {
                    Math.round((this.viX * 100.0f) / 360.0f);
                }
                cos = this.viX;
                if (this.wwc) {
                    f3 = 0.0f;
                } else {
                    cos = ((float) (1.0d - Math.pow((double) (1.0f - (this.viX / 360.0f)), 2.0d))) * 360.0f;
                    f3 = ((float) (1.0d - Math.pow((double) (1.0f - (this.viX / 360.0f)), 4.0d))) * 360.0f;
                }
                if (isInEditMode()) {
                    f = 360.0f;
                } else {
                    f = cos;
                }
                canvas.drawArc(this.wvZ, f3 - 90.0f, f, false, this.wvX);
            }
            if (z) {
                invalidate();
            }
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.wwb = SystemClock.uptimeMillis();
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.viX = this.viX;
        wheelSavedState.wwd = this.wwd;
        wheelSavedState.wwe = this.wwe;
        wheelSavedState.wwa = this.wwa;
        wheelSavedState.wvN = this.wvN;
        wheelSavedState.wvV = this.wvV;
        wheelSavedState.wvO = this.wvO;
        wheelSavedState.wvW = this.wvW;
        wheelSavedState.wvM = this.wvM;
        wheelSavedState.wwc = this.wwc;
        wheelSavedState.wvP = this.wvP;
        return wheelSavedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof WheelSavedState) {
            WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
            super.onRestoreInstanceState(wheelSavedState.getSuperState());
            this.viX = wheelSavedState.viX;
            this.wwd = wheelSavedState.wwd;
            this.wwe = wheelSavedState.wwe;
            this.wwa = wheelSavedState.wwa;
            this.wvN = wheelSavedState.wvN;
            this.wvV = wheelSavedState.wvV;
            this.wvO = wheelSavedState.wvO;
            this.wvW = wheelSavedState.wvW;
            this.wvM = wheelSavedState.wvM;
            this.wwc = wheelSavedState.wwc;
            this.wvP = wheelSavedState.wvP;
            this.wwb = SystemClock.uptimeMillis();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
