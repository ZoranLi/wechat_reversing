package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class an {

    static abstract class a<T> extends a {
        private com.google.android.gms.common.api.k.b<T> aHs;

        public a(com.google.android.gms.common.api.k.b<T> bVar) {
            this.aHs = bVar;
        }

        public final void ai(T t) {
            com.google.android.gms.common.api.k.b bVar = this.aHs;
            if (bVar != null) {
                bVar.V(t);
                this.aHs = null;
            }
        }
    }

    static final class f extends a {
        f() {
        }

        public final void f(Status status) {
        }
    }

    static final class b extends a<com.google.android.gms.wearable.c.c> {
        public b(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.c> bVar) {
            super(bVar);
        }

        public final void a(DeleteDataItemsResponse deleteDataItemsResponse) {
            ai(new com.google.android.gms.wearable.internal.bg.b(ak.cx(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.aGS));
        }
    }

    static final class c extends a<com.google.android.gms.wearable.n.a> {
        public c(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.n.a> bVar) {
            super(bVar);
        }

        public final void a(GetConnectedNodesResponse getConnectedNodesResponse) {
            List arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.aHb);
            ai(new com.google.android.gms.wearable.internal.ac.a(ak.cx(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class d extends a<com.google.android.gms.wearable.h> {
        public d(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.h> bVar) {
            super(bVar);
        }

        public final void b(DataHolder dataHolder) {
            ai(new com.google.android.gms.wearable.h(dataHolder));
        }
    }

    static final class e extends a<com.google.android.gms.wearable.c.d> {
        public e(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.d> bVar) {
            super(bVar);
        }

        public final void a(GetFdForAssetResponse getFdForAssetResponse) {
            ai(new com.google.android.gms.wearable.internal.bg.c(ak.cx(getFdForAssetResponse.statusCode), getFdForAssetResponse.aHd));
        }
    }

    static final class g extends a<com.google.android.gms.wearable.c.a> {
        private final List<FutureTask<Boolean>> aHt;

        g(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.a> bVar, List<FutureTask<Boolean>> list) {
            super(bVar);
            this.aHt = list;
        }

        public final void a(PutDataResponse putDataResponse) {
            ai(new com.google.android.gms.wearable.internal.bg.a(ak.cx(putDataResponse.statusCode), putDataResponse.aHc));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.aHt) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class h extends a<com.google.android.gms.wearable.k.b> {
        public h(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.k.b> bVar) {
            super(bVar);
        }

        public final void a(SendMessageResponse sendMessageResponse) {
            ai(new com.google.android.gms.wearable.internal.z.a(ak.cx(sendMessageResponse.statusCode), sendMessageResponse.atK));
        }
    }

    static final class i extends a<Status> {
        public i(com.google.android.gms.common.api.k.b<Status> bVar) {
            super(bVar);
        }

        public final void a(ChannelReceiveFileResponse channelReceiveFileResponse) {
            ai(new Status(channelReceiveFileResponse.statusCode));
        }
    }
}
