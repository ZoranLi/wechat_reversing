package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.game.c.ao;
import com.tencent.mm.plugin.game.c.bi;
import com.tencent.mm.plugin.game.c.bp;
import com.tencent.mm.plugin.game.c.ca;
import com.tencent.mm.plugin.game.c.k;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.y;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.ay;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.ui.l.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import java.util.HashMap;
import java.util.Map;

public class GameCenterUI2 extends MMActivity implements e {
    private Dialog leb;
    private int mqT = 0;
    private ao mri;
    private GameCenterListView mxJ;
    private f mxK;
    private GameTopBannerView mxL;
    private GameInfoView mxM;
    private GameInfoViewForeign mxN;
    private GameMessageBubbleView mxO;
    private GameCommonRecommendView mxP;
    private MyGameInfoView mxQ;
    private GameInstalledView mxR;
    private GameClassifyView mxS;
    private View mxT;
    private TextView mxU;
    private View mxV;
    private TextView mxW;
    private ImageView mxX;
    private View mxY;
    private boolean mxZ = true;
    j mxr = new j();
    private a mxs = new a(this) {
        final /* synthetic */ GameCenterUI2 myj;

        {
            this.myj = r1;
        }

        public final void nE(int i) {
            int headerViewsCount = this.myj.mxJ.getHeaderViewsCount();
            int firstVisiblePosition = this.myj.mxJ.getFirstVisiblePosition() - headerViewsCount;
            headerViewsCount = this.myj.mxJ.getLastVisiblePosition() - headerViewsCount;
            if (i >= firstVisiblePosition && i <= headerViewsCount) {
                this.myj.mxK.x(this.myj.mxJ.getChildAt(i - firstVisiblePosition), i);
            }
        }
    };
    private boolean mya;
    private boolean myb = false;
    private String myc = "";
    private q myd;
    private q mye;
    private q myf;
    private boolean myg = false;
    private OnClickListener myh = new OnClickListener(this) {
        final /* synthetic */ GameCenterUI2 myj;

        {
            this.myj = r1;
        }

        public final void onClick(View view) {
            int i = 7;
            com.tencent.mm.plugin.game.model.a.a aAv = com.tencent.mm.plugin.game.model.a.aAv();
            if (aAv.fRW == 2) {
                c.n(this.myj.uSU.uTo, aAv.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || bg.mA((String) tag)) {
                    Intent intent = new Intent(this.myj, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", MMBitmapFactory.ERROR_IO_FAILED);
                    this.myj.startActivity(intent);
                    i = 6;
                } else {
                    c.n(this.myj, (String) tag, "game_center_library");
                }
            }
            ai.a(this.myj.uSU.uTo, 10, (int) MMBitmapFactory.ERROR_IO_FAILED, 1, i, this.myj.mqT, null);
        }
    };
    private OnClickListener myi = new OnClickListener(this) {
        final /* synthetic */ GameCenterUI2 myj;

        {
            this.myj = r1;
        }

        public final void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof String) && !bg.mA((String) tag)) {
                c.n(this.myj.uSU.uTo, (String) view.getTag(), "game_center_feedback");
                ai.a(this.myj.uSU.uTo, 10, 1010, 1, 7, this.myj.mqT, null);
            }
        }
    };

    static /* synthetic */ void a(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.myb) {
            SubCoreGameCenter.aBC();
            gameCenterUI2.myd = t.aAO();
            if (gameCenterUI2.myd != null) {
                gameCenterUI2.myd.aAN();
            }
            SubCoreGameCenter.aBC();
            gameCenterUI2.mye = t.aAQ();
            if (gameCenterUI2.mye != null) {
                gameCenterUI2.mye.aAN();
            }
        }
        SubCoreGameCenter.aBC();
        gameCenterUI2.myf = t.aAS();
        if (gameCenterUI2.myf != null) {
            gameCenterUI2.myf.aAN();
        }
    }

    static /* synthetic */ void a(GameCenterUI2 gameCenterUI2, ae aeVar, int i) {
        if (gameCenterUI2.isFinishing()) {
            w.w("MicroMsg.GameCenterUI2", "GameCenterUI2 hasFinished");
        } else if (aeVar == null) {
            w.e("MicroMsg.GameCenterUI2", "Null data");
        } else {
            k kVar = aeVar.mri != null ? aeVar.mri.mur : null;
            if (kVar != null) {
                if (gameCenterUI2.mxY instanceof ViewStub) {
                    gameCenterUI2.mxY = ((ViewStub) gameCenterUI2.mxY).inflate();
                }
                gameCenterUI2.mxY.setVisibility(0);
                TextView textView = (TextView) gameCenterUI2.mxY.findViewById(R.h.cgO);
                TextView textView2 = (TextView) gameCenterUI2.mxY.findViewById(R.h.cBq);
                TextView textView3 = (TextView) gameCenterUI2.mxY.findViewById(R.h.cBi);
                if (bg.mA(kVar.msP)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(kVar.msP);
                    textView.setVisibility(0);
                }
                if (bg.mA(kVar.msQ)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(kVar.msQ);
                    textView2.setVisibility(0);
                }
                if (bg.mA(kVar.msR)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(kVar.msR);
                    textView3.setVisibility(0);
                }
                gameCenterUI2.a(aeVar);
                gameCenterUI2.mxJ.setVisibility(8);
            } else {
                n nVar;
                if (!(gameCenterUI2.mxY instanceof ViewStub)) {
                    gameCenterUI2.mxY.setVisibility(8);
                    gameCenterUI2.mxJ.setVisibility(0);
                }
                gameCenterUI2.a(aeVar);
                gameCenterUI2.mxL.mqT = gameCenterUI2.mqT;
                GameTopBannerView gameTopBannerView = gameCenterUI2.mxL;
                bi aBl = aeVar.aBl();
                boolean z = gameCenterUI2.myg;
                if (aBl == null || aBl.mvc == null || bg.mA(aBl.mvc.mte)) {
                    gameTopBannerView.setVisibility(8);
                } else {
                    gameTopBannerView.mFM = aBl.mvb != null ? ai.xR(aBl.mvb.msG) : null;
                    if (!gameTopBannerView.mFK.equals(aBl.mvc.mte)) {
                        gameTopBannerView.mFK = aBl.mvc.mte;
                        com.tencent.mm.plugin.game.d.e.aCi().f(gameTopBannerView.mxH, aBl.mvc.mte);
                        gameTopBannerView.mFI = gameTopBannerView.b(gameTopBannerView.mxH, gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.aXq), gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.aXp));
                        if (gameTopBannerView.mFI > 0) {
                            if (i == 2) {
                                ai.a(gameTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameTopBannerView.mqT, 0, null, null, gameTopBannerView.mFM);
                            }
                            if (gameTopBannerView.mFI <= 0 || aBl.mvb == null || bg.mA(aBl.mvb.msE)) {
                                gameTopBannerView.mxG.setVisibility(8);
                            } else {
                                com.tencent.mm.plugin.game.d.e.aCi().f(gameTopBannerView.mxG, aBl.mvb.msE);
                                gameTopBannerView.mFJ = gameTopBannerView.b(gameTopBannerView.mxG, gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.aXn), gameTopBannerView.mContext.getResources().getDimensionPixelSize(R.f.aXp));
                                if (gameTopBannerView.mFJ > 0) {
                                    gameTopBannerView.mxG.setVisibility(0);
                                    gameTopBannerView.mxG.setTag(aBl.mvb.msF);
                                    gameTopBannerView.mxG.setOnClickListener(gameTopBannerView);
                                } else {
                                    gameTopBannerView.mxG.setVisibility(8);
                                }
                            }
                            if (gameTopBannerView.mxG.getVisibility() == 0) {
                                if (aBl.mvb.mvT == gameTopBannerView.mContext.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0) || z) {
                                    ((ViewGroup) gameTopBannerView.getParent()).setPadding(0, gameTopBannerView.mFI - gameTopBannerView.mFJ, 0, 0);
                                    gameTopBannerView.mxG.setClickable(false);
                                } else {
                                    gameTopBannerView.mxH.setAlpha(0);
                                    gameTopBannerView.mxG.setClickable(true);
                                    gameTopBannerView.mContext.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", aBl.mvb.mvT).apply();
                                }
                                GameCenterListView.eI(true);
                                GameCenterListView.nG(gameTopBannerView.mFI - gameTopBannerView.mFJ);
                            } else {
                                GameCenterListView.eI(false);
                            }
                            gameTopBannerView.setVisibility(0);
                        } else {
                            gameTopBannerView.setVisibility(8);
                        }
                    } else if (i == 2) {
                        ai.a(gameTopBannerView.mContext, 10, 1017, 1, 1, 0, null, gameTopBannerView.mqT, 0, null, null, gameTopBannerView.mFM);
                    }
                }
                if (aeVar.mri != null ? aeVar.mri.muv : false) {
                    gameCenterUI2.mxN.mqT = gameCenterUI2.mqT;
                    gameCenterUI2.mxN.setVisibility(0);
                    gameCenterUI2.mxM.setVisibility(8);
                } else {
                    gameCenterUI2.mxN.setVisibility(8);
                    gameCenterUI2.mxM.mqT = gameCenterUI2.mqT;
                    gameCenterUI2.mxM.mBp = bg.ap(gameCenterUI2.myc, "");
                    GameInfoView gameInfoView = gameCenterUI2.mxM;
                    y yVar = aeVar.mri != null ? aeVar.mri.mui : null;
                    if (yVar == null) {
                        w.e("MicroMsg.GameInfoView", "Null data");
                        gameInfoView.setVisibility(8);
                    } else {
                        gameInfoView.setVisibility(0);
                        ((ViewGroup) gameInfoView.getParent()).setPadding(0, 0, 0, 0);
                        if (yVar.mtv == null) {
                            w.e("MicroMsg.GameInfoView", "MyProfile is null, use default data");
                            CharSequence xL = m.xL();
                            CharSequence xM = m.xM();
                            com.tencent.mm.plugin.game.d.e.aCi().h(gameInfoView.mBi, xL);
                            if (bg.mA(xM)) {
                                gameInfoView.mBj.setText(xL);
                            } else {
                                gameInfoView.mBj.setText(xM);
                            }
                            gameInfoView.mBh.setEnabled(false);
                        } else {
                            if (bg.mA(yVar.mtv.muU)) {
                                com.tencent.mm.plugin.game.d.e.aCi().h(gameInfoView.mBi, m.xL());
                            } else {
                                com.tencent.mm.plugin.game.d.e.a.a aVar = new com.tencent.mm.plugin.game.d.e.a.a();
                                aVar.hJi = true;
                                com.tencent.mm.plugin.game.d.e.aCi().a(gameInfoView.mBi, yVar.mtv.muU, aVar.aCj());
                            }
                            gameInfoView.mBj.setText(yVar.mtv.fDC);
                            Map hashMap = new HashMap();
                            if (bg.mA(yVar.mtv.muV)) {
                                gameInfoView.mBk.setVisibility(8);
                                hashMap.put("badge_icon", "0");
                            } else {
                                com.tencent.mm.plugin.game.d.e.aCi().f(gameInfoView.mBk, yVar.mtv.muV);
                                gameInfoView.mBk.setVisibility(0);
                                hashMap.put("badge_icon", "1");
                            }
                            gameInfoView.mBu = ai.u(hashMap);
                            gameInfoView.mBh.setEnabled(true);
                            gameInfoView.mBh.setTag(yVar.mtv.msF);
                            gameInfoView.mBh.setVisibility(0);
                            if (i == 2) {
                                ai.a(gameInfoView.mContext, (int) MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, gameInfoView.mBt, null, gameInfoView.mqT, gameInfoView.mBu);
                            }
                        }
                        if (yVar.mtw == null || bg.mA(yVar.mtw.muU)) {
                            gameInfoView.mBa.setVisibility(8);
                        } else if (!gameInfoView.mBn.equals(yVar.mtw.muU)) {
                            gameInfoView.mBn = yVar.mtw.muU;
                            gameInfoView.mBa.setVisibility(0);
                            com.tencent.mm.plugin.game.d.e.aCi().f(gameInfoView.mBb, yVar.mtw.muU);
                            gameInfoView.mBa.setTag(yVar.mtw.msF);
                            gameInfoView.aBS();
                        }
                        if (yVar.mtx == null || bg.mA(yVar.mtx.muU)) {
                            gameInfoView.mBd.setVisibility(8);
                        } else if (!gameInfoView.mBm.equals(yVar.mtx.muU)) {
                            gameInfoView.mBm = yVar.mtx.muU;
                            gameInfoView.mBd.setVisibility(0);
                            com.tencent.mm.plugin.game.d.e.aCi().f(gameInfoView.mBe, yVar.mtx.muU);
                            gameInfoView.mBd.setTag(yVar.mtx.msF);
                            SubCoreGameCenter.aBC();
                            if (t.aAU() != null) {
                                gameInfoView.mBf.setVisibility(0);
                            } else {
                                gameInfoView.mBf.setVisibility(8);
                            }
                        }
                        if (yVar.mty == null || bg.mA(yVar.mty.muU)) {
                            gameInfoView.mBg.setVisibility(8);
                            gameInfoView.mBo.setVisibility(8);
                        } else if (!gameInfoView.mBl.equals(yVar.mty.muU)) {
                            gameInfoView.mBl = yVar.mty.muU;
                            gameInfoView.mBg.setVisibility(0);
                            com.tencent.mm.plugin.game.d.e.aCi().f(gameInfoView.mBg, yVar.mty.muU);
                            gameInfoView.mBg.setTag(yVar.mty.msF);
                            gameInfoView.mBo.setVisibility(0);
                        }
                    }
                }
                gameCenterUI2.mxQ.a(aeVar.mrm, gameCenterUI2.mqT, i);
                GameCommonRecommendView gameCommonRecommendView = gameCenterUI2.mxP;
                ca caVar = aeVar.mri != null ? aeVar.mri.mul : null;
                int i2 = gameCenterUI2.mqT;
                if (caVar == null || caVar.mvJ == null || caVar.mvK == null || caVar.mvL == null) {
                    gameCommonRecommendView.setVisibility(8);
                } else {
                    gameCommonRecommendView.setVisibility(0);
                    gameCommonRecommendView.mqT = i2;
                    gameCommonRecommendView.myq = i;
                    gameCommonRecommendView.a(caVar);
                }
                gameCenterUI2.mxR.mqT = gameCenterUI2.mqT;
                GameInstalledView.v(aeVar.mrl);
                GameInstalledView gameInstalledView = gameCenterUI2.mxR;
                GameInstalledView.a aVar2 = new GameInstalledView.a();
                if (!(aeVar.mri.muo == null || aeVar.mri.muo.mvf == null)) {
                    aVar2.iconUrl = aeVar.mri.muo.mvf.msi;
                    aVar2.title = aeVar.mri.muo.mvf.fDC;
                    aVar2.iMP = aeVar.mri.muo.mvf.mse;
                }
                gameInstalledView.mBH = aVar2;
                gameCenterUI2.mxR.mBI = aeVar.aBn();
                gameCenterUI2.mxR.dK(true);
                gameCenterUI2.mxS.a(aeVar.mri != null ? aeVar.mri.mum : null, i, gameCenterUI2.mqT);
                if (gameCenterUI2.myb) {
                    gameCenterUI2.mxO.aBX();
                }
                bp bpVar = aeVar.mri != null ? aeVar.mri.muq : null;
                if (bpVar == null || bg.mA(bpVar.msk) || bg.mA(bpVar.msF)) {
                    gameCenterUI2.mxT.setVisibility(8);
                } else {
                    gameCenterUI2.mxT.setVisibility(0);
                    gameCenterUI2.mxU.setText(bpVar.msk);
                    gameCenterUI2.mxT.setTag(bpVar.msF);
                    gameCenterUI2.mxT.setOnClickListener(gameCenterUI2.myh);
                }
                if (!(aeVar.aBl() == null || aeVar.aBl().mvd == null || bg.mA(aeVar.aBl().mvd.mte))) {
                    com.tencent.mm.plugin.game.d.e.aCi().f(gameCenterUI2.mxX, aeVar.aBl().mvd.mte);
                    LayoutParams layoutParams = gameCenterUI2.mxX.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = (int) (((float) c.getScreenWidth(gameCenterUI2)) * (((float) gameCenterUI2.getResources().getDimensionPixelSize(R.f.aXo)) / ((float) gameCenterUI2.getResources().getDimensionPixelSize(R.f.aXp))));
                        gameCenterUI2.mxX.setLayoutParams(layoutParams);
                        gameCenterUI2.mxX.setVisibility(0);
                        if (gameCenterUI2.mxX.getVisibility() != 8) {
                            nVar = aeVar.mri == null ? aeVar.mri.mus : null;
                            if (nVar != null || bg.mA(nVar.fDC) || bg.mA(nVar.mse)) {
                                gameCenterUI2.mxV.setVisibility(8);
                            } else {
                                gameCenterUI2.mxV.setVisibility(0);
                                gameCenterUI2.mxW.setText(nVar.fDC);
                                gameCenterUI2.mxW.setTag(nVar.mse);
                            }
                        } else {
                            gameCenterUI2.mxV.setVisibility(8);
                        }
                        gameCenterUI2.mxK.nF(i);
                        gameCenterUI2.mxK.P(aeVar.mrk);
                    } else {
                        w.i("MicroMsg.GameCenterUI2", "mGameFooterImg, params is null");
                    }
                }
                gameCenterUI2.mxX.setVisibility(8);
                if (gameCenterUI2.mxX.getVisibility() != 8) {
                    gameCenterUI2.mxV.setVisibility(8);
                } else {
                    if (aeVar.mri == null) {
                    }
                    if (nVar != null) {
                    }
                    gameCenterUI2.mxV.setVisibility(8);
                }
                gameCenterUI2.mxK.nF(i);
                gameCenterUI2.mxK.P(aeVar.mrk);
            }
            if (i == 2) {
                c.vL().D(new Runnable(gameCenterUI2) {
                    final /* synthetic */ GameCenterUI2 myj;

                    {
                        this.myj = r1;
                    }

                    public final void run() {
                        SubCoreGameCenter.aBF().a("pb_index_2", this.myj.mri);
                    }
                });
            }
        }
    }

    static /* synthetic */ void c(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.myd == null || gameCenterUI2.myd.field_isHidden) {
            ai.a((Context) gameCenterUI2, 9, 901, 1, 6, 0, ai.co("resource", "0"));
            return;
        }
        int i = gameCenterUI2.myd.field_msgType;
        if (gameCenterUI2.myd.field_msgType == 100) {
            i = gameCenterUI2.myd.mqy;
        }
        ai.a(gameCenterUI2, 9, 901, 1, 6, 0, gameCenterUI2.myd.field_appId, 0, i, gameCenterUI2.myd.field_gameMsgId, gameCenterUI2.myd.mqz, ai.co("resource", String.valueOf(gameCenterUI2.myd.mpR.mqG)));
    }

    static /* synthetic */ void d(GameCenterUI2 gameCenterUI2) {
        if (gameCenterUI2.mye != null && !gameCenterUI2.mye.field_isHidden && !bg.mA(gameCenterUI2.mye.mqg.url)) {
            gameCenterUI2.myg = true;
            q qVar = gameCenterUI2.mye;
            c.a(gameCenterUI2.getBaseContext(), qVar, "game_center_h5_floatlayer");
            int i = qVar.field_msgType;
            if (qVar.field_msgType == 100) {
                i = qVar.mqy;
            }
            ai.a(gameCenterUI2, 10, MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, 1, 1, 0, qVar.field_appId, 0, i, qVar.field_gameMsgId, qVar.mqz, null);
            gameCenterUI2.mye.field_isRead = true;
            SubCoreGameCenter.aBB().c(gameCenterUI2.mye, new String[0]);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        if (ap.zb()) {
            this.mqT = getIntent().getIntExtra("game_report_from_scene", 0);
            this.myb = getIntent().getBooleanExtra("from_find_more_friend", false);
            c.vL().D(new Runnable(this) {
                final /* synthetic */ GameCenterUI2 myj;

                {
                    this.myj = r1;
                }

                public final void run() {
                    GameCenterUI2.a(this.myj);
                    if (this.myj.myb) {
                        GameCenterUI2.c(this.myj);
                        GameCenterUI2.d(this.myj);
                        SubCoreGameCenter.aBC();
                        t.aAP();
                        SubCoreGameCenter.aBC();
                        t.aAR();
                    }
                }
            });
            ap.vd().a(1238, this);
            KC();
            c.vL().D(new Runnable(this) {
                final /* synthetic */ GameCenterUI2 myj;

                {
                    this.myj = r1;
                }

                public final void run() {
                    byte[] xQ = SubCoreGameCenter.aBF().xQ("pb_index_2");
                    if (xQ == null) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 myn;

                            {
                                this.myn = r1;
                            }

                            public final void run() {
                                if (!this.myn.myj.isFinishing()) {
                                    this.myn.myj.leb = c.cm(this.myn.myj);
                                    this.myn.myj.leb.show();
                                }
                            }
                        });
                    } else {
                        final ae aeVar = new ae(xQ);
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 myn;

                            public final void run() {
                                try {
                                    GameCenterUI2.a(this.myn.myj, aeVar, 1);
                                } catch (Exception e) {
                                    w.e("MicroMsg.GameCenterUI2", "GameCenter crash, %s", new Object[]{e.getMessage()});
                                    this.myn.myj.finish();
                                }
                            }
                        });
                    }
                    SubCoreGameCenter.aBH().init(this.myj);
                    c.T(com.tencent.mm.plugin.game.model.e.aAC());
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 myn;

                        {
                            this.myn = r1;
                        }

                        public final void run() {
                            this.myn.myj.mxR.dK(true);
                        }
                    });
                    ap.vd().a(new ar(v.bIN(), com.tencent.mm.plugin.game.model.e.aAC(), this.myj.myd, this.myj.mye, this.myj.myf, this.myj.myb), 0);
                    Context context = this.myj.uSU.uTo;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
                    String string = sharedPreferences.getString("download_app_id_time_map", "");
                    if (!bg.mA(string)) {
                        String[] split = string.split(",");
                        String str = new String();
                        string = str;
                        for (String str2 : split) {
                            String[] split2 = str2.split("-");
                            String str3 = split2[0];
                            if (!(bg.mA(str3) || g.n(context, str3))) {
                                if (currentTimeMillis - bg.getLong(split2[1], 0) < 86400) {
                                    string = string + str2 + ",";
                                } else {
                                    com.tencent.mm.plugin.downloader.model.e.akM().aT(com.tencent.mm.plugin.downloader.model.e.akM().tI(str3).id);
                                }
                            }
                        }
                        if (!bg.mA(string)) {
                            if (string.charAt(string.length() - 1) == ',') {
                                string = string.substring(0, string.length() - 1);
                            }
                            sharedPreferences.edit().putString("download_app_id_time_map", string.toString()).apply();
                        }
                    }
                    ab.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", v.bIN()).commit();
                    a.mGh.aCf();
                }
            });
            ai.a(this, 10, 1000, 0, 1, 0, null, this.mqT, 0, null, null, null);
            w.i("MicroMsg.GameCenterUI2", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            w.i("MicroMsg.GameCenterUI2", "fromScene = %d", new Object[]{Integer.valueOf(this.mqT)});
            return;
        }
        w.e("MicroMsg.GameCenterUI2", "account not ready");
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (ap.zb()) {
            if (!this.mxZ) {
                if (this.mxM.getVisibility() == 0) {
                    this.mxM.aBS();
                } else if (this.mxN.getVisibility() == 0) {
                    this.mxN.aBS();
                }
                SubCoreGameCenter.aBH().init(this);
                this.mxR.dK(false);
                this.mxK.refresh();
                if (this.mxQ != null) {
                    MyGameInfoView myGameInfoView = this.mxQ;
                    String[] strArr = new String[MyGameInfoView.mFP.keySet().size()];
                    MyGameInfoView.mFP.keySet().toArray(strArr);
                    for (Object obj : strArr) {
                        View view = (View) MyGameInfoView.mFP.get(obj);
                        if (view != null) {
                            a aVar = (a) view.getTag();
                            com.tencent.mm.plugin.game.model.m mVar = (com.tencent.mm.plugin.game.model.m) myGameInfoView.mFO.get(obj);
                            if (!(mVar == null || mVar.mpz == null)) {
                                myGameInfoView.mzy.a(aVar.mCA, aVar.mCz, mVar.mpz, (com.tencent.mm.plugin.game.model.m) myGameInfoView.mFO.get(mVar.mpz.field_appId));
                            }
                        }
                    }
                }
                GameMessageBubbleView gameMessageBubbleView = this.mxO;
                gameMessageBubbleView.mDf.setOnClickListener(null);
                gameMessageBubbleView.setVisibility(8);
                if (this.myb) {
                    this.mxO.aBX();
                }
                if (a.mGh.mGg) {
                    a.mGh.mGg = false;
                    c.vL().D(new Runnable(this) {
                        final /* synthetic */ GameCenterUI2 myj;

                        {
                            this.myj = r1;
                        }

                        public final void run() {
                            ap.vd().a(new ar(v.bIN(), com.tencent.mm.plugin.game.model.e.aAC(), this.myj.myd, this.myj.mye, this.myj.myf, this.myj.myb), 0);
                        }
                    });
                }
            }
            this.mxZ = false;
            return;
        }
        w.e("MicroMsg.GameCenterUI2", "account not ready");
    }

    private void goBack() {
        String stringExtra = getIntent().getStringExtra("jump_find_more_friends");
        if (!bg.mA(stringExtra) && stringExtra.equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            d.a(this, ".ui.LauncherUI", intent);
        }
        finish();
    }

    protected void onDestroy() {
        w.i("MicroMsg.GameCenterUI2", "onDestroy");
        super.onDestroy();
        if (ap.zb()) {
            if (this.mxK != null) {
                this.mxK.clear();
            }
            if (this.mxR != null) {
                GameInstalledView gameInstalledView = this.mxR;
                if (gameInstalledView.mrk != null) {
                    gameInstalledView.mrk.clear();
                }
                if (gameInstalledView.mzx != null) {
                    l.b(gameInstalledView.mzx);
                }
            }
            if (this.mxQ != null) {
                MyGameInfoView myGameInfoView = this.mxQ;
                if (myGameInfoView.mzx != null) {
                    l.b(myGameInfoView.mzx);
                }
                if (MyGameInfoView.mFP != null) {
                    MyGameInfoView.mFP.clear();
                }
            }
            a.mGh.clearCache();
            ap.vd().b(1238, this);
            b aBH = SubCoreGameCenter.aBH();
            w.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
            if (aBH.mox != null) {
                aBH.mox.clear();
            }
            if (aBH.mow != null) {
                aBH.mow.clear();
            }
            ay.aBy();
            return;
        }
        w.e("MicroMsg.GameCenterUI2", "account not ready");
    }

    protected final int getLayoutId() {
        return R.i.deg;
    }

    protected final int Ol() {
        return 1;
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameCenterUI2 myj;

            {
                this.myj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.myj.goBack();
                return true;
            }
        });
        zi(R.l.epG);
        this.mxJ = (GameCenterListView) findViewById(R.h.bSK);
        this.mxJ.setOnItemClickListener(this.mxr);
        this.mxr.nC(this.mqT);
        this.mxK = new f(this);
        this.mxK.nC(this.mqT);
        this.mxK.a(this.mxs);
        LayoutInflater layoutInflater = (LayoutInflater) this.uSU.uTo.getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.dfs, this.mxJ, false);
        this.mxL = (GameTopBannerView) inflate.findViewById(R.h.cJq);
        this.mxJ.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.dej, this.mxJ, false);
        this.mxN = (GameInfoViewForeign) inflate.findViewById(R.h.bSI);
        this.mxJ.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.dei, this.mxJ, false);
        this.mxM = (GameInfoView) inflate.findViewById(R.h.bSH);
        this.mxJ.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.dee, this.mxJ, false);
        this.mxO = (GameMessageBubbleView) inflate.findViewById(R.h.bUE);
        this.mxJ.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.dem, this.mxJ, false);
        this.mxQ = (MyGameInfoView) inflate.findViewById(R.h.cmg);
        this.mxJ.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.bSG, this.mxJ, false);
        this.mxP = (GameCommonRecommendView) inflate.findViewById(R.h.bSG);
        this.mxJ.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.dek, this.mxJ, false);
        this.mxR = (GameInstalledView) inflate.findViewById(R.h.bUf);
        this.mxJ.addHeaderView(inflate);
        inflate = layoutInflater.inflate(R.i.den, this.mxJ, false);
        this.mxS = (GameClassifyView) inflate.findViewById(R.h.bSN);
        this.mxJ.addHeaderView(inflate);
        View inflate2 = layoutInflater.inflate(R.i.deh, this.mxJ, false);
        this.mxJ.addFooterView(inflate2);
        this.mxT = inflate2.findViewById(R.h.bTZ);
        this.mxT.setOnClickListener(this.myh);
        this.mxU = (TextView) inflate2.findViewById(R.h.bUa);
        inflate2 = layoutInflater.inflate(R.i.def, null);
        this.mxJ.addFooterView(inflate2);
        this.mxV = inflate2.findViewById(R.h.bPs);
        this.mxW = (TextView) inflate2.findViewById(R.h.bPt);
        this.mxW.setOnClickListener(this.myi);
        View inflate3 = layoutInflater.inflate(R.i.deG, this.mxJ, false);
        this.mxJ.addFooterView(inflate3);
        this.mxX = (ImageView) inflate3.findViewById(R.h.bUd);
        this.mxJ.setAdapter(this.mxK);
        this.mxY = findViewById(R.h.bVt);
    }

    private void a(ae aeVar) {
        if (aeVar == null || aeVar.aBk() == null) {
            this.myc = "";
        } else {
            this.myc = aeVar.aBk().msF;
        }
        if (bg.mA(this.myc)) {
            if (this.mya) {
                zn(0);
                this.mya = false;
            }
        } else if (!this.mya) {
            a(0, R.k.dsW, new OnMenuItemClickListener(this) {
                final /* synthetic */ GameCenterUI2 myj;

                {
                    this.myj = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    c.aa(this.myj.uSU.uTo, this.myj.myc);
                    ai.a(this.myj, 10, (int) MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, AuthorizedGameListUI.mwm, 7, this.myj.mqT, null);
                    return true;
                }
            });
            this.mya = true;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.GameCenterUI2", "errType: %d errCode: %d, scene: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.hashCode())});
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 1238:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bd.a aVar = ((ar) kVar).ldw.hsk.hsr;
                    c.vL().D(new Runnable(this) {
                        final /* synthetic */ GameCenterUI2 myj;

                        public final void run() {
                            if (aVar == null) {
                                this.myj.mri = new ao();
                            } else {
                                this.myj.mri = (ao) aVar;
                            }
                            final ae aeVar = new ae(aVar);
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 mym;

                                public final void run() {
                                    try {
                                        GameCenterUI2.a(this.mym.myj, aeVar, 2);
                                    } catch (Exception e) {
                                        w.e("MicroMsg.GameCenterUI2", "GameCenter crash, %s", new Object[]{e.getMessage()});
                                        this.mym.myj.finish();
                                    }
                                    if (this.mym.myj.leb != null) {
                                        this.mym.myj.leb.dismiss();
                                    }
                                    w.i("MicroMsg.GameCenterUI2", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
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

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.GameCenterUI2", "requestCode = %d, resultCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
