package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.a.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.InputStream;
import java.util.Map;
import junit.framework.Assert;

public final class c {
    a weJ;

    c(a aVar) {
        this.weJ = aVar;
    }

    public final int a(d dVar) {
        boolean z = true;
        Assert.assertTrue(dVar != null);
        if (dVar.weL == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Drawable a = a(this.weJ.sHh, dVar.weK.getContext());
        if (a == null) {
            return -1;
        }
        dVar.weK.setBackgroundDrawable(a);
        dVar.weL.setVisibility(this.weJ.sHc ? 0 : 8);
        return 0;
    }

    private static Drawable a(Map<String, String> map, Context context) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str = (String) map.get(displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        if (str == null) {
            b bVar = new b();
            displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            str = displayMetrics.density < 1.0f ? str2 + "LDPI" : displayMetrics.density >= DownloadHelper.SAVE_FATOR ? str2 + "HDPI" : str2 + "MDPI";
            str = (String) map.get(str + (configuration.orientation == 2 ? "_L" : "_P"));
        }
        if (u.mz(str).length() <= 0) {
            return null;
        }
        a.a MA = a.MA(str);
        if (MA == a.a.ERROR) {
            return null;
        }
        str = a.Mz(str);
        if (u.mz(str).length() <= 0) {
            return null;
        }
        try {
            Bitmap a;
            float density;
            if (MA == a.a.ASSET) {
                InputStream open = context.getAssets().open(str);
                density = com.tencent.mm.bg.a.getDensity(context);
                b bVar2 = new b();
                a = d.a(open, density);
            } else {
                float density2 = com.tencent.mm.bg.a.getDensity(context);
                b bVar3 = new b();
                density = 160.0f * density2;
                a = d.d(str, density2);
                if (a != null) {
                    a.setDensity((int) density);
                }
            }
            if (a == null) {
                w.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + MA + " path:" + str);
                return null;
            }
            byte[] ninePatchChunk = a.getNinePatchChunk();
            if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new NinePatchDrawable(a, ninePatchChunk, new Rect(), null);
            }
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, displayMetrics2.widthPixels, (displayMetrics2.widthPixels * a.getHeight()) / a.getWidth(), true);
            if (createScaledBitmap != null) {
                if (a != createScaledBitmap) {
                    w.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", a);
                    a.recycle();
                }
                a = createScaledBitmap;
            }
            Drawable bitmapDrawable = new BitmapDrawable(a);
            bitmapDrawable.setTargetDensity(displayMetrics2);
            return bitmapDrawable;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ADListView.Message", e, "", new Object[0]);
            return null;
        }
    }
}
