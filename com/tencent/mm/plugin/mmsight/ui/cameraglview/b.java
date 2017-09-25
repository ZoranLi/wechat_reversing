package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b implements Renderer {
    static float[] nMm = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static float[] nMn = new float[]{-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    private static final float[] nMo = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int gPG = 0;
    boolean lPZ = false;
    private int nFQ = 0;
    private int nFR = 0;
    private boolean nFb = false;
    private int nMA;
    private int nMB;
    private FloatBuffer nMC;
    private FloatBuffer nMD;
    private float[] nME = new float[16];
    boolean nMF = false;
    private float[] nMG = nMm;
    private int nMp = 0;
    private int nMq = 0;
    private byte[] nMr = null;
    ByteBuffer nMs;
    ByteBuffer nMt;
    private int nMu;
    private int nMv;
    private int nMw;
    private int nMx;
    private int nMy;
    private int nMz;

    public b() {
        Point aKG = d.aKG();
        float f = (((float) aKG.x) / ((float) aKG.y)) / 2.0f;
        nMn = new float[]{-1.0f, -f, 1.0f, -f, -1.0f, f, 1.0f, f};
    }

    public final void a(byte[] bArr, int i, int i2, int i3, boolean z) {
        try {
            int i4;
            if (this.nFR == i2 && this.nFQ == i && this.gPG == i3 && this.nFb == z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (i4 != 0) {
                w.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(true), this});
            }
            this.nMr = bArr;
            this.nFQ = i;
            this.nFR = i2;
            this.gPG = i3;
            this.nFb = z;
            if (i4 != 0) {
                this.nMs = ByteBuffer.allocateDirect(i2 * i);
                this.nMt = ByteBuffer.allocateDirect((i * i2) / 2);
                this.nMs.order(ByteOrder.nativeOrder());
                this.nMt.order(ByteOrder.nativeOrder());
                if (z) {
                    this.nMG = nMn;
                } else {
                    this.nMG = nMm;
                }
                if (this.nMG != null) {
                    this.nMC.put(this.nMG);
                    this.nMC.position(0);
                }
            }
            if (this.nMs != null && this.nMt != null) {
                this.nMs.put(bArr, 0, i * i2);
                this.nMs.position(0);
                this.nMt.put(bArr, i * i2, (i * i2) / 2);
                this.nMt.position(0);
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int i;
        w.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[]{this});
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        String str = "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n";
        int[] iArr = new int[1];
        int bp = c.bp("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", 35633);
        if (bp == 0) {
            w.e("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
            i = 0;
        } else {
            int bp2 = c.bp(str, 35632);
            if (bp2 == 0) {
                w.e("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
                i = 0;
            } else {
                i = GLES20.glCreateProgram();
                GLES20.glAttachShader(i, bp);
                GLES20.glAttachShader(i, bp2);
                GLES20.glLinkProgram(i);
                GLES20.glGetProgramiv(i, 35714, iArr, 0);
                if (iArr[0] <= 0) {
                    w.e("MicroMsg.MMSightCameraGLUtil", "link program failed");
                    i = 0;
                } else {
                    GLES20.glDeleteShader(bp);
                    GLES20.glDeleteShader(bp2);
                }
            }
        }
        this.nMw = i;
        if (this.nMw == 0) {
            w.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
        }
        this.nMy = GLES20.glGetAttribLocation(this.nMw, "a_position");
        this.nMx = GLES20.glGetAttribLocation(this.nMw, "a_texCoord");
        this.nMz = GLES20.glGetUniformLocation(this.nMw, "y_texture");
        this.nMA = GLES20.glGetUniformLocation(this.nMw, "uv_texture");
        this.nMB = GLES20.glGetUniformLocation(this.nMw, "uMatrix");
        this.nMu = c.aMo();
        this.nMv = c.aMo();
        this.nMC = ByteBuffer.allocateDirect(this.nMG.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.nMC.put(this.nMG);
        this.nMC.position(0);
        this.nMD = ByteBuffer.allocateDirect(nMo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.nMD.put(nMo);
        this.nMD.position(0);
        w.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[]{Integer.valueOf(this.nMu), Integer.valueOf(this.nMv), this});
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        w.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this});
        if (i != this.nMp || i2 != this.nMq) {
            w.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.nMp = i;
            this.nMq = i2;
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        bg.NA();
        this.lPZ = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.nMF) {
            w.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
            this.nMF = false;
            this.lPZ = false;
            this.nMr = null;
            this.nFQ = -1;
            this.nFR = -1;
            return;
        }
        if (!(this.nMw == 0 || this.nMu == -1 || this.nMv == -1 || this.nFQ <= 0 || this.nFR <= 0 || this.nMr == null)) {
            GLES20.glUseProgram(this.nMw);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.nMu);
            GLES20.glTexImage2D(3553, 0, 6409, this.nFQ, this.nFR, 0, 6409, 5121, this.nMs);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.nMz, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.nMv);
            GLES20.glTexImage2D(3553, 0, 6410, this.nFQ / 2, this.nFR / 2, 0, 6410, 5121, this.nMt);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.nMA, 1);
            Matrix.setIdentityM(this.nME, 0);
            Matrix.setRotateM(this.nME, 0, (float) this.gPG, 0.0f, 0.0f, -1.0f);
            GLES20.glUniformMatrix4fv(this.nMB, 1, false, this.nME, 0);
            this.nMC.position(0);
            GLES20.glVertexAttribPointer(this.nMy, 2, 5126, false, 0, this.nMC);
            GLES20.glEnableVertexAttribArray(this.nMy);
            this.nMD.position(0);
            GLES20.glVertexAttribPointer(this.nMx, 2, 5126, false, 0, this.nMD);
            GLES20.glEnableVertexAttribArray(this.nMx);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.nMy);
            GLES20.glDisableVertexAttribArray(this.nMx);
            GLES20.glBindTexture(3553, 0);
        }
        this.lPZ = false;
    }
}
