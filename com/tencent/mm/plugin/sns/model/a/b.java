package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.c;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class b extends k<String, Integer, Integer> {
    private static HashSet<String> pYV = new HashSet();
    private long dnsCostTime = -1;
    private int fEX = -1;
    protected alh fVV = null;
    private String host = "";
    private int iee = -1;
    protected a pYB;
    protected n pYC = null;
    protected a pYD = null;
    private String pYE = "";
    private String pYF = "";
    private String pYG = "";
    private int pYH = 0;
    protected int pYI = 0;
    private long pYJ = -1;
    protected long pYK = -1;
    protected long pYL = -1;
    protected long pYM = -1;
    protected String pYN = "";
    protected PString pYO = new PString();
    protected int pYP;
    protected long pYQ;
    protected long pYR;
    protected long pYS;
    private int pYT = 0;
    protected int pYU = 0;
    private Map<String, List<String>> pYW;
    int pYX = 0;

    public interface a {
        void a(int i, alh com_tencent_mm_protocal_c_alh, int i2, boolean z, String str, int i3);
    }

    public abstract boolean a(InputStream inputStream, Map<String, List<String>> map);

    public abstract boolean bfx();

    protected abstract int bfy();

    public final /* synthetic */ Object bed() {
        return bfz();
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        super.onPostExecute(num);
        if (this.pYD != null) {
            w.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[]{num, this.pYD.url, this.pYD.mediaId, Integer.valueOf(this.pYT), Integer.valueOf(pYV.size())});
            pYV.remove(this.pYD.pTX);
            if (this.pYD.pYx && num.intValue() != 2) {
                au.Fv(this.pYD.mediaId);
                if (!ae.beu()) {
                    System.currentTimeMillis();
                    if (this.pYD.pQM.pQS == 4) {
                        w.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                        this.pYC = com.tencent.mm.plugin.sns.lucky.a.a.dq(this.pYD.getPath() + i.e(this.fVV), this.pYD.getPath() + i.g(this.fVV));
                        ae.beI().a(this.pYD.mediaId, this.pYC, this.pYD.pQM.pQS);
                    } else if (this.pYD.pQM.pQS == 5) {
                        w.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                        this.pYC = com.tencent.mm.plugin.sns.lucky.a.a.dq(this.pYD.getPath() + i.e(this.fVV), this.pYD.getPath() + i.h(this.fVV));
                        ae.beI().a(this.pYD.mediaId, this.pYC, this.pYD.pQM.pQS);
                    } else if (this.pYD.pQM.fRK.size() <= 1) {
                        ae.beI().a(this.pYD.mediaId, this.pYC, this.pYD.pQM.pQS);
                    } else {
                        ae.beI().a(this.pYD.mediaId, this.pYC, 0);
                        List linkedList = new LinkedList();
                        int i = 0;
                        while (i < this.pYD.pQM.fRK.size() && i < 4) {
                            alh com_tencent_mm_protocal_c_alh = (alh) this.pYD.pQM.fRK.get(i);
                            g beI = ae.beI();
                            n nVar = beI.pSR == null ? null : (n) beI.pSR.get("0-" + com_tencent_mm_protocal_c_alh.mQY);
                            if (!i.a(nVar)) {
                                break;
                            }
                            linkedList.add(nVar);
                            w.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + nVar + " " + com_tencent_mm_protocal_c_alh.mQY);
                            i++;
                        }
                        this.pYC = n.g(i.h(linkedList, ae.beS()));
                        w.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.pYD.pQM.nif + " " + this.pYC);
                        ae.beI().a(this.pYD.pQM.nif, this.pYC, this.pYD.pQM.pQS);
                    }
                    String str = null;
                    if (this.pYD.pQM.pQS == 0) {
                        str = "0-" + this.pYD.pQM.nif;
                    } else if (this.pYD.pQM.pQS == 1) {
                        str = "1-" + this.pYD.pQM.nif;
                    } else if (this.pYD.pQM.pQS == 4) {
                        str = "4-" + this.pYD.pQM.nif;
                    } else if (this.pYD.pQM.pQS == 5) {
                        str = "5-" + this.pYD.pQM.nif;
                    }
                    ae.beI().Fa(str);
                }
            } else if (!this.pYD.pYx && this.pYD.pYz == 4) {
                ae.beI().ds(this.pYD.mediaId, this.pYD.getPath() + i.j(this.fVV));
            }
            this.pYB.a(num.intValue(), this.fVV, this.pYD.pYz, this.pYD.pYx, this.pYD.pTX, this.pYT);
        }
    }

    public static boolean FJ(String str) {
        if (pYV.contains(i.ao(1, str)) || pYV.contains(i.ao(5, str))) {
            return true;
        }
        return false;
    }

    public b(a aVar, a aVar2) {
        this.pYB = aVar;
        this.pYD = aVar2;
        if (aVar2 != null) {
            this.fVV = aVar2.pTY;
            pYV.add(aVar2.pTX);
            aVar2.init();
        }
    }

    public boolean bfw() {
        return true;
    }

    public String FK(String str) {
        return str;
    }

    public t b(t tVar) {
        return tVar;
    }

    protected static boolean a(int i, long j, PString pString) {
        if (System.currentTimeMillis() - j < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", new Object[]{Long.valueOf(r2 / 1000), Integer.valueOf(i)});
        return true;
    }

    private static boolean a(an anVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (anVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || anVar.cIm == 0 || bg.az((long) anVar.cIm) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    private Integer bfz() {
        h.vJ();
        if (!h.vI().isSDCardAvailable() || this.pYD == null) {
            hl(false);
            return Integer.valueOf(2);
        }
        if (bfw()) {
            w.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", new Object[]{this.pYD.pTT + this.pYD.bfv()});
            FileOp.deleteFile(r0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.pYM = System.currentTimeMillis();
        w.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.pYD.mediaId + " " + this.pYD.pYx + " type " + this.pYD.pYz);
        FileOp.kl(this.pYD.getPath());
        an anVar = this.pYD.pYA;
        String str = "";
        if (anVar == null) {
            str = "";
        } else if (anVar.equals(an.uJF)) {
            str = "album_friend";
        } else if (anVar.equals(an.uJG)) {
            str = "album_self";
        } else if (anVar.equals(an.uJH)) {
            str = "album_stranger";
        } else if (anVar.equals(an.uJI)) {
            str = "profile_friend";
        } else if (anVar.equals(an.uJJ)) {
            str = "profile_stranger";
        } else if (anVar.equals(an.uJK)) {
            str = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (anVar.equals(an.uJE)) {
            str = "timeline";
        }
        if (!bg.mA(str)) {
            str = "&scene=" + str;
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(d.sYN), o.getString(ae.bes()), Integer.valueOf(am.getNetTypeForStat(ab.getContext())), Integer.valueOf(am.getStrength(ab.getContext())), str});
        this.pYD.url = FK(this.pYD.url);
        this.dnsCostTime = bg.Nz();
        str = this.pYD.pYy ? "SnsSightDomainList" : "SnsAlbumDomainList";
        String str2 = this.pYD.pYy ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime";
        String value = com.tencent.mm.i.g.sV().getValue(str);
        long j = (long) com.tencent.mm.i.g.sV().getInt(str2, 0);
        w.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", new Object[]{Boolean.valueOf(this.pYD.pYy), Boolean.valueOf(this.pYD.pYx), value, Long.valueOf(j)});
        if (j <= 0) {
            j = 259200;
        }
        com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(this.pYD.url, a(anVar, this.pYD.url, j, value));
        this.dnsCostTime = bg.aA(this.dnsCostTime);
        try {
            str = bg.mA(bVar.ip) ? InetAddress.getByName(bVar.host).getHostAddress() : bVar.ip;
        } catch (Exception e) {
            str = "-";
        }
        w.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", new Object[]{format, this.pYD.url, this.pYD.mediaId, Integer.valueOf(bVar.iee), str, this.pYD.url, Integer.valueOf(this.pYD.pYz), Boolean.valueOf(r1), anVar.toString()});
        int i = 0;
        while (true) {
            this.pYI = 1;
            t a = a(bVar, format);
            int i2 = i + 1;
            String str3 = "MicroMsg.SnsCdnDownloadBase";
            String str4 = "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s";
            Object[] objArr = new Object[5];
            objArr[0] = bVar.ip;
            objArr[1] = Boolean.valueOf(a != null);
            objArr[2] = Integer.valueOf(this.pYI);
            objArr[3] = Boolean.valueOf(bVar.ieh);
            objArr[4] = bVar.ieg;
            w.d(str3, str4, objArr);
            if (bfA() && a == null && this.pYI == 1 && bVar.Mn() && i2 < 4) {
                i = i2;
            } else {
                i = 2;
            }
        }
        i = 2;
        if (a != null) {
            i = c(a);
        }
        w.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", new Object[]{Long.valueOf(bg.aA(currentTimeMillis)), Long.valueOf(this.pYJ), this.pYD.mediaId, this.pYD.url, Integer.valueOf(this.pYX)});
        return Integer.valueOf(i);
    }

    private t a(com.tencent.mm.network.b.b bVar, String str) {
        String message;
        try {
            this.pYG = bVar.ip;
            this.iee = bVar.iee;
            this.pYK = bg.Nz();
            t a = com.tencent.mm.network.b.a(this.pYD.url, bVar);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str);
            if (bg.getInt(com.tencent.mm.i.g.sV().getValue("SnsDownloadHttpKeep"), 0) > 0) {
                w.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
                a.setRequestProperty("Connection", "close");
            }
            a.setConnectTimeout(25000);
            a.setReadTimeout(25000);
            t b = b(a);
            this.pYW = b.getHeaderFields();
            List list = (List) this.pYW.get("X-ClientIp");
            if (list != null && list.size() > 0) {
                this.pYF = (String) list.get(0);
            }
            list = (List) this.pYW.get("X-ServerIp");
            if (list != null && list.size() > 0) {
                this.pYE = (String) list.get(0);
            }
            list = (List) this.pYW.get("X-ErrNo");
            if (list != null && list.size() > 0) {
                this.pYH = bg.PY((String) list.get(0));
            }
            list = (List) this.pYW.get("X-RtFlag");
            if (list != null && list.size() > 0) {
                this.pYI = bg.PY((String) list.get(0));
            }
            try {
                this.fEX = b.getResponseCode();
                this.host = b.url.getHost();
                if (this.fEX == m.CTRL_INDEX || this.fEX == v.CTRL_INDEX) {
                    H(b.getHeaderFields());
                    if (d(b)) {
                        this.pYK = bg.aA(this.pYK);
                        list = (List) this.pYW.get("Content-Length");
                        if (list != null && list.size() > 0) {
                            this.pYU = bg.PY((String) list.get(0));
                        }
                        w.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", new Object[]{this.pYD.url, this.pYF, this.pYE, Integer.valueOf(this.pYU), Integer.valueOf(this.pYH)});
                        return b;
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.a(22, 62, 1, true);
                    w.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.pYD.mediaId);
                    hl(false);
                    return null;
                }
                H(b.getHeaderFields());
                if (this.pYD.pYy) {
                    if (this.fEX >= 400 && this.fEX < 500) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(22, 78, 1, true);
                    } else if (this.fEX >= 500 && this.fEX < 600) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(22, 79, 1, true);
                    }
                } else if (this.fEX >= 400 && this.fEX < 500) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(22, 56, 1, true);
                } else if (this.fEX >= 500 && this.fEX < 600) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(22, 57, 1, true);
                }
                if (this.pYD.pYx) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 14, 1, true);
                }
                w.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.pYD.mediaId + " " + this.pYD.url + " " + this.fEX);
                hl(false);
                return null;
            } catch (SocketTimeoutException e) {
                this.fEX = 1;
                hl(false);
                message = e.getMessage();
                if (this.pYD.pYy) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(22, 77, 1, true);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(22, 55, 1, true);
                }
                if (this.pYD.pYx) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 14, 1, true);
                }
                w.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.pYD.mediaId + " " + this.pYD.url + " msg:" + message);
                return null;
            } catch (Exception e2) {
                hl(false);
                message = e2.getMessage();
                if (this.pYD.pYx) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 14, 1, true);
                }
                w.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.pYD.mediaId + " " + this.pYD.url + " msg:" + message);
                return null;
            }
        } catch (Throwable e3) {
            w.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "connect fail : " + e3.getMessage(), new Object[0]);
            this.fEX = 2;
            hl(false);
            return null;
        }
    }

    private int c(t tVar) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            this.pYS = bg.Nz();
            InputStream inputStream3 = tVar.getInputStream();
            try {
                this.pYL = bg.Nz();
                boolean a = a(inputStream3, this.pYW);
                inputStream3.close();
                w.i("MicroMsg.SnsCdnDownloadBase", "reportResult ret : " + a);
                if (a) {
                    this.pYL = bg.aA(this.pYL);
                    this.pYJ = bg.aA(this.pYM);
                    boolean bfx = bfx();
                    w.i("MicroMsg.SnsCdnDownloadBase", "processData ret : " + bfx);
                    if (bfx) {
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        hl(true);
                        if (this.pYD.pYx) {
                            return 3;
                        }
                        return 1;
                    }
                    this.fEX = 3;
                    hl(false);
                    if (tVar == null) {
                        return 2;
                    }
                    tVar.ieZ.disconnect();
                    return 2;
                }
                hl(false);
                if (tVar == null) {
                    return 2;
                }
                tVar.ieZ.disconnect();
                return 2;
            } catch (Exception e2) {
                e = e2;
                inputStream = inputStream3;
                try {
                    w.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "snscdndownload fail : " + e.getMessage(), new Object[0]);
                    this.fEX = 4;
                    hl(false);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e3, "", new Object[0]);
                        }
                    }
                    if (tVar != null) {
                        return 2;
                    }
                    tVar.ieZ.disconnect();
                    return 2;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "", new Object[0]);
                        }
                    }
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream2 = inputStream3;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (tVar != null) {
                    tVar.ieZ.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e32 = e4;
            inputStream = null;
            w.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e32, "snscdndownload fail : " + e32.getMessage(), new Object[0]);
            this.fEX = 4;
            hl(false);
            if (inputStream != null) {
                inputStream.close();
            }
            if (tVar != null) {
                return 2;
            }
            tVar.ieZ.disconnect();
            return 2;
        } catch (Throwable th4) {
            th = th4;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (tVar != null) {
                tVar.ieZ.disconnect();
            }
            throw th;
        }
    }

    private static void H(Map<String, List<String>> map) {
        if (map != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    List<String> list = (List) map.get(str);
                    if (list != null) {
                        stringBuffer.append(str + ":");
                        for (String str2 : list) {
                            stringBuffer.append(str2 + "|");
                        }
                        stringBuffer.append(";");
                    }
                }
                w.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[]{stringBuffer.toString()});
            } catch (Exception e) {
            }
        }
    }

    private static boolean d(t tVar) {
        try {
            List list = (List) tVar.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (bg.mA(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            if (list.toString().contains("no-cache")) {
                return false;
            }
            return false;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            return false;
        }
    }

    private static long FL(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return j;
        }
        try {
            String[] split = str.split("\\.");
            return bg.getLong(split[3], 0) + (((16777216 * bg.getLong(split[0], 0)) + (65536 * bg.getLong(split[1], 0))) + (256 * bg.getLong(split[2], 0)));
        } catch (Exception e) {
            return j;
        }
    }

    private void hl(boolean z) {
        long j;
        String str;
        if (this.pYD == null || !this.pYD.pYy) {
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.a(22, 53, this.pYJ, true);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(22, 52, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(22, 51, 1, true);
        } else {
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.a(22, 75, this.pYJ, true);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(22, 74, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(22, 73, 1, true);
        }
        if (!(this.pYD == null || !this.pYD.pYx || z || i.a(this.pYC))) {
            com.tencent.mm.plugin.report.service.g.oUh.a(150, 66, 1, true);
        }
        this.pYT = this.pYX;
        int i = am.isWifi(ab.getContext()) ? 1 : 0;
        int strength = am.getStrength(ab.getContext());
        String str2 = "MicroMsg.SnsCdnDownloadBase";
        String str3 = "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]";
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(this.iee);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(strength);
        objArr[3] = Long.valueOf(this.dnsCostTime);
        objArr[4] = Long.valueOf(this.pYK);
        objArr[5] = Long.valueOf(this.pYL);
        objArr[6] = Long.valueOf(this.pYJ);
        objArr[7] = this.pYE;
        objArr[8] = this.pYG;
        objArr[9] = this.pYF;
        objArr[10] = this.pYD == null ? "" : this.pYD.url;
        w.v(str2, str3, objArr);
        int netType = am.getNetType(ab.getContext());
        int i2 = 0;
        if (this.pYD != null) {
            i2 = this.pYD.pYz == 4 ? 1 : 0;
        }
        w.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[]{Integer.valueOf(this.fEX), Integer.valueOf(this.pYT), Integer.valueOf(netType), Integer.valueOf(i2), Integer.valueOf(this.pYH)});
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
        Object[] objArr2 = new Object[19];
        if (this.pYD == null) {
            str2 = "";
        } else {
            str2 = this.pYD.url;
        }
        objArr2[0] = str2;
        objArr2[1] = Long.valueOf(FL(this.pYG));
        if (z) {
            j = this.pYJ;
        } else {
            j = 0;
        }
        objArr2[2] = Long.valueOf(j);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.pYK);
        objArr2[7] = Integer.valueOf(0);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Long.valueOf(this.pYL);
        objArr2[10] = Long.valueOf(FL(this.pYF));
        objArr2[11] = Long.valueOf(FL(this.pYE));
        objArr2[12] = Integer.valueOf(this.iee);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.fEX);
        objArr2[15] = Integer.valueOf(this.pYT);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i2);
        objArr2[18] = Integer.valueOf(this.pYH);
        gVar.i(10736, objArr2);
        boolean isConnected = am.isConnected(ab.getContext());
        w.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.pYN);
        if (!(z || bg.mA(this.pYN) || !isConnected)) {
            String str4 = this.pYN;
            if (!(com.tencent.mm.network.b.ied == null || com.tencent.mm.network.b.ied.vh() == null)) {
                com.tencent.mm.network.b.ied.vh().reportFailIp(str4);
            }
        }
        w.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[]{this.pYO.value});
        int bfy = bfy();
        str2 = "";
        switch (bfy) {
            case 1:
                str = "100105";
                break;
            case 2:
                str = "100106";
                break;
            case 3:
                str = "100100";
                break;
            default:
                return;
        }
        c dX = com.tencent.mm.u.c.c.Az().dX(str);
        i = 0;
        if (dX.isValid()) {
            i = bg.getInt((String) dX.bKK().get("needUploadData"), 1);
            str2 = dX.field_expId;
        }
        if (i != 0) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.n("20ImgSize", this.pYX + ",");
            dVar.n("21NetType", (am.isWifi(ab.getContext()) ? 1 : 0) + ",");
            dVar.n("22DelayTime", (this.pYJ - this.pYK) + ",");
            dVar.n("23RetCode", this.fEX + ",");
            dVar.n("24DnsCostTime", this.dnsCostTime + ",");
            dVar.n("25ConnectCostTime", this.pYK + ",");
            dVar.n("26SendCostTime", ",");
            dVar.n("27WaitResponseCostTime", this.pYR + ",");
            dVar.n("28ReceiveCostTime", this.pYL + ",");
            dVar.n("29ClientAddrIP", this.pYF + ",");
            dVar.n("30ServerAddrIP", this.pYG + ",");
            dVar.n("31dnstype", this.iee + ",");
            dVar.n("32signal", am.getStrength(ab.getContext()) + ",");
            dVar.n("33host", this.host + ",");
            dVar.n("34MediaType", bfy + ",");
            dVar.n("35X_Errno", this.pYH + ",");
            dVar.n("36MaxPackageSize", this.pYP + ",");
            dVar.n("37MaxPackageTimeStamp", this.pYQ + ",");
            dVar.n("38PackageRecordList", this.pYO.value + ",");
            dVar.n("39ExpLayerId", str + ",");
            dVar.n("40ExpId", str2 + ",");
            dVar.n("41FeedId", ",");
            w.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.JG());
            com.tencent.mm.plugin.report.service.g.oUh.i(13480, new Object[]{dVar});
            if (this.fEX != m.CTRL_INDEX) {
                com.tencent.mm.plugin.report.service.g.oUh.i(14071, new Object[]{dVar});
            }
        }
    }

    public final com.tencent.mm.sdk.platformtools.ae bec() {
        return ae.bew();
    }

    protected boolean bfA() {
        return false;
    }
}
