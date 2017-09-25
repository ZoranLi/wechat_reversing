package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class a {
    public static boolean b(Context context, String str, int i) {
        if (context == null || str == null) {
            w.e("MicroMsg.AppBrandShortcutManager", "add fail, invalid argument");
            return false;
        }
        b bpVar = new bp();
        bpVar.fEY.username = str;
        com.tencent.mm.sdk.b.a.urY.m(bpVar);
        if (bpVar.fEZ.fFb == null) {
            w.e("MicroMsg.AppBrandShortcutManager", "no such user");
            return false;
        }
        Bitmap a = a(bpVar);
        if (a == null) {
            w.i("MicroMsg.AppBrandShortcutManager", "bitmap do not exist, delay get.");
            return true;
        }
        Intent a2 = a(context, bpVar, i, a(context, a, i), true);
        if (a2 == null) {
            w.e("MicroMsg.AppBrandShortcutManager", "add fail, intent is null");
            return false;
        }
        String bp;
        if (((Intent) a2.getParcelableExtra("android.intent.extra.shortcut.INTENT")) != null) {
            bp = c.bp(bpVar.fEZ.appId + String.valueOf(i), p.rA());
            if (bp != null) {
                bp = c.U(bp.getBytes());
            } else {
                bp = null;
            }
            w.i("MicroMsg.AppBrandShortcutManager", "alvinluo appId: %s, shortcutId: %s", r4, bp);
        } else {
            bp = null;
        }
        c.a(context, a2, bp, true);
        w.i("MicroMsg.AppBrandShortcutManager", "add shortcut %s", str);
        return true;
    }

    public static Intent a(Context context, bp bpVar, int i, Bitmap bitmap, boolean z) {
        if (context == null || bpVar.fEY.username == null) {
            w.e("MicroMsg.AppBrandShortcutManager", "buildIntent, wrong parameters");
            return null;
        } else if (bitmap == null && z) {
            w.e("MicroMsg.AppBrandShortcutManager", "no bmp");
            return null;
        } else {
            String str = bpVar.fEY.username;
            String str2 = TextUtils.isEmpty(bpVar.fEZ.fFa) ? str : bpVar.fEZ.fFa;
            String str3 = bpVar.fEZ.appId;
            String rO = rO(str);
            if (bg.mA(rO)) {
                return null;
            }
            str = z ? "com.android.launcher.action.INSTALL_SHORTCUT" : "com.android.launcher.action.UNINSTALL_SHORTCUT";
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : bpVar.fEZ.fFb) {
                stringBuilder.append(append);
            }
            String n = g.n((str2 + stringBuilder.toString()).getBytes());
            Intent intent = new Intent(str);
            intent.putExtra("android.intent.extra.shortcut.NAME", str2);
            intent.putExtra("duplicate", false);
            Parcelable intent2 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
            intent2.putExtra(Columns.TYPE, 1);
            intent2.putExtra(SlookAirButtonFrequentContactAdapter.ID, rO);
            intent2.putExtra("ext_info", rO(str3));
            StringBuilder stringBuilder2 = new StringBuilder();
            ap.yY();
            intent2.putExtra("token", bo(str3, stringBuilder2.append(c.uH()).toString()));
            intent2.putExtra("digest", n);
            intent2.putExtra("ext_info_1", i);
            intent2.setPackage(context.getPackageName());
            intent2.addFlags(67108864);
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            return intent;
        }
    }

    public static Bitmap a(bp bpVar) {
        Bitmap bitmap = null;
        for (String str : bpVar.fEZ.fFb) {
            if (!bg.mA(str)) {
                bitmap = com.tencent.mm.modelappbrand.a.b.AY().gN(str);
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
            }
        }
        return bitmap;
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        if (!(context == null || bitmap == null || bitmap.isRecycled())) {
            int density = (int) (com.tencent.mm.bg.a.getDensity(context) * 48.0f);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, density, density, false);
            if (createScaledBitmap != null) {
                bitmap2 = createScaledBitmap.copy(Config.ARGB_8888, true);
                createScaledBitmap.recycle();
            }
            if (i == 2) {
                a(context, bitmap2, com.tencent.mm.bg.a.V(context, R.l.dGd));
            } else if (i == 1) {
                a(context, bitmap2, com.tencent.mm.bg.a.V(context, R.l.dGe));
            }
        }
        return bitmap2;
    }

    private static void a(Context context, Bitmap bitmap, String str) {
        if (context != null && bitmap != null && !bitmap.isRecycled() && !bg.mA(str)) {
            int width = bitmap.getWidth();
            float density = com.tencent.mm.bg.a.getDensity(context);
            float f = 4.0f * density;
            float f2 = density * 2.0f;
            density *= 6.0f;
            Paint paint = new Paint();
            paint.setTextSize(density);
            paint.setFakeBoldText(true);
            paint.setAntiAlias(true);
            density = paint.measureText(str);
            FontMetrics fontMetrics = paint.getFontMetrics();
            float f3 = fontMetrics.bottom - fontMetrics.top;
            paint.setColor(Color.parseColor("#459AE9"));
            Canvas canvas = new Canvas(bitmap);
            Rect rect = new Rect((int) ((((float) width) - density) - (f * 2.0f)), (width * 2) / 3, width, (int) ((f3 + ((float) ((width * 2) / 3))) + (f2 * 2.0f)));
            canvas.drawRect(rect, paint);
            paint.setColor(-1);
            canvas.drawText(str, ((float) rect.left) + f, (((float) rect.top) + f2) - fontMetrics.ascent, paint);
        }
    }

    public static String rN(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String q = bg.q(ab.getContext(), Process.myPid());
        w.i("MicroMsg.AppBrandShortcutManager", "process name: %s", q);
        if (str.startsWith("shortcut_")) {
            return c.bp(new String(c.rR(str.substring(9))), p.rA());
        }
        return str;
    }

    private static String rO(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String q = bg.q(ab.getContext(), Process.myPid());
        w.i("MicroMsg.AppBrandShortcutManager", "process name: %s", q);
        q = c.bp(str, p.rA());
        if (bg.mA(q)) {
            return null;
        }
        return "shortcut_" + c.U(q.getBytes());
    }

    public static String bo(String str, String str2) {
        return g.n((g.n(str.getBytes()) + c.bp(str2, str)).getBytes());
    }
}
