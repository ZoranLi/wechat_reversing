package com.tencent.mm.network;

import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class b {
    public static a ied;

    public interface a {
        e vh();
    }

    public static class b {
        public String host = null;
        public int iee = 0;
        private ArrayList<String> ief = new ArrayList();
        public String ieg;
        public boolean ieh = false;
        private boolean iei = false;
        public String ip = "";
        URL url = null;

        public b(String str) {
            this.ieg = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                String str2;
                if (b.ied == null || b.ied.vh() == null) {
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.ied == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.ied.vh();
                    }
                    objArr[0] = str2;
                    objArr[1] = bg.bJZ();
                    w.e(str3, str4, objArr);
                    return;
                }
                this.iee = b.ied.vh().getHostByName(this.host, arrayList);
                w.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.iee), this.host, str);
                if (arrayList.size() <= 0) {
                    this.iee = 0;
                } else if (1 == this.iee) {
                    str2 = (String) arrayList.get((int) (bg.Nz() % ((long) arrayList.size())));
                    this.ip = str2;
                    this.url = new URL(str.replaceFirst(this.host, str2));
                }
            } catch (Throwable e) {
                w.e("MicroMsg.GprsSetting", "exception:%s", bg.g(e));
            }
        }

        public b(String str, boolean z) {
            this.ieh = z;
            this.ieg = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                if (b.ied == null || b.ied.vh() == null) {
                    String str2;
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.ied == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.ied.vh();
                    }
                    objArr[0] = str2;
                    objArr[1] = bg.bJZ();
                    w.e(str3, str4, objArr);
                    return;
                }
                this.iee = b.ied.vh().a(this.host, z, this.ief);
                Random random = new Random();
                random.setSeed(bg.Nz());
                Collections.shuffle(this.ief, random);
                w.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.iee), this.host, str, this.ief);
                if (this.ief.size() <= 0) {
                    this.iee = 0;
                } else if (1 == this.iee) {
                    this.ip = (String) this.ief.remove(0);
                    this.url = new URL(str.replaceFirst(this.host, this.ip));
                }
            } catch (Throwable e) {
                w.e("MicroMsg.GprsSetting", "exception:%s", bg.g(e));
            }
        }

        public final boolean Mn() {
            if (!this.ieh) {
                if (this.ief.isEmpty() || !Mo()) {
                    this.ieh = true;
                    this.iee = b.ied.vh().a(this.host, this.ieh, this.ief);
                    Random random = new Random();
                    random.setSeed(bg.Nz());
                    Collections.shuffle(this.ief, random);
                } else {
                    this.ief.clear();
                    return true;
                }
            }
            if (!this.ief.isEmpty() && Mo()) {
                this.ief.clear();
                return true;
            } else if (this.iei) {
                return false;
            } else {
                this.iei = true;
                try {
                    this.url = new URL(this.ieg);
                    return true;
                } catch (MalformedURLException e) {
                    return false;
                }
            }
        }

        private boolean Mo() {
            this.ip = (String) this.ief.remove(0);
            try {
                this.url = new URL(this.ieg.replaceFirst(this.host, this.ip));
                return true;
            } catch (MalformedURLException e) {
                return false;
            }
        }
    }

    public static void a(a aVar) {
        w.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.valueOf(false), bg.bJZ());
        ied = aVar;
    }

    public static int a(boolean z, List<String> list, String str) {
        int i = -1;
        if (ied != null) {
            try {
                i = ied.vh().a(str, z, list);
            } catch (Throwable e) {
                w.e("MicroMsg.GprsSetting", "exception:%s", bg.g(e));
            }
        }
        return i;
    }

    public static InputStream k(String str, int i, int i2) {
        t a = a(str, null);
        a.setConnectTimeout(i);
        a.setReadTimeout(i2);
        a.setRequestMethod("GET");
        if (a(a) != 0) {
            return null;
        }
        return a.getInputStream();
    }

    public static t a(String str, b bVar) {
        if (bVar == null) {
            bVar = new b(str);
        }
        w.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", bVar.host, bVar.url, bVar.ip, Integer.valueOf(bVar.iee));
        t tVar = new t(bVar.url, bVar.iee);
        tVar.ifa = bVar.ip;
        if (1 == bVar.iee) {
            tVar.setRequestProperty("Host", bVar.host);
            tVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        return tVar;
    }

    public static int a(t tVar) {
        try {
            if (tVar.getResponseCode() != m.CTRL_INDEX) {
                return -1;
            }
            return 0;
        } catch (Throwable e) {
            w.e("MicroMsg.GprsSetting", "exception:%s", bg.g(e));
            return -3;
        }
    }

    public static u mi(String str) {
        return new u(str);
    }
}
