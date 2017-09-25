package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI extends MMWizardActivity implements a {
    private ae handler = new ae(Looper.getMainLooper());
    private Button jMI;
    private Button jMJ;
    private TextView jMK;
    private TextView jML;
    private int ou = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            KC();
            this.ou = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLP;
            w.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.ou)});
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLK = this;
            acA();
        }
    }

    public final void KC() {
        zi(R.l.dMk);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakToPcUI jMM;

            {
                this.jMM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jw(1);
                this.jMM.zu(1);
                return true;
            }
        });
        this.jMI = (Button) findViewById(R.h.bru);
        this.jMI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakToPcUI jMM;

            {
                this.jMM = r1;
            }

            public final void onClick(View view) {
                if (this.jMM.ou == 0) {
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().aci().hmn = 1;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jw(0);
                    MMWizardActivity.z(this.jMM, new Intent(this.jMM, BakWaitingUI.class));
                }
            }
        });
        this.jMJ = (Button) findViewById(R.h.brs);
        this.jMJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakToPcUI jMM;

            {
                this.jMM = r1;
            }

            public final void onClick(View view) {
                if (this.jMM.ou == 0) {
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().aci().hmn = 2;
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().aci().zO();
                    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jw(1);
                    this.jMM.zu(1);
                }
            }
        });
        this.jMK = (TextView) findViewById(R.h.bry);
        this.jMK.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLQ);
        this.jML = (TextView) findViewById(R.h.brz);
        this.jML.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLR);
    }

    protected final int getLayoutId() {
        return R.i.cVo;
    }

    public void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.ou)});
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLK = null;
    }

    public final void acs() {
        this.ou = 0;
        this.jMI.setVisibility(0);
        this.jMJ.setVisibility(0);
        new ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ BakToPcUI jMM;

            {
                this.jMM = r1;
            }

            public final void run() {
                this.jMM.acA();
            }
        });
    }

    private void acA() {
        if (this.ou == 0) {
            this.jMI.setEnabled(true);
            this.jMJ.setEnabled(true);
            return;
        }
        this.jMI.setEnabled(false);
        this.jMJ.setEnabled(false);
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakToPcUI jMM;

            public final void run() {
                w.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    w.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", this.jMM.getString(R.l.dLe));
                    intent.putExtra("rawUrl", this.jMM.getString(R.l.dKB, new Object[]{v.bIN()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(this.jMM, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                this.jMM.zu(1);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().aci().hmn = 3;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().aci().zO();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jw(1);
        zu(1);
        return true;
    }
}
