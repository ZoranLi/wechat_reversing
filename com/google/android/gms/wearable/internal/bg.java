package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.FutureTask;

public final class bg implements com.google.android.gms.wearable.c {

    public static class a implements com.google.android.gms.wearable.c.a {
        private final Status aFq;
        private final f aHW;

        public a(Status status, f fVar) {
            this.aFq = status;
            this.aHW = fVar;
        }

        public final Status jv() {
            return this.aFq;
        }
    }

    public static class b implements com.google.android.gms.wearable.c.c {
        private final Status aFq;
        private final int aHX;

        public b(Status status, int i) {
            this.aFq = status;
            this.aHX = i;
        }

        public final Status jv() {
            return this.aFq;
        }
    }

    public static class c implements d {
        private final Status aFq;
        private volatile ParcelFileDescriptor aHY;
        private volatile InputStream aHZ;
        private volatile boolean mClosed = false;

        public c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.aFq = status;
            this.aHY = parcelFileDescriptor;
        }

        public final InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.aHY == null) {
                return null;
            } else {
                if (this.aHZ == null) {
                    this.aHZ = new AutoCloseInputStream(this.aHY);
                }
                return this.aHZ;
            }
        }

        public final Status jv() {
            return this.aFq;
        }

        public final void release() {
            if (this.aHY != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.aHZ != null) {
                        this.aHZ.close();
                    } else {
                        this.aHY.close();
                    }
                    this.mClosed = true;
                    this.aHY = null;
                    this.aHZ = null;
                } catch (IOException e) {
                }
            }
        }
    }

    class AnonymousClass3 extends aw<com.google.android.gms.wearable.c.c> {
        final /* synthetic */ Uri aGO;
        final /* synthetic */ bg aHT;
        final /* synthetic */ int aHU = 0;

        AnonymousClass3(bg bgVar, com.google.android.gms.common.api.c cVar, Uri uri, int i) {
            this.aHT = bgVar;
            this.aGO = uri;
            super(cVar);
        }

        protected final /* synthetic */ g b(Status status) {
            return new b(status, 0);
        }

        protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
            ao aoVar = (ao) bVar;
            ((x) aoVar.jY()).b(new b(this), this.aGO, this.aHU);
        }
    }

    public final e<h> a(com.google.android.gms.common.api.c cVar) {
        return cVar.a(new aw<h>(this, cVar) {
            final /* synthetic */ bg aHT;

            protected final /* synthetic */ g b(Status status) {
                return new h(DataHolder.bW(status.alZ));
            }

            protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
                ((x) ((ao) bVar).jY()).b(new d(this));
            }
        });
    }

    public final e<d> a(com.google.android.gms.common.api.c cVar, final Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.aFG == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.aFF == null) {
            return cVar.a(new aw<d>(this, cVar) {
                final /* synthetic */ bg aHT;

                protected final /* synthetic */ g b(Status status) {
                    return new c(status, null);
                }

                protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
                    ao aoVar = (ao) bVar;
                    ((x) aoVar.jY()).a(new e(this), asset);
                }
            });
        } else {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public final e<com.google.android.gms.wearable.c.a> a(com.google.android.gms.common.api.c cVar, final PutDataRequest putDataRequest) {
        return cVar.a(new aw<com.google.android.gms.wearable.c.a>(this, cVar) {
            final /* synthetic */ bg aHT;

            public final /* synthetic */ g b(Status status) {
                return new a(status, null);
            }

            protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
                ao aoVar = (ao) bVar;
                PutDataRequest putDataRequest = putDataRequest;
                for (Entry value : putDataRequest.mD().entrySet()) {
                    Asset asset = (Asset) value.getValue();
                    if (asset.aFF == null && asset.aFG == null && asset.aFH == null && asset.uri == null) {
                        throw new IllegalArgumentException("Put for " + putDataRequest.apg + " contains invalid asset: " + asset);
                    }
                }
                PutDataRequest e = PutDataRequest.e(putDataRequest.apg);
                e.aFF = putDataRequest.aFF;
                List arrayList = new ArrayList();
                for (Entry value2 : putDataRequest.mD().entrySet()) {
                    Asset asset2 = (Asset) value2.getValue();
                    if (asset2.aFF == null) {
                        e.b((String) value2.getKey(), (Asset) value2.getValue());
                    } else {
                        try {
                            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                            if (Log.isLoggable("WearableClient", 3)) {
                                new StringBuilder("processAssets: replacing data with FD in asset: ").append(asset2).append(" read:").append(createPipe[0]).append(" write:").append(createPipe[1]);
                            }
                            e.b((String) value2.getKey(), Asset.a(createPipe[0]));
                            Runnable futureTask = new FutureTask(new com.google.android.gms.wearable.internal.ao.AnonymousClass1(aoVar, createPipe[1], asset2.aFF));
                            arrayList.add(futureTask);
                            aoVar.aHu.submit(futureTask);
                        } catch (Throwable e2) {
                            throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e2);
                        }
                    }
                }
                ((x) aoVar.jY()).a(new g(this, arrayList), e);
            }
        });
    }

    public final e<com.google.android.gms.wearable.c.c> b(com.google.android.gms.common.api.c cVar, Uri uri) {
        return cVar.a(new AnonymousClass3(this, cVar, uri, 0));
    }
}
