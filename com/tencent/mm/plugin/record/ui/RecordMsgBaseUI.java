package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public abstract class RecordMsgBaseUI extends MMActivity {
    protected long fGM = -1;
    protected ListView kaM = null;
    protected h oPm;

    protected abstract h aWL();

    protected abstract String aWM();

    protected abstract String aWN();

    protected abstract String aWO();

    protected abstract void aWP();

    protected abstract void b(int i, int i2, Intent intent);

    protected final int getLayoutId() {
        return R.i.dmt;
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        e.f(this);
        super.onCreate(bundle);
        aWK();
        e.g(this);
    }

    protected void aWK() {
        this.oPm = aWL();
        this.fGM = getIntent().getLongExtra("message_id", -1);
        this.kaM = (ListView) findViewById(R.h.cxi);
        aWS();
        String aWN = aWN();
        String aWO = aWO();
        if (bg.mA(aWN) || bg.mA(aWO)) {
            w.i("MicroMsg.RecordMsgBaseUI", "subtitle time error!");
        } else {
            aWN = aWN.split(" ")[0];
            aWO = aWO.split(" ")[0];
            if (aWN.equals(aWO)) {
                this.oPm.oPg = false;
            } else {
                aWN = aWN + "~" + aWO;
                this.oPm.oPg = true;
            }
            SE(aWN);
        }
        View view = new View(this.uSU.uTo);
        view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.aXM)));
        this.kaM.addHeaderView(view, null, false);
        view = View.inflate(this.uSU.uTo, R.i.dms, null);
        this.kaM.setAdapter(this.oPm);
        this.oPm.Fg = this.kaM;
        this.oPm.aWQ();
        this.kaM.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ RecordMsgBaseUI oPn;

            {
                this.oPn = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    b qvVar = new qv();
                    qvVar.fXQ.type = 5;
                    qvVar.fXQ.fXR = this.oPn.kaM.getFirstVisiblePosition();
                    qvVar.fXQ.fXS = this.oPn.kaM.getLastVisiblePosition();
                    qvVar.fXQ.fXT = this.oPn.kaM.getHeaderViewsCount();
                    a.urY.m(qvVar);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecordMsgBaseUI oPn;

            {
                this.oPn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oPn.finish();
                return true;
            }
        });
        aWP();
        this.kaM.postDelayed(new Runnable(this) {
            final /* synthetic */ RecordMsgBaseUI oPn;

            public final void run() {
                View childAt = this.oPn.kaM.getChildAt(this.oPn.kaM.getLastVisiblePosition());
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    int bottom2 = this.oPn.kaM.getBottom();
                    int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.oPn.uSU.uTo, 64);
                    w.d("MicroMsg.RecordMsgBaseUI", "lastBotm %s, listBotm %s, listEndmargin %s", new Object[]{Integer.valueOf(bottom), Integer.valueOf(bottom2), Integer.valueOf(fromDPToPix)});
                    if (bottom < bottom2 - fromDPToPix) {
                        w.d("MicroMsg.RecordMsgBaseUI", "offset %d", new Object[]{Integer.valueOf((bottom2 - bottom) - fromDPToPix)});
                        view.setPadding(0, bottom, 0, 0);
                    }
                }
                this.oPn.kaM.addFooterView(view, null, false);
            }
        }, 100);
    }

    protected void onResume() {
        super.onResume();
        b qvVar = new qv();
        if (this.kaM != null) {
            qvVar.fXQ.type = 0;
            qvVar.fXQ.fXR = this.kaM.getFirstVisiblePosition();
            qvVar.fXQ.fXS = this.kaM.getLastVisiblePosition();
            qvVar.fXQ.fXT = this.kaM.getHeaderViewsCount();
            a.urY.m(qvVar);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.oPm != null) {
            h hVar = this.oPm;
            for (int i = 0; i < hVar.oPf.size(); i++) {
                h.b bVar = (h.b) hVar.oPf.valueAt(i);
                if (bVar != null) {
                    bVar.pause();
                }
            }
        }
        b qvVar = new qv();
        qvVar.fXQ.type = 1;
        a.urY.m(qvVar);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oPm != null) {
            this.oPm.destroy();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        b(i, i2, intent);
    }

    protected final void aWS() {
        CharSequence aWM = aWM();
        String string = this.uSU.uTo.getString(R.l.egP);
        if (aWM.endsWith(string) && aWM.lastIndexOf(string) > 0) {
            aWM = aWM.substring(0, aWM.lastIndexOf(string) - 1);
        }
        L(h.c(this.uSU.uTo, aWM, getResources().getDimensionPixelSize(R.f.aWE)));
    }
}
