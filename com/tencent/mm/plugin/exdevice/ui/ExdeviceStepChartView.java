package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView extends View {
    Paint jXK;
    private final int lnZ;
    private final int loA;
    private final float loB;
    private final int loC;
    private final float loD;
    private final int loE;
    private final float loF;
    private final int loG;
    private final float loH;
    private final int loI;
    private final float loJ;
    private final int loK;
    private final float loL;
    private final int loM;
    private final float loN;
    private final float loO;
    private final float loP;
    private final float loQ;
    private final int loR;
    private final int loS;
    private final int loT;
    private final int loU;
    private final float loV;
    private final int loW;
    private final float loX;
    private final int loY;
    private final float loZ;
    private final int loa;
    private final int lob;
    private final float loc;
    private final float lod;
    private final float loe;
    private final float lof;
    private final float log;
    private final int loh;
    private final int loi;
    private final int loj;
    private final int lok;
    private int lol;
    private int lom;
    private int lon;
    private final float loo;
    private final float lop;
    private final int loq;
    private final float lor;
    private final int los;
    private final float lot;
    private final int lou;
    private final float lov;
    private final int low;
    private final float lox;
    private final int loy;
    private final float loz;
    private boolean lpA;
    PathEffect lpB;
    private int lpC;
    private int lpD;
    private boolean lpE;
    private final int lpa;
    private final float lpb;
    private final int lpc;
    private final float lpd;
    private final int lpe;
    private final int lpf;
    private final int lpg;
    private final int lph;
    private final int lpi;
    private final int lpj;
    private final int lpk;
    private final int lpl;
    private final int lpm;
    private int lpn;
    private final Typeface lpo;
    private final Typeface lpp;
    private int lpq;
    private int lpr;
    int[] lps;
    private final int lpt;
    private float[] lpu;
    private float[] lpv;
    private boolean[] lpw;
    Path lpx;
    Path lpy;
    List<String> lpz;
    List<Point> points;

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lnZ = -1;
        this.loa = -1;
        this.lob = getResources().getColor(R.e.aTH);
        this.loc = 12.0f;
        this.lod = 28.0f;
        this.loe = 33.0f;
        this.lof = 12.0f;
        this.log = 12.0f;
        this.loh = getResources().getColor(R.e.aTI);
        this.loi = -1;
        this.loj = getResources().getColor(R.e.aTI);
        this.lok = -1;
        this.lol = Integer.MAX_VALUE;
        this.lom = 0;
        this.lon = 0;
        this.loo = 10.0f;
        this.lop = 2.5f;
        this.loq = (int) j(1, 2.5f);
        this.lor = 4.0f;
        this.los = (int) j(1, 4.0f);
        this.lot = 1.8f;
        this.lou = (int) j(1, 1.8f);
        this.lov = 1.0f;
        this.low = (int) j(1, 1.0f);
        this.lox = 8.0f;
        this.loy = (int) j(1, 8.0f);
        this.loz = 22.0f;
        this.loA = (int) j(1, 22.0f);
        this.loB = 67.0f;
        this.loC = (int) j(1, 67.0f);
        this.loD = 40.0f;
        this.loE = (int) j(1, 40.0f);
        this.loF = 22.0f;
        this.loG = (int) j(1, 22.0f);
        this.loH = 55.0f;
        this.loI = (int) j(1, 55.0f);
        this.loJ = 35.0f;
        this.loK = (int) j(1, 35.0f);
        this.loL = 45.0f;
        this.loM = (int) j(1, 45.0f);
        this.loN = 8.0f;
        this.loO = (float) ((int) j(1, 8.0f));
        this.loP = 8.0f;
        this.loQ = (float) ((int) j(1, 8.0f));
        this.loR = 2;
        this.loS = (int) j(1, 2.0f);
        this.loT = 15;
        this.loU = (int) j(1, 15.0f);
        this.loV = 33.0f;
        this.loW = (int) j(1, 33.0f);
        this.loX = 8.0f;
        this.loY = (int) j(1, 8.0f);
        this.loZ = 35.0f;
        this.lpa = (int) j(1, 35.0f);
        this.lpb = 10.0f;
        this.lpc = (int) j(1, 10.0f);
        this.lpd = 58.0f;
        this.lpe = (int) j(1, 58.0f);
        this.lpf = (int) j(1, 1.0f);
        this.lpg = 102;
        this.lph = 102;
        this.lpi = 153;
        this.lpj = 102;
        this.lpk = 102;
        this.lpl = 102;
        this.lpm = ao.CTRL_INDEX;
        this.lpn = 0;
        this.lpo = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.lpp = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.lpq = 0;
        this.lpr = 0;
        this.lps = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.lpt = 7;
        this.lpu = new float[7];
        this.lpv = new float[7];
        this.lpw = new boolean[7];
        this.lpA = false;
        this.lpB = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aqD();
    }

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lnZ = -1;
        this.loa = -1;
        this.lob = getResources().getColor(R.e.aTH);
        this.loc = 12.0f;
        this.lod = 28.0f;
        this.loe = 33.0f;
        this.lof = 12.0f;
        this.log = 12.0f;
        this.loh = getResources().getColor(R.e.aTI);
        this.loi = -1;
        this.loj = getResources().getColor(R.e.aTI);
        this.lok = -1;
        this.lol = Integer.MAX_VALUE;
        this.lom = 0;
        this.lon = 0;
        this.loo = 10.0f;
        this.lop = 2.5f;
        this.loq = (int) j(1, 2.5f);
        this.lor = 4.0f;
        this.los = (int) j(1, 4.0f);
        this.lot = 1.8f;
        this.lou = (int) j(1, 1.8f);
        this.lov = 1.0f;
        this.low = (int) j(1, 1.0f);
        this.lox = 8.0f;
        this.loy = (int) j(1, 8.0f);
        this.loz = 22.0f;
        this.loA = (int) j(1, 22.0f);
        this.loB = 67.0f;
        this.loC = (int) j(1, 67.0f);
        this.loD = 40.0f;
        this.loE = (int) j(1, 40.0f);
        this.loF = 22.0f;
        this.loG = (int) j(1, 22.0f);
        this.loH = 55.0f;
        this.loI = (int) j(1, 55.0f);
        this.loJ = 35.0f;
        this.loK = (int) j(1, 35.0f);
        this.loL = 45.0f;
        this.loM = (int) j(1, 45.0f);
        this.loN = 8.0f;
        this.loO = (float) ((int) j(1, 8.0f));
        this.loP = 8.0f;
        this.loQ = (float) ((int) j(1, 8.0f));
        this.loR = 2;
        this.loS = (int) j(1, 2.0f);
        this.loT = 15;
        this.loU = (int) j(1, 15.0f);
        this.loV = 33.0f;
        this.loW = (int) j(1, 33.0f);
        this.loX = 8.0f;
        this.loY = (int) j(1, 8.0f);
        this.loZ = 35.0f;
        this.lpa = (int) j(1, 35.0f);
        this.lpb = 10.0f;
        this.lpc = (int) j(1, 10.0f);
        this.lpd = 58.0f;
        this.lpe = (int) j(1, 58.0f);
        this.lpf = (int) j(1, 1.0f);
        this.lpg = 102;
        this.lph = 102;
        this.lpi = 153;
        this.lpj = 102;
        this.lpk = 102;
        this.lpl = 102;
        this.lpm = ao.CTRL_INDEX;
        this.lpn = 0;
        this.lpo = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.lpp = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.lpq = 0;
        this.lpr = 0;
        this.lps = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.lpt = 7;
        this.lpu = new float[7];
        this.lpv = new float[7];
        this.lpw = new boolean[7];
        this.lpA = false;
        this.lpB = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        aqD();
    }

    private void b(Canvas canvas, boolean z) {
        int i = 0;
        if (z) {
            this.lpy.reset();
            this.lpy.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                this.lpy.lineTo((float) ((Point) this.points.get(i2)).x, (float) ((Point) this.points.get(i2)).y);
            }
            this.lpy.lineTo(this.lpu[this.lpu.length - 1], (float) ((this.lon - this.loK) - 1));
            this.lpy.lineTo((float) this.loy, (float) ((this.lon - this.loK) - 1));
            this.lpy.lineTo((float) this.loy, this.lpv[0]);
            canvas.drawPath(this.lpy, this.jXK);
            return;
        }
        this.lpy.reset();
        this.lpy.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
        while (i < this.points.size()) {
            if (i <= 0) {
                aqF();
            } else if (((Point) this.points.get(i - 1)).y == this.lon - this.loE) {
                this.jXK.reset();
                this.jXK.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.jXK.setAntiAlias(true);
                this.jXK.setStrokeWidth((float) this.lou);
                this.jXK.setStyle(Style.STROKE);
                this.jXK.setColor(-1);
            } else {
                aqF();
            }
            this.lpy.lineTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            canvas.drawPath(this.lpy, this.jXK);
            this.lpy.reset();
            this.lpy.moveTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            i++;
        }
    }

    private void e(Canvas canvas) {
        this.jXK.reset();
        this.jXK.setAntiAlias(true);
        this.jXK.setColor(-1);
        this.jXK.setStrokeWidth(0.0f);
        this.jXK.setStyle(Style.FILL);
        for (int i = 0; i < this.points.size(); i++) {
            Point point = (Point) this.points.get(i);
            if (i == this.points.size() - 1) {
                canvas.drawCircle((float) point.x, (float) point.y, (float) this.los, this.jXK);
            } else {
                canvas.drawCircle((float) point.x, (float) point.y, (float) this.loq, this.jXK);
            }
        }
    }

    public final void aqC() {
        this.lpA = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getResources().getString(R.l.egw));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d");
        this.lpz.clear();
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(5, -6);
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                this.lpz.add(simpleDateFormat.format(instance.getTime()));
            } else {
                this.lpz.add(simpleDateFormat2.format(instance.getTime()));
            }
            instance.add(5, 1);
        }
        invalidate();
    }

    private float j(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        return TypedValue.applyDimension(i, f, system.getDisplayMetrics());
    }

    private void b(Canvas canvas, List<String> list) {
        if (list != null && list.size() == 7) {
            this.jXK.reset();
            this.jXK.setAntiAlias(true);
            this.jXK.setStrokeWidth(0.0f);
            this.jXK.setTextSize(j(2, 12.0f));
            this.jXK.setAlpha(153);
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    this.jXK.setTextAlign(Align.LEFT);
                } else {
                    this.jXK.setTextAlign(Align.CENTER);
                }
                if (this.lpw[i]) {
                    this.jXK.setColor(-1);
                } else {
                    this.jXK.setColor(this.loh);
                }
                canvas.drawText((String) list.get(i), (float) ((Point) this.points.get(i)).x, (float) (this.lon - this.loU), this.jXK);
            }
        }
    }

    private void aqD() {
        this.jXK = new Paint();
        this.lpx = new Path();
        this.lpy = new Path();
        this.points = new LinkedList();
        this.lpz = new LinkedList();
        aqE();
    }

    private void aqE() {
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                this.lpw[i] = true;
            } else {
                this.lpw[i] = false;
            }
        }
    }

    private void aqF() {
        this.jXK.reset();
        this.jXK.setAntiAlias(true);
        this.jXK.setStrokeWidth((float) this.lou);
        this.jXK.setStyle(Style.STROKE);
        this.jXK.setColor(-1);
    }

    protected void onDraw(Canvas canvas) {
        int i;
        this.points.clear();
        View findViewById = findViewById(R.h.bNd);
        this.lom = findViewById.getWidth();
        this.lon = findViewById.getHeight();
        this.lpq = ((this.lom - this.loy) - this.loA) / 6;
        this.lpr = ((this.lon - this.loC) - this.loE) / 2;
        for (i = 0; i < this.lpu.length; i++) {
            this.lpu[i] = (float) (this.loy + (this.lpq * i));
        }
        i = this.lps.length;
        if (i > 7) {
            i = 7;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.lps[i3] > 100000) {
                this.lps[i3] = 100000;
            }
            if (this.lps[i3] < 0) {
                this.lps[i3] = 0;
            }
            if (this.lps[i3] > i2) {
                i2 = this.lps[i3];
            }
        }
        if (i2 <= 15000 && i2 >= 0) {
            i2 = 15000;
        } else if (i2 <= 15000 || i2 > 100000) {
            i2 = 0;
        } else if (((double) i2) / 5000.0d > ((double) (((float) i2) / 5000.0f))) {
            i2 = ((i2 / Downloads.MIN_RETYR_AFTER) + 1) * Downloads.MIN_RETYR_AFTER;
        }
        this.lpn = (((this.lon - this.loC) - this.loE) * 10000) / i2;
        this.lpn = (this.lon - this.loE) - this.lpn;
        for (int i4 = 0; i4 < i; i4++) {
            this.lpv[i4] = ((float) (this.lon - this.loE)) - ((((float) this.lps[i4]) / ((float) i2)) * ((float) ((this.lon - this.loC) - this.loE)));
            this.points.add(new Point((int) this.lpu[i4], (int) this.lpv[i4]));
        }
        super.onDraw(canvas);
        if (!this.lpA) {
            e(canvas);
            if (this.lol != Integer.MAX_VALUE) {
                i2 = this.lol;
                this.jXK.reset();
                this.jXK.setColor(this.loh);
                this.jXK.setAntiAlias(true);
                this.jXK.setStrokeWidth(0.0f);
                this.jXK.setTextSize(j(2, 12.0f));
                this.jXK.setTextAlign(Align.CENTER);
                if (i2 >= 0 && i2 <= 6) {
                    if (i2 == 0) {
                        this.jXK.setTextAlign(Align.LEFT);
                    }
                    if (i2 == 6) {
                        this.jXK.setTextAlign(Align.RIGHT);
                    }
                    if (!this.lpE) {
                        this.lpC = ((Point) this.points.get(i2)).y - this.lpe;
                        this.lpD = this.lpC;
                        this.lpE = true;
                    }
                    if (this.lpE) {
                        float f = (float) (((double) this.lpD) / 8.0d);
                        if (this.lpC > 0) {
                            this.jXK.setAlpha(((this.lpD - this.lpC) * 255) / this.lpD);
                        }
                        canvas.drawText(this.lps[i2], (float) ((Point) this.points.get(i2)).x, (float) (this.lpC + this.lpe), this.jXK);
                        if (this.lpC > 0) {
                            if (((float) this.lpC) / ((float) this.lpD) <= 1.0f / f) {
                                this.lpC--;
                            } else {
                                this.lpC = (int) (((float) this.lpC) - ((((float) this.lpC) / ((float) this.lpD)) * f));
                            }
                            invalidate();
                        } else {
                            this.lpE = false;
                        }
                    }
                }
                i = this.lol;
                if (i >= 0 && i <= 6) {
                    this.lpw[i] = true;
                }
            }
        }
        this.jXK.reset();
        this.lpx.reset();
        this.jXK.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.jXK.setColor(this.lob);
        this.jXK.setStrokeWidth((float) this.low);
        this.jXK.setAlpha(102);
        this.jXK.setStyle(Style.STROKE);
        if (!(this.lpn == 0 || this.lpA)) {
            this.lpx.moveTo((float) this.loy, (float) this.lpn);
            this.lpx.lineTo((float) (this.lom - this.loG), (float) this.lpn);
            canvas.drawPath(this.lpx, this.jXK);
        }
        this.jXK.reset();
        this.lpx.reset();
        this.jXK.setColor(this.lob);
        this.jXK.setStrokeWidth((float) this.low);
        this.jXK.setStyle(Style.STROKE);
        this.jXK.setAlpha(102);
        this.lpx.reset();
        this.lpx.moveTo(this.loO, (float) (this.lon - this.loK));
        this.lpx.lineTo(((float) this.lom) - this.loQ, (float) (this.lon - this.loK));
        this.lpx.moveTo(this.loO, (float) this.loM);
        this.lpx.lineTo(((float) this.lom) - this.loQ, (float) this.loM);
        canvas.drawPath(this.lpx, this.jXK);
        if (!this.lpA) {
            this.jXK.reset();
            this.jXK.setColor(this.loj);
            this.jXK.setAntiAlias(true);
            this.jXK.setAlpha(102);
            this.jXK.setStrokeWidth(0.0f);
            this.jXK.setTextSize(j(2, 12.0f));
            this.jXK.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(R.l.egv), (float) (this.lom - this.loS), (float) (((double) this.lpn) + (((double) this.jXK.getTextSize()) * 0.34d)), this.jXK);
        }
        this.jXK.reset();
        this.jXK.setColor(-1);
        this.jXK.setAntiAlias(true);
        this.jXK.setStrokeWidth(0.0f);
        this.jXK.setTypeface(this.lpo);
        this.jXK.setTextSize(j(2, 28.0f));
        canvas.drawText(getResources().getString(R.l.egx), (float) this.loY, (float) this.loW, this.jXK);
        this.jXK.setTextAlign(Align.RIGHT);
        this.jXK.setTextSize(j(2, 33.0f));
        canvas.drawText(this.lps[this.lps.length - 1], (float) (this.lom - this.lpc), (float) this.lpa, this.jXK);
        if (this.points.size() > 2) {
            this.jXK.reset();
            this.jXK.setAntiAlias(true);
            this.jXK.setStrokeWidth(0.0f);
            this.jXK.setAlpha(102);
            this.jXK.setStyle(Style.FILL_AND_STROKE);
            this.jXK.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.lon - this.loK), -1, 16777215, TileMode.REPEAT));
            this.jXK.setColor(-1);
            b(canvas, true);
            aqF();
            if (!this.lpA) {
                b(canvas, false);
            }
        }
        b(canvas, this.lpz);
    }

    private int T(float f) {
        this.lol = Integer.MAX_VALUE;
        if (this.points.size() > 0) {
            int i = 0;
            while (i < this.points.size()) {
                if (i != 0) {
                    if (i > 0 && i < this.points.size() - 1) {
                        if (f < ((float) (((Point) this.points.get(i)).x + (this.lpq / 2))) && f > ((float) (((Point) this.points.get(i)).x - (this.lpq / 2)))) {
                            this.lol = i;
                            invalidate();
                            break;
                        }
                    } else if (i == this.points.size() - 1) {
                        if (f < ((float) this.lom) && f > ((float) (((Point) this.points.get(i)).x - (this.lpq / 2)))) {
                            this.lol = i;
                            invalidate();
                            break;
                        }
                    } else {
                        this.lol = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f < ((float) (((Point) this.points.get(i)).x + (this.lpq / 2))) && f > 0.0f) {
                    this.lol = i;
                    invalidate();
                    break;
                }
                i++;
            }
        }
        return this.lol;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        motionEvent.getY();
        w.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.lol);
        switch (motionEvent.getAction()) {
            case 0:
                w.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
                return true;
            case 1:
                w.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
                this.lol = T(x);
                aqE();
                this.lpE = false;
                invalidate();
                return false;
            default:
                w.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
                return false;
        }
    }
}
