package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMScrollGridView;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class FacingCreateChatRoomAllInOneUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
            if (z) {
                Location location = new Location(f2, f, (int) d2, i, "", "");
                if (!location.bDo()) {
                    this.oxv.owL = location;
                    this.oxv.owI = true;
                    FacingCreateChatRoomAllInOneUI.e(this.oxv);
                }
            } else {
                this.oxv.owI = false;
            }
            return false;
        }
    };
    private boolean jUy = false;
    private ProgressDialog kIa;
    private String kwg;
    private ae mHandler = new ae(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                    if (this.oxv.owY != null) {
                        this.oxv.owY.H(this.oxv.owV);
                        return;
                    }
                    return;
                case CdnLogic.MediaType_FAVORITE_VIDEO /*10002*/:
                    FacingCreateChatRoomAllInOneUI.d(this.oxv);
                    return;
                default:
                    return;
            }
        }
    };
    private c owF;
    private boolean owG = false;
    private boolean owH;
    private boolean owI;
    private boolean owJ;
    private boolean owK = false;
    private Location owL;
    private String owM;
    private MMPwdInputView owN;
    private View owO;
    private ProgressBar owP;
    private TextView owQ;
    private MMKeyBoardView owR;
    private TextView owS;
    private boolean owT = false;
    private boolean owU = false;
    private LinkedList<rj> owV = new LinkedList();
    private HashMap<String, rj> owW = new HashMap();
    private LinkedList<rj> owX = new LinkedList();
    private a owY;
    private View owZ;
    private TextView oxa;
    private MMScrollGridView oxb;
    private View oxc;
    private View oxd;
    private Button oxe;
    private MMCallBackScrollView oxf;
    private TextView oxg;
    private boolean oxh = false;
    private af oxi = new af();
    private aj oxj = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final boolean oQ() {
            FacingCreateChatRoomAllInOneUI.a(this.oxv);
            return false;
        }
    }, false);
    private com.tencent.mm.plugin.pwdgroup.a.a oxk;
    private com.tencent.mm.plugin.pwdgroup.a.a oxl;
    private int oxm;
    private Animation oxn;
    private AnimationSet oxo;
    private Animation oxp;
    public OnMenuItemClickListener oxq = new OnMenuItemClickListener(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.oxv.finish();
            return false;
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a oxr = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final void f(boolean z, String str) {
            w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", new Object[]{Boolean.valueOf(z), str});
            this.oxv.owM = str;
            if (z) {
                this.oxv.owH = true;
                FacingCreateChatRoomAllInOneUI.e(this.oxv);
            }
        }
    };
    private OnClickListener oxs = new OnClickListener(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final void onClick(View view) {
            this.oxv.owT = false;
            FacingCreateChatRoomAllInOneUI.d(this.oxv);
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a oxt = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final void input(String str) {
            if (this.oxv.owN == null) {
                return;
            }
            if (this.oxv.owG || this.oxv.owK) {
                MMPwdInputView g = this.oxv.owN;
                g.Ku();
                g.input(str);
                this.oxv.rx(a.oxz);
                return;
            }
            this.oxv.owN.input(str);
        }

        public final void Ku() {
            if (this.oxv.owN != null) {
                this.oxv.owN.Ku();
            }
        }

        public final void delete() {
            if (this.oxv.owN == null) {
                return;
            }
            if (this.oxv.owG || this.oxv.owK) {
                this.oxv.owN.Ku();
                this.oxv.rx(a.oxz);
                return;
            }
            MMPwdInputView g = this.oxv.owN;
            if (g.lCI > 0) {
                g.kxS.deleteCharAt(g.lCI - 1);
            }
            g.aUb();
            g.aUa();
        }
    };
    private aj oxu = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

        {
            this.oxv = r1;
        }

        public final boolean oQ() {
            this.oxv.owH = false;
            this.oxv.rx(a.oxC);
            return true;
        }
    }, false);

    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] oxy = new int[a.aTZ().length];

        static {
            try {
                oxy[a.oxz - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                oxy[a.oxA - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                oxy[a.oxB - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                oxy[a.oxC - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private enum a {
        ;

        public static int[] aTZ() {
            return (int[]) oxD.clone();
        }

        static {
            oxz = 1;
            oxA = 2;
            oxB = 3;
            oxC = 4;
            oxD = new int[]{oxz, oxA, oxB, oxC};
        }
    }

    static /* synthetic */ void a(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        if (facingCreateChatRoomAllInOneUI.jUy || facingCreateChatRoomAllInOneUI.owL == null) {
            w.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cancel refresh chat room member.");
            return;
        }
        w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryDoSearchScene]-----------");
        facingCreateChatRoomAllInOneUI.oxk = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.owM, facingCreateChatRoomAllInOneUI.kwg, facingCreateChatRoomAllInOneUI.owL.hCP, facingCreateChatRoomAllInOneUI.owL.hCQ, facingCreateChatRoomAllInOneUI.owL.accuracy, facingCreateChatRoomAllInOneUI.owL.fPH, facingCreateChatRoomAllInOneUI.owL.mac, facingCreateChatRoomAllInOneUI.owL.fPJ);
        ap.vd().a(facingCreateChatRoomAllInOneUI.oxk, 0);
    }

    static /* synthetic */ void d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        facingCreateChatRoomAllInOneUI.getString(R.l.dIO);
        facingCreateChatRoomAllInOneUI.kIa = g.a(facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(R.l.dJd), true, new OnCancelListener(facingCreateChatRoomAllInOneUI) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

            {
                this.oxv = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().cancel(653);
            }
        });
        facingCreateChatRoomAllInOneUI.aTW();
        ap.vd().a(new com.tencent.mm.plugin.pwdgroup.a.a(1, facingCreateChatRoomAllInOneUI.owM, facingCreateChatRoomAllInOneUI.kwg, facingCreateChatRoomAllInOneUI.owL.hCP, facingCreateChatRoomAllInOneUI.owL.hCQ, facingCreateChatRoomAllInOneUI.owL.accuracy, facingCreateChatRoomAllInOneUI.owL.fPH, facingCreateChatRoomAllInOneUI.owL.mac, facingCreateChatRoomAllInOneUI.owL.fPJ), 0);
    }

    static /* synthetic */ void e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.oxu != null) {
            facingCreateChatRoomAllInOneUI.oxu.KH();
        }
        if (facingCreateChatRoomAllInOneUI.owI) {
            if (facingCreateChatRoomAllInOneUI.owH) {
                facingCreateChatRoomAllInOneUI.rx(a.oxA);
            }
            if (facingCreateChatRoomAllInOneUI.owI && facingCreateChatRoomAllInOneUI.owH && !facingCreateChatRoomAllInOneUI.owJ) {
                w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
                facingCreateChatRoomAllInOneUI.owJ = true;
                facingCreateChatRoomAllInOneUI.owH = false;
                facingCreateChatRoomAllInOneUI.oxl = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.owM, "", facingCreateChatRoomAllInOneUI.owL.hCP, facingCreateChatRoomAllInOneUI.owL.hCQ, facingCreateChatRoomAllInOneUI.owL.accuracy, facingCreateChatRoomAllInOneUI.owL.fPH, facingCreateChatRoomAllInOneUI.owL.mac, facingCreateChatRoomAllInOneUI.owL.fPJ);
                ap.vd().a(facingCreateChatRoomAllInOneUI.oxl, 0);
                return;
            }
            return;
        }
        w.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
        facingCreateChatRoomAllInOneUI.rx(a.oxA);
        if (facingCreateChatRoomAllInOneUI.oxu != null) {
            facingCreateChatRoomAllInOneUI.oxu.v(15000, 15000);
        }
    }

    protected final int getLayoutId() {
        return R.i.dcf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            aTU();
        }
    }

    private void aTU() {
        this.owF = c.Gk();
        this.owF.a(this.gKp, true);
        ap.vd().a(653, this);
        KC();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    aTU();
                    return;
                } else {
                    g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

                        {
                            this.oxv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oxv.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            this.oxv.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

                        {
                            this.oxv = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oxv.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    protected void onResume() {
        if (this.owF != null) {
            this.owF.a(this.gKp, true);
        }
        if (this.oxh) {
            aTV();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.owF != null) {
            this.owF.c(this.gKp);
        }
        if (this.oxh) {
            aTW();
        }
        super.onPause();
    }

    protected void onDestroy() {
        ap.vd().b(653, this);
        if (this.owF != null) {
            this.owF.c(this.gKp);
        }
        if (!this.owU) {
            ap.vd().cancel(653);
            if (this.owL != null) {
                this.oxl = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.owM, "", this.owL.hCP, this.owL.hCQ, this.owL.accuracy, this.owL.fPH, this.owL.mac, this.owL.fPJ);
                ap.vd().a(this.oxl, 0);
            }
        }
        if (this.oxh) {
            aTW();
        }
        super.onDestroy();
    }

    protected final int Ol() {
        return 1;
    }

    protected final void KC() {
        zi(R.l.ekh);
        b(this.oxq);
        if (cO().cP() != null) {
            cO().cP().setBackgroundDrawable(getResources().getDrawable(R.g.biE));
        }
        this.owO = findViewById(R.h.bNU);
        this.owP = (ProgressBar) findViewById(R.h.bNT);
        this.owQ = (TextView) findViewById(R.h.bNV);
        this.owR = (MMKeyBoardView) findViewById(R.h.bNS);
        this.owS = (TextView) findViewById(R.h.bNR);
        this.owN = (MMPwdInputView) findViewById(R.h.bNP);
        this.owN.oys = this.oxr;
        this.owN.requestFocus();
        this.owR.oxt = this.oxt;
        rx(a.oxz);
        this.owZ = findViewById(R.h.bNI);
        this.oxa = (TextView) findViewById(R.h.bNK);
        this.oxb = (MMScrollGridView) findViewById(R.h.bNJ);
        this.oxb.setVisibility(4);
        this.oxe = (Button) findViewById(R.h.bNL);
        this.oxe.setOnClickListener(this.oxs);
        this.oxc = findViewById(R.h.bNM);
        this.oxd = findViewById(R.h.bNN);
        this.oxa.setText(R.l.ehp);
        this.oxf = (MMCallBackScrollView) findViewById(R.h.bNW);
        this.oxg = (TextView) findViewById(R.h.bNQ);
        this.oxf.oxJ = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

            {
                this.oxv = r1;
            }

            public final void bi(int i) {
                if (this.oxv.oxd == null) {
                    return;
                }
                if (i == 0) {
                    this.oxv.oxd.setVisibility(4);
                } else {
                    this.oxv.oxd.setVisibility(0);
                }
            }
        };
        this.owY = new a(this);
        this.oxb.setAdapter(this.owY);
        this.owY.H(this.owV);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 653:
                com.tencent.mm.plugin.pwdgroup.a.a aVar = (com.tencent.mm.plugin.pwdgroup.a.a) kVar;
                int i3 = aVar.owE;
                if (i3 == 0) {
                    this.owJ = false;
                    if (this.oxh) {
                        if (this.oxj != null) {
                            this.oxj.v(3000, 3000);
                        }
                        if (i == 0 && i2 == 0) {
                            final LinkedList linkedList = aVar.aTT().teK;
                            this.oxi.D(new Runnable(this) {
                                final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

                                public final void run() {
                                    int size;
                                    int i;
                                    rj rjVar;
                                    if (this.oxv.owX != null) {
                                        this.oxv.owX.clear();
                                    }
                                    if (this.oxv.owW != null) {
                                        this.oxv.owW.clear();
                                    }
                                    if (linkedList != null && linkedList.size() > 0) {
                                        size = linkedList.size();
                                        for (i = 0; i < size; i++) {
                                            rjVar = (rj) linkedList.get(i);
                                            if (!bg.mA(rjVar.twU)) {
                                                this.oxv.owW.put(rjVar.twU, rjVar);
                                            }
                                        }
                                    }
                                    size = this.oxv.owV.size();
                                    for (i = 0; i < size; i++) {
                                        rjVar = (rj) this.oxv.owV.get(i);
                                        if (this.oxv.owW.containsKey(rjVar.twU)) {
                                            this.oxv.owW.remove(rjVar.twU);
                                        } else {
                                            w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[]{rjVar.twU});
                                        }
                                    }
                                    if (this.oxv.owW != null && this.oxv.owW.size() > 0) {
                                        for (Entry value : this.oxv.owW.entrySet()) {
                                            this.oxv.owX.add((rj) value.getValue());
                                            w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[]{rjVar.twU});
                                        }
                                    }
                                    this.oxv.owV.addAll(this.oxv.owX);
                                    this.oxv.mHandler.sendEmptyMessage(CdnLogic.MediaType_FAVORITE_FILE);
                                }
                            });
                            this.kwg = aVar.aTT().tuo;
                            return;
                        }
                        return;
                    } else if (i == 0 && i2 == 0) {
                        rx(a.oxz);
                        this.oxm = this.owS.getHeight();
                        w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[]{Integer.valueOf(this.oxm)});
                        this.oxn = AnimationUtils.loadAnimation(this, R.a.aQW);
                        this.oxp = AnimationUtils.loadAnimation(this, R.a.aQU);
                        this.oxo = new AnimationSet(true);
                        this.oxo.addAnimation(AnimationUtils.loadAnimation(this, R.a.aRD));
                        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.oxm));
                        translateAnimation.setDuration(300);
                        this.oxo.addAnimation(translateAnimation);
                        this.oxn.setDuration(200);
                        this.oxo.setDuration(300);
                        this.oxp.setDuration(300);
                        this.oxn.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.oxo.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.oxp.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.oxo.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.oxo.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

                            {
                                this.oxv = r1;
                            }

                            public final void onAnimationStart(Animation animation) {
                                this.oxv.owZ.setVisibility(4);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.oxv.oxg.setVisibility(8);
                                this.oxv.owN.setVisibility(0);
                                this.oxv.oxb.setVisibility(0);
                                this.oxv.oxc.setVisibility(0);
                                this.oxv.owZ.setVisibility(0);
                                this.oxv.owO.setVisibility(8);
                                this.oxv.owR.setVisibility(8);
                                this.oxv.owN.clearAnimation();
                                this.oxv.oxb.clearAnimation();
                                this.oxv.owZ.clearAnimation();
                            }
                        });
                        this.owN.setVisibility(4);
                        this.owN.setAnimation(translateAnimation);
                        this.owR.startAnimation(this.oxn);
                        this.owO.startAnimation(this.oxn);
                        this.owS.startAnimation(this.oxn);
                        this.oxc.startAnimation(this.oxp);
                        this.owZ.startAnimation(this.oxo);
                        this.oxc.setVisibility(4);
                        this.owR.setVisibility(8);
                        this.owS.setVisibility(8);
                        this.oxh = true;
                        aTV();
                        return;
                    } else if (i2 == -431) {
                        this.owG = true;
                        rx(a.oxB);
                        return;
                    } else {
                        this.owG = true;
                        rx(a.oxC);
                        return;
                    }
                } else if (i3 == 3) {
                    if (i != 0 || i2 != 0) {
                        if (i2 == -431) {
                            rx(a.oxB);
                            this.owG = true;
                            return;
                        }
                        rx(a.oxC);
                        return;
                    }
                    return;
                } else if (i3 != 1) {
                    aFI();
                    return;
                } else if (i == 0 && i2 == 0) {
                    aFI();
                    w.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[]{aVar.aTT().ttq});
                    this.owU = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", r0);
                    com.tencent.mm.plugin.pwdgroup.a.imv.e(intent, this);
                    return;
                } else if (i2 == -432 && !this.owT) {
                    this.owT = true;
                    this.mHandler.sendEmptyMessageDelayed(CdnLogic.MediaType_FAVORITE_VIDEO, 3000);
                    return;
                } else if (i2 == -23) {
                    aFI();
                    uC(getString(R.l.ehq));
                    if (this.oxj != null) {
                        this.oxj.v(3000, 3000);
                        return;
                    }
                    return;
                } else {
                    aFI();
                    com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null) {
                        dn.a(this.uSU.uTo, null, null);
                    } else {
                        uC(getString(R.l.eHF));
                    }
                    if (this.oxj != null) {
                        this.oxj.v(3000, 3000);
                        return;
                    }
                    return;
                }
            default:
                w.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void gn(boolean z) {
        if (this.owR != null) {
            this.owR.go(z);
        }
    }

    private void rx(int i) {
        if (this.owQ != null) {
            switch (AnonymousClass10.oxy[i - 1]) {
                case 1:
                    gn(true);
                    this.owG = false;
                    this.owK = false;
                    this.owP.setVisibility(8);
                    this.owQ.setVisibility(8);
                    return;
                case 2:
                    gn(false);
                    this.owQ.setText(R.l.eHG);
                    this.owP.setVisibility(0);
                    this.owQ.setVisibility(8);
                    return;
                case 3:
                    gn(true);
                    this.owP.setVisibility(8);
                    this.owQ.setVisibility(0);
                    this.owQ.setText(R.l.eHE);
                    aTX();
                    return;
                case 4:
                    gn(true);
                    this.owP.setVisibility(8);
                    this.owQ.setVisibility(0);
                    this.owQ.setText(R.l.eHF);
                    aTX();
                    return;
                default:
                    w.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    return;
            }
        }
    }

    private void aFI() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }

    private void uC(String str) {
        g.a(this, str, "", getString(R.l.dHT), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

            {
                this.oxv = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void aTV() {
        this.jUy = false;
        if (this.oxj != null) {
            this.oxj.v(0, 0);
        }
    }

    private void aTW() {
        this.jUy = true;
        if (this.oxj != null) {
            this.oxj.KH();
        }
        ap.vd().c(this.oxk);
    }

    private void aTX() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.aQK);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.a.aQJ);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.oxv.owN.Ku();
                this.oxv.owN.startAnimation(loadAnimation2);
            }
        });
        loadAnimation2.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FacingCreateChatRoomAllInOneUI oxv;

            {
                this.oxv = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (this.oxv.owR != null) {
                    this.oxv.owR.go(true);
                }
            }
        });
        if (this.owN != null) {
            this.owN.startAnimation(loadAnimation);
        }
        if (this.owR != null) {
            this.owR.go(false);
        }
    }
}
