package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a implements e {
    public anv nZq;

    public a() {
        init();
    }

    private void init() {
        this.nZq = new anv();
        ap.yY();
        String valueOf = String.valueOf(c.vr().get(com.tencent.mm.storage.w.a.uBn, null));
        if (bg.mA(valueOf)) {
            this.nZq.tsY = new LinkedList();
            this.nZq.lastUpdateTime = 0;
            this.nZq.tsZ = 86400;
            this.nZq.version = 0;
            return;
        }
        try {
            this.nZq.aD(valueOf.getBytes("ISO-8859-1"));
        } catch (Exception e) {
            w.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
            this.nZq.tsY = new LinkedList();
            this.nZq.lastUpdateTime = 0;
            this.nZq.tsZ = 86400;
            this.nZq.version = 0;
        }
    }

    private void a(anv com_tencent_mm_protocal_c_anv) {
        if (!ap.zb()) {
            w.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
        } else if (com_tencent_mm_protocal_c_anv != null) {
            w.i("MicroMsg.CpuCardConfigManager", "setConfig config");
            this.nZq = com_tencent_mm_protocal_c_anv;
            try {
                String str = new String(this.nZq.toByteArray(), "ISO-8859-1");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uBn, str);
            } catch (UnsupportedEncodingException e) {
                w.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                w.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
        }
    }

    private anv aPc() {
        if (this.nZq == null) {
            init();
        }
        return this.nZq;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ap.vd().b(1561, this);
        if (kVar instanceof b) {
            anv aPc = aPc();
            aPc.lastUpdateTime = bg.Ny();
            if (i == 0 && i2 == 0) {
                mq mqVar = (mq) ((b) kVar).gUA.hsk.hsr;
                if (mqVar != null) {
                    aPc.tsZ = mqVar.tsZ;
                    aPc.tta = mqVar.tta;
                    ap.yY();
                    if (((Integer) c.vr().get(com.tencent.mm.storage.w.a.uBs, Integer.valueOf(0))).intValue() == 0) {
                        if (mqVar.tta == 1) {
                            ab.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ab.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                        } else {
                            ab.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ab.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                        }
                    }
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uBt, Integer.valueOf(mqVar.tta));
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uBw, mqVar.rCi);
                    if (aPc.version == mqVar.version) {
                        w.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + mqVar.version);
                        a(aPc);
                        return;
                    }
                    aPc.version = mqVar.version;
                    if (mqVar.tsY == null || mqVar.tsY.isEmpty()) {
                        aPc.tsY.clear();
                    } else {
                        if (aPc.tsY == null) {
                            aPc.tsY = new LinkedList();
                        } else {
                            aPc.tsY.clear();
                        }
                        for (int i3 = 0; i3 < mqVar.tsY.size(); i3++) {
                            is isVar = new is();
                            isVar.tbt = ((is) mqVar.tsY.get(i3)).tbt;
                            isVar.tnx = ((is) mqVar.tsY.get(i3)).tnx;
                            w.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bg.f(Integer.valueOf(isVar.tnx)) + ", url=" + bg.mz(isVar.tbt));
                            if (isVar.tnw == null) {
                                isVar.tnw = new LinkedList();
                            } else {
                                isVar.tnw.clear();
                            }
                            for (int i4 = 0; i4 < ((is) mqVar.tsY.get(i3)).tnw.size(); i4++) {
                                mr mrVar = new mr();
                                if (mrVar.ttb == null) {
                                    mrVar.ttb = new LinkedList();
                                } else {
                                    mrVar.ttb.clear();
                                }
                                for (int i5 = 0; i5 < ((mr) ((is) mqVar.tsY.get(i3)).tnw.get(i4)).ttb.size(); i5++) {
                                    lt ltVar = new lt();
                                    ltVar.gaJ = ((lt) ((mr) ((is) mqVar.tsY.get(i3)).tnw.get(i4)).ttb.get(i5)).gaJ;
                                    ltVar.nmZ = ((lt) ((mr) ((is) mqVar.tsY.get(i3)).tnw.get(i4)).ttb.get(i5)).nmZ;
                                    w.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bg.mz(ltVar.gaJ) + ", answer=" + bg.mz(ltVar.nmZ));
                                    mrVar.ttb.add(ltVar);
                                }
                                isVar.tnw.add(mrVar);
                            }
                            aPc.tsY.add(isVar);
                        }
                    }
                }
            }
            a(aPc);
        }
    }
}
