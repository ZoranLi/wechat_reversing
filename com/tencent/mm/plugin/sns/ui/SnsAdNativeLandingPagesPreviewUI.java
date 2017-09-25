package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.protocal.c.tv;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

@a(3)
public class SnsAdNativeLandingPagesPreviewUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("SnsAdNativeLandingPagesPreviewUI", "setFullScreen");
        getWindow().getAttributes();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getWindow().getDecorView().setSystemUiVisibility(5126);
        final Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Object stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        final long longExtra = intent.getLongExtra("sns_landing_pages_pageid", 0);
        if (TextUtils.isEmpty(stringExtra) && intent.getIntExtra("sns_landing_pages_no_store", 0) != 1) {
            stringExtra = i.bgZ().e(longExtra, 0, 0);
            intent.putExtra("sns_landing_pages_xml", stringExtra);
        }
        getIntent().getIntExtra("sns_landig_pages_from_source", 1);
        if (TextUtils.isEmpty(stringExtra) && longExtra > 0) {
            w.e("SnsAdNativeLandingPagesPreviewUI", "intent without canvas xml, pageId %d", new Object[]{Long.valueOf(longExtra)});
            if (longExtra <= 0) {
                finish();
                return;
            }
            final View findViewById = findViewById(f.cts);
            findViewById.setVisibility(0);
            b.a aVar = new b.a();
            aVar.hsm = new tv();
            aVar.hsn = new tw();
            aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
            aVar.hsl = 1286;
            b BE = aVar.BE();
            ((tv) BE.hsj.hsr).tCb = longExtra;
            u.a(BE, new u.a(this) {
                final /* synthetic */ SnsAdNativeLandingPagesPreviewUI qxK;

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    findViewById.setVisibility(8);
                    if (i == 0 && i2 == 0) {
                        tw twVar = (tw) bVar.hsk.hsr;
                        w.i("SnsAdNativeLandingPagesPreviewUI", "getCanvasInfo pageid %d ,xml %s", new Object[]{Long.valueOf(longExtra), twVar.tCc});
                        if (!TextUtils.isEmpty(twVar.tCc)) {
                            intent.putExtra("sns_landing_pages_xml", twVar.tCc);
                            this.qxK.g(intent, twVar.tCc);
                            i.bgZ().n(longExtra, twVar.tCc);
                        }
                    } else {
                        w.e("SnsAdNativeLandingPagesPreviewUI", "cgi fail page id %d, errType %d,errCode %d", new Object[]{Long.valueOf(longExtra), Integer.valueOf(i), Integer.valueOf(i2)});
                    }
                    this.qxK.finish();
                    return 0;
                }
            });
        } else if (!g(intent, stringExtra)) {
            finish();
        }
    }

    private boolean g(Intent intent, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (e.Gb(str)) {
            w.i("SnsAdNativeLandingPagesPreviewUI", "isValidCanvas time cost " + (System.currentTimeMillis() - currentTimeMillis));
            e.A(intent, this);
            finish();
            if (intent.getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false)) {
                overridePendingTransition(0, 0);
                return true;
            }
            overridePendingTransition(com.tencent.mm.plugin.sns.i.a.aRN, com.tencent.mm.plugin.sns.i.a.aRM);
            return true;
        }
        w.i("SnsAdNativeLandingPagesPreviewUI", "unknown canvas goto webview, " + str);
        int indexOf = str.indexOf("<shareWebUrl>");
        if (indexOf >= 0) {
            int indexOf2 = str.indexOf("</shareWebUrl>");
            if (indexOf2 > indexOf + 13) {
                String substring = str.substring(indexOf + 13, indexOf2);
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", substring);
                intent2.putExtra("showShare", true);
                d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                finish();
                overridePendingTransition(com.tencent.mm.plugin.sns.i.a.aRN, com.tencent.mm.plugin.sns.i.a.aRM);
                return true;
            }
        }
        return false;
    }

    protected final int getLayoutId() {
        return g.pHi;
    }
}
