package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import com.tencent.mm.plugin.appbrand.m.m;
import java.io.Serializable;

public final class a extends Paint implements Serializable {
    public int iDj = a.iDl;
    private float iDk = (((float) getAlpha()) / 255.0f);
    private int sl = getColor();

    public enum a {
        ;

        static {
            iDl = 1;
            iDm = 2;
            iDn = 3;
            iDo = 4;
            iDp = new int[]{iDl, iDm, iDn, iDo};
        }
    }

    protected final Object clone() {
        return super.clone();
    }

    public final a Ru() {
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Object a = m.a(Shader.class, "copy", shader, new Class[0], new Object[0], null);
            if (a != null && (a instanceof Shader)) {
                shader = (Shader) a;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.iDj = this.iDj;
        return aVar;
    }

    public final void J(float f) {
        this.iDk = f;
        setColor(this.sl);
    }

    public final void setColor(int i) {
        this.sl = i;
        super.setColor(((((int) (((float) Color.alpha(i)) * this.iDk)) & 255) << 24) | (16777215 & i));
    }

    public final void reset() {
        this.iDj = a.iDl;
        super.reset();
    }
}
