package com.tencent.mm.pluginsdk.ui.tools;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.tencent.mm.ui.widget.MMEditText.b;

public final class h {
    public static InputFilter[] sWw = new InputFilter[]{new LengthFilter(50)};

    public static class a implements TextWatcher {
        public b sWx = null;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.sWx != null) {
                this.sWx.aXQ();
            }
        }
    }
}
