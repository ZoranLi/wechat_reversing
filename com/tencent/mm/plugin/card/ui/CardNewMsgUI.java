package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.List;

public class CardNewMsgUI extends MMActivity implements com.tencent.mm.plugin.card.a.k.a {
    private ListView Fg;
    OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ CardNewMsgUI koq;

        {
            this.koq = r1;
        }

        public final void onClick(View view) {
            g gVar;
            if (view.getId() == R.h.bNs) {
                gVar = (g) view.getTag();
                if (gVar != null && gVar.afQ() != null) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
                    if (gVar.afQ().kfr == 0) {
                        w.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                        if (TextUtils.isEmpty(gVar.afQ().url)) {
                            w.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(this.koq, gVar.afQ().url, 2);
                        }
                    } else if (gVar.afQ().kfr == 1) {
                        w.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                        Intent intent = new Intent();
                        intent.putExtra("KEY_CARD_ID", gVar.field_card_id);
                        intent.putExtra("KEY_CARD_TP_ID", gVar.field_card_tp_id);
                        intent.setClass(this.koq, CardShopUI.class);
                        this.koq.startActivity(intent);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11324, new Object[]{"UsedStoresView", Integer.valueOf(gVar.field_card_type), gVar.field_card_tp_id, gVar.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                    }
                }
            } else if (view.getId() == R.h.cpD) {
                gVar = (g) view.getTag();
                if (gVar != null && gVar.afR() != null) {
                    if (gVar.afR().type == 0) {
                        w.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                        if (TextUtils.isEmpty(gVar.afR().url)) {
                            w.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                        } else {
                            com.tencent.mm.plugin.card.b.b.a(this.koq, gVar.afR().url, 2);
                        }
                    } else if (gVar.afR().type == 1) {
                        w.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                    }
                }
            }
        }
    };
    private View jAA;
    private View jjN;
    private a kon;
    private View koo = null;
    private boolean kop = false;

    class a extends k<g> {
        private int hOI = this.kor;
        final /* synthetic */ CardNewMsgUI koq;
        private int kor = 10;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (g) obj;
            if (obj == null) {
                obj = new g();
            }
            obj.b(cursor);
            return obj;
        }

        public a(CardNewMsgUI cardNewMsgUI) {
            this.koq = cardNewMsgUI;
            super(cardNewMsgUI, new g());
            ko(true);
        }

        public final void OK() {
            if (al.agc().Kr() > 0) {
                setCursor(al.agc().gUz.rawQuery("select * from CardMsgInfo where read_state = ?  order by time desc", new String[]{"1"}));
            } else {
                this.hOI = al.agc().getCount();
                h agc = al.agc();
                setCursor(agc.gUz.rawQuery("select * from CardMsgInfo order by time desc LIMIT " + this.kor, null));
            }
            notifyDataSetChanged();
        }

        protected final void OL() {
            aEW();
            OK();
        }

        public final boolean ahI() {
            return this.kor >= this.hOI;
        }

        public final int ahJ() {
            if (ahI()) {
                if (this.koq.koo.getParent() != null) {
                    this.koq.Fg.removeFooterView(this.koq.koo);
                }
                return 0;
            }
            this.kor += 10;
            if (this.kor <= this.hOI) {
                return 10;
            }
            this.kor = this.hOI;
            return this.hOI % 10;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            g gVar = (g) getItem(i);
            if (view == null) {
                view = View.inflate(this.koq.uSU.uTo, R.i.cWN, null);
                b bVar2 = new b(this.koq);
                bVar2.kow = (ImageView) view.findViewById(R.h.logo);
                bVar2.kox = view.findViewById(R.h.byJ);
                bVar2.koy = (ImageView) view.findViewById(R.h.byI);
                bVar2.koz = (TextView) view.findViewById(R.h.cJh);
                bVar2.koA = (TextView) view.findViewById(R.h.cIo);
                bVar2.koB = (TextView) view.findViewById(R.h.bIc);
                bVar2.koC = (TextView) view.findViewById(R.h.bNs);
                bVar2.koD = (TextView) view.findViewById(R.h.cGd);
                bVar2.koE = view.findViewById(R.h.cpD);
                bVar2.koF = (TextView) view.findViewById(R.h.cpE);
                bVar2.koG = (LinearLayout) view.findViewById(R.h.bmA);
                bVar2.koH = (LinearLayout) view.findViewById(R.h.bmB);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            bVar.koz.setText(gVar.field_title);
            bVar.koA.setText(o.c(this.koq, ((long) gVar.field_time) * 1000, true));
            bVar.koB.setText(gVar.field_description);
            int dimensionPixelSize = this.koq.getResources().getDimensionPixelSize(R.f.aYR);
            w.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " logo_url :  " + gVar.field_logo_url);
            if (TextUtils.isEmpty(gVar.field_logo_color)) {
                bVar.kox.setVisibility(8);
                bVar.kow.setVisibility(0);
                bVar.kow.setImageResource(R.g.bhq);
                m.a(bVar.kow, gVar.field_logo_url, dimensionPixelSize, R.g.bhq, true);
            } else {
                w.d("MicroMsg.CardNewMsgUI", "CardNewMsgUI getView () position : " + i + " field_logo_color :  " + gVar.field_logo_color);
                bVar.kox.setVisibility(0);
                bVar.kow.setVisibility(8);
                if (TextUtils.isEmpty(gVar.field_logo_url)) {
                    m.a(bVar.koy, R.g.bdy, l.ta(gVar.field_logo_color));
                } else {
                    m.a(this.koq, bVar.koy, gVar.field_logo_url, dimensionPixelSize, R.g.bdy, l.ta(gVar.field_logo_color));
                }
            }
            ir afQ = gVar.afQ();
            if (afQ == null || TextUtils.isEmpty(afQ.text)) {
                bVar.koC.setVisibility(8);
            } else {
                bVar.koC.setText(afQ.text);
                bVar.koC.setTag(gVar);
                bVar.koC.setVisibility(0);
                bVar.koC.setOnClickListener(this.koq.iuW);
            }
            iv afR = gVar.afR();
            if (afR == null || TextUtils.isEmpty(afR.text)) {
                bVar.koE.setVisibility(8);
                bVar.koD.setVisibility(8);
            } else {
                bVar.koF.setText(afR.text);
                bVar.koE.setVisibility(0);
                bVar.koE.setOnClickListener(this.koq.iuW);
                bVar.koE.setTag(gVar);
                bVar.koD.setVisibility(0);
            }
            gVar.afS();
            gVar.afT();
            a(gVar.kfi, gVar.kfj, bVar, gVar);
            return view;
        }

        private void a(List<com.tencent.mm.plugin.card.model.g.a> list, List<com.tencent.mm.plugin.card.model.g.b> list2, b bVar, final g gVar) {
            bVar.koG.removeAllViews();
            if ((list == null || list.size() == 0) && (list2 == null || list2.size() == 0)) {
                bVar.koH.setVisibility(8);
                return;
            }
            int i;
            View inflate;
            Button button;
            if (!bg.bV(list)) {
                for (i = 0; i < list.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.a aVar = (com.tencent.mm.plugin.card.model.g.a) list.get(i);
                    inflate = View.inflate(this.koq.uSU.uTo, R.i.cWd, null);
                    if (i == 0) {
                        inflate.findViewById(R.h.bvN).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.h.bvP)).setText(aVar.title);
                    ((TextView) inflate.findViewById(R.h.bvO)).setText(aVar.kfo);
                    button = (Button) inflate.findViewById(R.h.bvM);
                    button.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a kou;

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            if (aVar.kfr == 0) {
                                intent.setClass(this.kou.koq.uSU.uTo, CardDetailUI.class);
                                intent.putExtra("key_card_id", aVar.cardId);
                                intent.putExtra("key_card_ext", aVar.kfp);
                                intent.putExtra("key_from_scene", 17);
                                this.kou.koq.startActivity(intent);
                            } else if (aVar.kfr == 1) {
                                intent.setClass(this.kou.koq.uSU.uTo, CardConsumeSuccessUI.class);
                                intent.putExtra("key_card_id", gVar.field_card_id);
                                intent.putExtra("key_from_scene", 2);
                                this.kou.koq.startActivity(intent);
                            }
                            com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(8), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, aVar.cardId});
                        }
                    });
                    if (aVar.kfr == 0) {
                        button.setText(R.l.bvP);
                    } else if (aVar.kfr == 1) {
                        button.setText(R.l.dQa);
                    }
                    bVar.koG.addView(inflate);
                }
            }
            if (!bg.bV(list2)) {
                for (i = 0; i < list2.size(); i++) {
                    final com.tencent.mm.plugin.card.model.g.b bVar2 = (com.tencent.mm.plugin.card.model.g.b) list2.get(i);
                    inflate = View.inflate(this.koq.uSU.uTo, R.i.cWd, null);
                    if (i == 0 && bg.bV(list)) {
                        inflate.findViewById(R.h.bvN).setVisibility(8);
                    }
                    ((TextView) inflate.findViewById(R.h.bvP)).setText(bVar2.title);
                    ((TextView) inflate.findViewById(R.h.bvO)).setText(bVar2.description);
                    button = (Button) inflate.findViewById(R.h.bvM);
                    button.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a kou;

                        public final void onClick(View view) {
                            if (TextUtils.isEmpty(bVar2.kfu)) {
                                w.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(this.kou.koq, bVar2.kfu, 2);
                            }
                        }
                    });
                    button.setText(bVar2.kft);
                    bVar.koG.addView(inflate);
                }
            }
            bVar.koH.setVisibility(0);
        }
    }

    private class b {
        TextView koA;
        TextView koB;
        TextView koC;
        TextView koD;
        View koE;
        TextView koF;
        LinearLayout koG;
        LinearLayout koH;
        final /* synthetic */ CardNewMsgUI koq;
        ImageView kow;
        View kox;
        ImageView koy;
        TextView koz;

        public b(CardNewMsgUI cardNewMsgUI) {
            this.koq = cardNewMsgUI;
        }
    }

    static /* synthetic */ void a(CardNewMsgUI cardNewMsgUI, int i) {
        g gVar = (g) cardNewMsgUI.kon.getItem(i);
        if (gVar != null) {
            if (gVar.field_jump_type == 3) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.O(gVar.field_card_id, false);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    w.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.O(gVar.field_card_tp_id, false);
                }
            } else if (gVar.field_jump_type == 2) {
                if (TextUtils.isEmpty(gVar.field_url)) {
                    w.e("MicroMsg.CardNewMsgUI", "field_url is null");
                } else {
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) cardNewMsgUI, gVar.field_url, 4);
                }
            } else if (gVar.field_jump_type == 1) {
                w.i("MicroMsg.CardNewMsgUI", "field_jump_type is MM_CARD_ITEM_XML_MSG_JUMP_TYPE_NO");
            } else if (gVar.field_jump_type == 4) {
                if (!TextUtils.isEmpty(gVar.field_card_id)) {
                    cardNewMsgUI.O(gVar.field_card_id, true);
                } else if (TextUtils.isEmpty(gVar.field_card_tp_id)) {
                    w.e("MicroMsg.CardNewMsgUI", "field_card_id and field_card_tp_id is null");
                } else {
                    cardNewMsgUI.O(gVar.field_card_tp_id, true);
                }
            }
            int i2 = cardNewMsgUI.getIntent().getBooleanExtra("from_menu", false) ? 7 : 1;
            com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(i2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
        }
    }

    protected final int getLayoutId() {
        return R.i.cWP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        al.age().a((com.tencent.mm.plugin.card.a.k.a) this);
        al.age().afN();
    }

    protected void onDestroy() {
        this.kon.aEW();
        al.age().b(this);
        if (al.agc().Kr() > 0) {
            al.agc().afV();
        }
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.dRt);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI koq;

            {
                this.koq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.koq.finish();
                return true;
            }
        });
        this.Fg = (ListView) findViewById(R.h.bxM);
        this.kon = new a(this);
        this.Fg.setAdapter(this.kon);
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI koq;

            {
                this.koq = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == this.koq.kon.getCount()) {
                    int i2 = 1;
                    if (al.agc().Kr() > 0) {
                        al.agc().afV();
                    } else {
                        i2 = this.koq.kon.ahJ();
                    }
                    this.koq.kon.a(null, null);
                    if (!this.koq.kop) {
                        if (this.koq.jjN.getParent() != null) {
                            w.d("MicroMsg.CardNewMsgUI", "remove footer");
                            this.koq.Fg.removeFooterView(this.koq.jjN);
                        }
                        if (!this.koq.kon.ahI() && this.koq.koo.getParent() == null && r0 > 0) {
                            this.koq.Fg.addFooterView(this.koq.koo);
                            w.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
                        }
                    }
                    this.koq.kop = true;
                    this.koq.jjN.setVisibility(8);
                    return;
                }
                CardNewMsgUI.a(this.koq, i);
            }
        });
        this.Fg.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ CardNewMsgUI koq;

            {
                this.koq = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.ui.base.g.a(this.koq, this.koq.getResources().getString(R.l.dRu), null, this.koq.getResources().getString(R.l.dGB), new c(this.koq, i) {
                    final /* synthetic */ CardNewMsgUI koq;

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                g gVar = (g) this.koq.kon.getItem(r5);
                                if (gVar != null) {
                                    al.age().so(gVar.field_msg_id);
                                    this.koq.agB();
                                    this.koq.kon.a(null, null);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.Fg.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CardNewMsgUI koq;

            {
                this.koq = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (this.koq.kop && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (al.agc().Kr() > 0) {
                        al.agc().afV();
                    } else {
                        this.koq.kon.ahJ();
                    }
                    this.koq.kon.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.kon.uSN = new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ CardNewMsgUI koq;

            {
                this.koq = r1;
            }

            public final void OI() {
            }

            public final void OH() {
                this.koq.agB();
                if (this.koq.kon.ahI() && al.agc().Kr() == 0) {
                    this.koq.jjN.setVisibility(8);
                }
            }
        };
        a(0, getString(R.l.dQu), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardNewMsgUI koq;

            {
                this.koq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11582, new Object[]{"CardMsgClearMenu", Integer.valueOf(2), Integer.valueOf(0), "", "", ""});
                d.a(this.koq, new com.tencent.mm.plugin.card.b.d.a(this.koq) {
                    final /* synthetic */ CardNewMsgUI koq;

                    {
                        this.koq = r1;
                    }

                    public final void ahE() {
                        com.tencent.mm.plugin.card.a.k age = al.age();
                        if (age.kdw.size() != 0) {
                            List arrayList = new ArrayList();
                            arrayList.addAll(age.kdw);
                            for (int i = 0; i < arrayList.size(); i++) {
                                g gVar = (g) arrayList.get(i);
                                if (gVar != null) {
                                    age.kdw.remove(gVar);
                                    com.tencent.mm.plugin.card.a.k.d(gVar);
                                }
                            }
                            arrayList.clear();
                        }
                        this.koq.agB();
                        this.koq.kon.a(null, null);
                    }
                });
                return true;
            }
        });
        this.jAA = findViewById(R.h.bGB);
        agB();
        this.jjN = r.eC(this).inflate(R.i.cWM, null);
        this.koo = r.eC(this).inflate(R.i.diz, null);
        int Kr = al.agc().Kr();
        if (Kr > 0) {
            this.Fg.addFooterView(this.jjN);
        } else if (!this.kon.ahI() && Kr == 0 && al.agc().getCount() > 0) {
            this.Fg.addFooterView(this.koo);
            this.kop = true;
        } else if (this.kon.ahI() && Kr == 0) {
            al.agc().getCount();
        }
    }

    private void agB() {
        com.tencent.mm.plugin.card.a.k age = al.age();
        int size = (age.kdw == null || age.kdw.isEmpty()) ? 0 : age.kdw.size();
        if (size > 0) {
            this.Fg.setVisibility(0);
            this.jAA.setVisibility(8);
            kr(true);
        } else {
            this.Fg.setVisibility(8);
            this.jAA.setVisibility(0);
            kr(false);
        }
        this.kon.notifyDataSetChanged();
    }

    private void O(String str, boolean z) {
        Intent intent = new Intent(this, CardDetailUI.class);
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_is_share_card", z);
        intent.putExtra("key_from_scene", 4);
        startActivity(intent);
    }

    public final void a(g gVar) {
        if ((gVar.field_msg_type & 1) != 0 && (gVar.field_msg_type & 3) != 0) {
            agB();
            this.kon.a(null, null);
        }
    }

    public final void adZ() {
    }
}
