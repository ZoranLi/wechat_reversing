package com.tencent.mm.plugin.card.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.b;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@a(3)
public class CardGiftVideoUI extends MMActivity implements com.tencent.mm.plugin.card.b.a.a, f.a {
    int duration = 0;
    private String fVB;
    private CardGiftInfo klB;
    private ImageView klC;
    private ProgressBar klF;
    private ae klG = new ae(Looper.getMainLooper());
    private Bundle klH;
    private boolean klI = false;
    private g klJ;
    private int klK = 0;
    private int klL = 0;
    private int klM = 0;
    private int klN = 0;
    private boolean kmK;
    private RelativeLayout kmL;
    private f kmM;
    private RelativeLayout kmN;
    private ImageView kmO;
    TextView kmP;
    private MMPinProgressBtn kmQ;
    private TextView kmR;
    private l kmS;
    private aj kmT = new aj(new aj.a(this) {
        final /* synthetic */ CardGiftVideoUI kmU;

        {
            this.kmU = r1;
        }

        public final boolean oQ() {
            if (this.kmU.kmM.isPlaying()) {
                CardGiftVideoUI cardGiftVideoUI = this.kmU;
                int currentPosition = this.kmU.kmM.getCurrentPosition() / 1000;
                if (cardGiftVideoUI.kmP != null && cardGiftVideoUI.duration > 0) {
                    currentPosition = cardGiftVideoUI.duration - currentPosition;
                    if (currentPosition < 0) {
                        currentPosition = 0;
                    }
                    cardGiftVideoUI.kmP.setText(currentPosition + "\"");
                }
            }
            return true;
        }
    }, true);

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ CardGiftVideoUI kmU;
        final /* synthetic */ boolean kmW = true;

        AnonymousClass11(CardGiftVideoUI cardGiftVideoUI, boolean z) {
            this.kmU = cardGiftVideoUI;
        }

        public final void run() {
            w.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[]{Integer.valueOf(this.kmU.hashCode()), Boolean.valueOf(this.kmW)});
            if (this.kmW) {
                ((View) this.kmU.kmM).setVisibility(0);
                this.kmU.kmO.setVisibility(8);
                return;
            }
            ((View) this.kmU.kmM).setVisibility(8);
            this.kmU.kmO.setVisibility(0);
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int hyX;
        final /* synthetic */ int hyy = 100;
        final /* synthetic */ CardGiftVideoUI kmU;

        AnonymousClass2(CardGiftVideoUI cardGiftVideoUI, int i, int i2) {
            this.kmU = cardGiftVideoUI;
            this.hyX = i2;
        }

        public final void run() {
            if (this.kmU.kmQ == null) {
                return;
            }
            if (this.hyy == 0) {
                this.kmU.kmQ.setVisibility(8);
                return;
            }
            if (this.kmU.kmQ.getVisibility() != 0) {
                this.kmU.kmQ.setVisibility(0);
            }
            w.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[]{Integer.valueOf(this.hyX), Integer.valueOf(this.hyy)});
            if (this.kmU.kmQ.wvs != this.hyy && this.hyy > 0) {
                this.kmU.kmQ.setMax(this.hyy);
            }
            this.kmU.kmQ.setProgress(this.hyX);
        }
    }

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.uSU.bQg();
        this.klH = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        if (ap.oH() != null) {
            ap.oH().pS();
        }
        this.klB = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        this.fVB = getIntent().getStringExtra("key_video_path");
        this.kmK = getIntent().getBooleanExtra("key_is_mute", false);
        String str = "MicroMsg.CardGiftVideoUI";
        String str2 = "cardGiftInfo %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.klB == null ? "null" : this.klB.toString();
        w.d(str, str2, objArr);
        w.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[]{this.fVB, Boolean.valueOf(this.kmK)});
        KC();
        com.tencent.mm.plugin.card.b.a.a(this);
        ahB();
        if (this.klB == null) {
            w.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
        } else if (bg.mA(this.klB.kea)) {
            w.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
        } else {
            com.tencent.mm.plugin.card.b.a.f(this.klB.keb, this.klB.kee, this.klB.ken, 2);
            com.tencent.mm.plugin.card.b.a.f(this.klB.kea, this.klB.ked, this.klB.kem, 1);
        }
    }

    private void sO(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
            setResult(0);
            finish();
        } else if (e.aO(str)) {
            this.kmM.setVideoPath(str);
        } else {
            w.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[]{str});
            setResult(0);
            finish();
        }
    }

    private void ahB() {
        if (this.kmS == null) {
            this.kmS = new l(this.uSU.uTo);
        }
        if (bg.mA(this.fVB)) {
            w.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
        } else {
            this.kmS.a((VideoTextureView) this.kmM, new OnCreateContextMenuListener(this) {
                final /* synthetic */ CardGiftVideoUI kmU;

                {
                    this.kmU = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(0, 0, 0, this.kmU.getString(R.l.dUz));
                }
            }, new d(this) {
                final /* synthetic */ CardGiftVideoUI kmU;

                {
                    this.kmU = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            String lI = t.lI(this.kmU.fVB);
                            if (bg.mA(lI)) {
                                Toast.makeText(this.kmU, this.kmU.getString(R.l.fal), 1).show();
                                return;
                            }
                            Toast.makeText(this.kmU, this.kmU.getString(R.l.fam, new Object[]{lI}), 1).show();
                            k.b(lI, this.kmU);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    protected final void KC() {
        this.kmL = (RelativeLayout) findViewById(R.h.cMn);
        this.kmN = (RelativeLayout) findViewById(R.h.cMi);
        this.kmO = (ImageView) findViewById(R.h.cMj);
        this.kmP = (TextView) findViewById(R.h.cLN);
        this.kmQ = (MMPinProgressBtn) findViewById(R.h.cLY);
        this.klF = (ProgressBar) findViewById(R.h.cLT);
        this.kmR = (TextView) findViewById(R.h.cMl);
        this.kmM = new VideoTextureView(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.kmM.bQ(this.kmK);
        this.kmM.a(this);
        this.kmN.addView((View) this.kmM, layoutParams);
        this.klC = (ImageView) findViewById(R.h.bSt);
        this.klC.setLayerType(2, null);
        this.kmL.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CardGiftVideoUI kmU;

            {
                this.kmU = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.kmU.ahz();
                return true;
            }
        });
        ((View) this.kmM).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardGiftVideoUI kmU;

            {
                this.kmU = r1;
            }

            public final void onClick(View view) {
                this.kmU.ahz();
            }
        });
        this.klJ = new g(this);
    }

    public void onStart() {
        Bundle bundle = this.klH;
        if (!this.klI) {
            this.klI = true;
            if (VERSION.SDK_INT < 12) {
                w.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.klK = getIntent().getIntExtra("img_top", 0);
                this.klL = getIntent().getIntExtra("img_left", 0);
                this.klM = getIntent().getIntExtra("img_width", 0);
                this.klN = getIntent().getIntExtra("img_height", 0);
                this.klJ.p(this.klL, this.klK, this.klM, this.klN);
                if (bundle == null) {
                    this.kmL.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ CardGiftVideoUI kmU;

                        {
                            this.kmU = r1;
                        }

                        public final boolean onPreDraw() {
                            this.kmU.kmL.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.kmU.klJ.a(this.kmU.kmL, this.kmU.klC, null);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (!bg.mA(this.fVB)) {
            sO(this.fVB);
        }
        super.onResume();
    }

    protected void onPause() {
        this.kmM.pause();
        super.onPause();
    }

    protected void onDestroy() {
        this.kmM.stop();
        this.kmT.KH();
        com.tencent.mm.plugin.card.b.a.b(this);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        w.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
        ahz();
        return true;
    }

    public final void ahz() {
        this.klJ.p(this.klL, this.klK, this.klM, this.klN);
        this.klJ.a(this.kmL, this.klC, new b(this) {
            final /* synthetic */ CardGiftVideoUI kmU;

            {
                this.kmU = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new ae().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 kmV;

                    {
                        this.kmV = r1;
                    }

                    public final void run() {
                        this.kmV.kmU.finish();
                        this.kmV.kmU.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    protected final int getLayoutId() {
        return R.i.cWB;
    }

    public final void onError(int i, int i2) {
        setResult(0);
        this.kmM.stop();
        w.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void Uc() {
        setResult(-1);
        this.klG.post(new AnonymousClass11(this, true));
        this.klG.post(new Runnable(this) {
            final /* synthetic */ CardGiftVideoUI kmU;

            {
                this.kmU = r1;
            }

            public final void run() {
                w.d("MicroMsg.CardGiftVideoUI", "hide loading.");
                if (!(this.kmU.klF == null || this.kmU.klF.getVisibility() == 8)) {
                    this.kmU.klF.setVisibility(8);
                }
                if (this.kmU.kmQ != null && this.kmU.kmQ.getVisibility() != 8) {
                    this.kmU.kmQ.setVisibility(8);
                }
            }
        });
        this.kmM.start();
        this.duration = this.kmM.getDuration() / 1000;
        this.kmT.v(500, 500);
        w.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[]{Integer.valueOf(this.duration)});
    }

    public final void oW() {
        w.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        this.kmM.k(0.0d);
    }

    public final int bI(int i, int i2) {
        return 0;
    }

    public final void bp(int i, int i2) {
    }

    public final void aB(String str, int i) {
        if (str.equals(this.klB.kea)) {
            this.klG.post(new AnonymousClass2(this, 100, i));
        }
    }

    public final void fail(String str) {
    }

    public final void bA(String str, final String str2) {
        if (str.equals(this.klB.kea)) {
            this.klG.post(new Runnable(this) {
                final /* synthetic */ CardGiftVideoUI kmU;

                public final void run() {
                    this.kmU.kmO.setVisibility(8);
                    this.kmU.fVB = str2;
                    this.kmU.sO(this.kmU.fVB);
                    this.kmU.ahB();
                }
            });
        } else if (str.equals(this.klB.keb)) {
            this.klG.post(new Runnable(this) {
                final /* synthetic */ CardGiftVideoUI kmU;

                public final void run() {
                    if (bg.mA(this.kmU.fVB)) {
                        this.kmU.kmO.setVisibility(0);
                        c.a aVar = new c.a();
                        aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                        n.GX();
                        aVar.hJg = null;
                        aVar.hIN = m.sw(str2);
                        aVar.hIQ = 1;
                        aVar.hIL = true;
                        aVar.hIJ = true;
                        n.GW().a(str2, this.kmU.kmO, aVar.Hg());
                    }
                }
            });
        } else {
            w.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[]{str});
        }
    }
}
