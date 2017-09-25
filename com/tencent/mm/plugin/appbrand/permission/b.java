package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.ahm;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class b {
    public static final LinkedList<Runnable> jfh = new LinkedList();
    public static final a jfi = new a();
    public static boolean jfj = false;
    public final String ivH;
    public final b jff;
    public final String jfg;

    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ b jfl;
        final /* synthetic */ String jfm;

        AnonymousClass3(b bVar, String str) {
            this.jfl = bVar;
            this.jfm = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.jfl.ak(this.jfm, 1);
            b.jfi.put(this.jfl.ivH, this.jfl.jfg);
            w.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", new Object[]{this.jfl.ivH, this.jfl.jfg});
            this.jfl.jff.Wi();
        }
    }

    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ b jfl;
        final /* synthetic */ String jfm;

        AnonymousClass4(b bVar, String str) {
            this.jfl = bVar;
            this.jfm = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.jfl.ak(this.jfm, 2);
            b.jfi.y(this.jfl.ivH, this.jfl.jfg);
            w.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", new Object[]{this.jfl.ivH, this.jfl.jfg});
            this.jfl.jff.Wj();
        }
    }

    private static final class a {
        final HashMap<String, HashSet<String>> jfp = new HashMap();

        final boolean bd(String str, String str2) {
            if (bg.mA(str) || bg.mA(str2)) {
                return false;
            }
            boolean z;
            synchronized (this) {
                HashSet hashSet = (HashSet) this.jfp.get(str);
                if (hashSet == null || !hashSet.contains(str2)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            return z;
        }

        final void put(String str, String str2) {
            if (!bg.mA(str) && !bg.mA(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.jfp.get(str);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        this.jfp.put(str, hashSet);
                    }
                    hashSet.add(str2);
                }
            }
        }

        final void y(String str, String str2) {
            if (!bg.mA(str) && !bg.mA(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.jfp.get(str);
                    if (hashSet != null) {
                        hashSet.remove(str2);
                    }
                }
            }
        }
    }

    public interface b {
        void Wi();

        void Wj();

        void onCancel();
    }

    private static final class c implements b {
        private final b jfq;

        public c(b bVar) {
            this.jfq = bVar;
        }

        public final void Wi() {
            if (this.jfq != null) {
                this.jfq.Wi();
            }
            Wk();
        }

        public final void Wj() {
            if (this.jfq != null) {
                this.jfq.Wj();
            }
            Wk();
        }

        public final void onCancel() {
            if (this.jfq != null) {
                this.jfq.onCancel();
            }
            Wk();
        }

        private void Wk() {
            d.vL().D(new Runnable(this) {
                final /* synthetic */ c jfr;

                {
                    this.jfr = r1;
                }

                public final void run() {
                    Runnable runnable = (Runnable) b.jfh.pollFirst();
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    w.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
                    b.jfj = false;
                }
            });
        }
    }

    private b(b bVar, String str, String str2) {
        this.jff = bVar;
        this.ivH = str;
        this.jfg = str2;
    }

    public final void ak(String str, final int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 1027;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-usersetauth";
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_aho = new aho();
        com_tencent_mm_protocal_c_aho.mtb = this.ivH;
        com_tencent_mm_protocal_c_aho.tlA = str;
        com_tencent_mm_protocal_c_aho.tLI = i;
        aVar.hsm = com_tencent_mm_protocal_c_aho;
        aVar.hsn = new ahp();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.BE(), new com.tencent.mm.ipcinvoker.wx_extension.b.a(this) {
            final /* synthetic */ b jfl;

            public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                if (i != 0 || i2 != 0 || bVar.hsk.hsr == null) {
                    w.e("MicroMsg.AppBrandJsApiUserAuth", "setAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                } else if (((ahp) bVar.hsk.hsr).tLL.fIz == 0 && 1 == i) {
                    w.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s", new Object[]{this.jfl.ivH, this.jfl.jfg});
                    b.jfi.put(this.jfl.ivH, this.jfl.jfg);
                }
            }
        });
    }

    public static boolean bc(String str, String str2) {
        return jfi.bd(str, str2);
    }

    public static void a(final String str, final String str2, final b bVar) {
        if (!bg.mA(str) && !bg.mA(str2)) {
            final Runnable anonymousClass6 = new Runnable() {
                public final void run() {
                    b.b(str, str2, new c(bVar));
                }
            };
            d.vL().D(new Runnable() {
                public final void run() {
                    if (b.jfj) {
                        b.jfh.add(anonymousClass6);
                        w.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[]{str, str2});
                        return;
                    }
                    b.jfj = true;
                    anonymousClass6.run();
                }
            });
        }
    }

    public static void b(String str, String str2, b bVar) {
        if (jfi.bd(str, str2)) {
            w.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", new Object[]{str, str2});
            bVar.Wi();
            return;
        }
        w.i("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", new Object[]{str, str2});
        b bVar2 = new b(bVar, str, str2);
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 1116;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-userauth";
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ahm = new ahm();
        com_tencent_mm_protocal_c_ahm.mtb = bVar2.ivH;
        com_tencent_mm_protocal_c_ahm.tLX = bVar2.jfg;
        aVar.hsm = com_tencent_mm_protocal_c_ahm;
        aVar.hsn = new ahn();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.BE(), new com.tencent.mm.ipcinvoker.wx_extension.b.a(bVar2) {
            final /* synthetic */ b jfl;

            {
                this.jfl = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                    b bVar2 = this.jfl;
                    ahn com_tencent_mm_protocal_c_ahn = (ahn) bVar.hsk.hsr;
                    w.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, appId %s, api %s, checkAuth Response.errcode %d", new Object[]{bVar2.ivH, bVar2.jfg, Integer.valueOf(com_tencent_mm_protocal_c_ahn.tLL.fIz)});
                    if (com_tencent_mm_protocal_c_ahn.tLL.fIz == 0) {
                        b.jfi.put(bVar2.ivH, bVar2.jfg);
                        bVar2.jff.Wi();
                        return;
                    } else if (com_tencent_mm_protocal_c_ahn.tLL.fIz != -12000) {
                        bVar2.jff.Wj();
                        return;
                    } else {
                        String str2 = com_tencent_mm_protocal_c_ahn.tlC;
                        String str3 = com_tencent_mm_protocal_c_ahn.tLY;
                        h mW = com.tencent.mm.plugin.appbrand.b.mW(bVar2.ivH);
                        com.tencent.mm.plugin.appbrand.ipc.a.a(mW == null ? null : mW.iws.getContext(), str2, "", ab.getResources().getString(R.l.dEI), ab.getResources().getString(R.l.dEJ), new AnonymousClass3(bVar2, str3), new AnonymousClass4(bVar2, str3), new OnClickListener(bVar2) {
                            final /* synthetic */ b jfl;

                            {
                                this.jfl = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.jfi.y(this.jfl.ivH, this.jfl.jfg);
                                w.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", new Object[]{this.jfl.ivH, this.jfl.jfg});
                                this.jfl.jff.onCancel();
                            }
                        });
                        return;
                    }
                }
                w.e("MicroMsg.AppBrandJsApiUserAuth", "checkAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                b.jfi.y(this.jfl.ivH, this.jfl.jfg);
                this.jfl.jff.Wj();
            }
        });
    }
}
