package com.tencent.mm.plugin.emoji.sync.a;

import android.graphics.Bitmap;
import android.util.Base64;
import com.tencent.mm.ah.a.d.b;
import com.tencent.mm.e.a.cm;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import java.io.File;
import java.security.Key;
import java.util.Arrays;
import java.util.LinkedList;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a extends d {
    private c jFO;
    private String kMI;
    private String kNe;
    private String kNf;
    private e kOj;
    private String kOk;
    private String kOl;
    private String kOm;
    private String kOn;
    private String kOo;
    private com.tencent.mm.plugin.emoji.d.a kOp;
    private com.tencent.mm.ah.a.b.a kOq;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (bg.mA(str)) {
            w.e("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] can not create task md5 is null.");
        }
        this.kOk = str;
        this.kOl = str2;
        this.kOm = str3;
        this.kNe = str4;
        this.kOn = str5;
        this.kOo = str6;
        this.kMI = str7;
        this.kNf = str8;
        this.jFO = h.amc().kLa.Si(this.kOk);
        if (this.jFO == null) {
            this.jFO = new c();
            this.jFO.field_md5 = this.kOk;
            this.jFO.field_cdnUrl = this.kOl;
            this.jFO.field_thumbUrl = this.kOm;
            this.jFO.field_designerID = this.kNe;
            this.jFO.field_encrypturl = this.kOn;
            this.jFO.field_aeskey = this.kOo;
            this.jFO.field_groupId = this.kMI;
        }
        if (bg.mA(this.kOl)) {
            this.kOl = this.jFO.field_cdnUrl;
        } else {
            this.jFO.field_cdnUrl = this.kOl;
        }
        if (bg.mA(this.kOn)) {
            this.kOn = this.jFO.field_encrypturl;
            this.kOo = this.jFO.field_aeskey;
        } else {
            this.jFO.field_encrypturl = this.kOn;
            this.jFO.field_aeskey = this.kOo;
        }
        if (!bg.mA(this.kNe)) {
            this.jFO.field_designerID = this.kNe;
        }
        if (!bg.mA(this.kMI)) {
            this.jFO.field_groupId = this.kMI;
        }
        if (!bg.mA(this.kOm)) {
            this.jFO.field_thumbUrl = this.kOm;
        }
        if (!bg.mA(this.kNf)) {
            this.jFO.field_activityid = this.kNf;
        }
        this.kOp = new com.tencent.mm.plugin.emoji.d.a();
        this.kOq = new com.tencent.mm.ah.a.b.a();
    }

    public final void run() {
        String str;
        if (this.kOj != null) {
            this.kOj.uA(this.kOk);
        } else {
            w.w("MicroMsg.BKGLoader.EmojiDownloadTask", "call back is null.");
        }
        w.i("MicroMsg.BKGLoader.EmojiDownloadTask", "emoji md5:%s cndUrl:%s thumbUrl:%s field_designerID:%s field_encrypturl:%s field_groupId:%s", new Object[]{this.jFO.EP(), this.jFO.field_cdnUrl, this.jFO.field_thumbUrl, this.jFO.field_designerID, this.jFO.field_encrypturl, this.jFO.field_groupId});
        if (bg.mA(this.kOl) && bg.mA(this.kOn)) {
            g.oUh.a(164, 10, 1, false);
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.kOk);
            ap.vd().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
            amD();
        } else {
            boolean z;
            String str2 = this.kOl;
            if (bg.mA(this.kOn) || bg.mA(this.kOo)) {
                str = str2;
                z = false;
            } else {
                str = this.kOn;
                z = true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b jI = this.kOp.jI(str);
            if (jI == null || bg.bm(jI.data)) {
                w.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data suuse time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                amD();
            } else {
                w.d("MicroMsg.BKGLoader.EmojiDownloadTask", "get image data use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                byte[] bArr = jI.data;
                if (z) {
                    try {
                        byte[] bArr2 = jI.data;
                        byte[] decode = Base64.decode(Base64.encodeToString(bg.PT(this.kOo), 0).getBytes(), 0);
                        Key secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                        instance.init(2, secretKeySpec, new IvParameterSpec(Arrays.copyOf(decode, decode.length)));
                        bArr = instance.doFinal(bArr2);
                    } catch (Throwable e) {
                        w.w("MicroMsg.BKGLoader.EmojiDownloadTask", "encrypt file failed. %s", new Object[]{bg.g(e)});
                    }
                }
                Bitmap decodeByteArray = com.tencent.mm.sdk.platformtools.d.decodeByteArray(bArr, 10, 10);
                boolean a = this.kOq.a(str, bArr, f.g(this.jFO.eN(this.kMI, this.kOk), new Object[0]));
                File file = new File(this.jFO.eN(this.jFO.field_groupId, this.jFO.EP()));
                if (decodeByteArray != null && a && file.exists()) {
                    str = com.tencent.mm.a.g.f(file);
                    if (bg.mA(str) || !str.equalsIgnoreCase(this.jFO.EP())) {
                        if (file.exists()) {
                            file.delete();
                        }
                        amD();
                        if (z) {
                            com.tencent.mm.plugin.emoji.c.bi(8);
                            com.tencent.mm.plugin.emoji.c.a(this.kOk, 3, 0, 1, this.kMI, 1, this.kNe);
                        } else {
                            com.tencent.mm.plugin.emoji.c.bi(5);
                            com.tencent.mm.plugin.emoji.c.a(this.kOk, 2, 0, 1, this.kMI, 1, this.kNe);
                        }
                    } else {
                        this.jFO.field_size = bArr.length;
                        this.jFO.field_state = c.uLg;
                        this.jFO.field_temp = 0;
                        this.jFO.field_catalog = c.uKY;
                        this.jFO.field_type = EmojiLogic.ad(bArr);
                        int bNE = h.amc().kLa.bNE();
                        this.jFO.field_idx = bNE < n.alO() ? n.alO() : bNE + 1;
                        h.amc().kLa.t(this.jFO);
                        com.tencent.mm.storage.a.b bVar = h.amc().kLb;
                        if (!com.tencent.mm.storage.a.b.bNg()) {
                            h.amc().kLb.bNh();
                        }
                        com.tencent.mm.sdk.b.b cmVar = new cm();
                        cmVar.fFV.fFW = this.kOk;
                        cmVar.fFV.fEG = 0;
                        cmVar.fFV.success = true;
                        com.tencent.mm.sdk.b.a.urY.m(cmVar);
                        if (z) {
                            com.tencent.mm.plugin.emoji.c.bi(7);
                            com.tencent.mm.plugin.emoji.c.bi(4);
                            com.tencent.mm.plugin.emoji.c.a(this.kOk, 3, 0, 0, this.kMI, 0, this.kNe);
                        } else {
                            com.tencent.mm.plugin.emoji.c.bi(2);
                            com.tencent.mm.plugin.emoji.c.bi(4);
                            com.tencent.mm.plugin.emoji.c.a(this.kOk, 2, 0, 0, this.kMI, 1, this.kNe);
                        }
                        com.tencent.mm.plugin.emoji.e.e.alz().c(this.jFO, true);
                    }
                } else {
                    amD();
                    if (z) {
                        com.tencent.mm.plugin.emoji.c.bi(8);
                        com.tencent.mm.plugin.emoji.c.a(this.kOk, 3, 0, 1, this.kMI, 1, this.kNe);
                    } else {
                        com.tencent.mm.plugin.emoji.c.bi(3);
                        com.tencent.mm.plugin.emoji.c.a(this.kOk, 2, 1, 1, this.kMI, 1, this.kNe);
                    }
                }
            }
        }
        if (!bg.mA(this.jFO.field_thumbUrl)) {
            b jI2 = this.kOp.jI(this.jFO.field_thumbUrl);
            if (jI2 != null) {
                com.tencent.mm.ah.a.b.a aVar = this.kOq;
                str = this.jFO.field_thumbUrl;
                byte[] bArr3 = jI2.data;
                String str3 = this.jFO.field_thumbUrl;
                aVar.a(str, bArr3, f.g(this.jFO.eN(this.kMI, this.kOk) + "_cover", new Object[0]));
            }
        }
    }

    private void amD() {
        w.i("MicroMsg.BKGLoader.EmojiDownloadTask", "disable to download emoji when cdn download failed.");
        com.tencent.mm.sdk.b.b cmVar = new cm();
        cmVar.fFV.fFW = this.kOk;
        cmVar.fFV.fEG = 0;
        cmVar.fFV.success = false;
        com.tencent.mm.sdk.b.a.urY.m(cmVar);
        if (this.jFO != null) {
            w.i("MicroMsg.BKGLoader.EmojiDownloadTask", "[cpan] this emoji is broken. md5 is:%s", new Object[]{this.jFO.EP()});
            this.jFO.field_state = c.uLh;
            this.jFO.field_catalog = c.uKT;
            h.amc().kLa.t(this.jFO);
        }
    }

    public final String getKey() {
        return this.kOk;
    }

    public final void a(e eVar) {
        this.kOj = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (!(bg.mA(this.kOk) || bg.mA(aVar.kOk) || !this.kOk.equals(aVar.kOk))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
