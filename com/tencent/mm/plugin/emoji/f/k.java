package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.lo;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.g.c;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.protocal.c.ph;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.d;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import java.util.Iterator;
import java.util.List;

public final class k extends com.tencent.mm.y.k implements j {
    public final b gUA;
    private e gWW;
    public String kMI = "";
    private a kNh;
    private boolean kNi = false;
    private lo kNj = null;

    public k(String str) {
        b.a aVar = new b.a();
        aVar.hsm = new xr();
        aVar.hsn = new xs();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar.hsl = 521;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kMI = str;
        this.kNj = new lo();
    }

    public k(String str, a aVar) {
        b.a aVar2 = new b.a();
        aVar2.hsm = new xr();
        aVar2.hsn = new xs();
        aVar2.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar2.hsl = 521;
        aVar2.hso = 0;
        aVar2.hsp = 0;
        this.gUA = aVar2.BE();
        this.kMI = str;
        this.kNh = aVar;
        this.kNi = true;
        this.kNj = new lo();
    }

    public final int getType() {
        return 521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", new Object[]{this.kMI});
        this.gWW = eVar2;
        ((xr) this.gUA.hsj.hsr).tgW = this.kMI;
        if (!TextUtils.isEmpty(this.kMI)) {
            return a(eVar, this.gUA, this);
        }
        w.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
        return -1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 != 0 || i3 != 0) {
            w.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.kMI});
            if (this.kNi) {
                w.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.kNi) {
            List<ph> list = ((xs) this.gUA.hsk.hsr).jNe;
            com.tencent.mm.storage.a.e eVar = h.amc().kLc;
            String str2 = this.kMI;
            int i4 = ((xs) this.gUA.hsk.hsr).tEh;
            int amp = amp();
            if (eVar.uLo != null) {
                eVar.uLo.edit().putLong("274544" + str2, System.currentTimeMillis()).commit();
            }
            if (list != null && list.size() > 0) {
                long cs;
                g gVar;
                if (eVar.gUz instanceof g) {
                    g gVar2 = (g) eVar.gUz;
                    cs = gVar2.cs(Thread.currentThread().getId());
                    gVar = gVar2;
                } else {
                    gVar = null;
                    cs = -1;
                }
                eVar.gUz.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                d dVar = new d();
                dVar.field_groupId = str2;
                dVar.field_click_flag = i4;
                dVar.field_download_flag = amp;
                for (ph phVar : list) {
                    dVar.field_md5 = phVar.tup;
                    Iterator it = phVar.jNe.iterator();
                    while (it.hasNext()) {
                        aip com_tencent_mm_protocal_c_aip = (aip) it.next();
                        dVar.field_desc = com_tencent_mm_protocal_c_aip.msk;
                        dVar.field_lang = com_tencent_mm_protocal_c_aip.mtJ;
                        dVar.field_md5_lang = dVar.field_md5 + dVar.field_lang;
                        if (eVar.gUz.replace("EmojiInfoDesc", "md5_lang", dVar.pv()) < 0) {
                            if (gVar != null) {
                                gVar.aD(cs);
                            }
                        }
                    }
                }
                eVar.gUz.replace("EmojiInfoDesc", "md5_lang", dVar.pv());
                if (gVar != null) {
                    gVar.aD(cs);
                }
            }
            if (list != null && list.size() > 0) {
                w.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", new Object[]{this.kMI});
                this.kNj.fSG.fGa = this.kMI;
                com.tencent.mm.sdk.b.a.urY.m(this.kNj);
            }
        } else if ((amp() & 1) == 1) {
            c.a(this.kNh);
        } else {
            w.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.gWW.a(i2, i3, str, this);
    }

    private int amp() {
        return ((xs) this.gUA.hsk.hsr).tEj;
    }

    protected final int ub() {
        return 50;
    }

    protected final int a(p pVar) {
        return com.tencent.mm.y.k.b.hsT;
    }
}
