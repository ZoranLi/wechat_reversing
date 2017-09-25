package com.tencent.mm.plugin.nfc.b.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    private static a nZi = null;
    private Set<String> nZj;
    public d nZk = null;

    public static a aOZ() {
        if (nZi == null) {
            nZi = new a();
        }
        return nZi;
    }

    public final boolean a(Tag tag) {
        super.a(tag);
        this.nZj = new HashSet();
        for (String str : tag.getTechList()) {
            w.d("MicroMsg.ApduEngine", "[NFC]tech : " + str);
            this.nZj.add(str);
        }
        try {
            if (this.nZk != null && this.nZk.isConnected()) {
                this.nZk.close();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ApduEngine", e, "", new Object[0]);
            w.e("MicroMsg.ApduEngine", e.toString());
        }
        if (this.nZj.contains(IsoDep.class.getName())) {
            this.nZk = new b(tag);
            return true;
        } else if (this.nZj.contains(NfcA.class.getName())) {
            this.nZk = new c(tag);
            return true;
        } else {
            w.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
            return false;
        }
    }

    public final c a(com.tencent.mm.plugin.nfc.a.a aVar) {
        com.tencent.mm.plugin.nfc.b.a aVar2 = new com.tencent.mm.plugin.nfc.b.a(1, "def", aVar);
        a(aVar2);
        return aVar2.nZf;
    }

    private boolean a(com.tencent.mm.plugin.nfc.b.a aVar) {
        if (this.nZk == null) {
            w.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
            throw new IllegalStateException("ApduEngine not ready !");
        } else if (aVar == null || aVar.nZe == null) {
            w.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
            throw new IllegalArgumentException("apdu is null !");
        } else {
            w.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] do cmd : " + aVar.nZe.toString());
            aVar.nZf = this.nZk.a(aVar.nZe);
            c cVar = aVar.nZf;
            if (((short) (cVar.aOY() | (cVar.aOX() << 8))) == (short) -28672) {
                w.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> OK : " + aVar.nZf.toString());
                return true;
            }
            w.e("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> fail : " + aVar.nZf.toString());
            return false;
        }
    }

    public final boolean a(List<com.tencent.mm.plugin.nfc.b.a> list, boolean z, boolean z2) {
        for (com.tencent.mm.plugin.nfc.b.a a : list) {
            boolean a2 = a(a);
            if (!a2 && z) {
                return false;
            }
            if (a2 && z2) {
                return false;
            }
        }
        return true;
    }

    public final int cE(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter == null) {
            w.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
            return 0;
        } else if (!defaultAdapter.isEnabled()) {
            return 1;
        } else {
            if (this.nZk == null) {
                return 4;
            }
            try {
                if (this.nZk == null || !this.nZk.isConnected()) {
                    return 2;
                }
                return 3;
            } catch (IOException e) {
                w.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
                return 2;
            }
        }
    }

    public final int cF(Context context) {
        int cE = cE(context);
        if (cE != 3 && cE != 2) {
            return cE;
        }
        try {
            if (this.nZk != null) {
                this.nZk.connect();
                if (this.nZk.isConnected()) {
                    return 3;
                }
            }
            return 2;
        } catch (IOException e) {
            w.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
            return 2;
        }
    }

    public final String getInfo() {
        if (this.nZg == null) {
            w.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
            return null;
        }
        long Nz = bg.Nz();
        JSONObject jSONObject = new JSONObject();
        w.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.nZj.size());
        for (String str : this.nZj) {
            w.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = " + str);
            Object obj;
            if (str.equals(NfcA.class.getName())) {
                NfcA nfcA = NfcA.get(this.nZg);
                if (nfcA == null) {
                    w.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
                    obj = null;
                } else {
                    try {
                        obj = new JSONObject();
                        obj.put("atqa", com.tencent.mm.plugin.nfc.c.a.aB(nfcA.getAtqa()));
                        obj.put("sak", com.tencent.mm.plugin.nfc.c.a.aB(com.tencent.mm.plugin.nfc.c.a.b(nfcA.getSak())));
                    } catch (JSONException e) {
                        w.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + e.getLocalizedMessage());
                        return jSONObject.toString();
                    }
                }
                jSONObject.put(NfcA.class.getSimpleName(), obj);
            } else if (str.equals(IsoDep.class.getName())) {
                IsoDep isoDep = IsoDep.get(this.nZg);
                if (isoDep == null) {
                    w.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
                    obj = null;
                } else {
                    obj = new JSONObject();
                    obj.put("hiLayerResponse", com.tencent.mm.plugin.nfc.c.a.aB(isoDep.getHiLayerResponse()));
                    obj.put("historicalBytes", com.tencent.mm.plugin.nfc.c.a.aB(isoDep.getHistoricalBytes()));
                }
                jSONObject.put(IsoDep.class.getSimpleName(), obj);
            }
        }
        w.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (bg.Nz() - Nz));
        w.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + jSONObject.toString());
        return jSONObject.toString();
    }
}
