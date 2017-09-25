package b.a.e;

import b.a.a.a.b;
import b.a.c.e;
import b.a.d.c;
import b.a.d.g;
import b.a.d.h;
import b.a.d.i;
import b.a.d.j;
import b.a.d.k;
import b.a.f.d;
import com.qq.taf.jce.BuildConfig;
import java.util.Map.Entry;

public final class a implements b {
    private static /* synthetic */ int[] xpT;
    private b.a.d.a xpR;
    private b xpS;

    private static /* synthetic */ int[] ciM() {
        int[] iArr = xpT;
        if (iArr == null) {
            iArr = new int[h.values().length];
            try {
                iArr[h.Header.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[h.QueryString.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            xpT = iArr;
        }
        return iArr;
    }

    public a(b bVar, b.a.d.a aVar) {
        this.xpS = bVar;
        this.xpR = aVar;
    }

    public final i ciL() {
        this.xpR.vR("obtaining request token from " + this.xpS.ciA());
        c cVar = new c(j.POST, this.xpS.ciA());
        this.xpR.vR("setting oauth_callback to " + this.xpR.xpm);
        cVar.fr("oauth_callback", this.xpR.xpm);
        a(cVar, b.a.d.b.xps);
        b(cVar);
        this.xpR.vR("sending request...");
        g ciG = cVar.ciG();
        String body = ciG.getBody();
        this.xpR.vR("response status code: " + ciG.code);
        this.xpR.vR("response body: " + body);
        return new b.a.c.g().Wu(body);
    }

    private void a(c cVar, i iVar) {
        cVar.fr("oauth_timestamp", new d().ciO());
        cVar.fr("oauth_nonce", new d().getNonce());
        cVar.fr("oauth_consumer_key", this.xpR.xpk);
        cVar.fr("oauth_signature_method", new b.a.f.a().ciN());
        cVar.fr("oauth_version", BuildConfig.VERSION_NAME);
        if ((this.xpR.scope != null ? 1 : null) != null) {
            cVar.fr("scope", this.xpR.scope);
        }
        this.xpR.vR("generating signature...");
        String a = new b.a.c.c().a(cVar);
        String af = new b.a.f.a().af(a, this.xpR.xpl, iVar.tPO);
        this.xpR.vR("base string is: " + a);
        this.xpR.vR("signature is: " + af);
        cVar.fr("oauth_signature", af);
        this.xpR.vR("appended additional OAuth parameters: " + b.a.g.b.an(cVar.xpt));
    }

    public final i a(i iVar, k kVar) {
        this.xpR.vR("obtaining access token from " + this.xpS.ciB());
        c cVar = new c(j.POST, this.xpS.ciB());
        cVar.fr("oauth_token", iVar.token);
        cVar.fr("oauth_verifier", kVar.value);
        this.xpR.vR("setting token to: " + iVar + " and verifier to: " + kVar);
        a(cVar, iVar);
        b(cVar);
        return new b.a.c.g().Wu(cVar.ciG().getBody());
    }

    public final void a(i iVar, c cVar) {
        this.xpR.vR("signing request: " + cVar.ciE());
        Object obj = ("".equals(iVar.token) && "".equals(iVar.tPO)) ? 1 : null;
        if (obj == null) {
            cVar.fr("oauth_token", iVar.token);
        }
        this.xpR.vR("setting token to: " + iVar);
        a(cVar, iVar);
        b(cVar);
    }

    public final String b(i iVar) {
        return this.xpS.b(iVar);
    }

    private void b(c cVar) {
        switch (ciM()[this.xpR.xpo.ordinal()]) {
            case 1:
                this.xpR.vR("using Http Header signature");
                cVar.addHeader("Authorization", new e().a(cVar));
                return;
            case 2:
                this.xpR.vR("using Querystring signature");
                for (Entry entry : cVar.xpt.entrySet()) {
                    cVar.fs((String) entry.getKey(), (String) entry.getValue());
                }
                return;
            default:
                return;
        }
    }
}
