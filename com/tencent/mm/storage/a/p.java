package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class p extends i<o> implements a {
    public static final String[] gUx = new String[]{i.a(o.gTP, "EmotionRewardTipInfo")};
    private e gUz;

    public p(e eVar) {
        this(eVar, o.gTP, "EmotionRewardTipInfo");
    }

    private p(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gUz = eVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final o bNG() {
        Cursor a;
        Throwable e;
        try {
            a = this.gUz.a("select * from EmotionRewardTipInfo order by modifyTime desc limit 1 ", new String[0], 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        o oVar = new o();
                        oVar.b(a);
                        if (a == null) {
                            return oVar;
                        }
                        a.close();
                        return oVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", new Object[]{bg.g(e)});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            w.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", new Object[]{bg.g(e)});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return null;
    }

    public final boolean cI(String str, int i) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            return false;
        }
        w.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", new Object[]{Boolean.valueOf(this.gUz.eE("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'"))});
        return this.gUz.eE("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
    }

    public final boolean a(o oVar) {
        if (oVar == null) {
            w.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            return false;
        }
        long replace = this.gUz.replace("EmotionRewardTipInfo", "prodcutID", oVar.pv());
        if (replace > 0) {
            w.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            w.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            return true;
        }
        return false;
    }
}
