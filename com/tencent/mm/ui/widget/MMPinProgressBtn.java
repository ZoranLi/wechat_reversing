package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.CompoundButton;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.w;

public class MMPinProgressBtn extends CompoundButton {
    private Paint CT;
    private int sd;
    private int style;
    public int wvs;
    private Paint wvt;
    private RectF wvu = new RectF();
    private int wvv;
    private final float wvw = 4.0f;
    private Runnable wvx = new Runnable(this) {
        final /* synthetic */ MMPinProgressBtn wvy;

        {
            this.wvy = r1;
        }

        public final void run() {
            if (this.wvy.getVisibility() != 0) {
                w.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
                return;
            }
            this.wvy.sd = this.wvy.sd + 1;
            if (this.wvy.sd >= this.wvy.wvs) {
                this.wvy.sd = this.wvy.sd - 1;
                w.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
                return;
            }
            this.wvy.invalidate();
            this.wvy.postDelayed(this.wvy.wvx, 200);
        }
    };

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private int sd;
        private int wvs;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.sd = parcel.readInt();
            this.wvs = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sd);
            parcel.writeInt(this.wvs);
        }
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        this.wvs = 100;
        this.sd = 0;
        Resources resources = getResources();
        int color = resources.getColor(d.hbz);
        int color2 = resources.getColor(d.hbA);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fqG, i, 0);
            this.wvs = obtainStyledAttributes.getInteger(m.hfO, this.wvs);
            this.sd = obtainStyledAttributes.getInteger(m.hfP, this.sd);
            color = obtainStyledAttributes.getColor(m.hfM, color);
            color2 = obtainStyledAttributes.getColor(m.hfQ, color2);
            this.style = obtainStyledAttributes.getInteger(m.hfR, 0);
            this.wvv = obtainStyledAttributes.getDimensionPixelSize(m.hfN, resources.getDimensionPixelSize(e.hbJ));
            obtainStyledAttributes.recycle();
        }
        this.CT = new Paint();
        this.CT.setColor(color);
        this.CT.setStyle(Style.STROKE);
        this.CT.setStrokeWidth(4.0f);
        this.CT.setAntiAlias(true);
        this.wvt = new Paint();
        this.wvt.setColor(color2);
        this.wvt.setAntiAlias(true);
        setClickable(false);
    }

    public final void setMax(int i) {
        this.wvs = Math.max(0, i);
        invalidate();
    }

    public final void setProgress(int i) {
        this.sd = Math.max(0, i);
        this.sd = Math.min(i, this.wvs);
        invalidate();
    }

    public final void caB() {
        removeCallbacks(this.wvx);
        post(this.wvx);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(this.wvv, i), resolveSize(this.wvv, i2));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.wvu.set(2.0f, 2.0f, ((float) this.wvv) - 2.0f, ((float) this.wvv) - 2.0f);
        this.wvu.offset((float) ((getWidth() - this.wvv) / 2), (float) ((getHeight() - this.wvv) / 2));
        canvas.drawArc(this.wvu, 0.0f, 360.0f, true, this.CT);
        switch (this.style) {
            case 0:
                this.wvu.set(8.0f, 8.0f, ((float) this.wvv) - 8.0f, ((float) this.wvv) - 8.0f);
                this.wvu.offset((float) ((getWidth() - this.wvv) / 2), (float) ((getHeight() - this.wvv) / 2));
                canvas.drawArc(this.wvu, -90.0f, 360.0f * ((((float) this.sd) * 1.0f) / ((float) this.wvs)), true, this.wvt);
                return;
            case 1:
                this.wvu.set(2.0f, 2.0f, ((float) this.wvv) - 2.0f, ((float) this.wvv) - 2.0f);
                this.wvu.offset((float) ((getWidth() - this.wvv) / 2), (float) ((getHeight() - this.wvv) / 2));
                canvas.drawArc(this.wvu, 270.0f, (((((float) this.sd) * 1.0f) / ((float) this.wvs)) * 360.0f) - 360.0f, true, this.wvt);
                return;
            default:
                return;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (!isSaveEnabled()) {
            return onSaveInstanceState;
        }
        Parcelable savedState = new SavedState(onSaveInstanceState);
        savedState.wvs = this.wvs;
        savedState.sd = this.sd;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.wvs = savedState.wvs;
            this.sd = savedState.sd;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
