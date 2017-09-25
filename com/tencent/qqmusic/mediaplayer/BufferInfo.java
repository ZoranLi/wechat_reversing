package com.tencent.qqmusic.mediaplayer;

public class BufferInfo {
    public int bufferSize;
    public byte[] byteBuffer;
    public short[] shortBuffer;
    public byte[] tempByteBuffer;
    public short[] tempShortBuffer;

    public static BufferInfo byteToShortBuffer(BufferInfo bufferInfo) {
        if (!(bufferInfo == null || bufferInfo.byteBuffer == null || bufferInfo.byteBuffer.length == 0)) {
            int min = Math.min(bufferInfo.bufferSize, bufferInfo.byteBuffer.length);
            if (bufferInfo.shortBuffer == null) {
                bufferInfo.shortBuffer = new short[(min / 2)];
            }
            for (int i = 0; i < min / 2; i++) {
                bufferInfo.shortBuffer[i] = (short) (((short) (bufferInfo.byteBuffer[i * 2] & 255)) | ((short) (((short) (bufferInfo.byteBuffer[(i * 2) + 1] & 255)) << 8)));
            }
        }
        return bufferInfo;
    }

    public static BufferInfo shortToByteBuffer(BufferInfo bufferInfo) {
        int i = 0;
        if (!(bufferInfo == null || bufferInfo.shortBuffer == null || bufferInfo.shortBuffer.length == 0)) {
            int min = Math.min(bufferInfo.bufferSize, bufferInfo.shortBuffer.length);
            if (bufferInfo.byteBuffer == null) {
                bufferInfo.byteBuffer = new byte[(min * 2)];
            }
            int i2 = 0;
            while (i < min) {
                int i3 = i2 + 1;
                bufferInfo.byteBuffer[i2] = (byte) bufferInfo.shortBuffer[i];
                i2 = i3 + 1;
                bufferInfo.byteBuffer[i3] = (byte) (bufferInfo.shortBuffer[i] >> 8);
                i++;
            }
        }
        return bufferInfo;
    }

    public void setShortBufferCapacity(int i) {
        if (this.shortBuffer == null || this.shortBuffer.length < i) {
            this.shortBuffer = new short[i];
        }
    }

    public void setTempShortBufferCapacity(int i) {
        if (this.tempShortBuffer == null || this.tempShortBuffer.length < i) {
            this.tempShortBuffer = new short[i];
        }
    }

    public void setTempByteBufferCapacity(int i) {
        if (this.tempByteBuffer == null || this.tempByteBuffer.length < i) {
            this.tempByteBuffer = new byte[i];
        }
    }

    public void appendShort(short[] sArr, int i, int i2) {
        if (sArr != null && i >= 0 && i2 > 0 && i + i2 <= sArr.length) {
            setShortBufferCapacity(this.bufferSize + i2);
            System.arraycopy(sArr, i, this.shortBuffer, this.bufferSize, i2);
        }
    }

    public void fillShort(byte[] bArr, int i) {
        if (bArr != null && i > 0 && i <= bArr.length) {
            this.bufferSize = i / 2;
            if (this.shortBuffer == null || this.shortBuffer.length < this.bufferSize) {
                this.shortBuffer = new short[this.bufferSize];
            }
            for (int i2 = 0; i2 < this.bufferSize; i2++) {
                this.shortBuffer[i2] = (short) (((short) (bArr[i2 * 2] & 255)) | ((short) (((short) (bArr[(i2 * 2) + 1] & 255)) << 8)));
            }
        }
    }

    public BufferInfo copy(BufferInfo bufferInfo) {
        bufferInfo.bufferSize = this.bufferSize;
        bufferInfo.byteBuffer = this.byteBuffer;
        bufferInfo.shortBuffer = this.shortBuffer;
        bufferInfo.tempByteBuffer = this.tempByteBuffer;
        bufferInfo.tempShortBuffer = this.tempShortBuffer;
        return bufferInfo;
    }
}
