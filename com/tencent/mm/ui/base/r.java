package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class r extends SurfaceTexture {
    public SurfaceTexture lBp = null;

    public r() {
        super(0);
    }

    public final void setOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
        this.lBp.setOnFrameAvailableListener(onFrameAvailableListener);
    }

    public final void setDefaultBufferSize(int i, int i2) {
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
        this.lBp.setDefaultBufferSize(i, i2);
    }

    public final void updateTexImage() {
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
        this.lBp.updateTexImage();
    }

    public final void detachFromGLContext() {
        boolean z;
        String str;
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
        try {
            this.lBp.detachFromGLContext();
            z = false;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e, "%s", "detect texture problem, RuntimeException detachFromGLContext");
            z = true;
        }
        if (z) {
            String str2;
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = AD() + " detect texture problem error code = " + ((Integer) declaredMethod.invoke(this.lBp, new Object[0])).intValue() + ", detach = true, and error = " + z;
                b.r(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                w.w("MicroMsg.MMSurfaceTextureWrap", str2);
                w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(r0), Boolean.valueOf(true), Boolean.valueOf(z));
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2, "%s", "detect texture problem, IllegalArgumentException");
                str = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                w.w("MicroMsg.MMSurfaceTextureWrap", str);
                w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e22, "%s", "detect texture problem, IllegalAccessException");
                str = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                w.w("MicroMsg.MMSurfaceTextureWrap", str);
                w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e222) {
                w.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e222, "%s", "detect texture problem, InvocationTargetException");
                str = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                w.w("MicroMsg.MMSurfaceTextureWrap", str);
                w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e2222) {
                w.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2222, "%s", "detect texture problem, NoSuchMethodException");
                str = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                w.w("MicroMsg.MMSurfaceTextureWrap", str);
                w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable e22222) {
                w.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e22222, "%s", "detect texture problem, Exception");
                str = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                w.w("MicroMsg.MMSurfaceTextureWrap", str);
                w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            } catch (Throwable th) {
                str2 = AD() + " detect texture problem error code = 0" + ", detach = false, and error = " + z;
                b.r(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                w.w("MicroMsg.MMSurfaceTextureWrap", str2);
                w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(z));
            }
        }
    }

    private static String AD() {
        String format;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ab.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + e.REV);
        stringBuilderPrinter.println("#accinfo.build=" + e.TIME + ":" + e.HOSTNAME + ":" + f.fuV);
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.urS);
        String str = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.e.hgs);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getMemoryClass()), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.compatible.util.e.hgs, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            w.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", e.getMessage());
            format = str;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }

    public final void attachToGLContext(int i) {
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
        this.lBp.attachToGLContext(i);
    }

    public final void getTransformMatrix(float[] fArr) {
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
        this.lBp.getTransformMatrix(fArr);
    }

    public final long getTimestamp() {
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
        return this.lBp.getTimestamp();
    }

    public final void release() {
        super.release();
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
        this.lBp.release();
    }

    public final boolean equals(Object obj) {
        return this.lBp.equals(obj);
    }

    public final int hashCode() {
        return this.lBp.hashCode();
    }

    public final String toString() {
        return this.lBp.toString();
    }

    @TargetApi(19)
    public final void releaseTexImage() {
        w.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
        this.lBp.releaseTexImage();
    }
}
