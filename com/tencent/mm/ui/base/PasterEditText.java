package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;

public class PasterEditText extends EditText {
    private Context context;
    private ClipboardManager qBt = null;
    private int qBu = 0;

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PasterEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int bkj() {
        return this.qBu;
    }

    private void init() {
        this.qBt = (ClipboardManager) this.context.getSystemService("clipboard");
    }

    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322) {
            return super.onTextContextMenuItem(i);
        }
        if (!(this.qBt == null || this.qBt.getText() == null || !(this.qBt.getText() instanceof String) || this.qBt.getText() == null || this.qBt.getText().length() <= 0)) {
            this.qBu += this.qBt.getText().length();
        }
        return super.onTextContextMenuItem(i);
    }
}
