package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.cj;
import com.tencent.mm.plugin.game.c.ck;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.ad.a;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public class GameDetailRankLikeView extends LinearLayout implements OnClickListener {
    String ivH;
    int mqT;
    ad myY;
    a myZ;
    private Drawable mza;
    private Drawable mzb;
    private Animation mzc;
    private ImageView mzd;
    private TextView mze;

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mza = getContext().getResources().getDrawable(R.g.bfx);
        this.mzb = getContext().getResources().getDrawable(R.g.bfw);
        this.mzc = AnimationUtils.loadAnimation(getContext(), R.a.aRC);
        inflate(getContext(), R.i.dew, this);
        setOnClickListener(this);
        this.mzd = (ImageView) findViewById(R.h.cbk);
        this.mze = (TextView) findViewById(R.h.cbl);
    }

    final void aBR() {
        if (this.myZ != null) {
            if (this.myZ.mrg) {
                this.mzd.setImageDrawable(this.mza);
            } else {
                this.mzd.setImageDrawable(this.mzb);
            }
            int i = this.myZ.mrf;
            if (i > 99) {
                this.mze.setText("99+");
                return;
            } else if (i == 0) {
                this.mze.setText("");
                return;
            } else {
                this.mze.setText(String.valueOf(i));
                return;
            }
        }
        setVisibility(8);
    }

    public void onClick(View view) {
        if (m.xL().equals(this.myZ.fSf)) {
            if (this.myZ.mrf > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.ivH);
                getContext().startActivity(intent);
            }
        } else if (!this.myZ.mrg) {
            this.myZ.mrg = true;
            a aVar = this.myZ;
            aVar.mrf++;
            this.myY.aBj();
            String str = this.ivH;
            String str2 = this.myZ.fSf;
            b.a aVar2 = new b.a();
            aVar2.hsm = new cj();
            aVar2.hsn = new ck();
            aVar2.uri = "/cgi-bin/mmgame-bin/upfriend";
            aVar2.hsl = 1330;
            b BE = aVar2.BE();
            cj cjVar = (cj) BE.hsj.hsr;
            cjVar.msh = str;
            cjVar.mvU = str2;
            u.a(BE, new u.a(this) {
                final /* synthetic */ GameDetailRankLikeView mzf;

                {
                    this.mzf = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (!(i == 0 && i2 == 0)) {
                        w.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    }
                    return 0;
                }
            });
            ai.a(getContext(), 12, 1203, 1, 2, this.ivH, this.mqT, null);
            aBR();
            this.mzd.startAnimation(this.mzc);
        }
    }
}
