package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.a.ku;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.f.a.j;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class d extends c<rz> implements e {
    public int rPK;
    public int rPL;
    public gr rPM;
    public ku rPN;
    public long rPO;
    public c rPP;
    public c<ku> rPQ;

    public d() {
        this.rPL = 0;
        this.rPP = new c<gr>(this) {
            final /* synthetic */ d rPR;

            {
                this.rPR = r2;
                this.usg = gr.class.getName().hashCode();
            }

            private boolean a(gr grVar) {
                this.rPR.rPM = grVar;
                String str = this.rPR.rPM.fLZ.result;
                if (this.rPR.rPM.fLZ.fMb != null) {
                    this.rPR.rPL = this.rPR.rPM.fLZ.fMb.getInt("pay_channel", 0);
                }
                switch (this.rPR.rPM.fLZ.actionCode) {
                    case 10:
                    case 11:
                        a.urY.b(this.rPR);
                        w.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = " + str);
                        if (str == null) {
                            return true;
                        }
                        if (str.startsWith("weixin://wxpay")) {
                            this.rPR.rPK = 4;
                            ap.vd().a(233, this.rPR);
                            ap.vd().a(new l(str, this.rPR.rPM.fLZ.username, 4, (int) System.currentTimeMillis()), 0);
                            this.rPR.rPO = System.currentTimeMillis();
                        } else {
                            this.rPR.rPK = 1;
                            this.rPR.bY(str, this.rPR.rPL);
                        }
                        return true;
                    case 12:
                        d dVar = this.rPR;
                        w.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = " + str);
                        str = null;
                        Object obj = null;
                        String str2 = null;
                        for (String str3 : str.replace("http://p.weixin.qq.com?", "").split("&")) {
                            if (str3.startsWith("errcode=")) {
                                obj = str3.replace("errcode=", "");
                            } else if (str3.startsWith("errmsg=")) {
                                str = str3.replace("errmsg=", "");
                            } else if (str3.startsWith("importkey=")) {
                                str2 = str3.replace("importkey=", "");
                            }
                        }
                        if (!"0".equals(obj) || bg.mA(str2)) {
                            if (bg.mA(str)) {
                                str = dVar.rPM.fLZ.context.getString(R.l.fkA);
                            }
                            g.a(dVar.rPM.fLZ.context, str, "", new OnClickListener(dVar) {
                                final /* synthetic */ d rPR;

                                {
                                    this.rPR = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.rPR.rPM.nFq != null) {
                                        this.rPR.rPM.fMa.ret = 1;
                                        this.rPR.rPM.nFq.run();
                                    }
                                }
                            });
                        } else {
                            Context context = dVar.rPM.fLZ.context;
                            Intent intent = new Intent();
                            intent.putExtra("key_import_key", str2);
                            intent.putExtra("key_bind_scene", 2);
                            intent.putExtra("key_custom_bind_tips", null);
                            com.tencent.mm.bb.d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
                            if (dVar.rPM.nFq != null) {
                                dVar.rPM.fMa.ret = 1;
                                dVar.rPM.nFq.run();
                            }
                        }
                        return true;
                    default:
                        return false;
                }
            }
        };
        this.rPQ = new c<ku>(this) {
            final /* synthetic */ d rPR;

            {
                this.rPR = r2;
                this.usg = ku.class.getName().hashCode();
            }

            private boolean a(ku kuVar) {
                this.rPR.rPN = kuVar;
                String str = kuVar.fRp.url;
                int i = kuVar.fRp.scene;
                int i2 = kuVar.fRp.fRr;
                int i3 = kuVar.fRp.fFq;
                String str2 = kuVar.fRp.aJE == null ? "" : kuVar.fRp.aJE;
                this.rPR.rPK = 1;
                w.d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2});
                k jVar = new j(str, i, this.rPR.rPK, i2, i3, str2);
                ap.vd().a(385, this.rPR);
                ap.vd().a(jVar, 0);
                return false;
            }
        };
        this.usg = rz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rz rzVar = (rz) bVar;
        o.ccg();
        if (rzVar instanceof rz) {
            w.d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (rzVar.fZv.result == -1));
            a.urY.c(this);
            if (rzVar.fZv.result != -1) {
                return true;
            }
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (rzVar.fZv.intent == null || rzVar.fZv.intent.getIntExtra("pay_channel", 0) != 13) {
                com.tencent.mm.bb.d.a(rzVar.fZv.context, ".ui.LauncherUI", intent);
                return true;
            }
            w.i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
            return true;
        }
        w.f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            long currentTimeMillis = System.currentTimeMillis() - this.rPO;
            com.tencent.mm.plugin.report.service.g.oUh.i(11170, new Object[]{Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(am.getNetType(ab.getContext())), ""});
            f(i, i2, currentTimeMillis);
            w.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
            ap.vd().b(233, this);
            if (i == 0 && i2 == 0) {
                bY(((l) kVar).IQ(), this.rPL);
                return;
            }
            if (bg.mA(str)) {
                str = this.rPM.fLZ.context.getString(R.l.fkA);
            }
            g.a(this.rPM.fLZ.context, str, "", new OnClickListener(this) {
                final /* synthetic */ d rPR;

                {
                    this.rPR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.rPR.rPM.nFq != null) {
                        this.rPR.rPM.fMa.ret = 1;
                        this.rPR.rPM.nFq.run();
                    }
                }
            });
        } else if (kVar instanceof j) {
            w.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            ap.vd().b(385, this);
            if (i == 0 && i2 == 0 && "0".equals(((j) kVar).wEQ)) {
                j jVar = (j) kVar;
                PayInfo payInfo = new PayInfo();
                payInfo.fRv = this.rPK;
                payInfo.fJH = jVar.fJH;
                payInfo.appId = jVar.appId;
                payInfo.rPJ = jVar.rPJ;
                payInfo.fGa = jVar.fGa;
                payInfo.fRr = jVar.fRr;
                w.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[]{payInfo.toString()});
                com.tencent.mm.pluginsdk.wallet.e.a(this.rPN.fRp.context, payInfo, 0);
                if (this.rPN.nFq != null) {
                    this.rPN.fRq.ret = 1;
                    this.rPN.nFq.run();
                    return;
                }
                return;
            }
            if (bg.mA(str)) {
                if (bg.mA(((j) kVar).kAZ)) {
                    str = this.rPN.fRp.context.getString(R.l.fkA);
                } else {
                    str = ((j) kVar).kAZ;
                }
            }
            g.a(this.rPN.fRp.context, str, "", new OnClickListener(this) {
                final /* synthetic */ d rPR;

                {
                    this.rPR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.rPR.rPN.nFq != null) {
                        this.rPR.rPN.fRq.ret = 1;
                        this.rPR.rPN.nFq.run();
                    }
                }
            });
        } else {
            w.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
        }
    }

    public final void bY(String str, int i) {
        String str2 = null;
        w.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = " + str);
        PayInfo payInfo = new PayInfo();
        payInfo.fRv = this.rPK;
        Object obj = null;
        for (String str3 : str.replace("http://p.qq.com?", "").split("&")) {
            if (str3.startsWith("errcode=")) {
                obj = str3.replace("errcode=", "");
            } else if (str3.startsWith("errmsg=")) {
                str2 = str3.replace("errmsg=", "");
            } else if (str3.startsWith("reqkey=")) {
                payInfo.fJH = str3.replace("reqkey=", "");
            } else if (str3.startsWith("uuid=")) {
                payInfo.mry = str3.replace("uuid=", "");
            } else if (str3.startsWith("appid=")) {
                payInfo.appId = str3.replace("appid=", "");
            } else if (str3.startsWith("appsource=")) {
                payInfo.rPJ = str3.replace("appsource=", "");
            } else if (str3.startsWith("productid=")) {
                payInfo.fGa = str3.replace("productid=", "");
            }
        }
        payInfo.fRr = i;
        if ("0".equals(obj)) {
            com.tencent.mm.pluginsdk.wallet.e.a(this.rPM.fLZ.context, payInfo, 0);
            if (this.rPM.nFq != null) {
                this.rPM.fMa.ret = 1;
                this.rPM.nFq.run();
            }
        } else {
            if (bg.mA(str2)) {
                str2 = this.rPM.fLZ.context.getString(R.l.fkA);
            }
            g.a(this.rPM.fLZ.context, str2, "", new OnClickListener(this) {
                final /* synthetic */ d rPR;

                {
                    this.rPR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.rPR.rPM.nFq != null) {
                        this.rPR.rPM.fMa.ret = 1;
                        this.rPR.rPM.nFq.run();
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(obj) && Pattern.compile("[0-9]*").matcher(obj).matches()) {
            f(0, Integer.valueOf(obj).intValue(), 0);
        }
    }

    private void f(int i, int i2, long j) {
        IDKey iDKey;
        int i3 = 132;
        if (this.rPK == 1) {
            i3 = 163;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i3);
        iDKey2.SetValue(1);
        iDKey2.SetKey(26);
        arrayList.add(iDKey2);
        if (!(i == 0 && i2 == 0)) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            iDKey2.SetKey(8);
            if (i2 < 0) {
                iDKey.SetKey(9);
            } else if (i2 > 0) {
                iDKey.SetKey(10);
            }
        }
        if (this.rPK == 4 && j > 0) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i3);
            iDKey3.SetValue((int) j);
            iDKey2.SetKey(0);
            if (j <= 1000) {
                iDKey.SetKey(1);
                iDKey3.SetKey(4);
            } else if (j > 1000 && j <= 3000) {
                iDKey.SetKey(2);
                iDKey3.SetKey(5);
            } else if (j > 3000) {
                iDKey.SetKey(3);
                iDKey3.SetKey(6);
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey);
            arrayList.add(iDKey3);
        }
        com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, true);
    }
}
