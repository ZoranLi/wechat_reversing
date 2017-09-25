package com.tencent.mm.network;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class t {
    public HttpURLConnection ieZ;
    public int iee;
    public String ifa;
    private Map<String, List<String>> ifb = null;
    public URL url;

    public t(URL url, int i) {
        this.url = url;
        this.iee = i;
        this.ieZ = (HttpURLConnection) this.url.openConnection();
        if (1 == this.iee) {
            this.ieZ.setInstanceFollowRedirects(false);
        }
    }

    public final int getResponseCode() {
        int responseCode;
        while (true) {
            if (1 == this.iee && this.ifb == null) {
                this.ifb = this.ieZ.getRequestProperties();
            }
            responseCode = this.ieZ.getResponseCode();
            if (1 != this.iee || 302 != responseCode) {
                break;
            }
            String headerField = this.ieZ.getHeaderField("Location");
            if (headerField == null) {
                break;
            }
            this.url = new URL(this.url, headerField);
            this.ieZ = (HttpURLConnection) this.url.openConnection();
            this.ieZ.setInstanceFollowRedirects(false);
            if (this.ifb != null) {
                for (String str : this.ifb.keySet()) {
                    if (!(str.equals("Host") || str.equals("X-Online-Host"))) {
                        List list = (List) this.ifb.get(str);
                        for (int i = 0; i < list.size(); i++) {
                            this.ieZ.setRequestProperty(str, (String) list.get(i));
                        }
                    }
                }
            }
            this.ieZ.setRequestProperty("Host", this.url.getHost());
            this.ieZ.setRequestProperty("X-Online-Host", this.url.getHost());
        }
        return responseCode;
    }

    public final void setRequestMethod(String str) {
        this.ieZ.setRequestMethod(str);
    }

    public final void connect() {
        if (1 == this.iee && this.ifb == null) {
            this.ifb = this.ieZ.getRequestProperties();
        }
        this.ieZ.connect();
    }

    public final Map<String, List<String>> getHeaderFields() {
        if (1 == this.iee && this.ifb == null) {
            this.ifb = this.ieZ.getRequestProperties();
        }
        return this.ieZ.getHeaderFields();
    }

    public final String getHeaderField(String str) {
        if (1 == this.iee && this.ifb == null) {
            this.ifb = this.ieZ.getRequestProperties();
        }
        return this.ieZ.getHeaderField(str);
    }

    public final InputStream getInputStream() {
        if (1 == this.iee) {
            if (this.ifb == null) {
                this.ifb = this.ieZ.getRequestProperties();
            }
            getResponseCode();
        }
        return this.ieZ.getInputStream();
    }

    public final OutputStream getOutputStream() {
        if (1 == this.iee) {
            if (this.ifb == null) {
                this.ifb = this.ieZ.getRequestProperties();
            }
            getResponseCode();
        }
        return this.ieZ.getOutputStream();
    }

    public final void MA() {
        this.ieZ.setDoInput(true);
    }

    public final void MB() {
        this.ieZ.setDoOutput(true);
    }

    public final void setRequestProperty(String str, String str2) {
        this.ieZ.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.ieZ.setUseCaches(z);
    }

    public final void setConnectTimeout(int i) {
        this.ieZ.setConnectTimeout(i);
    }

    public final void setReadTimeout(int i) {
        this.ieZ.setReadTimeout(i);
    }

    public final void mj(String str) {
        this.ieZ.setRequestProperty("Referer", str);
    }

    public final String toString() {
        return this.ieZ.toString();
    }
}
