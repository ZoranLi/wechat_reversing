package com.b.a;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class a {
    public a aIA;
    private int aIB;
    public b aIC;
    public int aID = -1;
    public DeathRecipient aIE = new DeathRecipient(this) {
        final /* synthetic */ a aIF;

        {
            this.aIF = r1;
        }

        public final void binderDied() {
            if (this.aIF.aIC != null) {
                this.aIF.aIC.av(2101, -1);
            }
        }
    };
    public c aIy;
    public b aIz;

    private class a extends Handler {
        final /* synthetic */ a aIF;
        private final int aIG = MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN;
        private final int aIH = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
        private final int aII = MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK;
        private final int aIJ = 2004;
        private final int aIK = 2005;
        private final int aIL = 2006;

        public a(a aVar, Looper looper) {
            this.aIF = aVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = 2005;
            new StringBuilder("what = ").append(message.what);
            switch (message.what) {
                case 1:
                    if (this.aIF.aIC == null) {
                        return;
                    }
                    return;
                case 2:
                    if (this.aIF.aIC == null) {
                        return;
                    }
                    return;
                case 3:
                    if (this.aIF.aIC == null) {
                        return;
                    }
                    return;
                case 6:
                    if (this.aIF.aIC != null) {
                        this.aIF.aIC.av(0, message.arg1);
                    }
                    removeMessages(8);
                    return;
                case 7:
                    if (this.aIF.aIC != null) {
                        switch (message.arg1) {
                            case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                                i = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                                break;
                            case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                                i = MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK;
                                break;
                            case MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK /*2003*/:
                            case 2006:
                                break;
                            case 2004:
                                i = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
                                break;
                            case 2005:
                                i = 2006;
                                break;
                            default:
                                i = 2020;
                                break;
                        }
                        this.aIF.aIC.av(i, -1);
                    }
                    removeMessages(8);
                    return;
                case 8:
                    if (this.aIF.aIC != null) {
                        this.aIF.aIC.av(MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN, -1);
                    }
                    removeMessages(8);
                    this.aIF.abort();
                    return;
                default:
                    return;
            }
        }
    }

    public interface b {
        void av(int i, int i2);
    }

    public static a mZ() {
        c nc = nc();
        if (nc == null) {
            return null;
        }
        try {
            return new a(nc, Looper.getMainLooper(), 1);
        } catch (Exception e) {
            return null;
        }
    }

    private a(c cVar, Looper looper, int i) {
        this.aIy = cVar;
        a aVar = new a(this, looper);
        this.aIB = 1;
        this.aIz = new com.b.a.b.a(this) {
            final /* synthetic */ a aIF;

            {
                this.aIF = r1;
            }

            public final void a(int i, int i2, int i3, byte[] bArr) {
                this.aIF.aIA.sendMessage(this.aIF.aIA.obtainMessage(i, i2, i3, bArr));
            }
        };
        if (this.aIy.a(this.aIz, 1)) {
            this.aIA = aVar;
            cVar.asBinder().linkToDeath(this.aIE, 0);
            return;
        }
        throw new RuntimeException();
    }

    public final int[] na() {
        try {
            return this.aIy.c(this.aIz);
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public final int a(b bVar, int i, int[] iArr) {
        int i2 = -1;
        if (!(iArr == null || bVar == null)) {
            if (i > 0) {
                new StringBuilder("startIdentify send message timeout after ").append(i).append(" ms");
                this.aIA.sendMessageDelayed(this.aIA.obtainMessage(8), (long) i);
            }
            this.aIC = bVar;
            this.aID = 0;
            try {
                i2 = this.aIy.a(this.aIz, iArr, null);
            } catch (RemoteException e) {
            }
        }
        return i2;
    }

    public final void abort() {
        if (this.aIA != null) {
            this.aIA.removeMessages(8);
        }
        try {
            this.aIy.a(this.aIz);
        } catch (RemoteException e) {
        }
    }

    public static int[] nb() {
        c nc = nc();
        if (nc == null) {
            return new int[0];
        }
        try {
            return nc.nd();
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    private static c nc() {
        return com.b.a.c.a.x(ServiceManager.getService("authentication_service"));
    }
}
