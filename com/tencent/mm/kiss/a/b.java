package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b gZK;
    public LayoutInflater Du;
    public ConcurrentHashMap<String, c> gZJ = new ConcurrentHashMap();
    public Looper gZL;
    public ae gZM;
    public boolean gZN = false;
    public boolean gZO = false;
    public b gZP;
    public int mMode = 2;

    private static final class a implements OnAttachStateChangeListener {
        private String gZR;
        private b gZS;
        private c gZT = null;

        public a(String str, b bVar, c cVar) {
            this.gZR = str;
            this.gZS = bVar;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onViewDetachedFromWindow(android.view.View r5) {
            /*
            r4 = this;
            r0 = r4.gZS;
            r0 = r0.gZJ;
            r1 = r4.gZR;
            r0 = r0.get(r1);
            r0 = (com.tencent.mm.kiss.a.c) r0;
            r1 = r4.gZS;
            r1 = r1.mMode;
            r2 = 1;
            if (r1 != r2) goto L_0x0036;
        L_0x0013:
            if (r0 == 0) goto L_0x0025;
        L_0x0015:
            monitor-enter(r0);
            r1 = r0.hac;	 Catch:{ all -> 0x0033 }
            r1.remove(r5);	 Catch:{ all -> 0x0033 }
            r1 = r0.hab;	 Catch:{ all -> 0x0033 }
            r1.add(r5);	 Catch:{ all -> 0x0033 }
            monitor-exit(r0);	 Catch:{ all -> 0x0033 }
            r0 = r4.gZT;
            if (r0 == 0) goto L_0x0025;
        L_0x0025:
            r5.removeOnAttachStateChangeListener(r4);
            r0 = r4.gZS;
            r0 = r0.gZP;
            r1 = r0.init();	 Catch:{ Throwable -> 0x004b }
            if (r1 != 0) goto L_0x003c;
        L_0x0032:
            return;
        L_0x0033:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0033 }
            throw r1;
        L_0x0036:
            r1 = r4.gZS;
            r1.a(r0);
            goto L_0x0025;
        L_0x003c:
            r1 = r0.mHandler;
            r2 = 0;
            r1.removeCallbacksAndMessages(r2);
            r0 = r0.mHandler;
            r1 = 0;
            r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r0.sendEmptyMessageDelayed(r1, r2);
            goto L_0x0032;
        L_0x004b:
            r0 = move-exception;
            goto L_0x0032;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kiss.a.b.a.onViewDetachedFromWindow(android.view.View):void");
        }
    }

    private static final class b {
        Class gZU;
        Field gZV;
        Class gZW;
        Field gZX = null;
        private boolean gZY = false;
        private boolean gZZ = false;
        ae mHandler;

        public b(Looper looper) {
            this.mHandler = new ae(this, looper) {
                final /* synthetic */ b haa;

                public final void handleMessage(Message message) {
                    long nanoTime;
                    try {
                        nanoTime = System.nanoTime();
                        b bVar = this.haa;
                        ThreadLocal threadLocal = (ThreadLocal) bVar.gZV.get(null);
                        if (threadLocal != null) {
                            Object obj = threadLocal.get();
                            if (obj != null) {
                                try {
                                    obj = bVar.gZX.get(obj);
                                    if (obj != null) {
                                        if (obj instanceof List) {
                                            ((List) obj).clear();
                                        }
                                    }
                                } catch (Throwable e) {
                                    w.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                                }
                            }
                        }
                    } catch (Throwable e2) {
                        w.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                    } catch (Throwable th) {
                        return;
                    }
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    w.i("KISS.InflateRecycler", "durtion %s", Long.valueOf(nanoTime2));
                }
            };
        }

        final boolean init() {
            if (this.gZY) {
                return this.gZZ;
            }
            this.gZY = true;
            try {
                this.gZU = Class.forName("android.view.ViewRootImpl");
                try {
                    this.gZV = this.gZU.getDeclaredField("sRunQueues");
                    this.gZV.setAccessible(true);
                    try {
                        this.gZW = Class.forName("android.view.ViewRootImpl$RunQueue");
                        try {
                            this.gZX = this.gZW.getDeclaredField("mActions");
                            this.gZX.setAccessible(true);
                            this.gZZ = true;
                            return true;
                        } catch (Throwable e) {
                            w.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                            return false;
                        }
                    } catch (Throwable e2) {
                        w.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable e22) {
                    w.printErrStackTrace("KISS.InflateRecycler", e22, "", new Object[0]);
                    return false;
                }
            } catch (Throwable e222) {
                w.printErrStackTrace("KISS.InflateRecycler", e222, "", new Object[0]);
                return false;
            }
        }
    }

    public interface c {
    }

    class AnonymousClass1 extends ae {
        final /* synthetic */ b gZQ;

        public AnonymousClass1(b bVar, Looper looper) {
            this.gZQ = bVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            w.i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
            c cVar = (c) message.obj;
            int size = cVar.had - cVar.hab.size();
            int i = cVar.Ds;
            for (int i2 = 0; i2 < size; i2++) {
                View inflate = this.gZQ.Du.inflate(i, null);
                synchronized (cVar) {
                    cVar.hab.add(inflate);
                }
                if (!(cVar.hae == null || cVar.hae.length == 0)) {
                    for (int i3 = 0; i3 < cVar.hae.length; i3 += 2) {
                        View findViewById = inflate.findViewById(cVar.hae[i3]);
                        if (findViewById != null && (findViewById instanceof ViewStub)) {
                            int i4 = cVar.hae[i3 + 1];
                            if (i4 != 0) {
                                ((ViewStub) findViewById).setLayoutResource(i4);
                            }
                            ((ViewStub) findViewById).inflate();
                        }
                    }
                }
            }
            w.i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
            w.i("KISS.InflateRecycler", "preload done");
        }
    }

    static {
        gZK = null;
        gZK = new b();
    }

    public static b vS() {
        return gZK;
    }

    public final View a(Activity activity, String str, int i) {
        if (this.gZO) {
            w.i("KISS.InflateRecycler", "not support application inflate");
            return activity.getLayoutInflater().inflate(i, null);
        }
        c cVar = (c) this.gZJ.get(str);
        if (cVar != null) {
            View view;
            synchronized (cVar) {
                view = (View) cVar.hab.poll();
                if (this.mMode == 1) {
                    cVar.hac.add(view);
                }
            }
            if (view != null) {
                w.i("KISS.InflateRecycler", "cache reach");
                view.addOnAttachStateChangeListener(new a(str, this, null));
                return view;
            }
        }
        w.i("KISS.InflateRecycler", "no cache reach");
        return this.Du.inflate(i, null);
    }

    public final boolean a(String str, int i, int... iArr) {
        if (!this.gZN) {
            return false;
        }
        if (this.gZO) {
            w.i("KISS.InflateRecycler", "not support application inflate");
            return false;
        } else if (((c) this.gZJ.get(str)) != null) {
            return false;
        } else {
            c cVar = new c();
            this.gZJ.put(str, cVar);
            cVar.had = 6;
            cVar.gZR = str;
            cVar.Ds = i;
            cVar.hae = iArr;
            this.gZM.sendMessage(this.gZM.obtainMessage(0, cVar));
            return true;
        }
    }

    public final void a(c cVar) {
        if (this.gZN && !this.gZO && cVar.had > cVar.hab.size()) {
            this.gZM.sendMessage(this.gZM.obtainMessage(0, cVar));
        }
    }
}
