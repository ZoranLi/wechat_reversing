package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.sdk.platformtools.w;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class l implements X509TrustManager {
    private LinkedList<X509TrustManager> jbD = new LinkedList();
    private LinkedList<X509TrustManager> jbE = new LinkedList();
    KeyStore jbF;
    private X509Certificate[] jbG;

    public l() {
        try {
            this.jbF = KeyStore.getInstance(KeyStore.getDefaultType());
            this.jbF.load(null, null);
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandX509TrustManager", "Local KeyStore init failed");
        }
    }

    public final void init() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            int i = 0;
            while (trustManagers != null && i < trustManagers.length) {
                this.jbD.add((X509TrustManager) trustManagers[i]);
                i++;
            }
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandX509TrustManager", "init SystemTrustManager: " + e);
        }
        Vs();
        Vt();
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client Certification not supported");
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        Object obj;
        Iterator it = this.jbD.iterator();
        while (it.hasNext()) {
            try {
                ((X509TrustManager) it.next()).checkServerTrusted(x509CertificateArr, str);
                obj = 1;
                break;
            } catch (CertificateException e) {
            }
        }
        obj = null;
        if (obj == null) {
            it = this.jbE.iterator();
            while (it.hasNext()) {
                try {
                    ((X509TrustManager) it.next()).checkServerTrusted(x509CertificateArr, str);
                    obj = 1;
                    break;
                } catch (CertificateException e2) {
                }
            }
            obj = null;
            if (obj == null) {
                throw new CertificateException("Server Certificate not trusted");
            }
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return this.jbG;
    }

    private void Vs() {
        if (this.jbF != null) {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init(this.jbF);
                TrustManager[] trustManagers = instance.getTrustManagers();
                int i = 0;
                while (trustManagers != null && i < trustManagers.length) {
                    this.jbE.add((X509TrustManager) trustManagers[i]);
                    i++;
                }
            } catch (Exception e) {
                w.e("MicroMsg.AppBrandX509TrustManager", "initLocalTrustManager: " + e);
            }
        }
    }

    private void Vt() {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.jbD.iterator();
        while (it.hasNext()) {
            X509Certificate[] acceptedIssuers = ((X509TrustManager) it.next()).getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Iterator it2 = this.jbE.iterator();
        while (it2.hasNext()) {
            acceptedIssuers = ((X509TrustManager) it2.next()).getAcceptedIssuers();
            if (acceptedIssuers != null) {
                arrayList.addAll(Arrays.asList(acceptedIssuers));
            }
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        this.jbG = new X509Certificate[arrayList.size()];
        this.jbG = (X509Certificate[]) arrayList.toArray(this.jbG);
        long currentTimeMillis4 = System.currentTimeMillis();
        w.i("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3)});
    }
}
