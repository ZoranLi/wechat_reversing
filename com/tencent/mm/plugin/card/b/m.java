package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.a.c.g;
import com.tencent.mm.ah.a.d.b;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public final class m {

    static class AnonymousClass3 implements AnimationListener {
        final /* synthetic */ View kri;
        final /* synthetic */ ScaleAnimation krj;

        public AnonymousClass3(View view, ScaleAnimation scaleAnimation) {
            this.kri = view;
            this.krj = scaleAnimation;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            this.kri.startAnimation(this.krj);
        }
    }

    public static String ti(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.CardViewUtil", "toApply is null");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if ((i + 1) % 4 == 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void a(ImageView imageView, String str, int i, int i2, boolean z) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                imageView.setImageResource(i2);
                return;
            }
            a aVar = new a();
            aVar.hIO = e.hgu;
            n.GX();
            aVar.hJg = null;
            aVar.hIN = com.tencent.mm.plugin.card.model.m.sw(str);
            aVar.hIL = true;
            aVar.hJi = z;
            aVar.hIJ = true;
            aVar.hIS = i;
            aVar.hIR = i;
            aVar.hJa = i2;
            n.GW().a(str, imageView, aVar.Hg());
        }
    }

    public static void a(final Context context, final ImageView imageView, String str, int i, final int i2, final int i3) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                a(imageView, i2, i3);
                return;
            }
            a aVar = new a();
            aVar.hIO = e.hgu;
            n.GX();
            aVar.hJg = null;
            aVar.hIN = com.tencent.mm.plugin.card.model.m.sw(str);
            aVar.hIL = true;
            aVar.hJi = false;
            aVar.hIJ = true;
            aVar.hIS = i;
            aVar.hIR = i;
            aVar.hJa = i2;
            n.GW().a(str, imageView, aVar.Hg(), new g() {
                public final void jK(String str) {
                }

                public final void a(String str, View view, b bVar) {
                    if (bVar.bitmap != null) {
                        final Bitmap bitmap = bVar.bitmap;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 krh;

                            public final void run() {
                                imageView.setImageBitmap(bitmap);
                                imageView.setColorFilter(i3, Mode.SRC_IN);
                            }
                        });
                        return;
                    }
                    m.a(imageView, i2, i3);
                }
            });
        }
    }

    public static void a(final ImageView imageView, final int i, final int i2) {
        af.v(new Runnable() {
            public final void run() {
                imageView.setImageResource(i);
                imageView.setColorFilter(i2, Mode.SRC_IN);
            }
        });
    }

    public static void a(MMActivity mMActivity, com.tencent.mm.plugin.card.base.b bVar) {
        a(mMActivity, l.ta(bVar.afi().hib));
    }

    public static void a(MMActivity mMActivity, int i) {
        mMActivity.cO().cP().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(i);
        mMActivity.cO().cP().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.cO().cP().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(mMActivity.getResources().getColor(R.e.aUl));
            }
            findViewById = customView.findViewById(R.h.bng);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(R.g.bbC);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.white));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.white));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(MMActivity mMActivity, boolean z) {
        int color = mMActivity.getResources().getColor(R.e.aVj);
        mMActivity.cO().cP().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(color);
        mMActivity.cO().cP().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.cO().cP().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                if (z) {
                    findViewById.setBackgroundColor(mMActivity.getResources().getColor(R.e.aUk));
                } else {
                    findViewById.setVisibility(8);
                }
            }
            findViewById = customView.findViewById(R.h.bng);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(R.g.bdk);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.black));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.black));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(TextView textView, int i) {
        switch (i) {
            case 0:
                textView.setText(R.l.dSh);
                return;
            case 1:
                textView.setText(R.l.dSc);
                return;
            case 2:
                textView.setText(R.l.dSf);
                return;
            case 3:
                textView.setText(R.l.dSe);
                return;
            case 4:
                textView.setText(R.l.dSi);
                return;
            case 5:
                textView.setText(R.l.dSj);
                return;
            case 6:
                textView.setText(R.l.dSd);
                return;
            case 7:
                textView.setText(R.l.dSg);
                return;
            default:
                return;
        }
    }
}
