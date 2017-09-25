package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new Creator<BackStackState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mIndex;
    final String mName;
    final int nV;
    final int nW;
    final int[] oF;
    final int oa;
    final CharSequence ob;
    final int oc;
    final CharSequence od;
    final ArrayList<String> oe;
    final ArrayList<String> of;

    public BackStackState(d dVar) {
        int i = 0;
        for (a aVar = dVar.nO; aVar != null; aVar = aVar.os) {
            if (aVar.oA != null) {
                i += aVar.oA.size();
            }
        }
        this.oF = new int[(i + (dVar.nQ * 7))];
        if (dVar.nX) {
            i = 0;
            for (a aVar2 = dVar.nO; aVar2 != null; aVar2 = aVar2.os) {
                int i2 = i + 1;
                this.oF[i] = aVar2.ou;
                int i3 = i2 + 1;
                this.oF[i2] = aVar2.ov != null ? aVar2.ov.mIndex : -1;
                int i4 = i3 + 1;
                this.oF[i3] = aVar2.ow;
                i2 = i4 + 1;
                this.oF[i4] = aVar2.ox;
                i4 = i2 + 1;
                this.oF[i2] = aVar2.oy;
                i2 = i4 + 1;
                this.oF[i4] = aVar2.oz;
                if (aVar2.oA != null) {
                    int size = aVar2.oA.size();
                    i4 = i2 + 1;
                    this.oF[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.oF[i4] = ((Fragment) aVar2.oA.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.oF[i2] = 0;
                }
            }
            this.nV = dVar.nV;
            this.nW = dVar.nW;
            this.mName = dVar.mName;
            this.mIndex = dVar.mIndex;
            this.oa = dVar.oa;
            this.ob = dVar.ob;
            this.oc = dVar.oc;
            this.od = dVar.od;
            this.oe = dVar.oe;
            this.of = dVar.of;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.oF = parcel.createIntArray();
        this.nV = parcel.readInt();
        this.nW = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.oa = parcel.readInt();
        this.ob = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.oc = parcel.readInt();
        this.od = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.oe = parcel.createStringArrayList();
        this.of = parcel.createStringArrayList();
    }

    public final d a(m mVar) {
        d dVar = new d(mVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.oF.length) {
            a aVar = new a();
            int i3 = i2 + 1;
            aVar.ou = this.oF[i2];
            if (m.DEBUG) {
                new StringBuilder("Instantiate ").append(dVar).append(" op #").append(i).append(" base fragment #").append(this.oF[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.oF[i3];
            if (i2 >= 0) {
                aVar.ov = (Fragment) mVar.qj.get(i2);
            } else {
                aVar.ov = null;
            }
            i3 = i4 + 1;
            aVar.ow = this.oF[i4];
            i4 = i3 + 1;
            aVar.ox = this.oF[i3];
            i3 = i4 + 1;
            aVar.oy = this.oF[i4];
            int i5 = i3 + 1;
            aVar.oz = this.oF[i3];
            i4 = i5 + 1;
            int i6 = this.oF[i5];
            if (i6 > 0) {
                aVar.oA = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (m.DEBUG) {
                        new StringBuilder("Instantiate ").append(dVar).append(" set remove fragment #").append(this.oF[i4]);
                    }
                    i5 = i4 + 1;
                    aVar.oA.add((Fragment) mVar.qj.get(this.oF[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            dVar.nR = aVar.ow;
            dVar.nS = aVar.ox;
            dVar.nT = aVar.oy;
            dVar.nU = aVar.oz;
            dVar.a(aVar);
            i++;
            i2 = i4;
        }
        dVar.nV = this.nV;
        dVar.nW = this.nW;
        dVar.mName = this.mName;
        dVar.mIndex = this.mIndex;
        dVar.nX = true;
        dVar.oa = this.oa;
        dVar.ob = this.ob;
        dVar.oc = this.oc;
        dVar.od = this.od;
        dVar.oe = this.oe;
        dVar.of = this.of;
        dVar.D(1);
        return dVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.oF);
        parcel.writeInt(this.nV);
        parcel.writeInt(this.nW);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.oa);
        TextUtils.writeToParcel(this.ob, parcel, 0);
        parcel.writeInt(this.oc);
        TextUtils.writeToParcel(this.od, parcel, 0);
        parcel.writeStringList(this.oe);
        parcel.writeStringList(this.of);
    }
}
