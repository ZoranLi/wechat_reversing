package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView;
import com.tencent.mm.plugin.sight.encode.ui.MainSightSelectContactView;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView;
import com.tencent.mm.plugin.sight.encode.ui.b;
import com.tencent.mm.plugin.sight.encode.ui.c;
import com.tencent.mm.pluginsdk.m.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import java.util.HashSet;

public class SightForwardUI extends MMActivity {
    private String aGN;
    private MainSightForwardContainerView wrq;

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        cO().cP().hide();
        this.aGN = getIntent().getStringExtra("sight_local_path");
        if (!d.Eq(this.aGN)) {
            w.e("MicroMsg.SightForwardUI", "Path:%s, NOT SIGHT!", new Object[]{this.aGN});
            finish();
        } else if (ap.zb()) {
            String lu = s.lu(String.valueOf(SystemClock.elapsedRealtime()));
            o.KV();
            lu = s.lv(lu);
            if (e.p(this.aGN, lu) <= 0) {
                w.e("MicroMsg.SightForwardUI", "Copy File %s to %s FAIL!", new Object[]{this.aGN, lu});
                finish();
                return;
            }
            this.aGN = lu;
            w.i("MicroMsg.SightForwardUI", "Doing Forward Sight, path %s", new Object[]{this.aGN});
            this.wrq = (MainSightForwardContainerView) findViewById(R.h.bRe);
            this.wrq.pwY = new b(this) {
                final /* synthetic */ SightForwardUI wrr;

                {
                    this.wrr = r1;
                }

                public final void Et(String str) {
                    Intent intent = new Intent(this.wrr.uSU.uTo, En_5b8fbb1e.class);
                    intent.addFlags(67108864);
                    intent.putExtra("Chat_User", str);
                    this.wrr.startActivity(intent);
                    this.wrr.finish();
                }

                public final void bcO() {
                    Intent intent = new Intent();
                    intent.setClass(this.wrr.uSU.uTo, LauncherUI.class).addFlags(67108864);
                    this.wrr.startActivity(intent);
                    this.wrr.finish();
                }
            };
            MainSightForwardContainerView mainSightForwardContainerView = this.wrq;
            lu = this.aGN;
            mainSightForwardContainerView.pxk = this;
            mainSightForwardContainerView.pxg = lu;
            mainSightForwardContainerView.pxe = g.aV(lu);
            long currentTimeMillis = System.currentTimeMillis();
            mainSightForwardContainerView.pxh = 1.3333334f;
            mainSightForwardContainerView.pwX = (SightCameraView) ((ViewStub) mainSightForwardContainerView.findViewById(R.h.bvI)).inflate();
            mainSightForwardContainerView.pwX.sL(a.nCZ);
            mainSightForwardContainerView.pwX.ak(mainSightForwardContainerView.pxh);
            mainSightForwardContainerView.pwX.setVisibility(0);
            mainSightForwardContainerView.pxb = mainSightForwardContainerView.findViewById(R.h.cJu);
            mainSightForwardContainerView.pxb.setLayoutParams(new LayoutParams(-1, cO().cP().getHeight()));
            mainSightForwardContainerView.pxa = mainSightForwardContainerView.findViewById(R.h.cgS);
            mainSightForwardContainerView.ntw = mainSightForwardContainerView.findViewById(R.h.cgT);
            mainSightForwardContainerView.pwZ = mainSightForwardContainerView.findViewById(R.h.bvH);
            mainSightForwardContainerView.pxa.setOnClickListener(new OnClickListener(mainSightForwardContainerView) {
                final /* synthetic */ MainSightForwardContainerView pxp;

                {
                    this.pxp = r1;
                }

                public final void onClick(View view) {
                    this.pxp.hi(true);
                }
            });
            mainSightForwardContainerView.ntw.setOnClickListener(new OnClickListener(mainSightForwardContainerView) {
                final /* synthetic */ MainSightForwardContainerView pxp;

                {
                    this.pxp = r1;
                }

                public final void onClick(View view) {
                    this.pxp.aAh();
                }
            });
            mainSightForwardContainerView.bcN();
            w.d("MicroMsg.MainSightContainerView", "init concrol view use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.wrq.bcM();
            mainSightForwardContainerView = this.wrq;
            if (mainSightForwardContainerView.pwW == null) {
                DisplayMetrics displayMetrics = mainSightForwardContainerView.getResources().getDisplayMetrics();
                float f = ((float) displayMetrics.widthPixels) / mainSightForwardContainerView.pxh;
                mainSightForwardContainerView.pwW = (MainSightSelectContactView) mainSightForwardContainerView.findViewById(R.h.cBO);
                com.tencent.mm.plugin.sight.encode.ui.d.a aVar = mainSightForwardContainerView.pwW;
                MMFragmentActivity mMFragmentActivity = mainSightForwardContainerView.pxk;
                int i = (int) (((float) displayMetrics.heightPixels) - f);
                int i2 = displayMetrics.heightPixels;
                aVar.pxk = mMFragmentActivity;
                aVar.pxJ = i;
                aVar.pxO = mainSightForwardContainerView;
                aVar.addView(View.inflate(aVar.getContext(), R.i.dhG, null), -1, -2);
                aVar.Fg = (ListView) aVar.findViewById(R.h.cBN);
                aVar.pxM = new c(aVar);
                aVar.pxP = new LinearLayout(aVar.getContext());
                aVar.pxP.addView(new View(aVar.getContext()), -1, aVar.pxO.bcJ() - aVar.pxJ);
                aVar.pxP.getChildAt(0).setBackgroundColor(0);
                aVar.Fg.addHeaderView(aVar.pxP);
                aVar.Fg.setAdapter(aVar.pxM);
                aVar.Fg.setOnItemClickListener(mainSightForwardContainerView);
                aVar.pxT = new HashSet();
                aVar.pxU = new HashSet();
                aVar.Fg.setOnScrollListener(aVar);
                aVar.pxK = new com.tencent.mm.plugin.sight.encode.ui.d();
                aVar.pxK.pxF = aVar;
                MainSightSelectContactView mainSightSelectContactView = mainSightForwardContainerView.pwW;
                View findViewById = mainSightForwardContainerView.findViewById(R.h.cBe);
                Object obj = mainSightSelectContactView.pxK;
                obj.pxB = findViewById;
                obj.pxz = (EditText) findViewById.findViewById(R.h.bKP);
                obj.pxA = (TextView) findViewById.findViewById(R.h.cAm);
                obj.pxz.setOnFocusChangeListener(obj);
                obj.pxz.addTextChangedListener(obj);
                obj.pxA.setOnClickListener(obj);
                obj.pxD = (InputMethodManager) findViewById.getContext().getSystemService("input_method");
                mainSightForwardContainerView.pwW.pxN = mainSightForwardContainerView.findViewById(R.h.bLL);
                mainSightForwardContainerView.pwW.pxO = mainSightForwardContainerView;
            }
            mainSightForwardContainerView.hj(true);
            mainSightForwardContainerView.pwX.postDelayed(new Runnable(mainSightForwardContainerView) {
                final /* synthetic */ MainSightForwardContainerView pxp;

                {
                    this.pxp = r1;
                }

                public final void run() {
                    MainSightSelectContactView a = this.pxp.pwW;
                    a.pxf = false;
                    a.Fg.clearAnimation();
                    a.Fg.clearFocus();
                    a.Fg.setAdapter(a.pxM);
                    a.s(false, true);
                    a.setVisibility(0);
                    if (a.pxL == null) {
                        a.pxL = new TranslateAnimation(0.0f, 0.0f, (float) a.pxJ, 0.0f);
                        a.pxL.setDuration(300);
                    }
                    a.Fg.startAnimation(a.pxL);
                }
            }, 50);
        } else {
            w.e("MicroMsg.SightForwardUI", "acc not ready");
            finish();
        }
    }

    protected final int getLayoutId() {
        return R.i.dhF;
    }

    protected void onResume() {
        super.onResume();
        this.wrq.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.wrq.onPause();
    }
}
