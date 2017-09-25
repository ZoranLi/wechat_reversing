package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.af.a.a;
import com.tencent.mm.plugin.af.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.q;
import java.io.File;

public final class k {
    private static String filePath = null;

    public static boolean a(Fragment fragment, Intent intent, String str, int i) {
        Parcelable sightParams = new SightParams(1, i);
        String lu = s.lu(str);
        o.KV();
        String lv = s.lv(lu);
        o.KV();
        sightParams.h(lu, lv, s.lw(lu), e.gSz + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        d.a(fragment, "mmsight", ".ui.SightCaptureUI", intent, (int) n.CTRL_INDEX);
        fragment.aG().overridePendingTransition(a.rai, -1);
        return true;
    }

    public static boolean w(Context context, Intent intent) {
        return a(context, 17, intent, 2, 0);
    }

    public static boolean a(Context context, int i, Intent intent, int i2, int i3) {
        return a(context, i, intent, i2, "", i3);
    }

    public static boolean a(Context context, int i, Intent intent, int i2, String str, int i3) {
        Parcelable parcelable = null;
        if (intent != null) {
            parcelable = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (parcelable == null) {
            parcelable = new SightParams(i2, i3);
        }
        if (i2 == 1) {
            String lu = s.lu(str);
            o.KV();
            String lv = s.lv(lu);
            o.KV();
            parcelable.h(lu, lv, s.lw(lu), e.gSz + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        }
        if (parcelable == null) {
            w.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        }
        intent.putExtra("KEY_SIGHT_PARAMS", parcelable);
        d.b(context, "mmsight", ".ui.SightCaptureUI", intent, i);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(a.rai, -1);
        }
        return true;
    }

    public static boolean a(q qVar, String str, String str2) {
        w.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(bh.CTRL_INDEX), Boolean.valueOf(a(qVar, str, str2, (int) bh.CTRL_INDEX)));
        return a(qVar, str, str2, (int) bh.CTRL_INDEX);
    }

    private static boolean a(q qVar, String str, String str2, int i) {
        if (com.tencent.mm.n.a.aI(qVar.uSU.uTo) || com.tencent.mm.n.a.aH(qVar.uSU.uTo)) {
            return false;
        }
        filePath = str + str2;
        w.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
        aY(qVar.uSU.uTo, filePath);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TakePhotoUtil", e, "", new Object[0]);
            }
        }
        if (file.exists()) {
            intent.putExtra("output", Uri.fromFile(new File(filePath)));
            try {
                qVar.startActivityForResult(intent, bh.CTRL_INDEX);
                return true;
            } catch (ActivityNotFoundException e2) {
                w.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                return false;
            }
        }
        w.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. " + str);
        return false;
    }

    public static boolean c(Activity activity, String str, String str2, int i) {
        w.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(i), Boolean.valueOf(d(activity, str, str2, i)));
        return d(activity, str, str2, i);
    }

    private static boolean d(Activity activity, String str, String str2, int i) {
        if (com.tencent.mm.n.a.aI(activity) || com.tencent.mm.n.a.aH(activity)) {
            return false;
        }
        filePath = str + str2;
        w.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
        aY(activity, filePath);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TakePhotoUtil", e, "", new Object[0]);
            }
        }
        if (file.exists()) {
            intent.putExtra("output", Uri.fromFile(new File(filePath)));
            try {
                activity.startActivityForResult(intent, i);
                return true;
            } catch (Exception e2) {
                w.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                return false;
            }
        }
        w.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. " + str);
        return false;
    }

    private static void aY(Context context, String str) {
        Editor edit = context.getSharedPreferences("system_config_prefs", 0).edit();
        edit.putString("camera_file_path", str);
        edit.commit();
    }

    public static boolean a(Activity activity, int i, Intent intent) {
        a(activity, i, 1, 0, intent);
        return true;
    }

    public static boolean V(Activity activity) {
        a(activity, 2, 1, 0, 1, false, null);
        return true;
    }

    public static boolean W(Activity activity) {
        a(activity, (int) cf.CTRL_INDEX, 1, 11, null);
        return true;
    }

    public static boolean k(Fragment fragment) {
        a(fragment, (int) m.CTRL_INDEX, 1, 0, 1, "", "");
        return true;
    }

    public static boolean X(Activity activity) {
        a(activity, 2, 1, 5, null);
        return true;
    }

    public static void a(Fragment fragment, int i, String str, String str2) {
        a(fragment, (int) b.CTRL_INDEX, 9, i, 1, str, str2);
    }

    public static void b(Fragment fragment, int i, String str, String str2) {
        a(fragment, (int) b.CTRL_INDEX, 9, i, 3, str, str2);
    }

    public static void a(Activity activity, int i, int i2, int i3, Intent intent) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.addFlags(67108864);
        d.b(activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
    }

    public static void a(Activity activity, int i, int i2, int i3, int i4, boolean z, Intent intent) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.putExtra("query_media_type", i4);
        intent2.putExtra("show_header_view", z);
        intent2.addFlags(67108864);
        d.b(activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
    }

    public static void Y(Activity activity) {
        a(activity, 2, 1, 10, 1, true, null);
    }

    private static void a(Fragment fragment, int i, int i2, int i3, int i4, String str, String str2) {
        Intent intent = new Intent();
        if (!bg.mA(str2)) {
            intent.putExtra("GalleryUI_FromUser", str);
            intent.putExtra("GalleryUI_ToUser", str2);
        }
        intent.putExtra("max_select_count", i2);
        intent.putExtra("query_source_type", i3);
        intent.putExtra("query_media_type", i4);
        if (r.ijS) {
            intent.putExtra("show_header_view", true);
        } else {
            intent.putExtra("show_header_view", false);
        }
        intent.addFlags(67108864);
        d.a(fragment, "gallery", ".ui.AlbumPreviewUI", intent, i);
    }

    public static void c(Activity activity, int i, int i2, Intent intent) {
        intent.putExtra("max_select_count", i);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("query_source_type", i2);
        intent.addFlags(67108864);
        d.b(activity, "gallery", ".ui.GalleryEntryUI", intent, 4);
    }

    public static void a(Activity activity, String str, int i, int i2, int i3, boolean z) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        Intent intent = new Intent();
        intent.putExtra("output", Uri.fromFile(file));
        intent.putExtra("android.intent.extra.videoQuality", i3);
        intent.putExtra("android.intent.extras.CAMERA_FACING", z ? 1 : 0);
        if (i2 > 0) {
            intent.putExtra("android.intent.extra.durationLimit", i2);
        }
        intent.setAction("android.media.action.VIDEO_CAPTURE");
        intent.addCategory("android.intent.category.DEFAULT");
        activity.startActivityForResult(intent, i);
    }

    public static String b(Context context, Intent intent, String str) {
        if (filePath == null) {
            filePath = context.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
        }
        if (filePath == null || !com.tencent.mm.a.e.aO(filePath)) {
            filePath = com.tencent.mm.ui.tools.a.c(context, intent, str);
        }
        com.tencent.mm.platformtools.d.b(filePath, context);
        return filePath;
    }

    public static void h(String str, Context context) {
        com.tencent.mm.platformtools.d.a(str, context, h.rao);
    }

    public static String mr(String str) {
        return com.tencent.mm.platformtools.d.mr(str);
    }

    public static void b(String str, Context context) {
        com.tencent.mm.platformtools.d.b(str, context);
    }

    @TargetApi(8)
    public static String bGD() {
        return e.gSz;
    }

    public static String Nk() {
        return com.tencent.mm.platformtools.d.Nk();
    }
}
