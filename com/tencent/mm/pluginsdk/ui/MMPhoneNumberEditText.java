package com.tencent.mm.pluginsdk.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bi.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class MMPhoneNumberEditText extends EditText {
    public String jwX = "";
    private OnFocusChangeListener oNw = null;
    public boolean sJk = false;
    public Drawable sJl;
    a sJm;
    public boolean sJn;
    private boolean sJo = false;
    int swf = 0;

    public interface a {
        void bEm();

        void bEn();

        void f(MMPhoneNumberEditText mMPhoneNumberEditText);

        void g(MMPhoneNumberEditText mMPhoneNumberEditText);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.sJl = getResources().getDrawable(R.g.bgg);
        this.sJl.setBounds(0, 0, this.sJl.getIntrinsicWidth(), this.sJl.getIntrinsicHeight());
        w.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.sJl.getIntrinsicWidth()), Integer.valueOf(this.sJl.getIntrinsicHeight()));
        bEj();
        setHeight(this.sJl.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.f.aXJ) * 5));
        clearFocus();
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMPhoneNumberEditText sJp;

            {
                this.sJp = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MMPhoneNumberEditText mMPhoneNumberEditText = this.sJp;
                if (mMPhoneNumberEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - this.sJp.sJl.getIntrinsicWidth()))) {
                    if (mMPhoneNumberEditText.isFocused()) {
                        mMPhoneNumberEditText.setText("");
                        mMPhoneNumberEditText.bEl();
                    } else if (this.sJp.sJm != null) {
                        this.sJp.sJm.f(mMPhoneNumberEditText);
                    }
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMPhoneNumberEditText sJp;

            {
                this.sJp = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.sJp.bEj();
                if (!charSequence.toString().equals("") || this.sJp.sJo) {
                    if (charSequence.toString().equals("") || !this.sJp.sJo) {
                        if (this.sJp.sJm != null && this.sJp.isFocused()) {
                            this.sJp.sJm.bEn();
                        }
                    } else if (this.sJp.sJm != null && this.sJp.isFocused()) {
                        this.sJp.sJm.bEm();
                    }
                } else if (this.sJp.sJm != null && this.sJp.isFocused()) {
                    this.sJp.sJm.g(this.sJp);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (bg.mA(charSequence.toString())) {
                    this.sJp.sJo = true;
                } else {
                    this.sJp.sJo = false;
                }
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMPhoneNumberEditText sJp;

            {
                this.sJp = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.sJp.oNw != null) {
                    this.sJp.oNw.onFocusChange(view, z);
                }
                this.sJp.bEj();
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
        setText(g.bKH().d(getContext(), str, getTextSize()));
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
        if (getText().toString().equals("")) {
            bEl();
        } else {
            bEk();
        }
    }

    final void bEk() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.sJl, getCompoundDrawables()[3]);
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
