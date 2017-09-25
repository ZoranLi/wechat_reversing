package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.view.m;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.e.a.ah;
import com.tencent.mm.e.a.qu;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.d;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class l {
    public static boolean uSY = false;
    public static final int uTE = h.hdJ;
    private static boolean uTs = false;
    public ActionBar Gx;
    private int PROXIMITY_SCREEN_OFF_WAKE_LOCK = 32;
    String className;
    public AudioManager ibo;
    public View ipu;
    private p kww;
    public Context mContext;
    private int mgE = 0;
    private LayoutInflater myo;
    protected ae oPe = new ae(Looper.getMainLooper());
    private final long qqS = 300;
    public long qqT = SystemClock.elapsedRealtime();
    protected boolean uST = false;
    private View uSZ;
    public int uTA = 0;
    private boolean uTB = false;
    private c uTC = new c<qu>(this) {
        final /* synthetic */ l uTL;

        {
            this.uTL = r2;
            this.usg = qu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.e.a.qu.a aVar = ((qu) bVar).fXP;
            if (aVar.fDB == 2) {
                String str = aVar.fDE;
                int i = aVar.position;
                w.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position[%d] noticeId[%s]", Integer.valueOf(i), str);
                if (i <= 0 || i == this.uTL.uTA) {
                    this.uTL.a(aVar.fDD, aVar.visible, aVar.url, aVar.desc, str, i, false);
                } else {
                    w.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.uTL.uTA));
                }
            }
            return false;
        }
    };
    private int uTD = h.hdI;
    private int uTF = -1;
    public int uTG = 0;
    private a uTH;
    private MenuItem uTI;
    private Runnable uTJ = new Runnable(this) {
        final /* synthetic */ l uTL;

        {
            this.uTL = r1;
        }

        public final void run() {
            this.uTL.uTo.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (this.uTL.Gx != null) {
                this.uTL.Gx.hide();
            }
        }
    };
    private Runnable uTK = new Runnable(this) {
        final /* synthetic */ l uTL;

        {
            this.uTL = r1;
        }

        public final void run() {
            if (this.uTL.Gx != null) {
                this.uTL.Gx.show();
            }
        }
    };
    public View uTa;
    public View uTb;
    public TextView uTc;
    public FrameLayout uTd;
    public boolean uTe = true;
    String uTf = " ";
    int uTg = 0;
    int uTh = 0;
    d uTi = null;
    d uTj = null;
    private d uTk = null;
    private d uTl = null;
    private boolean uTm = false;
    boolean uTn = false;
    public ActionBarActivity uTo;
    private boolean uTp;
    private a uTq = new a();
    LinkedList<a> uTr = new LinkedList();
    ArrayList<Dialog> uTt;
    View uTu;
    public TextView uTv;
    View uTw;
    public ImageView uTx;
    View uTy;
    private TextView uTz;
    private WakeLock wakeLock = null;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ l uTL;
        final /* synthetic */ Runnable uTM;

        AnonymousClass2(l lVar, Runnable runnable) {
            this.uTL = lVar;
            this.uTM = runnable;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.uTL.qqT < 300) {
                this.uTM.run();
            }
            this.uTL.qqT = SystemClock.elapsedRealtime();
        }
    }

    public static final class a {
        boolean fFU = true;
        OnLongClickListener lLy;
        OnMenuItemClickListener oUT;
        String text;
        int uTR = -1;
        int uTS;
        Drawable uTT;
        View uTU;
        View uTV;
        int uTW = b.uTX;
        boolean visible = true;
    }

    public enum b {
        ;

        static {
            uTX = 1;
            uTY = 2;
            uTZ = 3;
            uUa = 4;
            uUb = 5;
            uUc = 6;
            uUd = 7;
            uUe = 8;
            uUf = 9;
            uUg = new int[]{uTX, uTY, uTZ, uUa, uUb, uUc, uUd, uUe, uUf};
        }
    }

    protected abstract void SC();

    protected abstract String aFO();

    protected abstract void bE(View view);

    protected abstract boolean bPO();

    protected abstract View bQa();

    public abstract void bit();

    protected abstract String getClassName();

    protected abstract int getLayoutId();

    public final void a(int i, final boolean z, final String str, final String str2, final String str3, final int i2, boolean z2) {
        w.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i2), this.uTb);
        if (!byl()) {
            return;
        }
        if (!z && this.uTb == null) {
            return;
        }
        if (this.Gx == null || this.Gx.isShowing()) {
            if (this.uTd == null) {
                this.uTd = (FrameLayout) this.ipu.findViewById(g.ckh);
            }
            if (this.uTb != null) {
                this.uTd.removeView(this.uTb);
            }
            int i3 = h.dju;
            if (i <= 0) {
                i = i3;
            }
            this.uTb = this.myo.inflate(i, null);
            this.uTc = (TextView) this.uTb.findViewById(g.coU);
            this.uTb.findViewById(g.hcM).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ l uTL;

                public final void onClick(View view) {
                    com.tencent.mm.sdk.b.b ahVar = new ah();
                    ahVar.fDx.type = 1;
                    ahVar.fDx.fDz = str3;
                    ahVar.fDx.position = i2;
                    com.tencent.mm.sdk.b.a.urY.m(ahVar);
                    this.uTL.uTb.setVisibility(8);
                }
            });
            this.uTb.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ l uTL;

                public final void onClick(View view) {
                    if (str != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        this.uTL.mContext.startActivity(intent);
                    }
                }
            });
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.uTB && VERSION.SDK_INT >= 16) {
                layoutParams.setMargins(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.uTo, 48.0f), 0, 0);
                w.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.topMargin));
            }
            this.uTd.addView(this.uTb, this.uTd.getChildCount(), layoutParams);
            if (this.uTb == null) {
                return;
            }
            if (z2) {
                this.uTb.setVisibility(z ? 0 : 8);
                String string = this.mContext.getString(k.hfi);
                if (bg.mA(str2)) {
                    str2 = this.mContext.getString(k.ebD);
                }
                if (str != null) {
                    CharSequence spannableString = new SpannableString(str2 + string);
                    spannableString.setSpan(new ForegroundColorSpan(-10119449), str2.length(), string.length() + str2.length(), 33);
                    this.uTc.setText(spannableString);
                } else {
                    w.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
                    this.uTc.setText(str2);
                }
                this.uTb.invalidate();
                this.uTd.invalidate();
                return;
            }
            this.uTb.post(new Runnable(this) {
                final /* synthetic */ l uTL;

                public final void run() {
                    this.uTL.uTb.setVisibility(z ? 0 : 8);
                    String string = this.uTL.mContext.getString(k.hfi);
                    CharSequence string2 = bg.mA(str2) ? this.uTL.mContext.getString(k.ebD) : str2;
                    if (str != null) {
                        CharSequence spannableString = new SpannableString(string2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                        this.uTL.uTc.setText(spannableString);
                    } else {
                        w.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
                        this.uTL.uTc.setText(string2);
                    }
                    this.uTL.uTb.invalidate();
                    this.uTL.uTd.invalidate();
                }
            });
            return;
        }
        w.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
    }

    private View findViewById(int i) {
        View findViewById = this.ipu.findViewById(i);
        return findViewById != null ? findViewById : this.uTo.findViewById(i);
    }

    public final void ag(int i, boolean z) {
        this.uTA = i;
        this.uTB = z;
    }

    public static Locale et(Context context) {
        String d = v.d(context.getSharedPreferences(ab.bIX(), 0));
        Resources resources = ab.getResources();
        if (d.equals("language_default")) {
            v.a(context, Locale.ENGLISH);
            if (resources instanceof com.tencent.mm.bh.a) {
                ((com.tencent.mm.bh.a) resources).bHE();
            }
            return Locale.getDefault();
        }
        Locale Po = v.Po(d);
        v.a(context, Po);
        if (resources instanceof com.tencent.mm.bh.a) {
            ((com.tencent.mm.bh.a) resources).bHE();
        }
        return Po;
    }

    public ActionBar cP() {
        return this.uTo.cO().cP();
    }

    public final void a(Context context, ActionBarActivity actionBarActivity) {
        this.mContext = actionBarActivity;
        this.uTo = actionBarActivity;
        SC();
        this.className = getClass().getName();
        w.aC(3, this.className);
        et(context);
        this.ibo = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int layoutId = getLayoutId();
        this.myo = LayoutInflater.from(this.mContext);
        this.ipu = this.myo.inflate(h.hdY, null);
        this.uSZ = this.ipu.findViewById(g.hcI);
        this.uTd = (FrameLayout) this.ipu.findViewById(g.ckh);
        this.mgE = this.mContext.getResources().getDimensionPixelSize(e.hbI);
        if (layoutId != -1) {
            this.uTa = bQa();
            if (this.uTa == null) {
                this.uTa = this.myo.inflate(getLayoutId(), null);
            } else if (this.uTa.getParent() != null) {
                ((ViewGroup) this.uTa.getParent()).removeView(this.uTa);
            }
            this.uTd.addView(this.uTa, 0);
        }
        bE(this.ipu);
        if (bPO()) {
            int dimensionPixelSize;
            x.d(x.a(this.uTo.getWindow(), this.uTa), this.uTa);
            ((ViewGroup) this.uTa.getParent()).removeView(this.uTa);
            ((ViewGroup) this.uTo.getWindow().getDecorView()).addView(this.uTa, 0);
            layoutId = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.aWR);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.aWS);
            }
            this.uTa.setPadding(this.uTa.getPaddingLeft(), dimensionPixelSize + (layoutId + this.uTa.getPaddingTop()), this.uTa.getPaddingRight(), this.uTa.getPaddingBottom());
        }
        this.Gx = cP();
        w.d("MicroMsg.MMActivityController", "onCreate, before.");
        Z(actionBarActivity);
        if (this.uTd == null || !(this.uTd instanceof LayoutListenerView)) {
            w.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        } else {
            ((LayoutListenerView) this.uTd).uSK = new com.tencent.mm.ui.LayoutListenerView.a(this) {
                final /* synthetic */ l uTL;
                private final int uTO = com.tencent.mm.bg.a.fromDPToPix(this.uTL.mContext, 100);

                {
                    this.uTL = r3;
                }

                public final void onSizeChanged(int i, int i2, int i3, int i4) {
                    if (((this.uTL.uTo.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 1 : 0) == 0 && i != 0 && i2 != 0 && i3 != 0 && i4 != 0 && i == i3) {
                        l lVar;
                        if (i2 > i4 && i2 - i4 > this.uTO) {
                            lVar = this.uTL;
                            lVar.uTG = 2;
                            lVar.bit();
                        } else if (i4 > i2 && i4 - i2 > this.uTO) {
                            lVar = this.uTL;
                            lVar.uTG = 1;
                            lVar.bit();
                        }
                    }
                }
            };
        }
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fDx.type = 2;
        ahVar.fDx.position = this.uTA;
        com.tencent.mm.sdk.b.a.urY.m(ahVar);
        if (ahVar.fDy.fDB == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.fDy.fDE;
            int i = ahVar.fDy.position;
            w.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", Integer.valueOf(i), str, bg.bJZ());
            if (i <= 0 || i == this.uTA) {
                a(ahVar.fDy.fDD, ahVar.fDy.visible, ahVar.fDy.url, ahVar.fDy.desc, str, i, true);
            } else {
                w.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.uTA));
            }
            w.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = actionBarActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(actionBarActivity.getResources().getColor(com.tencent.mm.s.a.d.aVV));
        }
    }

    public boolean Xb() {
        return false;
    }

    final void Z(Activity activity) {
        if (this.Gx != null && !Xb()) {
            if (VERSION.SDK_INT < 11) {
                this.Gx.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(com.tencent.mm.s.a.d.aSD)));
            }
            w.d("MicroMsg.MMActivityController", "onCreate, after");
            this.Gx.setLogo(new ColorDrawable(this.uTo.getResources().getColor(17170445)));
            this.Gx.cK();
            this.Gx.setDisplayHomeAsUpEnabled(false);
            this.Gx.cJ();
            this.Gx.cL();
            this.Gx.setIcon(f.bkS);
            if (this.uTF == -1) {
                this.Gx.setCustomView(r.eC(this.uTo).inflate(this.uTD, new LinearLayout(this.uTo), false));
            } else {
                this.Gx.setCustomView(r.eC(this.uTo).inflate(this.uTF, new LinearLayout(this.uTo), false));
            }
            this.uTv = (TextView) findViewById(16908308);
            this.uTz = (TextView) findViewById(16908309);
            this.uTu = findViewById(g.divider);
            this.uTw = findViewById(g.bnf);
            this.uTx = (ImageView) findViewById(g.bng);
            if (this.uTx != null) {
                this.uTx.setContentDescription(this.uTo.getString(k.dDn));
            }
            this.uTy = findViewById(g.hbZ);
            if (this.uTv != null) {
                this.uTv.setText(k.bpJ);
            }
            if (activity.getClass().getName() == "WebViewUI") {
                if (this.uTy != null) {
                    this.uTy.setVisibility(8);
                }
                if (this.uTx != null) {
                    this.uTx.setVisibility(0);
                }
                if (this.uTw != null) {
                    this.uTw.setVisibility(0);
                }
            } else if (activity instanceof MMActivity) {
                if (this.uTy != null) {
                    this.uTy.setVisibility(8);
                }
                if (this.uTx != null) {
                    this.uTx.setVisibility(0);
                }
                if (this.uTw != null) {
                    this.uTw.setVisibility(0);
                }
                if (this.uTv != null) {
                    this.uTv.setVisibility(0);
                }
            } else {
                if (this.uTy != null) {
                    this.uTy.setVisibility(0);
                }
                if (this.uTx != null) {
                    this.uTx.setVisibility(8);
                }
                if (this.uTw != null) {
                    this.uTw.setVisibility(8);
                }
            }
        }
    }

    public final void cV(boolean z) {
        this.uTe = z;
        if (this.uSZ == null && this.ipu != null) {
            this.uSZ = this.ipu.findViewById(g.hcI);
        }
        if (this.uSZ == null) {
            w.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
            return;
        }
        boolean z2;
        this.uSZ.setFocusable(!z);
        View view = this.uSZ;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        view.setFocusableInTouchMode(z2);
        if (!z) {
            Context context = this.uTo;
            if (this.wakeLock == null) {
                uSY = true;
                this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(this.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "screen Lock");
                this.wakeLock.acquire();
            }
        } else if (this.wakeLock != null && this.wakeLock.isHeld()) {
            uSY = false;
            this.wakeLock.release();
            this.wakeLock = null;
        }
    }

    public final void onStart() {
        this.uST = this.mContext.getSharedPreferences(ab.bIX(), 0).getBoolean("settings_landscape_mode", false);
        if (this.uST) {
            this.uTo.setRequestedOrientation(-1);
        } else {
            this.uTo.setRequestedOrientation(1);
        }
    }

    public final boolean bQb() {
        return this.uST;
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.uTH == null || !this.uTH.fFU) {
            return true;
        }
        a(this.uTI, this.uTH);
        return true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        int streamMaxVolume;
        int streamVolume;
        if (i != 25 || this.ibo == null) {
            if (i != 24 || this.ibo == null) {
                if (!this.uTp || this.kww == null || !this.kww.onKeyDown(i, keyEvent)) {
                    return false;
                }
                w.d("MicroMsg.MMActivityController", "match search view on key down");
                return true;
            } else if (keyEvent.getAction() != 0) {
                return true;
            } else {
                streamMaxVolume = this.ibo.getStreamMaxVolume(3);
                streamVolume = this.ibo.getStreamVolume(3);
                if (streamVolume >= streamMaxVolume) {
                    w.i("MicroMsg.MMActivityController", "has set the max volume");
                    return true;
                }
                streamMaxVolume /= 7;
                if (streamMaxVolume == 0) {
                    streamMaxVolume = 1;
                }
                this.ibo.setStreamVolume(3, streamMaxVolume + streamVolume, 5);
                return true;
            }
        } else if (keyEvent.getAction() != 0) {
            return true;
        } else {
            streamMaxVolume = this.ibo.getStreamMaxVolume(3);
            streamVolume = this.ibo.getStreamVolume(3);
            streamMaxVolume /= 7;
            if (streamMaxVolume == 0) {
                streamMaxVolume = 1;
            }
            this.ibo.setStreamVolume(3, streamVolume - streamMaxVolume, 5);
            return true;
        }
    }

    public boolean byl() {
        return true;
    }

    public final void onResume() {
        ku(true);
        com.tencent.mm.sdk.b.a.urY.b(this.uTC);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fDx.type = 2;
        ahVar.fDx.position = this.uTA;
        com.tencent.mm.sdk.b.a.urY.m(ahVar);
        if (ahVar.fDy.fDB == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.fDy.fDE;
            int i = ahVar.fDy.position;
            w.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", Integer.valueOf(i), str);
            if (i <= 0 || i == this.uTA) {
                a(ahVar.fDy.fDD, ahVar.fDy.visible, ahVar.fDy.url, ahVar.fDy.desc, str, i, true);
            } else {
                w.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.uTA));
            }
            w.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void onDestroy() {
        if (this.uTt != null) {
            int size = this.uTt.size();
            for (int i = 0; i < size; i++) {
                Dialog dialog = (Dialog) this.uTt.get(i);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.uTt.clear();
            this.uTt = null;
        }
    }

    private void ku(boolean z) {
        if (uTs || !z) {
            x.a(z, new Intent().putExtra("classname", getClassName() + aFO()));
        } else {
            x.a(z, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
        }
    }

    public static void bPQ() {
        uTs = true;
    }

    public final void onPause() {
        ku(false);
        com.tencent.mm.sdk.b.a.urY.c(this.uTC);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        w.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", Integer.valueOf(this.uTr.size()));
        if (this.Gx == null || this.uTr.size() == 0) {
            w.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.uTr.size()));
            return false;
        }
        int dimensionPixelSize;
        this.uTH = null;
        this.uTI = null;
        int height = this.Gx.getHeight();
        if (height == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.aWR);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.aWS);
            }
        } else {
            dimensionPixelSize = height;
        }
        Iterator it = this.uTr.iterator();
        while (it.hasNext()) {
            final a aVar = (a) it.next();
            if (aVar.uTR == 16908332) {
                w.v("MicroMsg.MMActivityController", "match back option menu, continue");
            } else if (aVar.uTR == g.cjK) {
                r1 = "MicroMsg.MMActivityController";
                String str = "match search menu, enable search view[%B], search view helper is null[%B]";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.uTp);
                objArr[1] = Boolean.valueOf(this.kww == null);
                w.v(r1, str, objArr);
                if (this.uTp && this.kww != null) {
                    this.kww.a(this.uTo, menu);
                }
            } else {
                final MenuItem add = menu.add(0, aVar.uTR, 0, aVar.text);
                r1 = getClass().getName();
                if (add == null) {
                    w.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
                } else if (add.getTitleCondensed() == null) {
                    w.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", r1);
                    add.setTitleCondensed("");
                } else if (!(add.getTitleCondensed() instanceof String)) {
                    w.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", r1, add.getTitleCondensed().getClass().getName(), add.getTitleCondensed());
                    add.setTitleCondensed(add.getTitleCondensed().toString());
                }
                OnClickListener anonymousClass10 = new OnClickListener(this) {
                    final /* synthetic */ l uTL;

                    public final void onClick(View view) {
                        this.uTL.a(add, aVar);
                    }
                };
                OnLongClickListener anonymousClass11 = new OnLongClickListener(this) {
                    final /* synthetic */ l uTL;

                    public final boolean onLongClick(View view) {
                        l lVar = this.uTL;
                        a aVar = aVar;
                        if (lVar.uTe) {
                            return aVar.lLy != null ? aVar.lLy.onLongClick(view) : false;
                        } else {
                            w.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
                            return true;
                        }
                    }
                };
                if (aVar.uTS == 0 && aVar.uTT == null) {
                    TextView textView;
                    if (aVar.uTU == null) {
                        aVar.uTU = View.inflate(this.mContext, h.cTA, null);
                    }
                    if (aVar.uTW == b.uTZ) {
                        aVar.uTU.findViewById(g.bmS).setVisibility(8);
                        aVar.uTU.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.uTU.findViewById(g.bmT);
                        textView.setBackgroundResource(f.bdc);
                        textView.setPadding(this.mgE, 0, this.mgE, 0);
                    } else if (aVar.uTW == b.uTY) {
                        aVar.uTU.findViewById(g.bmS).setVisibility(8);
                        aVar.uTU.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.uTU.findViewById(g.bmT);
                        textView.setBackgroundResource(f.bda);
                        textView.setPadding(this.mgE, 0, this.mgE, 0);
                    } else if (aVar.uTW == b.uUa) {
                        aVar.uTU.findViewById(g.bmS).setVisibility(8);
                        aVar.uTU.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.uTU.findViewById(g.bmT);
                        ((TextView) aVar.uTU.findViewById(g.bmT)).setTextColor(-8393929);
                        textView.setBackgroundResource(f.hbT);
                        textView.setPadding(this.mgE, 0, this.mgE, 0);
                        aVar.uTU.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    } else if (aVar.uTW == b.uUb || aVar.uTW == b.uUc || aVar.uTW == b.uUd || aVar.uTW == b.uUf) {
                        aVar.uTU.findViewById(g.bmT).setVisibility(8);
                        aVar.uTU.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.uTU.findViewById(g.bmS);
                        if (aVar.uTW == b.uUc) {
                            textView.setTextColor(this.uTo.getResources().getColor(com.tencent.mm.s.a.d.hbB));
                        } else if (aVar.uTW == b.uUd) {
                            textView.setTextColor(this.uTo.getResources().getColor(com.tencent.mm.s.a.d.aWu));
                        } else if (aVar.uTW == b.uUf) {
                            textView.setTextColor(this.uTo.getResources().getColor(com.tencent.mm.s.a.d.hbv));
                        }
                    } else if (aVar.uTW == b.uUe) {
                        aVar.uTU.findViewById(g.bmS).setVisibility(8);
                        aVar.uTU.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.uTU.findViewById(g.bmT);
                        textView.setBackgroundResource(f.hbK);
                        textView.setPadding(this.mgE, 0, this.mgE, 0);
                        textView.setTextColor(-2601405);
                    } else {
                        aVar.uTU.findViewById(g.bmT).setVisibility(8);
                        aVar.uTU.findViewById(g.divider).setVisibility(0);
                        textView = (TextView) aVar.uTU.findViewById(g.bmS);
                    }
                    textView.setVisibility(0);
                    textView.setText(aVar.text);
                    textView.setOnClickListener(anonymousClass10);
                    textView.setOnLongClickListener(anonymousClass11);
                    textView.setEnabled(aVar.fFU);
                    m.a(add, aVar.uTU);
                } else if (aVar.lLy != null) {
                    View imageButton;
                    int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 56);
                    if (aVar.uTV == null) {
                        imageButton = new ImageButton(this.mContext);
                        imageButton.setLayoutParams(new LayoutParams(fromDPToPix, dimensionPixelSize));
                        imageButton.setBackgroundResource(f.bbE);
                        imageButton.setMinimumHeight(dimensionPixelSize);
                        imageButton.setMinimumWidth(fromDPToPix);
                        aVar.uTV = imageButton;
                    } else {
                        imageButton = aVar.uTV;
                    }
                    if (aVar.uTT != null) {
                        ((ImageButton) imageButton).setImageDrawable(aVar.uTT);
                    } else {
                        ((ImageButton) imageButton).setImageResource(aVar.uTS);
                    }
                    m.a(add, imageButton);
                    LayoutParams layoutParams = imageButton.getLayoutParams();
                    layoutParams.width = fromDPToPix;
                    layoutParams.height = dimensionPixelSize;
                    imageButton.setOnClickListener(anonymousClass10);
                    imageButton.setOnLongClickListener(anonymousClass11);
                    imageButton.setEnabled(aVar.fFU);
                    imageButton.setContentDescription(aVar.text);
                } else if (aVar.uTT != null) {
                    add.setIcon(aVar.uTT);
                } else {
                    add.setIcon(aVar.uTS);
                }
                add.setEnabled(aVar.fFU);
                add.setVisible(aVar.visible);
                m.a(add, 2);
                if (aVar.uTS == f.bhb) {
                    this.uTH = aVar;
                    this.uTI = add;
                }
                w.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", Integer.valueOf(aVar.uTR), aVar.text, Boolean.valueOf(aVar.fFU), Boolean.valueOf(aVar.visible));
            }
        }
        return true;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        w.d("MicroMsg.MMActivityController", "on prepare option menu");
        if (this.uTp && this.kww != null) {
            this.kww.a(this.uTo, menu);
        }
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        w.v("MicroMsg.MMActivityController", "on options item selected");
        if (!this.uTe) {
            w.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() == this.uTq.uTR && this.uTq.fFU) {
            a(menuItem, this.uTq);
            return true;
        } else {
            Iterator it = this.uTr.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (menuItem.getItemId() == aVar.uTR) {
                    w.d("MicroMsg.MMActivityController", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    a(menuItem, aVar);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean bQc() {
        if (this.uTq == null || !this.uTq.fFU) {
            return false;
        }
        a(null, this.uTq);
        return true;
    }

    public final void a(MenuItem menuItem, a aVar) {
        if (!this.uTe) {
            w.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
        } else if (aVar.oUT != null) {
            aVar.oUT.onMenuItemClick(menuItem);
        }
    }

    public final void kp(boolean z) {
        if (z) {
            if (this.Gx != null) {
                this.Gx.hide();
            }
            this.oPe.removeCallbacks(this.uTK);
            this.oPe.removeCallbacks(this.uTJ);
            this.oPe.postDelayed(this.uTJ, 256);
            return;
        }
        this.uTo.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.oPe.removeCallbacks(this.uTJ);
        this.oPe.removeCallbacks(this.uTK);
        this.oPe.postDelayed(this.uTK, 256);
    }

    public final void d(boolean z, long j) {
        if (z) {
            if (this.Gx != null) {
                this.Gx.hide();
            }
            this.oPe.removeCallbacks(this.uTK);
            this.oPe.removeCallbacks(this.uTJ);
            this.oPe.postDelayed(this.uTJ, j);
            return;
        }
        this.uTo.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.oPe.removeCallbacks(this.uTJ);
        this.oPe.removeCallbacks(this.uTK);
        this.oPe.postDelayed(this.uTK, j);
    }

    public final void qP(String str) {
        if (this.Gx != null) {
            this.uTf = str;
            if (com.tencent.mm.bg.a.dM(this.uTo)) {
                this.uTv.setTextSize(0, ((float) com.tencent.mm.bg.a.U(this.uTo, e.aWy)) * com.tencent.mm.bg.a.dK(this.uTo));
            }
            bQd();
            SF(str);
        }
    }

    public final void L(CharSequence charSequence) {
        if (this.Gx != null) {
            this.uTf = charSequence.toString();
            this.uTv.setText(charSequence);
            if (com.tencent.mm.bg.a.dM(this.uTo)) {
                this.uTv.setTextSize(0, ((float) com.tencent.mm.bg.a.U(this.uTo, e.aWy)) * com.tencent.mm.bg.a.dK(this.uTo));
            }
            SF(charSequence.toString());
        }
    }

    protected final void SF(String str) {
        com.tencent.mm.ui.a.a aVar = a.uWW;
        Activity activity = this.uTo;
        if (!aVar.bQH() && !bg.mA(str) && activity != null) {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(k.hff) + str);
        }
    }

    public final void zi(int i) {
        qP(this.mContext.getString(i));
    }

    public final void SE(String str) {
        if (this.Gx != null) {
            if (str == null) {
                this.uTz.setVisibility(8);
                return;
            }
            this.uTz.setText(str);
            if (com.tencent.mm.bg.a.dM(this.uTo)) {
                this.uTz.setTextSize(1, 14.0f);
                this.uTv.setTextSize(1, 18.0f);
            }
            this.uTz.setVisibility(0);
            SF(str);
        }
    }

    public final void zj(int i) {
        if (this.Gx != null) {
            this.uTz.setText(this.mContext.getString(i));
            if (com.tencent.mm.bg.a.dM(this.uTo)) {
                this.uTz.setTextSize(1, 14.0f);
                this.uTv.setTextSize(1, 18.0f);
            }
            this.uTz.setVisibility(0);
            SF(this.mContext.getString(i));
        }
    }

    final d dT(int i, int i2) {
        Drawable drawable = this.mContext.getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        d dVar = new d(drawable);
        dVar.wuA = (drawable.getIntrinsicHeight() - i) / 2;
        return dVar;
    }

    final void bQd() {
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str3 = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.aWE);
        if (this.uTg != 0) {
            str3 = "# " + str3;
        }
        if (this.uTh != 0) {
            str = str3 + " #";
            i = 1;
        } else {
            str = str3;
            i = 0;
        }
        if (this.uTm) {
            str2 = str + " #";
            i2 = i + 2;
            i = 1;
        } else {
            str2 = str;
            i2 = i;
            i = 0;
        }
        if (this.uTn) {
            i3 = i + 2;
            i4 = i2 + 2;
            str3 = str2 + " #";
            i5 = 1;
        } else {
            i3 = i;
            i4 = i2;
            str3 = str2;
            i5 = 0;
        }
        CharSequence format = String.format(str3, new Object[]{this.uTf});
        w.v("MicroMsg.MMActivityController", "span title format %s", str3);
        format = com.tencent.mm.ui.f.c.b.a(this.mContext, format, dimensionPixelSize);
        if (format instanceof SpannableString) {
            int length;
            SpannableString spannableString = (SpannableString) format;
            if (this.uTg != 0) {
                spannableString.setSpan(this.uTi, 0, 1, 33);
            }
            if (this.uTh != 0) {
                length = spannableString.length() - i4;
                spannableString.setSpan(this.uTj, length, length + 1, 33);
            }
            if (this.uTm) {
                if (this.uTk == null) {
                    this.uTk = dT(dimensionPixelSize, j.heV);
                }
                length = spannableString.length() - i3;
                spannableString.setSpan(this.uTk, length, length + 1, 33);
            }
            if (this.uTn) {
                if (this.uTl == null) {
                    this.uTl = dT(dimensionPixelSize, j.heW);
                }
                length = spannableString.length() - i5;
                spannableString.setSpan(this.uTl, length, length + 1, 33);
            }
        }
        this.uTv.setText(format);
    }

    public void aQ() {
        this.uTo.aQ();
    }

    public boolean bQe() {
        return false;
    }

    public final void kq(boolean z) {
        if (this.uTq != null && this.uTq.fFU != z) {
            this.uTq.fFU = z;
            aQ();
        }
    }

    final void a(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.uTr.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.fFU != z2) {
                    aVar.fFU = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.uTr.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.uTR != i || aVar.fFU == z2) {
                    z4 = z3;
                } else {
                    aVar.fFU = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        if (!(this.kww == null ? false : this.kww.wnZ)) {
            aQ();
        }
        w.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    final void b(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.uTr.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.visible != z2) {
                    aVar.visible = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.uTr.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.uTR != i || aVar.visible == z2) {
                    z4 = z3;
                } else {
                    aVar.visible = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        z4 = this.kww == null ? false : this.kww.wnZ;
        if (z3 && !z4) {
            aQ();
        }
        w.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void a(boolean z, p pVar) {
        w.v("MicroMsg.MMActivityController", "add search menu");
        a aVar = new a();
        aVar.uTR = g.cjK;
        aVar.text = this.mContext.getString(k.dIz);
        aVar.uTS = j.dsV;
        aVar.oUT = null;
        aVar.lLy = null;
        zn(aVar.uTR);
        this.uTr.add(0, aVar);
        this.uTp = z;
        this.kww = pVar;
        aQ();
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i2) {
        a(i, 0, str, onMenuItemClickListener, null, i2);
    }

    public final void a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, "", onMenuItemClickListener, null, b.uTX);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        int i2 = b.uTX;
        a aVar = new a();
        aVar.uTR = i;
        aVar.uTT = drawable;
        aVar.text = str;
        aVar.oUT = onMenuItemClickListener;
        aVar.lLy = null;
        aVar.uTW = i2;
        zp(aVar.uTR);
        this.uTr.add(aVar);
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ l uTL;

            {
                this.uTL = r1;
            }

            public final void run() {
                this.uTL.aQ();
            }
        }, 200);
    }

    public final void a(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i3, this.mContext.getString(i2), onMenuItemClickListener, null, b.uTX);
    }

    public final void a(final OnMenuItemClickListener onMenuItemClickListener, int i) {
        if (this.Gx != null) {
            if (onMenuItemClickListener == null) {
                this.Gx.setDisplayHomeAsUpEnabled(false);
            } else {
                this.Gx.setDisplayHomeAsUpEnabled(false);
                if (this.uTw != null) {
                    this.uTw.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ l uTL;

                        public final void onClick(View view) {
                            onMenuItemClickListener.onMenuItemClick(null);
                        }
                    });
                }
            }
            if (!(this.uTx == null || i == 0)) {
                this.uTx.setImageResource(i);
            }
            this.uTq.uTR = 16908332;
            this.uTq.oUT = onMenuItemClickListener;
        }
    }

    public final void bQf() {
        if (!this.uTr.isEmpty()) {
            this.uTr.clear();
            aQ();
        }
    }

    private boolean zp(int i) {
        for (int i2 = 0; i2 < this.uTr.size(); i2++) {
            if (((a) this.uTr.get(i2)).uTR == i) {
                w.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.uTr.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final boolean zn(int i) {
        for (int i2 = 0; i2 < this.uTr.size(); i2++) {
            if (((a) this.uTr.get(i2)).uTR == i) {
                w.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.uTr.remove(i2);
                aQ();
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i3) {
        a aVar = new a();
        aVar.uTR = i;
        aVar.uTS = i2;
        aVar.text = str;
        aVar.oUT = onMenuItemClickListener;
        aVar.lLy = onLongClickListener;
        aVar.uTW = i3;
        if (aVar.uTS == f.bhb && bg.mA(str)) {
            aVar.text = this.mContext.getString(k.hfe);
        }
        zp(aVar.uTR);
        this.uTr.add(aVar);
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ l uTL;

            {
                this.uTL = r1;
            }

            public final void run() {
                this.uTL.aQ();
            }
        }, 200);
    }

    public final a zq(int i) {
        Iterator it = this.uTr.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.uTR == i) {
                return aVar;
            }
        }
        return null;
    }

    public final void bQg() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "hideTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.Gx == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.v(str, str2, objArr);
        if (this.Gx != null) {
            this.Gx.hide();
        }
    }

    public final void zo(int i) {
        this.uTm = i == 0;
        bQd();
    }

    public final boolean are() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = this.uTo.getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            w.e("MicroMsg.MMActivityController", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        w.v("MicroMsg.MMActivityController", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }

    public final boolean cX(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            w.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }

    public final void aHj() {
        Activity activity = this.uTo;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
