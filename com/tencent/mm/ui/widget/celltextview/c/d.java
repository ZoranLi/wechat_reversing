package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;

public final class d {
    public float wyA;
    private ArrayList<e> wyt;
    private ArrayList<RectF> wyu;
    public float wyv;
    public float wyw;
    public int wyx;
    public int wyy;
    public float wyz;

    public final void a(e eVar, RectF rectF) {
        if (this.wyt == null) {
            this.wyt = new ArrayList(1);
        }
        if (this.wyu == null) {
            this.wyu = new ArrayList(1);
        }
        this.wyt.add(eVar);
        this.wyu.add(rectF);
        this.wyv = (rectF.width() < 0.0f ? 0.0f : rectF.width()) + this.wyv;
        if (eVar.getType() == 0) {
            this.wyw = (float) ((int) rectF.height());
        } else if (eVar.getType() == 2 && this.wyw == 0.0f) {
            this.wyw = (float) ((int) rectF.height());
        }
    }

    public final void et(int i, int i2) {
        this.wyx = i;
        this.wyy = i2;
    }

    public final e Cz(int i) {
        if (i >= 0 && this.wyt != null) {
            return (e) this.wyt.get(i);
        }
        return null;
    }

    public final RectF CA(int i) {
        if (i >= 0 && this.wyu != null) {
            return (RectF) this.wyu.get(i);
        }
        return null;
    }

    public final void CB(int i) {
        if (this.wyt != null) {
            int size = this.wyt.size();
            if (i < size) {
                for (int i2 = 0; i2 < size - i; i2++) {
                    this.wyt.remove((size - i2) - 1);
                    RectF rectF = (RectF) this.wyu.remove((size - i2) - 1);
                    if (rectF != null) {
                        this.wyv -= rectF.width();
                        if (this.wyw >= rectF.height()) {
                            this.wyw = 0.0f;
                            Iterator it = this.wyt.iterator();
                            int i3 = 0;
                            while (it.hasNext()) {
                                e eVar = (e) it.next();
                                RectF rectF2 = (RectF) this.wyu.get(i3);
                                if (eVar.getType() == 0) {
                                    this.wyw = (float) ((int) rectF2.height());
                                } else if (eVar.getType() == 2 && this.wyw == 0.0f) {
                                    this.wyw = (float) ((int) rectF2.height());
                                }
                                i3++;
                            }
                        }
                    }
                }
            }
        }
    }

    public final int getSize() {
        if (this.wyt == null || this.wyu == null) {
            return 0;
        }
        int size = this.wyt.size();
        int size2 = this.wyu.size();
        return size >= size2 ? size2 : size;
    }
}
