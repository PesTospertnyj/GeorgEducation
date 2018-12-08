package chapter06.ourexamples.idclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by gd on 12/5/2018.
 */
@Entity
@IdClass(GlobalGroupIdClass.class)
public class GlobalStudentGroupWithIdClass {

    public GlobalStudentGroupWithIdClass() {
    }

    public GlobalStudentGroupWithIdClass(String univCode, String groupCode, Integer studentsNumber) {
        this.univCode = univCode;
        this.groupCode = groupCode;
        this.studentsNumber = studentsNumber;
    }

    @Id
    private String univCode;
    @Id
    private String groupCode;

    private Integer studentsNumber;

    public Integer getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(Integer studentsNumber) {
        this.studentsNumber = studentsNumber;
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

        GlobalStudentGroupWithIdClass that = (GlobalStudentGroupWithIdClass) o;

        if (univCode != null ? !univCode.equals(that.univCode) : that.univCode != null) return false;
        if (groupCode != null ? !groupCode.equals(that.groupCode) : that.groupCode != null) return false;
        return studentsNumber != null ? studentsNumber.equals(that.studentsNumber) : that.studentsNumber == null;
    }

    @Override
    public int hashCode() {
        int result = univCode != null ? univCode.hashCode() : 0;
        result = 31 * result + (groupCode != null ? groupCode.hashCode() : 0);
        result = 31 * result + (studentsNumber != null ? studentsNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GlobalStudentGroupWithIdClass{" +
                "univCode='" + univCode + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", studentsNumber=" + studentsNumber +
                '}';
    }
}
