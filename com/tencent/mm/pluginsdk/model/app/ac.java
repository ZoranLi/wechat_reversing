package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.b.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.ue;
import com.tencent.mm.protocal.c.uf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ac extends k implements j {
    private static final String[] sDQ = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};
    final String appId;
    private b gUA;
    private e gUD;
    private final int hSo = 3;

    public ac(String str) {
        this.appId = str;
        a aVar = new a();
        aVar.hsm = new ue();
        aVar.hsn = new uf();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfo";
        aVar.hsl = 231;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (this.appId == null || this.appId.length() == 0) {
            w.e("MicroMsg.NetSceneGetAppInfo", "doScene fail, appId is null");
            return -1;
        }
        ue ueVar = (ue) this.gUA.hsj.hsr;
        ueVar.msh = this.appId;
        ueVar.tvY = this.hSo;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 4 && i3 == -1011) {
            w.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3 + ", appinfo does not exist");
            com.tencent.mm.plugin.w.a.aRr();
            c bDc = i.bDc();
            bDc.field_appId = this.appId;
            com.tencent.mm.plugin.w.a.aRr().a(bDc);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            f fVar;
            uf ufVar = (uf) ((b) pVar).hsk.hsr;
            String str2 = ufVar.tCj.teg;
            aoq com_tencent_mm_protocal_c_aoq = ufVar.tCj;
            if (com_tencent_mm_protocal_c_aoq == null) {
                w.e("MicroMsg.NetSceneGetAppInfo", "convertToAppInfo : openAppInfo is null");
                fVar = null;
            } else {
                fVar = new f();
                fVar.field_appId = com_tencent_mm_protocal_c_aoq.msh;
                fVar.field_appName = com_tencent_mm_protocal_c_aoq.muS;
                fVar.field_appDiscription = com_tencent_mm_protocal_c_aoq.tTF;
                fVar.field_appIconUrl = com_tencent_mm_protocal_c_aoq.tee;
                fVar.field_appStoreUrl = com_tencent_mm_protocal_c_aoq.msD;
                fVar.field_appVersion = com_tencent_mm_protocal_c_aoq.tkv;
                fVar.field_appWatermarkUrl = com_tencent_mm_protocal_c_aoq.tTG;
                fVar.field_packageName = com_tencent_mm_protocal_c_aoq.teg;
                fVar.field_signature = p.Mi(com_tencent_mm_protocal_c_aoq.tku);
                fVar.field_appName_en = com_tencent_mm_protocal_c_aoq.tTH;
                fVar.field_appName_tw = com_tencent_mm_protocal_c_aoq.tTJ;
                fVar.field_appDiscription_en = com_tencent_mm_protocal_c_aoq.tTI;
                fVar.field_appDiscription_tw = com_tencent_mm_protocal_c_aoq.tTK;
                fVar.field_appInfoFlag = com_tencent_mm_protocal_c_aoq.msp;
                w.d("MicroMsg.NetSceneGetAppInfo", "appid = %s, appInfoFlag = %s", fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag));
            }
            if (fVar == null) {
                w.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info is null");
                this.gUD.a(3, -1, str, this);
                return;
            }
            fVar.field_appType = ufVar.tgZ;
            aoq com_tencent_mm_protocal_c_aoq2 = ufVar.tCj;
            String str3 = com_tencent_mm_protocal_c_aoq2.teg;
            String str4 = com_tencent_mm_protocal_c_aoq2.tku;
            Object obj = (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) ? 1 : null;
            if (obj != null || fVar.bCU()) {
                w.e("MicroMsg.NetSceneGetAppInfo", "no android app, packageName = " + str2);
                com.tencent.mm.pluginsdk.ui.tools.b.Nk(this.appId);
            }
            if (fVar.field_appId == null) {
                w.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : info.appId is null");
                this.gUD.a(3, -1, str, this);
            } else if (fVar.field_appId.equals(this.appId)) {
                i aRr = com.tencent.mm.plugin.w.a.aRr();
                n Me = aRr.Me(this.appId);
                if (Me == null || Me.field_appId == null || Me.field_appId.length() == 0) {
                    fVar.field_status = obj != null ? 3 : 4;
                    fVar.field_modifyTime = System.currentTimeMillis();
                    if (fVar.field_appId != null) {
                        for (Object equals : sDQ) {
                            if (fVar.field_appId.equals(equals)) {
                                fVar.field_status = -1;
                                break;
                            }
                        }
                    }
                    if (aRr.l(fVar)) {
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 1);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 2);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 3);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 4);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 5);
                    } else {
                        w.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : insert fail");
                        this.gUD.a(3, -1, str, this);
                        return;
                    }
                }
                fVar.field_status = obj != null ? 3 : Me.field_status;
                if (fVar.field_appId != null) {
                    for (Object equals2 : sDQ) {
                        if (fVar.field_appId.equals(equals2)) {
                            fVar.field_status = -1;
                            break;
                        }
                    }
                }
                if (Me == null) {
                    w.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appinfo is null");
                } else {
                    if (Me.bCV()) {
                        if (!bg.mA(Me.field_appIconUrl)) {
                            fVar.field_appIconUrl = Me.field_appIconUrl;
                        }
                        if (!bg.mA(Me.field_appName)) {
                            fVar.field_appName = Me.field_appName;
                        }
                        if (!bg.mA(Me.field_appName_en)) {
                            fVar.field_appName_en = Me.field_appName_en;
                        }
                        if (!bg.mA(Me.field_appName_tw)) {
                            fVar.field_appName_tw = Me.field_appName_tw;
                        }
                        if (!bg.mA(Me.field_appName_hk)) {
                            fVar.field_appName_hk = Me.field_appName_hk;
                        }
                    }
                    if (bg.mA(fVar.field_appId) || bg.mA(Me.field_appId)) {
                        w.e("MicroMsg.NetSceneGetAppInfo", "merge failed, some appid is null");
                    } else if (fVar.field_appId.equalsIgnoreCase(Me.field_appId)) {
                        fVar.field_openId = Me.field_openId;
                        fVar.field_authFlag = Me.field_authFlag;
                        fVar.bB(Me.gfa);
                        fVar.bC(Me.gfb);
                        fVar.bD(Me.gfc);
                    } else {
                        w.e("MicroMsg.NetSceneGetAppInfo", "merge failed, appis is different");
                    }
                }
                if (aRr.a(fVar, new String[0])) {
                    if (Me == null || Me.field_appIconUrl == null || Me.field_appIconUrl.length() == 0) {
                        obj = 1;
                    } else {
                        if (!bg.mA(fVar.gfu)) {
                            if (bg.mA(Me.gfu)) {
                                obj = 1;
                            } else if (!Me.gfu.equals(Me.gfu)) {
                                obj = 1;
                            }
                        }
                        if (!bg.mA(fVar.gfv)) {
                            if (bg.mA(Me.gfv)) {
                                obj = 1;
                            } else if (!Me.gfv.equals(Me.gfv)) {
                                obj = 1;
                            }
                        }
                        obj = (fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? null : !Me.field_appIconUrl.equals(fVar.field_appIconUrl) ? 1 : null;
                    }
                    if (obj != null) {
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 1);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 2);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 3);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 4);
                        com.tencent.mm.plugin.w.a.aRp().cu(this.appId, 5);
                    }
                } else {
                    w.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : update fail");
                    this.gUD.a(3, -1, str, this);
                    return;
                }
                if (bg.mA(fVar.field_openId)) {
                    w.d("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd, openId is null, trigger getAppSetting, appId = " + fVar.field_appId);
                    com.tencent.mm.plugin.w.a.aRs().Jl(fVar.field_appId);
                }
                this.gUD.a(i2, i3, str, this);
            } else {
                w.e("MicroMsg.NetSceneGetAppInfo", "onGYNetEnd : appId is different");
                this.gUD.a(3, -1, str, this);
            }
        } else {
            w.e("MicroMsg.NetSceneGetAppInfo", "errType = " + i2 + ", errCode = " + i3);
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 231;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }
}
