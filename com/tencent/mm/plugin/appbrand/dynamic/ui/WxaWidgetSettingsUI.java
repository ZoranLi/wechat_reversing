package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.c;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.ArrayList;

public class WxaWidgetSettingsUI extends MMActivity {
    String appId;
    int fKL;
    Button iJf;

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WxaWidgetSettingsUI iJg;

            {
                this.iJg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iJg.finish();
                return false;
            }
        });
        zi(R.l.fog);
        this.appId = getIntent().getStringExtra("app_id");
        this.fKL = getIntent().getIntExtra("pkg_type", 0);
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(R.h.cpr);
        DebuggerInfo oE = b.oE(this.appId);
        boolean z2 = oE != null && oE.iHK;
        mMSwitchBtn.lS(z2);
        mMSwitchBtn.wwD = new a(this) {
            final /* synthetic */ WxaWidgetSettingsUI iJg;

            {
                this.iJg = r1;
            }

            public final void bK(boolean z) {
                DebuggerInfo oE = b.oE(this.iJg.appId);
                if (oE == null) {
                    oE = new DebuggerInfo();
                    b.a(this.iJg.appId, oE);
                }
                oE.iHK = z;
            }
        };
        mMSwitchBtn = (MMSwitchBtn) findViewById(R.h.bXH);
        if ((oE != null && oE.iHI) || c.a.fp(this.fKL)) {
            z = true;
        }
        mMSwitchBtn.lS(z);
        mMSwitchBtn.setEnabled(c.a.hv(this.fKL));
        mMSwitchBtn.wwD = new a(this) {
            final /* synthetic */ WxaWidgetSettingsUI iJg;

            {
                this.iJg = r1;
            }

            public final void bK(boolean z) {
                DebuggerInfo oE = b.oE(this.iJg.appId);
                if (oE == null) {
                    oE = new DebuggerInfo();
                    b.a(this.iJg.appId, oE);
                }
                oE.iHI = z;
            }
        };
        this.iJf = (Button) findViewById(R.h.bKA);
        hE(com.tencent.mm.plugin.appbrand.dynamic.widget.b.Sp());
        this.iJf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WxaWidgetSettingsUI iJg;

            {
                this.iJg = r1;
            }

            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("MHardwareAccelerateDrawableView");
                arrayList.add("MTextureView");
                arrayList.add("MSurfaceView");
                arrayList.add("MCanvasView");
                arrayList.add("MDrawableView");
                final com.tencent.mm.ui.widget.picker.a aVar = new com.tencent.mm.ui.widget.picker.a(this.iJg.uSU.uTo, arrayList);
                int intValue = ((Integer) this.iJg.iJf.getTag()).intValue();
                if (aVar.wzl != null) {
                    aVar.wzl.setValue(intValue);
                }
                aVar.wzm = new com.tencent.mm.ui.widget.picker.a.a(this) {
                    final /* synthetic */ AnonymousClass4 iJi;

                    public final void c(boolean z, Object obj) {
                        com.tencent.mm.ui.widget.picker.a aVar = aVar;
                        if (aVar.wzi != null) {
                            aVar.wzi.dismiss();
                        }
                        if (z) {
                            this.iJi.iJg.iJf.setText((CharSequence) obj);
                        }
                        WxaWidgetSettingsUI wxaWidgetSettingsUI = this.iJi.iJg;
                        com.tencent.mm.ui.widget.picker.a aVar2 = aVar;
                        int i = 0;
                        if (aVar2.wzl != null) {
                            i = aVar2.wzl.getValue();
                        }
                        wxaWidgetSettingsUI.hE(i);
                    }
                };
                intValue = com.tencent.mm.bg.a.fromDPToPix(this.iJg.uSU.uTo, 288);
                if (intValue != 0) {
                    aVar.wzk = intValue;
                }
                LayoutParams layoutParams = (LayoutParams) aVar.kQt.getLayoutParams();
                layoutParams.height = aVar.wzk;
                aVar.kQt.setLayoutParams(layoutParams);
                aVar.kQt.invalidate();
                if (aVar.wzi != null) {
                    aVar.wzi.show();
                }
            }
        });
    }

    private void hE(int i) {
        this.iJf.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                this.iJf.setText(getString(R.l.foh, new Object[]{"MTextureView"}));
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.hH(1);
                return;
            case 2:
                this.iJf.setText(getString(R.l.foh, new Object[]{"MSurfaceView"}));
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.hH(2);
                return;
            case 3:
                this.iJf.setText(getString(R.l.foh, new Object[]{"MCanvasView"}));
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.hH(3);
                return;
            case 4:
                this.iJf.setText(getString(R.l.foh, new Object[]{"MDrawableView"}));
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.hH(4);
                return;
            default:
                this.iJf.setText(getString(R.l.foh, new Object[]{"MHardwareAccelerateDrawableView"}));
                com.tencent.mm.plugin.appbrand.dynamic.widget.b.hH(0);
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dsd;
    }
}
