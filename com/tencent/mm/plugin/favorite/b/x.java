package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.bb.d;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class x {
    private static Map<Long, Long> lFd = new HashMap();
    private static Map<Long, Long> lFe = new HashMap();
    private static long lFf = 0;
    public static List<Integer> lFg = new LinkedList();
    public static final int[] lFh = new int[]{2, 3, 4, 8, 14, 16, 18};
    public static final int[] lFi = new int[]{10, 8, 7};

    public interface a {
        boolean g(j jVar);
    }

    public static void bX(long j) {
        if (!lFd.containsKey(Long.valueOf(j))) {
            lFd.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static long bY(long j) {
        Long l = (Long) lFd.get(Long.valueOf(j));
        return l == null ? -1 : System.currentTimeMillis() - l.longValue();
    }

    public static void bZ(long j) {
        if (!lFe.containsKey(Long.valueOf(j))) {
            lFe.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static int bW(int i, int i2) {
        if (i2 == -401) {
            return -4;
        }
        if (i == 4) {
            return -2;
        }
        return -1;
    }

    public static long k(j jVar) {
        if (jVar == null) {
            return 0;
        }
        Iterator it = jVar.field_favProto.tzn.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = (int) (((rm) it.next()).txD + ((long) i));
        }
        return (long) i;
    }

    public static String atx() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xv()).append("favorite/").toString();
    }

    public static String aty() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xv()).append("favorite/web/").toString();
    }

    public static String atz() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xv()).append("favorite/voice/").toString();
    }

    public static String atA() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xv()).append("favorite/music/").toString();
    }

    public static rm a(j jVar, String str) {
        if (bg.mA(str) || jVar == null || jVar.field_favProto.tzn.size() == 0) {
            return null;
        }
        Iterator it = jVar.field_favProto.tzn.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (rmVar.lKv.equals(str)) {
                return rmVar;
            }
        }
        return null;
    }

    public static List<j> b(long j, int i, Set<Integer> set, a aVar) {
        if (j != 0) {
            return h.ata().a(j, i, (Set) set, aVar);
        }
        k ata = h.ata();
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<j> arrayList = new ArrayList();
            String str2 = "select " + k.lEl + " from FavItemInfo where itemStatus" + " > 0";
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                str = str2;
                for (Integer intValue : set) {
                    str = str + " and type != " + intValue.intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = ata.gUz.a(str + " order by updateTime desc limit 20", null, 2);
            if (a == null) {
                return arrayList;
            }
            while (a.moveToNext()) {
                j jVar = new j();
                jVar.b(a);
                if (aVar == null || !aVar.g(jVar)) {
                    arrayList.add(jVar);
                } else {
                    w.w("MicroMsg.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(jVar.field_id), Integer.valueOf(jVar.field_type)});
                }
            }
            a.close();
            return arrayList;
        }
        w.w("MicroMsg.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
        return null;
    }

    public static long q(long j, int i) {
        long j2;
        long j3;
        w.i("MicroMsg.FavoriteLogic", "tryStartBatchGet...");
        k ata = h.ata();
        if (ata.gUz == null) {
            w.e("MicroMsg.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
            j2 = 0;
        } else if (j == 0) {
            r0 = "select updateTime from (select * from FavItemInfo";
            if (i != -1) {
                r0 = r0 + " where type = " + i;
            }
            r2 = ata.gUz.rawQuery((r0 + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (r2 == null) {
                j2 = 0;
            } else if (r2.getCount() == 0) {
                r2.close();
                j2 = 0;
            } else {
                r2.moveToLast();
                j2 = r2.getLong(0);
                r2.close();
            }
        } else {
            r0 = "select updateTime from (select * from FavItemInfo where updateTime < " + j;
            if (i != -1) {
                r0 = r0 + " and type = " + i;
            }
            r2 = ata.gUz.rawQuery((r0 + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (r2 == null) {
                j2 = 0;
            } else if (r2.getCount() == 0) {
                r2.close();
                j2 = 0;
            } else {
                r2.moveToLast();
                j2 = r2.getLong(0);
                r2.close();
            }
        }
        k ata2 = h.ata();
        if (ata2.gUz == null) {
            w.e("MicroMsg.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
            j3 = 0;
        } else if (j == 0) {
            r2 = "select updateTime from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                r2 = r2 + " and type = " + i;
            }
            r4 = ata2.gUz.rawQuery(r2 + " order by updateTime desc limit 20", null);
            if (r4 == null) {
                j3 = 0;
            } else if (r4.getCount() == 0) {
                r4.close();
                j3 = 0;
            } else {
                r4.moveToLast();
                j3 = r4.getLong(0);
                r4.close();
            }
        } else {
            r2 = "select updateTime from FavItemInfo where updateTime < " + j;
            if (i != -1) {
                r2 = r2 + " and type = " + i;
            }
            r4 = ata2.gUz.rawQuery((r2 + " and itemStatus > 0") + " order by updateTime desc limit 20", null);
            if (r4 == null || r4.getCount() <= 0) {
                j3 = j;
            } else {
                r4.moveToLast();
                j3 = r4.getLong(0);
            }
            if (r4 != null) {
                r4.close();
            }
        }
        w.v("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j)});
        if (j2 == 0) {
            return j3;
        }
        LinkedList p = h.ata().p(j2, i);
        if (p.size() > 0) {
            w.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j)});
            w.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, need batch get idList size:%d", new Object[]{Integer.valueOf(p.size())});
            if (!ap.vd().a(new ab(p), 0)) {
                w.w("MicroMsg.FavoriteLogic", "do scene BatchGetFav fail");
                ab.atP();
            }
        }
        if (j3 == 0) {
            return j2;
        }
        return j2 < j3 ? j2 : j3;
    }

    public static void startSync() {
        ap.vd().a(new ad(), 0);
    }

    public static String vX(String str) {
        if (bg.mA(str)) {
            return null;
        }
        File file = new File(aty() + g.n(str.getBytes()));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static boolean d(rm rmVar) {
        return new File(g(rmVar)).exists();
    }

    public static boolean e(rm rmVar) {
        return o.Pj(g(rmVar));
    }

    public static boolean atB() {
        return ab.atQ() > 0;
    }

    public static void l(j jVar) {
        if (jVar.atj()) {
            switch (jVar.field_itemStatus) {
                case 3:
                    jVar.field_itemStatus = 1;
                    h.ata().a(jVar, "localId");
                    h.asR().run();
                    return;
                case 6:
                    if (h.asV().bQ(jVar.field_localId).size() == 0) {
                        jVar.field_itemStatus = 9;
                        h.ata().a(jVar, "localId");
                        ap.vd().a(new z(jVar), 0);
                        return;
                    }
                    jVar.field_itemStatus = 4;
                    h.asV().a(jVar);
                    h.ata().a(jVar, "localId");
                    for (a aVar : h.asV().bQ(jVar.field_localId)) {
                        w.i("MicroMsg.FavoriteLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), aVar.field_dataId, Integer.valueOf(aVar.field_dataType), Integer.valueOf(aVar.field_totalLen)});
                        h.asU().wd(aVar.field_dataId);
                    }
                    h.asU().run();
                    return;
                case 11:
                    jVar.field_itemStatus = 9;
                    h.ata().a(jVar, "localId");
                    h.asQ().run();
                    return;
                case 14:
                    h.ata().r(12, jVar.field_localId);
                    h.asQ().run();
                    return;
                case 16:
                    h.ata().r(15, jVar.field_localId);
                    h.asV().a(jVar);
                    for (a aVar2 : h.asV().bQ(jVar.field_localId)) {
                        w.i("MicroMsg.FavoriteLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), aVar2.field_dataId, Integer.valueOf(aVar2.field_dataType), Integer.valueOf(aVar2.field_totalLen)});
                        h.asU().wd(aVar2.field_dataId);
                    }
                    h.asU().run();
                    return;
                case 18:
                    h.ata().r(17, jVar.field_localId);
                    h.asS().run();
                    return;
                default:
                    return;
            }
        }
        w.f("MicroMsg.FavoriteLogic", "restartItemUpload status not upload failed!");
    }

    public static void m(j jVar) {
        if (jVar != null) {
            if (jVar.field_itemStatus == 8 || jVar.field_itemStatus == 10) {
                jVar.field_itemStatus = 7;
                List<rm> list = jVar.field_favProto.tzn;
                if (list.size() != 0) {
                    for (rm rmVar : list) {
                        a(jVar, rmVar, true);
                        b(jVar, rmVar, true);
                    }
                    return;
                }
                return;
            }
            w.e("MicroMsg.FavoriteLogic", "status not download failed or done!");
        }
    }

    public static void a(j jVar, rm rmVar, boolean z) {
        if (jVar != null && !bg.mA(rmVar.lKv)) {
            w.i("MicroMsg.FavoriteLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), rmVar.lKv});
            a vN = h.asV().vN(rmVar.lKv);
            if (vN != null && vN.field_status == 3) {
                h.asV().b(vN, "dataId");
                vN = null;
            }
            if (vN == null || vN.field_type != 1) {
                File file = new File(g(rmVar));
                if (!bg.mA(rmVar.txk) && !bg.mA(rmVar.txi) && !file.exists()) {
                    w.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    a(rmVar, jVar, 1, true);
                    if (z) {
                        h.asU().wd(rmVar.lKv);
                        if (!bg.mA(rmVar.tyk) && rmVar.tyk.equals("WeNoteHtmlFile")) {
                            h.asU().g(h.asV().vN(rmVar.lKv));
                        }
                    }
                    h.asU().run();
                    w.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            w.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            vN.field_status = 1;
            h.asV().a(vN, "dataId");
            if (z) {
                h.asU().wd(rmVar.lKv);
                if (!bg.mA(rmVar.tyk) && rmVar.tyk.equals("WeNoteHtmlFile")) {
                    h.asU().g(h.asV().vN(rmVar.lKv));
                }
            }
            h.asU().run();
        }
    }

    public static void b(j jVar, rm rmVar, boolean z) {
        if (!bg.mA(rmVar.lKv)) {
            String vZ = vZ(rmVar.lKv);
            a vN = h.asV().vN(vZ);
            if (vN != null && vN.field_status == 3) {
                h.asV().b(vN, "dataId");
                vN = null;
            }
            if (vN == null || vN.field_type != 1) {
                File file = new File(h(rmVar));
                if (!bg.mA(rmVar.txe) && !bg.mA(rmVar.hhy) && !file.exists()) {
                    a(rmVar, jVar, 1);
                    h.asU().wd(vZ);
                    h.asU().run();
                    return;
                }
                return;
            }
            vN.field_status = 1;
            h.asV().a(vN, "dataId");
            h.asU().wd(vZ);
            h.asU().run();
        }
    }

    public static void f(rm rmVar) {
        a vN = h.asV().vN(rmVar.lKv);
        if (!(vN == null || vN.field_status == 3)) {
            vN.field_status = 2;
            h.asV().a(vN, "dataId");
            h.asU().pauseDownload(rmVar.lKv);
        }
        vN = h.asV().vN(vZ(rmVar.lKv));
        if (vN != null && vN.field_status != 3) {
            vN.field_status = 2;
            h.asV().a(vN, "dataId");
            h.asU().pauseDownload(vZ(rmVar.lKv));
        }
    }

    public static rm n(j jVar) {
        if (jVar == null) {
            return new rm();
        }
        if (jVar.field_favProto.tzn.size() == 0) {
            return new rm();
        }
        return (rm) jVar.field_favProto.tzn.get(0);
    }

    public static CharSequence s(Context context, int i) {
        int i2 = i / 1000;
        if (i2 <= 0) {
            return context.getString(R.l.ejN, new Object[]{Integer.valueOf(0)});
        }
        int i3 = i2 / 60;
        i2 %= 60;
        if (i3 == 0) {
            return context.getString(R.l.ejN, new Object[]{Integer.valueOf(i2)});
        }
        return context.getString(R.l.ejM, new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    public static float aw(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static float ca(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static void o(j jVar) {
        if (jVar.ati()) {
            w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, itemStatu:%d", new Object[]{Integer.valueOf(jVar.field_itemStatus)});
            Iterator it = jVar.field_favProto.tzn.iterator();
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                a vN = h.asV().vN(rmVar.lKv);
                if (!(vN == null || vN.field_status == 3)) {
                    vN.field_status = 2;
                    h.asV().a(vN, "dataId");
                    h.asU().we(rmVar.lKv);
                }
                vN = h.asV().vN(vZ(rmVar.lKv));
                if (!(vN == null || vN.field_status == 3)) {
                    vN.field_status = 2;
                    h.asV().a(vN, "dataId");
                    h.asU().we(vZ(rmVar.lKv));
                }
            }
            j bT = h.ata().bT(jVar.field_localId);
            w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, after pause data itemStatu:%d", new Object[]{Integer.valueOf(bT.field_itemStatus)});
            switch (bT.field_itemStatus) {
                case 1:
                    h.ata().r(3, bT.field_localId);
                    w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(3)});
                    return;
                case 4:
                    h.ata().r(6, bT.field_localId);
                    w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(6)});
                    return;
                case 9:
                    h.ata().r(11, bT.field_localId);
                    w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(11)});
                    return;
                case 12:
                    h.ata().r(14, bT.field_localId);
                    w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(14)});
                    return;
                case 15:
                    h.ata().r(16, bT.field_localId);
                    w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(16)});
                    return;
                case 17:
                    h.ata().r(18, bT.field_localId);
                    w.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", new Object[]{Integer.valueOf(18)});
                    return;
                default:
                    return;
            }
        }
        w.e("MicroMsg.FavoriteLogic", "pauseItemUpload, not uploading");
    }

    public static String aS(String str, int i) {
        return g.n((str + i + System.currentTimeMillis()).getBytes());
    }

    public static String g(rm rmVar) {
        if (rmVar == null) {
            return "";
        }
        String str = rmVar.lKv;
        if (bg.mA(str) || !ap.zb()) {
            return "";
        }
        File vY = vY(str);
        Object obj = null;
        if (rmVar.aMw == 8 && !bg.mA(rmVar.title)) {
            str = rmVar.title;
            vY = vY(rmVar.lKv);
            obj = 1;
        }
        if (rmVar.txx != null && rmVar.txx.trim().length() > 0 && r0 == null) {
            str = str + "." + rmVar.txx;
        }
        return new File(vY, str).getAbsolutePath();
    }

    public static String h(rm rmVar) {
        if (rmVar == null || bg.mA(rmVar.lKv)) {
            return "";
        }
        String vZ = vZ(rmVar.lKv);
        return new File(vY(vZ), vZ).getAbsolutePath();
    }

    private static File vY(String str) {
        int hashCode = str.hashCode() & 255;
        r3 = new Object[3];
        ap.yY();
        r3[0] = c.xv();
        r3[1] = "favorite";
        r3[2] = Integer.valueOf(hashCode);
        File file = new File(String.format("%s/%s/%d/", r3));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static String vZ(String str) {
        return str + "_t";
    }

    public static boolean wa(String str) {
        if (bg.mA(str)) {
            return false;
        }
        return str.endsWith("_t");
    }

    public static boolean a(long j, Runnable runnable) {
        return a(h.ata().bT(j), true, runnable);
    }

    public static boolean a(j jVar, Runnable runnable) {
        return a(jVar, true, null);
    }

    public static boolean a(final j jVar, final boolean z, final Runnable runnable) {
        if (jVar == null) {
            w.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            af.v(runnable);
            return false;
        }
        if (Looper.myLooper() == ap.vL().nJF.getLooper()) {
            w.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), Boolean.valueOf(z)});
            a(jVar, z);
            af.v(runnable);
        } else {
            w.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), Boolean.valueOf(z)});
            ap.vL().D(new Runnable() {
                public final void run() {
                    w.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), Boolean.valueOf(z)});
                    x.a(jVar, z);
                    af.v(runnable);
                }
            });
        }
        return true;
    }

    public static void a(j jVar, boolean z) {
        p(jVar);
        h.asZ().bV(jVar.field_localId);
        h.ata().d(jVar);
        h.asV().bS(jVar.field_localId);
        h.asT().i(jVar);
        if (z) {
            Set atD = atD();
            atD.add(jVar.field_id);
            e(atD);
            atC();
        }
    }

    public static boolean au(List<j> list) {
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            return false;
        }
        Set atD = atD();
        for (j jVar : list) {
            p(jVar);
            h.asZ().bV(jVar.field_localId);
            h.ata().d(jVar);
            h.asV().bS(jVar.field_localId);
            h.asT().i(jVar);
            atD.add(jVar.field_id);
            w.d("MicroMsg.FavoriteLogic", "delete id %d", new Object[]{Integer.valueOf(jVar.field_id)});
        }
        e(atD);
        atC();
        return true;
    }

    public static void av(List<Integer> list) {
        if (list.size() == 0) {
            w.e("MicroMsg.FavoriteLogic", "setDeleted list null");
            return;
        }
        Set atD = atD();
        w.i("MicroMsg.FavoriteLogic", "setDeleted before del:%s", new Object[]{atD.toString()});
        for (Integer num : list) {
            boolean remove = atD.remove(num.toString());
            w.i("MicroMsg.FavoriteLogic", "setDeleted id:%d, ret:%b", new Object[]{num, Boolean.valueOf(remove)});
        }
        w.i("MicroMsg.FavoriteLogic", "setDeleted after del:%s", new Object[]{atD.toString()});
        e(atD);
    }

    public static void atC() {
        Set<String> atD = atD();
        if (atD.size() == 0) {
            w.v("MicroMsg.FavoriteLogic", "doBatchDel no item to delete");
            return;
        }
        w.i("MicroMsg.FavoriteLogic", "doBatchDel idList:%s", new Object[]{atD.toString()});
        LinkedList linkedList = new LinkedList();
        for (String str : atD) {
            try {
                linkedList.add(Integer.valueOf(bg.getInt(str, 0)));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FavoriteLogic", e, "", new Object[0]);
                w.e("MicroMsg.FavoriteLogic", "doBatchDel parseInt error:%s", new Object[]{e.getMessage()});
            }
        }
        w.i("MicroMsg.FavoriteLogic", "doBatchDel after parse, total size %d", new Object[]{Integer.valueOf(linkedList.size())});
        if (linkedList.size() > 0) {
            ap.vd().a(new aa(linkedList), 0);
        }
    }

    private static void e(Set<String> set) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : set) {
            stringBuffer.append(append).append(",");
        }
        Object obj = "";
        if (stringBuffer.length() > 0) {
            obj = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        w.i("MicroMsg.FavoriteLogic", "set need del IDs: %s", new Object[]{obj});
        ap.yY();
        c.vr().set(225282, obj);
    }

    private static Set<String> atD() {
        ap.yY();
        String str = (String) c.vr().get(225282, "");
        w.i("MicroMsg.FavoriteLogic", "get need del IDs: %s", new Object[]{str});
        Set<String> hashSet = new HashSet();
        if (bg.mA(str)) {
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return hashSet;
        }
        for (Object add : split) {
            hashSet.add(add);
        }
        return hashSet;
    }

    private static void p(j jVar) {
        Set set = com.tencent.mm.ay.a.idW;
        List list = jVar.field_favProto.tzn;
        for (int i = 0; i < list.size(); i++) {
            String h = h((rm) list.get(i));
            if (set == null || !set.contains(h)) {
                b.deleteFile(h);
            }
            h = g((rm) list.get(i));
            if (set == null || !set.contains(h)) {
                b.deleteFile(h);
            }
        }
    }

    public static void a(rm rmVar, j jVar, int i, boolean z) {
        if (i == 1 && (rmVar.txD <= 0 || bg.mA(rmVar.txk) || bg.mA(rmVar.txi))) {
            w.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bg.mA(g(rmVar))) {
            w.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type send, path must not be null!");
        } else if (h.asV().vN(rmVar.lKv) != null) {
            w.v("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", new Object[]{rmVar.lKv});
        } else {
            Object obj;
            w.i("MicroMsg.FavoriteLogic", "insert cdn data info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_id)});
            a aVar = new a();
            aVar.field_dataId = rmVar.lKv;
            aVar.field_totalLen = (int) rmVar.txD;
            aVar.field_type = i;
            aVar.field_favLocalId = jVar.field_localId;
            aVar.field_cdnKey = rmVar.txk;
            aVar.field_cdnUrl = rmVar.txi;
            aVar.field_path = g(rmVar);
            if (rmVar.aMw == 3) {
                String str = rmVar.txx;
                int i2 = (bg.mA(str) || !str.equals("speex")) ? (bg.mA(str) || !str.equals("silk")) ? -2 : -4 : -3;
                aVar.field_dataType = i2;
            } else {
                aVar.field_dataType = rmVar.aMw;
            }
            aVar.field_modifyTime = bg.Nz();
            boolean isWifi = am.isWifi(ab.getContext());
            if (i == 0) {
                w.i("MicroMsg.FavoriteLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(aVar.field_dataType), Integer.valueOf(aVar.field_totalLen)});
                if (z) {
                    obj = 1;
                } else if (isWifi) {
                    obj = 1;
                } else if (aVar.field_dataType == 8 || aVar.field_dataType == 4 || aVar.field_dataType == 15) {
                    if (((long) aVar.field_totalLen) <= atK()) {
                        w.i("MicroMsg.FavoriteLogic", "match max auto upload, max size %d", new Object[]{Long.valueOf(atK())});
                        obj = 1;
                    } else {
                        obj = null;
                    }
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.field_status = 1;
                    w.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status traning");
                } else {
                    aVar.field_status = 4;
                    w.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i == 1) {
                w.i("MicroMsg.FavoriteLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(aVar.field_dataType), Integer.valueOf(aVar.field_totalLen)});
                if (z) {
                    obj = 1;
                } else if (isWifi) {
                    obj = 1;
                } else if (aVar.field_dataType == 8 || aVar.field_dataType == 4 || aVar.field_dataType == 15) {
                    if (((long) aVar.field_totalLen) <= atJ()) {
                        w.i("MicroMsg.FavoriteLogic", "match max auto download, max size %d", new Object[]{Long.valueOf(atJ())});
                        obj = 1;
                    } else {
                        obj = null;
                    }
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    aVar.field_status = 1;
                    w.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status traning");
                } else {
                    aVar.field_status = 4;
                    w.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status pause");
                }
            }
            h.asV().a(aVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.c.c.f(aVar);
            } else {
                com.tencent.mm.plugin.favorite.c.c.e(aVar);
            }
        }
    }

    public static void a(rm rmVar, j jVar, int i) {
        if (i == 1 && (rmVar.txO <= 0 || bg.mA(rmVar.txe) || bg.mA(rmVar.hhy))) {
            w.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bg.mA(h(rmVar))) {
            w.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type send, path must not be null!");
        } else {
            String vZ = vZ(rmVar.lKv);
            if (h.asV().vN(vZ) != null) {
                w.w("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", new Object[]{vZ});
                return;
            }
            w.v("MicroMsg.FavoriteLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", new Object[]{Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_id)});
            a aVar = new a();
            aVar.field_cdnKey = rmVar.txe;
            aVar.field_cdnUrl = rmVar.hhy;
            aVar.field_dataId = vZ;
            aVar.field_favLocalId = jVar.field_localId;
            aVar.field_totalLen = (int) rmVar.txO;
            aVar.field_type = i;
            aVar.field_status = 1;
            aVar.field_path = h(rmVar);
            aVar.field_modifyTime = bg.Nz();
            h.asV().a(aVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.c.c.f(aVar);
            } else {
                com.tencent.mm.plugin.favorite.c.c.e(aVar);
            }
        }
    }

    private static void q(j jVar) {
        int i;
        com.tencent.mm.sdk.e.c cVar;
        com.tencent.mm.sdk.e.c bW = h.asZ().bW(jVar.field_localId);
        if (bW == null) {
            bW = new o();
            bW.field_localId = jVar.field_localId;
            i = 1;
            cVar = bW;
        } else {
            i = 0;
            cVar = bW;
        }
        cVar.field_tagContent = "";
        for (String str : jVar.field_tagProto.tzw) {
            cVar.field_tagContent += " " + str;
        }
        for (String str2 : jVar.field_tagProto.tzx) {
            cVar.field_tagContent += " " + str2;
            h.asT().vU(str2);
        }
        cVar.field_content = "";
        cVar.field_time = jVar.field_updateTime;
        cVar.field_type = jVar.field_type;
        if (i != 0) {
            h.asZ().b(cVar);
            return;
        }
        h.asZ().c(cVar, new String[]{"localId"});
    }

    public static void r(j jVar) {
        int i;
        com.tencent.mm.sdk.e.c cVar;
        com.tencent.mm.sdk.e.c bW = h.asZ().bW(jVar.field_localId);
        if (bW == null) {
            bW = new o();
            bW.field_localId = jVar.field_localId;
            i = 1;
            cVar = bW;
        } else {
            i = 0;
            cVar = bW;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (jVar.field_favProto.title != null) {
            stringBuffer.append(jVar.field_favProto.title);
        }
        if (jVar.field_favProto.desc != null) {
            stringBuffer.append(jVar.field_favProto.desc);
        }
        if (jVar.field_favProto.tzl != null) {
            rw rwVar = jVar.field_favProto.tzl;
            if (!bg.mA(rwVar.fOu)) {
                stringBuffer.append(rwVar.fOu);
                ap.yY();
                com.tencent.mm.e.b.af Rc = c.wR().Rc(rwVar.fOu);
                if (Rc != null) {
                    stringBuffer.append(Rc.field_nickname).append(Rc.field_conRemark);
                }
                ap.yY();
                Rc = c.wR().Rc(rwVar.toUser);
                if (Rc != null) {
                    stringBuffer.append(Rc.field_nickname).append(Rc.field_conRemark);
                }
                stringBuffer.append(rwVar.tyQ);
            }
        }
        LinkedList linkedList = jVar.field_favProto.tzn;
        cVar.field_subtype = 0;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (rmVar.desc != null) {
                stringBuffer.append(rmVar.desc);
            }
            if (rmVar.title != null) {
                stringBuffer.append(rmVar.title);
            }
            int i2 = rmVar.aMw;
            cVar.field_subtype = o.ms(i2) | cVar.field_subtype;
        }
        if (jVar.field_favProto.tyy != null) {
            if (jVar.field_favProto.tyy.desc != null) {
                stringBuffer.append(jVar.field_favProto.tyy.desc);
            }
            if (jVar.field_favProto.tyy.title != null) {
                stringBuffer.append(jVar.field_favProto.tyy.title);
            }
        }
        if (jVar.field_favProto.tyA != null) {
            if (jVar.field_favProto.tyA.desc != null) {
                stringBuffer.append(jVar.field_favProto.tyA.desc);
            }
            if (jVar.field_favProto.tyA.title != null) {
                stringBuffer.append(jVar.field_favProto.tyA.title);
            }
        }
        cVar.field_tagContent = "";
        for (String str : jVar.field_tagProto.tzw) {
            cVar.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : jVar.field_tagProto.tzx) {
            cVar.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            h.asT().vU(str2);
        }
        cVar.field_content = stringBuffer.toString();
        cVar.field_time = jVar.field_updateTime;
        cVar.field_type = jVar.field_type;
        if (i != 0) {
            h.asZ().b(cVar);
            return;
        }
        h.asZ().c(cVar, new String[]{"localId"});
    }

    public static ArrayList<j> a(List<String> list, List<String> list2, List<Integer> list3, List<j> list4, Set<Integer> set, a aVar) {
        String str;
        p asZ = h.asZ();
        ArrayList arrayList = new ArrayList();
        String str2 = "select localId from FavSearchInfo";
        String str3 = " 1=1 ";
        if (!(list == null || list.isEmpty())) {
            str = str3;
            for (String str32 : list) {
                str = str + " and content like '%" + str32 + "%'";
            }
            str32 = str;
        }
        if (!(list2 == null || list2.isEmpty())) {
            str = str32;
            for (String str322 : list2) {
                str = str + " and tagContent like '%" + str322 + "%'";
            }
            str322 = str;
        }
        str322 = str2 + " where " + str322;
        if (!(list3 == null || list3.isEmpty())) {
            str322 = str322 + " and ((1=1 ";
            str = str322;
            for (Integer intValue : list3) {
                str = str + " and type = " + intValue.intValue();
            }
            str322 = str + ") or (1=1";
            str = str322;
            for (Integer intValue2 : list3) {
                str = str + " and subtype & " + o.ms(intValue2.intValue()) + " != 0";
            }
            str322 = str + "))";
        }
        w.d("MicroMsg.FavSearchStorage", "search id sql {%s}", new Object[]{str322 + " order by time desc"});
        Cursor a = asZ.gUz.a(str322, null, 2);
        if (a == null) {
            List list5 = arrayList;
        } else {
            while (a.moveToNext()) {
                arrayList.add(Long.valueOf(a.getLong(0)));
            }
            a.close();
            Object obj = arrayList;
        }
        ArrayList<j> arrayList2 = new ArrayList();
        if (list5.size() == 0) {
            return arrayList2;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < list5.size() ? i + 20 : list5.size();
            w.v("MicroMsg.FavoriteLogic", "start:%d  end:%d listSize:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(list5.size())});
            Collection a2 = h.ata().a(list5.subList(i, size), (List) list4, (Set) set, aVar);
            if (a2 != null && a2.size() > 0) {
                arrayList2.addAll(a2);
            }
            if (size >= list5.size()) {
                return arrayList2;
            }
            i = size;
        }
    }

    public static int wb(String str) {
        if (!bg.mA(str) && str.equals("speex")) {
            return 1;
        }
        if (bg.mA(str) || !str.equals("silk")) {
            return 0;
        }
        return 2;
    }

    public static void cb(long j) {
        w.i("MicroMsg.FavoriteLogic", "setUsedCapacity:%d", new Object[]{Long.valueOf(j)});
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uBY, Long.valueOf(j));
    }

    public static void cc(long j) {
        w.i("MicroMsg.FavoriteLogic", "setTotalCapacity:%d", new Object[]{Long.valueOf(j)});
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uBZ, Long.valueOf(j));
    }

    public static long atE() {
        long atF = atF() - atG();
        if (atF < 0) {
            return AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        }
        return atF;
    }

    public static long atF() {
        ap.yY();
        return ((Long) c.vr().get(com.tencent.mm.storage.w.a.uBZ, Long.valueOf(0))).longValue();
    }

    public static long atG() {
        ap.yY();
        return ((Long) c.vr().get(com.tencent.mm.storage.w.a.uBY, Long.valueOf(0))).longValue();
    }

    public static boolean atH() {
        if (atF() != 0 && atE() < 10485760) {
            return true;
        }
        return false;
    }

    public static boolean atI() {
        if (atF() != 0 && atE() < 52428800) {
            return true;
        }
        return false;
    }

    public static long atJ() {
        return ab.getContext().getSharedPreferences(ab.bIX(), 0).getLong("fav_mx_auto_download_size", 26214400);
    }

    public static void cd(long j) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putLong("fav_mx_auto_download_size", j).commit();
    }

    public static long atK() {
        long j = ab.getContext().getSharedPreferences(ab.bIX(), 0).getLong("fav_mx_auto_upload_size", 0);
        if (j == 0) {
            return 26214400;
        }
        return j;
    }

    public static void ce(long j) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putLong("fav_mx_auto_upload_size", j).commit();
    }

    public static void cf(long j) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putLong("fav_mx_file_size", j).commit();
    }

    public static String U(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static void a(List<j> list, String[] strArr) {
        if (list != null && !list.isEmpty() && strArr != null && strArr.length > 0) {
            List<j> linkedList = new LinkedList();
            for (j jVar : list) {
                int i = 0;
                for (String vQ : strArr) {
                    i |= jVar.vQ(vQ);
                }
                if (i != 0) {
                    h.ata().a(jVar, "localId");
                    q(jVar);
                    linkedList.add(jVar);
                }
            }
            for (j jVar2 : linkedList) {
                y.a(jVar2, 3);
            }
        }
    }

    public static void a(j jVar, Collection<String> collection, int i) {
        if (jVar != null) {
            w.d("MicroMsg.FavoriteLogic", "mod tags %s", new Object[]{collection});
            Set hashSet = new HashSet();
            hashSet.addAll(jVar.field_tagProto.tzx);
            jVar.field_tagProto.tzx.clear();
            if (!(collection == null || collection.isEmpty())) {
                jVar.field_tagProto.tzx.addAll(collection);
                hashSet.removeAll(collection);
            }
            h.ata().a(jVar, "localId");
            q(jVar);
            h.asT().d(hashSet);
            y.a(jVar, i);
        }
    }

    public static String a(Context context, List<String> list) {
        if (context == null || list == null || list.isEmpty()) {
            return "";
        }
        String str = (String) list.get(0);
        String string = context.getResources().getString(R.l.ejD);
        int i = 1;
        while (i < list.size()) {
            String str2 = str + string + ((String) list.get(i));
            i++;
            str = str2;
        }
        return str;
    }

    public static String w(Context context, int i) {
        if (context == null) {
            return "";
        }
        switch (i) {
            case 1:
                return context.getString(R.l.eju);
            case 2:
                return context.getString(R.l.ejw);
            case 3:
                return context.getString(R.l.ejC);
            case 4:
                return context.getString(R.l.ejB);
            case 5:
                return context.getString(R.l.ejA);
            case 6:
                return context.getString(R.l.ejx);
            case 7:
                return context.getString(R.l.ejy);
            case 8:
                return context.getString(R.l.ejv);
            default:
                return "";
        }
    }

    public static Integer T(Context context, String str) {
        if (context == null) {
            return Integer.valueOf(-1);
        }
        if (context.getString(R.l.ejw).equals(str)) {
            return Integer.valueOf(2);
        }
        if (context.getString(R.l.ejy).equals(str)) {
            return Integer.valueOf(7);
        }
        if (context.getString(R.l.ejx).equals(str)) {
            return Integer.valueOf(6);
        }
        if (context.getString(R.l.eju).equals(str)) {
            return Integer.valueOf(1);
        }
        if (context.getString(R.l.ejB).equals(str)) {
            return Integer.valueOf(4);
        }
        if (context.getString(R.l.ejA).equals(str)) {
            return Integer.valueOf(5);
        }
        if (context.getString(R.l.ejC).equals(str)) {
            return Integer.valueOf(3);
        }
        if (context.getString(R.l.ejv).equals(str)) {
            return Integer.valueOf(8);
        }
        return Integer.valueOf(-1);
    }

    public static String eL(String str) {
        ap.yY();
        com.tencent.mm.storage.x Rc = c.wR().Rc(str);
        if (Rc == null) {
            w.w("MicroMsg.FavoriteLogic", "wtf get contact null, username %s", new Object[]{str});
            return "";
        }
        String tL = Rc.tL();
        if (!com.tencent.mm.u.o.dH(tL)) {
            return tL;
        }
        List eA = j.eA(str);
        String xL = m.xL();
        if (eA == null || eA.isEmpty()) {
            w.w("MicroMsg.FavoriteLogic", "get members from username error, content empty");
            return tL;
        }
        eA.remove(xL);
        eA.add(0, xL);
        return j.b(eA, 3);
    }

    public static void cg(long j) {
        lFf = j;
    }

    public static void atL() {
        if (0 >= lFf) {
            w.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            return;
        }
        j bT = h.ata().bT(lFf);
        lFf = 0;
        if (bT == null) {
            w.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            return;
        }
        w.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav ,go on");
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", bT.field_localId);
        d.b(ab.getContext(), "favorite", ".ui.FavTagEditUI", intent);
    }

    public static boolean s(j jVar) {
        if (jVar == null) {
            return false;
        }
        if (jVar.field_itemStatus == 8 || jVar.field_itemStatus == 10 || jVar.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static List<Long> atM() {
        k ata = h.ata();
        long currentTimeMillis = System.currentTimeMillis();
        List<Long> arrayList = new ArrayList();
        String str = "select localId from FavItemInfo where ";
        String str2 = "";
        int[] iArr = lFi;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = (str + " itemStatus in (" + str2 + ")") + " and datatotalsize > 0 ";
        str2 = "";
        iArr = lFh;
        length = iArr.length;
        i = 0;
        while (i < length) {
            i++;
            str2 = str2 + iArr[i] + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = ata.gUz.rawQuery((str + " and type in (" + str2 + ")") + " order by datatotalsize desc", null);
        if (rawQuery == null) {
            return arrayList;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return arrayList;
        }
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        long currentTimeMillis2 = System.currentTimeMillis();
        w.i("MicroMsg.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        return arrayList;
    }

    public static List<j> f(List<j> list, List<Long> list2) {
        int i = 0;
        List<j> arrayList = new ArrayList();
        if (list2 == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            Long valueOf = Long.valueOf(((j) list.get(list.size() - 1)).field_localId);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (valueOf.equals(list2.get(i2))) {
                    i = i2 + 1;
                    break;
                }
            }
        }
        int i3 = i;
        while (i3 < i + 20 && i3 < list2.size()) {
            j bT = h.ata().bT(((Long) list2.get(i3)).longValue());
            if (bT != null) {
                arrayList.add(bT);
            }
            i3++;
        }
        return arrayList;
    }

    public static boolean mu(int i) {
        for (int i2 : lFi) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean mv(int i) {
        for (int i2 : lFh) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static j wc(String str) {
        j jVar = new j();
        jVar.field_localId = -1;
        jVar.field_id = -1;
        jVar.field_xml = str;
        jVar.field_type = 18;
        jVar.vO(str);
        return jVar;
    }

    public static void i(rm rmVar) {
        if (!bg.mA(rmVar.lKv)) {
            w.i("MicroMsg.FavoriteLogic", "restart cdndata download, dataId %s", new Object[]{rmVar.lKv});
            a vN = h.asV().vN(rmVar.lKv);
            if (vN != null && (vN.field_status == 3 || vN.field_status == 4)) {
                h.asV().b(vN, "dataId");
                vN = null;
            }
            if (vN == null || vN.field_type != 1) {
                File file = new File(g(rmVar));
                if (!bg.mA(rmVar.txk) && !bg.mA(rmVar.txi) && !file.exists()) {
                    w.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    j jVar = new j();
                    jVar.field_localId = -1;
                    jVar.field_id = -1;
                    jVar.field_type = 18;
                    a(rmVar, jVar, 1, true);
                    h.asU().wd(rmVar.lKv);
                    h.asU().run();
                    w.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return;
                }
                return;
            }
            w.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            vN.field_status = 1;
            h.asV().a(vN, "dataId");
            h.asU().wd(rmVar.lKv);
            h.asU().run();
        }
    }

    public static boolean t(j jVar) {
        if (jVar == null) {
            return false;
        }
        rm n = n(jVar);
        if (n == null) {
            return false;
        }
        int bbO;
        int i;
        boolean a;
        long NA = bg.NA();
        com.tencent.mm.plugin.sight.base.a Er = com.tencent.mm.plugin.sight.base.d.Er(g(n));
        if (Er != null) {
            bbO = Er.bbO();
            i = n.duration;
            if (i <= 0 || Math.abs(i - bbO) >= 2) {
                n.ya(bbO);
                a = h.ata().a(jVar, "localId");
            } else {
                a = false;
            }
        } else {
            a = false;
            i = 0;
            bbO = 0;
        }
        w.i("MicroMsg.FavoriteLogic", "repair video duration[%d TO %d] %b cost time %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bbO), Boolean.valueOf(a), Long.valueOf(bg.aB(NA))});
        return a;
    }

    public static void a(af afVar) {
        if (afVar.hsK != null && afVar.hsK.zg() != null && afVar.hsK.zg().sZC == -435) {
            j bU = h.ata().bU((long) afVar.lFF);
            if (bU != null && bU.field_favProto != null && bU.field_favProto.tzn != null) {
                bU.field_favProto.yi(bU.field_favProto.version + 2);
                bU.field_itemStatus = 1;
                h.ata().a(bU, "localId");
                h.asR().run();
            }
        }
    }

    public static void e(String str, Context context) {
        String lI = t.lI(str);
        w.i("MicroMsg.FavoriteLogic", "save video now video path %s out path %s", new Object[]{str, lI});
        if (bg.mA(lI)) {
            Toast.makeText(context, context.getString(R.l.fal), 1).show();
            return;
        }
        Toast.makeText(context, context.getString(R.l.fam, new Object[]{lI}), 1).show();
        k.b(lI, context);
    }

    public static boolean a(List<j> list, Context context, OnClickListener onClickListener) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        q qVar = new q();
        int i = 0;
        int i2 = 0;
        Object obj = null;
        int i3 = 0;
        int i4 = 0;
        for (j jVar : list) {
            if (!(jVar == null || jVar.field_favProto == null || jVar.field_favProto.tzn == null)) {
                if (jVar.field_type == 3) {
                    i2++;
                } else {
                    Object obj2;
                    Iterator it = jVar.field_favProto.tzn.iterator();
                    int i5 = 0;
                    int i6 = i;
                    i = i4;
                    while (it.hasNext()) {
                        rm rmVar = (rm) it.next();
                        if (rmVar.tyq == 2) {
                            i6++;
                        } else if (rmVar.tyq == 1) {
                            i++;
                        } else {
                            i5++;
                        }
                    }
                    if (q.h(jVar)) {
                        i4 = i3 + 1;
                        if (i5 > 0) {
                            i5--;
                        }
                    } else {
                        i4 = i3;
                    }
                    if (obj == null && r7 == jVar.field_favProto.tzn.size()) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    obj = obj2;
                    i3 = i4;
                    i4 = i;
                    i = i6;
                }
            }
        }
        if (1 == list.size()) {
            if (((j) list.get(0)).field_type == 14 && (i > 0 || i4 > 0)) {
                com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ehI));
                return false;
            } else if (i > 0) {
                com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ehJ));
                return false;
            } else if (i4 > 0) {
                switch (((j) list.get(0)).field_type) {
                    case 2:
                        com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ehL));
                        break;
                    case 4:
                    case 16:
                        com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ehM));
                        break;
                    case 8:
                        com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ehK));
                        break;
                }
                return false;
            } else if (i3 > 0) {
                com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dAL));
                return false;
            } else if (i2 > 0) {
                com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dAM));
                return false;
            }
        } else if (i > 0 || i4 > 0 || i3 > 0 || i2 > 0) {
            if (obj != null) {
                com.tencent.mm.ui.base.g.a(context, context.getString(R.l.ehO), "", context.getString(R.l.dXk), context.getString(R.l.dXi), onClickListener, null, R.e.aWu);
            } else {
                com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ehN));
            }
            return false;
        }
        return true;
    }

    public static boolean u(j jVar) {
        Iterator it = jVar.field_favProto.tzn.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (rmVar.tyq == 2) {
                return true;
            }
            if (rmVar.tyq == 1) {
                return true;
            }
        }
        return false;
    }

    public static j ch(long j) {
        j jVar = new j();
        jVar.field_type = 18;
        jVar.field_sourceType = 6;
        String xL = m.xL();
        rw rwVar = new rw();
        rwVar.OD(xL);
        rwVar.OE(xL);
        rwVar.yj(jVar.field_sourceType);
        rwVar.ep(bg.Nz());
        jVar.field_favProto.a(rwVar);
        jVar.field_fromUser = rwVar.fOu;
        jVar.field_toUser = rwVar.toUser;
        jVar.field_favProto.yi(1);
        jVar.field_favProto.yh(127);
        jVar.field_edittime = bg.Ny();
        jVar.field_updateTime = bg.Nz();
        jVar.field_favProto.eo(jVar.field_edittime);
        jVar.field_favProto.tzl.ep(bg.Nz());
        jVar.field_itemStatus = 9;
        jVar.field_localId = j;
        h.ata().c(jVar);
        return jVar;
    }

    public static boolean v(j jVar) {
        if (h.ata().bT(jVar.field_localId) != null) {
            return true;
        }
        return false;
    }
}
