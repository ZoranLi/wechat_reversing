package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.a;

public final class d implements a {
    private AddrBookObserver jPP;
    private WatchDogPushReceiver jPQ;
    private TrafficStatsReceiver jPR;

    public final void a(Service service) {
        this.jPP = new AddrBookObserver(service);
        service.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.bCl(), true, this.jPP);
        this.jPQ = new WatchDogPushReceiver();
        service.registerReceiver(this.jPQ, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.jPR = new TrafficStatsReceiver();
        service.registerReceiver(this.jPR, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.at(service);
    }

    public final void b(Service service) {
        service.getContentResolver().unregisterContentObserver(this.jPP);
        service.unregisterReceiver(this.jPQ);
        service.unregisterReceiver(this.jPR);
        TrafficStatsReceiver.au(service);
    }
}
