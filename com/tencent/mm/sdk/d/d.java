package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class d {
    public String mName;
    public c uwt;
    public HandlerThread uwu;

    public static class a {
        private a uwA;
        private a uwB;
        private d uwv;
        private long uww;
        private int uwx;
        private String uwy;
        private a uwz;

        a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            a(dVar, message, str, aVar, aVar2, aVar3);
        }

        public final void a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            this.uwv = dVar;
            this.uww = System.currentTimeMillis();
            this.uwx = message != null ? message.what : 0;
            this.uwy = str;
            this.uwz = aVar;
            this.uwA = aVar2;
            this.uwB = aVar3;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("time=");
            Calendar.getInstance().setTimeInMillis(this.uww);
            stringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r0, r0, r0, r0, r0, r0}));
            stringBuilder.append(" processed=");
            stringBuilder.append(this.uwz == null ? "<null>" : this.uwz.getName());
            stringBuilder.append(" org=");
            stringBuilder.append(this.uwA == null ? "<null>" : this.uwA.getName());
            stringBuilder.append(" dest=");
            stringBuilder.append(this.uwB == null ? "<null>" : this.uwB.getName());
            stringBuilder.append(" what=");
            Object obj = this.uwv != null ? null : "";
            if (TextUtils.isEmpty(obj)) {
                stringBuilder.append(this.uwx);
                stringBuilder.append("(0x");
                stringBuilder.append(Integer.toHexString(this.uwx));
                stringBuilder.append(")");
            } else {
                stringBuilder.append(obj);
            }
            if (!TextUtils.isEmpty(this.uwy)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.uwy);
            }
            return stringBuilder.toString();
        }
    }

    private static class b {
        private int mCount = 0;
        public Vector<a> uwC = new Vector();
        private int uwD = 20;
        private int uwE = 0;
        private boolean uwF = false;

        final synchronized boolean bKj() {
            return this.uwF;
        }

        final synchronized void Po() {
            this.uwC.clear();
        }

        final synchronized void b(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            this.mCount++;
            if (this.uwC.size() < this.uwD) {
                this.uwC.add(new a(dVar, message, str, aVar, aVar2, aVar3));
            } else {
                a aVar4 = (a) this.uwC.get(this.uwE);
                this.uwE++;
                if (this.uwE >= this.uwD) {
                    this.uwE = 0;
                }
                aVar4.a(dVar, message, str, aVar, aVar2, aVar3);
            }
        }
    }

    private static class c extends Handler {
        private static final Object uwI = new Object();
        private boolean uwG;
        private boolean uwH;
        private Message uwJ;
        private b uwK;
        private boolean uwL;
        private c[] uwM;
        private int uwN;
        private c[] uwO;
        private int uwP;
        private a uwQ;
        private b uwR;
        private HashMap<c, c> uwS;
        private c uwT;
        private c uwU;
        private ArrayList<Message> uwV;
        private d uwv;

        private class c {
            boolean fCp;
            final /* synthetic */ c uwW;
            c uwX;
            c uwY;

            public c(c cVar) {
                this.uwW = cVar;
            }

            public final String toString() {
                String str;
                StringBuilder append = new StringBuilder("state=").append(this.uwX.getName()).append(",active=").append(this.fCp).append(",parent=");
                if (this.uwY == null) {
                    str = "null";
                } else {
                    str = this.uwY.uwX.getName();
                }
                return append.append(str).toString();
            }
        }

        private class a extends c {
            final /* synthetic */ c uwW;

            public a(c cVar) {
                this.uwW = cVar;
            }

            public final boolean f(Message message) {
                this.uwW.uwv;
                return true;
            }
        }

        private class b extends c {
            final /* synthetic */ c uwW;

            public b(c cVar) {
                this.uwW = cVar;
            }

            public final boolean f(Message message) {
                return false;
            }
        }

        static /* synthetic */ void b(c cVar, c cVar2) {
            if (cVar.uwH) {
                new StringBuilder("setInitialState: initialState=").append(cVar2.getName());
            }
            cVar.uwT = cVar2;
        }

        static /* synthetic */ void f(c cVar) {
            int i = 0;
            for (c cVar2 : cVar.uwS.values()) {
                int i2 = 0;
                c cVar3;
                while (cVar3 != null) {
                    cVar3 = cVar3.uwY;
                    i2++;
                }
                if (i >= i2) {
                    i2 = i;
                }
                i = i2;
            }
            if (cVar.uwH) {
                cVar.uwM = new c[i];
                cVar.uwO = new c[i];
                cVar.bKm();
                cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-2, uwI));
            } else {
                cVar.uwM = new c[i];
                cVar.uwO = new c[i];
                cVar.bKm();
                cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-2, uwI));
            }
        }

        public final void handleMessage(Message message) {
            if (!this.uwG) {
                if (this.uwH) {
                    new StringBuilder("handleMessage: E msg.what=").append(message.what);
                }
                this.uwJ = message;
                c cVar = null;
                if (this.uwL) {
                    cVar = n(message);
                } else if (!this.uwL && this.uwJ.what == -2 && this.uwJ.obj == uwI) {
                    this.uwL = true;
                    yy(0);
                } else {
                    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
                }
                a(cVar, message);
            }
        }

        private void a(c cVar, Message message) {
            b bVar;
            a aVar = this.uwM[this.uwN].uwX;
            boolean z = this.uwv.d(this.uwJ) && message.obj != uwI;
            if (this.uwK.bKj()) {
                if (this.uwU != null) {
                    this.uwK.b(this.uwv, this.uwJ, "", cVar, aVar, this.uwU);
                }
            } else if (z) {
                this.uwK.b(this.uwv, this.uwJ, "", cVar, aVar, this.uwU);
            }
            c cVar2 = this.uwU;
            c cVar3;
            if (cVar2 != null) {
                bVar = cVar2;
                while (true) {
                    this.uwP = 0;
                    c cVar4 = (c) this.uwS.get(bVar);
                    do {
                        c[] cVarArr = this.uwO;
                        int i = this.uwP;
                        this.uwP = i + 1;
                        cVarArr[i] = cVar4;
                        cVar4 = cVar4.uwY;
                        if (cVar4 == null) {
                            break;
                        }
                    } while (!cVar4.fCp);
                    if (this.uwH) {
                        new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.uwP).append(",curStateInfo: ").append(cVar4);
                    }
                    a(cVar4);
                    yy(bKl());
                    bKk();
                    if (bVar == this.uwU) {
                        break;
                    }
                    cVar3 = this.uwU;
                }
                this.uwU = null;
            } else {
                cVar3 = cVar2;
            }
            if (bVar != null && bVar == this.uwR) {
                this.uwv.XJ();
                if (this.uwv.uwu != null) {
                    getLooper().quit();
                    this.uwv.uwu = null;
                }
                this.uwv.uwt = null;
                this.uwv = null;
                this.uwJ = null;
                this.uwK.Po();
                this.uwM = null;
                this.uwO = null;
                this.uwS.clear();
                this.uwT = null;
                this.uwU = null;
                this.uwV.clear();
                this.uwG = true;
            }
        }

        private final c n(Message message) {
            c cVar = this.uwM[this.uwN];
            if (this.uwH) {
                new StringBuilder("processMsg: ").append(cVar.uwX.getName());
            }
            Object obj = (message.what == -1 && message.obj == uwI) ? 1 : null;
            if (obj != null) {
                b(this.uwR);
            } else {
                while (!cVar.uwX.f(message)) {
                    cVar = cVar.uwY;
                    if (cVar == null) {
                        this.uwv.e(message);
                        break;
                    } else if (this.uwH) {
                        new StringBuilder("processMsg: ").append(cVar.uwX.getName());
                    }
                }
            }
            if (cVar != null) {
                return cVar.uwX;
            }
            return null;
        }

        private final void a(c cVar) {
            while (this.uwN >= 0 && this.uwM[this.uwN] != cVar) {
                c cVar2 = this.uwM[this.uwN].uwX;
                if (this.uwH) {
                    new StringBuilder("invokeExitMethods: ").append(cVar2.getName());
                }
                cVar2.exit();
                this.uwM[this.uwN].fCp = false;
                this.uwN--;
            }
        }

        private final void yy(int i) {
            while (i <= this.uwN) {
                if (this.uwH) {
                    new StringBuilder("invokeEnterMethods: ").append(this.uwM[i].uwX.getName());
                }
                this.uwM[i].uwX.enter();
                this.uwM[i].fCp = true;
                i++;
            }
        }

        private final void bKk() {
            for (int size = this.uwV.size() - 1; size >= 0; size--) {
                Message message = (Message) this.uwV.get(size);
                if (this.uwH) {
                    new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.uwV.clear();
        }

        private final int bKl() {
            int i = this.uwN + 1;
            int i2 = i;
            for (int i3 = this.uwP - 1; i3 >= 0; i3--) {
                if (this.uwH) {
                    new StringBuilder("moveTempStackToStateStack: i=").append(i3).append(",j=").append(i2);
                }
                this.uwM[i2] = this.uwO[i3];
                i2++;
            }
            this.uwN = i2 - 1;
            if (this.uwH) {
                new StringBuilder("moveTempStackToStateStack: X mStateStackTop=").append(this.uwN).append(",startingIndex=").append(i).append(",Top=").append(this.uwM[this.uwN].uwX.getName());
            }
            return i;
        }

        private final void bKm() {
            if (this.uwH) {
                new StringBuilder("setupInitialStateStack: E mInitialState=").append(this.uwT.getName());
            }
            c cVar = (c) this.uwS.get(this.uwT);
            this.uwP = 0;
            while (cVar != null) {
                this.uwO[this.uwP] = cVar;
                cVar = cVar.uwY;
                this.uwP++;
            }
            this.uwN = -1;
            bKl();
        }

        private final c a(c cVar, c cVar2) {
            if (this.uwH) {
                new StringBuilder("addStateInternal: E state=").append(cVar.getName()).append(",parent=");
            }
            c cVar3 = (c) this.uwS.get(cVar);
            if (cVar3 == null) {
                cVar3 = new c(this);
                this.uwS.put(cVar, cVar3);
            }
            if (cVar3.uwY == null || cVar3.uwY == null) {
                cVar3.uwX = cVar;
                cVar3.uwY = null;
                cVar3.fCp = false;
                if (this.uwH) {
                    new StringBuilder("addStateInternal: X stateInfo: ").append(cVar3);
                }
                return cVar3;
            }
            throw new RuntimeException("state already added");
        }

        private c(Looper looper, d dVar) {
            super(looper);
            this.uwG = false;
            this.uwH = false;
            this.uwK = new b();
            this.uwN = -1;
            this.uwQ = new a(this);
            this.uwR = new b(this);
            this.uwS = new HashMap();
            this.uwV = new ArrayList();
            this.uwv = dVar;
            a(this.uwQ, null);
            a(this.uwR, null);
        }

        private final void b(a aVar) {
            this.uwU = (c) aVar;
            if (this.uwH) {
                new StringBuilder("transitionTo: destState=").append(this.uwU.getName());
            }
        }
    }

    public d(String str, Looper looper) {
        this.mName = str;
        this.uwt = new c(looper, this);
    }

    public final void b(c cVar) {
        this.uwt.a(cVar, null);
    }

    public final void c(c cVar) {
        c.b(this.uwt, cVar);
    }

    public final Message bKh() {
        c cVar = this.uwt;
        if (cVar == null) {
            return null;
        }
        return cVar.uwJ;
    }

    public final a bKi() {
        c cVar = this.uwt;
        if (cVar == null) {
            return null;
        }
        return cVar.uwM[cVar.uwN].uwX;
    }

    public final void b(a aVar) {
        this.uwt.b(aVar);
    }

    public void e(Message message) {
        if (this.uwt.uwH) {
            new StringBuilder(" - unhandledMessage: msg.what=").append(message.what);
        }
    }

    public void XJ() {
    }

    public boolean d(Message message) {
        return true;
    }

    private Message obtainMessage(int i) {
        return Message.obtain(this.uwt, i);
    }

    public final void yw(int i) {
        c cVar = this.uwt;
        if (cVar != null) {
            cVar.sendMessage(obtainMessage(i));
        }
    }

    public final void yx(int i) {
        c cVar = this.uwt;
        if (cVar != null) {
            cVar.sendMessageAtFrontOfQueue(obtainMessage(i));
        }
    }

    public final void quit() {
        c cVar = this.uwt;
        if (cVar != null) {
            cVar.sendMessage(cVar.obtainMessage(-1, c.uwI));
        }
    }

    public void start() {
        c cVar = this.uwt;
        if (cVar != null) {
            c.f(cVar);
        }
    }
}
