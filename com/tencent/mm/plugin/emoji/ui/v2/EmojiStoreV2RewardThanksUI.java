package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;

public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private String kMI;
    private ya kQW;
    private EmojiStoreV2RewardBannerView kXA;
    private View kXB;
    private MMCopiableTextView kXC;
    private TextView kXD;
    private TextView kXE;
    private AnimationDrawable kXF;
    private ae mHandler = new ae(this) {
        final /* synthetic */ EmojiStoreV2RewardThanksUI kXG;

        {
            this.kXG = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    String str = (String) message.obj;
                    if (bg.mA(str) || !e.aO(str)) {
                        w.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                        return;
                    }
                    this.kXG.kXA.ct(str, null);
                    this.kXG.kXA.setScaleType(ScaleType.FIT_XY);
                    if (this.kXG.kXF != null && this.kXG.kXF.isRunning()) {
                        this.kXG.kXF.stop();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    protected final int getLayoutId() {
        return R.i.daO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kMI = getIntent().getStringExtra("extra_id");
        KC();
        this.kQW = h.amc().kLf.So(this.kMI);
        if (this.kQW == null) {
            this.kXA.setBackgroundDrawable(getResources().getDrawable(R.g.beT));
            this.kXA.setImageDrawable(this.kXF);
            this.kXA.setScaleType(ScaleType.CENTER);
            this.kXF.start();
        } else if (this.kQW.tEC == null || bg.mA(this.kQW.tEC.tvw)) {
            this.kXA.setBackgroundDrawable(getResources().getDrawable(R.g.beT));
            this.kXA.setImageDrawable(this.kXF);
            this.kXA.setScaleType(ScaleType.CENTER);
            this.kXF.start();
        } else {
            final String str = this.kQW.tEC.tvx;
            ap.yY();
            final String C = EmojiLogic.C(c.xi(), this.kMI, str);
            if (e.aO(C)) {
                this.kXA.ct(C, null);
                this.kXA.setScaleType(ScaleType.FIT_XY);
                if (this.kXF != null && this.kXF.isRunning()) {
                    this.kXF.stop();
                }
            } else {
                n.GW().a(str, this.kXA, f.c(this.kMI, str, new Object[0]), new i(this) {
                    final /* synthetic */ EmojiStoreV2RewardThanksUI kXG;

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        if (!bg.mA(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
                            message.obj = C;
                            this.kXG.mHandler.sendMessage(message);
                        }
                    }
                });
                this.kXA.setBackgroundDrawable(getResources().getDrawable(R.g.beT));
                this.kXA.setImageDrawable(this.kXF);
                this.kXA.setScaleType(ScaleType.CENTER);
                this.kXF.start();
            }
        }
        if (this.kQW == null || this.kQW.tEC == null) {
            this.kXB.setVisibility(8);
            return;
        }
        this.kXB.setVisibility(0);
        bg.mA(this.kQW.tEC.tvz);
        this.kXC.setVisibility(0);
        this.kXC.setText(R.l.edG);
        this.kXD.setVisibility(8);
        this.kXE.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.kXF != null && this.kXF.isRunning()) {
            this.kXF.stop();
        }
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.edF);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardThanksUI kXG;

            {
                this.kXG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kXG.finish();
                return false;
            }
        });
        this.kXA = (EmojiStoreV2RewardBannerView) findViewById(R.h.cHV);
        this.kXA.gj = 1.0f;
        this.kXB = findViewById(R.h.cgD);
        this.kXC = (MMCopiableTextView) findViewById(R.h.cgF);
        this.kXD = (TextView) findViewById(R.h.cgC);
        this.kXE = (TextView) findViewById(R.h.cgE);
        this.kXF = (AnimationDrawable) getResources().getDrawable(R.g.beI);
    }

    protected final int Ol() {
        return 1;
    }
}
