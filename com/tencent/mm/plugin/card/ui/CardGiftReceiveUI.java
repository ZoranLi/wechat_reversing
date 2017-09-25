package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.n;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftReceiveUI extends MMActivity implements OnClickListener, e {
    private int hiC;
    private String hiD;
    private p irJ = null;
    private CardGiftInfo klB;
    private ProgressBar klF;
    private ae klG = new ae(Looper.getMainLooper());
    private ScrollView klR;
    private LinearLayout klS;
    private ImageView klT;
    private TextView klU;
    private TextView klV;
    private ImageView klW;
    private ImageView klX;
    private LinearLayout klY;
    private RelativeLayout klZ;
    private TextView kmA;
    private TextView kmB;
    private View kmC;
    com.tencent.mm.plugin.card.b.a.a kmD = new com.tencent.mm.plugin.card.b.a.a(this) {
        final /* synthetic */ CardGiftReceiveUI kmE;

        {
            this.kmE = r1;
        }

        public final void aB(String str, int i) {
            if (this.kmE.klB == null) {
                w.e("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress cardGiftInfo is null return!");
            } else if (bg.mA(str) || bg.mA(this.kmE.klB.kea) || !str.equals(this.kmE.klB.kea)) {
                this.kmE.klG.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 kmF;

                    {
                        this.kmF = r1;
                    }

                    public final void run() {
                        if (this.kmF.kmE.klF.getVisibility() != 0) {
                            this.kmF.kmE.klF.setVisibility(0);
                        }
                    }
                });
            } else {
                w.i("MicroMsg.CardGiftReceiveUI", "CDN  updateProgress fromUserContentVideoUrl return!");
            }
        }

        public final void fail(String str) {
            w.e("MicroMsg.CardGiftReceiveUI", "CDN download pic failure! fieldId:" + str);
        }

        public final void bA(final String str, final String str2) {
            w.i("MicroMsg.CardGiftReceiveUI", "CDN  download success! fieldId:" + str);
            if (this.kmE.klB == null) {
                w.e("MicroMsg.CardGiftReceiveUI", "CDN  download cardGiftInfo is null return!");
            } else if (bg.mA(str) || bg.mA(this.kmE.klB.kea) || !str.equals(this.kmE.klB.kea)) {
                this.kmE.klG.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 kmF;

                    public final void run() {
                        if (this.kmF.kmE.klF.getVisibility() != 8) {
                            this.kmF.kmE.klF.setVisibility(8);
                        }
                        if (bg.mA(str) || bg.mA(this.kmF.kmE.klB.keb) || !str.equals(this.kmF.kmE.klB.keb)) {
                            this.kmF.kmE.kmt.setVisibility(8);
                        } else {
                            this.kmF.kmE.kmt.setVisibility(0);
                        }
                        Bitmap mt = j.mt(str2);
                        if (mt == null) {
                            this.kmF.kmE.kmu.setImageResource(R.k.dwC);
                        } else {
                            this.kmF.kmE.kmu.setImageBitmap(mt);
                        }
                    }
                });
            } else {
                w.i("MicroMsg.CardGiftReceiveUI", "CDN  download fromUserContentVideoUrl! return");
            }
        }
    };
    private RelativeLayout kma;
    private TextView kmb;
    private ImageView kmc;
    private TextView kmd;
    private TextView kme;
    private TextView kmf;
    private ImageView kmg;
    private ImageView kmh;
    private View kmi;
    private TextView kmj;
    private LinearLayout kmk;
    private ListView kml;
    private RelativeLayout kmm;
    private LinearLayout kmn;
    private ImageView kmo;
    private TextView kmp;
    private LinearLayout kmq;
    private TextView kmr;
    private RelativeLayout kms;
    private RelativeLayout kmt;
    private ImageView kmu;
    private ImageView kmv;
    private TextView kmw;
    private TextView kmx;
    private ListView kmy;
    private RelativeLayout kmz;

    class a extends BaseAdapter {
        final /* synthetic */ CardGiftReceiveUI kmE;

        a(CardGiftReceiveUI cardGiftReceiveUI) {
            this.kmE = cardGiftReceiveUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return (AccepterItem) this.kmE.klB.keC.get(i);
        }

        public final int getCount() {
            return this.kmE.klB.keC.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AccepterItem accepterItem = (AccepterItem) this.kmE.klB.keC.get(i);
            if (view == null) {
                view = View.inflate(this.kmE, R.i.cWx, null);
                b bVar2 = new b(this.kmE);
                bVar2.kmG = (ImageView) view.findViewById(R.h.bXr);
                bVar2.kmH = (TextView) view.findViewById(R.h.cJT);
                bVar2.iUO = (TextView) view.findViewById(R.h.cJV);
                bVar2.kmI = (TextView) view.findViewById(R.h.cJU);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (accepterItem != null) {
                if (accepterItem.keK != null) {
                    ImageView imageView = bVar.kmG;
                    String str = accepterItem.keK;
                    int i2 = R.g.bhq;
                    if (!(imageView == null || TextUtils.isEmpty(str))) {
                        if (TextUtils.isEmpty(str)) {
                            imageView.setImageResource(i2);
                        } else {
                            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                            aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                            n.GX();
                            aVar.hJg = null;
                            aVar.hIN = m.sw(str);
                            aVar.hIL = true;
                            aVar.hJi = true;
                            aVar.hJj = 3.0f;
                            aVar.hIJ = true;
                            aVar.hIS = 34;
                            aVar.hIR = 34;
                            aVar.hJa = i2;
                            n.GW().a(str, imageView, aVar.Hg());
                        }
                    }
                }
                bVar.kmH.setText(accepterItem.keJ);
                bVar.iUO.setText(accepterItem.keH);
                bVar.kmI.setText(accepterItem.keI + this.kmE.uSU.uTo.getString(R.l.dQS));
            }
            return view;
        }
    }

    class b {
        public TextView iUO;
        final /* synthetic */ CardGiftReceiveUI kmE;
        public ImageView kmG;
        public TextView kmH;
        public TextView kmI;

        b(CardGiftReceiveUI cardGiftReceiveUI) {
            this.kmE = cardGiftReceiveUI;
        }
    }

    class c extends BaseAdapter {
        final /* synthetic */ CardGiftReceiveUI kmE;
        private LinkedList<AcceptedCardItem> kmJ;

        public final /* synthetic */ Object getItem(int i) {
            return kB(i);
        }

        c(CardGiftReceiveUI cardGiftReceiveUI, LinkedList<AcceptedCardItem> linkedList) {
            this.kmE = cardGiftReceiveUI;
            this.kmJ = linkedList;
        }

        public final int getCount() {
            return this.kmJ.size();
        }

        private AcceptedCardItem kB(int i) {
            return (AcceptedCardItem) this.kmJ.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            AcceptedCardItem kB = kB(i);
            if (view == null) {
                view = View.inflate(this.kmE, R.i.cWw, null);
                d dVar2 = new d(this.kmE);
                dVar2.iUO = (TextView) view.findViewById(R.h.cJX);
                dVar2.kmI = (TextView) view.findViewById(R.h.cJW);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.iUO.setText(kB.keH);
            dVar.kmI.setText(kB.keI + this.kmE.uSU.uTo.getString(R.l.dQS));
            return view;
        }
    }

    class d {
        public TextView iUO;
        final /* synthetic */ CardGiftReceiveUI kmE;
        public TextView kmI;

        d(CardGiftReceiveUI cardGiftReceiveUI) {
            this.kmE = cardGiftReceiveUI;
        }
    }

    static /* synthetic */ void a(CardGiftReceiveUI cardGiftReceiveUI, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(cardGiftReceiveUI, R.i.cWy, null);
        cardGiftReceiveUI.kmC = relativeLayout.findViewById(R.h.buL);
        cardGiftReceiveUI.kmA = (TextView) relativeLayout.findViewById(R.h.cKe);
        cardGiftReceiveUI.kmB = (TextView) relativeLayout.findViewById(R.h.cKd);
        cardGiftReceiveUI.kmA.setOnClickListener(cardGiftReceiveUI);
        cardGiftReceiveUI.kmB.setOnClickListener(cardGiftReceiveUI);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z) {
            if (cardGiftReceiveUI.kmz.getVisibility() == 0) {
                layoutParams.addRule(3, R.h.bmI);
            } else {
                layoutParams.addRule(3, R.h.bwZ);
            }
            layoutParams.bottomMargin = cardGiftReceiveUI.y(30);
            layoutParams.topMargin = cardGiftReceiveUI.y(40);
        } else {
            layoutParams.addRule(12, -1);
            layoutParams.bottomMargin = cardGiftReceiveUI.y(30);
            layoutParams.topMargin = cardGiftReceiveUI.y(40);
        }
        LayoutParams layoutParams2;
        if (cardGiftReceiveUI.kmz.getVisibility() == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            if (cardGiftReceiveUI.kms.getVisibility() == 0) {
                layoutParams2.topMargin = cardGiftReceiveUI.y(0);
                cardGiftReceiveUI.kmz.setLayoutParams(layoutParams2);
            } else {
                layoutParams2.topMargin = cardGiftReceiveUI.y(60);
            }
            cardGiftReceiveUI.kmz.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kmz.addView(relativeLayout, layoutParams);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.topMargin = cardGiftReceiveUI.y(60);
            cardGiftReceiveUI.kmm.setLayoutParams(layoutParams2);
            cardGiftReceiveUI.kmm.addView(relativeLayout, layoutParams);
        }
        if (bg.mA(cardGiftReceiveUI.klB.kew)) {
            cardGiftReceiveUI.kmA.setVisibility(8);
        } else {
            cardGiftReceiveUI.kmA.setVisibility(0);
            cardGiftReceiveUI.kmA.setText(cardGiftReceiveUI.klB.kew);
        }
        if (bg.mA(cardGiftReceiveUI.klB.kej)) {
            cardGiftReceiveUI.kmC.setVisibility(8);
            cardGiftReceiveUI.kmB.setVisibility(8);
            return;
        }
        cardGiftReceiveUI.kmC.setVisibility(0);
        cardGiftReceiveUI.kmB.setVisibility(0);
        cardGiftReceiveUI.kmB.setText(cardGiftReceiveUI.klB.kej);
    }

    protected final int getLayoutId() {
        return R.i.cWA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hiD = getIntent().getStringExtra("key_order_id");
        this.hiC = getIntent().getIntExtra("key_biz_uin", -1);
        this.klB = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        w.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[]{this.hiD, Integer.valueOf(this.hiC)});
        KC();
        ap.vd().a(1165, this);
        ap.vd().a(699, this);
        com.tencent.mm.plugin.card.b.a.a(this.kmD);
        if (this.klB == null) {
            w.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.hiC == -1) {
                w.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                return;
            }
            if (this.hiD == null) {
                w.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            w.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            ap.vd().a(new z(this.hiC, this.hiD), 0);
            this.irJ = g.a(this.uSU.uTo, getString(R.l.cbS), true, new OnCancelListener(this) {
                final /* synthetic */ CardGiftReceiveUI kmE;

                {
                    this.kmE = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.kmE.irJ != null && this.kmE.irJ.isShowing()) {
                        this.kmE.irJ.dismiss();
                    }
                    if (this.kmE.uSU.ipu.getVisibility() == 8 || this.kmE.uSU.ipu.getVisibility() == 4) {
                        w.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
                        this.kmE.finish();
                    }
                }
            });
            if (this.irJ != null) {
                this.irJ.show();
                return;
            }
            return;
        }
        agB();
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1165, this);
        ap.vd().b(699, this);
        com.tencent.mm.plugin.card.b.a.b(this.kmD);
    }

    private void agB() {
        if (this.klB == null) {
            w.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            return;
        }
        w.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[]{Integer.valueOf(this.klB.keq)});
        com.tencent.mm.ah.a.a.c.a aVar;
        if (this.klB.keq == 1 || this.klB.keq != 2) {
            this.klS.setVisibility(8);
            this.klY.setVisibility(0);
            this.kmd.setText(this.klB.keh);
            if (this.klB.keE == 1) {
                this.kmg.setAlpha(0.5f);
                this.kme.setVisibility(8);
                this.kmf.setVisibility(8);
                this.kma.setVisibility(8);
                this.klZ.setVisibility(8);
            } else {
                this.kme.setVisibility(0);
                this.kmf.setVisibility(0);
                this.kma.setVisibility(0);
                this.klZ.setVisibility(0);
                this.kme.setText(this.klB.kei);
                this.kmf.setText(R.l.dQS);
                if (bg.mA(this.klB.keu)) {
                    w.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardPriceTitleColor is empty");
                } else {
                    this.kme.setTextColor(bg.aF(this.klB.keu, getResources().getColor(R.e.black)));
                }
            }
            if (bg.mA(this.klB.kep)) {
                this.kmc.setVisibility(8);
                w.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.kmc.setVisibility(0);
                aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(this.klB.kep);
                aVar.hIL = true;
                aVar.hIJ = true;
                n.GW().a(this.klB.kep, this.kmc, aVar.Hg());
            }
            if (bg.mA(this.klB.keo)) {
                this.kmb.setVisibility(8);
                w.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
            } else {
                this.kmb.setVisibility(0);
                this.kmb.setText(this.klB.keo);
                if (bg.mA(this.klB.kes)) {
                    w.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
                } else {
                    this.kmb.setTextColor(bg.aF(this.klB.kes, getResources().getColor(R.e.black)));
                }
            }
            if (bg.mA(this.klB.ket)) {
                w.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.kmd.setTextColor(bg.aF(this.klB.ket, getResources().getColor(R.e.black)));
            }
            if (bg.mA(this.klB.keg)) {
                w.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(this.klB.keg);
                aVar.hJi = true;
                aVar.hIL = true;
                aVar.hIJ = true;
                aVar.hJb = new ColorDrawable(l.ta("#CCCCCC"));
                n.GW().a(this.klB.keg, this.kmh, aVar.Hg());
            }
            if (bg.mA(this.klB.kef)) {
                w.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(this.klB.kef);
                aVar.hIL = true;
                aVar.hIJ = true;
                aVar.hJb = new ColorDrawable(l.ta("#CCCCCC"));
                aVar.hJi = true;
                aVar.hJj = (float) com.tencent.mm.bg.a.fromDPToPix(this, 8);
                n.GW().a(this.klB.kef, this.kmg, aVar.Hg());
            }
        } else {
            this.klY.setVisibility(8);
            this.klS.setVisibility(0);
            this.klU.setText(this.klB.keo);
            this.klV.setText(this.klB.keh + "     " + this.klB.kei + this.uSU.uTo.getString(R.l.dQS));
            if (bg.mA(this.klB.kep)) {
                this.klT.setVisibility(8);
            } else {
                this.klT.setVisibility(0);
                aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(this.klB.kep);
                aVar.hIL = true;
                aVar.hIJ = true;
                n.GW().a(this.klB.kep, this.klT, aVar.Hg());
            }
            if (bg.mA(this.klB.kes)) {
                w.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descriptionTitleColor is empty");
            } else {
                this.klU.setTextColor(bg.aF(this.klB.kes, getResources().getColor(R.e.black)));
            }
            if (bg.mA(this.klB.ket)) {
                w.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.cardTitleColor is empty");
            } else {
                this.klV.setTextColor(bg.aF(this.klB.ket, getResources().getColor(R.e.black)));
            }
            if (bg.mA(this.klB.keg)) {
                w.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
            } else {
                aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(this.klB.keg);
                aVar.hJi = true;
                aVar.hIL = true;
                aVar.hIJ = true;
                aVar.hJb = new ColorDrawable(l.ta("#CCCCCC"));
                n.GW().a(this.klB.keg, this.klX, aVar.Hg());
            }
            if (bg.mA(this.klB.kef)) {
                w.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
            } else {
                aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(this.klB.kef);
                aVar.hIL = true;
                aVar.hIJ = true;
                aVar.hJb = new ColorDrawable(l.ta("#CCCCCC"));
                aVar.hJi = true;
                aVar.hJj = (float) com.tencent.mm.bg.a.fromDPToPix(this, 8);
                n.GW().a(this.klB.kef, this.klW, aVar.Hg());
            }
        }
        if (this.klB.keE == 1) {
            this.kmn.setVisibility(0);
            this.kmq.setVisibility(8);
            this.kmm.setVisibility(8);
            this.kmp.setText(h.b(this, this.klB.fTJ, this.kmp.getTextSize()));
            a(this.kmo);
        } else {
            this.kmn.setVisibility(8);
            this.kmq.setVisibility(0);
            this.kmm.setVisibility(0);
            a(this.kmv);
            this.kmw.setText(h.b(this, this.klB.fTJ, this.kmw.getTextSize()));
            if ((bg.mA(this.klB.kdZ) || "undefined".equals(this.klB.kdZ)) && (bg.mA(this.klB.kea) || "undefined".equals(this.klB.kea))) {
                this.kms.setVisibility(8);
                w.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
            } else {
                this.kms.setVisibility(0);
            }
            if (this.klB == null || bg.mA(this.klB.kdZ)) {
                w.e("MicroMsg.CardGiftReceiveUI", "fromUserContentPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.b.a.f(this.klB.kdZ, this.klB.kec, this.klB.kel, 2);
            }
            if (this.klB == null || bg.mA(this.klB.keb)) {
                w.e("MicroMsg.CardGiftReceiveUI", "fromUserContentThumbPicUrl is null");
            } else {
                com.tencent.mm.plugin.card.b.a.f(this.klB.keb, this.klB.kee, this.klB.ken, 2);
            }
            if (!bg.mA(this.klB.kdY)) {
                this.kmr.setText(h.b(this, this.klB.kdY, this.kmr.getTextSize()));
            }
        }
        agM();
        if (this.klB.keC.size() > 0) {
            this.kmz.setVisibility(0);
            this.kmy.setVisibility(0);
            this.kmy.setAdapter(new a(this));
            b(this.kmy);
            if (!bg.mA(this.klB.keD)) {
                this.kmx.setVisibility(0);
                this.kmx.setText(this.klB.keD);
            }
        } else {
            this.kmz.setVisibility(8);
            this.kmy.setVisibility(8);
            this.kmx.setVisibility(8);
        }
        if (bg.mA(this.klB.kew) && bg.mA(this.klB.kej)) {
            this.klR.setFillViewport(true);
        } else {
            this.klR.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ CardGiftReceiveUI kmE;

                {
                    this.kmE = r1;
                }

                public final void onGlobalLayout() {
                    w.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[]{Integer.valueOf(com.tencent.mm.bg.a.fromDPToPix(this.kmE.uSU.uTo, 67)), Integer.valueOf(this.kmE.klR.getChildAt(0).getHeight() + com.tencent.mm.bg.a.fromDPToPix(this.kmE.uSU.uTo, 67)), Integer.valueOf(this.kmE.getWindow().findViewById(16908290).getHeight())});
                    this.kmE.klR.setFillViewport(true);
                    if (this.kmE.klR.getChildAt(0).getHeight() + com.tencent.mm.bg.a.fromDPToPix(this.kmE.uSU.uTo, 67) > this.kmE.getWindow().findViewById(16908290).getHeight()) {
                        CardGiftReceiveUI.a(this.kmE, true);
                    } else {
                        CardGiftReceiveUI.a(this.kmE, false);
                    }
                    this.kmE.klR.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
    }

    private int y(int i) {
        return com.tencent.mm.bg.a.fromDPToPix(this.uSU.uTo, i);
    }

    private void a(ImageView imageView) {
        if (bg.mA(this.klB.kdX)) {
            w.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
            return;
        }
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this, 20);
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
        n.GX();
        aVar.hJg = null;
        aVar.hIN = m.sw(this.klB.kdX);
        aVar.hIL = true;
        aVar.hJi = true;
        aVar.hJj = 3.0f;
        aVar.hIJ = true;
        aVar.hIS = fromDPToPix;
        aVar.hIR = fromDPToPix;
        aVar.hJb = new ColorDrawable(l.ta("#CCCCCC"));
        n.GW().a(this.klB.kdX, imageView, aVar.Hg());
    }

    private void agM() {
        int i = 0;
        if (this.klB.keB.size() > 0) {
            this.kmi.setVisibility(0);
            this.kml.setVisibility(8);
            if (this.klB.keB.size() <= 2) {
                this.kmj.setVisibility(8);
                E(this.klB.keB);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.klB.keB.get(0));
            linkedList.add(this.klB.keB.get(1));
            E(linkedList);
            this.kmj.setVisibility(0);
            this.kmj.setOnClickListener(this);
            linkedList = new LinkedList();
            while (i < this.klB.keB.size()) {
                if (!(i == 0 || i == 1)) {
                    linkedList.add(this.klB.keB.get(i));
                }
                i++;
            }
            this.kml.setAdapter(new c(this, linkedList));
            b(this.kml);
            return;
        }
        this.kmi.setVisibility(8);
        this.kmj.setVisibility(8);
        this.kml.setVisibility(8);
    }

    private void E(LinkedList<AcceptedCardItem> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            AcceptedCardItem acceptedCardItem = (AcceptedCardItem) it.next();
            View inflate = View.inflate(this, R.i.cWw, null);
            TextView textView = (TextView) inflate.findViewById(R.h.cJW);
            ((TextView) inflate.findViewById(R.h.cJX)).setText(acceptedCardItem.keH);
            textView.setText(acceptedCardItem.keI + this.uSU.uTo.getString(R.l.dQS));
            this.kmk.addView(inflate);
        }
    }

    private static void b(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            int i = 0;
            for (int i2 = 0; i2 < count; i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    protected final void KC() {
        this.klR = (ScrollView) findViewById(R.h.bxi);
        this.klS = (LinearLayout) findViewById(R.h.byG);
        this.klT = (ImageView) findViewById(R.h.bZY);
        this.klU = (TextView) findViewById(R.h.cKr);
        this.klV = (TextView) findViewById(R.h.cKq);
        this.klW = (ImageView) findViewById(R.h.bZW);
        this.klX = (ImageView) findViewById(R.h.bZX);
        this.klW.setOnClickListener(this);
        this.klY = (LinearLayout) findViewById(R.h.byF);
        this.klZ = (RelativeLayout) findViewById(R.h.bsB);
        this.kma = (RelativeLayout) findViewById(R.h.bsD);
        this.kmb = (TextView) findViewById(R.h.cKa);
        this.kmd = (TextView) findViewById(R.h.cKp);
        this.kmc = (ImageView) findViewById(R.h.bZV);
        this.kme = (TextView) findViewById(R.h.cKt);
        this.kmf = (TextView) findViewById(R.h.cKu);
        this.kmg = (ImageView) findViewById(R.h.bZP);
        this.kmh = (ImageView) findViewById(R.h.bZQ);
        this.kmg.setOnClickListener(this);
        this.kmi = findViewById(R.h.bxD);
        this.kmj = (TextView) findViewById(R.h.cKs);
        this.kmk = (LinearLayout) findViewById(R.h.bxC);
        this.kml = (ListView) findViewById(R.h.bxE);
        this.kmm = (RelativeLayout) findViewById(R.h.bwY);
        this.kmn = (LinearLayout) findViewById(R.h.bVr);
        this.kmo = (ImageView) findViewById(R.h.bZS);
        this.kmp = (TextView) findViewById(R.h.cKh);
        this.kmq = (LinearLayout) findViewById(R.h.bVq);
        this.kmv = (ImageView) findViewById(R.h.bZR);
        this.kmw = (TextView) findViewById(R.h.cKg);
        this.kmr = (TextView) findViewById(R.h.cKf);
        this.kms = (RelativeLayout) findViewById(R.h.bxu);
        this.kmt = (RelativeLayout) findViewById(R.h.bXs);
        this.kmu = (ImageView) findViewById(R.h.cKi);
        this.kms.setOnClickListener(this);
        this.kmt.setOnClickListener(this);
        this.kmx = (TextView) findViewById(R.h.cJS);
        this.kmy = (ListView) findViewById(R.h.bmI);
        this.kmz = (RelativeLayout) findViewById(R.h.bwX);
        this.klF = (ProgressBar) findViewById(R.h.bXa);
        com.tencent.mm.plugin.card.b.m.b((MMActivity) this, false);
        qP("");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardGiftReceiveUI kmE;

            {
                this.kmE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kmE.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof z) {
                w.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.klB = ((z) kVar).kfJ;
                agB();
            } else if (kVar instanceof t) {
                Intent intent = new Intent(this, CardDetailUI.class);
                LinkedList linkedList = ((t) kVar).kfN;
                if (linkedList == null || linkedList.size() == 0) {
                    w.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardinfo list  size is null or empty!");
                    return;
                }
                com.tencent.mm.plugin.card.base.b bVar = (com.tencent.mm.plugin.card.base.b) linkedList.get(0);
                if (bVar == null || !(bVar instanceof CardInfo)) {
                    w.e("MicroMsg.CardGiftReceiveUI", "NetSceneBatchGetCardItemByTpInfo resp cardInfo  is null!");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add((CardInfo) it.next());
                }
                intent.putExtra("key_card_info", (CardInfo) bVar);
                intent.putExtra("key_previous_scene", 27);
                intent.putExtra("key_from_scene", 27);
                intent.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
                intent.putExtra("key_card_git_info", this.klB);
                startActivity(intent);
            }
        } else if (kVar instanceof z) {
            w.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.plugin.card.b.d.a(this, str, true);
        } else if (kVar instanceof t) {
            w.e("MicroMsg.CardGiftReceiveUI", ", NetSceneBatchGetCardItemByTpInfo onSceneEnd fail return!  errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.h.bXs) {
            if (!bg.mA(this.klB.kea)) {
                intent = new Intent(this, CardGiftVideoUI.class);
                intent.putExtra("key_gift_into", this.klB);
                intent.putExtra("key_is_mute", false);
                startActivity(intent);
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(3), this.hiD, o.getString(this.hiC)});
            }
        } else if (view.getId() == R.h.bxu) {
            if (this.klF.getVisibility() != 0 && !bg.mA(this.klB.kdZ)) {
                intent = new Intent(this, CardGiftImageUI.class);
                intent.putExtra("key_gift_into", this.klB);
                startActivity(intent);
                overridePendingTransition(0, 0);
                com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(4), this.hiD, o.getString(this.hiC)});
            }
        } else if (view.getId() == R.h.cKd) {
            if (this.klB != null && this.klB.kek) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(7), this.hiD, o.getString(this.hiC)});
                intent = new Intent(this, CardHomePageUI.class);
                intent.putExtra("key_home_page_from_scene", 2);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }
        } else if (view.getId() == R.h.cKe) {
            if (!TextUtils.isEmpty(this.klB.keF) && !TextUtils.isEmpty(this.klB.keG)) {
                com.tencent.mm.plugin.card.b.b.d(this.klB.kev, this.klB.keF, this.klB.keG, 1062, getIntent().getIntExtra("key_from_appbrand_type", 0));
                com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(8), this.hiD, o.getString(this.hiC)});
            } else if (!bg.mA(this.klB.kex)) {
                com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.klB.kex, 0);
                com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(8), this.hiD, o.getString(this.hiC)});
            }
        } else if (view.getId() == R.h.bZP || view.getId() == R.h.bZW) {
            if (bg.mA(this.klB.kez) || bg.mA(this.klB.keA)) {
                w.e("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.userCardId is null");
                return;
            }
            LinkedList linkedList = new LinkedList();
            jc jcVar = new jc();
            jcVar.kdE = this.klB.kez;
            jcVar.code = this.klB.keA;
            linkedList.add(jcVar);
            String stringExtra = getIntent().getStringExtra("key_template_id");
            bde com_tencent_mm_protocal_c_bde = new bde();
            com_tencent_mm_protocal_c_bde.ueu = stringExtra;
            w.i("MicroMsg.CardGiftReceiveUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{stringExtra});
            ap.vd().a(new t(linkedList, com_tencent_mm_protocal_c_bde, 27), 0);
            com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(9), this.hiD, o.getString(this.hiC)});
        } else if (view.getId() != R.h.cKs) {
        } else {
            if (this.kml.getVisibility() == 0) {
                this.kml.setVisibility(8);
                this.kmj.setText("查看全部");
                return;
            }
            this.kml.setVisibility(0);
            this.kmj.setText("收起");
        }
    }
}
