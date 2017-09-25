package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.as;
import com.tencent.mm.plugin.game.ui.GameDropdownView.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI extends MMActivity implements e {
    private View jAt;
    private Dialog leb;
    private GameBannerView mBR;
    private GameLibraryCategoriesView mBS;
    private View mBT;
    private TextView mBU;
    private View mBV;
    private GameDropdownView mBW;
    private HashMap<Integer, String> mBX;
    private int mBY = 0;
    private View mBZ;
    private Button mCa;
    private boolean mCb = false;
    private int mCc = 990;
    private int mCd = 0;
    private OnClickListener mCe = new OnClickListener(this) {
        final /* synthetic */ GameLibraryUI mCg;

        {
            this.mCg = r1;
        }

        public final void onClick(View view) {
            c.a(view, this.mCg);
            ai.a(this.mCg, 11, 1110, 999, 7, this.mCg.mqT, null);
        }
    };
    private a mCf = new a(this) {
        final /* synthetic */ GameLibraryUI mCg;

        {
            this.mCg = r1;
        }

        public final void nI(int i) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.mCg.mBX.keySet());
            if (i <= linkedList.size() - 1) {
                this.mCg.mBY = ((Integer) linkedList.get(i)).intValue();
                w.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[]{Integer.valueOf(this.mCg.mBY)});
                this.mCg.mqY = 0;
                this.mCg.aBU();
                ai.a(this.mCg, 11, 1111, this.mCg.mBY + this.mCg.mCc, 2, this.mCg.mqT, null);
            }
        }
    };
    private boolean mbo = false;
    private int mqT = 0;
    private int mqY = 0;
    private boolean mxZ = true;
    private ListView mxl;
    private k mxm;
    private boolean mxn = false;
    private boolean mxo = true;
    private j mxr = new j();
    private l.a mxs = new l.a(this) {
        final /* synthetic */ GameLibraryUI mCg;

        {
            this.mCg = r1;
        }

        public final void nE(int i) {
            int firstVisiblePosition = this.mCg.mxl.getFirstVisiblePosition() - this.mCg.mCd;
            int lastVisiblePosition = this.mCg.mxl.getLastVisiblePosition() - this.mCg.mCd;
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                this.mCg.mxm.x(this.mCg.mxl.getChildAt(i - firstVisiblePosition), i);
            }
        }
    };
    private OnScrollListener mxt = new OnScrollListener(this) {
        final /* synthetic */ GameLibraryUI mCg;

        {
            this.mCg = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.mCg.mxo && !this.mCg.mxn) {
                this.mCg.jAt.setVisibility(0);
                this.mCg.aBU();
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private OnClickListener myh = new OnClickListener(this) {
        final /* synthetic */ GameLibraryUI mCg;

        {
            this.mCg = r1;
        }

        public final void onClick(View view) {
            int i = 6;
            if (view.getTag() instanceof String) {
                c.a(view, this.mCg);
                i = 7;
            } else {
                Intent intent = new Intent(this.mCg, GameCategoryUI.class);
                intent.putExtra("extra_type", 2);
                intent.putExtra("extra_category_name", this.mCg.getString(R.l.eoO));
                intent.putExtra("game_report_from_scene", 1113);
                this.mCg.startActivity(intent);
            }
            ai.a(this.mCg, 11, 1113, 1, i, this.mCg.mqT, null);
        }
    };

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI, af afVar, boolean z) {
        Pair pair = null;
        gameLibraryUI.mxo = afVar.mrr.muC;
        LinkedList linkedList;
        if (z) {
            gameLibraryUI.mxm.O(afVar.mrt);
            w.i("MicroMsg.GameLibraryUI", "Appending list size: %d", new Object[]{Integer.valueOf(linkedList.size())});
        } else {
            LinkedList linkedList2;
            GameBannerView gameBannerView = gameLibraryUI.mBR;
            if (afVar.mrr.muA == null || afVar.mrr.muA.mvj == null) {
                w.e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                linkedList2 = new LinkedList();
                for (int i = 0; i < afVar.mrr.muA.mvj.size(); i++) {
                    GameBannerView.a aVar = new GameBannerView.a();
                    com.tencent.mm.plugin.game.c.a aVar2 = (com.tencent.mm.plugin.game.c.a) afVar.mrr.muA.mvj.get(i);
                    f a = aa.a(aVar2.msc);
                    if (a != null) {
                        d.a(a);
                        aVar.index = i;
                        aVar.mxk = a;
                        aVar.hqu = aVar2.msd;
                        aVar.moB = aVar2.mse;
                        linkedList2.add(aVar);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.Q(linkedList);
            gameLibraryUI.mBS.H(afVar.aBs());
            gameLibraryUI.mBS.mqT = gameLibraryUI.mqT;
            linkedList = new LinkedList();
            linkedList2 = afVar.mrs;
            Object obj = afVar.mrt;
            linkedList.addAll(linkedList2);
            linkedList.addAll(obj);
            gameLibraryUI.mxm.P(linkedList);
            w.i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(obj.size())});
            gameLibraryUI.mBX = afVar.aBr();
            linkedList = new LinkedList();
            linkedList.addAll(gameLibraryUI.mBX.values());
            GameDropdownView gameDropdownView = gameLibraryUI.mBW;
            LinkedList linkedList3 = new LinkedList();
            linkedList3.addAll(gameLibraryUI.mBX.keySet());
            gameDropdownView.b(linkedList, linkedList3.indexOf(Integer.valueOf(gameLibraryUI.mBY)));
            Pair pair2 = (afVar.mrr.muA == null || afVar.mrr.muA.mvk == null) ? null : new Pair(afVar.mrr.muA.mvk.mvy, afVar.mrr.muA.mvk.muL);
            if (pair2 == null || bg.mA((String) pair2.first) || bg.mA((String) pair2.second)) {
                gameLibraryUI.mBT.setTag(null);
                gameLibraryUI.mBU.setVisibility(8);
            } else {
                gameLibraryUI.mBT.setTag(pair2.second);
                gameLibraryUI.mBU.setVisibility(0);
                gameLibraryUI.mBU.setText((CharSequence) pair2.first);
            }
            SparseArray sparseArray = new SparseArray();
            if (linkedList2.size() != 0) {
                sparseArray.put(0, gameLibraryUI.mBT);
            }
            sparseArray.put(linkedList2.size(), gameLibraryUI.mBV);
            gameLibraryUI.mxm.b(sparseArray);
            if (!(afVar.mrr.muA == null || afVar.mrr.muA.mvm == null)) {
                pair = new Pair(afVar.mrr.muA.mvm.mvs, afVar.mrr.muA.mvm.mse);
            }
            if (pair != null) {
                gameLibraryUI.mCa.setText((CharSequence) pair.first);
                gameLibraryUI.mCa.setTag(pair.second);
                gameLibraryUI.mCb = true;
            }
        }
        if (!gameLibraryUI.mxo && gameLibraryUI.mCb) {
            gameLibraryUI.mBZ.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ap.zb()) {
            int i;
            this.mqT = getIntent().getIntExtra("game_report_from_scene", 0);
            ap.vd().a(1218, this);
            KC();
            final byte[] xQ = SubCoreGameCenter.aBF().xQ("pb_library");
            if (xQ == null) {
                w.i("MicroMsg.GameLibraryUI", "No cache found");
                i = 0;
            } else {
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ GameLibraryUI mCg;

                    public final void run() {
                        final af afVar = new af(xQ);
                        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 mCi;

                            public final void run() {
                                GameLibraryUI.a(this.mCi.mCg, afVar, false);
                            }
                        });
                    }
                });
                i = 1;
            }
            if (i == 0) {
                this.leb = c.cm(this);
                this.leb.show();
            }
            aBU();
            ai.a((Context) this, 11, (int) BuildConfig.VERSION_CODE, 0, 1, this.mqT, null);
            return;
        }
        w.e("MicroMsg.GameLibraryUI", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (ap.zb()) {
            this.mxm.refresh();
            if (!(this.mxZ || this.mBR == null)) {
                GameBannerView gameBannerView = this.mBR;
                if (gameBannerView.mxh != null && gameBannerView.mxh.bJq() && gameBannerView.mxg.size() > 1) {
                    gameBannerView.mxh.v(5000, 5000);
                    w.i("MicroMsg.GameBannerView", "Auto scroll restarted");
                }
            }
            if (this.mxZ) {
                this.mxZ = false;
                return;
            }
            return;
        }
        w.e("MicroMsg.GameLibraryUI", "account not ready");
    }

    protected void onPause() {
        super.onPause();
        if (this.mBR != null) {
            GameBannerView gameBannerView = this.mBR;
            if (gameBannerView.mxh != null) {
                gameBannerView.mxh.KH();
                w.i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
    }

    protected void onDestroy() {
        w.i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        ap.vd().b(1218, this);
        this.mxm.clear();
        if (this.mBR != null) {
            this.mBR.mxh.KH();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected final int getLayoutId() {
        return R.i.deI;
    }

    protected final int Ol() {
        return 1;
    }

    protected final void KC() {
        zi(R.l.deI);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameLibraryUI mCg;

            {
                this.mCg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mCg.goBack();
                return true;
            }
        });
        if (!bg.mA(SubCoreGameCenter.aBz())) {
            a(0, R.l.eYk, R.k.dsV, new OnMenuItemClickListener(this) {
                final /* synthetic */ GameLibraryUI mCg;

                {
                    this.mCg = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.mCg, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1109);
                    this.mCg.startActivity(intent);
                    return true;
                }
            });
        }
        this.mxl = (ListView) findViewById(R.h.bUr);
        this.mxl.setOnItemClickListener(this.mxr);
        this.mxr.nC(this.mqT);
        this.mxl.setOnScrollListener(this.mxt);
        this.mxm = new k(this);
        this.mxm.nC(this.mqT);
        this.mxm.a(this.mxs);
        LayoutInflater layoutInflater = (LayoutInflater) this.uSU.uTo.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.bUu, this.mxl, false);
        this.mBR = (GameBannerView) inflate.findViewById(R.h.bUu);
        this.mBR.mqT = this.mqT;
        this.mxl.addHeaderView(inflate);
        this.mCd++;
        this.mBS = (GameLibraryCategoriesView) layoutInflater.inflate(R.i.deK, this.mxl, false);
        View linearLayout = new LinearLayout(this);
        linearLayout.addView(this.mBS);
        this.mxl.addHeaderView(linearLayout);
        this.mCd++;
        this.mBT = layoutInflater.inflate(R.i.deO, this.mxl, false);
        this.mBT.setOnClickListener(this.mCe);
        this.mBU = (TextView) this.mBT.findViewById(R.h.bUt);
        this.mBV = layoutInflater.inflate(R.i.deJ, this.mxl, false);
        this.mBV.setOnClickListener(null);
        this.mBW = (GameDropdownView) this.mBV.findViewById(R.h.bUp);
        this.mBW.mAC = this.mBV;
        this.mBW.mAB = this.mCf;
        this.jAt = layoutInflater.inflate(R.i.deP, this.mxl, false);
        this.jAt.setVisibility(8);
        linearLayout = new LinearLayout(this);
        linearLayout.addView(this.jAt);
        this.mxl.addFooterView(linearLayout);
        this.mBZ = layoutInflater.inflate(R.i.deN, this.mxl, false);
        this.mBZ.setVisibility(8);
        this.mCa = (Button) this.mBZ.findViewById(R.h.bUs);
        this.mCa.setOnClickListener(this.myh);
        this.mxl.addFooterView(this.mBZ);
        this.mxl.setAdapter(this.mxm);
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

    private void aBU() {
        ap.vd().a(new as(this.mqY, com.tencent.mm.plugin.game.model.e.aAC(), this.mBY, this.mqY == 0), 0);
        this.mxn = true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1218:
                    final com.tencent.mm.bd.a aVar = ((as) kVar).ldw.hsk.hsr;
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ GameLibraryUI mCg;

                        public final void run() {
                            com.tencent.mm.bd.a aVar = aVar;
                            boolean z = this.mCg.mqY == 0 && !this.mCg.mbo;
                            final af afVar = new af(aVar, z, this.mCg.mqY);
                            this.mCg.mbo = true;
                            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass9 mCj;

                                public final void run() {
                                    GameLibraryUI.a(this.mCj.mCg, afVar, this.mCj.mCg.mqY != 0);
                                    this.mCj.mCg.mxn = false;
                                    this.mCj.mCg.jAt.setVisibility(8);
                                    this.mCj.mCg.mqY = this.mCj.mCg.mqY + 15;
                                    if (this.mCj.mCg.leb != null) {
                                        this.mCj.mCg.leb.dismiss();
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
        w.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 1) {
            w.e("MicroMsg.GameLibraryUI", "error request code");
        }
    }
}
