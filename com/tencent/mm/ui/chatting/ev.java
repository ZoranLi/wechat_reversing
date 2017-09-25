package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.l;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ev implements dp {
    static k<dp, Bundle> vPo = new k<dp, Bundle>() {
        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((dp) obj).ac((Bundle) obj2);
        }
    };
    public a vCd;
    final Set<String> vPn = new HashSet();

    protected ev(a aVar) {
        this.vCd = aVar;
    }

    public static void ad(Bundle bundle) {
        vPo.by(bundle);
        vPo.doNotify();
    }

    public final void ac(Bundle bundle) {
        int i = 1;
        boolean z = false;
        if (this.vCd.bVA()) {
            w.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
            return;
        }
        String string;
        int type;
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        Resp resp = new Resp(bundle);
        WXMediaMessage wXMediaMessage = resp.message;
        if (this.vPn.size() == 0) {
            Context context = this.vCd.uSU.uTo;
            Collection hashSet = new HashSet();
            string = context.getSharedPreferences(ab.bJa(), 0).getString("transactions_array_key", null);
            if (string != null && string.length() > 0) {
                for (Object add : string.split(";")) {
                    hashSet.add(add);
                }
            }
            this.vPn.addAll(hashSet);
        }
        if (this.vPn.contains(resp.transaction)) {
            this.vPn.remove(resp.transaction);
            a(this.vCd.uSU.uTo, this.vPn);
            f fVar = new f();
            fVar.field_appId = queryParameter;
            w.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = " + queryParameter);
            if (an.aRr().b((c) fVar, new String[0])) {
                type = wXMediaMessage.getType();
                l lVar;
                boolean z2;
                h b;
                byte[] bArr;
                int i2;
                String str;
                switch (type) {
                    case 1:
                        lVar = this.vCd.uSU;
                        queryParameter = wXMediaMessage.description;
                        o(fVar);
                        if (d.a(lVar, queryParameter, false, a(wXMediaMessage, fVar)) != null) {
                            z = true;
                        }
                        z2 = z;
                        break;
                    case 2:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                            l lVar2;
                            if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                                lVar2 = this.vCd.uSU;
                                string = wXImageObject.imagePath;
                                o(fVar);
                                b = d.b(lVar2, string, false, a(wXMediaMessage, fVar));
                            } else {
                                lVar2 = this.vCd.uSU;
                                byte[] bArr2 = wXImageObject.imageData;
                                o(fVar);
                                b = d.a(lVar2, bArr2, false, a(wXMediaMessage, fVar));
                            }
                        } else {
                            lVar = this.vCd.uSU;
                            bArr = wXMediaMessage.thumbData;
                            o(fVar);
                            b = d.a(lVar, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            w.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                        } else {
                            z = true;
                        }
                        z2 = z;
                        break;
                    case 3:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            lVar = this.vCd.uSU;
                            i2 = R.k.dtg;
                            str = wXMediaMessage.title;
                            o(fVar);
                            b = d.a(lVar, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            lVar = this.vCd.uSU;
                            queryParameter = wXMediaMessage.title;
                            o(fVar);
                            b = d.a(lVar, queryParameter, false, 2, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 4:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            lVar = this.vCd.uSU;
                            i2 = R.k.dtr;
                            str = wXMediaMessage.title;
                            o(fVar);
                            b = d.a(lVar, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            lVar = this.vCd.uSU;
                            queryParameter = wXMediaMessage.title;
                            o(fVar);
                            b = d.a(lVar, queryParameter, false, 1, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 5:
                        lVar = this.vCd.uSU;
                        queryParameter = wXMediaMessage.title;
                        str = wXMediaMessage.description;
                        o(fVar);
                        if (d.a(lVar, queryParameter, str, false, "", a(wXMediaMessage, fVar)) == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 7:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            lVar = this.vCd.uSU;
                            i2 = R.k.dtu;
                            str = wXMediaMessage.title;
                            o(fVar);
                            b = d.a(lVar, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            lVar = this.vCd.uSU;
                            queryParameter = wXMediaMessage.title;
                            o(fVar);
                            b = d.a(lVar, queryParameter, false, 0, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    case 8:
                        if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                            lVar = this.vCd.uSU;
                            i2 = R.k.dtu;
                            str = wXMediaMessage.title;
                            o(fVar);
                            b = d.a(lVar, i2, str, false, a(wXMediaMessage, fVar));
                        } else {
                            lVar = this.vCd.uSU;
                            bArr = wXMediaMessage.thumbData;
                            o(fVar);
                            b = d.a(lVar, bArr, false, a(wXMediaMessage, fVar));
                        }
                        if (b == null) {
                            i = 0;
                            break;
                        }
                        break;
                    default:
                        w.e("MicroMsg.WXAppMessageReceiver", "unknown type = " + type);
                        i = 0;
                        break;
                }
                if (i == 0) {
                    w.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
                    return;
                }
                return;
            }
            w.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = " + queryParameter);
            return;
        }
        w.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + resp.transaction);
    }

    public final boolean eT(String str, String str2) {
        w.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        Req req = new Req();
        req.username = this.vCd.bUg();
        req.transaction = g.n((u.Nz()).getBytes());
        req.openId = str2;
        SharedPreferences SB = this.vCd.SB(ab.bIX());
        ActionBarActivity actionBarActivity = this.vCd.uSU.uTo;
        req.lang = v.d(SB);
        ap.yY();
        req.country = (String) com.tencent.mm.u.c.vr().get(274436, null);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        p.aa(bundle);
        p.ab(bundle);
        Args args = new Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        boolean send = MMessageActV2.send(this.vCd.uSU.uTo, args);
        this.vPn.add(req.transaction);
        a(this.vCd.uSU.uTo, this.vPn);
        return send;
    }

    private String o(f fVar) {
        return this.vCd.getString(R.l.dXn, com.tencent.mm.pluginsdk.model.app.g.a(this.vCd.uSU.uTo, fVar, null));
    }

    private com.tencent.mm.pluginsdk.ui.applet.k.a a(final WXMediaMessage wXMediaMessage, final f fVar) {
        return new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
            final /* synthetic */ ev vPq;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    String str2 = null;
                    if (wXMediaMessage.getType() == 8) {
                        if (wXMediaMessage.thumbData == null) {
                            w.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                            return;
                        }
                        str2 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.vPq.vCd.uSU.uTo, wXMediaMessage, fVar.field_appId);
                        if (str2 == null) {
                            w.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                            return;
                        }
                    }
                    bm.zN().c(27, Integer.valueOf(1));
                    w.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", wXMediaMessage.messageAction, wXMediaMessage.messageExt);
                    com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.vPq.vCd.bUg(), 1, str2);
                }
            }
        };
    }

    @TargetApi(9)
    static void a(Context context, Set<String> set) {
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : set) {
                stringBuilder.append(str2);
                stringBuilder.append(";");
            }
            str2 = stringBuilder.toString();
        }
        Editor edit = context.getSharedPreferences(ab.bJa(), 0).edit();
        edit.putString("transactions_array_key", str2);
        if (VERSION.SDK_INT > 8) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
