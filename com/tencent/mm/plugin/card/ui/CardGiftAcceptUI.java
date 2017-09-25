package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.m.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@a(3)
public class CardGiftAcceptUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.CardGiftAcceptUI";
    private String fPs;
    private String fTJ;
    private int hiC;
    private String hiD;
    private p irJ = null;
    private RelativeLayout kln;
    private RelativeLayout klo;
    private ImageView klp;
    private TextView klq;
    private TextView klr;
    private ImageView kls;
    private Button klt;
    private LinearLayout klu;
    private TextView klv;
    private ImageView klw;
    private RelativeLayout klx;
    private ag kly;
    private q klz;

    protected final int getLayoutId() {
        return R.i.cWv;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hiD = getIntent().getStringExtra("key_order_id");
        this.hiC = getIntent().getIntExtra("key_biz_uin", -1);
        this.fTJ = getIntent().getStringExtra("key_from_user_name");
        this.fPs = getIntent().getStringExtra("key_chatroom_name");
        w.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[]{this.hiD, Integer.valueOf(this.hiC), this.fTJ});
        if (this.hiC == -1) {
            w.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            d.a(this, "", true);
        } else if (this.hiD == null) {
            w.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            d.a(this, "", true);
        } else {
            if (!bg.mA(this.fTJ)) {
                g.oUh.i(13866, new Object[]{Integer.valueOf(1), this.hiD, o.getString(this.hiC), this.fTJ});
            }
            KC();
            ap.vd().a(1171, this);
            ap.vd().a(1136, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1171, this);
        ap.vd().b(1136, this);
    }

    protected final void KC() {
        this.kln = (RelativeLayout) findViewById(R.h.bwW);
        this.klo = (RelativeLayout) findViewById(R.h.bxd);
        this.klp = (ImageView) findViewById(R.h.bxe);
        this.klq = (TextView) findViewById(R.h.bxf);
        this.klr = (TextView) findViewById(R.h.bxb);
        this.kls = (ImageView) findViewById(R.h.bZU);
        this.klt = (Button) findViewById(R.h.bxh);
        this.klv = (TextView) findViewById(R.h.bxc);
        this.klx = (RelativeLayout) findViewById(R.h.bxg);
        this.klw = (ImageView) findViewById(R.h.bxa);
        this.klu = (LinearLayout) findViewById(R.h.cqs);
        this.klx.setOnClickListener(this);
        this.kln.setOnClickListener(this);
        this.klo.setOnClickListener(this);
        this.klu.setOnClickListener(this);
        this.uSU.ipu.setVisibility(8);
        this.irJ = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.cbS), true, new OnCancelListener(this) {
            final /* synthetic */ CardGiftAcceptUI klA;

            {
                this.klA = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.klA.irJ != null && this.klA.irJ.isShowing()) {
                    this.klA.irJ.dismiss();
                }
                w.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
                this.klA.finish();
            }
        });
        ap.vd().a(new ag(this.hiC, this.hiD, this.fPs), 0);
        if (this.irJ != null) {
            this.irJ.show();
        }
    }

    private void bH(int i, int i2) {
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(2, i);
        gradientDrawable.setCornerRadius(6.0f);
        this.klt.setBackground(gradientDrawable);
    }

    public void onClick(View view) {
        if (view.getId() == R.h.bxh || view.getId() == R.h.cqs) {
            if (this.klt.getVisibility() == 0) {
                int aF = bg.aF(this.kly.kgc, getResources().getColor(R.e.aTl));
                bH(aF, aF);
                this.klt.setTextColor(getResources().getColor(R.e.white));
            }
            ahy();
            if (!bg.mA(this.fTJ)) {
                g.oUh.i(13866, new Object[]{Integer.valueOf(2), this.hiD, o.getString(this.hiC), this.fTJ});
            }
        } else if (view.getId() == R.h.bxg) {
            finish();
        } else if (view.getId() == R.h.bwW) {
            finish();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.dismiss();
            }
            if (kVar instanceof ag) {
                w.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                d.a(this, str, true);
            } else if (kVar instanceof q) {
                w.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                d.a(this, str, true);
            }
        } else if (kVar instanceof ag) {
            this.kly = (ag) kVar;
            w.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[]{Boolean.valueOf(this.kly.kga)});
            if (this.kly.kga) {
                w.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
                ahy();
                return;
            }
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.dismiss();
            }
            if (this.kly == null) {
                w.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            } else {
                int fromDPToPix;
                this.klr.setText(this.kly.content);
                this.klq.setText(h.b(this, this.kly.fTJ, this.klq.getTextSize()));
                if (this.kly.status == 0) {
                    if (bg.mA(this.kly.kfZ)) {
                        this.klt.setVisibility(0);
                        this.klt.setText(getResources().getString(R.l.dQP));
                        this.klt.setOnClickListener(this);
                    } else {
                        this.klt.setVisibility(0);
                        this.klt.setText(this.kly.kfZ);
                        this.klt.setOnClickListener(this);
                    }
                } else if (this.kly.status == 1 || this.kly.status != 2) {
                    this.klt.setVisibility(8);
                    this.klt.setOnClickListener(null);
                } else if (bg.mA(this.kly.kfZ)) {
                    this.klt.setVisibility(8);
                    this.klt.setOnClickListener(null);
                } else {
                    this.klt.setVisibility(0);
                    this.klt.setBackgroundDrawable(null);
                    this.klt.setText(this.kly.kfZ);
                    this.klt.setTextColor(getResources().getColor(R.e.black));
                    this.klt.setTextSize(1, 17.0f);
                    this.klt.setOnClickListener(null);
                }
                if (!bg.mA(this.kly.kgd)) {
                    this.klt.setVisibility(8);
                    this.klu.setVisibility(0);
                    this.klv.setText(this.kly.kgd);
                }
                if (!bg.mA(this.kly.kfY)) {
                    fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this, 15);
                    c.a aVar = new c.a();
                    aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                    n.GX();
                    aVar.hJg = null;
                    aVar.hIN = m.sw(this.kly.kfY);
                    aVar.hIL = true;
                    aVar.hJi = true;
                    aVar.hJj = (float) fromDPToPix;
                    aVar.hIJ = true;
                    aVar.hJa = R.g.bhq;
                    n.GW().a(this.kly.kfY, this.klp, aVar.Hg());
                }
                if (!bg.mA(this.kly.kgb)) {
                    n.GW().a(this.kly.kgb, this.kls);
                }
                if (!bg.mA(this.kly.kgc) && this.klt.getVisibility() == 0) {
                    fromDPToPix = bg.aF(this.kly.kgc, getResources().getColor(R.e.aTl));
                    bH(fromDPToPix, getResources().getColor(R.e.aTk));
                    this.klt.setTextColor(fromDPToPix);
                }
                if (!bg.mA(this.kly.kgc) && this.klv.getVisibility() == 0) {
                    this.klv.setTextColor(bg.aF(this.kly.kgc, getResources().getColor(R.e.aTl)));
                    fromDPToPix = getResources().getColor(R.e.aTl);
                    if (!bg.mA(this.kly.kgc)) {
                        fromDPToPix = bg.aF(this.kly.kgc, fromDPToPix);
                    }
                    ImageView imageView = this.klw;
                    Drawable drawable = this.klw.getDrawable();
                    ColorStateList valueOf = ColorStateList.valueOf(fromDPToPix);
                    drawable = android.support.v4.b.a.a.g(drawable);
                    android.support.v4.b.a.a.a(drawable, valueOf);
                    imageView.setImageDrawable(drawable);
                }
            }
            View view = this.klo;
            Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new OvershootInterpolator());
            scaleAnimation.setFillAfter(true);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation.setAnimationListener(new 3(view, scaleAnimation2));
            if (view != null) {
                view.startAnimation(scaleAnimation);
            }
            this.uSU.ipu.setVisibility(0);
        } else if (kVar instanceof q) {
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.dismiss();
            }
            w.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
            this.klz = (q) kVar;
            Intent intent = new Intent(this, CardGiftReceiveUI.class);
            intent.putExtra("key_order_id", this.hiD);
            intent.putExtra("key_biz_uin", this.hiC);
            intent.putExtra("key_gift_into", this.klz.kfJ);
            intent.putExtra("key_from_group_chat_room", !bg.mA(this.fPs));
            startActivity(intent);
            finish();
        }
    }

    private void ahy() {
        ap.vd().a(new q(this.hiC, this.hiD, this.fPs), 0);
        if (this.irJ != null) {
            this.irJ.show();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            w.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.dismiss();
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
