package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.k.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class k {

    static class AnonymousClass1 implements a {
        final /* synthetic */ MMActivity fxT;
        final /* synthetic */ String jhX;
        final /* synthetic */ String kKK;
        final /* synthetic */ String kKL;
        final /* synthetic */ String kKM;
        final /* synthetic */ String kKN;
        final /* synthetic */ String kKO;
        final /* synthetic */ int kKP;

        public AnonymousClass1(String str, String str2, String str3, String str4, String str5, String str6, int i, MMActivity mMActivity) {
            this.kKK = str;
            this.kKL = str2;
            this.kKM = str3;
            this.kKN = str4;
            this.jhX = str5;
            this.kKO = str6;
            this.kKP = i;
            this.fxT = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.kKK;
                String str3 = this.kKL;
                String str4 = this.kKM;
                String str5 = this.kKN;
                String str6 = this.jhX;
                String str7 = this.kKO;
                int i2 = this.kKP;
                w.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str4;
                wXMediaMessage.description = str5;
                IMediaObject wXEmojiSharedObject = new WXEmojiSharedObject();
                wXEmojiSharedObject.packageflag = i2;
                wXEmojiSharedObject.packageid = str3;
                wXEmojiSharedObject.thumburl = str6;
                wXEmojiSharedObject.url = str7;
                wXMediaMessage.mediaObject = wXEmojiSharedObject;
                n.GR();
                Bitmap gS = b.gS(str6);
                if (!(gS == null || gS.isRecycled())) {
                    w.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    gS.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                com.tencent.mm.sdk.b.b ntVar = new nt();
                ntVar.fUP.fNK = wXMediaMessage;
                ntVar.fUP.toUser = str2;
                ntVar.fUP.fUQ = 49;
                ntVar.fUP.fUR = str2;
                ntVar.fUP.fUS = "";
                com.tencent.mm.sdk.b.a.urY.m(ntVar);
                if (!TextUtils.isEmpty(str)) {
                    ntVar = new nv();
                    ntVar.fVa.fVb = str2;
                    ntVar.fVa.content = str;
                    ntVar.fVa.type = o.fG(str2);
                    ntVar.fVa.flags = 0;
                    com.tencent.mm.sdk.b.a.urY.m(ntVar);
                }
                g.oUh.i(10993, new Object[]{Integer.valueOf(0), str3});
                com.tencent.mm.ui.base.g.bl(this.fxT, this.fxT.getString(R.l.dIG));
            }
        }
    }

    static class AnonymousClass2 implements a {
        final /* synthetic */ MMActivity fxT;
        final /* synthetic */ String iVh;
        final /* synthetic */ String kKO;
        final /* synthetic */ String kKQ;
        final /* synthetic */ String kKR;
        final /* synthetic */ int kKS;
        final /* synthetic */ String kKT;
        final /* synthetic */ String kKU;

        public AnonymousClass2(String str, String str2, String str3, int i, String str4, String str5, String str6, MMActivity mMActivity) {
            this.kKQ = str;
            this.kKR = str2;
            this.iVh = str3;
            this.kKS = i;
            this.kKO = str4;
            this.kKT = str5;
            this.kKU = str6;
            this.fxT = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                String str2 = this.kKQ;
                String str3 = this.kKR;
                String str4 = this.iVh;
                int i2 = this.kKS;
                String str5 = this.kKO;
                String str6 = this.kKT;
                String str7 = this.kKU;
                w.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str3;
                wXMediaMessage.description = str4;
                IMediaObject wXDesignerSharedObject = new WXDesignerSharedObject();
                wXDesignerSharedObject.designerUIN = i2;
                wXDesignerSharedObject.thumburl = str7;
                wXDesignerSharedObject.url = str5;
                wXDesignerSharedObject.designerName = str6;
                wXDesignerSharedObject.designerRediretctUrl = str7;
                wXMediaMessage.mediaObject = wXDesignerSharedObject;
                n.GR();
                Bitmap gS = b.gS(str7);
                if (!(gS == null || gS.isRecycled())) {
                    w.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    gS.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                com.tencent.mm.sdk.b.b ntVar = new nt();
                ntVar.fUP.fNK = wXMediaMessage;
                ntVar.fUP.toUser = str2;
                ntVar.fUP.fUQ = 49;
                ntVar.fUP.fUR = str2;
                ntVar.fUP.fUS = "";
                com.tencent.mm.sdk.b.a.urY.m(ntVar);
                if (!TextUtils.isEmpty(str)) {
                    ntVar = new nv();
                    ntVar.fVa.fVb = str2;
                    ntVar.fVa.content = str;
                    ntVar.fVa.type = o.fG(str2);
                    ntVar.fVa.flags = 0;
                    com.tencent.mm.sdk.b.a.urY.m(ntVar);
                }
                com.tencent.mm.ui.base.g.bl(this.fxT, this.fxT.getString(R.l.dIG));
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i);
        String fQ = q.fQ("emoje_stroe");
        q.yC().n(fQ, true).l("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", fQ);
        d.a(context, "sns", ".ui.En_c4f742e5", intent, false);
    }

    public static void bQ(Context context) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
        d.a(context, ".ui.transmit.SelectConversationUI", intent, MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
    }

    public static void a(MMActivity mMActivity, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6) {
        final String str7 = str;
        final int i4 = i;
        final int i5 = i2;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final int i6 = i3;
        final String str12 = str6;
        final MMActivity mMActivity2 = mMActivity;
        com.tencent.mm.pluginsdk.ui.applet.d.a(mMActivity.uSU, str2, str4, str3, "", mMActivity.getString(R.l.dIA), new a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    String str2 = str7;
                    int i2 = i4;
                    int i3 = i5;
                    String str3 = str8;
                    String str4 = str9;
                    String str5 = str10;
                    String str6 = str11;
                    int i4 = i6;
                    String str7 = str12;
                    w.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.title = str3;
                    wXMediaMessage.description = str4;
                    IMediaObject wXEmojiPageSharedObject = new WXEmojiPageSharedObject();
                    wXEmojiPageSharedObject.type = i2;
                    wXEmojiPageSharedObject.tid = i3;
                    wXEmojiPageSharedObject.title = str3;
                    wXEmojiPageSharedObject.desc = str4;
                    wXEmojiPageSharedObject.iconUrl = str5;
                    wXEmojiPageSharedObject.secondUrl = str6;
                    wXEmojiPageSharedObject.pageType = i4;
                    wXEmojiPageSharedObject.url = str7;
                    wXMediaMessage.mediaObject = wXEmojiPageSharedObject;
                    n.GR();
                    Bitmap gS = b.gS(str5);
                    if (!(gS == null || gS.isRecycled())) {
                        w.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        gS.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    com.tencent.mm.sdk.b.b ntVar = new nt();
                    ntVar.fUP.fNK = wXMediaMessage;
                    ntVar.fUP.toUser = str2;
                    ntVar.fUP.fUQ = 49;
                    ntVar.fUP.fUR = str2;
                    ntVar.fUP.fUS = "";
                    com.tencent.mm.sdk.b.a.urY.m(ntVar);
                    if (!TextUtils.isEmpty(str)) {
                        ntVar = new nv();
                        ntVar.fVa.fVb = str2;
                        ntVar.fVa.content = str;
                        ntVar.fVa.type = o.fG(str2);
                        ntVar.fVa.flags = 0;
                        com.tencent.mm.sdk.b.a.urY.m(ntVar);
                    }
                    com.tencent.mm.ui.base.g.bl(mMActivity2, mMActivity2.getString(R.l.dIG));
                }
            }
        });
    }
}
