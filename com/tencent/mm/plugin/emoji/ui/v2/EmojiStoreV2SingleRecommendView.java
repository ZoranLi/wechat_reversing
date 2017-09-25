package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.co;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.g.b;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.r;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class EmojiStoreV2SingleRecommendView extends LinearLayout implements OnClickListener, b {
    private ae jsW = new ae(this) {
        final /* synthetic */ EmojiStoreV2SingleRecommendView kZe;

        {
            this.kZe = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 131075:
                    int i = message.getData().getInt("progress");
                    if (bg.mA(message.getData().getString("product_id"))) {
                        w.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        return;
                    }
                    if (this.kZe.kYZ != null) {
                        this.kZe.kYZ.setVisibility(8);
                    }
                    if (this.kZe.kZa != null) {
                        this.kZe.kZa.setVisibility(0);
                        this.kZe.kZa.setProgress(i);
                        return;
                    }
                    return;
                case 131076:
                    message.getData().getInt(DownloadInfo.STATUS);
                    if (bg.mA(message.getData().getString("product_id"))) {
                        w.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        return;
                    }
                    if (this.kZe.kYZ != null) {
                        this.kZe.kYZ.setVisibility(0);
                    }
                    if (this.kZe.kZa != null) {
                        this.kZe.kZa.setVisibility(8);
                        this.kZe.kZa.setProgress(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public String kMI;
    protected final int kON = 131074;
    private final int kOO = 131075;
    private final int kOP = 131076;
    private final String kOQ = "product_id";
    private final String kOR = "progress";
    private final String kOS = DownloadInfo.STATUS;
    private g kOr;
    private String kRB;
    public ImageView kRi;
    public ViewGroup kYV;
    public ImageView kYW;
    public TextView kYX;
    public TextView kYY;
    public Button kYZ;
    public ProgressBar kZa;
    public a kZb;
    private boolean kZc = true;
    private c kZd = new c<co>(this) {
        final /* synthetic */ EmojiStoreV2SingleRecommendView kZe;

        {
            this.kZe = r2;
            this.usg = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            co coVar = (co) bVar;
            if (coVar instanceof co) {
                this.kZe.kRB = coVar.fFZ.fGb;
                if (!bg.mA(coVar.fFZ.fGa) && coVar.fFZ.fGa.equalsIgnoreCase(this.kZe.kMI)) {
                    EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = this.kZe;
                    String str = coVar.fFZ.fGa;
                    int i = coVar.fFZ.status;
                    int i2 = coVar.fFZ.progress;
                    String str2 = coVar.fFZ.fGb;
                    w.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        emojiStoreV2SingleRecommendView.i(obtain);
                    } else {
                        w.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", new Object[]{Integer.valueOf(i)});
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt(DownloadInfo.STATUS, i);
                        obtain2.what = 131076;
                        emojiStoreV2SingleRecommendView.i(obtain2);
                    }
                }
            }
            return false;
        }
    };

    public EmojiStoreV2SingleRecommendView(Context context, boolean z) {
        super(context);
        this.kZc = z;
        init();
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        com.tencent.mm.sdk.b.a.urY.b(this.kZd);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        com.tencent.mm.sdk.b.a.urY.c(this.kZd);
    }

    private void init() {
        if (this.kZc) {
            this.kYV = (ViewGroup) r.eC(getContext()).inflate(R.i.daT, this);
        } else {
            this.kYV = (ViewGroup) r.eC(getContext()).inflate(R.i.daU, this);
        }
        this.kRi = (ImageView) this.kYV.findViewById(R.h.bKW);
        this.kYW = (ImageView) this.kYV.findViewById(R.h.bLh);
        this.kYX = (TextView) this.kYV.findViewById(R.h.bLH);
        this.kYY = (TextView) this.kYV.findViewById(R.h.bLJ);
        this.kYZ = (Button) this.kYV.findViewById(R.h.beJ);
        this.kZa = (ProgressBar) this.kYV.findViewById(R.h.bLd);
    }

    public final void E(String str, String str2, String str3) {
        ap.vd().a(new g(str, str2, str3), 0);
    }

    public final void alT() {
    }

    public final void i(Message message) {
        if (this.jsW != null) {
            this.jsW.sendMessage(message);
        }
    }

    private void c(pn pnVar) {
        Intent intent = new Intent();
        intent.setClass(getContext(), EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", pnVar.tgW);
        intent.putExtra("extra_name", pnVar.tuV);
        intent.putExtra("extra_copyright", pnVar.tvf);
        intent.putExtra("extra_coverurl", pnVar.tvd);
        intent.putExtra("extra_description", pnVar.tuW);
        intent.putExtra("extra_price", pnVar.tuY);
        intent.putExtra("extra_type", pnVar.tuZ);
        intent.putExtra("extra_flag", pnVar.tva);
        intent.putExtra("extra_price_num", pnVar.tvg);
        intent.putExtra("extra_price_type", pnVar.tvh);
        intent.putExtra("preceding_scence", 108);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", 8);
        intent.putExtra("check_clickflag", false);
        getContext().startActivity(intent);
    }

    public void onClick(View view) {
        if (view == this.kRi) {
            h.amc().kLb.Sd(this.kMI);
            com.tencent.mm.plugin.report.service.g.oUh.i(12068, new Object[]{Integer.valueOf(2), this.kMI, Integer.valueOf(this.kZb.field_recommandType)});
        } else if (view == this.kYV) {
            c(this.kZb.bMX());
            com.tencent.mm.plugin.report.service.g.oUh.i(12068, new Object[]{Integer.valueOf(4), this.kMI, Integer.valueOf(this.kZb.field_recommandType)});
        } else if (view != this.kYZ) {
            w.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
        } else if (this.kZb.field_buttonType == 1) {
            this.kOr = new g(this.kMI);
            ap.vd().a(this.kOr, 0);
            com.tencent.mm.plugin.report.service.g.oUh.i(12068, new Object[]{Integer.valueOf(3), this.kMI, Integer.valueOf(this.kZb.field_recommandType)});
            com.tencent.mm.plugin.report.service.g.oUh.i(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(8), "", this.kMI});
        } else if (this.kZb.field_buttonType == 2) {
            c(this.kZb.bMX());
            com.tencent.mm.plugin.report.service.g.oUh.i(12068, new Object[]{Integer.valueOf(4), this.kMI, Integer.valueOf(this.kZb.field_recommandType)});
        } else {
            w.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
    }
}
