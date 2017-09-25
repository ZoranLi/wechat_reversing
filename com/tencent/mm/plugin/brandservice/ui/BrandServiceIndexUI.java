package com.tencent.mm.plugin.brandservice.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.d.g;

public class BrandServiceIndexUI extends MMActivity implements a {
    private int huO = 251658241;
    private TextView kaw = null;
    private BrandServiceSortView kax;
    private boolean kay = false;
    private boolean kaz = false;

    protected final int getLayoutId() {
        return R.i.cVZ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.huO = getIntent().getIntExtra("intent_service_type", 251658241);
        this.kaz = s.ee(getIntent().getIntExtra("list_attr", 0), 16384);
        KC();
        w.DH().c(this);
    }

    protected void onResume() {
        if (this.kay) {
            this.kay = false;
            this.kax.refresh();
        }
        super.onResume();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        ae(1, true);
    }

    protected void onPause() {
        ap.yY();
        c.vr().set(233474, Long.valueOf(System.currentTimeMillis()));
        ap.yY();
        c.vr().set(233473, Long.valueOf(System.currentTimeMillis()));
        ap.yY();
        c.vr().set(233476, Long.valueOf(System.currentTimeMillis()));
        super.onPause();
    }

    protected void onDestroy() {
        if (ap.zb()) {
            this.kax.release();
            w.DH().f(this);
        }
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.dCJ);
        this.kax = (BrandServiceSortView) findViewById(R.h.cFV);
        this.kax.L(true);
        this.kax.kaz = this.kaz;
        this.kaw = (TextView) findViewById(R.h.cqt);
        this.kaw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI kaA;

            {
                this.kaA = r1;
            }

            public final void onClick(View view) {
            }
        });
        this.kaw.setVisibility(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI kaA;

            {
                this.kaA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kaA.finish();
                return true;
            }
        });
        a(0, R.l.eYk, R.k.dsU, new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI kaA;

            {
                this.kaA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.sdk.platformtools.w.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
                Intent intent = new Intent(this.kaA, BrandServiceLocalSearchUI.class);
                intent.putExtra("is_return_result", this.kaA.kaz);
                intent.addFlags(67108864);
                this.kaA.startActivityForResult(intent, 1);
                return true;
            }
        });
        a(1, R.l.dBN, R.k.dsI, new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI kaA;

            {
                this.kaA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (d.Ii()) {
                    Intent Il = d.Il();
                    Il.putExtra("KRightBtn", true);
                    Il.putExtra("ftsneedkeyboard", true);
                    Il.putExtra("key_load_js_without_delay", true);
                    Il.putExtra("ftsType", 1);
                    Il.putExtra("ftsbizscene", 6);
                    Il.putExtra("rawUrl", d.m(d.a(6, true, 0)));
                    com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Il);
                } else {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
                }
                this.kaA.ae(1, false);
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && this.kaz) {
            setResult(-1, intent);
            finish();
        }
    }

    public final void a(String str, l lVar) {
        com.tencent.mm.sdk.platformtools.w.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[]{str});
        this.kay = true;
    }
}
