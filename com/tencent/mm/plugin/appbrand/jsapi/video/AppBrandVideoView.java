package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView extends RelativeLayout {
    private boolean iWA;
    private boolean iWB;
    private b iWg = b.AUTO;
    AppBrandVideoWrapper iWh;
    private TextView iWi;
    private DanmuView iWj;
    AppBrandVideoViewControlBar iWk;
    private View iWl;
    TextView iWm;
    private LinearLayout iWn;
    private AppBrandDotPercentIndicator iWo;
    private TextView iWp;
    private ImageView iWq;
    String iWr;
    int iWs;
    boolean iWt;
    private boolean iWu;
    e iWv;
    private boolean iWw;
    private boolean iWx;
    private f iWy;
    a iWz;
    String ivH;

    public interface a {
        void Uk();

        void bW(boolean z);

        boolean isFullScreen();
    }

    private enum b {
        AUTO,
        LANDSCAPE,
        PORTRAIT
    }

    public AppBrandVideoView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.i.cUz, this);
        this.iWh = (AppBrandVideoWrapper) findViewById(R.h.cMo);
        this.iWi = (TextView) findViewById(R.h.progress);
        this.iWl = findViewById(R.h.bGZ);
        this.iWm = (TextView) findViewById(R.h.bHe);
        this.iWn = (LinearLayout) findViewById(R.h.bnQ);
        this.iWo = (AppBrandDotPercentIndicator) findViewById(R.h.bnR);
        this.iWp = (TextView) findViewById(R.h.bnO);
        this.iWq = (ImageView) findViewById(R.h.bnP);
        ViewGroup viewGroup = this.iWo;
        viewGroup.iVO = 8;
        viewGroup.removeAllViews();
        for (int i = 0; i < viewGroup.iVO; i++) {
            viewGroup.addView((ImageView) viewGroup.Du.inflate(R.i.cTW, viewGroup, false));
        }
        ((ImageView) findViewById(R.h.bHd)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final void onClick(View view) {
                this.iWC.start();
            }
        });
        this.iWy = new f(getContext(), this, new com.tencent.mm.plugin.appbrand.jsapi.video.f.b(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final void TX() {
                w.d("MicroMsg.AppBrandVideoView", "onSingleTap");
                if (this.iWC.iWu) {
                    this.iWC.iWk.Uo();
                }
            }

            public final void TY() {
                w.d("MicroMsg.AppBrandVideoView", "onDoubleTap");
            }

            public final void TZ() {
                if (this.iWC.iWh.Ux()) {
                    w.i("MicroMsg.AppBrandVideoView", "onStartDragProgress isLive: no seek");
                } else {
                    this.iWC.iWi.setVisibility(0);
                }
            }

            public final int d(int i, float f) {
                int i2 = 0;
                if (this.iWC.iWh.Ux()) {
                    w.i("MicroMsg.AppBrandVideoView", "onDragProgress isLive: no seek");
                } else {
                    w.i("MicroMsg.AppBrandVideoView", "onDragProgress:" + i + "/" + f);
                    float measuredWidth = f / ((float) this.iWC.getMeasuredWidth());
                    int Uu = this.iWC.iWh.Uu();
                    int currentPosition = ((int) (measuredWidth * ((float) Uu))) + getCurrentPosition();
                    if (currentPosition >= 0) {
                        if (currentPosition > Uu) {
                            i2 = Uu;
                        } else {
                            i2 = currentPosition;
                        }
                    }
                    this.iWC.iWi.setText(g.aq(((long) i2) * 1000) + "/" + g.aq(((long) Uu) * 1000));
                }
                return i2;
            }

            public final void e(int i, float f) {
                this.iWC.iWi.setVisibility(8);
                int Uw = this.iWC.iWh.Uw();
                w.i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(Uw), Float.valueOf(f)});
                if (this.iWC.iWh.Ux()) {
                    w.i("MicroMsg.AppBrandVideoView", "onEndDragProgress isLive: no seek");
                } else {
                    this.iWC.z(i, false);
                }
            }

            public final int getCurrentPosition() {
                return this.iWC.iWh.Uw();
            }

            public final void L(float f) {
                w.d("MicroMsg.AppBrandVideoView", "onAdjustVolume:" + f);
                this.iWC.iWo.K(f);
                this.iWC.iWp.setText(R.l.dGl);
                this.iWC.iWq.setImageResource(R.k.dtT);
                this.iWC.iWn.setVisibility(0);
            }

            public final void M(float f) {
                w.d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:" + f);
                this.iWC.iWo.K(f);
                this.iWC.iWp.setText(R.l.dGk);
                this.iWC.iWq.setImageResource(R.k.dtI);
                this.iWC.iWn.setVisibility(0);
            }

            public final void Ua() {
                this.iWC.iWn.setVisibility(8);
            }

            public final void Ub() {
                this.iWC.iWn.setVisibility(8);
            }
        });
        this.iWh.iWV = new com.tencent.mm.pluginsdk.ui.h.b(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final void onError(int i, int i2) {
                w.i("MicroMsg.AppBrandVideoView", "onError what=%d extra=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (this.iWC.iWv != null) {
                    e c = this.iWC.iWv;
                    w.e("MicroMsg.JsApiVideoCallback", "onError");
                    c.clean();
                }
            }

            public final void Uc() {
                w.i("MicroMsg.AppBrandVideoView", "onPrepared");
                f l = this.iWC.iWy;
                l.iXw = -1;
                l.iXx = 0;
                l.iXv = 0.0f;
            }

            public final void Ud() {
                w.i("MicroMsg.AppBrandVideoView", "onVideoEnded");
                if (this.iWC.iWm.getTag() == null) {
                    this.iWC.iWm.setText(AppBrandVideoView.hP(this.iWC.iWh.Uu()));
                }
                this.iWC.iWl.setVisibility(0);
                if (this.iWC.iWv != null) {
                    e c = this.iWC.iWv;
                    try {
                        c.a(new b(), c.UB());
                    } catch (JSONException e) {
                        w.e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[]{e});
                    }
                    c.UC();
                }
                if (this.iWC.iWB) {
                    this.iWC.z(0, true);
                }
            }

            public final void bp(int i, int i2) {
                w.i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (this.iWC.iWg == b.AUTO) {
                    this.iWC.iWg = i < i2 ? b.PORTRAIT : b.LANDSCAPE;
                    w.i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[]{this.iWC.iWg});
                }
            }

            public final void Ue() {
                w.i("MicroMsg.AppBrandVideoView", "onVideoPause");
                if (this.iWC.iWv != null) {
                    e c = this.iWC.iWv;
                    try {
                        c.a(new d(), c.UB());
                    } catch (JSONException e) {
                        w.e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", new Object[]{e});
                    }
                    c.UC();
                }
            }

            public final void Uf() {
                w.i("MicroMsg.AppBrandVideoView", "onVideoPlay");
                if (this.iWC.iWm.getTag() == null) {
                    this.iWC.iWm.setText(AppBrandVideoView.hP(this.iWC.iWh.Uu()));
                }
                if (this.iWC.iWu) {
                    this.iWC.iWk.Un();
                }
                if (this.iWC.iWv != null) {
                    e c = this.iWC.iWv;
                    try {
                        c.iXo = 0;
                        c.a(new e(), c.UB());
                        if (c.iXn == null) {
                            c.iXn = new aj(new com.tencent.mm.sdk.platformtools.aj.a(c) {
                                final /* synthetic */ e iXp;

                                {
                                    this.iXp = r1;
                                }

                                public final boolean oQ() {
                                    try {
                                        int Uv = this.iXp.iXl.iWh.Uv();
                                        if (Math.abs(Uv - this.iXp.iXo) >= 250) {
                                            JSONObject UB = this.iXp.UB();
                                            this.iXp.iXo = Uv;
                                            UB.put("position", this.iXp.iXl.iWh.Uw());
                                            this.iXp.a(new f(), UB);
                                        }
                                    } catch (JSONException e) {
                                        w.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", new Object[]{e});
                                    }
                                    return true;
                                }
                            }, true);
                        }
                        c.iXn.v(250, 250);
                    } catch (JSONException e) {
                        w.e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[]{e});
                    }
                }
            }
        };
        this.iWk = new AppBrandVideoViewControlBar(getContext());
        this.iWk.setVisibility(8);
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.iWk;
        appBrandVideoViewControlBar.iWH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final void onClick(View view) {
                this.iWC.bT(!this.iWC.TV());
            }
        });
        this.iWk.puM = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final void Uh() {
                w.i("MicroMsg.AppBrandVideoView", "onSeekPre");
            }

            public final void hR(int i) {
                this.iWC.z(i, false);
            }
        };
        this.iWk.d(new OnClickListener(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final void onClick(View view) {
                if (this.iWC.iWh.isPlaying()) {
                    this.iWC.pause();
                } else {
                    this.iWC.start();
                }
            }
        });
        this.iWk.iWM = new com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.b(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final int Ui() {
                return this.iWC.iWh.KI();
            }

            public final int Uj() {
                return this.iWC.iWh.Uu();
            }
        };
        this.iWh.a(this.iWk);
    }

    public final void bN(boolean z) {
        w.i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", new Object[]{Boolean.valueOf(z)});
        this.iWB = z;
    }

    public final void start() {
        w.i("MicroMsg.AppBrandVideoView", "start");
        if (!this.iWh.isPlaying()) {
            if (this.iWu) {
                AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.iWk;
                if (appBrandVideoViewControlBar.iWO == null) {
                    appBrandVideoViewControlBar.iWO = new aj(new com.tencent.mm.sdk.platformtools.aj.a(appBrandVideoViewControlBar) {
                        final /* synthetic */ AppBrandVideoViewControlBar iWT;

                        {
                            this.iWT = r1;
                        }

                        public final boolean oQ() {
                            if (this.iWT.Uq()) {
                                return true;
                            }
                            return false;
                        }
                    }, true);
                }
                appBrandVideoViewControlBar.Uq();
                appBrandVideoViewControlBar.iWO.KH();
                appBrandVideoViewControlBar.iWO.v(500, 500);
            }
            this.iWl.setVisibility(8);
            this.iWh.start();
            if (this.iWj != null && this.iWk.iWQ) {
                this.iWj.show();
            }
        }
    }

    public final void pause() {
        w.i("MicroMsg.AppBrandVideoView", "pause");
        if (this.iWh.isPlaying()) {
            this.iWh.pause();
            if (this.iWj != null && this.iWk.iWQ) {
                this.iWj.pause();
            }
        }
    }

    public final void stop() {
        w.i("MicroMsg.AppBrandVideoView", "stop");
        if (this.iWh.isPlaying()) {
            this.iWh.stop();
            AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.iWk;
            if (appBrandVideoViewControlBar.iWO != null) {
                appBrandVideoViewControlBar.iWO.KH();
            }
            if (this.iWj != null) {
                this.iWj.hide();
            }
        }
    }

    public final void clean() {
        w.i("MicroMsg.AppBrandVideoView", "clean");
        stop();
        this.iWh.Uy();
        if (this.iWj != null) {
            DanmuView danmuView = this.iWj;
            danmuView.status = 3;
            danmuView.UL();
            danmuView.iYb.clear();
            danmuView.invalidate();
        }
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.iWk;
        if (appBrandVideoViewControlBar.iWO != null) {
            appBrandVideoViewControlBar.iWO.KH();
        }
        if (appBrandVideoViewControlBar.iWN != null) {
            appBrandVideoViewControlBar.iWN.KH();
        }
    }

    public final void e(String str, boolean z, int i) {
        w.i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[]{str, Boolean.valueOf(z)});
        if (bg.mA(str)) {
            w.v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
            return;
        }
        stop();
        this.iWA = z;
        AppBrandVideoWrapper appBrandVideoWrapper = this.iWh;
        if (!bg.mA(str) && str.startsWith("wxfile://")) {
            w.i("MicroMsg.AppBrandVideoView", "convertPath appid=%s path=%s", new Object[]{this.ivH, str});
            AppBrandLocalMediaObject aH = c.aH(this.ivH, str);
            if (aH == null) {
                w.e("MicroMsg.AppBrandVideoView", "convertPath AppBrandLocalMediaObject null");
            } else {
                if (bg.mA(aH.hos)) {
                    w.e("MicroMsg.AppBrandVideoView", "convertPath fileFullPath null");
                } else {
                    str = String.format("%s%s", new Object[]{"wxfile://", aH.hos});
                    w.i("MicroMsg.AppBrandVideoView", "convertPath convertedPath=%s", new Object[]{str});
                }
            }
        }
        appBrandVideoWrapper.b(z, str, i);
        if (this.iWt) {
            w.i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
            start();
        }
    }

    public final void z(int i, boolean z) {
        w.i("MicroMsg.AppBrandVideoView", "seek to position=%d current=%d isLive=%b", new Object[]{Integer.valueOf(i), Integer.valueOf(this.iWh.Uw()), Boolean.valueOf(this.iWA)});
        if (!this.iWA) {
            this.iWl.setVisibility(8);
            if (z) {
                this.iWh.w(i, z);
            } else {
                this.iWh.hS(i);
            }
            if (this.iWj != null && r0 > i) {
                DanmuView danmuView = this.iWj;
                w.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[]{Integer.valueOf(i)});
                danmuView.UJ();
                danmuView.UL();
                danmuView.prepare();
                e.post(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass5(danmuView, i), "DanmuView-seekToPlayTime");
            }
        }
    }

    public final void bO(boolean z) {
        w.i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[]{Boolean.valueOf(z)});
        this.iWu = z;
    }

    public final void aY(String str, String str2) {
        w.i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", new Object[]{str});
        if (!bg.mA(str)) {
            ImageView imageView = (ImageView) findViewById(R.h.bGY);
            if (!bg.mA(str2)) {
                if ("fill".equalsIgnoreCase(str2)) {
                    imageView.setScaleType(ScaleType.FIT_XY);
                } else if ("cover".equalsIgnoreCase(str2)) {
                    imageView.setScaleType(ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ScaleType.FIT_CENTER);
                }
            }
            com.tencent.mm.modelappbrand.a.b.AY().a(imageView, str, null, null);
        }
    }

    public final void bP(boolean z) {
        AppBrandVideoViewControlBar appBrandVideoViewControlBar;
        w.i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            if (this.iWj == null) {
                TW();
            }
            appBrandVideoViewControlBar = this.iWk;
            appBrandVideoViewControlBar.iWI.setOnClickListener(new com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.AnonymousClass1(appBrandVideoViewControlBar, new com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.a(this) {
                final /* synthetic */ AppBrandVideoView iWC;

                {
                    this.iWC = r1;
                }

                public final void bV(boolean z) {
                    if (!z) {
                        this.iWC.iWj.hide();
                    } else if (this.iWC.iWh.isPlaying()) {
                        this.iWC.iWj.show();
                    } else {
                        this.iWC.iWj.pause();
                    }
                    if (this.iWC.iWv != null) {
                        e c = this.iWC.iWv;
                        int d = this.iWC.iWs;
                        try {
                            w.i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[]{Boolean.valueOf(z)});
                            JSONObject UB = c.UB();
                            UB.put("showDanmu", z);
                            UB.put("videoPlayerId", d);
                            c.a(new a(), UB);
                        } catch (JSONException e) {
                            w.e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[]{e});
                        }
                    }
                }
            }));
        }
        appBrandVideoViewControlBar = this.iWk;
        if (z) {
            appBrandVideoViewControlBar.iWI.setVisibility(0);
        } else {
            appBrandVideoViewControlBar.iWI.setVisibility(8);
        }
    }

    public final void pC(String str) {
        w.i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", new Object[]{str});
        if ("fill".equalsIgnoreCase(str)) {
            this.iWh.a(d.sIW);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.iWh.a(d.sIY);
        } else {
            this.iWh.a(d.sIX);
        }
    }

    public final void bQ(boolean z) {
        w.i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", new Object[]{Boolean.valueOf(z)});
        this.iWh.bQ(z);
    }

    public final void pD(String str) {
        w.i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %s", new Object[]{str});
        if ("horizontal".equalsIgnoreCase(str)) {
            this.iWg = b.LANDSCAPE;
        } else if ("vertical".equalsIgnoreCase(str)) {
            this.iWg = b.PORTRAIT;
        } else {
            this.iWg = b.AUTO;
        }
    }

    public final void bR(boolean z) {
        w.i("MicroMsg.AppBrandVideoView", "setDisableScroll isDisableScroll=%b", new Object[]{Boolean.valueOf(z)});
        this.iWw = z;
    }

    public final void bS(boolean z) {
        w.i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", new Object[]{Boolean.valueOf(z)});
        this.iWx = z;
    }

    public final void i(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            String str = "MicroMsg.AppBrandVideoView";
            String str2 = "setDanmakuItemList length=%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(jSONArray != null ? jSONArray.length() : 0);
            w.i(str, str2, objArr);
            if (this.iWj == null) {
                w.w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
                TW();
            }
            List arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d l = l(jSONArray.optJSONObject(i));
                if (l != null) {
                    arrayList.add(l);
                }
                i++;
            }
            DanmuView danmuView = this.iWj;
            danmuView.UJ();
            danmuView.UL();
            danmuView.iYb.clear();
            danmuView.prepare();
            if (arrayList.isEmpty()) {
                danmuView.UK();
                return;
            }
            new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass4(danmuView, arrayList).start();
            danmuView.UK();
        }
    }

    public final boolean aZ(String str, String str2) {
        int parseColor;
        if (this.iWj == null) {
            w.w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
            TW();
        }
        try {
            parseColor = Color.parseColor(str2);
        } catch (Exception e) {
            w.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", new Object[]{str2, e});
            parseColor = getResources().getColor(R.e.white);
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d aVar = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(str), parseColor, this.iWh.Uw());
        DanmuView danmuView = this.iWj;
        synchronized (danmuView.iYa) {
            danmuView.iYa.offerFirst(aVar);
            e.post(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass3(danmuView, aVar), "DanmuView-addItemToWaitingHead");
        }
        return true;
    }

    private com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int parseColor;
        int optInt = jSONObject.optInt("time", 0);
        CharSequence optString = jSONObject.optString("text", "");
        Object optString2 = jSONObject.optString("color", "");
        try {
            parseColor = Color.parseColor(optString2);
        } catch (Exception e) {
            w.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", new Object[]{optString2, e});
            parseColor = getResources().getColor(R.e.white);
        }
        return new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(optString), parseColor, optInt);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iWx || TV()) {
            if (this.iWy != null) {
                f fVar = this.iWy;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    fVar.iXv = motionEvent.getRawX();
                    fVar.iXu = ((AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                    fVar.iPO = g.bw(fVar.mContext);
                }
                fVar.iXs.onTouchEvent(motionEvent);
                if (actionMasked == 1 || actionMasked == 3) {
                    if (fVar.iXr == a.iXD) {
                        fVar.iXt.e(fVar.iXx, motionEvent.getRawX() - fVar.iXv);
                        fVar.iXw = -1;
                        fVar.iXx = 0;
                        fVar.iXv = 0.0f;
                    } else if (fVar.iXr == a.iXB) {
                        ((AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                        fVar.iXt.Ua();
                    } else if (fVar.iXr == a.iXC) {
                        fVar.iXt.Ub();
                    }
                    fVar.iXr = a.iXA;
                }
            }
            return true;
        }
        if (motionEvent.getAction() == 0 && this.iWu && this.iWl.getVisibility() != 0) {
            this.iWk.Uo();
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void bT(boolean z) {
        boolean z2 = false;
        w.i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen=%b", new Object[]{Boolean.valueOf(z)});
        if (this.iWz == null) {
            w.w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
        } else if (z == TV()) {
            w.i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
        } else if (z) {
            a aVar = this.iWz;
            if (this.iWg != b.PORTRAIT) {
                z2 = true;
            }
            aVar.bW(z2);
            AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.iWk;
            appBrandVideoViewControlBar.iWP = true;
            appBrandVideoViewControlBar.Up();
            bU(true);
        } else {
            this.iWz.Uk();
            this.iWk.Uk();
        }
    }

    public final boolean TV() {
        if (this.iWz != null) {
            return this.iWz.isFullScreen();
        }
        w.w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
        return false;
    }

    private void TW() {
        this.iWj = (DanmuView) findViewById(R.h.bHD);
        this.iWj.iXY = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c(this) {
            final /* synthetic */ AppBrandVideoView iWC;

            {
                this.iWC = r1;
            }

            public final int Ug() {
                return this.iWC.iWh.Uw();
            }
        };
        DanmuView danmuView = this.iWj;
        danmuView.iXU = 0.0f;
        danmuView.iXV = 0.8f;
        this.iWj.iXT = 5;
        this.iWj.iXS = m.CTRL_INDEX;
        this.iWj.hide();
        if (this.iWh != null && this.iWh.getHeight() > 0) {
            danmuView = this.iWj;
            int height = (int) ((danmuView.iXV - danmuView.iXU) * ((float) this.iWh.getHeight()));
            float bx = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.bx(getContext());
            DanmuView danmuView2 = this.iWj;
            danmuView2.iXR = (int) (((float) height) / bx);
            if (danmuView2.iXZ != null) {
                synchronized (danmuView2.iXZ) {
                    for (int i = 0; i < danmuView2.iXZ.size(); i++) {
                        ArrayList arrayList = (ArrayList) danmuView2.iXZ.get(Integer.valueOf(i));
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                }
            }
            danmuView2.UH();
        }
    }

    static String hP(int i) {
        return hQ(i / 60) + ":" + hQ(i % 60);
    }

    private static String hQ(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    final void bU(boolean z) {
        if (this.iWv != null) {
            Object obj = this.iWg == b.PORTRAIT ? "vertical" : "horizontal";
            e eVar = this.iWv;
            try {
                w.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[]{Integer.valueOf(this.iWs), Boolean.valueOf(z), obj});
                JSONObject UB = eVar.UB();
                UB.put("fullScreen", z);
                UB.put("videoPlayerId", r2);
                UB.put(TencentLocation.EXTRA_DIRECTION, obj);
                eVar.a(new c(), UB);
            } catch (JSONException e) {
                w.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[]{e});
            }
        }
    }
}
