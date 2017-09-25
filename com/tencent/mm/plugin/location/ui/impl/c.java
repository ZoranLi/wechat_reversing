package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.location.model.h;
import com.tencent.mm.plugin.location.ui.PoiHeaderView;
import com.tencent.mm.plugin.location.ui.SimpleImageView;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.location.ui.g;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class c extends b implements e {
    private static int nhw = 11;
    public static int nhx = 12;
    private static int nhy = 13;
    public static int nhz = 14;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ c nhD;

        {
            this.nhD = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            if (this.nhD.nhd == -85.0d || this.nhD.nhe == -1000.0d) {
                w.d("MicroMsg.MMPoiMapUI", "first get location");
                String str = ((int) (1000000.0f * f2)) + "," + ((int) (1000000.0f * f));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCI, str);
                this.nhD.nhd = (double) f2;
                this.nhD.nhe = (double) f;
                this.nhD.nhp = f2;
                this.nhD.nhq = f;
                this.nhD.lat = this.nhD.nhd;
                this.nhD.lng = this.nhD.nhe;
                this.nhD.ngN.i(this.nhD.lat, this.nhD.lng);
                this.nhD.ndG.getIController().animateTo(this.nhD.nhd, this.nhD.nhe, d.fn(false));
                if (!this.nhD.nhf) {
                    this.nhD.fu(false);
                }
            }
            return true;
        }
    };
    public String hOd = "";
    public double lat = -85.0d;
    public double lng = -1000.0d;
    private String nbf = "";
    private int nbg = 1;
    FrameLayout ngB;
    private View ngD;
    protected PoiHeaderView ngM;
    public PickPoi ngN;
    public MMLoadMoreListView ngO;
    public MMLoadMoreListView ngP;
    public View ngQ;
    public e ngR;
    public e ngS;
    private View ngT;
    public ImageButton ngU;
    private h ngV = null;
    public f ngW = null;
    private View ngX;
    private ImageButton ngY;
    ActionBarSearchView ngZ;
    public boolean nhA = false;
    public TextView nha;
    private com.tencent.mm.plugin.location.ui.e nhb;
    public g nhc;
    public double nhd = -85.0d;
    public double nhe = -1000.0d;
    public boolean nhf = false;
    private int nhg = 0;
    public RelativeLayout nhh;
    public int nhi;
    public int nhj;
    private int nhk;
    public boolean nhl = true;
    public boolean nhm = false;
    public boolean nhn = false;
    public FrameLayout nho;
    public float nhp;
    public float nhq;
    private int nhr = 0;
    private long nhs = -1;
    private long nht = -1;
    private long nhu = -1;
    private int nhv = -1;
    private TextView titleView;

    class a extends TranslateAnimation {
        final /* synthetic */ c nhD;
        private List<View> nhF = new ArrayList();

        public a(c cVar, float f) {
            this.nhD = cVar;
            super(0.0f, 0.0f, 0.0f, f);
        }

        public final a aHq() {
            setFillEnabled(true);
            setFillAfter(true);
            return this;
        }

        public final a ci(View view) {
            this.nhF.add(view);
            return this;
        }

        public final void ZB() {
            for (int i = 0; i < this.nhF.size(); i++) {
                ((View) this.nhF.get(i)).startAnimation(this);
            }
        }
    }

    public c(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(457, this);
        this.nhv = (int) (System.currentTimeMillis() / 1000);
        this.titleView = (TextView) findViewById(R.h.cjU);
        this.titleView.setText(getString(R.l.ewA));
        this.nhh = (RelativeLayout) findViewById(R.h.ccg);
        this.ngO = (MMLoadMoreListView) this.activity.findViewById(R.h.crZ);
        this.ngP = (MMLoadMoreListView) this.activity.findViewById(R.h.cAO);
        this.ngQ = this.activity.findViewById(R.h.cAU);
        this.nha = (TextView) findViewById(R.h.cAH);
        this.ngU = (ImageButton) findViewById(R.h.cbY);
        this.ngU.setContentDescription(getString(R.l.ewo));
        this.ngM = (PoiHeaderView) findViewById(R.h.crY);
        this.ndG.setBuiltInZoomControls(false);
        this.ngB = (FrameLayout) findViewById(R.h.bGH);
        this.nhb = new com.tencent.mm.plugin.location.ui.e(this.activity, R.g.biu, this.ndG);
        this.nhc = new g(this.activity, this.ndG);
        this.ngN = new PickPoi(this.activity);
        PickPoi pickPoi = this.ngN;
        ((ImageView) pickPoi.ncQ).setImageResource(R.g.bgk);
        this.ngB.addView(this.ngN);
        this.ngT = findViewById(R.h.cbD);
        this.ngD = this.activity.findViewById(R.h.cIW);
        this.ngX = (LinearLayout) this.activity.findViewById(R.h.cIY);
        this.ngX.setVisibility(0);
        switch (this.type) {
            case 0:
                ((TextView) findViewById(R.h.bmS)).setText(R.l.ewz);
                break;
            case 3:
                ((TextView) findViewById(R.h.bmS)).setText(R.l.dHP);
                break;
            case 8:
                ((TextView) findViewById(R.h.bmS)).setText(R.l.dHp);
                break;
        }
        this.ngY = (ImageButton) findViewById(R.h.cJe);
        this.ngY.setContentDescription(getString(R.l.eQh));
        this.ngZ = (ActionBarSearchView) findViewById(R.h.cBf);
        fv(false);
        this.ngR = new e(this.activity);
        this.ngS = new e(this.activity);
        this.ngS.nhO = true;
        this.ngN.nhK = this.ngR;
        this.ngO.setAdapter(this.ngR);
        this.ngO.setOnTouchListener(new OnTouchListener(this) {
            private float nhB;
            private short nhC = (short) 0;
            final /* synthetic */ c nhD;

            {
                this.nhD = r2;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.nhD.nhl) {
                    return true;
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        w.d("MicroMsg.MMPoiMapUI", "newpoi action down %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                        this.nhB = motionEvent.getRawY();
                        this.nhD.nhm = false;
                        break;
                    case 1:
                        w.d("MicroMsg.MMPoiMapUI", "newpoi action up ");
                        this.nhD.nhm = false;
                        break;
                    case 2:
                        w.d("MicroMsg.MMPoiMapUI", "newpoi action move %s", new Object[]{Float.valueOf(motionEvent.getRawY())});
                        if (this.nhD.nhm) {
                            w.d("MicroMsg.MMPoiMapUI", "newpoi blocked");
                            this.nhD.ngO.setSelection(0);
                        }
                        float rawY = this.nhB - motionEvent.getRawY();
                        if (Math.abs(rawY) < ((float) b.a(this.nhD.activity, 20.0f))) {
                            this.nhC = (short) 0;
                        } else if (rawY > 0.0f) {
                            this.nhC = (short) 1;
                        } else {
                            this.nhC = (short) -1;
                        }
                        if ((this.nhD.aHm() <= this.nhD.nhj && this.nhC == (short) 1) || ((!this.nhD.ngO.vkY && this.nhC == (short) -1 && this.nhD.aHm() < this.nhD.nhi) || (this.nhC == (short) -1 && this.nhD.aHm() >= this.nhD.nhi))) {
                            return false;
                        }
                        if (!this.nhD.nhl || this.nhC == (short) 0) {
                            return true;
                        }
                        w.d("MicroMsg.MMPoiMapUI", "newpoi start play isUP %s", new Object[]{Short.valueOf(this.nhC)});
                        if (this.nhC == (short) 1) {
                            this.nhD.ft(true);
                            return false;
                        }
                        this.nhD.ft(false);
                        return false;
                }
                return false;
            }
        });
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCI, "");
        if (!bg.mA(str) && (this.nhd == -85.0d || this.nhe == -1000.0d)) {
            String[] split = str.split(",");
            w.i("MicroMsg.MMPoiMapUI", "lastlocationinfo " + str);
            if (split.length == 2) {
                this.ndG.getIController().setCenter((double) ((float) ((((double) bg.PY(split[0])) * 1.0d) / 1000000.0d)), (double) ((float) ((((double) bg.PY(split[1])) * 1.0d) / 1000000.0d)));
            }
        }
        this.ngO.vkV = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void ajC() {
                this.nhD.aHl();
            }
        };
        this.ngU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[]{Double.valueOf(this.nhD.nhd), Double.valueOf(this.nhD.nhe)});
                if (this.nhD.nhd == -85.0d || this.nhD.nhe == -1000.0d) {
                    w.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
                    return;
                }
                this.nhD.ndG.getIController().animateTo(this.nhD.nhd, this.nhD.nhe);
                this.nhD.lat = this.nhD.nhd;
                this.nhD.lng = this.nhD.nhe;
                this.nhD.ngN.i(this.nhD.lat, this.nhD.lng);
                this.nhD.ngU.setBackgroundResource(R.g.bgn);
                this.nhD.ngU.setEnabled(true);
                this.nhD.fu(false);
                this.nhD.nhA = false;
                this.nhD.ngR.nhA = false;
            }
        });
        this.ngD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void onClick(View view) {
                this.nhD.k(c.nhx, this.nhD.ngR.nhN, false);
                this.nhD.aHf();
                this.nhD.activity.finish();
            }
        });
        this.ngX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void onClick(View view) {
                this.nhD.aHk();
            }
        });
        this.ngO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.d("MicroMsg.MMPoiMapUI", "newpoi listview itemClick position %d", new Object[]{Integer.valueOf(i)});
                if (!this.nhD.nhf) {
                    if (i >= this.nhD.ngR.getCount()) {
                        w.i("MicroMsg.MMPoiMapUI", "wrong position");
                        return;
                    }
                    f oJ = this.nhD.ngR.oJ(i);
                    if (oJ.type == 0) {
                        View view2 = this.nhD.nhc;
                        double d = oJ.aKd;
                        double d2 = oJ.aKe;
                        if (view2.ndn) {
                            view2.ndG.updateViewLayout(view2, d, d2);
                        } else {
                            view2.ndn = true;
                            view2.ndG.addView(view2, d, d2);
                        }
                        this.nhD.ngU.setBackgroundResource(R.g.bgm);
                    } else {
                        this.nhD.nhc.remove();
                        this.nhD.ngU.setEnabled(true);
                    }
                    this.nhD.ndG.getIController().animateTo(oJ.aKd, oJ.aKe);
                    this.nhD.ngR.nhN = i;
                    this.nhD.ngR.notifyDataSetChanged();
                }
                this.nhD.nhA = false;
            }
        });
        this.ngY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void onClick(View view) {
                if (!this.nhD.nhf) {
                    c cVar = this.nhD;
                    cVar.nhf = true;
                    cVar.ngP.bSi();
                    cVar.ngP.vkV = new com.tencent.mm.ui.base.MMLoadMoreListView.a(cVar) {
                        final /* synthetic */ c nhD;

                        {
                            this.nhD = r1;
                        }

                        public final void ajC() {
                            this.nhD.aHl();
                        }
                    };
                    cVar.ngP.setOnItemClickListener(new OnItemClickListener(cVar) {
                        final /* synthetic */ c nhD;

                        {
                            this.nhD = r1;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            f fVar = null;
                            if (this.nhD.ngS.nhN < this.nhD.ngS.getCount()) {
                                fVar = this.nhD.ngS.oJ(i);
                            }
                            this.nhD.ngW = fVar;
                            this.nhD.a(fVar);
                        }
                    });
                    cVar.ngP.setOnTouchListener(new OnTouchListener(cVar) {
                        final /* synthetic */ c nhD;

                        {
                            this.nhD = r1;
                        }

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            this.nhD.aHf();
                            return false;
                        }
                    });
                    cVar.ngO.setVisibility(8);
                    cVar.ngP.setVisibility(0);
                    cVar.ngP.setAdapter(cVar.ngS);
                    cVar.ngP.bSi();
                    cVar.findViewById(R.h.bVX).setVisibility(8);
                    cVar.ngZ.setVisibility(0);
                    cVar.ngZ.wkq = new OnFocusChangeListener(cVar) {
                        final /* synthetic */ c nhD;

                        {
                            this.nhD = r1;
                        }

                        public final void onFocusChange(View view, boolean z) {
                            if (z) {
                                this.nhD.aHj();
                            }
                        }
                    };
                    new ae().post(new Runnable(cVar) {
                        final /* synthetic */ c nhD;

                        {
                            this.nhD = r1;
                        }

                        public final void run() {
                            this.nhD.ngZ.bZv();
                            this.nhD.aHj();
                        }
                    });
                }
                this.nhD.ngS.clean();
                this.nhD.ngP.setAdapter(this.nhD.ngS);
                this.nhD.ngS.notifyDataSetChanged();
                this.nhD.ngQ.setVisibility(8);
            }
        });
        this.ngZ.setHint(getString(R.l.eww));
        this.ngZ.lE(false);
        this.ngZ.wko = new com.tencent.mm.ui.tools.ActionBarSearchView.a(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void aHp() {
                w.d("MicroMsg.MMPoiMapUI", "back pressed");
                this.nhD.k(c.nhz, this.nhD.ngS.nhN, true);
                this.nhD.a(null);
            }
        };
        this.ngZ.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                w.d("MicroMsg.MMPoiMapUI", "keyboard action");
                if (3 == i) {
                    this.nhD.fu(false);
                }
                return false;
            }
        });
        this.ngZ.wkn = new ActionBarSearchView.b(this) {
            final /* synthetic */ c nhD;

            {
                this.nhD = r1;
            }

            public final void aHn() {
            }

            public final void zE(String str) {
                w.d("MicroMsg.MMPoiMapUI", "searchText: %s", new Object[]{str});
                this.nhD.hOd = str;
                this.nhD.ngP.bSi();
                this.nhD.nha.setVisibility(8);
                if (bg.mA(str)) {
                    this.nhD.ngS.clean();
                    this.nhD.ngS.notifyDataSetChanged();
                    return;
                }
                this.nhD.fu(true);
            }

            public final void OF() {
                w.d("MicroMsg.MMPoiMapUI", "clear btn click");
                this.nhD.ngS.clean();
                this.nhD.ngS.notifyDataSetChanged();
            }

            public final void aHo() {
            }
        };
        this.nho = (FrameLayout) findViewById(R.h.ciN);
        this.nhi = b.a(this.activity, 280.0f);
        this.nhj = b.a(this.activity, 150.0f);
        int dP = com.tencent.mm.bg.a.dP(this.activity);
        int identifier = ab.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            identifier = ab.getResources().getDimensionPixelSize(identifier);
        } else {
            identifier = 0;
        }
        dP = ((dP - this.nhj) - identifier) - com.tencent.mm.bg.a.T(this.activity, R.f.aWS);
        if (dP > com.tencent.mm.bg.a.T(this.activity, R.f.baX)) {
            w.i("MicroMsg.MMPoiMapUI", "reset listview height: %s, statusBar: %s, actionBar: %s", new Object[]{Integer.valueOf(dP), Integer.valueOf(identifier), Integer.valueOf(r3)});
            LayoutParams layoutParams = this.nhh.getLayoutParams();
            layoutParams.height = dP;
            this.nhh.setLayoutParams(layoutParams);
        }
    }

    public final com.tencent.mm.plugin.p.d aHh() {
        return (com.tencent.mm.plugin.p.d) this.activity.findViewById(R.h.bSq);
    }

    public final void ft(final boolean z) {
        a aVar;
        a aVar2;
        this.nhl = false;
        if (z) {
            aVar = new a(this, (float) (-(aHm() - this.nhj)));
            aVar2 = new a(this, (float) ((-(aHm() - this.nhj)) / 2));
        } else {
            aVar = new a(this, (float) (this.nhi - aHm()));
            aVar2 = new a(this, (float) ((this.nhi - aHm()) / 2));
        }
        AnimationListener anonymousClass15 = new AnimationListener(this) {
            final /* synthetic */ c nhD;

            public final void onAnimationStart(Animation animation) {
                w.d("MicroMsg.MMPoiMapUI", "newpoi start animation %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
                this.nhD.nhl = false;
                this.nhD.nhm = true;
            }

            public final void onAnimationEnd(Animation animation) {
                this.nhD.nhl = true;
                if (z) {
                    this.nhD.oI(this.nhD.nhj);
                    this.nhD.nhn = true;
                } else {
                    this.nhD.oI(this.nhD.nhi);
                    this.nhD.nhn = false;
                }
                this.nhD.nhh.clearAnimation();
                this.nhD.ngU.clearAnimation();
                this.nhD.nho.clearAnimation();
                this.nhD.ngO.clearFocus();
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        aVar.setDuration(200);
        aVar = aVar.aHq();
        aVar.setAnimationListener(anonymousClass15);
        aVar.ci(this.nhh).ci(this.ngU).ZB();
        aVar2.setDuration(200);
        aVar2.aHq().ci(this.nho).ZB();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        w.d("MicroMsg.MMPoiMapUI", "dispatchKeyEvent");
        if (this.nhf) {
            a(null);
            k(nhz, this.ngS.nhN, true);
            return false;
        }
        k(nhx, this.ngR.nhN, false);
        this.activity.finish();
        return true;
    }

    public final void a(f fVar) {
        this.hOd = "";
        this.nhf = false;
        this.ngQ.setVisibility(8);
        this.ngP.setVisibility(8);
        this.ngZ.setVisibility(8);
        this.ngZ.Ug("");
        this.nha.setVisibility(8);
        this.ngO.setVisibility(0);
        this.ngO.setAdapter(this.ngR);
        this.ngR.notifyDataSetChanged();
        findViewById(R.h.bVX).setVisibility(0);
        aHf();
        if (fVar != null) {
            this.ndG.getIController().setCenter(fVar.aKd, fVar.aKe);
            this.lat = fVar.aKd;
            this.lng = fVar.aKe;
            PickPoi pickPoi = this.ngN;
            pickPoi.i(this.lat, this.lng);
            pickPoi.nhJ = false;
            fu(false);
        }
    }

    public final void aHk() {
        int i = this.ngR.nhN;
        Intent intent = new Intent();
        Parcelable locationIntent = new LocationIntent();
        if (i >= 0 && i < this.ngR.getCount()) {
            f oJ = this.ngR.oJ(i);
            locationIntent.lat = oJ.aKd;
            locationIntent.lng = oJ.aKe;
            locationIntent.hCX = oJ.nid;
            locationIntent.ndv = oJ.mName;
            locationIntent.label = oJ.nhT;
            locationIntent.naS = oJ.nhU;
            locationIntent.sBR = oJ.type;
            locationIntent.fOd = this.ndG.getZoomLevel();
            switch (this.type) {
                case 0:
                    i = nhw;
                    int i2 = this.ngR.nhN;
                    if (this.nhA) {
                        i = nhy;
                    }
                    k(i, i2, false);
                    break;
            }
            intent.putExtra("KLocationIntent", locationIntent);
            this.activity.setResult(-1, intent);
            this.activity.finish();
        }
    }

    public final void aHi() {
        PickPoi pickPoi = this.ngN;
        pickPoi.ncQ.clearAnimation();
        pickPoi.ncQ.startAnimation(pickPoi.ncP);
        this.lat = ((double) this.ndG.getMapCenterX()) / 1000000.0d;
        this.lng = ((double) this.ndG.getMapCenterY()) / 1000000.0d;
        this.ngN.i(this.lat, this.lng);
        this.ngU.setBackgroundResource(R.g.bgm);
        if (this.nhn) {
            ft(false);
        }
        fu(false);
        this.nhA = false;
        this.ngR.nhA = false;
    }

    public final void aHl() {
        int i = 1;
        w.i("MicroMsg.MMPoiMapUI", "loadingmore");
        if (this.ngV != null) {
            w.i("MicroMsg.MMPoiMapUI", "scene is doing");
            return;
        }
        byte[] bArr;
        int i2;
        if (this.nhf) {
            if (this.ngS.buffer == null) {
                w.i("MicroMsg.MMPoiMapUI", "buffer is null");
                return;
            }
            bArr = this.ngS.buffer;
        } else if (this.ngR.buffer == null) {
            w.i("MicroMsg.MMPoiMapUI", "buffer is null");
            return;
        } else {
            bArr = this.ngR.buffer;
        }
        if (this.nhg == 0) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        double d = this.lat;
        double d2 = this.lng;
        if (this.nhf) {
            i = 0;
        }
        this.ngV = new h(bArr, d, d2, i2, i, (double) this.nhq, (double) this.nhp, this.nbf, this.hOd);
        ap.vd().a(this.ngV, 0);
        this.nhr++;
    }

    public final void fu(boolean z) {
        if (this.nhc != null) {
            this.nhc.remove();
        }
        this.nbf = ((int) (this.lat * 1000000.0d)) + "_" + ((int) (this.lng * 1000000.0d)) + "_" + this.hOd;
        if (this.nbf.equals(this.ngR.arH)) {
            w.i("MicroMsg.MMPoiMapUI", "same key passed it ", new Object[]{this.nbf});
            return;
        }
        byte[] bArr = null;
        Object obj = 1;
        if (!this.nhf) {
            this.ngO.bSi();
            this.ngR.clean();
            this.ngR.zF(this.nbf);
            this.ngR.notifyDataSetChanged();
            bArr = this.ngR.buffer;
            this.ngT.setVisibility(0);
            fv(false);
            if (this.ngN.nhJ) {
                this.ngR.b(this.ngN.nhI);
            }
        } else if (this.nbg > 0 && z) {
            this.ngP.bSi();
            e eVar = this.ngS;
            eVar.buffer = null;
            eVar.kgf = false;
            eVar.arH = "";
            this.ngS.zF(this.nbf);
            this.ngS.lJr = this.hOd;
            bArr = this.ngS.buffer;
        } else if (z) {
            obj = null;
        } else {
            this.ngP.bSi();
            this.ngS.clean();
            this.ngS.zF(this.nbf);
            this.ngS.lJr = this.hOd;
            bArr = this.ngS.buffer;
            this.ngS.notifyDataSetChanged();
        }
        if (obj != null) {
            this.ngV = new h(bArr, this.lat, this.lng, this.nhg == 0 ? 0 : 1, this.nhf ? 0 : 1, (double) this.nhq, (double) this.nhp, this.nbf, this.hOd);
            ap.vd().a(this.ngV, 0);
            this.nhr++;
            if (this.nhu == -1) {
                this.nhu = System.currentTimeMillis();
                return;
            }
            return;
        }
        w.i("MicroMsg.MMPoiMapUI", "pass this query because query interval: %d", new Object[]{Integer.valueOf(this.nbg)});
    }

    public final void k(int i, int i2, boolean z) {
        String str;
        Object obj;
        if (this.nhd == -85.0d || this.nhe == -1000.0d) {
            str = "null/null";
        } else {
            str = String.format("%f/%f", new Object[]{Double.valueOf(this.nhd), Double.valueOf(this.nhe)});
        }
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5;
        if (z) {
            if (this.ngS.nhN < this.ngS.getCount()) {
                str2 = this.ngS.oJ(this.ngS.nhN).nie;
                str3 = str2;
                str2 = this.ngS.oJ(this.ngS.nhN).nhU;
            }
            str5 = str3;
            str3 = str2;
            str2 = str5;
        } else {
            if (this.ngR.nhN < this.ngR.getCount()) {
                str2 = this.ngR.oJ(this.ngR.nhN).nie;
                str3 = str2;
                obj = this.ngR.oJ(this.ngR.nhN).nhU;
            }
            str5 = str3;
            str3 = str2;
            str2 = str5;
        }
        if (i2 == 0 && bg.mA(r2) && this.ngR.getCount() > 1) {
            w.d("MicroMsg.MMPoiMapUI", "set searchid in first poi");
            str3 = this.ngR.oJ(1).nie;
            str4 = this.ngR.oJ(this.ngR.nhN).nif;
        }
        w.d("MicroMsg.MMPoiMapUI", "tofutest type:%d, index: %d, startTime: %s, lastTime: %s, firsSuccTime: %s, poiCount: %s, latlng: %s, entryTime: %s, searchId: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nhu), Long.valueOf(this.nht), Long.valueOf(this.nhs), Integer.valueOf(this.nhr), str, Integer.valueOf(this.nhv), str3});
        com.tencent.mm.plugin.report.service.g.oUh.i(11135, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Long.valueOf(this.nhu), Long.valueOf(this.nht), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.nhs), Integer.valueOf(this.nhr), str, obj, Integer.valueOf(this.nhv), str3, p.rA(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str4});
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.modelgeo.c.Gk().b(this.gKp, true);
        com.tencent.mm.plugin.location.ui.e eVar = this.nhb;
        eVar.ndl.b(eVar.gKp, true);
    }

    public final int getLayoutId() {
        return R.i.dkH;
    }

    public final void onPause() {
        super.onPause();
        com.tencent.mm.modelgeo.c.Gk().c(this.gKp);
        com.tencent.mm.plugin.location.ui.e eVar = this.nhb;
        eVar.ndl.c(eVar.gKp);
    }

    private void fv(boolean z) {
        w.d("MicroMsg.MMPoiMapUI", "enable send.. %b", new Object[]{Boolean.valueOf(z)});
        this.ngX.setEnabled(z);
        findViewById(R.h.bmS).setEnabled(z);
        this.ngY.setEnabled(z);
    }

    public final void onDestroy() {
        super.onDestroy();
        ap.vd().b(457, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 457 && i == 0 && i2 == 0) {
            this.ngV = null;
            h hVar = (h) kVar;
            if (hVar.nbf.equals(this.nbf)) {
                w.i("MicroMsg.MMPoiMapUI", "isend " + hVar.kgf + "searchId: " + hVar.iGy);
                if (this.nhs == -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.nht = currentTimeMillis;
                    this.nhs = currentTimeMillis;
                } else {
                    this.nht = System.currentTimeMillis();
                }
                this.nbg = hVar.nbg;
                if (this.nhf) {
                    this.ngQ.setVisibility(8);
                    if (this.ngS.getCount() == 0 && hVar.fRK != null && hVar.fRK.size() == 0) {
                        this.nha.setVisibility(0);
                        this.ngP.bSi();
                        return;
                    }
                    w.d("MicroMsg.MMPoiMapUI", "search is first: %s", new Object[]{Boolean.valueOf(hVar.isFirst())});
                    if (hVar.isFirst()) {
                        this.ngS.nhM.clear();
                    }
                    this.ngS.a(hVar.fRK, hVar.nbe, hVar.kgf, hVar.nbf);
                    if (this.ngS.kgf) {
                        this.ngP.bSi();
                        return;
                    }
                    this.ngP.bSh();
                    this.ngP.bSj();
                    return;
                }
                if (this.ngM != null) {
                    zr zrVar = (zr) hVar.gUA.hsk.hsr;
                    PoiHeaderView poiHeaderView = this.ngM;
                    CharSequence charSequence = zrVar.tGa;
                    String str2 = zrVar.tFD;
                    String str3 = zrVar.msN;
                    ap.yY();
                    String xb = com.tencent.mm.u.c.xb();
                    w.d("MicroMsg.PoiHeaderView", "setContent, url:%s, logUrl:%s", new Object[]{str2, str3});
                    poiHeaderView.ndB = str3;
                    poiHeaderView.ndC = "";
                    if (bg.mA(charSequence) || bg.mA(str2)) {
                        poiHeaderView.setVisibility(8);
                        poiHeaderView.kvp.setVisibility(8);
                        poiHeaderView.ndD.setVisibility(8);
                    } else {
                        poiHeaderView.setVisibility(0);
                        poiHeaderView.kvp.setVisibility(0);
                        poiHeaderView.ndD.setVisibility(0);
                        poiHeaderView.kvp.setText(charSequence);
                        SimpleImageView simpleImageView = poiHeaderView.ndD;
                        simpleImageView.imagePath = xb;
                        simpleImageView.url = str2;
                        simpleImageView.neJ = 0;
                        simpleImageView.lKi = 0;
                        if (str2 == null || str2.length() == 0) {
                            simpleImageView.setVisibility(8);
                        } else if (str2.startsWith("http")) {
                            r0 = BitmapFactory.decodeFile(simpleImageView.imagePath + com.tencent.mm.a.g.n(str2.getBytes()));
                            if (r0 != null) {
                                if (simpleImageView.neJ > 0 && simpleImageView.lKi > 0) {
                                    r0 = com.tencent.mm.sdk.platformtools.d.a(r0, simpleImageView.neJ, simpleImageView.lKi, true, false);
                                }
                                simpleImageView.setImageBitmap(r0);
                            } else {
                                com.tencent.mm.sdk.f.e.post(new a(str2, simpleImageView.handler), "SimpleImageView_download");
                            }
                        } else if (com.tencent.mm.a.e.aO(str2)) {
                            r0 = (simpleImageView.neJ <= 0 || simpleImageView.lKi <= 0) ? com.tencent.mm.sdk.platformtools.d.Pg(str2) : com.tencent.mm.sdk.platformtools.d.d(str2, simpleImageView.neJ, simpleImageView.lKi, true);
                            if (r0 == null) {
                                simpleImageView.setVisibility(8);
                            } else {
                                simpleImageView.setImageBitmap(r0);
                            }
                        } else {
                            simpleImageView.setVisibility(8);
                        }
                    }
                }
                this.ngT.setVisibility(8);
                fv(true);
                if (this.ngW != null) {
                    for (f fVar : hVar.fRK) {
                        if (fVar.nhT != null && fVar.mName != null && fVar.nhT.equals(this.ngW.nhT) && fVar.mName.equals(this.ngW.mName)) {
                            hVar.fRK.remove(fVar);
                            break;
                        }
                    }
                    this.ngR.b(this.ngW);
                    this.ngW = null;
                    this.nhA = true;
                    this.ngR.nhA = true;
                }
                this.ngR.a(hVar.fRK, hVar.nbe, hVar.kgf, hVar.nbf);
                this.ngR.nhN = 0;
                this.ngR.notifyDataSetChanged();
                if (this.ngR.kgf) {
                    this.ngO.bSi();
                    return;
                }
                this.ngO.bSh();
                this.ngO.bSj();
                return;
            }
            w.i("MicroMsg.MMPoiMapUI", "pass this resp!" + this.nbf + " " + hVar.nbf);
        }
    }

    public final void oI(int i) {
        ((FrameLayout.LayoutParams) this.nhh.getLayoutParams()).topMargin = i;
        ((FrameLayout.LayoutParams) this.ngU.getLayoutParams()).topMargin = i - b.a(this.activity, 65.0f);
        int i2 = (i - this.nhk) / 2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nho.getLayoutParams();
        if (i == this.nhj) {
            layoutParams.topMargin = b.a(this.activity, -65.0f);
        } else if (i == this.nhi) {
            layoutParams.topMargin = 0;
        } else {
            layoutParams.topMargin = i2 + layoutParams.topMargin;
        }
        this.nho.requestLayout();
        this.nhk = i;
        this.nhh.requestLayout();
        this.ngU.requestLayout();
    }

    public final int aHm() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nhh.getLayoutParams();
        this.nhk = marginLayoutParams.topMargin;
        return marginLayoutParams.topMargin;
    }
}
