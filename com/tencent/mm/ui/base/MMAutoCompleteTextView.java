package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.s.a.f;

public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable sJl = getResources().getDrawable(f.bgg);
    public a viy;

    private class a implements TextWatcher {
        private String viA;
        final /* synthetic */ MMAutoCompleteTextView viz;

        public a(MMAutoCompleteTextView mMAutoCompleteTextView, String str) {
            this.viz = mMAutoCompleteTextView;
            this.viA = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.toString().endsWith(this.viA)) {
                this.viz.showDropDown();
            }
        }
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sJl.setBounds(0, 0, this.sJl.getIntrinsicWidth(), this.sJl.getIntrinsicHeight());
        bEj();
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMAutoCompleteTextView viz;

            {
                this.viz = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                MMAutoCompleteTextView mMAutoCompleteTextView = this.viz;
                if (mMAutoCompleteTextView.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMAutoCompleteTextView.getWidth() - mMAutoCompleteTextView.getPaddingRight()) - this.viz.sJl.getIntrinsicWidth()))) {
                    mMAutoCompleteTextView.setText("");
                    this.viz.bEl();
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMAutoCompleteTextView viz;

            {
                this.viz = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.viz.bEj();
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMAutoCompleteTextView viz;

            {
                this.viz = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                this.viz.bEj();
            }
        });
    }

    private void bEj() {
        if (getText().toString().equals("") || !isFocused()) {
            bEl();
        } else {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.sJl, getCompoundDrawables()[3]);
        }
    }

    private void bEl() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }
}
