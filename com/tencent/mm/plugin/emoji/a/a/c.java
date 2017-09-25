package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.storage.ak;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c implements Cloneable, Iterable<f> {
    HashMap<String, ak> kIW;
    protected HashMap<String, ak> kIX;
    public boolean kIY;
    protected ArrayList<f> mItemList;

    private class a implements Iterator<f> {
        final /* synthetic */ c kIZ;
        private int mIndex = 0;

        public a(c cVar) {
            this.kIZ = cVar;
        }

        public final /* synthetic */ Object next() {
            c cVar = this.kIZ;
            int i = this.mIndex;
            this.mIndex = i + 1;
            return cVar.ln(i);
        }

        public final boolean hasNext() {
            return this.mIndex < this.kIZ.size();
        }

        public final void remove() {
        }
    }

    public /* synthetic */ Object clone() {
        return alr();
    }

    public void clear() {
        if (this.mItemList != null) {
            this.mItemList.clear();
            this.mItemList = null;
        }
        if (this.kIW != null) {
            this.kIW.clear();
            this.kIW = null;
        }
        if (this.kIX != null) {
            this.kIX.clear();
            this.kIX = null;
        }
    }

    public c(e eVar) {
        this(eVar == null ? null : eVar.kLM);
    }

    public c() {
        this.kIW = new HashMap();
        this.kIX = new HashMap();
        this.kIY = m.xX();
    }

    public c(List<f> list) {
        this();
        if (list != null) {
            this.mItemList = new ArrayList();
            this.mItemList.addAll(list);
        }
    }

    public final int size() {
        return this.mItemList == null ? 0 : this.mItemList.size();
    }

    public final f ln(int i) {
        if (this.mItemList == null || this.mItemList.size() <= i || i < 0 || this.mItemList == null) {
            return null;
        }
        return (f) this.mItemList.get(i);
    }

    public final f tU(String str) {
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                pn pnVar = fVar.kJb;
                if (pnVar != null && pnVar.tgW != null && pnVar.tgW.equals(str)) {
                    return fVar;
                }
            }
        }
        return null;
    }

    public final c alr() {
        try {
            c cVar = (c) super.clone();
            try {
                if (this.mItemList == null) {
                    return cVar;
                }
                cVar.mItemList = (ArrayList) this.mItemList.clone();
                return cVar;
            } catch (CloneNotSupportedException e) {
                return cVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void notifyDataSetChanged() {
        if (this.mItemList != null) {
            this.kIX = h.amc().kLb.bNf();
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                pn pnVar = fVar.kJb;
                if (pnVar != null) {
                    if (com.tencent.mm.plugin.emoji.h.a.d(pnVar)) {
                        fVar.dv(com.tencent.mm.plugin.emoji.h.a.anw() ? 7 : 3);
                    } else {
                        String str = pnVar.tgW;
                        fVar.a(this.kIY, tY(str), tW(str));
                    }
                }
            }
            als();
        }
    }

    public final void tV(String str) {
        f tU = tU(str);
        if (tU != null) {
            tU.dv(-1);
            tU.a(this.kIY, tY(str), tW(str));
        }
    }

    public final boolean tW(String str) {
        return this.kIX == null ? false : this.kIX.containsKey(str);
    }

    public final ak tX(String str) {
        ak tY = tY(str);
        if (tY != null) {
            return tY;
        }
        tY = new ak(str);
        this.kIW.put(str, tY);
        return tY;
    }

    public final ak tY(String str) {
        return (ak) this.kIW.get(str);
    }

    public Iterator<f> iterator() {
        return new a(this);
    }

    public void als() {
        if (this.mItemList != null && h.ame().kLK != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                pn pnVar = fVar.kJb;
                if (pnVar != null) {
                    Integer num = (Integer) h.ame().kLK.get(pnVar.tgW);
                    int intValue = num == null ? -1 : num.intValue();
                    if (intValue >= 0) {
                        fVar.dv(6);
                        fVar.sd = intValue;
                    }
                    if (intValue < 0 && fVar.mStatus == 6) {
                        fVar.dv(3);
                    }
                }
            }
        }
    }
}
