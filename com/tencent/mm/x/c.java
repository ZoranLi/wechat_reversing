package com.tencent.mm.x;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afw;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class c implements e {
    public boolean hqI = false;
    public Set<String> hqJ = new HashSet();
    f<String, c> hqK = new f(400);
    public Stack<h> hqL = new Stack();
    private ar hqM = null;
    private ar hqN = null;
    public String hqO = null;
    f<String, String> hqP = new f(m.CTRL_INDEX);
    public aj hqQ = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c hqS;
        private long hqT = 0;

        {
            this.hqS = r3;
        }

        public final boolean oQ() {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.hqS.hqI && currentTimeMillis - this.hqT > 60000) {
                w.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.hqT));
                this.hqS.hqI = false;
            }
            if (this.hqS.hqI) {
                this.hqS.hqQ.v(1000, 1000);
                return false;
            }
            this.hqT = currentTimeMillis;
            this.hqS.hqI = true;
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 5 && this.hqS.hqL.size() > 0; i++) {
                g.oUh.a(138, 42, 1, true);
                linkedList.add(new avx().OV(((h) this.hqS.hqL.pop()).getUsername()));
            }
            h.vd().a(new j(linkedList), 0);
            g.oUh.a(138, 44, 1, true);
            return false;
        }
    }, false);

    private static class c {
        public long hnT = 0;
        public int hqX = 0;
    }

    private class a implements com.tencent.mm.sdk.platformtools.ar.a {
        final /* synthetic */ c hqS;
        public h hqU = null;
        public byte[] hqV = null;

        public a(c cVar, h hVar) {
            this.hqS = cVar;
            this.hqU = hVar;
        }

        public final boolean Bn() {
            t tVar;
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            ProtocolException protocolException;
            g gVar;
            Object[] objArr;
            SocketTimeoutException socketTimeoutException;
            IOException iOException;
            Exception exception;
            if (this.hqU == null) {
                return false;
            }
            String Bt = this.hqU.Bt();
            String str = "";
            if (h.vG().uV()) {
                r1 = new Object[4];
                h.vG();
                r1[1] = o.getString(com.tencent.mm.kernel.a.uH());
                r1[2] = Integer.valueOf(am.getNetTypeForStat(ab.getContext()));
                r1[3] = Integer.valueOf(am.getStrength(ab.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r1);
            }
            w.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", this.hqU.getUsername(), str);
            this.hqV = null;
            t tVar2 = null;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            InputStream inputStream2 = null;
            g.oUh.a(138, 40, 1, true);
            try {
                tVar2 = com.tencent.mm.network.b.a(Bt, null);
                try {
                    tVar2.setRequestMethod("GET");
                    tVar2.setRequestProperty("referer", str);
                    tVar2.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
                    tVar2.setReadTimeout(Downloads.MIN_RETYR_AFTER);
                    if (com.tencent.mm.network.b.a(tVar2) != 0) {
                        int responseCode = tVar2.getResponseCode();
                        Map headerFields = tVar2.getHeaderFields();
                        List list = headerFields != null ? (List) headerFields.get("X-ErrNo") : null;
                        str = (list == null || list.size() <= 0) ? "" : (String) list.get(0);
                        w.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", Bt, Integer.valueOf(responseCode), str);
                        switch (responseCode) {
                            case TencentLocation.ERROR_UNKNOWN /*404*/:
                                g.oUh.a(138, 2, 1, true);
                                g.oUh.i(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hqU.getUsername(), tVar2.ifa, Integer.valueOf(tVar2.iee), tVar2.url.getHost(), Bt, str);
                                break;
                            case 502:
                                g.oUh.a(138, 3, 1, true);
                                g.oUh.i(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hqU.getUsername(), tVar2.ifa, Integer.valueOf(tVar2.iee), tVar2.url.getHost(), Bt, str);
                                break;
                            case 503:
                                g.oUh.a(138, 4, 1, true);
                                g.oUh.i(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hqU.getUsername(), tVar2.ifa, Integer.valueOf(tVar2.iee), tVar2.url.getHost(), Bt, str);
                                break;
                            case 504:
                                g.oUh.a(138, 5, 1, true);
                                g.oUh.i(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hqU.getUsername(), tVar2.ifa, Integer.valueOf(tVar2.iee), tVar2.url.getHost(), Bt, str);
                                break;
                            default:
                                g.oUh.a(138, 6, 1, true);
                                g.oUh.i(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hqU.getUsername(), tVar2.ifa, Integer.valueOf(tVar2.iee), tVar2.url.getHost(), Bt, str);
                                break;
                        }
                        return true;
                    }
                    int contentLength = tVar2.ieZ.getContentLength();
                    inputStream2 = tVar2.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            w.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", Bt);
                            return true;
                        } catch (ProtocolException e) {
                            tVar = tVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            protocolException = e;
                            g.oUh.a(138, 1, 1, true);
                            gVar = g.oUh;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE);
                            objArr[2] = protocolException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hqU.getUsername();
                            if (tVar != null) {
                                str = "null";
                            } else {
                                str = tVar.ifa;
                            }
                            objArr[5] = str;
                            objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                            objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                            objArr[8] = Bt;
                            objArr[9] = "";
                            gVar.i(14058, objArr);
                            w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                            if (tVar != null) {
                                try {
                                    tVar.ieZ.disconnect();
                                } catch (Throwable e2) {
                                    w.e("MicroMsg.HttpGetAvatar", "exception:%s", bg.g(e2));
                                    w.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", e2.getMessage());
                                    g.oUh.a(138, 9, 1, true);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (SocketTimeoutException e3) {
                            tVar = tVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            socketTimeoutException = e3;
                            g.oUh.a(138, 8, 1, true);
                            gVar = g.oUh;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO);
                            objArr[2] = socketTimeoutException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hqU.getUsername();
                            if (tVar != null) {
                                str = "null";
                            } else {
                                str = tVar.ifa;
                            }
                            objArr[5] = str;
                            objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                            objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                            objArr[8] = Bt;
                            objArr[9] = "";
                            gVar.i(14058, objArr);
                            w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                            if (tVar != null) {
                                tVar.ieZ.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (IOException e4) {
                            tVar = tVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            iOException = e4;
                            g.oUh.a(138, 7, 1, true);
                            gVar = g.oUh;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = iOException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hqU.getUsername();
                            if (tVar != null) {
                                str = "null";
                            } else {
                                str = tVar.ifa;
                            }
                            objArr[5] = str;
                            objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                            objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                            objArr[8] = Bt;
                            objArr[9] = "";
                            gVar.i(14058, objArr);
                            w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, iOException.getClass().getSimpleName(), iOException.getMessage());
                            if (tVar != null) {
                                tVar.ieZ.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (Exception e5) {
                            tVar = tVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            exception = e5;
                            g.oUh.a(138, 0, 1, true);
                            gVar = g.oUh;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = exception.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hqU.getUsername();
                            if (tVar != null) {
                                str = "null";
                            } else {
                                str = tVar.ifa;
                            }
                            objArr[5] = str;
                            if (tVar != null) {
                                str = "null";
                            } else {
                                str = Integer.valueOf(tVar.iee);
                            }
                            objArr[6] = str;
                            if (tVar != null) {
                                str = "null";
                            } else {
                                str = tVar.url.getHost();
                            }
                            objArr[7] = str;
                            objArr[8] = Bt;
                            objArr[9] = "";
                            gVar.i(14058, objArr);
                            w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, exception.getClass().getSimpleName(), exception.getMessage());
                            if (tVar != null) {
                                tVar.ieZ.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    g.oUh.a(138, 41, 1, true);
                    if (com.tencent.mm.sdk.a.b.bIu()) {
                        g.oUh.i(14058, Integer.valueOf(100001), Integer.valueOf(20000), "", Integer.valueOf(contentLength), this.hqU.getUsername(), tVar2.ifa, Integer.valueOf(tVar2.iee), tVar2.url.getHost(), Bt, "");
                    }
                    this.hqV = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.close();
                    try {
                        tVar2.ieZ.disconnect();
                    } catch (ProtocolException e6) {
                        tVar = tVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        protocolException = e6;
                        g.oUh.a(138, 1, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE);
                        objArr[2] = protocolException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = tVar.ifa;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                        }
                        objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                        if (tVar != null) {
                        }
                        objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (SocketTimeoutException e32) {
                        tVar = tVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        socketTimeoutException = e32;
                        g.oUh.a(138, 8, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO);
                        objArr[2] = socketTimeoutException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = tVar.ifa;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                        }
                        objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                        if (tVar != null) {
                        }
                        objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (IOException e42) {
                        tVar = tVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        iOException = e42;
                        g.oUh.a(138, 7, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = iOException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = tVar.ifa;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                        }
                        objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                        if (tVar != null) {
                        }
                        objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, iOException.getClass().getSimpleName(), iOException.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (Exception e52) {
                        tVar = tVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        exception = e52;
                        g.oUh.a(138, 0, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = exception.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = tVar.ifa;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                            str = Integer.valueOf(tVar.iee);
                        } else {
                            str = "null";
                        }
                        objArr[6] = str;
                        if (tVar != null) {
                            str = tVar.url.getHost();
                        } else {
                            str = "null";
                        }
                        objArr[7] = str;
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, exception.getClass().getSimpleName(), exception.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    }
                    try {
                        inputStream2.close();
                        if (contentLength > 0) {
                            try {
                                if (this.hqV.length < contentLength) {
                                    g.oUh.a(138, 15, 1, true);
                                    w.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
                                }
                            } catch (ProtocolException e62) {
                                tVar = null;
                                byteArrayOutputStream = null;
                                inputStream = null;
                                protocolException = e62;
                                g.oUh.a(138, 1, 1, true);
                                gVar = g.oUh;
                                objArr = new Object[10];
                                objArr[0] = Integer.valueOf(100001);
                                objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE);
                                objArr[2] = protocolException.getMessage();
                                objArr[3] = Integer.valueOf(0);
                                objArr[4] = this.hqU.getUsername();
                                if (tVar != null) {
                                    str = tVar.ifa;
                                } else {
                                    str = "null";
                                }
                                objArr[5] = str;
                                if (tVar != null) {
                                }
                                objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                                if (tVar != null) {
                                }
                                objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                                objArr[8] = Bt;
                                objArr[9] = "";
                                gVar.i(14058, objArr);
                                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                                if (tVar != null) {
                                    tVar.ieZ.disconnect();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return true;
                            } catch (SocketTimeoutException e322) {
                                tVar = null;
                                byteArrayOutputStream = null;
                                inputStream = null;
                                socketTimeoutException = e322;
                                g.oUh.a(138, 8, 1, true);
                                gVar = g.oUh;
                                objArr = new Object[10];
                                objArr[0] = Integer.valueOf(100001);
                                objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO);
                                objArr[2] = socketTimeoutException.getMessage();
                                objArr[3] = Integer.valueOf(0);
                                objArr[4] = this.hqU.getUsername();
                                if (tVar != null) {
                                    str = tVar.ifa;
                                } else {
                                    str = "null";
                                }
                                objArr[5] = str;
                                if (tVar != null) {
                                }
                                objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                                if (tVar != null) {
                                }
                                objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                                objArr[8] = Bt;
                                objArr[9] = "";
                                gVar.i(14058, objArr);
                                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                                if (tVar != null) {
                                    tVar.ieZ.disconnect();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return true;
                            } catch (IOException e422) {
                                tVar = null;
                                byteArrayOutputStream = null;
                                inputStream = null;
                                iOException = e422;
                                g.oUh.a(138, 7, 1, true);
                                gVar = g.oUh;
                                objArr = new Object[10];
                                objArr[0] = Integer.valueOf(100001);
                                objArr[1] = Integer.valueOf(10003);
                                objArr[2] = iOException.getMessage();
                                objArr[3] = Integer.valueOf(0);
                                objArr[4] = this.hqU.getUsername();
                                if (tVar != null) {
                                    str = tVar.ifa;
                                } else {
                                    str = "null";
                                }
                                objArr[5] = str;
                                if (tVar != null) {
                                }
                                objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                                if (tVar != null) {
                                }
                                objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                                objArr[8] = Bt;
                                objArr[9] = "";
                                gVar.i(14058, objArr);
                                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, iOException.getClass().getSimpleName(), iOException.getMessage());
                                if (tVar != null) {
                                    tVar.ieZ.disconnect();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return true;
                            } catch (Exception e522) {
                                tVar = null;
                                byteArrayOutputStream = null;
                                inputStream = null;
                                exception = e522;
                                g.oUh.a(138, 0, 1, true);
                                gVar = g.oUh;
                                objArr = new Object[10];
                                objArr[0] = Integer.valueOf(100001);
                                objArr[1] = Integer.valueOf(10003);
                                objArr[2] = exception.getMessage();
                                objArr[3] = Integer.valueOf(0);
                                objArr[4] = this.hqU.getUsername();
                                if (tVar != null) {
                                    str = tVar.ifa;
                                } else {
                                    str = "null";
                                }
                                objArr[5] = str;
                                if (tVar != null) {
                                    str = Integer.valueOf(tVar.iee);
                                } else {
                                    str = "null";
                                }
                                objArr[6] = str;
                                if (tVar != null) {
                                    str = tVar.url.getHost();
                                } else {
                                    str = "null";
                                }
                                objArr[7] = str;
                                objArr[8] = Bt;
                                objArr[9] = "";
                                gVar.i(14058, objArr);
                                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, exception.getClass().getSimpleName(), exception.getMessage());
                                if (tVar != null) {
                                    tVar.ieZ.disconnect();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return true;
                            }
                        }
                        tVar = null;
                        byteArrayOutputStream = null;
                        inputStream = null;
                    } catch (ProtocolException e622) {
                        tVar = null;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        protocolException = e622;
                        g.oUh.a(138, 1, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE);
                        objArr[2] = protocolException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = "null";
                        } else {
                            str = tVar.ifa;
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                        }
                        objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                        if (tVar != null) {
                        }
                        objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (SocketTimeoutException e3222) {
                        tVar = null;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        socketTimeoutException = e3222;
                        g.oUh.a(138, 8, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO);
                        objArr[2] = socketTimeoutException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = "null";
                        } else {
                            str = tVar.ifa;
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                        }
                        objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                        if (tVar != null) {
                        }
                        objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (IOException e4222) {
                        tVar = null;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        iOException = e4222;
                        g.oUh.a(138, 7, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = iOException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = "null";
                        } else {
                            str = tVar.ifa;
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                        }
                        objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                        if (tVar != null) {
                        }
                        objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, iOException.getClass().getSimpleName(), iOException.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (Exception e5222) {
                        tVar = null;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        exception = e5222;
                        g.oUh.a(138, 0, 1, true);
                        gVar = g.oUh;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = exception.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hqU.getUsername();
                        if (tVar != null) {
                            str = "null";
                        } else {
                            str = tVar.ifa;
                        }
                        objArr[5] = str;
                        if (tVar != null) {
                            str = "null";
                        } else {
                            str = Integer.valueOf(tVar.iee);
                        }
                        objArr[6] = str;
                        if (tVar != null) {
                            str = "null";
                        } else {
                            str = tVar.url.getHost();
                        }
                        objArr[7] = str;
                        objArr[8] = Bt;
                        objArr[9] = "";
                        gVar.i(14058, objArr);
                        w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, exception.getClass().getSimpleName(), exception.getMessage());
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    }
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (ProtocolException e6222) {
                    tVar = tVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    protocolException = e6222;
                    g.oUh.a(138, 1, 1, true);
                    gVar = g.oUh;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE);
                    objArr[2] = protocolException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hqU.getUsername();
                    if (tVar != null) {
                        str = "null";
                    } else {
                        str = tVar.ifa;
                    }
                    objArr[5] = str;
                    if (tVar != null) {
                    }
                    objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                    if (tVar != null) {
                    }
                    objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                    objArr[8] = Bt;
                    objArr[9] = "";
                    gVar.i(14058, objArr);
                    w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (SocketTimeoutException e32222) {
                    tVar = tVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    socketTimeoutException = e32222;
                    g.oUh.a(138, 8, 1, true);
                    gVar = g.oUh;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO);
                    objArr[2] = socketTimeoutException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hqU.getUsername();
                    if (tVar != null) {
                        str = "null";
                    } else {
                        str = tVar.ifa;
                    }
                    objArr[5] = str;
                    if (tVar != null) {
                    }
                    objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                    if (tVar != null) {
                    }
                    objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                    objArr[8] = Bt;
                    objArr[9] = "";
                    gVar.i(14058, objArr);
                    w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (IOException e42222) {
                    tVar = tVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    iOException = e42222;
                    g.oUh.a(138, 7, 1, true);
                    gVar = g.oUh;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10003);
                    objArr[2] = iOException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hqU.getUsername();
                    if (tVar != null) {
                        str = "null";
                    } else {
                        str = tVar.ifa;
                    }
                    objArr[5] = str;
                    if (tVar != null) {
                    }
                    objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                    if (tVar != null) {
                    }
                    objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                    objArr[8] = Bt;
                    objArr[9] = "";
                    gVar.i(14058, objArr);
                    w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, iOException.getClass().getSimpleName(), iOException.getMessage());
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (Exception e52222) {
                    tVar = tVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    exception = e52222;
                    g.oUh.a(138, 0, 1, true);
                    gVar = g.oUh;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10003);
                    objArr[2] = exception.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hqU.getUsername();
                    if (tVar != null) {
                        str = "null";
                    } else {
                        str = tVar.ifa;
                    }
                    objArr[5] = str;
                    if (tVar != null) {
                        str = "null";
                    } else {
                        str = Integer.valueOf(tVar.iee);
                    }
                    objArr[6] = str;
                    if (tVar != null) {
                        str = "null";
                    } else {
                        str = tVar.url.getHost();
                    }
                    objArr[7] = str;
                    objArr[8] = Bt;
                    objArr[9] = "";
                    gVar.i(14058, objArr);
                    w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, exception.getClass().getSimpleName(), exception.getMessage());
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                }
            } catch (ProtocolException e62222) {
                tVar = tVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                protocolException = e62222;
                g.oUh.a(138, 1, 1, true);
                gVar = g.oUh;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE);
                objArr[2] = protocolException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hqU.getUsername();
                if (tVar != null) {
                    str = tVar.ifa;
                } else {
                    str = "null";
                }
                objArr[5] = str;
                if (tVar != null) {
                }
                objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                if (tVar != null) {
                }
                objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                objArr[8] = Bt;
                objArr[9] = "";
                gVar.i(14058, objArr);
                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                if (tVar != null) {
                    tVar.ieZ.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (SocketTimeoutException e322222) {
                tVar = tVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                socketTimeoutException = e322222;
                g.oUh.a(138, 8, 1, true);
                gVar = g.oUh;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO);
                objArr[2] = socketTimeoutException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hqU.getUsername();
                if (tVar != null) {
                    str = tVar.ifa;
                } else {
                    str = "null";
                }
                objArr[5] = str;
                if (tVar != null) {
                }
                objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                if (tVar != null) {
                }
                objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                objArr[8] = Bt;
                objArr[9] = "";
                gVar.i(14058, objArr);
                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                if (tVar != null) {
                    tVar.ieZ.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (IOException e422222) {
                tVar = tVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                iOException = e422222;
                g.oUh.a(138, 7, 1, true);
                gVar = g.oUh;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = iOException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hqU.getUsername();
                if (tVar != null) {
                    str = tVar.ifa;
                } else {
                    str = "null";
                }
                objArr[5] = str;
                if (tVar != null) {
                }
                objArr[6] = tVar != null ? "null" : Integer.valueOf(tVar.iee);
                if (tVar != null) {
                }
                objArr[7] = tVar != null ? "null" : tVar.url.getHost();
                objArr[8] = Bt;
                objArr[9] = "";
                gVar.i(14058, objArr);
                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, iOException.getClass().getSimpleName(), iOException.getMessage());
                if (tVar != null) {
                    tVar.ieZ.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (Exception e522222) {
                tVar = tVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                exception = e522222;
                g.oUh.a(138, 0, 1, true);
                gVar = g.oUh;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = exception.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hqU.getUsername();
                if (tVar != null) {
                    str = tVar.ifa;
                } else {
                    str = "null";
                }
                objArr[5] = str;
                if (tVar != null) {
                    str = Integer.valueOf(tVar.iee);
                } else {
                    str = "null";
                }
                objArr[6] = str;
                if (tVar != null) {
                    str = tVar.url.getHost();
                } else {
                    str = "null";
                }
                objArr[7] = str;
                objArr[8] = Bt;
                objArr[9] = "";
                gVar.i(14058, objArr);
                w.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Bt, exception.getClass().getSimpleName(), exception.getMessage());
                if (tVar != null) {
                    tVar.ieZ.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            }
        }

        public final boolean Bo() {
            if (!(this.hqU == null || bg.mA(this.hqU.getUsername()))) {
                if (bg.bm(this.hqV)) {
                    this.hqS.hqJ.remove(this.hqU.getUsername());
                    g.oUh.a(138, 10, 1, true);
                } else {
                    if (com.tencent.mm.u.ag.a.hlT != null) {
                        com.tencent.mm.u.ag.a.hlT.aH(this.hqV.length, 0);
                    }
                    this.hqS.a(new d(this.hqS, this.hqU, this.hqV));
                }
            }
            return false;
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.ar.a {
        final /* synthetic */ c hqS;
        Bitmap hqW = null;
        String username = null;

        public b(c cVar, String str) {
            this.hqS = cVar;
            this.username = str;
        }

        public final boolean Bn() {
            h hVar = null;
            int i = 0;
            if (bg.mA(this.username)) {
                return false;
            }
            String str = this.username;
            if (str == null ? false : str.startsWith("ammURL_")) {
                String str2 = (String) this.hqS.hqP.get(str);
                if (!bg.mA(str2)) {
                    h hs = n.Bm().hs(str);
                    if (hs == null || !str.equals(hs.getUsername())) {
                        Cursor a = n.Bm().hnH.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bg.my(str2) + "\"", null, 2);
                        if (a != null) {
                            if (a.moveToFirst()) {
                                a.moveToFirst();
                                hVar = new h();
                                hVar.b(a);
                            }
                            a.close();
                        }
                        if (!(hVar == null || bg.mA(hVar.getUsername()))) {
                            FileOp.p(b.hd(hVar.getUsername()), b.hd(str));
                        }
                        hVar = new h();
                        hVar.username = str;
                        hVar.gkq = 3;
                        hVar.hrA = str2;
                        hVar.hrB = str2;
                        hVar.fRW = 3;
                        hVar.aV(true);
                        hVar.fRW = 31;
                        n.Bm().a(hVar);
                    }
                }
            }
            d Bl = c.Bl();
            if (Bl == null) {
                return false;
            }
            if (d.hrb.containsKey(this.username)) {
                i = ((Integer) d.hrb.get(this.username)).intValue();
            }
            if (i != 0) {
                n.Bx();
                Context context = n.getContext();
                if (context != null) {
                    Bl.d(this.username, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i));
                }
            }
            this.hqW = d.hk(this.username);
            return true;
        }

        public final boolean Bo() {
            if (this.hqW == null) {
                h hVar;
                c cVar = this.hqS;
                String str = this.username;
                w.d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (bg.mA(str)) {
                    hVar = null;
                } else if (str.equals(cVar.hqO + "@bottle") && !bg.b((Boolean) h.vI().vr().get(60, null), false)) {
                    hVar = null;
                } else if (!str.equals(cVar.hqO) || bg.b((Boolean) h.vI().vr().get(59, null), false)) {
                    long Ny = bg.Ny();
                    c cVar2 = (c) cVar.hqK.get(str);
                    if (cVar2 == null || cVar2.hqX < 5 || Ny - cVar2.hnT >= 600) {
                        h hh = c.hh(str);
                        if (hh == null) {
                            w.w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            cVar2 = new c();
                            cVar2.hqX = 5;
                            cVar2.hnT = Ny;
                            cVar.hqK.k(str, cVar2);
                            hVar = null;
                        } else {
                            if (cVar2 == null || Ny - cVar2.hnT > 600) {
                                w.d("MicroMsg.AvatarService", "new user: %s", str);
                                cVar2 = new c();
                                cVar2.hqX = 1;
                                cVar2.hnT = Ny;
                                cVar.hqK.k(str, cVar2);
                            } else if (cVar2.hqX < 5) {
                                w.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(cVar2.hqX), Long.valueOf(Ny - cVar2.hnT));
                                cVar2.hqX++;
                                cVar2.hnT = Ny;
                                cVar.hqK.k(str, cVar2);
                            }
                            hVar = hh;
                        }
                    } else {
                        w.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        hVar = null;
                    }
                } else {
                    hVar = null;
                }
                if (hVar == null) {
                    cVar.hqJ.remove(str);
                } else if (bg.mA(hVar.Bt())) {
                    w.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(hVar.gkq));
                    if (4 == hVar.gkq) {
                        w.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else {
                        cVar.hqL.push(hVar);
                        if (cVar.hqL.size() > 5) {
                            cVar.hqQ.v(0, 0);
                        } else {
                            cVar.hqQ.v(1000, 1000);
                        }
                    }
                } else {
                    cVar.a(new a(cVar, hVar));
                }
                return false;
            }
            d Bl = c.Bl();
            if (Bl != null) {
                Bl.c(this.username, this.hqW);
            }
            this.hqS.hqJ.remove(this.username);
            return false;
        }
    }

    private class d implements com.tencent.mm.sdk.platformtools.ar.a {
        Bitmap bitmap = null;
        byte[] buf;
        final /* synthetic */ c hqS;
        h hqY = null;

        public d(c cVar, h hVar, byte[] bArr) {
            this.hqS = cVar;
            this.hqY = hVar;
            this.buf = bArr;
        }

        public final boolean Bn() {
            if (this.hqY == null || bg.mA(this.hqY.getUsername())) {
                w.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                g.oUh.a(138, 13, 1, true);
                return false;
            }
            if (c.Bl() != null) {
                this.bitmap = d.f(this.hqY.getUsername(), this.buf);
                if (this.bitmap == null) {
                    g.oUh.a(138, 14, 1, true);
                }
            }
            i Bm = c.Bm();
            if (Bm == null) {
                return true;
            }
            this.hqY.fRW = -1;
            this.hqY.Bu();
            Bm.a(this.hqY);
            return true;
        }

        public final boolean Bo() {
            if (!bg.mA(this.hqY.getUsername())) {
                d Bl = c.Bl();
                if (!(Bl == null || this.bitmap == null)) {
                    Bl.c(this.hqY.getUsername(), this.bitmap);
                }
                this.hqS.hqJ.remove(this.hqY.getUsername());
            }
            return false;
        }
    }

    public c() {
        h.vd().a(123, (e) this);
        this.hqI = false;
        this.hqO = com.tencent.mm.u.m.xL();
    }

    public final Bitmap b(String str, boolean z, int i) {
        Bitmap bitmap;
        d Bl = Bl();
        if (Bl != null) {
            if (i < 0 || i <= 5) {
                bitmap = null;
            } else {
                bitmap = d.hj(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}));
                if (bitmap != null) {
                    w.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i));
                    return bitmap;
                }
                w.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i));
            }
            if (bitmap == null) {
                bitmap = d.hj(str);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (i < 0 || i <= 5) {
                return bitmap;
            }
            w.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i));
            bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) i);
            Bl.c(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}), bitmap);
            return bitmap;
        } else if (z) {
            return null;
        } else {
            w.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.hqJ.contains(str)) {
                return null;
            }
            this.hqJ.add(str);
            a(new b(this, str));
            return null;
        }
    }

    public final void hf(String str) {
        a(new b(this, str));
    }

    public final void hg(final String str) {
        h.vL().D(new Runnable(this) {
            final /* synthetic */ c hqS;

            public final void run() {
                if (!bg.mA(str) && !str.equals(this.hqS.hqO)) {
                    i Bm = c.Bm();
                    if (Bm != null) {
                        h hs = Bm.hs(str);
                        if (hs != null && hs.getUsername().equals(str)) {
                            boolean z;
                            if (bg.Ny() - (((long) hs.hrD) * 60) > 86400) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                return;
                            }
                            if (bg.mA(hs.Bt())) {
                                w.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                            } else if (c.Bl() != null) {
                                d.s(str, false);
                                d.s(str, true);
                                this.hqS.hf(str);
                            }
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|checkAvatarExpire";
            }
        });
    }

    static h hh(String str) {
        h hs = n.Bm().hs(str);
        if (hs != null && hs.getUsername().equals(str)) {
            return hs;
        }
        af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str);
        if (Rc == null || !Rc.field_username.equals(str)) {
            boolean z;
            String str2 = "MicroMsg.AvatarService";
            String str3 = "ct == null? :%s";
            Object[] objArr = new Object[2];
            if (Rc == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            w.d(str2, str3, objArr);
            return null;
        } else if (Rc.gkq == 4) {
            b.u(str, Rc.gkq);
            w.d("MicroMsg.AvatarService", "ct imgFlag :%s", Integer.valueOf(Rc.gkq));
            return null;
        } else {
            hs = new h();
            hs.username = str;
            hs.gkq = 3;
            byte[] Rg = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rg(str);
            if (bg.bm(Rg)) {
                return hs;
            }
            h a;
            try {
                a = b.a(str, (ame) new ame().aD(Rg));
            } catch (Throwable e) {
                w.e("MicroMsg.AvatarService", "exception:%s", bg.g(e));
                a = hs;
            }
            return a;
        }
    }

    public final void cancel() {
        while (this.hqL.size() > 0) {
            this.hqJ.remove(this.hqL.pop());
        }
    }

    public final int a(com.tencent.mm.sdk.platformtools.ar.a aVar) {
        if (aVar instanceof a) {
            if (this.hqM == null) {
                this.hqM = new ar(1, "getavatar", 2, h.vL().nJF.getLooper());
            }
            return this.hqM.c(aVar);
        }
        if (this.hqN == null) {
            this.hqN = new ar(1, "readsave", 1, h.vL().nJF.getLooper());
        }
        return this.hqN.c(aVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 123) {
            if (!(i == 0 && i2 == 0)) {
                g.oUh.a(138, 12, 1, true);
            }
            g.oUh.a(138, 45, 1, true);
            j jVar = (j) kVar;
            Set hashSet = new HashSet();
            if (jVar.hrG != null) {
                Iterator it = jVar.hrG.iterator();
                while (it.hasNext()) {
                    afw com_tencent_mm_protocal_c_afw = (afw) it.next();
                    String str2 = com_tencent_mm_protocal_c_afw.tKZ.tZr;
                    if (com_tencent_mm_protocal_c_afw.tfh == null || com_tencent_mm_protocal_c_afw.tfh.tZp == null || com_tencent_mm_protocal_c_afw.tfh.tZp.sYA == null) {
                        g.oUh.a(138, 11, 1, true);
                    } else {
                        hashSet.add(str2);
                        h hVar = new h();
                        hVar.username = str2;
                        hVar.gkq = 3;
                        g.oUh.a(138, 43, 1, true);
                        a(new d(this, hVar, com_tencent_mm_protocal_c_afw.tfh.tZp.sYA));
                    }
                }
            }
            if (jVar.hrF != null) {
                Iterator it2 = jVar.hrF.iterator();
                while (it2.hasNext()) {
                    String str3 = ((avx) it2.next()).tZr;
                    if (!hashSet.contains(str3)) {
                        this.hqJ.remove(str3);
                    }
                }
            }
            this.hqI = false;
            if (this.hqL.size() > 0) {
                this.hqQ.v(0, 0);
            }
        }
    }

    public static d Bl() {
        if (h.vG().uV()) {
            return n.Bl();
        }
        return null;
    }

    public static i Bm() {
        if (h.vG().uV()) {
            return n.Bm();
        }
        return null;
    }

    public final String hi(String str) {
        if (bg.mA(str)) {
            return "";
        }
        String format;
        try {
            format = String.format("%s%x_%s", new Object[]{"ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4)});
        } catch (Exception e) {
            format = String.format("%s%x_", new Object[]{"ammURL_", Integer.valueOf(str.hashCode())});
        }
        this.hqP.put(format, str);
        return format;
    }
}
