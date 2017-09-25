package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.c.au;
import com.google.android.gms.c.au.a;
import com.google.android.gms.c.av;
import com.google.android.gms.c.bd;
import com.google.android.gms.c.be;
import java.util.ArrayList;
import java.util.List;

public final class j {
    public final i aFP;
    private final Uri apg;

    public j(f fVar) {
        this.apg = fVar.getUri();
        this.aFP = a((f) fVar.jO());
    }

    private static i a(f fVar) {
        Throwable e;
        if (fVar.getData() == null && fVar.mD().size() > 0) {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        } else if (fVar.getData() == null) {
            return new i();
        } else {
            try {
                List arrayList = new ArrayList();
                int size = fVar.mD().size();
                for (int i = 0; i < size; i++) {
                    g gVar = (g) fVar.mD().get(Integer.toString(i));
                    if (gVar == null) {
                        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + fVar);
                    }
                    arrayList.add(Asset.ar(gVar.getId()));
                }
                byte[] data = fVar.getData();
                return au.a(new a((av) be.a(new av(), data, data.length), arrayList));
            } catch (bd e2) {
                e = e2;
            } catch (NullPointerException e3) {
                e = e3;
            }
        }
        new StringBuilder("Unable to parse datamap from dataItem. uri=").append(fVar.getUri()).append(", data=").append(Base64.encodeToString(fVar.getData(), 0));
        throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=" + fVar.getUri(), e);
    }
}
