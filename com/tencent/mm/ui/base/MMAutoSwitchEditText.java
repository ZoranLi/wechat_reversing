package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class MMAutoSwitchEditText extends EditText {
    a viD = new a(this);

    public static class a implements TextWatcher, OnKeyListener {
        private String jqT;
        private EditText kM;
        int mIndex = 0;
        c viE;
        b viF;
        d viG;
        int viH = 4;

        public a(EditText editText) {
            this.kM = editText;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            int i = 0;
            this.jqT = editable.toString();
            Object obj = "";
            if (this.viG != null) {
                this.viG.bRO();
            }
            int i2 = 0;
            while (i < this.jqT.length()) {
                i2++;
                if (i2 > this.viH) {
                    break;
                }
                obj = obj + this.jqT.charAt(i);
                i++;
            }
            if (i2 > this.viH) {
                this.kM.setText(obj);
                this.kM.setSelection(obj.length());
            }
            if (i2 >= this.viH && this.viE != null) {
                this.viE.Ac(this.mIndex);
            }
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 67 && this.kM.getText().toString().trim().length() == 0 && this.viF != null) {
                this.viF.Ab(this.mIndex);
            }
            return false;
        }
    }

    public interface b {
        void Ab(int i);
    }

    public interface c {
        void Ac(int i);
    }

    public interface d {
        void bRO();
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(this.viD);
        setOnKeyListener(this.viD);
    }
}
