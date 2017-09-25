package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.smtt.sdk.WebView;

public class YANumberPicker extends View {
    private int Xl = 2;
    private VelocityTracker fk;
    private q iB;
    private float jAa;
    private float jAb;
    private float jAc;
    private int jAd = 0;
    private int jAe = 0;
    private int jAf = 0;
    private int jAg = 0;
    private int jAh = 0;
    private int jrj;
    int jyO = -13421773;
    int jyP = -695533;
    private int jyQ = -695533;
    private int jyR = 0;
    private int jyS = 0;
    private int jyT = 0;
    private int jyU = 0;
    private int jyV = 0;
    private int jyW = 0;
    private int jyX = 0;
    int jyY = 0;
    private int jyZ = 0;
    private boolean jzA = true;
    private boolean jzB = false;
    private boolean jzC = true;
    private boolean jzD = false;
    private boolean jzE = false;
    private boolean jzF = true;
    Paint jzG = new Paint();
    private TextPaint jzH = new TextPaint();
    private Paint jzI = new Paint();
    private String[] jzJ;
    private CharSequence[] jzK;
    private CharSequence[] jzL;
    private Handler jzM;
    private Handler jzN;
    public a jzO;
    private b jzP;
    private int jzQ;
    private int jzR;
    private int jzS;
    private int jzT;
    private float jzU = 0.0f;
    private float jzV = 0.0f;
    private float jzW = 0.0f;
    private boolean jzX = false;
    private int jzY;
    private int jzZ;
    int jza = -695533;
    private int jzb = 0;
    private int jzc = 0;
    private int jzd = 3;
    private int jze = 0;
    private int jzf = 0;
    private int jzg = -1;
    private int jzh = -1;
    int jzi = 0;
    int jzj = 0;
    private int jzk = 0;
    private int jzl = 0;
    private int jzm = 0;
    private int jzn = 0;
    private int jzo = 0;
    private int jzp = ck.CTRL_INDEX;
    private int jzq = 8;
    private String jzr;
    public String jzs;
    private String jzt;
    private String jzu;
    private float jzv = 1.0f;
    private float jzw = 0.0f;
    private float jzx = 0.0f;
    private float jzy = 0.0f;
    private boolean jzz = true;
    private HandlerThread mHandlerThread;
    private boolean mHasInit = false;
    private int xV = 0;

    public interface a {
        void a(YANumberPicker yANumberPicker, int i);
    }

    public interface b {
    }

    static /* synthetic */ void a(YANumberPicker yANumberPicker, int i, int i2, Object obj) {
        yANumberPicker.jd(0);
        if (i != i2 && ((obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && yANumberPicker.jzO != null)) {
            yANumberPicker.jzO.a(yANumberPicker, yANumberPicker.jzi + i2);
        }
        yANumberPicker.jzo = i2;
        if (yANumberPicker.jzD) {
            yANumberPicker.jzD = false;
            yANumberPicker.D(yANumberPicker.ZL() - yANumberPicker.jzg, false);
            yANumberPicker.jzA = false;
            yANumberPicker.postInvalidate();
        }
    }

    public YANumberPicker(Context context) {
        super(context);
        init(context);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
        init(context);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
        init(context);
    }

    private void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fsr);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.n.fsJ) {
                    this.jzd = obtainStyledAttributes.getInt(index, 3);
                } else if (index == R.n.fsv) {
                    this.jza = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == R.n.fsw) {
                    this.Xl = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == R.n.fsx) {
                    this.jzb = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.n.fsy) {
                    this.jzc = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.n.fsL) {
                    String[] strArr;
                    CharSequence[] textArray = obtainStyledAttributes.getTextArray(index);
                    if (textArray == null) {
                        strArr = null;
                    } else {
                        String[] strArr2 = new String[textArray.length];
                        for (index = 0; index < textArray.length; index++) {
                            strArr2[index] = textArray[index].toString();
                        }
                        strArr = strArr2;
                    }
                    this.jzJ = strArr;
                } else if (index == R.n.fsN) {
                    this.jyO = obtainStyledAttributes.getColor(index, -13421773);
                } else if (index == R.n.fsO) {
                    this.jyP = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == R.n.fsM) {
                    this.jyQ = obtainStyledAttributes.getColor(index, -695533);
                } else if (index == R.n.fsR) {
                    this.jyR = obtainStyledAttributes.getDimensionPixelSize(index, b(context, 13.0f));
                } else if (index == R.n.fsS) {
                    this.jyS = obtainStyledAttributes.getDimensionPixelSize(index, b(context, 15.0f));
                } else if (index == R.n.fsQ) {
                    this.jyT = obtainStyledAttributes.getDimensionPixelSize(index, b(context, 14.0f));
                } else if (index == R.n.fsG) {
                    this.jzg = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.n.fsF) {
                    this.jzh = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.n.fsT) {
                    this.jzA = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R.n.fsK) {
                    this.jzz = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R.n.fsA) {
                    this.jzr = obtainStyledAttributes.getString(index);
                } else if (index == R.n.fss) {
                    this.jzu = obtainStyledAttributes.getString(index);
                } else if (index == R.n.fsz) {
                    this.jzt = obtainStyledAttributes.getString(index);
                } else if (index == R.n.fsE) {
                    this.jyW = obtainStyledAttributes.getDimensionPixelSize(index, c(context, 8.0f));
                } else if (index == R.n.fsD) {
                    this.jyX = obtainStyledAttributes.getDimensionPixelSize(index, c(context, 8.0f));
                } else if (index == R.n.fsC) {
                    this.jyY = obtainStyledAttributes.getDimensionPixelSize(index, c(context, 2.0f));
                } else if (index == R.n.fsB) {
                    this.jyZ = obtainStyledAttributes.getDimensionPixelSize(index, c(context, 5.0f));
                } else if (index == R.n.fst) {
                    this.jzK = obtainStyledAttributes.getTextArray(index);
                } else if (index == R.n.fsu) {
                    this.jzL = obtainStyledAttributes.getTextArray(index);
                } else if (index == R.n.fsI) {
                    this.jzE = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.n.fsH) {
                    this.jzF = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == R.n.fsP) {
                    this.jzs = obtainStyledAttributes.getString(index);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void init(Context context) {
        this.iB = q.a(context, null);
        this.jzp = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.jzq = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.jyR == 0) {
            this.jyR = b(context, 13.0f);
        }
        if (this.jyS == 0) {
            this.jyS = b(context, 15.0f);
        }
        if (this.jyT == 0) {
            this.jyT = b(context, 14.0f);
        }
        if (this.jyW == 0) {
            this.jyW = c(context, 8.0f);
        }
        if (this.jyX == 0) {
            this.jyX = c(context, 8.0f);
        }
        this.jzG.setColor(this.jza);
        this.jzG.setAntiAlias(true);
        this.jzG.setStyle(Style.STROKE);
        this.jzG.setStrokeWidth((float) this.Xl);
        this.jzH.setColor(this.jyO);
        this.jzH.setAntiAlias(true);
        this.jzH.setTextAlign(Align.CENTER);
        this.jzI.setColor(this.jyQ);
        this.jzI.setAntiAlias(true);
        this.jzI.setTextAlign(Align.CENTER);
        this.jzI.setTextSize((float) this.jyT);
        if (this.jzd % 2 == 0) {
            this.jzd++;
        }
        if (this.jzg == -1 || this.jzh == -1) {
            if (this.jzJ == null) {
                this.jzJ = new String[1];
                this.jzJ[0] = "0";
            }
            ZO();
            if (this.jzg == -1) {
                this.jzg = 0;
            }
            if (this.jzh == -1) {
                this.jzh = this.jzJ.length - 1;
            }
            h(this.jzg, this.jzh, false);
        }
        initHandler();
    }

    private void initHandler() {
        this.mHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.mHandlerThread.start();
        this.jzM = new Handler(this, this.mHandlerThread.getLooper()) {
            final /* synthetic */ YANumberPicker jAi;

            public final void handleMessage(Message message) {
                int i = 0;
                switch (message.what) {
                    case 1:
                        if (this.jAi.iB.isFinished()) {
                            int c;
                            if (this.jAi.jAe != 0) {
                                if (this.jAi.xV == 0) {
                                    this.jAi.jd(1);
                                }
                                int e;
                                if (this.jAi.jAe < (-this.jAi.jzZ) / 2) {
                                    e = (int) ((((float) (this.jAi.jzZ + this.jAi.jAe)) * 300.0f) / ((float) this.jAi.jzZ));
                                    int i2 = 0;
                                    this.jAi.iB.startScroll(0, this.jAi.jAf, i2, this.jAi.jAe + this.jAi.jzZ, e * 3);
                                    c = this.jAi.je((this.jAi.jAf + this.jAi.jzZ) + this.jAi.jAe);
                                    i = e;
                                } else {
                                    e = (int) ((((float) (-this.jAi.jAe)) * 300.0f) / ((float) this.jAi.jzZ));
                                    this.jAi.iB.startScroll(0, this.jAi.jAf, 0, this.jAi.jAe, e * 3);
                                    c = this.jAi.je(this.jAi.jAf + this.jAi.jAe);
                                    i = e;
                                }
                                this.jAi.postInvalidate();
                            } else {
                                this.jAi.jd(0);
                                c = this.jAi.je(this.jAi.jAf);
                            }
                            Message c2 = YANumberPicker.b(2, this.jAi.jzo, c, message.obj);
                            if (this.jAi.jzF) {
                                this.jAi.jzN.sendMessageDelayed(c2, (long) (i * 2));
                                return;
                            } else {
                                this.jAi.jzM.sendMessageDelayed(c2, (long) (i * 2));
                                return;
                            }
                        }
                        if (this.jAi.xV == 0) {
                            this.jAi.jd(1);
                        }
                        this.jAi.jzM.sendMessageDelayed(YANumberPicker.b(1, 0, 0, message.obj), 32);
                        return;
                    case 2:
                        YANumberPicker.a(this.jAi, message.arg1, message.arg2, message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.jzN = new Handler(this) {
            final /* synthetic */ YANumberPicker jAi;

            {
                this.jAi = r1;
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 2:
                        YANumberPicker.a(this.jAi, message.arg1, message.arg2, message.obj);
                        return;
                    case 3:
                        this.jAi.requestLayout();
                        return;
                    default:
                        return;
                }
            }
        };
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        super.onMeasure(i, i2);
        cC(false);
        int mode = MeasureSpec.getMode(i);
        this.jAg = mode;
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i3 = size;
        } else {
            i3 = Math.max(this.jyU, this.jyV) == 0 ? 0 : this.jyX;
            if (Math.max(this.jyU, this.jyV) != 0) {
                i4 = this.jyW;
            }
            i3 = Math.max(this.jzm, (((i3 + (i4 + Math.max(this.jyU, this.jyV))) + (this.jyZ * 2)) * 2) + Math.max(this.jzk, this.jzn)) + (getPaddingLeft() + getPaddingRight());
            if (mode == Integer.MIN_VALUE) {
                i3 = Math.min(i3, size);
            }
        }
        mode = MeasureSpec.getMode(i2);
        this.jAh = mode;
        i4 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (this.jzd * (this.jzl + (this.jyY * 2))) + (getPaddingTop() + getPaddingBottom());
            i4 = mode == Integer.MIN_VALUE ? Math.min(size, i4) : size;
        }
        setMeasuredDimension(i3, i4);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        super.onSizeChanged(i, i2, i3, i4);
        this.jrj = i;
        this.jzY = i2;
        this.jzZ = this.jzY / this.jzd;
        this.jAc = ((float) ((this.jrj + getPaddingLeft()) - getPaddingRight())) / 2.0f;
        int value = ZK() > 1 ? this.mHasInit ? getValue() - this.jzi : this.jzB ? this.jAd + ((this.jzd - 1) / 2) : 0 : 0;
        if (this.jzA && this.jzC) {
            z = true;
        } else {
            z = false;
        }
        D(value, z);
        if (this.jyR > this.jzZ) {
            this.jyR = this.jzZ;
        }
        if (this.jyS > this.jzZ) {
            this.jyS = this.jzZ;
        }
        if (this.jzI == null) {
            throw new IllegalArgumentException("mPaintHint should not be null.");
        }
        this.jzI.setTextSize((float) this.jyT);
        this.jzy = a(this.jzI.getFontMetrics());
        this.jyU = a(this.jzr, this.jzI);
        if (this.jzH == null) {
            throw new IllegalArgumentException("mPaintText should not be null.");
        }
        this.jzH.setTextSize((float) this.jyS);
        this.jzx = a(this.jzH.getFontMetrics());
        this.jzH.setTextSize((float) this.jyR);
        this.jzw = a(this.jzH.getFontMetrics());
        ZM();
        this.jze = this.jzd / 2;
        this.jzf = this.jze + 1;
        this.jAa = (float) ((this.jze * this.jzY) / this.jzd);
        this.jAb = (float) ((this.jzf * this.jzY) / this.jzd);
        if (this.jzb < 0) {
            this.jzb = 0;
        }
        if (this.jzc < 0) {
            this.jzc = 0;
        }
        if (this.jzb + this.jzc != 0 && getPaddingLeft() + this.jzb >= (this.jrj - getPaddingRight()) - this.jzc) {
            value = (((getPaddingLeft() + this.jzb) + getPaddingRight()) + this.jzc) - this.jrj;
            this.jzb = (int) (((float) this.jzb) - ((((float) value) * ((float) this.jzb)) / ((float) (this.jzb + this.jzc))));
            this.jzc = (int) (((float) this.jzc) - ((((float) value) * ((float) this.jzc)) / ((float) (this.jzb + this.jzc))));
        }
        this.mHasInit = true;
    }

    public void postInvalidate() {
        if (z.al(this)) {
            super.postInvalidate();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHandlerThread == null || !this.mHandlerThread.isAlive()) {
            initHandler();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandlerThread.quit();
        if (this.jzZ != 0) {
            if (!this.iB.isFinished()) {
                this.iB.abortAnimation();
                this.jAf = this.iB.getCurrY();
                ZN();
                if (this.jAe != 0) {
                    if (this.jAe < (-this.jzZ) / 2) {
                        this.jAf = (this.jAf + this.jzZ) + this.jAe;
                    } else {
                        this.jAf += this.jAe;
                    }
                    ZN();
                }
                jd(0);
            }
            int je = je(this.jAf);
            if (je != this.jzo && this.jzE) {
                try {
                    if (this.jzO != null) {
                        this.jzO.a(this, this.jzi + je);
                    }
                } catch (Exception e) {
                }
            }
            this.jzo = je;
        }
    }

    private int ZK() {
        return (this.jzh - this.jzg) + 1;
    }

    public final void setDisplayedValues(String[] strArr) {
        boolean z = true;
        if (this.jzM != null) {
            this.jzM.removeMessages(1);
        }
        ZP();
        if (strArr == null) {
            throw new IllegalArgumentException("newDisplayedValues should not be null.");
        } else if ((this.jzj - this.jzi) + 1 > strArr.length) {
            throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.jzj - this.jzi) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
        } else {
            this.jzJ = strArr;
            ZO();
            cC(true);
            this.jzo = this.jzg + 0;
            if (!(this.jzA && this.jzC)) {
                z = false;
            }
            D(0, z);
            postInvalidate();
            this.jzN.sendEmptyMessage(3);
        }
    }

    public final void setMaxValue(int i) {
        if (this.jzJ == null) {
            throw new NullPointerException("mDisplayedValues should not be null");
        } else if ((i - this.jzi) + 1 > this.jzJ.length) {
            throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.jzi) + 1) + " and mDisplayedValues.length is " + this.jzJ.length);
        } else {
            this.jzj = i;
            this.jzh = (this.jzj - this.jzi) + this.jzg;
            h(this.jzg, this.jzh, true);
            ZM();
        }
    }

    public final void setValue(int i) {
        if (i < this.jzi) {
            throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + i);
        } else if (i > this.jzj) {
            throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + i);
        } else {
            int i2 = i - this.jzi;
            if (this.jzg >= 0 && this.jzg <= i2 && i2 <= this.jzh) {
                this.jzo = i2;
                int i3 = i2 - this.jzg;
                boolean z = this.jzA && this.jzC;
                D(i3, z);
                postInvalidate();
            }
        }
    }

    public final int getValue() {
        return ZL() + this.jzi;
    }

    public final void setDividerHeight(int i) {
        if (i != this.Xl) {
            this.Xl = i;
            this.jzG.setStrokeWidth((float) this.Xl);
            postInvalidate();
        }
    }

    private int ZL() {
        if (this.jAe == 0) {
            return je(this.jAf);
        }
        if (this.jAe < (-this.jzZ) / 2) {
            return je((this.jAf + this.jzZ) + this.jAe);
        }
        return je(this.jAf + this.jAe);
    }

    private void h(int i, int i2, boolean z) {
        if (i > i2) {
            throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
        } else if (this.jzJ == null) {
            throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
        } else if (i < 0) {
            throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + i);
        } else if (i > this.jzJ.length - 1) {
            throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.jzJ.length - 1) + " minShowIndex is " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + i2);
        } else if (i2 > this.jzJ.length - 1) {
            throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.jzJ.length - 1) + " maxShowIndex is " + i2);
        } else {
            this.jzg = i;
            this.jzh = i2;
            if (z) {
                boolean z2;
                this.jzo = this.jzg + 0;
                if (this.jzA && this.jzC) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                D(0, z2);
                postInvalidate();
            }
        }
    }

    private void jd(int i) {
        if (this.xV != i) {
            this.xV = i;
        }
    }

    private int je(int i) {
        boolean z = false;
        if (this.jzZ == 0) {
            return 0;
        }
        int i2 = (i / this.jzZ) + (this.jzd / 2);
        int ZK = ZK();
        if (this.jzA && this.jzC) {
            z = true;
        }
        int i3 = i(i2, ZK, z);
        if (i3 >= 0 && i3 < ZK()) {
            return i3 + this.jzg;
        }
        throw new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + i3 + " getOneRecycleSize() : " + ZK() + " mWrapSelectorWheel : " + this.jzA);
    }

    private static int i(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3;
    }

    private void ZM() {
        this.jzS = 0;
        this.jzT = (-this.jzd) * this.jzZ;
        if (this.jzJ != null) {
            this.jzS = ((ZK() - (this.jzd / 2)) - 1) * this.jzZ;
            this.jzT = (-(this.jzd / 2)) * this.jzZ;
        }
    }

    private int jf(int i) {
        if (this.jzA && this.jzC) {
            return i;
        }
        if (i < this.jzT) {
            return this.jzT;
        }
        if (i > this.jzS) {
            return this.jzS;
        }
        return i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jzZ != 0) {
            if (this.fk == null) {
                this.fk = VelocityTracker.obtain();
            }
            this.fk.addMovement(motionEvent);
            this.jzW = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.jzX = true;
                    this.jzM.removeMessages(1);
                    ZP();
                    this.jzV = this.jzW;
                    this.jzU = (float) this.jAf;
                    jd(0);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    int yVelocity;
                    if (!this.jzX) {
                        VelocityTracker velocityTracker = this.fk;
                        velocityTracker.computeCurrentVelocity(1000);
                        yVelocity = (int) (velocityTracker.getYVelocity() * this.jzv);
                        if (Math.abs(yVelocity) > this.jzp) {
                            this.iB.a(this.jAf, 0, -yVelocity, Integer.MIN_VALUE, Integer.MAX_VALUE, jf(Integer.MIN_VALUE), jf(Integer.MAX_VALUE));
                            invalidate();
                            jd(2);
                        }
                        this.jzM.sendMessageDelayed(b(1, 0, 0, null), 0);
                        if (this.fk != null) {
                            this.fk.clear();
                            this.fk.recycle();
                            this.fk = null;
                            break;
                        }
                    }
                    float y = motionEvent.getY();
                    yVelocity = 0;
                    while (yVelocity < this.jzd) {
                        if (((float) (this.jzZ * yVelocity)) <= y && y < ((float) (this.jzZ * (yVelocity + 1)))) {
                            if (yVelocity >= 0 && yVelocity < this.jzd) {
                                int ZL;
                                int i;
                                int i2;
                                yVelocity -= this.jzd / 2;
                                if (!(this.jzA && this.jzC)) {
                                    ZL = ZL();
                                    if (ZL + yVelocity > this.jzh) {
                                        yVelocity = this.jzh - ZL;
                                    } else if (ZL + yVelocity < this.jzg) {
                                        yVelocity = this.jzg - ZL;
                                    }
                                }
                                if (this.jAe < (-this.jzZ) / 2) {
                                    ZL = this.jzZ + this.jAe;
                                    i = (int) ((((float) (this.jzZ + this.jAe)) * 300.0f) / ((float) this.jzZ));
                                    i = yVelocity < 0 ? (-i) - (yVelocity * e.CTRL_INDEX) : i + (yVelocity * e.CTRL_INDEX);
                                } else {
                                    ZL = this.jAe;
                                    i = (int) ((((float) (-this.jAe)) * 300.0f) / ((float) this.jzZ));
                                    i = yVelocity < 0 ? i - (yVelocity * e.CTRL_INDEX) : i + (yVelocity * e.CTRL_INDEX);
                                }
                                int i3 = ZL + (yVelocity * this.jzZ);
                                if (i < e.CTRL_INDEX) {
                                    i2 = e.CTRL_INDEX;
                                } else {
                                    i2 = i;
                                }
                                if (i2 > 600) {
                                    i2 = 600;
                                }
                                this.iB.startScroll(0, this.jAf, 0, i3, i2);
                                this.jzM.sendMessageDelayed(b(1, 0, 0, null), (long) (i2 / 4));
                                postInvalidate();
                                break;
                            }
                        }
                        yVelocity++;
                    }
                    break;
                    break;
                case 2:
                    float f = this.jzV - this.jzW;
                    if (!this.jzX || ((float) (-this.jzq)) >= f || f >= ((float) this.jzq)) {
                        this.jzX = false;
                        this.jAf = jf((int) (f + this.jzU));
                        ZN();
                        invalidate();
                    }
                    jd(1);
                    break;
                case 3:
                    this.jzU = (float) this.jAf;
                    ZP();
                    this.jzM.sendMessageDelayed(b(1, 0, 0, null), 0);
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    private static float a(FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private void D(int i, boolean z) {
        this.jAd = i - ((this.jzd - 1) / 2);
        this.jAd = i(this.jAd, ZK(), z);
        if (this.jzZ == 0) {
            this.jzB = true;
            return;
        }
        this.jAf = this.jAd * this.jzZ;
        this.jzQ = this.jAd + (this.jzd / 2);
        this.jzQ %= ZK();
        if (this.jzQ < 0) {
            this.jzQ += ZK();
        }
        this.jzR = this.jzQ;
        ZN();
    }

    public void computeScroll() {
        if (this.jzZ != 0 && this.iB.computeScrollOffset()) {
            this.jAf = this.iB.getCurrY();
            ZN();
            postInvalidate();
        }
    }

    private void ZN() {
        this.jAd = (int) Math.floor((double) (((float) this.jAf) / ((float) this.jzZ)));
        this.jAe = -(this.jAf - (this.jAd * this.jzZ));
        if (this.jzP != null) {
            if ((-this.jAe) > this.jzZ / 2) {
                this.jzR = (this.jAd + 1) + (this.jzd / 2);
            } else {
                this.jzR = this.jAd + (this.jzd / 2);
            }
            this.jzR %= ZK();
            if (this.jzR < 0) {
                this.jzR += ZK();
            }
            this.jzQ = this.jzR;
        }
    }

    private void cC(boolean z) {
        float textSize = this.jzH.getTextSize();
        this.jzH.setTextSize((float) this.jyS);
        this.jzk = a(this.jzJ, this.jzH);
        this.jzm = a(this.jzK, this.jzH);
        this.jzn = a(this.jzL, this.jzH);
        this.jzH.setTextSize((float) this.jyT);
        this.jyV = a(this.jzu, this.jzH);
        this.jzH.setTextSize(textSize);
        textSize = this.jzH.getTextSize();
        this.jzH.setTextSize((float) this.jyS);
        this.jzl = (int) (((double) (this.jzH.getFontMetrics().bottom - this.jzH.getFontMetrics().top)) + 0.5d);
        this.jzH.setTextSize(textSize);
        if (!z) {
            return;
        }
        if (this.jAg == Integer.MIN_VALUE || this.jAh == Integer.MIN_VALUE) {
            this.jzN.sendEmptyMessage(3);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = 0.0f;
        for (int i = 0; i < this.jzd + 1; i++) {
            float f2;
            float f3;
            float f4 = (float) (this.jAe + (this.jzZ * i));
            int i2 = this.jAd + i;
            int ZK = ZK();
            boolean z = this.jzA && this.jzC;
            int i3 = i(i2, ZK, z);
            if (i == this.jzd / 2) {
                float f5 = ((float) (this.jzZ + this.jAe)) / ((float) this.jzZ);
                i2 = a(f5, this.jyO, this.jyP);
                f = (float) this.jyR;
                f2 = ((((float) this.jyS) - f) * f5) + f;
                f = this.jzw;
                float f6 = f + ((this.jzx - f) * f5);
                f = f5;
                ZK = i2;
                f3 = f2;
                f2 = f6;
            } else if (i == (this.jzd / 2) + 1) {
                ZK = a(1.0f - f, this.jyO, this.jyP);
                f3 = (float) this.jyR;
                f3 += (1.0f - f) * (((float) this.jyS) - f3);
                f2 = 1.0f - f;
                float f7 = this.jzw;
                f2 = (f2 * (this.jzx - f7)) + f7;
            } else {
                ZK = this.jyO;
                f3 = (float) this.jyR;
                f2 = this.jzw;
            }
            this.jzH.setColor(ZK);
            this.jzH.setTextSize(f3);
            if (i3 >= 0 && i3 < ZK()) {
                CharSequence ellipsize;
                CharSequence charSequence = this.jzJ[this.jzg + i3];
                if (this.jzs != null) {
                    TruncateAt truncateAt;
                    TextPaint textPaint = this.jzH;
                    f7 = (float) (getWidth() - (this.jyZ * 2));
                    String str = this.jzs;
                    Object obj = -1;
                    switch (str.hashCode()) {
                        case -1074341483:
                            if (str.equals("middle")) {
                                i2 = 1;
                                break;
                            }
                            break;
                        case 100571:
                            if (str.equals("end")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 109757538:
                            if (str.equals("start")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case null:
                            truncateAt = TruncateAt.START;
                            break;
                        case 1:
                            truncateAt = TruncateAt.MIDDLE;
                            break;
                        case 2:
                            truncateAt = TruncateAt.END;
                            break;
                        default:
                            throw new IllegalArgumentException("Illegal text ellipsize type.");
                    }
                    ellipsize = TextUtils.ellipsize(charSequence, textPaint, f7, truncateAt);
                } else {
                    ellipsize = charSequence;
                }
                canvas.drawText(ellipsize.toString(), this.jAc, f2 + (f4 + ((float) (this.jzZ / 2))), this.jzH);
            } else if (!TextUtils.isEmpty(this.jzt)) {
                canvas.drawText(this.jzt, this.jAc, f2 + (f4 + ((float) (this.jzZ / 2))), this.jzH);
            }
        }
        if (this.jzz) {
            canvas.drawLine((float) (getPaddingLeft() + this.jzb), this.jAa, (float) ((this.jrj - getPaddingRight()) - this.jzc), this.jAa, this.jzG);
            canvas.drawLine((float) (getPaddingLeft() + this.jzb), this.jAb, (float) ((this.jrj - getPaddingRight()) - this.jzc), this.jAb, this.jzG);
        }
        if (!TextUtils.isEmpty(this.jzr)) {
            canvas.drawText(this.jzr, (this.jAc + ((float) ((this.jzk + this.jyU) / 2))) + ((float) this.jyW), ((this.jAa + this.jAb) / 2.0f) + this.jzy, this.jzI);
        }
    }

    private static int a(CharSequence[] charSequenceArr, Paint paint) {
        int i = 0;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                if (charSequence != null) {
                    i = Math.max(a(charSequence, paint), i);
                }
            }
        }
        return i;
    }

    private static int a(CharSequence charSequence, Paint paint) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        return (int) (paint.measureText(charSequence.toString()) + 0.5f);
    }

    private void ZO() {
        this.jzC = this.jzJ.length > this.jzd;
    }

    private void ZP() {
        if (this.iB != null && !this.iB.isFinished()) {
            this.iB.startScroll(0, this.iB.getCurrY(), 0, 0, 1);
            this.iB.abortAnimation();
            postInvalidate();
        }
    }

    public final void ZQ() {
        ZP();
        if (this.jzM != null) {
            this.jzM.sendMessageDelayed(b(1, 0, 0, null), 0);
        }
    }

    private static Message b(int i, int i2, int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    private static int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    private static int c(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    private static int a(float f, int i, int i2) {
        int i3 = (i & WebView.NIGHT_MODE_COLOR) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & 65280) >>> 8;
        int i6 = (i & 255) >>> 0;
        return (((((int) ((((float) (((WebView.NIGHT_MODE_COLOR & i2) >>> 24) - i3)) * f) + ((float) i3))) << 24) | (((int) ((((float) (((16711680 & i2) >>> 16) - i4)) * f) + ((float) i4))) << 16)) | (((int) ((((float) (((65280 & i2) >>> 8) - i5)) * f) + ((float) i5))) << 8)) | ((int) ((((float) (((i2 & 255) >>> 0) - i6)) * f) + ((float) i6)));
    }
}
