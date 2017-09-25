package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements am {
    private static HashMap<Integer, c> gJr;
    private a kAf = new a(this) {
        final /* synthetic */ b oft;

        {
            this.oft = r1;
        }

        public final void a(final d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:" + a);
            this.oft.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 ofv;

                public final void run() {
                    com.tencent.mm.plugin.order.model.c aRz = b.aRz();
                    String str = a;
                    String str2 = aVar.hst.tfc;
                    if (!TextUtils.isEmpty(str)) {
                        j Cn = com.tencent.mm.plugin.order.model.c.Cn(str);
                        if (Cn == null) {
                            w.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                        } else if (!TextUtils.isEmpty(Cn.ogT) || !TextUtils.isEmpty(Cn.ohk) || !TextUtils.isEmpty(Cn.ohj) || !TextUtils.isEmpty(Cn.fSs) || !TextUtils.isEmpty(Cn.ohf) || !TextUtils.isEmpty(Cn.ohg) || !TextUtils.isEmpty(Cn.ohe) || !TextUtils.isEmpty(Cn.ohi) || !TextUtils.isEmpty(Cn.ohh) || !TextUtils.isEmpty(Cn.ohd)) {
                            if (Cn.ohd != null && com.tencent.mm.plugin.order.c.c.tb(Cn.ohd)) {
                                int intValue = Integer.valueOf(Cn.ohd).intValue();
                                if (!(intValue == 2 || intValue == 1)) {
                                    return;
                                }
                            }
                            if (TextUtils.isEmpty(Cn.ohf)) {
                                Cn.fSm = str2;
                            } else {
                                Cn.fSm = str2 + Cn.ohf;
                            }
                            w.i("MicroMsg.MallPayMsgManager", "msgid: " + Cn.fSm);
                            w.i("MicroMsg.MallPayMsgManager", "msgType: " + Cn.ohd);
                            if (aRz.Cp(Cn.fSm)) {
                                w.e("MicroMsg.MallPayMsgManager", "msg for id " + Cn.fSm + " is exist!!");
                                com.tencent.mm.plugin.order.b.a Cr = aRz.Cr(Cn.fSm);
                                aRz.Co(Cn.fSm);
                                aRz.kdw.add(Cn);
                                aRz.a(Cn, str, Cr.field_isRead);
                            } else {
                                aRz.kdw.add(Cn);
                                aRz.a(Cn, str, "0");
                            }
                            aRz.aRD();
                            b aRw = b.aRw();
                            if (Cn != null) {
                                apu com_tencent_mm_protocal_c_apu = new apu();
                                if (TextUtils.isEmpty(Cn.ohf) || !com.tencent.mm.plugin.order.c.c.tb(Cn.ohf)) {
                                    com_tencent_mm_protocal_c_apu.ogM = (int) (System.currentTimeMillis() / 1000);
                                    com_tencent_mm_protocal_c_apu.ogO = (int) (System.currentTimeMillis() / 1000);
                                } else {
                                    com_tencent_mm_protocal_c_apu.ogM = Integer.valueOf(Cn.ohf).intValue();
                                    com_tencent_mm_protocal_c_apu.ogO = Integer.valueOf(Cn.ohf).intValue();
                                }
                                com_tencent_mm_protocal_c_apu.ogR = 100000;
                                com_tencent_mm_protocal_c_apu.ogT = Cn.ogT;
                                com_tencent_mm_protocal_c_apu.ogJ = Cn.fSm;
                                com_tencent_mm_protocal_c_apu.ogN = Cn.ohh;
                                com_tencent_mm_protocal_c_apu.tUP = -1;
                                com_tencent_mm_protocal_c_apu.ogU = Cn.ohe;
                                com_tencent_mm_protocal_c_apu.ogV = Cn.ohh;
                                com_tencent_mm_protocal_c_apu.ogW = Cn.fSs;
                            }
                            aRw.aRx();
                        }
                    }
                }
            });
        }
    };
    private List<WeakReference<Object>> kcI = new ArrayList();
    public ae mHandler = new ae(Looper.getMainLooper());
    com.tencent.mm.plugin.order.model.b ofp = null;
    private com.tencent.mm.plugin.order.b.b ofq;
    private com.tencent.mm.plugin.order.model.c ofr = null;
    private a ofs = new a(this) {
        final /* synthetic */ b oft;

        {
            this.oft = r1;
        }

        public final void a(d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            w.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:" + a);
            this.oft.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 ofu;

                public final void run() {
                    b bVar = this.ofu.oft;
                    h.vG().uQ();
                    if (bVar.ofp == null) {
                        bVar.ofp = new com.tencent.mm.plugin.order.model.b();
                    }
                    com.tencent.mm.plugin.order.model.b bVar2 = bVar.ofp;
                    String str = a;
                    if (!bg.mA(str)) {
                        Map q = bh.q(str, "sysmsg");
                        if (q != null) {
                            try {
                                str = (String) q.get(".sysmsg.wxpay.transid");
                                if (!bg.mA(str)) {
                                    w.d("MicroMsg.WalletOrdersManager", "transid " + str);
                                    if (!bVar2.ofJ.contains(str)) {
                                        bVar2.ofJ.add(str);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(204817, Integer.valueOf(bVar2.ofJ.size()));
                                        w.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + bVar2.ofJ.size());
                                        bVar2.aRA();
                                        b.aRw().adZ();
                                    }
                                }
                            } catch (Exception e) {
                                w.e("MicroMsg.WalletOrdersManager", "cmdid error");
                            }
                        }
                    }
                }
            });
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.order.b.b.gUx;
            }
        });
        com.tencent.mm.wallet_core.a.g("ShowOrdersInfoProcess", a.class);
    }

    public static b aRw() {
        b bVar = (b) ap.yR().gs("plugin.order");
        if (bVar != null) {
            return bVar;
        }
        w.w("MicroMsg.SubCoreWalletOrder", "not found in MMCore, new one");
        Object bVar2 = new b();
        ap.yR().a("plugin.order", bVar2);
        return bVar2;
    }

    public final void aRx() {
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
        }
    }

    public final void adZ() {
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
        }
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        this.ofp = null;
        this.ofr = null;
    }

    public final void onAccountRelease() {
    }

    public static com.tencent.mm.plugin.order.b.b aRy() {
        h.vG().uQ();
        if (aRw().ofq == null) {
            b aRw = aRw();
            ap.yY();
            aRw.ofq = new com.tencent.mm.plugin.order.b.b(com.tencent.mm.u.c.wO());
        }
        return aRw().ofq;
    }

    public static com.tencent.mm.plugin.order.model.c aRz() {
        h.vG().uQ();
        if (aRw().ofr == null) {
            aRw().ofr = new com.tencent.mm.plugin.order.model.c();
        }
        return aRw().ofr;
    }

    public static String aHI() {
        if (!ap.zb()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(com.tencent.mm.u.c.xb()).append("order").toString();
    }
}
