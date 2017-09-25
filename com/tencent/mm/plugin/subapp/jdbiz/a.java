package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.e.a.jw;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public final class a implements com.tencent.mm.u.bp.a {
    public c qSt = new c<jw>(this) {
        final /* synthetic */ a qSu;

        {
            this.qSu = r2;
            this.usg = jw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jw jwVar = (jw) bVar;
            if ((jwVar instanceof jw) && jwVar.fQk.fQm != null && jwVar.fQk.fQl != null && "bizjd".equals(jwVar.fQk.fQl)) {
                String ap = bg.ap(jwVar.fQk.fQm.getString("activity_id"), "");
                String ap2 = bg.ap(jwVar.fQk.fQm.getString("jump_url"), "");
                g.oUh.i(11179, ap2, c.bmM().bmR().qSx, Integer.valueOf(4));
                b bmR = c.bmM().bmR();
                if (!(bmR == null || bmR.qSx == null || !bmR.qSx.equals(ap))) {
                    c.bmM().bmQ();
                    c.bmM().bmP();
                }
                com.tencent.mm.sdk.b.a.urY.c(this.qSu.qSt);
            }
            return false;
        }
    };

    public final void a(com.tencent.mm.y.d.a aVar) {
        w.i("MicroMsg.JDSysMsgNotifyLsn", "receivemsg jd");
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.JDSysMsgNotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        final b bVar = new b();
        bVar.FU(n.a(buVar.tff));
        w.i("MicroMsg.JDSysMsgNotifyLsn", "bizType " + bg.ap(bVar.qSw, ""));
        if (bg.mA(bVar.qSw)) {
            w.e("MicroMsg.JDSysMsgNotifyLsn", "bizTye is null or nil");
        } else if (bg.mA(bVar.qSx)) {
            w.e("MicroMsg.JDSysMsgNotifyLsn", "activity id is null");
        } else if (!bVar.a(c.bmM().bmR())) {
            w.i("MicroMsg.JDSysMsgNotifyLsn", "fo zu baoyou! the activityid is same");
        } else if (!c.bmU()) {
            w.e("MicroMsg.JDSysMsgNotifyLsn", "no entrance, ignore msg");
        } else if (bVar.qSw.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            buVar.tfj = null;
            if (bg.mA(bVar.qSH) || bg.mA(bVar.jumpUrl) || bg.mA(bVar.qSI) || bg.mA(bVar.qSJ) || bg.mA(bVar.qSG)) {
                w.e("MicroMsg.JDSysMsgNotifyLsn", "invalid params");
            } else if (bVar.bmF()) {
                w.i("MicroMsg.JDSysMsgNotifyLsn", "ingore msg due to msg is expired");
            } else {
                c bmM = c.bmM();
                String str = bVar.qSx;
                if (bg.mA(str) ? false : bmM.qSM.containsKey(str)) {
                    w.i("MicroMsg.JDSysMsgNotifyLsn", "activity id already show, " + bVar.qSx);
                } else if (bVar.a(c.bmM().bmR())) {
                    bmM = c.bmM();
                    str = bVar.qSx;
                    if (!bg.mA(str)) {
                        bmM.qSM.put(str, Integer.valueOf(1));
                    }
                    w.i("MicroMsg.JDSysMsgNotifyLsn", "add activity id" + bVar.qSx);
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ a qSu;

                        public final void run() {
                            a aVar = this.qSu;
                            b bVar = bVar;
                            ap.yY();
                            int intValue = ((Integer) com.tencent.mm.u.c.vr().get(15, Integer.valueOf(0))).intValue();
                            if (ap.vd().foreground && 1 == intValue) {
                                String bQ;
                                JDRemindDialog.a(ab.getContext(), bVar.qSH, bVar.qSI, bVar.qSJ, c.bQ(bVar.jumpUrl, 5), bVar.qSx);
                                g.oUh.i(11178, bQ, c.bmM().bmR().qSx, Integer.valueOf(5));
                                return;
                            }
                            bQ = c.bQ(bVar.jumpUrl, 4);
                            Bundle bundle = new Bundle();
                            bundle.putString("activity_id", bVar.qSx);
                            bundle.putString("jump_url", bQ);
                            ((ai) ap.getNotification()).a(37, ab.getContext().getString(R.l.dIp), bVar.qSG, bQ, "bizjd", bundle);
                            com.tencent.mm.sdk.b.a.urY.b(aVar.qSt);
                            g.oUh.i(11178, bQ, c.bmM().bmR().qSx, Integer.valueOf(4));
                        }
                    });
                } else {
                    w.i("MicroMsg.JDSysMsgNotifyLsn", "the remind activitid is same");
                }
            }
            c.b(bVar);
        } else if (bVar.qSw.equals("1")) {
            c.b(bVar);
        } else if (bVar.qSw.equals("2")) {
            c.b(bVar);
        }
        ap.yY();
        com.tencent.mm.u.c.vr().jY(true);
    }
}
