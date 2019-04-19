package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developers")
public class Developer extends EntityTable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "City")
    private String city;
    @Column(name = "Age")
    private int age;
    @Column(name = "salary")
    private Integer salary;

    @ManyToMany
    @JoinTable(name = "developer_skills",
            joinColumns = @JoinColumn(name = "id_developer", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName = "id")
    )
    private List<Skill> skills = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "developers")
    private List<Project> projects = new ArrayList<>();
}
