package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.c;
import com.tencent.mm.e.a.s;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;

public final class b implements e {
    private c kLz = new c(this) {
        final /* synthetic */ b kLA;

        {
            this.kLA = r1;
        }

        public final void a(boolean z, Object... objArr) {
            boolean g;
            Throwable e;
            String str;
            String str2;
            Object[] objArr2;
            int aN;
            if (objArr == null || objArr.length < 2) {
                w.w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
                return;
            }
            ov ovVar;
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (objArr[0] instanceof ov) {
                ovVar = (ov) objArr[0];
            } else {
                ovVar = null;
            }
            if (ovVar == null) {
                w.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
            } else if (z) {
                File file;
                byte[] c;
                ap.yY();
                String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", ovVar.tup);
                String str3 = D + "_encrypt";
                if (booleanValue) {
                    if (com.tencent.mm.a.e.aN(str3) > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            g = a.g(Base64.encodeToString(bg.PT(ovVar.tus), 0), str3, D);
                            if (g) {
                                try {
                                    com.tencent.mm.plugin.emoji.c.bi(7);
                                } catch (Exception e2) {
                                    e = e2;
                                    w.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[]{bg.g(e)});
                                    com.tencent.mm.plugin.emoji.c.bi(8);
                                    w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    if (g) {
                                        str = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                        str2 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                        objArr2 = new Object[5];
                                        objArr2[0] = ovVar.tup;
                                        objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str3));
                                        objArr2[2] = g.aV(str3) != null ? "" : g.aV(str3);
                                        objArr2[3] = ovVar.tus;
                                        objArr2[4] = ovVar.tur;
                                        w.i(str, str2, objArr2);
                                        com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 0, 1, "", 1, "");
                                        com.tencent.mm.loader.stub.b.deleteFile(str3);
                                        b.aK(ovVar.tup, 2);
                                        return;
                                    }
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                    file = new File(D);
                                    aN = com.tencent.mm.a.e.aN(D);
                                    c = com.tencent.mm.a.e.c(D, 0, 10);
                                    if (aN > 0) {
                                    }
                                    this.kLA.a(ovVar, booleanValue);
                                    return;
                                }
                                w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                if (g) {
                                    str = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                    str2 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                    objArr2 = new Object[5];
                                    objArr2[0] = ovVar.tup;
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str3));
                                    if (g.aV(str3) != null) {
                                    }
                                    objArr2[2] = g.aV(str3) != null ? "" : g.aV(str3);
                                    objArr2[3] = ovVar.tus;
                                    objArr2[4] = ovVar.tur;
                                    w.i(str, str2, objArr2);
                                    com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 0, 1, "", 1, "");
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                    b.aK(ovVar.tup, 2);
                                    return;
                                }
                                com.tencent.mm.loader.stub.b.deleteFile(str3);
                            } else {
                                com.tencent.mm.plugin.emoji.c.bi(8);
                                w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                if (g) {
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                } else {
                                    str = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                    str2 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                    objArr2 = new Object[5];
                                    objArr2[0] = ovVar.tup;
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str3));
                                    if (g.aV(str3) != null) {
                                    }
                                    objArr2[2] = g.aV(str3) != null ? "" : g.aV(str3);
                                    objArr2[3] = ovVar.tus;
                                    objArr2[4] = ovVar.tur;
                                    w.i(str, str2, objArr2);
                                    com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 0, 1, "", 1, "");
                                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                                    b.aK(ovVar.tup, 2);
                                    return;
                                }
                            }
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            g = false;
                            e = th;
                            w.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", new Object[]{bg.g(e)});
                            com.tencent.mm.plugin.emoji.c.bi(8);
                            w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (g) {
                                com.tencent.mm.loader.stub.b.deleteFile(str3);
                                file = new File(D);
                                aN = com.tencent.mm.a.e.aN(D);
                                c = com.tencent.mm.a.e.c(D, 0, 10);
                                if (aN > 0) {
                                }
                                this.kLA.a(ovVar, booleanValue);
                                return;
                            }
                            str = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                            str2 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                            objArr2 = new Object[5];
                            objArr2[0] = ovVar.tup;
                            objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.aN(str3));
                            if (g.aV(str3) != null) {
                            }
                            objArr2[2] = g.aV(str3) != null ? "" : g.aV(str3);
                            objArr2[3] = ovVar.tus;
                            objArr2[4] = ovVar.tur;
                            w.i(str, str2, objArr2);
                            com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 0, 1, "", 1, "");
                            com.tencent.mm.loader.stub.b.deleteFile(str3);
                            b.aK(ovVar.tup, 2);
                            return;
                        }
                    }
                    w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", new Object[]{ovVar.tup});
                    com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 1, 1, "", 1, "");
                    b.aK(ovVar.tup, 2);
                    return;
                }
                file = new File(D);
                aN = com.tencent.mm.a.e.aN(D);
                c = com.tencent.mm.a.e.c(D, 0, 10);
                if (aN > 0 || c == null) {
                    this.kLA.a(ovVar, booleanValue);
                    return;
                }
                String f = g.f(file);
                if (bg.mA(f) || !f.equalsIgnoreCase(ovVar.tup)) {
                    w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", new Object[]{f, ovVar.tup, ovVar.msN});
                    file.delete();
                    b.aK(ovVar.tup, 2);
                    if (booleanValue) {
                        com.tencent.mm.plugin.emoji.c.bi(5);
                        com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 0, 1, "", 1, "");
                        return;
                    }
                    com.tencent.mm.plugin.emoji.c.bi(5);
                    com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 2, 0, 1, "", 1, "");
                    return;
                }
                if (booleanValue) {
                    com.tencent.mm.plugin.emoji.c.bi(4);
                    com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 0, 0, "", 0, "");
                } else {
                    com.tencent.mm.plugin.emoji.c.bi(4);
                    com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 2, 0, 0, "", 1, "");
                }
                int i = com.tencent.mm.storage.a.c.uLd;
                if (o.bf(c)) {
                    i = com.tencent.mm.storage.a.c.uLc;
                } else {
                    i = com.tencent.mm.storage.a.c.uLd;
                }
                com.tencent.mm.storage.a.c Si = h.amc().kLa.Si(f);
                if (Si == null) {
                    Si = new com.tencent.mm.storage.a.c();
                    Si.field_md5 = f;
                    Si.field_catalog = com.tencent.mm.storage.a.c.uKT;
                    Si.field_size = com.tencent.mm.a.e.aN(D);
                }
                Si.field_type = i;
                Si.field_state = com.tencent.mm.storage.a.c.uLg;
                h.amc().kLa.t(Si);
                b.aK(ovVar.tup, 1);
                EmojiLogic.a(ab.getContext(), null, Si.EP(), Si.ozt, Si);
            } else {
                this.kLA.a(ovVar, booleanValue);
            }
        }
    };

    public final void a(ov ovVar, boolean z) {
        w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to download by cgi.emojiMd5:%s", new Object[]{ovVar.tup});
        if (z) {
            com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 3, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.bi(8);
        } else {
            com.tencent.mm.plugin.emoji.c.a(ovVar.tup, 2, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.bi(3);
        }
        aK(ovVar.tup, 2);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 221:
                return;
            case 697:
                String str2 = "";
                com.tencent.mm.plugin.emoji.f.e eVar = (com.tencent.mm.plugin.emoji.f.e) kVar;
                if (eVar.kMP == com.tencent.mm.plugin.emoji.f.e.kMN) {
                    eu euVar = eVar.gUA == null ? null : (eu) eVar.gUA.hsj.hsr;
                    if (!(euVar == null || euVar.tiK == null || euVar.tiK.size() <= 0)) {
                        str2 = (String) euVar.tiK.get(0);
                    }
                    if (i == 0 && i2 == 0) {
                        ev evVar = eVar.gUA == null ? null : (ev) eVar.gUA.hsk.hsr;
                        if (evVar == null || evVar.tiM == null || evVar.tiM.size() <= 0) {
                            aK(str2, 2);
                            w.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
                            return;
                        }
                        ov ovVar = (ov) evVar.tiM.get(0);
                        ap.yY();
                        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", ovVar.tup);
                        com.tencent.mm.ah.a.a alV;
                        String str3;
                        String str4;
                        if (!bg.mA(ovVar.tur) && !bg.mA(ovVar.tus)) {
                            alV = h.alV();
                            str3 = ovVar.tur;
                            str4 = ovVar.tur;
                            alV.a(str3, f.h(D + "_encrypt", ovVar, Boolean.valueOf(true)), this.kLz);
                            com.tencent.mm.plugin.emoji.c.bi(6);
                            return;
                        } else if (bg.mA(ovVar.msN)) {
                            w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
                            aK(str2, 2);
                            return;
                        } else {
                            alV = h.alV();
                            str3 = ovVar.msN;
                            str4 = ovVar.msN;
                            alV.a(str3, f.g(D, ovVar, Boolean.valueOf(false)), this.kLz);
                            com.tencent.mm.plugin.emoji.c.bi(1);
                            return;
                        }
                    }
                    aK(str2, 2);
                    return;
                }
                w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
                return;
            default:
                w.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
                return;
        }
    }

    public static void aK(String str, int i) {
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fCV.fCW = str;
        sVar.fCV.status = i;
        sVar.fCV.fCX = 0;
        com.tencent.mm.sdk.b.a.urY.m(sVar);
        w.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
    }
}
