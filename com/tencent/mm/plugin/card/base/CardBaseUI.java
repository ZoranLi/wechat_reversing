package com.tencent.mm.plugin.card.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ad;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.x;
import com.tencent.mm.plugin.card.sharecard.model.b;
import com.tencent.mm.plugin.card.sharecard.ui.g;
import com.tencent.mm.plugin.card.sharecard.ui.h;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.d;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardBaseUI extends MMActivity implements a, e {
    private float gKj = -85.0f;
    private float gKk = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ CardBaseUI kcA;

        {
            this.kcA = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                if (!(f2 == -85.0f || f == -1000.0f)) {
                    this.kcA.gKj = f2;
                    this.kcA.gKk = f;
                    al.agg().o(this.kcA.gKj, this.kcA.gKk);
                    this.kcA.aeI();
                }
                if (!this.kcA.hvS) {
                    this.kcA.hvS = true;
                    n.a(2010, f, f2, (int) d2);
                }
                return false;
            }
            this.kcA.aeJ();
            return true;
        }
    };
    public c hvP;
    private boolean hvS = false;
    private p iLz = null;
    public ListView kcr = null;
    public BaseAdapter kcs = null;
    public RelativeLayout kct = null;
    public LinearLayout kcu;
    public LinearLayout kcv;
    public boolean kcw = false;
    public boolean kcx = true;
    public a kcy = null;
    public CardInfo kcz;

    public abstract void aeA();

    static /* synthetic */ void a(CardBaseUI cardBaseUI, String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        cardBaseUI.kcw = false;
        cardBaseUI.A(linkedList);
    }

    static /* synthetic */ void c(CardBaseUI cardBaseUI, String str) {
        cardBaseUI.da(true);
        ap.vd().a(new af(cardBaseUI.kcz.field_card_id, str, 17), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.kcx = true;
        ap.vd().a(652, this);
    }

    public void onPause() {
        super.onPause();
        this.kcx = false;
        ap.vd().b(652, this);
    }

    public void KC() {
        a dVar;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardBaseUI kcA;

            {
                this.kcA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kcA.finish();
                return true;
            }
        });
        this.kcr = (ListView) findViewById(16908298);
        this.kct = (RelativeLayout) findViewById(R.h.bGB);
        if (this.kct != null) {
            this.kcr.setEmptyView(this.kct);
        }
        this.kcu = (LinearLayout) View.inflate(getBaseContext(), R.i.cWJ, null);
        this.kcv = (LinearLayout) View.inflate(getBaseContext(), R.i.cWH, null);
        this.kcr.addHeaderView(this.kcu);
        this.kcr.addFooterView(this.kcv);
        this.kcs = aeC();
        this.kcr.setAdapter(this.kcs);
        this.kcr.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardBaseUI kcA;

            {
                this.kcA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    w.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
                    return;
                }
                if (i > 0) {
                    i--;
                }
                if (i < this.kcA.kcs.getCount()) {
                    this.kcA.b(this.kcA.kcy.kl(i));
                }
            }
        });
        this.kcr.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardBaseUI kcA;

            {
                this.kcA = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    w.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
                } else {
                    if (i > 0) {
                        i--;
                    }
                    if (i < this.kcA.kcs.getCount()) {
                        this.kcA.c(this.kcA.kcy.kl(i));
                    }
                }
                return true;
            }
        });
        ap.vd().a(560, this);
        ap.vd().a(692, this);
        BaseAdapter baseAdapter = this.kcs;
        if (baseAdapter instanceof com.tencent.mm.plugin.card.ui.c) {
            dVar = new d((com.tencent.mm.plugin.card.ui.c) baseAdapter);
        } else {
            Object dVar2 = baseAdapter instanceof com.tencent.mm.plugin.card.sharecard.ui.c ? new com.tencent.mm.plugin.card.sharecard.ui.d((com.tencent.mm.plugin.card.sharecard.ui.c) baseAdapter) : baseAdapter instanceof g ? new h((g) baseAdapter) : new com.tencent.mm.plugin.card.ui.h((com.tencent.mm.plugin.card.ui.g) baseAdapter);
        }
        this.kcy = dVar;
        this.kcy.onCreate();
        aeA();
    }

    public int getLayoutId() {
        return R.i.cWD;
    }

    public void onDestroy() {
        ap.vd().b(560, this);
        ap.vd().b(692, this);
        if (this.kcy != null) {
            this.kcy.onDestroy();
        }
        super.onDestroy();
    }

    public void a(b bVar) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", bVar.afm());
        intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        intent.putExtra("key_from_scene", 3);
        startActivity(intent);
        if (aeB() == com.tencent.mm.plugin.card.model.n.a.kfE) {
            com.tencent.mm.plugin.report.service.g.oUh.i(11324, new Object[]{"ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
        } else if (aeB() == com.tencent.mm.plugin.card.model.n.a.kfD) {
            com.tencent.mm.plugin.report.service.g.oUh.i(11324, new Object[]{"ClickMemberCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0)});
        }
    }

    public final void da(boolean z) {
        if (z) {
            this.iLz = p.b(this, getString(R.l.dJd), true, 0, null);
        } else if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
            this.iLz = null;
        }
    }

    public final void A(LinkedList<String> linkedList) {
        da(true);
        ap.vd().a(new r(linkedList), 0);
    }

    public void a(int i, int i2, String str, k kVar) {
        int i3;
        if (i != 0 || i2 != 0) {
            da(false);
            if (kVar instanceof af) {
                i3 = ((af) kVar).kfH;
                CharSequence charSequence = ((af) kVar).kfI;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(charSequence)) {
                        charSequence = getString(R.l.dQR);
                    }
                    str = charSequence;
                }
            }
            if (!(kVar instanceof x) && !(kVar instanceof ad) && !(kVar instanceof b) && this.kcx) {
                com.tencent.mm.plugin.card.b.d.b(this, str, i2);
            }
        } else if (kVar instanceof r) {
            da(false);
            com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dQG));
            al.afZ();
            com.tencent.mm.plugin.card.a.b.kn(4);
            this.kcy.zm();
            aeL();
        } else if (kVar instanceof af) {
            da(false);
            i3 = ((af) kVar).kfH;
            String str2 = ((af) kVar).kfI;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(R.l.dQR);
                }
                com.tencent.mm.plugin.card.b.d.b(this, str2, i3);
                return;
            }
            if (this.kcz != null) {
                it afj = this.kcz.afj();
                afj.status = 3;
                this.kcz.a(afj);
                if (!al.aga().c(this.kcz, new String[0])) {
                    w.e("MicroMsg.CardBaseUI", "update newSerial fail, cardId = %s", new Object[]{this.kcz.field_card_id});
                }
            }
            this.kcy.zm();
            aeL();
        }
    }

    public int aeB() {
        return com.tencent.mm.plugin.card.model.n.a.kfz;
    }

    public BaseAdapter aeC() {
        return new com.tencent.mm.plugin.card.ui.c(this, aeB());
    }

    public boolean aeD() {
        return true;
    }

    public boolean aeE() {
        return true;
    }

    public void b(b bVar) {
        if (!aeD()) {
            w.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            w.e("MicroMsg.CardBaseUI", "onListItemClick  item == null");
        } else if (bVar.aeU()) {
            a(bVar);
        } else if (!TextUtils.isEmpty(bVar.afi().toq)) {
            com.tencent.mm.plugin.card.b.b.a((MMActivity) this, bVar.afi().toq, 0);
        }
    }

    public void c(final b bVar) {
        if (!aeE()) {
            w.e("MicroMsg.CardBaseUI", "isItemClickable return false");
        } else if (bVar == null) {
            w.e("MicroMsg.CardBaseUI", "onListItemLongClick  item == null");
        } else {
            ArrayList arrayList = new ArrayList();
            if (bVar.aeV()) {
                arrayList.add(getResources().getString(R.l.dRr));
            }
            arrayList.add(getResources().getString(R.l.dGB));
            final String afm = bVar.afm();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar.afi().keS);
            com.tencent.mm.ui.base.g.a(this, stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), null, new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ CardBaseUI kcA;

                public final void hq(int i) {
                    if (bVar.aeV()) {
                        switch (i) {
                            case 0:
                                this.kcA.a((CardInfo) bVar);
                                return;
                            case 1:
                                com.tencent.mm.plugin.card.b.d.a(this.kcA, afm, "", new com.tencent.mm.plugin.card.b.d.a(this.kcA, afm) {
                                    final /* synthetic */ CardBaseUI kcA;

                                    public final void aeM() {
                                        CardBaseUI.a(this.kcA, r3);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                    switch (i) {
                        case 0:
                            com.tencent.mm.plugin.card.b.d.a(this.kcA, afm, "", /* anonymous class already generated */);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            j(intent.getStringExtra("Select_Conv_User"), 0, false);
        }
    }

    public void a(CardInfo cardInfo) {
        this.kcz = cardInfo;
        com.tencent.mm.plugin.card.b.b.a((MMActivity) this, 0, (a) this);
    }

    public final void j(final String str, int i, final boolean z) {
        if (this.kcz == null) {
            w.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo == null");
        } else if (this.kcz.afi() == null) {
            w.e("MicroMsg.CardBaseUI", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                if (TextUtils.isEmpty(this.kcz.afk().ubj)) {
                    stringBuilder.append(getString(R.l.eWV));
                } else {
                    stringBuilder.append(this.kcz.afk().ubj);
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(11582, new Object[]{"OperGift", Integer.valueOf(2), Integer.valueOf(this.kcz.afi().kdF), this.kcz.field_card_tp_id, this.kcz.field_card_id, str});
            } else if (i == 1) {
                stringBuilder.append(getString(R.l.dQQ, new Object[]{this.kcz.afi().keS}));
                com.tencent.mm.plugin.report.service.g.oUh.i(11582, new Object[]{"OperGift", Integer.valueOf(3), Integer.valueOf(this.kcz.afi().kdF), this.kcz.field_card_tp_id, this.kcz.field_card_id, str});
            }
            com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, stringBuilder.toString(), this.kcz.afi().kdG, this.kcz.afi().title + "\n" + this.kcz.afi().keT, null, false, getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                final /* synthetic */ CardBaseUI kcA;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        CardBaseUI.c(this.kcA, str);
                        com.tencent.mm.ui.base.g.bl(this.kcA, this.kcA.getResources().getString(R.l.dQW));
                        if (z) {
                            Context context = this.kcA;
                            String str2 = str;
                            Intent intent = new Intent();
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", str2);
                            com.tencent.mm.plugin.card.a.imv.e(intent, context);
                        }
                    }
                }
            });
        }
    }

    public final void aeF() {
        if (this.hvP == null) {
            this.hvP = c.Gk();
        }
        if (this.hvP != null) {
            this.hvP.a(this.gKp, true);
        }
    }

    public final void aeG() {
        if (this.hvP != null) {
            this.hvP.a(this.gKp, true);
        }
    }

    public final void aeH() {
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
    }

    public void aeI() {
    }

    public void aeJ() {
    }

    public void aeK() {
    }

    public void aeL() {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.CardBaseUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    aeK();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ CardBaseUI kcA;

                        {
                            this.kcA = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kcA.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
