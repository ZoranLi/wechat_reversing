package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.w;

public class e {

    private static class a implements a {
        private a() {
        }

        public final void a(Bundle bundle, final c cVar) {
            Parcelable parcelable = bundle.getParcelable("__remote_task_data");
            String string = bundle.getString("__remote_task_class");
            if (string == null || string.length() == 0) {
                w.e("IPC.IPCInvoker", "proxy AsyncInvoke failed, class is null or nil.");
                return;
            }
            g gVar = (g) n.b(string, g.class);
            if (gVar == null) {
                w.w("IPC.IPCInvoker", "proxy AsyncInvoke failed, newInstance(%s) return null.", string);
                return;
            }
            gVar.a(parcelable, new h<Parcelable>(this) {
                final /* synthetic */ a gVW;

                public final /* synthetic */ void ak(Object obj) {
                    Parcelable parcelable = (Parcelable) obj;
                    if (cVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("__remote_task_result_data", parcelable);
                        cVar.k(bundle);
                    }
                }
            });
        }
    }

    private static class b implements k {
        private b() {
        }

        public final Bundle l(Bundle bundle) {
            Parcelable parcelable = bundle.getParcelable("__remote_task_data");
            String string = bundle.getString("__remote_task_class");
            if (string == null || string.length() == 0) {
                w.e("IPC.IPCInvoker", "proxy SyncInvoke failed, class is null or nil.");
                return null;
            }
            i iVar = (i) n.b(string, i.class);
            if (iVar == null) {
                w.w("IPC.IPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", string);
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("__remote_task_result_data", (Parcelable) iVar.al(parcelable));
            return bundle2;
        }
    }

    public static <T extends a> boolean a(final String str, final Bundle bundle, final Class<T> cls, final c cVar) {
        if (str != null && str.length() != 0) {
            return l.d(new Runnable() {
                public final void run() {
                    if (d.dS(str)) {
                        a aVar = (a) n.a(cls, a.class);
                        if (aVar == null) {
                            w.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", cls);
                            return;
                        }
                        aVar.a(bundle, cVar);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.a dQ = b.un().dQ(str);
                    if (dQ == null) {
                        w.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", str);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.b bVar = null;
                    try {
                        if (cVar != null) {
                            bVar = new com.tencent.mm.ipcinvoker.b.b.a(this) {
                                final /* synthetic */ AnonymousClass1 gVS;

                                {
                                    this.gVS = r1;
                                }

                                public final void k(Bundle bundle) {
                                    if (bundle != null) {
                                        bundle.setClassLoader(e.class.getClassLoader());
                                    }
                                    cVar.k(bundle);
                                }
                            };
                        }
                        dQ.a(bundle, cls.getName(), bVar);
                    } catch (RemoteException e) {
                        w.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e);
                    }
                }
            });
        }
        w.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.");
        return false;
    }

    public static <T extends k> Bundle a(String str, Bundle bundle, Class<T> cls) {
        if (str.length() == 0) {
            w.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.");
            return null;
        } else if (d.dS(str)) {
            k kVar = (k) n.a(cls, k.class);
            if (kVar != null) {
                return kVar.l(bundle);
            }
            w.e("IPC.IPCInvoker", "invokeSync failed, newInstance(%s) return null.", cls);
            return null;
        } else {
            com.tencent.mm.ipcinvoker.b.a dQ = b.un().dQ(str);
            if (dQ == null) {
                w.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                return null;
            }
            try {
                Bundle d = dQ.d(bundle, cls.getName());
                if (d == null) {
                    return d;
                }
                d.setClassLoader(e.class.getClassLoader());
                return d;
            } catch (RemoteException e) {
                w.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e);
                return null;
            }
        }
    }

    public static <T extends g<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(final String str, final InputType inputType, final Class<T> cls, final h<ResultType> hVar) {
        if (str != null && str.length() != 0) {
            return l.d(new Runnable() {
                public final void run() {
                    if (d.dS(str)) {
                        ((a) n.a(a.class, a.class)).a(e.a(inputType, cls), new c(this) {
                            final /* synthetic */ AnonymousClass2 gVV;

                            {
                                this.gVV = r1;
                            }

                            public final void k(Bundle bundle) {
                                if (hVar != null) {
                                    bundle.setClassLoader(e.class.getClassLoader());
                                    hVar.ak(bundle.getParcelable("__remote_task_result_data"));
                                }
                            }
                        });
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.a dQ = b.un().dQ(str);
                    if (dQ == null) {
                        w.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", str);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.b.b bVar = null;
                    try {
                        if (hVar != null) {
                            bVar = new com.tencent.mm.ipcinvoker.b.b.a(this) {
                                final /* synthetic */ AnonymousClass2 gVV;

                                {
                                    this.gVV = r1;
                                }

                                public final void k(Bundle bundle) {
                                    bundle.setClassLoader(e.class.getClassLoader());
                                    hVar.ak(bundle.getParcelable("__remote_task_result_data"));
                                }
                            };
                        }
                        dQ.a(e.a(inputType, cls), a.class.getName(), bVar);
                    } catch (RemoteException e) {
                        w.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", e);
                    }
                }
            });
        }
        w.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.");
        return false;
    }

    public static <T extends i<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String str, InputType inputType, Class<T> cls) {
        if (str == null || str.length() == 0) {
            w.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.");
            return null;
        } else if (d.dS(str)) {
            r0 = ((b) n.a(b.class, b.class)).l(a(inputType, cls));
            if (r0 == null) {
                return null;
            }
            r0.setClassLoader(e.class.getClassLoader());
            return r0.getParcelable("__remote_task_result_data");
        } else {
            com.tencent.mm.ipcinvoker.b.a dQ = b.un().dQ(str);
            if (dQ == null) {
                w.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", str);
                return null;
            }
            try {
                r0 = dQ.d(a(inputType, cls), b.class.getName());
                if (r0 == null) {
                    return null;
                }
                r0.setClassLoader(e.class.getClassLoader());
                return r0.getParcelable("__remote_task_result_data");
            } catch (RemoteException e) {
                w.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", e);
                return null;
            }
        }
    }

    public static Bundle a(Parcelable parcelable, Class<?> cls) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("__remote_task_data", parcelable);
        bundle.putString("__remote_task_class", cls.getName());
        return bundle;
    }
}
