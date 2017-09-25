package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;

public final class f extends LinearLayout {
    TextView llG;
    private Context mContext;
    private ImageView mnA;
    private ImageView mnB;
    public j mnC;
    private a mnD;
    public h mnE = null;
    b mnz;

    public f(b bVar) {
        super(bVar.getContext());
        this.mContext = bVar.getContext();
        this.mnz = bVar;
        this.mnC = new h(bVar);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        setLayoutParams(new LayoutParams(-1, displayMetrics.widthPixels > displayMetrics.heightPixels ? this.mContext.getResources().getDimensionPixelSize(R.f.aWR) : this.mContext.getResources().getDimensionPixelSize(R.f.aWS)));
        setBackgroundResource(R.e.aSB);
        View inflate = r.eC(getContext()).inflate(R.i.dfu, this, false);
        addView(inflate);
        this.mnA = (ImageView) inflate.findViewById(R.h.bmU);
        this.mnA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f mnF;

            {
                this.mnF = r1;
            }

            public final void onClick(View view) {
                if (!this.mnF.azQ()) {
                    this.mnF.mnz.azC();
                }
            }
        });
        this.llG = (TextView) inflate.findViewById(R.h.title);
        this.mnB = (ImageView) inflate.findViewById(R.h.bna);
        this.mnB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f mnF;

            {
                this.mnF = r1;
            }

            public final void onClick(View view) {
                this.mnF.mnC.aAb();
            }
        });
    }

    public final void tC(String str) {
        this.llG.setText(str);
    }

    public final void aAb() {
        if (this.mnC != null) {
            this.mnC.aAb();
        }
    }

    public final void y(Bundle bundle) {
        this.mnD = bundle == null ? null : new a(bundle);
    }

    public final boolean azQ() {
        if (this.mnD != null) {
            a aVar = this.mnD;
            boolean z = (!aVar.mlS || bg.mA(aVar.azs()) || bg.mA(aVar.azt()) || bg.mA(aVar.azu())) ? false : true;
            if (z) {
                w.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[]{this.mnD.azs(), this.mnD.azt(), this.mnD.azu()});
                View inflate = View.inflate(getContext(), R.i.dit, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cjX);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(R.h.cjZ);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(R.e.aVo));
                textView = (TextView) inflate.findViewById(R.h.cjY);
                textView.setTextColor(getResources().getColor(R.e.aVo));
                textView.setVisibility(8);
                this.mnE = g.a(getContext(), true, "", inflate, r4, r5, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ f mnF;

                    {
                        this.mnF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mnF.mnE = null;
                        this.mnF.mnz.azC();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ f mnF;

                    {
                        this.mnF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mnF.mnE = null;
                    }
                });
                return true;
            }
        }
        return false;
    }
}
