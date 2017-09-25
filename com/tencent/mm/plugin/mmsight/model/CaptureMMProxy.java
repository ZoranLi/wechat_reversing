package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy extends a {
    private static CaptureMMProxy nAR;
    private static String nAS = "";

    public static void createProxy(CaptureMMProxy captureMMProxy) {
        nAR = captureMMProxy;
    }

    public static CaptureMMProxy getInstance() {
        return nAR;
    }

    public CaptureMMProxy(d dVar) {
        super(dVar);
    }

    public String getAccVideoPath() {
        String str = (String) REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
        w.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + nAS);
        if (!bg.mA(str)) {
            nAS = str;
        }
        if (bg.mA(nAS)) {
            return str;
        }
        return nAS;
    }

    public String getSubCoreImageFullPath(String str) {
        String str2 = (String) REMOTE_CALL("getSubCoreImageFullPathInMM", new Object[]{str});
        w.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath " + str2);
        return str2;
    }

    public Object get(com.tencent.mm.storage.w.a aVar, Object obj) {
        w.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[]{aVar, obj});
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", new Object[]{aVar, obj});
        w.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[]{aVar, obj, REMOTE_CALL});
        return REMOTE_CALL == null ? obj : REMOTE_CALL;
    }

    public boolean set(com.tencent.mm.storage.w.a aVar, Object obj) {
        Boolean bool = (Boolean) REMOTE_CALL("setConfigStorage", new Object[]{aVar, obj});
        w.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[]{aVar, obj});
        return bool.booleanValue();
    }

    public VideoTransPara getSnsAlbumVideoTransPara() {
        Parcelable parcelable = (Parcelable) REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
        w.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: " + parcelable);
        return (VideoTransPara) parcelable;
    }

    public String getDeviceInfoConfig() {
        w.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[]{(String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0])});
        return (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    }

    public String getDynamicConfig(String str) {
        w.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[]{str, (String) REMOTE_CALL("getDynamicConfigInMM", new Object[]{str})});
        return (String) REMOTE_CALL("getDynamicConfigInMM", new Object[]{str});
    }

    public byte[] getWeixinMeta() {
        w.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[]{(byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0])});
        return (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    }

    public boolean checkUseMMVideoPlayer() {
        Object REMOTE_CALL = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
        if (REMOTE_CALL == null) {
            return true;
        }
        w.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", new Object[]{REMOTE_CALL});
        return ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public VideoTransPara getSnsAlbumVideoTransParaInMM() {
        w.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
        VideoTransPara Ex = com.tencent.mm.modelcontrol.d.Eu().Ex();
        w.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: " + Ex);
        return Ex;
    }

    @f
    public boolean checkUseMMVideoPlayerInMM() {
        w.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
        com.tencent.mm.modelcontrol.d.Eu();
        boolean EB = com.tencent.mm.modelcontrol.d.EB();
        w.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: " + EB);
        return EB;
    }

    @f
    public String getAccVideoPathInMM() {
        w.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
        o.KU();
        return o.getAccVideoPath();
    }

    @f
    public String getSubCoreImageFullPathInMM(String str) {
        w.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[]{str});
        return n.GS().js(str);
    }

    @f
    public Object getConfigStorage(int i, Object obj) {
        w.d("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[]{((com.tencent.mm.storage.w.a[]) com.tencent.mm.storage.w.a.class.getEnumConstants())[i], obj});
        h.vJ();
        return h.vI().vr().get(((com.tencent.mm.storage.w.a[]) com.tencent.mm.storage.w.a.class.getEnumConstants())[i], obj);
    }

    @f
    public boolean setConfigStorage(int i, Object obj) {
        w.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[]{((com.tencent.mm.storage.w.a[]) com.tencent.mm.storage.w.a.class.getEnumConstants())[i], obj});
        h.vJ();
        h.vI().vr().a(r0, obj);
        return true;
    }

    @f
    public String getDeviceInfoConfigInMM() {
        h.vJ();
        return h.vI().vs().bMU();
    }

    @f
    public String getDynamicConfigInMM(String str) {
        return ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue(str);
    }

    @f
    public byte[] getWeixinMetaDataInMM() {
        return com.tencent.mm.modelcontrol.d.Eu().getWeixinMeta();
    }

    protected final Bundle objectsToBundle(Object... objArr) {
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else if (objArr[i] instanceof com.tencent.mm.storage.w.a) {
                bundle.putInt(String.valueOf(i), ((com.tencent.mm.storage.w.a) objArr[i]).ordinal());
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        return bundle;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        w.d("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() == Void.TYPE) {
                        return;
                    }
                    if (invoke instanceof Parcelable) {
                        bundle.putParcelable("result_key", (Parcelable) invoke);
                    } else {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            w.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[]{bg.g(e)});
        }
    }
}
