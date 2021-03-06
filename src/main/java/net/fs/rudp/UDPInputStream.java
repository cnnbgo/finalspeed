package net.fs.rudp;

public class UDPInputStream {

    Receiver receiver;

    boolean streamClosed = false;

    ConnectionUDP conn;

    UDPInputStream(ConnectionUDP conn) {
        this.conn = conn;
        receiver = conn.receiver;
    }

    public int read(byte[] b, int off, int len) throws ConnectException, InterruptedException {
        byte[] b2;
        b2 = read2();
        if (len < b2.length) {
            throw new ConnectException("error5");
        } else {
            System.arraycopy(b2, 0, b, off, b2.length);
            return b2.length;
        }
    }

    public byte[] read2() throws ConnectException, InterruptedException {
        return receiver.receive();
    }

    public void closeStream_Local() {
        if (!streamClosed) {
            receiver.closeStream_Local();
        }
    }


}
