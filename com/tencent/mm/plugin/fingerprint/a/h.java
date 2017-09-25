package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.R;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class h extends c<ko> {
    private String fJH;
    public boolean lNZ;
    private a lOu;
    public ko lOv;
    private com.tencent.mm.pluginsdk.wallet.h lOw;
    private Runnable lOx;

    public class a implements b {
        final /* synthetic */ h lOy;

        public a(h hVar) {
            this.lOy = hVar;
        }

        public final void av(int i, int i2) {
            if (this.lOy.lNZ) {
                w.e("MicroMsg.OpenFingerPrintAuthEventListener", "hy: event already end. ignore");
                return;
            }
            String string;
            switch (i) {
                case 0:
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_SUCCESS");
                    h hVar = this.lOy;
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "onSuccess()");
                    hVar.lNZ = true;
                    com.tencent.mm.plugin.fingerprint.a.auQ();
                    com.tencent.mm.plugin.fingerprint.a.auR();
                    com.tencent.mm.pluginsdk.l.a.sBC.a(hVar.lOv, i2);
                    if (hVar.lNZ) {
                        hVar.lOv = null;
                    }
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onSuccess()");
                    h.avu();
                    return;
                case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify timeout");
                    return;
                case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                    this.lOy.eo(false);
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_TIMEOUT");
                    return;
                case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: identify FingerPrintConst.RESULT_NO_MATCH");
                    this.lOy.lNZ = false;
                    h.avu();
                    this.lOy.eo(true);
                    this.lOy.G(1, "");
                    return;
                case 2004:
                case 2005:
                case 2007:
                case 10308:
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    this.lOy.lNZ = true;
                    string = ab.getContext().getString(R.l.eXb);
                    if (i == 10308) {
                        string = ab.getContext().getString(R.l.eXc);
                    } else if (i == 2007) {
                        q.rHB.lOI = true;
                    }
                    h.avu();
                    this.lOy.G(2, string);
                    return;
                case 2009:
                    w.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                    if (this.lOy.lOv != null) {
                        com.tencent.mm.plugin.soter.c.a.ut(this.lOy.lOv.fQZ.fRc);
                    }
                    this.lOy.lNZ = true;
                    string = ab.getContext().getString(R.l.eXb);
                    h.avu();
                    this.lOy.G(i, string);
                    return;
                default:
                    return;
            }
        }
    }

    public h() {
        this.lOw = null;
        this.lOx = null;
        this.lNZ = false;
        this.fJH = "";
        this.usg = ko.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        ko koVar = (ko) bVar;
        if (ap.zb()) {
            this.lNZ = false;
            if (koVar instanceof ko) {
                w.i("MicroMsg.OpenFingerPrintAuthEventListener", "handle OpenFingerPrintAuthEventListener");
                if (e.avd()) {
                    this.lOv = koVar;
                    if (this.lOv == null) {
                        w.e("MicroMsg.OpenFingerPrintAuthEventListener", null, new Object[]{"mEvent is null !!!"});
                    } else {
                        this.lOx = this.lOv.fQZ.fRd;
                        this.fJH = koVar.fQZ.fLT;
                        com.tencent.mm.plugin.fingerprint.a.auQ();
                        if (com.tencent.mm.plugin.fingerprint.a.auR() == null) {
                            return true;
                        }
                        com.tencent.mm.plugin.fingerprint.a.auQ();
                        com.tencent.mm.plugin.fingerprint.a.auR();
                        boolean auX = c.auX();
                        if (this.lOu == null) {
                            this.lOu = new a(this);
                        }
                        com.tencent.mm.plugin.fingerprint.a.auQ();
                        com.tencent.mm.plugin.fingerprint.a.auR();
                        this.lOw = com.tencent.mm.pluginsdk.l.a.sBC.avi();
                        if (this.lOw == null) {
                            return eo(false);
                        }
                        this.lOw.a(new com.tencent.mm.pluginsdk.wallet.a(this) {
                            final /* synthetic */ h lOy;

                            {
                                this.lOy = r1;
                            }

                            public final void S(int i, String str) {
                                w.i("MicroMsg.OpenFingerPrintAuthEventListener", "hy: pre processing done. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                                if (i == 0) {
                                    this.lOy.eo(false);
                                } else {
                                    this.lOy.G(1, "");
                                }
                            }
                        });
                        return auX;
                    }
                }
                w.e("MicroMsg.OpenFingerPrintAuthEventListener", "device is not support FingerPrintAuth");
                this.lNZ = true;
                G(1, "");
                return true;
            }
        }
        w.e("MicroMsg.OpenFingerPrintAuthEventListener", "OpenFingerPrintAuthEvent account is not ready");
        return false;
    }

    public final void release() {
        com.tencent.mm.plugin.fingerprint.a.auQ();
        if (com.tencent.mm.plugin.fingerprint.a.auR() != null) {
            com.tencent.mm.plugin.fingerprint.a.auQ();
            com.tencent.mm.plugin.fingerprint.a.auR();
            c.release();
        }
        this.lOv = null;
    }

    public static void avu() {
        boolean z = true;
        com.tencent.mm.plugin.fingerprint.a.auQ();
        if (com.tencent.mm.plugin.fingerprint.a.auR() != null) {
            com.tencent.mm.plugin.fingerprint.a.auQ();
            com.tencent.mm.plugin.fingerprint.a.auR();
            c.abort();
            com.tencent.mm.plugin.fingerprint.a.auQ();
            com.tencent.mm.plugin.fingerprint.a.auR();
            c.release();
            String str = "MicroMsg.OpenFingerPrintAuthEventListener";
            String str2 = "stopIdentify() isSoter: %b";
            Object[] objArr = new Object[1];
            com.tencent.mm.plugin.fingerprint.a.auQ();
            com.tencent.mm.plugin.fingerprint.a.auR();
            if (com.tencent.mm.pluginsdk.l.a.sBC.type() != 2) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.i(str, str2, objArr);
        }
    }

    public final boolean eo(boolean z) {
        avu();
        com.tencent.mm.plugin.fingerprint.a.auQ();
        com.tencent.mm.plugin.fingerprint.a.auR();
        if (c.auX()) {
            com.tencent.mm.plugin.fingerprint.a.auQ();
            com.tencent.mm.plugin.fingerprint.a.auR();
            if (c.a(this.lOu, z) != 0) {
                w.e("MicroMsg.OpenFingerPrintAuthEventListener", "failed to start identify");
                release();
                this.lNZ = true;
                G(1, "");
                return false;
            }
            w.i("MicroMsg.OpenFingerPrintAuthEventListener", "startIdentify()");
            return true;
        }
        w.e("MicroMsg.OpenFingerPrintAuthEventListener", "no fingerprints enrolled, use settings to enroll fingerprints first");
        release();
        this.lNZ = true;
        G(1, "");
        return false;
    }

    public final void G(int i, String str) {
        w.i("MicroMsg.OpenFingerPrintAuthEventListener", "onFail()");
        com.tencent.mm.plugin.fingerprint.a.auQ();
        com.tencent.mm.plugin.fingerprint.a.auR();
        com.tencent.mm.pluginsdk.l.a.sBC.a(this.lOv, i, str);
        if (this.lNZ) {
            this.lOv = null;
        }
        w.i("MicroMsg.OpenFingerPrintAuthEventListener", "callback OpenFingerPrintAuthEvent onFail()");
    }
}
