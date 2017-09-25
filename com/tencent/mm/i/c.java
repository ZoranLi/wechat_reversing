package com.tencent.mm.i;

import android.util.SparseArray;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static final String gTi = (w.hgq + "configlist/");
    public SparseArray<d> gTh = new SparseArray();

    public static String er(int i) {
        return gTi + "config_" + i + ".xml";
    }

    public final boolean a(File file, File file2) {
        Throwable e;
        InputStream inputStream = null;
        int i = 0;
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            boolean z = false;
            while (i < listFiles.length) {
                File file3 = listFiles[i];
                z = a(file3, new File(file2.getPath(), file3.getName()));
                if (z) {
                    file.delete();
                }
                i++;
            }
            return z;
        }
        OutputStream fileOutputStream;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    file.delete();
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e2));
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e22));
                    }
                    return true;
                } catch (Exception e3) {
                    e22 = e3;
                    inputStream = fileInputStream;
                    try {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e22));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e222));
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e2222));
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e4));
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e5));
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                inputStream = fileInputStream;
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e2222));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (Exception e7) {
            e2222 = e7;
            fileOutputStream = null;
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e2222));
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            e2222 = th4;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }

    public final void init() {
        for (int load : d.gTj) {
            load(load);
        }
    }

    public final void l(int i, String str) {
        d dVar = new d(i);
        dVar.gTl = bh.q(str, "ConfigList");
        if (dVar.gTl.containsKey(".ConfigList.$version")) {
            dVar.version = Integer.valueOf((String) dVar.gTl.get(".ConfigList.$version")).intValue();
        }
        int i2 = 0;
        while (true) {
            String str2 = ".ConfigList.Config" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (dVar.gTl.get(str2 + ".$name") != null) {
                String str3 = (String) dVar.gTl.get(str2 + ".$name");
                if (!str3.equalsIgnoreCase("JDWebViewMenu")) {
                    int i3 = 0;
                    while (true) {
                        String str4 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        String str5 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$key";
                        String str6 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$lang";
                        if (!dVar.gTl.containsKey(str4)) {
                            break;
                        }
                        String str7 = (String) dVar.gTl.get(str5);
                        str4 = (String) dVar.gTl.get(str4);
                        str5 = (String) dVar.gTl.get(str6);
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ConfigListInfo", "itemKey " + str7 + " itemValue " + str4 + " itemLang " + str5);
                        if (str5 == null || d.dB(str5)) {
                            if (!dVar.gTk.containsKey(str3)) {
                                dVar.gTk.put(str3, new HashMap());
                            }
                            ((HashMap) dVar.gTk.get(str3)).put(str7, str4);
                        }
                        i3++;
                    }
                }
                i2++;
            } else {
                this.gTh.put(Integer.valueOf(i).intValue(), dVar);
                return;
            }
        }
    }

    public final String z(String str, String str2) {
        d es = es(1);
        if (es != null && es.gTk.containsKey(str)) {
            return (String) ((HashMap) es.gTk.get(str)).get(str2);
        }
        return null;
    }

    public final d es(int i) {
        if (this.gTh.get(1) == null) {
            load(1);
        }
        return (d) this.gTh.get(1);
    }

    private void load(int i) {
        InputStream fileInputStream;
        Throwable e;
        try {
            File file = new File(er(i));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    Reader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    l(i, stringBuffer.toString());
                    inputStreamReader.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e3) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e3));
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        e3 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e4));
                            }
                        }
                        throw e3;
                    }
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e32) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e32));
                }
            }
        } catch (Exception e5) {
            e32 = e5;
            fileInputStream = null;
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e32));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th2) {
            e32 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e32;
        }
    }

    public static int sF() {
        int i;
        String value = ((a) h.h(a.class)).sV().getValue("VoiceVOIPSwitch");
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ConfigListDecoder", "voip is " + value);
        try {
            i = bg.getInt(value, 0);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "exception:%s", bg.g(e));
            i = 0;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is " + i);
        return i;
    }

    public final boolean sG() {
        boolean z = true;
        if (bg.getInt(z("WebViewConfig", "disableWePkg"), 0) != 1) {
            z = false;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ConfigListDecoder", "disableWePkg : " + z);
        return z;
    }

    public final String sH() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", z("FreeWiFiConfig", "CheckURL"));
        return z("FreeWiFiConfig", "CheckURL");
    }

    public final boolean sI() {
        boolean z = true;
        if (bg.getInt(z("ShowConfig", "showRecvTmpMsgBtn"), 0) != 1) {
            z = false;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : " + z);
        return z;
    }

    public final List<String> sJ() {
        List<String> list = null;
        String z = z("IBeacon", "Content");
        if (!bg.mA(z)) {
            list = new ArrayList();
            try {
                Iterator keys = new JSONObject(z.replace(",}", "}")).keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null) {
                        list.add(next.toString());
                    }
                }
            } catch (JSONException e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + e.getMessage());
            }
        }
        return list;
    }

    public final String sK() {
        return z("MailApp", "MailAppRedirectUrAndroid");
    }

    public final String getMailAppEnterUlAndroid() {
        return z("MailApp", "MailAppEnterMailAppUrlAndroid");
    }
}
