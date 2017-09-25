package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.nfc.NfcAdapter;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.util.HashMap;

public final class a implements am {
    private com.tencent.mm.plugin.nfc_open.b.a nZo;

    private static a aPb() {
        a aVar = (a) ap.yR().gs("plugin.nfc_open");
        if (aVar != null) {
            return aVar;
        }
        w.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
        Object aVar2 = new a();
        ap.yR().a("plugin.nfc_open", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aN(boolean z) {
    }

    public final void aM(boolean z) {
        boolean z2;
        int i = 1800;
        h.vG().uQ();
        if (aPb().nZo == null) {
            aPb().nZo = new com.tencent.mm.plugin.nfc_open.b.a();
        }
        com.tencent.mm.plugin.nfc_open.b.a aVar = aPb().nZo;
        if (NfcAdapter.getDefaultAdapter(ab.getContext()) == null) {
            w.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        } else if (aVar.nZq != null) {
            int i2 = aVar.nZq.tsZ;
            if (i2 >= 1800) {
                i = i2 > 604800 ? 604800 : i2;
            }
            w.i("MicroMsg.CpuCardConfigManager", "now=" + bg.Ny() + ", lastUpdateTime=" + aVar.nZq.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + aVar.nZq.tsZ);
            if (bg.Ny() - aVar.nZq.lastUpdateTime > ((long) i)) {
                z2 = true;
                if (z2) {
                    w.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
                    ap.vd().a(1561, aVar);
                    ap.vd().a(new b(aVar.nZq.version), 0);
                }
                ap.yY();
                i = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBs, Integer.valueOf(0))).intValue();
                if (i == 0) {
                    ap.yY();
                    if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBt, Integer.valueOf(0))).intValue() != 1) {
                        fZ(true);
                    } else {
                        fZ(false);
                    }
                } else if (i != 1) {
                    fZ(true);
                } else {
                    fZ(false);
                }
                w.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
                e.post(new Runnable(this) {
                    final /* synthetic */ a nZp;

                    {
                        this.nZp = r1;
                    }

                    public final void run() {
                        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "system_config_prefs", 4);
                        if (bg.aB(sharedPreferences.getLong("NFC_REPORT_TIME", 0)) > 86400000) {
                            int cF = com.tencent.mm.plugin.nfc.b.a.a.aOZ().cF(ab.getContext());
                            if (cF == 0) {
                                g.oUh.i(12779, new Object[]{p.rA(), Integer.valueOf(0)});
                            } else {
                                g.oUh.i(12779, new Object[]{p.rA(), Integer.valueOf(1)});
                            }
                            Editor edit = sharedPreferences.edit();
                            edit.putLong("NFC_REPORT_TIME", bg.NA());
                            edit.commit();
                            w.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = " + cF);
                        }
                    }
                }, getClass().getName());
            }
        }
        z2 = false;
        if (z2) {
            w.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            ap.vd().a(1561, aVar);
            ap.vd().a(new b(aVar.nZq.version), 0);
        }
        ap.yY();
        i = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBs, Integer.valueOf(0))).intValue();
        if (i == 0) {
            ap.yY();
            if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBt, Integer.valueOf(0))).intValue() != 1) {
                fZ(false);
            } else {
                fZ(true);
            }
        } else if (i != 1) {
            fZ(false);
        } else {
            fZ(true);
        }
        w.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        e.post(/* anonymous class already generated */, getClass().getName());
    }

    private static void fZ(boolean z) {
        if (z) {
            ab.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ab.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
        } else {
            ab.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ab.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        }
    }

    public final void onAccountRelease() {
    }
}
