package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public final class b extends View {
    protected static int kxA;
    protected static int kxB;
    protected static int kxC;
    protected static int kxv = 32;
    protected static int kxw;
    protected static int kxx = 1;
    protected static int kxy;
    protected static int kxz = 10;
    protected int aar;
    protected int jTi;
    protected int jTj;
    public Collection<com.tencent.mm.plugin.chatroom.d.a> kug = new ArrayList();
    protected int kxD = 80;
    protected Paint kxE;
    protected Paint kxF;
    protected Paint kxG;
    protected Paint kxH;
    protected Paint kxI;
    protected int kxJ;
    protected int kxK;
    protected int kxL;
    protected int kxM;
    protected int kxN;
    protected int kxO;
    protected int kxP;
    protected int kxQ;
    protected int kxR;
    private final StringBuilder kxS;
    protected boolean kxT = false;
    protected boolean kxU = false;
    protected int kxV = -1;
    protected int kxW = -1;
    protected int kxX = -1;
    protected int kxY = -1;
    protected int kxZ = -1;
    protected int kya = -1;
    protected int kyb = -1;
    protected int kyc = 1;
    protected int kyd = 7;
    protected int kye = this.kyd;
    private int kyf = 0;
    protected Boolean kyg;
    protected int kyh = kxv;
    protected int kyi = 0;
    final Time kyj;
    private final Calendar kyk;
    private final Calendar kyl;
    private final Boolean kym;
    public int kyn = 6;
    private DateFormatSymbols kyo = new DateFormatSymbols();
    public a kyp;
    private Context mContext;

    public interface a {
        void b(com.tencent.mm.plugin.chatroom.d.a aVar);
    }

    public b(Context context, TypedArray typedArray) {
        super(context);
        this.mContext = context;
        Resources resources = context.getResources();
        this.kyl = Calendar.getInstance();
        this.kyk = Calendar.getInstance();
        this.kyj = new Time(Time.getCurrentTimezone());
        this.kyj.setToNow();
        this.kxJ = typedArray.getColor(R.n.fpu, resources.getColor(R.e.aVm));
        this.kxK = typedArray.getColor(R.n.fpx, resources.getColor(R.e.aVm));
        this.kxL = typedArray.getColor(R.n.fpv, resources.getColor(R.e.aVm));
        this.kxM = typedArray.getColor(R.n.fpv, resources.getColor(R.e.aVn));
        this.kxN = typedArray.getColor(R.n.fpy, resources.getColor(R.e.aVm));
        this.kxP = typedArray.getColor(R.n.fpz, resources.getColor(R.e.aVm));
        this.kxQ = typedArray.getColor(R.n.fpw, resources.getColor(R.e.aUY));
        this.kxR = typedArray.getColor(R.n.fpA, resources.getColor(R.e.aVI));
        this.kxO = typedArray.getColor(R.n.fpB, resources.getColor(R.e.aVJ));
        this.kyg = Boolean.valueOf(typedArray.getBoolean(R.n.fpD, false));
        this.kxS = new StringBuilder(50);
        kxy = typedArray.getDimensionPixelSize(R.n.fpK, resources.getDimensionPixelSize(R.f.bbg));
        kxC = typedArray.getDimensionPixelSize(R.n.fpM, resources.getDimensionPixelSize(R.f.bbi));
        kxA = typedArray.getDimensionPixelSize(R.n.fpL, resources.getDimensionPixelSize(R.f.bbh));
        kxB = typedArray.getDimensionPixelOffset(R.n.fpG, resources.getDimensionPixelOffset(R.f.bae));
        kxw = typedArray.getDimensionPixelSize(R.n.fpJ, resources.getDimensionPixelOffset(R.f.baU));
        this.kyh = (typedArray.getDimensionPixelSize(R.n.fps, resources.getDimensionPixelOffset(R.f.aYu)) - kxB) / 6;
        this.kyi = typedArray.getDimensionPixelSize(R.n.fpt, resources.getDimensionPixelOffset(R.f.aYX));
        this.kym = Boolean.valueOf(typedArray.getBoolean(R.n.fpE, true));
        this.kxH = new Paint();
        this.kxH.setAntiAlias(true);
        this.kxH.setTextSize((float) kxC);
        this.kxH.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.kxH.setColor(this.kxM);
        this.kxH.setTextAlign(Align.LEFT);
        this.kxH.setStyle(Style.FILL);
        this.kxG = new Paint();
        this.kxG.setFakeBoldText(true);
        this.kxG.setAntiAlias(true);
        this.kxG.setColor(this.kxO);
        this.kxG.setTextAlign(Align.CENTER);
        this.kxG.setStyle(Style.FILL);
        this.kxI = new Paint();
        this.kxI.setFakeBoldText(true);
        this.kxI.setAntiAlias(true);
        this.kxI.setColor(this.kxR);
        this.kxI.setTextAlign(Align.CENTER);
        this.kxI.setStyle(Style.FILL);
        this.kxE = new Paint();
        this.kxE.setAntiAlias(true);
        this.kxE.setTextSize((float) kxA);
        this.kxE.setColor(this.kxM);
        this.kxE.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.kxE.setStyle(Style.FILL);
        this.kxE.setTextAlign(Align.CENTER);
        this.kxE.setFakeBoldText(true);
        this.kxF = new Paint();
        this.kxF.setAntiAlias(true);
        this.kxF.setTextSize((float) kxy);
        this.kxF.setStyle(Style.FILL);
        this.kxF.setTextAlign(Align.CENTER);
        this.kxF.setFakeBoldText(false);
    }

    private void c(Canvas canvas) {
        int i = kxB - (kxA / 2);
        int i2 = (this.aar - (this.kxD * 2)) / (this.kyd * 2);
        for (int i3 = 0; i3 < this.kyd; i3++) {
            int i4 = (((i3 * 2) + 1) * i2) + this.kxD;
            this.kyl.set(7, (this.kyc + i3) % this.kyd);
            canvas.drawText(this.kyo.getShortWeekdays()[this.kyl.get(7)].toUpperCase(Locale.getDefault()), (float) i4, (float) i, this.kxE);
        }
    }

    private int ajD() {
        return (this.kyf < this.kyc ? this.kyf + this.kyd : this.kyf) - this.kyc;
    }

    private boolean a(int i, Time time) {
        return this.jTi < time.year || ((this.jTi == time.year && this.jTj < time.month) || (this.jTj == time.month && i < time.monthDay));
    }

    private void d(Canvas canvas) {
        int i = (this.aar - (this.kxD * 2)) / (this.kyd * 2);
        int i2 = (((this.kyh + kxy) / 2) - kxx) + kxB;
        int ajD = ajD();
        int i3 = 1;
        while (i3 <= this.kye) {
            if (i3 <= this.kyb || -1 == this.kyb) {
                int i4 = this.kxD + (((ajD * 2) + 1) * i);
                if ((this.jTj == this.kxX && this.kxV == i3 && this.kxZ == this.jTi) || ((this.jTj == this.kxY && this.kxW == i3 && this.kya == this.jTi) || (this.kxT && this.kyb == i3 && this.kxV == -1))) {
                    if (this.kyg.booleanValue()) {
                        canvas.drawRoundRect(new RectF((float) (i4 - kxw), (float) ((i2 - (kxy / 3)) - kxw), (float) (kxw + i4), (float) ((i2 - (kxy / 3)) + kxw)), 10.0f, 10.0f, this.kxI);
                    } else {
                        canvas.drawCircle((float) i4, (float) (i2 - (kxy / 3)), (float) kxw, this.kxI);
                    }
                    if (this.kxT && this.kyb == i3 && this.kxV == -1) {
                        this.kxF.setColor(this.kxR);
                        this.kxF.setTypeface(Typeface.defaultFromStyle(0));
                        this.kxF.setTextSize(30.0f);
                        canvas.drawText(this.mContext.getResources().getString(R.l.eYi), (float) i4, (float) ((i2 + 12) + kxw), this.kxF);
                    }
                }
                this.kxF.setTextSize((float) kxy);
                if (!(this.kxT && this.kyb == i3)) {
                    this.kxF.setColor(this.kxN);
                    this.kxF.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.kxV != -1 && this.kxW != -1 && this.kxZ == this.kya && this.kxX == this.kxY && this.kxV == this.kxW && i3 == this.kxV && this.jTj == this.kxX && this.jTi == this.kxZ) {
                    this.kxF.setColor(this.kxR);
                }
                if (this.kxV != -1 && this.kxW != -1 && this.kxZ == this.kya && this.kxZ == this.jTi && ((this.jTj == this.kxX && this.kxY == this.kxX && ((this.kxV < this.kxW && i3 > this.kxV && i3 < this.kxW) || (this.kxV > this.kxW && i3 < this.kxV && i3 > this.kxW))) || ((this.kxX < this.kxY && this.jTj == this.kxX && i3 > this.kxV) || ((this.kxX < this.kxY && this.jTj == this.kxY && i3 < this.kxW) || ((this.kxX > this.kxY && this.jTj == this.kxX && i3 < this.kxV) || (this.kxX > this.kxY && this.jTj == this.kxY && i3 > this.kxW)))))) {
                    this.kxF.setColor(this.kxR);
                }
                if (!(this.kxV == -1 || this.kxW == -1 || this.kxZ == this.kya || (((this.kxZ != this.jTi || this.jTj != this.kxX) && (this.kya != this.jTi || this.jTj != this.kxY)) || ((this.kxX >= this.kxY || this.jTj != this.kxX || i3 >= this.kxV) && ((this.kxX >= this.kxY || this.jTj != this.kxY || i3 <= this.kxW) && ((this.kxX <= this.kxY || this.jTj != this.kxX || i3 <= this.kxV) && (this.kxX <= this.kxY || this.jTj != this.kxY || i3 >= this.kxW))))))) {
                    this.kxF.setColor(this.kxR);
                }
                if (this.kxV != -1 && this.kxW != -1 && this.kxZ == this.kya && this.jTi == this.kxZ && ((this.jTj > this.kxX && this.jTj < this.kxY && this.kxX < this.kxY) || (this.jTj < this.kxX && this.jTj > this.kxY && this.kxX > this.kxY))) {
                    this.kxF.setColor(this.kxR);
                }
                if (!(this.kxV == -1 || this.kxW == -1 || this.kxZ == this.kya || ((this.kxZ >= this.kya || ((this.jTj <= this.kxX || this.jTi != this.kxZ) && (this.jTj >= this.kxY || this.jTi != this.kya))) && (this.kxZ <= this.kya || ((this.jTj >= this.kxX || this.jTi != this.kxZ) && (this.jTj <= this.kxY || this.jTi != this.kya)))))) {
                    this.kxF.setColor(this.kxR);
                }
                if (!this.kym.booleanValue() && a(i3, this.kyj) && this.kyj.month == this.jTj && this.kyj.year == this.jTi) {
                    this.kxF.setColor(this.kxP);
                    this.kxF.setTypeface(Typeface.defaultFromStyle(2));
                }
                for (com.tencent.mm.plugin.chatroom.d.a aVar : this.kug) {
                    if (aVar.jXa == i3 && aVar.month == this.jTj && aVar.year == this.jTi) {
                        this.kxF.setColor(this.kxQ);
                        this.kxF.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                if ((this.jTj == this.kxX && this.kxV == i3 && this.kxZ == this.jTi) || ((this.jTj == this.kxY && this.kxW == i3 && this.kya == this.jTi) || (this.kxT && this.kyb == i3 && this.kxV == -1))) {
                    this.kxF.setTypeface(Typeface.defaultFromStyle(0));
                    this.kxF.setColor(-1);
                }
                canvas.drawText(String.format("%d", new Object[]{Integer.valueOf(i3)}), (float) i4, (float) i2, this.kxF);
                ajD++;
                if (ajD == this.kyd) {
                    ajD = 0;
                    i2 += this.kyh;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    protected final void onDraw(Canvas canvas) {
        int i = (((this.aar - (this.kxD * 2)) / (this.kyd * 2)) + this.kxD) - (kxC / 2);
        int i2 = ((kxB - kxC) / 2) + kxC;
        this.kxS.setLength(0);
        long timeInMillis = this.kyk.getTimeInMillis();
        StringBuilder stringBuilder = new StringBuilder(DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52).toLowerCase());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        canvas.drawText(stringBuilder.toString(), (float) i, (float) i2, this.kxH);
        canvas.drawLine(0.0f, (float) kxB, (float) this.aar, (float) (kxB + 1), this.kxH);
        c(canvas);
        d(canvas);
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), ((this.kyh * this.kyn) + kxB) + this.kyi);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.aar = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            com.tencent.mm.plugin.chatroom.d.a aVar;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = this.kxD;
            if (x < ((float) i) || x > ((float) (this.aar - this.kxD))) {
                aVar = null;
            } else {
                int ajD = ((((int) (((x - ((float) i)) * ((float) this.kyd)) / ((float) ((this.aar - i) - this.kxD)))) - ajD()) + 1) + ((((int) (y - ((float) kxB))) / this.kyh) * this.kyd);
                if (this.jTj > 11 || this.jTj < 0 || com.tencent.mm.plugin.chatroom.f.a.bK(this.jTj, this.jTi) < ajD || ajD <= 0) {
                    aVar = null;
                } else {
                    com.tencent.mm.plugin.chatroom.d.a aVar2 = new com.tencent.mm.plugin.chatroom.d.a(this.jTi, this.jTj, ajD);
                    for (com.tencent.mm.plugin.chatroom.d.a aVar3 : this.kug) {
                        if (aVar3.equals(aVar2)) {
                            break;
                        }
                    }
                    aVar3 = null;
                }
            }
            if (!(aVar3 == null || this.kyp == null || (!this.kym.booleanValue() && aVar3.month == this.kyj.month && aVar3.year == this.kyj.year && aVar3.jXa < this.kyj.monthDay))) {
                this.kyp.b(aVar3);
            }
        }
        return true;
    }

    public final void e(HashMap<String, Integer> hashMap) {
        int i = 0;
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            int i2;
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.kyh = ((Integer) hashMap.get("height")).intValue();
                if (this.kyh < kxz) {
                    this.kyh = kxz;
                }
            }
            if (hashMap.containsKey("selected_begin_day")) {
                this.kxV = ((Integer) hashMap.get("selected_begin_day")).intValue();
            }
            if (hashMap.containsKey("selected_last_day")) {
                this.kxW = ((Integer) hashMap.get("selected_last_day")).intValue();
            }
            if (hashMap.containsKey("selected_begin_month")) {
                this.kxX = ((Integer) hashMap.get("selected_begin_month")).intValue();
            }
            if (hashMap.containsKey("selected_last_month")) {
                this.kxY = ((Integer) hashMap.get("selected_last_month")).intValue();
            }
            if (hashMap.containsKey("selected_begin_year")) {
                this.kxZ = ((Integer) hashMap.get("selected_begin_year")).intValue();
            }
            if (hashMap.containsKey("selected_last_year")) {
                this.kya = ((Integer) hashMap.get("selected_last_year")).intValue();
            }
            this.jTj = ((Integer) hashMap.get("month")).intValue();
            this.jTi = ((Integer) hashMap.get("year")).intValue();
            this.kxT = false;
            this.kyb = -1;
            this.kyk.set(2, this.jTj);
            this.kyk.set(1, this.jTi);
            this.kyk.set(5, 1);
            this.kyf = this.kyk.get(7);
            if (hashMap.containsKey("week_start")) {
                this.kyc = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.kyc = this.kyk.getFirstDayOfWeek();
            }
            this.kye = com.tencent.mm.plugin.chatroom.f.a.bK(this.jTj, this.jTi);
            for (i2 = 0; i2 < this.kye; i2++) {
                boolean z;
                int i3 = i2 + 1;
                Time time = this.kyj;
                if (this.jTi == time.year && this.jTj == time.month && i3 == time.monthDay) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.kxT = true;
                    this.kyb = i3;
                }
                this.kxU = a(i3, this.kyj);
            }
            i2 = ajD();
            int i4 = (this.kye + i2) / this.kyd;
            if ((i2 + this.kye) % this.kyd > 0) {
                i = 1;
            }
            this.kyn = i4 + i;
            return;
        }
        throw new InvalidParameterException("You must specify month and year for this view");
    }
}
