package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiMineUI extends BaseEmojiStoreUI implements OnClickListener {
    private final String TAG = "MicroMsg.emoji.EmojiMineUI";
    private View kPN;
    private TextView kPO;
    private ViewGroup kQA;
    private ViewGroup kQB;
    private ViewGroup kQC;
    private TextView kQD;
    private ViewGroup kQz;

    protected final int getLayoutId() {
        return R.i.daB;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        g.oUh.A(10931, String.valueOf(getIntent().getIntExtra("10931", 0)));
        w.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[]{Integer.valueOf(r0)});
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiMineUI kQE;

            {
                this.kQE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kQE.finish();
                return true;
            }
        });
        a(0, getString(R.l.ecV), new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiMineUI kQE;

            {
                this.kQE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ArrayList bNp = h.amc().kLb.bNp();
                List arrayList = new ArrayList();
                Iterator it = bNp.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.field_type != a.TYPE_CUSTOM) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    com.tencent.mm.ui.base.g.h(this.kQE.uSU.uTo, R.l.ecn, R.l.dIO);
                } else if (am.isConnected(ab.getContext())) {
                    Intent intent = new Intent();
                    intent.setClass(this.kQE, EmojiSortUI.class);
                    this.kQE.startActivity(intent);
                } else {
                    com.tencent.mm.ui.base.g.a(this.kQE, this.kQE.getString(R.l.ecY), "", this.kQE.getString(R.l.ecX), new DialogInterface.OnClickListener(this.kQE) {
                        final /* synthetic */ EmojiMineUI kQE;

                        {
                            this.kQE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        });
        ap.yY();
        if (!((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uzH, Boolean.valueOf(false))).booleanValue()) {
            com.tencent.mm.plugin.emoji.c.a.dq(true);
        }
        g.oUh.a(406, 3, 1, false);
        g.oUh.a(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected final void KC() {
        zi(R.l.eSv);
        super.KC();
        this.kPN = findViewById(R.h.cHc);
        this.kPO = (TextView) this.kPN.findViewById(R.h.cHb);
        this.kPO.setText(R.l.eeh);
        if (h.alZ().kNA.kNQ) {
            h.alZ();
            if (BKGLoaderManager.amA()) {
                this.kPN.setVisibility(0);
                bP(8001, 3000);
                this.Fg.setOnScrollListener(null);
            }
        }
        this.kPN.setVisibility(8);
        this.Fg.setOnScrollListener(null);
    }

    public void onClick(View view) {
        Intent intent;
        if (view == this.kQA) {
            intent = new Intent();
            intent.setClass(this, EmojiCustomUI.class);
            startActivity(intent);
        } else if (view == this.kQB) {
            intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            startActivity(intent);
        }
    }

    protected final boolean amL() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a amH() {
        return new com.tencent.mm.plugin.emoji.a.c(this.uSU.uTo);
    }

    protected final int amO() {
        return 8;
    }

    protected final int amQ() {
        return 2;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i - 1, j);
    }

    public final void a(String str, l lVar) {
        if (str != null && str.equals("event_update_group")) {
            ang();
            bP(131074, 50);
        }
    }

    public final void e(String str, int i, int i2, String str2) {
    }

    protected final boolean amX() {
        return false;
    }

    protected final void amI() {
        this.kQC = (ViewGroup) View.inflate(this.uSU.uTo, R.i.dav, null);
        this.kQD = (TextView) this.kQC.findViewById(16908310);
        this.kQD.setText(R.l.eSw);
        this.kQC.setVisibility(8);
        this.kQD.setVisibility(8);
        this.Fg.addHeaderView(this.kQC, null, false);
        this.kQz = (ViewGroup) View.inflate(this.uSU.uTo, R.i.dau, null);
        this.kQA = (ViewGroup) this.kQz.findViewById(R.h.cjS);
        ((TextView) this.kQA.findViewById(16908310)).setText(R.l.daq);
        this.kQB = (ViewGroup) this.kQz.findViewById(R.h.cjT);
        ((TextView) this.kQB.findViewById(16908310)).setText(R.l.ecN);
        this.kQB.findViewById(R.h.content).setBackgroundResource(R.g.bep);
        this.kQA.setOnClickListener(this);
        this.kQB.setOnClickListener(this);
        this.Fg.addFooterView(this.kQz, null, false);
    }

    protected final boolean amW() {
        return true;
    }

    protected final boolean amT() {
        boolean z = true;
        if (this.kLV != null) {
            this.kLV.notifyDataSetChanged();
            this.kPa = true;
            this.jAA.setVisibility(8);
        } else {
            z = false;
        }
        amY();
        return z;
    }

    protected final void c(xy xyVar) {
        super.c(xyVar);
    }

    protected final void a(boolean z, e eVar, boolean z2, boolean z3) {
    }

    protected final boolean amK() {
        return false;
    }

    public final void h(Message message) {
        if (message.what == 8001 && this.kPN != null) {
            this.kPN.setVisibility(8);
        }
        super.h(message);
    }

    public final void amY() {
        if (this.kQC == null) {
            return;
        }
        if (this.kLV == null || this.kLV.isEmpty()) {
            this.kQC.setVisibility(8);
            this.kQD.setVisibility(8);
            return;
        }
        this.kQC.setVisibility(0);
        this.kQD.setVisibility(0);
    }

    protected final int amF() {
        return 24;
    }

    protected final int amG() {
        return 7;
    }
}
