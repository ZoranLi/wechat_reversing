package com.tencent.mm.svg.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.svg.WeChatSVG;
import com.tencent.mm.svg.b.b;
import com.tencent.mm.svg.c;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.util.EncodingUtils;

public final class a {
    private static String uMT = ".svg.code.drawable";
    protected static int uMU = 3;
    private static String uMV = "";
    private static Map<Integer, c> uMW = new ConcurrentHashMap();
    private static Map<Integer, Picture> uMX = new ConcurrentHashMap();
    private static Map<String, Picture> uMY = new ConcurrentHashMap();
    private static Float uMZ;
    private TypedValue uMR = new TypedValue();
    private byte[] uMS = new byte[0];

    public static void bl(String str) {
        uMV = str;
    }

    public static Drawable c(Resources resources, int i) {
        return a(resources, i, 0.0f);
    }

    private static Drawable a(Resources resources, int i, float f) {
        String str;
        if (i == 0) {
            String str2;
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "getSVGDrawable a invalid resource!!! %s", Integer.valueOf(i));
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Why no log??", new Object[0]);
            String str3 = "MicroMsg.SVGCompat";
            str = "The stack : %s";
            Object[] objArr = new Object[1];
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 4) {
                str2 = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 3;
                while (i2 < stackTrace.length) {
                    if (stackTrace[i2].getClassName().contains("com.tencent.mm") && !stackTrace[i2].getClassName().contains("sdk.platformtools.Log")) {
                        stringBuilder.append("[");
                        stringBuilder.append(stackTrace[i2].getClassName().substring(15));
                        stringBuilder.append(":");
                        stringBuilder.append(stackTrace[i2].getMethodName());
                        stringBuilder.append("(" + stackTrace[i2].getLineNumber() + ")]");
                    }
                    i2++;
                }
                str2 = stringBuilder.toString();
            }
            objArr[0] = str2;
            com.tencent.mm.svg.b.c.e(str3, str, objArr);
            return new c(new Picture(), i);
        } else if (b.bOa()) {
            return c(resources, i, f);
        } else {
            str = uMV + uMT;
            float f2 = resources.getDisplayMetrics().density;
            float f3 = f > 0.0f ? f : 1.0f;
            Picture picture;
            if (f > 0.0f) {
                String str4 = i + "_scale_" + f;
                picture = (Picture) uMY.get(str4);
                if (picture == null) {
                    picture = a(f2, a(resources, i, str), f3);
                    uMY.put(str4, picture);
                }
                return new c(picture, i);
            }
            picture = (Picture) uMX.get(Integer.valueOf(i));
            if (picture == null) {
                picture = a(f2, a(resources, i, str), f3);
                uMX.put(Integer.valueOf(i), picture);
            }
            return new c(picture, i);
        }
    }

    public static Bitmap b(Resources resources, int i, float f) {
        Drawable a = a(resources, i, f);
        Bitmap createBitmap = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Config.ARGB_8888);
        a.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public final boolean d(Resources resources, int i) {
        try {
            if (resources.getResourceTypeName(i).equals("raw")) {
                String charSequence;
                synchronized (this.uMS) {
                    TypedValue typedValue = this.uMR;
                    if (typedValue == null) {
                        typedValue = new TypedValue();
                        this.uMR = typedValue;
                    }
                    resources.getValue(i, typedValue, true);
                    charSequence = typedValue.string.toString();
                }
                if (charSequence.endsWith(".svg")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGCompat", e, "resource not found", new Object[0]);
            return false;
        }
    }

    public static Map<Integer, c> bNT() {
        return uMW;
    }

    protected static boolean b(View view, Paint paint) {
        if (VERSION.SDK_INT <= 10) {
            return false;
        }
        if (view == null) {
            return false;
        }
        if (view.getLayerType() != 1) {
            view.setLayerType(1, paint);
        }
        if (!view.willNotCacheDrawing()) {
            return true;
        }
        view.setWillNotCacheDrawing(false);
        if (view.getWindowToken() == null) {
            return true;
        }
        view.buildLayer();
        return true;
    }

    protected static View u(Drawable drawable) {
        while (true) {
            Callback callback = drawable.getCallback();
            if (callback != null) {
                if (!(callback instanceof View)) {
                    if (!(callback instanceof Drawable)) {
                        break;
                    }
                    drawable = (Drawable) callback;
                } else {
                    return (View) callback;
                }
            }
            break;
        }
        return null;
    }

    private static Drawable c(Resources resources, int i, float f) {
        com.tencent.mm.svg.b.c.d("MicroMsg.SVGCompat", "Using wechat svg library.", new Object[0]);
        InputStream openRawResource = resources.openRawResource(i);
        try {
            byte[] bArr = new byte[openRawResource.available()];
            openRawResource.read(bArr);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
                }
            }
            long parse = WeChatSVG.parse(EncodingUtils.getString(bArr, "UTF-8").toString());
            if (parse == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Parse SVG failed.", new Object[0]);
                return null;
            }
            float[] viewPort = WeChatSVG.getViewPort(parse);
            float f2 = resources.getDisplayMetrics().density;
            float f3 = (f > 0.0f ? f : 1.0f) * ((viewPort[0] / ((float) uMU)) * f2);
            float f4 = (viewPort[1] / ((float) uMU)) * f2;
            if (f <= 0.0f) {
                f = 1.0f;
            }
            float f5 = f4 * f;
            Picture picture = new Picture();
            int renderViewPort = WeChatSVG.renderViewPort(parse, picture.beginRecording((int) f3, (int) f5), (float) ((int) f3), (float) ((int) f5));
            picture.endRecording();
            WeChatSVG.release(parse);
            Drawable cVar = new c(picture, i);
            if (renderViewPort >= 0) {
                return cVar;
            }
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Render SVG failed. Reason : %s", Integer.valueOf(renderViewPort));
            return null;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGPictureDrawable failed. Reason : IOException", new Object[0]);
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.SVGCompat", e22, "", new Object[0]);
                }
            }
            return null;
        } catch (Throwable th) {
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.SVGCompat", e3, "", new Object[0]);
                }
            }
        }
    }

    private static c a(Resources resources, int i, String str) {
        Object obj = "";
        try {
            if (uMW.containsKey(Integer.valueOf(i))) {
                return (c) uMW.get(Integer.valueOf(i));
            }
            String resourceName = resources.getResourceName(i);
            if (resourceName == null) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : resource not found", new Object[0]);
                return null;
            }
            String str2;
            int indexOf = resourceName.indexOf("/");
            if (indexOf > 0) {
                str2 = str + "." + resourceName.substring(indexOf + 1);
            } else {
                str2 = str + "." + resourceName;
            }
            c cVar = (c) Class.forName(str2).newInstance();
            uMW.put(Integer.valueOf(i), cVar);
            return cVar;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SVGCompat", e, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : ClassNotFoundException %s", obj);
            return null;
        } catch (Throwable e2) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : InstantiationException %s", obj);
            w.printErrStackTrace("MicroMsg.SVGCompat", e2, "", new Object[0]);
            return null;
        } catch (Throwable e22) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "Get SVGCodeDrawable failed. Reason : IllegalAccessException %s", obj);
            w.printErrStackTrace("MicroMsg.SVGCompat", e22, "", new Object[0]);
            return null;
        }
    }

    private static Picture a(float f, c cVar, float f2) {
        Picture picture = new Picture();
        if (cVar == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGCompat", "fromCodeToPicture code is null!", new Object[0]);
        } else {
            if (uMZ == null) {
                uMZ = Float.valueOf(f / ((float) uMU));
            }
            float floatValue = uMZ.floatValue() * f2;
            Canvas beginRecording = picture.beginRecording((int) (((float) cVar.b(0, new Object[0])) * floatValue), (int) (((float) cVar.b(1, new Object[0])) * floatValue));
            beginRecording.save();
            beginRecording.scale(floatValue, floatValue);
            Looper myLooper = Looper.myLooper();
            cVar.b(2, beginRecording, myLooper);
            beginRecording.restore();
            picture.endRecording();
        }
        return picture;
    }
}
