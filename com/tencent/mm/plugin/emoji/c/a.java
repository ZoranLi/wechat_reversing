package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.e.a.lc;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<lc> {
    public a() {
        this.usg = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z;
        alu();
        ap.yY();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzO, Long.valueOf(0))).longValue() > 86400000) {
            int i = 1;
        } else {
            z = false;
        }
        if (i != 0) {
            ap.vd().a(new e(), 0);
        }
        dr(false);
        dq(false);
        ap.yY();
        if (((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzH, Boolean.valueOf(false))).booleanValue()) {
            ap.yY();
            Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzF, null);
            long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
            if (System.currentTimeMillis() - longValue > 86400000) {
                i = 1;
                if (i != 0) {
                    ap.vd().a(new n(8, 15), 0);
                }
                ap.yY();
                if (System.currentTimeMillis() - ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzR, Long.valueOf(0))).longValue() > 86400000) {
                    i = h.amc().kLa.jZ(false);
                    g.oUh.i(11597, new Object[]{Integer.valueOf(i)});
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzR, Long.valueOf(System.currentTimeMillis()));
                }
                return false;
            }
        }
        z = false;
        if (i != 0) {
            ap.vd().a(new n(8, 15), 0);
        }
        ap.yY();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzR, Long.valueOf(0))).longValue() > 86400000) {
            i = h.amc().kLa.jZ(false);
            g.oUh.i(11597, new Object[]{Integer.valueOf(i)});
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzR, Long.valueOf(System.currentTimeMillis()));
        }
        return false;
    }

    public static void dq(boolean z) {
        long j;
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzE, null);
        if (obj == null || !(obj instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) obj).longValue();
        }
        if ((System.currentTimeMillis() - j > 86400000) || z) {
            w.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[]{Boolean.valueOf(h.amc().kLb.bNm())});
            if (h.amc().kLb.bNm() || z) {
                ap.vd().a(new s(h.amc().kLb.bNo(), 1), 0);
                return;
            }
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzH, Boolean.valueOf(true));
        }
    }

    public static void dr(boolean z) {
        ap.yY();
        boolean z2;
        if (bg.b((Boolean) com.tencent.mm.u.c.vr().get(348165, null), false)) {
            long j;
            ap.yY();
            Object obj = com.tencent.mm.u.c.vr().get(348166, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                int i = 1;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (i != 0 || z) {
            ArrayList bND = h.amc().kLa.bND();
            if (bND.size() > 0) {
                w.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[]{Integer.valueOf(bND.size())});
                List arrayList = new ArrayList();
                int size = bND.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new d((String) bND.get(i2)));
                    w.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[]{bND.get(i2)});
                }
                h.alZ().kNA.am(arrayList);
                h.alZ().kNA.amx();
            } else {
                w.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
                ap.yY();
                com.tencent.mm.u.c.vr().set(348165, Boolean.valueOf(false));
            }
            ap.yY();
            com.tencent.mm.u.c.vr().set(348166, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void alu() {
        ap.yY();
        boolean b = bg.b((Boolean) com.tencent.mm.u.c.vr().get(348162, null), false);
        ap.yY();
        boolean z;
        if (bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uzD, null), false) || !b) {
            z = false;
        } else {
            long j;
            ap.yY();
            Object obj = com.tencent.mm.u.c.vr().get(348163, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                int i = 1;
            } else {
                z = false;
            }
        }
        if (i != 0) {
            w.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
            ArrayList arrayList = (ArrayList) h.amc().kLa.bNz();
            if (arrayList.size() <= 0) {
                w.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
                ap.yY();
                com.tencent.mm.u.c.vr().set(348162, Boolean.valueOf(false));
                return;
            }
            ap.yY();
            com.tencent.mm.u.c.vr().set(348163, Long.valueOf(System.currentTimeMillis()));
            w.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
            if (arrayList.size() > 50) {
                int size = arrayList.size();
                w.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[]{Integer.valueOf(size / 50)});
                for (int i2 = 0; i2 <= r6; i2++) {
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = i2 * 50;
                    int i4 = ((i2 + 1) * 50) + -1 >= size ? size : (i2 + 1) * 50;
                    w.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                    if (i4 > i3) {
                        arrayList2.addAll(arrayList.subList(i3, i4));
                        ap.vd().a(new com.tencent.mm.plugin.emoji.f.d(arrayList2), 0);
                    }
                }
                return;
            }
            ap.vd().a(new com.tencent.mm.plugin.emoji.f.d(arrayList), 0);
        }
    }
}
