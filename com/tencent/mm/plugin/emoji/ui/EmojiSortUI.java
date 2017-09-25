package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.DragSortListView.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiSortUI extends EmojiBaseActivity implements a, e {
    ProgressDialog kIa;
    private com.tencent.mm.plugin.emoji.a.e kQH;
    private DragSortListView kQI;
    private s kQJ;
    private g kQK = new g(this) {
        final /* synthetic */ EmojiSortUI kQM;

        {
            this.kQM = r1;
        }

        public final void bQ(int i, int i2) {
            com.tencent.mm.storage.a.a aVar = (com.tencent.mm.storage.a.a) this.kQM.kQH.getItem(i);
            this.kQM.kQH.remove(aVar);
            this.kQM.kQH.insert(aVar, i2);
        }
    };
    private l kQL = new l(this) {
        final /* synthetic */ EmojiSortUI kQM;

        {
            this.kQM = r1;
        }

        public final void remove(int i) {
            this.kQM.kQH.remove(this.kQM.kQH.getItem(i));
        }
    };
    private ArrayList<com.tencent.mm.storage.a.a> mData = new ArrayList();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        this.mData = h.amc().kLb.bNp();
        this.kQI = (DragSortListView) findViewById(16908298);
        this.kQI.wta = this.kQK;
        this.kQI.wtb = this.kQL;
        this.kQH = new com.tencent.mm.plugin.emoji.a.e(this.uSU.uTo, this.mData);
        this.kQI.setAdapter(this.kQH);
        h.amc().kLb.c(this);
        ap.vd().a(717, this);
    }

    protected void onDestroy() {
        h.amc().kLb.f(this);
        ap.vd().b(717, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.daw;
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiSortUI kQM;

            {
                this.kQM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kQM.finish();
                return true;
            }
        });
        qP(getString(R.l.eSu));
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiSortUI kQM;

            {
                this.kQM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (am.isConnected(ab.getContext())) {
                    Context context = this.kQM;
                    context.getString(R.l.dIO);
                    context.kIa = com.tencent.mm.ui.base.g.a(context, context.getString(R.l.dJd), true, new OnCancelListener(context) {
                        final /* synthetic */ EmojiSortUI kQM;

                        {
                            this.kQM = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (this.kQM.kQJ != null) {
                                ap.vd().c(this.kQM.kQJ);
                            }
                        }
                    });
                    List arrayList = new ArrayList();
                    if (!(this.kQM.kQH == null || this.kQM.kQH.kIf == null)) {
                        for (com.tencent.mm.storage.a.a aVar : this.kQM.kQH.kIf) {
                            arrayList.add(aVar.field_productID);
                        }
                    }
                    this.kQM.kQJ = new s(arrayList, 2);
                    ap.vd().a(this.kQM.kQJ, 0);
                } else {
                    com.tencent.mm.ui.base.g.a(this.kQM, this.kQM.getString(R.l.ecY), "", this.kQM.getString(R.l.ecX), new OnClickListener(this.kQM) {
                        final /* synthetic */ EmojiSortUI kQM;

                        {
                            this.kQM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        });
        ((TextView) findViewById(16908310)).setText(R.l.edq);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (str != null && str.equals("event_update_group") && this.kQH != null) {
            com.tencent.mm.plugin.emoji.a.e eVar = this.kQH;
            ArrayList bNp = h.amc().kLb.bNp();
            eVar.clear();
            Iterator it = bNp.iterator();
            while (it.hasNext()) {
                eVar.insert((com.tencent.mm.storage.a.a) it.next(), eVar.getCount());
            }
            eVar.notifyDataSetChanged();
        }
    }

    public final void g(Message message) {
    }

    public final void h(Message message) {
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.emoji.EmojiSortUI", "ErrType:" + i + "   errCode:" + i2);
        if (this.kIa != null) {
            this.kIa.dismiss();
        }
        if (i == 0 && i == 0) {
            this.kQH.alp();
            finish();
            return;
        }
        com.tencent.mm.ui.base.g.a(this, getString(R.l.ecW), "", new OnClickListener(this) {
            final /* synthetic */ EmojiSortUI kQM;

            {
                this.kQM = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
