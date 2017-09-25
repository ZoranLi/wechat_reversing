package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;

public class IconPreference extends Preference {
    private Context context;
    private String desc;
    public Drawable drawable;
    private int height;
    private TextView mVG;
    public ImageView nvU;
    private String piN;
    private int piO;
    private int piP;
    private int vqC;
    private int vqD;
    private int vqE;
    private ImageView vqF;
    private ViewGroup vqG;
    private TextView vqH;
    private int vqJ;
    private String vqK;
    private int vqL;
    private int vqM;
    private int vqN;
    private Bitmap vqO;
    public int vqP;
    private int vqQ;
    private int vqR;
    private View vqS;
    private View vqT;
    public LayoutParams vqU;
    private TextView vqV;
    private TextView vqW;
    private ImageView vqX;
    private boolean vqY;
    public boolean vqZ;
    private int vra;

    public IconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piN = "";
        this.piO = -1;
        this.piP = 8;
        this.vqC = 8;
        this.vqJ = 8;
        this.desc = "";
        this.vqK = "";
        this.vqL = -1;
        this.vqM = 8;
        this.vqN = -1;
        this.vqO = null;
        this.vqP = -1;
        this.vqQ = 8;
        this.vqD = 0;
        this.vqE = 8;
        this.vqR = 8;
        this.nvU = null;
        this.vqF = null;
        this.vqG = null;
        this.vqS = null;
        this.vqT = null;
        this.height = -1;
        this.vqY = false;
        this.vqZ = false;
        this.vra = -1;
        this.context = context;
        setLayoutResource(h.diC);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.heo, viewGroup2);
        return onCreateView;
    }

    public final void cM(String str, int i) {
        this.piN = str;
        this.piO = i;
    }

    public final void cN(String str, int i) {
        R(str, i, this.vqN);
    }

    public final void R(String str, int i, int i2) {
        this.vqK = str;
        this.vqL = i;
        this.vqN = i2;
        if (this.vqV != null) {
            this.vqV.setText(str);
            if (i != -1) {
                this.vqV.setBackgroundDrawable(a.a(this.context, i));
            }
            if (i2 != -1) {
                this.vqV.setTextColor(i2);
            }
        }
    }

    public final void As(int i) {
        this.piP = i;
        if (this.vqW != null) {
            this.vqW.setVisibility(i);
        }
    }

    public final void At(int i) {
        this.vqM = i;
        if (this.vqV != null) {
            this.vqV.setVisibility(i);
        }
    }

    public final void kY(boolean z) {
        this.vqY = z;
        if (this.vqV == null) {
            return;
        }
        if (z) {
            this.vqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.hbX, 0);
            this.vqV.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.aXR));
            return;
        }
        this.vqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public final void Au(int i) {
        this.vqC = i;
        if (this.vqF != null) {
            this.vqF.setVisibility(i);
        }
    }

    public final void eb(int i, int i2) {
        this.vqC = i;
        this.vra = i2;
    }

    public final void P(Bitmap bitmap) {
        this.vqO = bitmap;
        this.vqP = -1;
        if (this.nvU != null) {
            this.nvU.setImageBitmap(bitmap);
        }
    }

    public final void Av(int i) {
        this.vqP = i;
        this.vqO = null;
        if (this.nvU != null) {
            this.nvU.setImageResource(i);
        }
    }

    public final void Aw(int i) {
        this.vqQ = i;
        if (this.nvU != null) {
            this.nvU.setVisibility(this.vqQ);
        }
    }

    public final void Ax(int i) {
        this.vqD = i;
        if (this.vqG != null) {
            this.vqG.setVisibility(this.vqD);
        }
    }

    public final void Ay(int i) {
        this.vqE = i;
        if (this.vqS != null) {
            this.vqS.setVisibility(this.vqE);
        }
    }

    public final void Az(int i) {
        this.vqR = i;
        if (this.vqT != null) {
            this.vqT.setVisibility(i);
        }
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.vqX = (ImageView) view.findViewById(g.bWV);
        if (this.vqX != null) {
            if (this.drawable != null) {
                this.vqX.setImageDrawable(this.drawable);
                this.vqX.setVisibility(0);
            } else if (this.PG != 0) {
                ImageView imageView = this.vqX;
                Drawable drawable = this.mContext.getResources().getDrawable(this.PG);
                this.drawable = drawable;
                imageView.setImageDrawable(drawable);
                this.vqX.setVisibility(0);
            } else {
                this.vqX.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.ckj);
        linearLayout.setMinimumHeight((int) (((float) view.getResources().getDimensionPixelSize(e.aXQ)) * a.dL(this.context)));
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        this.vqW = (TextView) view.findViewById(g.cHL);
        if (this.vqW != null) {
            if (this.vqZ) {
                this.vqW.setCompoundDrawablesWithIntrinsicBounds(f.hbX, 0, 0, 0);
                this.vqW.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.aXR));
            } else {
                this.vqW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.vqW.setVisibility(this.piP);
            this.vqW.setText(this.piN);
            if (this.piO != -1) {
                this.vqW.setBackgroundDrawable(a.a(this.context, this.piO));
            }
        }
        this.vqV = (TextView) view.findViewById(g.hdo);
        if (this.vqV != null) {
            this.vqV.setVisibility(this.vqM);
            this.vqV.setText(this.vqK);
            if (this.vqL != -1) {
                this.vqV.setBackgroundDrawable(a.a(this.context, this.vqL));
            }
            if (this.vqN != -1) {
                this.vqV.setTextColor(this.vqN);
            }
            if (this.vqY) {
                this.vqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, f.hbX, 0);
                this.vqV.setCompoundDrawablePadding((int) this.context.getResources().getDimension(e.aXR));
            } else {
                this.vqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        this.vqF = (ImageView) view.findViewById(g.hdm);
        this.vqF.setVisibility(this.vqC);
        if (this.vra != -1) {
            this.vqF.setImageResource(this.vra);
        }
        this.nvU = (ImageView) view.findViewById(g.hct);
        this.vqG = (ViewGroup) view.findViewById(g.hcX);
        this.vqT = view.findViewById(g.hcW);
        this.vqT.setVisibility(this.vqR);
        this.vqS = view.findViewById(g.cyV);
        this.vqS.setVisibility(this.vqE);
        if (this.vqO != null) {
            this.nvU.setImageBitmap(this.vqO);
        } else if (this.vqP != -1) {
            this.nvU.setImageResource(this.vqP);
        }
        this.nvU.setVisibility(this.vqQ);
        this.vqG.setVisibility(this.vqD);
        if (this.vqU != null) {
            this.nvU.setLayoutParams(this.vqU);
        }
        this.vqH = (TextView) view.findViewById(16908310);
        this.mVG = (TextView) view.findViewById(g.bHZ);
        if (this.mVG != null) {
            this.mVG.setVisibility(this.vqJ);
            this.mVG.setText(this.desc);
        }
    }
}
