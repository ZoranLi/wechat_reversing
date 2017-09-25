package com.tencent.mm.plugin.photoedit.f;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.WebView;

public final class a implements Cloneable {
    public static Rect gG = new Rect();
    private static int olV = ((int) ab.getResources().getDimension(R.f.aYs));
    private static int olW = ((int) ab.getResources().getDimension(R.f.aYr));
    public static float olX = ab.getResources().getDimension(R.f.aZo);
    public static float olY = ab.getResources().getDimension(R.f.aZn);
    public static Path olZ = new Path();
    public static Path oma = new Path();
    public static Paint omb = new Paint();
    public static Paint omc = new Paint();
    public static Paint omd = new Paint();
    public static Paint ome = new Paint();
    public static Paint omf = new Paint();
    public Matrix mMatrix = new Matrix();
    public Rect oiW;
    public Rect old = new Rect();
    public Rect olg = new Rect();

    static {
        omd.setColor(WebView.NIGHT_MODE_COLOR);
        omb.setColor(-1);
        omb.setStrokeWidth((float) olV);
        omb.setStyle(Style.STROKE);
        omb.setAntiAlias(true);
        ome.set(omb);
        ome.setStrokeWidth((float) olW);
        omf.set(omb);
        omf.setStrokeWidth(olX);
        omc.set(omb);
        omc.setStrokeWidth((float) (olV * 7));
        omc.setColor(549174203);
    }

    public a(Rect rect) {
        this.oiW = rect;
    }

    public static void ra(int i) {
        omf.setAlpha(i);
        omb.setAlpha(i);
        ome.setAlpha((int) (0.7058824f * ((float) i)));
    }

    public static void rb(int i) {
        omd.setAlpha((int) (0.9019608f * ((float) i)));
    }

    public final Object clone() {
        return super.clone();
    }
}
