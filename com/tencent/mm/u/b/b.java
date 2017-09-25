package com.tencent.mm.u.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b {
    private boolean hoJ = false;
    public ArrayList<a> mListeners = new ArrayList();

    public interface a {
        void Ar();
    }

    public enum b {
        Main,
        Chatting
    }

    public static String Ah() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
    }

    public static String Ai() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
    }

    public static boolean Aj() {
        ap.yY();
        return ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    public static String Ak() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
    }

    public static String Al() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
    }

    public static boolean Am() {
        ap.yY();
        return ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    public static boolean An() {
        ap.yY();
        return ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    private static boolean Ao() {
        ap.yY();
        return ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    public final void k(Map<String, String> map) {
        if (map != null) {
            g.oUh.a(633, 3, 1, false);
            Object obj = (String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.url");
            Object obj2 = (String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.wording");
            long j = bg.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.duration"), 0);
            boolean z = bg.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.autotrigger"), 0) == 1;
            boolean z2 = bg.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.closable"), 0) == 1;
            Object obj3 = (String) map.get(".sysmsg.banner.monitorbanner_n.chatting.url");
            Object obj4 = (String) map.get(".sysmsg.banner.monitorbanner_n.chatting.wording");
            long j2 = bg.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.duration"), 0);
            boolean z3 = bg.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.autotrigger"), 0) == 1;
            boolean z4 = bg.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.closable"), 0) == 1;
            if (!bg.mA(obj2) || !bg.mA(obj4)) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, obj4);
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, obj3);
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j2));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z4));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z3));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, obj2);
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, obj);
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z2));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(bg.Ny()));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.valueOf(false));
                Ap();
            }
        }
    }

    public static boolean a(b bVar) {
        long longValue;
        boolean booleanValue;
        boolean An;
        String Ak;
        w.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", bVar);
        long Ny = bg.Ny();
        ap.yY();
        long longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(-1))).longValue();
        if (bVar == b.Chatting) {
            ap.yY();
            longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            ap.yY();
            booleanValue = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
            An = An();
            Ak = Ak();
        } else {
            ap.yY();
            longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            ap.yY();
            booleanValue = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
            ap.yY();
            An = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
            Ak = Ah();
        }
        if (bg.mA(Ak)) {
            w.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
            return false;
        } else if (booleanValue) {
            w.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
            return false;
        } else if (longValue2 < 0) {
            w.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
            return false;
        } else if (An && !Ao()) {
            w.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
            return false;
        } else if (longValue == -1) {
            w.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
            return true;
        } else if (longValue2 + longValue > Ny) {
            w.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
            return true;
        } else {
            w.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
            return false;
        }
    }

    public final void Ap() {
        synchronized (b.class) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((a) it.next()).Ar();
            }
        }
    }

    public final void Aq() {
        if (!Ao()) {
            w.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(bg.Ny()));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.valueOf(true));
            Ap();
        }
    }

    public final void b(b bVar) {
        if (bVar == b.Main) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
        } else {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
        }
        Ap();
    }
}
