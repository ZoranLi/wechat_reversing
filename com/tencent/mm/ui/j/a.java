package com.tencent.mm.ui.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import b.a.d.i;
import b.a.d.j;
import b.a.d.k;
import b.a.g.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.g.a.e;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"HandlerLeak"})
public final class a implements com.tencent.mm.ui.j.b.a {
    public Context context = null;
    public ae qpE = new ae(this) {
        final /* synthetic */ a wrz;

        {
            this.wrz = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1000) {
                String str = (String) message.obj;
                if (str != null) {
                    Context context = this.wrz.context;
                    com.tencent.mm.ui.j.b.a aVar = this.wrz;
                    if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                        e.A(context, "Error", "Application requires permission to access the Internet");
                    } else {
                        new b(context, str, aVar).show();
                    }
                } else {
                    this.wrz.c(c.Failed);
                }
            }
            if (message.what == 1010) {
                c cVar = (c) message.obj;
                a aVar2 = this.wrz;
                aVar2.wrw = false;
                if (cVar == c.Failed) {
                    aVar2.wru = null;
                    a.a(null);
                }
                if (aVar2.wry != null) {
                    aVar2.wry.b(cVar);
                }
            }
        }
    };
    public b.a.e.b wrs = null;
    public i wrt = null;
    public i wru = null;
    private boolean wrv = false;
    boolean wrw = false;
    public b wrx = null;
    public a wry = null;

    public interface a {
        void b(c cVar);
    }

    public interface b {
        void a(c cVar);
    }

    public enum c {
        Finished,
        Failed,
        Canceled
    }

    public a() {
        i iVar;
        b.a.a.a aVar = new b.a.a.a();
        aVar.xpn = b.a.a.a.D(b.a.a.a.c.a.class);
        String str = "XMr2y8FEVEqZBcZ1TU3gLA";
        d.ft(str, "Invalid Api key");
        aVar.xpk = str;
        str = "kyWwA5vbB6H1NDQFufR9hD5vWGStxhweIbatclCo";
        d.ft(str, "Invalid Api secret");
        aVar.xpl = str;
        str = "wechatapp://sign-in-twitter.wechatapp.com/";
        d.d(str, "Callback can't be null");
        aVar.xpm = str;
        d.d(aVar.xpn, "You must specify a valid api through the provider() method");
        d.ft(aVar.xpk, "You must provide an api key");
        d.ft(aVar.xpl, "You must provide an api secret");
        this.wrs = aVar.xpn.a(new b.a.d.a(aVar.xpk, aVar.xpl, aVar.xpm, aVar.xpo, aVar.scope, aVar.xpp));
        if (h.vG().uV()) {
            str = (String) h.vI().vr().get(69377, null);
            String str2 = (String) h.vI().vr().get(69378, null);
            iVar = (bg.mA(str) || bg.mA(str2)) ? null : new i(str, str2);
        } else {
            w.e("Twitter", "acchas not ready for restoreTwitterAccessToken");
            iVar = null;
        }
        this.wrt = iVar;
    }

    public final void a(b bVar, Context context) {
        if (!this.wrv) {
            g.oUh.a(583, 0, 1, false);
            this.wrx = bVar;
            this.context = context;
            this.wrv = true;
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ a wrz;

                {
                    this.wrz = r1;
                }

                public final void run() {
                    Object b;
                    try {
                        this.wrz.wru = this.wrz.wrs.ciL();
                        b = this.wrz.wrs.b(this.wrz.wru);
                    } catch (b.a.b.a e) {
                        b = null;
                    }
                    this.wrz.qpE.sendMessage(this.wrz.qpE.obtainMessage(1000, b));
                }
            }, "Twitter_doOAuth");
        }
    }

    public final boolean cam() {
        return this.wrt != null;
    }

    public final void a(a aVar) {
        if (!this.wrw) {
            this.wry = aVar;
            this.wrw = true;
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ a wrz;

                {
                    this.wrz = r1;
                }

                public final void run() {
                    Object obj = c.Finished;
                    if (this.wrz.wrt == null) {
                        obj = c.Failed;
                    } else {
                        b.a.d.c cVar = new b.a.d.c(j.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
                        this.wrz.wrs.a(this.wrz.wrt, cVar);
                        try {
                            if (cVar.ciG().code != m.CTRL_INDEX) {
                                obj = c.Failed;
                            }
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.Twitter", e, "request error.", new Object[0]);
                            obj = c.Failed;
                        }
                    }
                    this.wrz.qpE.sendMessage(this.wrz.qpE.obtainMessage(1010, obj));
                }
            }, "Twitter_validationAccessToken");
        }
    }

    public static void a(i iVar) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0);
        if (iVar == null) {
            h.vI().vr().set(69377, "");
            h.vI().vr().set(69378, "");
            return;
        }
        h.vI().vr().set(69377, iVar.token);
        h.vI().vr().set(69378, iVar.tPO);
    }

    public final void c(c cVar) {
        this.wrv = false;
        this.wru = null;
        if (this.wrx != null) {
            this.wrx.a(cVar);
        }
    }

    public final void m(final Bundle bundle) {
        h.vL().D(new Runnable(this) {
            final /* synthetic */ a wrz;

            public final void run() {
                i iVar = null;
                if (this.wrz.wru != null) {
                    a.lO(true);
                    String string = bundle.getString("oauth_verifier");
                    if (string != null) {
                        try {
                            iVar = this.wrz.wrs.a(this.wrz.wru, new k(string));
                        } catch (b.a.b.a e) {
                        }
                    }
                    if (iVar != null) {
                        this.wrz.wrt = iVar;
                        a.a(this.wrz.wrt);
                        new ae(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 wrB;

                            {
                                this.wrB = r1;
                            }

                            public final void run() {
                                this.wrB.wrz.c(c.Finished);
                                g.oUh.a(583, 1, 1, false);
                            }
                        });
                        return;
                    }
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 wrB;

                        {
                            this.wrB = r1;
                        }

                        public final void run() {
                            this.wrB.wrz.c(c.Failed);
                            g.oUh.a(583, 4, 1, false);
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|onComplete";
            }
        });
    }

    public final void can() {
        lO(false);
        c(c.Failed);
        g.oUh.a(583, 2, 1, false);
    }

    public final void onCancel() {
        lO(false);
        c(c.Canceled);
        g.oUh.a(583, 3, 1, false);
    }

    public static void lO(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ao.i.a(10251, z ? "1" : "2"));
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new com.tencent.mm.ao.i(arrayList));
    }
}
