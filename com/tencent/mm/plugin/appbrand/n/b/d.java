package com.tencent.mm.plugin.appbrand.n.b;

import com.tencent.mm.plugin.appbrand.n.e.a;
import com.tencent.mm.plugin.appbrand.n.e.c;
import com.tencent.mm.plugin.appbrand.n.e.i;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public final class d extends c {
    public final c a(a aVar, i iVar) {
        super.a(aVar, iVar);
        iVar.rb("WebSocket Protocol Handshake");
        iVar.put("Server", "Java-WebSocket");
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        iVar.put("Date", simpleDateFormat.format(instance.getTime()));
        return iVar;
    }

    public final a XU() {
        return new d();
    }
}
