package com.tencent.mm.app.plugin.a;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cr;
import com.tencent.mm.e.a.dq;
import com.tencent.mm.e.a.io;
import com.tencent.mm.e.a.kl;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public com.tencent.mm.ui.chatting.En_5b8fbb1e.a fyo;
    public b fyp;
    public a fyq;
    private String fyr;
    public Map<String, Boolean> fys;
    public boolean fyt = true;

    class a extends c<cr> {
        final /* synthetic */ a fyv;

        a(a aVar) {
            this.fyv = aVar;
            this.usg = cr.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ((cr) bVar).fGi.fyt = this.fyv.fyt;
            return true;
        }
    }

    class b extends c<kl> {
        final /* synthetic */ a fyv;

        b(a aVar) {
            this.fyv = aVar;
            this.usg = kl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            kl klVar = (kl) bVar;
            if (this.fyv.fyo != null) {
                if (!this.fyv.fyo.isFinishing()) {
                    int i = klVar.fQR.op;
                    String str = klVar.fQR.fOo;
                    w.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "opcode is %d, brand name is %s", Integer.valueOf(i), str);
                    if (this.fyv.fyo.bUg().equals(str)) {
                        switch (i) {
                            case 1:
                                a aVar = this.fyv;
                                w.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "handleConnectFailedReason, reason : %d, brand name : %s", Integer.valueOf(klVar.fQR.fOl), str);
                                BizInfo hW = e.hW(str);
                                if (a.a(hW)) {
                                    if (hW.bd(false).Da().hvc == 1) {
                                        aVar.fyo.SE(null);
                                        break;
                                    }
                                }
                                w.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
                                break;
                                break;
                            case 2:
                                this.fyv.d(klVar.fQR.fHm, str, klVar.fQR.fwJ);
                                break;
                            case 3:
                                if (this.fyv.fys != null) {
                                    this.fyv.fys.clear();
                                    w.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "clear connected device ids successfully.");
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    w.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "not current brandname");
                } else {
                    w.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context isFinishing");
                }
            } else {
                w.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context == null");
            }
            return false;
        }
    }

    public a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar) {
        w.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now init the event listener");
        this.fyo = aVar;
        if (this.fyp == null) {
            this.fyp = new b(this);
        }
        com.tencent.mm.sdk.b.a.urY.b(this.fyp);
        if (this.fyq == null) {
            this.fyq = new a(this);
        }
        com.tencent.mm.sdk.b.a.urY.b(this.fyq);
    }

    public final synchronized void d(int i, String str, String str2) {
        w.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connect state : %d", Integer.valueOf(i));
        if (this.fyo != null && !bg.mA(str)) {
            BizInfo hW = e.hW(str);
            if (a(hW)) {
                if (this.fys == null) {
                    this.fys = new HashMap();
                }
                Map map = this.fys;
                if (!str.equals(this.fyr)) {
                    this.fyr = str;
                    map.clear();
                }
                if (hW.bd(false).Da().hvc != 1) {
                    w.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "connDeviceIds : (%s) , deviceId : (%s)", map, str2);
                    switch (i) {
                        case -1:
                            this.fyo.SE(null);
                            break;
                        case 0:
                            if (map.size() == 0) {
                                this.fyo.zj(R.l.efW);
                                break;
                            }
                            break;
                        case 1:
                            if (map.size() == 0) {
                                this.fyo.zj(R.l.efV);
                                break;
                            }
                            break;
                        case 2:
                            map.put(str2, Boolean.valueOf(true));
                            this.fyo.SE(this.fyo.getString(R.l.efU, Integer.valueOf(map.size())));
                            w.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now connected(deviceId : %s), set the tips gone", str2);
                            break;
                        case 4:
                            if (map.remove(str2) != null) {
                                w.i("MicroMsg.exdevice.ChattingUIExDeviceLogic", "disconnected(deviceId : %s) successfully.", str2);
                            }
                            this.fyo.SE(this.fyo.getString(R.l.efU, Integer.valueOf(map.size())));
                            break;
                        default:
                            break;
                    }
                }
                this.fyo.SE(null);
            } else {
                w.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "It's not a biz, brandName(%s).", str);
            }
        } else {
            w.w("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null or brandName is null or nil.");
        }
    }

    public final void a(final int i, BizInfo bizInfo) {
        if (this.fyo == null) {
            w.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "notifySwitchView, context is null, maybe has been released");
        } else if (o.eV(this.fyo.bUg()) && a(bizInfo)) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a fyv;

                public final void run() {
                    com.tencent.mm.sdk.b.b dqVar;
                    if (1 == i) {
                        dqVar = new dq();
                        dqVar.fHz.op = 0;
                        dqVar.fHz.userName = this.fyv.fyo.bUg();
                        dqVar.fHz.context = this.fyv.fyo.uSU.uTo;
                        com.tencent.mm.sdk.b.a.urY.m(dqVar);
                        if (this.fyv.fyo.bUg().equals("gh_43f2581f6fd6")) {
                            dqVar = new pq();
                            dqVar.fWA.action = 1;
                            com.tencent.mm.sdk.b.a.urY.a(dqVar, Looper.getMainLooper());
                        }
                    }
                    dqVar = new io();
                    dqVar.fOn.opType = i;
                    dqVar.fOn.fOp = 1;
                    dqVar.fOn.fOo = this.fyv.fyo.bUg();
                    com.tencent.mm.sdk.b.a.urY.m(dqVar);
                }
            });
        }
    }

    public static boolean a(BizInfo bizInfo) {
        if (bizInfo == null || bizInfo == null) {
            return false;
        }
        ExtInfo bd = bizInfo.bd(false);
        if (bd == null || bd.Da() == null || !bd.Da().Dj()) {
            return false;
        }
        return true;
    }
}
