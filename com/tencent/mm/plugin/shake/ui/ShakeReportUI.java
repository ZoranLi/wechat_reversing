package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.df;
import com.tencent.mm.e.a.dg;
import com.tencent.mm.e.a.dm;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.d.a.k.1;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.x;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShakeReportUI extends MMActivity implements com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.shake.b.l.a, com.tencent.mm.plugin.shake.c.a.f.a, com.tencent.mm.sdk.e.j.a, b, al {
    private static List<com.tencent.mm.plugin.shake.d.a.h.a> gKn = new CopyOnWriteArrayList();
    private c gKi;
    private boolean gKl = false;
    private Map<String, com.tencent.mm.plugin.shake.d.a.h.a> gKm = new ConcurrentHashMap();
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ ShakeReportUI psK;

        {
            this.psK = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (z) {
                w.d("MicroMsg.ShakeReportUI", "on location get ok");
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAx, String.valueOf(f2));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAy, String.valueOf(f));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCN, String.valueOf(d2));
                this.psK.gKl = true;
                if (this.psK.gKi != null) {
                    this.psK.gKi.c(this.psK.gKp);
                }
            } else {
                w.w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            return false;
        }
    };
    private com.tencent.mm.ah.a.a hHR = null;
    private ImageView ioV;
    private com.tencent.mm.pluginsdk.m.c nVn;
    private boolean oIa = true;
    private boolean prA = false;
    private boolean prB = false;
    private int prC = 22;
    private c prD;
    private l prE = new l();
    private f prF;
    private View prG;
    private View prH;
    private TextView prI;
    private TextView prJ;
    private TextView prK;
    private View prL;
    private View prM;
    private View prN;
    private View prO;
    private Animation prP;
    private Animation prQ;
    private Animation prR;
    private Animation prS;
    private View prT = null;
    private View prU = null;
    private MMImageView prV = null;
    private TextView prW = null;
    private ImageView prX = null;
    private String prY = "";
    private Bitmap prZ = null;
    private boolean prv = false;
    private boolean prw = false;
    private boolean prx;
    private boolean pry = false;
    private boolean prz = false;
    private boolean psA = false;
    private boolean psB = false;
    private boolean psC = false;
    private boolean psD = false;
    private int psE = 1;
    private long psF = 0;
    private boolean psG = false;
    private com.tencent.mm.sdk.b.c psH = new com.tencent.mm.sdk.b.c<dg>(this) {
        final /* synthetic */ ShakeReportUI psK;

        {
            this.psK = r2;
            this.usg = dg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dg dgVar = (dg) bVar;
            String str = dgVar.fHe.fHc;
            int i = dgVar.fHe.fHf;
            int i2 = dgVar.fHe.fHg;
            String str2 = dgVar.fHe.fHj;
            double d = dgVar.fHe.fHi;
            int i3 = dgVar.fHe.fHk;
            if (!this.psK.gKm.containsKey(str + "," + i + "," + i2)) {
                com.tencent.mm.plugin.shake.d.a.h.a aVar = new com.tencent.mm.plugin.shake.d.a.h.a();
                aVar.mry = str;
                aVar.hQZ = dgVar.fHe.fHh;
                aVar.major = i;
                aVar.minor = i2;
                aVar.pqr = str2;
                aVar.pqs = d;
                aVar.pqt = i3;
                this.psK.gKm.put(str + "," + i + "," + i2, aVar);
                if (dgVar.fHe.fHh >= 0.0d && ShakeReportUI.gKn.size() > 0) {
                    i3 = 0;
                    while (i3 < ShakeReportUI.gKn.size()) {
                        com.tencent.mm.plugin.shake.d.a.h.a aVar2 = (com.tencent.mm.plugin.shake.d.a.h.a) ShakeReportUI.gKn.get(i3);
                        if (dgVar.fHe.fHh >= aVar2.hQZ) {
                            if (i3 == ShakeReportUI.gKn.size() - 1 && dgVar.fHe.fHh > aVar2.hQZ) {
                                ShakeReportUI.gKn.add(aVar);
                                break;
                            }
                            i3++;
                        } else {
                            ShakeReportUI.gKn.add(i3, aVar);
                            break;
                        }
                    }
                }
                ShakeReportUI.gKn.add(aVar);
                if (this.psK.gKm.size() == 1 && !this.psK.psG) {
                    this.psK.psF = System.currentTimeMillis() - this.psK.psF;
                    g.oUh.i(11497, new Object[]{String.valueOf((int) (((double) (this.psK.psF / 1000)) + 0.5d)), Integer.valueOf(0), Integer.valueOf((int) this.psK.psF)});
                    this.psK.psF = 0;
                    this.psK.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass24 psO;

                        {
                            this.psO = r1;
                        }

                        public final void run() {
                            ShakeReportUI.h(this.psO.psK);
                        }
                    });
                }
            }
            w.i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", new Object[]{str + "," + i + "," + i2, Integer.valueOf(this.psK.gKm.size())});
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c psI = new com.tencent.mm.sdk.b.c<dm>(this) {
        final /* synthetic */ ShakeReportUI psK;

        {
            this.psK = r2;
            this.usg = dm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dm dmVar = (dm) bVar;
            w.d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", new Object[]{Integer.valueOf(dmVar.fHu.fHv)});
            boolean hasSystemFeature = this.psK.uSU.uTo.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (dmVar.fHu.fHv == 10 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
                this.psK.bbA();
            } else if (dmVar.fHu.fHv == 12) {
                if (VERSION.SDK_INT < 18 || !hasSystemFeature) {
                    this.psK.psE = 1;
                } else {
                    this.psK.bbz();
                    this.psK.psE = 0;
                }
                bg zL = bg.zL();
                String mz = com.tencent.mm.sdk.platformtools.bg.mz(zL.hnP);
                String mz2 = com.tencent.mm.sdk.platformtools.bg.mz(zL.hnO);
                int i = hasSystemFeature ? 1 : 0;
                if (this.psK.psB) {
                    g.oUh.i(13139, new Object[]{mz, mz2, Integer.valueOf(1), Integer.valueOf(this.psK.psE), Integer.valueOf(1), Integer.valueOf(i)});
                } else {
                    g.oUh.i(13139, new Object[]{mz, mz2, Integer.valueOf(0), Integer.valueOf(this.psK.psE), Integer.valueOf(1), Integer.valueOf(i)});
                }
                if (this.psK.psC && this.psK.psB && !this.psK.psG && this.psK.psl < 4) {
                    this.psK.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass25 psP;

                        {
                            this.psP = r1;
                        }

                        public final void run() {
                            ShakeReportUI.h(this.psP.psK);
                        }
                    });
                }
            }
            return false;
        }
    };
    private OnClickListener psJ = new OnClickListener(this) {
        public long pra = 0;
        final /* synthetic */ ShakeReportUI psK;

        {
            this.psK = r3;
        }

        public final void onClick(View view) {
            if (!com.tencent.mm.sdk.platformtools.bg.mA((String) this.psK.prG.getTag()) && this.psK.psc != null) {
                d L = this.psK.psc;
                String str = L.field_username;
                Intent intent;
                if (11 != L.field_type) {
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(str);
                    if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Sns_from_Scene", 22);
                        if (str != null && str.length() > 0) {
                            if (Rc.bLe()) {
                                g.oUh.A(10298, str + "," + this.psK.prC);
                                intent2.putExtra("Contact_Scene", this.psK.prC);
                            }
                            com.tencent.mm.plugin.shake.a.imv.d(intent2, this.psK);
                            return;
                        }
                        return;
                    }
                    if ((L.field_reserved1 & 8) > 0) {
                        g.oUh.A(10298, L.field_username + "," + this.psK.prC);
                    }
                    intent = new Intent();
                    intent.putExtra("Contact_User", L.field_username);
                    intent.putExtra("Contact_Nick", L.field_nickname);
                    intent.putExtra("Contact_Distance", L.field_distance);
                    intent.putExtra("Contact_Signature", L.field_signature);
                    intent.putExtra("Contact_Province", L.getProvince());
                    intent.putExtra("Contact_City", L.getCity());
                    intent.putExtra("Contact_Sex", L.field_sex);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_VUser_Info", L.field_reserved3);
                    intent.putExtra("Contact_VUser_Info_Flag", L.field_reserved1);
                    intent.putExtra("Contact_KSnsIFlag", L.field_snsFlag);
                    intent.putExtra("Contact_KSnsBgUrl", L.field_sns_bgurl);
                    intent.putExtra("Contact_Scene", this.psK.prC);
                    intent.putExtra("Sns_from_Scene", 22);
                    com.tencent.mm.plugin.shake.a.imv.d(intent, this.psK);
                } else if (System.currentTimeMillis() - this.pra > 3000) {
                    this.pra = System.currentTimeMillis();
                    intent = new Intent();
                    intent.putExtra("rawUrl", L.getCity());
                    intent.putExtra("scene", 27);
                    intent.putExtra("stastic_scene", 5);
                    com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    l.b bVar = this.psK.prE.poq;
                    if (bVar != null && (bVar instanceof h)) {
                        h.a(L);
                        h.b(L);
                    }
                }
            }
        }
    };
    private Dialog psa;
    private ImageView psb = null;
    private d psc = null;
    private ImageView psd;
    private ImageView pse;
    private ImageView psf;
    private ImageView psg;
    private ImageView psh;
    private ImageView psi;
    private TextView psj;
    private int psk = 1;
    private int psl = 0;
    private View psm;
    private ImageView psn;
    private ImageView pso;
    private ImageView psp;
    private ImageView psq;
    private View psr;
    private View pss;
    private View pst;
    private View psu;
    private View psv = null;
    private int psw = 0;
    private com.tencent.mm.plugin.shake.c.b.a psx;
    private boolean psy = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> psz = new HashMap();

    static class a extends com.tencent.mm.pluginsdk.m.c.a {
        private final long[] ijZ = new long[]{300, 200, 300, 200};
        private long jXs = com.tencent.mm.sdk.platformtools.bg.NA();
        private Vibrator jYD;
        WeakReference<ShakeReportUI> psQ;

        public a(ShakeReportUI shakeReportUI) {
            this.psQ = new WeakReference(shakeReportUI);
        }

        public final void aOz() {
            ShakeReportUI shakeReportUI = (ShakeReportUI) this.psQ.get();
            if (shakeReportUI != null) {
                if (shakeReportUI.isFinishing()) {
                    w.e("MicroMsg.ShakeReportUI", "ui finished");
                } else if (shakeReportUI.prA) {
                    shakeReportUI.bbG();
                    long aB = com.tencent.mm.sdk.platformtools.bg.aB(this.jXs);
                    if (aB < 1200) {
                        w.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:" + aB);
                        return;
                    }
                    w.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:" + aB);
                    this.jXs = com.tencent.mm.sdk.platformtools.bg.NA();
                    if (shakeReportUI.prD != null) {
                        c w = shakeReportUI.prD;
                        if (w.view != null) {
                            w.view.setKeepScreenOn(true);
                        }
                        w.fyI.v(30000, 30000);
                    }
                    if (shakeReportUI.prF != null) {
                        f q = shakeReportUI.prF;
                        if (q.nul != null) {
                            q.nul.dismiss();
                        }
                    }
                    ShakeReportUI shakeReportUI2;
                    if (shakeReportUI.prx) {
                        shakeReportUI2 = (ShakeReportUI) this.psQ.get();
                        if (shakeReportUI2 != null) {
                            aq.B(shakeReportUI2, R.l.eVW);
                        }
                    } else {
                        shakeReportUI2 = (ShakeReportUI) this.psQ.get();
                        if (shakeReportUI2 != null) {
                            if (this.jYD == null) {
                                this.jYD = (Vibrator) shakeReportUI2.getSystemService("vibrator");
                            }
                            if (this.jYD != null) {
                                this.jYD.vibrate(this.ijZ, -1);
                            }
                        }
                    }
                    com.tencent.mm.pluginsdk.m.c.a.reset();
                    ShakeReportUI.y(shakeReportUI);
                } else {
                    w.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                }
            }
        }

        public final void onRelease() {
        }
    }

    static /* synthetic */ void h(ShakeReportUI shakeReportUI) {
        if (bbL()) {
            ViewGroup viewGroup = (ViewGroup) shakeReportUI.findViewById(R.h.cDW);
            if (viewGroup != null) {
                int i;
                int childCount = viewGroup.getChildCount();
                List arrayList = new ArrayList();
                int i2 = 0;
                for (i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i).getVisibility() == 0) {
                        i2++;
                        arrayList.add(viewGroup.getChildAt(i));
                    }
                }
                int width;
                Animation animationSet;
                Animation alphaAnimation;
                Animation translateAnimation;
                View view;
                if (!shakeReportUI.psA && (shakeReportUI.psB || shakeReportUI.psD)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    animationSet = new AnimationSet(false);
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(600);
                    translateAnimation = new TranslateAnimation((float) viewGroup.getWidth(), (float) (viewGroup.getWidth() - childCount), 0.0f, 0.0f);
                    animationSet.addAnimation(alphaAnimation);
                    translateAnimation.setDuration(600);
                    animationSet.addAnimation(translateAnimation);
                    shakeReportUI.findViewById(R.h.cEj).setAnimation(animationSet);
                    if (i2 < 4) {
                        for (i = 0; i < i2; i++) {
                            view = (View) arrayList.get(i);
                            translateAnimation = new TranslateAnimation((float) (((i * width) + (width / 2)) - ((i * childCount) + (childCount / 2))), 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(600);
                            view.setAnimation(translateAnimation);
                        }
                    }
                } else if (!(shakeReportUI.psA || shakeReportUI.psB || shakeReportUI.psD)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    Animation animationSet2 = new AnimationSet(false);
                    animationSet = new AlphaAnimation(0.0f, 1.0f);
                    animationSet.setDuration(1200);
                    alphaAnimation = new TranslateAnimation((float) ((-childCount) / 2), 0.0f, 0.0f, 0.0f);
                    animationSet2.addAnimation(animationSet);
                    alphaAnimation.setDuration(600);
                    animationSet2.addAnimation(alphaAnimation);
                    shakeReportUI.findViewById(R.h.cEg).setAnimation(animationSet2);
                    for (i = 1; i < i2 + 1; i++) {
                        view = (View) arrayList.get(i - 1);
                        translateAnimation = new TranslateAnimation((float) (-(((i * childCount) + (childCount / 2)) - (((i - 1) * width) + (width / 2)))), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(600);
                        view.setAnimation(translateAnimation);
                    }
                }
                shakeReportUI.psA = true;
                shakeReportUI.psk = 5;
                shakeReportUI.psG = true;
                shakeReportUI.bbJ();
                shakeReportUI.bbC();
                shakeReportUI.gV(false);
            }
        }
    }

    static /* synthetic */ void y(ShakeReportUI shakeReportUI) {
        if (shakeReportUI.prL == null) {
            shakeReportUI.prL = shakeReportUI.findViewById(R.h.cEE);
        }
        if (shakeReportUI.prM == null) {
            shakeReportUI.prM = shakeReportUI.findViewById(R.h.cDB);
        }
        if (shakeReportUI.prN == null) {
            shakeReportUI.prN = shakeReportUI.findViewById(R.h.cDG);
        }
        if (shakeReportUI.prO == null) {
            shakeReportUI.prO = shakeReportUI.findViewById(R.h.cDH);
        }
        if (shakeReportUI.prP == null) {
            shakeReportUI.prP = AnimationUtils.loadAnimation(shakeReportUI.uSU.uTo, R.a.aRU);
            shakeReportUI.prP.setAnimationListener(new AnimationListener(shakeReportUI) {
                final /* synthetic */ ShakeReportUI psK;

                {
                    this.psK = r1;
                }

                public final void onAnimationStart(Animation animation) {
                    this.psK.prv = false;
                    this.psK.prw = true;
                    this.psK.gU(false);
                    this.psK.prz = true;
                    this.psK.gY(true);
                }

                public final void onAnimationEnd(Animation animation) {
                    this.psK.gU(true);
                    this.psK.prz = false;
                    if (!this.psK.prv) {
                        this.psK.pry = true;
                        this.psK.gX(true);
                        this.psK.bbC();
                        if (this.psK.prE.pop == 3) {
                            com.tencent.mm.am.b.HH();
                        } else if (this.psK.prE.pop == 5) {
                            l.b bVar = this.psK.prE.poq;
                            if (bVar != null && (bVar instanceof h)) {
                                h hVar = (h) bVar;
                                Collection arrayList = new ArrayList();
                                arrayList.addAll(ShakeReportUI.gKn);
                                hVar.pql = arrayList;
                            }
                        }
                        this.psK.prE.poq.start();
                    }
                    this.psK.prw = false;
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (shakeReportUI.prQ == null) {
            shakeReportUI.prQ = AnimationUtils.loadAnimation(shakeReportUI.uSU.uTo, R.a.aRS);
        }
        if (shakeReportUI.prR == null) {
            shakeReportUI.prR = AnimationUtils.loadAnimation(shakeReportUI.uSU.uTo, R.a.aRE);
        }
        if (!(shakeReportUI.prS == null || shakeReportUI.prJ == null)) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(shakeReportUI.prJ, shakeReportUI.prS);
        }
        shakeReportUI.sE(3);
        shakeReportUI.prN.startAnimation(shakeReportUI.prR);
        shakeReportUI.prO.startAnimation(shakeReportUI.prR);
        shakeReportUI.prN.setVisibility(0);
        shakeReportUI.prO.setVisibility(0);
        shakeReportUI.prI.setVisibility(4);
        shakeReportUI.prL.startAnimation(shakeReportUI.prP);
        shakeReportUI.prM.startAnimation(shakeReportUI.prQ);
        if (shakeReportUI.prG != null && shakeReportUI.prG.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.uSU.uTo, R.a.aRH);
            loadAnimation.setFillAfter(true);
            shakeReportUI.prG.startAnimation(loadAnimation);
            new ae().postDelayed(new Runnable(shakeReportUI) {
                final /* synthetic */ ShakeReportUI psK;

                {
                    this.psK = r1;
                }

                public final void run() {
                    if (this.psK.prG != null) {
                        this.psK.prG.setVisibility(8);
                    }
                }
            }, loadAnimation.getDuration());
        }
        shakeReportUI.prB = false;
        new ae().postDelayed(new Runnable(shakeReportUI) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void run() {
                if (this.psK.prN != null) {
                    this.psK.prN.setVisibility(8);
                }
                if (this.psK.prO != null) {
                    this.psK.prO.setVisibility(8);
                }
                if (this.psK.prI != null) {
                    this.psK.prI.setVisibility(0);
                }
                if (!this.psK.prB && !this.psK.prv) {
                    this.psK.sE(1);
                }
            }
        }, 1200);
    }

    protected final int getLayoutId() {
        return R.i.doq;
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        zi(R.l.eVJ);
        this.gKi = c.Gk();
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAx, "");
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAy, "");
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCN, "");
        this.psv = findViewById(R.h.cEg);
        bg zL = bg.zL();
        String mz = com.tencent.mm.sdk.platformtools.bg.mz(zL.hnP);
        String mz2 = com.tencent.mm.sdk.platformtools.bg.mz(zL.hnO);
        String z = com.tencent.mm.i.g.sW().z("IBeacon", "GatedLaunch");
        if (com.tencent.mm.sdk.platformtools.bg.mA(z)) {
            z = null;
        }
        this.psB = false;
        this.psC = false;
        if (z != null) {
            try {
                JSONObject jSONObject = new JSONObject(z);
                i = jSONObject.getInt("gatedlaunch");
                ap.zb();
                if (i != 0) {
                    JSONArray jSONArray;
                    int length;
                    String string;
                    int i3;
                    JSONArray jSONArray2;
                    if (i == 1) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(mz) && i3 == 1) {
                                this.psB = true;
                            } else if (string.equals(mz) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(mz2)) {
                                        this.psB = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 2) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(mz) && i3 == 1) {
                                this.psC = true;
                                this.psB = true;
                            } else if (string.equals(mz) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(mz2)) {
                                        this.psC = true;
                                        this.psB = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 3) {
                        this.psB = true;
                        this.psC = false;
                    } else if (i == 4) {
                        this.psB = true;
                        this.psC = true;
                    }
                }
            } catch (JSONException e) {
                w.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
                this.psB = false;
                this.psC = false;
            }
        }
        if (ap.zb()) {
            ap.yY();
            if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCF, Integer.valueOf(0))).intValue() == 1) {
                this.psD = true;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean hasSystemFeature = ab.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter == null || !hasSystemFeature || VERSION.SDK_INT < 18 || defaultAdapter.getState() != 12) {
            this.psE = 1;
        } else {
            this.psE = 0;
        }
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (hasSystemFeature) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.psB) {
            g.oUh.i(13139, new Object[]{mz, mz2, Integer.valueOf(1), Integer.valueOf(this.psE), Integer.valueOf(i2), Integer.valueOf(i)});
        } else {
            g.oUh.i(13139, new Object[]{mz, mz2, Integer.valueOf(0), Integer.valueOf(this.psE), Integer.valueOf(i2), Integer.valueOf(i)});
        }
        if (this.psD || this.psB) {
            this.psA = true;
            this.psv = findViewById(R.h.cEj);
            if (this.psC) {
                if (defaultAdapter == null || defaultAdapter.getState() != 12) {
                    this.psA = false;
                } else if (defaultAdapter != null) {
                    defaultAdapter.getState();
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.f baX = m.baX();
        if (baX.kcI == null) {
            baX.kcI = new ArrayList();
        }
        if (this != null) {
            baX.kcI.add(new WeakReference(this));
        }
        Boolean valueOf = Boolean.valueOf(false);
        long Ny = com.tencent.mm.sdk.platformtools.bg.Ny();
        long j = 0;
        long j2 = 0;
        if (ap.zb()) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCC, Boolean.valueOf(true));
            ap.yY();
            Boolean valueOf2 = Boolean.valueOf(com.tencent.mm.sdk.platformtools.bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCA, null), false));
            ap.yY();
            j = com.tencent.mm.sdk.platformtools.bg.a((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCB, null), 0);
            ap.yY();
            j2 = com.tencent.mm.sdk.platformtools.bg.a((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCv, null), 0);
            valueOf = valueOf2;
        }
        if (!valueOf.booleanValue() || Ny - r6 >= r4) {
            KC();
        } else {
            this.psk = 5;
            this.psA = true;
            this.pry = true;
            KC();
            bbC();
            ap.yY();
            String ap = com.tencent.mm.sdk.platformtools.bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCz, null), "");
            ap.yY();
            z = com.tencent.mm.sdk.platformtools.bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCy, null), "");
            if (!(z == null || z.equals(""))) {
                String[] split = z.split(",");
                d dVar = new d();
                dVar.field_type = 11;
                dVar.field_username = split[0];
                dVar.field_nickname = split[0];
                dVar.field_signature = split[1];
                dVar.field_province = split[2];
                dVar.field_city = split[3];
                dVar.field_sex = 1;
                try {
                    dVar.field_lvbuffer = (String.valueOf(split[4]) + "," + String.valueOf(split[5]) + "," + String.valueOf(split[6])).getBytes(ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e2) {
                    w.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
                }
                dVar.field_insertBatch = 2;
                e baS = m.baS();
                baS.baK();
                baS.a(dVar, true);
                List linkedList = new LinkedList();
                linkedList.add(dVar);
                d(linkedList, 1);
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCy, "");
                z = ap + "," + split[4] + split[5] + split[6];
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCz, z);
            }
        }
        this.prD = new c(this.uSU.uTa);
        this.nVn = new com.tencent.mm.pluginsdk.m.c(this);
        if (!this.nVn.bDP()) {
            com.tencent.mm.ui.base.g.a(this, R.l.eVI, R.l.dIO, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ShakeReportUI psK;

                {
                    this.psK = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.psK.finish();
                }
            });
        }
        if (com.tencent.mm.plugin.shake.a.imw != null) {
            com.tencent.mm.plugin.shake.a.imw.ou();
        }
        j.b(this);
        w.i("MicroMsg.ShakeReportUI", "%s", new Object[]{getResources().getDisplayMetrics().toString()});
        i = m.baT().Kr();
        g.oUh.i(11317, new Object[]{Integer.valueOf(i), e.bbN()});
        g.oUh.i(11710, new Object[]{Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        if (this.oIa) {
            w.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")), com.tencent.mm.sdk.platformtools.bg.bJZ(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                aVK();
            }
        }
    }

    private void aVK() {
        bbB();
        ap.yY();
        com.tencent.mm.u.c.a(this);
        ap.yY();
        com.tencent.mm.u.c.vr().a(this);
        m.baS().c(this);
        if (this.prE.poq != null) {
            this.prE.poq.resume();
        }
        this.prA = true;
        if (!(this.psx == null || !this.psx.isShowing() || this.psx.ppz)) {
            this.prA = false;
        }
        w.i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (!(this.nVn == null || this.nVn.bDN())) {
            this.nVn.a(new a(this));
            if (!this.nVn.bDP() || this.prI == null) {
                this.prI.setText(getString(R.l.eVI));
            } else {
                this.prI.setText(getString(R.l.eUW));
            }
        }
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void run() {
                if (this.psK.nVn != null) {
                    this.psK.nVn.bDO();
                }
            }
        }, 1000);
        if (this.nVn != null) {
            this.nVn.bDO();
        }
        gW(false);
        gX(false);
        bbD();
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(327696, "1");
        if (k.baQ()) {
            if (this.psk == 4) {
                gT(true);
            }
            if (str.equals("4")) {
                cm(findViewById(R.h.cEo));
            }
        }
        if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            cm(findViewById(R.h.cEl));
        } else if (str.equals("6") && com.tencent.mm.plugin.shake.c.c.a.bbq()) {
            cm(findViewById(R.h.cEb));
        }
        boolean aD = com.tencent.mm.q.c.uk().aD(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && com.tencent.mm.am.c.HQ() && this.prE.pop != 3) {
            getIntent().putExtra("shake_music", false);
            this.psk = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.prE.pop != 4 && k.baQ()) {
            getIntent().putExtra("shake_tv", false);
            this.psk = 4;
        } else if (this.prE.pop != 6 && com.tencent.mm.plugin.shake.c.c.a.bbq() && (aD || getIntent().getBooleanExtra("shake_card", false))) {
            this.psw = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            w.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.psk = 6;
        }
        bbC();
        gU(true);
        w.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[]{Boolean.valueOf(r.iiM)});
        if (r.iiM) {
            ap.vd().a(new com.tencent.mm.ap.k(7), 0);
        }
        gY(true);
        bbJ();
        bbz();
    }

    protected void onPause() {
        ap.yY();
        com.tencent.mm.u.c.b(this);
        ap.yY();
        com.tencent.mm.u.c.vr().b(this);
        m.baS().f(this);
        if (this.prE.poq != null) {
            this.prE.poq.pause();
        }
        this.prA = false;
        if (this.nVn != null) {
            this.nVn.aAA();
        }
        this.prD.bbx();
        if (this.psk != 5) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(327696, this.psk);
        }
        if (this.psk == 4) {
            gT(false);
        }
        bbA();
        super.onPause();
    }

    protected void onDestroy() {
        if (!(this.prZ == null || this.prZ.isRecycled())) {
            this.prZ.recycle();
        }
        if (this.psa != null && this.psa.isShowing()) {
            this.psa.dismiss();
            this.psa = null;
        }
        if (this.prE.poq != null) {
            this.prE.poq.baF();
        }
        if (this.nVn != null) {
            this.nVn.aAA();
            this.nVn = null;
        }
        com.tencent.mm.plugin.shake.d.a.j a = com.tencent.mm.plugin.shake.d.a.j.a(null);
        if (com.tencent.mm.plugin.shake.d.a.j.nGp) {
            com.tencent.mm.plugin.shake.d.a.j.nGp = false;
            if (!a.pqu.bbs()) {
                w.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        com.tencent.mm.plugin.shake.d.a.j.pqv = null;
        j.c(this);
        com.tencent.mm.sdk.b.a.urY.c(this.psH);
        com.tencent.mm.sdk.b.a.urY.c(this.psI);
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCC, Boolean.valueOf(false));
        bbA();
        if (com.tencent.mm.plugin.shake.c.c.a.bbq()) {
            com.tencent.mm.q.c.uk().t(262154, false);
        }
        bbG();
        com.tencent.mm.plugin.shake.c.a.f baX = m.baX();
        if (baX.kcI != null && this != null) {
            for (int i = 0; i < baX.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) baX.kcI.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.shake.c.a.f.a aVar = (com.tencent.mm.plugin.shake.c.a.f.a) weakReference.get();
                    if (aVar != null && aVar.equals(this)) {
                        baX.kcI.remove(weakReference);
                        break;
                    }
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.d baY = m.baY();
        baY.gKj = -85.0f;
        baY.gKk = -1000.0f;
        if (this.gKi != null) {
            this.gKi.c(this.gKp);
        }
        super.onDestroy();
    }

    private void bbz() {
        if (bbL() && BluetoothAdapter.getDefaultAdapter() != null) {
            List<String> sJ = com.tencent.mm.i.g.sW().sJ();
            if (sJ != null) {
                this.psF = System.currentTimeMillis();
                for (String str : sJ) {
                    w.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[]{str});
                    com.tencent.mm.sdk.b.b dfVar = new df();
                    dfVar.fHa.fHc = str;
                    dfVar.fHa.fGZ = true;
                    com.tencent.mm.sdk.b.a.urY.m(dfVar);
                }
            }
        }
    }

    private void bbA() {
        ap.yY();
        if (!Boolean.valueOf(com.tencent.mm.sdk.platformtools.bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCC, null), false)).booleanValue()) {
            this.gKm.clear();
            gKn = new CopyOnWriteArrayList();
        }
        if (VERSION.SDK_INT >= 18) {
            List<String> sJ = com.tencent.mm.i.g.sW().sJ();
            if (sJ != null) {
                for (String str : sJ) {
                    com.tencent.mm.sdk.b.b dfVar = new df();
                    w.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[]{str});
                    dfVar.fHa.fHc = str;
                    dfVar.fHa.fGZ = false;
                    com.tencent.mm.sdk.b.a.urY.m(dfVar);
                }
            }
        }
    }

    protected final void KC() {
        com.tencent.mm.plugin.shake.c.c.a.baM();
        this.psz.put(Integer.valueOf(1), Boolean.valueOf(true));
        this.psz.put(Integer.valueOf(3), Boolean.valueOf(false));
        this.psz.put(Integer.valueOf(4), Boolean.valueOf(false));
        this.psz.put(Integer.valueOf(5), Boolean.valueOf(false));
        this.psz.put(Integer.valueOf(6), Boolean.valueOf(false));
        this.hHR = new com.tencent.mm.ah.a.a(this);
        this.prI = (TextView) findViewById(R.h.cDZ);
        this.prH = findViewById(R.h.cEp);
        this.prJ = (TextView) findViewById(R.h.cDU);
        this.prK = (TextView) findViewById(R.h.cDY);
        this.psm = findViewById(R.h.cED);
        this.psn = (ImageView) findViewById(R.h.cEr);
        this.pso = (ImageView) findViewById(R.h.cEt);
        this.psp = (ImageView) findViewById(R.h.cEv);
        this.psq = (ImageView) findViewById(R.h.cEx);
        this.psr = findViewById(R.h.cEs);
        this.pss = findViewById(R.h.cEu);
        this.pst = findViewById(R.h.cEw);
        this.psu = findViewById(R.h.cEy);
        this.prG = findViewById(R.h.cDX);
        this.prG.setOnClickListener(this.psJ);
        this.ioV = (ImageView) this.prG.findViewById(R.h.cDJ);
        this.ioV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void onClick(View view) {
                if (this.psK.psk != 5) {
                    this.psK.prF = new f(this.psK, (String) this.psK.prG.getTag(), null, com.tencent.mm.pluginsdk.ui.f.a.sIT);
                    this.psK.prF.bEf();
                }
            }
        });
        bbB();
        View inflate = View.inflate(this.uSU.uTo, R.i.don, null);
        this.psa = new i(this.uSU.uTo, R.m.foK);
        this.psa.setContentView(inflate);
        this.psa.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                    final /* synthetic */ AnonymousClass4 psL;

                    {
                        this.psL = r1;
                    }

                    public final boolean queueIdle() {
                        s.a(this.psL.psK, 0, this.psL.psK.getString(R.l.eVS));
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(4117, Boolean.valueOf(true));
                        return false;
                    }
                });
            }
        });
        ((Button) inflate.findViewById(R.h.cDD)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void onClick(View view) {
                this.psK.psa.cancel();
            }
        });
        ap.yY();
        boolean f = com.tencent.mm.sdk.platformtools.bg.f((Boolean) com.tencent.mm.u.c.vr().get(4108, null));
        ap.yY();
        boolean f2 = com.tencent.mm.sdk.platformtools.bg.f((Boolean) com.tencent.mm.u.c.vr().get(4117, null));
        if (!f) {
            inflate.setVisibility(0);
            this.psa.show();
            ap.yY();
            com.tencent.mm.u.c.vr().set(4108, Boolean.valueOf(true));
        } else if (!f2) {
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ ShakeReportUI psK;

                {
                    this.psK = r1;
                }

                public final boolean queueIdle() {
                    s.a(this.psK, 0, this.psK.getString(R.l.eVS));
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(4117, Boolean.valueOf(true));
                    return false;
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.psK.pry = false;
                this.psK.finish();
                return true;
            }
        });
        a(0, R.l.dBQ, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.psK.pry = false;
                Intent intent = new Intent();
                intent.setClass(this.psK, ShakePersonalInfoUI.class);
                this.psK.startActivityForResult(intent, 3);
                return true;
            }
        });
        OnClickListener anonymousClass29 = new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void onClick(View view) {
                this.psK.cm(view);
            }
        };
        if (this.psD || this.psB) {
            this.psb = (ImageView) findViewById(R.h.cEi);
        } else {
            this.psb = (ImageView) findViewById(R.h.cEh);
        }
        this.psd = (ImageView) findViewById(R.h.cEe);
        this.pse = (ImageView) findViewById(R.h.cEk);
        this.psf = (ImageView) findViewById(R.h.cEn);
        this.psg = (ImageView) findViewById(R.h.cEa);
        this.psj = (TextView) findViewById(R.h.cEd);
        this.psi = (ImageView) findViewById(R.h.cEc);
        this.psh = (ImageView) findViewById(R.h.cEm);
        bbI();
        this.psv.setOnClickListener(anonymousClass29);
        findViewById(R.h.cEj).setOnClickListener(anonymousClass29);
        findViewById(R.h.cEf).setOnClickListener(anonymousClass29);
        findViewById(R.h.cEl).setOnClickListener(anonymousClass29);
        findViewById(R.h.cEo).setOnClickListener(anonymousClass29);
        findViewById(R.h.cEb).setOnClickListener(anonymousClass29);
        com.tencent.mm.sdk.b.a.urY.b(this.psH);
        com.tencent.mm.sdk.b.a.urY.b(this.psI);
        bbE();
        bbH();
        gY(true);
    }

    private void bbB() {
        ap.yY();
        int a = com.tencent.mm.sdk.platformtools.bg.a((Integer) com.tencent.mm.u.c.vr().get(12290, null), 0);
        ImageView imageView = (ImageView) findViewById(R.h.cDV);
        if (!(this.prZ == null || this.prZ.isRecycled())) {
            this.prZ.recycle();
        }
        ap.yY();
        if (com.tencent.mm.sdk.platformtools.bg.e((Boolean) com.tencent.mm.u.c.vr().get(4110, null))) {
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xb()).append("default_shake_img_filename.jpg").toString();
            if (com.tencent.mm.a.e.aO(stringBuilder2)) {
                this.prZ = j.mt(stringBuilder2);
                imageView.setImageDrawable(new BitmapDrawable(this.prZ));
            } else {
                Drawable bitmapDrawable;
                try {
                    bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.decodeStream(this.uSU.uTo.getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e) {
                    w.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            ap.yY();
            this.prZ = j.mt((String) com.tencent.mm.u.c.vr().get(4111, null));
            imageView.setImageDrawable(new BitmapDrawable(this.prZ));
        }
        imageView = (ImageView) findViewById(R.h.bjN);
        ImageView imageView2 = (ImageView) findViewById(R.h.bjK);
        imageView.setImageResource(a == 2 ? R.g.bjM : R.g.bjN);
        imageView2.setImageResource(a == 2 ? R.g.bjL : R.g.bjK);
        OnClickListener anonymousClass7 = new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void onClick(View view) {
                if (this.psK.prw) {
                    this.psK.prA = false;
                    this.psK.prv = true;
                    this.psK.gX(false);
                    com.tencent.mm.ui.base.g.a(this.psK.uSU.uTo, null, new String[]{this.psK.getString(R.l.eVu)}, "", new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass7 psM;

                        {
                            this.psM = r1;
                        }

                        public final void hq(int i) {
                            this.psM.psK.prA = true;
                            switch (i) {
                                case 0:
                                    com.tencent.mm.pluginsdk.ui.tools.k.a(this.psM.psK, 1, null);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass7 psM;

                        {
                            this.psM = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.psM.psK.prA = true;
                        }
                    });
                }
            }
        };
        imageView.setOnClickListener(anonymousClass7);
        imageView2.setOnClickListener(anonymousClass7);
        if (this.prN == null) {
            this.prN = findViewById(R.h.cDG);
        }
        this.prN.setOnClickListener(anonymousClass7);
        if (this.prO == null) {
            this.prO = findViewById(R.h.cDH);
        }
        this.prO.setOnClickListener(anonymousClass7);
    }

    private void gT(boolean z) {
        String format = String.format("%1$s-shaketype-%2$d", new Object[]{getClass().getName(), Integer.valueOf(4)});
        w.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        x.a(z, new Intent().putExtra("classname", format));
    }

    private void bbC() {
        l.b bVar;
        if (this.psk == 3 && com.tencent.mm.am.c.HQ()) {
            this.psk = 3;
            this.prK.setText(R.l.eVQ);
            this.psb.setBackgroundResource(R.g.bjC);
            this.psd.setBackgroundResource(R.g.bjG);
            this.pse.setBackgroundResource(R.g.bjF);
            this.psf.setBackgroundResource(R.g.bjI);
            this.psg.setBackgroundResource(R.g.bjA);
            findViewById(R.h.cDW).setVisibility(0);
            zi(R.l.eVM);
            g.oUh.i(11720, new Object[]{Integer.valueOf(2)});
        } else if (this.psk == 4 && k.baQ()) {
            this.psk = 4;
            this.prK.setText(R.l.eVR);
            this.psb.setBackgroundResource(R.g.bjC);
            this.psd.setBackgroundResource(R.g.bjG);
            this.pse.setBackgroundResource(R.g.bjE);
            this.psf.setBackgroundResource(R.g.bjJ);
            this.psg.setBackgroundResource(R.g.bjA);
            findViewById(R.h.cDW).setVisibility(0);
            zi(R.l.eVN);
            g.oUh.i(11720, new Object[]{Integer.valueOf(3)});
        } else if (this.psk == 5 && bbK()) {
            this.psk = 5;
            this.prK.setText(R.l.eVP);
            this.psb.setBackgroundResource(R.g.bjD);
            this.psd.setBackgroundResource(R.g.bjG);
            this.pse.setBackgroundResource(R.g.bjE);
            this.psf.setBackgroundResource(R.g.bjI);
            this.psg.setBackgroundResource(R.g.bjA);
            findViewById(R.h.cDW).setVisibility(0);
            zi(R.l.eVL);
            g.oUh.i(11720, new Object[]{Integer.valueOf(4)});
        } else if (this.psk == 6 && com.tencent.mm.plugin.shake.c.c.a.bbq()) {
            this.psk = 6;
            this.prK.setText(R.l.eVO);
            this.psb.setBackgroundResource(R.g.bjC);
            this.psd.setBackgroundResource(R.g.bjG);
            this.pse.setBackgroundResource(R.g.bjE);
            this.psf.setBackgroundResource(R.g.bjI);
            this.psg.setBackgroundResource(R.g.bjB);
            findViewById(R.h.cDW).setVisibility(0);
            zi(R.l.eVK);
            bbF();
            bbI();
            g.oUh.i(11720, new Object[]{Integer.valueOf(5)});
        } else {
            this.psk = 1;
            this.prK.setText(R.l.eVd);
            this.psb.setBackgroundResource(R.g.bjC);
            this.psd.setBackgroundResource(R.g.bjH);
            this.pse.setBackgroundResource(R.g.bjE);
            this.psf.setBackgroundResource(R.g.bjI);
            this.psg.setBackgroundResource(R.g.bjA);
            if (com.tencent.mm.am.c.HQ()) {
                findViewById(R.h.cDW).setVisibility(0);
            }
            zi(R.l.eVJ);
            g.oUh.i(11720, new Object[]{Integer.valueOf(1)});
        }
        l lVar = this.prE;
        int i = this.psk;
        if (i == lVar.pop) {
            bVar = lVar.poq;
        } else {
            if (lVar.poq != null) {
                lVar.poq.baF();
            }
            switch (i) {
                case 1:
                    lVar.poq = new com.tencent.mm.plugin.shake.b.c(this, this);
                    break;
                case 3:
                    lVar.poq = com.tencent.mm.plugin.shake.d.a.j.a((com.tencent.mm.plugin.shake.b.l.a) this);
                    break;
                case 4:
                    lVar.poq = new com.tencent.mm.plugin.shake.d.a.l(this, this);
                    break;
                case 5:
                    lVar.poq = new h(this);
                    break;
                case 6:
                    lVar.poq = new com.tencent.mm.plugin.shake.c.a.g(this);
                    break;
            }
            lVar.pop = i;
            lVar.poq.init();
            bVar = lVar.poq;
        }
        if (!this.pry) {
            gX(false);
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bbq() && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
            com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
            int i2 = this.psw;
            gVar.jZM = i2;
            w.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:" + i2);
            if (this.psw == 3) {
                w.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                com.tencent.mm.plugin.shake.c.a.g gVar2 = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                String stringExtra = getIntent().getStringExtra("key_shake_card_ext_info");
                if (stringExtra == null || stringExtra.length() > 256) {
                    w.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:" + stringExtra);
                    return;
                }
                w.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + gVar2.mFM);
                gVar2.mFM = stringExtra;
            }
        }
    }

    private void bbD() {
        ap.yY();
        this.prx = com.tencent.mm.sdk.platformtools.bg.e((Boolean) com.tencent.mm.u.c.vr().get(4112, null));
        if (this.prx) {
            zo(8);
        } else {
            zo(0);
        }
    }

    private void gU(boolean z) {
        com.tencent.mm.plugin.shake.b.f fVar = null;
        gV(z);
        if (this.prU == null) {
            this.prU = findViewById(R.h.bVx);
        }
        if (z) {
            if (m.baT().Kr() <= 0) {
                this.prU.setVisibility(8);
                return;
            }
            if (this.prW == null) {
                this.prW = (TextView) this.prU.findViewById(R.h.cDN);
            }
            this.prW.setText(getString(R.l.eVB, new Object[]{Integer.valueOf(r2)}));
            this.prU.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShakeReportUI psK;

                {
                    this.psK = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.psK, ShakeMsgListUI.class);
                    intent.putExtra("shake_msg_from", 1);
                    intent.putExtra("shake_msg_list_title", this.psK.getString(R.l.eWa));
                    this.psK.startActivity(intent);
                }
            });
            if (this.prV == null) {
                this.prV = (MMImageView) findViewById(R.h.cDT);
            }
            com.tencent.mm.plugin.shake.b.g baT = m.baT();
            Cursor a = baT.gUz.a("SELECT * FROM " + baT.getTableName() + " where status != 1 ORDER BY rowid" + " DESC LIMIT 1", null, 2);
            if (a != null) {
                com.tencent.mm.plugin.shake.b.f fVar2;
                if (a.moveToFirst()) {
                    fVar2 = new com.tencent.mm.plugin.shake.b.f();
                    fVar2.b(a);
                } else {
                    fVar2 = null;
                }
                a.close();
                fVar = fVar2;
            }
            if (fVar != null) {
                String str = fVar.field_thumburl;
                if (com.tencent.mm.sdk.platformtools.bg.mA(str)) {
                    this.prV.setImageResource(R.k.dtu);
                } else {
                    Object bVar = new com.tencent.mm.plugin.shake.e.b(str);
                    Bitmap a2 = j.a(bVar);
                    this.prV.setTag(bVar.No());
                    if (a2 == null || a2.isRecycled()) {
                        this.prV.setImageResource(R.k.dtu);
                    } else {
                        this.prV.setImageBitmap(a2);
                    }
                }
            }
            this.prU.setVisibility(0);
            return;
        }
        this.prU.setVisibility(8);
    }

    private void gV(boolean z) {
        if (this.prT == null) {
            this.prT = findViewById(R.h.bVw);
        }
        if (this.prE.pop == 3 || this.prE.pop == 4 || this.prE.pop == 5 || this.prE.pop == 6 || !z) {
            this.prT.setVisibility(8);
            return;
        }
        int Kr = com.tencent.mm.av.l.KA().Kr();
        if (Kr <= 0) {
            this.prT.setVisibility(8);
            return;
        }
        this.prT.setVisibility(0);
        ((TextView) this.prT.findViewById(R.h.czG)).setText(getResources().getQuantityString(R.j.dsD, Kr, new Object[]{Integer.valueOf(Kr)}));
        this.prT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.psK, ShakeSayHiListUI.class);
                intent.putExtra("IntentSayHiType", 1);
                this.psK.startActivity(intent);
            }
        });
        if (this.prX == null) {
            this.prX = (ImageView) findViewById(R.h.cjn);
        }
        com.tencent.mm.av.j Kv = com.tencent.mm.av.l.KA().Kv();
        if (Kv != null) {
            this.prY = Kv.field_sayhiuser;
            com.tencent.mm.pluginsdk.ui.a.b.a(this.prX, this.prY);
        }
    }

    private void gW(boolean z) {
        if (this.prJ == null) {
            return;
        }
        if (z) {
            this.prJ.setVisibility(0);
            return;
        }
        this.prJ.setVisibility(8);
        this.prJ.cancelLongPress();
    }

    private void gX(boolean z) {
        if (this.prH == null) {
            return;
        }
        if (z) {
            this.prH.setVisibility(0);
        } else {
            this.prH.setVisibility(4);
        }
    }

    private void sE(int i) {
        gX(i == 1);
        if (i == 2) {
            gW(true);
        } else {
            gW(false);
        }
    }

    public final void yP() {
        bbC();
    }

    private void Em(String str) {
        this.pry = false;
        if (this.prx) {
            aq.B(this.uSU.uTo, R.l.eVH);
        }
        if (this.prS == null) {
            this.prS = AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aQW);
        }
        sE(2);
        if (str == null || str.length() <= 1) {
            this.prJ.setText(R.l.eVj);
        } else {
            this.prJ.setText(str);
        }
        this.prJ.startAnimation(this.prS);
        this.prB = true;
        com.tencent.mm.sdk.platformtools.af.f(new Runnable(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void run() {
                this.psK.gW(false);
                this.psK.gX(false);
            }
        }, this.prS.getDuration());
    }

    public final void d(List<d> list, long j) {
        gY(true);
        if (list == null || !this.pry || j == 6) {
            this.psc = null;
            if (j == 6) {
                Em(getString(R.l.eVr));
                return;
            } else if (j == 7) {
                Em(getString(R.l.eVp));
                return;
            } else if (j == 8) {
                Em(getString(R.l.eVn));
                return;
            } else if (j == 9) {
                Em(getString(R.l.eVm));
                return;
            } else if (j == 10) {
                Em(getString(R.l.eVq));
                return;
            } else {
                Em(null);
                return;
            }
        }
        this.pry = false;
        if (list.size() > 0) {
            this.psc = (d) list.get(0);
        }
        int size;
        d dVar;
        Intent intent;
        if (this.prE.pop == 1) {
            if (list.size() <= 0 || ((d) list.get(0)).field_type == 0) {
                this.prC = ((d) list.get(0)).scene;
                size = list.size();
                if (size == 0) {
                    Em(null);
                    return;
                } else if (size == 1) {
                    w.i("MicroMsg.ShakeReportUI", "1 u:" + ((d) list.get(0)).field_username + " n:" + ((d) list.get(0)).field_nickname + " d:" + ((d) list.get(0)).field_distance);
                    if (this.prx) {
                        aq.B(this.uSU.uTo, R.l.eVz);
                    }
                    sE(3);
                    dVar = (d) list.get(0);
                    if (!com.tencent.mm.sdk.platformtools.bg.mA(dVar.field_username)) {
                        this.prG.setTag(dVar.field_username);
                        this.prG.setVisibility(0);
                        ap.yY();
                        af Rc = com.tencent.mm.u.c.wR().Rc(dVar.field_username);
                        String str = dVar.field_nickname + (com.tencent.mm.j.a.ez(Rc.field_type) ? getString(R.l.eVA) : "");
                        if (dVar.field_sex == 1) {
                            this.prG.setContentDescription(str + dVar.field_distance + this.uSU.uTo.getString(R.l.eVV));
                        } else if (dVar.field_sex == 2) {
                            this.prG.setContentDescription(str + dVar.field_distance + this.uSU.uTo.getString(R.l.eVU));
                        } else {
                            this.prG.setContentDescription(str + dVar.field_distance);
                        }
                        TextView textView = (TextView) this.prG.findViewById(R.h.cDK);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.uSU.uTo, dVar.field_nickname + (com.tencent.mm.j.a.ez(Rc.field_type) ? getString(R.l.eVA) : ""), textView.getTextSize()));
                        if (this.ioV != null) {
                            if (com.tencent.mm.sdk.platformtools.bg.mA(str)) {
                                this.ioV.setContentDescription(getString(R.l.eUZ));
                            } else {
                                this.ioV.setContentDescription(String.format(getString(R.l.eUY), new Object[]{str}));
                            }
                        }
                        ((TextView) this.prG.findViewById(R.h.cDI)).setText(dVar.field_distance);
                        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) this.prG.findViewById(R.h.cDJ), dVar.field_username);
                        ImageView imageView = (ImageView) this.prG.findViewById(R.h.cDM);
                        if (dVar.field_reserved1 != 0) {
                            imageView.setVisibility(0);
                            imageView.setImageBitmap(BackwardSupportUtil.b.c(com.tencent.mm.u.ag.a.hlU.eY(dVar.field_reserved1), 2.0f));
                        } else {
                            imageView.setVisibility(8);
                        }
                        if (dVar.field_reserved1 != 0 || dVar.field_sex == 0) {
                            this.prG.findViewById(R.h.cDL).setVisibility(8);
                        } else {
                            Drawable a = com.tencent.mm.bg.a.a(this, dVar.field_sex == 1 ? R.k.dxs : R.k.dxr);
                            this.prG.findViewById(R.h.cDL).setVisibility(0);
                            ((ImageView) this.prG.findViewById(R.h.cDL)).setImageDrawable(a);
                        }
                        if (dVar.getProvince() == null) {
                            w.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
                            dVar.field_province = "";
                        }
                        if (dVar.getCity() == null) {
                            w.e("MicroMsg.ShakeReportUI", "CITY NULL");
                            dVar.field_city = "";
                        }
                        this.prG.startAnimation(AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aRG));
                        return;
                    }
                    return;
                } else {
                    if (this.prx) {
                        aq.B(this.uSU.uTo, R.l.eVz);
                    }
                    sE(3);
                    gV(false);
                    intent = new Intent(this, ShakeItemListUI.class);
                    intent.putExtra("_key_show_type_", -1);
                    intent.putExtra("_key_title_", getString(R.l.eVy));
                    startActivity(intent);
                    return;
                }
            }
            Em(null);
        } else if (this.prE.pop == 3) {
            size = list.size();
            if (size == 0) {
                Em(getString(R.l.eVG));
            } else if (size == 1) {
                if (this.prx) {
                    aq.B(this.uSU.uTo, R.l.eVz);
                }
                sE(3);
                if (((d) list.get(0)).field_type == 4) {
                    anf a2 = com.tencent.mm.plugin.shake.d.a.i.a(((d) list.get(0)).field_lvbuffer, j);
                    com.tencent.mm.am.b.c(a2);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    intent2.putExtra("key_offset", a2.tRI);
                    intent2.putExtra("music_player_beg_time", a2.pRp);
                    intent2.putExtra("key_scene", 3);
                    if (com.tencent.mm.am.c.HR()) {
                        intent2.putExtra("KGlobalShakeMusic", true);
                    }
                    com.tencent.mm.bb.d.b(this, "music", ".ui.MusicMainUI", intent2);
                    return;
                }
                w.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
            }
        } else if (this.prE.pop == 4) {
            gY(true);
            size = list.size();
            if (size == 0) {
                Em(getString(R.l.eWb));
            } else if (size == 1) {
                if (this.prx) {
                    aq.B(this.uSU.uTo, R.l.eVz);
                }
                sE(3);
                new ae().postDelayed(new 1((d) list.get(0), this), 100);
            }
        } else if (this.prE.pop == 5) {
            switch ((int) j) {
                case 1:
                    if (list.isEmpty() || ((d) list.get(0)).field_type != 11) {
                        Em(null);
                        return;
                    } else if (list.size() == 1) {
                        if (this.prx) {
                            aq.B(this.uSU.uTo, R.l.eVz);
                        }
                        sE(3);
                        dVar = (d) list.get(0);
                        if (!com.tencent.mm.sdk.platformtools.bg.mA(dVar.field_username)) {
                            this.prG.setTag(dVar.field_username);
                            ((TextView) this.prG.findViewById(R.h.cDK)).setText(dVar.field_username);
                            this.prG.setContentDescription(com.tencent.mm.sdk.platformtools.bg.mz(dVar.field_nickname));
                            ((TextView) this.prG.findViewById(R.h.cDI)).setText(dVar.field_signature);
                            this.hHR.a(dVar.getProvince(), (ImageView) this.prG.findViewById(R.h.cDJ));
                            this.prG.findViewById(R.h.cDL).setVisibility(8);
                            this.prG.startAnimation(AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aRG));
                            this.prG.setVisibility(0);
                            return;
                        }
                        return;
                    } else {
                        if (this.prx) {
                            aq.B(this.uSU.uTo, R.l.eVz);
                        }
                        sE(3);
                        gV(false);
                        intent = new Intent(this, ShakeItemListUI.class);
                        intent.putExtra("_key_show_type_", -12);
                        intent.putExtra("_key_title_", getString(R.l.eVx));
                        intent.putExtra("_key_show_from_shake_", true);
                        intent.putExtra("_ibeacon_new_insert_size", list.size());
                        startActivity(intent);
                        return;
                    }
                case 6:
                    Em(getString(R.l.eVr));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, final com.tencent.mm.plugin.shake.c.a.e eVar, long j) {
        this.psy = true;
        if (i == 1251) {
            if (eVar != null) {
                w.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
                com.tencent.mm.plugin.shake.c.c.a.baM();
                bbJ();
                bbE();
                bbH();
                this.psw = 4;
                m.baY().putValue("key_shake_card_item", eVar);
            }
        } else if (i != 1250) {
        } else {
            if (eVar == null) {
                this.psc = null;
                Em(null);
            } else if ((eVar == null || this.pry) && !this.pry) {
                this.psc = null;
                Em(null);
            } else {
                this.pry = false;
                w.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                if (this.prE.pop == 6) {
                    l.b bVar = this.prE.poq;
                    if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
                        com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                        switch ((int) j) {
                            case 1:
                                w.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                if (gVar.kfr == 3) {
                                    w.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                    if (eVar == null || TextUtils.isEmpty(eVar.poT)) {
                                        Em(getString(R.l.eVa));
                                        return;
                                    } else {
                                        Em(eVar.poT);
                                        return;
                                    }
                                }
                                w.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + gVar.kfr);
                                sE(3);
                                if (eVar.kfr == 1) {
                                    this.prA = false;
                                }
                                if (this.psx != null && this.psx.isShowing()) {
                                    return;
                                }
                                if (eVar.poV) {
                                    ViewStub viewStub = (ViewStub) findViewById(R.h.cMD);
                                    if (viewStub != null) {
                                        viewStub.inflate();
                                    }
                                    ((ShakeEggAnimFrame) findViewById(R.h.bzm)).P(this);
                                    new ae().postDelayed(new Runnable(this) {
                                        final /* synthetic */ ShakeReportUI psK;

                                        public final void run() {
                                            this.psK.a(eVar);
                                        }
                                    }, 1000);
                                    return;
                                }
                                a(eVar);
                                return;
                            case 2:
                                w.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                Em(getString(R.l.eVa));
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    }

    private void a(com.tencent.mm.plugin.shake.c.a.e eVar) {
        this.psx = com.tencent.mm.plugin.shake.c.b.a.a(this, eVar, new OnCancelListener(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                this.psK.prA = true;
                this.psK.psx = null;
                this.psK.prK.setText("");
            }
        }, new com.tencent.mm.plugin.shake.c.b.a.b(this) {
            final /* synthetic */ ShakeReportUI psK;

            {
                this.psK = r1;
            }

            public final void bbg() {
                this.psK.prA = true;
                this.psK.prK.setText("");
            }
        });
    }

    private void cm(View view) {
        if (view != null) {
            w.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), com.tencent.mm.sdk.platformtools.bg.bJZ(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                aj("", false);
                if (view.getId() == R.h.cEf) {
                    g.oUh.i(11722, new Object[]{Integer.valueOf(1)});
                    if (this.psk != 1) {
                        if (this.psk == 4) {
                            gT(false);
                        }
                        this.psk = 1;
                        bbC();
                        gV(false);
                        if (this.prG != null) {
                            this.prG.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.cEl) {
                    g.oUh.i(11722, new Object[]{Integer.valueOf(2)});
                    if (!(this.gKl || this.gKi == null)) {
                        this.gKi.a(this.gKp, true);
                    }
                    if (!(com.tencent.mm.n.a.aJ(this) || com.tencent.mm.n.a.aH(this) || this.psk == 3)) {
                        if (this.psk == 4) {
                            gT(false);
                        }
                        this.psk = 3;
                        bbC();
                        gV(false);
                        if (this.prG != null) {
                            this.prG.setVisibility(8);
                        }
                    }
                    if (com.tencent.mm.am.c.HR()) {
                        ap.yY();
                        if (com.tencent.mm.u.c.vr().getInt(4118, 0) == 0) {
                            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.uSU.uTo);
                            aVar.zW(R.l.dIO);
                            aVar.zX(R.l.eVt);
                            aVar.zZ(R.l.eVs).a(new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ ShakeReportUI psK;

                                {
                                    this.psK = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.psK.psa != null) {
                                        this.psK.psa.cancel();
                                    }
                                }
                            });
                            aVar.kK(true);
                            aVar.d(new OnCancelListener(this) {
                                final /* synthetic */ ShakeReportUI psK;

                                {
                                    this.psK = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().setInt(4118, 1);
                                    this.psK.psh.setVisibility(8);
                                }
                            });
                            this.psa = aVar.WJ();
                            this.psa.show();
                        }
                    }
                } else if (view.getId() == R.h.cEo) {
                    g.oUh.i(11722, new Object[]{Integer.valueOf(3)});
                    if (!(this.gKl || this.gKi == null)) {
                        this.gKi.a(this.gKp, true);
                    }
                    if (!(com.tencent.mm.n.a.aJ(this) || com.tencent.mm.n.a.aH(this) || this.psk == 4)) {
                        gT(true);
                        this.psk = 4;
                        bbC();
                        gV(false);
                        if (this.prG != null) {
                            this.prG.setVisibility(8);
                        }
                    }
                } else if (view.getId() == R.h.cEj || view.getId() == R.h.cEg) {
                    g.oUh.i(11722, new Object[]{Integer.valueOf(4)});
                    if (this.psk != 5) {
                        this.psk = 5;
                        bbC();
                        gV(false);
                        if (this.prG != null) {
                            this.prG.setVisibility(8);
                        }
                        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                            boolean isProviderEnabled;
                            LocationManager locationManager = (LocationManager) ab.getContext().getSystemService("location");
                            if (locationManager != null) {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                            } else {
                                isProviderEnabled = true;
                            }
                            if (!isProviderEnabled) {
                                Em(getString(R.l.eVn));
                            }
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                            Em(getString(R.l.eVm));
                        } else if (defaultAdapter == null) {
                            Em(getString(R.l.eVq));
                        }
                    }
                } else if (view.getId() == R.h.cEb) {
                    g.oUh.i(11722, new Object[]{Integer.valueOf(5)});
                    if (this.psk != 6) {
                        if (this.psk == 4) {
                            gT(false);
                        }
                        this.psk = 6;
                        bbC();
                        gV(false);
                        if (this.prG != null) {
                            this.prG.setVisibility(8);
                        }
                        com.tencent.mm.q.c.uk().t(262155, false);
                        this.psi.setVisibility(8);
                    }
                }
                gU(true);
                gX(false);
                gY(true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(com.tencent.mm.u.c.xb()).append("custom_shake_img_filename.jpg").toString());
                    com.tencent.mm.plugin.shake.a.imv.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(4110, Boolean.valueOf(false));
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(4111, stringExtra);
                    bbB();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        bbD();
        if (!this.prz) {
            gU(true);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        a("", null);
    }

    public final void k(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled() && this.prV != null && this.prV.getTag() != null && str.equals((String) this.prV.getTag())) {
            this.prV.setImageBitmap(bitmap);
        }
    }

    public final void bba() {
        com.tencent.mm.plugin.shake.c.c.a.baM();
        bbE();
        bbF();
        bbI();
        bbJ();
        bbH();
    }

    private void bbE() {
        if (!com.tencent.mm.plugin.shake.c.c.a.bbq()) {
            return;
        }
        if (com.tencent.mm.q.c.uk().aD(262155, 266259)) {
            this.psi.setVisibility(0);
        } else {
            this.psi.setVisibility(8);
        }
    }

    private void bbF() {
        if (this.psk == 6 && com.tencent.mm.plugin.shake.c.c.a.bbq()) {
            boolean aD = com.tencent.mm.q.c.uk().aD(262154, 266258);
            boolean aD2 = com.tencent.mm.q.c.uk().aD(262155, 266259);
            if (aD) {
                aj(com.tencent.mm.plugin.shake.c.c.a.bbl(), true);
            } else if (aD2) {
                aj(com.tencent.mm.plugin.shake.c.c.a.bbn(), true);
            } else if (!this.psy) {
                if (TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.bbj())) {
                    aj(getString(R.l.eVb), true);
                } else {
                    aj(com.tencent.mm.plugin.shake.c.c.a.bbj(), true);
                }
            }
        }
    }

    private void aj(String str, boolean z) {
        this.pry = false;
        if (this.prS == null) {
            this.prS = AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aQW);
        }
        sE(2);
        gW(true);
        if (str != null && str.length() > 1) {
            this.prJ.setText(str);
        } else if (z) {
            this.prJ.setText(R.l.eVb);
        } else {
            this.prJ.setText("");
            gW(false);
        }
        this.prB = true;
    }

    private void bbG() {
        if (this.psx != null && this.psx.isShowing()) {
            this.psx.dismiss();
        }
        this.psx = null;
    }

    private void bbH() {
        int intExtra;
        int i;
        int i2 = 1;
        boolean baN = com.tencent.mm.plugin.shake.c.c.a.baN();
        boolean aD = com.tencent.mm.q.c.uk().aD(262154, 266258);
        boolean aD2 = com.tencent.mm.q.c.uk().aD(262155, 266259);
        if (getIntent().getBooleanExtra("shake_card", false)) {
            intExtra = getIntent().getIntExtra("shake_card", 0);
        } else {
            intExtra = 0;
        }
        g gVar = g.oUh;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(intExtra);
        if (aD) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(baN ? 1 : 0);
        objArr[4] = com.tencent.mm.plugin.shake.c.c.a.bbm();
        objArr[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.bbi());
        gVar.i(11668, objArr);
        g gVar2 = g.oUh;
        Object[] objArr2 = new Object[6];
        objArr2[0] = Integer.valueOf(2);
        objArr2[1] = Integer.valueOf(intExtra);
        if (aD2) {
            intExtra = 1;
        } else {
            intExtra = 0;
        }
        objArr2[2] = Integer.valueOf(intExtra);
        if (!baN) {
            i2 = 0;
        }
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = com.tencent.mm.plugin.shake.c.c.a.bbm();
        objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.bbi());
        gVar2.i(11668, objArr2);
    }

    private void bbI() {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.bbk())) {
            this.psj.setText(com.tencent.mm.plugin.shake.c.c.a.bbk());
        }
    }

    private void bbJ() {
        if (com.tencent.mm.am.c.HQ()) {
            w.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
            this.psz.put(Integer.valueOf(3), Boolean.valueOf(true));
            findViewById(R.h.cEl).setVisibility(0);
            if (com.tencent.mm.am.c.HR()) {
                ap.yY();
                if (com.tencent.mm.u.c.vr().getInt(4118, 0) == 0) {
                    this.psh.setVisibility(0);
                } else {
                    this.psh.setVisibility(8);
                }
            }
        } else {
            this.psz.put(Integer.valueOf(3), Boolean.valueOf(false));
            findViewById(R.h.cEl).setVisibility(8);
            w.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
        }
        if (k.baQ()) {
            this.psz.put(Integer.valueOf(4), Boolean.valueOf(true));
            findViewById(R.h.cEo).setVisibility(0);
            w.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        } else {
            this.psz.put(Integer.valueOf(4), Boolean.valueOf(false));
            findViewById(R.h.cEo).setVisibility(8);
            w.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
        }
        if (com.tencent.mm.plugin.shake.c.c.a.bbq()) {
            this.psz.put(Integer.valueOf(6), Boolean.valueOf(true));
            findViewById(R.h.cEb).setVisibility(0);
            w.i("MicroMsg.ShakeReportUI", "show shake card tab");
        } else {
            findViewById(R.h.cEb).setVisibility(8);
            this.psz.put(Integer.valueOf(6), Boolean.valueOf(false));
            w.i("MicroMsg.ShakeReportUI", "hide shake card tab");
        }
        if (bbK()) {
            this.psz.put(Integer.valueOf(5), Boolean.valueOf(true));
            this.psv.setVisibility(0);
            w.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        } else {
            this.psz.put(Integer.valueOf(5), Boolean.valueOf(false));
            this.psv.setVisibility(8);
            w.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
        }
        int i = 0;
        for (Boolean booleanValue : this.psz.values()) {
            int i2;
            if (booleanValue.booleanValue()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.psl = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.cDW);
        if (i == 1) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
        if (i > 4 && this.psG) {
            findViewById(R.h.cEo).setVisibility(8);
            w.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
            this.psl--;
        } else if (i > 4 && !this.psG) {
            this.psv.setVisibility(8);
            this.psA = false;
            this.psl--;
            w.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
        }
    }

    private boolean bbK() {
        w.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + v.bIJ() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + v.bIN());
        return this.psA && bbL();
    }

    private static boolean bbL() {
        return v.bIJ() || v.bIN().equals("en") || v.bIN().equals("ja");
    }

    private void gY(boolean z) {
        this.psm.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ShakeReportUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = com.tencent.mm.sdk.platformtools.bg.bJZ();
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.ShakeReportUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    aVK();
                    return;
                }
                this.oIa = false;
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ ShakeReportUI psK;

                    {
                        this.psK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.psK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.psK.oIa = true;
                        this.psK.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ ShakeReportUI psK;

                    {
                        this.psK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.psK.oIa = true;
                        this.psK.finish();
                    }
                });
                return;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ShakeReportUI psK;

                        {
                            this.psK = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.psK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ShakeReportUI psK;

                        {
                            this.psK = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
