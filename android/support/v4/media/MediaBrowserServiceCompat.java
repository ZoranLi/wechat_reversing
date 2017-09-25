package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    private final android.support.v4.e.a<IBinder, b> uh = new android.support.v4.e.a();
    private final f ui = new f();
    Token uj;

    public static final class a {
        final Bundle mExtras;
        final String up;
    }

    private class b {
        final /* synthetic */ MediaBrowserServiceCompat un;
        String uq;
        Bundle ur;
        d us;
        a ut;
        HashMap<String, List<Bundle>> uu = new HashMap();

        public b(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.un = mediaBrowserServiceCompat;
        }
    }

    public static class c<T> {
        int uf;
        Object uv;
        private boolean uw;
        boolean ux;

        c(Object obj) {
            this.uv = obj;
        }

        final boolean isDone() {
            return this.uw || this.ux;
        }

        void b(T t, int i) {
        }
    }

    private interface d {
        void a(String str, Token token, Bundle bundle);

        void a(String str, List<MediaItem> list, Bundle bundle);

        IBinder asBinder();

        void bx();
    }

    private final class f extends Handler {
        final /* synthetic */ MediaBrowserServiceCompat un;
        private final g uz;

        private f(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.un = mediaBrowserServiceCompat;
            this.uz = new g(this.un);
        }

        public final void handleMessage(Message message) {
            Bundle data = message.getData();
            g gVar;
            g gVar2;
            String string;
            switch (message.what) {
                case 1:
                    gVar = this.uz;
                    String string2 = data.getString("data_package_name");
                    int i = data.getInt("data_calling_uid");
                    Bundle bundle = data.getBundle("data_root_hints");
                    d eVar = new e(this.un, message.replyTo);
                    if (MediaBrowserServiceCompat.a(gVar.un, string2, i)) {
                        gVar.un.ui.b(new AnonymousClass1(gVar, eVar, string2, bundle, i));
                        return;
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + string2);
                case 2:
                    gVar2 = this.uz;
                    gVar2.un.ui.b(new AnonymousClass2(gVar2, new e(this.un, message.replyTo)));
                    return;
                case 3:
                    gVar = this.uz;
                    string = data.getString("data_media_item_id");
                    data = data.getBundle("data_options");
                    gVar.un.ui.b(new AnonymousClass3(gVar, new e(this.un, message.replyTo), string, data));
                    return;
                case 4:
                    gVar = this.uz;
                    string = data.getString("data_media_item_id");
                    data = data.getBundle("data_options");
                    gVar.un.ui.b(new AnonymousClass4(gVar, new e(this.un, message.replyTo), string, data));
                    return;
                case 5:
                    gVar = this.uz;
                    Object string3 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    if (!TextUtils.isEmpty(string3) && resultReceiver != null) {
                        gVar.un.ui.b(new AnonymousClass5(gVar, string3, resultReceiver));
                        return;
                    }
                    return;
                case 6:
                    gVar2 = this.uz;
                    gVar2.un.ui.b(new AnonymousClass6(gVar2, new e(this.un, message.replyTo)));
                    return;
                case 7:
                    gVar2 = this.uz;
                    gVar2.un.ui.b(new AnonymousClass7(gVar2, new e(this.un, message.replyTo)));
                    return;
                default:
                    new StringBuilder("Unhandled message: ").append(message).append("\n  Service version: 1\n  Client version: ").append(message.arg1);
                    return;
            }
        }

        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        private void b(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private class g {
        final /* synthetic */ MediaBrowserServiceCompat un;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ d uA;
            final /* synthetic */ String uB;
            final /* synthetic */ Bundle uC;
            final /* synthetic */ int uD;
            final /* synthetic */ g uE;

            AnonymousClass1(g gVar, d dVar, String str, Bundle bundle, int i) {
                this.uE = gVar;
                this.uA = dVar;
                this.uB = str;
                this.uC = bundle;
                this.uD = i;
            }

            public final void run() {
                IBinder asBinder = this.uA.asBinder();
                this.uE.un.uh.remove(asBinder);
                b bVar = new b(this.uE.un);
                bVar.uq = this.uB;
                bVar.ur = this.uC;
                bVar.us = this.uA;
                bVar.ut = this.uE.un.bw();
                if (bVar.ut == null) {
                    new StringBuilder("No root for client ").append(this.uB).append(" from service ").append(getClass().getName());
                    try {
                        this.uA.bx();
                        return;
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.uB);
                        return;
                    }
                }
                try {
                    this.uE.un.uh.put(asBinder, bVar);
                    if (this.uE.un.uj != null) {
                        this.uA.a(bVar.ut.up, this.uE.un.uj, bVar.ut.mExtras);
                    }
                } catch (RemoteException e2) {
                    new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.uB);
                    this.uE.un.uh.remove(asBinder);
                }
            }
        }

        class AnonymousClass2 implements Runnable {
            final /* synthetic */ d uA;
            final /* synthetic */ g uE;

            AnonymousClass2(g gVar, d dVar) {
                this.uE = gVar;
                this.uA = dVar;
            }

            public final void run() {
                this.uE.un.uh.remove(this.uA.asBinder());
            }
        }

        class AnonymousClass3 implements Runnable {
            final /* synthetic */ d uA;
            final /* synthetic */ g uE;
            final /* synthetic */ String uF;
            final /* synthetic */ Bundle um;

            AnonymousClass3(g gVar, d dVar, String str, Bundle bundle) {
                this.uE = gVar;
                this.uA = dVar;
                this.uF = str;
                this.um = bundle;
            }

            public final void run() {
                b bVar = (b) this.uE.un.uh.get(this.uA.asBinder());
                if (bVar == null) {
                    new StringBuilder("addSubscription for callback that isn't registered id=").append(this.uF);
                } else {
                    MediaBrowserServiceCompat.a(this.uE.un, this.uF, bVar, this.um);
                }
            }
        }

        class AnonymousClass4 implements Runnable {
            final /* synthetic */ d uA;
            final /* synthetic */ g uE;
            final /* synthetic */ String uF;
            final /* synthetic */ Bundle um;

            AnonymousClass4(g gVar, d dVar, String str, Bundle bundle) {
                this.uE = gVar;
                this.uA = dVar;
                this.uF = str;
                this.um = bundle;
            }

            public final void run() {
                b bVar = (b) this.uE.un.uh.get(this.uA.asBinder());
                if (bVar == null) {
                    new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.uF);
                } else if (!MediaBrowserServiceCompat.a(this.uF, bVar, this.um)) {
                    new StringBuilder("removeSubscription called for ").append(this.uF).append(" which is not subscribed");
                }
            }
        }

        class AnonymousClass5 implements Runnable {
            final /* synthetic */ g uE;
            final /* synthetic */ String uG;
            final /* synthetic */ ResultReceiver uo;

            AnonymousClass5(g gVar, String str, ResultReceiver resultReceiver) {
                this.uE = gVar;
                this.uG = str;
                this.uo = resultReceiver;
            }

            public final void run() {
                MediaBrowserServiceCompat.a(this.uE.un, this.uG, this.uo);
            }
        }

        class AnonymousClass6 implements Runnable {
            final /* synthetic */ d uA;
            final /* synthetic */ g uE;

            AnonymousClass6(g gVar, d dVar) {
                this.uE = gVar;
                this.uA = dVar;
            }

            public final void run() {
                IBinder asBinder = this.uA.asBinder();
                this.uE.un.uh.remove(asBinder);
                b bVar = new b(this.uE.un);
                bVar.us = this.uA;
                this.uE.un.uh.put(asBinder, bVar);
            }
        }

        class AnonymousClass7 implements Runnable {
            final /* synthetic */ d uA;
            final /* synthetic */ g uE;

            AnonymousClass7(g gVar, d dVar) {
                this.uE = gVar;
                this.uA = dVar;
            }

            public final void run() {
                this.uE.un.uh.remove(this.uA.asBinder());
            }
        }

        public g(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.un = mediaBrowserServiceCompat;
        }
    }

    private class h {
    }

    private class e implements d {
        final /* synthetic */ MediaBrowserServiceCompat un;
        final Messenger uy;

        e(MediaBrowserServiceCompat mediaBrowserServiceCompat, Messenger messenger) {
            this.un = mediaBrowserServiceCompat;
            this.uy = messenger;
        }

        public final IBinder asBinder() {
            return this.uy.getBinder();
        }

        public final void a(String str, Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            a(1, bundle2);
        }

        public final void bx() {
            a(2, null);
        }

        public final void a(String str, List<MediaItem> list, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            if (list != null) {
                String str2 = "data_media_item_list";
                if (list instanceof ArrayList) {
                    list = (ArrayList) list;
                } else {
                    Object arrayList = new ArrayList(list);
                }
                bundle2.putParcelableArrayList(str2, list);
            }
            a(3, bundle2);
        }

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            this.uy.send(obtain);
        }
    }

    private class i extends h {
    }

    public abstract a bw();

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, b bVar, Bundle bundle) {
        List list = (List) bVar.uu.get(str);
        List<Bundle> arrayList = list == null ? new ArrayList() : list;
        for (Bundle a : arrayList) {
            if (a.a(bundle, a)) {
                return;
            }
        }
        arrayList.add(bundle);
        bVar.uu.put(str, arrayList);
        final b bVar2 = bVar;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        c anonymousClass1 = new c<List<MediaItem>>(mediaBrowserServiceCompat, str) {
            final /* synthetic */ MediaBrowserServiceCompat un;

            final /* synthetic */ void b(Object obj, int i) {
                List list = null;
                if (this.un.uh.get(bVar2.us.asBinder()) == bVar2) {
                    List list2;
                    if ((i & 1) != 0) {
                        Bundle bundle = bundle2;
                        int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                        int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                        if (!(i2 == -1 && i3 == -1)) {
                            int i4 = i3 * (i2 - 1);
                            int i5 = i4 + i3;
                            if (i2 <= 0 || i3 <= 0 || i4 >= list.size()) {
                                list2 = list;
                                bVar2.us.a(str2, list2, bundle2);
                            }
                            if (i5 > list.size()) {
                                i5 = list.size();
                            }
                            list2 = list.subList(i4, i5);
                            bVar2.us.a(str2, list2, bundle2);
                        }
                    }
                    list2 = list;
                    try {
                        bVar2.us.a(str2, list2, bundle2);
                    } catch (RemoteException e) {
                        new StringBuilder("Calling onLoadChildren() failed for id=").append(str2).append(" package=").append(bVar2.uq);
                    }
                }
            }
        };
        if (bundle != null) {
            anonymousClass1.uf = 1;
        }
        if (!anonymousClass1.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.uq + " id=" + str);
        }
    }

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, final ResultReceiver resultReceiver) {
        c anonymousClass2 = new c<MediaItem>(mediaBrowserServiceCompat, str) {
            final /* synthetic */ MediaBrowserServiceCompat un;

            final /* synthetic */ void b(Object obj, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", null);
                ResultReceiver resultReceiver = resultReceiver;
                if (resultReceiver.vq) {
                    if (resultReceiver.mHandler != null) {
                        resultReceiver.mHandler.post(new b(resultReceiver, 0, bundle));
                    } else {
                        resultReceiver.onReceiveResult(0, bundle);
                    }
                } else if (resultReceiver.vr != null) {
                    try {
                        resultReceiver.vr.send(0, bundle);
                    } catch (RemoteException e) {
                    }
                }
            }
        };
        if (anonymousClass2.ux) {
            throw new IllegalStateException("sendResult() called twice for: " + anonymousClass2.uv);
        }
        anonymousClass2.ux = true;
        anonymousClass2.b(null, anonymousClass2.uf);
        if (!anonymousClass2.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    static /* synthetic */ boolean a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : mediaBrowserServiceCompat.getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean a(String str, b bVar, Bundle bundle) {
        List<Bundle> list = (List) bVar.uu.get(str);
        if (list == null) {
            return false;
        }
        boolean z;
        for (Bundle bundle2 : list) {
            if (a.a(bundle, bundle2)) {
                list.remove(bundle2);
                z = true;
                break;
            }
        }
        z = false;
        if (list.size() != 0) {
            return z;
        }
        bVar.uu.remove(str);
        return z;
    }
}
