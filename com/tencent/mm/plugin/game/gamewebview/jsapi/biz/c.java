package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import java.io.File;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_BYTE = 274;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "addToEmoticon";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        w.i("MicroMsg.GameJsApiAddToEmotion", "invoke");
        JSONObject pb = d.pb(str);
        if (pb == null) {
            w.e("MicroMsg.GameJsApiAddToEmotion", "bundle is null");
            aVar.pq(a.d("addToEmoticon:fail_null_data", null));
            return;
        }
        String optString = pb.optString("base64DataString");
        final String optString2 = pb.optString("thumbUrl");
        final String optString3 = pb.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (!bg.mA(optString)) {
            w.i("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon use base64DataString");
            int indexOf = optString.indexOf(";base64,");
            String str2 = "";
            if (indexOf != -1) {
                str2 = optString.substring(indexOf + 8, optString.length());
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (bg.bm(decode)) {
                    aVar.pq(a.d("addToEmoticon:fail", null));
                    return;
                }
                optString = g.n(decode);
                ap.yY();
                optString3 = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", optString);
                if (!(e.aO(optString3) && g.aV(optString3).equalsIgnoreCase(optString))) {
                    e.b(optString3, decode, decode.length);
                }
                a(context, optString, optString2, aVar);
            } catch (Exception e) {
                w.e("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon error:" + e.getMessage());
                aVar.pq(a.d("addToEmoticon:fail", null));
            }
        } else if (bg.mA(optString3)) {
            w.e("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
            aVar.pq(a.d("addToEmoticon:fail_base64DataString_and_url_is_null", null));
        } else {
            w.i("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[]{optString3});
            File file = new File(context.getCacheDir(), g.n(optString3.getBytes()));
            if (file.exists()) {
                optString = g.f(file);
                ap.yY();
                optString3 = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", optString);
                if (!FileOp.aO(optString3)) {
                    FileOp.p(file.getAbsolutePath(), optString3);
                }
                a(context, optString, optString2, aVar);
                return;
            }
            com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIL = true;
            aVar2.hIN = file.getAbsolutePath();
            aVar2.hJm = new Object[]{file.getAbsolutePath()};
            final Context context2 = context;
            final GameJsApiMMTask.a aVar3 = aVar;
            h.alV().a(optString3, null, aVar2.Hg(), new i(this) {
                final /* synthetic */ c mkd;

                public final void a(String str, Bitmap bitmap, Object... objArr) {
                    w.i("MicroMsg.GameJsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
                    GameJsApiMMTask.a aVar;
                    c cVar;
                    if (bitmap == null || objArr == null || objArr.length <= 0) {
                        aVar = aVar3;
                        cVar = this.mkd;
                        aVar.pq(a.d("addToEmoticon:fail", null));
                    } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                        aVar = aVar3;
                        cVar = this.mkd;
                        aVar.pq(a.d("addToEmoticon:fail", null));
                    } else if (str.equals(optString3)) {
                        File file = new File(objArr[0].toString());
                        if (file.exists()) {
                            String f = g.f(file);
                            ap.yY();
                            FileOp.p(file.getAbsolutePath(), EmojiLogic.D(com.tencent.mm.u.c.xi(), "", f));
                            this.mkd.a(context2, f, optString2, aVar3);
                            return;
                        }
                        aVar = aVar3;
                        cVar = this.mkd;
                        aVar.pq(a.d("addToEmoticon:fail", null));
                    } else {
                        aVar = aVar3;
                        cVar = this.mkd;
                        aVar.pq(a.d("addToEmoticon:fail", null));
                    }
                }
            });
        }
    }

    public final void a(Context context, String str, String str2, GameJsApiMMTask.a aVar) {
        ap.yY();
        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", str);
        com.tencent.mm.storage.a.c Si = h.amc().kLa.Si(str);
        if (Si == null && e.aO(D)) {
            int i = o.Pj(D) ? com.tencent.mm.storage.a.c.uLa : com.tencent.mm.storage.a.c.uKZ;
            com.tencent.mm.storage.a.c cVar = new com.tencent.mm.storage.a.c();
            cVar.field_md5 = str;
            cVar.field_catalog = com.tencent.mm.storage.a.c.uKT;
            cVar.field_type = i;
            cVar.field_size = e.aN(D);
            cVar.field_temp = 1;
            cVar.field_thumbUrl = str2;
            h.amc().kLa.r(cVar);
            Si = cVar;
        }
        if (Si != null) {
            w.i("MicroMsg.GameJsApiAddToEmotion", "doAddAction %b", new Object[]{Boolean.valueOf(h.alY().a(context, Si, 18, m.xL()))});
            if (h.alY().a(context, Si, 18, m.xL())) {
                aVar.pq(a.d("addToEmoticon:ok", null));
                return;
            } else {
                aVar.pq(a.d("addToEmoticon:fail", null));
                return;
            }
        }
        aVar.pq(a.d("addToEmoticon:fail", null));
    }
}
