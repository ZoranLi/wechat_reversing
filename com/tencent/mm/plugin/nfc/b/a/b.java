package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.w;

public final class b implements d {
    private IsoDep nZl;

    public b(Tag tag) {
        if (tag == null) {
            w.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            throw new IllegalStateException("tag is null");
        } else {
            this.nZl = IsoDep.get(tag);
        }
    }

    public final boolean connect() {
        if (!this.nZl.isConnected()) {
            this.nZl.connect();
        }
        return true;
    }

    public final void close() {
        if (this.nZl.isConnected()) {
            this.nZl.close();
        }
    }

    public final boolean isConnected() {
        return this.nZl.isConnected();
    }

    public final boolean aPa() {
        close();
        connect();
        return true;
    }

    public final c a(a aVar) {
        if (this.nZl == null) {
            w.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            throw new IllegalStateException("IsoDep is null");
        }
        connect();
        c cVar = null;
        while (true) {
            c cVar2 = new c(this.nZl.transceive(aVar.getBytes()));
            if (cVar2.nYV.length == 0) {
                return cVar;
            }
            if (cVar2.nYV.length - 2 <= 0) {
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
                aVar = new a((byte[]) com.tencent.mm.plugin.nfc.a.b.nZd.clone());
            }
        }
    }
}
