package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.f.c.b;

public class MMClearEditText extends EditText {
    public String jwX = "";
    private OnFocusChangeListener oNw = null;
    public OnTouchListener rlX = new OnTouchListener(this) {
        final /* synthetic */ MMClearEditText viR;

        {
            this.viR = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            MMClearEditText mMClearEditText = this.viR;
            if (mMClearEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - this.viR.sJl.getIntrinsicWidth()))) {
                mMClearEditText.setText("");
                this.viR.bEl();
            }
            return false;
        }
    };
    public boolean sJk = false;
    final Drawable sJl = getResources().getDrawable(f.bgg);
    int swf = 0;
    private boolean viQ = false;

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bGi();
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bGi();
    }

    private void bGi() {
        this.sJl.setBounds(0, 0, this.sJl.getIntrinsicWidth(), this.sJl.getIntrinsicHeight());
        w.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.sJl.getIntrinsicWidth()), Integer.valueOf(this.sJl.getIntrinsicHeight()));
        bEj();
        setHeight(this.sJl.getIntrinsicHeight() + (getResources().getDimensionPixelSize(e.aXJ) * 5));
        setOnTouchListener(this.rlX);
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMClearEditText viR;

            {
                this.viR = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.viR.bEj();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMClearEditText viR;

            {
                this.viR = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.viR.oNw != null) {
                    this.viR.oNw.onFocusChange(view, z);
                }
                this.viR.bEj();
            }
        });
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.swf = 0;
            String obj = getText().toString();
            try {
                ME(obj);
            } catch (IndexOutOfBoundsException e) {
                w.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.swf));
                if (this.swf < 3) {
                    this.swf++;
                    ME(" " + obj);
                } else {
                    w.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        return onTextContextMenuItem;
    }

    private void ME(String str) {
        int selectionStart = getSelectionStart();
        setText(b.a(getContext(), (CharSequence) str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.oNw = onFocusChangeListener;
    }

    private void bEj() {
        if (getText().toString().equals("") || !isFocused()) {
            bEl();
        } else if (!this.viQ) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.sJl, getCompoundDrawables()[3]);
        }
    }

    private void bEl() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            if (!this.sJk) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
