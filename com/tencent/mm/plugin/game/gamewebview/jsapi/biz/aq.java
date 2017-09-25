package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
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
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import org.json.JSONObject;

public final class aq extends a {
    public static final int CTRL_BYTE = 275;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "shareEmoticon";

    public final void a(final Context context, String str, final GameJsApiMMTask.a aVar) {
        w.i("MicroMsg.GameJsApiShareEmotion", "invoke");
        JSONObject pb = d.pb(str);
        if (pb == null) {
            w.e("MicroMsg.GameJsApiShareEmotion", "data is null");
            aVar.pq(a.d("shareEmoticon:fail_null_data", null));
            return;
        }
        String optString = pb.optString("base64DataString");
        final String optString2 = pb.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String D;
        if (bg.mA(optString)) {
            w.i("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon use url:%s", new Object[]{optString2});
            File file = new File(context.getCacheDir(), g.n(optString2.getBytes()));
            if (file.exists()) {
                optString2 = g.f(file);
                ap.yY();
                D = EmojiLogic.D(c.xi(), "", optString2);
                if (!FileOp.aO(D)) {
                    FileOp.p(file.getAbsolutePath(), D);
                }
                b(context, optString2, aVar);
                return;
            }
            com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIL = true;
            aVar2.hIN = file.getAbsolutePath();
            aVar2.hJm = new Object[]{file.getAbsolutePath()};
            h.alV().a(optString2, null, aVar2.Hg(), new i(this) {
                final /* synthetic */ aq mkX;

                public final void a(String str, Bitmap bitmap, Object... objArr) {
                    w.i("MicroMsg.GameJsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
                    GameJsApiMMTask.a aVar;
                    aq aqVar;
                    if (bitmap == null || objArr == null || objArr.length <= 0) {
                        aVar = aVar;
                        aqVar = this.mkX;
                        aVar.pq(a.d("shareEmoticon:fail", null));
                    } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                        aVar = aVar;
                        aqVar = this.mkX;
                        aVar.pq(a.d("shareEmoticon:fail", null));
                    } else if (str.equals(optString2)) {
                        File file = new File(objArr[0].toString());
                        if (file.exists()) {
                            String f = g.f(file);
                            ap.yY();
                            FileOp.p(file.getAbsolutePath(), EmojiLogic.D(c.xi(), "", f));
                            this.mkX.b(context, f, aVar);
                            return;
                        }
                        aVar = aVar;
                        aqVar = this.mkX;
                        aVar.pq(a.d("shareEmoticon:fail", null));
                    } else {
                        aVar = aVar;
                        aqVar = this.mkX;
                        aVar.pq(a.d("shareEmoticon:fail", null));
                    }
                }
            });
            return;
        }
        w.i("MicroMsg.GameJsApiShareEmotion", "use base64DataString");
        int indexOf = optString.indexOf(";base64,");
        optString2 = "";
        if (indexOf != -1) {
            optString2 = optString.substring(indexOf + 8, optString.length());
        }
        try {
            byte[] decode = Base64.decode(optString2, 0);
            if (bg.bm(decode)) {
                aVar.pq(a.d("shareEmoticon:fail", null));
                return;
            }
            optString = g.n(decode);
            ap.yY();
            D = EmojiLogic.D(c.xi(), "", optString);
            if (!(e.aO(D) && g.aV(D).equalsIgnoreCase(optString))) {
                e.b(D, decode, decode.length);
            }
            b(context, optString, aVar);
        } catch (Exception e) {
            w.e("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon error:" + e.getMessage());
            aVar.pq(a.d("shareEmoticon:fail_base64_decode_fail", null));
        }
    }

    public final void b(Context context, String str, final GameJsApiMMTask.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
        if (context instanceof MMActivity) {
            ((MMActivity) context).uSV = new MMActivity.a(this) {
                final /* synthetic */ aq mkX;

                public final void a(int i, int i2, Intent intent) {
                    w.i("MicroMsg.GameJsApiShareEmotion", "mmOnActivityResult, %d", new Object[]{Integer.valueOf(i)});
                    if (i == (this.mkX.hashCode() & 65535)) {
                        w.i("MicroMsg.GameJsApiShareEmotion", "share emmotion resultCode: %d", new Object[]{Integer.valueOf(i2)});
                        GameJsApiMMTask.a aVar;
                        aq aqVar;
                        switch (i2) {
                            case -1:
                                com.tencent.mm.storage.a.c b;
                                String ap = bg.ap(intent.getStringExtra("Select_Conv_User"), "");
                                String ap2 = bg.ap(intent.getStringExtra("emoji_thumb_path"), "");
                                com.tencent.mm.storage.a.c Si = h.amc().kLa.Si(ap2);
                                if (Si == null) {
                                    ap.yY();
                                    String D = EmojiLogic.D(c.xi(), "", ap2);
                                    if (e.aO(D)) {
                                        b = h.amc().kLa.b(ap2, "", com.tencent.mm.storage.a.c.uKT, o.Pj(D) ? com.tencent.mm.storage.a.c.uLa : com.tencent.mm.storage.a.c.uKZ, e.aN(D), "");
                                        for (String str : bg.f(bg.ap(ap, "").split(","))) {
                                            if (b != null) {
                                                h.alY().a(str, b, null);
                                            }
                                        }
                                        aVar = aVar;
                                        aqVar = this.mkX;
                                        aVar.pq(a.d("shareEmoticon:ok", null));
                                        return;
                                    }
                                }
                                b = Si;
                                for (String str2 : bg.f(bg.ap(ap, "").split(","))) {
                                    if (b != null) {
                                        h.alY().a(str2, b, null);
                                    }
                                }
                                aVar = aVar;
                                aqVar = this.mkX;
                                aVar.pq(a.d("shareEmoticon:ok", null));
                                return;
                            case 0:
                                aVar = aVar;
                                aqVar = this.mkX;
                                aVar.pq(a.d("shareEmoticon:ok", null));
                                return;
                            default:
                                aVar = aVar;
                                aqVar = this.mkX;
                                aVar.pq(a.d("shareEmoticon:ok", null));
                                return;
                        }
                    }
                }
            };
            com.tencent.mm.bb.d.a(context, ".ui.transmit.SelectConversationUI", intent, hashCode() & 65535);
        }
    }
}
