package android.support.v4.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {
    public int dX;
    Context mContext;
    public boolean ny = false;
    public b<D> ts;
    public a<D> tt;
    public boolean tu = false;
    public boolean tv = true;
    public boolean tw = false;
    public boolean tx = false;

    public interface a<D> {
    }

    public interface b<D> {
        void b(c<D> cVar, D d);
    }

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public final void deliverResult(D d) {
        if (this.ts != null) {
            this.ts.b(this, d);
        }
    }

    public final void a(b<D> bVar) {
        if (this.ts == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.ts != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.ts = null;
        }
    }

    public final void a(a<D> aVar) {
        if (this.tt == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.tt != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.tt = null;
        }
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public void onReset() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        android.support.v4.e.c.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.dX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.dX);
        printWriter.print(" mListener=");
        printWriter.println(this.ts);
        if (this.ny || this.tw || this.tx) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.ny);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.tw);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.tx);
        }
        if (this.tu || this.tv) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.tu);
            printWriter.print(" mReset=");
            printWriter.println(this.tv);
        }
    }
}
