package com.tencent.mm.plugin.exdevice.f.a;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class e {
    public static void a(final Context context, final ImageView imageView, final String str, final int i) {
        Assert.assertTrue(imageView != null);
        if (af.isMainThread()) {
            b(imageView, str, i);
        } else {
            af.v(new Runnable() {
                public final void run() {
                    e.b(imageView, str, i);
                }
            });
        }
    }

    public static void b(ImageView imageView, String str, int i) {
        if (bg.mA(str) || "#".equals(str)) {
            w.d("MicroMsg.ExdeviceRankUtil", "hy: url is null or nill. set to default picture resource");
            imageView.setImageResource(i);
            return;
        }
        w.d("MicroMsg.ExdeviceRankUtil", "hy: set url to %s", new Object[]{str});
        ad.apw().a(str, imageView, ad.uY(str));
    }

    public static void b(final MMActivity mMActivity) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(mMActivity.getString(R.l.efA));
        linkedList2.add(Integer.valueOf(0));
        g.a(mMActivity, "", linkedList, linkedList2, null, true, new d() {
            public final void bN(int i, int i2) {
                switch (i2) {
                    case 0:
                        Context context = mMActivity;
                        Intent intent = new Intent();
                        intent.putExtra("query_source_type", 9);
                        intent.putExtra("query_media_type", 1);
                        intent.putExtra("max_select_count", 1);
                        com.tencent.mm.bb.d.b(context, "gallery", ".ui.AlbumPreviewUI", intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public static boolean a(MMActivity mMActivity, int i, int i2, Intent intent, String str) {
        if (i == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                return false;
            }
            String str2 = (String) stringArrayListExtra.get(0);
            Intent intent2 = new Intent();
            intent2.putExtra("CropImageMode", 1);
            intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.gSH + "temp.cover");
            intent2.putExtra("CropImage_ImgPath", str2);
            com.tencent.mm.bb.d.a(mMActivity, ".ui.tools.CropImageNewUI", intent2, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
            return true;
        } else if (i != MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED || i2 != -1) {
            return false;
        } else {
            String va = d.va(com.tencent.mm.compatible.util.e.gSH + "temp.cover");
            a apD = ad.apD();
            apD.appName = str;
            long currentTimeMillis = System.currentTimeMillis();
            apD.lfn = com.tencent.mm.modelcdntran.d.a("uploadexdeivce", currentTimeMillis, m.yr().field_username, String.valueOf(currentTimeMillis));
            String str3 = apD.lfn;
            h hVar = new h();
            hVar.hze = apD;
            hVar.field_mediaId = str3;
            hVar.field_fullpath = va;
            hVar.field_thumbpath = "";
            hVar.field_fileType = b.hxU;
            hVar.field_talker = "";
            hVar.field_priority = b.hxK;
            hVar.field_needStorage = true;
            hVar.field_isStreamMedia = false;
            hVar.field_appType = com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX;
            hVar.field_bzScene = 2;
            if (!com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                w.e("MicroMsg.ExdevicePictureUploader", "hy: cdntra addSendTask failed. clientid:%s", new Object[]{str3});
            }
            return true;
        }
    }
}
