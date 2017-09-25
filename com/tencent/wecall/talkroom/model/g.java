package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.pb.common.b.a.a.aj;
import com.tencent.pb.common.c.j;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g {
    public List<a> gJv = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    class AnonymousClass10 implements Runnable {
        final /* synthetic */ g xll;
        final /* synthetic */ int xln;

        AnonymousClass10(g gVar, int i) {
            this.xll = gVar;
            this.xln = i;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a Ee : this.xll.gJv) {
                    Ee.Ee(this.xln);
                }
            }
        }
    }

    class AnonymousClass12 implements Runnable {
        final /* synthetic */ boolean nZX;
        final /* synthetic */ g xll;

        AnonymousClass12(g gVar, boolean z) {
            this.xll = gVar;
            this.nZX = z;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a fN : this.xll.gJv) {
                    fN.fN(this.nZX);
                }
            }
        }
    }

    class AnonymousClass13 implements Runnable {
        final /* synthetic */ String xkQ;
        final /* synthetic */ g xll;
        final /* synthetic */ byte[] xlo;

        AnonymousClass13(g gVar, String str, byte[] bArr) {
            this.xll = gVar;
            this.xkQ = str;
            this.xlo = bArr;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a z : this.xll.gJv) {
                    z.z(this.xkQ, this.xlo);
                }
            }
        }
    }

    class AnonymousClass16 implements Runnable {
        final /* synthetic */ MultiTalkGroup nPE;
        final /* synthetic */ g xll;

        AnonymousClass16(g gVar, MultiTalkGroup multiTalkGroup) {
            this.xll = gVar;
            this.nPE = multiTalkGroup;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a b : this.xll.gJv) {
                    b.b(this.nPE);
                }
            }
        }
    }

    class AnonymousClass18 implements Runnable {
        final /* synthetic */ int fBw;
        final /* synthetic */ g xll;

        AnonymousClass18(g gVar, int i) {
            this.xll = gVar;
            this.fBw = i;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a Ed : this.xll.gJv) {
                    Ed.Ed(this.fBw);
                }
            }
        }
    }

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ List xlk;
        final /* synthetic */ g xll;

        AnonymousClass1(g gVar, List list) {
            this.xll = gVar;
            this.xlk = list;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a aU : this.xll.gJv) {
                    aU.aU(this.xlk);
                }
            }
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ MultiTalkGroup nPE;
        final /* synthetic */ g xll;

        AnonymousClass4(g gVar, MultiTalkGroup multiTalkGroup) {
            this.xll = gVar;
            this.nPE = multiTalkGroup;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a p : this.xll.gJv) {
                    p.p(this.nPE);
                }
            }
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ MultiTalkGroup nPE;
        final /* synthetic */ g xll;

        AnonymousClass5(g gVar, MultiTalkGroup multiTalkGroup) {
            this.xll = gVar;
            this.nPE = multiTalkGroup;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a q : this.xll.gJv) {
                    q.q(this.nPE);
                }
            }
        }
    }

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String xkQ;
        final /* synthetic */ g xll;
        final /* synthetic */ boolean xlm;

        AnonymousClass6(g gVar, String str, boolean z) {
            this.xll = gVar;
            this.xkQ = str;
            this.xlm = z;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                List<a> arrayList = new ArrayList(this.xll.gJv);
            }
            for (a bf : arrayList) {
                bf.bf(this.xkQ, this.xlm);
            }
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ int iJw;
        final /* synthetic */ g xll;

        AnonymousClass7(g gVar, int i) {
            this.xll = gVar;
            this.iJw = i;
        }

        public final void run() {
            synchronized (this.xll.gJv) {
                for (a onStateChanged : this.xll.gJv) {
                    onStateChanged.onStateChanged(this.iJw);
                }
            }
        }
    }

    public interface a {
        void Ed(int i);

        void Ee(int i);

        void a(int i, MultiTalkGroup multiTalkGroup);

        void aGO();

        void aU(List<aj> list);

        void b(MultiTalkGroup multiTalkGroup);

        void bf(String str, boolean z);

        void chA();

        void chy();

        void chz();

        void dc(List<MultiTalkGroup> list);

        void dm(String str, int i);

        void e(int i, Object obj);

        void fN(boolean z);

        void g(MultiTalkGroup multiTalkGroup);

        void onStateChanged(int i);

        void p(MultiTalkGroup multiTalkGroup);

        void q(MultiTalkGroup multiTalkGroup);

        void z(String str, byte[] bArr);
    }

    public final void dc(final List<MultiTalkGroup> list) {
        Runnable anonymousClass15 = new Runnable(this) {
            final /* synthetic */ g xll;

            public final void run() {
                synchronized (this.xll.gJv) {
                    for (a dc : this.xll.gJv) {
                        dc.dc(list);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass15.run();
        } else {
            this.handler.post(anonymousClass15);
        }
    }

    public final void a(final int i, final MultiTalkGroup multiTalkGroup) {
        Runnable anonymousClass17 = new Runnable(this) {
            final /* synthetic */ g xll;

            public final void run() {
                synchronized (this.xll.gJv) {
                    for (a a : this.xll.gJv) {
                        a.a(i, multiTalkGroup);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass17.run();
        } else {
            this.handler.post(anonymousClass17);
        }
    }

    public final void e(final int i, final Object obj) {
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ g xll;

            public final void run() {
                synchronized (this.xll.gJv) {
                    for (a e : this.xll.gJv) {
                        e.e(i, obj);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
        } else {
            this.handler.post(anonymousClass2);
        }
    }

    public final void g(final MultiTalkGroup multiTalkGroup) {
        Runnable anonymousClass3 = new Runnable(this) {
            final /* synthetic */ g xll;

            public final void run() {
                synchronized (this.xll.gJv) {
                    for (a g : this.xll.gJv) {
                        g.g(multiTalkGroup);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass3.run();
        } else {
            this.handler.post(anonymousClass3);
        }
    }

    public final void dm(final String str, final int i) {
        j.ac(new Runnable(this) {
            final /* synthetic */ g xll;

            public final void run() {
                synchronized (this.xll.gJv) {
                    for (a dm : this.xll.gJv) {
                        dm.dm(str, i);
                    }
                }
            }
        });
    }
}
