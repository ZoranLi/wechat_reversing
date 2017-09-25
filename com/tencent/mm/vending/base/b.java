package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.f;

public abstract class b<_Struct, _Change> extends Vending<_Struct, Integer, _Change> {
    public int mCount = 0;
    public int wBY = 5;
    private a wBZ = new a();

    private static final class a {
        public int abF = -1;
        public int abG = -1;
        boolean gUO = false;

        final void set(int i, int i2) {
            this.abF = i;
            this.abG = i2;
        }
    }

    public abstract int cbp();

    public abstract _Struct ug(int i);

    protected /* synthetic */ boolean invalidIndex(Object obj) {
        return ((Integer) obj).intValue() < 0;
    }

    protected /* synthetic */ void requestIndexImpl(i iVar, Object obj) {
        Integer num = (Integer) obj;
        int i = this.mCount;
        if (i > 0) {
            eu(Math.min(i - 1, num.intValue()), Math.min(i - 1, num.intValue() + this.wBY));
            eu(Math.max(Math.min(0, num.intValue()), num.intValue()), Math.max(Math.min(0, num.intValue()), num.intValue() - this.wBY));
        }
    }

    protected /* synthetic */ Object resolveAsynchronous(Object obj) {
        return ug(((Integer) obj).intValue());
    }

    public final <T> T get(int i) {
        if (this.mCount != 0) {
            return super.get(Integer.valueOf(i));
        }
        com.tencent.mm.vending.f.a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
        return null;
    }

    public final void CG(int i) {
        if (this.mCount == 0) {
            com.tencent.mm.vending.f.a.e("Vending.ForwardVending", "the count is 0, why call null?", new Object[0]);
        } else {
            super.request(Integer.valueOf(i));
        }
    }

    protected void synchronizing(int i, Object obj) {
        this.mCount = cbp();
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "the count %s", new Object[]{Integer.valueOf(this.mCount)});
    }

    private void eu(int i, int i2) {
        int[] iArr;
        int i3 = i >= i2 ? 1 : 0;
        int min = Math.min(i, i2);
        int max = Math.max(i, i2);
        synchronized (this.wBZ) {
            int i4;
            a aVar = this.wBZ;
            if (aVar.gUO) {
                int i5 = aVar.abF;
                i4 = aVar.abG;
                if (i5 > max || i4 < min) {
                    if (i5 > max + 1 || i4 < min - 1) {
                        aVar.set(min, max);
                    }
                    iArr = new int[]{min, max};
                } else if (min < i5) {
                    if (max > i4) {
                        aVar.set(min, max);
                        iArr = new int[]{min, i5 - 1, i4 + 1, max};
                    } else {
                        aVar.set(min, i4);
                        iArr = new int[]{min, i5 - 1};
                    }
                } else if (max > i4) {
                    aVar.set(i5, max);
                    iArr = new int[]{i4 + 1, max};
                } else {
                    iArr = null;
                }
            } else {
                aVar.set(min, max);
                aVar.gUO = true;
                iArr = new int[]{min, max};
            }
        }
        if (iArr != null) {
            min = i3 != 0 ? iArr.length - 2 : 0;
            while (true) {
                if (i3 != 0) {
                    if (min < 0) {
                        return;
                    }
                } else if (min >= iArr.length) {
                    return;
                }
                int i6 = iArr[min];
                i4 = iArr[min + 1];
                int abs = Math.abs(i6 - i4);
                for (max = 0; max <= abs; max++) {
                    int i7;
                    if (i3 != 0) {
                        i7 = i4 - max;
                    } else {
                        i7 = i6 + max;
                    }
                    f loader = getLoader();
                    Integer valueOf = Integer.valueOf(i7);
                    if (!loader.iAu.get()) {
                        synchronized (loader.wCf) {
                            com.tencent.mm.vending.base.Vending.f.b bVar = (com.tencent.mm.vending.base.Vending.f.b) loader.wCd.get(valueOf);
                            if (bVar == null || bVar == com.tencent.mm.vending.base.Vending.f.b.NIL) {
                                loader.wCd.put(valueOf, com.tencent.mm.vending.base.Vending.f.b.PENDING);
                                loader.mVendingHandler.sendMessage(loader.mVendingHandler.obtainMessage(0, valueOf));
                            }
                        }
                    }
                }
                if (i3 != 0) {
                    min -= 2;
                } else {
                    min += 2;
                }
            }
        }
    }

    protected void loaderClear() {
        synchronized (this.wBZ) {
            a aVar = this.wBZ;
            aVar.abF = -1;
            aVar.abG = -1;
            aVar.gUO = false;
        }
    }
}
