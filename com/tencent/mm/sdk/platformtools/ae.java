package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ae implements com.tencent.mm.sdk.platformtools.ag.a {
    private static final String TAG = "MicroMsg.MMHandler";
    private static b sLogCallback;
    private ag handler;
    private int latestSize;
    private LinkedList<WeakReference<ak>> latestTasks;
    private ConcurrentHashMap<Runnable, WeakReference<ak>> map;
    private String toStringResult;

    public interface a extends Callback {
    }

    public interface b {
        void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f);
    }

    public ae() {
        this.map = new ConcurrentHashMap();
        this.latestTasks = new LinkedList();
        this.toStringResult = null;
        this.handler = new ag(this);
        if (getLooper().getThread().getName().equals("initThread")) {
            w.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bg.bJZ());
        }
    }

    public ae(Looper looper) {
        this.map = new ConcurrentHashMap();
        this.latestTasks = new LinkedList();
        this.toStringResult = null;
        this.handler = new ag(looper, (com.tencent.mm.sdk.platformtools.ag.a) this);
        if (looper.getThread().getName().equals("initThread")) {
            w.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bg.bJZ());
        }
    }

    public ae(a aVar) {
        this.map = new ConcurrentHashMap();
        this.latestTasks = new LinkedList();
        this.toStringResult = null;
        this.handler = new ag((Callback) aVar, (com.tencent.mm.sdk.platformtools.ag.a) this);
        if (getLooper().getThread().getName().equals("initThread")) {
            w.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bg.bJZ());
        }
    }

    public ae(Looper looper, a aVar) {
        this.map = new ConcurrentHashMap();
        this.latestTasks = new LinkedList();
        this.toStringResult = null;
        this.handler = new ag(looper, aVar, this);
        if (looper.getThread().getName().equals("initThread")) {
            w.e(TAG, "MMHandler can not init handler with initThread looper, stack %s", bg.bJZ());
        }
    }

    @TargetApi(14)
    public String getMessageName(Message message) {
        if (VERSION.SDK_INT >= 14) {
            return this.handler.getMessageName(message);
        }
        if (message.getCallback() != null) {
            return message.getCallback().getClass().getName();
        }
        return "0x" + Integer.toHexString(message.what);
    }

    public final Message obtainMessage() {
        return this.handler.obtainMessage();
    }

    public final Message obtainMessage(int i) {
        return this.handler.obtainMessage(i);
    }

    public final Message obtainMessage(int i, Object obj) {
        return this.handler.obtainMessage(i, obj);
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        return this.handler.obtainMessage(i, i2, i3);
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        return this.handler.obtainMessage(i, i2, i3, obj);
    }

    public final boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    public final boolean postAtTime(Runnable runnable, long j) {
        return this.handler.postAtTime(runnable, j);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        return this.handler.postAtTime(runnable, obj, j);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return this.handler.postDelayed(runnable, j);
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return this.handler.postAtFrontOfQueue(runnable);
    }

    public final boolean postAtFrontOfQueueV2(Runnable runnable) {
        return this.handler.sendMessageAtTime(Message.obtain(this.handler, runnable), 0);
    }

    public final void removeCallbacks(Runnable runnable) {
        if (runnable != null) {
            WeakReference weakReference = (WeakReference) this.map.get(runnable);
            if (!(weakReference == null || weakReference.get() == null)) {
                this.handler.removeCallbacks((Runnable) weakReference.get());
            }
            this.map.remove(runnable);
        }
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        if (runnable != null) {
            WeakReference weakReference = (WeakReference) this.map.get(runnable);
            if (!(weakReference == null || weakReference.get() == null || (obj != null && ((ak) weakReference.get()).utz != obj))) {
                this.handler.removeCallbacks((Runnable) weakReference.get(), obj);
            }
            this.map.remove(runnable);
        }
    }

    public final boolean sendMessage(Message message) {
        return this.handler.sendMessage(message);
    }

    public final boolean sendEmptyMessage(int i) {
        return this.handler.sendEmptyMessage(i);
    }

    public final boolean sendEmptyMessageDelayed(int i, long j) {
        return this.handler.sendEmptyMessageDelayed(i, j);
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        return this.handler.sendEmptyMessageAtTime(i, j);
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        return this.handler.sendMessageDelayed(message, j);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        return this.handler.sendMessageAtTime(message, j);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        return this.handler.sendMessageAtFrontOfQueue(message);
    }

    public final void removeMessages(int i) {
        this.handler.removeMessages(i);
    }

    public final void removeMessages(int i, Object obj) {
        this.handler.removeMessages(i, obj);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
        if (obj == null) {
            this.map.clear();
            return;
        }
        Iterator it = this.map.entrySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry != null) {
                    WeakReference weakReference = (WeakReference) entry.getValue();
                    if (!(weakReference == null || weakReference.get() == null || ((ak) weakReference.get()).utz != obj)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final boolean hasMessages(int i) {
        return this.handler.hasMessages(i);
    }

    public final boolean hasMessages(int i, Object obj) {
        return this.handler.hasMessages(i, obj);
    }

    public final Looper getLooper() {
        return this.handler.getLooper();
    }

    public final void dump(Printer printer, String str) {
        this.handler.dump(printer, str);
    }

    public String toString() {
        if (this.toStringResult == null) {
            this.toStringResult = "MMHandler(" + getClass().getName() + ")";
        }
        return this.toStringResult;
    }

    public void handleMessage(Message message) {
    }

    public final void onTaskAdded(Runnable runnable, ak akVar) {
        this.map.put(runnable, new WeakReference(akVar));
    }

    public final void onTaskRunEnd(Runnable runnable, ak akVar) {
        WeakReference weakReference = (WeakReference) this.map.get(runnable);
        if (weakReference != null && weakReference.get() != null && weakReference.get() == akVar) {
            this.map.remove(runnable);
            if (this.latestSize > 0) {
                if (this.latestTasks.size() == this.latestSize) {
                    this.latestTasks.pop();
                }
                this.latestTasks.add(weakReference);
            }
        }
    }

    public static Handler fetchFreeHandler() {
        return new Handler();
    }

    public static Handler fetchFreeHandler(Looper looper) {
        return new Handler(looper);
    }

    public static Handler fetchFreeHandler(a aVar) {
        return new Handler(aVar);
    }

    public static Handler fetchFreeHandler(Looper looper, a aVar) {
        return new Handler(looper, aVar);
    }

    public static void setLogCallback(b bVar) {
        sLogCallback = bVar;
    }

    public void onLog(Message message, Runnable runnable, Thread thread, long j, long j2, float f) {
        if (sLogCallback != null) {
            sLogCallback.onLog(message, runnable, thread, j, j2, f);
        }
    }

    public void setLatestSize(int i) {
        this.latestSize = i;
    }

    public String dumpLatestTasks(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList linkedList = new LinkedList(this.latestTasks);
        stringBuilder.append("|MMHandler latest(" + linkedList.size() + ") tasks done info");
        Iterator it = linkedList.iterator();
        if (it != null) {
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    stringBuilder.append("[index = " + i + "|task=" + ((ak) weakReference.get()).dump(z) + "]");
                }
                i++;
            }
        }
        linkedList.clear();
        return stringBuilder.toString();
    }

    public String dump(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(this.map);
        stringBuilder.append("tasks info size = " + concurrentHashMap.size() + '\n');
        Iterator it = concurrentHashMap.values().iterator();
        if (it != null) {
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    stringBuilder.append("[index = " + i + " | taskinfo:" + ((ak) weakReference.get()).dump(z) + "]\n");
                }
                i++;
            }
        }
        concurrentHashMap.clear();
        return stringBuilder.toString();
    }

    public static String dump(Runnable runnable, boolean z) {
        if (runnable == null) {
            return "";
        }
        if (runnable instanceof ak) {
            return ((ak) runnable).dump(z);
        }
        return runnable.toString();
    }

    public Runnable findTaskByRunTime(long j) {
        Iterator it = new ConcurrentHashMap(this.map).values().iterator();
        long currentTimeMillis = System.currentTimeMillis();
        if (it != null) {
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    ak akVar = (ak) weakReference.get();
                    if (akVar.started && akVar.hpu >= akVar.utB && currentTimeMillis - akVar.hpu > j) {
                        w.i(TAG, "findTaskByRunTime limit: %d, found task info: %s", Long.valueOf(j), akVar.dump(true));
                        return akVar;
                    }
                }
            }
        }
        w.i(TAG, "findTaskByRunTime limit: %d, not found!", Long.valueOf(j));
        return null;
    }

    public Runnable findTaskByName(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Iterator it = new ConcurrentHashMap(this.map).values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (!(weakReference == null || weakReference.get() == null)) {
                    ak akVar = (ak) weakReference.get();
                    if (akVar.mjV.equals(str)) {
                        w.i(TAG, "findTaskByName: %s, found task info: %s", str, akVar.dump(true));
                        return akVar;
                    }
                }
            }
        }
        w.i(TAG, "findTaskByName: %s, not found!", str);
        return null;
    }
}
