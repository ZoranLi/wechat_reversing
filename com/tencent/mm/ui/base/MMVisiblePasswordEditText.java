package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.j;
import com.tencent.mm.sdk.platformtools.w;

public class MMVisiblePasswordEditText extends EditText {
    public String jwX = "";
    final Drawable vnN = getResources().getDrawable(j.heX);
    final Drawable vnO = getResources().getDrawable(j.heY);
    private boolean vnP = false;

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bGi();
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bGi();
    }

    private void bGi() {
        this.vnN.setBounds(0, 0, this.vnN.getIntrinsicWidth(), this.vnN.getIntrinsicHeight());
        this.vnO.setBounds(0, 0, this.vnO.getIntrinsicWidth(), this.vnO.getIntrinsicHeight());
        w.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", new Object[]{Integer.valueOf(this.vnN.getIntrinsicWidth()), Integer.valueOf(this.vnN.getIntrinsicHeight())});
        bSF();
        setHeight(this.vnN.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.aXJ) * 5));
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMVisiblePasswordEditText vnQ;

            {
                this.vnQ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z = true;
                MMVisiblePasswordEditText mMVisiblePasswordEditText = this.vnQ;
                if (mMVisiblePasswordEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - this.vnQ.vnN.getIntrinsicWidth()))) {
                    mMVisiblePasswordEditText = this.vnQ;
                    if (this.vnQ.vnP) {
                        z = false;
                    }
                    mMVisiblePasswordEditText.vnP = z;
                    this.vnQ.bSF();
                }
                return false;
            }
        });
    }

    private void bSF() {
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.vnP) {
            setInputType(1);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vnO, getCompoundDrawables()[3]);
        } else {
            setInputType(129);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vnN, getCompoundDrawables()[3]);
        }
        setSelection(selectionStart, selectionEnd);
    }
}
