package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.a.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    public static String raK;
    public static c raL;
    private final String TAG = "MicroMsg.MMTraceRoute";
    private final int raM = 64;
    private boolean raN = false;
    public f raO = new f();
    public Map<String, Set<Integer>> raP = new HashMap();
    public e raQ;
    public d raR;
    public c raS;
    public b raT;
    public String userName;

    private class a implements Runnable {
        private String ip;
        private Set<Integer> raU;
        final /* synthetic */ a raV;

        public a(a aVar, String str, Set<Integer> set) {
            this.raV = aVar;
            this.ip = str;
            this.raU = set;
        }

        public final void run() {
            Socket socket;
            Throwable e;
            this.raV.a(this.ip, String.format("connect %s: ", new Object[]{this.ip}), Integer.valueOf(1));
            for (Integer num : this.raU) {
                a aVar = this.raV;
                String str = this.ip;
                int intValue = num.intValue();
                try {
                    socket = new Socket();
                    try {
                        socket.setSoTimeout(Downloads.MIN_RETYR_AFTER);
                        long Nz = bg.Nz();
                        socket.connect(new InetSocketAddress(str, intValue));
                        long Nz2 = bg.Nz();
                        w.i("MicroMsg.MMTraceRoute", "connect success" + str + ":" + intValue);
                        aVar.a(str, String.format("port = %d, time = %dms ", new Object[]{Integer.valueOf(intValue), Long.valueOf(Nz2 - Nz)}), Integer.valueOf(1));
                        try {
                            socket.close();
                        } catch (Throwable e2) {
                            w.e("MicroMsg.MMTraceRoute", "close err: " + e2.getMessage());
                            w.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        }
                    } catch (UnknownHostException e3) {
                        e2 = e3;
                        try {
                            aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                            w.e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                            w.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (Throwable e22) {
                                    w.e("MicroMsg.MMTraceRoute", "close err: " + e22.getMessage());
                                    w.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            e22 = th;
                        }
                    } catch (IOException e4) {
                        e22 = e4;
                        aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e22.toString()}), Integer.valueOf(1));
                        w.e("MicroMsg.MMTraceRoute", "connect err:" + e22.getMessage());
                        w.printErrStackTrace("MicroMsg.MMTraceRoute", e22, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e222) {
                                w.e("MicroMsg.MMTraceRoute", "close err: " + e222.getMessage());
                                w.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                            }
                        }
                    } catch (Exception e5) {
                        e222 = e5;
                        aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e222.toString()}), Integer.valueOf(1));
                        w.e("MicroMsg.MMTraceRoute", "connect err:" + e222.toString());
                        w.printErrStackTrace("MicroMsg.MMTraceRoute", e222, "", new Object[0]);
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (Throwable e2222) {
                                w.e("MicroMsg.MMTraceRoute", "close err: " + e2222.getMessage());
                                w.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                            }
                        }
                    }
                } catch (UnknownHostException e6) {
                    e2222 = e6;
                    socket = null;
                    aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    w.e("MicroMsg.MMTraceRoute", "connect err: " + e2222.getMessage());
                    w.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e7) {
                    e2222 = e7;
                    socket = null;
                    aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    w.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.getMessage());
                    w.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Exception e8) {
                    e2222 = e8;
                    socket = null;
                    aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2222.toString()}), Integer.valueOf(1));
                    w.e("MicroMsg.MMTraceRoute", "connect err:" + e2222.toString());
                    w.printErrStackTrace("MicroMsg.MMTraceRoute", e2222, "", new Object[0]);
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    socket = null;
                }
            }
            this.raV.a(this.ip, "\n", Integer.valueOf(1));
            return;
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable e9) {
                    w.e("MicroMsg.MMTraceRoute", "close err: " + e9.getMessage());
                    w.printErrStackTrace("MicroMsg.MMTraceRoute", e9, "", new Object[0]);
                }
            }
            throw e2222;
            throw e2222;
        }
    }

    public interface b {
        void boo();
    }

    public interface c {
        void bop();
    }

    public interface d {
        void boq();
    }

    public interface e {
        void bor();
    }

    private class f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {
        final /* synthetic */ a raV;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int raW;
            final /* synthetic */ String raX;
            final /* synthetic */ PByteArray raY;
            final /* synthetic */ f raZ;

            AnonymousClass1(f fVar, int i, String str, PByteArray pByteArray) {
                this.raZ = fVar;
                this.raW = i;
                this.raX = str;
                this.raY = pByteArray;
            }

            public final void run() {
                String str = "http://" + ab.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str + "/cgi-bin/mmsupport-bin/stackreport?version=");
                stringBuffer.append(Integer.toHexString(com.tencent.mm.protocal.d.sYN));
                stringBuffer.append("&devicetype=");
                stringBuffer.append(com.tencent.mm.protocal.d.DEVICE_TYPE);
                stringBuffer.append("&filelength=");
                stringBuffer.append(this.raW);
                stringBuffer.append("&sum=");
                stringBuffer.append(this.raX);
                stringBuffer.append("&reporttype=");
                stringBuffer.append(4);
                if (!(this.raZ.raV.userName == null || this.raZ.raV.userName.equals(""))) {
                    stringBuffer.append("&username=");
                    stringBuffer.append(this.raZ.raV.userName);
                }
                w.d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
                f.a(this.raZ, stringBuffer.toString(), this.raY.value);
            }
        }

        private f(a aVar) {
            this.raV = aVar;
        }

        static /* synthetic */ void a(f fVar, String str, byte[] bArr) {
            DefaultHttpClient defaultHttpClient;
            HttpUriRequest httpPost;
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    defaultHttpClient = new DefaultHttpClient();
                    httpPost = new HttpPost(str);
                    try {
                        break;
                    } catch (Throwable e) {
                        w.e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e.getMessage());
                        w.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                        i = i2;
                    } catch (Throwable e2) {
                        w.e("MicroMsg.MMTraceRoute", "http post IOException: " + e2.getMessage());
                        w.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        i = i2;
                    }
                } else {
                    fVar.raV.bon();
                    return;
                }
            }
            HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            w.i("MicroMsg.MMTraceRoute", "http pose returnContent : " + bg.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
            a aVar = fVar.raV;
            if (aVar.raS != null) {
                aVar.raS.bop();
            }
        }
    }

    private class g implements Runnable {
        final /* synthetic */ a raV;
        private String rba;
        private String rbb;
        private boolean rbc;
        private Integer rbd;

        public g(a aVar, String str, String str2, boolean z, Integer num) {
            this.raV = aVar;
            this.rba = str;
            this.rbb = str2;
            this.rbc = z;
            this.rbd = num;
        }

        public final void run() {
            a aVar = this.raV;
            String str = this.rba;
            String str2 = this.rbb;
            Integer num = this.rbd;
            for (int i = 1; i <= 3; i++) {
                List z = b.z(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), str});
                if (z.size() == 2) {
                    String str3 = (String) z.get(0);
                    if (bg.mA(str3)) {
                        w.e("MicroMsg.MMTraceRoute", "runcommand err " + str);
                        aVar.a(str2, "run command err ", num);
                    } else {
                        String obj = z.get(1).toString();
                        if (b.Hw(str3) > 0) {
                            if (!bg.mA(b.Hv(str3))) {
                                str3 = String.format(" %sms ", new Object[]{b.Hv(str3)});
                            } else if (bg.mA(obj)) {
                                str3 = String.format("unable to get time", new Object[0]);
                            } else {
                                str3 = String.format(" %sms ", new Object[]{obj});
                            }
                        } else {
                            str3 = String.format(" router no response ", new Object[0]);
                        }
                        if (i == 3) {
                            str3 = str3 + "\n";
                        }
                        aVar.a(str2, str3, num);
                    }
                } else if (i == 3) {
                    aVar.a(str2, " router no response\n", num);
                } else {
                    aVar.a(str2, " router no response", num);
                }
            }
        }
    }

    private class h implements Runnable {
        private String ip;
        final /* synthetic */ a raV;
        private int rbe;

        public h(a aVar, String str, int i) {
            this.raV = aVar;
            this.ip = str;
            this.rbe = i;
        }

        public final void run() {
            boolean z = true;
            w.i("MicroMsg.MMTraceRoute", "ttl= " + this.rbe);
            a aVar = this.raV;
            String str = this.ip;
            int i = this.rbe;
            List z2 = b.z(new String[]{"ping", "-c 1", "-t " + String.valueOf(i), str});
            if (z2.size() != 2) {
                aVar.a(str, String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)}), Integer.valueOf(i + 1));
            } else {
                String str2 = (String) z2.get(0);
                if (str2.length() == 0) {
                    w.e("MicroMsg.MMTraceRoute", "runcommand err");
                } else {
                    String str3;
                    int indexOf = str2.indexOf("From ");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf("from ");
                        if (indexOf < 0) {
                            str3 = null;
                            if (bg.mA(str3)) {
                                if (b.Hw(str2) <= 0) {
                                    str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                                    w.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                                    aVar.a(str, str2, Integer.valueOf(i + 1));
                                }
                                if (!z) {
                                }
                            }
                            if (!str.equals(str3)) {
                                aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                            } else if (b.Hw(str2) > 0) {
                                aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                if (a.raL != null) {
                                    a.raL.execute(new g(aVar, str3, str, true, Integer.valueOf(i + 1)));
                                }
                            } else {
                                aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                if (a.raL != null) {
                                    a.raL.execute(new g(aVar, str3, str, false, Integer.valueOf(i + 1)));
                                }
                            }
                            if (!z) {
                            }
                        }
                    }
                    int indexOf2 = str2.indexOf(" ", indexOf);
                    if (indexOf2 < 0) {
                        indexOf = str2.indexOf(":", indexOf);
                        if (indexOf < 0) {
                            str3 = null;
                            if (bg.mA(str3)) {
                                if (!str.equals(str3)) {
                                    aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                } else if (b.Hw(str2) > 0) {
                                    aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                    if (a.raL != null) {
                                        a.raL.execute(new g(aVar, str3, str, false, Integer.valueOf(i + 1)));
                                    }
                                } else {
                                    aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                                    if (a.raL != null) {
                                        a.raL.execute(new g(aVar, str3, str, true, Integer.valueOf(i + 1)));
                                    }
                                }
                                if (!z) {
                                }
                            }
                            if (b.Hw(str2) <= 0) {
                                str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                                w.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                                aVar.a(str, str2, Integer.valueOf(i + 1));
                            }
                            if (!z) {
                            }
                        }
                    }
                    indexOf = indexOf2;
                    indexOf++;
                    indexOf2 = str2.indexOf(" ", indexOf);
                    str3 = indexOf2 < 0 ? null : str2.substring(indexOf, indexOf2).replace(":", "");
                    if (bg.mA(str3)) {
                        if (b.Hw(str2) <= 0) {
                            str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i)});
                            w.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl" + str);
                            aVar.a(str, str2, Integer.valueOf(i + 1));
                        }
                        if (!z) {
                        }
                    }
                    if (!str.equals(str3)) {
                        aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                    } else if (b.Hw(str2) > 0) {
                        aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                        if (a.raL != null) {
                            a.raL.execute(new g(aVar, str3, str, true, Integer.valueOf(i + 1)));
                        }
                    } else {
                        aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i), str3}), Integer.valueOf(i + 1));
                        if (a.raL != null) {
                            a.raL.execute(new g(aVar, str3, str, false, Integer.valueOf(i + 1)));
                        }
                    }
                    if (!z) {
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
    }

    private class i implements Runnable {
        private String ip;
        final /* synthetic */ a raV;

        public i(a aVar, String str) {
            this.raV = aVar;
            this.ip = str;
        }

        public final void run() {
            int i = 1;
            List z = b.z(new String[]{"ping", "-c 1", new StringBuilder("-t 64").toString(), this.ip});
            if (z.size() != 2) {
                this.raV.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                return;
            }
            String str = (String) z.get(0);
            if (bg.mA(str)) {
                this.raV.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                w.e("MicroMsg.MMTraceRoute", "runcommand err");
                return;
            }
            int Hw = b.Hw(str);
            if (Hw <= 0) {
                w.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
                this.raV.a(this.ip, "failed to touch server: " + this.ip + "\n", Integer.valueOf(0));
                return;
            }
            String obj = z.get(1).toString();
            if (!bg.mA(b.Hv(str))) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Hw), b.Hv(str)});
            } else if (bg.mA(obj)) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Hw), "unknown"});
            } else {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(Hw), obj});
            }
            this.raV.a(this.ip, str + "\n", Integer.valueOf(0));
            int i2 = (64 - Hw) + 5;
            if (i2 < 0) {
                i2 = 64;
            }
            while (i < i2 && !this.raV.bol()) {
                Runnable hVar = new h(this.raV, this.ip, i);
                if (a.raL != null) {
                    a.raL.execute(hVar);
                }
                i++;
            }
        }
    }

    private class j implements Runnable {
        final /* synthetic */ a raV;

        public j(a aVar) {
            this.raV = aVar;
        }

        public final void run() {
            long Nz;
            this.raV.hY(false);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long Nz2 = bg.Nz();
            w.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + simpleDateFormat.format(new Date(Nz2)));
            for (Entry entry : this.raV.raP.entrySet()) {
                Runnable iVar = new i(this.raV, (String) entry.getKey());
                if (a.raL != null) {
                    a.raL.execute(iVar);
                }
                iVar = new a(this.raV, (String) entry.getKey(), (Set) entry.getValue());
                if (a.raL != null) {
                    a.raL.execute(iVar);
                }
            }
            while (!this.raV.bol() && a.raL.getActiveCount() > 0) {
                w.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.raL.getActiveCount()));
                Nz = bg.Nz();
                if (Nz - Nz2 >= 120000) {
                    w.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + ((Nz - Nz2) / 1000));
                    this.raV.hY(true);
                    this.raV.stop();
                    if (this.raV.raQ != null) {
                        this.raV.raQ.bor();
                        return;
                    }
                    return;
                }
                try {
                    Thread.sleep(500);
                } catch (Throwable e) {
                    w.e("MicroMsg.MMTraceRoute", "wait for command end err: " + e.getMessage());
                    w.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                }
            }
            Nz = bg.Nz();
            w.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + simpleDateFormat.format(new java.util.Date(Nz)));
            w.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + ((Nz - Nz2) / 1000));
            if (this.raV.raR != null && !this.raV.bol()) {
                this.raV.raR.boq();
            }
        }
    }

    public final synchronized boolean bol() {
        return this.raN;
    }

    public final synchronized void hY(boolean z) {
        this.raN = z;
    }

    public a(String str) {
        this.userName = str;
        raK = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()).toString() + ".log";
    }

    public final void stop() {
        hY(true);
        if (raL != null) {
            try {
                raL.shutdownNow();
            } catch (Exception e) {
                w.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e.getMessage());
            }
        }
    }

    public final void b(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            w.e("MicroMsg.MMTraceRoute", "no ip contains");
            return;
        }
        String str = "";
        if (z) {
            str = str + "long: ";
        } else {
            str = str + "short: ";
        }
        int length = strArr.length;
        int i = 0;
        String str2 = str;
        while (i < length) {
            str = strArr[i];
            String[] split = str.split(":");
            if (split == null || split.length != 3) {
                w.e("MicroMsg.MMTraceRoute", "err ip " + str);
                str = str2;
            } else if (this.raP.containsKey(split[0])) {
                ((Set) this.raP.get(split[0])).add(Integer.valueOf(bg.getInt(split[1], 0)));
                str = str2;
            } else {
                Set hashSet = new HashSet();
                hashSet.add(Integer.valueOf(bg.getInt(split[1], 0)));
                this.raP.put(split[0], hashSet);
                str = str2 + split[0] + " ";
            }
            i++;
            str2 = str;
        }
        com.tencent.mm.a.e.e(raK, (str2 + "\n").getBytes());
    }

    public final synchronized void a(String str, String str2, Integer num) {
        if (!(str == null || str2 == null)) {
            if (num.intValue() >= 0) {
                if (!this.raO.containsKey(str)) {
                    Map concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(num, new StringBuilder(str2));
                    this.raO.put(str, (ConcurrentHashMap) concurrentHashMap);
                } else if (((ConcurrentHashMap) this.raO.get(str)).containsKey(num)) {
                    ((StringBuilder) ((ConcurrentHashMap) this.raO.get(str)).get(num)).append(str2);
                } else {
                    new ConcurrentHashMap().put(num, new StringBuilder(str2));
                    ((ConcurrentHashMap) this.raO.get(str)).put(num, new StringBuilder(str2));
                }
            }
        }
    }

    public final synchronized void bom() {
        if (this.raO != null) {
            String str;
            f fVar = this.raO;
            File file = new File(raK);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    com.tencent.mm.a.e.e(raK, (fVar.raV.userName + "\n").getBytes());
                } catch (Throwable e) {
                    w.e("MicroMsg.MMTraceRoute", "create log file err " + e.getMessage());
                    w.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    fVar.raV.bon();
                }
            }
            for (Entry key : fVar.raV.raO.entrySet()) {
                String str2 = (String) key.getKey();
                if (!bg.mA(str2) && fVar.raV.raO.containsKey(str2)) {
                    Map map = (Map) fVar.raV.raO.get(str2);
                    if (map != null) {
                        String str3 = "";
                        if (map.size() != 1 || map.get(Integer.valueOf(1)) == null) {
                            int i = 0;
                            Object obj = null;
                            while (i < map.size() && obj == null) {
                                Object obj2;
                                if (map.get(Integer.valueOf(i)) != null) {
                                    String stringBuilder = ((StringBuilder) map.get(Integer.valueOf(i))).toString();
                                    if (!bg.mA(stringBuilder)) {
                                        str = str3 + stringBuilder;
                                        obj2 = stringBuilder.contains("FIN") ? 1 : obj;
                                        i++;
                                        obj = obj2;
                                        str3 = str;
                                    }
                                }
                                str = str3;
                                obj2 = obj;
                                i++;
                                obj = obj2;
                                str3 = str;
                            }
                        } else {
                            str3 = str3 + ((StringBuilder) map.get(Integer.valueOf(1))).toString();
                        }
                        if (str3.length() > 0) {
                            w.i("MicroMsg.MMTraceRoute", str2 + str3);
                            com.tencent.mm.a.e.e(raK, str3.getBytes());
                        }
                    } else {
                        continue;
                    }
                }
            }
            byte[] c = com.tencent.mm.a.e.c(raK, 0, -1);
            if (bg.bm(c)) {
                w.e("MicroMsg.MMTraceRoute", "read log failed");
                fVar.raV.bon();
            } else {
                str = com.tencent.mm.a.g.n(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.sYN), Integer.valueOf(c.length)}).getBytes()).toLowerCase();
                c = q.l(c);
                PByteArray pByteArray = new PByteArray();
                com.tencent.mm.a.c.a(pByteArray, c, str.getBytes());
                com.tencent.mm.sdk.f.e.post(new AnonymousClass1(fVar, r1, str, pByteArray), "MMTraceRoute_uploadLog");
            }
        }
        return;
    }

    public final void bon() {
        if (this.raT != null) {
            this.raT.boo();
        }
    }
}
