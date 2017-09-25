package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d implements e {
    public int index;
    public SparseArray<c> rbQ = null;
    public boolean rbR = false;
    public b rbS;
    public a rbT;
    public aj rbU = new aj(new a(this) {
        final /* synthetic */ d rbV;

        {
            this.rbV = r1;
        }

        public final boolean oQ() {
            if (this.rbV.rbR) {
                w.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[]{Integer.valueOf(this.rbV.index)});
                this.rbV.bov();
                this.rbV.rbT.a(-1, this.rbV.rbQ, null);
            }
            return false;
        }
    }, false);
    long start;

    public d(int i, a aVar) {
        this.index = i;
        this.rbT = aVar;
    }

    public final void bov() {
        this.rbS = null;
        this.rbR = false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.rbS != kVar) {
            w.e("MicroMsg.WorkingTranslate", "not my translate work");
            return;
        }
        int size;
        this.rbU.KH();
        w.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start)});
        String str2 = "MicroMsg.WorkingTranslate";
        String str3 = "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (((b) kVar).rbI != null) {
            size = ((b) kVar).rbI.size();
        } else {
            size = 0;
        }
        objArr[3] = Integer.valueOf(size);
        w.d(str2, str3, objArr);
        bov();
        this.rbT.a(i2, this.rbQ, ((b) kVar).rbI);
    }
}
