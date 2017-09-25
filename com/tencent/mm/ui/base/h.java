package com.tencent.mm.ui.base;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;
import java.util.List;

public class h extends Dialog implements DialogInterface {
    private CheckBox Qb;
    private View jpZ;
    private View kD;
    private EditText kM;
    private TextView llG;
    private Button lyE;
    private ImageView mBb;
    private Context mContext;
    private boolean ppy;
    public Button rMX;
    private LinearLayout vhT;
    private TextView vhU;
    private TextView vhV;
    private TextView vhW;
    private TextView vhX;
    private View vhY;
    private ViewStub vhZ;
    private LinearLayout vib;
    private ViewGroup vic;
    private LinearLayout vid;
    private ViewGroup vie;
    private View vif;
    private boolean vig = false;
    private boolean vih = false;
    private Animation vii;
    private Animation vij;
    private Animation vik;
    private Animation vil;
    private c vim;
    private int[] vin = new int[]{g.hds, g.hdt, g.hdu, g.hdv, g.hdw, g.hdx, g.hdy, g.hdz, g.hdA};

    public static class a {
        private Context mContext;
        public c vix = new c();

        public interface a {
            void auI();
        }

        public interface b {
            void bET();
        }

        public interface c {
            CharSequence a(CharSequence charSequence, float f);
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final a SW(String str) {
            this.vix.title = str;
            return this;
        }

        public final a M(CharSequence charSequence) {
            this.vix.title = charSequence;
            return this;
        }

        public final a zW(int i) {
            this.vix.title = this.mContext.getString(i);
            return this;
        }

        public final a SX(String str) {
            this.vix.vfW = str;
            return this;
        }

        public final a zX(int i) {
            this.vix.vfW = this.mContext.getString(i);
            return this;
        }

        public final a N(CharSequence charSequence) {
            this.vix.vfX = charSequence;
            return this;
        }

        public final a kJ(boolean z) {
            this.vix.vgc = z;
            return this;
        }

        public final a a(String str, CharSequence charSequence, Boolean bool, b bVar) {
            this.vix.vfL = str;
            this.vix.vfN = charSequence;
            this.vix.vfO = bool.booleanValue();
            this.vix.vfQ = bVar;
            return this;
        }

        public final a a(Bitmap bitmap, boolean z, int i) {
            this.vix.vfV = bitmap;
            this.vix.vgd = z;
            this.vix.vgk = i;
            return this;
        }

        public final a zY(int i) {
            this.vix.vgj = i;
            return this;
        }

        public final a SY(String str) {
            this.vix.vfI = str;
            return this;
        }

        public final a dd(View view) {
            this.vix.sdv = view;
            return this;
        }

        public final a SZ(String str) {
            this.vix.vfZ = str;
            return this;
        }

        public final a zZ(int i) {
            this.vix.vfZ = this.mContext.getString(i);
            return this;
        }

        public final a a(OnClickListener onClickListener) {
            this.vix.vge = onClickListener;
            return this;
        }

        public final a a(boolean z, OnClickListener onClickListener) {
            this.vix.vge = onClickListener;
            this.vix.vgm = z;
            return this;
        }

        public final a Ta(String str) {
            this.vix.vga = str;
            return this;
        }

        public final a Aa(int i) {
            this.vix.vga = this.mContext.getString(i);
            return this;
        }

        public final a b(OnClickListener onClickListener) {
            this.vix.vgf = onClickListener;
            return this;
        }

        public final a d(OnCancelListener onCancelListener) {
            this.vix.FU = onCancelListener;
            return this;
        }

        public final a a(OnDismissListener onDismissListener) {
            this.vix.FV = onDismissListener;
            return this;
        }

        public final a kK(boolean z) {
            this.vix.ppy = z;
            return this;
        }

        public final a kL(boolean z) {
            this.vix.vgb = z;
            return this;
        }

        public h WJ() {
            h hVar = new h(this.mContext);
            hVar.a(this.vix);
            return hVar;
        }

        public final a bRM() {
            this.vix.vfP = true;
            return this;
        }
    }

    static /* synthetic */ void a(h hVar, Animation animation) {
        if (hVar.vib != null) {
            hVar.vib.startAnimation(animation);
        }
        if (hVar.vid != null) {
            hVar.vid.startAnimation(animation);
        }
        if (hVar.vhX != null && hVar.vig) {
            hVar.vhX.startAnimation(animation);
        }
        if (hVar.kM == null) {
            return;
        }
        if (hVar.vih) {
            hVar.kM.startAnimation(animation);
        } else {
            hVar.kM.setVisibility(8);
        }
    }

    public h(Context context) {
        super(context, l.foK);
        this.mContext = context;
        this.vhT = (LinearLayout) r.eC(this.mContext).inflate(com.tencent.mm.s.a.h.hdZ, null);
        this.rMX = (Button) this.vhT.findViewById(g.ckg);
        this.lyE = (Button) this.vhT.findViewById(g.cjW);
        this.llG = (TextView) this.vhT.findViewById(g.hcD);
        this.vhU = (TextView) this.vhT.findViewById(g.cka);
        this.vhV = (TextView) this.vhT.findViewById(g.hcC);
        this.vhW = (TextView) this.vhT.findViewById(g.cke);
        this.vhX = (TextView) this.vhT.findViewById(g.bEz);
        this.kM = (EditText) this.vhT.findViewById(g.bED);
        this.Qb = (CheckBox) this.vhT.findViewById(g.hch);
        this.mBb = (ImageView) this.vhT.findViewById(g.ckd);
        this.jpZ = this.vhT.findViewById(g.hcE);
        this.vhZ = (ViewStub) this.vhT.findViewById(g.hdC);
        this.vib = (LinearLayout) this.vhT.findViewById(g.ckb);
        this.vic = (ViewGroup) this.vhT.findViewById(g.hcz);
        this.vif = this.vhT.findViewById(g.hcA);
        this.vid = (LinearLayout) this.vhT.findViewById(g.hcB);
        this.vie = (ViewGroup) this.vhT.findViewById(g.hdB);
        setCanceledOnTouchOutside(true);
        this.vii = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.s.a.a.aQJ);
        this.vij = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.s.a.a.aQJ);
        this.vik = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.s.a.a.aQK);
        this.vil = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.s.a.a.aQK);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.vhT);
    }

    public View getContentView() {
        return this.vhT;
    }

    public void setTitle(CharSequence charSequence) {
        this.jpZ.setVisibility(0);
        this.llG.setVisibility(0);
        if (this.vim != null) {
            charSequence = this.vim.a(charSequence.toString(), this.llG.getTextSize());
        }
        this.llG.setMaxLines(2);
        this.llG.setText(charSequence);
        zS(d.hbu);
    }

    public void setTitle(int i) {
        this.jpZ.setVisibility(0);
        this.llG.setVisibility(0);
        this.llG.setMaxLines(2);
        this.llG.setText(i);
        zS(d.hbu);
    }

    private void zS(int i) {
        if (this.vhU != null) {
            this.vhU.setTextColor(this.vhU.getContext().getResources().getColor(i));
        }
    }

    public final void setMessage(CharSequence charSequence) {
        this.vib.setVisibility(0);
        this.vhU.setVisibility(0);
        if (this.vim != null) {
            c cVar = this.vim;
            this.vhU.getContext();
            charSequence = cVar.a(charSequence.toString(), this.vhU.getTextSize());
        }
        this.vhU.setText(charSequence);
    }

    private void kH(boolean z) {
        if (z) {
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 8);
            this.vib.setVisibility(0);
            this.vib.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            this.vib.setBackgroundResource(f.hbN);
        }
    }

    public final String bRK() {
        return this.kM == null ? null : this.kM.getText().toString();
    }

    public final int bRL() {
        if (this.kM instanceof PasterEditText) {
            return ((PasterEditText) this.kM).bkj();
        }
        return 0;
    }

    private void zT(int i) {
        if (this.vib != null) {
            this.vib.setVisibility(i);
        }
        if (this.vid != null) {
            this.vid.setVisibility(i);
        }
        if (this.vhX != null && this.vig) {
            this.vhX.setVisibility(i);
        }
        if (this.kM == null) {
            return;
        }
        if (this.vih) {
            this.kM.setVisibility(i);
        } else {
            this.kM.setVisibility(8);
        }
    }

    private void cs(List<String> list) {
        LinearLayout linearLayout;
        this.vhZ.setLayoutResource(com.tencent.mm.s.a.h.hdQ);
        try {
            linearLayout = (LinearLayout) this.vhZ.inflate();
        } catch (Exception e) {
            this.vhZ.setVisibility(0);
            linearLayout = null;
        }
        if (list != null) {
            int i = 0;
            for (String str : list) {
                if (i <= 8) {
                    int i2;
                    if (linearLayout != null) {
                        ImageView imageView = (ImageView) linearLayout.findViewById(this.vin[i]);
                        if (str != null) {
                            imageView.setVisibility(0);
                            com.tencent.mm.ui.f.a.a.a(imageView, str);
                            i2 = i + 1;
                            i = i2;
                        }
                    }
                    i2 = i;
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public final void H(View view, int i) {
        this.kD = view;
        if (this.kD != null) {
            this.vib.setVisibility(0);
            this.vid.setVisibility(0);
            this.vid.removeAllViews();
            this.vid.setGravity(1);
            this.vid.addView(this.kD, new LayoutParams(i, i));
        }
    }

    public final void a(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        if (this.rMX != null) {
            this.rMX.setVisibility(0);
            this.rMX.setText(charSequence);
            this.rMX.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ h viq;

                public final void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onClick(this.viq, -1);
                    }
                    if (z) {
                        this.viq.dismiss();
                    }
                }
            });
        }
    }

    public final void zU(int i) {
        this.rMX.setTextColor(i);
    }

    public final void zV(int i) {
        this.lyE.setTextColor(i);
    }

    public final void a(int i, OnClickListener onClickListener) {
        a(this.mContext.getString(i), true, onClickListener);
    }

    public final void b(CharSequence charSequence, final boolean z, final OnClickListener onClickListener) {
        if (this.lyE != null) {
            this.lyE.setVisibility(0);
            this.lyE.setText(charSequence);
            this.lyE.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ h viq;

                public final void onClick(View view) {
                    if (onClickListener != null) {
                        onClickListener.onClick(this.viq, -2);
                    }
                    if (z) {
                        this.viq.cancel();
                    }
                }
            });
        }
    }

    public final void b(int i, OnClickListener onClickListener) {
        b(this.mContext.getString(i), true, onClickListener);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.ppy = z;
        setCanceledOnTouchOutside(this.ppy);
    }

    public final void kI(boolean z) {
        super.setCancelable(false);
    }

    public final Button getButton(int i) {
        switch (i) {
            case -2:
                return this.lyE;
            case -1:
                return this.rMX;
            default:
                return null;
        }
    }

    public final void a(c cVar) {
        CharSequence charSequence;
        CharSequence charSequence2;
        ImageView imageView;
        TextView textView;
        if (cVar.title != null && cVar.title.length() > 0) {
            setTitle(cVar.title);
        }
        if (cVar.sHe != 0) {
            this.llG.setTextColor(ColorStateList.valueOf(cVar.sHe));
        }
        if (cVar.vgh != 0) {
            this.llG.setMaxLines(cVar.vgh);
        }
        if (cVar.vgi != 0) {
            this.vhU.setMaxLines(cVar.vgi);
        }
        if (cVar.sdv != null) {
            H(cVar.sdv, -1);
        }
        if (cVar.vgg != null) {
            this.vhY = cVar.vgg;
            if (this.vhY != null) {
                this.vib.setVisibility(8);
                this.vhX.setVisibility(8);
                this.kM.setVisibility(8);
                this.vie.removeAllViews();
                this.vie.addView(this.vhY, new LayoutParams(-1, -1));
                this.vie.setVisibility(8);
            }
        }
        if (cVar.vfT != null) {
            Drawable drawable = cVar.vfT;
            if (this.kD == null) {
                this.vib.setVisibility(0);
                this.mBb.setVisibility(0);
                this.mBb.setBackgroundDrawable(drawable);
            }
        }
        if (cVar.vfW != null && cVar.vfW.length() > 0) {
            setMessage(cVar.vfW);
        }
        kH(cVar.vgc);
        if (cVar.fKz != null) {
            String str = cVar.fKz;
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 120);
            this.vib.setVisibility(0);
            this.mBb.setVisibility(0);
            if (this.mBb instanceof com.tencent.mm.ui.f.a) {
                ((com.tencent.mm.ui.f.a) this.mBb).K(str, fromDPToPix, fromDPToPix);
            }
            int i = cVar.vgl;
            this.vib.setVisibility(i);
            this.mBb.setVisibility(i);
        }
        if (!(cVar.vgn || cVar.vgo)) {
            if (cVar.vfW != null && cVar.vfW.length() > 0) {
                setMessage(cVar.vfW);
            }
            if (cVar.vfX == null || cVar.vfX.length() <= 0) {
                kH(false);
            } else {
                charSequence = cVar.vfX;
                this.vib.setVisibility(0);
                this.vhV.setVisibility(0);
                this.vhV.setMaxLines(2);
                this.vhV.setText(charSequence);
            }
            if (cVar.vfY != null && cVar.vfY.length() > 0) {
                charSequence = cVar.vfY;
                if (charSequence != null) {
                    this.vib.setVisibility(0);
                    this.vhW.setVisibility(0);
                    if (this.vim != null) {
                        c cVar2 = this.vim;
                        this.vhW.getContext();
                        charSequence = cVar2.a(charSequence.toString(), this.vhW.getTextSize());
                    }
                    this.vhW.setText(charSequence);
                }
            }
            if (cVar.vfU != null) {
                Bitmap bitmap = cVar.vfU;
                if (this.kD == null) {
                    this.vib.setVisibility(0);
                    this.mBb.setVisibility(0);
                    this.mBb.setImageBitmap(bitmap);
                }
            }
        }
        Bitmap bitmap2;
        CharSequence charSequence3;
        View inflate;
        if (cVar.vgn) {
            bitmap2 = cVar.vfU;
            charSequence2 = cVar.vfX;
            charSequence3 = cVar.vfY;
            inflate = r.eC(this.mContext).inflate(com.tencent.mm.s.a.h.hdM, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(g.ckd);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(g.hcC);
                textView.setVisibility(0);
                if (this.vim != null) {
                    charSequence2 = this.vim.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(g.cke);
                textView.setVisibility(0);
                if (this.vim != null) {
                    charSequence2 = this.vim.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            H(inflate, -1);
        } else if (cVar.vgo) {
            bitmap2 = cVar.vfU;
            charSequence2 = cVar.vfX;
            charSequence3 = cVar.vfY;
            inflate = r.eC(this.mContext).inflate(com.tencent.mm.s.a.h.hdN, null);
            if (bitmap2 != null) {
                imageView = (ImageView) inflate.findViewById(g.ckd);
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
            }
            if (charSequence2 != null) {
                textView = (TextView) inflate.findViewById(g.hcC);
                textView.setVisibility(0);
                if (this.vim != null) {
                    charSequence2 = this.vim.a(charSequence2.toString(), textView.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (charSequence3 != null) {
                textView = (TextView) inflate.findViewById(g.cke);
                textView.setVisibility(0);
                if (this.vim != null) {
                    charSequence2 = this.vim.a(charSequence3.toString(), textView.getTextSize());
                } else {
                    charSequence2 = charSequence3;
                }
                textView.setText(charSequence2);
            }
            H(inflate, -1);
        }
        if (!(cVar.vfL == null && cVar.vfN == null)) {
            String str2 = cVar.vfL;
            charSequence2 = cVar.vfN;
            Boolean valueOf = Boolean.valueOf(cVar.vfO);
            final b bVar = cVar.vfQ;
            this.vhZ.setLayoutResource(com.tencent.mm.s.a.h.hdP);
            LinearLayout linearLayout = null;
            try {
                linearLayout = (LinearLayout) this.vhZ.inflate();
            } catch (Exception e) {
                this.vhZ.setVisibility(0);
            }
            if (!(linearLayout == null || str2 == null)) {
                imageView = (ImageView) linearLayout.findViewById(g.hdr);
                imageView.setVisibility(0);
                com.tencent.mm.ui.f.a.a.a(imageView, str2);
            }
            if (!(linearLayout == null || charSequence2 == null)) {
                textView = (TextView) linearLayout.findViewById(g.hdD);
                textView.setVisibility(0);
                if (this.vim != null) {
                    charSequence2 = this.vim.a(charSequence2.toString(), this.llG.getTextSize());
                }
                textView.setText(charSequence2);
            }
            if (valueOf.booleanValue() && linearLayout != null) {
                imageView = (ImageView) linearLayout.findViewById(g.hcv);
                imageView.setVisibility(0);
                zT(0);
                linearLayout.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ h viq;

                    public final void onClick(View view) {
                        if (bVar != null) {
                            bVar.bET();
                        }
                        if (imageView.isSelected()) {
                            this.viq.vie.startAnimation(this.viq.vil);
                            this.viq.vil.setAnimationListener(new AnimationListener(this) {
                                final /* synthetic */ AnonymousClass1 vir;

                                {
                                    this.vir = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                    h.a(this.vir.viq, this.vir.viq.vii);
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    this.vir.viq.vie.setVisibility(8);
                                    this.vir.viq.zT(0);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }
                            });
                            ObjectAnimator.ofFloat(imageView, "rotation", new float[]{180.0f, 0.0f}).setDuration(200).start();
                            imageView.setSelected(false);
                            return;
                        }
                        this.viq.vie.startAnimation(this.viq.vij);
                        this.viq.vij.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ AnonymousClass1 vir;

                            {
                                this.vir = r1;
                            }

                            public final void onAnimationStart(Animation animation) {
                                h.a(this.vir.viq, this.vir.viq.vik);
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.vir.viq.vie.setVisibility(0);
                                this.vir.viq.zT(8);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 180.0f}).setDuration(200).start();
                        imageView.setSelected(true);
                    }
                });
            }
        }
        if (cVar.vfR != null) {
            final a aVar = cVar.vfR;
            if (this.vib != null && this.vib.getVisibility() == 0) {
                this.vib.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ h viq;

                    public final void onClick(View view) {
                        if (aVar != null) {
                            aVar.auI();
                        }
                    }
                });
            } else if (this.vid != null) {
                this.vid.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ h viq;

                    public final void onClick(View view) {
                        if (aVar != null) {
                            aVar.auI();
                        }
                    }
                });
            }
        }
        if (cVar.vfM != null) {
            cs(cVar.vfM);
        }
        if (!(cVar.vfV == null || cVar.vfV.isRecycled())) {
            Bitmap bitmap3 = cVar.vfV;
            boolean z = cVar.vgd;
            int i2 = cVar.vgk;
            if (bitmap3 != null) {
                Bitmap bitmap4;
                kH(false);
                this.vib.setVisibility(0);
                this.vib.setGravity(1);
                this.vib.setPadding(0, 0, 0, 0);
                View inflate2 = View.inflate(this.mContext, com.tencent.mm.s.a.h.hdO, null);
                imageView = (ImageView) inflate2.findViewById(g.ckd);
                if (z) {
                    int i3;
                    int i4;
                    bitmap4 = null;
                    float height = ((float) bitmap3.getHeight()) / ((float) bitmap3.getWidth());
                    int U = com.tencent.mm.bg.a.U(this.mContext, e.hbG);
                    int U2 = com.tencent.mm.bg.a.U(this.mContext, e.hbF);
                    if (height > 0.0f && ((double) height) < 0.5d) {
                        i3 = (int) (((float) U) / height);
                        i4 = U;
                    } else if (((double) height) >= 0.5d && height < 1.0f) {
                        U = (int) (((float) U2) * height);
                        i3 = U2;
                        i4 = U;
                    } else if (height >= 1.0f && height < 2.0f) {
                        U = (int) (((float) U2) / height);
                        i3 = U;
                        i4 = U2;
                        r18 = U2;
                        U2 = U;
                        U = r18;
                    } else if (height >= 2.0f) {
                        i4 = (int) (((float) U) * height);
                        i3 = U;
                        r18 = U;
                        U = U2;
                        U2 = r18;
                    } else {
                        U = 0;
                        U2 = 0;
                        i3 = 0;
                        i4 = 0;
                    }
                    if (i4 > 0 && i3 > 0 && bitmap3 != null) {
                        bitmap4 = Bitmap.createScaledBitmap(bitmap3, i3, i4, true);
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(U2, U));
                    }
                    bitmap4 = com.tencent.mm.sdk.platformtools.d.a(bitmap4, true, (float) com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 3));
                } else {
                    bitmap4 = bitmap3;
                }
                imageView.setImageBitmap(bitmap4);
                imageView = (ImageView) inflate2.findViewById(g.hcu);
                if (i2 == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    if (i2 == 1) {
                        imageView.setImageResource(j.heU);
                    } else if (i2 == 2) {
                        imageView.setImageResource(j.dts);
                    }
                }
                H(inflate2, -2);
            }
        }
        if (cVar.vfH != null && cVar.vfH.length() > 0) {
            charSequence = cVar.vfH;
            if (charSequence != null) {
                this.vhX.setVisibility(0);
                this.vhX.setText(charSequence);
            }
            this.vig = true;
            i = cVar.vgj;
            if (this.vhX != null) {
                this.vhX.setGravity(i);
            }
        }
        if (cVar.vfI != null && cVar.vfI.length() > 0) {
            charSequence = cVar.vfI;
            this.kM.setVisibility(0);
            this.kM.setHint(charSequence);
        }
        if (cVar.vfJ != null && cVar.vfJ.length() > 0) {
            charSequence = cVar.vfJ;
            this.Qb.setVisibility(0);
            this.Qb.setText(charSequence);
        }
        if (cVar.vfK) {
            this.vih = cVar.vfK;
            if (cVar.vfK) {
                this.kM.setVisibility(0);
            } else {
                this.kM.setVisibility(8);
            }
        }
        if (cVar.vfZ != null && cVar.vfZ.length() > 0) {
            a(cVar.vfZ, cVar.vgm, cVar.vge);
        }
        if (cVar.vga != null && cVar.vga.length() > 0) {
            b(cVar.vga, true, cVar.vgf);
        }
        if (cVar.FU != null) {
            setOnCancelListener(cVar.FU);
        }
        if (cVar.FV != null) {
            setOnDismissListener(cVar.FV);
        }
        if (cVar.vfS != null) {
            this.vim = cVar.vfS;
        }
        setCancelable(cVar.ppy);
        this.ppy = cVar.ppy;
        if (!this.ppy) {
            super.setCancelable(cVar.vgb);
        }
        if (cVar.vfP) {
            View inflate3 = r.eC(getContext()).inflate(com.tencent.mm.s.a.h.hdL, null);
            this.lyE = (Button) inflate3.findViewById(g.cjW);
            this.rMX = (Button) inflate3.findViewById(g.ckg);
            if (cVar.vfZ != null && cVar.vfZ.length() > 0) {
                a(cVar.vfZ, cVar.vgm, cVar.vge);
            }
            if (cVar.vga != null && cVar.vga.length() > 0) {
                b(cVar.vga, true, cVar.vgf);
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.vif.setVisibility(8);
            this.vic.removeAllViews();
            this.vic.addView(inflate3, layoutParams);
        }
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMAlertDialog", e, "", new Object[0]);
        }
    }

    public void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            af.v(new Runnable(this) {
                final /* synthetic */ h viq;

                {
                    this.viq = r1;
                }

                public final void run() {
                    this.viq.dismiss();
                }
            });
            w.e("MicroMsg.MMAlertDialog", bg.bJZ().toString());
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.MMAlertDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
