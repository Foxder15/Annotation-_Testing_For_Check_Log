package Entity;

import Annotation.CheckLog;
import Annotation.VIPLog;
import constant.VIPLevel;

public class UserVIP extends User{
    private long VIPNumber;
    @VIPLog
    private VIPLevel level;

    public UserVIP(User user, long VIPNumber, VIPLevel level) {
        super(user.getId(), user.getName(), user.getEmail());
        this.VIPNumber = VIPNumber;
        this.level = level;
    }

    public long getVIPNumber() {
        return VIPNumber;
    }

    public void setVIPNumber(long VIPNumber) {
        this.VIPNumber = VIPNumber;
    }

    public VIPLevel getLevel() {
        return level;
    }

    public void setLevel(VIPLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "UserVIP{" +
                "VIPNumber=" + VIPNumber +
                ", level=" + level +
                '}';
    }
}
