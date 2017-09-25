package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.qb;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.o;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    public HashMap<Long, String> kLC = new HashMap();
    private boolean kLD = false;
    List<b> kLE = new LinkedList();
    private qb kLF;
    public a kLG;
    public List kLH = Collections.synchronizedList(new ArrayList());
    private com.tencent.mm.ah.a.c.c kLz = new com.tencent.mm.ah.a.c.c(this) {
        final /* synthetic */ c kLI;

        {
            this.kLI = r1;
        }

        public final void a(boolean z, Object... objArr) {
            al alVar;
            com.tencent.mm.storage.a.c cVar;
            Throwable e;
            File file;
            String f;
            String str;
            Object[] objArr2;
            if (objArr == null || objArr.length < 4) {
                w.w("MicroMsg.emoji.EmojiService", "extra obj error");
                return;
            }
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            if (objArr[0] instanceof al) {
                alVar = (al) objArr[0];
            } else {
                alVar = null;
            }
            if (objArr[1] instanceof com.tencent.mm.storage.a.c) {
                cVar = (com.tencent.mm.storage.a.c) objArr[1];
            } else {
                cVar = null;
            }
            if (objArr[3] instanceof Long) {
                ((Long) objArr[3]).longValue();
            }
            if (alVar == null || cVar == null) {
                w.w("MicroMsg.emoji.EmojiService", "msginfo or  emojiInfo");
                return;
            }
            this.kLI.kLH.remove(alVar.fFW);
            if (cVar.field_state == com.tencent.mm.storage.a.c.uLi) {
                w.d("MicroMsg.emoji.EmojiService", "first receive emoji,then update.");
                cVar.field_state = com.tencent.mm.storage.a.c.uLg;
                ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(cVar);
            }
            if (z) {
                String eN = cVar.eN(cVar.field_groupId, cVar.EP());
                if (booleanValue) {
                    String str2 = eN + "_encrypt";
                    if (com.tencent.mm.a.e.aN(str2) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean g;
                        String str3;
                        Object[] objArr3;
                        try {
                            g = com.tencent.mm.a.a.g(Base64.encodeToString(bg.PT(alVar.aeskey), 0), str2, eN);
                            if (g) {
                                try {
                                    com.tencent.mm.plugin.emoji.c.bi(7);
                                } catch (Exception e2) {
                                    e = e2;
                                    w.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[]{bg.g(e)});
                                    com.tencent.mm.plugin.emoji.c.bi(8);
                                    w.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), eN});
                                    if (g) {
                                        str3 = "MicroMsg.emoji.EmojiService";
                                        eN = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                        objArr3 = new Object[6];
                                        objArr3[0] = cVar != null ? "" : cVar.EP();
                                        objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str2));
                                        objArr3[2] = g.aV(str2) != null ? "" : g.aV(str2);
                                        objArr3[3] = cVar != null ? "" : cVar.field_aeskey;
                                        objArr3[4] = cVar != null ? "" : cVar.field_encrypturl;
                                        objArr3[5] = alVar != null ? "" : alVar.uJA;
                                        w.i(str3, eN, objArr3);
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 1, alVar.fGa, 1, alVar.uJB);
                                        com.tencent.mm.loader.stub.b.deleteFile(str2);
                                        c.alR();
                                        return;
                                    }
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                    file = new File(eN);
                                    if (com.tencent.mm.a.e.aN(eN) > 0) {
                                        c.a(alVar, cVar, booleanValue);
                                        return;
                                    }
                                    f = g.f(file);
                                    if (!bg.mA(f)) {
                                    }
                                    eN = "MicroMsg.emoji.EmojiService";
                                    str = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                                    objArr2 = new Object[3];
                                    objArr2[0] = f;
                                    objArr2[1] = cVar == null ? cVar.EP() : "";
                                    objArr2[2] = cVar == null ? cVar.field_cdnUrl : "";
                                    w.i(eN, str, objArr2);
                                    file.delete();
                                    c.alR();
                                    if (booleanValue) {
                                        com.tencent.mm.plugin.emoji.c.bi(5);
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 2, 0, 1, alVar.fGa, 1, alVar.uJB);
                                        return;
                                    }
                                    com.tencent.mm.plugin.emoji.c.bi(5);
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 1, alVar.fGa, 1, alVar.uJB);
                                    return;
                                }
                                w.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), eN});
                                if (g) {
                                    str3 = "MicroMsg.emoji.EmojiService";
                                    eN = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    if (cVar != null) {
                                    }
                                    objArr3[0] = cVar != null ? "" : cVar.EP();
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str2));
                                    if (g.aV(str2) != null) {
                                    }
                                    objArr3[2] = g.aV(str2) != null ? "" : g.aV(str2);
                                    if (cVar != null) {
                                    }
                                    objArr3[3] = cVar != null ? "" : cVar.field_aeskey;
                                    if (cVar != null) {
                                    }
                                    objArr3[4] = cVar != null ? "" : cVar.field_encrypturl;
                                    if (alVar != null) {
                                    }
                                    objArr3[5] = alVar != null ? "" : alVar.uJA;
                                    w.i(str3, eN, objArr3);
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 1, alVar.fGa, 1, alVar.uJB);
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                    c.alR();
                                    return;
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(str2);
                            } else {
                                com.tencent.mm.plugin.emoji.c.bi(8);
                                w.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), eN});
                                if (g) {
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiService";
                                    eN = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                                    objArr3 = new Object[6];
                                    if (cVar != null) {
                                    }
                                    objArr3[0] = cVar != null ? "" : cVar.EP();
                                    objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str2));
                                    if (g.aV(str2) != null) {
                                    }
                                    objArr3[2] = g.aV(str2) != null ? "" : g.aV(str2);
                                    if (cVar != null) {
                                    }
                                    objArr3[3] = cVar != null ? "" : cVar.field_aeskey;
                                    if (cVar != null) {
                                    }
                                    objArr3[4] = cVar != null ? "" : cVar.field_encrypturl;
                                    if (alVar != null) {
                                    }
                                    objArr3[5] = alVar != null ? "" : alVar.uJA;
                                    w.i(str3, eN, objArr3);
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 1, alVar.fGa, 1, alVar.uJB);
                                    com.tencent.mm.loader.stub.b.deleteFile(str2);
                                    c.alR();
                                    return;
                                }
                            }
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            g = false;
                            e = th;
                            w.e("MicroMsg.emoji.EmojiService", "encrypt file failed. exception:%s", new Object[]{bg.g(e)});
                            com.tencent.mm.plugin.emoji.c.bi(8);
                            w.i("MicroMsg.emoji.EmojiService", "encrypt file use time:%d %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), eN});
                            if (g) {
                                com.tencent.mm.loader.stub.b.deleteFile(str2);
                                file = new File(eN);
                                if (com.tencent.mm.a.e.aN(eN) > 0) {
                                    f = g.f(file);
                                    if (bg.mA(f)) {
                                    }
                                    eN = "MicroMsg.emoji.EmojiService";
                                    str = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                                    objArr2 = new Object[3];
                                    objArr2[0] = f;
                                    if (cVar == null) {
                                    }
                                    objArr2[1] = cVar == null ? cVar.EP() : "";
                                    if (cVar == null) {
                                    }
                                    objArr2[2] = cVar == null ? cVar.field_cdnUrl : "";
                                    w.i(eN, str, objArr2);
                                    file.delete();
                                    c.alR();
                                    if (booleanValue) {
                                        com.tencent.mm.plugin.emoji.c.bi(5);
                                        com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 1, alVar.fGa, 1, alVar.uJB);
                                        return;
                                    }
                                    com.tencent.mm.plugin.emoji.c.bi(5);
                                    com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 2, 0, 1, alVar.fGa, 1, alVar.uJB);
                                    return;
                                }
                                c.a(alVar, cVar, booleanValue);
                                return;
                            }
                            str3 = "MicroMsg.emoji.EmojiService";
                            eN = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s srcContent:%s";
                            objArr3 = new Object[6];
                            if (cVar != null) {
                            }
                            objArr3[0] = cVar != null ? "" : cVar.EP();
                            objArr3[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str2));
                            if (g.aV(str2) != null) {
                            }
                            objArr3[2] = g.aV(str2) != null ? "" : g.aV(str2);
                            if (cVar != null) {
                            }
                            objArr3[3] = cVar != null ? "" : cVar.field_aeskey;
                            if (cVar != null) {
                            }
                            objArr3[4] = cVar != null ? "" : cVar.field_encrypturl;
                            if (alVar != null) {
                            }
                            objArr3[5] = alVar != null ? "" : alVar.uJA;
                            w.i(str3, eN, objArr3);
                            com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 1, alVar.fGa, 1, alVar.uJB);
                            com.tencent.mm.loader.stub.b.deleteFile(str2);
                            c.alR();
                            return;
                        }
                    }
                    w.i("MicroMsg.emoji.EmojiService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{cVar.EP()});
                    com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 1, 1, alVar.fGa, 1, alVar.uJB);
                    c.alR();
                    return;
                }
                file = new File(eN);
                if (com.tencent.mm.a.e.aN(eN) > 0) {
                    f = g.f(file);
                    if (bg.mA(f) || !f.equalsIgnoreCase(cVar.EP())) {
                        eN = "MicroMsg.emoji.EmojiService";
                        str = "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s";
                        objArr2 = new Object[3];
                        objArr2[0] = f;
                        if (cVar == null) {
                        }
                        objArr2[1] = cVar == null ? cVar.EP() : "";
                        if (cVar == null) {
                        }
                        objArr2[2] = cVar == null ? cVar.field_cdnUrl : "";
                        w.i(eN, str, objArr2);
                        file.delete();
                        c.alR();
                        if (booleanValue) {
                            com.tencent.mm.plugin.emoji.c.bi(5);
                            com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 1, alVar.fGa, 1, alVar.uJB);
                            return;
                        }
                        com.tencent.mm.plugin.emoji.c.bi(5);
                        com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 2, 0, 1, alVar.fGa, 1, alVar.uJB);
                        return;
                    }
                    if (booleanValue) {
                        com.tencent.mm.plugin.emoji.c.bi(4);
                        com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 0, 0, alVar.fGa, 0, alVar.uJB);
                    } else {
                        com.tencent.mm.plugin.emoji.c.bi(4);
                        com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 2, 0, 0, alVar.fGa, 1, alVar.uJB);
                    }
                    com.tencent.mm.plugin.emoji.e.e.alz().c(cVar, true);
                    if (this.kLI.kLG != null) {
                        this.kLI.kLG.i(cVar);
                    }
                    c.alR();
                    return;
                }
                c.a(alVar, cVar, booleanValue);
                return;
            }
            c.a(alVar, cVar, booleanValue);
        }
    };

    public interface a {
        void i(com.tencent.mm.storage.a.c cVar);
    }

    private class b {
        com.tencent.mm.storage.a.c fEk;
        long fGM;
        String fJz;
        final /* synthetic */ c kLI;
        String toUserName;

        public b(c cVar, long j, String str, com.tencent.mm.storage.a.c cVar2, String str2) {
            this.kLI = cVar;
            this.fGM = j;
            this.toUserName = str;
            this.fEk = cVar2;
            this.fJz = str2;
        }
    }

    public c() {
        ap.vd().a(aa.CTRL_BYTE, this);
    }

    public final void a(String str, com.tencent.mm.storage.a.c cVar, au auVar) {
        if (!bg.mA(str) && cVar != null) {
            long j;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            if (cVar == null || bg.mA(cVar.field_groupId)) {
                h.amd().alK();
            } else {
                boolean z2;
                j amd = h.amd();
                String str2 = cVar.field_groupId;
                if (bg.mA(str2)) {
                    w.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
                    z2 = false;
                } else if (amd.kKE || m.xU()) {
                    o oVar;
                    if (amd.kKI == null || !amd.kKI.containsKey(str2)) {
                        oVar = new o();
                        oVar.field_prodcutID = str2;
                    } else {
                        oVar = (o) amd.kKI.get(str2);
                    }
                    if (System.currentTimeMillis() - oVar.field_showTipsTime < amd.kKF) {
                        w.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                        amd.alK();
                        z2 = false;
                    } else {
                        String str3;
                        String str4;
                        Object[] objArr;
                        String str5;
                        Object[] objArr2;
                        int i;
                        String str6;
                        int i2;
                        Object[] objArr3;
                        if (oVar == null || System.currentTimeMillis() - oVar.field_setFlagTime <= 86400000) {
                            str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str4 = "no need to get reward today. continu count:%d total count:%d";
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(amd.kKH == null ? 0 : amd.kKH.field_continuCount);
                            objArr[1] = Integer.valueOf(amd.kKH == null ? 0 : amd.kKH.field_totalCount);
                            w.d(str3, str4, objArr);
                        } else if (amd.kKH != null && str2.equalsIgnoreCase(amd.kKH.field_prodcutID) && amd.kKH.field_continuCount >= amd.kKG - 1 && amd.kKH.field_continuCount <= (amd.kKG + 5) - 1) {
                            ap.vd().a(new com.tencent.mm.plugin.emoji.f.o(str2, com.tencent.mm.plugin.emoji.f.o.kNq), 0);
                        } else if (oVar != null && oVar.field_totalCount >= amd.jZR - 1 && oVar.field_totalCount <= (amd.jZR + 5) - 1) {
                            ap.vd().a(new com.tencent.mm.plugin.emoji.f.o(str2, com.tencent.mm.plugin.emoji.f.o.kNq), 0);
                        }
                        if (amd.kKH == null || !str2.equalsIgnoreCase(amd.kKH.field_prodcutID) || amd.kKH.field_continuCount < amd.kKG) {
                            if (oVar != null && oVar.field_totalCount >= amd.jZR) {
                                if ((oVar.field_flag & com.tencent.mm.plugin.emoji.f.o.kNr) != com.tencent.mm.plugin.emoji.f.o.kNr || (oVar.field_flag & com.tencent.mm.plugin.emoji.f.o.kNs) == com.tencent.mm.plugin.emoji.f.o.kNs) {
                                    str5 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
                                    objArr2 = new Object[4];
                                    objArr2[0] = Boolean.valueOf(false);
                                    objArr2[1] = str2;
                                    objArr2[2] = Integer.valueOf(amd.kKH == null ? 0 : amd.kKH.field_totalCount);
                                    i = 3;
                                    if (amd.kKH == null) {
                                        str6 = str5;
                                        objArr = objArr2;
                                        Object[] objArr4 = objArr2;
                                        i2 = 3;
                                        i = 0;
                                        str2 = str4;
                                        objArr3 = objArr4;
                                        objArr3[i2] = Integer.valueOf(i);
                                        w.i(str6, str2, objArr);
                                    } else {
                                        str2 = str5;
                                        str5 = str4;
                                        objArr3 = objArr2;
                                    }
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d";
                                    objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(true);
                                    objArr[1] = str2;
                                    objArr[2] = Integer.valueOf(amd.kKH == null ? 0 : amd.kKH.field_totalCount);
                                    w.i(str3, str4, objArr);
                                    amd.a(oVar, true);
                                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                    objArr3 = new Object[2];
                                    objArr3[0] = Integer.valueOf(0);
                                    objArr3[1] = amd.kKH == null ? "" : amd.kKH.field_prodcutID;
                                    gVar.i(12953, objArr3);
                                    z2 = true;
                                }
                            }
                            amd.a(oVar, false);
                            z2 = false;
                        } else if ((amd.kKH.field_flag & com.tencent.mm.plugin.emoji.f.o.kNr) != com.tencent.mm.plugin.emoji.f.o.kNr || (amd.kKH.field_flag & com.tencent.mm.plugin.emoji.f.o.kNs) == com.tencent.mm.plugin.emoji.f.o.kNs) {
                            objArr2 = new Object[4];
                            objArr2[0] = Boolean.valueOf(false);
                            objArr2[1] = str2;
                            objArr2[2] = Integer.valueOf(amd.kKH.field_continuCount);
                            i = 3;
                            str2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str5 = "isNeedShowTip:%b productid:%s  continue count:%d flag:%d";
                            objArr3 = objArr2;
                        } else {
                            w.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[]{Boolean.valueOf(true), str2, Integer.valueOf(amd.kKH.field_continuCount)});
                            amd.a(oVar, true);
                            com.tencent.mm.plugin.report.service.g.oUh.i(12953, new Object[]{Integer.valueOf(0), amd.kKH.field_prodcutID});
                            z2 = true;
                        }
                        str6 = str2;
                        str2 = str5;
                        objArr = objArr3;
                        objArr3 = objArr2;
                        i2 = i;
                        i = amd.kKH.field_flag;
                        objArr3[i2] = Integer.valueOf(i);
                        w.i(str6, str2, objArr);
                        amd.a(oVar, false);
                        z2 = false;
                    }
                } else {
                    w.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[]{Boolean.valueOf(amd.kKE), Boolean.valueOf(m.xU())});
                    z2 = false;
                }
                w.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[]{Boolean.valueOf(z2)});
                z = z2;
            }
            if (auVar == null) {
                ce auVar2 = new au();
                if (cVar.field_type == com.tencent.mm.storage.a.c.uLc || cVar.field_type == com.tencent.mm.storage.a.c.uLd) {
                    auVar2.setType(1048625);
                } else {
                    auVar2.setType(47);
                }
                auVar2.cH(str);
                auVar2.dw(1);
                String xL = m.xL();
                boolean z3 = (cVar.bCU() || cVar.isGif()) ? false : true;
                auVar2.setContent(aj.a(xL, currentTimeMillis, z3, cVar.EP(), z, ""));
                auVar2.cI(cVar.EP());
                auVar2.z(ay.gk(auVar2.field_talker));
                ap.yY();
                j = currentTimeMillis;
                currentTimeMillis = com.tencent.mm.u.c.wT().L(auVar2);
            } else {
                long j2 = auVar.field_msgId;
                aj RD = aj.RD(auVar.field_content);
                if (RD.time != 0) {
                    j = RD.time;
                    currentTimeMillis = j2;
                } else {
                    return;
                }
            }
            w.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = " + currentTimeMillis);
            this.kLE.add(new b(this, currentTimeMillis, str, cVar, String.valueOf(j)));
            if (!this.kLD || this.kLE.size() == 1) {
                this.kLD = true;
                ap.vd().a(new r(String.valueOf(j), str, cVar, currentTimeMillis), 0);
            }
            String str7 = cVar.field_md5;
            uv(cVar.field_groupId);
        }
    }

    public final void uv(final String str) {
        af.v(new Runnable(this) {
            final /* synthetic */ c kLI;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r12 = this;
                r0 = 1;
                r1 = 0;
                r2 = com.tencent.mm.plugin.emoji.model.h.amc();
                r2 = r2.kLc;
                r3 = r2;
                r4 = android.text.TextUtils.isEmpty(r3);
                if (r4 != 0) goto L_0x0070;
            L_0x0010:
                r4 = new java.lang.StringBuilder;
                r4.<init>();
                r5 = com.tencent.mm.storage.a.a.uKQ;
                r4 = r4.append(r5);
                r4 = r4.toString();
                r4 = r3.equals(r4);
                if (r4 != 0) goto L_0x0070;
            L_0x0025:
                r4 = r2.uLo;
                r5 = new java.lang.StringBuilder;
                r6 = "274544";
                r5.<init>(r6);
                r5 = r5.append(r3);
                r5 = r5.toString();
                r6 = 0;
                r4 = r4.getLong(r5, r6);
                r6 = java.lang.System.currentTimeMillis();
                r8 = r6 - r4;
                r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
                r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
                if (r8 < 0) goto L_0x0061;
            L_0x004a:
                if (r0 == 0) goto L_0x0060;
            L_0x004c:
                com.tencent.mm.plugin.emoji.model.h.alY();
                r0 = r2;
                r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                if (r2 == 0) goto L_0x0072;
            L_0x0057:
                r0 = "MicroMsg.emoji.EmojiMgrImpl";
                r1 = "doSceneGetEmotionDesc get emotion desc faild.";
                com.tencent.mm.sdk.platformtools.w.w(r0, r1);
            L_0x0060:
                return;
            L_0x0061:
                r2 = r2.Sh(r3);
                if (r2 != 0) goto L_0x0070;
            L_0x0067:
                r2 = r6 - r4;
                r4 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
                r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                if (r2 >= 0) goto L_0x004a;
            L_0x0070:
                r0 = r1;
                goto L_0x004a;
            L_0x0072:
                r2 = new com.tencent.mm.plugin.emoji.f.k;
                r2.<init>(r0);
                r0 = com.tencent.mm.u.ap.vd();
                r0.a(r2, r1);
                goto L_0x0060;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.model.c.1.run():void");
            }
        });
    }

    public final boolean h(com.tencent.mm.storage.a.c cVar) {
        al alVar;
        String str = null;
        if (cVar == null) {
            w.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            alVar = null;
        } else {
            alVar = new al();
            alVar.fFW = cVar.field_md5;
            alVar.uJw = cVar.field_type;
            alVar.uJx = cVar.field_size;
            alVar.fGa = cVar.field_groupId;
            alVar.uJB = cVar.field_designerID;
            alVar.thumbUrl = cVar.field_thumbUrl;
            alVar.fJY = cVar.field_encrypturl;
            alVar.aeskey = cVar.field_aeskey;
            alVar.width = cVar.field_width;
            alVar.height = cVar.field_height;
            alVar.mLO = cVar.field_cdnUrl;
            alVar.uJD = cVar.field_activityid;
        }
        if (alVar == null) {
            w.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            alVar.uJC = false;
            a(alVar, null, true);
            if (cVar != null) {
                str = cVar.field_groupId;
            }
            uv(str);
        }
        return true;
    }

    public final void a(al alVar, com.tencent.mm.y.d.a aVar, boolean z) {
        com.tencent.mm.storage.a.c cVar;
        if (alVar == null) {
            w.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
        }
        if (!(aVar == null || aVar.hst == null || aVar.hst.tfk != alVar.fTQ)) {
            alVar.gxE = ay.c(aVar);
            alVar.hJR = aVar.hst.tfl;
            alVar.iam = (long) aVar.hst.ogM;
        }
        com.tencent.mm.storage.a.c Si = h.amc().kLa.Si(alVar.fFW);
        if (Si != null) {
            Object obj = null;
            if (!(bg.mA(alVar.fGa) || alVar.fGa.equals(Si.field_groupId))) {
                Si.field_groupId = alVar.fGa;
                obj = 1;
            }
            if (!(bg.mA(alVar.uJB) || alVar.uJB.equals(Si.field_designerID))) {
                Si.field_designerID = alVar.uJB;
                obj = 1;
            }
            if (!(bg.mA(alVar.thumbUrl) || alVar.thumbUrl.equals(Si.field_thumbUrl))) {
                Si.field_thumbUrl = alVar.thumbUrl;
                obj = 1;
            }
            if (!(bg.mA(alVar.fJY) || alVar.fJY.equals(Si.field_encrypturl))) {
                Si.field_encrypturl = alVar.fJY;
                obj = 1;
            }
            if (!(bg.mA(alVar.aeskey) || alVar.aeskey.equals(Si.field_aeskey))) {
                Si.field_aeskey = alVar.aeskey;
                obj = 1;
            }
            if (!(bg.mA(alVar.mLO) || alVar.mLO.equals(Si.field_cdnUrl))) {
                Si.field_cdnUrl = alVar.mLO;
                obj = 1;
            }
            if (alVar.width > 0 && alVar.width != Si.field_width) {
                Si.field_width = alVar.width;
                obj = 1;
            }
            if (alVar.height > 0 && alVar.height != Si.field_height) {
                Si.field_height = alVar.height;
                obj = 1;
            }
            if (!(bg.mA(alVar.uJD) || alVar.uJD.equalsIgnoreCase(Si.field_activityid))) {
                Si.field_activityid = alVar.uJD;
                obj = 1;
            }
            if (obj != null) {
                h.amc().kLa.t(Si);
                w.i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", new Object[]{Si.field_designerID, Si.field_thumbUrl});
            }
            cVar = Si;
        } else {
            w.d("MicroMsg.emoji.EmojiService", "jacks prepare Emoji check groupId&md5 handle remote server old emoji version");
            com.tencent.mm.storage.a.c cVar2 = new com.tencent.mm.storage.a.c();
            cVar2.field_md5 = alVar.fFW;
            cVar2.field_svrid = alVar.id;
            cVar2.field_catalog = com.tencent.mm.storage.a.c.uKT;
            cVar2.field_type = alVar.uJw;
            cVar2.field_size = alVar.uJx;
            cVar2.field_groupId = alVar.fGa;
            cVar2.field_designerID = alVar.uJB;
            cVar2.field_thumbUrl = alVar.thumbUrl;
            cVar2.field_cdnUrl = alVar.mLO;
            cVar2.field_temp = 1;
            cVar2.field_encrypturl = alVar.fJY;
            cVar2.field_aeskey = alVar.aeskey;
            cVar2.field_designerID = alVar.uJB;
            cVar2.field_thumbUrl = alVar.thumbUrl;
            cVar2.field_state = com.tencent.mm.storage.a.c.uLi;
            cVar2.field_width = alVar.width;
            cVar2.field_height = alVar.height;
            cVar2.field_activityid = alVar.uJD;
            h.amc().kLa.r(cVar2);
            cVar = cVar2;
        }
        long j = 0;
        if (alVar.uJC) {
            cVar.bNr();
            if (alVar.fTQ != 0) {
                ap.yY();
                ce x = com.tencent.mm.u.c.wT().x(alVar.fJL, alVar.fTQ);
                if (x.field_msgSvrId == alVar.fTQ) {
                    j = x.field_msgId;
                }
            }
            ap.yY();
            com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(alVar.fJL);
            if (Rc == null || ((int) Rc.gTQ) == 0) {
                x xVar = new x(alVar.fJL);
                xVar.setType(2);
                ap.yY();
                com.tencent.mm.u.c.wR().R(xVar);
            }
            ce auVar = new au();
            auVar.setType(47);
            auVar.cH(alVar.fJL);
            auVar.dw(m.eH(alVar.iah) ? 1 : 0);
            auVar.cI(cVar.EP());
            auVar.y(alVar.fTQ);
            String str = alVar.iah;
            boolean z2 = (cVar.bCU() || cVar.isGif()) ? false : true;
            auVar.setContent(aj.a(str, 0, z2, cVar.EP(), false, alVar.uJA));
            auVar.z(ay.i(auVar.field_talker, alVar.iam));
            auVar.dv(3);
            if (!bg.mA(alVar.gxF)) {
                auVar.cN(alVar.gxF);
            }
            if (aVar == null) {
                int i = alVar.gxE;
                if (i != 0) {
                    auVar.dF(i);
                    if (auVar.field_msgId == 0 && auVar.field_isSend == 0 && (i & 2) != 0) {
                        auVar.z(ay.a(auVar.field_talker, alVar.iam, true, auVar.field_msgSeq));
                    }
                }
                if (alVar.hJR != 0) {
                    auVar.B((long) alVar.hJR);
                }
                w.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(alVar.hJR)});
            } else {
                ay.a(auVar, aVar);
            }
            if (this.kLC != null && this.kLC.containsKey(Long.valueOf(auVar.field_msgSvrId))) {
                w.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
                auVar.setContent((String) this.kLC.get(Long.valueOf(auVar.field_msgSvrId)));
                auVar.setType(10000);
                this.kLC.remove(Long.valueOf(auVar.field_msgSvrId));
            }
            long i2 = ay.i(auVar);
            if (!m.eH(alVar.iah)) {
                ap.yY();
                ((ai) ap.getNotification()).a(com.tencent.mm.u.c.wT().cA(i2));
            }
            j = i2;
        }
        if (!cVar.bNr()) {
            if (!z) {
                w.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[]{Boolean.valueOf(z)});
                this.kLH.remove(alVar.fFW);
                alR();
            } else if (this.kLH == null || !this.kLH.contains(alVar.fFW)) {
                this.kLH.add(alVar.fFW);
                String eN = cVar.eN(cVar.field_groupId, cVar.EP());
                if (!bg.mA(alVar.fJY) && !bg.mA(alVar.aeskey)) {
                    h.alV().a(alVar.fJY, f.h(eN + "_encrypt", alVar, cVar, Boolean.valueOf(true), Long.valueOf(j)), this.kLz);
                    com.tencent.mm.plugin.emoji.c.bi(6);
                } else if (bg.mA(alVar.mLO)) {
                    this.kLH.remove(alVar.fFW);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(alVar.fFW);
                    ap.vd().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
                    w.i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", new Object[]{alVar.fFW});
                    com.tencent.mm.plugin.emoji.c.bi(9);
                } else {
                    h.alV().a(alVar.mLO, f.g(eN, alVar, cVar, Boolean.valueOf(false), Long.valueOf(j)), this.kLz);
                    com.tencent.mm.plugin.emoji.c.bi(1);
                }
            } else {
                w.i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", new Object[]{alVar.fFW});
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 2;
        w.d("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(kVar instanceof r)) {
            return;
        }
        if (this.kLE.size() <= 0) {
            this.kLD = false;
            return;
        }
        b bVar;
        b bVar2 = (b) this.kLE.remove(0);
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.c.oTb.a(111, 35, 1, true);
            i3 = 5;
        }
        ap.yY();
        au cA = com.tencent.mm.u.c.wT().cA(bVar2.fGM);
        cA.dv(i3);
        ap.yY();
        com.tencent.mm.u.c.wT().a(bVar2.fGM, cA);
        if (this.kLE.size() > 0) {
            bVar = (b) this.kLE.get(0);
            ap.vd().a(new r(bVar.fJz, bVar.toUserName, bVar.fEk, bVar.fGM), 0);
        } else {
            this.kLD = false;
            bVar = bVar2;
        }
        if (this.kLF == null) {
            this.kLF = new qb();
        }
        this.kLF.fXf.fGa = bVar.fEk.field_groupId;
        com.tencent.mm.sdk.b.a.urY.m(this.kLF);
    }

    public static void a(al alVar, com.tencent.mm.storage.a.c cVar, boolean z) {
        String str = "MicroMsg.emoji.EmojiService";
        String str2 = "handleCNDDownloadResult file no exist., try to download by cgi.emojiMd5:%s field_cdnUrl:%s";
        Object[] objArr = new Object[2];
        objArr[0] = cVar == null ? "" : cVar.EP();
        objArr[1] = cVar == null ? "" : cVar.field_cdnUrl;
        w.i(str, str2, objArr);
        if (z) {
            com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 3, 1, 1, alVar.fGa, 1, alVar.uJB);
            com.tencent.mm.plugin.emoji.c.bi(8);
        } else {
            com.tencent.mm.plugin.emoji.c.a(alVar.fFW, 2, 1, 1, alVar.fGa, 1, alVar.uJB);
            com.tencent.mm.plugin.emoji.c.bi(3);
        }
        alR();
    }

    public static void alR() {
        ap.yY();
        com.tencent.mm.u.c.wT().doNotify();
    }
}
