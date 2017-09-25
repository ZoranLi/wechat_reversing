package com.tencent.mm.plugin.card.sharecard.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;

public final class a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    Bitmap iuR;
    OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ a khJ;

        {
            this.khJ = r1;
        }

        public final void onClick(View view) {
            if (view.getId() != R.h.coS) {
                return;
            }
            if (this.khJ.khC.isChecked()) {
                if (this.khJ.khG != null) {
                    this.khJ.khG.kv(1);
                }
            } else if (this.khJ.khG != null) {
                this.khJ.khG.kv(0);
            }
        }
    };
    public b kcX;
    public MMActivity kdb;
    TextView khA;
    TextView khB;
    public CheckBox khC;
    String khD;
    int khE = 1;
    boolean khF = false;
    public a khG;
    float khH = 0.0f;
    private OnLongClickListener khI = new OnLongClickListener(this) {
        final /* synthetic */ a khJ;

        {
            this.khJ = r1;
        }

        public final boolean onLongClick(View view) {
            if (view.getId() == R.h.bCY) {
                p.I(this.khJ.kdb, this.khJ.kcX.afj().code);
                g.bl(this.khJ.kdb, this.khJ.kdb.getString(R.l.dGy));
            }
            return false;
        }
    };
    View khv;
    private View khw;
    private View khx;
    private View khy;
    Bitmap khz;

    public interface a {
        void kv(int i);
    }

    public a(MMActivity mMActivity, View view) {
        this.kdb = mMActivity;
        this.khv = view;
    }

    final void R(float f) {
        LayoutParams attributes = this.kdb.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.kdb.getWindow().setAttributes(attributes);
    }

    public final void agB() {
        w.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (this.khF) {
            String str;
            ImageView imageView;
            if (!bg.mA(this.kcX.afj().tnT)) {
                w.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[]{this.kcX.afj().tnT});
                str = r0;
            } else if (this.kcX.afc()) {
                w.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[]{al.agn().getCode()});
                str = r0;
            } else {
                w.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[]{this.kcX.afj().code});
                str = r0;
            }
            View view;
            TextView textView;
            switch (this.kcX.afj().tnG) {
                case 0:
                    if (this.khy == null) {
                        this.khy = ((ViewStub) this.khv.findViewById(R.h.bwC)).inflate();
                    }
                    TextView textView2 = (TextView) this.khy.findViewById(R.h.bCY);
                    textView2.setText(m.ti(str));
                    textView2.setOnLongClickListener(this.khI);
                    if (!this.kcX.aeP()) {
                        textView2.setTextColor(l.ta(this.kcX.afi().hib));
                    }
                    if (str.length() <= 12) {
                        textView2.setTextSize(1, 33.0f);
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView2.setTextSize(1, 30.0f);
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView2.setTextSize(1, 24.0f);
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView2.setTextSize(1, 18.0f);
                    } else if (str.length() > 40) {
                        textView2.setVisibility(8);
                    }
                    cc(this.khy);
                    break;
                case 1:
                    if (this.khx == null) {
                        this.khx = ((ViewStub) this.khv.findViewById(R.h.bww)).inflate();
                    }
                    view = this.khx;
                    imageView = (ImageView) view.findViewById(R.h.bCC);
                    textView = (TextView) view.findViewById(R.h.bCY);
                    if (!this.kcX.aeP()) {
                        textView.setTextColor(l.ta(this.kcX.afi().hib));
                    }
                    if (TextUtils.isEmpty(str) || str.length() > 40) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(m.ti(str));
                        if (this.kcX.aeY()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.khI);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                    if (this.khE != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.p(this.khz);
                        if (TextUtils.isEmpty(str)) {
                            this.khz = null;
                            imageView.setImageBitmap(this.khz);
                        } else {
                            this.khz = com.tencent.mm.bf.a.a.b(this.kdb, str, 5, 0);
                            a(imageView, this.khz);
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.CardConsumeCodeController", e, "", new Object[0]);
                    }
                    cc(this.khx);
                    break;
                case 2:
                    if (this.khw == null) {
                        this.khw = ((ViewStub) this.khv.findViewById(R.h.bwA)).inflate();
                    }
                    view = this.khw;
                    imageView = (ImageView) view.findViewById(R.h.bCR);
                    textView = (TextView) view.findViewById(R.h.bCY);
                    if (!this.kcX.aeP()) {
                        textView.setTextColor(l.ta(this.kcX.afi().hib));
                    }
                    if (str.length() <= 40) {
                        textView.setText(m.ti(str));
                        if (this.kcX.aeY()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.khI);
                        } else {
                            textView.setVisibility(8);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                    if (this.khE != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.p(this.iuR);
                        if (TextUtils.isEmpty(str)) {
                            this.iuR = null;
                            imageView.setImageBitmap(this.iuR);
                        } else {
                            this.iuR = com.tencent.mm.bf.a.a.b(this.kdb, str, 0, 3);
                            a(imageView, this.iuR);
                        }
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                    }
                    cc(this.khw);
                    break;
            }
            if (bg.mA(this.kcX.afi().kAO)) {
                this.khA.setVisibility(8);
                this.khB.setVisibility(8);
            } else if (this.kcX.afi().toO != null) {
                this.khB.setText(this.kcX.afi().kAO);
                this.khB.setVisibility(0);
                this.khA.setVisibility(8);
                if (this.khw != null) {
                    imageView = (ImageView) this.khw.findViewById(R.h.bCR);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = com.tencent.mm.bg.a.fromDPToPix(this.kdb, 180);
                    layoutParams.width = com.tencent.mm.bg.a.fromDPToPix(this.kdb, 180);
                    imageView.setLayoutParams(layoutParams);
                }
            } else {
                this.khA.setText(this.kcX.afi().kAO);
                this.khA.setVisibility(0);
            }
            if (!this.kcX.aeO() || TextUtils.isEmpty(this.kcX.afo()) || this.kcX.afo().equals(com.tencent.mm.u.m.xL())) {
                this.khC.setChecked(false);
                this.khC.setVisibility(8);
                return;
            }
            this.khC.setVisibility(0);
            this.khC.setText(h.g(this.kdb, " " + this.kdb.getString(R.l.dQA, new Object[]{l.td(this.kcX.afo())}), this.kdb.getResources().getDimensionPixelOffset(R.f.aXU)));
            return;
        }
        w.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null && !bitmap.isRecycled()) {
            imageView.setImageBitmap(bitmap);
            if (this.khE != 1) {
                imageView.setAlpha(10);
            } else {
                imageView.setAlpha(255);
            }
        }
    }

    private void cc(View view) {
        Button button = (Button) view.findViewById(R.h.bCQ);
        if (this.khE == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.khE == -1) {
            button.setText(R.l.dRi);
        }
    }
}
