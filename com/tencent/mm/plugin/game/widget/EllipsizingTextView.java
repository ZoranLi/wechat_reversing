package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EllipsizingTextView extends TextView {
    private final List<Object> mHn = new ArrayList();
    private boolean mHo;
    private boolean mHp;
    private boolean mHq;
    private String mHr;
    private float mHs = 1.0f;
    private float mHt = 0.0f;
    private int maxLines = -1;

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.mHp = true;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setLineSpacing(float f, float f2) {
        this.mHt = f;
        this.mHs = f2;
        super.setLineSpacing(f, f2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.mHq) {
            this.mHr = charSequence.toString();
            this.mHp = true;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.mHp) {
            CharSequence charSequence;
            boolean z;
            Iterator it;
            super.setEllipsize(null);
            int maxLines = getMaxLines();
            String str = this.mHr;
            if (maxLines != -1) {
                Layout yf = yf(str);
                if (yf.getLineCount() > maxLines) {
                    str = this.mHr.substring(0, yf.getLineEnd(maxLines - 1)).trim();
                    if (!(str.getBytes().length != str.length())) {
                        while (yf(str + "...").getLineCount() > maxLines) {
                            int lastIndexOf = str.lastIndexOf(32);
                            if (lastIndexOf == -1) {
                                break;
                            }
                            str = str.substring(0, lastIndexOf);
                        }
                    } else if (str.length() >= 2) {
                        str = str.substring(0, (str.length() - 1) - 1);
                    }
                    charSequence = str + "...";
                    z = true;
                    if (!charSequence.equals(getText())) {
                        this.mHq = true;
                        try {
                            setText(charSequence);
                        } finally {
                            this.mHq = false;
                        }
                    }
                    this.mHp = false;
                    if (z != this.mHo) {
                        this.mHo = z;
                        it = this.mHn.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
            }
            Object obj = str;
            z = false;
            if (charSequence.equals(getText())) {
                this.mHq = true;
                setText(charSequence);
            }
            this.mHp = false;
            if (z != this.mHo) {
                this.mHo = z;
                it = this.mHn.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
        super.onDraw(canvas);
    }

    private Layout yf(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Alignment.ALIGN_NORMAL, this.mHs, this.mHt, false);
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }
}
