package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.InvalidBoxException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;

public class FlacSeekTable implements SeekTable {
    private static final int SEEK_POINT_SIZE = 18;
    private static final byte TYPE_SEEKTABLE = (byte) 3;
    private static final byte TYPE_STREAMINFO = (byte) 0;
    public long firstFrameOffset;
    public long[] offsets;
    public long[] sampleNumbers;
    private int sampleRate = 0;

    private interface BlockHandler {
        boolean handle(Parsable parsable, int i);
    }

    class SeektableHandler implements BlockHandler {
        SeektableHandler() {
        }

        public boolean handle(Parsable parsable, int i) {
            int i2 = 0;
            if (i != 3) {
                return false;
            }
            byte[] bArr = new byte[3];
            parsable.readBytes(bArr, 0, 3);
            int from = BytesUtil.from(bArr) / 18;
            FlacSeekTable.this.sampleNumbers = new long[from];
            FlacSeekTable.this.offsets = new long[from];
            while (i2 < from) {
                FlacSeekTable.this.sampleNumbers[i2] = parsable.readLong();
                FlacSeekTable.this.offsets[i2] = parsable.readLong();
                parsable.skip(2);
                i2++;
            }
            if (FlacSeekTable.seekToFirstFrame(parsable)) {
                FlacSeekTable.this.firstFrameOffset = parsable.tell() - 2;
                return true;
            }
            throw new InvalidBoxException("can't find audio frame!");
        }
    }

    class StreamInfoHandler implements BlockHandler {
        StreamInfoHandler() {
        }

        public boolean handle(Parsable parsable, int i) {
            if (i != 0) {
                return false;
            }
            parsable.skip(13);
            parsable.readBytes(new byte[3], 0, 3);
            parsable.skip(21);
            return true;
        }
    }

    public FlacSeekTable(int i) {
        this.sampleRate = i;
    }

    public long[] getOffsetRangeOfSample(int i) {
        if (binarySearchFloor(this.sampleNumbers, (long) i, true, true) + 1 >= this.offsets.length) {
            return new long[]{this.firstFrameOffset + this.offsets[binarySearchFloor(this.sampleNumbers, (long) i, true, true)], -1};
        }
        return new long[]{this.firstFrameOffset + this.offsets[binarySearchFloor(this.sampleNumbers, (long) i, true, true)], this.firstFrameOffset + this.offsets[binarySearchFloor(this.sampleNumbers, (long) i, true, true) + 1]};
    }

    public void parse(InputStream inputStream) {
        Parsable parsableInputStreamWrapper = new ParsableInputStreamWrapper(inputStream);
        if (seekToFlac(parsableInputStreamWrapper)) {
            if (!walkThrough(parsableInputStreamWrapper, this.sampleRate == 0 ? new BlockHandler[]{new SeektableHandler(), new StreamInfoHandler()} : new BlockHandler[]{new SeektableHandler()})) {
                throw new InvalidBoxException("lack one or more critical BLOCK(s) to create seek table!");
            }
        }
    }

    public long seek(long j) {
        int binarySearchFloor = binarySearchFloor(this.sampleNumbers, (long) ((int) (Math.round(((double) j) / 1000.0d) * ((long) this.sampleRate))), true, true);
        return this.offsets[binarySearchFloor] + this.firstFrameOffset;
    }

    private static boolean seekToFlac(Parsable parsable) {
        byte[] bArr = new byte[4];
        parsable.readBytes(bArr, 0, 4);
        if (bArr[0] == (byte) 73 && bArr[1] == (byte) 68 && bArr[2] == (byte) 51) {
            parsable.skip(2);
            parsable.skip((long) Id3Util.unsynchsafe(parsable.readInt()));
            parsable.readBytes(bArr, 0, 4);
        }
        if (bArr[0] == (byte) 102 && bArr[1] == (byte) 76 && bArr[2] == (byte) 97 && bArr[3] == (byte) 67) {
            return true;
        }
        return false;
    }

    private static boolean walkThrough(Parsable parsable, BlockHandler... blockHandlerArr) {
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        HashSet hashSet = new HashSet();
        while (hashSet.size() < blockHandlerArr.length && parsable.available() > 0) {
            parsable.readBytes(bArr, 0, 1);
            int i = bArr[0] & 127;
            boolean z = false;
            for (BlockHandler blockHandler : blockHandlerArr) {
                z = blockHandler.handle(parsable, i);
                if (z) {
                    hashSet.add(Integer.valueOf(blockHandler.hashCode()));
                    break;
                }
            }
            if (!z) {
                if (((bArr[0] & 255) >> 7) == 1) {
                    break;
                }
                parsable.readBytes(bArr2, 0, 3);
                parsable.skip((long) BytesUtil.from(bArr2));
            }
        }
        if (hashSet.size() == blockHandlerArr.length) {
            return true;
        }
        return false;
    }

    public static boolean seekToFirstFrame(Parsable parsable) {
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        boolean z = false;
        while (parsable.available() > 0) {
            if (z) {
                byte[] bArr3 = new byte[2];
                parsable.readBytes(bArr3, 0, 2);
                if ((bArr3[0] & 255) == 255 && ((bArr3[1] & 255) >> 2) == 62) {
                    return true;
                }
                return false;
            }
            parsable.readBytes(bArr, 0, 1);
            if (((bArr[0] & 255) >> 7) == 1) {
                z = true;
            }
            parsable.readBytes(bArr2, 0, 3);
            parsable.skip((long) BytesUtil.from(bArr2));
        }
        return false;
    }

    private static int binarySearchFloor(long[] jArr, long j, boolean z, boolean z2) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z) {
            binarySearch--;
        }
        return z2 ? Math.max(0, binarySearch) : binarySearch;
    }
}
