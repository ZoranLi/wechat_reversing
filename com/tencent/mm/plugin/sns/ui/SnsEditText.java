package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText extends MMEditText {
    private Context context;
    private boolean nbn = false;
    private ClipboardManager qBt = null;
    int qBu = 0;
    private int qBv = 0;
    private int qBw = 0;
    private int qBx = 10;
    private float y;

    public SnsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.qBt = (ClipboardManager) this.context.getSystemService("clipboard");
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SnsEditText qBy;

            {
                this.qBy = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.qBy.qBw = charSequence.length();
                if (i2 <= 0) {
                    try {
                        if (this.qBy.qBw > this.qBy.qBv && i3 > 30) {
                            String substring = charSequence.toString().substring(i, i + i3);
                            if ((substring.indexOf("\n") >= 0 && i3 > 30) || i3 > 100) {
                                this.qBy.qBu = this.qBy.qBu + substring.length();
                                w.d("MicroMsg.SnsEditText", "parsterLen: %d %d", new Object[]{Integer.valueOf(substring.length()), Integer.valueOf(this.qBy.qBu)});
                            }
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SnsEditText", e, "", new Object[0]);
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    this.qBy.qBv = charSequence.length();
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
    }

    public final int bkj() {
        return this.qBu;
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.y - motionEvent.getY()) > ((float) this.qBx)) {
                this.nbn = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.nbn = false;
        } else if (this.nbn) {
            this.nbn = false;
            return true;
        }
        this.y = motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }
}
