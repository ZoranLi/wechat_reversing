package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.t;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.mm.bi.g;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.PasterEditText;

public class WXRTEditText extends PasterEditText {
    public int mhm = 0;
    public boolean suB = false;
    b svR;
    private int svS = -1;
    private int svT = -1;
    private boolean svU;
    private int svV;
    private int svW;
    private String svX;
    public String svY = "";
    private Spannable svZ;
    public int swa = 0;
    private WXRTEditText swb = null;
    public t swc;
    private String swd = "";
    TextWatcher swe = new TextWatcher(this) {
        final /* synthetic */ WXRTEditText swg;

        {
            this.swg = r1;
        }

        public final synchronized void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Object c = this.swg.svX == null ? "" : this.swg.svX;
            if (!(this.swg.svU || charSequence.toString().equals(c))) {
                this.swg.svV = this.swg.getSelectionStart();
                this.swg.svW = this.swg.getSelectionEnd();
                this.swg.svX = charSequence.toString();
                this.swg.svY = this.swg.svX;
                this.swg.svZ = this.swg.bBM();
            }
        }

        public final synchronized void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            String str = this.swg.svY == null ? "" : this.swg.svY;
            if (!(this.swg.svU || str.equals(charSequence2) || this.swg.svR == null || !c.bBv().F(charSequence2.subSequence(i, i + i3).toString(), "", 0))) {
                this.swg.swd = charSequence.toString();
                this.swg.b(((SpannableStringBuilder) charSequence.subSequence(0, i)).append((SpannableStringBuilder) charSequence.subSequence(i + i3, charSequence2.length())));
                this.swg.svR.bBt();
            }
        }

        public final synchronized void afterTextChanged(Editable editable) {
            w.d("noteeditor.WXRTEditText", "afterTextChanged");
            if (bg.mA(this.swg.swd) || !this.swg.swd.equals(editable.toString())) {
                w.d("noteeditor.WXRTEditText", "afteronUITextSplit");
                String obj = editable.toString();
                String str = this.swg.svY == null ? "" : this.swg.svY;
                if (this.swg.swa != 0) {
                    this.swg.svY = "";
                }
                if (!(this.swg.svR == null || this.swg.svU || str.equals(obj))) {
                    this.swg.bBM();
                    this.swg.svY = obj;
                    b e = this.swg.svR;
                    WXRTEditText h = this.swg.swb;
                    this.swg.getSelectionStart();
                    e.a(h, this.swg.getSelectionEnd());
                }
            } else {
                this.swg.swd = "";
            }
        }
    };
    int swf = 0;

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setMaxHeight(int i) {
        super.setMaxHeight(i);
    }

    private void init() {
        this.swb = this;
        removeTextChangedListener(this.swe);
        addTextChangedListener(this.swe);
        setMovementMethod(h.getInstance());
    }

    public final void Ls(String str) {
        bBO();
        if (bg.mA(str)) {
            setText("");
        } else {
            b(a.Lq(str));
        }
        bBP();
    }

    public final void b(Spanned spanned) {
        bBO();
        super.setText(spanned, BufferType.EDITABLE);
        onSelectionChanged(0, 0);
        bBP();
    }

    public final void setText(String str) {
        bBO();
        super.setText(str);
        bBP();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            bBN();
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.svR != null) {
            this.svR.a(this, z, bBN());
        }
    }

    protected void onSelectionChanged(int i, int i2) {
        if (this.svS != i || this.svT != i2) {
            this.svS = i;
            this.svT = i2;
            super.onSelectionChanged(i, i2);
            if (this.svR != null) {
                this.svR.a(this, i, i2);
            }
        }
    }

    public final Spannable bBM() {
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        return new a(text);
    }

    public final String a(i iVar) {
        if (iVar == i.swk) {
            return getText().toString();
        }
        if (iVar == i.swl) {
            return com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
        }
        return "";
    }

    public final int bBN() {
        if (this.swc.ge() == -1) {
            return 0;
        }
        return this.swc.ge();
    }

    public boolean onTextContextMenuItem(int i) {
        if (i == 16908319) {
            this.svR.bBs();
            return true;
        }
        if (i == 16908321 || i == 16908320) {
            f.QZ();
        } else if (i == 16908322) {
            if (f.dj(getContext())) {
                f.QZ();
            } else if (f.bBH()) {
                this.svR.b(this);
                return true;
            }
        }
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i == 16908322) {
                this.swf = 0;
                try {
                    b(getText());
                } catch (IndexOutOfBoundsException e) {
                    w.e("noteeditor.WXRTEditText", "!!MMEditText Exception %d", new Object[]{Integer.valueOf(this.swf)});
                    if (this.swf < 3) {
                        this.swf++;
                        b(new SpannableStringBuilder(TextUtils.concat(new CharSequence[]{" ", r3})));
                    } else {
                        throw e;
                    }
                }
            }
            if (i == 16908322 && this.suB) {
                if (this.svR != null) {
                    this.svR.a(this, false, bBN());
                }
                this.suB = false;
            }
            return onTextContextMenuItem;
        } catch (NullPointerException e2) {
            w.e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", new Object[]{e2});
            return false;
        }
    }

    private void b(Spannable spannable) {
        int selectionStart = getSelectionStart();
        b(g.bKH().d(getContext(), spannable, getTextSize()));
        int length = getText().length() - spannable.length();
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

    public final synchronized void bBO() {
        this.svU = true;
    }

    public final synchronized void bBP() {
        this.svU = false;
    }
}
