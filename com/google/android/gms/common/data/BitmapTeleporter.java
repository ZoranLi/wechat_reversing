package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter implements SafeParcelable {
    public static final Creator<BitmapTeleporter> CREATOR = new d();
    final int aoA;
    private Bitmap aoB = null;
    private boolean aoC = false;
    private File aoD;
    ParcelFileDescriptor aoz;
    final int mVersionCode;

    BitmapTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor, int i2) {
        this.mVersionCode = i;
        this.aoz = parcelFileDescriptor;
        this.aoA = i2;
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    private FileOutputStream jM() {
        if (this.aoD == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.aoD);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.aoz = ParcelFileDescriptor.open(createTempFile, SQLiteDatabase.CREATE_IF_NECESSARY);
                createTempFile.delete();
                return fileOutputStream;
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not create temporary file", e2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.aoz == null) {
            Bitmap bitmap = this.aoB;
            Buffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            Closeable dataOutputStream = new DataOutputStream(jM());
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                b(dataOutputStream);
            } catch (Throwable e) {
                throw new IllegalStateException("Could not write into unlinked file", e);
            } catch (Throwable th) {
                b(dataOutputStream);
            }
        }
        d.a(this, parcel, i | 1);
        this.aoz = null;
    }
}
