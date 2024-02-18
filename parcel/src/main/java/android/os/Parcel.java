package android.os;

public final class Parcel {

    public final void writeString8(String val) {
        throw new RuntimeException("Stub");
    }

    public final String readString8() {
        throw new RuntimeException("Stub");
    }

    public final int readInt() {
        throw new RuntimeException("Stub");
    }

    public final void writeInt(int val) {
        throw new RuntimeException("Stub");
    }

    public static Parcel obtain() {
        throw new RuntimeException("Stub");
    }

    public final void recycle() {
        throw new RuntimeException("Stub");
    }

    public final void setDataPosition(int pos) {
        throw new RuntimeException("Stub");
    }

    public final void unmarshall(byte[] data, int offset, int length) {
        throw new RuntimeException("Stub");
    }
    public final byte[] marshall() {
        throw new RuntimeException("Stub");
    }

    @Deprecated
    public final <T extends Parcelable> T readParcelable(ClassLoader loader) {
        throw new RuntimeException("Stub");
    }

    public final void writeParcelable(Parcelable p, int parcelableFlags) {
        throw new RuntimeException("Stub");
    }
}
