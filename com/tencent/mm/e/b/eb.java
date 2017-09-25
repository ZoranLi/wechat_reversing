package com.tencent.mm.e.b;

import com.tencent.mm.bj.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import junit.framework.Assert;

public final class eb extends g {
    private static eb gJq = null;
    private static HashMap<Integer, c> gJr;

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new c() {
            public final String[] pP() {
                return new String[]{i.a(ba.pw(), "FavItemInfo")};
            }
        });
        gJr.put(Integer.valueOf("FavSearchInfo".hashCode()), new c() {
            public final String[] pP() {
                return new String[]{i.a(bb.pw(), "FavSearchInfo")};
            }
        });
        gJr.put(Integer.valueOf("FavEditInfo".hashCode()), new c() {
            public final String[] pP() {
                return new String[]{i.a(az.pw(), "FavEditInfo")};
            }
        });
        gJr.put(Integer.valueOf("FavCdnInfo".hashCode()), new c() {
            public final String[] pP() {
                return new String[]{i.a(ax.pw(), "FavCdnInfo")};
            }
        });
        gJr.put(Integer.valueOf("FavConfigInfo".hashCode()), new c() {
            public final String[] pP() {
                return new String[]{i.a(ay.pw(), "FavConfigInfo")};
            }
        });
    }

    private eb() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        h.vG();
        if (a.uH() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        w.d("MicroMsg.FavoriteDataBase", "db path", new Object[]{h.vI().cachePath + "enFavorite.db"});
        h.vG();
        if (a("", h.vI().cachePath + "enFavorite.db", (long) a.uH(), p.rA(), gJr)) {
            String str = this.uLZ;
            if (!bg.mA(str)) {
                w.e("MicroMsg.FavoriteDataBase", "dbinit failed :" + str);
                b.r("init db Favorite Failed: [ " + str + "]", "DBinit");
            }
            w.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return;
        }
        throw new com.tencent.mm.u.b((byte) 0);
    }

    public static eb pO() {
        if (gJq == null) {
            gJq = new eb();
        }
        return gJq;
    }

    public final void cQ(String str) {
        super.cQ(str);
        gJq = null;
    }
}
