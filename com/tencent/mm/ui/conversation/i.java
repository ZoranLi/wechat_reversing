package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.gc;
import com.tencent.mm.e.a.hz;
import com.tencent.mm.e.a.li;
import com.tencent.mm.e.a.qt;
import com.tencent.mm.modelmulti.g;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.dbbackup.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.io.File;

public final class i implements e, f {
    private static boolean wdV = false;
    public Activity fPi;
    public ProgressDialog isv = null;
    WakeLock wakeLock = null;
    public h wdP = null;
    public volatile boolean wdQ;
    public boolean wdR = false;
    public com.tencent.mm.compatible.util.g.a wdS = new com.tencent.mm.compatible.util.g.a();
    boolean wdT = false;
    public g wdU = null;
    a wdW;
    a wdX;
    c wdY = new c<li>(this) {
        final /* synthetic */ i web;

        {
            this.web = r2;
            this.usg = li.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ((li) bVar).fSi.fSj = this.web.bYI();
            return false;
        }
    };
    c wdZ = new c<qt>(this) {
        final /* synthetic */ i web;

        {
            this.web = r2;
            this.usg = qt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return bYJ();
        }

        private boolean bYJ() {
            if (this.web.fPi == null) {
                w.i("MicroMsg.InitHelper", "inithelper hasn't initialized");
            } else {
                this.web.wdR = false;
                this.web.bYG();
            }
            return false;
        }
    };
    FLock wea;

    public interface a {
        void bYK();

        void bYL();
    }

    final boolean bYF() {
        if (!m.Hv()) {
            return false;
        }
        if (this.wdP != null && this.wdP.isShowing()) {
            return false;
        }
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.e vI = com.tencent.mm.kernel.h.vI();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vG().uQ();
        boolean z = bg.mz((String) vI.gYi.get(8195, null)).length() <= 0 || bg.f((Integer) vI.gYi.get(15, null)) == 0;
        if (!z || vI.vn() == null) {
            z = false;
        } else {
            z = true;
        }
        this.wdQ = z;
        if (this.wdQ) {
            this.wdP = new com.tencent.mm.ui.base.h.a(this.fPi).zW(R.l.ebk).SX(this.fPi.getString(R.l.ebj)).kK(false).zZ(R.l.ebl).a(new OnClickListener(this) {
                final /* synthetic */ i web;

                {
                    this.web = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.web.wdP.dismiss();
                    this.web.bYG();
                }
            }).Aa(R.l.ebi).b(new OnClickListener(this) {
                final /* synthetic */ i web;

                {
                    this.web = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.web.wdP.dismiss();
                    this.web.wdQ = false;
                    this.web.bYG();
                }
            }).WJ();
            this.wdP.show();
            com.tencent.mm.kernel.h.vJ();
            new File(com.tencent.mm.kernel.h.vI().cachePath, "EnMicroMsg.db.corrupt").delete();
        } else {
            bYG();
        }
        return true;
    }

    public final void bYG() {
        if (this.wdR) {
            w.i("MicroMsg.InitHelper", "summerinit doInit but hasTryDoInitButFailed true ret");
            return;
        }
        if (!this.wakeLock.isHeld()) {
            w.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
            this.wakeLock.acquire();
        }
        this.wdX.bYK();
        if (this.wdQ) {
            ((d) ap.yR().gs("plugin.dbbackup")).b(new com.tencent.mm.plugin.dbbackup.b(this) {
                final /* synthetic */ i web;

                {
                    this.web = r1;
                }

                public final void kZ(final int i) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 wec;

                        public final void run() {
                            if (i == -2) {
                                Toast.makeText(this.wec.web.fPi, R.l.eIT, 1).show();
                            } else if (i == 0) {
                                Toast.makeText(this.wec.web.fPi, R.l.eIU, 0).show();
                            } else {
                                Toast.makeText(this.wec.web.fPi, R.l.eIQ, 1).show();
                            }
                        }
                    });
                    this.web.wdQ = false;
                    if (this.web.wdU == null) {
                        if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                            com.tencent.mm.plugin.sns.b.m.pQB.bdu();
                        }
                        this.web.wdU = new g(this.web);
                        w.d("MicroMsg.InitHelper", "dkinit doInit t:%d initScene:%d", Long.valueOf(this.web.wdS.se()), Integer.valueOf(this.web.wdU.hashCode()));
                        this.web.wdS.gSO = SystemClock.elapsedRealtime();
                        ap.vd().a(this.web.wdU, 0);
                    }
                }
            });
        } else if (this.wdU == null) {
            if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                com.tencent.mm.plugin.sns.b.m.pQB.bdu();
            }
            this.wdU = new g(this);
            w.d("MicroMsg.InitHelper", "dkinit doInit t:%d initScene:%d", Long.valueOf(this.wdS.se()), Integer.valueOf(this.wdU.hashCode()));
            this.wdS.gSO = SystemClock.elapsedRealtime();
            ap.vd().a(this.wdU, 0);
        }
        af.v(new Runnable(this) {
            final /* synthetic */ i web;

            {
                this.web = r1;
            }

            public final void run() {
                String str = "MicroMsg.InitHelper";
                String str2 = "dkinit showProgressDlg t:%d initScene:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(this.web.wdS.se());
                objArr[1] = Integer.valueOf(this.web.wdU == null ? -2 : this.web.wdU.hashCode());
                w.d(str, str2, objArr);
                if (this.web.isv != null && this.web.isv.isShowing()) {
                    this.web.isv.dismiss();
                }
                i iVar;
                Context context;
                if (this.web.wdQ) {
                    iVar = this.web;
                    context = this.web.fPi;
                    this.web.fPi.getString(R.l.dIO);
                    iVar.isv = com.tencent.mm.ui.base.g.a(context, this.web.fPi.getString(R.l.eIR), false, null);
                } else {
                    iVar = this.web;
                    context = this.web.fPi;
                    this.web.fPi.getString(R.l.dIO);
                    iVar.isv = com.tencent.mm.ui.base.g.a(context, this.web.fPi.getString(R.l.dHA), false, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass10 wed;

                        {
                            this.wed = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(this.wed.web.wdU);
                            if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                                com.tencent.mm.plugin.sns.b.m.pQB.bdv();
                            }
                        }
                    });
                }
                ap.vL().bJi();
            }
        });
    }

    public final void a(int i, int i2, k kVar) {
        if (kVar != null && kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX) {
            final int i3 = (int) (i2 != 0 ? (((long) i) * 100) / ((long) i2) : 0);
            af.v(new Runnable(this) {
                final /* synthetic */ i web;

                public final void run() {
                    if (!this.web.wdQ && this.web.isv != null) {
                        this.web.isv.setMessage(this.web.fPi.getString(R.l.dHA) + i3 + "%");
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 138 || kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX) {
            int i3;
            String str2 = "MicroMsg.InitHelper";
            String str3 = "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(kVar.getType());
            objArr[4] = Integer.valueOf(hashCode());
            if (this.wdU == null) {
                i3 = -2;
            } else {
                i3 = this.wdU.hashCode();
            }
            objArr[5] = Integer.valueOf(i3);
            w.i(str2, str3, objArr);
            if (this.wdU != null && kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX) {
                this.wdU = null;
                w.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", Long.valueOf(this.wdS.se()));
                com.tencent.mm.u.ag.a.hlS.a(null, null, null);
                if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                    com.tencent.mm.plugin.sns.b.m.pQB.bdv();
                }
                this.wdX.bYL();
                if (this.wakeLock.isHeld()) {
                    w.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
                    this.wakeLock.release();
                }
                ap.vL().bJk();
                if (this.isv != null) {
                    this.isv.dismiss();
                    this.isv = null;
                }
            }
            if (p.a(this.fPi, i, i2, new Intent().setClass(this.fPi, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                w.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
            } else if (ap.zb()) {
                if (!this.wdT) {
                    this.wdT = true;
                    ap.yY();
                    str2 = (String) com.tencent.mm.u.c.vr().get(5, null);
                    ap.yY();
                    if ((((Integer) com.tencent.mm.u.c.vr().get(57, Integer.valueOf(0))).intValue() != 0) && str2 != null) {
                        com.tencent.mm.ui.base.g.a(this.fPi, this.fPi.getString(R.l.eJD, new Object[]{str2}), this.fPi.getString(R.l.dIO), this.fPi.getString(R.l.eJF), this.fPi.getString(R.l.eJE), new OnClickListener(this) {
                            final /* synthetic */ i web;

                            {
                                this.web = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.setClassName(this.web.fPi, "com.tencent.mm.ui.account.RegByFacebookSetPwdUI");
                                this.web.fPi.startActivity(intent);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ i web;

                            {
                                this.web = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                }
                if (i == 4 && i2 == -17 && !wdV) {
                    q.Hy().gg(7);
                    wdV = true;
                }
                if (X(i, i2, kVar.getType())) {
                    w.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
                    return;
                }
                if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX) {
                    b hzVar = new hz();
                    if (i == 3 && i2 == -1) {
                        this.wdR = true;
                        hzVar.fND.fMu = false;
                        com.tencent.mm.sdk.b.a.urY.m(hzVar);
                        this.wdW.bYs();
                    } else {
                        hzVar.fND.fMu = true;
                        com.tencent.mm.sdk.b.a.urY.m(hzVar);
                    }
                }
                if (!com.tencent.mm.ui.p.a.a(this.fPi, i, i2, str, 4)) {
                    if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX) {
                        new ae().post(new Runnable(this) {
                            final /* synthetic */ i web;

                            {
                                this.web = r1;
                            }

                            public final void run() {
                                q.Hy().gg(5);
                            }
                        });
                        if ((com.tencent.mm.u.m.xR() & FileUtils.S_IWUSR) != 0) {
                            ap.yY();
                            if (com.tencent.mm.u.c.wW().Rm("masssendapp") == null) {
                                com.tencent.mm.storage.ae aeVar = new com.tencent.mm.storage.ae();
                                aeVar.setUsername("masssendapp");
                                aeVar.setContent(ab.getContext().getResources().getString(R.l.dYJ));
                                aeVar.s(u.Nz() + 2000);
                                aeVar.dw(0);
                                aeVar.dt(0);
                                ap.yY();
                                com.tencent.mm.u.c.wW().d(aeVar);
                                i3 = com.tencent.mm.u.m.xR() & -129;
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(40, Integer.valueOf(i3));
                            }
                        }
                    }
                    if (kVar.getType() == 138 || kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ i web;

                            {
                                this.web = r1;
                            }

                            public final void run() {
                                b gcVar = new gc();
                                gcVar.fLs.data = "MAIN_UI_EVENT_INIT_FINALLY";
                                com.tencent.mm.sdk.b.a.urY.m(gcVar);
                            }
                        });
                        this.wdW.bYs();
                    }
                }
            } else {
                w.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
            }
        } else if (kVar.getType() != 113) {
            X(i, i2, kVar.getType());
        } else {
            w.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
        }
    }

    private boolean X(int i, int i2, int i3) {
        ap.yY();
        long d = u.d((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, null));
        ap.yY();
        long d2 = u.d((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_UPDATE_UPDATE_TIME_LONG, null));
        ap.yY();
        long d3 = u.d((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_UPDATE_UPDATE_VERION_LONG, null));
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf(0));
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
        if (d3 == ((long) com.tencent.mm.protocal.d.sYN) && u.az(d2) < 3600) {
            if (d == 1) {
                if (p.b(this.fPi, 4, -17)) {
                    return true;
                }
            } else if (d == 2 && p.b(this.fPi, 4, -16)) {
                return true;
            }
        }
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            w.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (r.iiJ) {
                ab.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", (u.Ny() - 86400) - 1).commit();
            }
            if (p.b(this.fPi, i, i2)) {
                return true;
            }
        }
        return false;
    }

    final int bYH() {
        return this.wdU == null ? -2 : this.wdU.hashCode();
    }

    public final boolean bYI() {
        return this.wdU != null;
    }
}
