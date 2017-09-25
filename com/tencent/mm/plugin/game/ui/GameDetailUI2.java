package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.plugin.game.c.ba;
import com.tencent.mm.plugin.game.c.cc;
import com.tencent.mm.plugin.game.c.r;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.l.b;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI.a;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2 extends MMActivity implements e {
    private String appId = null;
    private Dialog leb;
    private TextView mAa;
    private TextView mAb;
    private boolean mAc = false;
    private LinearLayout mAd;
    private TextView mAe;
    private LinearLayout mAf;
    private TextView mAg;
    private cc mAh;
    private OnClickListener mAi = new OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 mAp;

        {
            this.mAp = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.mAp.mzz.aAK();
            this.mAp.mzy.a(this.mAp.mzF, this.mAp.mzE, this.mAp.mpz, this.mAp.mzz);
        }
    };
    private View.OnClickListener mAj = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 mAp;

        {
            this.mAp = r1;
        }

        public final void onClick(View view) {
            if (this.mAp.mpz == null) {
                w.e("MicroMsg.GameDetailUI2", "Null appInfo");
            } else if (this.mAp.mzz == null) {
                w.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
            } else {
                this.mAp.mzz.cj(this.mAp.uSU.uTo);
                this.mAp.mzy.a(this.mAp.mpz, this.mAp.mzz);
            }
        }
    };
    private View.OnClickListener mAk = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 mAp;

        {
            this.mAp = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof String) {
                c.a(view, this.mAp);
                ai.a(this.mAp.uSU.uTo, 12, 1203, 999, 7, this.mAp.appId, this.mAp.mqT, null);
                return;
            }
            a aVar = new a();
            aVar.mzq = this.mAp.mzq;
            aVar.mzr = this.mAp.mzr;
            aVar.mzs = this.mAp.mpz;
            String fQ = q.fQ("rankData");
            q.yC().n(fQ, true).l(GameDetailRankUI.mzo, aVar);
            Intent intent = new Intent(this.mAp.uSU.uTo, GameDetailRankUI.class);
            intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, fQ);
            this.mAp.startActivity(intent);
            ai.a(this.mAp.uSU.uTo, 12, 1203, 999, 6, this.mAp.appId, this.mAp.mqT, null);
        }
    };
    private View.OnClickListener mAl = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 mAp;

        {
            this.mAp = r1;
        }

        public final void onClick(View view) {
            c.a(view, this.mAp);
            ai.a(this.mAp.uSU.uTo, 12, 1204, 999, 7, this.mAp.appId, this.mAp.mqT, null);
        }
    };
    private View.OnClickListener mAm = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 mAp;

        {
            this.mAp = r1;
        }

        public final void onClick(View view) {
            c.a(view, this.mAp);
            ai.a(this.mAp.uSU.uTo, 12, 1205, 1, 7, this.mAp.appId, this.mAp.mqT, null);
        }
    };
    private View.OnClickListener mAn = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 mAp;

        {
            this.mAp = r1;
        }

        public final void onClick(View view) {
            c.a(view, this.mAp);
            ai.a(this.mAp.uSU.uTo, 12, 1205, 999, 7, this.mAp.appId, this.mAp.mqT, null);
        }
    };
    private View.OnClickListener mAo = new View.OnClickListener(this) {
        final /* synthetic */ GameDetailUI2 mAp;

        {
            this.mAp = r1;
        }

        public final void onClick(View view) {
            c.a(view, this.mAp);
            ai.a(this.mAp.uSU.uTo, 12, 1206, 1, 7, this.mAp.appId, this.mAp.mqT, null);
        }
    };
    private com.tencent.mm.plugin.game.model.c mpz = null;
    private int mqT = 0;
    private ViewGroup mzA;
    private ImageView mzB;
    private ImageView mzC;
    private TextView mzD;
    private Button mzE;
    private TextProgressBar mzF;
    private TextView mzG;
    private LinearLayout mzH;
    private GameDetailAutoScrollView mzI;
    private LinearLayout mzJ;
    private TextView mzK;
    private LinearLayout mzL;
    private TextView mzM;
    private LinearLayout mzN;
    private ImageView mzO;
    private View mzP;
    private TextView mzQ;
    private TextView mzR;
    private View mzS;
    private TextView mzT;
    private ImageView mzU;
    private TextView mzV;
    private TextView mzW;
    private LinearLayout mzX;
    private GameMediaList mzY;
    private TextView mzZ;
    private String mzq = null;
    private String mzr = null;
    private int mzt = 18;
    private boolean mzu;
    private boolean mzv;
    private String mzw = null;
    private b mzx = null;
    private e mzy = null;
    private m mzz = null;

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, final cc ccVar) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(gameDetailUI2.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(gameDetailUI2) {
            final /* synthetic */ GameDetailUI2 mAp;

            public final void a(l lVar) {
                if (ccVar.mvQ) {
                    lVar.a(0, this.mAp.getString(R.l.fnu), R.k.duZ);
                }
                if (ccVar.mvR) {
                    lVar.a(1, this.mAp.getString(R.l.fnv), R.k.duP);
                }
            }
        };
        eVar.qJg = new d(gameDetailUI2) {
            final /* synthetic */ GameDetailUI2 mAp;

            {
                this.mAp = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        GameDetailUI2.p(this.mAp);
                        return;
                    case 1:
                        GameDetailUI2.q(this.mAp);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, ac acVar) {
        if (gameDetailUI2.isFinishing()) {
            w.w("MicroMsg.GameDetailUI2", "GameDetailUI2 hasFinished");
        } else if (acVar == null) {
            w.e("MicroMsg.GameDetailUI2", "Null data");
        } else {
            gameDetailUI2.mpz = acVar.mrb;
            String str = acVar.mqZ.mtZ == null ? null : bg.mA(acVar.mqZ.mtZ.mvA) ? null : acVar.mqZ.mtZ.mvA;
            gameDetailUI2.mzq = str;
            str = acVar.mqZ.mtZ == null ? null : bg.mA(acVar.mqZ.mtZ.mvB) ? null : acVar.mqZ.mtZ.mvB;
            gameDetailUI2.mzr = str;
            if (!gameDetailUI2.mzv) {
                gameDetailUI2.mzv = true;
                ai.a(gameDetailUI2, 12, 1200, 0, 1, gameDetailUI2.appId, gameDetailUI2.mqT, null);
            }
            com.tencent.mm.plugin.game.model.c cVar = acVar.mrb;
            com.tencent.mm.ah.a.a GW = com.tencent.mm.ah.n.GW();
            String str2 = acVar.mqZ.mtU;
            ImageView imageView = gameDetailUI2.mzB;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIK = true;
            GW.a(str2, imageView, aVar.Hg());
            ImageView imageView2 = gameDetailUI2.mzC;
            str2 = gameDetailUI2.appId;
            float density = com.tencent.mm.bg.a.getDensity(gameDetailUI2);
            if (!(imageView2 == null || bg.mA(str2))) {
                Bitmap b = g.b(str2, 1, density);
                if (b == null || b.isRecycled()) {
                    imageView2.setImageResource(R.g.bfs);
                    an.aRr().c(new com.tencent.mm.plugin.game.ui.i.a.AnonymousClass1(str2, density, imageView2));
                } else {
                    imageView2.setImageBitmap(b);
                }
            }
            gameDetailUI2.mzD.setText(cVar != null ? cVar.field_appName : "");
            if (cVar == null || bg.mA(cVar.moy)) {
                gameDetailUI2.mzG.setVisibility(8);
            } else {
                gameDetailUI2.mzG.setText(cVar.moy);
                gameDetailUI2.mzG.setVisibility(0);
            }
            if (gameDetailUI2.mpz == null) {
                gameDetailUI2.mzE.setVisibility(8);
            } else {
                gameDetailUI2.mzE.setVisibility(0);
                if (gameDetailUI2.mzy == null) {
                    gameDetailUI2.mzy = new e(gameDetailUI2);
                    gameDetailUI2.mzy.mxb = gameDetailUI2.mAi;
                    gameDetailUI2.mzy.mqT = gameDetailUI2.mqT;
                    gameDetailUI2.mzy.mwG = gameDetailUI2.mzw;
                }
                gameDetailUI2.mzE.setOnClickListener(gameDetailUI2.mAj);
                gameDetailUI2.mzF.setOnClickListener(gameDetailUI2.mAj);
                gameDetailUI2.mzz = new m(gameDetailUI2.mpz);
                gameDetailUI2.mzz.cj(gameDetailUI2);
                gameDetailUI2.mzz.aAK();
                gameDetailUI2.mzy.a(gameDetailUI2.mzF, gameDetailUI2.mzE, gameDetailUI2.mpz, gameDetailUI2.mzz);
                w.i("MicroMsg.GameDetailUI2", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[]{Integer.valueOf(gameDetailUI2.mpz.status), Integer.valueOf(gameDetailUI2.mzz.mode), Integer.valueOf(gameDetailUI2.mzz.status)});
                if (!bg.mA(gameDetailUI2.appId)) {
                    if (gameDetailUI2.mzx != null) {
                        com.tencent.mm.plugin.game.model.l.a(gameDetailUI2.mzx);
                    } else {
                        gameDetailUI2.mzx = new b(gameDetailUI2) {
                            final /* synthetic */ GameDetailUI2 mAp;

                            {
                                this.mAp = r1;
                            }

                            public final void g(int i, String str, boolean z) {
                                if (this.mAp.mpz != null) {
                                    this.mAp.mzz.cj(this.mAp);
                                    this.mAp.mzz.aAK();
                                    if (z) {
                                        this.mAp.mzy.a(this.mAp.mzF, this.mAp.mzE, this.mAp.mpz, this.mAp.mzz);
                                    }
                                }
                            }
                        };
                        com.tencent.mm.plugin.game.model.l.a(gameDetailUI2.mzx);
                    }
                }
            }
            Collection arrayList = new ArrayList();
            if (acVar.mqZ.mua != null) {
                Iterator it = acVar.mqZ.mua.iterator();
                while (it.hasNext()) {
                    r rVar = (r) it.next();
                    if (bg.mA(rVar.jNj)) {
                        arrayList.add("");
                    } else {
                        ap.yY();
                        x Rc = com.tencent.mm.u.c.wR().Rc(rVar.jNj);
                        if (Rc == null || Rc.gTQ == 0) {
                            arrayList.add(rVar.jNj + " ");
                        } else {
                            arrayList.add(Rc.tL() + " ");
                        }
                    }
                    arrayList.add(rVar.mtg);
                }
            }
            if (arrayList.size() != 0) {
                gameDetailUI2.mzI.setVisibility(0);
                GameDetailAutoScrollView gameDetailAutoScrollView = gameDetailUI2.mzI;
                gameDetailAutoScrollView.myI.clear();
                gameDetailAutoScrollView.mxh.KH();
                if (arrayList.size() == 0 || arrayList.size() % 2 != 0) {
                    gameDetailAutoScrollView.myJ.setVisibility(8);
                    gameDetailAutoScrollView.myM.setVisibility(8);
                } else {
                    gameDetailAutoScrollView.myI.addAll(arrayList);
                    gameDetailAutoScrollView.kZt = 0;
                    gameDetailAutoScrollView.myK.setText(h.b(gameDetailAutoScrollView.getContext(), (CharSequence) gameDetailAutoScrollView.myI.get(0), gameDetailAutoScrollView.myK.getTextSize()));
                    gameDetailAutoScrollView.myL.setText((CharSequence) gameDetailAutoScrollView.myI.get(1));
                    gameDetailAutoScrollView.myJ.setVisibility(0);
                    gameDetailAutoScrollView.myM.setVisibility(8);
                    if (gameDetailAutoScrollView.myI.size() / 2 != 1) {
                        gameDetailAutoScrollView.mxh.v(5000, 5000);
                    }
                }
            } else {
                gameDetailUI2.mzI.setVisibility(8);
            }
            gameDetailUI2.b(acVar.mrc);
            CharSequence charSequence = acVar.mqZ.mtZ == null ? null : bg.mA(acVar.mqZ.mtZ.muK) ? null : acVar.mqZ.mtZ.muK;
            String str3 = acVar.mqZ.mtZ == null ? null : bg.mA(acVar.mqZ.mtZ.muL) ? null : acVar.mqZ.mtZ.muL;
            if (bg.mA(charSequence)) {
                gameDetailUI2.mzK.setVisibility(8);
            } else {
                gameDetailUI2.mzK.setText(charSequence);
                if (bg.mA(str3)) {
                    gameDetailUI2.mzK.setTag(null);
                } else {
                    gameDetailUI2.mzK.setTag(str3);
                }
                gameDetailUI2.mzK.setOnClickListener(gameDetailUI2.mAk);
            }
            gameDetailUI2.a(acVar);
            gameDetailUI2.b(acVar);
            if (bg.mA(acVar.aBe()) || bg.mA(acVar.aBf())) {
                gameDetailUI2.mzX.setVisibility(8);
            } else {
                gameDetailUI2.mzX.setVisibility(0);
                gameDetailUI2.mzY.R(acVar.aBd());
                gameDetailUI2.mzZ.setText(acVar.aBe());
                gameDetailUI2.mAa.setText(acVar.aBf());
            }
            if (acVar.mqZ.muc == null) {
                gameDetailUI2.mzS.setVisibility(8);
            } else {
                gameDetailUI2.mzS.setVisibility(0);
                gameDetailUI2.mzT.setText(acVar.mqZ.muc.title);
                com.tencent.mm.ah.n.GW().a(acVar.mqZ.muc.hSW, gameDetailUI2.mzU);
                gameDetailUI2.mzV.setText(acVar.mqZ.muc.muN);
                gameDetailUI2.mzW.setText(acVar.mqZ.muc.desc);
                ((ViewGroup) gameDetailUI2.mzV.getParent().getParent()).setTag(acVar.mqZ.muc.muO);
                ((ViewGroup) gameDetailUI2.mzV.getParent().getParent()).setOnClickListener(gameDetailUI2.mAo);
            }
            gameDetailUI2.c(acVar);
            gameDetailUI2.mAh = acVar.mqZ.mub;
            if (gameDetailUI2.mAh == null || !(gameDetailUI2.mAh.mvQ || gameDetailUI2.mAh.mvR)) {
                gameDetailUI2.uSU.bQf();
            } else {
                super.a(0, R.g.bhb, new OnMenuItemClickListener(gameDetailUI2) {
                    final /* synthetic */ GameDetailUI2 mAp;

                    {
                        this.mAp = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        GameDetailUI2.a(this.mAp, this.mAp.mAh);
                        ai.a(this.mAp.uSU.uTo, 12, 1207, 1, 2, this.mAp.appId, this.mAp.mqT, null);
                        return false;
                    }
                });
            }
            gameDetailUI2.mzA.removeView(gameDetailUI2.mzX);
            gameDetailUI2.mzA.removeView(gameDetailUI2.mzS);
            gameDetailUI2.mzA.removeView(gameDetailUI2.mAd);
            if (acVar.mrb.status == 1) {
                gameDetailUI2.mzA.addView(gameDetailUI2.mzS);
                gameDetailUI2.mzA.addView(gameDetailUI2.mzX);
            } else {
                gameDetailUI2.mzA.addView(gameDetailUI2.mzX);
                gameDetailUI2.mzA.addView(gameDetailUI2.mzS);
            }
            gameDetailUI2.mzA.addView(gameDetailUI2.mAd);
        }
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        f.a aVar = new f.a();
        aVar.title = gameDetailUI2.mAh.mvN;
        aVar.description = gameDetailUI2.mAh.mvO;
        aVar.type = 5;
        if (bg.mA(gameDetailUI2.mAh.msi)) {
            aVar.thumburl = gameDetailUI2.mpz.field_appIconUrl;
        } else {
            aVar.thumburl = gameDetailUI2.mAh.msi;
        }
        aVar.url = gameDetailUI2.mAh.mse;
        com.tencent.mm.pluginsdk.model.app.l.a(aVar, gameDetailUI2.appId, gameDetailUI2.mpz.field_appName, str, null, null, null);
        if (!bg.mA(str2)) {
            com.tencent.mm.sdk.b.b nvVar = new nv();
            nvVar.fVa.fVb = str;
            nvVar.fVa.content = str2;
            nvVar.fVa.type = o.fG(str);
            nvVar.fVa.flags = 0;
            com.tencent.mm.sdk.b.a.urY.m(nvVar);
        }
    }

    static /* synthetic */ void p(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
        com.tencent.mm.bb.d.a(gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.uSU.uTo.overridePendingTransition(R.a.aRq, R.a.aQY);
    }

    static /* synthetic */ void q(GameDetailUI2 gameDetailUI2) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.mAh.mvP);
        String str = gameDetailUI2.mAh.msi;
        if (bg.mA(str)) {
            str = gameDetailUI2.mpz.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.mAh.mse);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        str = q.fQ("game_center");
        q.yC().n(str, true).l("prePublishId", "game_center");
        intent.putExtra("reportSessionId", str);
        com.tencent.mm.bb.d.b(gameDetailUI2.uSU.uTo, "sns", ".ui.En_c4f742e5", intent, 3);
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        if (ap.zb()) {
            this.mzu = true;
            this.mzv = false;
            this.appId = getIntent().getStringExtra("game_app_id");
            if (bg.mA(this.appId)) {
                w.e("MicroMsg.GameDetailUI2", "appid is null or nill");
                finish();
            } else {
                this.mqT = getIntent().getIntExtra("game_report_from_scene", 0);
            }
            KC();
            ap.vd().a(1217, this);
            final byte[] xQ = SubCoreGameCenter.aBF().xQ(this.appId);
            if (xQ == null || xQ.length == 0) {
                w.i("MicroMsg.GameDetailUI2", "No cache found");
                z = false;
            } else {
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ GameDetailUI2 mAp;

                    public final void run() {
                        final ac acVar = new ac(xQ);
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 mAt;

                            public final void run() {
                                GameDetailUI2.a(this.mAt.mAp, acVar);
                            }
                        });
                    }
                });
            }
            if (!z) {
                this.leb = c.cm(this);
                this.leb.show();
            }
            ap.vd().a(new com.tencent.mm.plugin.game.model.ap(v.bIN(), this.appId, g.n(this, this.appId)), 0);
            return;
        }
        w.e("MicroMsg.GameDetailUI2", "account not ready");
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dep;
    }

    protected final int Ol() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!(this.mpz == null || this.mzz == null)) {
            this.mzz.aAK();
            this.mzy.a(this.mzF, this.mzE, this.mpz, this.mzz);
        }
        if (this.mzu) {
            this.mzu = false;
        } else {
            b(new ad(this.appId));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1217, this);
        if (this.mzx != null) {
            com.tencent.mm.plugin.game.model.l.b(this.mzx);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!bg.mA(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            startActivity(intent);
        }
        finish();
    }

    protected final void KC() {
        zi(R.l.eoB);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameDetailUI2 mAp;

            {
                this.mAp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mAp.goBack();
                return true;
            }
        });
        this.mzA = (ViewGroup) findViewById(R.h.bSQ);
        this.mzB = (ImageView) findViewById(R.h.bSR);
        this.mzC = (ImageView) findViewById(R.h.bUc);
        this.mzD = (TextView) findViewById(R.h.bUJ);
        this.mzG = (TextView) findViewById(R.h.bUe);
        this.mzE = (Button) findViewById(R.h.bSy);
        this.mzF = (TextProgressBar) findViewById(R.h.bUM);
        this.mzF.nQ(this.mzt);
        this.mzH = (LinearLayout) findViewById(R.h.bTN);
        this.mzI = (GameDetailAutoScrollView) findViewById(R.h.bTM);
        this.mzJ = (LinearLayout) findViewById(R.h.bTw);
        this.mzK = (TextView) findViewById(R.h.bTy);
        this.mzL = (LinearLayout) findViewById(R.h.bSY);
        this.mzM = (TextView) findViewById(R.h.bTh);
        this.mzN = (LinearLayout) findViewById(R.h.bSZ);
        this.mzO = (ImageView) findViewById(R.h.bTa);
        this.mzP = findViewById(R.h.bTb);
        this.mzQ = (TextView) findViewById(R.h.bTd);
        this.mzR = (TextView) findViewById(R.h.bTc);
        this.mzS = findViewById(R.h.bTi);
        this.mzT = (TextView) findViewById(R.h.bTm);
        this.mzU = (ImageView) findViewById(R.h.bTl);
        this.mzV = (TextView) findViewById(R.h.bTj);
        this.mzW = (TextView) findViewById(R.h.bTk);
        this.mzX = (LinearLayout) findViewById(R.h.bSU);
        this.mzY = (GameMediaList) findViewById(R.h.bTv);
        GameMediaList gameMediaList = this.mzY;
        String str = this.appId;
        int i = this.mqT;
        gameMediaList.appId = str;
        gameMediaList.lvp = 12;
        gameMediaList.mAG = i;
        gameMediaList.mContext = this;
        this.mzY.mCE = R.i.deS;
        this.mzZ = (TextView) findViewById(R.h.bSW);
        this.mAa = (TextView) findViewById(R.h.bSV);
        this.mAa.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ GameDetailUI2 mAp;

            {
                this.mAp = r1;
            }

            public final void onGlobalLayout() {
                if (this.mAp.mAa.getLineCount() > 3) {
                    this.mAp.mAb.setVisibility(0);
                } else {
                    this.mAp.mAb.setVisibility(8);
                }
            }
        });
        this.mAb = (TextView) findViewById(R.h.bSX);
        this.mAb.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ GameDetailUI2 mAp;

            {
                this.mAp = r1;
            }

            public final void onClick(View view) {
                if (this.mAp.mAc) {
                    this.mAp.mAa.setMaxLines(3);
                    this.mAp.mAb.setText(this.mAp.getResources().getText(R.l.eos));
                    this.mAp.mAc = false;
                    return;
                }
                this.mAp.mAa.setMaxLines(100);
                this.mAp.mAb.setText(this.mAp.getResources().getText(R.l.eot));
                this.mAp.mAc = true;
            }
        });
        this.mAd = (LinearLayout) findViewById(R.h.bTn);
        this.mAe = (TextView) findViewById(R.h.bTu);
        this.mAf = (LinearLayout) findViewById(R.h.bTo);
        this.mAg = (TextView) findViewById(R.h.bTp);
    }

    private void b(ad adVar) {
        int i = 0;
        List list = adVar.mrd;
        if (list == null || list.size() == 0) {
            this.mzJ.setVisibility(8);
            this.mzK.setVisibility(8);
            return;
        }
        this.mzJ.setVisibility(0);
        if (list.size() > 3) {
            this.mzK.setVisibility(0);
        } else {
            this.mzK.setVisibility(8);
        }
        this.mzJ.removeAllViews();
        h hVar = new h(this.uSU.uTo);
        hVar.Ds = R.i.dex;
        hVar.a(adVar);
        hVar.mqT = this.mqT;
        while (i < list.size() && i < 3) {
            this.mzJ.addView(hVar.getView(i, null, this.mzH));
            i++;
        }
    }

    private void a(ac acVar) {
        LinkedList linkedList = null;
        if (acVar.mrc.mrd == null || acVar.mrc.mrd.size() == 0) {
            linkedList = acVar.mqZ.mtV;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.mzH.setVisibility(8);
            return;
        }
        this.mzH.setVisibility(0);
        this.mzH.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.game.c.q qVar = (com.tencent.mm.plugin.game.c.q) it.next();
            View inflate = LayoutInflater.from(this.uSU.uTo).inflate(R.i.deA, this.mzH, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.bTP);
            TextView textView = (TextView) inflate.findViewById(R.h.bTQ);
            TextView textView2 = (TextView) inflate.findViewById(R.h.bTO);
            if (bg.mA(qVar.jNj)) {
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hJi = true;
                com.tencent.mm.ah.n.GW().a(qVar.msi, imageView, aVar.Hg());
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, qVar.jNj, 0.5f, false);
            }
            textView.setText(qVar.fDC);
            textView2.setText(qVar.mtg);
            this.mzH.addView(inflate);
        }
    }

    private void b(ac acVar) {
        if (acVar.aBb() == null || acVar.aBb().isEmpty()) {
            this.mzL.setVisibility(8);
            return;
        }
        int i;
        ac.a aVar;
        this.mzL.setVisibility(0);
        if (bg.mA(acVar.aBa())) {
            this.mzM.setVisibility(8);
        } else {
            this.mzM.setVisibility(0);
            this.mzM.setText(acVar.aBa());
        }
        this.mzN.removeAllViews();
        int i2;
        if (acVar.aBc() == 1) {
            this.mzN.setOrientation(1);
            i2 = R.i.des;
            this.mzO.setVisibility(8);
            i = i2;
        } else {
            this.mzN.setOrientation(0);
            i2 = R.i.der;
            this.mzO.setVisibility(0);
            i = i2;
        }
        Iterator it = acVar.aBb().iterator();
        while (it.hasNext()) {
            ac.b bVar = (ac.b) it.next();
            View inflate = LayoutInflater.from(this.uSU.uTo).inflate(i, this.mzN, false);
            com.tencent.mm.ah.n.GW().a(bVar.fSl, (ImageView) inflate.findViewById(R.h.bTf));
            if (acVar.aBc() == 1) {
                ((TextView) inflate.findViewById(R.h.bTg)).setText(bVar.title);
            }
            ((TextView) inflate.findViewById(R.h.bTe)).setText(bVar.desc);
            if (acVar.aBc() == 1) {
                inflate.setTag(bVar.url);
                inflate.setOnClickListener(this.mAl);
            }
            this.mzN.addView(inflate);
        }
        if (acVar.mqZ.mud != null) {
            aVar = new ac.a();
            aVar.title = acVar.mqZ.mud.muI;
            aVar.desc = acVar.mqZ.mud.desc;
            aVar.url = acVar.mqZ.mud.url;
        } else if (acVar.mqZ.mtY == null || bg.mA(acVar.mqZ.mtY.muK) || bg.mA(acVar.mqZ.mtY.muL)) {
            aVar = null;
        } else {
            aVar = new ac.a();
            aVar.title = acVar.mqZ.mtY.muK;
            aVar.url = acVar.mqZ.mtY.muL;
        }
        if (aVar != null) {
            this.mzP.setVisibility(0);
            this.mzQ.setText(aVar.title);
            if (bg.mA(aVar.desc)) {
                this.mzR.setVisibility(8);
            } else {
                this.mzR.setVisibility(0);
                this.mzR.setText(aVar.desc);
            }
            this.mzP.setTag(aVar.url);
            this.mzP.setOnClickListener(this.mAl);
            return;
        }
        this.mzP.setVisibility(8);
    }

    private void c(ac acVar) {
        if (acVar.aBh() == null || acVar.aBh().isEmpty()) {
            this.mAd.setVisibility(8);
            return;
        }
        this.mAd.setVisibility(0);
        if (bg.mA(acVar.aBg())) {
            this.mAe.setVisibility(8);
        } else {
            this.mAe.setVisibility(0);
            this.mAe.setText(acVar.aBg());
        }
        this.mAf.removeAllViews();
        this.mAf.setOnClickListener(null);
        Iterator it = acVar.aBh().iterator();
        while (it.hasNext()) {
            ba baVar = (ba) it.next();
            View inflate = LayoutInflater.from(this.uSU.uTo).inflate(R.i.det, this.mAf, false);
            TextView textView = (TextView) inflate.findViewById(R.h.bTt);
            TextView textView2 = (TextView) inflate.findViewById(R.h.bTq);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.bTr);
            ((TextView) inflate.findViewById(R.h.bTs)).setText(baVar.muQ);
            textView.setText(baVar.fDC);
            textView2.setText(baVar.mtg);
            com.tencent.mm.ah.n.GW().a(baVar.muM, imageView);
            inflate.setTag(baVar.mse);
            inflate.setOnClickListener(this.mAm);
            this.mAf.addView(inflate);
        }
        Pair pair = acVar.mqZ.mtY == null ? null : (bg.mA(acVar.mqZ.mtX.fDC) || bg.mA(acVar.mqZ.mtX.muL)) ? null : new Pair(acVar.mqZ.mtX.muK, acVar.mqZ.mtX.muL);
        if (pair != null) {
            this.mAg.setVisibility(0);
            this.mAg.setText((CharSequence) pair.first);
            this.mAg.setTag(pair.second);
            this.mAg.setOnClickListener(this.mAn);
            return;
        }
        this.mAg.setVisibility(8);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1217:
                    final com.tencent.mm.bd.a aVar = ((com.tencent.mm.plugin.game.model.ap) kVar).ldw.hsk.hsr;
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ GameDetailUI2 mAp;

                        public final void run() {
                            final ac acVar = new ac(aVar);
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass14 mAu;

                                public final void run() {
                                    GameDetailUI2.a(this.mAu.mAp, acVar);
                                    if (this.mAu.mAp.leb != null) {
                                        this.mAu.mAp.leb.dismiss();
                                    }
                                }
                            });
                        }
                    });
                    return;
                default:
                    return;
            }
        }
        if (!com.tencent.mm.plugin.game.a.a.imw.a(this, i, i2, str)) {
            Toast.makeText(this, getString(R.l.eoW, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        if (this.leb != null) {
            this.leb.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                switch (i2) {
                    case 0:
                        return;
                    case 2:
                        if (this.mpz != null && this.mzz != null) {
                            this.mzz.aAL();
                            this.mzy.a(this.mpz, this.mzz);
                            return;
                        }
                        return;
                    case 3:
                        if (this.mzz != null) {
                            this.mzz.aAK();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            case 2:
                if (i2 == -1) {
                    final String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bg.mA(stringExtra)) {
                        String str = this.mAh.msi;
                        if (bg.mA(str)) {
                            str = this.mpz.field_appIconUrl;
                        }
                        com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, this.mAh.mvN, str, this.mAh.mvO, null, getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                            final /* synthetic */ GameDetailUI2 mAp;

                            public final void a(boolean z, String str, int i) {
                                if (z) {
                                    GameDetailUI2.a(this.mAp, stringExtra, str);
                                    com.tencent.mm.ui.base.g.bl(this.mAp, this.mAp.getResources().getString(R.l.dXl));
                                    ai.a(this.mAp.uSU.uTo, 12, 1207, 2, 14, this.mAp.appId, this.mAp.mqT, null);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (i2 == -1) {
                    ai.a(this.uSU.uTo, 12, 1207, 2, 15, this.appId, this.mqT, null);
                    return;
                }
                return;
            default:
                w.e("MicroMsg.GameDetailUI2", "error request code");
                return;
        }
    }
}
