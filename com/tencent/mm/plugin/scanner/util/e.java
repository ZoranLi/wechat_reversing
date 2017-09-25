package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ku;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Map;

public final class e implements com.tencent.mm.plugin.z.a.c.a, com.tencent.mm.y.e {
    public String aJE;
    public String appId;
    public int fFq;
    public String fFt;
    public String imagePath;
    private ProgressDialog kbu = null;
    private int pdq;
    private String pdr;
    private Bundle pds;
    public a pdt = null;
    private Map<k, Integer> pdu = new HashMap();
    public int pdv;
    private Activity qb;

    public interface a {
        void k(int i, Bundle bundle);
    }

    public e() {
        onResume();
    }

    public final void a(Activity activity, String str, int i, int i2, int i3, a aVar, Bundle bundle) {
        w.i("MicroMsg.QBarStringHandler", "deal QBarString %s, source:%d, codeType: %s, codeVersion: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.qb = activity;
        this.pdq = i;
        this.pdr = str;
        this.pdt = aVar;
        this.pds = bundle;
        if (bg.mA(str)) {
            w.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
        } else if (ap.vd().BR() == 0) {
            Toast.makeText(activity, activity.getString(R.l.elv), 0).show();
            if (this.pdt != null) {
                this.pdt.k(0, null);
            }
        } else {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            if (bg.mA(str2)) {
                w.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[]{str, Boolean.valueOf(true), Boolean.valueOf(true)});
                if (str.startsWith("weixin://wxpay/bizpayurl")) {
                    w.i("MicroMsg.QBarStringHandler", "do native pay");
                    int si = si(this.pdq);
                    int rI = rI(si);
                    final b kuVar = new ku();
                    kuVar.fRp.url = str;
                    kuVar.fRp.fRr = rI;
                    kuVar.fRp.scene = si;
                    kuVar.fRp.context = this.qb;
                    if (rI == 13) {
                        w.d("MicroMsg.QBarStringHandler", "add source and sourceType");
                        kuVar.fRp.aJE = this.aJE;
                        kuVar.fRp.fFq = this.fFq;
                    }
                    kuVar.nFq = new Runnable(this) {
                        final /* synthetic */ e pdx;

                        public final void run() {
                            if (this.pdx.getContext() != null && kuVar.fRq != null) {
                                if (kuVar.fRq.ret == 1) {
                                    this.pdx.gu(true);
                                } else if (kuVar.fRq.ret == 2) {
                                    this.pdx.gu(false);
                                }
                            }
                        }
                    };
                    com.tencent.mm.sdk.b.a.urY.a(kuVar, Looper.myLooper());
                    new ae(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                        final /* synthetic */ e pdx;

                        {
                            this.pdx = r1;
                        }

                        public final void run() {
                            if (this.pdx.pdt != null) {
                                this.pdx.pdt.k(3, null);
                            }
                        }
                    }, 200);
                    return;
                } else if (str.startsWith("https://wx.tenpay.com/f2f") || str.startsWith("wxp://f2f")) {
                    if (this.pdt != null) {
                        this.pdt.k(5, null);
                    }
                    com.tencent.mm.pluginsdk.wallet.e.a(this.qb, 1, str, rI(si(this.pdq)), null);
                    if (this.pdt != null) {
                        this.pdt.k(3, null);
                        return;
                    }
                    return;
                } else if (str.startsWith("wxp://wbf2f")) {
                    if (this.pdt != null) {
                        this.pdt.k(5, null);
                    }
                    com.tencent.mm.pluginsdk.wallet.e.a(this.qb, 6, str, rI(si(this.pdq)), null);
                    if (this.pdt != null) {
                        this.pdt.k(3, null);
                        return;
                    }
                    return;
                } else if (str.startsWith("wxhb://f2f")) {
                    w.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
                    if (i2 == 19) {
                        if (this.pdt != null) {
                            this.pdt.k(5, null);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("key_share_url", str);
                        d.b(this.qb, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", intent, 1);
                        return;
                    }
                    return;
                } else {
                    String str3 = this.appId;
                    w.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[]{str, Integer.valueOf(this.pdq), Integer.valueOf(this.pdv > 0 ? this.pdv : si(this.pdq))});
                    final k lVar = new l(str, r2, i2, i3, str3, (int) System.currentTimeMillis());
                    this.pdu.put(lVar, Integer.valueOf(1));
                    ap.vd().a(lVar, 0);
                    if (this.kbu != null) {
                        this.kbu.dismiss();
                    }
                    activity.getString(R.l.dIO);
                    this.kbu = g.a(activity, activity.getString(R.l.eHv), true, new OnCancelListener(this) {
                        final /* synthetic */ e pdx;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(lVar);
                            if (this.pdx.pdt != null) {
                                this.pdx.pdt.k(1, null);
                            }
                        }
                    });
                    return;
                }
            }
            a(activity, i, str2, false);
        }
    }

    private static int rI(int i) {
        if (i == 30 || i == 37 || i == 38 || i == 40) {
            return 13;
        }
        if (i == 4) {
            return 12;
        }
        if (i == 34) {
            return 24;
        }
        return 0;
    }

    public final void aZa() {
        w.i("MicroMsg.QBarStringHandler", "cancel Deal");
        this.pdr = null;
        this.qb = null;
        onPause();
    }

    public final void onResume() {
        w.i("MicroMsg.QBarStringHandler", "onResume");
        ap.vd().a(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
        ap.vd().a(233, this);
        ap.vd().a(666, this);
    }

    public final void onPause() {
        w.i("MicroMsg.QBarStringHandler", "onPause");
        ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
        ap.vd().b(233, this);
        ap.vd().b(666, this);
    }

    private void a(Activity activity, int i, String str, boolean z) {
        int i2 = 2;
        w.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[]{str});
        if (i != 2) {
            i2 = 1;
        }
        final k aaVar = new aa(str, i2, 5, z);
        this.pdu.put(aaVar, Integer.valueOf(1));
        ap.vd().a(aaVar, 0);
        activity.getString(R.l.dIO);
        this.kbu = g.a(activity, activity.getString(R.l.eOV), new OnCancelListener(this) {
            final /* synthetic */ e pdx;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(aaVar);
                if (this.pdx.pdt != null) {
                    this.pdx.pdt.k(1, null);
                }
            }
        });
    }

    private static int si(int i) {
        if (i == 1) {
            return 34;
        }
        if (i == 0) {
            return 4;
        }
        if (i == 3) {
            return 42;
        }
        return 30;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            String str2 = "MicroMsg.QBarStringHandler";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(kVar == null);
            w.e(str2, str3, objArr);
            if (this.pdt != null) {
                this.pdt.k(2, null);
                return;
            }
            return;
        }
        if (!this.pdu.containsKey(kVar)) {
            if (kVar instanceof y) {
                w.e("MicroMsg.QBarStringHandler", "emotion scan scene");
            } else {
                w.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
                return;
            }
        }
        this.pdu.remove(kVar);
        if (this.kbu != null) {
            this.kbu.dismiss();
            this.kbu = null;
        }
        if (i == 4 && i2 == -4) {
            g.a(this.qb, R.l.eHq, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ e pdx;

                {
                    this.pdx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.pdx.pdt != null) {
                        this.pdx.pdt.k(1, null);
                    }
                }
            });
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (ap.vd().BS()) {
                    com.tencent.mm.pluginsdk.ui.k.u(this.qb, ap.vd().getNetworkServerIp(), String.valueOf(i2));
                } else if (com.tencent.mm.network.aa.bn(this.qb)) {
                    com.tencent.mm.pluginsdk.ui.k.dD(this.qb);
                } else {
                    Toast.makeText(this.qb, this.qb.getString(R.l.elu, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.qb, this.qb.getString(R.l.elv, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            if (this.pdt != null) {
                this.pdt.k(1, null);
            }
        } else if (i == 4 && i2 == -2004) {
            g.h(this.qb, R.l.eHl, R.l.dIO);
            if (this.pdt != null) {
                this.pdt.k(1, null);
            }
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.qb, this.qb.getString(R.l.elQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.pdt != null) {
                this.pdt.k(1, null);
            }
        } else if (kVar.getType() == MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
            awr Jx;
            af Rc;
            BizInfo hO;
            ExtInfo extInfo;
            Intent intent;
            Bundle bundle;
            aa aaVar = (aa) kVar;
            if (!aaVar.hSZ) {
                awr Jx2 = aaVar.Jx();
                if (x.yC(Jx2.tMP) && Jx2.tMW != null && !bg.mA(Jx2.tMW.hAS) && com.tencent.mm.modelappbrand.a.gH(Jx2.tMW.hAS)) {
                    int si = this.pdv > 0 ? this.pdv : si(this.pdq);
                    w.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[]{this.pdr, Integer.valueOf(this.pdq), Integer.valueOf(si)});
                    final k lVar = new l(this.pdr, null, 43, 0);
                    this.pdu.put(lVar, Integer.valueOf(1));
                    ap.vd().a(lVar, 0);
                    if (this.kbu != null) {
                        this.kbu.dismiss();
                    }
                    Context context = this.qb;
                    this.qb.getString(R.l.dIO);
                    this.kbu = g.a(context, this.qb.getString(R.l.eHv), true, new OnCancelListener(this) {
                        final /* synthetic */ e pdx;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(lVar);
                            if (this.pdx.pdt != null) {
                                this.pdx.pdt.k(1, null);
                            }
                        }
                    });
                    obj = 1;
                    if (obj == null) {
                        Jx = ((aa) kVar).Jx();
                        str3 = n.a(Jx.ttp);
                        w.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + Jx.ttp);
                        com.tencent.mm.x.n.Bl().g(str3, n.a(Jx.tfh));
                        if (this.kbu != null && this.kbu.isShowing()) {
                            w.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                            this.kbu.dismiss();
                        }
                        if (bg.mz(str3).length() <= 0) {
                            ap.yY();
                            Rc = c.wR().Rc(str3);
                            if (Rc != null && com.tencent.mm.j.a.ez(Rc.field_type) && Rc.bLe()) {
                                hO = com.tencent.mm.modelbiz.w.DH().hO(str3);
                                hO.bd(false);
                                extInfo = hO.hut;
                                if (extInfo.hux != null) {
                                    extInfo.huN = extInfo.hux.optInt("ScanQRCodeType", 0);
                                }
                                if (!((extInfo.huN != 1 ? 1 : null) == null || hO.CH())) {
                                    intent = new Intent();
                                    intent.putExtra("Chat_User", str3);
                                    intent.putExtra("finish_direct", true);
                                    com.tencent.mm.plugin.scanner.b.imv.e(intent, this.qb);
                                    obj = 1;
                                }
                            }
                            switch (this.pdq) {
                                case 0:
                                case 2:
                                    si = 30;
                                    break;
                                case 1:
                                    si = 45;
                                    break;
                                default:
                                    si = 30;
                                    break;
                            }
                            Intent intent2 = new Intent();
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent2, Jx, si);
                            if (!(Rc == null || com.tencent.mm.j.a.ez(Rc.field_type))) {
                                intent2.putExtra("Contact_IsLBSFriend", true);
                            }
                            if ((Jx.tMP & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.oUh.A(10298, str3 + "," + si);
                            }
                            if (this.qb != null) {
                                com.tencent.mm.plugin.scanner.b.imv.d(intent2, this.qb);
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                Object[] objArr2 = new Object[6];
                                objArr2[0] = Integer.valueOf(x.yC(Jx.tMP) ? 0 : 1);
                                objArr2[1] = Integer.valueOf(this.fFq);
                                objArr2[2] = Integer.valueOf(this.pdq);
                                objArr2[3] = this.imagePath;
                                objArr2[4] = this.pdr;
                                objArr2[5] = bg.mz(this.fFt);
                                gVar.i(14268, objArr2);
                            }
                            obj = 1;
                        } else {
                            if (this.qb != null) {
                                Toast.makeText(this.qb, R.l.ePo, 0).show();
                            }
                            obj = null;
                        }
                        if (obj == null) {
                            if (this.pdt != null) {
                                bundle = new Bundle();
                                bundle.putString("geta8key_fullurl", n.a(((aa) kVar).Jx().ttp));
                                bundle.putInt("geta8key_action_code", 4);
                                this.pdt.k(3, bundle);
                            }
                        } else if (this.pdt != null) {
                            this.pdt.k(1, null);
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                Jx = ((aa) kVar).Jx();
                str3 = n.a(Jx.ttp);
                w.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + Jx.ttp);
                com.tencent.mm.x.n.Bl().g(str3, n.a(Jx.tfh));
                w.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
                this.kbu.dismiss();
                if (bg.mz(str3).length() <= 0) {
                    if (this.qb != null) {
                        Toast.makeText(this.qb, R.l.ePo, 0).show();
                    }
                    obj = null;
                } else {
                    ap.yY();
                    Rc = c.wR().Rc(str3);
                    hO = com.tencent.mm.modelbiz.w.DH().hO(str3);
                    hO.bd(false);
                    extInfo = hO.hut;
                    if (extInfo.hux != null) {
                        extInfo.huN = extInfo.hux.optInt("ScanQRCodeType", 0);
                    }
                    if (extInfo.huN != 1) {
                    }
                    intent = new Intent();
                    intent.putExtra("Chat_User", str3);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.scanner.b.imv.e(intent, this.qb);
                    obj = 1;
                }
                if (obj == null) {
                    if (this.pdt != null) {
                        this.pdt.k(1, null);
                    }
                } else if (this.pdt != null) {
                    bundle = new Bundle();
                    bundle.putString("geta8key_fullurl", n.a(((aa) kVar).Jx().ttp));
                    bundle.putInt("geta8key_action_code", 4);
                    this.pdt.k(3, bundle);
                }
            }
        } else if (kVar.getType() == 233) {
            int i3;
            String IQ = ((l) kVar).IQ();
            Bundle bundle2 = new Bundle();
            bundle2.putString("geta8key_fullurl", IQ);
            bundle2.putInt("geta8key_action_code", ((l) kVar).IS());
            if (this.pdt != null) {
                this.pdt.k(4, bundle2);
            }
            if (this.pdv > 0) {
                i3 = this.pdv;
            } else {
                i3 = si(this.pdq);
            }
            w.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[]{Integer.valueOf(i3)});
            boolean a = com.tencent.mm.plugin.z.a.c.a(this, (l) kVar, new OnClickListener(this) {
                final /* synthetic */ e pdx;

                {
                    this.pdx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.pdx.pdt != null) {
                        this.pdx.pdt.k(1, null);
                    }
                }
            }, this.pdr, i3, this.pdq, new Runnable(this) {
                final /* synthetic */ e pdx;

                {
                    this.pdx = r1;
                }

                public final void run() {
                    if (this.pdx.pdt != null) {
                        this.pdx.pdt.k(3, null);
                    }
                }
            }, this.pds);
            if (a || ((l) kVar).IS() != 4) {
                w.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[]{Boolean.valueOf(a)});
                if (!a && this.pdt != null) {
                    this.pdt.k(1, null);
                    return;
                }
                return;
            }
            a(this.qb, this.pdq, IQ, true);
        } else if (kVar.getType() != 666) {
        } else {
            if (i != 0 || i2 != 0) {
                w.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
            } else if (kVar instanceof y) {
                w.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[]{((y) kVar).Jv().tgW});
                Intent intent3 = new Intent();
                intent3.putExtra("extra_id", r0);
                intent3.putExtra("preceding_scence", 11);
                intent3.putExtra("download_entrance_scene", 14);
                d.b(this.qb, "emoji", ".ui.EmojiStoreDetailUI", intent3);
                w.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
                if (this.pdt != null) {
                    this.pdt.k(3, null);
                }
            }
        }
    }

    public final Context getContext() {
        return this.qb;
    }

    public final void gu(boolean z) {
        if (z) {
            if (this.pdt != null) {
                this.pdt.k(1, null);
            }
        } else if (this.pdt != null) {
            this.pdt.k(3, null);
        }
    }
}
