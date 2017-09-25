package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.e.a.kx;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class a implements com.tencent.mm.plugin.video.a, b {
    private static final Pattern pdK = Pattern.compile(",");
    private static int roi = 20;
    private static int roj = 70;
    protected int RQ = 240;
    protected int aar = 320;
    protected ObservableSurfaceView roA = null;
    protected ObservableTextureView roB;
    protected f roC;
    protected boolean roD = false;
    protected boolean roE = false;
    protected byte[] roF = null;
    protected int[] roG = null;
    protected List<byte[]> roH;
    protected boolean roI = true;
    protected int roJ;
    protected int roK = 0;
    protected int roL = 0;
    protected int roM = 0;
    PreviewCallback roN = new PreviewCallback(this) {
        final /* synthetic */ a roO;

        {
            this.roO = r1;
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr == null || bArr.length <= 0) {
                g.oUh.a(159, 0, 1, false);
                g.oUh.a(159, 3, 1, false);
                if (this.roO.roC != null) {
                    this.roO.roC.aNu();
                }
            } else if (this.roO.rou == null) {
                w.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
            } else if (this.roO.roC != null) {
                int i;
                int i2;
                boolean z;
                int i3;
                boolean z2;
                int i4;
                if (this.roO.rok) {
                    i4 = i.rqv;
                    if (p.gRc.gPd && p.gRc.gPc.gPG != 0) {
                        i = p.gRc.gPc.gPH;
                        i2 = i4;
                        z = true;
                    }
                    i2 = i4;
                    z = false;
                    i = 1;
                } else {
                    i4 = i.rqw;
                    if (p.gRc.gPf && p.gRc.gPe.gPG != 0) {
                        i = p.gRc.gPe.gPH;
                        i2 = i4;
                        z = true;
                    }
                    i2 = i4;
                    z = false;
                    i = 1;
                }
                if (i2 > 0) {
                    i3 = 32;
                } else {
                    i3 = 0;
                }
                a aVar = this.roO;
                if (z || i2 <= 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                aVar.rol = z2;
                int i5 = this.roO.rou.width;
                int i6 = this.roO.rou.height;
                if (z) {
                    if (this.roO.roF == null) {
                        this.roO.roF = new byte[(((i5 * i6) * 3) / 2)];
                        this.roO.roF[0] = (byte) 90;
                    }
                    m bpd = d.bpd();
                    i2 = bArr.length;
                    int i7 = this.roO.rov;
                    byte[] bArr2 = this.roO.roF;
                    int length = this.roO.roF.length;
                    com.tencent.mm.plugin.voip.model.g gVar = bpd.riE.rew.rfS;
                    if (gVar.rgm != com.tencent.mm.plugin.voip.model.g.rgl && gVar.rew.rfQ.nGp && gVar.rew.bpp()) {
                        gVar.rew.rfQ.videoRorate90D(bArr, i2, i5, i6, i7, bArr2, length, i5, i6, i);
                    }
                    this.roO.roC.a(this.roO.roF, (long) this.roO.roF.length, i5, i6, this.roO.rov + i3);
                } else {
                    this.roO.roC.a(bArr, (long) bArr.length, this.roO.rou.width, this.roO.rou.height, this.roO.rov + i3);
                }
                if (com.tencent.mm.plugin.voip.b.d.brh() >= 8) {
                    this.roO.ros.addCallbackBuffer(bArr);
                }
            }
        }
    };
    protected boolean rok = false;
    protected boolean rol = false;
    protected boolean rom = false;
    protected boolean ron = false;
    protected boolean roo = false;
    protected long rop = 0;
    protected long roq = 30000;
    protected int ror = 0;
    protected Camera ros;
    protected Parameters rot;
    protected Size rou;
    protected int rov;
    protected boolean rox = false;
    protected boolean roy = false;
    protected boolean roz = false;

    public a(int i, int i2) {
        this.aar = i;
        this.RQ = i2;
        i.cY(ab.getContext().getApplicationContext());
        w.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[]{Integer.valueOf(this.aar), Integer.valueOf(this.RQ)});
    }

    public final void a(ObservableSurfaceView observableSurfaceView) {
        if (observableSurfaceView != null) {
            this.roA = observableSurfaceView;
            this.roA.a(this);
            this.roz = true;
        }
    }

    public final void a(ObservableTextureView observableTextureView) {
        w.d("MicroMsg.Voip.CaptureRender", "bindTextureView");
        if (observableTextureView != null) {
            this.roB = observableTextureView;
            this.roB.a(this);
            this.roz = false;
        }
    }

    public final void a(SurfaceHolder surfaceHolder) {
        boolean z = false;
        w.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
        if (!this.rox || surfaceHolder.getSurface() == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "surfaceChange failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.rox);
            if (surfaceHolder.getSurface() == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.e(str, str2, objArr);
            return;
        }
        try {
            this.ros.setPreviewCallback(null);
            this.ros.stopPreview();
            this.ros.setPreviewDisplay(surfaceHolder);
            brn();
            this.ros.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.oUh.a(159, 0, 1, false);
            g.oUh.a(159, 2, 1, false);
            w.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.ror = 1;
        }
        if (this.roE) {
            brp();
            this.roE = false;
        }
        d.bpd().uY(this.ror);
    }

    public final void b(SurfaceTexture surfaceTexture) {
        boolean z = false;
        w.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
        if (!this.rox || surfaceTexture == null) {
            String str = "MicroMsg.Voip.CaptureRender";
            String str2 = "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.rox);
            if (surfaceTexture == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.e(str, str2, objArr);
            return;
        }
        try {
            this.ros.setPreviewCallback(null);
            this.ros.stopPreview();
            this.ros.setPreviewTexture(surfaceTexture);
            brn();
            this.ros.startPreview();
        } catch (Exception e) {
            Exception exception = e;
            g.oUh.a(159, 0, 1, false);
            g.oUh.a(159, 2, 1, false);
            w.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + exception.getMessage());
            this.ror = 1;
        }
        if (this.roE) {
            brp();
            this.roE = false;
        }
        d.bpd().uY(this.ror);
    }

    public final int a(f fVar, boolean z) {
        if (i.rqs.gOW <= 0) {
            this.ror = 1;
            return -1;
        }
        if (z) {
            if (!i.rqs.roY) {
                z = false;
            }
        } else if (!i.rqs.roZ) {
            z = true;
        }
        this.roC = fVar;
        if (d(z, this.aar, this.RQ) <= 0) {
            int d = d(z, 0, 0);
            if (d <= 0) {
                this.ror = 1;
                return d;
            }
        }
        brn();
        this.ror = 0;
        return 1;
    }

    private void brn() {
        if (this.rou == null || this.rou.height <= 0 || this.rou.width <= 0) {
            this.ros.setPreviewCallback(this.roN);
            return;
        }
        int i;
        int i2 = ((this.rou.height * this.rou.width) * 3) / 2;
        if (this.roH == null) {
            this.roH = new ArrayList(3);
            for (i = 0; i < 3; i++) {
                this.roH.add(new byte[i2]);
            }
        }
        for (i = 0; i < this.roH.size(); i++) {
            this.ros.addCallbackBuffer((byte[]) this.roH.get(i));
        }
        this.ros.setPreviewCallbackWithBuffer(this.roN);
    }

    private static Camera im(boolean z) {
        Camera camera = null;
        if (i.rqs.gOW > 0 && i.rqy) {
            if (z) {
                try {
                    camera = Camera.open(i.rqt);
                    w.i("Camera", "Use front");
                } catch (Exception e) {
                    Exception exception = e;
                    g.oUh.a(159, 0, 1, false);
                    g.oUh.a(159, 1, 1, false);
                    w.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + exception.toString());
                }
            } else {
                camera = Camera.open(i.rqu);
                w.i("Camera", "Use back");
            }
        }
        return camera;
    }

    private Camera in(boolean z) {
        Camera im = im(z);
        if (im == null) {
            try {
                im = Camera.open();
                try {
                    Parameters parameters = im.getParameters();
                    parameters.set("camera-id", z ? 2 : 1);
                    im.setParameters(parameters);
                } catch (Exception e) {
                    Exception exception = e;
                    g.oUh.a(159, 0, 1, false);
                    w.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + exception.toString());
                }
            } catch (Exception e2) {
                w.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + e2.toString());
                g.oUh.a(159, 0, 1, false);
                g.oUh.a(159, 1, 1, false);
                if (this.roC != null) {
                    this.roC.aNu();
                }
                return null;
            }
        }
        this.rok = z;
        h(im);
        g(im);
        return im;
    }

    private static boolean a(Camera camera, int i, int i2) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            if (i > 0 && i2 > 0) {
                parameters.setPreviewSize(i, i2);
            }
            camera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            g.oUh.a(159, 0, 1, false);
            w.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + e.toString());
            return false;
        }
    }

    private boolean f(Camera camera) {
        if (camera == null) {
            return false;
        }
        try {
            Parameters parameters = camera.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                w.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    w.d("MicroMsg.Voip.CaptureRender", "supported focus modes : " + str);
                }
                if (p.gRc.gPC == 0) {
                    if (supportedFocusModes.contains("auto")) {
                        w.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.roy = false;
                    } else if (supportedFocusModes.contains("continuous-video")) {
                        w.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.roy = true;
                    }
                } else if (p.gRc.gPC == 1) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        w.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
                        parameters.setFocusMode("continuous-video");
                        this.roy = true;
                    } else if (supportedFocusModes.contains("auto")) {
                        w.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
                        parameters.setFocusMode("auto");
                        this.roy = false;
                    }
                }
                camera.setParameters(parameters);
            }
            return true;
        } catch (Exception e) {
            g.oUh.a(159, 0, 1, false);
            w.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + e.toString());
            return false;
        }
    }

    private static Point a(CharSequence charSequence, Point point) {
        int indexOf;
        int parseInt;
        String[] split = pdK.split(charSequence);
        int length = split.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        while (i < length) {
            int i5;
            String trim = split[i].trim();
            indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                w.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                i5 = i2;
                i2 = i3;
            } else {
                try {
                    parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    indexOf = Integer.parseInt(trim.substring(indexOf + 1));
                    i5 = Math.abs(parseInt - point.x) + Math.abs(indexOf - point.y);
                    if (i5 == 0) {
                        break;
                    } else if (i5 >= i4 || parseInt == indexOf) {
                        i5 = i2;
                        i2 = i3;
                    } else {
                        i4 = i5;
                        i2 = parseInt;
                        i5 = indexOf;
                    }
                } catch (NumberFormatException e) {
                    w.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + trim);
                    i5 = i2;
                    i2 = i3;
                }
            }
            i++;
            i3 = i2;
            i2 = i5;
        }
        indexOf = i2;
        parseInt = i3;
        if (parseInt <= 0 || indexOf <= 0) {
            return null;
        }
        return new Point(parseInt, indexOf);
    }

    private int d(boolean z, int i, int i2) {
        Exception e;
        Size size;
        Camera camera;
        CameraInfo cameraInfo;
        int i3;
        w.i("MicroMsg.Voip.CaptureRender", "try open camera, face: " + z);
        this.roy = false;
        Object obj = 1;
        if (this.ros != null) {
            if (this.rok != z) {
                this.ros.setPreviewCallback(null);
                this.ros.stopPreview();
                this.ros.release();
                this.ros = null;
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            this.ros = in(z);
            if (this.ros == null) {
                this.rox = false;
                return -1;
            }
        }
        try {
            Parameters parameters;
            Point point;
            Object obj2;
            Size size2;
            boolean a;
            if (this.ros != null) {
                this.ros.getParameters();
            }
            this.rox = true;
            Camera camera2 = this.ros;
            int i4 = i.rqs.roX;
            if (camera2 != null) {
                try {
                    parameters = camera2.getParameters();
                    if (l.qq()) {
                        parameters.setPreviewFpsRange(i4 * 1000, i4 * 1000);
                    } else {
                        parameters.setPreviewFrameRate(i4);
                    }
                    camera2.setParameters(parameters);
                } catch (Exception e2) {
                    w.e("MicroMsg.Voip.CaptureRender", "SafeSetFps error:" + e2.toString());
                }
            }
            w.i("MicroMsg.Voip.CaptureRender", "Camera Open Success, try set size: w,h:" + i + "," + i2);
            if (z) {
                point = i.rqs.rpc;
            } else {
                point = i.rqs.rpd;
            }
            if (point != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            Size size3 = null;
            if (point != null) {
                Camera camera3 = this.ros;
                camera3.getClass();
                Size size4 = new Size(camera3, point.x, point.y);
                w.i("MicroMsg.Voip.CaptureRender", "getCameraSize from table:" + size4.width + "," + size4.height);
                size = size4;
            } else {
                size = null;
            }
            try {
                CharSequence charSequence;
                Camera camera4 = this.ros;
                parameters = camera4.getParameters();
                Point point2 = new Point(i, i2);
                String str = parameters.get("preview-size-values");
                if (str == null) {
                    charSequence = parameters.get("preview-size-value");
                } else {
                    Object obj3 = str;
                }
                Point point3 = null;
                if (charSequence != null) {
                    w.i("MicroMsg.Voip.CaptureRender", "preview-size-values parameter: " + charSequence);
                    point3 = a(charSequence, point2);
                }
                if (point3 == null) {
                    point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
                }
                camera4.getClass();
                size2 = new Size(camera4, point3.x, point3.y);
                try {
                    w.i("MicroMsg.Voip.CaptureRender", "getCameraResolution:" + size2.width + "," + size2.height);
                } catch (Exception e3) {
                    e2 = e3;
                    size3 = size2;
                    w.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e2.getMessage()});
                    size2 = size3;
                    if (obj2 != null) {
                        w.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                        if (size2 != null) {
                            w.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                            if (!a(this.ros, size2.width, size2.height)) {
                                w.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                                return -1;
                            }
                        }
                    }
                    a = a(this.ros, size.width, size.height);
                    w.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    w.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (!a(this.ros, size2.width, size2.height)) {
                        w.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                    f(this.ros);
                    this.rot = this.ros.getParameters();
                    this.rou = this.rot.getPreviewSize();
                    i4 = this.rot.getPreviewFrameRate();
                    this.rov = i.rqx;
                    if (this.rov <= 0) {
                        this.rov = 7;
                    }
                    try {
                        camera = this.ros;
                        cameraInfo = new CameraInfo();
                        Camera.getCameraInfo(this.rok ? i.rqu : i.rqt, cameraInfo);
                        i3 = 0;
                        switch (((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                            case 0:
                                i3 = 0;
                                break;
                            case 1:
                                i3 = 90;
                                break;
                            case 2:
                                i3 = 180;
                                break;
                            case 3:
                                i3 = 270;
                                break;
                        }
                        i3 = this.rok ? ((cameraInfo.orientation - i3) + 360) % 360 : (360 - ((i3 + cameraInfo.orientation) % 360)) % 360;
                        camera.setDisplayOrientation(i3);
                        this.roJ = i3;
                    } catch (Exception e22) {
                        w.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", new Object[]{e22.getMessage()});
                    }
                    w.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.rou.width), Integer.valueOf(this.rou.height), Integer.valueOf(this.rov), Integer.valueOf(i.rqv), Integer.valueOf(this.roJ)});
                    return 1;
                }
            } catch (Exception e4) {
                e22 = e4;
                w.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[]{e22.getMessage()});
                size2 = size3;
                if (obj2 != null) {
                    a = a(this.ros, size.width, size.height);
                    w.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                    w.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (a(this.ros, size2.width, size2.height)) {
                        w.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
                w.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
                if (size2 != null) {
                    w.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                    if (a(this.ros, size2.width, size2.height)) {
                        w.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
                f(this.ros);
                this.rot = this.ros.getParameters();
                this.rou = this.rot.getPreviewSize();
                i4 = this.rot.getPreviewFrameRate();
                this.rov = i.rqx;
                if (this.rov <= 0) {
                    this.rov = 7;
                }
                camera = this.ros;
                cameraInfo = new CameraInfo();
                if (this.rok) {
                }
                Camera.getCameraInfo(this.rok ? i.rqu : i.rqt, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.rok) {
                }
                camera.setDisplayOrientation(i3);
                this.roJ = i3;
                w.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.rou.width), Integer.valueOf(this.rou.height), Integer.valueOf(this.rov), Integer.valueOf(i.rqv), Integer.valueOf(this.roJ)});
                return 1;
            }
            if (obj2 != null) {
                a = a(this.ros, size.width, size.height);
                w.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + size.width + ",h" + size.height);
                if (!(a || size2 == null)) {
                    w.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + size2.width + ",h" + size2.height);
                    if (a(this.ros, size2.width, size2.height)) {
                        w.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + size2.width + ",h" + size2.height);
                        return -1;
                    }
                }
            }
            w.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
            if (size2 != null) {
                w.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + size2.width + ",h" + size2.height);
                if (a(this.ros, size2.width, size2.height)) {
                    w.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + size2.width + ",h" + size2.height);
                    return -1;
                }
            }
            f(this.ros);
            try {
                this.rot = this.ros.getParameters();
                this.rou = this.rot.getPreviewSize();
                i4 = this.rot.getPreviewFrameRate();
                this.rov = i.rqx;
                if (this.rov <= 0) {
                    this.rov = 7;
                }
                camera = this.ros;
                cameraInfo = new CameraInfo();
                if (this.rok) {
                }
                Camera.getCameraInfo(this.rok ? i.rqu : i.rqt, cameraInfo);
                i3 = 0;
                switch (((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                    case 0:
                        i3 = 0;
                        break;
                    case 1:
                        i3 = 90;
                        break;
                    case 2:
                        i3 = 180;
                        break;
                    case 3:
                        i3 = 270;
                        break;
                }
                if (this.rok) {
                }
                camera.setDisplayOrientation(i3);
                this.roJ = i3;
                w.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.rou.width), Integer.valueOf(this.rou.height), Integer.valueOf(this.rov), Integer.valueOf(i.rqv), Integer.valueOf(this.roJ)});
                return 1;
            } catch (Exception e222) {
                g.oUh.a(159, 0, 1, false);
                w.e("MicroMsg.Voip.CaptureRender", "try getParameters and getPreviewSize fail, error:%s", new Object[]{e222.getMessage()});
                return -1;
            }
        } catch (Exception e2222) {
            g.oUh.a(159, 0, 1, false);
            w.e("MicroMsg.Voip.CaptureRender", "Camera open failed, error:%s", new Object[]{e2222.getMessage()});
            if (this.roC != null) {
                this.roC.aNu();
            }
            return -1;
        }
    }

    public final void bro() {
        if (i.rqs.gOW < 2) {
            w.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + i.rqs.gOW);
            return;
        }
        w.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + i.rqs.gOW);
        brq();
        a(this.roC, !this.rok);
        brp();
        d.bpd().uY(this.ror);
        this.roI = true;
    }

    public final int brp() {
        if (!this.rox) {
            w.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
            this.ror = 1;
            return -1;
        } else if (this.roD) {
            w.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
            return -1;
        } else if (this.roA == null || this.roA.box()) {
            w.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[]{Boolean.valueOf(this.roz)});
            if (this.roA != null && this.roz) {
                try {
                    this.ros.setPreviewDisplay(this.roA.getSurfaceHolder());
                } catch (Exception e) {
                    g.oUh.a(159, 0, 1, false);
                    g.oUh.a(159, 2, 1, false);
                    this.ror = 1;
                    w.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e.toString());
                }
            } else if (!(this.roB == null || this.roz)) {
                try {
                    this.ros.setPreviewTexture(this.roB.getSurfaceTexture());
                } catch (Exception e2) {
                    g.oUh.a(159, 0, 1, false);
                    g.oUh.a(159, 2, 1, false);
                    this.ror = 1;
                    w.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + e2.toString());
                }
            }
            try {
                this.ros.startPreview();
            } catch (Exception e22) {
                g.oUh.a(159, 0, 1, false);
                g.oUh.a(159, 2, 1, false);
                this.ror = 1;
                if (this.roC != null) {
                    this.roC.aNu();
                }
                w.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + e22.toString());
            }
            this.roD = true;
            return 1;
        } else {
            w.d("MicroMsg.Voip.CaptureRender", "StartCapture:surface not ready, try later.... ");
            this.roE = true;
            return 0;
        }
    }

    public final void brq() {
        w.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.roD);
        if (this.roD) {
            this.roE = false;
            this.ros.setPreviewCallback(null);
            try {
                this.ros.stopPreview();
            } catch (Exception e) {
                w.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + e.toString());
            }
            this.roD = false;
        }
        if (1 == this.ror) {
            com.tencent.mm.sdk.b.b kxVar = new kx();
            kxVar.fRD.type = 2;
            com.tencent.mm.sdk.b.a.urY.m(kxVar);
        }
        w.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.rox);
        if (this.rox) {
            this.ror = 0;
            this.roE = false;
            this.ros.setPreviewCallback(null);
            this.ros.release();
            this.ros = null;
            this.rox = false;
        } else if (this.ros != null) {
            this.ros.release();
            this.ros = null;
            this.rox = false;
        }
        this.roF = null;
        if (this.roH != null) {
            this.roH.clear();
        }
        this.roH = null;
        this.roy = false;
    }

    public static void brr() {
    }

    @TargetApi(14)
    public final void n(int[] iArr) {
        boolean z = true;
        if (p.gRc.gPC != 1 || !this.roy) {
            if (p.gRc.gPB > MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                this.roq = (long) p.gRc.gPB;
            }
            boolean z2;
            boolean z3;
            if (iArr == null) {
                w.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
                z2 = System.currentTimeMillis() - this.rop > this.roq;
                if (!this.rom || z2 || this.ron != this.rok) {
                    String str = "MicroMsg.Voip.CaptureRender";
                    StringBuilder stringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
                    if (this.rom) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    StringBuilder append = stringBuilder.append(z3).append(",isAutoFocusTimeout: ").append(z2).append(",mAutoFocusTimeOut:").append(this.roq).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
                    if (this.ron == this.rok) {
                        z = false;
                    }
                    w.i(str, append.append(z).append(",isClickScreen :false").toString());
                    try {
                        if (this.ros != null && this.ros.getParameters() != null && this.ros.getParameters().getFocusMode() != null && this.ros.getParameters().getFocusMode().equals("auto")) {
                            this.ros.autoFocus(null);
                            this.roG = null;
                            this.rop = System.currentTimeMillis();
                            this.rom = true;
                            this.ron = this.rok;
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        w.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + e.toString());
                        return;
                    }
                }
                return;
            }
            Rect rect;
            Parameters parameters;
            if (this.roG == null) {
                this.roG = iArr;
                z2 = true;
            } else {
                z2 = false;
            }
            int[] iArr2 = this.roG;
            int abs = Math.abs(iArr2[3] - iArr[3]) + ((Math.abs(iArr2[0] - iArr[0]) + Math.abs(iArr2[1] - iArr[1])) + Math.abs(iArr2[2] - iArr[2]));
            w.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", new Object[]{Integer.valueOf(abs)});
            if (abs > roj || abs > roi) {
                this.roG = iArr;
                if (abs > roj) {
                    z2 = true;
                }
                if (abs > roi) {
                    z3 = true;
                    if (!z2 || z3) {
                        List arrayList;
                        rect = new Rect(this.roG[0], this.roG[1], this.roG[2], this.roG[3]);
                        parameters = this.ros.getParameters();
                        if (z3) {
                            if (com.tencent.mm.compatible.util.d.eo(14) || parameters.getMaxNumMeteringAreas() <= 0) {
                                w.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                                z3 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setMeteringAreas(arrayList);
                            }
                        }
                        if (z2) {
                            if (com.tencent.mm.compatible.util.d.eo(14) || parameters.getMaxNumFocusAreas() <= 0) {
                                w.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                                z2 = false;
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new Area(rect, 1000));
                                parameters.setFocusAreas(arrayList);
                            }
                        }
                        if (z2 || r3) {
                            this.ros.setParameters(parameters);
                        }
                        if (z2) {
                            w.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.roI)});
                            if (this.roI) {
                                this.rom = false;
                                this.roI = false;
                                this.ros.autoFocus(new AutoFocusCallback(this) {
                                    final /* synthetic */ a roO;

                                    {
                                        this.roO = r1;
                                    }

                                    public final void onAutoFocus(boolean z, Camera camera) {
                                        w.d("MicroMsg.Voip.CaptureRender", "onAutoFocus, success:%b", new Object[]{Boolean.valueOf(z)});
                                        this.roO.roI = true;
                                    }
                                });
                            }
                        }
                    }
                    return;
                }
            }
            z3 = false;
            if (z2) {
            }
            try {
                rect = new Rect(this.roG[0], this.roG[1], this.roG[2], this.roG[3]);
                parameters = this.ros.getParameters();
                if (z3) {
                    if (com.tencent.mm.compatible.util.d.eo(14)) {
                    }
                    w.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
                    z3 = false;
                }
                if (z2) {
                    if (com.tencent.mm.compatible.util.d.eo(14)) {
                    }
                    w.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
                    z2 = false;
                }
                this.ros.setParameters(parameters);
                if (z2) {
                    w.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[]{Boolean.valueOf(this.roI)});
                    if (this.roI) {
                        this.rom = false;
                        this.roI = false;
                        this.ros.autoFocus(/* anonymous class already generated */);
                    }
                }
            } catch (Exception e2) {
                w.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", new Object[]{e2.getMessage()});
            }
        }
    }

    private int g(Camera camera) {
        int i;
        int i2;
        Throwable th;
        if (camera == null) {
            return 0;
        }
        try {
            List<Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
            if (supportedPreviewSizes == null || supportedPreviewSizes.size() == 0) {
                i = 0;
            } else {
                i = 0;
                for (Size size : supportedPreviewSizes) {
                    try {
                        w.d("MicroMsg.Voip.CaptureRender", "support Size:" + size.width + "," + size.height);
                        if (i == 0) {
                            this.roK = size.width;
                            this.roL = size.height;
                        }
                        i++;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        i2 = i;
                        th = th2;
                    }
                }
            }
            List<Integer> supportedPreviewFormats = camera.getParameters().getSupportedPreviewFormats();
            if (!(supportedPreviewFormats == null || supportedPreviewFormats.size() == 0)) {
                for (Integer intValue : supportedPreviewFormats) {
                    w.i("MicroMsg.Voip.CaptureRender", "support Format:" + intValue.intValue());
                }
            }
            return i;
        } catch (Throwable e2) {
            th = e2;
            i2 = 0;
            w.printErrStackTrace("MicroMsg.Voip.CaptureRender", th, "", new Object[0]);
            return i2;
        }
    }

    private static void h(Camera camera) {
        List supportedPreviewFrameRates;
        String str;
        List list = null;
        try {
            supportedPreviewFrameRates = camera.getParameters().getSupportedPreviewFrameRates();
        } catch (Exception e) {
            w.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + e.toString());
            supportedPreviewFrameRates = list;
        }
        String str2 = "supportFps:";
        if (supportedPreviewFrameRates != null) {
            str = str2;
            for (int i = 0; i < supportedPreviewFrameRates.size(); i++) {
                str = str + ((Integer) supportedPreviewFrameRates.get(i)).intValue() + ",";
            }
        } else {
            str = str2;
        }
        w.i("MicroMsg.Voip.CaptureRender", str);
    }

    public final boolean brs() {
        return this.rok;
    }

    public final boolean brt() {
        return this.rol;
    }

    public final int bru() {
        return this.ror;
    }

    public final void brv() {
        try {
            if (this.rot != null) {
                Size previewSize = this.rot.getPreviewSize();
                c brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
                int i = this.rox ? 1 : 0;
                this.rot.getPreviewFrameRate();
                int i2 = this.roK;
                int i3 = this.roL;
                int i4 = previewSize.width;
                int i5 = previewSize.height;
                w.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                brP.rrD = i;
                brP.rrz = i2;
                brP.rrA = i3;
                brP.rrB = i4;
                brP.rrC = i5;
            }
        } catch (Exception e) {
            w.e("MicroMsg.Voip.CaptureRender", "getCameraDataForVoipCS failed" + e.getMessage());
        }
    }
}
