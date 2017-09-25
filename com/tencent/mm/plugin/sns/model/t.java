package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.mm.e.a.pc;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.c;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ak;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class t extends k implements j {
    public static List<ak> pUq = new LinkedList();
    private static c pUs;
    private static boolean pUt = true;
    public String gKJ = "";
    b gUA;
    e gUD;
    private a pUr = new a(this);

    class a {
        LinkedList<lu> lFB;
        ae lFC = new ae(this) {
            final /* synthetic */ a pUz;

            {
                this.pUz = r1;
            }

            public final void handleMessage(Message message) {
                if (this.pUz.lFB == null || this.pUz.lFB.isEmpty()) {
                    k kVar = this.pUz.pUw;
                    bcd com_tencent_mm_protocal_c_bcd = (bcd) kVar.gUA.hsk.hsr;
                    bcc com_tencent_mm_protocal_c_bcc = (bcc) kVar.gUA.hsj.hsr;
                    byte[] g = ad.g(com_tencent_mm_protocal_c_bcc.tob.tZp.toByteArray(), com_tencent_mm_protocal_c_bcd.tob.tZp.toByteArray());
                    if (g != null && g.length > 0) {
                        h.vJ();
                        h.vI().vr().set(8195, bg.bo(g));
                    }
                    com_tencent_mm_protocal_c_bcc.tob.bb(g);
                    if ((com_tencent_mm_protocal_c_bcd.tlZ & com_tencent_mm_protocal_c_bcc.toa) == 0) {
                        kVar.gUD.a(0, 0, "", kVar);
                        return;
                    } else {
                        kVar.a(kVar.hsD, kVar.gUD);
                        return;
                    }
                }
                final lu luVar = (lu) this.pUz.lFB.getFirst();
                w.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + luVar.tsa);
                this.pUz.lFB.removeFirst();
                switch (luVar.tsa) {
                    case 45:
                        ae.bev().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 pUB;

                            public final void run() {
                                if (!this.pUB.pUz.pUw.a(luVar, this.pUB.pUz.lFC)) {
                                    this.pUB.pUz.lFC.sendEmptyMessage(0);
                                }
                            }
                        });
                        return;
                    case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                        ae.bev().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 pUB;

                            public final void run() {
                                if (!this.pUB.pUz.pUw.b(luVar, this.pUB.pUz.lFC)) {
                                    this.pUB.pUz.lFC.sendEmptyMessage(0);
                                }
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        };
        final /* synthetic */ t pUw;

        a(t tVar) {
            this.pUw = tVar;
        }
    }

    public t() {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bcc();
        aVar.hsn = new bcd();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        aVar.hsl = JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
        aVar.hso = 102;
        aVar.hsp = 1000000102;
        this.gUA = aVar.BE();
        ((bcc) this.gUA.hsj.hsr).toa = 256;
        this.gKJ = m.xL();
        if (pUt) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            String stringBuilder2 = stringBuilder.append(h.vI().cachePath).append("ad_1100007").toString();
            w.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  " + stringBuilder2);
            byte[] c = FileOp.c(stringBuilder2, 0, -1);
            if (c != null) {
                try {
                    pUs = (c) new c().aD(c);
                    w.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (pUs == null) {
                        w.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        w.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + pUs.qaF.size());
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
            pUt = false;
        }
    }

    protected final int ub() {
        return 10;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        h.vJ();
        byte[] PT = bg.PT(bg.mz((String) h.vI().vr().get(8195, null)));
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(PT);
        ((bcc) this.gUA.hsj.hsr).tob = com_tencent_mm_protocal_c_avw;
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public static void dm(long j) {
        if (pUs == null) {
            pUs = new c();
        }
        pUs.qaF.add(Long.valueOf(j));
    }

    public static void dn(long j) {
        if (pUs != null) {
            pUs.qaF.remove(Long.valueOf(j));
        }
    }

    public static boolean do(long j) {
        if (pUs != null && pUs.qaF.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public static void bef() {
        if (pUs != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            String stringBuilder2 = stringBuilder.append(h.vI().cachePath).append("ad_1100007").toString();
            w.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = pUs.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                w.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + pUs.qaF.size());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public final boolean BI() {
        return true;
    }

    public final int getType() {
        return JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bcd com_tencent_mm_protocal_c_bcd = (bcd) ((b) pVar).hsk.hsr;
            LinkedList linkedList = com_tencent_mm_protocal_c_bcd.toe.jNe;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(com_tencent_mm_protocal_c_bcd.tob == null || com_tencent_mm_protocal_c_bcd.tob.tZp == null)) {
                    byte[] g = ad.g(((bcc) ((b) pVar).hsj.hsr).tob.tZp.toByteArray(), com_tencent_mm_protocal_c_bcd.tob.tZp.toByteArray());
                    if (g != null && g.length > 0) {
                        h.vJ();
                        h.vI().vr().set(8195, bg.bo(g));
                    }
                }
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            a aVar = this.pUr;
            aVar.lFB = linkedList;
            aVar.lFC.sendEmptyMessage(0);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final boolean a(lu luVar, final ae aeVar) {
        try {
            final bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(luVar.tsb.tZp.toByteArray());
            String str = new String(com_tencent_mm_protocal_c_bbk.ucj.tZp.toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            w.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + com_tencent_mm_protocal_c_bbk.tmx + " " + i.df(com_tencent_mm_protocal_c_bbk.tmx) + " isPhoto " + z);
            if (z) {
                String df = i.df(com_tencent_mm_protocal_c_bbk.tmx);
                com.tencent.mm.plugin.sns.storage.k Gk = ae.beO().Gk(com_tencent_mm_protocal_c_bbk.tgG);
                if (bg.mA(Gk.field_newerIds)) {
                    ae.beO().dD(com_tencent_mm_protocal_c_bbk.tgG, df);
                } else {
                    String[] split = Gk.field_newerIds.split(",");
                    z = true;
                    for (Object equals : split) {
                        if (df.equals(equals)) {
                            z = false;
                        }
                    }
                    int i = 0;
                    String str2 = df;
                    while (i < 2 && i < split.length && z) {
                        str2 = str2 + "," + split[i];
                        i++;
                    }
                    w.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + com_tencent_mm_protocal_c_bbk.tmx + " S: " + df + " list " + Gk.field_newerIds + " newer " + str2);
                    if (z) {
                        ae.beO().dD(com_tencent_mm_protocal_c_bbk.tgG, str2);
                    }
                }
            }
            if (ae.beL().dA(com_tencent_mm_protocal_c_bbk.tmx)) {
                w.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                return false;
            }
            com.tencent.mm.sdk.b.a.urY.m(new pc());
            ae.ayz().post(new Runnable(this) {
                final /* synthetic */ t pUw;

                public final void run() {
                    if (!com_tencent_mm_protocal_c_bbk.tgG.equals(this.pUw.gKJ)) {
                        h.vJ();
                        if (h.vG().uV()) {
                            h.vJ();
                            String str = (String) h.vI().vr().get(68377, null);
                            h.vJ();
                            if (!(bg.a((Integer) h.vI().vr().get(68400, null), 0) == com_tencent_mm_protocal_c_bbk.ogM && (bg.mA(str) || str.equals(com_tencent_mm_protocal_c_bbk.tgG)))) {
                                h.vJ();
                                h.vI().vr().set(68377, com_tencent_mm_protocal_c_bbk.tgG);
                                h.vJ();
                                h.vI().vr().set(68400, Integer.valueOf(com_tencent_mm_protocal_c_bbk.ogM));
                                h.vJ();
                                h.vI().vr().set(68418, i.df(com_tencent_mm_protocal_c_bbk.tmx));
                            }
                            for (ak yM : t.pUq) {
                                yM.yM();
                            }
                        } else {
                            w.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
                            return;
                        }
                    }
                    aeVar.sendEmptyMessage(0);
                }
            });
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean b(lu luVar, final ae aeVar) {
        try {
            boolean z;
            bav com_tencent_mm_protocal_c_bav = (bav) new bav().aD(luVar.tsb.tZp.toByteArray());
            long j = com_tencent_mm_protocal_c_bav.tmx;
            long j2 = com_tencent_mm_protocal_c_bav.ubQ;
            final bau com_tencent_mm_protocal_c_bau = com_tencent_mm_protocal_c_bav.ubR;
            String str = com_tencent_mm_protocal_c_bav.teW;
            if (str == null) {
                str = "";
            }
            w.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + com_tencent_mm_protocal_c_bau.jOc + " " + j + " " + str);
            com.tencent.mm.sdk.e.c d;
            boolean a;
            com.tencent.mm.plugin.sns.storage.j beP;
            String str2;
            switch (com_tencent_mm_protocal_c_bau.jOc) {
                case 9:
                    d = ae.beP().d(j, (long) com_tencent_mm_protocal_c_bau.ubK, com_tencent_mm_protocal_c_bau.jOc);
                    if (d != null) {
                        d.bhh();
                        a = ae.beP().a(d.uxb, d);
                        ai.b(j, com_tencent_mm_protocal_c_bav);
                        w.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  " + a);
                        break;
                    }
                    break;
                case 10:
                    d = ae.beP().d(j, com_tencent_mm_protocal_c_bau.ubN, com_tencent_mm_protocal_c_bau.jOc);
                    if (d != null) {
                        d.bhh();
                        a = ae.beP().a(d.uxb, d);
                        ai.b(j, com_tencent_mm_protocal_c_bav);
                        w.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  " + a);
                        break;
                    }
                    break;
                case 11:
                    beP = ae.beP();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j;
                    w.i("MicroMsg.SnsCommentStorage", "set sns del " + str2);
                    w.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + beP.hnH.eE("SnsComment", str2));
                    break;
                case 12:
                    beP = ae.beP();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j + " and talker = " + bg.my(com_tencent_mm_protocal_c_bau.tWt);
                    w.i("MicroMsg.SnsCommentStorage", "set sns del  by username " + str2);
                    w.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + beP.hnH.eE("SnsComment", str2));
                    break;
                case 13:
                    b(com_tencent_mm_protocal_c_bav, com_tencent_mm_protocal_c_bau, j, j2, str);
                    break;
                case 14:
                    c(com_tencent_mm_protocal_c_bav, com_tencent_mm_protocal_c_bau, j, j2, str);
                    break;
                default:
                    a(com_tencent_mm_protocal_c_bav, com_tencent_mm_protocal_c_bau, j, j2, str);
                    break;
            }
            if ((com_tencent_mm_protocal_c_bau.ubP & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            ae.ayz().post(new Runnable(this) {
                final /* synthetic */ t pUw;

                public final void run() {
                    if (z) {
                        for (ak akVar : t.pUq) {
                            w.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
                            akVar.yL();
                        }
                    }
                    aeVar.sendEmptyMessage(0);
                }
            });
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean dp(long j) {
        try {
            return a.a(j, null, bg.getInt(g.sV().getValue("SnsAdNotifyLimit"), 0), bg.getInt(g.sV().getValue("SnsAdNotifyLikeTimeLimit"), 0), bg.getInt(g.sV().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return true;
        }
    }

    private static boolean a(bav com_tencent_mm_protocal_c_bav, bau com_tencent_mm_protocal_c_bau, long j, long j2, String str) {
        try {
            boolean a;
            int i = bg.getInt(g.sV().getValue("SnsAdNotifyLimit"), 0);
            int i2 = bg.getInt(g.sV().getValue("SnsAdNotifyLikeTimeLimit"), 0);
            int i3 = bg.getInt(g.sV().getValue("SnsAdNotifyCommentTimeLimit"), 0);
            if ((i > 0 || i2 > 0 || i3 > 0) && (com_tencent_mm_protocal_c_bau.jOc == 8 || com_tencent_mm_protocal_c_bau.jOc == 7)) {
                a = a.a(j, com_tencent_mm_protocal_c_bav, i, i2, i3, true);
                if (do(j)) {
                    w.i("MicroMsg.NetSceneNewSyncAlbum", "user open notify off");
                }
                if (!a) {
                    w.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bau.ubN + " " + com_tencent_mm_protocal_c_bau.ubK + " actionLimit:" + i + " actionLikeTimeLimit:" + i2 + " actionCommentTimeLimit:" + i3);
                    if (a.a(j, com_tencent_mm_protocal_c_bav)) {
                        return false;
                    }
                    w.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID  " + com_tencent_mm_protocal_c_bav.ubR.ubN);
                    return false;
                }
            }
            w.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bau.ubN + " " + com_tencent_mm_protocal_c_bau.ubK + " actionLimit: " + i);
            if (ae.beP().a(j, com_tencent_mm_protocal_c_bau.tWt, com_tencent_mm_protocal_c_bau.ogM, str)) {
                return false;
            }
            bau com_tencent_mm_protocal_c_bau2 = com_tencent_mm_protocal_c_bav.ubS;
            com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
            iVar.field_snsID = j;
            iVar.field_parentID = j2;
            iVar.field_createTime = com_tencent_mm_protocal_c_bau.ogM;
            iVar.field_talker = com_tencent_mm_protocal_c_bau.tWt;
            iVar.field_type = com_tencent_mm_protocal_c_bau.jOc;
            iVar.field_curActionBuf = com_tencent_mm_protocal_c_bau.toByteArray();
            iVar.field_refActionBuf = com_tencent_mm_protocal_c_bau2.toByteArray();
            iVar.field_clientId = str;
            iVar.field_isSilence = (com_tencent_mm_protocal_c_bau.ubP & 2) == 0 ? 0 : 1;
            if (com_tencent_mm_protocal_c_bau.jOc == 8 || com_tencent_mm_protocal_c_bau.jOc == 7) {
                iVar.field_commentSvrID = com_tencent_mm_protocal_c_bau.ubN;
                if (!a.a(j, com_tencent_mm_protocal_c_bav)) {
                    w.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + iVar.field_snsID + " " + iVar.field_commentSvrID);
                    return false;
                }
            }
            iVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_bau.ubK;
            if (!ai.a(j, com_tencent_mm_protocal_c_bav)) {
                return false;
            }
            ae.beP().b(iVar);
            com.tencent.mm.plugin.sns.storage.j beP = ae.beP();
            if ((com_tencent_mm_protocal_c_bau.ubP & 2) != 0) {
                a = true;
            } else {
                a = false;
            }
            beP.m(j, a);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean b(bav com_tencent_mm_protocal_c_bav, bau com_tencent_mm_protocal_c_bau, long j, long j2, String str) {
        try {
            w.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bau.ubN + " " + com_tencent_mm_protocal_c_bau.ubK);
            if (com.tencent.mm.plugin.sns.lucky.a.g.bdF()) {
                if (ae.beP().a(j, com_tencent_mm_protocal_c_bau.tWt, com_tencent_mm_protocal_c_bau.ogM, str)) {
                    return false;
                }
                bau com_tencent_mm_protocal_c_bau2 = com_tencent_mm_protocal_c_bav.ubS;
                com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
                iVar.field_snsID = j;
                iVar.field_parentID = j2;
                iVar.field_createTime = com_tencent_mm_protocal_c_bau.ogM;
                iVar.field_talker = com_tencent_mm_protocal_c_bau.tWt;
                iVar.field_type = com_tencent_mm_protocal_c_bau.jOc;
                iVar.field_curActionBuf = com_tencent_mm_protocal_c_bau.toByteArray();
                iVar.field_refActionBuf = com_tencent_mm_protocal_c_bau2.toByteArray();
                iVar.field_clientId = str;
                iVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_bau.ubK;
                w.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
                ai.c(j, com_tencent_mm_protocal_c_bav);
                yN();
                ae.beP().b(iVar);
                return true;
            }
            w.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
            return false;
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean c(bav com_tencent_mm_protocal_c_bav, bau com_tencent_mm_protocal_c_bau, long j, long j2, String str) {
        try {
            w.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j + " " + com_tencent_mm_protocal_c_bau.ubN + " " + com_tencent_mm_protocal_c_bau.ubK);
            if (ae.beP().a(j, com_tencent_mm_protocal_c_bau.tWt, com_tencent_mm_protocal_c_bau.ogM, str)) {
                return false;
            }
            bau com_tencent_mm_protocal_c_bau2 = com_tencent_mm_protocal_c_bav.ubS;
            com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
            iVar.field_snsID = j;
            iVar.field_parentID = j2;
            iVar.field_createTime = com_tencent_mm_protocal_c_bau.ogM;
            iVar.field_talker = com_tencent_mm_protocal_c_bau.tWt;
            iVar.field_type = com_tencent_mm_protocal_c_bau.jOc;
            iVar.field_curActionBuf = com_tencent_mm_protocal_c_bau.toByteArray();
            iVar.field_refActionBuf = com_tencent_mm_protocal_c_bau2.toByteArray();
            iVar.field_clientId = str;
            iVar.field_commentSvrID = (long) com_tencent_mm_protocal_c_bau.ubK;
            aex com_tencent_mm_protocal_c_aex = new aex();
            w.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + com_tencent_mm_protocal_c_bau.ubO);
            com_tencent_mm_protocal_c_aex.aD(n.a(com_tencent_mm_protocal_c_bau.ubO));
            w.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + com_tencent_mm_protocal_c_aex.fZT);
            ae.beP().b(iVar);
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static void beg() {
        for (ak akVar : pUq) {
            if (akVar != null) {
                akVar.yO();
            }
        }
    }

    private static void yN() {
        for (ak akVar : pUq) {
            if (akVar != null) {
                akVar.yN();
            }
        }
    }

    public static void a(ak akVar) {
        if (!pUq.contains(akVar)) {
            pUq.add(akVar);
        }
    }

    public static void b(ak akVar) {
        pUq.remove(akVar);
    }
}
