package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.y.k;
import java.util.List;

public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    protected f jid;
    private int oig;
    private MallTransactionObject oih = null;
    private c oii;

    public void onCreate(Bundle bundle) {
        String string;
        String str = null;
        super.onCreate(bundle);
        b ai = a.ai(this);
        if (ai != null && (ai instanceof com.tencent.mm.plugin.order.a.a)) {
            string = aRN().getString("key_trans_id");
            str = aRN().getString("bill_id");
        } else if (getIntent().getIntExtra("scene", 0) == 1 || getIntent().getIntExtra("scene", 0) == 2) {
            string = getIntent().getStringExtra("trans_id");
            str = getIntent().getStringExtra("bill_id");
        } else {
            string = null;
        }
        if (bg.mA(string)) {
            w.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
            g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                final /* synthetic */ MallOrderTransactionInfoUI oij;

                {
                    this.oij = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oij.finish();
                }
            });
        }
        this.oig = aRN().getInt("key_pay_type");
        KC();
        ccJ().a(new h(string, str), true, true);
    }

    protected final void KC() {
        zi(R.l.ezG);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallOrderTransactionInfoUI oij;

            {
                this.oij = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oij.finish();
                return false;
            }
        });
        this.jid = this.vrv;
        this.oii = new c(this);
        this.oii.init();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oii != null) {
            this.oii.release();
        }
    }

    protected final int getLayoutId() {
        return R.i.dif;
    }

    public final int ON() {
        return R.o.ftQ;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final boolean f(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof h) {
            MallOrderDetailObject mallOrderDetailObject = ((h) kVar).ogH;
            if (mallOrderDetailObject != null) {
                List list;
                this.oih = mallOrderDetailObject.ofw;
                this.jid.removeAll();
                Context context = this.uSU.uTo;
                f fVar = this.jid;
                MallTransactionObject mallTransactionObject = this.oih;
                Object[] objArr = new Object[]{this.oii};
                if (mallTransactionObject == null) {
                    list = null;
                } else {
                    com.tencent.mm.plugin.order.model.a.a bVar;
                    switch (mallTransactionObject.ofL) {
                        case 21:
                            bVar = new com.tencent.mm.plugin.order.ui.a.b();
                            break;
                        default:
                            bVar = new com.tencent.mm.plugin.order.ui.a.a();
                            if (objArr[0] instanceof c) {
                                ((com.tencent.mm.plugin.order.ui.a.a) bVar).oii = (c) objArr[0];
                                break;
                            }
                            break;
                    }
                    list = bVar.a(context, fVar, mallTransactionObject);
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        this.jid.a((Preference) list.get(i3));
                    }
                }
                this.jid.notifyDataSetChanged();
            }
        }
        return true;
    }

    private Bundle aRN() {
        Bundle ah = a.ah(this);
        if (ah == null) {
            return new Bundle();
        }
        return ah;
    }
}
