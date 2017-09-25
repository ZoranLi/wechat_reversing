package com.tencent.mm.ui.widget.celltextview.a;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.celltextview.c.b;
import com.tencent.mm.ui.widget.celltextview.c.d;
import com.tencent.mm.ui.widget.celltextview.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static Paint wyl = new Paint();
    public String jqT;
    public float mGH;
    public ArrayList<e> wyc;
    public LinkedList<b> wyd;
    public ArrayList<d> wyj;
    public float wyk;

    public a(String str, float f, float f2) {
        this.jqT = str;
        this.mGH = f;
        this.wyk = f2;
    }

    public final void al(ArrayList<e> arrayList) {
        if (arrayList != null) {
            if (this.wyc == null) {
                this.wyc = new ArrayList();
            }
            this.wyc.addAll(arrayList);
        }
    }

    public final int hashCode() {
        int measureText;
        wyl.setTextSize(this.mGH);
        if (this.jqT != null) {
            measureText = (int) wyl.measureText(this.jqT);
        } else {
            measureText = 0;
        }
        w.d("CellTextCache", "width:%s hash:%s", Integer.valueOf(measureText), Integer.valueOf(caT()));
        return measureText + caT();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.wyk == aVar.wyk && this.mGH == aVar.mGH && this.jqT.equals(aVar.jqT) && caT() == aVar.caT()) {
            return true;
        }
        return false;
    }

    private int caT() {
        Iterator it = this.wyc.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((e) it.next()).caZ() + i;
        }
        return i;
    }
}
