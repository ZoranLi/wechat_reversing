package com.tencent.mm.plugin.favorite.b;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.favorite.c.a;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class m {
    public static boolean a(String str, LinkedList<rm> linkedList, long j) {
        if (str.length() == 0) {
            w.e("MicroMsg.FavPostLogic", "postNote null");
            return false;
        }
        j a;
        if (-1 == j) {
            a = a(linkedList, j);
        } else {
            a = h.ata().bT(j);
        }
        a.w(a);
        return true;
    }

    public static j a(LinkedList<rm> linkedList, long j) {
        j jVar = null;
        if (j != -1) {
            jVar = h.ata().bT(j);
            if (jVar == null) {
                jVar = x.ch(j);
            }
            jVar.field_favProto.tzn.clear();
        }
        if (jVar == null) {
            jVar = new j();
            jVar.field_type = 18;
            jVar.field_sourceType = 6;
            f(jVar);
            jVar.field_favProto.yi(1);
            jVar.field_favProto.yh(127);
        }
        jVar.field_edittime = bg.Ny();
        jVar.field_updateTime = bg.Nz();
        jVar.field_favProto.eo(jVar.field_edittime);
        jVar.field_favProto.tzl.ep(bg.Nz());
        jVar.field_favProto.av(linkedList);
        return jVar;
    }

    private static List<String> as(List<String> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        List<String> arrayList = new ArrayList();
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        for (String str : list) {
            try {
                InputStream openRead = FileOp.openRead(str);
                if (openRead != null) {
                    if (MMBitmapFactory.checkIsImageLegal(openRead, decodeResultLogger)) {
                        arrayList.add(str);
                    } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        g.oUh.A(12712, KVStatHelper.getKVStatString(openRead, 5, decodeResultLogger));
                    }
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    public static boolean at(List<String> list) {
        List<String> as = as(list);
        if (as == null || as.size() == 0) {
            w.e("MicroMsg.FavPostLogic", "postImgs path null");
            return false;
        }
        j jVar = new j();
        jVar.field_type = 2;
        jVar.field_sourceType = 6;
        f(jVar);
        for (String str : as) {
            rm rmVar = new rm();
            rmVar.NZ(str);
            rmVar.NY(x.aS(rmVar.toString(), 2));
            d.b(str, ck.CTRL_INDEX, ck.CTRL_INDEX, CompressFormat.JPEG, 90, x.h(rmVar));
            rmVar.Oa(x.h(rmVar));
            rmVar.yb(2);
            jVar.field_favProto.tzn.add(rmVar);
        }
        a.w(jVar);
        g.oUh.i(10648, new Object[]{Integer.valueOf(2), Integer.valueOf(as.size())});
        return true;
    }

    public static void f(j jVar) {
        String xL = com.tencent.mm.u.m.xL();
        rw rwVar = new rw();
        rwVar.OD(xL);
        rwVar.OE(xL);
        rwVar.yj(jVar.field_sourceType);
        rwVar.ep(bg.Nz());
        jVar.field_favProto.a(rwVar);
        jVar.field_fromUser = rwVar.fOu;
        jVar.field_toUser = rwVar.toUser;
    }
}
