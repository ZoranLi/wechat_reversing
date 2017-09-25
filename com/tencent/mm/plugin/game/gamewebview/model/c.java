package com.tencent.mm.plugin.game.gamewebview.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ax.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.ScrollAlwaysTextView;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c extends b {
    private ImageView jla;
    private ScrollAlwaysTextView mlx;

    public c(Context context) {
        super(context);
        if (this.view != null) {
            this.mlx = (ScrollAlwaysTextView) this.view.findViewById(R.h.bVb);
            this.jla = (ImageView) this.view.findViewById(R.h.bVa);
            this.view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c mly;

                {
                    this.mly = r1;
                }

                public final void onClick(View view) {
                    a aVar = a.idS;
                    String Ma = a.Ma();
                    if (!bg.mA(Ma)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", Ma);
                        intent.putExtra("is_from_keep_top", true);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        d.b((Context) this.mly.sNB.get(), "game", ".gamewebview.ui.GameWebViewUI", intent);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.bVc;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.bVc).setVisibility(i);
        }
    }

    public final boolean Xj() {
        w.i("MicroMsg.GameWebViewBanner", "refreshAndReturnIsVisible");
        a aVar = a.idS;
        if (a.LZ()) {
            w.i("MicroMsg.GameWebViewBanner", "refreshAndReturnIsVisible, VISIBLE");
            aVar = a.idS;
            CharSequence Mb = a.Mb();
            if (this.mlx != null) {
                this.mlx.setText(Mb);
            }
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
