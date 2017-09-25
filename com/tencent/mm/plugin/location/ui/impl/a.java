package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.ui.RemarkUI;
import com.tencent.mm.plugin.location.ui.c;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public abstract class a extends com.tencent.mm.plugin.p.a {
    public Activity activity;
    ae handler = new ae(Looper.getMainLooper());
    protected ProgressDialog isv = null;
    protected float jWC = 0.0f;
    DisplayMetrics mBC = null;
    protected float mxi = 0.0f;
    protected String ncV;
    protected String nci = "";
    protected String ndv = "";
    public String ngh = "";
    protected boolean ngi = false;
    public boolean ngj = false;
    protected Addr ngk = null;
    protected d ngl;
    protected LocationInfo ngm = new LocationInfo((byte) 0);
    protected LocationInfo ngn = new LocationInfo((byte) 0);
    protected a ngo;
    protected boolean ngp = false;
    protected HashMap<String, c> ngq = new HashMap();
    protected b ngr;
    protected boolean ngs = false;
    protected int ngt = 0;
    protected ArrayList<String> ngu = new ArrayList();
    protected boolean ngv = false;
    protected boolean ngw = false;
    protected com.tencent.mm.plugin.location.model.c ngx = null;
    protected com.tencent.mm.modelgeo.c ngy;
    public com.tencent.mm.modelgeo.b.a ngz = new com.tencent.mm.modelgeo.b.a(this) {
        final /* synthetic */ a ngA;

        {
            this.ngA = r1;
        }

        public final void b(Addr addr) {
            w.d("MicroMsg.BaseMapUI", "onGetAddrss  %s", new Object[]{addr.toString()});
            this.ngA.ngk = addr;
            String str = addr.hCG;
            String Gh = addr.Gh();
            this.ngA.ngn.fRX = this.ngA.activity.getResources().getString(R.l.ewp);
            if (addr.tag != null && addr.tag.equals(this.ngA.ngn.naN)) {
                this.ngA.ngn.naQ = Gh;
            } else if (!bg.mA(addr.hCE)) {
                this.ngA.ngo.ngC.setVisibility(0);
            }
            if (addr.tag != null && this.ngA.ngq.containsKey(addr.tag)) {
                c cVar = (c) this.ngA.ngq.get(addr.tag);
                cVar.setText(cVar.aGw() + Gh);
            }
            float f = addr.hCQ;
            f = addr.hCP;
        }
    };
    protected int type = 0;
    int zoom;

    class a {
        com.tencent.mm.plugin.p.d ndu;
        final /* synthetic */ a ngA;
        FrameLayout ngB;
        RelativeLayout ngC;
        View ngD;
        ImageButton ngE;
        View ngF;
        TextView ngG;
        TextView ngH;
        TextView ngI;
        TextView ngJ;
        TextView ngK;
        TextView titleView;

        a(a aVar) {
            this.ngA = aVar;
        }
    }

    protected abstract String Oh();

    protected abstract void aHd();

    abstract void aHe();

    public a(Activity activity) {
        this.activity = activity;
        this.ngr = b.Gi();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onBackPressed() {
        this.activity.finish();
    }

    protected final void a(n nVar) {
        this.ngo.ndu.addLocationPin(nVar.ndt);
    }

    public void onCreate(Bundle bundle) {
        this.ngy = com.tencent.mm.modelgeo.c.Gk();
        LocationInfo locationInfo = this.ngn;
        LocationInfo locationInfo2 = this.ngm;
        String d = v.d(ab.bIY());
        w.d("MicroMsg.BaseMapUI", " initLanguage " + d);
        if (d.equals("language_default")) {
            v.a(this.activity, Locale.ENGLISH);
            d = "en";
        } else {
            v.a(this.activity, v.Po(d));
        }
        locationInfo2.naR = d;
        locationInfo.naR = d;
        w.d("MicroMsg.BaseMapUI", "sosomap " + this.ngm.naR);
        this.activity.requestWindowFeature(1);
        this.activity.setContentView(R.i.dfy);
        ((FrameLayout) findViewById(R.h.ciM)).addView(d.cv(this.activity));
        this.ngl = new d(this.activity);
        this.ngo = new a(this);
        this.ncV = this.activity.getIntent().getStringExtra("kRemark");
        this.ngu = this.activity.getIntent().getStringArrayListExtra("kTags");
        this.type = this.activity.getIntent().getIntExtra("map_view_type", 0);
        this.ngj = this.activity.getIntent().getBooleanExtra("kIs_pick_poi", false);
        w.i("MicroMsg.BaseMapUI", "isPickPoi " + this.ngj);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        w.d("MicroMsg.BaseMapUI", "dispatchKeyEvent");
        aHd();
        this.activity.finish();
        return true;
    }

    public void onResume() {
        x.a(true, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onPause() {
        x.a(false, new Intent().putExtra("classname", getClass().getName()));
    }

    public void onDestroy() {
        this.ngr.a(this.ngz);
        w.d("MicroMsg.BaseMapUI", "destory");
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        System.gc();
    }

    public final String getString(int i) {
        return this.activity.getString(i);
    }

    protected final void aHa() {
        if (this.ngo.ngI != null && this.ngo.ngJ != null) {
            this.ngo.ngI.setText(h.b(this.ngo.ngI.getContext(), this.ncV, this.ngo.ngI.getTextSize()));
            if (this.ngu == null || this.ngu.isEmpty()) {
                this.ngo.ngJ.setText("");
                return;
            }
            CharSequence charSequence = (String) this.ngu.get(0);
            String string = this.activity.getResources().getString(R.l.ejD);
            int i = 1;
            while (i < this.ngu.size()) {
                String str = charSequence + string + ((String) this.ngu.get(i));
                i++;
                Object obj = str;
            }
            this.ngo.ngJ.setText(h.b(this.ngo.ngJ.getContext(), charSequence, this.ngo.ngJ.getTextSize()));
        }
    }

    protected final void aHb() {
        this.ngo.ngC.removeAllViews();
        View inflate = View.inflate(this.activity, R.i.dgP, null);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.ngo.ngC.addView(inflate, layoutParams);
        this.ngo.ngI = (TextView) inflate.findViewById(R.h.ccl);
        this.ngo.ngI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a ngA;

            {
                this.ngA = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.ngA.activity, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", this.ngA.aHc());
                intent.putExtra("key_hint", this.ngA.getString(R.l.ewv));
                intent.putExtra("Kwebmap_locaion", this.ngA.ngm.naQ);
                intent.putExtra("kFavInfoLocalId", this.ngA.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", this.ngA.activity.getIntent().getStringExtra("kRemark"));
                this.ngA.activity.startActivityForResult(intent, Downloads.RECV_BUFFER_SIZE);
            }
        });
        this.ngo.ngJ = (TextView) inflate.findViewById(R.h.ccp);
        this.ngo.ngJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a ngA;

            {
                this.ngA = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_item_id", this.ngA.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("key_fav_result_list", this.ngA.activity.getIntent().getStringArrayListExtra("kTags"));
                com.tencent.mm.bb.d.b(this.ngA.activity, "favorite", ".ui.FavTagEditUI", intent, 4100);
            }
        });
        aHa();
    }

    protected final String aHc() {
        return bg.ap(this.ncV, "");
    }

    protected final boolean c(LocationInfo locationInfo) {
        if (this.ngo.ndu.getIController() == null || !e.f(locationInfo.naO, locationInfo.naP)) {
            return false;
        }
        this.ngo.ndu.getIController().animateTo(locationInfo.naO, locationInfo.naP);
        return true;
    }

    public final View findViewById(int i) {
        return this.activity.findViewById(i);
    }

    protected final void KC() {
        w.d("MicroMsg.BaseMapUI", "initView");
        this.ngo.ndu = (com.tencent.mm.plugin.p.d) findViewById(R.h.bSq);
        this.ngo.ngB = (FrameLayout) findViewById(R.h.bGH);
        this.ngo.ngC = (RelativeLayout) findViewById(R.h.cIP);
        this.ngo.ngD = findViewById(R.h.cIW);
        this.ngo.ngE = (ImageButton) findViewById(R.h.cIX);
        this.ngo.ngF = findViewById(R.h.cIY);
        this.ngo.ngG = (TextView) findViewById(R.h.bmS);
        this.ngo.titleView = (TextView) findViewById(R.h.cjU);
        this.ngo.ngK = (TextView) findViewById(R.h.cll);
        this.ngo.titleView.setText(Oh());
        this.ngo.ndu.getIController().setZoom(d.fn(false));
        if (!(this.type == 0 || this.type == 3)) {
            this.ngo.ngE.setVisibility(0);
            this.ngo.ngF.setVisibility(8);
            this.ngo.ngE.setEnabled(false);
            this.ngo.ngE.setImageResource(R.g.bhb);
        }
        this.ngo.ndu.setBuiltInZoomControls(false);
        this.ngo.ngD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a ngA;

            {
                this.ngA = r1;
            }

            public final void onClick(View view) {
                this.ngA.aHd();
                this.ngA.aHf();
                this.ngA.activity.finish();
            }
        });
        this.ngo.ngG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a ngA;

            {
                this.ngA = r1;
            }

            public final void onClick(View view) {
            }
        });
        aHe();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2) {
            if (Downloads.RECV_BUFFER_SIZE == i) {
                if (this.ngo.ngI != null) {
                    CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                    this.ncV = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                    aHa();
                }
            } else if (4100 == i && this.ngo.ngJ != null) {
                this.ngu = intent.getStringArrayListExtra("key_fav_result_list");
                aHa();
            }
        }
    }

    protected final void aHf() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.activity.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    public boolean aHg() {
        return true;
    }
}
