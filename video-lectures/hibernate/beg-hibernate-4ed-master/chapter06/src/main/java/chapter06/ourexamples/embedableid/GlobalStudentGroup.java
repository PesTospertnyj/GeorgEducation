package chapter06.ourexamples.embedableid;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gd on 12/5/2018.
 */
@Entity
public class GlobalStudentGroup {

    public GlobalStudentGroup(GlobalGroupId globalGroupId, Integer studentsNumber) {
        this.globalGroupId = globalGroupId;
        this.studentsNumber = studentsNumber;
    }

    @Id
    private GlobalGroupId globalGroupId;
    private Integer studentsNumber;

    public GlobalGroupId getGlobalGroupId() {
        return globalGroupId;
    }

    public void setGlobalGroupId(GlobalGroupId globalGroupId) {
        this.globalGroupId = globalGroupId;
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

        GlobalStudentGroup that = (GlobalStudentGroup) o;

        if (globalGroupId != null ? !globalGroupId.equals(that.globalGroupId) : that.globalGroupId != null)
            return false;
        return studentsNumber != null ? studentsNumber.equals(that.studentsNumber) : that.studentsNumber == null;
    }

    @Override
    public int hashCode() {
        int result = globalGroupId != null ? globalGroupId.hashCode() : 0;
        result = 31 * result + (studentsNumber != null ? studentsNumber.hashCode() : 0);
        return result;
    }
}
