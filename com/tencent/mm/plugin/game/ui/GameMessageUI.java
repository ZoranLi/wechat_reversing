package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.q.d;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class GameMessageUI extends MMActivity implements OnItemClickListener, e {
    private int gLF = 0;
    private int jZM;
    private ListView mDm;
    private m mDn;
    private TextView mDo;
    private View mDp;
    private int mDq = 1;
    private boolean mDr = false;
    private boolean mDs = false;
    private String mDt = "";
    private OnClickListener mDu;
    private OnClickListener mDv;
    private OnScrollListener mxt = new OnScrollListener(this) {
        final /* synthetic */ GameMessageUI mDw;

        {
            this.mDw = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.mDw.mDn.ahI()) {
                m b = this.mDw.mDn;
                if (!b.ahI()) {
                    b.kor += 15;
                    if (b.kor > b.hOI) {
                        b.kor = b.hOI;
                    }
                } else if (b.uSN != null) {
                    b.uSN.OH();
                }
                this.mDw.mDn.a(null, null);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(573, this);
        this.gLF = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.mDt = getIntent().getStringExtra("game_manage_url");
        KC();
        SubCoreGameCenter.aBC();
        t.aAT();
    }

    protected void onResume() {
        super.onResume();
        this.mDn.notifyDataSetChanged();
        if (this.mDs && this.mDp != null) {
            this.mDm.removeHeaderView(this.mDp);
        }
    }

    protected final void KC() {
        zi(R.l.deZ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameMessageUI mDw;

            {
                this.mDw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mDw.goBack();
                return true;
            }
        });
        a(0, getString(R.l.dGt), new OnMenuItemClickListener(this) {
            final /* synthetic */ GameMessageUI mDw;

            {
                this.mDw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mDw.mDu = new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 mDx;

                    {
                        this.mDx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SubCoreGameCenter.aBB().eE("GameRawMessage", "delete from GameRawMessage");
                        this.mDx.mDw.mDn.OL();
                        this.mDx.mDw.mDn.notifyDataSetChanged();
                    }
                };
                this.mDw.mDv = new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 mDx;

                    {
                        this.mDx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                };
                g.a(this.mDw.uSU.uTo, R.l.eor, 0, this.mDw.mDu, this.mDw.mDv);
                return false;
            }
        });
        this.jZM = getIntent().getIntExtra("game_report_from_scene", 0);
        this.mDm = (ListView) findViewById(R.h.bUH);
        this.mDm.setOnItemClickListener(this);
        if (this.gLF > 20) {
            if (getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true)) {
                this.mDp = View.inflate(this, R.i.dfc, null);
                this.mDp.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ GameMessageUI mDw;

                    {
                        this.mDw = r1;
                    }

                    public final void onClick(View view) {
                        if (!bg.mA(this.mDw.mDt)) {
                            c.aa(this.mDw.uSU.uTo, this.mDw.mDt);
                            ai.a(this.mDw.uSU.uTo, 13, 1302, 1, 7, this.mDw.jZM, null);
                        }
                        this.mDw.mDs = true;
                    }
                });
                this.mDm.addHeaderView(this.mDp);
                this.mDp.setVisibility(0);
                getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
            } else if (this.mDp != null) {
                this.mDp.setVisibility(8);
            }
        }
        q qVar = new q();
        qVar.mqC = true;
        this.mDn = new m(this, qVar, this.jZM);
        this.mDn.ko(true);
        nL(8);
        this.mDn.uSN = new a(this) {
            final /* synthetic */ GameMessageUI mDw;

            {
                this.mDw = r1;
            }

            public final void OI() {
            }

            public final void OH() {
                if (this.mDw.mDn.getCount() == 0) {
                    this.mDw.mDm.setVisibility(8);
                    this.mDw.nL(0);
                    this.mDw.kr(false);
                    return;
                }
                this.mDw.mDm.setVisibility(0);
                this.mDw.nL(8);
                this.mDw.kr(true);
            }
        };
        this.mDm.setOnScrollListener(this.mxt);
        this.mDm.setAdapter(this.mDn);
        ai.a(this.uSU.uTo, 13, 1300, 0, 1, 0, null, this.jZM, 0, null, null, null);
    }

    private void nL(int i) {
        if (this.mDo == null) {
            this.mDo = (TextView) findViewById(R.h.bUF);
        }
        this.mDo.setVisibility(i);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        SubCoreGameCenter.aBB().aAX();
        finish();
    }

    protected final int getLayoutId() {
        return R.i.deZ;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mDn != null) {
            this.mDn.aEW();
        }
        ap.vd().b(573, this);
        boolean eE = SubCoreGameCenter.aBB().eE("GameRawMessage", "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")");
        w.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", new Object[]{Boolean.valueOf(eE), r1});
        SubCoreGameCenter.aBB().aAX();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar = (q) adapterView.getAdapter().getItem(i);
        if (qVar == null) {
            w.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[]{Integer.valueOf(i)});
            return;
        }
        qVar.aAN();
        int a;
        if (qVar.field_msgType == 100) {
            if (!bg.mA(qVar.mqo)) {
                d dVar = (d) qVar.mpU.get(qVar.mqo);
                if (dVar != null) {
                    a = r.a(this, qVar, dVar, qVar.field_appId, 1301);
                    if (a != 0) {
                        ai.a(this.uSU.uTo, 13, 1301, 4, a, 0, qVar.field_appId, this.jZM, qVar.mqy, qVar.field_gameMsgId, qVar.mqz, null);
                    }
                }
            }
        } else if (qVar.mqA == 0) {
            switch (qVar.field_msgType) {
                case 2:
                case 5:
                    if (com.tencent.mm.pluginsdk.model.app.g.n(this, qVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.e.V(this, qVar.field_appId);
                        a = 3;
                    } else {
                        r0 = new Bundle();
                        r0.putCharSequence("game_app_id", qVar.field_appId);
                        r0.putInt("game_report_from_scene", 1301);
                        a = c.a(this, qVar.field_appId, null, r0);
                    }
                    ai.a(this.uSU.uTo, 13, 1301, 4, a, 0, qVar.field_appId, this.jZM, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
                case 6:
                    if (!bg.mA(qVar.mqj)) {
                        c.aa(this, qVar.mqj);
                        ai.a(this.uSU.uTo, 13, 1301, 4, 7, 0, qVar.field_appId, this.jZM, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                        return;
                    }
                    return;
                case 10:
                case 11:
                    if (!bg.mA(qVar.mpH)) {
                        c.aa(this, qVar.mpH);
                        ai.a(this.uSU.uTo, 13, 1301, 4, 7, 0, qVar.field_appId, this.jZM, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (qVar.mqA) {
                case 1:
                    if (bg.mA(qVar.field_appId)) {
                        w.e("MicroMsg.GameMessageUI", "appid is null");
                        return;
                    }
                    r0 = new Bundle();
                    r0.putCharSequence("game_app_id", qVar.field_appId);
                    r0.putInt("game_report_from_scene", 1301);
                    ai.a(this.uSU.uTo, 13, 1301, 4, c.a(this, qVar.field_appId, null, r0), 0, qVar.field_appId, this.jZM, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
                case 2:
                    if (com.tencent.mm.pluginsdk.model.app.g.n(this, qVar.field_appId)) {
                        com.tencent.mm.plugin.game.model.e.V(this, qVar.field_appId);
                        a = 3;
                    } else {
                        r0 = new Bundle();
                        r0.putCharSequence("game_app_id", qVar.field_appId);
                        r0.putInt("game_report_from_scene", 1301);
                        a = c.a(this, qVar.field_appId, null, r0);
                    }
                    ai.a(this.uSU.uTo, 13, 1301, 4, a, 0, qVar.field_appId, this.jZM, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
                case 3:
                    if (bg.mA(qVar.mqB)) {
                        w.e("MicroMsg.GameMessageUI", "jumpurl is null");
                        return;
                    }
                    c.aa(this, qVar.mqB);
                    ai.a(this.uSU.uTo, 13, 1301, 4, 7, 0, qVar.field_appId, this.jZM, qVar.field_msgType, qVar.field_gameMsgId, qVar.mqz, null);
                    return;
                default:
                    w.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + qVar.mqA);
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 573) {
                nL(8);
                this.mDn.a(null, null);
            }
        } else if (this.mDn.getCount() > 0) {
            w.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        } else if (!com.tencent.mm.plugin.game.a.a.imw.a(this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.eoK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
