package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.f.a;
import junit.framework.Assert;

public final class c implements b {
    private com.tencent.mm.vending.e.c wBC = new com.tencent.mm.vending.e.c();
    private b wBU = b.cbr();
    private a wBV;
    private com.tencent.mm.vending.c.b<? extends a> wBW;
    private int wBX = 0;

    private synchronized <T extends com.tencent.mm.vending.c.b<? extends a>> T B(Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        T t;
        if (this.wBW == null) {
            try {
                this.wBW = (com.tencent.mm.vending.c.b) cls.newInstance();
                if (this.wBV == null) {
                    this.wBV = (a) this.wBW.NM();
                }
                cbs();
                t = this.wBW;
            } catch (IllegalAccessException e) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            } catch (InstantiationException e2) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.wBW)) {
            t = this.wBW;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    private synchronized <T extends a> T C(Class<? extends a> cls) {
        T t;
        if (this.wBW != null) {
            t = (a) this.wBW.NM();
        } else if (this.wBV == null) {
            try {
                this.wBV = (a) cls.newInstance();
                cbs();
                t = this.wBV;
            } catch (InstantiationException e) {
                throw new InternalError("Could not create interactor instance : " + cls.toString());
            } catch (IllegalAccessException e2) {
                throw new InternalError("Could not create interactor instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.wBV)) {
            t = this.wBV;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    private void cbs() {
        if (this.wBU != null) {
            b bVar = this.wBU;
            a aVar = this.wBV;
            if (bVar.wBQ.containsKey(this)) {
                a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
                return;
            }
            bVar.wBQ.put(this, aVar);
            a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", new Object[]{this, Integer.valueOf(hashCode()), aVar, Looper.myLooper()});
            int i = bVar.wBR.get(hashCode(), 0);
            if (i > 0 && i < 4) {
                if (i > 0) {
                    bVar.wBS.sendMessage(bVar.wBS.obtainMessage(1, aVar));
                }
                if (i >= 2) {
                    bVar.wBS.sendMessage(bVar.wBS.obtainMessage(2, aVar));
                }
                if (i >= 3) {
                    bVar.wBS.sendMessage(bVar.wBS.obtainMessage(3, aVar));
                }
                if (i >= 4) {
                    bVar.wBS.sendMessage(bVar.wBS.obtainMessage(4, aVar));
                }
            }
        }
    }

    private synchronized void B(Intent intent, Context context) {
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.wBV);
        this.wBV.mContext = context;
        this.wBV.wBK = new com.tencent.mm.vending.d.a(intent);
    }

    public final synchronized a vQ() {
        if (this.wBV == null && this.wBU != null) {
            this.wBV = (a) this.wBU.wBQ.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.wBV);
        return this.wBV;
    }

    public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity activity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return B(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{activity});
        return null;
    }

    public final <T extends a> T b(Activity activity, Class<? extends a> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return C(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{activity});
        return null;
    }

    public final void CF(int i) {
        this.wBX = i;
        b bVar = this.wBU;
        a aVar = (a) bVar.wBQ.get(this);
        if (aVar != null) {
            switch (i) {
                case 1:
                    a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    bVar.wBQ.remove(this);
                    break;
                default:
                    a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", new Object[]{Integer.valueOf(i), aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    return;
            }
            bVar.wBS.sendMessage(bVar.wBS.obtainMessage(i, aVar));
        }
        bVar.wBR.put(hashCode(), i);
    }

    public final void C(Intent intent, Context context) {
        B(intent, context);
        CF(1);
    }

    public final void a(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.wBC.a(aVar);
    }

    public final void onDestroy() {
        this.wBC.dead();
        CF(4);
    }
}
