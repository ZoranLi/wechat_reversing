package com.tencent.mm.plugin.voip.video;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender implements Renderer {
    static String TAG = "OpenGlRender";
    public static int rpA = 1;
    public static int rpB = 2;
    public static int rpC = 0;
    public static int rpD = 1;
    public static int rpE = 0;
    public static int rpF = 1;
    public static int rpG = 2;
    public static int rpH = 3;
    public static int rpI = 4;
    public static int rpJ = 12;
    public static int rpK = 16;
    public static int rpL = 0;
    public static int rpM = 1;
    public static int rpX = 0;
    static boolean rpZ = false;
    public static int rpz = 0;
    int rpN = rpL;
    public boolean rpO = false;
    public Bitmap rpP = null;
    private int rpQ = 0;
    private int rpR = 0;
    private byte[] rpS = null;
    private int[] rpT = null;
    private int rpU;
    private int rpV;
    private int rpW;
    WeakReference<Object> rpY;
    boolean rpi = false;
    int rpj = 0;
    long rpk = 0;
    long rpl = 0;
    int rpm = 0;
    a rpn;
    public float rpo = 1.2f;
    public float rpp = 1.93f;
    public float rpq = 1.05f;
    boolean rpr = false;
    public boolean rps = false;
    boolean rpt = false;
    boolean rpu = false;
    boolean rpv = false;
    int rpw = 0;
    int rpx = 0;
    WeakReference<OpenGlView> rpy;

    private class a extends ae {
        final /* synthetic */ OpenGlRender rqa;

        public a(OpenGlRender openGlRender, Looper looper) {
            this.rqa = openGlRender;
            super(looper);
        }

        public final void handleMessage(Message message) {
            this.rqa.requestRender();
        }
    }

    private native void render32(int[] iArr, int i, int i2, int i3, int i4);

    private native void render8(byte[] bArr, int i, int i2, int i3, int i4);

    final native void Init(int i, Object obj, int i2);

    final native void Uninit(int i);

    final native void setMode(int i, int i2, int i3, int i4);

    final native void setParam(float f, float f2, float f3, int i);

    public static int brx() {
        if (rpX == 0) {
            rpX = ((ActivityManager) ab.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT ? 2 : 1;
            if (Build.MODEL.equals("Nexus 6")) {
                rpX = 2;
            }
        }
        return rpX;
    }

    public OpenGlRender(OpenGlView openGlView, int i) {
        if (!rpZ) {
            k.b("mm_gl_disp", OpenGlRender.class.getClassLoader());
            rpZ = true;
        }
        this.rpN = i;
        this.rpy = new WeakReference(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.rpn = new a(this, myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.rpn = new a(this, myLooper);
            } else {
                this.rpn = null;
            }
        }
        this.rpY = null;
    }

    public final void onDrawFrame(GL10 gl10) {
        if (this.rps && this.rpr && this.rpy.get() != null) {
            if (this.rpS != null) {
                render8(this.rpS, this.rpU, this.rpV, this.rpW, this.rpN);
                this.rpS = null;
            }
            if (this.rpT != null) {
                render32(this.rpT, this.rpU, this.rpV, this.rpW, this.rpN);
                this.rpT = null;
                return;
            }
            return;
        }
        this.rpS = null;
        this.rpT = null;
    }

    public final void b(byte[] bArr, int i, int i2, int i3) {
        if (this.rpr && this.rpS == null) {
            this.rpU = i;
            this.rpV = i2;
            this.rpW = i3;
            this.rpS = bArr;
            requestRender();
        }
    }

    public final void a(int[] iArr, int i, int i2, int i3) {
        if (this.rpr && this.rpT == null) {
            this.rpU = i;
            this.rpV = i2;
            this.rpW = i3;
            this.rpT = iArr;
            requestRender();
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        w.i(TAG, "onSurfaceChanged, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.rpw != i || this.rpx != i2) {
            gl10.glViewport(0, 0, i, i2);
            this.rpw = i;
            this.rpx = i2;
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public final void bry() {
        this.rps = false;
        this.rpv = false;
    }

    public final void brz() {
        w.i(TAG, "steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[]{Integer.valueOf(this.rpN), Boolean.valueOf(this.rpr), Boolean.valueOf(this.rps)});
        if (this.rpr && this.rps) {
            w.i(TAG, "steve: Reset GLRender first! mode=%d", new Object[]{Integer.valueOf(this.rpN)});
            this.rpr = false;
            this.rps = false;
            Uninit(this.rpN);
        }
    }

    public final void requestRender() {
        if (this.rpr) {
            if (!this.rpv) {
                setMode(((OpenGlView) this.rpy.get()).getWidth(), ((OpenGlView) this.rpy.get()).getHeight(), 0, this.rpN);
                this.rpv = true;
            }
            if (this.rpy.get() != null) {
                OpenGlView openGlView = (OpenGlView) this.rpy.get();
                openGlView.rqb = true;
                openGlView.requestRender();
            }
        }
    }
}
