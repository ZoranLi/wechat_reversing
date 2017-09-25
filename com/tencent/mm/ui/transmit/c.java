package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.base.h;

public final class c {
    h oHT;
    a wqZ;

    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ c wra;

        AnonymousClass1(c cVar) {
            this.wra = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.wra.wqZ.cad();
        }
    }

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ c wra;

        AnonymousClass2(c cVar) {
            this.wra = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            c cVar = this.wra;
            if (cVar.oHT != null) {
                cVar.oHT.dismiss();
                cVar.oHT = null;
            }
            cVar.wqZ.cad();
        }
    }

    public interface a {
        void cad();
    }

    c(a aVar) {
        this.wqZ = aVar;
    }
}
