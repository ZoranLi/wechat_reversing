package com.tencent.mm.plugin.exdevice.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.dt;
import com.tencent.mm.e.a.dx;
import com.tencent.mm.e.a.hm;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.aff;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g implements e {
    String fOz;
    public long gLE;
    long gVi;
    public a hGH = new a(this) {
        final /* synthetic */ g lcW;

        {
            this.lcW = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", new Object[]{this.lcW.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, Boolean.valueOf(this.lcW.lcC)});
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                try {
                    int i2;
                    int i3 = (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f);
                    w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 >= 100) {
                        i2 = 99;
                    } else {
                        i2 = i3;
                    }
                    for (String aN : this.lcW.lcE.keySet()) {
                        this.lcW.aN(aN, i2);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", new Object[]{e});
                }
            }
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (this.lcW.lcC) {
                    afg com_tencent_mm_protocal_c_afg = new afg();
                    this.lcW.a(com_tencent_mm_protocal_c_afg, this.lcW.gLE);
                    this.lcW.lcC = false;
                    if (g.bl(this.lcW.gLE).booleanValue() || g.bm(this.lcW.gLE).booleanValue()) {
                        com_tencent_mm_protocal_c_afg.tKx.tng = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                        com_tencent_mm_protocal_c_afg.tKx.tKB = this.lcW.lcG;
                        com_tencent_mm_protocal_c_afg.tKx.tnk = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                        com_tencent_mm_protocal_c_afg.tKx.msN = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                        w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", new Object[]{com_tencent_mm_protocal_c_afg.tKx.msN});
                    } else if (g.bk(this.lcW.gLE).booleanValue()) {
                        com_tencent_mm_protocal_c_afg.tKy.tng = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                        com_tencent_mm_protocal_c_afg.tKy.tnk = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                        com_tencent_mm_protocal_c_afg.tKy.msN = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                        w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", new Object[]{com_tencent_mm_protocal_c_afg.tKy.msN});
                    } else if (g.bn(this.lcW.gLE).booleanValue()) {
                        com_tencent_mm_protocal_c_afg.tKA.msN = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                        w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", new Object[]{com_tencent_mm_protocal_c_afg.tKA.msN});
                    }
                    this.lcW.lcF = com_tencent_mm_protocal_c_afg;
                    for (String aN2 : this.lcW.lcE.keySet()) {
                        ap.vd().a(new n(com_tencent_mm_protocal_c_afg, (String) this.lcW.lcE.get(aN2), aN2, 1), 0);
                    }
                    this.lcW.lcE.clear();
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = " + str);
        }

        public final byte[] i(String str, byte[] bArr) {
            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
            return bArr;
        }
    };
    String hGx = "";
    public String lcA = "send_data_failed";
    private String lcB = "send_data_sending";
    boolean lcC = false;
    boolean lcD = false;
    public HashMap<String, String> lcE = new HashMap();
    public afg lcF;
    long lcG;
    public List<b> lcH = null;
    public List<b> lcI = new ArrayList();
    public HashMap<String, String> lcJ = new HashMap();
    HashMap<String, Integer> lcK = new HashMap();
    public HashMap<String, Boolean> lcL = new HashMap();
    j.a lcM;
    j.a lcN;
    j.a lcO;
    j.a lcP;
    Runnable lcQ = new Runnable(this) {
        final /* synthetic */ g lcW;

        {
            this.lcW = r1;
        }

        public final void run() {
            Throwable e;
            String str = null;
            try {
                String str2 = com.tencent.mm.compatible.util.e.gSy + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(this.lcW.fOz.hashCode()), "jpg"});
                byte[] uV = g.uV(this.lcW.fOz);
                if (uV != null) {
                    afh com_tencent_mm_protocal_c_afh;
                    String str3;
                    String str4;
                    int i;
                    String str5;
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(uV, 0, uV.length);
                    g gVar = this.lcW;
                    BufferedOutputStream bufferedOutputStream;
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2)));
                        try {
                            decodeByteArray.compress(CompressFormat.JPEG, 80, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                        } catch (IOException e3) {
                            e2 = e3;
                            try {
                                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                                g.bR(gVar.lcT, gVar.lcA);
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable e22) {
                                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                    }
                                }
                                this.lcW.lcx = str2;
                                if (this.lcW.lcx == null) {
                                }
                                com_tencent_mm_protocal_c_afh = new afh();
                                str3 = this.lcW.lcx;
                                if (str3 != null) {
                                }
                                str4 = null;
                                i = -1;
                                str5 = null;
                                com_tencent_mm_protocal_c_afh.tvt = str;
                                com_tencent_mm_protocal_c_afh.msj = str5;
                                com_tencent_mm_protocal_c_afh.jNW = i;
                                com_tencent_mm_protocal_c_afh.tup = str4;
                                this.lcW.lcR.tKx = com_tencent_mm_protocal_c_afh;
                                this.lcW.lcR.tKu = 3;
                                ap.vd().a(new n(this.lcW.lcR, this.lcW.lcS, this.lcW.lcT, this.lcW.lcU), 0);
                                return;
                            } catch (Throwable th) {
                                e22 = th;
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Throwable e4) {
                                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e4, "", new Object[0]);
                                    }
                                }
                                throw e22;
                            }
                        }
                    } catch (IOException e5) {
                        e22 = e5;
                        bufferedOutputStream = null;
                        w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Exception in saveImageToFile !");
                        g.bR(gVar.lcT, gVar.lcA);
                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        this.lcW.lcx = str2;
                        if (this.lcW.lcx == null) {
                        }
                        com_tencent_mm_protocal_c_afh = new afh();
                        str3 = this.lcW.lcx;
                        if (str3 != null) {
                        }
                        str4 = null;
                        i = -1;
                        str5 = null;
                        com_tencent_mm_protocal_c_afh.tvt = str;
                        com_tencent_mm_protocal_c_afh.msj = str5;
                        com_tencent_mm_protocal_c_afh.jNW = i;
                        com_tencent_mm_protocal_c_afh.tup = str4;
                        this.lcW.lcR.tKx = com_tencent_mm_protocal_c_afh;
                        this.lcW.lcR.tKu = 3;
                        ap.vd().a(new n(this.lcW.lcR, this.lcW.lcS, this.lcW.lcT, this.lcW.lcU), 0);
                        return;
                    } catch (Throwable th2) {
                        e22 = th2;
                        bufferedOutputStream = null;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw e22;
                    }
                    this.lcW.lcx = str2;
                    if (this.lcW.lcx == null || FileOp.aO(this.lcW.lcx)) {
                        com_tencent_mm_protocal_c_afh = new afh();
                        str3 = this.lcW.lcx;
                        if (str3 != null || str3.length() <= 0) {
                            str4 = null;
                            i = -1;
                            str5 = null;
                        } else {
                            File file = new File(str3);
                            str5 = file.getName();
                            i = (int) file.length();
                            str = str5.substring(str5.lastIndexOf(".") + 1, str5.length());
                            str4 = com.tencent.mm.a.g.f(file);
                            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable filePath %s", new Object[]{str3});
                            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileSize %s", new Object[]{Integer.valueOf(i)});
                            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "downloadImageRunnable fileMd5 %s", new Object[]{str4});
                        }
                        com_tencent_mm_protocal_c_afh.tvt = str;
                        com_tencent_mm_protocal_c_afh.msj = str5;
                        com_tencent_mm_protocal_c_afh.jNW = i;
                        com_tencent_mm_protocal_c_afh.tup = str4;
                        this.lcW.lcR.tKx = com_tencent_mm_protocal_c_afh;
                        this.lcW.lcR.tKu = 3;
                        ap.vd().a(new n(this.lcW.lcR, this.lcW.lcS, this.lcW.lcT, this.lcW.lcU), 0);
                        return;
                    }
                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mSnsImagePath is null or file not exist!");
                    g.bR(this.lcW.lcT, this.lcW.lcA);
                    return;
                }
                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get image error !");
                g.bR(this.lcW.lcT, this.lcW.lcA);
            } catch (Throwable e222) {
                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
            }
        }
    };
    afg lcR;
    String lcS;
    String lcT;
    int lcU;
    public HashMap<Integer, String> lcV = new HashMap();
    boolean lct = false;
    boolean lcu = false;
    boolean lcv = false;
    String lcw;
    public String lcx;
    int lcy;
    public String lcz = "send_data_sucess";

    public g() {
        this.lcI.clear();
        this.lcJ.clear();
        this.lcL.clear();
        this.lcH = ad.apt().apX();
        if (this.lcH != null && this.lcH.size() > 0) {
            w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[]{Integer.valueOf(this.lcH.size())});
            int size = this.lcH.size();
            int i = 0;
            while (i < size) {
                if (((b) this.lcH.get(i)).gtX.contains("internet_to_device") && !((b) this.lcH.get(i)).gtX.contains("wechat_to_device")) {
                    this.lcI.add(this.lcH.get(i));
                }
                i++;
            }
            this.lcP = new j.a(this) {
                final /* synthetic */ g lcW;

                {
                    this.lcW = r1;
                }

                public final void f(int i, Object... objArr) {
                    int i2;
                    Object obj;
                    if (i == 15 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        try {
                            w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", new Object[]{new String((byte[]) objArr[1])});
                            int i3 = new JSONObject(r1).getInt("progress");
                            try {
                                this.lcW.aN((String) this.lcW.lcV.get(Integer.valueOf(intValue)), i3);
                                if (i3 >= 100) {
                                    this.lcW.lcV.remove(Integer.valueOf(intValue));
                                }
                                i2 = i3;
                            } catch (JSONException e) {
                                JSONException jSONException = e;
                                i2 = i3;
                                JSONException jSONException2 = jSONException;
                                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", new Object[]{obj});
                                w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", new Object[]{Integer.valueOf(i2)});
                            }
                        } catch (JSONException e2) {
                            obj = e2;
                            i2 = 0;
                            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", new Object[]{obj});
                            w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", new Object[]{Integer.valueOf(i2)});
                        }
                        w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", new Object[]{Integer.valueOf(i2)});
                    }
                }
            };
            this.lcM = new j.a(this) {
                final /* synthetic */ g lcW;

                {
                    this.lcW = r1;
                }

                public final void f(int i, Object... objArr) {
                    JSONObject jSONObject;
                    String string;
                    Exception e;
                    Object obj;
                    Object obj2;
                    JSONObject jSONObject2;
                    int size;
                    int i2;
                    String str = null;
                    if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(new String((byte[]) objArr[0]));
                            jSONObject = jSONObject3.getJSONObject("deviceInfo");
                            try {
                                string = jSONObject.getString("deviceType");
                            } catch (Exception e2) {
                                e = e2;
                                string = null;
                                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", new Object[]{e});
                                obj = string;
                                obj2 = str;
                                jSONObject2 = jSONObject;
                                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                                size = this.lcW.lcH.size();
                                i2 = 0;
                                while (i2 < size) {
                                    this.lcW.lcJ.put(obj2, jSONObject2.toString());
                                    this.lcW.lcI.add(this.lcW.lcH.get(i2));
                                    g.ap(this.lcW.lcI);
                                    i2++;
                                }
                            }
                            try {
                                str = jSONObject.getString("deviceId");
                                if (jSONObject3.isNull("profile")) {
                                    w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
                                    return;
                                }
                                JSONArray jSONArray = jSONObject3.getJSONArray("profile");
                                w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", new Object[]{jSONArray.toString()});
                                String str2 = string;
                                string = str;
                                jSONObject2 = jSONObject;
                                if (!(obj == null || obj2 == null)) {
                                    w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                                }
                                size = this.lcW.lcH.size();
                                i2 = 0;
                                while (i2 < size) {
                                    if (((b) this.lcW.lcH.get(i2)).field_deviceID.equals(obj2) && ((b) this.lcW.lcH.get(i2)).field_deviceType.equals(obj) && ((b) this.lcW.lcH.get(i2)).gtX.contains("wechat_to_device") && !this.lcW.lcI.contains(this.lcW.lcH.get(i2))) {
                                        this.lcW.lcJ.put(obj2, jSONObject2.toString());
                                        this.lcW.lcI.add(this.lcW.lcH.get(i2));
                                        g.ap(this.lcW.lcI);
                                    }
                                    i2++;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", new Object[]{e});
                                obj = string;
                                obj2 = str;
                                jSONObject2 = jSONObject;
                                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                                size = this.lcW.lcH.size();
                                i2 = 0;
                                while (i2 < size) {
                                    this.lcW.lcJ.put(obj2, jSONObject2.toString());
                                    this.lcW.lcI.add(this.lcW.lcH.get(i2));
                                    g.ap(this.lcW.lcI);
                                    i2++;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            jSONObject = null;
                            string = null;
                            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", new Object[]{e});
                            obj = string;
                            obj2 = str;
                            jSONObject2 = jSONObject;
                            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[]{obj, obj2});
                            size = this.lcW.lcH.size();
                            i2 = 0;
                            while (i2 < size) {
                                this.lcW.lcJ.put(obj2, jSONObject2.toString());
                                this.lcW.lcI.add(this.lcW.lcH.get(i2));
                                g.ap(this.lcW.lcI);
                                i2++;
                            }
                        }
                    }
                }
            };
            this.lcN = new j.a(this) {
                final /* synthetic */ g lcW;

                {
                    this.lcW = r1;
                }

                public final void f(int i, Object... objArr) {
                    if (i == 12 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        byte[] bArr = (byte[]) objArr[1];
                        if (intValue > 0) {
                            String str = (String) this.lcW.lcV.get(Integer.valueOf(intValue));
                            if (str != null) {
                                try {
                                    w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new Object[]{new String(bArr)});
                                    JSONObject jSONObject = new JSONObject(r2);
                                    if (jSONObject.isNull("errcode") || jSONObject.getInt("errcode") == 0) {
                                        g.bR(str, this.lcW.lcz);
                                        w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
                                        return;
                                    }
                                    g.bR(str, this.lcW.lcA);
                                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", new Object[]{r2});
                                    return;
                                } catch (JSONException e) {
                                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", new Object[]{e});
                                    return;
                                }
                            }
                        }
                        w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =" + intValue);
                    }
                }
            };
            this.lcO = new j.a(this) {
                final /* synthetic */ g lcW;

                {
                    this.lcW = r1;
                }

                public final void f(int i, Object... objArr) {
                    if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                        String str = (String) objArr[0];
                        int intValue = ((Integer) objArr[1]).intValue();
                        Object obj = null;
                        try {
                            JSONObject jSONObject = new JSONObject(new String(str));
                            obj = jSONObject.getString("deviceId");
                            jSONObject.getString("deviceType");
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e, "", new Object[0]);
                            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
                        }
                        switch (intValue) {
                            case -2:
                            case -1:
                            case 0:
                                this.lcW.lcL.put(obj, Boolean.valueOf(false));
                                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = " + intValue);
                                return;
                            case 1:
                                this.lcW.lcL.put(obj, Boolean.valueOf(true));
                                w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            ap.vd().a(1717, this);
            j.apk().a(14, this.lcM);
            j.apk().a(12, this.lcN);
            j.apk().a(13, this.lcO);
            j.apk().a(15, this.lcP);
            w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    public static Boolean bk(long j) {
        boolean z = false;
        ap.yY();
        ce cA = c.wT().cA(j);
        if (cA.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        String str = cA.field_content;
        if (cA.field_type == 49) {
            f.a ek = f.a.ek(str);
            if (ek != null && ek.type == 6) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    public static Boolean bl(long j) {
        boolean z = false;
        ap.yY();
        ce cA = c.wT().cA(j);
        if (cA.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (cA.field_type == 3) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static Boolean bm(long j) {
        boolean z = false;
        ap.yY();
        ce cA = c.wT().cA(j);
        if (cA.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (cA.bMp()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static Boolean bn(long j) {
        boolean z = false;
        ap.yY();
        ce cA = c.wT().cA(j);
        if (cA.field_msgId == 0) {
            return Boolean.valueOf(false);
        }
        if (cA.field_type == 62) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static byte[] uV(String str) {
        t a;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "url %s", new Object[]{str});
        try {
            a = com.tencent.mm.network.b.a(str, null);
            try {
                a.setRequestMethod("GET");
                a.setConnectTimeout(25000);
                a.setReadTimeout(25000);
                inputStream = a.getInputStream();
                try {
                    if (a.getResponseCode() == m.CTRL_INDEX) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            byteArrayOutputStream.close();
                            inputStream.close();
                            a.ieZ.disconnect();
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e2) {
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2, "", new Object[0]);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                }
                            }
                            a.ieZ.disconnect();
                        } catch (Exception e3) {
                            e22 = e3;
                            try {
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22, "", new Object[0]);
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable e222) {
                                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e2222) {
                                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222, "", new Object[0]);
                                    }
                                }
                                if (a != null) {
                                    a.ieZ.disconnect();
                                }
                                return bArr;
                            } catch (Throwable th2) {
                                th = th2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Throwable e22222) {
                                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e222222) {
                                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222222, "", new Object[0]);
                                    }
                                }
                                if (a != null) {
                                    a.ieZ.disconnect();
                                }
                                throw th;
                            }
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e2222222) {
                            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222222, "", new Object[0]);
                        }
                    }
                    a.ieZ.disconnect();
                } catch (Exception e4) {
                    e2222222 = e4;
                    byteArrayOutputStream = bArr;
                    w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e2222222, "", new Object[0]);
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        a.ieZ.disconnect();
                    }
                    return bArr;
                } catch (Throwable e22222222) {
                    byteArrayOutputStream = bArr;
                    th = e22222222;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (a != null) {
                        a.ieZ.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e22222222 = e5;
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e22222222, "", new Object[0]);
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (a != null) {
                    a.ieZ.disconnect();
                }
                return bArr;
            } catch (Throwable e222222222) {
                inputStream = bArr;
                byteArrayOutputStream = bArr;
                th = e222222222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (a != null) {
                    a.ieZ.disconnect();
                }
                throw th;
            }
        } catch (Exception e6) {
            e222222222 = e6;
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e222222222, "", new Object[0]);
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.ieZ.disconnect();
            }
            return bArr;
        } catch (Throwable e2222222222) {
            a = bArr;
            inputStream = bArr;
            byteArrayOutputStream = bArr;
            th = e2222222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (a != null) {
                a.ieZ.disconnect();
            }
            throw th;
        }
        return bArr;
    }

    public final bfc api() {
        com.tencent.mm.sdk.b.b hmVar = new hm();
        hmVar.fMT.fGN = this.lcw;
        com.tencent.mm.sdk.b.a.urY.m(hmVar);
        return hmVar.fMU.fMV;
    }

    public final boolean a(afg com_tencent_mm_protocal_c_afg, long j) {
        int i = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String bo = bo(j);
        if (bo != null && bo.length() > 0) {
            File file = new File(bo);
            str2 = file.getName();
            i = (int) file.length();
            str3 = str2.substring(str2.lastIndexOf(".") + 1, str2.length());
            str = com.tencent.mm.a.g.f(file);
            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[]{bo});
            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[]{Integer.valueOf(i)});
            w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[]{str});
        }
        ap.yY();
        ce cA = c.wT().cA(j);
        if (cA.field_msgId == 0) {
            w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
            return false;
        }
        switch (cA.field_type) {
            case 3:
                afh com_tencent_mm_protocal_c_afh = new afh();
                com_tencent_mm_protocal_c_afh.tvt = str3;
                com_tencent_mm_protocal_c_afh.msj = str2;
                com_tencent_mm_protocal_c_afh.jNW = i;
                com_tencent_mm_protocal_c_afh.tup = str;
                com_tencent_mm_protocal_c_afg.tKx = com_tencent_mm_protocal_c_afh;
                com_tencent_mm_protocal_c_afg.tKu = 3;
                break;
            case 48:
                ap.yY();
                au.b Aw = c.wT().Aw(cA.field_content);
                afi com_tencent_mm_protocal_c_afi = new afi();
                com_tencent_mm_protocal_c_afi.tlp = (float) Aw.naO;
                com_tencent_mm_protocal_c_afi.tlq = (float) Aw.naP;
                com_tencent_mm_protocal_c_afi.tKC = (float) Aw.fOd;
                com_tencent_mm_protocal_c_afi.mvE = Aw.label;
                com_tencent_mm_protocal_c_afi.tKD = Aw.ndv;
                com_tencent_mm_protocal_c_afg.tKw = com_tencent_mm_protocal_c_afi;
                com_tencent_mm_protocal_c_afg.tKu = 2;
                break;
            case 49:
            case 268435505:
                f.a ek = f.a.ek(cA.field_content);
                if (ek != null) {
                    if (ek.type != 3) {
                        if (ek.type != 6) {
                            if (ek.type != 5) {
                                if (ek.type == 2) {
                                    afh com_tencent_mm_protocal_c_afh2 = new afh();
                                    com_tencent_mm_protocal_c_afh2.tvt = "jpg";
                                    com_tencent_mm_protocal_c_afh2.msj = str2;
                                    com_tencent_mm_protocal_c_afh2.jNW = i;
                                    com_tencent_mm_protocal_c_afh2.tup = str;
                                    com_tencent_mm_protocal_c_afg.tKx = com_tencent_mm_protocal_c_afh2;
                                    com_tencent_mm_protocal_c_afg.tKu = 3;
                                    break;
                                }
                            }
                            afk com_tencent_mm_protocal_c_afk = new afk();
                            com_tencent_mm_protocal_c_afk.msN = ek.url;
                            com_tencent_mm_protocal_c_afk.fDC = ek.title;
                            com_tencent_mm_protocal_c_afk.tKE = ek.description;
                            com_tencent_mm_protocal_c_afk.muS = ek.appName;
                            com_tencent_mm_protocal_c_afg.tKz = com_tencent_mm_protocal_c_afk;
                            com_tencent_mm_protocal_c_afg.tKu = 5;
                            break;
                        }
                        aff com_tencent_mm_protocal_c_aff = new aff();
                        com_tencent_mm_protocal_c_aff.tvt = ek.hhr;
                        com_tencent_mm_protocal_c_aff.msj = ek.title;
                        com_tencent_mm_protocal_c_aff.jNW = i;
                        com_tencent_mm_protocal_c_aff.tup = str;
                        com_tencent_mm_protocal_c_afg.tKy = com_tencent_mm_protocal_c_aff;
                        com_tencent_mm_protocal_c_afg.tKu = 4;
                        break;
                    }
                    afj com_tencent_mm_protocal_c_afj = new afj();
                    com_tencent_mm_protocal_c_afj.fDC = ek.title;
                    com_tencent_mm_protocal_c_afj.tKE = ek.description;
                    com_tencent_mm_protocal_c_afj.msN = ek.url;
                    com_tencent_mm_protocal_c_afj.tKF = ek.hhp;
                    com_tencent_mm_protocal_c_afj.trc = ek.hhH;
                    com_tencent_mm_protocal_c_afj.tKG = ek.hhI;
                    com_tencent_mm_protocal_c_afj.muS = ek.appName;
                    com_tencent_mm_protocal_c_afj.tKH = ek.hhy;
                    com_tencent_mm_protocal_c_afj.tKI = ek.hhz;
                    com_tencent_mm_protocal_c_afj.tKJ = ek.hhF;
                    com_tencent_mm_protocal_c_afg.tKv = com_tencent_mm_protocal_c_afj;
                    com_tencent_mm_protocal_c_afg.tKu = 1;
                    break;
                }
                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
                return false;
                break;
            case 62:
                afl com_tencent_mm_protocal_c_afl = new afl();
                com_tencent_mm_protocal_c_afl.tvt = str3;
                com_tencent_mm_protocal_c_afl.jNW = i;
                com_tencent_mm_protocal_c_afl.tup = str;
                com_tencent_mm_protocal_c_afl.msj = str2;
                com_tencent_mm_protocal_c_afg.tKA = com_tencent_mm_protocal_c_afl;
                com_tencent_mm_protocal_c_afg.tKu = 6;
                break;
        }
        return true;
    }

    static String p(String str, long j) {
        InputStream openRead;
        Throwable e;
        IOException e2;
        if (str == null) {
            return null;
        }
        String substring = str.substring(0, str.lastIndexOf("/"));
        substring = substring + "/" + ("image_hd_" + str.hashCode());
        OutputStream cVar;
        try {
            cVar = new com.tencent.mm.modelsfs.c(new File(substring), j);
            try {
                openRead = FileOp.openRead(str);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (openRead.read(bArr) != -1) {
                        cVar.write(bArr);
                    }
                    try {
                        cVar.flush();
                        cVar.close();
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e3) {
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3, "", new Object[0]);
                                return null;
                            }
                        }
                        return substring;
                    } catch (Throwable e32) {
                        w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32, "", new Object[0]);
                        return null;
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    try {
                        w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e322) {
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            return null;
                        }
                        try {
                            openRead.close();
                            return null;
                        } catch (Throwable e3222) {
                            w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e3222, "", new Object[0]);
                            return null;
                        }
                    } catch (Throwable th) {
                        e3222 = th;
                        if (cVar != null) {
                            try {
                                cVar.flush();
                                cVar.close();
                            } catch (Throwable e32222) {
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e32222, "", new Object[0]);
                                return null;
                            }
                        }
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (Throwable e322222) {
                                w.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", e322222, "", new Object[0]);
                                return null;
                            }
                        }
                        throw e322222;
                    }
                }
            } catch (IOException e5) {
                e2 = e5;
                openRead = null;
                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
                if (cVar != null) {
                    cVar.flush();
                    cVar.close();
                }
                if (openRead != null) {
                    return null;
                }
                openRead.close();
                return null;
            } catch (Throwable th2) {
                e322222 = th2;
                openRead = null;
                if (cVar != null) {
                    cVar.flush();
                    cVar.close();
                }
                if (openRead != null) {
                    openRead.close();
                }
                throw e322222;
            }
        } catch (IOException e6) {
            e2 = e6;
            openRead = null;
            cVar = null;
            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "enc image error %s", new Object[]{e2.getMessage()});
            if (cVar != null) {
                cVar.flush();
                cVar.close();
            }
            if (openRead != null) {
                return null;
            }
            openRead.close();
            return null;
        } catch (Throwable th3) {
            e322222 = th3;
            openRead = null;
            cVar = null;
            if (cVar != null) {
                cVar.flush();
                cVar.close();
            }
            if (openRead != null) {
                openRead.close();
            }
            throw e322222;
        }
    }

    private String bo(long j) {
        String str = "";
        ap.yY();
        ce cA = c.wT().cA(j);
        if (cA.field_msgId == 0) {
            return "";
        }
        int i = cA.field_type;
        String str2 = cA.field_content;
        if (cA.axO()) {
            f.a ek = f.a.ek(str2);
            if (ek != null && (ek.type == 6 || ek.type == 2)) {
                com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek.fCW);
                if (LW != null) {
                    return LW.field_fileFullPath;
                }
                w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                return str;
            } else if (ek == null) {
                return str;
            } else {
                if (ek.type != 3 && ek.type != 5) {
                    return str;
                }
                this.lcu = true;
                return str;
            }
        } else if (i == 3) {
            d n = n.GS().n(cA);
            if (n == null) {
                return str;
            }
            str = n.GS().ju(n.hEZ);
            if (bg.mA(str)) {
                return n.GS().ju(n.hFb);
            }
            return str;
        } else if (i == 62) {
            o.KV();
            return s.lv(cA.field_imgPath);
        } else if (i != 48) {
            return str;
        } else {
            this.lcu = true;
            return str;
        }
    }

    public static void ap(List<b> list) {
        List arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("deviceType", ((b) list.get(i)).field_deviceType);
            hashMap.put("deviceID", ((b) list.get(i)).field_deviceID);
            hashMap.put("displayName", c((b) list.get(i)));
            hashMap.put("iconUrl", ((b) list.get(i)).iconUrl);
            hashMap.put("ability", ((b) list.get(i)).gtX);
            hashMap.put("abilityInf", ((b) list.get(i)).gtY);
            arrayList.add(hashMap);
        }
        com.tencent.mm.sdk.b.b dtVar = new dt();
        dtVar.fHE.fGQ = arrayList;
        com.tencent.mm.sdk.b.a.urY.m(dtVar);
    }

    public static void bR(String str, String str2) {
        com.tencent.mm.sdk.b.b dxVar = new dx();
        dxVar.fHP.fHR = str2;
        dxVar.fHP.fwJ = str;
        com.tencent.mm.sdk.b.a.urY.m(dxVar);
    }

    public final void aN(String str, int i) {
        com.tencent.mm.sdk.b.b dxVar = new dx();
        dxVar.fHP.fwJ = str;
        if (i >= 100) {
            dxVar.fHP.fHR = this.lcz;
        } else {
            dxVar.fHP.fHR = this.lcB;
        }
        dxVar.fHP.progress = i;
        com.tencent.mm.sdk.b.a.urY.m(dxVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
        } else if (kVar instanceof n) {
            n nVar = (n) kVar;
            if (i == 0 && i2 == 0) {
                bfq com_tencent_mm_protocal_c_bfq = (nVar.gUA == null || nVar.gUA.hsk.hsr == null) ? null : (bfq) nVar.gUA.hsk.hsr;
                String str2 = com_tencent_mm_protocal_c_bfq.ugb;
                if (1 == nVar.ldC) {
                    bR(nVar.fwJ, this.lcz);
                    return;
                }
                String str3 = nVar.fwJ;
                String str4 = (String) this.lcJ.get(str3);
                bR(str3, this.lcB);
                String bo = (!this.lcv || this.lcw == null) ? bo(this.gLE) : this.lcx;
                if (str4 == null || str4.length() == 0) {
                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
                    bR(str3, this.lcA);
                    return;
                }
                if (!this.lct) {
                    w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
                    Java2CExDevice.stopScanWCLanDevice();
                    this.lct = true;
                }
                if (!(this.lcL.containsKey(str3) && ((Boolean) this.lcL.get(str3)).booleanValue())) {
                    w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: " + str4);
                    if (Java2CExDevice.connectWCLanDevice(str4.getBytes(), true) != 0) {
                        bR(str3, this.lcA);
                        w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
                    }
                }
                int useWCLanDeviceService;
                if (this.lcu) {
                    useWCLanDeviceService = Java2CExDevice.useWCLanDeviceService(str4.getBytes(), str2.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lcV.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lcK.put(str3, Integer.valueOf(useWCLanDeviceService));
                        w.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: " + useWCLanDeviceService);
                        return;
                    }
                    bR(str3, this.lcA);
                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
                    return;
                } else if (bo == null || bo.length() == 0) {
                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
                    bR(str3, this.lcA);
                    return;
                } else {
                    useWCLanDeviceService = Java2CExDevice.sendFileToWCLanDevice(str4.getBytes(), str2.getBytes(), bo.getBytes());
                    if (useWCLanDeviceService != 0) {
                        this.lcV.put(Integer.valueOf(useWCLanDeviceService), str3);
                        this.lcK.put(str3, Integer.valueOf(useWCLanDeviceService));
                        w.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =" + useWCLanDeviceService);
                        return;
                    }
                    bR(str3, this.lcA);
                    w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
                    return;
                }
            }
            w.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            bR(nVar.fwJ, this.lcA);
        }
    }

    static String c(b bVar) {
        if (bVar == null) {
            return "";
        }
        String str = null;
        if (!bg.mA(bVar.gtR)) {
            str = bVar.gtR;
        } else if (!bg.mA(bVar.gtS)) {
            str = bVar.gtS;
        } else if (bVar.field_mac != 0) {
            str = com.tencent.mm.plugin.exdevice.j.b.bG(bVar.field_mac);
        } else if (!bg.mA(bVar.field_deviceID)) {
            str = bVar.field_deviceID;
        }
        return bg.mz(str);
    }
}
