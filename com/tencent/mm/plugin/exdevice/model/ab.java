package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.gr;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.exdevice.a;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.protocal.c.aeo;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.x.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ab extends c<gr> implements e {
    private ProgressDialog isv;
    public gr ldR;

    public ab() {
        this.usg = gr.class.getName().hashCode();
    }

    private boolean a(gr grVar) {
        if (grVar instanceof gr) {
            this.ldR = grVar;
            String str = this.ldR.fLZ.result;
            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "action = %s, key = %s", new Object[]{Integer.valueOf(this.ldR.fLZ.actionCode), str});
            if (!bg.mA(str)) {
                switch (this.ldR.fLZ.actionCode) {
                    case 15:
                        if (this.ldR.fLZ.context != null && (this.ldR.fLZ.context instanceof Activity)) {
                            ap.vd().a(540, this);
                            final k uVar = new u(str);
                            ap.vd().a(uVar, 0);
                            Context context = this.ldR.fLZ.context;
                            this.ldR.fLZ.context.getString(R.l.dIO);
                            this.isv = g.a(context, this.ldR.fLZ.context.getString(R.l.eOV), new OnCancelListener(this) {
                                final /* synthetic */ ab ldT;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ap.vd().c(uVar);
                                    if (this.ldT.ldR.nFq != null) {
                                        this.ldT.ldR.fMa.ret = 1;
                                        this.ldT.ldR.nFq.run();
                                    }
                                }
                            });
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        w.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (kVar == null) {
            apr();
        } else if (i == 0 && i2 == 0) {
            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 540) {
                ap.vd().b(540, this);
                u uVar = (u) kVar;
                awz com_tencent_mm_protocal_c_awz = (uVar.gUA == null || uVar.gUA.hsk.hsr == null) ? null : (awz) uVar.gUA.hsk.hsr;
                if (com_tencent_mm_protocal_c_awz == null) {
                    w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp == null");
                    apr();
                    return;
                }
                String str2;
                String str3;
                LinkedList linkedList;
                String str4;
                ArrayList arrayList;
                int i3;
                bdo com_tencent_mm_protocal_c_bdo;
                Intent intent;
                Object obj;
                boolean contains;
                ame com_tencent_mm_protocal_c_ame;
                String mz;
                af Rc;
                af xVar;
                bcp com_tencent_mm_protocal_c_bcp;
                BizInfo hO;
                my myVar;
                aen com_tencent_mm_protocal_c_aen = com_tencent_mm_protocal_c_awz.tjo;
                if (com_tencent_mm_protocal_c_aen != null) {
                    w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "deviceId = %s, deviceType = %s", new Object[]{com_tencent_mm_protocal_c_aen.jNm, com_tencent_mm_protocal_c_aen.thD});
                }
                aeo com_tencent_mm_protocal_c_aeo = com_tencent_mm_protocal_c_awz.tjp;
                if (com_tencent_mm_protocal_c_aeo != null) {
                    w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "AuthKey = %s, BrandName = %s, CloseStrategy = %s, ConnProto = %s, ConnStrategy = %s, Mac = %s", new Object[]{com_tencent_mm_protocal_c_aeo.thm, com_tencent_mm_protocal_c_aeo.tJE, Integer.valueOf(com_tencent_mm_protocal_c_aeo.tJH), com_tencent_mm_protocal_c_aeo.tJF, Integer.valueOf(com_tencent_mm_protocal_c_aeo.tJG), com_tencent_mm_protocal_c_aeo.tiU});
                }
                String str5 = "";
                String str6 = "";
                LinkedList linkedList2 = new LinkedList();
                if (com_tencent_mm_protocal_c_awz.tZP != null) {
                    if (com_tencent_mm_protocal_c_awz.tZP.tfw != null) {
                        str5 = com_tencent_mm_protocal_c_awz.tZP.tfw;
                    }
                    if (com_tencent_mm_protocal_c_awz.tZP.title != null) {
                        str6 = com_tencent_mm_protocal_c_awz.tZP.title;
                    }
                    if (com_tencent_mm_protocal_c_awz.tZP.tfx != null) {
                        str2 = str5;
                        str3 = str6;
                        linkedList = com_tencent_mm_protocal_c_awz.tZP.tfx;
                        str4 = str3;
                        arrayList = new ArrayList();
                        if (linkedList != null && linkedList.size() > 0) {
                            for (i3 = 0; i3 < linkedList.size(); i3++) {
                                com_tencent_mm_protocal_c_bdo = (bdo) linkedList.get(i3);
                                if (com_tencent_mm_protocal_c_bdo.type.contains("text")) {
                                    arrayList.add(com_tencent_mm_protocal_c_bdo.content);
                                }
                            }
                        }
                        w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{com_tencent_mm_protocal_c_awz.tiZ});
                        if (com_tencent_mm_protocal_c_awz.tZO != 1) {
                            intent = new Intent();
                            intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                            obj = (com_tencent_mm_protocal_c_aeo.tJF.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || com_tencent_mm_protocal_c_aeo.tJF.contains("1")) ? 1 : null;
                            contains = com_tencent_mm_protocal_c_aeo.tJF.contains("4");
                            if (obj == null && contains) {
                                w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Category connect proto can not be blue&wifi at the same time...");
                                return;
                            }
                            if (obj != null) {
                                intent.putExtra("device_scan_conn_proto", "blue");
                            } else if (contains) {
                                intent.putExtra("device_scan_conn_proto", "wifi");
                            }
                            intent.putExtra("device_id", com_tencent_mm_protocal_c_aen.jNm);
                            intent.putExtra("device_type", com_tencent_mm_protocal_c_aen.thD);
                            intent.putExtra("device_title", com_tencent_mm_protocal_c_aeo.tJL);
                            intent.putExtra("device_desc", com_tencent_mm_protocal_c_aeo.tJM);
                            intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_aeo.muU);
                            intent.putExtra("device_category_id", com_tencent_mm_protocal_c_aeo.tJN);
                            intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_aeo.tJE);
                            intent.putExtra("bind_ticket", com_tencent_mm_protocal_c_awz.tiZ);
                            intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_aeo.gtW);
                            intent.putExtra("device_airkiss_key", str2);
                            intent.putExtra("device_airkiss_title", str4);
                            intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                            d.b(this.ldR.fLZ.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                            acS();
                        }
                        com_tencent_mm_protocal_c_ame = com_tencent_mm_protocal_c_awz.tja;
                        if (com_tencent_mm_protocal_c_ame != null) {
                            w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                            apr();
                            return;
                        }
                        acS();
                        if (com_tencent_mm_protocal_c_ame != null) {
                            w.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        } else {
                            str2 = n.a(com_tencent_mm_protocal_c_ame.ttp);
                            mz = bg.mz(com_tencent_mm_protocal_c_ame.tQL);
                            if (bg.mA(str2) || !bg.mA(mz)) {
                                w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                                ap.yY();
                                Rc = com.tencent.mm.u.c.wR().Rc(str2);
                                if (Rc == null && str2.equals(Rc.field_encryptUsername)) {
                                    w.w("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cat's replace user with stranger");
                                } else {
                                    xVar = new x(str2);
                                    xVar.bO(com_tencent_mm_protocal_c_ame.hAI);
                                    xVar.setType(com_tencent_mm_protocal_c_ame.tsx & com_tencent_mm_protocal_c_ame.tsy);
                                    if (bg.mA(mz)) {
                                        xVar.bX(mz);
                                    } else if (Rc != null && ((int) Rc.gTQ) > 0) {
                                        xVar.bX(Rc.field_encryptUsername);
                                    }
                                    xVar.gTQ = Rc != null ? 0 : (long) ((int) Rc.gTQ);
                                    xVar.bR(n.a(com_tencent_mm_protocal_c_ame.tLj));
                                    xVar.bS(n.a(com_tencent_mm_protocal_c_ame.ttf));
                                    xVar.bT(n.a(com_tencent_mm_protocal_c_ame.ttg));
                                    xVar.di(com_tencent_mm_protocal_c_ame.hAD);
                                    xVar.dl(com_tencent_mm_protocal_c_ame.tsD);
                                    xVar.bQ(n.a(com_tencent_mm_protocal_c_ame.tQF));
                                    xVar.dm(com_tencent_mm_protocal_c_ame.tsH);
                                    xVar.dn(com_tencent_mm_protocal_c_ame.hAH);
                                    xVar.ck(RegionCodeDecoder.ab(com_tencent_mm_protocal_c_ame.hAM, com_tencent_mm_protocal_c_ame.hAE, com_tencent_mm_protocal_c_ame.hAF));
                                    xVar.ce(com_tencent_mm_protocal_c_ame.hAG);
                                    xVar.de(com_tencent_mm_protocal_c_ame.tMP);
                                    xVar.cj(com_tencent_mm_protocal_c_ame.tMQ);
                                    xVar.setSource(com_tencent_mm_protocal_c_ame.tfW);
                                    xVar.dd(com_tencent_mm_protocal_c_ame.tMT);
                                    xVar.bU(com_tencent_mm_protocal_c_ame.tMS);
                                    if (o.fK(com_tencent_mm_protocal_c_ame.tMR)) {
                                        xVar.ci(com_tencent_mm_protocal_c_ame.tMR);
                                    }
                                    xVar.dp((int) bg.Ny());
                                    xVar.bP(n.a(com_tencent_mm_protocal_c_ame.tQl));
                                    xVar.bV(n.a(com_tencent_mm_protocal_c_ame.tQn));
                                    xVar.bW(n.a(com_tencent_mm_protocal_c_ame.tQm));
                                    xVar.cl(com_tencent_mm_protocal_c_ame.tgT);
                                    xVar.cm(com_tencent_mm_protocal_c_ame.tQV);
                                    if (!(Rc == null || bg.mz(Rc.gkL).equals(bg.mz(com_tencent_mm_protocal_c_ame.tQV)))) {
                                        com.tencent.mm.ar.c.Ih();
                                        com.tencent.mm.ar.c.jW(str2);
                                    }
                                    ap.yY();
                                    com.tencent.mm.u.c.wR().Rh(str2);
                                    if (bg.mA(xVar.field_username)) {
                                        str5 = xVar.field_username;
                                        com.tencent.mm.x.n.Bm().a(b.a(str5, com_tencent_mm_protocal_c_ame));
                                        com_tencent_mm_protocal_c_bcp = com_tencent_mm_protocal_c_ame.tMV;
                                        if (!(xVar.field_username.endsWith("@chatroom") || com_tencent_mm_protocal_c_bcp == null)) {
                                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bcp.hAO + " " + com_tencent_mm_protocal_c_ame.ttp);
                                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + com_tencent_mm_protocal_c_bcp.hAP);
                                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.hAQ);
                                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.udF);
                                            if (m.pQB != null) {
                                                m.pQB.a(xVar.field_username, com_tencent_mm_protocal_c_bcp);
                                            }
                                        }
                                        str6 = com.tencent.mm.u.m.xL();
                                        if (!(str6 == null || str6.equals(str5))) {
                                            hO = com.tencent.mm.modelbiz.w.DH().hO(str5);
                                            hO.field_username = str5;
                                            hO.field_brandList = com_tencent_mm_protocal_c_ame.hAN;
                                            myVar = com_tencent_mm_protocal_c_ame.tMW;
                                            if (myVar != null) {
                                                hO.field_brandFlag = myVar.hAR;
                                                hO.field_brandInfo = myVar.hAT;
                                                hO.field_brandIconURL = myVar.hAU;
                                                hO.field_extInfo = myVar.hAS;
                                                hO.field_attrSyncVersion = null;
                                                hO.field_incrementUpdateTime = 0;
                                            }
                                            if (!com.tencent.mm.modelbiz.w.DH().e(hO)) {
                                                com.tencent.mm.modelbiz.w.DH().d(hO);
                                            }
                                            xVar.dq(hO.field_type);
                                        }
                                    } else {
                                        w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                                    }
                                    xVar.dg(com_tencent_mm_protocal_c_ame.tQU);
                                    if (!(com_tencent_mm_protocal_c_ame.tQQ == null || com_tencent_mm_protocal_c_ame.tQQ.tfr == null)) {
                                        xVar.cn(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjr);
                                        xVar.co(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjs);
                                        xVar.cp(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjt);
                                    }
                                    if (o.fE(str2)) {
                                        xVar.tl();
                                    }
                                    if (xVar.bLe()) {
                                        xVar.to();
                                    }
                                    if (bg.mA(mz)) {
                                        ap.yY();
                                        com.tencent.mm.u.c.wR().b(mz, xVar);
                                    } else {
                                        ap.yY();
                                        com.tencent.mm.u.c.wR().Q(xVar);
                                    }
                                    if (!(Rc == null || (Rc.field_type & 2048) == (xVar.field_type & 2048))) {
                                        if ((xVar.field_type & 2048) == 0) {
                                            ap.yY();
                                            com.tencent.mm.u.c.wW().Rr(xVar.field_username);
                                        } else {
                                            ap.yY();
                                            com.tencent.mm.u.c.wW().Rs(xVar.field_username);
                                        }
                                    }
                                }
                            } else {
                                w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact user is null user:%s enuser:%s", new Object[]{str2, mz});
                            }
                        }
                        str5 = n.a(com_tencent_mm_protocal_c_ame.ttp);
                        if (this.ldR != null || this.ldR.fLZ == null || this.ldR.fLZ.context == null) {
                            w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                            return;
                        }
                        ap.yY();
                        af Rc2 = com.tencent.mm.u.c.wR().Rc(str5);
                        if (Rc2 == null) {
                            return;
                        }
                        if (com_tencent_mm_protocal_c_aeo.gtV != 0 && com_tencent_mm_protocal_c_aen != null) {
                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to DeviceProfileUI.");
                            Context context = this.ldR.fLZ.context;
                            Intent intent2 = new Intent(context, ExdeviceDeviceProfileUI.class);
                            if (!(context instanceof Activity)) {
                                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            }
                            intent2.putExtra("device_id", com_tencent_mm_protocal_c_aen.jNm);
                            intent2.putExtra("device_type", com_tencent_mm_protocal_c_aen.thD);
                            intent2.putExtra("device_mac", com_tencent_mm_protocal_c_aeo.tiU);
                            intent2.putExtra("device_brand_name", com_tencent_mm_protocal_c_aeo.tJE);
                            intent2.putExtra("device_alias", com_tencent_mm_protocal_c_aeo.hAI);
                            intent2.putExtra("device_desc", com_tencent_mm_protocal_c_aeo.tJM);
                            intent2.putExtra("device_title", com_tencent_mm_protocal_c_aeo.tJL);
                            intent2.putExtra("device_icon_url", com_tencent_mm_protocal_c_aeo.muU);
                            intent2.putExtra("device_jump_url", com_tencent_mm_protocal_c_aeo.msF);
                            intent2.putExtra("bind_ticket", com_tencent_mm_protocal_c_awz.tiZ);
                            intent2.putExtra("device_has_bound", ad.apt().bU(Rc2.field_username, com_tencent_mm_protocal_c_aen.jNm) != null);
                            context.startActivity(intent2);
                            return;
                        } else if (com_tencent_mm_protocal_c_aen != null) {
                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "Jump to ContactInfoUI.");
                            intent = new Intent();
                            intent.putExtra("Contact_User", str5);
                            intent.putExtra("KIsHardDevice", true);
                            intent.putExtra("KHardDeviceBindTicket", com_tencent_mm_protocal_c_awz.tiZ);
                            intent.putExtra("device_id", com_tencent_mm_protocal_c_aen.jNm);
                            intent.putExtra("device_type", com_tencent_mm_protocal_c_aen.thD);
                            a.lao.d(intent, this.ldR.fLZ.context);
                            return;
                        } else {
                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "cannot jump.");
                            return;
                        }
                    }
                }
                str2 = str5;
                str3 = str6;
                linkedList = linkedList2;
                str4 = str3;
                arrayList = new ArrayList();
                for (i3 = 0; i3 < linkedList.size(); i3++) {
                    com_tencent_mm_protocal_c_bdo = (bdo) linkedList.get(i3);
                    if (com_tencent_mm_protocal_c_bdo.type.contains("text")) {
                        arrayList.add(com_tencent_mm_protocal_c_bdo.content);
                    }
                }
                w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "resp.BindTicket = %s", new Object[]{com_tencent_mm_protocal_c_awz.tiZ});
                if (com_tencent_mm_protocal_c_awz.tZO != 1) {
                    com_tencent_mm_protocal_c_ame = com_tencent_mm_protocal_c_awz.tja;
                    if (com_tencent_mm_protocal_c_ame != null) {
                        acS();
                        if (com_tencent_mm_protocal_c_ame != null) {
                            str2 = n.a(com_tencent_mm_protocal_c_ame.ttp);
                            mz = bg.mz(com_tencent_mm_protocal_c_ame.tQL);
                            if (bg.mA(str2)) {
                            }
                            w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "processModContact : %s", new Object[]{str2});
                            ap.yY();
                            Rc = com.tencent.mm.u.c.wR().Rc(str2);
                            if (Rc == null) {
                            }
                            xVar = new x(str2);
                            xVar.bO(com_tencent_mm_protocal_c_ame.hAI);
                            xVar.setType(com_tencent_mm_protocal_c_ame.tsx & com_tencent_mm_protocal_c_ame.tsy);
                            if (bg.mA(mz)) {
                                xVar.bX(Rc.field_encryptUsername);
                            } else {
                                xVar.bX(mz);
                            }
                            if (Rc != null) {
                            }
                            xVar.gTQ = Rc != null ? 0 : (long) ((int) Rc.gTQ);
                            xVar.bR(n.a(com_tencent_mm_protocal_c_ame.tLj));
                            xVar.bS(n.a(com_tencent_mm_protocal_c_ame.ttf));
                            xVar.bT(n.a(com_tencent_mm_protocal_c_ame.ttg));
                            xVar.di(com_tencent_mm_protocal_c_ame.hAD);
                            xVar.dl(com_tencent_mm_protocal_c_ame.tsD);
                            xVar.bQ(n.a(com_tencent_mm_protocal_c_ame.tQF));
                            xVar.dm(com_tencent_mm_protocal_c_ame.tsH);
                            xVar.dn(com_tencent_mm_protocal_c_ame.hAH);
                            xVar.ck(RegionCodeDecoder.ab(com_tencent_mm_protocal_c_ame.hAM, com_tencent_mm_protocal_c_ame.hAE, com_tencent_mm_protocal_c_ame.hAF));
                            xVar.ce(com_tencent_mm_protocal_c_ame.hAG);
                            xVar.de(com_tencent_mm_protocal_c_ame.tMP);
                            xVar.cj(com_tencent_mm_protocal_c_ame.tMQ);
                            xVar.setSource(com_tencent_mm_protocal_c_ame.tfW);
                            xVar.dd(com_tencent_mm_protocal_c_ame.tMT);
                            xVar.bU(com_tencent_mm_protocal_c_ame.tMS);
                            if (o.fK(com_tencent_mm_protocal_c_ame.tMR)) {
                                xVar.ci(com_tencent_mm_protocal_c_ame.tMR);
                            }
                            xVar.dp((int) bg.Ny());
                            xVar.bP(n.a(com_tencent_mm_protocal_c_ame.tQl));
                            xVar.bV(n.a(com_tencent_mm_protocal_c_ame.tQn));
                            xVar.bW(n.a(com_tencent_mm_protocal_c_ame.tQm));
                            xVar.cl(com_tencent_mm_protocal_c_ame.tgT);
                            xVar.cm(com_tencent_mm_protocal_c_ame.tQV);
                            com.tencent.mm.ar.c.Ih();
                            com.tencent.mm.ar.c.jW(str2);
                            ap.yY();
                            com.tencent.mm.u.c.wR().Rh(str2);
                            if (bg.mA(xVar.field_username)) {
                                str5 = xVar.field_username;
                                com.tencent.mm.x.n.Bm().a(b.a(str5, com_tencent_mm_protocal_c_ame));
                                com_tencent_mm_protocal_c_bcp = com_tencent_mm_protocal_c_ame.tMV;
                                w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsFlag modcontact " + com_tencent_mm_protocal_c_bcp.hAO + " " + com_tencent_mm_protocal_c_ame.ttp);
                                w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBg modcontact " + com_tencent_mm_protocal_c_bcp.hAP);
                                w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.hAQ);
                                w.i("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "SnsBgId modcontact " + com_tencent_mm_protocal_c_bcp.udF);
                                if (m.pQB != null) {
                                    m.pQB.a(xVar.field_username, com_tencent_mm_protocal_c_bcp);
                                }
                                str6 = com.tencent.mm.u.m.xL();
                                hO = com.tencent.mm.modelbiz.w.DH().hO(str5);
                                hO.field_username = str5;
                                hO.field_brandList = com_tencent_mm_protocal_c_ame.hAN;
                                myVar = com_tencent_mm_protocal_c_ame.tMW;
                                if (myVar != null) {
                                    hO.field_brandFlag = myVar.hAR;
                                    hO.field_brandInfo = myVar.hAT;
                                    hO.field_brandIconURL = myVar.hAU;
                                    hO.field_extInfo = myVar.hAS;
                                    hO.field_attrSyncVersion = null;
                                    hO.field_incrementUpdateTime = 0;
                                }
                                if (com.tencent.mm.modelbiz.w.DH().e(hO)) {
                                    com.tencent.mm.modelbiz.w.DH().d(hO);
                                }
                                xVar.dq(hO.field_type);
                            } else {
                                w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "dkinit dealModContactExtInfo failed invalid contact");
                            }
                            xVar.dg(com_tencent_mm_protocal_c_ame.tQU);
                            xVar.cn(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjr);
                            xVar.co(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjs);
                            xVar.cp(com_tencent_mm_protocal_c_ame.tQQ.tfr.tjt);
                            if (o.fE(str2)) {
                                xVar.tl();
                            }
                            if (xVar.bLe()) {
                                xVar.to();
                            }
                            if (bg.mA(mz)) {
                                ap.yY();
                                com.tencent.mm.u.c.wR().Q(xVar);
                            } else {
                                ap.yY();
                                com.tencent.mm.u.c.wR().b(mz, xVar);
                            }
                            if ((xVar.field_type & 2048) == 0) {
                                ap.yY();
                                com.tencent.mm.u.c.wW().Rs(xVar.field_username);
                            } else {
                                ap.yY();
                                com.tencent.mm.u.c.wW().Rr(xVar.field_username);
                            }
                        } else {
                            w.f("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "unable to parse mod contact");
                        }
                        str5 = n.a(com_tencent_mm_protocal_c_ame.ttp);
                        if (this.ldR != null) {
                        }
                        w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "a8KeyRedirectEvent null");
                        return;
                    }
                    w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "mContact == null");
                    apr();
                    return;
                }
                intent = new Intent();
                intent.putExtra("device_scan_mode", "SCAN_CATALOG");
                if (!com_tencent_mm_protocal_c_aeo.tJF.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                }
                contains = com_tencent_mm_protocal_c_aeo.tJF.contains("4");
                if (obj == null) {
                }
                if (obj != null) {
                    intent.putExtra("device_scan_conn_proto", "blue");
                } else if (contains) {
                    intent.putExtra("device_scan_conn_proto", "wifi");
                }
                intent.putExtra("device_id", com_tencent_mm_protocal_c_aen.jNm);
                intent.putExtra("device_type", com_tencent_mm_protocal_c_aen.thD);
                intent.putExtra("device_title", com_tencent_mm_protocal_c_aeo.tJL);
                intent.putExtra("device_desc", com_tencent_mm_protocal_c_aeo.tJM);
                intent.putExtra("device_icon_url", com_tencent_mm_protocal_c_aeo.muU);
                intent.putExtra("device_category_id", com_tencent_mm_protocal_c_aeo.tJN);
                intent.putExtra("device_brand_name", com_tencent_mm_protocal_c_aeo.tJE);
                intent.putExtra("bind_ticket", com_tencent_mm_protocal_c_awz.tiZ);
                intent.putExtra("device_ble_simple_proto", com_tencent_mm_protocal_c_aeo.gtW);
                intent.putExtra("device_airkiss_key", str2);
                intent.putExtra("device_airkiss_title", str4);
                intent.putStringArrayListExtra("device_airkiss_steps", arrayList);
                d.b(this.ldR.fLZ.context, "exdevice", ".ui.ExdeviceBindDeviceGuideUI", intent);
                acS();
            }
        } else {
            w.e("MicroMsg.exdevice.SearchDeviceGetA8KeyRedirectListener", "scene.getType() = %s", new Object[]{Integer.valueOf(kVar.getType())});
            apr();
        }
    }

    private void apr() {
        if (this.ldR != null && this.ldR.nFq != null) {
            this.ldR.fMa.ret = 1;
            this.ldR.nFq.run();
        }
    }

    private void acS() {
        if (this.ldR != null && this.ldR.nFq != null) {
            this.ldR.fMa.ret = 2;
            this.ldR.nFq.run();
        }
    }
}
