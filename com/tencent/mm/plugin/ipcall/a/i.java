package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.ax;
import com.tencent.mm.e.a.az;
import com.tencent.mm.e.a.hu;
import com.tencent.mm.e.a.hv;
import com.tencent.mm.e.a.pv;
import com.tencent.mm.e.a.qw;
import com.tencent.mm.i.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.plugin.ipcall.d.1;
import com.tencent.mm.plugin.ipcall.d.2;
import com.tencent.mm.plugin.ipcall.ui.IPCallDialUI;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class i implements am {
    private static HashMap<Integer, c> mNC;
    private static i mNj = null;
    private com.tencent.mm.sdk.b.c mNA = new com.tencent.mm.sdk.b.c<pv>(this) {
        final /* synthetic */ i mNG;

        {
            this.mNG = r2;
            this.usg = pv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pv pvVar = (pv) bVar;
            if (pvVar instanceof pv) {
                Intent intent = new Intent(ab.getContext(), IPCallDialUI.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("IPCallTalkUI_contactId", pvVar.fWS.fWT);
                intent.putExtra("IPCallTalkUI_countryCode", pvVar.fWS.fWU);
                intent.putExtra("IPCallTalkUI_nickname", pvVar.fWS.aIO);
                intent.putExtra("IPCallTalkUI_phoneNumber", pvVar.fWS.fWV);
                ab.getContext().startActivity(intent);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mNB = new com.tencent.mm.sdk.b.c<hu>(this) {
        final /* synthetic */ i mNG;

        {
            this.mNG = r2;
            this.usg = hu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hu huVar = (hu) bVar;
            if (huVar instanceof hu) {
                if (huVar.fNt.fNw && this.mNG.mNx == huVar.fNt.fNv && this.mNG.mNw != null) {
                    Context context = this.mNG.mNw;
                    w.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert");
                    if (d.aDM()) {
                        int i;
                        int i2 = g.sV().getInt("WCOMaxTimesForTryShowWcoMainFromVoip", 0);
                        ap.yY();
                        int intValue = ((Integer) com.tencent.mm.u.c.vr().get(a.uBW, Integer.valueOf(0))).intValue();
                        ap.yY();
                        long longValue = ((Long) com.tencent.mm.u.c.vr().get(a.uBV, Long.valueOf(0))).longValue();
                        long Ny = bg.Ny();
                        if (Ny - longValue > 86400) {
                            i = 0;
                            w.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert reset time");
                        } else {
                            i = intValue;
                        }
                        if (i >= i2) {
                            w.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert reach max time" + i2);
                        } else if (Ny - longValue < 1800) {
                            w.i("MicroMsg.IPCallPluginUtil", "tryShowNavAlert not reach INTERVAL_TIMES_TRY_SHOW_WCO_MAIN");
                        } else {
                            i++;
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(a.uBW, Integer.valueOf(i));
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(a.uBV, Long.valueOf(Ny));
                            com.tencent.mm.ui.base.g.a(context, R.l.etw, R.l.evr, new 1(), new 2());
                            this.mNG.mNw = null;
                            this.mNG.mNx = 0;
                        }
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(13338, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    this.mNG.mNw = null;
                    this.mNG.mNx = 0;
                }
                if (!huVar.fNt.fNw) {
                    if (huVar.fNt.fNv == 0) {
                        this.mNG.mNw = null;
                        this.mNG.mNx = 0;
                    } else {
                        this.mNG.mNw = huVar.fNt.fNu;
                        this.mNG.mNx = huVar.fNt.fNv;
                    }
                }
            }
            return false;
        }
    };
    private bp.a mND = new bp.a(this) {
        final /* synthetic */ i mNG;

        {
            this.mNG = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            w.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
            String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q == null) {
                w.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
                return;
            }
            int i;
            int i2;
            String substring;
            if (q.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
                i = bg.getInt((String) q.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[]{Integer.valueOf(i)});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBE, Integer.valueOf(i));
                i2 = i;
            } else {
                i2 = -1;
            }
            if (q.containsKey(".sysmsg.WeChatOut.AcctRD")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WeChatOut.AcctRD"), 0))});
                if (bg.getInt((String) q.get(".sysmsg.WeChatOut.AcctRD"), 0) != 0) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uBD, Boolean.valueOf(true));
                    com.tencent.mm.plugin.report.service.g.oUh.i(13254, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(-1), Integer.valueOf(-1)});
                } else {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uBD, Boolean.valueOf(false));
                }
            }
            if (q.containsKey(".sysmsg.WeChatOut.TabRD")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WeChatOut.TabRD"), 0))});
                if (bg.getInt((String) q.get(".sysmsg.WeChatOut.TabRD"), 0) != 0) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uBQ, Boolean.valueOf(true));
                    com.tencent.mm.plugin.report.service.g.oUh.i(13254, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
                } else {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uBQ, Boolean.valueOf(false));
                }
            }
            if (q.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WeChatOut.RechargeRD"), 0))});
                if (bg.getInt((String) q.get(".sysmsg.WeChatOut.RechargeRD"), 0) != 0) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uBK, Boolean.valueOf(true));
                    com.tencent.mm.plugin.report.service.g.oUh.i(13254, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
                } else {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uBK, Boolean.valueOf(false));
                }
            }
            if (q.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[]{(String) q.get(".sysmsg.WeChatOut.RechargeWording")});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBJ, substring);
            }
            if (q.containsKey(".sysmsg.WeChatOut.PackagePurchaseWording")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[]{(String) q.get(".sysmsg.WeChatOut.PackagePurchaseWording")});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBL, substring);
            }
            if (q.containsKey(".sysmsg.WeChatOut.AccountWording")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[]{(String) q.get(".sysmsg.WeChatOut.AccountWording")});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBF, substring);
            }
            if (q.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0))});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBU, Integer.valueOf(i));
            }
            if (q.containsKey(".sysmsg.WeChatOut.TabWording")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[]{(String) q.get(".sysmsg.WeChatOut.TabWording")});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBP, substring);
            }
            if (q.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[]{(String) q.get(".sysmsg.WeChatOut.AccountActivityWording")});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBG, substring);
            }
            if (q.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0))});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBH, Integer.valueOf(i));
            }
            if (q.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0))});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBI, Integer.valueOf(i));
            }
            if (q.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WeChatOut.TabRedDotType"), 0))});
                com.tencent.mm.plugin.report.service.g.oUh.i(13254, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i)});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBR, Integer.valueOf(i));
            }
            i = a.indexOf("<ActivityInfo>");
            i2 = a.indexOf("</ActivityInfo>");
            if (i > 0 && i2 > 0 && i2 > i) {
                substring = a.substring(i, i2 + 15);
                w.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[]{substring});
                com.tencent.mm.plugin.ipcall.a.g.a yr = com.tencent.mm.plugin.ipcall.a.g.a.yr(substring);
                if (yr != null && bg.mA(yr.fDC) && bg.mA(yr.msk)) {
                    w.i("MicroMsg.SubCoreIPCall", "clear activity");
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uCd, Boolean.valueOf(false));
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uCe, "");
                } else if (yr != null) {
                    if (!bg.mA(yr.mQT)) {
                        com.tencent.mm.ah.n.GR().a(yr.mQT, null);
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uCd, Boolean.valueOf(true));
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uCe, substring);
                }
            }
            com.tencent.mm.sdk.b.a.urY.m(new hv());
            com.tencent.mm.sdk.b.a.urY.m(new qw());
        }
    };
    private bp.a mNE = new bp.a(this) {
        final /* synthetic */ i mNG;

        {
            this.mNG = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            w.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
            bu buVar = aVar.hst;
            String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q == null) {
                w.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
                return;
            }
            int i;
            h aEq = i.aEq();
            long j = (long) buVar.tfc;
            if (q != null) {
                com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.plugin.ipcall.a.g.g();
                gVar.field_svrId = j;
                gVar.field_title = (String) q.get(".sysmsg.WeChatOutMsg.Title");
                if (gVar.field_title == null) {
                    gVar.field_title = "";
                }
                gVar.field_content = (String) q.get(".sysmsg.WeChatOutMsg.Content");
                if (gVar.field_content == null) {
                    gVar.field_content = "";
                }
                int i2 = bg.getInt((String) q.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                gVar.field_msgType = i2;
                gVar.field_pushTime = bg.getLong((String) q.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                gVar.field_descUrl = (String) q.get(".sysmsg.WeChatOutMsg.DescUrl");
                if (gVar.field_descUrl == null) {
                    gVar.field_descUrl = "";
                }
                w.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[]{gVar.field_svrId, gVar.field_title, gVar.field_content, gVar.field_msgType, gVar.field_pushTime, gVar.field_descUrl});
                aEq.b(gVar);
                i = i2;
            } else {
                i = -1;
            }
            if (i != -1) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uBT, Integer.valueOf(i));
            }
            ap.yY();
            com.tencent.mm.u.c.vr().a(a.uBS, Boolean.valueOf(true));
            com.tencent.mm.plugin.report.service.g.oUh.i(13254, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1)});
        }
    };
    private bp.a mNF = new bp.a(this) {
        final /* synthetic */ i mNG;

        {
            this.mNG = r1;
        }

        public final void a(com.tencent.mm.y.d.a aVar) {
            w.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
            String a = n.a(aVar.hst.tff);
            if (a == null || a.length() == 0) {
                w.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q == null) {
                w.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
            } else if (q.containsKey(".sysmsg.WCONotify.NotifyGetBalance")) {
                w.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[]{Integer.valueOf(bg.getInt((String) q.get(".sysmsg.WCONotify.NotifyGetBalance"), 0))});
                if (bg.getInt((String) q.get(".sysmsg.WCONotify.NotifyGetBalance"), 0) > 0) {
                    ap.vd().a(new com.tencent.mm.plugin.ipcall.a.d.g(2), 0);
                }
            }
        }
    };
    private g mNk = new g();
    private com.tencent.mm.plugin.ipcall.a.c.a mNl = new com.tencent.mm.plugin.ipcall.a.c.a();
    private com.tencent.mm.plugin.ipcall.a.c.b mNm = new com.tencent.mm.plugin.ipcall.a.c.b();
    private com.tencent.mm.plugin.ipcall.a.b.b mNn = new com.tencent.mm.plugin.ipcall.a.b.b();
    private f mNo = new f();
    private com.tencent.mm.plugin.ipcall.c mNp = new com.tencent.mm.plugin.ipcall.c();
    private com.tencent.mm.plugin.ipcall.a.g.d mNq;
    private l mNr;
    private j mNs;
    private h mNt;
    private com.tencent.mm.plugin.voip.video.h mNu;
    private com.tencent.mm.plugin.voip.video.d mNv;
    public Context mNw;
    public long mNx;
    private com.tencent.mm.sdk.b.c mNy = new com.tencent.mm.sdk.b.c<az>(this) {
        final /* synthetic */ i mNG;

        {
            this.mNG = r2;
            this.usg = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w.d("MicroMsg.SubCoreIPCall", "change language");
            com.tencent.mm.plugin.ipcall.b.a.aFw();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mNz = new com.tencent.mm.sdk.b.c<ax>(this) {
        final /* synthetic */ i mNG;

        {
            this.mNG = r2;
            this.usg = ax.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ax axVar = (ax) bVar;
            if (axVar instanceof ax) {
                axVar.fEs.fEt = i.aEl().aEb();
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        mNC = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.ipcall.a.g.d.gUx;
            }
        });
        mNC.put(Integer.valueOf("IPCallRecord".hashCode()), new c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
        mNC.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new c() {
            public final String[] pP() {
                return j.gUx;
            }
        });
        mNC.put(Integer.valueOf("IPCallMsg".hashCode()), new c() {
            public final String[] pP() {
                return h.gUx;
            }
        });
    }

    public static i aEg() {
        if (mNj == null) {
            mNj = new i();
            ap.yR().a("plugin.ipcall", mNj);
        }
        return mNj;
    }

    public static g aEh() {
        return aEg().mNk;
    }

    public static com.tencent.mm.plugin.ipcall.a.c.a aEi() {
        return aEg().mNl;
    }

    public static com.tencent.mm.plugin.ipcall.a.c.b aEj() {
        return aEg().mNm;
    }

    public static com.tencent.mm.plugin.ipcall.a.b.b aEk() {
        return aEg().mNn;
    }

    public static f aEl() {
        return aEg().mNo;
    }

    public static com.tencent.mm.plugin.ipcall.c aEm() {
        return aEg().mNp;
    }

    public static com.tencent.mm.plugin.ipcall.a.g.d aEn() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aEg().mNq == null) {
            i aEg = aEg();
            ap.yY();
            aEg.mNq = new com.tencent.mm.plugin.ipcall.a.g.d(com.tencent.mm.u.c.wO());
        }
        return aEg().mNq;
    }

    public static l aEo() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aEg().mNr == null) {
            i aEg = aEg();
            ap.yY();
            aEg.mNr = new l(com.tencent.mm.u.c.wO());
        }
        return aEg().mNr;
    }

    public static j aEp() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aEg().mNs == null) {
            i aEg = aEg();
            ap.yY();
            aEg.mNs = new j(com.tencent.mm.u.c.wO());
        }
        return aEg().mNs;
    }

    public static h aEq() {
        com.tencent.mm.kernel.h.vG().uQ();
        if (aEg().mNt == null) {
            i aEg = aEg();
            ap.yY();
            aEg.mNt = new h(com.tencent.mm.u.c.wO());
        }
        return aEg().mNt;
    }

    public static com.tencent.mm.plugin.voip.video.h aEr() {
        if (aEg().mNu == null) {
            aEg().mNu = new com.tencent.mm.plugin.voip.video.h(ab.getContext());
        }
        return aEg().mNu;
    }

    public static com.tencent.mm.plugin.voip.video.d aEs() {
        if (aEg().mNv == null) {
            aEg().mNv = new com.tencent.mm.plugin.voip.video.d(ab.getContext());
        }
        return aEg().mNv;
    }

    public final HashMap<Integer, c> uh() {
        return mNC;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        Object obj = this.mNk;
        obj.mMV.init();
        obj.mMW.init();
        obj.mMX.init();
        obj.mMY.init();
        obj.mMZ.init();
        obj.mNa.init();
        obj.mNb.init();
        obj.mNc.init();
        obj.mMV.mNH = obj;
        obj.mMX.mNH = obj;
        obj.mMY.mNH = obj;
        obj.mNa.mNH = obj;
        obj.mNc.mNH = obj;
        obj.mMW.mNJ = obj;
        obj.mMZ.mNJ = obj;
        ap.a(obj.mNg);
        b.init();
        com.tencent.mm.sdk.b.a.urY.b(d.aDX().mMI);
        com.tencent.mm.sdk.b.a.urY.b(e.aEa().irS);
        ap.getSysCmdMsgExtension().a("WeChatOut", this.mND, true);
        ap.getSysCmdMsgExtension().a("WeChatOutMsg", this.mNE, true);
        ap.getSysCmdMsgExtension().a("WCONotify", this.mNF, true);
        com.tencent.mm.sdk.b.a.urY.b(this.mNy);
        com.tencent.mm.sdk.b.a.urY.b(this.mNz);
        com.tencent.mm.sdk.b.a.urY.b(this.mNA);
        com.tencent.mm.sdk.b.a.urY.b(this.mNB);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.mNo.aEb()) {
            this.mNp.ck(0, 0);
        }
        g gVar = this.mNk;
        gVar.mMV.destroy();
        gVar.mMW.destroy();
        gVar.mMX.destroy();
        gVar.mMY.destroy();
        gVar.mMZ.destroy();
        gVar.mNb.destroy();
        ap.b(gVar.mNg);
        b.release();
        Object aDX = d.aDX();
        ap.vd().b(JsApiGetBackgroundAudioState.CTRL_INDEX, aDX);
        ap.vd().b(JsApiSetBackgroundAudioState.CTRL_INDEX, aDX);
        com.tencent.mm.sdk.b.a.urY.c(aDX.mMI);
        com.tencent.mm.sdk.b.a.urY.c(e.aEa().irS);
        ap.getSysCmdMsgExtension().b("WeChatOut", this.mND, true);
        ap.getSysCmdMsgExtension().b("WeChatOutMsg", this.mNE, true);
        ap.getSysCmdMsgExtension().b("WCONotify", this.mNF, true);
        com.tencent.mm.sdk.b.a.urY.c(this.mNy);
        com.tencent.mm.sdk.b.a.urY.c(this.mNz);
        com.tencent.mm.sdk.b.a.urY.c(this.mNA);
        com.tencent.mm.sdk.b.a.urY.c(this.mNB);
    }
}
