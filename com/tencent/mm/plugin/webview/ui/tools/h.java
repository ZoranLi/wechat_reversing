package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.ScrollAlwaysTextView;

public final class h extends b {
    private ScrollAlwaysTextView mlx;

    public h(Context context) {
        super(context);
        if (this.view != null) {
            this.mlx = (ScrollAlwaysTextView) this.view.findViewById(R.h.cSl);
            this.view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h sgb;

                {
                    this.sgb = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.ax.b bVar = com.tencent.mm.ax.b.idU;
                    String Mc = com.tencent.mm.ax.b.Mc();
                    if (!bg.mA(Mc)) {
                        com.tencent.mm.ax.b bVar2 = com.tencent.mm.ax.b.idU;
                        int Md = com.tencent.mm.ax.b.Md();
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", Mc);
                        intent.putExtra("is_from_keep_top", true);
                        intent.putExtra("keep_top_scene", Md);
                        if (Md == 2) {
                            intent.putExtra("custom_keep_top_url", Mc);
                            bVar2 = com.tencent.mm.ax.b.idU;
                            intent.putExtra("custom_keep_top_title", com.tencent.mm.ax.b.Mb());
                        }
                        d.b((Context) this.sgb.sNB.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.drN;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cSm).setVisibility(i);
        }
    }

    private void setTitle(String str) {
        if (this.mlx != null) {
            this.mlx.setText(str);
        }
    }

    public final boolean Xj() {
        com.tencent.mm.ax.b bVar = com.tencent.mm.ax.b.idU;
        if (com.tencent.mm.ax.b.LZ()) {
            bVar = com.tencent.mm.ax.b.idU;
            if (com.tencent.mm.ax.b.Md() == 2) {
                bVar = com.tencent.mm.ax.b.idU;
                setTitle(com.tencent.mm.ax.b.Mb());
            } else {
                Context context = ab.getContext();
                int i = R.l.fnJ;
                Object[] objArr = new Object[1];
                com.tencent.mm.ax.b bVar2 = com.tencent.mm.ax.b.idU;
                objArr[0] = com.tencent.mm.ax.b.Mb();
                setTitle(context.getString(i, objArr));
            }
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
