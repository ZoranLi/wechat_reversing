package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.PasterEditText;

public class MMEditText extends PasterEditText {
    int swf = 0;
    public InputConnection wvn;
    public a wvo;

    public interface a {
        void aIv();
    }

    public interface b {
        void aXQ();
    }

    public static class c implements TextWatcher {
        private final int aIo;
        private EditText oBT;
        private TextView wvp;
        public b wvq = null;
        private boolean wvr = false;

        public c(EditText editText, TextView textView, int i) {
            this.oBT = editText;
            this.wvp = textView;
            this.aIo = i;
        }

        public final void afterTextChanged(Editable editable) {
            int i;
            int i2 = 0;
            String obj = editable.toString();
            CharSequence charSequence = "";
            int i3 = 0;
            for (i = 0; i < obj.length(); i++) {
                if (bg.f(obj.charAt(i))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 > this.aIo) {
                    break;
                }
                charSequence = charSequence + obj.charAt(i);
            }
            if (i3 > this.aIo) {
                try {
                    this.oBT.setText(charSequence);
                    if (this.wvr) {
                        this.oBT.setSelection(0);
                    } else {
                        this.oBT.setSelection(this.oBT.getText().toString().length());
                    }
                    this.wvr = false;
                } catch (Exception e) {
                    this.wvr = true;
                    w.e("MicroMsg.MMEditText", "error " + e.getMessage());
                    this.oBT.setText(charSequence);
                    this.oBT.setSelection(0);
                }
            }
            i = this.aIo - i3;
            if (i >= 0) {
                i2 = i;
            }
            if (this.wvp != null) {
                this.wvp.setText((i2 / 2));
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.wvq != null) {
                this.wvq.aXQ();
            }
        }
    }

    public MMEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.wvn = super.onCreateInputConnection(editorInfo);
        return this.wvn;
    }

    public MMEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void Uz(String str) {
        int m = com.tencent.mm.ui.f.c.b.m(getContext(), getText().toString(), getSelectionStart());
        int m2 = com.tencent.mm.ui.f.c.b.m(getContext(), getText().toString(), getSelectionEnd());
        StringBuffer stringBuffer = new StringBuffer(getText());
        setText(com.tencent.mm.ui.f.c.b.a(getContext(), stringBuffer.substring(0, m) + str + stringBuffer.substring(m2, stringBuffer.length()), getTextSize()));
        setSelection(m + str.length());
    }

    public boolean onTextContextMenuItem(int i) {
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i != 16908322) {
                return onTextContextMenuItem;
            }
            this.swf = 0;
            String obj = getText().toString();
            try {
                ME(obj);
                return onTextContextMenuItem;
            } catch (IndexOutOfBoundsException e) {
                w.e("MicroMsg.MMEditText", "!!MMEditText Exception %d", Integer.valueOf(this.swf));
                if (this.swf < 3) {
                    this.swf++;
                    ME(" " + obj);
                    return onTextContextMenuItem;
                }
                throw e;
            }
        } catch (NullPointerException e2) {
            w.e("MicroMsg.MMEditText", "!!MMEditText NullPointerException %s", e2);
            return false;
        }
    }

    private void ME(String str) {
        int selectionStart = getSelectionStart();
        setText(com.tencent.mm.ui.f.c.b.a(getContext(), (CharSequence) str, getTextSize()));
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

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        String str = "MicroMsg.MMEditText";
        String str2 = "on onKeyPreIme, listener null ? %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.wvo == null);
        w.v(str, str2, objArr);
        if (this.wvo != null && i == 4) {
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                w.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == 1) {
                w.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    w.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
                    this.wvo.aIv();
                    InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                    if (inputMethodManager == null) {
                        return true;
                    }
                    inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }
}
