package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.RectF;
import android.text.style.ClickableSpan;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    public int abH;
    public int jkE = -5908174;
    public int wd;
    public ClickableSpan wyq;
    public LinkedList<RectF> wyr;

    public b(ClickableSpan clickableSpan, int i, int i2) {
        this.abH = i;
        this.wd = i2;
        this.wyq = clickableSpan;
    }

    public final boolean es(int i, int i2) {
        Iterator it = this.wyr.iterator();
        while (it.hasNext()) {
            if (((RectF) it.next()).contains((float) i, (float) i2)) {
                return true;
            }
        }
        return false;
    }
}
