package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.plugin.sns.a.a.f;
import com.tencent.mm.plugin.sns.a.a.i;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.y.k;
import java.util.List;

@a(3)
public class SnsBrowseUI extends SnsBaseGalleryUI implements s.a {
    private String fJz;
    private int fLz = 0;
    private int jYp = 0;
    private int jYq = 0;
    Bundle klH;
    private boolean klI = false;
    g klJ;
    private int klK = 0;
    private int klL = 0;
    private int klM = 0;
    private int klN = 0;
    private ImageView lMk;
    private ae mHandler = new ae();
    private int qzd = 0;
    private boolean qze = false;
    private boolean qzf = false;
    private boolean qzg = false;
    private v qzh;
    private int qzi;
    private int qzj;
    private int qzk = 0;
    private float qzl = 1.0f;
    private int qzm = 0;
    private int qzn = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uSU.bQg();
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        KC();
        this.klH = bundle;
    }

    public void onDestroy() {
        b gz;
        if (this.qzb != null) {
            int intExtra = getIntent().getIntExtra("K_ad_scene", -1);
            SnsInfoFlip snsInfoFlip = this.qzb;
            String str = this.fJz;
            if (snsInfoFlip.pQJ) {
                if (intExtra < 0) {
                    w.i("MicroMsg.SnsInfoFlip", "pass by scene " + intExtra);
                } else {
                    m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(str);
                    if (Gg != null) {
                        if (snsInfoFlip.qCr >= 0) {
                            long longValue = snsInfoFlip.qBT.containsKey(Integer.valueOf(snsInfoFlip.qCr)) ? ((Long) snsInfoFlip.qBT.get(Integer.valueOf(snsInfoFlip.qCr))).longValue() : 0;
                            if (longValue > 0) {
                                long longValue2 = snsInfoFlip.qBU.containsKey(Integer.valueOf(snsInfoFlip.qCr)) ? ((Long) snsInfoFlip.qBU.get(Integer.valueOf(snsInfoFlip.qCr))).longValue() : 0;
                                longValue = bg.aB(longValue);
                                longValue2 += longValue;
                                snsInfoFlip.qBU.put(Integer.valueOf(snsInfoFlip.qCr), Long.valueOf(longValue2));
                                w.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + snsInfoFlip.qCr + " curtime " + longValue2 + " passtime " + longValue);
                            }
                        }
                        e bhJ = Gg.bhJ();
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer.append("<desc>");
                        String str2 = "<item><id>%d</id><duration>%d</duration><count>%d</count></item>";
                        String str3 = "%d|%d|%d";
                        for (Integer num : snsInfoFlip.qBS.keySet()) {
                            int intValue = ((Integer) snsInfoFlip.qBS.get(num)).intValue();
                            int longValue3 = snsInfoFlip.qBU.containsKey(num) ? (int) (((Long) snsInfoFlip.qBU.get(num)).longValue() * 1) : 0;
                            stringBuffer.append(String.format(str2, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}));
                            stringBuffer2.append(String.format(str3, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}) + "&");
                        }
                        stringBuffer.append("</desc>");
                        str = stringBuffer2.toString();
                        str2 = str.endsWith("&") ? str.substring(0, str.length() - 1) : str;
                        i beF = com.tencent.mm.plugin.sns.model.ae.beF();
                        Object[] objArr = new Object[1];
                        objArr[0] = f.a(Gg.field_snsId, com.tencent.mm.plugin.sns.data.i.df(Gg.field_snsId), Gg.bhI(), Integer.valueOf(intExtra), Long.valueOf(snsInfoFlip.qCj), Long.valueOf(System.currentTimeMillis()), str2, Integer.valueOf(snsInfoFlip.getCount()));
                        beF.i(12014, objArr);
                        if (bhJ.bha().qeJ != 1) {
                            k cVar = new c(Gg.bhH(), 6, intExtra, stringBuffer.toString(), Gg.bhL());
                            h.vJ();
                            h.vH().gXC.a(cVar, 0);
                        }
                        gz = b.gz(729);
                        gz.kG(com.tencent.mm.plugin.sns.data.i.df(Gg.field_snsId)).kG(Gg.bhI()).gC(intExtra).kG(snsInfoFlip.qCj).kG(System.currentTimeMillis()).kG(str2).gC(snsInfoFlip.getCount());
                        gz.JE();
                    }
                }
            }
        }
        gz = b.o(getIntent());
        if (gz != null) {
            this.qzb.qCs.size();
            gz.gC(this.qzb.getCount()).gC(this.qzb.bkr());
            gz.update();
            gz.JE();
        }
        this.qzb.bkp();
        this.qzb.onDestroy();
        com.tencent.mm.plugin.sns.model.ae.beI().Q(this);
        if (this.qze) {
            this.qzb.bkt();
        }
        if (this.qzh != null) {
            this.qzh.stop();
        }
        super.onDestroy();
    }

    protected void onPause() {
        if (this.qzb != null) {
            this.qzb.onPause();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (this.qzb != null) {
            this.qzb.asx();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.pHp;
    }

    public void onStart() {
        Bundle bundle = this.klH;
        if (!this.klI) {
            this.klI = true;
            if (VERSION.SDK_INT >= 12) {
                this.klK = getIntent().getIntExtra("img_gallery_top", 0);
                this.klL = getIntent().getIntExtra("img_gallery_left", 0);
                this.klM = getIntent().getIntExtra("img_gallery_width", 0);
                this.klN = getIntent().getIntExtra("img_gallery_height", 0);
                this.klJ.p(this.klL, this.klK, this.klM, this.klN);
                if (bundle == null) {
                    this.qzb.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ SnsBrowseUI qzo;

                        {
                            this.qzo = r1;
                        }

                        public final boolean onPreDraw() {
                            this.qzo.qzb.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.qzo.jYp = this.qzo.qzb.getWidth();
                            this.qzo.jYq = this.qzo.qzb.getHeight();
                            this.qzo.qzi = this.qzo.qzb.getWidth();
                            this.qzo.qzj = this.qzo.qzb.getHeight();
                            com.tencent.mm.plugin.sns.model.ae.beI();
                            String B = com.tencent.mm.plugin.sns.model.g.B(this.qzo.qzb.biS());
                            if (B != null) {
                                Options Pe = d.Pe(B);
                                this.qzo.qzj = (int) (((float) Pe.outHeight) * (((float) this.qzo.qzi) / ((float) Pe.outWidth)));
                                if (this.qzo.qzj > this.qzo.qzb.getHeight()) {
                                    this.qzo.qzj = this.qzo.qzb.getHeight();
                                }
                            }
                            this.qzo.klJ.ek(this.qzo.qzi, this.qzo.qzj);
                            this.qzo.klJ.a(this.qzo.qzb, this.qzo.lMk, null);
                            this.qzo.bjQ();
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        w.d("MicroMsg.SnsPopMediasUI", "onStart ");
    }

    public final void adz() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        ahz();
        return true;
    }

    protected final void KC() {
        this.klJ = new g(this.uSU.uTo);
        this.klI = false;
        String ap = bg.ap(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.fJz = bg.ap(getIntent().getStringExtra("sns_gallery_localId"), "");
        this.qzd = getIntent().getIntExtra("sns_gallery_position", 0);
        this.fLz = getIntent().getIntExtra("sns_position", 0);
        this.qze = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
        this.qzf = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
        this.qzg = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
        m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(this.fJz);
        this.lMk = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.bSt);
        this.lMk.setLayerType(2, null);
        this.qzb = new SnsInfoFlip(this);
        this.qzb.setLayerType(2, null);
        this.qzb.qze = this.qze;
        this.qzb.qti = true;
        List Fn = ai.Fn(this.fJz);
        this.qzb.qBV = true;
        this.qzb.qBX = true;
        this.qzb.tU(Gg.field_type);
        this.qzb.qzg = this.qzg;
        this.qzb.a(Fn, ap, this.qzd, this.qyW, this);
        SnsInfoFlip snsInfoFlip = this.qzb;
        an bLR = an.bLR();
        bLR.cIm = Gg.field_createTime;
        snsInfoFlip.pQT = bLR;
        addView(this.qzb);
        if (Gg != null && Gg.tE(32)) {
            this.qzb.pQJ = true;
        }
        this.qzc = (Button) findViewById(com.tencent.mm.plugin.sns.i.f.pCC);
        final bfc bhd = Gg.bhd();
        final as asVar = bhd != null ? bhd.pYt : null;
        ax axVar = new ax();
        af.a(this, axVar, bhd.pYt);
        if (axVar.qJb) {
            this.qzc.setVisibility(0);
            this.qzc.setText(axVar.qJc);
            this.qzc.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsBrowseUI qzo;

                public final void onClick(View view) {
                    if (asVar.tdQ != null) {
                        String bm = com.tencent.mm.plugin.sns.c.a.imw.bm(asVar.tdQ.mtb);
                        int i = 0;
                        if (bhd.ufB.tsN == 1) {
                            i = 2;
                        } else if (bhd.ufB.tsN == 3) {
                            i = 5;
                        } else if (bhd.ufB.tsN == 15) {
                            i = 4;
                        }
                        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bhd, this.qzo)) {
                            com.tencent.mm.plugin.sns.c.a.imw.a(this.qzo, asVar.tdQ.mtb, bm, bhd.jNj, i, 18, 9, asVar.tdQ.tdJ, bhd.mQY);
                            return;
                        }
                        com.tencent.mm.sdk.b.b ghVar;
                        switch (asVar.jOc) {
                            case 4:
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", asVar.msN);
                                com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qzo);
                                com.tencent.mm.plugin.sns.c.a.imw.a(this.qzo, asVar.tdQ.mtb, bm, bhd.jNj, i, 18, 1, asVar.tdQ.tdJ, bhd.mQY);
                                return;
                            case 5:
                                if (asVar.tdM == 1) {
                                    ghVar = new gh();
                                    ghVar.fLB.actionCode = 2;
                                    ghVar.fLB.scene = 3;
                                    ghVar.fLB.appId = asVar.tdQ.mtb;
                                    ghVar.fLB.context = this.qzo;
                                    com.tencent.mm.sdk.b.a.urY.m(ghVar);
                                    com.tencent.mm.plugin.sns.c.a.imw.a(this.qzo, asVar.tdQ.mtb, bm, bhd.jNj, i, 18, 6, asVar.tdQ.tdJ, bhd.mQY);
                                    return;
                                }
                                return;
                            case 6:
                                int a = af.a(this.qzo, asVar);
                                if (a == 1) {
                                    ghVar = new gh();
                                    ghVar.fLB.context = this.qzo;
                                    ghVar.fLB.actionCode = 2;
                                    ghVar.fLB.appId = asVar.tdQ.mtb;
                                    ghVar.fLB.messageAction = asVar.tdQ.tdL;
                                    ghVar.fLB.messageExt = asVar.tdQ.tdK;
                                    ghVar.fLB.scene = 3;
                                    com.tencent.mm.sdk.b.a.urY.m(ghVar);
                                    com.tencent.mm.plugin.sns.c.a.imw.a(this.qzo, asVar.tdQ.mtb, bm, bhd.jNj, i, 18, 6, asVar.tdQ.tdJ, bhd.mQY);
                                    return;
                                } else if (a == 2) {
                                    com.tencent.mm.sdk.b.b ghVar2 = new gh();
                                    ghVar2.fLB.context = this.qzo;
                                    ghVar2.fLB.actionCode = 1;
                                    ghVar2.fLB.appId = asVar.tdQ.mtb;
                                    ghVar2.fLB.messageAction = asVar.tdQ.tdL;
                                    ghVar2.fLB.messageExt = asVar.tdQ.tdK;
                                    ghVar2.fLB.scene = 3;
                                    com.tencent.mm.sdk.b.a.urY.m(ghVar2);
                                    com.tencent.mm.plugin.sns.c.a.imw.a(this.qzo, asVar.tdQ.mtb, bm, bhd.jNj, i, 18, 3, asVar.tdQ.tdJ, bhd.mQY);
                                    return;
                                } else {
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                }
            });
        } else {
            this.qzc.setVisibility(8);
        }
        if (!com.tencent.mm.plugin.sns.lucky.a.m.h(Gg)) {
            w.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + Gg.field_userName + " " + Gg.field_snsId);
            finish();
        } else if (Gg.field_type == 21 && !Gg.field_userName.equals(com.tencent.mm.u.m.xL())) {
            this.qzh = new v(com.tencent.mm.compatible.util.e.hgs + "/Pictures/Screenshots/", new v.a(this) {
                final /* synthetic */ SnsBrowseUI qzo;

                {
                    this.qzo = r1;
                }

                public final void bjR() {
                    com.tencent.mm.plugin.sns.lucky.a.b.mN(44);
                    com.tencent.mm.plugin.sns.lucky.b.a.a(4, com.tencent.mm.plugin.sns.model.ae.beL().Gg(this.qzo.fJz));
                }
            });
            this.qzh.start();
        }
    }

    public final void ahz() {
        int i = this.klM;
        int i2 = this.klN;
        int i3 = this.klL;
        int i4 = this.klK;
        if (!this.qzf) {
            com.tencent.mm.sdk.b.b ggVar = new gg();
            ggVar.fLx.fLA = this.qzb.qBQ.getSelectedItemPosition();
            ggVar.fLx.fLz = this.fLz;
            com.tencent.mm.sdk.b.a.urY.m(ggVar);
            i = ggVar.fLy.fEd;
            i2 = ggVar.fLy.fEe;
            i3 = ggVar.fLy.fEb;
            i4 = ggVar.fLy.fEc;
        }
        this.qzi = this.qzb.getWidth();
        this.qzj = this.qzb.getHeight();
        com.tencent.mm.plugin.sns.model.ae.beI();
        String B = com.tencent.mm.plugin.sns.model.g.B(this.qzb.biS());
        if (B != null) {
            Options Pe = d.Pe(B);
            this.qzj = (int) (((float) Pe.outHeight) * (((float) this.qzi) / ((float) Pe.outWidth)));
            if (this.qzj > this.qzb.getHeight()) {
                if (((double) this.qzj) < ((double) this.qzb.getHeight()) * 2.5d) {
                    this.qzk = this.qzj - this.qzb.getHeight();
                    if (this.qzb.getCount() == 1) {
                        i2 = (i2 * this.qzb.getHeight()) / this.qzj;
                        this.qzk = 0;
                    }
                }
                this.qzj = this.qzb.getHeight();
            }
        }
        this.klJ.ek(this.qzi, this.qzj);
        this.klJ.p(i3, i4, i, i2);
        if (((double) this.qzl) != 1.0d) {
            this.klJ.wmy = 1.0f / this.qzl;
            if (!(this.qzm == 0 && this.qzn == 0)) {
                this.klJ.el(((int) (((float) (this.qzb.getWidth() / 2)) * (1.0f - this.qzl))) + this.qzm, (int) (((float) ((this.qzb.getHeight() / 2) + this.qzn)) - (((float) (this.qzj / 2)) * this.qzl)));
            }
        }
        this.klJ.qoq = this.qzk;
        this.klJ.a(this.qzb, this.lMk, new g.b(this) {
            final /* synthetic */ SnsBrowseUI qzo;

            {
                this.qzo = r1;
            }

            public final void onAnimationStart() {
                SnsInfoFlip snsInfoFlip = this.qzo.qzb;
                if (snsInfoFlip.qCd != null) {
                    snsInfoFlip.qCd.setVisibility(8);
                }
                this.qzo.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qzr;

                    {
                        this.qzr = r1;
                    }

                    public final void run() {
                        SnsInfoFlip snsInfoFlip = this.qzr.qzo.qzb;
                        if (snsInfoFlip.qBQ != null) {
                            View selectedView = snsInfoFlip.qBQ.getSelectedView();
                            if (selectedView instanceof MultiTouchImageView) {
                                ((MultiTouchImageView) selectedView).bSJ();
                            }
                        }
                    }
                }, 20);
            }

            public final void onAnimationEnd() {
                this.qzo.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qzr;

                    {
                        this.qzr = r1;
                    }

                    public final void run() {
                        this.qzr.qzo.finish();
                        this.qzr.qzo.overridePendingTransition(0, 0);
                    }
                });
            }
        }, new g.a(this) {
            final /* synthetic */ SnsBrowseUI qzo;

            {
                this.qzo = r1;
            }

            public final void q(int i, int i2, int i3, int i4) {
                if (this.qzo.qzb.qBQ != null && VERSION.SDK_INT >= 18) {
                    this.qzo.qzb.qBQ.setClipBounds(new Rect(i, i2, i3, i4));
                }
            }
        });
    }

    public final void bjQ() {
        final Gallery gallery = this.qzb.qBQ;
        if (gallery instanceof MMGestureGallery) {
            ((MMGestureGallery) gallery).wmV = new MMGestureGallery.b(this) {
                final /* synthetic */ SnsBrowseUI qzo;

                public final void C(float f, float f2) {
                    if ((this.qzo.jYq == 0 || this.qzo.jYp == 0) && this.qzo.qzb != null) {
                        this.qzo.jYq = this.qzo.qzb.getHeight();
                        this.qzo.jYp = this.qzo.qzb.getWidth();
                    }
                    if (this.qzo.jYq != 0) {
                        float f3 = 1.0f - (f2 / ((float) this.qzo.jYq));
                        if (f3 > 1.0f) {
                            f3 = 1.0f;
                        }
                        this.qzo.qzl = f3;
                        View selectedView = ((MMGestureGallery) gallery).getSelectedView();
                        if (selectedView instanceof MultiTouchImageView) {
                            selectedView.setPivotX((float) (this.qzo.jYp / 2));
                            selectedView.setPivotY((float) (this.qzo.jYq / 2));
                            selectedView.setScaleX(f3);
                            selectedView.setScaleY(f3);
                            selectedView.setTranslationX(f);
                            selectedView.setTranslationY(f2);
                            this.qzo.lMk.setAlpha(f3);
                        }
                    }
                }

                public final void D(float f, float f2) {
                    this.qzo.qzm = (int) f;
                    this.qzo.qzn = (int) f2;
                }
            };
        }
    }

    public final void bN(String str, int i) {
        w.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(true), str});
        if (this.qzb != null) {
            this.qzb.asx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int Ol() {
        return 2;
    }

    public final void bO(String str, int i) {
        this.qzd = i;
    }
}
