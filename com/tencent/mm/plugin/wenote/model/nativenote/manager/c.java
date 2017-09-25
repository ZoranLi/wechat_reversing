package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.b;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c {
    public static volatile c svk = null;
    public ArrayList<a> jnH = null;
    public com.tencent.mm.plugin.wenote.model.nativenote.b.a svl = null;
    public rm svm = null;
    public int svn = 0;
    public int svo = 0;
    public int svp = 0;
    public boolean svq = false;

    private c() {
    }

    public static c bBv() {
        if (svk == null) {
            synchronized (c.class) {
                if (svk == null) {
                    svk = new c();
                }
            }
        }
        return svk;
    }

    public final int size() {
        return this.jnH != null ? this.jnH.size() : 0;
    }

    public final a wS(int i) {
        if (this.jnH == null || i < 0 || i >= this.jnH.size()) {
            return null;
        }
        return (a) this.jnH.get(i);
    }

    public final boolean a(a aVar) {
        boolean z = true;
        synchronized (this) {
            if (aVar != null) {
                if (this.jnH != null) {
                    this.jnH.add(aVar);
                    a(aVar, true);
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean a(int i, a aVar, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.jnH != null && i >= 0 && i <= this.jnH.size()) {
                this.jnH.add(i, aVar);
                z2 = true;
            }
        }
        if (z2 && z && this.svl != null) {
            this.svl.wO(i);
            if (i > 0) {
                this.svl.dA(i - 1, this.jnH.size() - (i - 1));
            } else {
                this.svl.dA(i, this.jnH.size() - i);
            }
        }
        return z2;
    }

    private boolean a(int i, a aVar) {
        if (aVar == null || this.jnH == null || i < 0 || i > this.jnH.size()) {
            return false;
        }
        this.jnH.add(i, aVar);
        a(aVar, true);
        return true;
    }

    public final boolean X(int i, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.jnH != null && i >= 0 && i < this.jnH.size()) {
                a((a) this.jnH.get(i), false);
                this.jnH.remove(i);
                z2 = true;
            }
        }
        if (z2 && z && this.svl != null) {
            this.svl.wP(i);
            if (i > 0) {
                this.svl.dA(i - 1, this.jnH.size() - (i - 1));
            } else {
                this.svl.dA(i, this.jnH.size() - i);
            }
        }
        return z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, com.tencent.mm.plugin.wenote.model.a.a r6) {
        /*
        r4 = this;
        r1 = 0;
        r2 = -1;
        monitor-enter(r4);
        r0 = r4.jnH;	 Catch:{ all -> 0x004a }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        monitor-exit(r4);	 Catch:{ all -> 0x004a }
    L_0x0008:
        return;
    L_0x0009:
        r1 = r1 + 1;
    L_0x000b:
        r0 = r4.jnH;	 Catch:{ all -> 0x004a }
        r0 = r0.size();	 Catch:{ all -> 0x004a }
        if (r1 >= r0) goto L_0x004d;
    L_0x0013:
        r0 = r4.jnH;	 Catch:{ all -> 0x004a }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004a }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x004a }
        r0 = r0.bBj();	 Catch:{ all -> 0x004a }
        r0 = r0.equals(r5);	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0009;
    L_0x0025:
        r0 = r4.jnH;	 Catch:{ all -> 0x004a }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004a }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x004a }
        r3 = 0;
        r4.a(r0, r3);	 Catch:{ all -> 0x004a }
        r0 = r4.jnH;	 Catch:{ all -> 0x004a }
        r0.set(r1, r6);	 Catch:{ all -> 0x004a }
        r0 = 1;
        r4.a(r6, r0);	 Catch:{ all -> 0x004a }
        r0 = r1;
    L_0x003b:
        monitor-exit(r4);	 Catch:{ all -> 0x004a }
        if (r0 == r2) goto L_0x0008;
    L_0x003e:
        r1 = r4.svl;
        if (r1 == 0) goto L_0x0008;
    L_0x0042:
        r1 = r4.svl;
        r2 = 0;
        r1.L(r0, r2);
        goto L_0x0008;
    L_0x004a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x004a }
        throw r0;
    L_0x004d:
        r0 = r2;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.lang.String, com.tencent.mm.plugin.wenote.model.a.a):void");
    }

    public final void bBw() {
        String str = "MicroMsg.WNNote.NoteDataManager";
        String str2 = "clear mDataList, size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.jnH != null ? this.jnH.size() : 0);
        w.i(str, str2, objArr);
        synchronized (this) {
            if (this.jnH != null) {
                this.jnH.clear();
            }
        }
        this.svp = 0;
        this.svo = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y(int r5, boolean r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.jnH;	 Catch:{ all -> 0x002e }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
    L_0x0006:
        return;
    L_0x0007:
        if (r5 < 0) goto L_0x0031;
    L_0x0009:
        r0 = r4.jnH;	 Catch:{ all -> 0x002e }
        r0 = r0.size();	 Catch:{ all -> 0x002e }
        if (r5 >= r0) goto L_0x0031;
    L_0x0011:
        r0 = r4.jnH;	 Catch:{ all -> 0x002e }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002e }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x002c;
    L_0x001b:
        r1 = r0.suA;	 Catch:{ all -> 0x002e }
        if (r1 == r6) goto L_0x002c;
    L_0x001f:
        r0.suA = r6;	 Catch:{ all -> 0x002e }
        r0 = r4.svl;	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x002c;
    L_0x0025:
        r0 = r4.svl;	 Catch:{ all -> 0x002e }
        r2 = 0;
        r0.L(r5, r2);	 Catch:{ all -> 0x002e }
    L_0x002c:
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        goto L_0x0006;
    L_0x002e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002e }
        throw r0;
    L_0x0031:
        r0 = -1;
        if (r5 != r0) goto L_0x002c;
    L_0x0034:
        r0 = 0;
        r1 = r0;
    L_0x0036:
        r0 = r4.jnH;	 Catch:{ all -> 0x002e }
        r0 = r0.size();	 Catch:{ all -> 0x002e }
        if (r1 >= r0) goto L_0x002c;
    L_0x003e:
        r0 = r4.jnH;	 Catch:{ all -> 0x002e }
        r0 = r0.get(r1);	 Catch:{ all -> 0x002e }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0059;
    L_0x0048:
        r2 = r0.suA;	 Catch:{ all -> 0x002e }
        if (r2 == r6) goto L_0x0059;
    L_0x004c:
        r0.suA = r6;	 Catch:{ all -> 0x002e }
        r0 = r4.svl;	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0059;
    L_0x0052:
        r0 = r4.svl;	 Catch:{ all -> 0x002e }
        r2 = 0;
        r0.L(r1, r2);	 Catch:{ all -> 0x002e }
    L_0x0059:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.Y(int, boolean):void");
    }

    public final int bBx() {
        int i;
        synchronized (this) {
            if (this.jnH != null) {
                for (int i2 = 0; i2 < this.jnH.size(); i2++) {
                    if (((a) this.jnH.get(i2)).sut) {
                        i = i2;
                        break;
                    }
                }
            }
            i = -1;
        }
        return i;
    }

    public final void bBy() {
        synchronized (this) {
            if (this.jnH != null) {
                Iterator it = this.jnH.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    aVar.sut = false;
                    aVar.suz = false;
                }
            }
        }
    }

    private void bBz() {
        if (this.jnH != null) {
            Iterator it = this.jnH.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                aVar.sut = false;
                aVar.suz = false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(int r4, boolean r5) {
        /*
        r3 = this;
        r0 = 0;
        monitor-enter(r3);
        r1 = r3.jnH;	 Catch:{ all -> 0x004d }
        if (r1 == 0) goto L_0x0010;
    L_0x0006:
        if (r4 < 0) goto L_0x0010;
    L_0x0008:
        r1 = r3.jnH;	 Catch:{ all -> 0x004d }
        r1 = r1.size();	 Catch:{ all -> 0x004d }
        if (r4 < r1) goto L_0x0012;
    L_0x0010:
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
    L_0x0011:
        return;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        r0 = r3.jnH;	 Catch:{ all -> 0x004d }
        r0 = r0.size();	 Catch:{ all -> 0x004d }
        if (r1 >= r0) goto L_0x0050;
    L_0x001b:
        if (r1 != r4) goto L_0x0036;
    L_0x001d:
        r0 = r3.jnH;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x004d }
        r2 = 1;
        r0.sut = r2;	 Catch:{ all -> 0x004d }
        r0 = r3.jnH;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x004d }
        r0.suz = r5;	 Catch:{ all -> 0x004d }
    L_0x0032:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0013;
    L_0x0036:
        r0 = r3.jnH;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x004d }
        r2 = 0;
        r0.sut = r2;	 Catch:{ all -> 0x004d }
        r0 = r3.jnH;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x004d }
        r2 = 0;
        r0.suz = r2;	 Catch:{ all -> 0x004d }
        goto L_0x0032;
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
        throw r0;
    L_0x0050:
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.Z(int, boolean):void");
    }

    public final int bBA() {
        int i;
        synchronized (this) {
            if (this.jnH != null) {
                int i2 = 0;
                while (i2 < this.jnH.size()) {
                    if (((a) this.jnH.get(i2)).getType() == 4 && ((h) this.jnH.get(i2)).suE.booleanValue()) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            i = -1;
        }
        return i;
    }

    public final String bBB() {
        String stringBuilder;
        synchronized (this) {
            if (this.svn == 0 && this.jnH != null) {
                Iterator it = this.jnH.iterator();
                while (it.hasNext()) {
                    k kVar = (k) ((a) it.next());
                    if (kVar.suI.startsWith("WeNote_")) {
                        int i = bg.getInt(kVar.suI.substring(7), -1);
                        if (i <= this.svn) {
                            i = this.svn;
                        }
                        this.svn = i;
                    }
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("WeNote_");
            int i2 = this.svn + 1;
            this.svn = i2;
            stringBuilder = stringBuilder2.append(i2).toString();
        }
        return stringBuilder;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String bBC() {
        /*
        r4 = this;
        r1 = "";
        monitor-enter(r4);
        r0 = r4.jnH;	 Catch:{ all -> 0x0141 }
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r4.jnH;	 Catch:{ all -> 0x0141 }
        r0 = r0.size();	 Catch:{ all -> 0x0141 }
        if (r0 > 0) goto L_0x0015;
    L_0x0010:
        r0 = "";
        monitor-exit(r4);	 Catch:{ all -> 0x0141 }
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = 0;
        r2 = r0;
    L_0x0017:
        r0 = r4.jnH;	 Catch:{ all -> 0x0141 }
        r0 = r0.size();	 Catch:{ all -> 0x0141 }
        if (r2 >= r0) goto L_0x0134;
    L_0x001f:
        r0 = r4.jnH;	 Catch:{ all -> 0x0141 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0141 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x0141 }
        r3 = r0.getType();	 Catch:{ all -> 0x0141 }
        switch(r3) {
            case 1: goto L_0x0034;
            case 2: goto L_0x00a8;
            case 3: goto L_0x00fc;
            case 4: goto L_0x00e0;
            case 5: goto L_0x0118;
            case 6: goto L_0x00c4;
            default: goto L_0x002e;
        };	 Catch:{ all -> 0x0141 }
    L_0x002e:
        r0 = r1;
    L_0x002f:
        r1 = r2 + 1;
        r2 = r1;
        r1 = r0;
        goto L_0x0017;
    L_0x0034:
        r0 = (com.tencent.mm.plugin.wenote.model.a.e) r0;	 Catch:{ all -> 0x0141 }
        r3 = r0.content;	 Catch:{ all -> 0x0141 }
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);	 Catch:{ all -> 0x0141 }
        if (r3 == 0) goto L_0x0053;
    L_0x003e:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r0.<init>();	 Catch:{ all -> 0x0141 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0141 }
        r1 = "<br/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.toString();	 Catch:{ all -> 0x0141 }
        goto L_0x002f;
    L_0x0053:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r3.<init>();	 Catch:{ all -> 0x0141 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.content;	 Catch:{ all -> 0x0141 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0141 }
        r1 = r0.toString();	 Catch:{ all -> 0x0141 }
        r0 = r2 + 1;
        r3 = r4.jnH;	 Catch:{ all -> 0x0141 }
        r3 = r3.size();	 Catch:{ all -> 0x0141 }
        if (r0 >= r3) goto L_0x002e;
    L_0x0070:
        r0 = r4.jnH;	 Catch:{ all -> 0x0141 }
        r3 = r2 + 1;
        r0 = r0.get(r3);	 Catch:{ all -> 0x0141 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.a) r0;	 Catch:{ all -> 0x0141 }
        r0 = r0.getType();	 Catch:{ all -> 0x0141 }
        r3 = 1;
        if (r0 != r3) goto L_0x002e;
    L_0x0081:
        r0 = r4.jnH;	 Catch:{ all -> 0x0141 }
        r3 = r2 + 1;
        r0 = r0.get(r3);	 Catch:{ all -> 0x0141 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.e) r0;	 Catch:{ all -> 0x0141 }
        r0 = r0.content;	 Catch:{ all -> 0x0141 }
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ all -> 0x0141 }
        if (r0 != 0) goto L_0x002e;
    L_0x0093:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r0.<init>();	 Catch:{ all -> 0x0141 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0141 }
        r1 = "<br/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.toString();	 Catch:{ all -> 0x0141 }
        goto L_0x002f;
    L_0x00a8:
        r0 = (com.tencent.mm.plugin.wenote.model.a.c) r0;	 Catch:{ all -> 0x0141 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r3.<init>();	 Catch:{ all -> 0x0141 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.suI;	 Catch:{ all -> 0x0141 }
        r3 = 2;
        r0 = cq(r0, r3);	 Catch:{ all -> 0x0141 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0141 }
        r0 = r0.toString();	 Catch:{ all -> 0x0141 }
        goto L_0x002f;
    L_0x00c4:
        r0 = (com.tencent.mm.plugin.wenote.model.a.g) r0;	 Catch:{ all -> 0x0141 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r3.<init>();	 Catch:{ all -> 0x0141 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.suI;	 Catch:{ all -> 0x0141 }
        r3 = 6;
        r0 = cq(r0, r3);	 Catch:{ all -> 0x0141 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0141 }
        r0 = r0.toString();	 Catch:{ all -> 0x0141 }
        goto L_0x002f;
    L_0x00e0:
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x0141 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r3.<init>();	 Catch:{ all -> 0x0141 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.suI;	 Catch:{ all -> 0x0141 }
        r3 = 4;
        r0 = cq(r0, r3);	 Catch:{ all -> 0x0141 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0141 }
        r0 = r0.toString();	 Catch:{ all -> 0x0141 }
        goto L_0x002f;
    L_0x00fc:
        r0 = (com.tencent.mm.plugin.wenote.model.a.d) r0;	 Catch:{ all -> 0x0141 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r3.<init>();	 Catch:{ all -> 0x0141 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.suI;	 Catch:{ all -> 0x0141 }
        r3 = 3;
        r0 = cq(r0, r3);	 Catch:{ all -> 0x0141 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0141 }
        r0 = r0.toString();	 Catch:{ all -> 0x0141 }
        goto L_0x002f;
    L_0x0118:
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0141 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0141 }
        r3.<init>();	 Catch:{ all -> 0x0141 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0141 }
        r0 = r0.suI;	 Catch:{ all -> 0x0141 }
        r3 = 5;
        r0 = cq(r0, r3);	 Catch:{ all -> 0x0141 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0141 }
        r0 = r0.toString();	 Catch:{ all -> 0x0141 }
        goto L_0x002f;
    L_0x0134:
        r0 = "\n";
        r2 = "<br/>";
        r0 = r1.replaceAll(r0, r2);	 Catch:{ all -> 0x0141 }
        monitor-exit(r4);	 Catch:{ all -> 0x0141 }
        goto L_0x0014;
    L_0x0141:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0141 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBC():java.lang.String");
    }

    private static String cq(String str, int i) {
        return String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[]{Integer.valueOf(i), str, str});
    }

    public final rv Lr(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.WNNote.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
            return null;
        }
        List arrayList = new ArrayList();
        synchronized (this) {
            int i = 0;
            while (i < this.jnH.size()) {
                a aVar = (a) this.jnH.get(i);
                if (bg.mA(aVar.lKv)) {
                    aVar.lKv = e.Lj(aVar.toString());
                }
                if ((aVar.getType() == 6 || aVar.getType() == 4) && bg.mA(((k) aVar).fQE)) {
                    rm rmVar = new rm();
                    rmVar.NY(aVar.lKv);
                    rmVar.NV(aVar.bBk());
                    String o = e.o(rmVar);
                    if (FileOp.aO(o)) {
                        w.e("MicroMsg.WNNote.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[]{Integer.valueOf(aVar.getType())});
                        ((k) aVar).fQE = o;
                    }
                }
                if (aVar.getType() != 1) {
                    arrayList.add((k) aVar);
                } else {
                    com.tencent.mm.plugin.wenote.model.a.e eVar = (com.tencent.mm.plugin.wenote.model.a.e) aVar;
                    com.tencent.mm.plugin.wenote.model.a.e eVar2;
                    if (!bg.mA(eVar.content)) {
                        if (arrayList.size() <= 0 || ((k) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                            eVar2 = new com.tencent.mm.plugin.wenote.model.a.e();
                            eVar2.content = eVar.content;
                            eVar2.lKv = eVar.lKv;
                            eVar2.suI = eVar.suI;
                            eVar2.type = eVar.type;
                            eVar2.suH = null;
                            arrayList.add(eVar2);
                        } else {
                            eVar2 = (com.tencent.mm.plugin.wenote.model.a.e) arrayList.get(arrayList.size() - 1);
                            eVar2.content += eVar.content;
                        }
                        if (i + 1 < this.jnH.size() && ((a) this.jnH.get(i + 1)).getType() == 1 && !bg.mA(((com.tencent.mm.plugin.wenote.model.a.e) this.jnH.get(i + 1)).content)) {
                            eVar = (com.tencent.mm.plugin.wenote.model.a.e) arrayList.get(arrayList.size() - 1);
                            eVar.content += "<br/>";
                        }
                    } else if (arrayList.size() <= 0 || ((k) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                        eVar2 = new com.tencent.mm.plugin.wenote.model.a.e();
                        eVar2.content = "<br/>";
                        eVar2.lKv = eVar.lKv;
                        eVar2.suI = eVar.suI;
                        eVar2.type = eVar.type;
                        eVar2.suH = null;
                        arrayList.add(eVar2);
                    } else {
                        eVar = (com.tencent.mm.plugin.wenote.model.a.e) arrayList.get(arrayList.size() - 1);
                        eVar.content += "<br/>";
                    }
                }
                i++;
            }
        }
        if (bg.mA(this.svm.lKv)) {
            this.svm.yb(8);
            this.svm.Oi("WeNoteHtmlFile");
            this.svm.jK(true);
            this.svm.NV(".htm");
            this.svm.NY(e.Lj(this.svm.toString()));
        }
        String o2 = e.o(this.svm);
        File file = new File(o2);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNote.NoteDataManager", e, "", new Object[0]);
                return null;
            }
        }
        byte[] bytes = str.getBytes();
        if (com.tencent.mm.a.e.b(o2, bytes, bytes.length) != 0) {
            return null;
        }
        this.svm.NZ(o2);
        w.i("MicroMsg.WNNote.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
        return b.a(str, arrayList, this.svm);
    }

    public final int a(a aVar, WXRTEditText wXRTEditText, boolean z, boolean z2) {
        if (aVar == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        return a(arrayList, wXRTEditText, true, true, z, z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.a> r11, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        /*
        r10 = this;
        r9 = 10;
        r2 = -1;
        r6 = 1;
        r4 = 0;
        if (r11 == 0) goto L_0x0011;
    L_0x0007:
        r1 = r11.size();
        if (r1 <= 0) goto L_0x0011;
    L_0x000d:
        r1 = r10.jnH;
        if (r1 != 0) goto L_0x001c;
    L_0x0011:
        r1 = "MicroMsg.WNNote.NoteDataManager";
        r3 = "insertItemList,error,return";
        com.tencent.mm.sdk.platformtools.w.e(r1, r3);
        r1 = r2;
    L_0x001b:
        return r1;
    L_0x001c:
        r1 = com.tencent.mm.plugin.wenote.model.a.bAZ();
        r1 = r1.stz;
        if (r1 != 0) goto L_0x002f;
    L_0x0024:
        r1 = "MicroMsg.WNNote.NoteDataManager";
        r3 = "insertItemList, but get wnnote base is null, return";
        com.tencent.mm.sdk.platformtools.w.e(r1, r3);
        r1 = r2;
        goto L_0x001b;
    L_0x002f:
        if (r15 == 0) goto L_0x0042;
    L_0x0031:
        r1 = r10.ab(r11);
        if (r1 == 0) goto L_0x0042;
    L_0x0037:
        r1 = r10.svl;
        if (r1 == 0) goto L_0x0042;
    L_0x003b:
        r1 = r10.svl;
        r1.bBq();
        r1 = r2;
        goto L_0x001b;
    L_0x0042:
        if (r13 == 0) goto L_0x0056;
    L_0x0044:
        r1 = r11.size();
        r1 = r1 + -1;
        r1 = r11.get(r1);
        r1 = (com.tencent.mm.plugin.wenote.model.a.a) r1;
        r1.suv = r2;
        r1.sut = r6;
        r1.suz = r4;
    L_0x0056:
        monitor-enter(r10);
        if (r12 != 0) goto L_0x008a;
    L_0x0059:
        r3 = r10.size();	 Catch:{ all -> 0x01f5 }
        r10.bBz();	 Catch:{ all -> 0x01f5 }
        r5 = r11.iterator();	 Catch:{ all -> 0x01f5 }
        r2 = r3;
    L_0x0065:
        r1 = r5.hasNext();	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x01ad;
    L_0x006b:
        r1 = r5.next();	 Catch:{ all -> 0x01f5 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.a) r1;	 Catch:{ all -> 0x01f5 }
        r10.b(r1);	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x021f;
    L_0x0076:
        r7 = r10.jnH;	 Catch:{ all -> 0x01f5 }
        if (r7 == 0) goto L_0x021f;
    L_0x007a:
        r7 = r10.jnH;	 Catch:{ all -> 0x01f5 }
        r7.add(r1);	 Catch:{ all -> 0x01f5 }
        r7 = 1;
        r10.a(r1, r7);	 Catch:{ all -> 0x01f5 }
        r1 = r6;
    L_0x0084:
        if (r1 == 0) goto L_0x021c;
    L_0x0086:
        r1 = r2 + 1;
    L_0x0088:
        r2 = r1;
        goto L_0x0065;
    L_0x008a:
        r5 = r12.bBN();	 Catch:{ all -> 0x01f5 }
        r3 = r10.wS(r5);	 Catch:{ all -> 0x01f5 }
        if (r3 != 0) goto L_0x0097;
    L_0x0094:
        monitor-exit(r10);	 Catch:{ all -> 0x01f5 }
        r1 = r2;
        goto L_0x001b;
    L_0x0097:
        r10.bBz();	 Catch:{ all -> 0x01f5 }
        r1 = r12.swa;	 Catch:{ all -> 0x01f5 }
        if (r1 != 0) goto L_0x0189;
    L_0x009e:
        r1 = r3.getType();	 Catch:{ all -> 0x01f5 }
        if (r1 != r6) goto L_0x0189;
    L_0x00a4:
        r1 = r12.getSelectionStart();	 Catch:{ all -> 0x01f5 }
        r2 = r12.getSelectionEnd();	 Catch:{ all -> 0x01f5 }
        r7 = new com.tencent.mm.plugin.wenote.model.nativenote.manager.e;	 Catch:{ all -> 0x01f5 }
        r7.<init>(r1, r2);	 Catch:{ all -> 0x01f5 }
        r2 = r12.getText();	 Catch:{ all -> 0x01f5 }
        r1 = 0;
        r8 = r7.abH;	 Catch:{ all -> 0x01f5 }
        r1 = r2.subSequence(r1, r8);	 Catch:{ all -> 0x01f5 }
        r7 = r7.wd;	 Catch:{ all -> 0x01f5 }
        r8 = r2.length();	 Catch:{ all -> 0x01f5 }
        r2 = r2.subSequence(r7, r8);	 Catch:{ all -> 0x01f5 }
        r7 = r1.length();	 Catch:{ all -> 0x01f5 }
        if (r7 <= r6) goto L_0x00e3;
    L_0x00cc:
        r7 = r1.length();	 Catch:{ all -> 0x01f5 }
        r7 = r7 + -1;
        r7 = r1.charAt(r7);	 Catch:{ all -> 0x01f5 }
        if (r7 != r9) goto L_0x00e3;
    L_0x00d8:
        r7 = 0;
        r8 = r1.length();	 Catch:{ all -> 0x01f5 }
        r8 = r8 + -1;
        r1 = r1.subSequence(r7, r8);	 Catch:{ all -> 0x01f5 }
    L_0x00e3:
        r7 = r2.length();	 Catch:{ all -> 0x01f5 }
        if (r7 <= r6) goto L_0x00f9;
    L_0x00e9:
        r7 = 0;
        r7 = r2.charAt(r7);	 Catch:{ all -> 0x01f5 }
        if (r7 != r9) goto L_0x00f9;
    L_0x00f0:
        r7 = 1;
        r8 = r2.length();	 Catch:{ all -> 0x01f5 }
        r2 = r2.subSequence(r7, r8);	 Catch:{ all -> 0x01f5 }
    L_0x00f9:
        r1 = (android.text.Spanned) r1;	 Catch:{ all -> 0x01f5 }
        r7 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x01f5 }
        r0 = r2;
        r0 = (android.text.Spanned) r0;	 Catch:{ all -> 0x01f5 }
        r1 = r0;
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x01f5 }
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r7);	 Catch:{ all -> 0x01f5 }
        if (r1 != 0) goto L_0x0151;
    L_0x010d:
        r0 = r3;
        r0 = (com.tencent.mm.plugin.wenote.model.a.e) r0;	 Catch:{ all -> 0x01f5 }
        r1 = r0;
        r1.content = r7;	 Catch:{ all -> 0x01f5 }
        r5 = r5 + 1;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r2);	 Catch:{ all -> 0x01f5 }
        if (r1 != 0) goto L_0x0186;
    L_0x011b:
        r1 = new com.tencent.mm.plugin.wenote.model.a.e;	 Catch:{ all -> 0x01f5 }
        r1.<init>();	 Catch:{ all -> 0x01f5 }
        r3 = 1;
        r1.type = r3;	 Catch:{ all -> 0x01f5 }
        r1.content = r2;	 Catch:{ all -> 0x01f5 }
        r2 = 0;
        r1.suv = r2;	 Catch:{ all -> 0x01f5 }
        r2 = 0;
        r1.sut = r2;	 Catch:{ all -> 0x01f5 }
        r2 = 0;
        r1.suz = r2;	 Catch:{ all -> 0x01f5 }
        r10.a(r5, r1);	 Catch:{ all -> 0x01f5 }
        r3 = r5;
        r4 = r6;
        r2 = r5;
    L_0x0134:
        r5 = r11.iterator();	 Catch:{ all -> 0x01f5 }
    L_0x0138:
        r1 = r5.hasNext();	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x01ad;
    L_0x013e:
        r1 = r5.next();	 Catch:{ all -> 0x01f5 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.a) r1;	 Catch:{ all -> 0x01f5 }
        r10.b(r1);	 Catch:{ all -> 0x01f5 }
        r1 = r10.a(r2, r1);	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x0219;
    L_0x014d:
        r1 = r2 + 1;
    L_0x014f:
        r2 = r1;
        goto L_0x0138;
    L_0x0151:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r2);	 Catch:{ all -> 0x01f5 }
        if (r1 != 0) goto L_0x015e;
    L_0x0157:
        r3 = (com.tencent.mm.plugin.wenote.model.a.e) r3;	 Catch:{ all -> 0x01f5 }
        r3.content = r2;	 Catch:{ all -> 0x01f5 }
        r3 = r5;
        r2 = r5;
        goto L_0x0134;
    L_0x015e:
        r1 = r10.jnH;	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x017d;
    L_0x0162:
        if (r5 < 0) goto L_0x017d;
    L_0x0164:
        r1 = r10.jnH;	 Catch:{ all -> 0x01f5 }
        r1 = r1.size();	 Catch:{ all -> 0x01f5 }
        if (r5 >= r1) goto L_0x017d;
    L_0x016c:
        r1 = r10.jnH;	 Catch:{ all -> 0x01f5 }
        r1 = r1.get(r5);	 Catch:{ all -> 0x01f5 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.a) r1;	 Catch:{ all -> 0x01f5 }
        r2 = 0;
        r10.a(r1, r2);	 Catch:{ all -> 0x01f5 }
        r1 = r10.jnH;	 Catch:{ all -> 0x01f5 }
        r1.remove(r5);	 Catch:{ all -> 0x01f5 }
    L_0x017d:
        r1 = r10.svl;	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x0186;
    L_0x0181:
        r1 = r10.svl;	 Catch:{ all -> 0x01f5 }
        r1.wP(r5);	 Catch:{ all -> 0x01f5 }
    L_0x0186:
        r3 = r5;
        r2 = r5;
        goto L_0x0134;
    L_0x0189:
        r1 = r12.swa;	 Catch:{ all -> 0x01f5 }
        if (r1 == r6) goto L_0x0216;
    L_0x018d:
        r3 = r5 + 1;
    L_0x018f:
        r5 = r11.iterator();	 Catch:{ all -> 0x01f5 }
        r2 = r3;
    L_0x0194:
        r1 = r5.hasNext();	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x01ad;
    L_0x019a:
        r1 = r5.next();	 Catch:{ all -> 0x01f5 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.a) r1;	 Catch:{ all -> 0x01f5 }
        r10.b(r1);	 Catch:{ all -> 0x01f5 }
        r1 = r10.a(r2, r1);	 Catch:{ all -> 0x01f5 }
        if (r1 == 0) goto L_0x0214;
    L_0x01a9:
        r1 = r2 + 1;
    L_0x01ab:
        r2 = r1;
        goto L_0x0194;
    L_0x01ad:
        monitor-exit(r10);	 Catch:{ all -> 0x01f5 }
        r1 = r2 + -1;
        if (r1 < 0) goto L_0x01f8;
    L_0x01b2:
        r1 = r2 + -1;
        r5 = bBv();
        r5 = r5.size();
        if (r1 >= r5) goto L_0x01f8;
    L_0x01be:
        r1 = r2 + -1;
    L_0x01c0:
        r5 = r10.svl;
        if (r5 == 0) goto L_0x001b;
    L_0x01c4:
        r2 = r2 - r3;
        if (r4 == 0) goto L_0x01c9;
    L_0x01c7:
        r2 = r2 + 1;
    L_0x01c9:
        if (r3 < 0) goto L_0x01d2;
    L_0x01cb:
        if (r2 <= 0) goto L_0x01d2;
    L_0x01cd:
        r4 = r10.svl;
        r4.dz(r3, r2);
    L_0x01d2:
        if (r3 <= 0) goto L_0x0203;
    L_0x01d4:
        r2 = r10.svl;
        r4 = r3 + -1;
        r5 = bBv();
        r5 = r5.size();
        r3 = r3 + -1;
        r3 = r5 - r3;
        r2.dA(r4, r3);
    L_0x01e7:
        if (r16 == 0) goto L_0x01ee;
    L_0x01e9:
        r2 = r10.svl;
        r2.bBp();
    L_0x01ee:
        r2 = r10.svl;
        r2.wQ(r1);
        goto L_0x001b;
    L_0x01f5:
        r1 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x01f5 }
        throw r1;
    L_0x01f8:
        r1 = bBv();
        r1 = r1.size();
        r1 = r1 + -1;
        goto L_0x01c0;
    L_0x0203:
        if (r3 != 0) goto L_0x01e7;
    L_0x0205:
        r2 = r10.svl;
        r4 = bBv();
        r4 = r4.size();
        r4 = r4 - r3;
        r2.dA(r3, r4);
        goto L_0x01e7;
    L_0x0214:
        r1 = r2;
        goto L_0x01ab;
    L_0x0216:
        r3 = r5;
        goto L_0x018f;
    L_0x0219:
        r1 = r2;
        goto L_0x014f;
    L_0x021c:
        r1 = r2;
        goto L_0x0088;
    L_0x021f:
        r1 = r4;
        goto L_0x0084;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.util.ArrayList, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, boolean, boolean, boolean, boolean):int");
    }

    private void b(a aVar) {
        if (aVar != null) {
            k kVar = (k) aVar;
            if (!(kVar.getType() == 0 || kVar.getType() == 1)) {
                if (bg.mA(kVar.suI)) {
                    if (this.svn == 0 && this.jnH != null) {
                        Iterator it = this.jnH.iterator();
                        while (it.hasNext()) {
                            k kVar2 = (k) ((a) it.next());
                            if (kVar2.suI.startsWith("WeNote_")) {
                                int i = bg.getInt(kVar2.suI.substring(7), -1);
                                if (i <= this.svn) {
                                    i = this.svn;
                                }
                                this.svn = i;
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("WeNote_");
                    int i2 = this.svn + 1;
                    this.svn = i2;
                    kVar.suI = stringBuilder.append(i2).toString();
                }
                b bVar = com.tencent.mm.plugin.wenote.model.a.bAZ().stz;
                if (bVar == null) {
                    w.e("MicroMsg.WNNote.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[]{aVar.toString()});
                } else if (bVar.stD == null) {
                    w.e("MicroMsg.WNNote.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[]{aVar.toString()});
                } else {
                    bVar.stD.put(kVar.suI, kVar);
                }
            }
            if (bg.mA(aVar.lKv)) {
                aVar.lKv = e.Lj(aVar.toString());
            }
        }
    }

    public final ArrayList<a> bBD() {
        if (this.jnH == null) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.jnH.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mm.plugin.wenote.b.b.c((a) it.next()));
            }
        }
        return arrayList;
    }

    public final boolean ab(ArrayList<a> arrayList) {
        Iterator it = arrayList.iterator();
        String str = "";
        int i = 0;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.getType() != 1) {
                i++;
            } else {
                str = str + ((com.tencent.mm.plugin.wenote.model.a.e) aVar).content;
            }
        }
        return F("", str, i);
    }

    public final boolean F(String str, String str2, int i) {
        int i2 = this.svp;
        int i3 = this.svo;
        if (i2 + i > 30) {
            return true;
        }
        if (i > 0 && i3 > 16384) {
            return true;
        }
        String str3 = "";
        if (!bg.mA(str)) {
            str3 = str3 + str;
        }
        if (!bg.mA(str2)) {
            Spanned Lq = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Lq(str2);
            if (Lq != null) {
                str3 = str3 + Lq.toString();
            }
        }
        for (int i4 = 0; i4 < str3.length(); i4++) {
            i3 += com.tencent.mm.plugin.wenote.b.b.i(str3.charAt(i4));
            if (i3 > 16384) {
                return true;
            }
        }
        return false;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            if (aVar.getType() == 1) {
                int Lw = com.tencent.mm.plugin.wenote.b.b.Lw(((com.tencent.mm.plugin.wenote.model.a.e) aVar).content);
                if (z) {
                    this.svo = Lw + this.svo;
                } else {
                    this.svo -= Lw;
                }
            } else if (z) {
                this.svp++;
            } else {
                this.svp--;
            }
        }
    }
}
