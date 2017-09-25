package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.protocal.c.sl;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public final class b extends i {
    private com.tencent.mm.plugin.card.base.b kcX;
    private MMActivity kdb;
    private View kpM;
    private TextView kpN;
    private g kpO;

    public final void KC() {
        this.kdb = this.kqe.ahm();
        this.kpO = this.kqe.aho();
    }

    public final void destroy() {
        super.destroy();
        this.kdb = null;
        this.kpO = null;
    }

    public final void update() {
        if (this.kpM == null) {
            this.kpM = ((ViewStub) findViewById(R.h.bvV)).inflate();
            this.kpM.findViewById(R.h.bvL).setOnClickListener(this.kqe.ahn());
        }
        this.kcX = this.kqe.ahj();
        this.kpO = this.kqe.aho();
        boolean ahY = this.kpO.ahY();
        boolean ahZ = this.kpO.ahZ();
        if (ahY) {
            this.kpM.setVisibility(0);
            w.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + ahY + " acceptViewEnabled:" + ahZ);
            Button button = (Button) this.kpM.findViewById(R.h.bvL);
            View findViewById = this.kpM.findViewById(R.h.bvU);
            findViewById.setBackgroundDrawable(null);
            findViewById.setOnClickListener(null);
            int dimensionPixelSize = this.kdb.getResources().getDimensionPixelSize(R.f.aYP);
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            if (ahZ) {
                if (!TextUtils.isEmpty(this.kcX.afi().tot)) {
                    button.setText(this.kcX.afi().tot);
                }
                Drawable d;
                Drawable bJ;
                Drawable stateListDrawable;
                if (this.kcX.aeP()) {
                    button.setTextColor(l.ta(this.kcX.afi().hib));
                    d = l.d(this.kdb, l.ta(this.kcX.afi().hib), dimensionPixelSize);
                    bJ = l.bJ(l.ta(this.kcX.afi().hib), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, bJ);
                    stateListDrawable.addState(new int[0], d);
                    int[] iArr = new int[]{this.kdb.getResources().getColor(R.e.white), l.ta(this.kcX.afi().hib)};
                    int[][] iArr2 = new int[][]{new int[]{16842919, 16842910}, new int[0]};
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(new ColorStateList(iArr2, iArr));
                    layoutParams = (LayoutParams) this.kpM.getLayoutParams();
                    layoutParams.topMargin = this.kdb.getResources().getDimensionPixelSize(R.f.aYy);
                    this.kpM.setLayoutParams(layoutParams);
                    this.kpM.findViewById(R.h.bJN).setVisibility(8);
                    final f ahr = this.kqe.ahr();
                    CheckBox checkBox = (CheckBox) this.kpM.findViewById(R.h.bwV);
                    if (ahr.afH() == null || !ahr.afH().kdU) {
                        w.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
                        checkBox.setVisibility(8);
                    } else {
                        w.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
                        checkBox.setVisibility(0);
                        sl slVar = this.kcX.afi().toE;
                        if (slVar == null || TextUtils.isEmpty(slVar.text)) {
                            checkBox.setText(ahr.afH().title);
                        } else {
                            checkBox.setText(slVar.text);
                        }
                        checkBox.setChecked(ahr.afH().kdV);
                        checkBox.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ b kpQ;

                            public final void onClick(View view) {
                                if (((CheckBox) view).isChecked()) {
                                    ahr.afH().kdV = true;
                                } else {
                                    ahr.afH().kdV = false;
                                }
                            }
                        });
                    }
                } else if (this.kcX.aeQ() || this.kcX.aeO() || this.kcX.aeR()) {
                    d = l.bJ(l.ta(this.kcX.afi().hib), dimensionPixelSize);
                    bJ = l.bJ(l.aF(this.kcX.afi().hib, aa.CTRL_BYTE), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, bJ);
                    stateListDrawable.addState(new int[0], d);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.kdb.getResources().getColor(R.e.aWx));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    d = l.bJ(l.ta(this.kcX.afi().hib), dimensionPixelSize);
                    bJ = l.bJ(l.aF(this.kcX.afi().hib, aa.CTRL_BYTE), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, bJ);
                    stateListDrawable.addState(new int[0], d);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.kdb.getResources().getColor(R.e.aWx));
                }
            } else {
                this.kpM.setEnabled(false);
                findViewById.setEnabled(false);
                button.setEnabled(false);
                button.setText(this.kcX.aeP() ? this.kcX.afi().tot : this.kpO.ahR());
                if (this.kcX.aeP()) {
                    button.setTextColor(l.aF(this.kcX.afi().hib, 125));
                    button.setBackgroundDrawable(l.d(this.kdb, l.aF(this.kcX.afi().hib, 125), dimensionPixelSize));
                    layoutParams = (LayoutParams) this.kpM.getLayoutParams();
                    layoutParams.topMargin = this.kdb.getResources().getDimensionPixelSize(R.f.aYz);
                    this.kpM.setLayoutParams(layoutParams);
                    this.kpM.findViewById(R.h.bJN).setVisibility(8);
                } else if (this.kcX.aeQ() || this.kcX.aeO() || this.kcX.aeR()) {
                    button.setTextColor(this.kdb.getResources().getColor(R.e.aUf));
                    button.setBackgroundDrawable(l.u(this.kdb, this.kdb.getResources().getColor(R.e.aTf)));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    button.setTextColor(this.kdb.getResources().getColor(R.e.aUf));
                    button.setBackgroundDrawable(l.u(this.kdb, this.kdb.getResources().getColor(R.e.aTf)));
                }
            }
            if (!this.kcX.aeQ() && !this.kcX.aeO()) {
                if (this.kcX.afi().toF != null && !bg.mA(this.kcX.afi().toF.text)) {
                    if (this.kpN == null) {
                        this.kpN = (TextView) this.kpM.findViewById(R.h.bvS);
                    }
                    this.kpN.setText(this.kcX.afi().toF.text);
                    if (!bg.mA(this.kcX.afi().toF.url)) {
                        this.kpN.setOnClickListener(this.kqe.ahn());
                        this.kpN.setTextColor(l.ta(this.kcX.afi().hib));
                    }
                    this.kpN.setVisibility(0);
                    return;
                } else if (this.kpN != null) {
                    this.kpN.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        w.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
        this.kpM.setVisibility(8);
    }

    public final void aiz() {
        this.kpM.setVisibility(8);
    }
}
