package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.accountsync.a.c;
import com.tencent.mm.plugin.accountsync.a.c.a;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.Map;

public final class h implements b, e {
    public String kwg;
    public MobileVerifyUI vdQ;
    public String vdX;
    private boolean vdY = true;
    public a vdc = null;

    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] vdT = new int[a.bRt().length];

        static {
            try {
                vdT[a.veB - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vdT[a.veC - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vdT[a.veD - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                vdT[a.veE - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.vdQ = mobileVerifyUI;
    }

    public final void start() {
        bf.zK();
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",RE200_300," + ap.ec("RE200_300") + ",1");
        com.tencent.mm.plugin.c.b.mM("RE200_300");
    }

    public final void stop() {
    }

    public final boolean zE(int i) {
        final k sVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass8.vdT[i - 1]) {
            case 1:
                g.a(this.vdQ, this.vdQ.getString(R.l.eBf), "", this.vdQ.getString(R.l.eBg), this.vdQ.getString(R.l.eBh), new OnClickListener(this) {
                    final /* synthetic */ h vdZ;

                    {
                        this.vdZ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vdZ.vdQ.finish();
                        c.hj(a.irV);
                        bf.zK();
                        com.tencent.mm.plugin.c.b.mN(this.vdZ.vdQ.oVk);
                        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",RE200_300," + ap.ec("RE200_300") + ",2");
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ h vdZ;

                    {
                        this.vdZ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            case 2:
                ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
                sVar = new s(this.vdQ.fOI, 15, this.vdQ.vcL.getText().toString().trim(), 0, "");
                ap.vd().a(sVar, 0);
                mobileVerifyUI = this.vdQ;
                context = this.vdQ;
                this.vdQ.getString(R.l.dIO);
                mobileVerifyUI.isv = g.a(context, this.vdQ.getString(R.l.dOc), true, new OnCancelListener(this) {
                    final /* synthetic */ h vdZ;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(sVar);
                        ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, this.vdZ);
                    }
                });
                return false;
            case 3:
                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_400," + ap.ec("R200_400") + ",1");
                bf.zK();
                com.tencent.mm.plugin.c.b.mM("RE200_250");
                ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
                ap.vd().a(new s(this.vdQ.fOI, 14, "", 0, ""), 0);
                c.hj(a.irW);
                return false;
            case 4:
                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_350_auto," + ap.ec("R200_350_auto") + ",1");
                ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
                sVar = new s(this.vdQ.fOI, 15, this.vdQ.vcL.getText().toString().trim(), 0, "");
                ap.vd().a(sVar, 0);
                mobileVerifyUI = this.vdQ;
                context = this.vdQ;
                this.vdQ.getString(R.l.dIO);
                mobileVerifyUI.isv = g.a(context, this.vdQ.getString(R.l.dOc), true, new OnCancelListener(this) {
                    final /* synthetic */ h vdZ;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(sVar);
                        ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, this.vdZ);
                    }
                });
                return false;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.vdQ.isv != null) {
            this.vdQ.isv.dismiss();
            this.vdQ.isv = null;
        }
        if (kVar.getType() == 255) {
            ap.vd().b(255, (e) this);
            if (i != 0 || i2 != 0) {
                this.vdQ.kE(this.vdY);
            }
        } else if (kVar.getType() != 701 || this.vdc == null) {
            com.tencent.mm.f.a dn;
            int AJ;
            Intent intent;
            String str2;
            if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX) {
                ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX, (e) this);
                AJ = ((s) kVar).AJ();
                if (AJ != 15) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    if (AJ != 15) {
                        return;
                    }
                    if (this.vdQ.veo.booleanValue()) {
                        this.vdX = ((s) kVar).Fu();
                        ap.vd().a(126, (e) this);
                        r3 = new com.tencent.mm.modelsimple.w("", this.vdQ.lOq, this.vdQ.aIO, 0, "", this.vdQ.fOI, "", "", this.vdX, this.vdQ.hSN, "", "", "", true, this.vdQ.ven.booleanValue());
                        ap.vd().a(r3, 0);
                        r4 = this.vdQ;
                        r5 = this.vdQ;
                        this.vdQ.getString(R.l.dIO);
                        r4.isv = g.a(r5, this.vdQ.getString(R.l.eKf), true, new OnCancelListener(this) {
                            final /* synthetic */ h vdZ;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(r3);
                                ap.vd().b(126, this.vdZ);
                            }
                        });
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("regsetinfo_ticket", ((s) kVar).Fu());
                    intent.putExtra("regsetinfo_user", this.vdQ.fOI);
                    intent.putExtra("regsetinfo_ismobile", 1);
                    intent.putExtra("regsetinfo_NextControl", ((s) kVar).Fx());
                    intent.setClass(this.vdQ, RegSetInfoUI.class);
                    this.vdQ.startActivity(intent);
                    c.hj(a.irX);
                    com.tencent.mm.plugin.c.b.mN("R200_900_phone");
                    bf.zK();
                    str2 = "RE200_300";
                    com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + "," + str2 + "," + ap.ec(str2) + ",2");
                    return;
                } else if (i2 == -35) {
                    dn = com.tencent.mm.f.a.dn(str);
                    final k kVar2;
                    if (dn != null) {
                        kVar2 = kVar;
                        dn.a(this.vdQ, new OnClickListener(this) {
                            final /* synthetic */ h vdZ;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ap.vd().a(701, this.vdZ);
                                this.vdZ.vdc = new a(new a.a(this) {
                                    final /* synthetic */ AnonymousClass13 veb;

                                    {
                                        this.veb = r1;
                                    }

                                    public final void a(ProgressDialog progressDialog) {
                                        this.veb.vdZ.vdQ.isv = progressDialog;
                                    }
                                }, ((s) kVar2).getUsername(), ((s) kVar2).Ft(), this.vdZ.vdQ.fOI);
                                this.vdZ.vdc.h(this.vdZ.vdQ);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ h vdZ;

                            {
                                this.vdZ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    kVar2 = kVar;
                    g.a(this.vdQ, this.vdQ.getString(R.l.dNi), null, new OnClickListener(this) {
                        final /* synthetic */ h vdZ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ap.vd().a(701, this.vdZ);
                            this.vdZ.vdc = new a(new a.a(this) {
                                final /* synthetic */ AnonymousClass15 vec;

                                {
                                    this.vec = r1;
                                }

                                public final void a(ProgressDialog progressDialog) {
                                    this.vec.vdZ.vdQ.isv = progressDialog;
                                }
                            }, ((s) kVar2).getUsername(), ((s) kVar2).Ft(), this.vdZ.vdQ.fOI);
                            this.vdZ.vdc.h(this.vdZ.vdQ);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ h vdZ;

                        {
                            this.vdZ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                } else if (i2 == -212) {
                    intent = new Intent(this.vdQ, MobileLoginOrForceReg.class);
                    intent.putExtra("ticket", ((s) kVar).Fu());
                    intent.putExtra("moble", this.vdQ.fOI);
                    intent.putExtra("next_controll", ((s) kVar).Fx());
                    intent.putExtra("username", ((s) kVar).getUsername());
                    intent.putExtra("password", ((s) kVar).Ft());
                    intent.putExtra("nickname", ((s) kVar).FE());
                    intent.putExtra("avatar_url", ((s) kVar).FD());
                    if (this.vdQ.veo.booleanValue()) {
                        intent.putExtra("kintent_nickname", this.vdQ.aIO);
                        intent.putExtra("kintent_password", this.vdQ.lOq);
                        intent.putExtra("kintent_hasavatar", this.vdQ.ven);
                    }
                    this.vdQ.startActivity(intent);
                    com.tencent.mm.plugin.c.b.mN("R200_600");
                    bf.zK();
                    str2 = "RE200_300";
                    com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + "," + str2 + "," + ap.ec(str2) + ",2");
                    return;
                } else if (i2 == -51) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this.vdQ, null, null);
                        return;
                    } else {
                        g.h(this.vdQ, R.l.dOf, R.l.btr);
                        return;
                    }
                }
            } else if (kVar.getType() == 126) {
                final String str3;
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean bool = this.vdQ.ven;
                    final String str4 = this.vdQ.lOq;
                    str3 = this.vdQ.aIO;
                    if (this.vdQ.uUx == null) {
                        MobileVerifyUI mobileVerifyUI = this.vdQ;
                        Context context = this.vdQ;
                        int i3 = R.l.eKg;
                        byte[] FI = ((com.tencent.mm.modelsimple.w) kVar).FI();
                        String FJ = ((com.tencent.mm.modelsimple.w) kVar).FJ();
                        final k kVar3 = kVar;
                        AnonymousClass2 anonymousClass2 = new OnClickListener(this) {
                            final /* synthetic */ h vdZ;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ap.vd().a(126, this.vdZ);
                                final k wVar = new com.tencent.mm.modelsimple.w("", str4, str3, 0, "", this.vdZ.vdQ.fOI, "", "", this.vdZ.vdX, this.vdZ.vdQ.hSN, "", ((com.tencent.mm.modelsimple.w) kVar3).FJ(), this.vdZ.vdQ.uUx.bRz(), true, bool.booleanValue());
                                ap.vd().a(wVar, 0);
                                MobileVerifyUI mobileVerifyUI = this.vdZ.vdQ;
                                Context context = this.vdZ.vdQ;
                                this.vdZ.vdQ.getString(R.l.dIO);
                                mobileVerifyUI.isv = g.a(context, this.vdZ.vdQ.getString(R.l.eKf), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass2 vea;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(wVar);
                                        ap.vd().b(126, this.vea.vdZ);
                                    }
                                });
                            }
                        };
                        OnDismissListener anonymousClass3 = new OnDismissListener(this) {
                            final /* synthetic */ h vdZ;

                            {
                                this.vdZ = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.vdZ.vdQ.uUx = null;
                            }
                        };
                        final String str5 = str4;
                        final String str6 = str3;
                        final k kVar4 = kVar;
                        final Boolean bool2 = bool;
                        SecurityImage.b anonymousClass4 = new SecurityImage.b(this) {
                            final /* synthetic */ h vdZ;

                            public final void bQI() {
                                this.vdZ.vdQ.aHf();
                                ap.vd().a(126, this.vdZ);
                                ap.vd().a(new com.tencent.mm.modelsimple.w("", str5, str6, 0, "", this.vdZ.vdQ.fOI, "", "", this.vdZ.vdX, this.vdZ.vdQ.hSN, "", ((com.tencent.mm.modelsimple.w) kVar4).FJ(), "", true, bool2.booleanValue()), 0);
                            }
                        };
                        mobileVerifyUI.uUx = SecurityImage.a.a(context, i3, 0, FI, FJ, "", anonymousClass2, null, anonymousClass3, anonymousClass4);
                        return;
                    }
                    this.vdQ.uUx.a(0, ((com.tencent.mm.modelsimple.w) kVar).FI(), ((com.tencent.mm.modelsimple.w) kVar).FJ(), "");
                    return;
                }
                if (i == 0 && i2 == 0) {
                    String str7;
                    final String str8;
                    Intent intent2;
                    String str9;
                    final k kVar5;
                    final boolean z;
                    final k kVar6;
                    final String str10;
                    final String str11;
                    final int i4;
                    final String str12 = this.vdQ.fOI;
                    Boolean bool3 = this.vdQ.ven;
                    int FB = ((com.tencent.mm.modelsimple.w) kVar).FB();
                    final String Jr = ((com.tencent.mm.modelsimple.w) kVar).Jr();
                    final int Js = ((com.tencent.mm.modelsimple.w) kVar).Js();
                    String str13 = null;
                    String str14 = null;
                    boolean z2 = false;
                    Map q = bh.q(((com.tencent.mm.modelsimple.w) kVar).Jt(), "wording");
                    if (q != null) {
                        str2 = (String) q.get(".wording.switch");
                        if (bg.mA(str2)) {
                            z2 = true;
                        } else {
                            AJ = bg.PY(str2);
                            if (AJ == 0) {
                                z2 = false;
                            } else if (AJ == 1) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            str2 = (String) q.get(".wording.title");
                            if (!bg.mA(str2)) {
                                str13 = str2;
                            }
                            str2 = (String) q.get(".wording.desc");
                            if (bg.mA(str2)) {
                                str7 = str13;
                            } else {
                                str14 = str2;
                                str7 = str13;
                            }
                            w.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                            w.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(FB));
                            w.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", Jr);
                            w.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(Js));
                            w.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str8);
                            ap.unhold();
                            ap.aT(true);
                            if (bool3.booleanValue()) {
                                this.kwg = ((com.tencent.mm.modelsimple.w) kVar).Jq();
                                ao.hlW.L("login_user_name", str12);
                                if (Jr != null) {
                                    if (Jr.contains("0")) {
                                        com.tencent.mm.plugin.c.b.mN("R300_100_phone");
                                        if (z2) {
                                            intent2 = new Intent(this.vdQ, FindMContactIntroUI.class);
                                        } else {
                                            intent2 = new Intent(this.vdQ, FindMContactAlertUI.class);
                                            intent2.putExtra("alert_title", str7);
                                            intent2.putExtra("alert_message", str14);
                                        }
                                        intent2.addFlags(67108864);
                                        intent2.putExtra("regsetinfo_ticket", this.kwg);
                                        intent2.putExtra("regsetinfo_NextStep", Jr);
                                        intent2.putExtra("regsetinfo_NextStyle", Js);
                                        intent = com.tencent.mm.plugin.c.a.imv.ak(this.vdQ);
                                        intent.addFlags(67108864);
                                        intent.putExtra("LauncherUI.enter_from_reg", true);
                                        MMWizardActivity.b(this.vdQ, intent2, intent);
                                        this.vdQ.finish();
                                    }
                                }
                                intent2 = com.tencent.mm.plugin.c.a.imv.ak(this.vdQ);
                                intent2.addFlags(67108864);
                                intent2.putExtra("LauncherUI.enter_from_reg", true);
                                this.vdQ.startActivity(intent2);
                                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.vdQ.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                                this.vdQ.finish();
                            } else {
                                str9 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar";
                                str2 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar.hd";
                                new File(str9).renameTo(new File(str2));
                                com.tencent.mm.loader.stub.b.deleteFile(str9);
                                d.b(str2, 96, 96, CompressFormat.JPEG, 90, str9);
                                kVar5 = kVar;
                                str3 = str12;
                                str8 = Jr;
                                z = z2;
                                kVar6 = kVar;
                                str10 = str7;
                                str11 = str14;
                                i4 = Js;
                                new o(this.vdQ, com.tencent.mm.compatible.util.e.gSG + "temp.avatar").a(new Runnable(this) {
                                    final /* synthetic */ h vdZ;

                                    public final void run() {
                                        this.vdZ.kwg = ((com.tencent.mm.modelsimple.w) kVar5).Jq();
                                        ao.hlW.L("login_user_name", str3);
                                        com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.gSG + "temp.avatar");
                                        if (str8 == null || !str8.contains("0")) {
                                            Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.vdZ.vdQ);
                                            ak.addFlags(67108864);
                                            this.vdZ.vdQ.startActivity(ak);
                                            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.vdZ.vdQ.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                                            this.vdZ.vdQ.finish();
                                            return;
                                        }
                                        com.tencent.mm.plugin.c.b.mN("R300_100_phone");
                                        if (z) {
                                            ak = new Intent(this.vdZ.vdQ, FindMContactAlertUI.class);
                                            ak.putExtra("alert_title", str7);
                                            ak.putExtra("alert_message", str14);
                                        } else {
                                            ak = new Intent(this.vdZ.vdQ, FindMContactIntroUI.class);
                                        }
                                        ak.addFlags(67108864);
                                        ak.putExtra("regsetinfo_ticket", this.vdZ.kwg);
                                        ak.putExtra("regsetinfo_NextStep", str8);
                                        ak.putExtra("regsetinfo_NextStyle", Js);
                                        Intent ak2 = com.tencent.mm.plugin.c.a.imv.ak(this.vdZ.vdQ);
                                        ak2.addFlags(67108864);
                                        MMWizardActivity.b(this.vdZ.vdQ, ak, ak2);
                                        this.vdZ.vdQ.finish();
                                    }
                                }, new Runnable(this) {
                                    final /* synthetic */ h vdZ;

                                    public final void run() {
                                        this.vdZ.kwg = ((com.tencent.mm.modelsimple.w) kVar6).Jq();
                                        ao.hlW.L("login_user_name", str12);
                                        if (Jr == null || !Jr.contains("0")) {
                                            Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.vdZ.vdQ);
                                            ak.addFlags(67108864);
                                            this.vdZ.vdQ.startActivity(ak);
                                            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.vdZ.vdQ.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                                            this.vdZ.vdQ.finish();
                                            return;
                                        }
                                        com.tencent.mm.plugin.c.b.mN("R300_100_phone");
                                        if (z2) {
                                            ak = new Intent(this.vdZ.vdQ, FindMContactAlertUI.class);
                                            ak.putExtra("alert_title", str10);
                                            ak.putExtra("alert_message", str11);
                                        } else {
                                            ak = new Intent(this.vdZ.vdQ, FindMContactIntroUI.class);
                                        }
                                        ak.addFlags(67108864);
                                        ak.putExtra("regsetinfo_ticket", this.vdZ.kwg);
                                        ak.putExtra("regsetinfo_NextStep", Jr);
                                        ak.putExtra("regsetinfo_NextStyle", i4);
                                        Intent ak2 = com.tencent.mm.plugin.c.a.imv.ak(this.vdZ.vdQ);
                                        ak2.addFlags(67108864);
                                        MMWizardActivity.b(this.vdZ.vdQ, ak, ak2);
                                        this.vdZ.vdQ.finish();
                                    }
                                });
                            }
                        }
                    }
                    str7 = null;
                    w.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                    w.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(FB));
                    w.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", Jr);
                    w.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(Js));
                    w.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str8);
                    ap.unhold();
                    ap.aT(true);
                    if (bool3.booleanValue()) {
                        this.kwg = ((com.tencent.mm.modelsimple.w) kVar).Jq();
                        ao.hlW.L("login_user_name", str12);
                        if (Jr != null) {
                            if (Jr.contains("0")) {
                                com.tencent.mm.plugin.c.b.mN("R300_100_phone");
                                if (z2) {
                                    intent2 = new Intent(this.vdQ, FindMContactAlertUI.class);
                                    intent2.putExtra("alert_title", str7);
                                    intent2.putExtra("alert_message", str14);
                                } else {
                                    intent2 = new Intent(this.vdQ, FindMContactIntroUI.class);
                                }
                                intent2.addFlags(67108864);
                                intent2.putExtra("regsetinfo_ticket", this.kwg);
                                intent2.putExtra("regsetinfo_NextStep", Jr);
                                intent2.putExtra("regsetinfo_NextStyle", Js);
                                intent = com.tencent.mm.plugin.c.a.imv.ak(this.vdQ);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this.vdQ, intent2, intent);
                                this.vdQ.finish();
                            }
                        }
                        intent2 = com.tencent.mm.plugin.c.a.imv.ak(this.vdQ);
                        intent2.addFlags(67108864);
                        intent2.putExtra("LauncherUI.enter_from_reg", true);
                        this.vdQ.startActivity(intent2);
                        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.vdQ.getClass().getName() + ",R200_900_phone," + ap.ec("R200_900_phone") + ",4");
                        this.vdQ.finish();
                    } else {
                        str9 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar";
                        str2 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar.hd";
                        new File(str9).renameTo(new File(str2));
                        com.tencent.mm.loader.stub.b.deleteFile(str9);
                        d.b(str2, 96, 96, CompressFormat.JPEG, 90, str9);
                        kVar5 = kVar;
                        str3 = str12;
                        str8 = Jr;
                        z = z2;
                        kVar6 = kVar;
                        str10 = str7;
                        str11 = str14;
                        i4 = Js;
                        new o(this.vdQ, com.tencent.mm.compatible.util.e.gSG + "temp.avatar").a(/* anonymous class already generated */, /* anonymous class already generated */);
                    }
                }
                dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this.vdQ, null, null);
                    return;
                }
            }
            if (!this.vdQ.p(i, i2, str)) {
                if (kVar.getType() == 701) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null && dn.a(this.vdQ, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.vdQ, this.vdQ.getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else {
            ap.vd().b(701, (e) this);
            this.vdc.a(this.vdQ, i, i2, str, kVar);
            if (i == 0 && i2 == 0) {
                if (kVar instanceof u) {
                    this.vdY = ((u) kVar).Jp();
                }
                ap.vd().a(255, (e) this);
                r3 = new v(1);
                ap.vd().a(r3, 0);
                r4 = this.vdQ;
                r5 = this.vdQ;
                this.vdQ.getString(R.l.dIO);
                r4.isv = g.a(r5, this.vdQ.getString(R.l.eSL), true, new OnCancelListener(this) {
                    final /* synthetic */ h vdZ;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(r3);
                    }
                });
            }
        }
    }
}
