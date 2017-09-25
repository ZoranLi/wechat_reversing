package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item> extends com.tencent.mm.vending.base.b<_Struct, Cursor> {
    public Cursor Bo = null;
    protected Map<Integer, _Item> kda = null;
    public int mCount;
    public a wBA;
    protected _Item wBB;

    public interface a {
        void biI();

        void biJ();
    }

    public abstract _Item a(_Item _Item, Cursor cursor);

    public abstract Cursor bkY();

    protected /* synthetic */ Object prepareVendingDataAsynchronous() {
        if (this.wBA != null) {
            this.wBA.biI();
        }
        Cursor bkY = bkY();
        if (this.wBA != null) {
            this.wBA.biJ();
        }
        return bkY;
    }

    public b(_Item _Item) {
        this.wBB = _Item;
        this.mCount = -1;
        cbo();
    }

    private Cursor getCursor() {
        if (this.Bo == null || this.Bo.isClosed()) {
            Assert.assertNotNull(this.Bo);
        }
        return this.Bo;
    }

    public void destroyAsynchronous() {
        aEW();
    }

    public final void aEW() {
        if (this.kda != null) {
            this.kda.clear();
        }
        if (this.Bo != null) {
            this.Bo.close();
        }
        this.mCount = -1;
    }

    public final void cbo() {
        if (this.kda == null) {
            this.kda = new HashMap();
        }
    }

    public final int cbp() {
        if (this.mCount < 0) {
            this.mCount = getCursor().getCount();
        }
        return this.mCount;
    }

    public final _Item getItem(int i) {
        _Item _Item;
        if (this.kda != null) {
            _Item = this.kda.get(Integer.valueOf(i));
            if (_Item != null) {
                return _Item;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.kda == null) {
            return a(this.wBB, getCursor());
        }
        _Item = a(null, getCursor());
        this.kda.put(Integer.valueOf(i), _Item);
        return _Item;
    }
}
