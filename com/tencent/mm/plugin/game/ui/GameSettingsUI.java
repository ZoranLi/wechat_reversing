package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Map;

public class GameSettingsUI extends MMActivity implements t, e {
    private String appId;
    private ProgressDialog isv = null;
    private TextView mFq;
    private TextView mFr;
    private CheckBox mFs;
    private View mFt;
    private View mFu;
    private CheckBox mFv;
    private AuthorizationInfoLayout mFw;
    private ArrayList<String> mFx;
    private boolean mFy;
    private int mqT = 0;
    private ImageView mwf;
    private TextView mwg;
    private f mxk;

    static /* synthetic */ void a(GameSettingsUI gameSettingsUI, boolean z) {
        gameSettingsUI.g(new x(2, z ? new aj(gameSettingsUI.appId, 0, "1") : new aj(gameSettingsUI.appId, 0, "0")));
    }

    static /* synthetic */ void b(GameSettingsUI gameSettingsUI, boolean z) {
        int i = 0;
        if (!z) {
            i = 1;
        }
        gameSettingsUI.mFy = z;
        gameSettingsUI.g(new al(gameSettingsUI.appId, 1, i));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mqT = getIntent().getIntExtra("game_report_from_scene", 0);
        SubCoreGameCenter.aBG().a(2, this);
        ap.vd().a(1221, this);
        this.appId = getIntent().getStringExtra("game_app_id");
        if (bg.mA(this.appId)) {
            w.f("MicroMsg.GameSettingsUI", "appid is null or nill");
        } else {
            this.mxk = g.aJ(this.appId, true);
        }
        KC();
        g(new al(this.appId));
    }

    protected final int getLayoutId() {
        return R.i.cUU;
    }

    protected void onDestroy() {
        super.onDestroy();
        SubCoreGameCenter.aBG().b(2, this);
        ap.vd().b(1221, this);
    }

    protected final void KC() {
        int i = 0;
        this.mwf = (ImageView) findViewById(R.h.bUc);
        this.mwg = (TextView) findViewById(R.h.bUJ);
        this.mFq = (TextView) findViewById(R.h.bTR);
        this.mFw = (AuthorizationInfoLayout) findViewById(R.h.bSD);
        if (this.mxk != null) {
            Bitmap b = g.b(this.mxk.field_appId, 1, a.getDensity(this));
            if (b == null) {
                this.mwf.setImageResource(R.g.bcg);
            } else {
                this.mwf.setImageBitmap(d.a(b, true, 5.0f));
            }
            if (!bg.mA(this.mxk.field_appName)) {
                this.mwg.setText(g.a(this, this.mxk, null));
            }
            if (!bg.mA(this.mxk.gfb)) {
                this.mFq.setText(this.mxk.gfb);
            }
            String str = this.mxk.gfa;
            if (!bg.mA(str)) {
                Map q = bh.q(str, "ScopeList");
                if (q != null && q.size() > 0) {
                    int i2 = bg.getInt((String) q.get(".ScopeList.Count"), 0);
                    if (i2 > 0) {
                        this.mFx = new ArrayList();
                        while (i < i2) {
                            Object obj;
                            StringBuilder stringBuilder = new StringBuilder(".ScopeList.List.item");
                            if (i == 0) {
                                obj = "";
                            } else {
                                obj = Integer.valueOf(i);
                            }
                            String stringBuilder2 = stringBuilder.append(obj).append(".Scope").toString();
                            if (!bg.mA((String) q.get(stringBuilder2))) {
                                this.mFx.add(q.get(stringBuilder2));
                            }
                            i++;
                        }
                    } else {
                        w.d("MicroMsg.GameSettingsUI", "auth info is null :" + this.mxk.field_appName + ", " + this.appId);
                    }
                }
                if (this.mFx == null || this.mFx.size() <= 0) {
                    w.d("MicroMsg.GameSettingsUI", "this game's authinfo is null " + this.appId);
                    this.mFw.setVisibility(8);
                } else {
                    this.mFw.F(this.mFx);
                }
            }
        }
        this.mFr = (TextView) findViewById(R.h.bJx);
        this.mFr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameSettingsUI mFz;

            {
                this.mFz = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.base.g.a(this.mFz, R.l.eoD, R.l.eoC, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 mFA;

                    {
                        this.mFA = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mFA.mFz.g(new x(2, new aj(this.mFA.mFz.appId, 1, null)));
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 mFA;

                    {
                        this.mFA = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.mFs = (CheckBox) findViewById(R.h.bmG);
        this.mFs.setChecked(g.LX(this.appId));
        this.mFt = findViewById(R.h.bmy);
        this.mFt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameSettingsUI mFz;

            {
                this.mFz = r1;
            }

            public final void onClick(View view) {
                if (this.mFz.mFs.isChecked()) {
                    this.mFz.mFs.setChecked(false);
                    GameSettingsUI.a(this.mFz, false);
                    return;
                }
                this.mFz.mFs.setChecked(true);
                GameSettingsUI.a(this.mFz, true);
            }
        });
        this.mFv = (CheckBox) findViewById(R.h.cFc);
        this.mFu = findViewById(R.h.cFb);
        this.mFu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameSettingsUI mFz;

            {
                this.mFz = r1;
            }

            public final void onClick(View view) {
                if (this.mFz.mFv.isChecked()) {
                    this.mFz.mFv.setChecked(false);
                    GameSettingsUI.b(this.mFz, false);
                    return;
                }
                this.mFz.mFv.setChecked(true);
                GameSettingsUI.b(this.mFz, true);
            }
        });
        zi(R.l.epB);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameSettingsUI mFz;

            {
                this.mFz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mFz.setResult(0);
                this.mFz.finish();
                return true;
            }
        });
    }

    private void g(final k kVar) {
        ap.vd().a(kVar, 0);
        getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ GameSettingsUI mFz;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(kVar);
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.w wVar) {
        if (!cf(i, i2)) {
            aj ajVar = (aj) wVar;
            if (ajVar.cmdId == 0) {
                boolean LX = g.LX(this.appId);
                if (this.mFs != null) {
                    this.mFs.setChecked(LX);
                }
                if (LX) {
                    ai.a(this.uSU.uTo, 10, MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, AuthorizedGameListUI.mwp, 20, 1, this.appId, this.mqT, 0, null, null, null);
                } else {
                    ai.a(this.uSU.uTo, 10, MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, AuthorizedGameListUI.mwp, 21, 1, this.appId, this.mqT, 0, null, null, null);
                }
            } else if (ajVar.cmdId == 1) {
                w.i("MicroMsg.GameSettingsUI", "relieve app authorization ok");
                Intent intent = new Intent();
                intent.putExtra("game_app_id", this.appId);
                setResult(-1, intent);
                finish();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!cf(i, i2)) {
            switch (kVar.getType()) {
                case 1221:
                    int i3 = ((af) ((al) kVar).ldw.hsj.hsr).mtC;
                    ag agVar = (ag) ((al) kVar).ldw.hsk.hsr;
                    Object obj = (agVar == null || (agVar.mtD & 1) <= 0) ? null : 1;
                    switch (i3) {
                        case 0:
                            this.mFv.setChecked(obj == null);
                            return;
                        case 1:
                            ai.a(this.uSU.uTo, 10, MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, AuthorizedGameListUI.mwq, this.mFy ? 20 : 21, 1, this.appId, this.mqT, 0, null, null, null);
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    private boolean cf(int i, int i2) {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        Toast.makeText(this, getString(R.l.eoP, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        setResult(0);
        finish();
        return true;
    }
}
