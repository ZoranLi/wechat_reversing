package com.tencent.mm.pluginsdk.model;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.i.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.se;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e {
    public static boolean a(cb cbVar, Intent intent) {
        if (cbVar == null) {
            w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null");
            if (cbVar.fFA == null) {
                return false;
            }
            cbVar.fFA.fFG = R.l.eib;
            return false;
        }
        double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
        int intExtra = intent.getIntExtra("kwebmap_scale", 0);
        String ap = bg.ap(intent.getStringExtra("Kwebmap_locaion"), "");
        String stringExtra = intent.getStringExtra("kPoiName");
        intent.getCharSequenceExtra("kRemark");
        intent.getStringArrayListExtra("kTags");
        rs rsVar = new rs();
        rsVar.Ou(ap);
        rsVar.m(doubleExtra);
        rsVar.l(doubleExtra2);
        rsVar.yf(intExtra);
        rsVar.Ov(stringExtra);
        rv rvVar = new rv();
        rw rwVar = new rw();
        String xL = m.xL();
        rwVar.OD(xL);
        rwVar.OE(xL);
        rwVar.yj(6);
        rwVar.ep(bg.Nz());
        rvVar.b(rsVar);
        rvVar.a(rwVar);
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 6;
        return true;
    }

    public static boolean a(cb cbVar, int i, String str, String str2, String str3) {
        if (bg.mA(str)) {
            w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            cbVar.fFA.fFG = R.l.eib;
            return false;
        }
        w.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str2, str3, str, Integer.valueOf(i));
        if (new File(str).length() > ((long) b.sD())) {
            cbVar.fFA.fFG = R.l.ejH;
            return false;
        }
        rv rvVar = new rv();
        rw rwVar = new rw();
        rm rmVar = new rm();
        rmVar.NZ(str);
        rmVar.yb(8);
        rmVar.NV(com.tencent.mm.a.e.aQ(str));
        rmVar.jK(true);
        rmVar.NL(str2);
        rmVar.NM(str3);
        rwVar.OD(m.xL());
        rwVar.OE(m.xL());
        rwVar.yj(i);
        rwVar.ep(bg.Nz());
        rvVar.a(rwVar);
        rvVar.tzn.add(rmVar);
        cbVar.fFA.title = rmVar.title;
        cbVar.fFA.desc = rmVar.title;
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 8;
        return true;
    }

    public static boolean a(cb cbVar, int i, String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
            cbVar.fFA.fFG = R.l.eib;
            return false;
        }
        w.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", str, Integer.valueOf(i));
        rv rvVar = new rv();
        rw rwVar = new rw();
        rm rmVar = new rm();
        rmVar.yb(2);
        rmVar.NZ(str);
        rmVar.NY(g.n((rmVar.toString() + 2 + System.currentTimeMillis()).getBytes()));
        com.tencent.mm.sdk.b.b fpVar = new fp();
        fpVar.fKp.type = 27;
        fpVar.fKp.fKr = rmVar;
        a.urY.m(fpVar);
        String str2 = fpVar.fKq.fKz;
        d.b(str, ck.CTRL_INDEX, ck.CTRL_INDEX, CompressFormat.JPEG, 90, str2);
        rmVar.Oa(str2);
        rwVar.OD(m.xL());
        rwVar.OE(m.xL());
        rwVar.yj(i);
        rwVar.ep(bg.Nz());
        rvVar.a(rwVar);
        rvVar.tzn.add(rmVar);
        cbVar.fFA.title = rmVar.title;
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 2;
        return true;
    }

    public static boolean a(cb cbVar, long j) {
        return a(cbVar, ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA(j));
    }

    public static boolean a(cb cbVar, au auVar) {
        boolean z = false;
        boolean z2 = true;
        if (cbVar == null || auVar == null) {
            w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event or msg is null");
            if (cbVar != null) {
                cbVar.fFA.fFG = R.l.eib;
            }
        } else {
            au Y = au.Y(auVar);
            rv rvVar;
            if (Y.bMk()) {
                rvVar = new rv();
                rvVar.a(S(Y));
                cbVar.fFA.fFC = rvVar;
                if (Y.bMw()) {
                    cbVar.fFA.desc = Y.field_content + "\n\n" + Y.field_transContent;
                } else {
                    cbVar.fFA.desc = Y.field_content;
                }
                cbVar.fFA.type = 1;
                if (com.tencent.mm.ui.tools.h.Un(cbVar.fFA.desc) > b.sz()) {
                    cbVar.fFA.fFG = R.l.ejF;
                } else {
                    z = true;
                }
            } else if (Y.bLZ()) {
                rv rvVar2 = new rv();
                rvVar2.a(S(Y));
                r5 = new rm();
                a(r5, Y);
                if (o.fq(Y.field_talker)) {
                    String a = com.tencent.mm.sdk.platformtools.h.a(com.tencent.mm.plugin.record.b.xg(), "recbiz_", Y.field_imgPath, ".rec", 2);
                    if (bg.mA(a)) {
                        a = null;
                    } else {
                        new File(a).exists();
                    }
                    r5.NZ(a);
                } else {
                    r5.NZ(q.js(Y.field_imgPath));
                }
                r5.yb(3);
                r5.jK(true);
                com.tencent.mm.modelvoice.b lV = q.lV(Y.field_imgPath);
                if (lV != null) {
                    r5.NV(wV(lV.getFormat()));
                    r5.ya((int) new n(Y.field_content).time);
                    r0 = new LinkedList();
                    r0.add(r5);
                    rvVar2.av(r0);
                    cbVar.fFA.fFC = rvVar2;
                    cbVar.fFA.type = 3;
                    z = true;
                }
            } else if (Y.bMj()) {
                z = b(cbVar, Y);
            } else if (Y.bMh()) {
                com.tencent.mm.ah.d dVar = null;
                if (Y.field_msgId > 0) {
                    dVar = com.tencent.mm.ah.n.GS().aj(Y.field_msgId);
                }
                if ((dVar == null || dVar.hEY <= 0) && Y.field_msgSvrId > 0) {
                    dVar = com.tencent.mm.ah.n.GS().ai(Y.field_msgSvrId);
                }
                if (dVar == null) {
                    w.w("MicroMsg.GetFavDataSource", "getImgDataPath: try get imgInfo fail");
                    cbVar.fFA.fFG = R.l.eih;
                } else {
                    rv rvVar3 = new rv();
                    rvVar3.a(S(Y));
                    r4 = new rm();
                    a(r4, Y);
                    r4.yb(2);
                    r4.NZ(com.tencent.mm.ah.n.GS().m(com.tencent.mm.ah.e.c(dVar), "", ""));
                    if (dVar.GB()) {
                        dVar = com.tencent.mm.ah.n.GS().fT(dVar.hFi);
                        if (dVar.hrs > dVar.offset) {
                            r4.NZ(com.tencent.mm.ah.n.GS().m("SERVERID://" + Y.field_msgSvrId, "", ""));
                        }
                    }
                    r4.Oa(com.tencent.mm.ah.n.GS().v(Y.field_imgPath, true));
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(r4);
                    rvVar3.av(linkedList);
                    cbVar.fFA.fFC = rvVar3;
                    cbVar.fFA.type = 2;
                    z = true;
                }
            } else if (Y.bMl() || Y.bMm()) {
                rvVar = new rv();
                rvVar.a(S(Y));
                r4 = new rm();
                a(r4, Y);
                com.tencent.mm.modelvideo.o.KV();
                r4.Oa(s.lw(Y.field_imgPath));
                r4.NV(com.tencent.mm.a.e.aQ(r4.txG));
                r lH = t.lH(Y.field_imgPath);
                w.i("MicroMsg.GetFavDataSource", "video length is %d", Integer.valueOf(lH.hrs));
                if (lH.hrs > b.sD()) {
                    cbVar.fFA.fFG = R.l.ejH;
                } else if (Y.bMm() && t.lJ(lH.getFileName())) {
                    cbVar.fFA.fFG = R.l.eia;
                } else {
                    if (lH.Lk()) {
                        com.tencent.mm.modelvideo.o.KV();
                        w.i("MicroMsg.GetFavDataSource", "this video had finish download, set orgn path [%s]", s.lv(Y.field_imgPath));
                        r4.NZ(r6);
                    } else {
                        w.i("MicroMsg.GetFavDataSource", "this video had not finish download, set orgn path null");
                        r4.NZ("");
                    }
                    r4.ya(lH.iap);
                    r0 = new LinkedList();
                    r0.add(r4);
                    rvVar.av(r0);
                    cbVar.fFA.fFC = rvVar;
                    if (Y.bMm()) {
                        cbVar.fFA.type = 16;
                        r4.yb(15);
                    } else {
                        cbVar.fFA.type = 4;
                        r4.yb(4);
                    }
                    r lH2 = t.lH(Y.field_imgPath);
                    r4.Oj(lH2.fUY);
                    bdu com_tencent_mm_protocal_c_bdu = lH2.iay;
                    if (!(com_tencent_mm_protocal_c_bdu == null || bg.mA(com_tencent_mm_protocal_c_bdu.hjJ))) {
                        rp rpVar = new rp();
                        rpVar.hjD = com_tencent_mm_protocal_c_bdu.hjD;
                        rpVar.tyZ = com_tencent_mm_protocal_c_bdu.tyZ;
                        rpVar.hjG = com_tencent_mm_protocal_c_bdu.hjG;
                        rpVar.hjH = com_tencent_mm_protocal_c_bdu.hjH;
                        rpVar.hjF = com_tencent_mm_protocal_c_bdu.hjF;
                        rpVar.hjI = com_tencent_mm_protocal_c_bdu.hjI;
                        rpVar.hjJ = com_tencent_mm_protocal_c_bdu.hjJ;
                        rpVar.hjK = com_tencent_mm_protocal_c_bdu.hjK;
                        r4.a(rpVar);
                    }
                    z = true;
                }
            } else if (Y.bLX() || Y.bLY()) {
                z = c(cbVar, Y);
            } else if (Y.bMi() || !Y.axO() || Y.bMo()) {
                cbVar.fFA.fFG = R.l.eij;
            } else {
                rvVar = new rv();
                rvVar.a(S(Y));
                String str = Y.field_content;
                if (str != null) {
                    f.a ek = f.a.ek(str);
                    if (ek != null) {
                        cbVar.fFA.fFC = rvVar;
                        rw rwVar = rvVar.tzl;
                        rwVar.OJ(ek.appId);
                        rwVar.OL(ek.fUR);
                        com.tencent.mm.pluginsdk.model.app.b LW;
                        String v;
                        rm a2;
                        ru ruVar;
                        switch (ek.type) {
                            case 1:
                                cbVar.fFA.fFC = rvVar;
                                cbVar.fFA.desc = ek.title;
                                cbVar.fFA.type = 1;
                                break;
                            case 2:
                                if (!com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
                                    cbVar.fFA.fFG = R.l.eiq;
                                    z2 = false;
                                    break;
                                }
                                LW = com.tencent.mm.plugin.w.a.abL().LW(ek.fCW);
                                r5 = new rm();
                                a(r5, Y);
                                if (LW != null) {
                                    r5.NZ(LW.field_fileFullPath);
                                }
                                v = com.tencent.mm.ah.n.GS().v(Y.field_imgPath, true);
                                if (com.tencent.mm.a.e.aO(v)) {
                                    r5.Oa(v);
                                }
                                r5.yb(2);
                                r5.NL(ek.title);
                                r5.NM(ek.description);
                                rvVar.tzn.add(r5);
                                cbVar.fFA.type = 2;
                                break;
                            case 3:
                                rvVar.tzn.add(a(Y, ek, 7));
                                cbVar.fFA.type = 7;
                                break;
                            case 4:
                                a2 = a(Y, ek, 4);
                                rvVar.OB(a2.title);
                                rvVar.OC(a2.desc);
                                rvVar.tzn.add(a2);
                                cbVar.fFA.type = 4;
                                break;
                            case 5:
                                if (ek.url != null && !ek.url.equals("")) {
                                    rvVar.tzl.OK(ek.url);
                                    a2 = a(Y, ek, 5);
                                    rvVar.tzn.add(a2);
                                    rvVar.OB(a2.title);
                                    rvVar.OC(a2.desc);
                                    cbVar.fFA.type = 5;
                                    break;
                                }
                                cbVar.fFA.fFG = R.l.eif;
                                z2 = false;
                                break;
                            case 6:
                                if (!com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
                                    cbVar.fFA.fFG = R.l.eiq;
                                    z2 = false;
                                    break;
                                }
                                LW = com.tencent.mm.plugin.w.a.abL().LW(ek.fCW);
                                r5 = new rm();
                                if (LW != null) {
                                    r5.NZ(LW.field_fileFullPath);
                                }
                                a(r5, Y);
                                r5.yb(8);
                                r5.NV(ek.hhr);
                                v = com.tencent.mm.ah.n.GS().v(Y.field_imgPath, true);
                                if (bg.mA(v)) {
                                    r5.jK(true);
                                }
                                if (com.tencent.mm.a.e.aO(v)) {
                                    r5.Oa(v);
                                }
                                r5.NL(ek.title);
                                r5.NM(ek.description);
                                rvVar.tzn.add(r5);
                                cbVar.fFA.desc = ek.title;
                                cbVar.fFA.type = 8;
                                break;
                            case 7:
                                if (ek.fCW != null && ek.fCW.length() != 0) {
                                    if (!com.tencent.mm.kernel.h.vI().isSDCardAvailable()) {
                                        cbVar.fFA.fFG = R.l.eiq;
                                        z2 = false;
                                        break;
                                    }
                                }
                                cbVar.fFA.fFG = R.l.eic;
                                cbVar.fFA.fFG = R.l.eij;
                                z2 = false;
                                break;
                            case 10:
                                ruVar = new ru();
                                ruVar.Ow(ek.title);
                                ruVar.Ox(ek.description);
                                ruVar.yg(ek.hhL);
                                ruVar.Oz(ek.hhM);
                                ruVar.Oy(ek.thumburl);
                                cbVar.fFA.title = ek.title;
                                cbVar.fFA.desc = ek.description;
                                cbVar.fFA.type = 10;
                                rvVar.b(ruVar);
                                break;
                            case 13:
                                ruVar = new ru();
                                ruVar.Ow(ek.title);
                                ruVar.Ox(ek.description);
                                ruVar.yg(ek.hhR);
                                ruVar.Oz(ek.hhS);
                                ruVar.Oy(ek.thumburl);
                                cbVar.fFA.title = ek.title;
                                cbVar.fFA.desc = ek.description;
                                cbVar.fFA.type = 11;
                                rvVar.b(ruVar);
                                break;
                            case 19:
                            case 24:
                                cbVar.fFA.fFD = new se();
                                z2 = a(cbVar, ek, rvVar, Y);
                                break;
                            case 20:
                                rz rzVar = new rz();
                                rzVar.OM(ek.title);
                                rzVar.ON(ek.description);
                                rzVar.OP(ek.hhP);
                                rzVar.OO(ek.thumburl);
                                cbVar.fFA.title = ek.title;
                                cbVar.fFA.desc = ek.description;
                                cbVar.fFA.type = 15;
                                rvVar.b(rzVar);
                                break;
                            default:
                                cbVar.fFA.fFG = R.l.eij;
                                z2 = false;
                                break;
                        }
                    }
                    cbVar.fFA.fFG = R.l.eik;
                    z2 = false;
                } else {
                    cbVar.fFA.fFG = R.l.eik;
                    z2 = false;
                }
                z = z2;
            }
            cbVar.fFA.fFs = Y.field_content;
            if (z || cbVar.fFA.fFG == 0) {
                c.a(Y, cbVar, z);
            }
        }
        return z;
    }

    private static rw S(au auVar) {
        rw rwVar = new rw();
        if (auVar.field_isSend == 1) {
            rwVar.OD(m.xL());
            rwVar.OE(auVar.field_talker);
            if (o.dH(auVar.field_talker)) {
                rwVar.OG(rwVar.fOu);
            }
        } else {
            rwVar.OD(auVar.field_talker);
            rwVar.OE(m.xL());
            if (o.dH(auVar.field_talker)) {
                rwVar.OG(auVar.field_content != null ? auVar.field_content.substring(0, Math.max(0, auVar.field_content.indexOf(58))) : "");
                if (!(bg.mA(rwVar.tyQ) || auVar.bLZ())) {
                    auVar.setContent(auVar.field_content.substring(rwVar.tyQ.length() + 1));
                    if (auVar.field_content.length() > 0 && '\n' == auVar.field_content.charAt(0)) {
                        auVar.setContent(auVar.field_content.substring(1));
                    }
                    if (auVar.bMs()) {
                        auVar.cK(auVar.field_transContent.substring(rwVar.tyQ.length() + 1));
                        if (auVar.field_transContent.length() > 0 && '\n' == auVar.field_transContent.charAt(0)) {
                            auVar.cK(auVar.field_transContent.substring(1));
                        }
                    }
                }
            }
        }
        rwVar.yj(1);
        rwVar.ep(auVar.field_createTime);
        rwVar.OH(auVar.field_msgSvrId);
        if (auVar.field_msgSvrId > 0) {
            rwVar.OF(auVar.field_msgSvrId);
        }
        return rwVar;
    }

    private static boolean b(cb cbVar, au auVar) {
        rv rvVar = new rv();
        rvVar.a(S(auVar));
        Map q = bh.q(auVar.field_content, "msg");
        if (q != null) {
            try {
                rs rsVar = new rs();
                rsVar.Ou((String) q.get(".msg.location.$label"));
                rsVar.m(Double.parseDouble((String) q.get(".msg.location.$x")));
                rsVar.l(Double.parseDouble((String) q.get(".msg.location.$y")));
                rsVar.yf(Integer.valueOf((String) q.get(".msg.location.$scale")).intValue());
                rsVar.Ov((String) q.get(".msg.location.$poiname"));
                rvVar.b(rsVar);
                cbVar.fFA.type = 6;
                cbVar.fFA.fFC = rvVar;
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.GetFavDataSource", "parse failed, %s", e.getStackTrace().toString());
            }
        }
        cbVar.fFA.fFG = R.l.eik;
        return false;
    }

    private static void a(rm rmVar, au auVar) {
        if (auVar.field_isSend != 1) {
            rmVar.Od(String.valueOf(auVar.field_msgSvrId));
        } else if (o.dH(auVar.field_talker) || auVar.field_talker.equals("filehelper")) {
            rmVar.Od(String.valueOf(auVar.field_msgSvrId));
        } else {
            rmVar.Od(auVar.field_talker + "#" + String.valueOf(auVar.field_msgSvrId));
        }
    }

    public static String wV(int i) {
        if (i == 1) {
            return "speex";
        }
        if (i == 4) {
            return "silk";
        }
        return "amr";
    }

    private static rm a(au auVar, f.a aVar, int i) {
        rm rmVar = new rm();
        a(rmVar, auVar);
        rmVar.NS(aVar.hhH);
        rmVar.NT(aVar.hhI);
        rmVar.NR(aVar.url);
        rmVar.jJ(true);
        File file = new File(bg.ap(com.tencent.mm.ah.n.GS().v(auVar.field_imgPath, true), ""));
        if (file.exists()) {
            rmVar.Oa(file.getAbsolutePath());
        } else {
            rmVar.jK(true);
        }
        rmVar.NL(aVar.title);
        rmVar.NM(aVar.description);
        rmVar.Ok(aVar.canvasPageXml);
        rmVar.yb(i);
        rmVar.Oj(aVar.fUY);
        return rmVar;
    }

    private static boolean c(cb cbVar, au auVar) {
        rv rvVar = new rv();
        rw S = S(auVar);
        rvVar.a(S);
        try {
            k rV = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
            List list = rV.hkm;
            S.OL(rV.fUR);
            if (list != null && list.size() > cbVar.fFA.fFE) {
                w.i("MicroMsg.GetFavDataSource", "favorite biz msg, index is %d", Integer.valueOf(cbVar.fFA.fFE));
                l lVar = (l) list.get(cbVar.fFA.fFE);
                if (com.tencent.mm.t.h.em(lVar.hkx)) {
                    cbVar.fFA.fFG = R.l.eij;
                    return false;
                }
                String Bs;
                sf sfVar;
                S.OK(lVar.url);
                if (cbVar.fFA.fFE > 0) {
                    S.OF("");
                }
                rm rmVar = new rm();
                rmVar.NL(lVar.title);
                rmVar.NM(lVar.hku);
                a(rmVar, auVar);
                String str = lVar.hks;
                if (bg.mA(str)) {
                    com.tencent.mm.x.h hs = com.tencent.mm.x.n.Bm().hs(auVar.field_talker);
                    if (hs != null) {
                        Bs = hs.Bs();
                        if (bg.mA(Bs)) {
                            rmVar.Oa(s.n(Bs, auVar.field_type, cbVar.fFA.fFE <= 0 ? "@S" : "@T"));
                            rmVar.jK(false);
                            if (bg.mA(rmVar.txI) || !FileOp.aO(rmVar.txI)) {
                                rmVar.NU(Bs);
                                rmVar.jK(true);
                                sfVar = new sf();
                                sfVar.OT(Bs);
                                rvVar.b(sfVar);
                            }
                        } else {
                            rmVar.jK(true);
                        }
                        rmVar.jJ(true);
                        rmVar.yb(5);
                        rvVar.tzn.add(rmVar);
                        cbVar.fFA.fFC = rvVar;
                        cbVar.fFA.desc = lVar.title;
                        cbVar.fFA.type = 5;
                        return true;
                    }
                }
                Bs = str;
                if (bg.mA(Bs)) {
                    rmVar.jK(true);
                } else {
                    if (cbVar.fFA.fFE <= 0) {
                    }
                    rmVar.Oa(s.n(Bs, auVar.field_type, cbVar.fFA.fFE <= 0 ? "@S" : "@T"));
                    rmVar.jK(false);
                    rmVar.NU(Bs);
                    rmVar.jK(true);
                    sfVar = new sf();
                    sfVar.OT(Bs);
                    rvVar.b(sfVar);
                }
                rmVar.jJ(true);
                rmVar.yb(5);
                rvVar.tzn.add(rmVar);
                cbVar.fFA.fFC = rvVar;
                cbVar.fFA.desc = lVar.title;
                cbVar.fFA.type = 5;
                return true;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.GetFavDataSource", e, "", new Object[0]);
            w.e("MicroMsg.GetFavDataSource", "retransmit app msg error : %s", e.getLocalizedMessage());
        }
        cbVar.fFA.fFG = R.l.eik;
        return false;
    }

    private static boolean a(cb cbVar, f.a aVar, rv rvVar, au auVar) {
        com.tencent.mm.sdk.b.b lzVar = new lz();
        lzVar.fTf.type = 0;
        lzVar.fTf.fTh = aVar.hhQ;
        a.urY.m(lzVar);
        c cVar = lzVar.fTg.fTp;
        if (cVar == null) {
            w.w("MicroMsg.GetFavDataSource", "fill favorite event fail, parse record msg null");
            cbVar.fFA.fFG = R.l.eik;
            return false;
        }
        rvVar.OB(cVar.title);
        Iterator it = cVar.hkm.iterator();
        int i = 0;
        while (it.hasNext()) {
            rm rmVar;
            int i2;
            rm rmVar2 = (rm) it.next();
            rm q;
            se seVar;
            long j;
            com.tencent.mm.sdk.b.b lzVar2;
            se seVar2;
            switch (rmVar2.aMw) {
                case 1:
                    q = q(rmVar2);
                    q.yb(1);
                    q.NM(rmVar2.desc);
                    seVar = cbVar.fFA.fFD;
                    seVar.tzy++;
                    rmVar = q;
                    break;
                case 2:
                    j = auVar.field_msgId;
                    q = q(rmVar2);
                    q.yb(2);
                    lzVar2 = new lz();
                    lzVar2.fTf.type = 1;
                    lzVar2.fTf.fKe = rmVar2;
                    lzVar2.fTf.fGM = j;
                    a.urY.m(lzVar2);
                    if (bg.mA(lzVar2.fTg.fTq) && bg.mA(lzVar2.fTg.fKz)) {
                        w.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                    }
                    q.NZ(lzVar2.fTg.fTq);
                    q.Oa(lzVar2.fTg.fKz);
                    q.jK(false);
                    q.jJ(false);
                    seVar = cbVar.fFA.fFD;
                    seVar.tzz++;
                    rmVar = q;
                    break;
                case 3:
                    j = auVar.field_msgId;
                    q = q(rmVar2);
                    q.yb(3);
                    if (!bg.mA(rmVar2.tyk)) {
                        lzVar2 = new lz();
                        lzVar2.fTf.type = 1;
                        lzVar2.fTf.fKe = rmVar2;
                        lzVar2.fTf.fGM = j;
                        a.urY.m(lzVar2);
                        if (bg.mA(lzVar2.fTg.fTq) && bg.mA(lzVar2.fTg.fKz)) {
                            w.e("MicroMsg.GetFavDataSource", "cloneImgItem:not record plugin ? get paths error");
                        }
                        q.NZ(lzVar2.fTg.fTq);
                        q.ya(rmVar2.duration);
                        q.jK(true);
                        q.jJ(false);
                        q.NV(rmVar2.txx);
                    }
                    seVar = cbVar.fFA.fFD;
                    seVar.tzA++;
                    rmVar = q;
                    break;
                case 4:
                case 15:
                    j = auVar.field_msgId;
                    q = q(rmVar2);
                    a(q, rmVar2);
                    if (rmVar2.aMw == 15) {
                        q.yb(15);
                    } else {
                        q.yb(4);
                    }
                    lzVar2 = new lz();
                    lzVar2.fTf.type = 1;
                    lzVar2.fTf.fKe = rmVar2;
                    lzVar2.fTf.fGM = j;
                    a.urY.m(lzVar2);
                    if (bg.mA(lzVar2.fTg.fTq) && bg.mA(lzVar2.fTg.fKz)) {
                        w.e("MicroMsg.GetFavDataSource", "cloneVideoItem:not record plugin ? get paths error");
                    }
                    q.jJ(false);
                    q.NZ(lzVar2.fTg.fTq);
                    q.jK(false);
                    q.Oa(lzVar2.fTg.fKz);
                    q.ya(rmVar2.duration);
                    seVar = cbVar.fFA.fFD;
                    seVar.tzB++;
                    rmVar = q;
                    break;
                case 5:
                    j = auVar.field_msgId;
                    q = q(rmVar2);
                    a(q, rmVar2);
                    q.yb(5);
                    lzVar2 = new lz();
                    lzVar2.fTf.type = 1;
                    lzVar2.fTf.fKe = rmVar2;
                    lzVar2.fTf.fGM = j;
                    a.urY.m(lzVar2);
                    if (bg.mA(lzVar2.fTg.fTq) && bg.mA(lzVar2.fTg.fKz)) {
                        w.e("MicroMsg.GetFavDataSource", "cloneUrlItem:not record plugin ? get paths error");
                    }
                    q.Oa(lzVar2.fTg.fKz);
                    q.jK(false);
                    if (!(rmVar2.tyc == null || rmVar2.tyc.tyy == null)) {
                        sf sfVar = new sf();
                        sfVar.OQ(rmVar2.tyc.tyy.title);
                        sfVar.OR(rmVar2.tyc.tyy.desc);
                        sfVar.OT(rmVar2.tyc.tyy.thumbUrl);
                        sfVar.yk(rmVar2.tyc.tyy.tzP);
                        sfVar.OS(rmVar2.tyc.tyy.tzN);
                        q.tyc.a(sfVar);
                    }
                    seVar = cbVar.fFA.fFD;
                    seVar.tzC++;
                    rmVar = q;
                    break;
                case 6:
                    q = q(rmVar2);
                    q.yb(6);
                    if (!(rmVar2.tyc == null || rmVar2.tyc.tyw == null)) {
                        rs rsVar = new rs();
                        rsVar.Ou(rmVar2.tyc.tyw.label);
                        rsVar.m(rmVar2.tyc.tyw.lat);
                        rsVar.l(rmVar2.tyc.tyw.lng);
                        rsVar.yf(rmVar2.tyc.tyw.fOd);
                        rsVar.Ov(rmVar2.tyc.tyw.fRX);
                        q.tyc.a(rsVar);
                    }
                    seVar = cbVar.fFA.fFD;
                    seVar.tzD++;
                    rmVar = q;
                    break;
                case 7:
                    j = auVar.field_msgId;
                    q = q(rmVar2);
                    a(q, rmVar2);
                    q.yb(7);
                    lzVar2 = new lz();
                    lzVar2.fTf.type = 1;
                    lzVar2.fTf.fKe = rmVar2;
                    lzVar2.fTf.fGM = j;
                    a.urY.m(lzVar2);
                    if (bg.mA(lzVar2.fTg.fTq) && bg.mA(lzVar2.fTg.fKz)) {
                        w.e("MicroMsg.GetFavDataSource", "cloneMusicItem:not record plugin ? get paths error");
                    }
                    q.Oa(lzVar2.fTg.fKz);
                    q.jK(false);
                    seVar = cbVar.fFA.fFD;
                    seVar.tzE++;
                    rmVar = q;
                    break;
                case 8:
                    j = auVar.field_msgId;
                    q = q(rmVar2);
                    a(q, rmVar2);
                    q.yb(8);
                    lzVar2 = new lz();
                    lzVar2.fTf.type = 1;
                    lzVar2.fTf.fKe = rmVar2;
                    lzVar2.fTf.fGM = j;
                    a.urY.m(lzVar2);
                    if (bg.mA(lzVar2.fTg.fTq) && bg.mA(lzVar2.fTg.fKz)) {
                        w.e("MicroMsg.GetFavDataSource", "cloneFileItem:not record plugin ? get paths error");
                    }
                    q.NZ(lzVar2.fTg.fTq);
                    q.Oa(lzVar2.fTg.fKz);
                    q.jJ(false);
                    q.NV(rmVar2.txx);
                    seVar = cbVar.fFA.fFD;
                    seVar.tzF++;
                    rmVar = q;
                    break;
                case 10:
                    rmVar2 = a(rmVar2, rmVar2.aMw);
                    seVar2 = cbVar.fFA.fFD;
                    seVar2.tzH++;
                    rmVar = rmVar2;
                    break;
                case 11:
                    rmVar2 = a(rmVar2, rmVar2.aMw);
                    seVar2 = cbVar.fFA.fFD;
                    seVar2.tzI++;
                    rmVar = rmVar2;
                    break;
                case 12:
                case 14:
                    q = q(rmVar2);
                    q.yb(14);
                    if (!(rmVar2.tyc == null || rmVar2.tyc.tyC == null)) {
                        rz rzVar = new rz();
                        rzVar.OM(rmVar2.tyc.tyC.title);
                        rzVar.ON(rmVar2.tyc.tyC.desc);
                        rzVar.OP(rmVar2.tyc.tyC.info);
                        rzVar.OO(rmVar2.tyc.tyC.thumbUrl);
                        q.tyc.a(rzVar);
                    }
                    seVar = cbVar.fFA.fFD;
                    seVar.tzL++;
                    rmVar = q;
                    break;
                case 16:
                    q = q(rmVar2);
                    q.yb(16);
                    q.NM(rmVar2.desc);
                    seVar = cbVar.fFA.fFD;
                    seVar.tzM++;
                    rmVar = q;
                    break;
                case 17:
                    q = q(rmVar2);
                    q.NL(rmVar2.title);
                    q.NM(rmVar2.desc);
                    q.yb(17);
                    q.Ol(rmVar2.tys);
                    rmVar = q;
                    break;
                default:
                    rmVar = null;
                    break;
            }
            if (rmVar != null) {
                String format;
                int i3 = i + 1;
                if (auVar.field_isSend != 1) {
                    format = String.format("%d$%d", new Object[]{Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i)});
                } else if (o.dH(auVar.field_talker) || auVar.field_talker.equals("filehelper")) {
                    format = String.format("%d$%d", new Object[]{Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i)});
                } else {
                    format = String.format("%s#%d$%d", new Object[]{auVar.field_talker, Long.valueOf(auVar.field_msgSvrId), Integer.valueOf(i)});
                }
                rmVar.Od(format);
                rvVar.tzn.add(rmVar);
                i2 = i3;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (bg.mA(((rm) cVar.hkm.get(0)).txx) || !((rm) cVar.hkm.get(0)).txx.equals(".htm")) {
            cbVar.fFA.type = 14;
        } else {
            cbVar.fFA.type = 18;
        }
        return true;
    }

    private static rm q(rm rmVar) {
        rm rmVar2 = new rm();
        rn rnVar = new rn();
        ro roVar = new ro();
        ro roVar2 = rmVar.tyc.tyu;
        if (roVar2.tyM) {
            roVar.Om(roVar2.fOu);
        }
        if (roVar2.tyN) {
            roVar.On(roVar2.toUser);
        }
        if (roVar2.tyR) {
            roVar.Op(roVar2.tyQ);
        }
        roVar.ye(1);
        roVar.em(bg.Nz());
        rnVar.c(roVar);
        rmVar2.a(rnVar);
        rmVar2.Og(rmVar.tye);
        rmVar2.Oh(rmVar.tyg);
        rmVar2.jK(true);
        rmVar2.jJ(true);
        rmVar2.Oi(rmVar.tyk);
        rmVar2.yd(rmVar.tyq);
        rmVar2.NW(rmVar.txz);
        rmVar2.NX(rmVar.txB);
        rmVar2.ej(rmVar.txD);
        rmVar2.Ob(rmVar.txK);
        rmVar2.Oc(rmVar.txM);
        rmVar2.ek(rmVar.txO);
        return rmVar2;
    }

    private static void a(rm rmVar, rm rmVar2) {
        rmVar.NS(rmVar2.txr);
        rmVar.NT(rmVar2.txt);
        rmVar.NR(rmVar2.txp);
        rmVar.NL(rmVar2.title);
        rmVar.NM(rmVar2.desc);
    }

    private static rm a(rm rmVar, int i) {
        rm q = q(rmVar);
        q.yb(i);
        if (!(rmVar.tyc == null || rmVar.tyc.tyA == null)) {
            ru ruVar = new ru();
            ruVar.Ow(rmVar.tyc.tyA.title);
            ruVar.Ox(rmVar.tyc.tyA.desc);
            ruVar.yg(rmVar.tyc.tyA.type);
            ruVar.Oz(rmVar.tyc.tyA.info);
            ruVar.Oy(rmVar.tyc.tyA.thumbUrl);
            q.tyc.a(ruVar);
        }
        return q;
    }
}
