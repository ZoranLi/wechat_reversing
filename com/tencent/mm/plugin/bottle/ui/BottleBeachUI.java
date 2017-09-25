package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ao.g;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.io.Serializable;

@a(1)
public class BottleBeachUI extends MMActivity implements OnClickListener, l.a.a, b, e {
    private p irJ = null;
    private View jVD;
    private FrameLayout jVE;
    private ThrowBottleUI jVF;
    private PickBottleUI jVG;
    private OpenBottleUI jVH;
    private BallonImageView jVI;
    private LightHouseImageView jVJ;
    private ImageView jVK;
    private MoonImageView jVL;
    private ImageView jVM;
    private int jVN = 0;
    boolean jVO = true;
    private ImageView jVP;
    private ImageView jVQ;
    private ImageView jVR;
    private TextView jVS;
    private d jVT;
    private b jVU;
    private boolean jVV = true;

    protected final int getLayoutId() {
        return R.i.cVR;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!m.yc()) {
            ap.yY();
            c.wQ().b(new g(11, 1));
        }
        KC();
        ap.vd().a(com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX, this);
        ap.vd().a(new d(), 0);
    }

    protected void onResume() {
        super.onResume();
        adA();
        this.uSU.uTa.postDelayed(new Runnable(this) {
            final /* synthetic */ BottleBeachUI jVW;

            {
                this.jVW = r1;
            }

            public final void run() {
                if (this.jVW.jVI != null && this.jVW.jVN == 0 && this.jVW.jVV) {
                    this.jVW.adz();
                }
            }
        }, 1000);
        if (this.jVN == 3 && this.jVH != null) {
            OpenBottleUI openBottleUI = this.jVH;
            if (openBottleUI.fCZ != null && openBottleUI.fCZ.bLZ()) {
                OpenBottleUI.jXn.a(openBottleUI);
            }
            openBottleUI.cV(true);
            openBottleUI.jXw = bg.NA();
        }
        ap.yY();
        c.wW().a(this);
        w.DP().a(this);
        ap.vd().a(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
    }

    protected void onPause() {
        super.onPause();
        if (this.jVN == 1 && this.jVF != null) {
            this.jVF.adW();
        }
        if (this.jVN == 3 && this.jVH != null) {
            this.jVH.onPause();
        }
        if (ap.zb()) {
            ap.yY();
            c.wW().b(this);
            ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
        }
        w.DP().b(this);
    }

    public void onDestroy() {
        if (this.jVF != null) {
            ThrowBottleUI throwBottleUI = this.jVF;
            throwBottleUI.jYz = null;
            throwBottleUI.jYC = null;
            if (throwBottleUI.jYD != null) {
                throwBottleUI.jYD.cancel();
                throwBottleUI.jYD = null;
            }
            if (throwBottleUI.jYE != null) {
                throwBottleUI.jYE.release();
            }
            throwBottleUI.jYE = null;
            throwBottleUI.jYF = null;
            throwBottleUI.jXf = null;
            if (throwBottleUI.jYA != null) {
                throwBottleUI.jYA.release();
            }
            this.jVF = null;
        }
        if (this.jVG != null) {
            PickBottleUI pickBottleUI = this.jVG;
            pickBottleUI.handler.removeCallbacks(pickBottleUI.jXE);
            pickBottleUI.handler.removeCallbacks(pickBottleUI.jXF);
            pickBottleUI.jXf = null;
            pickBottleUI.jXA = null;
            pickBottleUI.jXB = null;
            this.jVG = null;
        }
        if (this.jVT != null) {
            this.jVT.cancel();
            this.jVT.context = null;
            this.jVT = null;
        }
        if (this.jVH != null) {
            b bVar = this.jVH;
            if (bVar.fCZ != null && bVar.fCZ.bLZ()) {
                bVar.adJ();
            }
            bVar.jXf = null;
            if (bVar.jXo != null) {
                bVar.jXo.release();
                bVar.jXo = null;
            }
            OpenBottleUI.jXn = null;
            ap.yY();
            c.wR().b(bVar);
            this.jVH = null;
        }
        this.jVI = null;
        this.jVJ = null;
        this.jVL = null;
        if (this.jVU != null) {
            this.jVU.dismiss();
            this.jVU = null;
        }
        ap.vd().b(com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX, this);
        super.onDestroy();
    }

    protected final int Ol() {
        return 1;
    }

    protected final void KC() {
        int i = 8;
        zi(R.l.dPj);
        a(0, R.l.dBQ, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleBeachUI jVW;

            {
                this.jVW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.jVW, BottlePersonalInfoUI.class);
                intent.putExtra("is_allow_set", false);
                this.jVW.startActivity(intent);
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleBeachUI jVW;

            {
                this.jVW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jVW.aHf();
                this.jVW.finish();
                return false;
            }
        });
        boolean bJR = bg.bJR();
        if (this.jVI == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.h.btT);
            ((FrameLayout) frameLayout.getParent()).removeView(frameLayout);
            ((FrameLayout) getWindow().getDecorView()).addView(frameLayout, 0);
            frameLayout.setBackgroundResource(bJR ? R.g.bcE : R.g.bcM);
            frameLayout.setVisibility(0);
            this.jVI = (BallonImageView) findViewById(R.h.btS);
            this.jVJ = (LightHouseImageView) findViewById(R.h.btZ);
            this.jVK = (ImageView) findViewById(R.h.buy);
            this.jVL = (MoonImageView) findViewById(R.h.bub);
        }
        this.jVI.setVisibility(bJR ? 0 : 8);
        this.jVJ.setVisibility(bJR ? 8 : 0);
        this.jVL.jVK = this.jVK;
        MoonImageView moonImageView = this.jVL;
        if (!bJR) {
            i = 0;
        }
        moonImageView.setVisibility(i);
        this.jVD = findViewById(R.h.btU);
        this.jVD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BottleBeachUI jVW;

            {
                this.jVW = r1;
            }

            public final void onClick(View view) {
                this.jVW.adz();
            }
        });
        this.jVP = (ImageView) findViewById(R.h.bup);
        this.jVQ = (ImageView) findViewById(R.h.buo);
        this.jVR = (ImageView) findViewById(R.h.bun);
        this.jVP.setOnClickListener(this);
        this.jVQ.setOnClickListener(this);
        this.jVR.setOnClickListener(this);
        this.jVM = (ImageView) findViewById(R.h.btV);
        this.jVM.setOnClickListener(this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.w.d("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (i2 == -2002 && this.jVN == 0) {
            jT(R.l.dPi);
            return;
        }
        switch (kVar.getType()) {
            case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                com.tencent.mm.sdk.platformtools.w.i("MM.UI.BottleUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (this.irJ != null) {
                    this.irJ.dismiss();
                    this.irJ = null;
                }
                if (!com.tencent.mm.plugin.bottle.a.imw.a(this.uSU.uTo, i, i2, str)) {
                    if (i == 4 && i2 == -4) {
                        com.tencent.mm.ui.base.g.h(this.uSU.uTo, R.l.dCI, R.l.dIO);
                        return;
                    } else if (i == 0 && i2 == 0) {
                        awr Jx = ((aa) kVar).Jx();
                        String a = n.a(Jx.ttp);
                        com.tencent.mm.x.n.Bl().g(a, n.a(Jx.tfh));
                        Intent intent = new Intent();
                        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Jx, 25);
                        if (bg.mz(a).length() > 0) {
                            if ((Jx.tMP & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.oUh.A(10298, a + ",25");
                            }
                            com.tencent.mm.plugin.bottle.a.imv.d(intent, this.uSU.uTo);
                            return;
                        }
                        return;
                    } else {
                        Toast.makeText(this.uSU.uTo, this.uSU.uTo.getString(R.l.elQ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX /*152*/:
                adA();
                return;
            default:
                jS(R.l.dPr);
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            if (this.jVN == 3) {
                com.tencent.mm.sdk.platformtools.w.v("MM.UI.BottleUI", "on key dwon");
                if (i == 25 && this.jVH.adM()) {
                    ap.yZ().ec(0);
                    return true;
                } else if (i == 24 && this.jVH.adM()) {
                    ap.yZ().eb(0);
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        } else if (!this.jVO) {
            return true;
        } else {
            if (this.jVN == 0) {
                finish();
                return true;
            }
            jU(0);
            return true;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (R.h.bup == id) {
            if (com.tencent.mm.plugin.bottle.a.c.ado() > 0) {
                jU(1);
            } else {
                jT(R.l.dPl);
            }
        } else if (R.h.buo == id) {
            if (com.tencent.mm.plugin.bottle.a.c.adp() > 0) {
                jU(2);
            } else {
                jT(R.l.dPk);
            }
        } else if (R.h.bun == id) {
            if (!this.jVV) {
                adz();
            }
            r0 = new Intent();
            r0.setClass(this, BottleConversationUI.class);
            r0.putExtra("conversation_from", "from_beach");
            startActivity(r0);
        } else if (R.h.btV == id) {
            if (this.jVN == 3) {
                this.jVH.onPause();
                this.jVH.adJ();
            }
            jU(0);
            h(0, 8, 8, 8);
        } else if (R.h.bur == id) {
            String str = ((PickedBottleImageView) view).jXp;
            String str2 = ((PickedBottleImageView) view).jVk;
            if (str2 != null && str2.length() > 0) {
                jU(0);
                ap.yY();
                af Rc = c.wR().Rc(str2);
                if (Rc == null || ((int) Rc.gTQ) == 0 || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                    final k aaVar = new aa(str2);
                    ap.vd().a(aaVar, 0);
                    Context context = this.uSU.uTo;
                    getString(R.l.dIO);
                    this.irJ = com.tencent.mm.ui.base.g.a(context, getString(R.l.dCL), true, new OnCancelListener(this) {
                        final /* synthetic */ BottleBeachUI jVW;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(aaVar);
                        }
                    });
                    return;
                }
                r0 = new Intent();
                r0.putExtra("Contact_User", Rc.field_username);
                if (Rc.bLe()) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(10298, Rc.field_username + ",25");
                    r0.putExtra("Contact_Scene", 25);
                }
                com.tencent.mm.plugin.bottle.a.imv.d(r0, this.uSU.uTo);
            } else if (str != null) {
                jU(3);
                OpenBottleUI openBottleUI = this.jVH;
                if (openBottleUI.jXo == null) {
                    openBottleUI.jXo = (ThrowBottleAnimUI) openBottleUI.jXf.findViewById(R.h.buA);
                    openBottleUI.jXo.jYs = new ThrowBottleAnimUI.a(openBottleUI) {
                        final /* synthetic */ OpenBottleUI jXy;

                        {
                            this.jXy = r1;
                        }

                        public final void adN() {
                            this.jXy.jXo.setVisibility(8);
                            this.jXy.jXf.jU(0);
                        }
                    };
                }
                if (openBottleUI.jXg == null) {
                    openBottleUI.jXg = (TextView) openBottleUI.findViewById(R.h.buh);
                    openBottleUI.jXh = (LinearLayout) openBottleUI.findViewById(R.h.buk);
                    openBottleUI.jXi = (FrameLayout) openBottleUI.findViewById(R.h.bum);
                    openBottleUI.jXj = (ImageView) openBottleUI.findViewById(R.h.buj);
                    openBottleUI.jXk = (TextView) openBottleUI.findViewById(R.h.bul);
                    openBottleUI.jXl = (TextView) openBottleUI.findViewById(R.h.bud);
                    openBottleUI.jXm = (TextView) openBottleUI.findViewById(R.h.bue);
                    openBottleUI.jXi.setOnClickListener(openBottleUI);
                }
                openBottleUI.jXp = str;
                com.tencent.mm.sdk.platformtools.w.d("MM.Bottle_OpenBottleUI", str);
                ap.yY();
                openBottleUI.fCZ = c.wT().Ai(str);
                if (openBottleUI.fCZ.bLZ()) {
                    float aw;
                    openBottleUI.jXg.setVisibility(8);
                    openBottleUI.jXh.setVisibility(0);
                    openBottleUI.jXi.setMinimumWidth(com.tencent.mm.bg.a.fromDPToPix(openBottleUI.jXf, OpenBottleUI.jZ((int) q.B(openBottleUI.fCZ))));
                    openBottleUI.jXk.setText(openBottleUI.jXf.getString(R.l.ema, new Object[]{Integer.valueOf((int) aw)}));
                    OpenBottleUI.jXn.a(openBottleUI);
                    if (openBottleUI.fCZ != null) {
                        aw = q.aw(new com.tencent.mm.modelvoice.n(openBottleUI.fCZ.field_content).time);
                        FrameLayout frameLayout = openBottleUI.jXi;
                        openBottleUI.getResources().getString(R.l.dPG);
                        frameLayout.setContentDescription(String.format("%d", new Object[]{Integer.valueOf((int) aw)}));
                    }
                } else {
                    openBottleUI.jXg.setVisibility(0);
                    openBottleUI.jXh.setVisibility(8);
                    openBottleUI.jXg.setText(openBottleUI.fCZ.field_content);
                    h.d(openBottleUI.jXg, 1);
                }
                openBottleUI.adK();
                if (openBottleUI.jXu == null) {
                    openBottleUI.jXu = (TextView) openBottleUI.findViewById(R.h.bNp);
                    openBottleUI.jXu.setOnClickListener(new OnClickListener(openBottleUI) {
                        final /* synthetic */ OpenBottleUI jXy;

                        {
                            this.jXy = r1;
                        }

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            String substring = bg.mA(this.jXy.jXp) ? "" : this.jXy.jXp.substring(0, this.jXy.jXp.indexOf(58));
                            String substring2 = bg.mA(this.jXy.jXp) ? "" : this.jXy.jXp.substring(this.jXy.jXp.indexOf(58) + 1);
                            intent.putExtra("k_username", substring);
                            Serializable kV = com.tencent.mm.av.a.kV(this.jXy.jXp);
                            substring = "";
                            if (kV.size() > 0) {
                                substring = (String) kV.get(0);
                            }
                            kV.clear();
                            kV.add(String.format("<exposecontent><bottleid>%s</bottleid><hellomsg>%s</hellomsg></exposecontent>", new Object[]{substring2, substring}));
                            intent.putExtra("k_outside_expose_proof_item_list", kV);
                            intent.putExtra("showShare", false);
                            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(37)}));
                            com.tencent.mm.bb.d.b(this.jXy.jXf, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    });
                }
            } else {
                jU(0);
            }
        }
    }

    private void adz() {
        boolean z = this.jVV;
        kp(z);
        this.jVV = !z;
    }

    private void jS(int i) {
        CharSequence string = i > 0 ? this.uSU.uTo.getString(i) : null;
        if (this.jVT == null) {
            this.jVT = new d(this);
        }
        this.jVT.cancel();
        if (string != null) {
            this.jVT.setDuration(0);
            this.jVT.setText(string);
            this.jVT.show();
        }
    }

    public final void jT(int i) {
        if (this.jVU == null) {
            this.jVU = new b(this);
        }
        b bVar = this.jVU;
        bVar.itE.setText(getString(i));
        this.jVU.show();
    }

    public final void jU(int i) {
        this.jVN = i;
        jS(0);
        if (this.jVV) {
            adz();
        }
        switch (i) {
            case 0:
                this.jVO = true;
                h(0, 8, 8, 8);
                return;
            case 1:
                h(8, 0, 8, 8);
                return;
            case 2:
                h(8, 8, 0, 8);
                return;
            case 3:
                h(8, 8, 8, 0);
                return;
            default:
                h(8, 8, 8, 8);
                return;
        }
    }

    private void h(int i, int i2, int i3, int i4) {
        com.tencent.mm.sdk.platformtools.w.v("MM.UI.BottleUI", "set frame visible");
        if (this.jVE == null) {
            this.jVE = (FrameLayout) findViewById(R.h.btY);
        }
        this.jVD.setVisibility(i);
        if (i == 0) {
            adA();
            this.jVM.setVisibility(8);
            aHf();
        }
        if (i2 == 0 && this.jVF == null) {
            this.jVF = (ThrowBottleUI) View.inflate(this, R.i.cVV, null);
            this.jVE.addView(this.jVF);
            ThrowBottleUI throwBottleUI = this.jVF;
            throwBottleUI.jYA = new ToneGenerator(1, 60);
            throwBottleUI.jYD = (Vibrator) throwBottleUI.jXf.getSystemService("vibrator");
            throwBottleUI.jYG = (ImageView) throwBottleUI.findViewById(R.h.but);
            throwBottleUI.jYH = (TextView) throwBottleUI.findViewById(R.h.btR);
            throwBottleUI.jYH.setVisibility(8);
            throwBottleUI.jYI = (ImageView) throwBottleUI.findViewById(R.h.bus);
            throwBottleUI.jYJ = (MMEditText) throwBottleUI.findViewById(R.h.buG);
            throwBottleUI.jYK = throwBottleUI.findViewById(R.h.buC);
            throwBottleUI.jYN = (ThrowBottleFooter) throwBottleUI.findViewById(R.h.buH);
            throwBottleUI.jXC = (ImageView) throwBottleUI.jXf.findViewById(R.h.btV);
            throwBottleUI.jYM = (ImageButton) throwBottleUI.findViewById(R.h.btQ);
            throwBottleUI.jYM.setOnClickListener(throwBottleUI);
            throwBottleUI.jYL = (Button) throwBottleUI.findViewById(R.h.buD);
            throwBottleUI.jYL.setOnTouchListener(new OnTouchListener(throwBottleUI) {
                final /* synthetic */ ThrowBottleUI jYZ;

                {
                    this.jYZ = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (view == this.jYZ.jYL) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                if (!this.jYZ.jYO) {
                                    com.tencent.mm.sdk.platformtools.w.i("MM.Bottle.ThrowBottleUI", "summerper checkPermission checkMicrophone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.jYZ.jXf, "android.permission.RECORD_AUDIO", 80, null, null))});
                                    if (com.tencent.mm.pluginsdk.i.a.a(this.jYZ.jXf, "android.permission.RECORD_AUDIO", 80, null, null)) {
                                        ThrowBottleUI throwBottleUI = this.jYZ;
                                        throwBottleUI.jYO = true;
                                        throwBottleUI.jYL.setBackgroundDrawable(com.tencent.mm.bg.a.a(throwBottleUI.jXf, R.g.bja));
                                        throwBottleUI.jYL.setText(throwBottleUI.jYt ? R.l.dPD : R.l.dPB);
                                        if (throwBottleUI.jYt) {
                                            if (!com.tencent.mm.n.a.aJ(throwBottleUI.getContext()) && !com.tencent.mm.n.a.aH(throwBottleUI.jXf)) {
                                                ap.yY();
                                                if (!c.isSDCardAvailable()) {
                                                    s.eP(throwBottleUI.jXf);
                                                    break;
                                                }
                                                throwBottleUI.jYW = true;
                                                com.tencent.mm.sdk.platformtools.w.v("MM.Bottle.ThrowBottleUI", "record start");
                                                if (throwBottleUI.jYz != null) {
                                                    throwBottleUI.jYz.jVj = null;
                                                    throwBottleUI.jYz = null;
                                                }
                                                throwBottleUI.jYz = new com.tencent.mm.plugin.bottle.a.h.d(throwBottleUI.getContext(), throwBottleUI);
                                                throwBottleUI.jYU.v(100, 100);
                                                throwBottleUI.jYG.setVisibility(0);
                                                throwBottleUI.jYH.setVisibility(0);
                                                throwBottleUI.jYF = (AnimationDrawable) throwBottleUI.jYH.getBackground();
                                                throwBottleUI.jYF.start();
                                                throwBottleUI.jYI.setVisibility(8);
                                                if (throwBottleUI.jYz != null) {
                                                    ad.Pt("keep_app_silent");
                                                    throwBottleUI.jYz.bx("_USER_FOR_THROWBOTTLE_");
                                                    throwBottleUI.jYP = false;
                                                    throwBottleUI.jYV.v(200, 200);
                                                    throwBottleUI.jYA.startTone(24);
                                                    throwBottleUI.handler.postDelayed(new Runnable(throwBottleUI) {
                                                        final /* synthetic */ ThrowBottleUI jYZ;

                                                        {
                                                            this.jYZ = r1;
                                                        }

                                                        public final void run() {
                                                            this.jYZ.jYA.stopTone();
                                                        }
                                                    }, 200);
                                                    throwBottleUI.jYD.vibrate(50);
                                                    throwBottleUI.jYz.a(throwBottleUI.jYY);
                                                }
                                                throwBottleUI.jXf.getWindow().getDecorView().setKeepScreenOn(true);
                                                break;
                                            }
                                            com.tencent.mm.sdk.platformtools.w.d("MM.Bottle.ThrowBottleUI", "voip is running, can't record voice");
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                this.jYZ.jYO = false;
                                this.jYZ.jYL.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.jYZ.jXf, R.g.biZ));
                                this.jYZ.jYL.setText(this.jYZ.jYt ? R.l.dPE : R.l.dPB);
                                if (!this.jYZ.jYt) {
                                    this.jYZ.cW(false);
                                    String trim = this.jYZ.jYJ.getText().toString().trim();
                                    if (trim.length() < 5) {
                                        this.jYZ.jXf.jT(R.l.dPC);
                                        break;
                                    }
                                    this.jYZ.jYJ.setText("");
                                    com.tencent.mm.plugin.bottle.a.h.c cVar = new com.tencent.mm.plugin.bottle.a.h.c(trim, this.jYZ);
                                    this.jYZ.adV();
                                } else if (!this.jYZ.jYP) {
                                    this.jYZ.adW();
                                }
                                this.jYZ.jYW = false;
                                break;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            throwBottleUI.setOnClickListener(throwBottleUI);
            if (throwBottleUI.jYQ == null) {
                throwBottleUI.jYQ = (LayoutParams) throwBottleUI.jYJ.getLayoutParams();
                throwBottleUI.jYS = throwBottleUI.jYQ.topMargin;
            }
            throwBottleUI.jYN.jYw = new ThrowBottleFooter.a(throwBottleUI) {
                final /* synthetic */ ThrowBottleUI jYZ;

                {
                    this.jYZ = r1;
                }

                public final void adT() {
                    if (this.jYZ.jYR == 0) {
                        this.jYZ.jYR = this.jYZ.getHeight();
                    }
                    int[] iArr = new int[]{0, 0};
                    int[] iArr2 = new int[]{0, 0};
                    this.jYZ.getLocationInWindow(iArr);
                    this.jYZ.jYN.getLocationInWindow(iArr2);
                    if ((((double) (iArr2[1] - iArr[1])) * 1.0d) / ((double) this.jYZ.jYR) < 0.5d) {
                        this.jYZ.jYQ.topMargin = this.jYZ.jYS;
                        this.jYZ.jYQ.bottomMargin = 0;
                        this.jYZ.jYK.setVisibility(0);
                        this.jYZ.requestLayout();
                        return;
                    }
                    this.jYZ.jYQ.topMargin = (this.jYZ.jYS * 1) / 6;
                    this.jYZ.jYQ.bottomMargin = this.jYZ.jYN.getHeight();
                    this.jYZ.jYK.setVisibility(8);
                    this.jYZ.requestLayout();
                }
            };
        }
        if (this.jVF != null) {
            this.jVF.setVisibility(i2);
        }
        if (i3 == 0 && this.jVG == null) {
            this.jVG = (PickBottleUI) View.inflate(this, R.i.cVU, null);
            this.jVE.addView(this.jVG);
            this.jVG.KC();
        }
        if (this.jVG != null) {
            this.jVG.setVisibility(i3);
        }
        if (i3 == 0) {
            this.jVG.density = com.tencent.mm.bg.a.getDensity(this);
            PickBottleUI pickBottleUI = this.jVG;
            pickBottleUI.jXB.setVisibility(8);
            pickBottleUI.jXA.x(Integer.MAX_VALUE, -1, -1);
            pickBottleUI.jXC.setVisibility(8);
            pickBottleUI.jXf.jVO = false;
            pickBottleUI.handler.postDelayed(pickBottleUI.jXE, 1000);
        }
        if (i4 == 0 && this.jVH == null) {
            this.jVH = (OpenBottleUI) View.inflate(this, R.i.cVT, null);
            this.jVE.addView(this.jVH);
            Object obj = this.jVH;
            ((Button) obj.findViewById(R.h.bui)).setOnClickListener(obj);
            ((Button) obj.findViewById(R.h.bug)).setOnClickListener(obj);
            obj.jXv = this;
        }
        if (this.jVH != null) {
            this.jVH.setVisibility(i4);
        }
    }

    private void adA() {
        if (this.jVS == null) {
            this.jVS = (TextView) findViewById(R.h.bua);
            this.jVS.setBackgroundResource(com.tencent.mm.ui.tools.s.fg(this.uSU.uTo));
        }
        int adq = com.tencent.mm.plugin.bottle.a.c.adq();
        this.jVS.setText(String.valueOf(adq));
        this.jVS.setVisibility(adq > 0 ? 0 : 8);
    }

    public final void in(String str) {
        if (this.jVG != null) {
            PickBottleUI pickBottleUI = this.jVG;
            if (pickBottleUI.jXB != null) {
                PickedBottleImageView pickedBottleImageView = pickBottleUI.jXB;
                if (str.equals(pickedBottleImageView.jVk)) {
                    pickedBottleImageView.jXJ = l.b(pickedBottleImageView.jVk, pickedBottleImageView.iconUrl, R.g.bhR);
                    pickedBottleImageView.update();
                    pickedBottleImageView.invalidate();
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        adA();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.w.i("MM.UI.BottleUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BottleBeachUI jVW;

                        {
                            this.jVW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.jVW.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
