package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static final HashMap<String, MMToClientEvent> iKw = new HashMap();

    public static void a(MMToClientEvent mMToClientEvent) {
        w.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", new Object[]{mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode())});
        if (mMToClientEvent.appId == null) {
            w.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            return;
        }
        synchronized (iKw) {
            if (iKw.get(mMToClientEvent.appId) == null) {
                iKw.put(mMToClientEvent.appId, mMToClientEvent);
            } else {
                w.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                iKw.remove(mMToClientEvent.appId);
                iKw.put(mMToClientEvent.appId, mMToClientEvent);
            }
        }
    }

    public static void b(MMToClientEvent mMToClientEvent) {
        w.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", new Object[]{mMToClientEvent.appId});
        synchronized (iKw) {
            iKw.remove(mMToClientEvent.appId);
        }
    }

    public static void f(String str, int i, String str2) {
        w.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", new Object[]{str, Integer.valueOf(i), str2});
        synchronized (iKw) {
            MMToClientEvent mMToClientEvent = (MMToClientEvent) iKw.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.iKo = 3;
                mMToClientEvent.appId = str;
                mMToClientEvent.type = i;
                mMToClientEvent.fJu = str2;
                mMToClientEvent.SL();
            }
            return;
        }
        w.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static void ac(String str, int i) {
        w.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", new Object[]{Integer.valueOf(i)});
        synchronized (iKw) {
            MMToClientEvent mMToClientEvent = (MMToClientEvent) iKw.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.iKo = 4;
                mMToClientEvent.fCK = i;
                mMToClientEvent.SL();
            }
            return;
        }
        w.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static <T extends Parcelable> void a(T t) {
        if (t != null) {
            MMToClientEvent mMToClientEvent;
            LinkedList linkedList = new LinkedList();
            synchronized (iKw) {
                for (MMToClientEvent mMToClientEvent2 : iKw.values()) {
                    linkedList.add(mMToClientEvent2);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                mMToClientEvent2 = (MMToClientEvent) it.next();
                if (t != null) {
                    synchronized (mMToClientEvent2) {
                        mMToClientEvent2.iKo = 5;
                        mMToClientEvent2.iKp = t.getClass().getName();
                        mMToClientEvent2.iKq = t;
                        mMToClientEvent2.SL();
                    }
                }
            }
        }
    }
}
