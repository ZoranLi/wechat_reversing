package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.ui.b.a;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.ul;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public class AuthorizedGameListUI extends MMActivity implements OnItemClickListener, t {
    public static int mwm = 1;
    public static int mwn = 2;
    public static int mwo = 4;
    public static int mwp = 5;
    public static int mwq = 6;
    private ProgressDialog isv = null;
    private int mqT = 0;
    private ListView mwi;
    private a mwj;
    private View mwk;
    private int mwl = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mqT = getIntent().getIntExtra("game_report_from_scene", 0);
        SubCoreGameCenter.aBG().a(3, this);
        KC();
        final k xVar = new x(3, new ao(v.d(getSharedPreferences(ab.bIX(), 0))));
        ap.vd().a(xVar, 0);
        getString(R.l.dIO);
        this.isv = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ AuthorizedGameListUI mwr;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(xVar);
            }
        });
    }

    protected void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.bUv;
    }

    protected final void KC() {
        this.mwi = (ListView) findViewById(R.h.bUw);
        this.mwk = findViewById(R.h.bLR);
        this.mwj = new a(this);
        this.mwj.mwt = new a(this) {
            final /* synthetic */ AuthorizedGameListUI mwr;

            {
                this.mwr = r1;
            }

            public final void nB(int i) {
                if (i <= 0) {
                    this.mwr.mwi.setVisibility(8);
                    this.mwr.mwk.setVisibility(0);
                    return;
                }
                this.mwr.mwi.setVisibility(0);
                this.mwr.mwk.setVisibility(8);
            }
        };
        this.mwi.setVerticalScrollBarEnabled(false);
        this.mwi.setOnItemClickListener(this);
        this.mwi.setAdapter(this.mwj);
        zi(R.l.eoY);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AuthorizedGameListUI mwr;

            {
                this.mwr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mwr.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        SubCoreGameCenter.aBG().b(3, this);
        if (this.mwj != null) {
            this.mwj.clear();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this, GameSettingsUI.class);
        this.mwl = i;
        intent.putExtra("game_app_id", ((dp) this.mwj.getItem(i)).msh);
        intent.putExtra("game_report_from_scene", this.mqT);
        startActivityForResult(intent, 0);
        ai.a((Context) this, 10, (int) MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, mwn, 6, this.mqT, null);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            w.e("MicroMsg.AuthorizedGameListUI", "invaild requestcode" + i);
            return;
        }
        if (i2 == -1) {
            this.mwj.remove(this.mwl);
            ai.a(this.uSU.uTo, 10, MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, mwo, 21, 1, intent.getStringExtra("game_app_id"), this.mqT, 0, null, null, null);
        }
        if (this.mwj != null) {
            this.mwj.notifyDataSetChanged();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.w wVar) {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
        if (i == 0 && i2 == 0) {
            LinkedList linkedList = ((ul) ((ao) wVar).ldw.hsk.hsr).tCo;
            if (linkedList == null || linkedList.size() == 0) {
                w.d("MicroMsg.AuthorizedGameListUI", "no authapp");
            }
            this.mwj.O(linkedList);
            return;
        }
        Toast.makeText(this, getString(R.l.eoW, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
