package io.study.jpa.manytoone.company.employee;

import io.study.jpa.manytoone.company.department.Department;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EMP", schema = "public")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "EMPLOYEE_ID")
    private Long id;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID")
    private Department dept;

    public Employee(){}

    public Employee(String name, Department dept){
        this.name = name;
        this.dept = dept;
    }

    // Mysql, MariaDB 에서는 auto increment 대신 직접 지정해야 하므로 아래의 생성자를 데이터 주입시 사용
    // GenerationType.AUTO 인데 Mysql 일경우 or GenerationType.TABLE 일 경우 사용
    // 또는 매핑시 시퀀스 테이블 전략을 선택하기
    public Employee(Long id, String name, Department dept){
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", dept=" + dept +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}
