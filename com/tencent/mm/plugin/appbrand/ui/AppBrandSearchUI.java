package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import java.util.List;

public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private View jjA;
    private String jjB;
    private String jjC;
    private int scene;

    private static class GetLocationGeoTask extends MainProcessTask {
        public static final Creator<GetLocationGeoTask> CREATOR = new Creator<GetLocationGeoTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                GetLocationGeoTask getLocationGeoTask = new GetLocationGeoTask();
                getLocationGeoTask.f(parcel);
                return getLocationGeoTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetLocationGeoTask[i];
            }
        };

        public final void PM() {
            c.Gk().a(new a(this) {
                final /* synthetic */ GetLocationGeoTask jjG;

                {
                    this.jjG = r1;
                }

                public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                    c.Gk().c(this);
                    w.d("MicroMsg.AppBrandSearchUI", "onGetLocation(%s, %s, %s, %s, %s, %s)", new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
                    return false;
                }
            }, true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p.post(new Runnable(this) {
            final /* synthetic */ AppBrandSearchUI jjF;

            {
                this.jjF = r1;
            }

            public final void run() {
                AppBrandMainProcessService.a(new GetLocationGeoTask());
            }
        });
        this.jjC = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        w.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", new Object[]{this.jjC});
        g.oUh.i(13929, new Object[]{this.jjC, "", Integer.valueOf(1), Integer.valueOf(this.scene)});
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.jjC);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
    }

    public void onDestroy() {
        if (this.scene == 3 || this.scene == 16) {
            g.oUh.i(13929, new Object[]{this.jjC, b.hpR, Integer.valueOf(2), Integer.valueOf(this.scene)});
        }
        super.onDestroy();
    }

    public final boolean WV() {
        this.jjA.setVisibility(8);
        return super.WV();
    }

    public final void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
        if (!TextUtils.isEmpty(str2)) {
            this.jjA.setVisibility(8);
        }
        try {
            this.iYF.d(CdnLogic.MediaType_FAVORITE_FILE, null);
        } catch (RemoteException e) {
            w.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", new Object[]{e});
        }
        super.a(str, str2, list, bVar);
    }

    protected final void bE(View view) {
        super.bE(view);
        this.jjB = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.jjA = getLayoutInflater().inflate(R.i.cUp, (ViewGroup) view, false);
        View findViewById = this.jjA.findViewById(R.h.cmy);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppBrandSearchUI jjF;

            {
                this.jjF = r1;
            }

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(this.jjF.jjB)) {
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", this.jjF.jjB);
                    intent.putExtra("geta8key_scene", 41);
                    intent.putExtra("show_long_click_popup_menu", false);
                    d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        if (TextUtils.isEmpty(this.jjB)) {
            findViewById.setVisibility(8);
            this.jjA.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.jjA.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.jjA);
            return;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (getWindow().hasFeature(9)) {
            View view2 = this.jjA;
            int paddingLeft = this.jjA.getPaddingLeft();
            Rect rect = new Rect();
            int bxY = bxY();
            View decorView = getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int height = decorView.getHeight();
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            if (height == 0) {
                bxY += WW();
            }
            bxY = (height - rect.height() < 0 || iArr[1] <= m.CTRL_INDEX) ? bxY + rect.top : bxY + (height - rect.height());
            view2.setPadding(paddingLeft, bxY + this.jjA.getPaddingTop(), this.jjA.getPaddingRight(), this.jjA.getPaddingBottom());
        }
        addContentView(this.jjA, layoutParams);
    }

    private int WW() {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = getResources().getDimensionPixelSize(bg.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
        }
        return i;
    }
}
