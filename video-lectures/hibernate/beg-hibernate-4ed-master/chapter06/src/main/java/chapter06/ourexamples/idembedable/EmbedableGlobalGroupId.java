package chapter06.ourexamples.idembedable;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by gd on 12/5/2018.
 */
@Embeddable
public class EmbedableGlobalGroupId implements Serializable
 {

    private String univCode;
    private String groupCode;

    public EmbedableGlobalGroupId(String univCode, String groupCode) {
        this.univCode = univCode;
        this.groupCode = groupCode;
    }

    public String getUnivCode() {
        return univCode;
    }

    public void setUnivCode(String univCode) {
        this.univCode = univCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmbedableGlobalGroupId that = (EmbedableGlobalGroupId) o;

        if (univCode != null ? !univCode.equals(that.univCode) : that.univCode != null) return false;
        return groupCode != null ? groupCode.equals(that.groupCode) : that.groupCode == null;
    }

    @Override
    public int hashCode() {
        int result = univCode != null ? univCode.hashCode() : 0;
        result = 31 * result + (groupCode != null ? groupCode.hashCode() : 0);
        return result;
    }
}
