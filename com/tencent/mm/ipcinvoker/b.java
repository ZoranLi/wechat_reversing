package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.ipcinvoker.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b implements c {
    private static b gVC;
    private Map<String, Class<?>> gVD = new HashMap();
    public Map<String, a> gVE = new ConcurrentHashMap();
    private volatile boolean gVF;
    public ae mHandler;

    private static class a {
        com.tencent.mm.ipcinvoker.b.a gVK;
        ServiceConnection gVL;
        volatile boolean gVM;
        Runnable gVN;
    }

    public static b un() {
        if (gVC == null) {
            synchronized (b.class) {
                if (gVC == null) {
                    gVC = new b();
                }
            }
        }
        return gVC;
    }

    private b() {
        HandlerThread Qu = e.Qu("IPCBridgeThread#" + hashCode());
        Qu.start();
        this.mHandler = new ae(Qu.getLooper());
    }

    public final com.tencent.mm.ipcinvoker.b.a dQ(final String str) {
        a aVar = (a) this.gVE.get(str);
        if (aVar == null) {
            if (this.gVF) {
                w.i("IPC.IPCBridgeManager", "build IPCBridge(process : %s) failed, locked.", str);
                return null;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                w.w("IPC.IPCBridgeManager", "getIPCBridge failed, can not create bridge on Main thread.");
                return null;
            } else {
                Class cls = (Class) this.gVD.get(str);
                if (cls == null) {
                    w.w("IPC.IPCBridgeManager", "getServiceClass by '%s', got null.", str);
                    return null;
                }
                final a aVar2 = new a();
                synchronized (this.gVE) {
                    this.gVE.put(str, aVar2);
                }
                synchronized (aVar2) {
                    aVar2.gVM = true;
                }
                final Context context = d.getContext();
                aVar2.gVL = new ServiceConnection(this) {
                    final /* synthetic */ b gVI;

                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        if (iBinder == null) {
                            w.i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", Integer.valueOf(aVar2.hashCode()));
                            context.unbindService(aVar2.gVL);
                            this.gVI.gVE.remove(str);
                            aVar2.gVL = null;
                            aVar2.gVK = null;
                        } else {
                            w.i("IPC.IPCBridgeManager", "onServiceConnected(%s)", Integer.valueOf(aVar2.hashCode()));
                            aVar2.gVK = com.tencent.mm.ipcinvoker.b.a.a.z(iBinder);
                        }
                        if (aVar2.gVN != null) {
                            this.gVI.mHandler.removeCallbacks(aVar2.gVN);
                        }
                        synchronized (aVar2) {
                            aVar2.gVM = false;
                            aVar2.notifyAll();
                            aVar2.gVN = null;
                        }
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        w.i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                        this.gVI.gVE.remove(str);
                        aVar2.gVK = null;
                        synchronized (aVar2) {
                            aVar2.gVM = false;
                        }
                        aVar2.gVL = null;
                    }
                };
                try {
                    w.i("IPC.IPCBridgeManager", "bindService(bw : %s, tid : %s, intent : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()), new Intent(context, cls));
                    context.bindService(r4, aVar2.gVL, 1);
                    aVar2.gVN = new Runnable(this) {
                        final /* synthetic */ b gVI;

                        public final void run() {
                            w.i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", Integer.valueOf(aVar2.hashCode()), Long.valueOf(Thread.currentThread().getId()));
                            if (aVar2.gVM) {
                                synchronized (aVar2) {
                                    if (aVar2.gVM) {
                                        aVar2.gVM = false;
                                        aVar2.notifyAll();
                                        aVar2.gVN = null;
                                        synchronized (this.gVI.gVE) {
                                            this.gVI.gVE.remove(str);
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    };
                    this.mHandler.postDelayed(aVar2.gVN, Looper.myLooper() == Looper.getMainLooper() ? 3000 : 10000);
                    synchronized (aVar2) {
                        if (aVar2.gVM) {
                            aVar2.wait();
                        }
                    }
                    synchronized (aVar2) {
                        aVar2.gVM = false;
                    }
                    aVar = aVar2;
                } catch (InterruptedException e) {
                    try {
                        w.e("IPC.IPCBridgeManager", "%s", e);
                        synchronized (this.gVE) {
                            this.gVE.remove(str);
                            synchronized (aVar2) {
                                aVar2.gVM = false;
                                return null;
                            }
                        }
                    } catch (Throwable th) {
                        synchronized (aVar2) {
                            aVar2.gVM = false;
                        }
                    }
                } catch (Throwable e2) {
                    w.e("IPC.IPCBridgeManager", "bindService error : %s", Log.getStackTraceString(e2));
                    synchronized (this.gVE) {
                        this.gVE.remove(str);
                        synchronized (aVar2) {
                            aVar2.gVM = false;
                            return null;
                        }
                    }
                }
            }
        } else if (aVar.gVM) {
            try {
                synchronized (aVar) {
                    if (aVar.gVM) {
                        aVar.wait();
                    }
                }
            } catch (InterruptedException e3) {
                w.e("IPC.IPCBridgeManager", "%s", e3);
            }
        }
        return aVar.gVK;
    }

    public final void dR(final String str) {
        if (d.dS(str)) {
            w.i("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", str);
            return;
        }
        synchronized (this.gVE) {
            final a aVar = (a) this.gVE.get(str);
        }
        if (aVar == null) {
            w.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", str);
            return;
        }
        if (aVar.gVM) {
            synchronized (aVar) {
                aVar.gVM = false;
                aVar.notifyAll();
            }
        }
        if (aVar.gVL == null) {
            w.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
            return;
        }
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ b gVI;

            public final void run() {
                if (aVar.gVL == null) {
                    w.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", str);
                    return;
                }
                d.getContext().unbindService(aVar.gVL);
                synchronized (this.gVI.gVE) {
                    this.gVI.gVE.remove(str);
                }
                synchronized (aVar) {
                    aVar.gVK = null;
                    aVar.gVM = false;
                    aVar.gVL = null;
                }
            }
        });
    }

    public final synchronized void uo() {
        this.gVF = true;
    }

    public final <T extends BaseIPCService> void a(String str, Class<T> cls) {
        this.gVD.put(str, cls);
    }
}
