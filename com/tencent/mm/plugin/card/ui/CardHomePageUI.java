package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.k;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;

public class CardHomePageUI extends CardBaseUI implements d, a {
    private int fromScene = 0;
    private boolean kiL = false;
    private boolean kiN = true;
    private boolean kiP = false;
    private String kiQ = "";
    private boolean kiR = false;
    private boolean kiS = false;
    private long kiW = 0;
    boolean kiX = false;
    private b kiy;
    private i knf;
    private f kng;
    private f knh;
    private f kni;
    private boolean knj = true;
    private boolean knk = false;
    private TextView knl;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.kiW = currentTimeMillis;
        KC();
        al.age().a(this.knf);
        ap.vd().a(1164, this);
        ap.vd().a(984, this);
        al.agh().agr();
        al.afZ();
        com.tencent.mm.plugin.card.a.b.kn(1);
        agP();
        Looper.myQueue().addIdleHandler(new IdleHandler(this) {
            final /* synthetic */ CardHomePageUI knm;

            {
                this.knm = r1;
            }

            public final boolean queueIdle() {
                if (this.knm.kiy != null) {
                    boolean z;
                    ap.yY();
                    Integer num = (Integer) c.vr().get(w.a.uAV, Integer.valueOf(0));
                    if (num == null || num.intValue() != 1) {
                        ap.yY();
                        c.vr().a(w.a.uAV, Integer.valueOf(1));
                        Cursor kp = al.aga().kp(n.a.kfz);
                        if (kp == null || kp.getCount() <= 0) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
                            z = false;
                        } else {
                            kp.moveToFirst();
                            while (!kp.isAfterLast()) {
                                com.tencent.mm.sdk.e.c cardInfo = new CardInfo();
                                cardInfo.b(kp);
                                if (cardInfo.field_card_type == -1) {
                                    if (cardInfo.afi() == null) {
                                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
                                    } else {
                                        cardInfo.field_card_type = cardInfo.afi().kdF;
                                        if (!al.aga().c(cardInfo, new String[0])) {
                                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", new Object[]{cardInfo.field_card_id});
                                        }
                                    }
                                }
                                kp.moveToNext();
                            }
                            kp.close();
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
                        this.knm.ahC();
                    }
                }
                return false;
            }
        });
        al.agh().a(this);
        al.aga().c(this);
    }

    protected final int getLayoutId() {
        return R.i.cWC;
    }

    protected void onDestroy() {
        if (this.knk) {
            aeH();
        }
        al.age().b(this.knf);
        this.kiy.kgP = null;
        ap.vd().b(1164, this);
        ap.vd().b(984, this);
        al.agh().b(this);
        al.aga().f(this);
        k.afO();
        b.agy();
        long currentTimeMillis = System.currentTimeMillis() - this.kiW;
        g.oUh.i(13219, new Object[]{"CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected void onResume() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[]{Boolean.valueOf(this.knk), Boolean.valueOf(this.kiX), Boolean.valueOf(this.kiL)});
        if (this.knk && this.kiX && this.kiL) {
            this.kiQ = "";
            this.kiR = false;
            aeG();
        } else if (this.kiL) {
            this.kiQ = "";
            agN();
        }
        this.kiL = false;
        ar();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(1);
            iDKey2.SetValue(i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.oUh.b(arrayList, true);
            this.mStartTime = 0;
        }
        HandlerThread cE = e.cE("updateOfflineQrcode", 0);
        cE.start();
        new ae(cE.getLooper()).post(new Runnable(this) {
            final /* synthetic */ CardHomePageUI knm;

            {
                this.knm = r1;
            }

            public final void run() {
                al.agq().a(q.EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD);
            }
        });
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void KC() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.knk = r0;
        if (this.knk) {
            agK();
        } else {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
            agN();
        }
        super.KC();
    }

    protected final void aeA() {
        zi(R.l.dQX);
        a(0, getString(R.l.dRt), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardHomePageUI knm;

            {
                this.knm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.card.b.b.a(this.knm, true);
                g.oUh.i(11582, new Object[]{"CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", ""});
                return true;
            }
        });
        this.kiy = new b(this);
        this.kiy.init();
        if (this.knf == null) {
            this.knf = new i(this, this.uSU.ipu);
            i iVar = this.knf;
            iVar.kog = View.inflate(iVar.kdb, R.i.cWO, null);
            iVar.kog.setVisibility(8);
            iVar.koh = (TextView) iVar.kog.findViewById(R.h.bxw);
            iVar.koi = (ImageView) iVar.kog.findViewById(R.h.bxv);
            iVar.kog.setOnClickListener(new OnClickListener(iVar) {
                final /* synthetic */ i kom;

                {
                    this.kom = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.card.b.b.a(this.kom.kdb, false);
                    al.age().afN();
                    this.kom.ahH();
                    g.oUh.i(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                }
            });
            iVar.ahH();
            if (iVar.koj == null) {
                iVar.koj = ((ViewStub) iVar.khv.findViewById(R.h.bxL)).inflate();
                iVar.koj.setVisibility(8);
                iVar.kok = (TextView) iVar.koj.findViewById(R.h.bxw);
                iVar.kol = (ImageView) iVar.koj.findViewById(R.h.bxv);
                iVar.koj.setOnClickListener(new OnClickListener(iVar) {
                    final /* synthetic */ i kom;

                    {
                        this.kom = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.card.b.b.a(this.kom.kdb, false);
                        al.age().afN();
                        this.kom.ahH();
                        g.oUh.i(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                    }
                });
            }
            this.knf.kjg = true;
        }
        if (this.kng == null) {
            this.kng = new f(this, findViewById(R.h.bxI), 1, this.kiy);
        }
        if (this.knh == null) {
            this.knh = new f(this, findViewById(R.h.byr), 2, this.kiy);
        }
        if (this.kni == null) {
            this.kni = new f(this, findViewById(R.h.byB), 3, this.kiy);
        }
        if (this.kng != null) {
            this.kng.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI knm;

                {
                    this.knm = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.knm, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    this.knm.startActivity(intent);
                    g.oUh.i(11324, new Object[]{"GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        if (this.knh != null) {
            this.knh.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI knm;

                {
                    this.knm = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.knm, ShareCardListUI.class);
                    intent.putExtra("key_layout_buff", this.knm.kiQ);
                    this.knm.knj = true;
                    this.knm.startActivity(intent);
                    l lVar = (l) al.agf().getValue("key_share_card_layout_data");
                    if (lVar != null) {
                        int i;
                        int i2;
                        int i3;
                        int i4 = lVar.fVu ? 1 : 0;
                        if (lVar.fVv) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (lVar.khj != null) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (TextUtils.isEmpty(lVar.khk)) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        g.oUh.i(13685, new Object[]{Integer.valueOf(2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                        if (lVar.fVv) {
                            this.knm.kiL = true;
                            lVar.fVv = false;
                        }
                        if (lVar.fVu) {
                            this.knm.kiL = true;
                            lVar.fVu = false;
                            lVar.khj = null;
                            lVar.khk = "";
                        }
                    }
                    ap.yY();
                    c.vr().a(w.a.uAH, "");
                    g.oUh.i(11324, new Object[]{"ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        if (this.kni != null) {
            this.kni.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI knm;

                {
                    this.knm = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.knm, CardIndexUI.class);
                    intent.putExtra("key_card_type", 3);
                    this.knm.startActivity(intent);
                    g.oUh.i(11324, new Object[]{"ClickTicketCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardHomePageUI knm;

            {
                this.knm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.knm.fromScene == 1 || this.knm.fromScene == 2) {
                    this.knm.ahD();
                } else {
                    this.knm.finish();
                }
                return true;
            }
        });
    }

    protected final int aeB() {
        return n.a.kfE;
    }

    private void agK() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CardHomePageUI", "initLocation");
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ CardHomePageUI knm;

            {
                this.knm = r1;
            }

            public final void run() {
                this.knm.hvP = com.tencent.mm.modelgeo.c.Gk();
                this.knm.aeF();
                this.knm.kiX = true;
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CardHomePageUI", "initLocation end");
            }
        });
    }

    protected final void aeK() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.knk);
        if (!this.knk) {
            this.knk = true;
            agK();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        agP();
        this.kiL = true;
        this.knj = true;
    }

    private void ar() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "updateView()");
        this.knf.ahH();
        ahC();
        this.knh.ar();
        this.kni.ar();
    }

    private void ahC() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
        c cVar = (c) this.kcs;
        if (this.knl == null) {
            this.knl = (TextView) findViewById(R.h.cjA);
            this.knl.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI knm;

                {
                    this.knm = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.knm, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    this.knm.startActivity(intent);
                    g.oUh.i(11324, new Object[]{"GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        if (cVar.getCount() > 0) {
            this.knl.setVisibility(0);
            this.knl.setText(getString(R.l.dSa, new Object[]{Integer.valueOf(b.ags())}));
            this.kng.setVisibility(8);
            return;
        }
        this.knl.setVisibility(8);
        this.kng.setVisibility(0);
    }

    protected final void aeL() {
        ahC();
    }

    protected final void aeI() {
        if (this.kiR) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.knk) {
                aeH();
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
        this.kiR = true;
        agN();
        aeH();
    }

    protected final void aeJ() {
        if (this.kiS || this.kiR) {
            aeH();
            return;
        }
        this.kiS = true;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "onLocationFail()");
        agN();
    }

    private void agN() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        if (!this.knj) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
        } else if (this.kiP) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
        } else {
            if (this.kiN && !bg.mA(this.kiQ)) {
                this.kiQ = "";
            }
            this.kiP = true;
            this.knj = false;
            ap.vd().a(new com.tencent.mm.plugin.card.sharecard.model.b((double) al.agg().gKj, (double) al.agg().gKk, this.kiQ), 0);
        }
        if (com.tencent.mm.plugin.card.b.l.aiJ()) {
            ap.yY();
            int intValue = ((Integer) c.vr().get(w.a.uAL, Integer.valueOf(1))).intValue();
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is " + intValue);
            ap.vd().a(new ad((double) al.agg().gKj, (double) al.agg().gKk, intValue), 0);
        } else {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
        }
        al.agg().m("", "", 4);
    }

    protected final boolean aeD() {
        return super.aeD();
    }

    protected final boolean aeE() {
        return true;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                this.kiP = false;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar instanceof ad) {
            ahC();
            this.kcy.zm();
            this.kni.ar();
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) kVar;
            this.kiP = false;
            this.kiQ = bVar.kgX;
            this.kiy.N(bVar.kfG, this.kiN);
            if (!(b.agz() && b.agA())) {
                this.kiN = false;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
            ar();
        }
    }

    private void agP() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean aC = com.tencent.mm.q.c.uk().aC(262152, 266256);
        boolean aD = com.tencent.mm.q.c.uk().aD(262152, 266256);
        boolean a = com.tencent.mm.q.c.uk().a(w.a.uAz, w.a.uAB);
        boolean a2 = com.tencent.mm.q.c.uk().a(w.a.uAA, w.a.uAC);
        ap.yY();
        String mz = bg.mz((String) c.vr().get(w.a.uAF, null));
        if (aC) {
            g.oUh.i(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (aD) {
            g.oUh.i(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (a && !a2) {
            g.oUh.i(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (a && a2) {
            g.oUh.i(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else if (a2) {
            g.oUh.i(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        } else {
            g.oUh.i(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), mz});
        }
    }

    public final void aft() {
        this.kiL = true;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        this.kiL = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fromScene == 1 || this.fromScene == 2) {
                ahD();
            } else {
                finish();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ahD() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.bb.d.a(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
    }
}
