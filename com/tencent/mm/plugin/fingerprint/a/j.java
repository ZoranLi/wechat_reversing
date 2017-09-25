package com.tencent.mm.plugin.fingerprint.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.d.a.c.h;
import com.tencent.d.b.a.e;
import com.tencent.d.b.c.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j extends a {
    public a lOA = null;
    private k lOz = null;

    public final boolean auZ() {
        boolean z;
        if (p.gRg.gRo == 1) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(com.tencent.d.b.a.cfL())});
        return z && com.tencent.d.b.a.cfL();
    }

    public final boolean ava() {
        return com.tencent.d.a.a.hd(ab.getContext());
    }

    public final void avb() {
        w.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
        e.en(true);
        e.em(true);
        b.blZ();
    }

    public final boolean avc() {
        return false;
    }

    public final void bZ(Context context) {
        w.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    }

    public final boolean avd() {
        return auZ();
    }

    @TargetApi(16)
    public final int a(final com.tencent.mm.pluginsdk.wallet.b bVar, int i, boolean z) {
        if (z) {
            w.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
        } else {
            com.tencent.d.b.c.b anonymousClass1 = new com.tencent.d.b.c.b(this) {
                final /* synthetic */ j lOC;

                public final void avw() {
                    w.i("MicroMsg.SoterAuthMgrImp", "alvinluo onStartAuthentication");
                }

                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                    w.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationHelp helpCode: %d, helpString: %s", new Object[]{Integer.valueOf(i), charSequence});
                    if (bVar != null) {
                        bVar.av(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, -1);
                    }
                }

                public final void avx() {
                    this.lOC.lOA = null;
                    w.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationSucceed");
                }

                public final void onAuthenticationFailed() {
                    w.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationFailed");
                    if (bVar != null) {
                        bVar.av(MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK, -1);
                    }
                }

                public final void avy() {
                    w.i("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationCancelled");
                    this.lOC.lOA = null;
                }

                public final void onAuthenticationError(int i, CharSequence charSequence) {
                    w.e("MicroMsg.SoterAuthMgrImp", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), charSequence});
                    this.lOC.lOA = null;
                }
            };
            this.lOA = new a();
            com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.a>(this) {
                final /* synthetic */ j lOC;

                public final /* synthetic */ void a(e eVar) {
                    com.tencent.d.b.a.a aVar = (com.tencent.d.b.a.a) eVar;
                    w.i("MicroMsg.SoterAuthMgrImp", "alvinluo requestAuthAndSign onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(aVar.errCode), aVar.fPf});
                    if (aVar.isSuccess()) {
                        q.rHB.rHD = (h) aVar.wZO;
                        if (bVar != null) {
                            bVar.av(0, -1);
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.plugin.soter.c.a.dj(3, aVar.errCode);
                    if (aVar.errCode == 13) {
                        w.i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                        com.tencent.d.a.a.bd(e.avl(), true);
                        if (bVar != null) {
                            bVar.av(2007, -1);
                        }
                    } else if (aVar.errCode == 25) {
                        w.i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                        if (bVar != null) {
                            bVar.av(10308, -1);
                        }
                    } else if (aVar.errCode == 24) {
                        w.i("MicroMsg.SoterAuthMgrImp", "alvinluo user cancelled");
                        if (bVar != null) {
                            bVar.av(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, -1);
                        }
                    } else if (aVar.errCode == 26) {
                        w.e("MicroMsg.SoterAuthMgrImp", "alvinluo add authenticate task failed");
                        if (bVar != null) {
                            bVar.av(2009, -1);
                        }
                    } else if (bVar != null) {
                        bVar.av(2005, -1);
                    }
                }
            }, new com.tencent.d.b.f.b.a().Df(1).ho(ab.getContext()).a(this.lOA).VK(q.rHB.lOH).a(anonymousClass1).xan);
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final void ave() {
        w.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    @SuppressLint({"NewApi"})
    public final void avf() {
        w.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    public final void a(ko koVar, int i) {
        w.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
        koVar.fRa.fRe = avv();
        koVar.fRa.errCode = !bg.mA(koVar.fRa.fRe) ? 0 : 1;
        koVar.fRa.fRf = 2;
        koVar.fRa.fLU = "";
        koVar.fRa.fLV = "";
        if (koVar.fQZ.fRd != null) {
            koVar.fQZ.fRd.run();
        }
    }

    private static String avv() {
        h hVar = q.rHB.rHD;
        if (hVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("json", hVar.wZN);
                jSONObject.put("signature", hVar.signature);
                return jSONObject.toString();
            } catch (Throwable e) {
                w.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[]{e.toString()});
                w.printErrStackTrace("MicroMsg.SoterAuthMgrImp", e, "", new Object[0]);
                return "";
            }
        }
        w.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
        return "";
    }

    public final void avg() {
        if (com.tencent.d.a.a.VD(e.avl())) {
            com.tencent.d.a.a.bd(e.avl(), false);
        }
    }

    public final g auY() {
        this.lOz = new k();
        return this.lOz;
    }

    public final Map<String, String> avh() {
        Map<String, String> hashMap = new HashMap();
        c blU = com.tencent.mm.plugin.soter.c.b.blU();
        String str = blU.qPZ;
        String str2 = blU.qQa;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        return hashMap;
    }

    public final com.tencent.mm.pluginsdk.wallet.h avi() {
        return new l();
    }

    public final Map<String, String> avj() {
        return avh();
    }

    public final boolean avk() {
        boolean cfE = com.tencent.d.a.a.cfE();
        boolean VD = com.tencent.d.a.a.VD(e.avl());
        boolean VE = com.tencent.d.a.a.VE(e.avl());
        w.v("MicroMsg.SoterAuthMgrImp", "hasAsk: %b, hasAuthKey: %b, isAuthKeyValid: %b", new Object[]{Boolean.valueOf(cfE), Boolean.valueOf(VD), Boolean.valueOf(VE)});
        if (!(com.tencent.d.a.a.cfE() && com.tencent.d.a.a.VD(e.avl()) && com.tencent.d.a.a.VE(e.avl()))) {
            w.i("MicroMsg.SoterAuthMgrImp", "hy: no ask or auth key");
            q.rHB.lOI = true;
        }
        if (q.rHB.lOI) {
            return false;
        }
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        w.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (!z) {
            String string = bundle.getString("pwd");
            if (bg.mA(string)) {
                w.e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
            } else if (q.rHB.lOI) {
                w.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start gen auth key");
                com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>(this) {
                    final /* synthetic */ j lOC;

                    {
                        this.lOC = r1;
                    }

                    public final /* synthetic */ void a(e eVar) {
                        com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                        w.i("MicroMsg.SoterAuthMgrImp", "hy: gen auth key onResult: errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fPf});
                        if (cVar.isSuccess()) {
                            w.i("MicroMsg.SoterAuthMgrImp", "alvinluo gen auth key and upload success");
                        } else {
                            w.e("MicroMsg.SoterAuthMgrImp", "alvinluo gen or upload auth key failed");
                            com.tencent.mm.plugin.soter.c.a.dj(2, cVar.errCode);
                        }
                        q.rHB.reset();
                    }
                }, true, 1, new com.tencent.mm.plugin.fingerprint.b.c(string), new com.tencent.mm.plugin.soter.b.e());
            }
        }
        return false;
    }

    public final boolean auU() {
        return com.tencent.d.a.a.he(ab.getContext());
    }

    public final void auW() {
        if (this.lOA != null && VERSION.SDK_INT >= 16) {
            w.i("MicroMsg.SoterAuthMgrImp", "alvinluo cancel fingeprint canceller");
            this.lOA.mh(true);
            if (com.tencent.mm.plugin.soter.c.a.blT()) {
                com.tencent.mm.plugin.soter.c.a.c(1, -1000223, -1, "user cancelled");
            }
        }
    }

    public final int type() {
        return 2;
    }
}
