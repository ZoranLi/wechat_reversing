package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.w;

public final class c implements d {
    private NfcA nZm;

    public c(Tag tag) {
        this.nZm = NfcA.get(tag);
    }

    public final com.tencent.mm.plugin.nfc.a.c a(a aVar) {
        if (this.nZm == null) {
            w.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            throw new IllegalStateException("NfcA is null");
        }
        connect();
        com.tencent.mm.plugin.nfc.a.c cVar = null;
        while (true) {
            com.tencent.mm.plugin.nfc.a.c cVar2 = new com.tencent.mm.plugin.nfc.a.c(this.nZm.transceive(aVar.getBytes()));
            if (cVar2.nYV.length == 0) {
                return cVar;
            }
            if (cVar2.nYV.length - 2 < 0) {
                return cVar2;
            }
            if (cVar2.aOX() == (short) 108) {
                aVar.qv(cVar2.aOY());
            } else {
                if (cVar == null) {
                    cVar = cVar2;
                } else {
                    cVar.a(cVar2);
                }
                if (cVar2.aOX() != (short) 97) {
                    return cVar;
                }
                if (cVar2.aOY() != (short) 0) {
                    aVar = new a((byte[]) b.nZd.clone());
                } else {
                    cVar.nYV[cVar.nYV.length - 1] = (byte) -112;
                    return cVar;
                }
            }
        }
    }

    public final boolean connect() {
        if (!this.nZm.isConnected()) {
            this.nZm.connect();
        }
        return true;
    }

    public final void close() {
        if (this.nZm.isConnected()) {
            this.nZm.close();
        }
    }

    public final boolean isConnected() {
        return this.nZm.isConnected();
    }

    public final boolean aPa() {
        close();
        connect();
        return true;
    }
}
