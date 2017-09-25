package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.y;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class p {
    static ProgressDialog isv = null;
    private static boolean uUw = false;
    static SecurityImage uUx = null;

    static class AnonymousClass5 implements OnCancelListener {
        final /* synthetic */ Activity iic;
        final /* synthetic */ Intent uUy = null;

        AnonymousClass5(Intent intent, Activity activity) {
            this.iic = activity;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            g.oUh.a(405, 39, 1, true);
            if (this.uUy != null) {
                this.iic.finish();
                this.iic.startActivity(this.uUy);
                b.A(this.iic, this.uUy);
            }
        }
    }

    public static class a {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(final android.content.Context r9, int r10, int r11, java.lang.String r12, int r13) {
            /*
            r1 = 0;
            r8 = 2;
            r3 = 0;
            r2 = 1;
            switch(r10) {
                case 1: goto L_0x0009;
                case 2: goto L_0x00ef;
                case 3: goto L_0x010d;
                case 4: goto L_0x0110;
                default: goto L_0x0007;
            };
        L_0x0007:
            r0 = r3;
        L_0x0008:
            return r0;
        L_0x0009:
            r0 = r13 & 2;
            if (r0 == 0) goto L_0x0029;
        L_0x000d:
            r0 = com.tencent.mm.u.ap.vd();
            r0 = r0.BS();
            if (r0 == 0) goto L_0x0029;
        L_0x0017:
            r0 = com.tencent.mm.u.ap.vd();
            r0 = r0.getNetworkServerIp();
            r4 = java.lang.String.valueOf(r11);
            r0 = com.tencent.mm.pluginsdk.ui.k.u(r9, r0, r4);
            if (r0 != 0) goto L_0x0067;
        L_0x0029:
            r0 = r13 & 1;
            if (r0 == 0) goto L_0x0039;
        L_0x002d:
            r0 = com.tencent.mm.network.aa.bn(r9);
            if (r0 == 0) goto L_0x0039;
        L_0x0033:
            r0 = com.tencent.mm.pluginsdk.ui.k.dD(r9);
            if (r0 != 0) goto L_0x0067;
        L_0x0039:
            r0 = r13 & 4;
            if (r0 == 0) goto L_0x004c;
        L_0x003d:
            r0 = com.tencent.mm.sdk.platformtools.am.isWap(r9);
            if (r0 == 0) goto L_0x004c;
        L_0x0043:
            r0 = com.tencent.mm.u.ap.zb();
            if (r0 != 0) goto L_0x0069;
        L_0x0049:
            r0 = r3;
        L_0x004a:
            if (r0 != 0) goto L_0x0067;
        L_0x004c:
            r0 = com.tencent.mm.R.l.elu;
            r1 = new java.lang.Object[r8];
            r4 = java.lang.Integer.valueOf(r2);
            r1[r3] = r4;
            r3 = java.lang.Integer.valueOf(r11);
            r1[r2] = r3;
            r0 = r9.getString(r0, r1);
            r0 = android.widget.Toast.makeText(r9, r0, r2);
            r0.show();
        L_0x0067:
            r0 = r2;
            goto L_0x0008;
        L_0x0069:
            com.tencent.mm.u.ap.yY();
            r0 = com.tencent.mm.u.c.vr();
            r4 = 61;
            r0 = r0.get(r4, r1);
            r0 = (java.lang.Boolean) r0;
            r0 = com.tencent.mm.sdk.platformtools.bg.f(r0);
            if (r0 == 0) goto L_0x0080;
        L_0x007e:
            r0 = r3;
            goto L_0x004a;
        L_0x0080:
            r0 = "show_wap_adviser";
            r0 = com.tencent.mm.sdk.platformtools.ad.Pt(r0);
            if (r0 != 0) goto L_0x008b;
        L_0x0089:
            r0 = r3;
            goto L_0x004a;
        L_0x008b:
            r0 = com.tencent.mm.R.i.dkh;
            r1 = android.view.View.inflate(r9, r0, r1);
            r0 = com.tencent.mm.R.h.cnc;
            r0 = r1.findViewById(r0);
            r0 = (android.widget.TextView) r0;
            r4 = com.tencent.mm.R.l.eDx;
            r0.setText(r4);
            r0 = com.tencent.mm.R.h.cnb;
            r0 = r1.findViewById(r0);
            r0 = (android.widget.CheckBox) r0;
            r4 = com.tencent.mm.R.l.eGU;
            r4 = r9.getString(r4);
            r0.setText(r4);
            r4 = new com.tencent.mm.ui.MMAppMgr$12;
            r4.<init>();
            r0.setOnCheckedChangeListener(r4);
            r0.setVisibility(r3);
            r0 = new com.tencent.mm.ui.base.h$a;
            r0.<init>(r9);
            r4 = com.tencent.mm.R.l.dIO;
            r0.zW(r4);
            r0.dd(r1);
            r1 = com.tencent.mm.R.l.eGW;
            r1 = r0.zZ(r1);
            r4 = new com.tencent.mm.ui.MMAppMgr$13;
            r4.<init>(r9);
            r1.a(r4);
            r0.kK(r3);
            r1 = com.tencent.mm.R.l.eGV;
            r0.Aa(r1);
            r1 = new com.tencent.mm.ui.MMAppMgr$14;
            r1.<init>();
            r0.a(r1);
            r0 = r0.WJ();
            r0.show();
            r0 = r2;
            goto L_0x004a;
        L_0x00ef:
            r0 = com.tencent.mm.R.l.elv;
            r1 = new java.lang.Object[r8];
            r4 = java.lang.Integer.valueOf(r8);
            r1[r3] = r4;
            r3 = java.lang.Integer.valueOf(r11);
            r1[r2] = r3;
            r0 = r9.getString(r0, r1);
            r0 = android.widget.Toast.makeText(r9, r0, r2);
            r0.show();
            r0 = r2;
            goto L_0x0008;
        L_0x010d:
            r0 = r2;
            goto L_0x0008;
        L_0x0110:
            r4 = com.tencent.mm.f.a.dn(r12);
            if (r4 == 0) goto L_0x0007;
        L_0x0116:
            r0 = "MicroMsg.MMErrorProcessor";
            r5 = "summertips errCode[%d], showType[%d], url[%s], desc[%s]";
            r6 = 4;
            r6 = new java.lang.Object[r6];
            r7 = java.lang.Integer.valueOf(r11);
            r6[r3] = r7;
            r7 = r4.showType;
            r7 = java.lang.Integer.valueOf(r7);
            r6[r2] = r7;
            r7 = r4.url;
            r6[r8] = r7;
            r7 = 3;
            r8 = r4.desc;
            r6[r7] = r8;
            com.tencent.mm.sdk.platformtools.w.i(r0, r5, r6);
            r0 = r4.url;
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
            if (r0 != 0) goto L_0x014f;
        L_0x0141:
            r0 = new com.tencent.mm.ui.p$a$1;
            r0.<init>(r4, r9);
        L_0x0146:
            r0 = r4.a(r9, r0, r1);
            if (r0 == 0) goto L_0x0007;
        L_0x014c:
            r0 = r2;
            goto L_0x0008;
        L_0x014f:
            r0 = r1;
            goto L_0x0146;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.p.a.a(android.content.Context, int, int, java.lang.String, int):boolean");
        }
    }

    public static boolean a(final Activity activity, int i, int i2, final Intent intent, String str) {
        if (i != 4) {
            return false;
        }
        w.d("MicroMsg.MMErrorProcessor", "errType = " + i + " errCode = " + i2);
        switch (i2) {
            case -205:
            case -72:
            case -9:
            case -4:
            case -3:
                w.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                com.tencent.mm.ui.base.g.a((Context) activity, R.l.ezj, R.l.dIO, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.A(activity, intent);
                            d.bd(activity);
                        }
                    }
                });
                return true;
            case -140:
            case -104:
                w.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", Integer.valueOf(i2), str);
                if (bg.mA(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i2 == -104) {
                        w.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", str);
                        break;
                    }
                }
                str = str.substring(16);
                if (!bg.mA(str) && str.startsWith("<")) {
                    Map q = bh.q(str, "e");
                    if (!(q == null || bg.mA((String) q.get(".e.Content")))) {
                        str = (String) q.get(".e.Content");
                    }
                }
                if (bg.mA(str)) {
                    str = ab.getContext().getString(R.l.ezj);
                }
                com.tencent.mm.ui.base.g.a((Context) activity, str, ab.getContext().getString(R.l.dIO), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.A(activity, intent);
                            d.bd(activity);
                        }
                    }
                });
                return true;
            case -100:
                String uI = ap.uI();
                w.e("MicroMsg.MMErrorProcessor", "account expired=" + i2 + " lastKickReason=" + uI);
                com.tencent.mm.sdk.b.a.urY.m(new com.tencent.mm.e.a.w());
                com.tencent.mm.sdk.b.b imVar = new im();
                imVar.fOk.status = 0;
                imVar.fOk.fOl = 1;
                com.tencent.mm.sdk.b.a.urY.m(imVar);
                String str2;
                if (uUw) {
                    String str3 = "MicroMsg.MMErrorProcessor";
                    String str4 = "already show kickout dialog before, ignore. lastKickReason[%s]";
                    Object[] objArr = new Object[1];
                    if (bg.mA(uI)) {
                        str2 = "";
                    } else {
                        str2 = uI;
                    }
                    objArr[0] = str2;
                    w.i(str3, str4, objArr);
                    return true;
                }
                if (!bg.mA(uI)) {
                    final com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(uI);
                    if (dn != null) {
                        w.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", Integer.valueOf(dn.showType));
                        if ((dn.showType == 3 || dn.showType == 4) && dn.a(activity, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    ap.hold();
                                    if (bg.mA(dn.url)) {
                                        activity.startActivity(intent);
                                        b.A(activity, intent);
                                    } else {
                                        Intent intent = new Intent();
                                        StringBuilder stringBuilder = new StringBuilder(dn.url);
                                        stringBuilder.append("&wechat_real_lang=" + v.bIN());
                                        intent.putExtra("rawUrl", stringBuilder.toString());
                                        intent.putExtra("showShare", false);
                                        intent.putExtra("show_bottom", false);
                                        intent.putExtra("needRedirect", false);
                                        intent.putExtra("neverGetA8Key", true);
                                        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                                        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                                        com.tencent.mm.bb.d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                                    }
                                    d.bd(activity);
                                    com.tencent.mm.sdk.b.b yVar = new y();
                                    yVar.fDf.fDg = true;
                                    com.tencent.mm.sdk.b.a.urY.m(yVar);
                                }
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (intent != null) {
                                    if (!(activity instanceof LauncherUI)) {
                                        activity.finish();
                                    }
                                    activity.startActivity(intent);
                                    b.A(activity, intent);
                                    d.bd(activity);
                                }
                            }
                        })) {
                            uUw = true;
                            w.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
                            return true;
                        }
                    }
                }
                if (!bg.mA(uI) && uI.startsWith("<")) {
                    Map q2 = bh.q(uI, "e");
                    if (!(q2 == null || bg.mA((String) q2.get(".e.Content")))) {
                        str2 = (String) q2.get(".e.Content");
                        w.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + str2 + " |v=" + q2);
                        uI = str2;
                    }
                }
                w.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", uI);
                if (bg.mA(uI)) {
                    uI = com.tencent.mm.bg.a.V(activity, R.l.ezi);
                }
                com.tencent.mm.ui.base.g.a((Context) activity, uI, activity.getString(R.l.dIO), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            ap.hold();
                            activity.startActivity(intent);
                            b.A(activity, intent);
                            d.bd(activity);
                            com.tencent.mm.sdk.b.b yVar = new y();
                            yVar.fDf.fDg = true;
                            com.tencent.mm.sdk.b.a.urY.m(yVar);
                        }
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        if (intent != null) {
                            if (!(activity instanceof LauncherUI)) {
                                activity.finish();
                            }
                            activity.startActivity(intent);
                            b.A(activity, intent);
                            d.bd(activity);
                        }
                    }
                });
                uUw = true;
                w.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
                return true;
            case -75:
                w.e("MicroMsg.MMErrorProcessor", "account expired=" + i2);
                com.tencent.mm.ui.base.g.a((Context) activity, R.l.dDe, R.l.dIO, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (intent != null) {
                            activity.finish();
                            activity.startActivity(intent);
                            b.A(activity, intent);
                            d.bd(activity);
                        }
                    }
                });
                return true;
        }
        return false;
    }

    public static h a(final Activity activity, String str, final String str2, final Intent intent) {
        com.tencent.mm.sdk.b.b imVar = new im();
        imVar.fOk.status = 0;
        imVar.fOk.fOl = 1;
        com.tencent.mm.sdk.b.a.urY.m(imVar);
        return com.tencent.mm.ui.base.g.a((Context) activity, str, activity.getString(R.l.dIO), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                g.oUh.a(322, 23, 1, true);
                g gVar = g.oUh;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4023);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bg.mA(str2)), str2});
                gVar.i(11098, objArr);
                ap.hold();
                if (bg.mA(str2)) {
                    activity.startActivity(intent);
                    b.A(activity, intent);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    com.tencent.mm.bb.d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                }
                d.bd(activity);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.oUh.a(322, 24, 1, true);
                g gVar = g.oUh;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(4024);
                objArr[1] = String.format("%b|%s", new Object[]{Boolean.valueOf(bg.mA(str2)), str2});
                gVar.i(11098, objArr);
                activity.startActivity(intent);
                b.A(activity, intent);
                d.bd(activity);
            }
        });
    }

    public static boolean ab(Activity activity) {
        boolean z = true;
        if (bg.PY(com.tencent.mm.i.g.sV().getValue("SilentDownloadApkAtWiFi")) != 0) {
            return false;
        }
        ap.yY();
        boolean z2 = (((Integer) c.vr().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
        if (!(am.isWifi((Context) activity) && z2)) {
            z = false;
        }
        if ((f.fuX & 1) != 0) {
            w.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
            z = false;
        } else {
            w.d("MicroMsg.MMErrorProcessor", "not channel pack.");
        }
        if (z && t.Nx()) {
            return ac(activity);
        }
        return false;
    }

    public static boolean eB(final Context context) {
        final String Nu = t.Nu();
        final int Nv = t.Nv();
        w.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", Nu, Integer.valueOf(Nv));
        if (bg.mA(Nu) || t.Nw()) {
            return false;
        }
        ap.vL().D(new Runnable() {
            public final void run() {
                if (Nv == 4 && com.tencent.mm.pluginsdk.model.app.a.bCQ() == null) {
                    w.w("MicroMsg.MMErrorProcessor", "alphaUpdateInfo expired");
                } else if (l.y.bCs() != null && l.y.bCs().DE(Nu) != null) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 uUA;

                        {
                            this.uUA = r1;
                        }

                        public final void run() {
                            if (l.y.bCs() != null) {
                                l.y.bCs().cM(context);
                            }
                        }
                    });
                }
            }
        });
        return true;
    }

    public static boolean b(final Activity activity, int i, int i2) {
        w.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.sYN), Integer.valueOf(f.fuV), Integer.valueOf(f.fuX));
        if (i != 4) {
            return false;
        }
        l.t b;
        switch (i2) {
            case -17:
                long j = ab.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1);
                w.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", Long.valueOf(j), Long.valueOf(bg.az(j)));
                if (j != -1 && bg.az(j) < 86400) {
                    return true;
                }
                if ((f.fuX & 2) != 0) {
                    w.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    return true;
                }
                w.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                String value = com.tencent.mm.i.g.sV().getValue("SilentDownloadApkAtWiFi");
                ap.yY();
                boolean z = ((((Integer) c.vr().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0 ? 1 : null) != null && (bg.mA(value) || bg.PY(value) == 0);
                if ((f.fuX & 1) != 0) {
                    w.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
                    z = false;
                } else {
                    w.d("MicroMsg.MMErrorProcessor", "not channel pack.");
                }
                if (bg.PY(value) != 0) {
                    w.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
                }
                w.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", Boolean.valueOf(z));
                if (z) {
                    g.oUh.a(405, 40, 1, true);
                    return ac(activity);
                } else if (l.y.bCs() == null) {
                    return false;
                } else {
                    b = l.y.bCs().b(activity, new AnonymousClass5(null, activity));
                    g.oUh.a(405, 38, 1, true);
                    b.update(2);
                    return true;
                }
            case -16:
                if (l.y.bCs() == null) {
                    return false;
                }
                b = l.y.bCs().b(activity, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.oUh.a(405, 37, 1, true);
                        activity.finish();
                        MMAppMgr.a(activity, true);
                    }
                });
                g.oUh.a(405, 36, 1, true);
                b.update(1);
                return true;
            default:
                return false;
        }
    }

    private static boolean ac(Activity activity) {
        com.tencent.mm.pluginsdk.model.app.a bCQ = com.tencent.mm.pluginsdk.model.app.a.bCQ();
        if (bCQ != null) {
            bCQ.bCT();
            w.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
            return true;
        } else if (l.y.bCs() == null) {
            return false;
        } else {
            l.y.bCs().cL(activity).update(2);
            return true;
        }
    }
}
