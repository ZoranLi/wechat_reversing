package com.tencent.mm.plugin.hp.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.hp.b.e.AnonymousClass2;
import com.tencent.mm.plugin.hp.b.e.AnonymousClass3;
import com.tencent.mm.plugin.hp.b.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bfe;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements j {
    private final b gUA;
    private e gUD;
    private String mLA;
    private LinkedList<bfe> mLB;
    private boolean mLC;
    private String mLz;

    public a() {
        this("", "", null, false);
    }

    public a(String str, String str2, List<bfe> list) {
        this(str, str2, list, true);
    }

    private a(String str, String str2, List<bfe> list, boolean z) {
        String str3;
        int i = 3;
        this.mLB = new LinkedList();
        this.mLC = true;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new la();
        aVar.hsn = new lb();
        aVar.uri = "/cgi-bin/micromsg-bin/checktinkerupdate";
        aVar.hsl = 922;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        if (z) {
            str3 = str2;
        } else {
            int i2;
            str = "tinker_id_" + BaseBuildInfo.baseRevision();
            str3 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
            list = new LinkedList();
            long j = 0;
            try {
                j = ((long) com.tencent.mm.kernel.a.uX()) & 4294967295L;
                w.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "uin is %s", new Object[]{bg.Qj(String.valueOf(j))});
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e, "tinker patch manager get uin failed.", new Object[0]);
            }
            list.add(cv("code-version", com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION));
            list.add(cv("code-reversion", com.tencent.mm.sdk.platformtools.e.REV));
            String str4 = TencentLocation.NETWORK_PROVIDER;
            if (am.isWifi(ab.getContext())) {
                i2 = 3;
            } else {
                i2 = 2;
            }
            list.add(cv(str4, String.valueOf(i2)));
            list.add(cv("sdk", String.valueOf(VERSION.SDK_INT)));
            list.add(cv("os-name", d.sYJ));
            list.add(cv("device-brand", d.sYG));
            list.add(cv("device-name", d.sYL));
            list.add(cv(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(j)));
            String str5 = TencentLocation.NETWORK_PROVIDER;
            if (!am.isWifi(ab.getContext())) {
                i = 2;
            }
            list.add(cv(str5, String.valueOf(i)));
        }
        this.mLz = str;
        this.mLA = str3;
        this.mLB.addAll(list);
        this.mLC = z;
    }

    public final int getType() {
        return 922;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "doScene");
        this.gUD = eVar2;
        la laVar = (la) this.gUA.hsj.hsr;
        laVar.tro = this.mLz;
        laVar.trp = this.mLA;
        laVar.trq = this.mLB;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bfh com_tencent_mm_protocal_c_bfh = ((lb) ((b) pVar).hsk.hsr).trr;
            if (com_tencent_mm_protocal_c_bfh != null) {
                if (this.mLC) {
                    Object obj;
                    w.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
                    com.tencent.mm.plugin.hp.d.b bVar = new com.tencent.mm.plugin.hp.d.b(com_tencent_mm_protocal_c_bfh);
                    w.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
                    com.tencent.mm.plugin.hp.b.e eVar = new com.tencent.mm.plugin.hp.b.e(bVar);
                    com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", new Object[]{eVar.mLp.toString()});
                    com.tencent.mm.plugin.hp.d.b bVar2 = eVar.mLp;
                    if (bVar2.mLK.intValue() > 4 || bVar2.mLK.intValue() <= 0) {
                        w.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", new Object[]{bVar2.mLK, Integer.valueOf(1), Integer.valueOf(4)});
                        g.oUh.a(614, 24, 1, false);
                        obj = null;
                    } else {
                        if (bVar2.aDp()) {
                            if (TextUtils.isEmpty(bVar2.mLQ)) {
                                w.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
                                g.oUh.a(614, 25, 1, false);
                                obj = null;
                            } else if (TextUtils.isEmpty(bVar2.mLO)) {
                                w.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
                                g.oUh.a(614, 26, 1, false);
                                obj = null;
                            } else if (TextUtils.isEmpty(bVar2.mLP)) {
                                w.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
                                g.oUh.a(614, 27, 1, false);
                                obj = null;
                            }
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
                    } else {
                        if ((eVar.mLp.mLK.intValue() == 3 ? 1 : null) != null) {
                            Context context = ab.getContext();
                            com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(context);
                            if (hp.xgw) {
                                com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
                                n nVar = new n(ab.getContext(), new AnonymousClass3(eVar, context, hp));
                                SharePatchInfo.a(hp.xgs, new SharePatchInfo(hp.xgv.xgA, "00000000000000000000000000000000", Build.FINGERPRINT, "odex"), hp.xgt);
                            } else {
                                com.tencent.tinker.lib.e.a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
                            }
                        } else if (eVar.mLp.aDp()) {
                            com.tencent.tinker.lib.e.a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", new Object[]{eVar.mLp.mLN, eVar.mLp.aDr()});
                            Context context2 = ab.getContext();
                            if (eVar.mLp.mLN.intValue() == 2 && am.isMobile(ab.getContext()) && eVar.mLp.aDq()) {
                                if (com.tencent.mm.plugin.hp.tinker.g.ae(context2, eVar.mLp.mLQ)) {
                                    g.oUh.a(614, 44, 1, false);
                                    w.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", new Object[]{eVar.mLp.mLQ});
                                } else {
                                    if (eVar.mLp.mLM.intValue() == 2) {
                                        i.a(ab.getContext().getString(R.l.emb), ab.getContext().getString(R.l.emd, new Object[]{eVar.mLp.aDr(), ab.getContext().getString(R.l.eYY), bg.ay((long) eVar.mLp.fileSize)}), ab.getContext().getString(R.l.eZc), new OnClickListener(eVar) {
                                            final /* synthetic */ e mLr;

                                            {
                                                this.mLr = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                if (this.mLr.mLp.aDo()) {
                                                    this.mLr.aDh();
                                                }
                                            }
                                        }, ab.getContext().getString(R.l.eYQ), new AnonymousClass2(eVar, context2));
                                    } else if (eVar.mLp.mLM.intValue() == 3) {
                                        w.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
                                        bVar2 = eVar.mLp;
                                        Intent intent = new Intent();
                                        com.tencent.mm.plugin.hp.d.d.a(intent, ap.vd().hsZ, bVar2);
                                        com.tencent.mm.sdk.b.b laVar = new com.tencent.mm.e.a.la();
                                        laVar.fRH.intent = intent;
                                        com.tencent.mm.sdk.b.a.urY.m(laVar);
                                    }
                                    com.tencent.mm.plugin.hp.b.a.nW(4);
                                }
                            } else if (eVar.mLp.aDo() && !com.tencent.mm.plugin.hp.tinker.g.ae(context2, eVar.mLp.mLQ)) {
                                eVar.aDh();
                            }
                        }
                    }
                    w.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
                    com.tencent.mm.plugin.hp.b.a.cj(4, 0);
                } else {
                    w.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui.");
                }
            } else if (str.equalsIgnoreCase("no baseid matched")) {
                com.tencent.mm.plugin.hp.b.a.cj(1, 0);
            } else if (str.equalsIgnoreCase("no update for this patch")) {
                com.tencent.mm.plugin.hp.b.a.cj(2, 0);
            } else if (str.equalsIgnoreCase("no sutable patch available")) {
                com.tencent.mm.plugin.hp.b.a.cj(3, 0);
            } else {
                com.tencent.mm.plugin.hp.b.a.cj(5, 0);
            }
        } else {
            w.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
            com.tencent.mm.plugin.hp.b.a.cj(5, i2);
        }
        this.gUD.a(i2, i3, str, this);
    }

    private static bfe cv(String str, String str2) {
        bfe com_tencent_mm_protocal_c_bfe = new bfe();
        com_tencent_mm_protocal_c_bfe.arH = str;
        com_tencent_mm_protocal_c_bfe.value = str2;
        return com_tencent_mm_protocal_c_bfe;
    }
}
