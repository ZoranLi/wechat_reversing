package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public class CardInvalidCardUI extends CardBaseUI {
    static /* synthetic */ LinkedList c(CardInvalidCardUI cardInvalidCardUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardInvalidCardUI.kcs.getCount(); i++) {
            CardInfo cardInfo = (CardInfo) cardInvalidCardUI.kcy.kl(i);
            if (cardInfo != null) {
                linkedList.add(cardInfo.field_card_id);
            }
        }
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.KC();
    }

    protected final void KC() {
        super.KC();
    }

    protected final int aeB() {
        return a.kfA;
    }

    protected final void aeA() {
        zi(R.l.dQZ);
        a(0, getString(R.l.dQu), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardInvalidCardUI knw;

            {
                this.knw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                d.a(this.knw, new d.a(this.knw) {
                    final /* synthetic */ CardInvalidCardUI knw;

                    {
                        this.knw = r1;
                    }

                    public final void ahE() {
                        this.knw.kcw = true;
                        this.knw.A(CardInvalidCardUI.c(this.knw));
                    }
                });
                return true;
            }
        });
        if (this.kcs.getCount() > 0) {
            kr(true);
        } else {
            kr(false);
        }
    }

    protected final int getLayoutId() {
        return R.i.cWE;
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0 && (kVar instanceof r)) {
            if (this.kcw) {
                g.bl(this, getResources().getString(R.l.dQw));
            } else {
                g.bl(this, getResources().getString(R.l.dQG));
            }
        }
        this.kcw = false;
    }
}
