package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.plugin.webview.model.m;
import com.tencent.mm.plugin.webview.model.n;
import com.tencent.mm.plugin.webview.model.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.protocal.c.agk;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.agm;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.ahl;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    private Context context;
    final HashMap<String, d> mnj = new HashMap();
    final int rWF;
    private com.tencent.mm.plugin.webview.stub.e rXh;
    final HashMap<String, String> sjA = new HashMap();
    final HashMap<String, agk> sjz = new HashMap();

    public interface a {

        public enum a {
            RET_OK(0),
            RET_FAIL(-1),
            RET_REJECT(-2),
            RET_ACCESS_DENIED(-3);
            
            private int code;

            private a(int i) {
                this.code = i;
            }

            public final int getCode() {
                return this.code;
            }
        }

        void a(a aVar, String str, LinkedList<biy> linkedList, int i, int i2);
    }

    public interface b {
        int bwi();
    }

    public static class d {
        public String appId;
        public List<String> sjK;
    }

    public static abstract class c implements a {
        public boolean sjJ = true;

        public boolean bzj() {
            return this.sjJ;
        }

        public final void iW(boolean z) {
            this.sjJ = z;
        }
    }

    public final String JZ(String str) {
        if (str == null) {
            return null;
        }
        String str2 = (String) this.sjA.get(str);
        if (!bg.mA(str2)) {
            return str2;
        }
        String xI = xI(str);
        w.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[]{str2, str, xI});
        if (bg.mA(xI)) {
            return str2;
        }
        return (String) this.sjA.get(xI);
    }

    public c(int i) {
        this.rWF = i;
    }

    final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar) {
        this.context = context;
        this.rXh = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof b)) {
            w.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
        } else if (((b) kVar).bwi() != this.rWF) {
            w.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[]{Integer.valueOf(this.rWF), Integer.valueOf(((b) kVar).bwi())});
        } else {
            int type = kVar.getType();
            if (type == 1093) {
                ap.vd().b(1093, this);
                m mVar = (m) kVar;
                if (mVar == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "");
                } else if (mVar.rWD == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                } else {
                    int i3 = 0;
                    if (!(mVar.bwj() == null || mVar.bwj().tLs == null)) {
                        i3 = mVar.bwj().tLs.fIz;
                    }
                    if (i == 0 && i2 == 0) {
                        agu bwj = mVar.bwj();
                        agt com_tencent_mm_protocal_c_agt = mVar.gUA == null ? null : (agt) mVar.gUA.hsj.hsr;
                        if (bwj == null || bg.mA(mVar.mkT) || com_tencent_mm_protocal_c_agt == null || bg.mA(com_tencent_mm_protocal_c_agt.fTO)) {
                            String str2 = "MicroMsg.webview.JSVerifyHelper";
                            String str3 = "something null %b, %b, %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(bwj == null);
                            objArr[1] = Boolean.valueOf(bg.mA(mVar.mkT));
                            objArr[2] = Boolean.valueOf(com_tencent_mm_protocal_c_agt == null);
                            w.e(str2, str3, objArr);
                            mVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
                        } else if (bwj.tLs == null) {
                            w.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            mVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
                        } else if (bwj.tLs.fIz != 0) {
                            w.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[]{Integer.valueOf(bwj.tLs.fIz), bwj.tLs.fIA});
                            mVar.rWD.a(a.RET_FAIL, bwj.tLs.fIA, null, i2, i3);
                        } else {
                            this.sjA.put(xI(com_tencent_mm_protocal_c_agt.url), com_tencent_mm_protocal_c_agt.fTO);
                            d dVar = new d();
                            dVar.appId = com_tencent_mm_protocal_c_agt.fTO;
                            dVar.sjK = bwj.tLF;
                            this.mnj.put(xI(com_tencent_mm_protocal_c_agt.url), dVar);
                            mVar.rWD.a(a.RET_OK, null, bwj.tLE, i2, i3);
                        }
                    } else if (i == 4) {
                        mVar.rWD.a(a.RET_FAIL, i2 + "_" + str, null, i2, i3);
                    } else {
                        mVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
                    }
                }
            } else if (type == 1095) {
                ap.vd().b(1095, this);
                a(i, i2, str, (l) kVar);
            } else if (type == 1094) {
                ap.vd().b(1094, this);
                n nVar = (n) kVar;
                if (nVar == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    return;
                }
                int i4;
                g.oUh.a(157, 24, 1, false);
                if (nVar.bwk() == null || nVar.bwk().tLs == null) {
                    i4 = 0;
                } else {
                    i4 = nVar.bwk().tLs.fIz;
                }
                if (i == 0 && i2 == 0) {
                    agw bwk = nVar.bwk();
                    if (bwk == null || bwk.tLs == null) {
                        w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        nVar.rWD.a(a.RET_FAIL, null, null, i2, i4);
                        return;
                    } else if (bwk.tLs.fIz != 0) {
                        w.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(bwk.tLs.fIz), bwk.tLs.fIA});
                        nVar.rWD.a(a.RET_FAIL, bwk.tLs.fIA, null, i2, i4);
                        return;
                    } else {
                        biy com_tencent_mm_protocal_c_biy = bwk.tLG;
                        if (com_tencent_mm_protocal_c_biy == null) {
                            w.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            nVar.rWD.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            return;
                        } else if (com_tencent_mm_protocal_c_biy.uiB != 1) {
                            w.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_biy.uiB)});
                            nVar.rWD.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            return;
                        } else {
                            nVar.rWD.a(a.RET_OK, null, null, i2, i4);
                            return;
                        }
                    }
                }
                w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                g.oUh.a(157, 25, 1, false);
                if (i == 4) {
                    nVar.rWD.a(a.RET_FAIL, i2 + "_" + str, null, i2, i4);
                } else {
                    nVar.rWD.a(a.RET_FAIL, null, null, i2, i4);
                }
            } else if (type == 1096) {
                ap.vd().b(1096, this);
                o oVar = (o) kVar;
                agx com_tencent_mm_protocal_c_agx = oVar.gUA == null ? null : (agx) oVar.gUA.hsj.hsr;
                if (com_tencent_mm_protocal_c_agx == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                } else if (i != 0 || i2 != 0) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), com_tencent_mm_protocal_c_agx.tLm});
                } else if (com.tencent.mm.protocal.c.NH(bg.mz(com_tencent_mm_protocal_c_agx.tLm)) == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                } else {
                    agk com_tencent_mm_protocal_c_agk = ((o) kVar).rWG;
                    com_tencent_mm_protocal_c_agk.thx = 1;
                    this.sjz.put(com_tencent_mm_protocal_c_agx.tLm + com_tencent_mm_protocal_c_agx.url, com_tencent_mm_protocal_c_agk);
                }
            }
        }
    }

    private void a(int i, final int i2, String str, final l lVar) {
        if (lVar == null) {
            w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            return;
        }
        int i3 = 0;
        if (!(lVar.bwh() == null || lVar.bwh().tLs == null)) {
            i3 = lVar.bwh().tLs.fIz;
        }
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i == 4) {
                lVar.rWD.a(a.RET_FAIL, str, null, i2, i3);
            } else {
                lVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
            }
        } else if (bg.mA(lVar.rWE)) {
            w.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            lVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
        } else {
            agm bwh = lVar.bwh();
            if (bwh == null || bwh.tLs == null) {
                w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                lVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
            } else if (bwh.tLs.fIz != 0) {
                w.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[]{Integer.valueOf(bwh.tLs.fIz), bwh.tLs.fIA});
                lVar.rWD.a(a.RET_FAIL, bwh.tLs.fIA, null, i2, i3);
            } else {
                w.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[]{Integer.valueOf(lVar.bwg() == null ? 0 : lVar.bwg().tLr)});
                if ((lVar.bwg() == null ? 0 : lVar.bwg().tLr) == 1) {
                    if (bwh.tLv == null) {
                        w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        lVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
                        return;
                    }
                    Iterator it = bwh.tLv.iterator();
                    while (it.hasNext()) {
                        ahl com_tencent_mm_protocal_c_ahl = (ahl) it.next();
                        if (com_tencent_mm_protocal_c_ahl.tLW == null) {
                            w.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator it2 = com_tencent_mm_protocal_c_ahl.tLW.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                if (!bg.mA(str2)) {
                                    agk com_tencent_mm_protocal_c_agk = new agk();
                                    com_tencent_mm_protocal_c_agk.tLm = str2;
                                    com_tencent_mm_protocal_c_agk.thx = com_tencent_mm_protocal_c_ahl.tLU;
                                    com_tencent_mm_protocal_c_agk.tLn = com_tencent_mm_protocal_c_ahl.tLV;
                                    this.sjz.put(com_tencent_mm_protocal_c_agk.tLm + lVar.url, com_tencent_mm_protocal_c_agk);
                                }
                            }
                        }
                    }
                } else if (bwh.tLt == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    lVar.rWD.a(a.RET_FAIL, "nullAuthInfo", null, i2, i3);
                    return;
                } else {
                    Iterator it3 = bwh.tLt.iterator();
                    while (it3.hasNext()) {
                        agk com_tencent_mm_protocal_c_agk2 = (agk) it3.next();
                        if (!bg.mA(com_tencent_mm_protocal_c_agk2.tLm)) {
                            this.sjz.put(com_tencent_mm_protocal_c_agk2.tLm + lVar.url, com_tencent_mm_protocal_c_agk2);
                        }
                    }
                }
                final agk com_tencent_mm_protocal_c_agk3 = (agk) this.sjz.get(lVar.rWE + lVar.url);
                if (com_tencent_mm_protocal_c_agk3 == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[]{lVar.rWE, lVar.url});
                    lVar.rWD.a(a.RET_FAIL, null, null, i2, i3);
                } else if (com_tencent_mm_protocal_c_agk3.thx == 1) {
                    lVar.rWD.a(a.RET_OK, null, null, i2, i3);
                } else if (this.context == null) {
                    w.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    a(lVar, i2, com_tencent_mm_protocal_c_agk3);
                } else {
                    WebViewStubTempUI.a(this.context, this.rXh, bg.mz(com_tencent_mm_protocal_c_agk3.tLn), "", this.context.getString(R.l.evv), this.context.getString(R.l.evu), new OnClickListener(this) {
                        final /* synthetic */ c sjD;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
                            this.sjD.a(lVar, i2, com_tencent_mm_protocal_c_agk3);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ c sjD;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
                            lVar.rWD.a(a.RET_REJECT, "cancel", null, i2, lVar.bwh().tLs.fIz);
                        }
                    });
                }
            }
        }
    }

    public final void a(l lVar, int i, agk com_tencent_mm_protocal_c_agk) {
        agl bwg = lVar.bwg();
        agm bwh = lVar.bwh();
        if (bwg == null) {
            w.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            lVar.rWD.a(a.RET_FAIL, null, null, i, lVar.bwh().tLs.fIz);
        } else if (bwh == null) {
            w.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            lVar.rWD.a(a.RET_FAIL, null, null, i, lVar.bwh().tLs.fIz);
        } else {
            ap.vd().a(1096, this);
            LinkedList linkedList = bwh.tLv;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ahl com_tencent_mm_protocal_c_ahl = (ahl) it.next();
                    if (com_tencent_mm_protocal_c_ahl != null) {
                        w.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{com_tencent_mm_protocal_c_ahl.tLW, com_tencent_mm_protocal_c_ahl.scope, com_tencent_mm_protocal_c_ahl.tLV, Integer.valueOf(com_tencent_mm_protocal_c_ahl.tLU), bwg.tLm});
                        com_tencent_mm_protocal_c_ahl.tLU = 1;
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    if (((ahl) it.next()) != null) {
                        w.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[]{((ahl) it.next()).tLW, ((ahl) it.next()).scope, ((ahl) it.next()).tLV, Integer.valueOf(((ahl) it.next()).tLU), bwg.tLm});
                    }
                }
            }
            ap.vd().a(new o(com_tencent_mm_protocal_c_agk, bwg.url, bwg.msh, bwg.tLm, bwg.lUw, bwg.tLo, bwg.signature, bwg.tLp, bwg.tLq, bwg.tLr, linkedList, this.rWF), 0);
            lVar.rWD.a(a.RET_OK, null, null, i, lVar.bwh().tLs.fIz);
        }
    }

    static String xI(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
