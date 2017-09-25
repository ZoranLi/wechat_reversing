package com.tencent.mm.plugin.offline;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashSet;
import java.util.Map;

public final class g {
    public static String TAG = "MicroMsg.OfflineGetMsgLogic";
    public static int obA = 23;
    public static int obB = 6;
    public static int obC = 5;
    public static int obD = 20;
    public static int obE = 20000;
    public static int obF = 20001;
    public static int obG = CdnLogic.MediaType_FAVORITE_FILE;
    public static int obH;
    public static int obt = Downloads.MIN_RETYR_AFTER;
    private static int obu;
    public static int obv = Downloads.MIN_RETYR_AFTER;
    public static int obw = 0;
    public static int obx = 24;
    public static int oby = 4;
    public static int obz = 8;
    public e obI = new e(this) {
        final /* synthetic */ g obL;

        {
            this.obL = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if ((kVar instanceof d) && i == 0 && i2 == 0) {
                d dVar = (d) kVar;
                int i3 = dVar.ocs;
                g.obH = i3;
                if (i3 == 0) {
                    g.obH = g.obv;
                }
                w.d(g.TAG, "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[]{dVar.oct, dVar.ocr});
                if (bg.mA(dVar.ocr) || bg.mA(dVar.oct)) {
                    w.d(g.TAG, "OfflineGetMsgLogic msg is null");
                } else if (g.da(dVar.oct, dVar.ocr)) {
                    w.i(g.TAG, "from cgi");
                    if (bh.q(dVar.ocr, "sysmsg") != null) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(135, 71, 1, true);
                        k.aQd();
                        r aQe = k.aQe();
                        String str2 = dVar.ocr;
                        w.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
                        aQe.BV(str2);
                        aQe.BW(str2);
                    } else {
                        return;
                    }
                }
                w.i(g.TAG, "mIntercal=" + g.obH);
                long j = (long) g.obH;
                this.obL.obK.v(j, j);
            }
        }
    };
    public boolean obJ = true;
    public aj obK = new aj(new a(this) {
        final /* synthetic */ g obL;

        {
            this.obL = r1;
        }

        public final boolean oQ() {
            if (this.obL.obK != null) {
                if (!ap.zb()) {
                    long j = (long) g.obt;
                    this.obL.obK.v(j, j);
                } else if (com.tencent.mm.plugin.offline.c.a.aRn() && com.tencent.mm.plugin.offline.c.a.aQL()) {
                    g.aPZ();
                }
            }
            return false;
        }
    }, false);
    public int status = 0;

    static {
        int intValue;
        obu = 30000;
        obH = obv;
        ap.yY();
        Object obj = c.vr().get(com.tencent.mm.storage.w.a.uHD, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            obH = intValue;
            if (intValue == 0) {
                obH = obv;
            }
        }
        ap.yY();
        obj = c.vr().get(com.tencent.mm.storage.w.a.uHF, Integer.valueOf(0));
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            if (intValue != 0) {
                obu = intValue;
            }
        }
    }

    public static int aPY() {
        return obu;
    }

    public g() {
        ap.vd().a(385, this.obI);
    }

    public static void aPZ() {
        w.i(TAG, "doGetOfflineMsg doScene:NetSceneOfflineGetMsg");
        ap.vd().a(new d(), 0);
    }

    public static boolean da(String str, String str2) {
        Object obj;
        String str3;
        int i;
        if (bg.mA(str2)) {
            w.i(TAG, "shouldDeal appmsg is null");
            obj = null;
        } else {
            boolean z;
            Map q = bh.q(str2, "sysmsg");
            str3 = (String) q.get(".sysmsg.paymsg.req_key");
            i = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
            k.aQd();
            q BX = k.aQh().BX(str3);
            k.aQd();
            q aQl = k.aQh().aQl();
            if (aQl != null) {
                w.d(TAG, "isOrderClosed lastest status req_key=" + aQl.field_reqkey);
            }
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(obE));
            hashSet.add(Integer.valueOf(obB));
            hashSet.add(Integer.valueOf(obC));
            hashSet.add(Integer.valueOf(-1));
            if (aQl == null || hashSet.contains(Integer.valueOf(aQl.field_status))) {
                w.i(TAG, "isOrderClosed true;status==null?" + (aQl == null));
                if (aQl != null) {
                    w.i(TAG, "isOrderClosed status.field_status=" + aQl.field_status);
                }
                z = true;
            } else {
                w.i(TAG, "isOrderClosed false");
                if (aQl != null) {
                    w.d(TAG, "status=" + aQl.field_status + ";req_key=" + aQl.field_reqkey);
                } else {
                    w.d(TAG, "isOrderClosed status=null");
                }
                z = false;
            }
            if (BX != null) {
                com.tencent.mm.plugin.report.service.g.oUh.a(135, 63, 1, true);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(135, 64, 1, true);
            }
            w.d(TAG, "isLastestClose = " + z + ";status==null?" + (BX == null));
            if (BX == null) {
                if (aQl == null) {
                    w.v(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage", new Object[]{str3, Integer.valueOf(i)});
                    obj = 1;
                } else if (z) {
                    w.v(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d", new Object[]{str3, Integer.valueOf(i), aQl.field_reqkey, Integer.valueOf(aQl.field_status)});
                    obj = 1;
                } else {
                    w.v(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d", new Object[]{str3, Integer.valueOf(i), aQl.field_reqkey, Integer.valueOf(aQl.field_status)});
                    obj = null;
                }
            } else if (aQl == null) {
                w.v(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(BX.field_status)});
                k.aQd();
                k.aQh().BY(str3);
                obj = null;
            } else {
                w.v(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(BX.field_status), aQl.field_reqkey, Integer.valueOf(aQl.field_status)});
                if (BX.field_reqkey.equals(aQl.field_reqkey)) {
                    if (cC(aQl.field_status, i)) {
                        w.v(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(BX.field_status), aQl.field_reqkey, Integer.valueOf(aQl.field_status)});
                        obj = 1;
                    } else {
                        w.v(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false. mark current reqKey give-up", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(BX.field_status), aQl.field_reqkey, Integer.valueOf(aQl.field_status)});
                        k.aQd();
                        k.aQh().BY(str3);
                        obj = null;
                    }
                } else if (z) {
                    w.v(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(BX.field_status), aQl.field_reqkey, Integer.valueOf(aQl.field_status)});
                    obj = 1;
                } else {
                    w.v(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(BX.field_status), aQl.field_reqkey, Integer.valueOf(aQl.field_status)});
                    k.aQd();
                    k.aQh().BY(str3);
                    obj = null;
                }
            }
        }
        if (obj != null) {
            k.aQd();
            q aQl2 = k.aQh().aQl();
            q = bh.q(str2, "sysmsg");
            i = bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
            str3 = (String) q.get(".sysmsg.paymsg.req_key");
            if (i == 24) {
                com.tencent.mm.plugin.report.service.g.oUh.a(135, 58, 1, true);
            } else if (i == 6) {
                com.tencent.mm.plugin.report.service.g.oUh.a(135, 59, 1, true);
            } else if (i == 4 || i == 5 || i == 20) {
                com.tencent.mm.plugin.report.service.g.oUh.a(135, 60, 1, true);
            } else if (i == 23) {
                com.tencent.mm.plugin.report.service.g.oUh.a(135, 66, 1, true);
            }
            if (aQl2 == null || aQl2.field_reqkey == null || !aQl2.field_reqkey.equals(str3)) {
                q qVar = new q();
                qVar.field_reqkey = str3;
                if (!bg.mA(str)) {
                    qVar.field_ack_key = str;
                }
                qVar.field_status = obw;
                a(qVar, i);
            } else {
                a(aQl2, i);
            }
            w.i(TAG, "dealMsg true");
            return true;
        }
        w.i(TAG, "dealMsg false");
        return false;
    }

    private static boolean cC(int i, int i2) {
        w.i(TAG, "checkStatus from=" + i + ";to=" + i2);
        if (i == i2) {
            return false;
        }
        if (i == obw) {
            return true;
        }
        if (i == obx) {
            if (i2 != obx) {
                return true;
            }
            return false;
        } else if (i == obB) {
            if (i2 == obE) {
                return true;
            }
            return false;
        } else if (i == obC) {
            if (i2 == obE) {
                return true;
            }
            return false;
        } else if (i == obD) {
            if (i2 == obE) {
                return true;
            }
            return false;
        } else if (i == obz || i == obA) {
            if (i2 == obB || i2 == obE) {
                return true;
            }
            return false;
        } else if (i != obG) {
            return false;
        } else {
            if (i2 == obB || i2 == obE) {
                return true;
            }
            return false;
        }
    }

    private static boolean a(q qVar, int i) {
        boolean cC = cC(qVar.field_status, i);
        w.i(TAG, "isallow=" + cC + ";old status = " + qVar.field_status + ";new status = " + i);
        if (i == oby) {
            i = obE;
        }
        if (cC) {
            qVar.field_status = i;
            k.aQd();
            k.aQh().a(qVar);
        }
        return cC;
    }

    public static void bu(String str, int i) {
        if (!bg.mA(str)) {
            k.aQd();
            q BX = k.aQh().BX(str);
            if (BX != null) {
                a(BX, i);
                return;
            }
            BX = new q();
            BX.field_reqkey = str;
            BX.field_status = i;
            k.aQd();
            k.aQh().a(BX);
        }
    }

    public static void aQa() {
        k.aQd();
        com.tencent.mm.plugin.offline.b.a aQh = k.aQh();
        aQh.gUz.eE("OfflineOrderStatus", "UPDATE OfflineOrderStatus SET status=" + obE + " where status!=" + obE);
    }

    public final void stop() {
        if (com.tencent.mm.plugin.offline.c.a.aRn()) {
            w.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.obK.bJq());
            if (!this.obK.bJq()) {
                com.tencent.mm.plugin.report.service.g.oUh.a(135, 62, 1, true);
                this.obK.KH();
            }
        }
    }
}
