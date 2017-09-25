package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public final class ap {
    public static boolean fYK;
    private TelephonyManager uuJ;
    private PhoneStateListener uuK;
    public List<a> uuL = new LinkedList();

    public interface a {
        void dL(int i);
    }

    public final void a(a aVar) {
        this.uuL.add(aVar);
    }

    public static boolean oS() {
        w.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", Boolean.valueOf(fYK));
        return fYK;
    }

    public final void ek(Context context) {
        w.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
        if (this.uuJ == null) {
            this.uuJ = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.uuK == null) {
            this.uuK = new PhoneStateListener(this) {
                final /* synthetic */ ap uuM;

                {
                    this.uuM = r1;
                }

                public final void onCallStateChanged(int i, String str) {
                    w.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", Integer.valueOf(i), str);
                    if (this.uuM.uuL.size() > 0) {
                        for (a dL : (a[]) this.uuM.uuL.toArray(new a[this.uuM.uuL.size()])) {
                            dL.dL(i);
                        }
                    }
                    super.onCallStateChanged(i, str);
                    switch (i) {
                        case 0:
                            ap.fYK = false;
                            return;
                        case 1:
                        case 2:
                            ap.fYK = true;
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        this.uuJ.listen(this.uuK, 32);
    }
}
