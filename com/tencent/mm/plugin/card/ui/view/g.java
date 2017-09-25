package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.a.a;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.b.p;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.i;

public abstract class g extends i {
    String code;
    private Bitmap iuR;
    protected b kcX;
    MMActivity kdb;
    private OnLongClickListener khI = new OnLongClickListener(this) {
        final /* synthetic */ g kqa;

        {
            this.kqa = r1;
        }

        public final boolean onLongClick(View view) {
            if (view.getId() == R.h.bCY) {
                p.I(this.kqa.kdb, this.kqa.kcX.afj().code);
                com.tencent.mm.ui.base.g.bl(this.kqa.kdb, this.kqa.getString(R.l.dGy));
            }
            return false;
        }
    };
    private Bitmap khz;
    private j kkQ;
    private ViewGroup kpX;
    private aa kpY;
    private ViewStub kpZ;

    public abstract aa aiE();

    public abstract aa aiF();

    public abstract aa aiG();

    public abstract String e(c cVar);

    public abstract boolean h(b bVar);

    public final void KC() {
        this.kdb = this.kqe.ahm();
        this.kkQ = this.kqe.ahs();
        this.kcX = this.kqe.ahj();
        if (this.kcX == null) {
            w.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
            return;
        }
        switch (this.kcX.afj().tnG) {
            case 0:
                this.kpY = aiG();
                break;
            case 1:
                this.kpY = aiF();
                break;
            case 2:
                this.kpY = aiE();
                break;
            default:
                this.kpY = aiE();
                break;
        }
        if (this.kpY == null) {
            w.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
            return;
        }
        switch (this.kcX.afj().tnG) {
            case 0:
                if (this.kpZ == null) {
                    this.kpZ = (ViewStub) findViewById(R.h.bwB);
                    break;
                }
                break;
            case 1:
                if (this.kpZ == null) {
                    this.kpZ = (ViewStub) findViewById(R.h.bwe);
                    break;
                }
                break;
            case 2:
                if (this.kpZ == null) {
                    this.kpZ = (ViewStub) findViewById(R.h.byf);
                    break;
                }
                break;
            default:
                if (this.kpZ == null) {
                    this.kpZ = (ViewStub) findViewById(R.h.byf);
                    break;
                }
                break;
        }
        if (this.kpZ == null) {
            w.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
        } else if (this.kpY == null) {
            w.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
        } else if (this.kpY.getLayoutId() == 0) {
            w.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
        } else {
            this.kpZ.setLayoutResource(this.kpY.getLayoutId());
            if (this.kpX == null) {
                this.kpX = (ViewGroup) this.kpZ.inflate();
            }
        }
        if (this.kpX == null) {
            w.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
        }
    }

    public final void d(b bVar) {
        if (bVar == null) {
            w.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
        } else {
            this.kcX = bVar;
        }
    }

    public final void destroy() {
        super.destroy();
        this.kdb = null;
        this.kkQ = null;
        this.kcX = null;
        this.kpX = null;
        this.kpY = null;
        l.p(this.iuR);
        l.p(this.khz);
    }

    public final void update() {
        if (this.kcX == null) {
            w.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
        } else if (this.kpY == null) {
            w.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
        } else if (this.kpX == null) {
            w.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
        } else {
            this.kkQ.ahK();
            d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
            this.kpY.c(this.kpX, this.kcX);
        }
    }

    public final void d(c cVar) {
        int i = 1;
        if (this.kcX == null) {
            w.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
        } else if (cVar == null) {
            w.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
        } else if (this.kpY.i(this.kcX)) {
            this.kpY.e(this.kpX);
            w.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", new Object[]{Integer.valueOf(cVar.action)});
            this.code = e(cVar);
            if (i.wx(this.code)) {
                w.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
                return;
            }
            View view;
            String str;
            ImageView imageView;
            switch (this.kcX.afj().tnG) {
                case 0:
                    view = this.kpX;
                    str = this.code;
                    TextView textView = (TextView) view.findViewById(R.h.bCY);
                    textView.setText(m.ti(str));
                    textView.setOnLongClickListener(this.khI);
                    String str2 = this.kcX.afi().hib;
                    if (!i.wx(str2)) {
                        textView.setTextColor(l.ta(str2));
                    }
                    if (str.length() <= 12) {
                        textView.setTextSize(1, 33.0f);
                        return;
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView.setTextSize(1, 30.0f);
                        return;
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView.setTextSize(1, 24.0f);
                        return;
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView.setTextSize(1, 18.0f);
                        return;
                    } else if (str.length() > 40) {
                        textView.setVisibility(8);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    view = this.kpX;
                    String str3 = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(R.h.bCC);
                        l.p(this.khz);
                        if (str3 != null && str3.length() > 0) {
                            this.khz = a.b(this.kdb, str3, 5, 0);
                        }
                        a(imageView, this.khz);
                        imageView.setOnClickListener(this.kqe.ahn());
                        this.kkQ.khz = this.khz;
                        return;
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.CardBaseCodeView", e, "", new Object[0]);
                        return;
                    }
                case 2:
                    view = this.kpX;
                    str = this.code;
                    try {
                        imageView = (ImageView) view.findViewById(R.h.bCR);
                        l.p(this.iuR);
                        if (!(this.kcX == null || this.kcX.afi() == null)) {
                            i = this.kcX.afi().toR;
                        }
                        this.iuR = a.b(this.kdb, str, 0, i);
                        a(imageView, this.iuR);
                        if (aiH()) {
                            imageView.setOnClickListener(this.kqe.ahn());
                        }
                        this.kkQ.iuR = this.iuR;
                        return;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.CardBaseCodeView", e2, "", new Object[0]);
                        return;
                    }
                default:
                    return;
            }
        } else {
            w.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", new Object[]{Integer.valueOf(cVar.action)});
            aiC();
        }
    }

    public final void aiC() {
        if (this.kpY != null && this.kcX != null && this.kpX != null) {
            this.kpY.a(this.kpX, this.kcX);
        }
    }

    public final void aiD() {
        if (this.kcX == null || this.kpY == null || this.kpX == null) {
            w.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
        } else {
            this.kpY.b(this.kpX, this.kcX);
        }
    }

    public final void aiz() {
        if (this.kpX != null) {
            this.kpX.setVisibility(8);
        }
    }

    public boolean aiH() {
        return true;
    }

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
