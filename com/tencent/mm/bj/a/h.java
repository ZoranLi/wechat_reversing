package com.tencent.mm.bj.a;

import android.database.CursorIndexOutOfBoundsException;
import com.tencent.mm.bj.a.c.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectQuery;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public final class h extends SQLiteDirectQuery {
    final int a(b bVar, int i, int i2) {
        int step;
        Object obj = 1;
        acquireReference();
        bVar.acquireReference();
        if (i > 0) {
            try {
                step = step(i);
                if (step < i) {
                    Log.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", Integer.valueOf(i), Integer.valueOf(step));
                    bVar.releaseReference();
                    releaseReference();
                    return step;
                }
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (SQLiteException e2) {
                Log.e("WCDB.SQLiteNewQuery", "exception: " + e2.getMessage() + "; query: " + getSql());
                throw e2;
            } catch (Throwable th) {
                bVar.releaseReference();
                releaseReference();
            }
        }
        int length = getColumnNames().length;
        int i3 = i2 + i;
        step = i;
        while (step < i3) {
            if (step(1) == 1) {
                bVar.uMs = bVar.bNP();
                for (int i4 = 0; i4 < length; i4++) {
                    switch (getType(i4)) {
                        case 0:
                            break;
                        case 1:
                            long j = getLong(i4);
                            if (bVar.uMs == null) {
                                break;
                            }
                            bVar.uMs.M(i4, j);
                            break;
                        case 2:
                            getDouble(i4);
                            break;
                        case 3:
                            String string = getString(i4);
                            if (bVar.uMs == null) {
                                break;
                            }
                            bVar.uMs.az(i4, string);
                            break;
                        case 4:
                            byte[] blob = getBlob(i4);
                            if (bVar.uMs == null) {
                                break;
                            }
                            bVar.uMs.m(i4, blob);
                            break;
                        default:
                            bVar.dQ(step, 1);
                            throw new SQLiteException("Unknown column type when filling window.");
                    }
                }
                bVar.dQ(step, 0);
                step++;
            } else {
                if (obj == null) {
                    step += step(Integer.MAX_VALUE);
                }
                reset(true);
                bVar.releaseReference();
                releaseReference();
                return step;
            }
        }
        obj = null;
        if (obj == null) {
            step += step(Integer.MAX_VALUE);
        }
        reset(true);
        bVar.releaseReference();
        releaseReference();
        return step;
    }

    final int a(c cVar, int i, int i2) {
        int step;
        Object obj;
        acquireReference();
        if (i > 0) {
            try {
                step = step(i);
                if (step < i) {
                    Log.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", Integer.valueOf(i), Integer.valueOf(step));
                    releaseReference();
                    return step;
                }
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (SQLiteException e2) {
                Log.e("WCDB.SQLiteNewQuery", "exception: " + e2.getMessage() + "; query: " + getSql());
                throw e2;
            } catch (Throwable th) {
                releaseReference();
            }
        }
        int length = getColumnNames().length;
        int i3 = i2 + i;
        int i4 = i;
        while (i4 < i3) {
            if (step(1) == 1) {
                Object[] objArr;
                int i5 = i4 / cVar.uMu;
                if (cVar.uMt.indexOfKey(i5) < 0) {
                    obj = new Object[(cVar.uMu * cVar.columnCount)];
                    cVar.uMt.put(i5, obj);
                    objArr = obj;
                } else {
                    objArr = (Object[]) cVar.uMt.get(i5);
                }
                int i6 = cVar.columnCount * (i4 % cVar.uMu);
                int i7 = i6 + cVar.columnCount;
                step = i4 + 1;
                if (step <= cVar.uMv) {
                    step = cVar.uMv;
                }
                cVar.uMv = step;
                a aVar = new a(cVar, i6, i7, objArr);
                for (i5 = 0; i5 < length; i5++) {
                    String str;
                    switch (getType(i5)) {
                        case 0:
                            str = null;
                            break;
                        case 1:
                            str = Long.valueOf(getLong(i5));
                            break;
                        case 2:
                            str = Double.valueOf(getDouble(i5));
                            break;
                        case 3:
                            str = getString(i5);
                            break;
                        case 4:
                            str = getBlob(i5);
                            break;
                        default:
                            throw new SQLiteException("Unknown column type when filling window.");
                    }
                    if (aVar.index == aVar.endIndex) {
                        throw new CursorIndexOutOfBoundsException("No more columns left.");
                    }
                    Object[] objArr2 = aVar.uMw;
                    i7 = aVar.index;
                    aVar.index = i7 + 1;
                    objArr2[i7] = str;
                }
                i4++;
            } else {
                obj = 1;
                if (obj != null) {
                    step = step(Integer.MAX_VALUE) + i4;
                } else {
                    step = i4;
                }
                reset(true);
                releaseReference();
                return step;
            }
        }
        obj = null;
        if (obj != null) {
            step = i4;
        } else {
            step = step(Integer.MAX_VALUE) + i4;
        }
        reset(true);
        releaseReference();
        return step;
    }

    h(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
    }

    public final String toString() {
        return "SQLiteNewQuery: " + getSql();
    }
}
