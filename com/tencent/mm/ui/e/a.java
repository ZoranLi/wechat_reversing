package com.tencent.mm.ui.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public class a extends b {
    public String mUrl = null;
    private String mWA = null;
    private boolean vfC = false;
    public com.tencent.mm.u.b.b.b vfD = null;
    private String vfE = "";

    public a(Context context, com.tencent.mm.u.b.b.b bVar) {
        super(context);
        this.vfD = bVar;
        refresh();
    }

    public int getLayoutId() {
        return R.i.cYJ;
    }

    private void refresh() {
        ap.yY().xA();
        if (com.tencent.mm.u.b.b.a(this.vfD)) {
            w.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", this.vfD, this.mWA, this.mUrl, Boolean.valueOf(this.vfC));
            if (this.vfD == com.tencent.mm.u.b.b.b.Chatting) {
                ap.yY().xA();
                this.mWA = com.tencent.mm.u.b.b.Ak();
                ap.yY().xA();
                this.mUrl = com.tencent.mm.u.b.b.Al();
                ap.yY().xA();
                this.vfC = com.tencent.mm.u.b.b.Am();
            } else {
                ap.yY().xA();
                this.mWA = com.tencent.mm.u.b.b.Ah();
                ap.yY().xA();
                this.mUrl = com.tencent.mm.u.b.b.Ai();
                ap.yY().xA();
                this.vfC = com.tencent.mm.u.b.b.Aj();
            }
            TextView textView = (TextView) getView().findViewById(R.h.bBb);
            if (bg.mA(this.mWA)) {
                textView.setText(R.l.dJd);
            } else {
                textView.setText(this.mWA);
            }
            textView.setSelected(true);
            getView().setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a vfF;

                {
                    this.vfF = r1;
                }

                public final void onClick(View view) {
                    this.vfF.zG(1);
                    if (!bg.mA(this.vfF.mUrl)) {
                        this.vfF.Iu(this.vfF.mUrl);
                    }
                }
            });
            if (getView().getVisibility() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                h.vG();
                this.vfE = stringBuilder.append(com.tencent.mm.kernel.a.uH()).append("_").append(System.currentTimeMillis()).toString();
                zG(0);
            }
            setVisibility(0);
            ImageView imageView = (ImageView) getView().findViewById(R.h.bCB);
            if (this.vfC) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a vfF;

                    {
                        this.vfF = r1;
                    }

                    public final void onClick(View view) {
                        w.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                        this.vfF.zG(2);
                        com.tencent.mm.u.b.b xA = ap.yY().xA();
                        com.tencent.mm.u.b.b.b bVar = this.vfF.vfD;
                        if (bVar == com.tencent.mm.u.b.b.b.Main) {
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
                        } else {
                            if (bVar == com.tencent.mm.u.b.b.b.Chatting) {
                                if (com.tencent.mm.u.b.b.An()) {
                                    ap.yY();
                                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(true));
                                } else {
                                    ap.yY();
                                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
                                }
                            }
                            this.vfF.setVisibility(8);
                        }
                        xA.Ap();
                        this.vfF.setVisibility(8);
                    }
                });
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        w.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
        setVisibility(8);
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        getView().findViewById(R.h.clb).setVisibility(i);
    }

    protected void Iu(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b((Context) this.sNB.get(), "webview", ".ui.tools.WebViewUI", intent);
    }

    public final boolean Xj() {
        refresh();
        return super.Xj();
    }

    public final void destroy() {
    }

    public final void zG(int i) {
        int i2 = 1;
        g gVar = g.oUh;
        Object[] objArr = new Object[3];
        objArr[0] = this.vfE;
        objArr[1] = Integer.valueOf(i);
        if (this.vfD == com.tencent.mm.u.b.b.b.Main) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        gVar.i(14439, objArr);
        g.oUh.a(633, (long) i, 1, false);
    }
}
