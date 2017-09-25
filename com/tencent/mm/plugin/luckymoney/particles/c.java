package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c {
    ValueAnimator jsj;
    private float noA;
    private float noB;
    private float noC;
    private float noD;
    private float noE;
    private float noF;
    private float noG;
    private Float noH;
    private Float noI;
    private Float noJ;
    private Float noK;
    private int noL;
    private int noM;
    private float noN;
    private float noO;
    private float noP;
    private float noQ;
    private Float noR;
    private Float noS;
    private long noT;
    public float noU;
    public float noV;
    private final b nom;
    private final d non;
    final ViewGroup noo;
    public final ConfettiView nop;
    final Queue<b> noq;
    public final List<b> nor;
    long nos;
    int not;
    public long nou;
    float nov;
    float now;
    public Interpolator nox;
    private Rect noy;
    private float noz;
    final Random random;

    public c(Context context, b bVar, d dVar, ViewGroup viewGroup) {
        this(bVar, dVar, viewGroup, ConfettiView.cx(context));
    }

    private c(b bVar, d dVar, ViewGroup viewGroup, ConfettiView confettiView) {
        this.random = new Random();
        this.noq = new LinkedList();
        this.nor = new ArrayList(e.CTRL_INDEX);
        this.nom = bVar;
        this.non = dVar;
        this.noo = viewGroup;
        this.nop = confettiView;
        this.nop.nor = this.nor;
        this.nop.addOnAttachStateChangeListener(new OnAttachStateChangeListener(this) {
            final /* synthetic */ c noW;

            {
                this.noW = r1;
            }

            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                this.noW.aIe();
            }
        });
        this.noT = -1;
        this.noy = new Rect(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
    }

    public final c t(float f, float f2) {
        this.noz = f / 1000.0f;
        this.noA = f2 / 1000.0f;
        return this;
    }

    public final c u(float f, float f2) {
        this.noB = f / 1000.0f;
        this.noC = f2 / 1000.0f;
        return this;
    }

    public final c W(float f) {
        this.noD = f / 1000000.0f;
        this.noE = 0.0f;
        return this;
    }

    public final c X(float f) {
        this.noF = f / 1000000.0f;
        this.noG = 0.0f;
        return this;
    }

    public final c aIb() {
        this.noL = 180;
        this.noM = 180;
        return this;
    }

    public final c aIc() {
        this.noP = 3.6E-4f;
        this.noQ = 1.8E-4f;
        return this;
    }

    public final c aId() {
        this.noR = Float.valueOf(0.36f);
        this.noS = Float.valueOf(0.0f);
        return this;
    }

    public final void aIe() {
        if (this.jsj != null) {
            this.jsj.cancel();
        }
        this.nop.aIe();
    }

    final void x(int i, long j) {
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = (b) this.noq.poll();
            if (bVar == null) {
                bVar = this.nom.b(this.random);
            }
            d dVar = this.non;
            Random random = this.random;
            bVar.npk = 0;
            bVar.npm = 0.0f;
            bVar.npl = 0.0f;
            bVar.npo = 0.0f;
            bVar.npn = 0.0f;
            bVar.noF = 0.0f;
            bVar.noD = 0.0f;
            bVar.noJ = null;
            bVar.noH = null;
            bVar.npq = null;
            bVar.npp = null;
            bVar.npr = 0.0f;
            bVar.nps = 0.0f;
            bVar.noP = 0.0f;
            bVar.noR = null;
            bVar.npt = null;
            bVar.noT = 0;
            bVar.npu = 0.0f;
            bVar.npv = 0.0f;
            bVar.nox = null;
            bVar.npx = 0.0f;
            bVar.npw = 0.0f;
            bVar.npy = 0.0f;
            bVar.alpha = 255;
            bVar.npz = false;
            bVar.npb = false;
            bVar.npk = j;
            bVar.npl = (random.nextFloat() * ((float) (dVar.noZ - dVar.noX))) + ((float) dVar.noX);
            bVar.npm = (((float) (dVar.npa - dVar.noY)) * random.nextFloat()) + ((float) dVar.noY);
            bVar.npn = a(this.noz, this.noA, random);
            bVar.npo = a(this.noB, this.noC, random);
            bVar.noD = a(this.noD, this.noE, random);
            bVar.noF = a(this.noF, this.noG, random);
            bVar.noH = this.noH == null ? null : Float.valueOf(a(this.noH.floatValue(), this.noI.floatValue(), random));
            bVar.noJ = this.noJ == null ? null : Float.valueOf(a(this.noJ.floatValue(), this.noK.floatValue(), random));
            bVar.npr = a((float) this.noL, (float) this.noM, random);
            bVar.nps = a(this.noN, this.noO, random);
            bVar.noP = a(this.noP, this.noQ, random);
            bVar.noR = this.noR == null ? null : Float.valueOf(a(this.noR.floatValue(), this.noS.floatValue(), random));
            bVar.noT = this.noT;
            bVar.nox = this.nox;
            bVar.npu = a(this.noU, this.noV, random);
            bVar.g(this.noy);
            this.nor.add(bVar);
        }
    }

    private static float a(float f, float f2, Random random) {
        return (((random.nextFloat() * 2.0f) - 1.0f) * f2) + f;
    }
}
