package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.u.x.a;
import com.tencent.mm.u.x.b;
import java.util.ArrayList;

public final class c implements k {
    public static i imv;
    public static h imw;

    public final void a(i iVar) {
        imv = iVar;
    }

    public static void j(Intent intent, Context context) {
        intent.putExtra("geta8key_scene", 14);
        imv.j(intent, context);
    }

    public static void a(long j, rs rsVar, String str, String str2, ArrayList<String> arrayList, Context context) {
        if (rsVar != null && context != null) {
            Intent intent = new Intent();
            intent.putExtra("KFavLocSigleView", true);
            intent.putExtra("map_view_type", 2);
            intent.putExtra("kFavInfoLocalId", j);
            intent.putExtra("kwebmap_slat", rsVar.lat);
            intent.putExtra("kwebmap_lng", rsVar.lng);
            intent.putExtra("kPoiName", rsVar.fRX);
            intent.putExtra("Kwebmap_locaion", rsVar.label);
            if (rsVar.fOd >= 0) {
                intent.putExtra("kwebmap_scale", rsVar.fOd);
            }
            intent.putExtra("kisUsername", str);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kRemark", str2);
            intent.putExtra("kTags", arrayList);
            intent.putExtra("kFavCanDel", true);
            intent.putExtra("kFavCanRemark", true);
            imv.o(intent, context);
        }
    }

    public static void c(String str, Context context) {
        if (bg.mA(str)) {
            w.w("MicroMsg.FavApplication", "share image to timeline fail, filePath is null");
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + m.xL() + "_0";
        String fQ = q.fQ(str2);
        q.yC().n(fQ, true).l("prePublishId", str2);
        intent.putExtra("reportSessionId", fQ);
        imv.a(str, intent, context);
    }

    public static void d(String str, Context context) {
        if (bg.mA(str)) {
            w.w("MicroMsg.FavApplication", "share image to friend fail, imgPath is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        imv.l(intent, context);
    }

    public static void a(String str, String str2, Context context) {
        if (bg.mA(str)) {
            w.w("MicroMsg.FavApplication", "save image fail, path is null");
        } else if (!d.a(str, context, R.l.eaX)) {
            Toast.makeText(context, str2, 1).show();
        }
    }

    public static String getAppName(Context context, String str) {
        b bVar = a.hlQ;
        if (bVar != null) {
            return bVar.m(context, str);
        }
        return "";
    }

    public final void a(h hVar) {
        imw = hVar;
    }

    public static String bP(long j) {
        if (j == 0) {
            return "0KB";
        }
        if ((((double) j) * 1.0d) / 1048576.0d >= 1.0d) {
            return String.format("%dMB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1048576.0d))});
        } else if ((((double) j) * 1.0d) / 1024.0d < 1.0d) {
            return "1KB";
        } else {
            return String.format("%dKB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1024.0d))});
        }
    }
}
