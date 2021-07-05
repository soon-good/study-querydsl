package io.study.jpa.manytoone.company.department;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "DEPT", schema = "public")
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DEPT_ID")
    private Long id;

    @Column(name = "DEPT_NAME")
    private String deptName;

//    @OneToMany(mappedBy = "dept")
//    List<Employee> employees = new ArrayList<>();

    public Department(){}

    public Department(String deptName){
        this.deptName = deptName;
    }

    public Department(Long id, String deptName){
        this.id = id;
        this.deptName = deptName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
