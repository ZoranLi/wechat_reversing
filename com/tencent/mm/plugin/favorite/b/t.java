package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.sa;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class t {
    public HashMap<String, WeakReference<a>> hCU = new HashMap();
    public sc lEw = new sc();
    private HashSet<Integer> lEx = new HashSet();
    private boolean lEy = true;
    private List<sa> lEz = new LinkedList();

    public interface a {
        void ats();

        void att();
    }

    public t() {
        ap.yY();
        try {
            this.lEw.aD(bg.PT((String) c.vr().get(225283, "")));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            w.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", new Object[]{e.getMessage()});
            this.lEw = new sc();
        }
        w.i("MicroMsg.FavTagSetMgr", "tag:\n%s", new Object[]{this.lEw.tzv});
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.hCU.put(aVar.toString(), new WeakReference(aVar));
        }
    }

    private void dY(boolean z) {
        for (WeakReference weakReference : this.hCU.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    ((a) weakReference.get()).ats();
                } else {
                    ((a) weakReference.get()).att();
                }
            }
        }
    }

    private void save() {
        byte[] toByteArray;
        try {
            toByteArray = this.lEw.toByteArray();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            w.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", new Object[]{e.getMessage()});
            toByteArray = null;
        }
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ t lEB;

            public final void run() {
                String bo = bg.bo(toByteArray);
                ap.yY();
                c.vr().set(225283, bo);
            }

            public final String toString() {
                return super.toString() + "|save";
            }
        });
        this.lEy = true;
    }

    public final List<sa> mt(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        if (this.lEy) {
            w.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.lEz.clear();
            Iterator it = this.lEw.tzv.iterator();
            while (it.hasNext()) {
                this.lEz.addAll(((sb) it.next()).tzu);
            }
            this.lEy = false;
        }
        w.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", new Object[]{Integer.valueOf(this.lEz.size())});
        return this.lEz;
    }

    public final int atr() {
        Iterator it = this.lEw.tzv.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((sb) it.next()).tzu.size() + i;
        }
        return i;
    }

    public final void vU(final String str) {
        if (!bg.mA(str)) {
            if (this.lEx.contains(Integer.valueOf(str.hashCode()))) {
                w.d("MicroMsg.FavTagSetMgr", "has add tag %s", new Object[]{str});
                return;
            }
            this.lEx.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                w.d("MicroMsg.FavTagSetMgr", "add tag %s, post", new Object[]{str});
                af.v(new Runnable(this) {
                    final /* synthetic */ t lEB;

                    public final void run() {
                        this.lEB.vV(str);
                    }
                });
                return;
            }
            w.d("MicroMsg.FavTagSetMgr", "add tag %s", new Object[]{str});
            vV(str);
        }
    }

    public final void vV(String str) {
        int i;
        sb sbVar;
        sb sbVar2;
        sa saVar;
        int i2 = 0;
        String mp = com.tencent.mm.platformtools.c.mp(str.toLowerCase());
        if (mp == null || mp.length() <= 0) {
            i = 35;
        } else {
            i = mp.charAt(0);
        }
        Iterator it = this.lEw.tzv.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            sbVar = (sb) it.next();
            if (sbVar.tzt == i) {
                break;
            } else if (sbVar.tzt > i) {
                sbVar = new sb();
                sbVar.tzt = i;
                this.lEw.tzv.add(i3, sbVar);
                break;
            } else {
                i3++;
            }
        }
        sbVar = null;
        if (sbVar == null) {
            sbVar = new sb();
            sbVar.tzt = i;
            this.lEw.tzv.add(sbVar);
            sbVar2 = sbVar;
        } else {
            sbVar2 = sbVar;
        }
        Iterator it2 = sbVar2.tzu.iterator();
        while (it2.hasNext()) {
            int compareTo;
            saVar = (sa) it2.next();
            i3 = saVar.tzs.compareTo(mp);
            if (i3 == 0) {
                compareTo = saVar.sgP.compareTo(str);
            } else {
                compareTo = i3;
            }
            if (compareTo != 0) {
                if (compareTo > 0) {
                    saVar = new sa();
                    saVar.sgP = str;
                    saVar.tzs = mp;
                    sbVar2.tzu.add(i2, saVar);
                    save();
                    dY(true);
                    return;
                }
                i2++;
            } else {
                return;
            }
        }
        saVar = new sa();
        saVar.sgP = str;
        saVar.tzs = mp;
        sbVar2.tzu.add(saVar);
        dY(true);
        save();
    }

    public final void i(j jVar) {
        if (jVar != null) {
            for (String removeTag : jVar.field_tagProto.tzx) {
                removeTag(removeTag);
            }
        }
    }

    public final void d(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            w.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", new Object[]{set});
            for (String removeTag : set) {
                removeTag(removeTag);
            }
        }
    }

    private void removeTag(final String str) {
        if (!bg.mA(str)) {
            this.lEx.remove(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                w.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", new Object[]{str});
                af.v(new Runnable(this) {
                    final /* synthetic */ t lEB;

                    public final void run() {
                        this.lEB.vW(str);
                    }
                });
                return;
            }
            w.d("MicroMsg.FavTagSetMgr", "remove tag %s", new Object[]{str});
            vW(str);
        }
    }

    public final void vW(String str) {
        char c;
        sb sbVar;
        String mp = com.tencent.mm.platformtools.c.mp(str.toLowerCase());
        if (mp == null || mp.length() <= 0) {
            c = '#';
        } else {
            c = mp.charAt(0);
        }
        Iterator it = this.lEw.tzv.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb sbVar2 = (sb) it.next();
            if (sbVar2.tzt == c) {
                sbVar = sbVar2;
                break;
            } else if (sbVar2.tzt <= c) {
                i++;
            } else {
                return;
            }
        }
        sbVar = null;
        if (sbVar != null) {
            Iterator it2 = sbVar.tzu.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                sa saVar = (sa) it2.next();
                int compareTo = saVar.tzs.compareTo(mp);
                if (compareTo == 0) {
                    compareTo = saVar.sgP.compareTo(str);
                }
                if (compareTo == 0) {
                    int i3;
                    p asZ = h.asZ();
                    String str2 = saVar.sgP;
                    if (!bg.mA(str2)) {
                        w.d("MicroMsg.FavSearchStorage", "is tag exist sql {%s}", new Object[]{"select count(localId) from FavSearchInfo where tagContent like '%" + str2 + "%'"});
                        Cursor a = asZ.gUz.a(str2, null, 2);
                        if (a == null || !a.moveToFirst()) {
                            i3 = 0;
                        } else {
                            i3 = a.getInt(0);
                        }
                        if (a != null) {
                            a.close();
                        }
                        if (i3 > 0) {
                            i3 = 1;
                            if (i3 == 0) {
                                sbVar.tzu.remove(i2);
                                if (sbVar.tzu.isEmpty()) {
                                    this.lEw.tzv.remove(i);
                                }
                                dY(false);
                                save();
                                return;
                            }
                            return;
                        }
                    }
                    boolean z = false;
                    if (i3 == 0) {
                        sbVar.tzu.remove(i2);
                        if (sbVar.tzu.isEmpty()) {
                            this.lEw.tzv.remove(i);
                        }
                        dY(false);
                        save();
                        return;
                    }
                    return;
                } else if (compareTo <= 0) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
