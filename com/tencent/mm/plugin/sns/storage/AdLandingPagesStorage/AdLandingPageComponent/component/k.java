package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.net.URI;

public class k extends j {
    RelativeLayout ned;
    Button qig;

    public k(Context context, i iVar, ViewGroup viewGroup) {
        super(context, iVar, viewGroup);
    }

    protected final i bgs() {
        return (i) this.qib;
    }

    protected final int aTQ() {
        return g.pGX;
    }

    @TargetApi(17)
    protected final void bgl() {
        boolean z = true;
        this.qhP = 0;
        int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
        this.ned.setBackgroundColor(this.backgroundColor);
        if (bg.mA(((i) this.qib).qft)) {
            boolean z2;
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (bg.mA(((i) this.qib).qfs) || ((i) this.qib).qfq <= 0.0f) {
                z2 = false;
            } else {
                int parseColor;
                try {
                    parseColor = Color.parseColor(((i) this.qib).qfs);
                } catch (Throwable e) {
                    w.e("MicroMsg.Sns.AdLandingPageBtnComponent", bg.g(e));
                    parseColor = 0;
                }
                gradientDrawable.setStroke((int) ((i) this.qib).qfq, parseColor);
                z2 = true;
            }
            if (bg.mA(((i) this.qib).qfr)) {
                z = z2;
            } else {
                int parseColor2;
                try {
                    parseColor2 = Color.parseColor(((i) this.qib).qfr);
                } catch (Throwable e2) {
                    w.e("MicroMsg.Sns.AdLandingPageBtnComponent", bg.g(e2));
                    parseColor2 = 0;
                }
                gradientDrawable.setColor(parseColor2);
            }
            if (z) {
                this.qig.setBackgroundDrawable(gradientDrawable);
            }
        } else {
            d.a("adId", ((i) this.qib).qft, false, 0, 0, new a(this) {
                final /* synthetic */ k qih;

                {
                    this.qih = r1;
                }

                public final void bgn() {
                }

                public final void bgo() {
                }

                @TargetApi(16)
                public final void FW(String str) {
                    try {
                        this.qih.qig.setBackground(Drawable.createFromPath(str));
                    } catch (Exception e) {
                        w.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                    }
                }
            });
        }
        this.qig.setText(((i) this.qib).title);
        d(this.qig);
        this.qig.setTextSize(0, ((i) this.qib).qfp);
        if (((i) this.qib).qfo != null && ((i) this.qib).qfo.length() > 0) {
            this.qig.setTextColor(Color.parseColor(((i) this.qib).qfo));
        }
        try {
            this.qig.setTextAlignment(4);
        } catch (Exception e3) {
            w.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        this.qig.setLayoutParams(new LayoutParams((width - ((int) ((i) this.qib).qfM)) - ((int) ((i) this.qib).qfN), this.qig.getLayoutParams().height));
    }

    protected void d(Button button) {
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ k qih;

            {
                this.qih = r1;
            }

            public final void onClick(View view) {
                this.qih.bgr();
                this.qih.bgt();
            }
        });
    }

    protected final void bgt() {
        i iVar = (i) this.qib;
        if (iVar.fEC == 4) {
            f fVar = (f) iVar;
            w.i("MicroMsg.Sns.AdLandingPageBtnComponent", "ext is " + fVar.kfp);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", fVar.kez);
            intent.putExtra("key_card_ext", fVar.kfp);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            com.tencent.mm.bb.d.b(this.context, "card", ".ui.CardDetailUI", intent);
            return;
        }
        String k;
        Intent intent2 = new Intent();
        String str = iVar.qfm;
        try {
            if (!(TextUtils.isEmpty(iVar.qdW) || TextUtils.isEmpty(iVar.qdX))) {
                k = k(str, "traceid=" + iVar.qdW + "&aid=" + iVar.qdX);
                w.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[]{k});
                intent2.putExtra("rawUrl", k);
                intent2.putExtra("useJs", true);
                intent2.putExtra(Columns.TYPE, -255);
                intent2.putExtra("geta8key_scene", 2);
                com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent2);
            }
        } catch (Throwable e) {
            w.e("MicroMsg.Sns.AdLandingPageBtnComponent", bg.g(e));
        }
        k = str;
        w.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[]{k});
        intent2.putExtra("rawUrl", k);
        intent2.putExtra("useJs", true);
        intent2.putExtra(Columns.TYPE, -255);
        intent2.putExtra("geta8key_scene", 2);
        com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent2);
    }

    @TargetApi(17)
    public final View bgf() {
        View view = this.ipu;
        this.ned = (RelativeLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.pEc);
        this.qig = (Button) view.findViewById(com.tencent.mm.plugin.sns.i.f.pEb);
        return view;
    }

    private static String k(String str, String... strArr) {
        URI uri = new URI(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(strArr[0]).append("&");
        }
        if (stringBuilder.length() <= 1) {
            return str;
        }
        String stringBuilder2;
        StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String query = uri.getQuery();
        if (query == null) {
            stringBuilder2 = deleteCharAt.toString();
        } else {
            stringBuilder2 = query + "&" + deleteCharAt.toString();
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
    }
}
