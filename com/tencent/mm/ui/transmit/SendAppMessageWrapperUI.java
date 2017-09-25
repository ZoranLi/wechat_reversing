package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.protocal.c.bpv;
import com.tencent.mm.protocal.c.bpw;
import com.tencent.mm.protocal.c.bqf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.u;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class SendAppMessageWrapperUI extends MMActivity {
    private String aJE = null;
    private aj fyI = new aj(new aj.a(this) {
        final /* synthetic */ SendAppMessageWrapperUI wrd;

        {
            this.wrd = r1;
        }

        public final boolean oQ() {
            if (this.wrd.getWindow() != null && this.wrd.getWindow().getDecorView() != null && this.wrd.getWindow().getDecorView().getWindowToken() != null) {
                SendAppMessageWrapperUI.c(this.wrd);
                return false;
            } else if (this.wrd.lHz >= 10) {
                return false;
            } else {
                SendAppMessageWrapperUI.b(this.wrd);
                return true;
            }
        }
    }, true);
    private int lHz = 0;
    private int scene = 0;
    private String toUser = null;
    private WXMediaMessage vHi = null;
    private f wrb = null;
    private boolean wrc = false;

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, WXMediaMessage wXMediaMessage, String str, int i) {
        w.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc msg[%s], text[%s], parsterLen[%d], scene[%d]", wXMediaMessage, str, Integer.valueOf(i), Integer.valueOf(sendAppMessageWrapperUI.scene));
        if (sendAppMessageWrapperUI.scene == 0) {
            String str2;
            String fQ;
            String str3;
            String str4;
            bm.zN().c(38, Integer.valueOf(1));
            if (wXMediaMessage.getType() != 8) {
                str2 = null;
            } else if (wXMediaMessage.thumbData == null) {
                w.e("MicroMsg.SendAppMessageWrapperUI", "summerbig code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                return;
            } else {
                str2 = ((c) h.j(c.class)).getEmojiMgr().a((Context) sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.wrb.field_appId);
                if (str2 == null) {
                    w.v("MicroMsg.SendAppMessageWrapperUI", "summerbig sendEmoji Fail cause emojiconmd5 is null");
                    return;
                }
                com.tencent.mm.storage.a.c ub = ((c) h.j(c.class)).getEmojiMgr().ub(str2);
                if (ub == null) {
                    w.i("MicroMsg.SendAppMessageWrapperUI", "emoji is null.");
                    return;
                }
                if (ub.field_size > bg.getInt(g.sV().getValue("InputLimitSendThirdPartyAppMsgEmotionBufSize"), SQLiteGlobal.journalSizeLimit)) {
                    w.i("MicroMsg.SendAppMessageWrapperUI", "third party shared emoji can't bigger 512 KB");
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(13461, sendAppMessageWrapperUI.wrb.field_appId, sendAppMessageWrapperUI.wrb.field_appName, Integer.valueOf(ub.field_size));
            }
            if (wXMediaMessage.getType() == 5 || wXMediaMessage.getType() == 2) {
                w.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), appId : %s", sendAppMessageWrapperUI.wrb.field_appId);
                fQ = q.fQ("app_" + sendAppMessageWrapperUI.wrb.field_appId);
                q.yC().n(fQ, true).l("prePublishId", "app_" + sendAppMessageWrapperUI.wrb.field_appId);
            } else {
                fQ = null;
            }
            LinkedList linkedList = new LinkedList(bg.f(sendAppMessageWrapperUI.toUser.split(",")));
            if (wXMediaMessage.getType() == 36) {
                sendAppMessageWrapperUI.a(wXMediaMessage, linkedList);
            } else {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    str3 = (String) it.next();
                    l.a(wXMediaMessage, sendAppMessageWrapperUI.wrb.field_appId, sendAppMessageWrapperUI.wrb.field_appName, str3, 2, str2, fQ);
                }
            }
            if (sendAppMessageWrapperUI.wrb.field_appId.equals("wx4310bbd51be7d979")) {
                str4 = null;
            } else {
                str4 = sendAppMessageWrapperUI.getString(R.l.dXh, new Object[]{sendAppMessageWrapperUI.wrb.field_appName});
            }
            if (str4 == null) {
                str4 = sendAppMessageWrapperUI.getString(R.l.dXg);
            }
            str3 = sendAppMessageWrapperUI.getString(R.l.dXo);
            k.a anonymousClass4 = new k.a(sendAppMessageWrapperUI) {
                final /* synthetic */ SendAppMessageWrapperUI wrd;

                {
                    this.wrd = r1;
                }

                public final void a(boolean z, String str, int i) {
                    this.wrd.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
                    this.wrd.finish();
                }
            };
            d.a(sendAppMessageWrapperUI.uSU, sendAppMessageWrapperUI.getString(R.l.dXl), str4, str3, new k.a(sendAppMessageWrapperUI) {
                final /* synthetic */ SendAppMessageWrapperUI wrd;

                {
                    this.wrd = r1;
                }

                public final void a(boolean z, String str, int i) {
                    this.wrd.setResult(-1);
                    this.wrd.finish();
                    ReportUtil.a(this.wrd, ReportUtil.b(this.wrd.getIntent().getExtras(), 0));
                }
            }, anonymousClass4);
            if (str == null || str.length() == 0) {
                w.i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
                return;
            }
            w.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:" + str);
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                ap.vd().a(new j((String) it2.next(), str, o.fG(sendAppMessageWrapperUI.toUser)), 0);
            }
            return;
        }
        if (m.pQz != null) {
            m.pQz.a(wXMediaMessage, str, sendAppMessageWrapperUI.wrb.field_appId, sendAppMessageWrapperUI.wrb.field_appName, i);
            m.pQz.bdz();
        }
        ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.b(sendAppMessageWrapperUI.getIntent().getExtras(), 0));
        sendAppMessageWrapperUI.finish();
    }

    static /* synthetic */ int b(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        int i = sendAppMessageWrapperUI.lHz + 1;
        sendAppMessageWrapperUI.lHz = i;
        return i;
    }

    static /* synthetic */ void c(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        boolean z = false;
        boolean z2 = true;
        if (sendAppMessageWrapperUI.vHi == null) {
            w.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = sendAppMessageWrapperUI.vHi.getType();
        WXMediaMessage wXMediaMessage;
        com.tencent.mm.ui.base.h b;
        WXMediaMessage wXMediaMessage2;
        WXMediaMessage wXMediaMessage3;
        d.a aVar;
        switch (type) {
            case 1:
                wXMediaMessage = sendAppMessageWrapperUI.vHi;
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (wXTextObject.text != null && wXTextObject.text.length() != 0) {
                    sendAppMessageWrapperUI.wrb.field_appId.equals("wx4310bbd51be7d979");
                    if (d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage.description, true, sendAppMessageWrapperUI.a(wXMediaMessage)) != null) {
                        break;
                    }
                }
                w.e("MicroMsg.SendAppMessageWrapperUI", "dealText fail, text is empty");
                z2 = false;
                break;
            case 2:
                wXMediaMessage = sendAppMessageWrapperUI.vHi;
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                    b = (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) ? d.b(sendAppMessageWrapperUI.uSU, wXImageObject.imagePath, true, sendAppMessageWrapperUI.a(wXMediaMessage)) : d.a(sendAppMessageWrapperUI.uSU, wXImageObject.imageData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                } else {
                    b = d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage.thumbData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                }
                if (b == null) {
                    w.e("MicroMsg.SendAppMessageWrapperUI", "showDialogItem3 fail, invalid argument");
                } else {
                    z = true;
                }
                z2 = z;
                break;
            case 3:
                wXMediaMessage2 = sendAppMessageWrapperUI.vHi;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? d.a(sendAppMessageWrapperUI.uSU, R.k.dtg, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage2.title, true, 2, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 4:
                wXMediaMessage2 = sendAppMessageWrapperUI.vHi;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? d.a(sendAppMessageWrapperUI.uSU, R.k.dtr, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage2.title, true, 1, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 5:
                wXMediaMessage3 = sendAppMessageWrapperUI.vHi;
                if (d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.uSU.uTo.getResources().getString(R.l.dXm), sendAppMessageWrapperUI.a(wXMediaMessage3)) == null) {
                    z2 = false;
                    break;
                }
                break;
            case 6:
                wXMediaMessage2 = sendAppMessageWrapperUI.vHi;
                b = (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) ? d.a(sendAppMessageWrapperUI.uSU, R.k.dte, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2)) : d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 7:
                wXMediaMessage2 = sendAppMessageWrapperUI.vHi;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    Bitmap b2 = com.tencent.mm.pluginsdk.model.app.g.b(sendAppMessageWrapperUI.wrb.field_appId, 1, com.tencent.mm.bg.a.getDensity(sendAppMessageWrapperUI));
                    if (b2 == null || b2.isRecycled()) {
                        b = d.a(sendAppMessageWrapperUI.uSU, R.k.dtu, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2));
                    } else {
                        com.tencent.mm.ui.l lVar = sendAppMessageWrapperUI.uSU;
                        CharSequence charSequence = wXMediaMessage2.title;
                        CharSequence charSequence2 = wXMediaMessage2.description;
                        CharSequence charSequence3 = sendAppMessageWrapperUI.aJE;
                        k.a a = sendAppMessageWrapperUI.a(wXMediaMessage2);
                        View O = d.O(lVar.uTo, R.i.cZn);
                        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
                        aVar2.kK(false);
                        aVar2.kL(false);
                        d.l(O, true);
                        d.a(lVar, aVar2, a, O, lVar.uTo.getResources().getString(R.l.dXm));
                        TextView textView = (TextView) O.findViewById(R.h.bEF);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, charSequence, textView.getTextSize()));
                        textView = (TextView) O.findViewById(R.h.bEC);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, charSequence2, textView.getTextSize()));
                        textView = (TextView) O.findViewById(R.h.bEz);
                        if (charSequence3 == null || charSequence3.length() == 0) {
                            textView.setVisibility(8);
                        } else {
                            textView.setText(charSequence3);
                            textView.setVisibility(0);
                        }
                        ImageView imageView = (ImageView) O.findViewById(R.h.bEE);
                        if (imageView != null) {
                            if (b2 == null || b2.isRecycled()) {
                                w.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
                                imageView.setVisibility(8);
                            } else {
                                imageView.setVisibility(0);
                                imageView.setImageBitmap(b2);
                                d.a(aVar2, b2);
                            }
                        }
                        aVar2.dd(O);
                        b = aVar2.WJ();
                        b.show();
                    }
                } else {
                    b = d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 8:
                wXMediaMessage = sendAppMessageWrapperUI.vHi;
                String a2 = ((c) h.j(c.class)).getEmojiMgr().a((Context) sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.wrb.field_appId);
                String string = sendAppMessageWrapperUI.uSU.uTo.getIntent().getExtras().getString("Select_Conv_User", null);
                if (bg.mA(a2)) {
                    if (d.a(sendAppMessageWrapperUI.uSU, R.k.dtu, wXMediaMessage.title, true, sendAppMessageWrapperUI.a(wXMediaMessage)) == null) {
                        z2 = false;
                        break;
                    }
                }
                aVar = new d.a(sendAppMessageWrapperUI.uSU.uTo);
                aVar.bs(string).MR(a2).c(Boolean.valueOf(true)).xp(R.l.dIA).a(sendAppMessageWrapperUI.a(wXMediaMessage)).oHT.show();
                if (aVar.oHT == null) {
                    z2 = false;
                    break;
                }
                break;
            case 36:
                WXMediaMessage wXMediaMessage4 = sendAppMessageWrapperUI.vHi;
                if (wXMediaMessage4 != null && (wXMediaMessage4.mediaObject instanceof WXMiniProgramObject)) {
                    WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage4.mediaObject;
                    aVar = new d.a(sendAppMessageWrapperUI.uSU.uTo);
                    aVar.bs(sendAppMessageWrapperUI.uSU.uTo.getIntent().getExtras().getString("Select_Conv_User", null));
                    final View aR = ((com.tencent.mm.modelappbrand.h) h.h(com.tencent.mm.modelappbrand.h.class)).aR(sendAppMessageWrapperUI);
                    final String aM = b.aM(sendAppMessageWrapperUI);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("image_data", wXMediaMessage4.thumbData);
                    bundle.putString("title", wXMediaMessage4.title);
                    bundle.putString("msg_path", wXMiniProgramObject.path);
                    ((com.tencent.mm.modelappbrand.h) h.h(com.tencent.mm.modelappbrand.h.class)).a(aM, aR, bundle);
                    aVar.cR(aR);
                    aVar.c(Boolean.valueOf(true));
                    aVar.bEW();
                    aVar.jrW = new OnDismissListener(sendAppMessageWrapperUI) {
                        final /* synthetic */ SendAppMessageWrapperUI wrd;

                        public final void onDismiss(DialogInterface dialogInterface) {
                            ((com.tencent.mm.modelappbrand.h) h.h(com.tencent.mm.modelappbrand.h.class)).a(aM, aR);
                        }
                    };
                    aVar.xp(R.l.dIA);
                    aVar.a(sendAppMessageWrapperUI.a(wXMediaMessage4)).oHT.show();
                    break;
                }
                z2 = false;
                break;
            case 38:
                wXMediaMessage3 = sendAppMessageWrapperUI.vHi;
                if (d.a(sendAppMessageWrapperUI.uSU, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.uSU.uTo.getResources().getString(R.l.dXm), sendAppMessageWrapperUI.a(wXMediaMessage3), sendAppMessageWrapperUI.getResources().getString(R.l.dHj)) == null) {
                    z2 = false;
                    break;
                }
                break;
            default:
                w.e("MicroMsg.SendAppMessageWrapperUI", "unknown type = " + type);
                z2 = false;
                break;
        }
        if (!z2) {
            w.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, result is false");
            sendAppMessageWrapperUI.finish();
        }
    }

    static /* synthetic */ void d(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        if (sendAppMessageWrapperUI.scene == 0) {
            Intent intent = new Intent();
            intent.putExtra("Select_Report_Args", ReportUtil.b(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
            sendAppMessageWrapperUI.setResult(0, intent);
        } else {
            ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.b(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
        }
        sendAppMessageWrapperUI.finish();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
        r12 = this;
        r5 = -1;
        r11 = -5;
        r10 = 2;
        r4 = 0;
        r3 = 1;
        super.onCreate(r13);
        r0 = r12.cO();
        r0 = r0.cP();
        r0.hide();
        r0 = com.tencent.mm.sdk.platformtools.ab.bIX();
        r0 = r12.getSharedPreferences(r0, r4);
        r1 = "settings_landscape_mode";
        r1 = r0.getBoolean(r1, r4);
        if (r1 != 0) goto L_0x0040;
    L_0x0024:
        r1 = "MicroMsg.SendAppMessageWrapperUI";
        r2 = "change orientation";
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r12.wrc = r3;
        r12.setRequestedOrientation(r5);
        r0 = r0.edit();
        r1 = "settings_landscape_mode";
        r0 = r0.putBoolean(r1, r3);
        r0.commit();
    L_0x0040:
        r0 = r12.getIntent();
        r1 = r0.getExtras();
        r2 = new com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
        r2.<init>(r1);
        r0 = "Select_Conv_User";
        r0 = r1.getString(r0);
        r12.toUser = r0;
        r0 = "SendAppMessageWrapper_Scene";
        r0 = r1.getInt(r0, r4);
        r12.scene = r0;
        r0 = "SendAppMessageWrapper_AppId";
        r0 = r1.getString(r0);
        if (r0 != 0) goto L_0x007a;
    L_0x0068:
        r0 = "_mmessage_content";
        r0 = r1.getString(r0);
        r0 = android.net.Uri.parse(r0);
        r1 = "appid";
        r0 = r0.getQueryParameter(r1);
    L_0x007a:
        r1 = new com.tencent.mm.pluginsdk.model.app.f;
        r1.<init>();
        r12.wrb = r1;
        r1 = r12.wrb;
        r1.field_appId = r0;
        r0 = com.tencent.mm.pluginsdk.model.app.an.aRr();
        r1 = r12.wrb;
        r5 = new java.lang.String[r4];
        r0.b(r1, r5);
        r0 = r12.wrb;
        r0 = r0.field_appName;
        if (r0 != 0) goto L_0x00d1;
    L_0x0096:
        r0 = com.tencent.mm.R.l.dXp;
        r0 = r12.getString(r0);
    L_0x009c:
        r1 = com.tencent.mm.R.l.dXn;
        r5 = new java.lang.Object[r3];
        r5[r4] = r0;
        r0 = r12.getString(r1, r5);
        r12.aJE = r0;
        r0 = r2.message;
        r12.vHi = r0;
        r0 = "MicroMsg.SendAppMessageWrapperUI";
        r1 = "onCreate, messageAction = %s, messageExt = %s";
        r2 = new java.lang.Object[r10];
        r5 = r12.vHi;
        r5 = r5.messageAction;
        r2[r4] = r5;
        r5 = r12.vHi;
        r5 = r5.messageExt;
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r12.scene;
        if (r0 != r3) goto L_0x0369;
    L_0x00c7:
        r0 = r12.vHi;
        r0 = r0.mediaObject;
        if (r0 != 0) goto L_0x00dd;
    L_0x00cd:
        r12.finish();
    L_0x00d0:
        return;
    L_0x00d1:
        r0 = r12.uSU;
        r0 = r0.uTo;
        r1 = r12.wrb;
        r5 = 0;
        r0 = com.tencent.mm.pluginsdk.model.app.g.a(r0, r1, r5);
        goto L_0x009c;
    L_0x00dd:
        r0 = r12.vHi;
        r0 = r0.getType();
        r1 = 38;
        if (r0 != r1) goto L_0x0151;
    L_0x00e7:
        r0 = r12.vHi;
        r0 = r0.mediaObject;
        r0 = (com.tencent.mm.opensdk.modelmsg.WXVideoFileObject) r0;
        r5 = r0.filePath;
        r1 = r0.filePath;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x020e;
    L_0x00f7:
        r0 = r0.filePath;
        r0 = com.tencent.mm.a.e.aO(r0);
        if (r0 == 0) goto L_0x020e;
    L_0x00ff:
        r2 = 0;
        r1 = new android.media.MediaMetadataRetriever;	 Catch:{ Exception -> 0x01c0, all -> 0x01f3 }
        r1.<init>();	 Catch:{ Exception -> 0x01c0, all -> 0x01f3 }
        r1.setDataSource(r5);	 Catch:{ Exception -> 0x0377 }
        r0 = 9;
        r0 = r1.extractMetadata(r0);	 Catch:{ Exception -> 0x0377 }
        r2 = -1;
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r2);	 Catch:{ Exception -> 0x0377 }
        r2 = "MicroMsg.SendAppMessageWrapperUI";
        r6 = "video duration %d";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0377 }
        r8 = 0;
        r9 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0377 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x0377 }
        com.tencent.mm.sdk.platformtools.w.i(r2, r6, r7);	 Catch:{ Exception -> 0x0377 }
        r2 = 10500; // 0x2904 float:1.4714E-41 double:5.1877E-320;
        if (r0 < r2) goto L_0x0131;
    L_0x012a:
        r0 = -5;
        r12.setResult(r0);	 Catch:{ Exception -> 0x0377 }
        r12.finish();	 Catch:{ Exception -> 0x0377 }
    L_0x0131:
        r1.release();	 Catch:{ Exception -> 0x01ac }
    L_0x0134:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "K_SEGMENTVIDEOPATH";
        r0.putExtra(r1, r5);
        r1 = "KSEGMENTVIDEOTHUMBPATH";
        r2 = "";
        r0.putExtra(r1, r2);
        r1 = "mmsight";
        r2 = ".segment.VideoCompressUI";
        com.tencent.mm.bb.d.b(r12, r1, r2, r0, r10);
    L_0x0151:
        r0 = r12.vHi;
        r0 = r0.getType();
        r1 = 39;
        if (r0 != r1) goto L_0x0364;
    L_0x015b:
        r0 = r12.vHi;
        r0 = r0.mediaObject;
        r0 = (com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject) r0;
        r1 = r0.filePath;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x0198;
    L_0x0169:
        r1 = r0.filePath;
        r1 = com.tencent.mm.a.e.aO(r1);
        if (r1 == 0) goto L_0x0198;
    L_0x0171:
        r1 = r0.filePath;
        r0 = com.tencent.mm.i.g.sV();
        r2 = "ShareVideoMaxSize";
        r5 = 4194304; // 0x400000 float:5.877472E-39 double:2.0722615E-317;
        r0 = r0.getInt(r2, r5);
        r6 = com.tencent.mm.modelsfs.FileOp.ki(r1);
        r8 = (long) r0;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0213;
    L_0x0189:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "file len too big ";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        r0 = r3;
    L_0x0193:
        if (r0 == 0) goto L_0x0216;
    L_0x0195:
        r0 = r3;
    L_0x0196:
        if (r0 == 0) goto L_0x0364;
    L_0x0198:
        r0 = r12.getIntent();
        r0 = r0.getExtras();
        r0 = com.tencent.mm.pluginsdk.model.app.ReportUtil.b(r0, r11);
        com.tencent.mm.pluginsdk.model.app.ReportUtil.a(r12, r0);
        r12.finish();
        goto L_0x00d0;
    L_0x01ac:
        r0 = move-exception;
        r1 = "MicroMsg.SendAppMessageWrapperUI";
        r2 = "%s";
        r6 = new java.lang.Object[r3];
        r7 = r0.getMessage();
        r6[r4] = r7;
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r6);
        goto L_0x0134;
    L_0x01c0:
        r0 = move-exception;
        r1 = r2;
    L_0x01c2:
        r2 = "MicroMsg.SendAppMessageWrapperUI";
        r6 = "Analysis duration of mediaItem %s error %s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0374 }
        r8 = 0;
        r7[r8] = r5;	 Catch:{ all -> 0x0374 }
        r8 = 1;
        r9 = r0.getMessage();	 Catch:{ all -> 0x0374 }
        r7[r8] = r9;	 Catch:{ all -> 0x0374 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r6, r7);	 Catch:{ all -> 0x0374 }
        if (r1 == 0) goto L_0x0134;
    L_0x01da:
        r1.release();	 Catch:{ Exception -> 0x01df }
        goto L_0x0134;
    L_0x01df:
        r0 = move-exception;
        r1 = "MicroMsg.SendAppMessageWrapperUI";
        r2 = "%s";
        r6 = new java.lang.Object[r3];
        r7 = r0.getMessage();
        r6[r4] = r7;
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r6);
        goto L_0x0134;
    L_0x01f3:
        r0 = move-exception;
        r1 = r2;
    L_0x01f5:
        if (r1 == 0) goto L_0x01fa;
    L_0x01f7:
        r1.release();	 Catch:{ Exception -> 0x01fb }
    L_0x01fa:
        throw r0;
    L_0x01fb:
        r1 = move-exception;
        r2 = "MicroMsg.SendAppMessageWrapperUI";
        r5 = "%s";
        r3 = new java.lang.Object[r3];
        r6 = r1.getMessage();
        r3[r4] = r6;
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r5, r3);
        goto L_0x01fa;
    L_0x020e:
        r12.finish();
        goto L_0x0134;
    L_0x0213:
        r0 = r4;
        goto L_0x0193;
    L_0x0216:
        r1 = com.tencent.mm.modelsns.a.a.kF(r1);
        r0 = r1.hTk;
        if (r0 <= 0) goto L_0x023c;
    L_0x021e:
        r0 = r1.hTj;
        if (r0 <= 0) goto L_0x023c;
    L_0x0222:
        r0 = r1.hTk;
        r0 = (float) r0;
        r2 = r1.hTj;
        r2 = (float) r2;
        r0 = r0 / r2;
        r2 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x023c;
    L_0x022f:
        r0 = r1.hTk;
        r0 = (float) r0;
        r2 = r1.hTj;
        r2 = (float) r2;
        r0 = r0 / r2;
        r2 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x02c9;
    L_0x023c:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "check ratio faild width = [%d], height = [%d]";
        r5 = new java.lang.Object[r10];
        r6 = r1.hTk;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r4] = r6;
        r6 = r1.hTj;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r5);
        r0 = r3;
    L_0x0258:
        if (r0 != 0) goto L_0x02c6;
    L_0x025a:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "check duration %d";
        r5 = new java.lang.Object[r3];
        r6 = r1.hTi;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r4] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r5);
        r0 = r1.hTi;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r0 > r2) goto L_0x02cb;
    L_0x0273:
        r0 = r3;
    L_0x0274:
        if (r0 != 0) goto L_0x02c6;
    L_0x0276:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "checkFormat() called with: item = [%s]";
        r5 = new java.lang.Object[r3];
        r5[r4] = r1;
        com.tencent.mm.sdk.platformtools.w.d(r0, r2, r5);
        r0 = r1.hTf;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x02b4;
    L_0x028b:
        r0 = r1.hTf;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r2 == 0) goto L_0x02d5;
    L_0x0293:
        r0 = r3;
    L_0x0294:
        if (r0 != 0) goto L_0x02b4;
    L_0x0296:
        r0 = "video/avc";
        r2 = r1.hTg;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 == 0) goto L_0x02b4;
    L_0x02a1:
        r0 = r1.hTh;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x035e;
    L_0x02a9:
        r0 = "audio/mp4a-latm";
        r2 = r1.hTh;
        r0 = r0.equalsIgnoreCase(r2);
        if (r0 != 0) goto L_0x035e;
    L_0x02b4:
        r0 = "MicroMsg.ShareSnsImpl";
        r2 = "check video format failed, dst format [video/avc], video format [%s]";
        r5 = new java.lang.Object[r3];
        r1 = r1.hTg;
        r5[r4] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r5);
        r0 = r3;
    L_0x02c4:
        if (r0 == 0) goto L_0x0361;
    L_0x02c6:
        r0 = r3;
        goto L_0x0196;
    L_0x02c9:
        r0 = r4;
        goto L_0x0258;
    L_0x02cb:
        r0 = r1.hTi;
        r2 = 10500; // 0x2904 float:1.4714E-41 double:5.1877E-320;
        if (r0 < r2) goto L_0x02d3;
    L_0x02d1:
        r0 = r3;
        goto L_0x0274;
    L_0x02d3:
        r0 = r4;
        goto L_0x0274;
    L_0x02d5:
        r2 = com.tencent.mm.modelsns.a.hTe;
        if (r2 != 0) goto L_0x0336;
    L_0x02d9:
        r2 = new java.util.HashSet;
        r2.<init>();
        com.tencent.mm.modelsns.a.hTe = r2;
        r5 = ".h264";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".h26l";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".264";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".avc";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".mov";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".mp4";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".m4a";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".3gp";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".3g2";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".mj2";
        r2.add(r5);
        r2 = com.tencent.mm.modelsns.a.hTe;
        r5 = ".m4v";
        r2.add(r5);
    L_0x0336:
        r0 = r0.trim();
        r2 = ".";
        r2 = r0.lastIndexOf(r2);
        if (r2 < 0) goto L_0x0349;
    L_0x0343:
        r5 = r0.length();
        if (r2 < r5) goto L_0x034c;
    L_0x0349:
        r0 = r3;
        goto L_0x0294;
    L_0x034c:
        r5 = com.tencent.mm.modelsns.a.hTe;
        r0 = r0.substring(r2);
        r0 = r5.contains(r0);
        if (r0 != 0) goto L_0x035b;
    L_0x0358:
        r0 = r3;
        goto L_0x0294;
    L_0x035b:
        r0 = r4;
        goto L_0x0294;
    L_0x035e:
        r0 = r4;
        goto L_0x02c4;
    L_0x0361:
        r0 = r4;
        goto L_0x0196;
    L_0x0364:
        r12.lN(r3);
        goto L_0x00d0;
    L_0x0369:
        r0 = r12.fyI;
        r2 = 100;
        r4 = 100;
        r0.v(r2, r4);
        goto L_0x00d0;
    L_0x0374:
        r0 = move-exception;
        goto L_0x01f5;
    L_0x0377:
        r0 = move-exception;
        goto L_0x01c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI.onCreate(android.os.Bundle):void");
    }

    private void lN(boolean z) {
        Intent a = com.tencent.mm.modelsns.a.a(this.vHi, this.wrb.field_appId, this.wrb.field_appName);
        if (a == null) {
            finish();
            return;
        }
        String str = null;
        if (this.vHi.getType() == 5 || this.vHi.getType() == 2 || this.vHi.getType() == 38) {
            w.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", this.wrb.field_appId);
            String fQ = q.fQ("app_" + this.wrb.field_appId);
            q.b n = q.yC().n(fQ, true);
            n.l("prePublishId", "app_" + this.wrb.field_appId);
            if (this.vHi.mediaObject instanceof WXWebpageObject) {
                n.l(SlookSmartClipMetaTag.TAG_TYPE_URL, ((WXWebpageObject) this.vHi.mediaObject).webpageUrl);
            }
            str = fQ;
        }
        a.putExtra("reportSessionId", str);
        if (z) {
            com.tencent.mm.bb.d.b(this, "sns", ".ui.En_c4f742e5", a, 1);
        } else {
            com.tencent.mm.bb.d.b((Context) this, "sns", ".ui.En_c4f742e5", a);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + i + " resultCode " + i2);
        if (i == 1) {
            if (i2 == -1) {
                ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), 0));
            } else {
                ReportUtil.a(this, ReportUtil.b(getIntent().getExtras(), -2));
            }
            finish();
        } else if (i == 2 && i2 == -1) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.vHi.mediaObject;
            wXVideoFileObject.filePath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
            if (bg.mA(wXVideoFileObject.filePath) || !e.aO(wXVideoFileObject.filePath)) {
                setResult(-5);
            } else {
                lN(false);
            }
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.wrc) {
            w.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
            SharedPreferences sharedPreferences = getSharedPreferences(ab.bIX(), 0);
            setRequestedOrientation(1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        aHf();
        return super.onTouchEvent(motionEvent);
    }

    private k.a a(final WXMediaMessage wXMediaMessage) {
        return new k.a(this) {
            final /* synthetic */ SendAppMessageWrapperUI wrd;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    SendAppMessageWrapperUI.a(this.wrd, wXMediaMessage, str, i);
                } else {
                    SendAppMessageWrapperUI.d(this.wrd);
                }
            }
        };
    }

    private void a(final WXMediaMessage wXMediaMessage, final LinkedList<String> linkedList) {
        WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage.mediaObject;
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(this.wrb.field_appId);
        stringBuilder.append("_");
        ap.yY();
        stringBuilder.append(com.tencent.mm.a.o.getString(com.tencent.mm.u.c.uH()));
        stringBuilder.append("_");
        stringBuilder.append(bg.Ny());
        stringBuilder.append("_");
        stringBuilder.append("1");
        final String stringBuilder2 = stringBuilder.toString();
        if (wXMiniProgramObject.withShareTicket) {
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
            aVar.hsl = 1118;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_bpv = new bpv();
            com_tencent_mm_protocal_c_bpv.fTO = this.wrb.field_appId;
            com_tencent_mm_protocal_c_bpv.unW = linkedList;
            aVar.hsm = com_tencent_mm_protocal_c_bpv;
            aVar.hsn = new bpw();
            u.a(aVar.BE(), new u.a(this) {
                final /* synthetic */ SendAppMessageWrapperUI wrd;

                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, com.tencent.mm.y.k kVar) {
                    w.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    bpw com_tencent_mm_protocal_c_bpw = (bpw) bVar.hsk.hsr;
                    if (i != 0 || i2 != 0 || com_tencent_mm_protocal_c_bpw == null || com_tencent_mm_protocal_c_bpw.unX == null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            l.a(wXMediaMessage, this.wrd.wrb.field_appId, this.wrd.wrb.field_appName, (String) it.next(), 2, null, null);
                        }
                    } else {
                        LinkedList linkedList = com_tencent_mm_protocal_c_bpw.unX == null ? new LinkedList() : com_tencent_mm_protocal_c_bpw.unX;
                        w.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList.size()));
                        int i3 = 0;
                        while (i3 < linkedList.size()) {
                            bqf com_tencent_mm_protocal_c_bqf = i3 < linkedList.size() ? (bqf) linkedList.get(i3) : new bqf();
                            com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
                            aVar.appId = this.wrd.wrb.field_appId;
                            aVar.appName = this.wrd.wrb.field_appName;
                            aVar.hht = 2;
                            aVar.hjS = com_tencent_mm_protocal_c_bqf.uov;
                            aVar.hjR = stringBuilder2;
                            l.a(aVar, wXMediaMessage, (String) linkedList.get(i3));
                            i3++;
                        }
                    }
                    return 0;
                }
            });
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                l.a(wXMediaMessage, this.wrb.field_appId, this.wrb.field_appName, (String) it.next(), 2, null, null);
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            int i = ((String) it2.next()).endsWith("chatroom") ? 1 : 0;
            String encode = p.encode(bg.mz(wXMiniProgramObject.webpageUrl));
            String encode2 = p.encode(bg.mz(wXMediaMessage.title));
            String encode3 = p.encode(bg.mz(wXMediaMessage.description));
            String encode4 = p.encode(bg.mz(wXMiniProgramObject.path));
            com.tencent.mm.plugin.report.service.g.oUh.i(14127, this.wrb.field_appId, wXMiniProgramObject.userName, encode4, encode2, encode3, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), stringBuilder2);
        }
    }

    protected final void KC() {
    }

    protected final int getLayoutId() {
        return -1;
    }
}
