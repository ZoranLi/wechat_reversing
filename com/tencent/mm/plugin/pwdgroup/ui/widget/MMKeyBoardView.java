package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MMKeyBoardView extends LinearLayout implements OnClickListener, OnLongClickListener {
    private ColorStateList ec;
    private Context mContext;
    private float mGH;
    private Button oxL;
    private Button oxM;
    private Button oxN;
    private Button oxO;
    private Button oxP;
    private Button oxQ;
    private Button oxR;
    private Button oxS;
    private Button oxT;
    private Button oxU;
    private ImageButton oxV;
    private View oxW;
    private View oxX;
    private View oxY;
    private View oxZ;
    public a oxt;
    private View oya;
    private View oyb;
    private boolean oyc;
    private int oyd;
    private int oye;
    private int oyf;
    private int oyg;
    private int oyh;
    private int oyi;
    private int oyj;
    private int oyk;
    private int oyl;

    public interface a {
        void Ku();

        void delete();

        void input(String str);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMKeyBoardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.oyc = true;
        this.mContext = context;
        this.oyd = getResources().getDimensionPixelSize(R.f.bai);
        this.oye = getResources().getDimensionPixelSize(R.f.baj);
        this.mGH = (float) getResources().getDimensionPixelSize(R.f.bak);
        this.ec = getResources().getColorStateList(R.e.aUv);
        this.oyf = getResources().getColor(R.e.aUu);
        this.oxL = new Button(this.mContext);
        this.oxM = new Button(this.mContext);
        this.oxN = new Button(this.mContext);
        this.oxO = new Button(this.mContext);
        this.oxP = new Button(this.mContext);
        this.oxQ = new Button(this.mContext);
        this.oxR = new Button(this.mContext);
        this.oxS = new Button(this.mContext);
        this.oxT = new Button(this.mContext);
        this.oxU = new Button(this.mContext);
        this.oxV = new ImageButton(this.mContext);
        this.oxW = new View(this.mContext);
        this.oxW = new View(this.mContext);
        this.oxX = new View(this.mContext);
        this.oxY = new View(this.mContext);
        this.oxZ = new View(this.mContext);
        this.oya = new View(this.mContext);
        this.oyb = new View(this.mContext);
        this.oxL.setBackgroundResource(R.g.bgc);
        this.oxM.setBackgroundResource(R.g.bgc);
        this.oxN.setBackgroundResource(R.g.bgc);
        this.oxO.setBackgroundResource(R.g.bgc);
        this.oxP.setBackgroundResource(R.g.bgc);
        this.oxQ.setBackgroundResource(R.g.bgc);
        this.oxR.setBackgroundResource(R.g.bgc);
        this.oxS.setBackgroundResource(R.g.bgc);
        this.oxT.setBackgroundResource(R.g.bgc);
        this.oxQ.setBackgroundResource(R.g.bgc);
        this.oxU.setBackgroundResource(R.g.bgc);
        this.oxV.setBackgroundResource(R.g.bgc);
        this.oxV.setImageResource(R.g.bgd);
        this.oxL.setText("0");
        this.oxM.setText("1");
        this.oxN.setText("2");
        this.oxO.setText(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        this.oxP.setText("4");
        this.oxQ.setText("5");
        this.oxR.setText("6");
        this.oxS.setText("7");
        this.oxT.setText("8");
        this.oxU.setText("9");
        this.oxL.setGravity(17);
        this.oxM.setGravity(17);
        this.oxN.setGravity(17);
        this.oxO.setGravity(17);
        this.oxP.setGravity(17);
        this.oxQ.setGravity(17);
        this.oxR.setGravity(17);
        this.oxS.setGravity(17);
        this.oxT.setGravity(17);
        this.oxU.setGravity(17);
        this.oxL.setTextSize(0, this.mGH);
        this.oxM.setTextSize(0, this.mGH);
        this.oxN.setTextSize(0, this.mGH);
        this.oxO.setTextSize(0, this.mGH);
        this.oxP.setTextSize(0, this.mGH);
        this.oxQ.setTextSize(0, this.mGH);
        this.oxR.setTextSize(0, this.mGH);
        this.oxS.setTextSize(0, this.mGH);
        this.oxT.setTextSize(0, this.mGH);
        this.oxU.setTextSize(0, this.mGH);
        this.oxL.setTextColor(this.ec);
        this.oxM.setTextColor(this.ec);
        this.oxN.setTextColor(this.ec);
        this.oxO.setTextColor(this.ec);
        this.oxP.setTextColor(this.ec);
        this.oxQ.setTextColor(this.ec);
        this.oxR.setTextColor(this.ec);
        this.oxS.setTextColor(this.ec);
        this.oxT.setTextColor(this.ec);
        this.oxU.setTextColor(this.ec);
        this.oxL.setOnClickListener(this);
        this.oxM.setOnClickListener(this);
        this.oxN.setOnClickListener(this);
        this.oxO.setOnClickListener(this);
        this.oxP.setOnClickListener(this);
        this.oxQ.setOnClickListener(this);
        this.oxR.setOnClickListener(this);
        this.oxS.setOnClickListener(this);
        this.oxT.setOnClickListener(this);
        this.oxU.setOnClickListener(this);
        this.oxV.setOnClickListener(this);
        this.oxV.setOnLongClickListener(this);
        this.oxW.setBackgroundColor(this.oyf);
        this.oxW.setBackgroundColor(this.oyf);
        this.oxX.setBackgroundColor(this.oyf);
        this.oxY.setBackgroundColor(this.oyf);
        this.oxZ.setBackgroundColor(this.oyf);
        this.oya.setBackgroundColor(this.oyf);
        this.oyb.setBackgroundColor(this.oyf);
        addView(this.oxL);
        addView(this.oxM);
        addView(this.oxN);
        addView(this.oxO);
        addView(this.oxP);
        addView(this.oxQ);
        addView(this.oxR);
        addView(this.oxS);
        addView(this.oxT);
        addView(this.oxU);
        addView(this.oxV);
        addView(this.oxW);
        addView(this.oxX);
        addView(this.oxY);
        addView(this.oxZ);
        addView(this.oya);
        addView(this.oyb);
        post(new Runnable(this) {
            final /* synthetic */ MMKeyBoardView oym;

            {
                this.oym = r1;
            }

            public final void run() {
                this.oym.requestLayout();
            }
        });
    }

    protected void onDraw(Canvas canvas) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.oyg = getWidth();
        this.oyh = getHeight();
        int i5 = -this.oye;
        int i6 = (this.oyk - this.oye) + 1;
        int i7 = ((this.oyk * 2) - this.oye) + 2;
        int i8 = this.oyl + 2;
        int i9 = (this.oyl * 2) + 3;
        int i10 = (this.oyl * 3) + 4;
        this.oxM.layout(i5, 1, this.oyi + i5, this.oyj + 1);
        this.oxN.layout(i6, 1, this.oyi + i6, this.oyj + 1);
        this.oxO.layout(i7, 1, this.oyi + i7, this.oyj + 1);
        this.oxP.layout(i5, i8, this.oyi + i5, this.oyj + i8);
        this.oxQ.layout(i6, i8, this.oyi + i6, this.oyj + i8);
        this.oxR.layout(i7, i8, this.oyi + i7, this.oyj + i8);
        this.oxS.layout(i5, i9, this.oyi + i5, this.oyj + i9);
        this.oxT.layout(i6, i9, this.oyi + i6, this.oyj + i9);
        this.oxU.layout(i7, i9, this.oyi + i7, this.oyj + i9);
        this.oxL.layout(i6, i10, this.oyi + i6, this.oyj + i10);
        this.oxV.layout(i7, i10, this.oyi + i7, this.oyj + i10);
        this.oxW.layout(0, this.oyd + 1, this.oyg, (this.oyd + 1) + 1);
        this.oxX.layout(0, this.oyd + i8, this.oyg, (i8 + this.oyd) + 1);
        this.oxY.layout(0, this.oyd + i9, this.oyg, (i9 + this.oyd) + 1);
        this.oxZ.layout(0, this.oyd + i10, this.oyg, (this.oyd + i10) + 1);
        this.oya.layout(this.oyk + 1, this.oyd, this.oyk + 2, this.oyh);
        this.oyb.layout((this.oyk * 2) + 2, this.oyd, (this.oyk * 2) + 3, this.oyh);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.oyg = getWidth();
        this.oyh = getHeight();
        if (!(this.oyg == 0 || this.oyh == 0)) {
            this.oyk = (this.oyg - 2) / 3;
            this.oyl = ((this.oyh - this.oyd) - 4) / 4;
            this.oyi = this.oyk + (this.oye * 2);
            this.oyj = this.oyl + (this.oyd * 2);
        }
        this.oxM.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxN.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxO.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxP.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxQ.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxR.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxS.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxT.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxU.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxL.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxV.measure(MeasureSpec.makeMeasureSpec(this.oyi, 1073741824), MeasureSpec.makeMeasureSpec(this.oyj, 1073741824));
        this.oxW.measure(MeasureSpec.makeMeasureSpec(this.oyg, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.oxX.measure(MeasureSpec.makeMeasureSpec(this.oyg, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.oxY.measure(MeasureSpec.makeMeasureSpec(this.oyg, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.oxZ.measure(MeasureSpec.makeMeasureSpec(this.oyg, 1073741824), MeasureSpec.makeMeasureSpec(1, 1073741824));
        this.oya.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.oyh, 1073741824));
        this.oyb.measure(MeasureSpec.makeMeasureSpec(1, 1073741824), MeasureSpec.makeMeasureSpec(this.oyh, 1073741824));
    }

    public void onClick(View view) {
        if (!this.oyc) {
            w.d("MicroMsg.Facing.MMKeyBoardView", "onClick KeyBoard is disable.");
        } else if (view == this.oxL) {
            input("0");
        } else if (view == this.oxM) {
            input("1");
        } else if (view == this.oxN) {
            input("2");
        } else if (view == this.oxO) {
            input(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (view == this.oxP) {
            input("4");
        } else if (view == this.oxQ) {
            input("5");
        } else if (view == this.oxR) {
            input("6");
        } else if (view == this.oxS) {
            input("7");
        } else if (view == this.oxT) {
            input("8");
        } else if (view == this.oxU) {
            input("9");
        } else if (view == this.oxV && this.oxt != null && this.oyc) {
            this.oxt.delete();
        }
    }

    public boolean onLongClick(View view) {
        if (view == this.oxV && this.oxt != null && this.oyc) {
            this.oxt.Ku();
        }
        return false;
    }

    public final void go(boolean z) {
        this.oyc = z;
        this.oxL.setEnabled(z);
        this.oxM.setEnabled(z);
        this.oxN.setEnabled(z);
        this.oxO.setEnabled(z);
        this.oxP.setEnabled(z);
        this.oxQ.setEnabled(z);
        this.oxR.setEnabled(z);
        this.oxS.setEnabled(z);
        this.oxT.setEnabled(z);
        this.oxU.setEnabled(z);
        this.oxV.setEnabled(z);
    }

    private void input(String str) {
        if (this.oxt != null && this.oyc) {
            this.oxt.input(str);
        }
    }
}
