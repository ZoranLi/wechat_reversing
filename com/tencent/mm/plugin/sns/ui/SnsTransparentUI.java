package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class SnsTransparentUI extends MMActivity {
    private Map<String, Bitmap> qiG = new HashMap();

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        Intent intent = getIntent();
        if (intent != null) {
            switch (intent.getIntExtra("op", -1)) {
                case 2:
                    final String stringExtra = intent.getStringExtra("adlandingXml");
                    final String stringExtra2 = intent.getStringExtra("shareTitle");
                    final String stringExtra3 = intent.getStringExtra("shareThumbUrl");
                    final String stringExtra4 = intent.getStringExtra("shareDesc");
                    final String stringExtra5 = intent.getStringExtra("shareUrl");
                    w.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 259);
                    intent2.putExtra("select_is_ret", true);
                    d.a(this, ".ui.transmit.SelectConversationUI", intent2, 0, new MMActivity.a(this) {
                        final /* synthetic */ SnsTransparentUI qJB;

                        public final void a(int i, int i2, Intent intent) {
                            if (i2 == -1) {
                                String str;
                                if (intent == null) {
                                    str = null;
                                } else {
                                    str = intent.getStringExtra("Select_Conv_User");
                                }
                                if (str == null || str.length() == 0) {
                                    w.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
                                    this.qJB.finish();
                                    return;
                                }
                                w.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
                                final String str2 = stringExtra;
                                final Context context = this.qJB;
                                n.a.sNx.a(((MMActivity) context).uSU, stringExtra2, stringExtra3, stringExtra4, context.getResources().getString(j.dIA), new k.a(this) {
                                    final /* synthetic */ AnonymousClass1 qJD;

                                    public final void a(boolean z, final String str, int i) {
                                        if (z) {
                                            final WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                            wXMediaMessage.title = stringExtra2;
                                            wXMediaMessage.description = stringExtra4;
                                            IMediaObject wXWebpageObject = new WXWebpageObject();
                                            wXWebpageObject.canvasPageXml = str2;
                                            wXWebpageObject.webpageUrl = stringExtra5;
                                            wXMediaMessage.mediaObject = wXWebpageObject;
                                            if (this.qJD.qJB.qiG.containsKey(stringExtra3)) {
                                                Bitmap bitmap = (Bitmap) this.qJD.qJB.qiG.get(stringExtra3);
                                                if (!(bitmap == null || bitmap.isRecycled())) {
                                                    w.i("SnsTransparentUI", "thumb image is not null");
                                                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                }
                                                b ntVar = new nt();
                                                ntVar.fUP.fNK = wXMediaMessage;
                                                ntVar.fUP.toUser = str;
                                                ntVar.fUP.fUQ = 49;
                                                ntVar.fUP.fUR = "";
                                                ntVar.fUP.fUS = "";
                                                com.tencent.mm.sdk.b.a.urY.m(ntVar);
                                                if (!TextUtils.isEmpty(str)) {
                                                    ntVar = new nv();
                                                    ntVar.fVa.fVb = str;
                                                    ntVar.fVa.content = str;
                                                    ntVar.fVa.type = o.fG(str);
                                                    ntVar.fVa.flags = 0;
                                                    com.tencent.mm.sdk.b.a.urY.m(ntVar);
                                                }
                                                g.bl(context, context.getString(j.dIG));
                                                this.qJD.qJB.finish();
                                                return;
                                            }
                                            aa.Pq(stringExtra3);
                                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a("adId", stringExtra3, false, 1000000001, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                                                final /* synthetic */ AnonymousClass1 qJF;

                                                public final void bgn() {
                                                }

                                                public final void bgo() {
                                                }

                                                public final void FW(String str) {
                                                    try {
                                                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                                                        this.qJF.qJD.qJB.qiG.put(stringExtra3, decodeFile);
                                                        if (!(decodeFile == null || decodeFile.isRecycled())) {
                                                            w.i("SnsTransparentUI", "thumb image is not null");
                                                            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                            decodeFile.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                        }
                                                        b ntVar = new nt();
                                                        ntVar.fUP.fNK = wXMediaMessage;
                                                        ntVar.fUP.toUser = str;
                                                        ntVar.fUP.fUQ = 49;
                                                        ntVar.fUP.fUR = "";
                                                        ntVar.fUP.fUS = "";
                                                        com.tencent.mm.sdk.b.a.urY.m(ntVar);
                                                        if (!TextUtils.isEmpty(str)) {
                                                            ntVar = new nv();
                                                            ntVar.fVa.fVb = str;
                                                            ntVar.fVa.content = str;
                                                            ntVar.fVa.type = o.fG(str);
                                                            ntVar.fVa.flags = 0;
                                                            com.tencent.mm.sdk.b.a.urY.m(ntVar);
                                                        }
                                                        g.bl(context, context.getString(j.dIG));
                                                        this.qJF.qJD.qJB.finish();
                                                    } catch (Exception e) {
                                                        w.e("SnsTransparentUI", "this has a error : " + e.toString());
                                                        this.qJF.qJD.qJB.finish();
                                                    }
                                                }
                                            });
                                            return;
                                        }
                                        this.qJD.qJB.finish();
                                    }
                                });
                                return;
                            }
                            this.qJB.finish();
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }
}
