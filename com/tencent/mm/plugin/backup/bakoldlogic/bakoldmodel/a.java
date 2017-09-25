package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.backup.bakoldlogic.a.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    public static int jJu = 8;
    public LinkedList<String> hNf;
    public final ae handler;
    public boolean htv = false;
    private final int jBq = -21;
    private LinkedList<String> jDn;
    public final b jJq;
    public final c jJr;
    private final a jJs;
    public ArrayList<com.tencent.mm.plugin.backup.bakoldlogic.a.a> jJt;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ a jJx;
        final /* synthetic */ PLong jJy;
        final /* synthetic */ PInt jJz;

        public AnonymousClass3(a aVar, PLong pLong, PInt pInt) {
            this.jJx = aVar;
            this.jJy = pLong;
            this.jJz = pInt;
        }

        public final void run() {
            this.jJx.jJr.a(this.jJx.jJt, this.jJy, this.jJz);
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ long jJA;
        final /* synthetic */ long jJB;
        final /* synthetic */ a jJx;

        public AnonymousClass4(a aVar, long j, long j2) {
            this.jJx = aVar;
            this.jJA = j;
            this.jJB = j2;
        }

        public final void run() {
            this.jJx.jJr.a(this.jJA, this.jJB, this.jJx.jJt, false);
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ a jJx;
        final /* synthetic */ PLong jJy;
        final /* synthetic */ PInt jJz;

        public AnonymousClass5(a aVar, PLong pLong, PInt pInt) {
            this.jJx = aVar;
            this.jJy = pLong;
            this.jJz = pInt;
        }

        public final void run() {
            this.jJx.jJr.a(this.jJx.jJt, this.jJy, this.jJz);
        }
    }

    public interface a {
        void m(int i, long j);
    }

    public interface b {
        void abO();

        void n(int i, long j);
    }

    public interface c {
        void a(long j, long j2, ArrayList<com.tencent.mm.plugin.backup.bakoldlogic.a.a> arrayList, boolean z);

        void a(ArrayList<com.tencent.mm.plugin.backup.bakoldlogic.a.a> arrayList, PLong pLong, PInt pInt);
    }

    public a(b bVar, c cVar) {
        this.jJq = bVar;
        this.jJr = cVar;
        this.jJs = null;
        this.handler = new ae(Looper.getMainLooper());
    }

    public final void cancel() {
        w.i("MicroMsg.BakCalculator", "calculator cancel.");
        w.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[]{bg.bJZ()});
        this.htv = true;
    }

    public final LinkedList<String> a(PLong pLong, PInt pInt) {
        if (pLong == null || pInt == null) {
            w.e("MicroMsg.BakCalculator", "calculConv backupDataSize or msgCount is null.");
            return null;
        }
        pInt.value = 0;
        pLong.value = 0;
        this.jDn = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor c = com.tencent.mm.plugin.backup.g.a.abC().abD().wW().c(o.hlr, d.aap(), "*");
        if (c.getCount() == 0) {
            c.close();
            return this.htv ? null : this.jDn;
        } else {
            c.moveToFirst();
            w.i("MicroMsg.BakCalculator", "calcItems userCnt at conv:%d", new Object[]{Integer.valueOf(c.getCount())});
            while (!this.htv) {
                aj aeVar = new com.tencent.mm.storage.ae();
                aeVar.b(c);
                if (!bg.mA(aeVar.field_username)) {
                    int Ax = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().Ax(aeVar.field_username);
                    w.i("MicroMsg.BakCalculator", "calculConv user:%s convMsgCount:%d", new Object[]{aeVar.field_username, Integer.valueOf(Ax)});
                    if (Ax > 0) {
                        pInt.value = Ax + pInt.value;
                        ap.yY();
                        if (!x.yC(com.tencent.mm.u.c.wR().Rc(aeVar.field_username).field_verifyFlag)) {
                            this.jDn.add(aeVar.field_username);
                        }
                    }
                }
                if (!c.moveToNext()) {
                    final PLong pLong2;
                    c.close();
                    String str = (String) com.tencent.mm.plugin.backup.g.a.abC().abD().vr().get(2, null);
                    Iterator it = this.jDn.iterator();
                    int i = 0;
                    int i2 = 0;
                    while (it.hasNext()) {
                        int i3;
                        Cursor Ar = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().Ar((String) it.next());
                        w.i("MicroMsg.BakCalculator", "calcItems user:%s msgCnt:%d[cu.getCount]", new Object[]{r12, Integer.valueOf(Ar.getCount())});
                        long j = pLong.value;
                        if (Ar.moveToFirst()) {
                            int i4 = i2;
                            int i5 = i;
                            while (!Ar.isAfterLast()) {
                                if (this.htv) {
                                    w.i("MicroMsg.BakCalculator", "calcItems cancel, return");
                                    Ar.close();
                                    return null;
                                }
                                au auVar = new au();
                                auVar.b(Ar);
                                try {
                                    com.tencent.mm.plugin.backup.e.a.a.a(auVar, true, str, pLong, null, null, false, false, 0);
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.BakCalculator", e, "packedMsg", new Object[0]);
                                }
                                i = i5 + 1;
                                i2 = (int) ((((long) i) * 100) / ((long) pInt.value));
                                w.i("MicroMsg.BakCalculator", "temPro, progress, tempCnt, msgCount.value:  %d, %d, %d, %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(pInt.value)});
                                if (this.jJq == null || i2 <= i4) {
                                    i2 = i4;
                                } else if (-1 == this.jBq) {
                                    this.jJs.m(i2, pLong.value);
                                } else if (-21 == this.jBq) {
                                    pLong2 = pLong;
                                    this.handler.post(new Runnable(this) {
                                        final /* synthetic */ a jJx;

                                        public final void run() {
                                            this.jJx.jJq.n(i2, pLong2.value);
                                        }
                                    });
                                }
                                Ar.moveToNext();
                                i4 = i2;
                                i5 = i;
                            }
                            i3 = i4;
                            i2 = i5;
                        } else {
                            i3 = i2;
                            i2 = i;
                        }
                        Ar.close();
                        w.i("MicroMsg.BakCalculator", "calc user:%s,  itemSize:%d, backupDataSize:%d, msgCount:%d", new Object[]{r12, Long.valueOf(pLong.value - j), Long.valueOf(pLong.value), Integer.valueOf(pInt.value)});
                        i = i2;
                        i2 = i3;
                    }
                    w.i("MicroMsg.BakCalculator", "calc all, backupDataSize:%d, msgCount:%d, userSize:%d", new Object[]{Long.valueOf(pLong.value), Integer.valueOf(pInt.value), Integer.valueOf(this.jDn.size())});
                    if (-1 == this.jBq) {
                        this.jJs.m(100, pLong.value);
                    } else if (-21 == this.jBq && this.jJq != null) {
                        pLong2 = pLong;
                        this.handler.post(new Runnable(this) {
                            final /* synthetic */ a jJx;

                            public final void run() {
                                this.jJx.jJq.n(100, pLong2.value);
                                this.jJx.jJq.abO();
                            }
                        });
                    }
                    w.d("MicroMsg.BakCalculator", "loading  " + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.htv) {
                        return null;
                    }
                    return this.jDn;
                }
            }
            c.close();
            return null;
        }
    }

    public final boolean a(PLong pLong, PInt pInt, String str, long j, PLong pLong2, String str2) {
        Cursor Ar = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().Ar(str2);
        w.i("MicroMsg.BakCalculator", "calConversation user:%s msgCnt:%d[cu.getCount]", new Object[]{str2, Integer.valueOf(Ar.getCount())});
        if (Ar.moveToFirst()) {
            com.tencent.mm.plugin.backup.bakoldlogic.a.a aVar = new com.tencent.mm.plugin.backup.bakoldlogic.a.a();
            aVar.jBh = str2;
            pLong.value = 0;
            pInt.value = 0;
            while (!Ar.isAfterLast()) {
                if (this.htv) {
                    w.i("MicroMsg.BakCalculator", "calcItemsToChoose cancel, return");
                    Ar.close();
                    e.n(this.jJt);
                    return true;
                }
                au auVar = new au();
                auVar.b(Ar);
                try {
                    com.tencent.mm.plugin.backup.e.a.a.a(auVar, true, str, pLong, null, null, false, false, 0);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.BakCalculator", e, "packedMsg", new Object[0]);
                }
                pInt.value++;
                Ar.moveToNext();
            }
            aVar.jBk = pLong.value;
            aVar.jBl = (long) pInt.value;
            this.jJt.add(aVar);
            pLong2.value++;
            w.i("MicroMsg.BakCalculator", "calcItemsToChoose calitem user:%s,  convDataSize:%d, convMsgCount:%d", new Object[]{str2, Long.valueOf(pLong.value), Integer.valueOf(pInt.value)});
        }
        if (this.jJr != null) {
            final long j2 = pLong2.value;
            final long j3 = j;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ a jJx;

                public final void run() {
                    if (j2 % ((long) a.jJu) == 0) {
                        this.jJx.jJr.a(j2, j3, this.jJx.jJt, true);
                    } else {
                        this.jJx.jJr.a(j2, j3, this.jJx.jJt, false);
                    }
                }
            });
        }
        Ar.close();
        return false;
    }
}
