package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class o {
    public List<ElementQuery> rBV = null;
    public SparseArray<String> rHA = null;

    public final String I(Context context, int i) {
        if (this.rHA != null) {
            String str = (String) this.rHA.get(i);
            if (!bg.mA(str)) {
                return str;
            }
        }
        return context.getString(R.l.fen);
    }

    public final ElementQuery HT(String str) {
        if (this.rBV == null || this.rBV.size() == 0) {
            w.w("MicroMsg.WalletBankElementManager", "hy: no element from given banktype");
            return null;
        }
        for (ElementQuery elementQuery : this.rBV) {
            if (elementQuery.ofd != null && elementQuery.ofd.equals(str)) {
                return elementQuery;
            }
        }
        w.w("MicroMsg.WalletBankElementManager", "hy: not found given banktype: %s", new Object[]{str});
        return null;
    }

    public final ElementQuery HU(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.WalletBankElementManager", "hy: bindSerail given is null");
            return null;
        } else if (this.rBV != null || this.rBV.size() == 0) {
            for (ElementQuery elementQuery : this.rBV) {
                if (str.equals(elementQuery.ofe)) {
                    return elementQuery;
                }
            }
            w.w("MicroMsg.WalletBankElementManager", "hy: not found given element query");
            return null;
        } else {
            w.w("MicroMsg.WalletBankElementManager", "hy: element list is null. get element failed");
            return null;
        }
    }
}
