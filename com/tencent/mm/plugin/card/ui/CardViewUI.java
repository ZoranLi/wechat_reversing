package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Collection;
import java.util.LinkedList;

public class CardViewUI extends CardBaseUI {
    private int afo = 1;
    private String hir = "";
    private int jZM;
    private LinkedList<jc> kjR = new LinkedList();
    private int klf;
    private String kpp;
    private View kpq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.CardViewUI", "onCreate intent is null");
            finish();
            return;
        }
        this.jZM = intent.getIntExtra("key_previous_scene", 7);
        this.klf = intent.getIntExtra("key_from_appbrand_type", 0);
        this.afo = intent.getIntExtra("view_type", 0);
        this.kpp = intent.getStringExtra("user_name");
        Object stringExtra = intent.getStringExtra("card_list");
        this.hir = getIntent().getStringExtra("key_template_id");
        if (this.afo == 0) {
            if (TextUtils.isEmpty(stringExtra)) {
                w.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
                finish();
                return;
            }
            Collection aE = k.aE(stringExtra, this.jZM);
            if (aE != null && aE.size() > 0) {
                this.kjR.clear();
                this.kjR.addAll(aE);
            }
        }
        KC();
    }

    protected void onDestroy() {
        ap.vd().b(699, this);
        super.onDestroy();
    }

    public final void VK() {
        super.VK();
        if (this.jZM == 26) {
            overridePendingTransition(0, 0);
        }
    }

    protected final void aeA() {
        int i;
        if (this.afo == 0) {
            zi(R.l.dSv);
        } else if (this.afo == 1) {
            zi(R.l.dQU);
        }
        ap.vd().a(699, this);
        int i2 = R.l.dQb;
        if (this.afo == 0) {
            da(true);
            bde com_tencent_mm_protocal_c_bde = new bde();
            com_tencent_mm_protocal_c_bde.ueu = this.hir;
            w.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{this.hir});
            ap.vd().a(new t(this.kjR, com_tencent_mm_protocal_c_bde, this.jZM), 0);
            i = R.l.dQb;
        } else if (this.afo == 1) {
            this.kpq = View.inflate(this, R.i.cWI, null);
            if (this.kcu != null) {
                this.kcu.addView(this.kpq);
            }
            i = R.l.dSb;
        } else {
            i = i2;
        }
        findViewById(R.h.coh).setVisibility(8);
        ((TextView) findViewById(R.h.coj)).setText(i);
    }

    protected final int aeB() {
        return a.kfB;
    }

    protected final BaseAdapter aeC() {
        if (this.afo == 0) {
            return new g(getApplicationContext());
        }
        return super.aeC();
    }

    protected final boolean aeE() {
        if (this.afo == 1) {
            return false;
        }
        return super.aeE();
    }

    protected final void b(b bVar) {
        if (this.afo == 1) {
            a((CardInfo) bVar);
        } else {
            super.b(bVar);
        }
    }

    protected final void a(CardInfo cardInfo) {
        if (this.afo == 1) {
            this.kcz = cardInfo;
            j(this.kpp, 1, true);
            return;
        }
        super.a(cardInfo);
        if (this.kcz != null) {
            g.oUh.i(11582, new Object[]{"OperGift", Integer.valueOf(4), Integer.valueOf(this.kcz.afi().kdF), this.kcz.field_card_tp_id, this.kcz.field_card_id, this.kpp});
        }
    }

    protected final void a(b bVar) {
        if (this.afo == 0) {
            al.agf().kcz = (CardInfo) bVar;
            Intent intent = new Intent(this, CardDetailUI.class);
            intent.putExtra("key_card_id", ((CardInfo) bVar).field_card_id);
            intent.putExtra("key_from_scene", 51);
            intent.putExtra("key_from_appbrand_type", this.klf);
            startActivity(intent);
            return;
        }
        super.a(bVar);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        int i3 = 0;
        if (kVar instanceof t) {
            da(false);
            if (i == 0 && i2 == 0) {
                Object obj = ((t) kVar).kfN;
                if (obj != null && obj.size() > 0) {
                    if (this.kcs instanceof g) {
                        g gVar = (g) this.kcs;
                        if (obj != null) {
                            gVar.kiF.clear();
                            gVar.kiF.addAll(obj);
                            gVar.kny.clear();
                            while (i3 < obj.size()) {
                                gVar.kny.add(new Boolean(true));
                                i3++;
                            }
                        }
                    }
                    this.kcs.notifyDataSetChanged();
                    return;
                }
                return;
            }
            d.b(this, str, i2);
            return;
        }
        super.a(i, i2, str, kVar);
    }
}
