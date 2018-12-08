package chapter06.ourexamples.idembedable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gd on 12/5/2018.
 */
@Entity
public class GlobalStudentGroup2 {

    public GlobalStudentGroup2(EmbedableGlobalGroupId embedableGlobalGroupId, Integer studentsNumber) {
        this.embedableGlobalGroupId = embedableGlobalGroupId;
        this.studentsNumber = studentsNumber;
    }

    @Id
    private EmbedableGlobalGroupId embedableGlobalGroupId;

//    private EmbedableGlobalGroupId embedableGlobalGroupId111111;

    private Integer studentsNumber;

    public EmbedableGlobalGroupId getEmbedableGlobalGroupId() {
        return embedableGlobalGroupId;
    }

    public void setEmbedableGlobalGroupId(EmbedableGlobalGroupId embedableGlobalGroupId) {
        this.embedableGlobalGroupId = embedableGlobalGroupId;
    }

    public Integer getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(Integer studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalStudentGroup2 that = (GlobalStudentGroup2) o;

        if (embedableGlobalGroupId != null ? !embedableGlobalGroupId.equals(that.embedableGlobalGroupId) : that.embedableGlobalGroupId != null)
            return false;
        return studentsNumber != null ? studentsNumber.equals(that.studentsNumber) : that.studentsNumber == null;
    }

    @Override
    public int hashCode() {
        int result = embedableGlobalGroupId != null ? embedableGlobalGroupId.hashCode() : 0;
        result = 31 * result + (studentsNumber != null ? studentsNumber.hashCode() : 0);
        return result;
    }
}
