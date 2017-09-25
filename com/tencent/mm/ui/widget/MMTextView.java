package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.w;

public class MMTextView extends TextView {
    private long gLE = -1;
    private boolean wwJ = false;
    public b wwK = null;
    private GestureDetector wwL = null;
    private boolean wwM = false;
    private boolean wwN = false;
    private boolean wwO = false;
    private a wwP = null;

    public interface a {
        void a(CharSequence charSequence, long j);
    }

    public interface b {
        boolean ds(View view);
    }

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.wwL = new GestureDetector(getContext(), new SimpleOnGestureListener(this) {
            final /* synthetic */ MMTextView wwQ;

            {
                this.wwQ = r1;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                if (this.wwQ.wwK == null) {
                    return false;
                }
                return this.wwQ.wwK.ds(this.wwQ);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = action == 1 && this.wwJ;
        if (z) {
            w.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            return true;
        }
        boolean z2;
        if (action == 0) {
            this.wwJ = false;
        }
        if (this.wwK == null || this.wwL == null) {
            z2 = false;
        } else {
            z2 = this.wwL.onTouchEvent(motionEvent);
        }
        if (z2) {
            return z2;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Suppress
    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.wwP != null && this.wwM && (charSequence instanceof Spannable) && ((Spannable) charSequence).getSpans(0, charSequence.length(), Object.class) != null) {
            this.wwP.a(charSequence, this.gLE);
        }
        this.wwN = false;
    }

    public void cancelLongPress() {
        w.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.wwJ = true;
        super.cancelLongPress();
    }

    public boolean performLongClick() {
        w.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.wwJ = true;
        return super.performLongClick();
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            return -1;
        }
    }
}
