package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ao.q;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.a.bd;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l.t;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater extends LinearLayout implements t, e {
    private boolean fEq;
    private int upV;
    private p urb = null;
    private boolean urc = false;
    private boolean urd = false;
    private boolean ure = false;
    private e urf;
    private e urg;

    static /* synthetic */ void a(Updater updater, Intent intent, com.tencent.mm.network.e eVar, a aVar) {
        intent.putExtra("intent_short_ips", bIi());
        intent.putExtra("intent_client_version", d.sYN);
        intent.putExtra("intent_extra_session", eVar.Cc().vc());
        intent.putExtra("intent_extra_cookie", eVar.Cc().BX());
        intent.putExtra("intent_extra_ecdhkey", eVar.Cc().BZ());
        intent.putExtra("intent_extra_uin", eVar.Cc().uH());
        intent.putExtra("intent_update_type", updater.upV);
        intent.putExtra("intent_extra_desc", ((aca) aVar.gUA.hsk.hsr).tHC);
        intent.putExtra("intent_extra_md5", aVar.bHJ());
        intent.putExtra("intent_extra_size", aVar.bHI());
        intent.putExtra("intent_extra_download_url", aVar.bCq());
        intent.putExtra("intent_extra_patchInfo", aVar.bHK());
        intent.putExtra("intent_extra_updateMode", f.fuX);
        intent.putExtra("intent_extra_marketUrl", f.uss);
        w.d("MicroMsg.NetSceneGetUpdateInfo", "summerupdate extInfo[%s], stack[%s]", bg.mz(n.b(((aca) aVar.gUA.hsk.hsr).tHJ)), bg.bJZ());
        intent.putExtra("intent_extra_extinfo", r0);
    }

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        ap.vd().a(11, (e) this);
        g.oUh.a(405, 42, 1, true);
    }

    public final void onStop() {
        g.oUh.a(405, 43, 1, true);
        cancel();
    }

    public static Updater c(Context context, final OnCancelListener onCancelListener) {
        if (context == null) {
            return null;
        }
        if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).getWindow() == null)) {
            w.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            return null;
        }
        ab.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bg.Ny()).commit();
        ap.getNotification().cancel(34);
        w.i("MicroMsg.Updater", "showWithProgress");
        final Updater updater = (Updater) View.inflate(context, R.i.dpp, null);
        updater.onStart();
        p a = p.a(context, context.getString(R.l.eYW), true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ap.getNotification().cancel(99);
                g.oUh.a(405, 47, 1, true);
                Updater.yo(2);
                updater.onStop();
                if (!updater.urc && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        try {
            updater.urb = a;
            updater.urb.show();
            updater.fEq = true;
            g.oUh.a(405, 46, 1, true);
            return updater;
        } catch (Throwable e) {
            w.e("MicroMsg.Updater", "exception in showWithProgress, ", e.getMessage());
            w.printErrStackTrace("MicroMsg.Updater", e, "", new Object[0]);
            return null;
        }
    }

    public static Updater d(Context context, final OnCancelListener onCancelListener) {
        ab.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bg.Ny()).commit();
        ap.getNotification().cancel(34);
        w.i("MicroMsg.Updater", "show update dialog");
        final Updater updater = (Updater) View.inflate(context, R.i.dpp, null);
        updater.onStart();
        p a = p.a(context, "", true, 0, null);
        a.setCancelable(true);
        a.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                ap.getNotification().cancel(99);
                g.oUh.a(405, 49, 1, true);
                Updater.yo(2);
                updater.onStop();
                if (!updater.urc && onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        g.oUh.a(405, 48, 1, true);
        updater.urb = a;
        updater.fEq = false;
        return updater;
    }

    public static Updater dT(Context context) {
        ab.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bg.Ny()).commit();
        ap.getNotification().cancel(34);
        g.oUh.a(405, 50, 1, true);
        w.i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.urd = true;
        return updater;
    }

    public static void cM(Context context) {
        context.startActivity(new Intent(context, AppInstallerUI.class));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            g.oUh.a(405, 51, 1, true);
            w.i("MicroMsg.Updater", "isShow " + this.fEq);
            if (!(this.fEq || this.urb == null)) {
                this.urb.show();
            }
            this.urc = true;
            if (this.urb != null) {
                this.urb.cancel();
            }
            final a aVar = (a) kVar;
            ap.vd().a(new bb(new bb.a(this) {
                final /* synthetic */ Updater urm;

                public final void a(final com.tencent.mm.network.e eVar) {
                    long j;
                    String Nu;
                    if (eVar == null) {
                        g.oUh.a(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    ap.getNotification().cancel(34);
                    w.i("MicroMsg.Updater", "go to update");
                    if (!h.getExternalStorageState().equals("mounted")) {
                        w.e("MicroMsg.Updater", "no sdcard.");
                        g.oUh.a(405, 53, 1, true);
                        this.urm.urd = false;
                    }
                    int bHI = aVar.bHI();
                    i bc = i.bc(aVar.bHK());
                    String dS = i.dS(this.urm.getContext());
                    i.a aVar = null;
                    if (bc != null) {
                        aVar = bc.bb(dS);
                    }
                    if (aVar == null) {
                        j = (long) bHI;
                    } else {
                        j = (long) (aVar.size + bHI);
                    }
                    if (!com.tencent.mm.compatible.util.f.G(j)) {
                        w.e("MicroMsg.Updater", "no enough space.");
                        g.oUh.a(405, 54, 1, true);
                        this.urm.urd = false;
                    }
                    if ((f.fuX & 1) != 0) {
                        w.i("MicroMsg.Updater", "channel pack, not silence download.");
                        g.oUh.a(405, 55, 1, true);
                        this.urm.urd = false;
                    }
                    if (this.urm.upV == 2 && !this.urm.ure) {
                        Nu = i.Nu();
                        if (!(c.DE(aVar.bHJ()) == null || bg.mA(Nu) || !Nu.equals(aVar.bHJ()))) {
                            w.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", Nu);
                            g.oUh.a(405, 56, 1, true);
                            return;
                        }
                    }
                    aca bCr = aVar.bCr();
                    if (bCr == null || bCr.tHG == 0 || bg.mA(bCr.tHH)) {
                        if (this.urm.urd) {
                            w.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            g.oUh.a(405, 58, 1, true);
                            ap.vd().a(725, this.urm.urf = new e(this) {
                                final /* synthetic */ AnonymousClass3 urn;

                                public final void a(int i, int i2, String str, k kVar) {
                                    ap.vd().b(221, this.urn.urm.urf);
                                    this.urn.urm.urf = null;
                                    if (i == 0 && i2 == 0) {
                                        long j;
                                        s sVar = (s) kVar;
                                        if (((aax) sVar.hRS.hsj.hsr).jOc == 0) {
                                            String str2 = ((aay) sVar.hRS.hsk.hsr).opI;
                                            if (!bg.mA(str2)) {
                                                Map q = bh.q(str2, "resourcecontrolinfo");
                                                if (q != null) {
                                                    str2 = (String) q.get(".resourcecontrolinfo.enableupdate");
                                                    String str3 = (String) q.get(".resourcecontrolinfo.expiredtime");
                                                    w.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", q);
                                                    if (bg.getInt(str2, 1) == 0) {
                                                        j = bg.getLong(str3, 0);
                                                        if (j > System.currentTimeMillis() / 1000) {
                                                            w.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                                            g.oUh.a(405, 0, 1, true);
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        j = 0;
                                        if (j > System.currentTimeMillis() / 1000) {
                                            w.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                            g.oUh.a(405, 0, 1, true);
                                            return;
                                        }
                                    }
                                    w.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                                    g.oUh.a(405, 59, 1, true);
                                    Intent intent = new Intent(this.urn.urm.getContext(), UpdaterService.class);
                                    Updater.a(this.urn.urm, intent, eVar, aVar);
                                    intent.putExtra("intent_extra_run_in_foreground", true);
                                    intent.putExtra("intent_extra_download_mode", 2);
                                    this.urn.urm.getContext().startService(intent);
                                }
                            });
                            ap.vd().a(new s(), 0);
                        } else {
                            w.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(this.urm.getContext(), AppUpdaterUI.class);
                            Updater.a(this.urm, intent, eVar, aVar);
                            w.i("MicroMsg.Updater", "current updateType : %s", Integer.valueOf(this.urm.upV));
                            if (this.urm.upV == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                g.oUh.a(405, 60, 1, true);
                            } else {
                                g.oUh.a(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            this.urm.getContext().startActivity(intent);
                        }
                        com.tencent.mm.q.c.uk().s(262145, true);
                        com.tencent.mm.pluginsdk.model.app.a.bCR();
                        return;
                    }
                    Nu = bCr.tHH;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", Nu);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bb.d.b(this.urm.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    i.bIc();
                    g.oUh.a(405, 57, 1, true);
                }
            }), 0);
            onStop();
            return;
        }
        g.oUh.a(405, 62, 1, true);
        if (this.urb != null) {
            p pVar = this.urb;
            if (pVar.jqh != null) {
                pVar.jqh.setVisibility(8);
            }
            final TextView textView = (TextView) this.urb.findViewById(R.h.ckl);
            if (i == 4 && i2 == -18) {
                com.tencent.mm.sdk.b.a.urY.m(new bd());
                com.tencent.mm.y.n vd = ap.vd();
                e anonymousClass4 = new e(this) {
                    final /* synthetic */ Updater urm;

                    public final void a(int i, int i2, String str, k kVar) {
                        ap.vd().b(922, this.urm.urg);
                        this.urm.urf = null;
                        if (i == 0 && i2 == 0) {
                            bfh com_tencent_mm_protocal_c_bfh = ((lb) ((b) kVar.hsK).hsk.hsr).trr;
                            if (com_tencent_mm_protocal_c_bfh == null || com_tencent_mm_protocal_c_bfh.ufP != 3) {
                                this.urm.urb.findViewById(R.h.ckk).setVisibility(8);
                                if (textView != null) {
                                    g.oUh.a(405, 63, 1, true);
                                    textView.setText(R.l.eZb);
                                    return;
                                }
                                return;
                            }
                            Intent intent = new Intent(this.urm.getContext(), AppUpdaterUI.class);
                            Updater.a(intent, new e(com_tencent_mm_protocal_c_bfh));
                            this.urm.getContext().startActivity(intent);
                            if (this.urm.urb != null) {
                                this.urm.urb.cancel();
                            }
                            this.urm.onStop();
                            return;
                        }
                        this.urm.urb.findViewById(R.h.ckk).setVisibility(8);
                        if (textView != null) {
                            g.oUh.a(405, 63, 1, true);
                            textView.setText(R.l.eZb);
                        }
                    }
                };
                this.urg = anonymousClass4;
                vd.a(922, anonymousClass4);
            } else if (textView != null) {
                g.oUh.a(405, 64, 1, true);
                textView.setText(R.l.eYR);
                com.tencent.mm.pluginsdk.ui.d.h.d(textView, 1);
            }
        }
        i.bIg();
        cancel();
    }

    public static void a(Intent intent, e eVar) {
        String str;
        intent.putExtra("intent_short_ips", bIi());
        intent.putExtra("intent_client_version", d.sYN);
        intent.putExtra("intent_update_type", 3);
        String str2 = "intent_extra_desc";
        boolean z = (eVar.mLL == null || eVar.mLL.isEmpty() || !eVar.mLL.containsKey(Integer.valueOf(4))) ? false : true;
        if (z) {
            HashMap hashMap = eVar.mLL;
            if (hashMap == null || hashMap.isEmpty()) {
                str = "";
            } else {
                str = "";
                LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(4));
                if (linkedList != null && !linkedList.isEmpty()) {
                    int size = linkedList.size();
                    int i = 0;
                    while (i < size) {
                        String str3;
                        anc com_tencent_mm_protocal_c_anc = (anc) linkedList.get(i);
                        if (com_tencent_mm_protocal_c_anc.lang.equalsIgnoreCase("default")) {
                            str3 = new String(Base64.decode(com_tencent_mm_protocal_c_anc.content, 0));
                        } else if (com_tencent_mm_protocal_c_anc.lang.equalsIgnoreCase(v.bIN())) {
                            str = new String(Base64.decode(com_tencent_mm_protocal_c_anc.content, 0));
                            break;
                        } else {
                            str3 = str;
                        }
                        i++;
                        str = str3;
                    }
                }
            }
        } else {
            str = "";
        }
        intent.putExtra(str2, str);
        intent.putExtra("intent_extra_md5", eVar.mLP);
        intent.putExtra("intent_extra_size", eVar.fileSize);
        intent.putExtra("intent_extra_download_url", new String[]{eVar.mLO});
        intent.putExtra("intent_extra_patchInfo", eVar.bHX());
        intent.putExtra("intent_extra_updateMode", f.fuX);
        intent.putExtra("intent_extra_marketUrl", f.uss);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
    }

    private void cancel() {
        ap.vd().b(11, (e) this);
    }

    private static String[] bIi() {
        int i = 0;
        if (r.iiF == null || r.iiF.length() <= 0) {
            String string = ab.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List NJ = com.tencent.mm.protocal.n.NJ(string);
            String[] strArr = new String[NJ.size()];
            while (i < NJ.size()) {
                strArr[i] = ((com.tencent.mm.protocal.n) NJ.get(i)).naK;
                i++;
            }
            return strArr;
        }
        return new String[]{r.iiF};
    }

    public final void update(int i) {
        ac(i, false);
    }

    public final void ac(int i, boolean z) {
        w.i("MicroMsg.Updater", "summerupdate begin update routine, type=" + i);
        this.upV = i;
        this.ure = z;
        g.oUh.a(405, 44, 1, true);
        ap.vd().a(new a(i), 0);
    }

    public static void d(String str, int i, String str2, String str3) {
        Intent intent = new Intent(ab.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", d.sYN);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", f.fuX);
        intent.putExtra("intent_extra_marketUrl", f.uss);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        g.oUh.a(405, 45, 1, true);
        ab.getContext().startService(intent);
    }

    public static void yo(int i) {
        if (ap.zb()) {
            w.d("MicroMsg.Updater", "reportUpdateStat : opCode = " + i);
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new q(i));
        }
    }
}
