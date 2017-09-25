package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.pluginsdk.l.p;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i {
    public List<p> gJv = new LinkedList();
    ae handler = new ae(Looper.getMainLooper());

    class AnonymousClass10 implements Runnable {
        final /* synthetic */ String nct;
        final /* synthetic */ String ncu;
        final /* synthetic */ i qYV;

        AnonymousClass10(i iVar, String str, String str2) {
            this.qYV = iVar;
            this.nct = str;
            this.ncu = str2;
        }

        public final void run() {
            synchronized (this.qYV.gJv) {
                for (p cI : this.qYV.gJv) {
                    cI.cI(this.nct, this.ncu);
                }
            }
        }
    }

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String kuJ;
        final /* synthetic */ i qYV;

        AnonymousClass11(i iVar, String str) {
            this.qYV = iVar;
            this.kuJ = str;
        }

        public final void run() {
            synchronized (this.qYV.gJv) {
                Iterator it = this.qYV.gJv.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    public final void aGO() {
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ i qYV;

            {
                this.qYV = r1;
            }

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p aGO : this.qYV.gJv) {
                        aGO.aGO();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass1.run();
        } else {
            this.handler.post(anonymousClass1);
        }
    }

    public final void C(final String str, final int i, final int i2) {
        Runnable anonymousClass5 = new Runnable(this) {
            final /* synthetic */ i qYV;

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p C : this.qYV.gJv) {
                        C.C(str, i, i2);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass5.run();
        } else {
            this.handler.post(anonymousClass5);
        }
    }

    public final void oE(final int i) {
        Runnable anonymousClass7 = new Runnable(this) {
            final /* synthetic */ i qYV;

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p oE : this.qYV.gJv) {
                        oE.oE(i);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass7.run();
        } else {
            this.handler.post(anonymousClass7);
        }
    }

    public final void zC(final String str) {
        Runnable anonymousClass8 = new Runnable(this) {
            final /* synthetic */ i qYV;

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p zC : this.qYV.gJv) {
                        zC.zC(str);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass8.run();
        } else {
            this.handler.post(anonymousClass8);
        }
    }

    public final void k(final int i, final int i2, final String str) {
        Runnable anonymousClass9 = new Runnable(this) {
            final /* synthetic */ i qYV;

            public final void run() {
                synchronized (this.qYV.gJv) {
                    for (p k : this.qYV.gJv) {
                        k.k(i, i2, str);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass9.run();
        } else {
            this.handler.post(anonymousClass9);
        }
    }
}
